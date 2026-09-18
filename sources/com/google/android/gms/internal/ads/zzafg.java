package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzafg {
    protected final zzaea zza;

    protected zzafg(zzaea zzaeaVar) {
        this.zza = zzaeaVar;
    }

    protected abstract boolean zza(zzfp zzfpVar) throws zzcc;

    protected abstract boolean zzb(zzfp zzfpVar, long j) throws zzcc;

    public final boolean zzf(zzfp zzfpVar, long j) throws zzcc {
        return zza(zzfpVar) && zzb(zzfpVar, j);
    }
}
