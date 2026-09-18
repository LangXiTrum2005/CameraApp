package org.wysaid.view;

import android.content.Context;
import android.media.AudioRecord;
import android.os.Process;
import android.util.AttributeSet;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class CameraRecordGLSurfaceView extends CameraGLSurfaceViewWithTexture {
    private AudioRecordRunnable mAudioRecordRunnable;
    private Thread mAudioThread;
    private final Object mRecordStateLock;
    private boolean mShouldRecord;

    public interface EndRecordingCallback {
        void endRecordingOK();
    }

    public interface StartRecordingCallback {
        void startRecordingOver(boolean z);
    }

    public CameraRecordGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mShouldRecord = false;
        this.mRecordStateLock = new Object();
    }

    public synchronized boolean isRecording() {
        return this.mShouldRecord;
    }

    public void startRecording(String str) {
        startRecording(str, null);
    }

    public void startRecording(final String str, final StartRecordingCallback startRecordingCallback) {
        queueEvent(new Runnable() { // from class: org.wysaid.view.CameraRecordGLSurfaceView.1
            @Override // java.lang.Runnable
            public void run() {
                if (CameraRecordGLSurfaceView.this.mFrameRecorder == null) {
                    Log.e("libCGE_java", "Error: startRecording after release!!");
                    StartRecordingCallback startRecordingCallback2 = startRecordingCallback;
                    if (startRecordingCallback2 != null) {
                        startRecordingCallback2.startRecordingOver(false);
                        return;
                    }
                    return;
                }
                if (!CameraRecordGLSurfaceView.this.mFrameRecorder.startRecording(30, str)) {
                    Log.e("libCGE_java", "start recording failed!");
                    StartRecordingCallback startRecordingCallback3 = startRecordingCallback;
                    if (startRecordingCallback3 != null) {
                        startRecordingCallback3.startRecordingOver(false);
                        return;
                    }
                    return;
                }
                Log.i("libCGE_java", "glSurfaceView recording, file: " + str);
                synchronized (CameraRecordGLSurfaceView.this.mRecordStateLock) {
                    CameraRecordGLSurfaceView.this.mShouldRecord = true;
                    CameraRecordGLSurfaceView cameraRecordGLSurfaceView = CameraRecordGLSurfaceView.this;
                    cameraRecordGLSurfaceView.mAudioRecordRunnable = new AudioRecordRunnable(startRecordingCallback);
                    if (CameraRecordGLSurfaceView.this.mAudioRecordRunnable.audioRecord != null) {
                        CameraRecordGLSurfaceView.this.mAudioThread = new Thread(CameraRecordGLSurfaceView.this.mAudioRecordRunnable);
                        CameraRecordGLSurfaceView.this.mAudioThread.start();
                    }
                }
            }
        });
    }

    public void endRecording() {
        endRecording(null, true);
    }

    public void endRecording(EndRecordingCallback endRecordingCallback) {
        endRecording(endRecordingCallback, true);
    }

    public void endRecording(final EndRecordingCallback endRecordingCallback, final boolean z) {
        Log.i("libCGE_java", "notify quit...");
        synchronized (this.mRecordStateLock) {
            this.mShouldRecord = false;
        }
        if (this.mFrameRecorder == null) {
            Log.e("libCGE_java", "Error: endRecording after release!!");
        } else {
            joinAudioRecording();
            queueEvent(new Runnable() { // from class: org.wysaid.view.CameraRecordGLSurfaceView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (CameraRecordGLSurfaceView.this.mFrameRecorder != null) {
                        CameraRecordGLSurfaceView.this.mFrameRecorder.endRecording(z);
                    }
                    EndRecordingCallback endRecordingCallback2 = endRecordingCallback;
                    if (endRecordingCallback2 != null) {
                        endRecordingCallback2.endRecordingOK();
                    }
                }
            });
        }
    }

    @Override // org.wysaid.view.CameraGLSurfaceViewWithTexture, org.wysaid.view.CameraGLSurfaceView
    protected void onRelease() {
        synchronized (this.mRecordStateLock) {
            this.mShouldRecord = false;
        }
        joinAudioRecording();
        super.onRelease();
    }

    @Override // org.wysaid.view.CameraGLSurfaceView
    public void stopPreview() {
        synchronized (this.mRecordStateLock) {
            if (this.mShouldRecord) {
                Log.e("libCGE_java", "The camera is recording! cannot stop!");
            } else {
                super.stopPreview();
            }
        }
    }

    public void joinAudioRecording() {
        Thread thread = this.mAudioThread;
        if (thread != null) {
            try {
                thread.join();
                this.mAudioThread = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class AudioRecordRunnable implements Runnable {
        private static final int sampleRate = 44100;
        ShortBuffer audioBuffer;
        ByteBuffer audioBufferRef;
        public AudioRecord audioRecord;
        int bufferReadResult;
        int bufferSize;
        public volatile boolean isInitialized;
        StartRecordingCallback recordingCallback;

        private AudioRecordRunnable(StartRecordingCallback startRecordingCallback) {
            StartRecordingCallback startRecordingCallback2;
            this.recordingCallback = startRecordingCallback;
            try {
                this.bufferSize = AudioRecord.getMinBufferSize(sampleRate, 16, 2);
                Log.i("libCGE_java", "audio min buffer size: " + this.bufferSize);
                this.audioRecord = new AudioRecord(1, sampleRate, 16, 2, this.bufferSize);
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(this.bufferSize * 2).order(ByteOrder.nativeOrder());
                this.audioBufferRef = byteBufferOrder;
                this.audioBuffer = byteBufferOrder.asShortBuffer();
            } catch (Exception unused) {
                AudioRecord audioRecord = this.audioRecord;
                if (audioRecord != null) {
                    audioRecord.release();
                    this.audioRecord = null;
                }
            }
            if (this.audioRecord != null || (startRecordingCallback2 = this.recordingCallback) == null) {
                return;
            }
            startRecordingCallback2.startRecordingOver(false);
            this.recordingCallback = null;
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            this.isInitialized = false;
            if (this.audioRecord == null) {
                this.recordingCallback.startRecordingOver(false);
                this.recordingCallback = null;
                return;
            }
            while (this.audioRecord.getState() == 0) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.isInitialized = true;
            try {
                this.audioRecord.startRecording();
                if (this.audioRecord.getRecordingState() != 3) {
                    StartRecordingCallback startRecordingCallback = this.recordingCallback;
                    if (startRecordingCallback != null) {
                        startRecordingCallback.startRecordingOver(false);
                        this.recordingCallback = null;
                        return;
                    }
                    return;
                }
                StartRecordingCallback startRecordingCallback2 = this.recordingCallback;
                if (startRecordingCallback2 != null) {
                    startRecordingCallback2.startRecordingOver(true);
                    this.recordingCallback = null;
                }
                while (true) {
                    synchronized (CameraRecordGLSurfaceView.this.mRecordStateLock) {
                        if (!CameraRecordGLSurfaceView.this.mShouldRecord) {
                            this.audioRecord.stop();
                            this.audioRecord.release();
                            Log.i("libCGE_java", "Audio thread end!");
                            return;
                        }
                    }
                    this.audioBufferRef.position(0);
                    this.bufferReadResult = this.audioRecord.read(this.audioBufferRef, this.bufferSize * 2);
                    if (CameraRecordGLSurfaceView.this.mShouldRecord && this.bufferReadResult > 0 && CameraRecordGLSurfaceView.this.mFrameRecorder != null && CameraRecordGLSurfaceView.this.mFrameRecorder.getTimestamp() > CameraRecordGLSurfaceView.this.mFrameRecorder.getAudioStreamtime()) {
                        this.audioBuffer.position(0);
                        CameraRecordGLSurfaceView.this.mFrameRecorder.recordAudioFrame(this.audioBuffer, this.bufferReadResult / 2);
                    }
                }
            } catch (Exception unused) {
                StartRecordingCallback startRecordingCallback3 = this.recordingCallback;
                if (startRecordingCallback3 != null) {
                    startRecordingCallback3.startRecordingOver(false);
                    this.recordingCallback = null;
                }
            }
        }
    }
}
