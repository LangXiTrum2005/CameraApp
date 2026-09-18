package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcfk implements Runnable {
    final /* synthetic */ zzcfp zza;

    zzcfk(zzcfp zzcfpVar) {
        this.zza = zzcfpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcfp zzcfpVar = this.zza;
        if (zzcfpVar.zzq != null) {
            zzcfpVar.zzq.zzh();
        }
    }
}
