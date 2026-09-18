package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcfy implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzcfz zzb;

    zzcfy(zzcfz zzcfzVar, boolean z) {
        this.zza = z;
        this.zzb = zzcfzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzK("windowVisibilityChanged", "isVisible", String.valueOf(this.zza));
    }
}
