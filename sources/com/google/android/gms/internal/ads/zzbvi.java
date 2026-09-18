package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbvi implements com.google.android.gms.ads.internal.overlay.zzp {
    final /* synthetic */ zzbvk zza;

    zzbvi(zzbvk zzbvkVar) {
        this.zza = zzbvkVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbA() {
        zzcec.zze("Opening AdMobCustomTabsAdapter overlay.");
        zzbvk zzbvkVar = this.zza;
        zzbvkVar.zzb.onAdOpened(zzbvkVar);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbC() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbD(int i) {
        zzcec.zze("AdMobCustomTabsAdapter overlay is closed.");
        zzbvk zzbvkVar = this.zza;
        zzbvkVar.zzb.onAdClosed(zzbvkVar);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbP() {
        zzcec.zze("AdMobCustomTabsAdapter overlay is resumed.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbt() {
        zzcec.zze("AdMobCustomTabsAdapter overlay is paused.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbz() {
        zzcec.zze("Delay close AdMobCustomTabsAdapter overlay.");
    }
}
