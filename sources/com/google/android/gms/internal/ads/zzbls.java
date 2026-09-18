package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AdManagerAdView;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbls implements Runnable {
    final /* synthetic */ AdManagerAdView zza;
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzbu zzb;
    final /* synthetic */ zzblt zzc;

    zzbls(zzblt zzbltVar, AdManagerAdView adManagerAdView, com.google.android.gms.ads.internal.client.zzbu zzbuVar) {
        this.zza = adManagerAdView;
        this.zzb = zzbuVar;
        this.zzc = zzbltVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.zza.zzb(this.zzb)) {
            zzcec.zzj("Could not bind.");
            return;
        }
        zzblt zzbltVar = this.zzc;
        zzbltVar.zza.onAdManagerAdViewLoaded(this.zza);
    }
}
