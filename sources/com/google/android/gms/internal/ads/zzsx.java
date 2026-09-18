package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzsx extends Exception {
    public final String zza;
    public final boolean zzb;
    public final zzsv zzc;
    public final String zzd;
    public final zzsx zze;

    public zzsx(zzam zzamVar, Throwable th, boolean z, int i) {
        this("Decoder init failed: [" + i + "], " + zzamVar.toString(), th, zzamVar.zzm, false, null, "androidx.media3.exoplayer.mediacodec.MediaCodecRenderer_neg_" + Math.abs(i), null);
    }

    static /* bridge */ /* synthetic */ zzsx zza(zzsx zzsxVar, zzsx zzsxVar2) {
        return new zzsx(zzsxVar.getMessage(), zzsxVar.getCause(), zzsxVar.zza, false, zzsxVar.zzc, zzsxVar.zzd, zzsxVar2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public zzsx(zzam zzamVar, Throwable th, boolean z, zzsv zzsvVar) {
        String str = "Decoder init failed: " + zzsvVar.zza + ", " + zzamVar.toString();
        String str2 = zzamVar.zzm;
        int i = zzfy.zza;
        this(str, th, str2, false, zzsvVar, th instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException) th).getDiagnosticInfo() : null, null);
    }

    private zzsx(String str, Throwable th, String str2, boolean z, zzsv zzsvVar, String str3, zzsx zzsxVar) {
        super(str, th);
        this.zza = str2;
        this.zzb = false;
        this.zzc = zzsvVar;
        this.zzd = str3;
        this.zze = zzsxVar;
    }
}
