package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzapl implements Runnable {
    final /* synthetic */ zzaqa zza;
    final /* synthetic */ zzapm zzb;

    zzapl(zzapm zzapmVar, zzaqa zzaqaVar) {
        this.zza = zzaqaVar;
        this.zzb = zzapmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzb.zzc.put(this.zza);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
