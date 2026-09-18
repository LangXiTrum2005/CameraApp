package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzera implements zzgej {
    final /* synthetic */ zzeqt zza;
    final /* synthetic */ zzfmz zzb;
    final /* synthetic */ zzfmo zzc;
    final /* synthetic */ zzdlk zzd;
    final /* synthetic */ zzerb zze;

    zzera(zzerb zzerbVar, zzeqt zzeqtVar, zzfmz zzfmzVar, zzfmo zzfmoVar, zzdlk zzdlkVar) {
        this.zza = zzeqtVar;
        this.zzb = zzfmzVar;
        this.zzc = zzfmoVar;
        this.zzd = zzdlkVar;
        this.zze = zzerbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        zzfmz zzfmzVar;
        final com.google.android.gms.ads.internal.client.zze zzeVarZza = this.zzd.zza().zza(th);
        this.zzd.zzb().zzbK(zzeVarZza);
        this.zze.zzb.zzB().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeqz
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zze.zzd.zza().zzbK(zzeVarZza);
            }
        });
        zzfie.zzb(zzeVarZza.zza, th, "NativeAdLoader.onFailure");
        this.zza.zza();
        if (((Boolean) zzbht.zzc.zze()).booleanValue() && (zzfmzVar = this.zzb) != null) {
            zzfmzVar.zzc(zzeVarZza);
            zzfmo zzfmoVar = this.zzc;
            zzfmoVar.zzg(th);
            zzfmoVar.zzf(false);
            zzfmzVar.zza(zzfmoVar);
            zzfmzVar.zzg();
            return;
        }
        zzerb zzerbVar = this.zze;
        zzfmo zzfmoVar2 = this.zzc;
        zzfnc zzfncVar = zzerbVar.zze;
        zzfmoVar2.zza(zzeVarZza);
        zzfmoVar2.zzg(th);
        zzfmoVar2.zzf(false);
        zzfncVar.zzb(zzfmoVar2.zzl());
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfmz zzfmzVar;
        zzcwh zzcwhVar = (zzcwh) obj;
        synchronized (this.zze) {
            zzcwhVar.zzn().zza(this.zze.zzd.zzd());
            this.zza.zzb(zzcwhVar);
            this.zze.zzb.zzB().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeqy
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zze.zzd.zzb().zzr();
                }
            });
            if (!((Boolean) zzbht.zzc.zze()).booleanValue() || (zzfmzVar = this.zzb) == null) {
                zzfnc zzfncVar = this.zze.zze;
                zzfmo zzfmoVar = this.zzc;
                zzfmoVar.zzb(zzcwhVar.zzp().zzb);
                zzfmoVar.zzd(zzcwhVar.zzl().zzg());
                zzfmoVar.zzf(true);
                zzfncVar.zzb(zzfmoVar.zzl());
            } else {
                zzfmzVar.zzf(zzcwhVar.zzp().zzb);
                zzfmzVar.zze(zzcwhVar.zzl().zzg());
                zzfmo zzfmoVar2 = this.zzc;
                zzfmoVar2.zzf(true);
                zzfmzVar.zza(zzfmoVar2);
                zzfmzVar.zzg();
            }
        }
    }
}
