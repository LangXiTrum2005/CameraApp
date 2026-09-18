package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcfj implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcfp zzc;

    zzcfj(zzcfp zzcfpVar, String str, String str2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzcfpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcfp zzcfpVar = this.zzc;
        if (zzcfpVar.zzq != null) {
            zzcfpVar.zzq.zzb(this.zza, this.zzb);
        }
    }
}
