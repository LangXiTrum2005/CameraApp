package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzboz implements Runnable {
    final /* synthetic */ zzbpc zza;

    zzboz(zzbpc zzbpcVar) {
        this.zza = zzbpcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbpc.zzc(this.zza);
    }
}
