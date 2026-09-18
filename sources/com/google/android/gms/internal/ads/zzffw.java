package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzffw implements zzgej {
    final /* synthetic */ zzeqt zza;
    final /* synthetic */ zzfmz zzb;
    final /* synthetic */ zzfmo zzc;
    final /* synthetic */ zzffy zzd;
    final /* synthetic */ zzffz zze;

    zzffw(zzffz zzffzVar, zzeqt zzeqtVar, zzfmz zzfmzVar, zzfmo zzfmoVar, zzffy zzffyVar) {
        this.zza = zzeqtVar;
        this.zzb = zzfmzVar;
        this.zzc = zzfmoVar;
        this.zzd = zzffyVar;
        this.zze = zzffzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        zzfmz zzfmzVar;
        zzdst zzdstVar = (zzdst) this.zze.zze.zzd();
        final com.google.android.gms.ads.internal.client.zze zzeVarZzb = zzdstVar == null ? zzfij.zzb(th, null) : zzdstVar.zzb().zza(th);
        synchronized (this.zze) {
            try {
                if (zzdstVar != null) {
                    zzdstVar.zza().zzbK(zzeVarZzb);
                    this.zze.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzffu
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zze.zzd.zzbK(zzeVarZzb);
                        }
                    });
                } else {
                    this.zze.zzd.zzbK(zzeVarZzb);
                    this.zze.zzk(this.zzd).zzh().zzb().zzc().zzh();
                }
                zzfie.zzb(zzeVarZzb.zza, th, "RewardedAdLoader.onFailure");
                this.zza.zza();
                if (!((Boolean) zzbht.zzc.zze()).booleanValue() || (zzfmzVar = this.zzb) == null) {
                    zzfnc zzfncVar = this.zze.zzg;
                    zzfmo zzfmoVar = this.zzc;
                    zzfmoVar.zza(zzeVarZzb);
                    zzfmoVar.zzg(th);
                    zzfmoVar.zzf(false);
                    zzfncVar.zzb(zzfmoVar.zzl());
                } else {
                    zzfmzVar.zzc(zzeVarZzb);
                    zzfmo zzfmoVar2 = this.zzc;
                    zzfmoVar2.zzg(th);
                    zzfmoVar2.zzf(false);
                    zzfmzVar.zza(zzfmoVar2);
                    zzfmzVar.zzg();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfmz zzfmzVar;
        zzdso zzdsoVar = (zzdso) obj;
        synchronized (this.zze) {
            zzdsoVar.zzn().zzd(this.zze.zzd);
            this.zza.zzb(zzdsoVar);
            zzffz zzffzVar = this.zze;
            Executor executor = zzffzVar.zzb;
            final zzffp zzffpVar = zzffzVar.zzd;
            Objects.requireNonNull(zzffpVar);
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzffv
                @Override // java.lang.Runnable
                public final void run() {
                    zzffpVar.zzr();
                }
            });
            this.zze.zzd.onAdMetadataChanged();
            if (!((Boolean) zzbht.zzc.zze()).booleanValue() || (zzfmzVar = this.zzb) == null) {
                zzfnc zzfncVar = this.zze.zzg;
                zzfmo zzfmoVar = this.zzc;
                zzfmoVar.zzb(zzdsoVar.zzp().zzb);
                zzfmoVar.zzd(zzdsoVar.zzl().zzg());
                zzfmoVar.zzf(true);
                zzfncVar.zzb(zzfmoVar.zzl());
            } else {
                zzfmzVar.zzf(zzdsoVar.zzp().zzb);
                zzfmzVar.zze(zzdsoVar.zzl().zzg());
                zzfmo zzfmoVar2 = this.zzc;
                zzfmoVar2.zzf(true);
                zzfmzVar.zza(zzfmoVar2);
                zzfmzVar.zzg();
            }
        }
    }
}
