package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzffz implements zzequ {
    private final Context zza;
    private final Executor zzb;
    private final zzclg zzc;
    private final zzffp zzd;
    private final zzfed zze;
    private final zzfgz zzf;
    private final zzfnc zzg;
    private final zzfhf zzh;
    private ListenableFuture zzi;

    public zzffz(Context context, Executor executor, zzclg zzclgVar, zzfed zzfedVar, zzffp zzffpVar, zzfhf zzfhfVar, zzfgz zzfgzVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzclgVar;
        this.zze = zzfedVar;
        this.zzd = zzffpVar;
        this.zzh = zzfhfVar;
        this.zzf = zzfgzVar;
        this.zzg = zzclgVar.zzz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzdss zzk(zzfeb zzfebVar) {
        zzdss zzdssVarZzi = this.zzc.zzi();
        zzdaf zzdafVar = new zzdaf();
        zzdafVar.zze(this.zza);
        zzdafVar.zzi(((zzffy) zzfebVar).zza);
        zzdafVar.zzh(this.zzf);
        zzdssVarZzi.zzd(zzdafVar.zzj());
        zzdssVarZzi.zzc(new zzdgm().zzn());
        return zzdssVarZzi;
    }

    @Override // com.google.android.gms.internal.ads.zzequ
    public final boolean zza() {
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0055  */
    @Override // com.google.android.gms.internal.ads.zzequ
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzeqs zzeqsVar, zzeqt zzeqtVar) throws RemoteException {
        zzfmz zzfmzVar;
        zzcab zzcabVar = new zzcab(zzlVar, str);
        if (zzcabVar.zzb == null) {
            zzcec.zzg("Ad unit ID should not be null for rewarded video ad.");
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzffs
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzi();
                }
            });
            return false;
        }
        ListenableFuture listenableFuture = this.zzi;
        if (listenableFuture != null && !listenableFuture.isDone()) {
            return false;
        }
        if (((Boolean) zzbht.zzc.zze()).booleanValue()) {
            zzfed zzfedVar = this.zze;
            if (zzfedVar.zzd() != null) {
                zzfmz zzfmzVarZzh = ((zzdst) zzfedVar.zzd()).zzh();
                zzfmzVarZzh.zzh(5);
                zzfmzVarZzh.zzb(zzcabVar.zza.zzp);
                zzfmzVar = zzfmzVarZzh;
            } else {
                zzfmzVar = null;
            }
        } else {
            zzfmzVar = null;
        }
        zzfie.zza(this.zza, zzcabVar.zza.zzf);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziN)).booleanValue() && zzcabVar.zza.zzf) {
            this.zzc.zzk().zzn(true);
        }
        zzfhf zzfhfVar = this.zzh;
        zzfhfVar.zzs(zzcabVar.zzb);
        zzfhfVar.zzr(com.google.android.gms.ads.internal.client.zzq.zzd());
        zzfhfVar.zzE(zzcabVar.zza);
        Context context = this.zza;
        zzfhh zzfhhVarZzG = zzfhfVar.zzG();
        zzfmo zzfmoVarZzb = zzfmn.zzb(context, zzfmy.zzf(zzfhhVarZzG), 5, zzcabVar.zza);
        zzffy zzffyVar = new zzffy(null);
        zzffyVar.zza = zzfhhVarZzG;
        ListenableFuture listenableFutureZzc = this.zze.zzc(new zzfee(zzffyVar, null), new zzfec() { // from class: com.google.android.gms.internal.ads.zzfft
            @Override // com.google.android.gms.internal.ads.zzfec
            public final zzdad zza(zzfeb zzfebVar) {
                return this.zza.zzk(zzfebVar);
            }
        }, null);
        this.zzi = listenableFutureZzc;
        zzgen.zzr(listenableFutureZzc, new zzffw(this, zzeqtVar, zzfmzVar, zzfmoVarZzb, zzffyVar), this.zzb);
        return true;
    }

    final /* synthetic */ void zzi() {
        this.zzd.zzbK(zzfij.zzd(6, null, null));
    }

    final void zzj(int i) {
        this.zzh.zzo().zza(i);
    }
}
