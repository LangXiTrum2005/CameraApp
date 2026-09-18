package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.HandlerThread;
import android.os.Trace;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzse implements zzsq {
    private final zzfxu zzb;
    private final zzfxu zzc;
    private boolean zzd;

    public zzse(int i) {
        zzsc zzscVar = new zzsc(i);
        zzsd zzsdVar = new zzsd(i);
        this.zzb = zzscVar;
        this.zzc = zzsdVar;
        this.zzd = true;
    }

    static /* synthetic */ HandlerThread zza(int i) {
        return new HandlerThread(zzsg.zzr(i, "ExoPlayer:MediaCodecAsyncAdapter:"));
    }

    static /* synthetic */ HandlerThread zzb(int i) {
        return new HandlerThread(zzsg.zzr(i, "ExoPlayer:MediaCodecQueueingThread:"));
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0038 A[Catch: Exception -> 0x0065, TryCatch #1 {Exception -> 0x0065, blocks: (B:4:0x001c, B:6:0x0020, B:9:0x0029, B:11:0x0031, B:13:0x0048, B:12:0x0038), top: B:29:0x001c }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.android.gms.internal.ads.zzsf] */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.google.android.gms.internal.ads.zzsg] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    public final zzsg zzc(zzsp zzspVar) throws Exception {
        MediaCodec mediaCodecCreateByCodecName;
        zzss zzskVar;
        int i;
        String str = zzspVar.zza.zza;
        ?? r2 = 0;
        r2 = 0;
        try {
            int i2 = zzfy.zza;
            Trace.beginSection("createCodec:" + str);
            mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            try {
                if (this.zzd) {
                    zzam zzamVar = zzspVar.zzc;
                    if (zzfy.zza >= 34 && zzcb.zzh(zzamVar.zzm)) {
                        zzskVar = new zztq(mediaCodecCreateByCodecName);
                        i = 4;
                    } else {
                        zzskVar = new zzsk(mediaCodecCreateByCodecName, zzb(((zzsd) this.zzc).zza));
                        i = 0;
                    }
                } else {
                    zzskVar = new zzsk(mediaCodecCreateByCodecName, zzb(((zzsd) this.zzc).zza));
                    i = 0;
                }
                zzsg zzsgVar = new zzsg(mediaCodecCreateByCodecName, zza(((zzsc) this.zzb).zza), zzskVar, r2);
                try {
                    Trace.endSection();
                    zzsg.zzh(zzsgVar, zzspVar.zzb, zzspVar.zzd, null, i);
                    return zzsgVar;
                } catch (Exception e) {
                    e = e;
                    r2 = zzsgVar;
                    if (r2 != 0) {
                        r2.zzl();
                    } else if (mediaCodecCreateByCodecName != null) {
                        mediaCodecCreateByCodecName.release();
                    }
                    throw e;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            mediaCodecCreateByCodecName = null;
        }
    }

    public final void zzd(boolean z) {
        this.zzd = true;
    }
}
