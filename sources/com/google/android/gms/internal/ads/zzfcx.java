package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfcx implements zzgej {
    final /* synthetic */ zzeqt zza;
    final /* synthetic */ zzfmz zzb;
    final /* synthetic */ zzfmo zzc;
    final /* synthetic */ zzcvc zzd;
    final /* synthetic */ zzfcy zze;

    zzfcx(zzfcy zzfcyVar, zzeqt zzeqtVar, zzfmz zzfmzVar, zzfmo zzfmoVar, zzcvc zzcvcVar) {
        this.zza = zzeqtVar;
        this.zzb = zzfmzVar;
        this.zzc = zzfmoVar;
        this.zzd = zzcvcVar;
        this.zze = zzfcyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        zzfmz zzfmzVar;
        final com.google.android.gms.ads.internal.client.zze zzeVarZza = this.zzd.zzd().zza(th);
        synchronized (this.zze) {
            this.zze.zzl = null;
            this.zzd.zzf().zzbK(zzeVarZza);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhZ)).booleanValue()) {
                this.zze.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfcv
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zze.zzd.zzbK(zzeVarZza);
                    }
                });
            }
            zzfcy zzfcyVar = this.zze;
            zzfcyVar.zzh.zzd(zzfcyVar.zzj.zzc());
            zzfie.zzb(zzeVarZza.zza, th, "BannerAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbht.zzc.zze()).booleanValue() || (zzfmzVar = this.zzb) == null) {
                zzfnc zzfncVar = this.zze.zzi;
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
        zzcuf zzcufVar = (zzcuf) obj;
        synchronized (this.zze) {
            this.zze.zzl = null;
            this.zze.zzf.removeAllViews();
            if (zzcufVar.zzc() != null) {
                ViewParent parent = zzcufVar.zzc().getParent();
                if (parent instanceof ViewGroup) {
                    zzcec.zzj("Banner view provided from " + (zzcufVar.zzl() != null ? zzcufVar.zzl().zzg() : "") + " already has a parent view. Removing its old parent.");
                    ((ViewGroup) parent).removeView(zzcufVar.zzc());
                }
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhZ)).booleanValue()) {
                zzdfc zzdfcVarZzn = zzcufVar.zzn();
                zzdfcVarZzn.zza(this.zze.zzd);
                zzdfcVarZzn.zzc(this.zze.zze);
            }
            this.zze.zzf.addView(zzcufVar.zzc());
            this.zza.zzb(zzcufVar);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhZ)).booleanValue()) {
                zzfcy zzfcyVar = this.zze;
                Executor executor = zzfcyVar.zzb;
                final zzeqe zzeqeVar = zzfcyVar.zzd;
                Objects.requireNonNull(zzeqeVar);
                executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfcw
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzeqeVar.zzr();
                    }
                });
            }
            this.zze.zzh.zzd(zzcufVar.zza());
            if (!((Boolean) zzbht.zzc.zze()).booleanValue() || (zzfmzVar = this.zzb) == null) {
                zzfnc zzfncVar = this.zze.zzi;
                zzfmo zzfmoVar = this.zzc;
                zzfmoVar.zzb(zzcufVar.zzp().zzb);
                zzfmoVar.zzd(zzcufVar.zzl().zzg());
                zzfmoVar.zzf(true);
                zzfncVar.zzb(zzfmoVar.zzl());
            } else {
                zzfmzVar.zzf(zzcufVar.zzp().zzb);
                zzfmzVar.zze(zzcufVar.zzl().zzg());
                zzfmo zzfmoVar2 = this.zzc;
                zzfmoVar2.zzf(true);
                zzfmzVar.zza(zzfmoVar2);
                zzfmzVar.zzg();
            }
        }
    }
}
