package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfeo implements zzgej {
    final /* synthetic */ zzeqt zza;
    final /* synthetic */ zzfmz zzb;
    final /* synthetic */ zzfmo zzc;
    final /* synthetic */ zzdko zzd;
    final /* synthetic */ zzfep zze;

    zzfeo(zzfep zzfepVar, zzeqt zzeqtVar, zzfmz zzfmzVar, zzfmo zzfmoVar, zzdko zzdkoVar) {
        this.zza = zzeqtVar;
        this.zzb = zzfmzVar;
        this.zzc = zzfmoVar;
        this.zzd = zzdkoVar;
        this.zze = zzfepVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        zzfmz zzfmzVar;
        final com.google.android.gms.ads.internal.client.zze zzeVarZza = this.zzd.zza().zza(th);
        synchronized (this.zze) {
            this.zze.zzi = null;
            this.zzd.zzb().zzbK(zzeVarZza);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzib)).booleanValue()) {
                this.zze.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfek
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zze.zzd.zzbK(zzeVarZza);
                    }
                });
                this.zze.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfel
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zze.zze.zzbK(zzeVarZza);
                    }
                });
            }
            zzfie.zzb(zzeVarZza.zza, th, "InterstitialAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbht.zzc.zze()).booleanValue() || (zzfmzVar = this.zzb) == null) {
                zzfnc zzfncVar = this.zze.zzg;
                zzfmo zzfmoVar = this.zzc;
                zzfmoVar.zza(zzeVarZza);
                zzfmoVar.zzg(th);
                zzfmoVar.zzf(false);
                zzfncVar.zzb(zzfmoVar.zzl());
            } else {
                zzfmzVar.zzc(zzeVarZza);
                zzfmo zzfmoVar2 = this.zzc;
                zzfmoVar2.zzg(th);
                zzfmoVar2.zzf(false);
                zzfmzVar.zza(zzfmoVar2);
                zzfmzVar.zzg();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfmz zzfmzVar;
        zzdjn zzdjnVar = (zzdjn) obj;
        synchronized (this.zze) {
            this.zze.zzi = null;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzib)).booleanValue()) {
                zzdfc zzdfcVarZzn = zzdjnVar.zzn();
                zzdfcVarZzn.zza(this.zze.zzd);
                zzdfcVarZzn.zzd(this.zze.zze);
            }
            this.zza.zzb(zzdjnVar);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzib)).booleanValue()) {
                this.zze.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfem
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zze.zzd.zzr();
                    }
                });
                this.zze.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfen
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zze.zze.zzr();
                    }
                });
            }
            if (!((Boolean) zzbht.zzc.zze()).booleanValue() || (zzfmzVar = this.zzb) == null) {
                zzfnc zzfncVar = this.zze.zzg;
                zzfmo zzfmoVar = this.zzc;
                zzfmoVar.zzb(zzdjnVar.zzp().zzb);
                zzfmoVar.zzd(zzdjnVar.zzl().zzg());
                zzfmoVar.zzf(true);
                zzfncVar.zzb(zzfmoVar.zzl());
            } else {
                zzfmzVar.zzf(zzdjnVar.zzp().zzb);
                zzfmzVar.zze(zzdjnVar.zzl().zzg());
                zzfmo zzfmoVar2 = this.zzc;
                zzfmoVar2.zzf(true);
                zzfmzVar.zza(zzfmoVar2);
                zzfmzVar.zzg();
            }
        }
    }
}
