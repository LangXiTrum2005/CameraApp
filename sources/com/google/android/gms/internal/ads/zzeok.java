package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzeok implements com.google.android.gms.ads.internal.zzf {
    final /* synthetic */ zzceu zza;
    final /* synthetic */ zzfgy zzb;
    final /* synthetic */ zzfgm zzc;
    final /* synthetic */ zzeoq zzd;
    final /* synthetic */ zzeol zze;

    zzeok(zzeol zzeolVar, zzceu zzceuVar, zzfgy zzfgyVar, zzfgm zzfgmVar, zzeoq zzeoqVar) {
        this.zza = zzceuVar;
        this.zzb = zzfgyVar;
        this.zzc = zzfgmVar;
        this.zzd = zzeoqVar;
        this.zze = zzeolVar;
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zza(View view) {
        this.zza.zzc(this.zze.zzd.zza(this.zzb, this.zzc, view, this.zzd));
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzb() {
    }

    @Override // com.google.android.gms.ads.internal.zzf
    public final void zzc() {
    }
}
