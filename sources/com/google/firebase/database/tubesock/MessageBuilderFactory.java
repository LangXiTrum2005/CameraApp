package com.google.firebase.database.tubesock;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class MessageBuilderFactory {

    interface Builder {
        boolean appendBytes(byte[] bArr);

        WebSocketMessage toMessage();
    }

    MessageBuilderFactory() {
    }

    static class BinaryBuilder implements Builder {
        private int pendingByteCount = 0;
        private List<byte[]> pendingBytes = new ArrayList();

        BinaryBuilder() {
        }

        @Override // com.google.firebase.database.tubesock.MessageBuilderFactory.Builder
        public boolean appendBytes(byte[] bArr) {
            this.pendingBytes.add(bArr);
            this.pendingByteCount += bArr.length;
            return true;
        }

        @Override // com.google.firebase.database.tubesock.MessageBuilderFactory.Builder
        public WebSocketMessage toMessage() {
            byte[] bArr = new byte[this.pendingByteCount];
            int length = 0;
            for (int i = 0; i < this.pendingBytes.size(); i++) {
                byte[] bArr2 = this.pendingBytes.get(i);
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return new WebSocketMessage(bArr);
        }
    }

    static class TextBuilder implements Builder {
        private static ThreadLocal<CharsetDecoder> localDecoder = new ThreadLocal<CharsetDecoder>() { // from class: com.google.firebase.database.tubesock.MessageBuilderFactory.TextBuilder.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            public CharsetDecoder initialValue() {
                CharsetDecoder charsetDecoderNewDecoder = Charset.forName("UTF8").newDecoder();
                charsetDecoderNewDecoder.onMalformedInput(CodingErrorAction.REPORT);
                charsetDecoderNewDecoder.onUnmappableCharacter(CodingErrorAction.REPORT);
                return charsetDecoderNewDecoder;
            }
        };
        private static ThreadLocal<CharsetEncoder> localEncoder = new ThreadLocal<CharsetEncoder>() { // from class: com.google.firebase.database.tubesock.MessageBuilderFactory.TextBuilder.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            public CharsetEncoder initialValue() {
                CharsetEncoder charsetEncoderNewEncoder = Charset.forName("UTF8").newEncoder();
                charsetEncoderNewEncoder.onMalformedInput(CodingErrorAction.REPORT);
                charsetEncoderNewEncoder.onUnmappableCharacter(CodingErrorAction.REPORT);
                return charsetEncoderNewEncoder;
            }
        };
        private StringBuilder builder = new StringBuilder();
        private ByteBuffer carryOver;

        TextBuilder() {
        }

        @Override // com.google.firebase.database.tubesock.MessageBuilderFactory.Builder
        public boolean appendBytes(byte[] bArr) {
            String strDecodeString = decodeString(bArr);
            if (strDecodeString == null) {
                return false;
            }
            this.builder.append(strDecodeString);
            return true;
        }

        @Override // com.google.firebase.database.tubesock.MessageBuilderFactory.Builder
        public WebSocketMessage toMessage() {
            if (this.carryOver != null) {
                return null;
            }
            return new WebSocketMessage(this.builder.toString());
        }

        private String decodeString(byte[] bArr) {
            try {
                return localDecoder.get().decode(ByteBuffer.wrap(bArr)).toString();
            } catch (CharacterCodingException unused) {
                return null;
            }
        }

        private String decodeStringStreaming(byte[] bArr) {
            try {
                ByteBuffer buffer = getBuffer(bArr);
                int iRemaining = (int) (buffer.remaining() * localDecoder.get().averageCharsPerByte());
                CharBuffer charBufferAllocate = CharBuffer.allocate(iRemaining);
                while (true) {
                    CoderResult coderResultDecode = localDecoder.get().decode(buffer, charBufferAllocate, false);
                    if (coderResultDecode.isError()) {
                        return null;
                    }
                    if (!coderResultDecode.isUnderflow()) {
                        if (coderResultDecode.isOverflow()) {
                            iRemaining = (iRemaining * 2) + 1;
                            CharBuffer charBufferAllocate2 = CharBuffer.allocate(iRemaining);
                            charBufferAllocate.flip();
                            charBufferAllocate2.put(charBufferAllocate);
                            charBufferAllocate = charBufferAllocate2;
                        }
                    } else {
                        if (buffer.remaining() > 0) {
                            this.carryOver = buffer;
                        }
                        localEncoder.get().encode(CharBuffer.wrap(charBufferAllocate));
                        charBufferAllocate.flip();
                        return charBufferAllocate.toString();
                    }
                }
            } catch (CharacterCodingException unused) {
                return null;
            }
        }

        private ByteBuffer getBuffer(byte[] bArr) {
            ByteBuffer byteBuffer = this.carryOver;
            if (byteBuffer != null) {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + byteBuffer.remaining());
                byteBufferAllocate.put(this.carryOver);
                this.carryOver = null;
                byteBufferAllocate.put(bArr);
                byteBufferAllocate.flip();
                return byteBufferAllocate;
            }
            return ByteBuffer.wrap(bArr);
        }
    }

    static Builder builder(byte b) {
        if (b == 2) {
            return new BinaryBuilder();
        }
        return new TextBuilder();
    }
}
