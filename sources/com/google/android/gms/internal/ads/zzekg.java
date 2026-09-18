package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzekg implements zzgej {
    final /* synthetic */ zzekh zza;

    zzekg(zzekh zzekhVar) {
        this.zza = zzekhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.client.zze zzeVarZza = this.zza.zza.zzd().zza(th);
        this.zza.zzd.zzbK(zzeVarZza);
        zzfie.zzb(zzeVarZza.zza, th, "DelayedBannerAd.onFailure");
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* synthetic */ void zzb(Object obj) {
        ((zzcuf) obj).zzj();
    }
}
