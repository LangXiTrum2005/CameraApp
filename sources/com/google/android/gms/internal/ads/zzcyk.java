package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcyk implements com.google.android.gms.ads.internal.client.zza {
    private final zzcyo zza;
    private final zzfhh zzb;

    zzcyk(zzcyo zzcyoVar, zzfhh zzfhhVar) {
        this.zza = zzcyoVar;
        this.zzb = zzfhhVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        this.zza.zzc(this.zzb.zzf);
    }
}
