package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdmu implements zzgej {
    final /* synthetic */ View zza;
    final /* synthetic */ zzdmv zzb;

    zzdmu(zzdmv zzdmvVar, View view) {
        this.zza = view;
        this.zzb = zzdmvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfb)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzo().zzv(th, "omid native display exp");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzb.zzac(this.zza, (zzfod) obj);
    }
}
