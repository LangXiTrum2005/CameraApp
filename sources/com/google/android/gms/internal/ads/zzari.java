package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzari implements zzarj {
    private static final Logger zzb = Logger.getLogger(zzari.class.getName());
    final ThreadLocal zza = new zzarh(this);

    public abstract zzarm zza(String str, byte[] bArr, String str2);

    @Override // com.google.android.gms.internal.ads.zzarj
    public final zzarm zzb(zzhgp zzhgpVar, zzarn zzarnVar) throws IOException {
        int iZza;
        long jZzc;
        long jZzb = zzhgpVar.zzb();
        ((ByteBuffer) this.zza.get()).rewind().limit(8);
        do {
            iZza = zzhgpVar.zza((ByteBuffer) this.zza.get());
            if (iZza == 8) {
                ((ByteBuffer) this.zza.get()).rewind();
                long jZze = zzarl.zze((ByteBuffer) this.zza.get());
                byte[] bArr = null;
                if (jZze < 8 && jZze > 1) {
                    Logger logger = zzb;
                    Level level = Level.SEVERE;
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("Plausibility check failed: size < 8 (size = ");
                    sb.append(jZze);
                    sb.append("). Stop parsing!");
                    logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                    return null;
                }
                byte[] bArr2 = new byte[4];
                ((ByteBuffer) this.zza.get()).get(bArr2);
                try {
                    String str = new String(bArr2, "ISO-8859-1");
                    if (jZze == 1) {
                        ((ByteBuffer) this.zza.get()).limit(16);
                        zzhgpVar.zza((ByteBuffer) this.zza.get());
                        ((ByteBuffer) this.zza.get()).position(8);
                        jZzc = zzarl.zzf((ByteBuffer) this.zza.get()) - 16;
                    } else {
                        jZzc = jZze == 0 ? zzhgpVar.zzc() - zzhgpVar.zzb() : jZze - 8;
                    }
                    if ("uuid".equals(str)) {
                        ((ByteBuffer) this.zza.get()).limit(((ByteBuffer) this.zza.get()).limit() + 16);
                        zzhgpVar.zza((ByteBuffer) this.zza.get());
                        bArr = new byte[16];
                        for (int iPosition = ((ByteBuffer) this.zza.get()).position() - 16; iPosition < ((ByteBuffer) this.zza.get()).position(); iPosition++) {
                            bArr[iPosition - (((ByteBuffer) this.zza.get()).position() - 16)] = ((ByteBuffer) this.zza.get()).get(iPosition);
                        }
                        jZzc -= 16;
                    }
                    long j = jZzc;
                    zzarm zzarmVarZza = zza(str, bArr, zzarnVar instanceof zzarm ? ((zzarm) zzarnVar).zza() : "");
                    zzarmVarZza.zzc(zzarnVar);
                    ((ByteBuffer) this.zza.get()).rewind();
                    zzarmVarZza.zzb(zzhgpVar, (ByteBuffer) this.zza.get(), j, this);
                    return zzarmVarZza;
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }
        } while (iZza >= 0);
        zzhgpVar.zze(jZzb);
        throw new EOFException();
    }
}
