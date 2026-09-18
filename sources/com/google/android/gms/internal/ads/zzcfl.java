package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcfl implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzcfp zzc;

    zzcfl(zzcfp zzcfpVar, int i, int i2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzcfpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcfp zzcfpVar = this.zzc;
        if (zzcfpVar.zzq != null) {
            zzcfpVar.zzq.zzj(this.zza, this.zzb);
        }
    }
}
