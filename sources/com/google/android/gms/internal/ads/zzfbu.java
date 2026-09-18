package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfbu implements zzequ {
    protected final zzclg zza;
    private final Context zzb;
    private final Executor zzc;
    private final zzfck zzd;
    private final zzfed zze;
    private final zzcei zzf;
    private final ViewGroup zzg;
    private final zzfnc zzh;
    private final zzfhf zzi;

    @Nullable
    private ListenableFuture zzj;

    protected zzfbu(Context context, Executor executor, zzclg zzclgVar, zzfed zzfedVar, zzfck zzfckVar, zzfhf zzfhfVar, zzcei zzceiVar) {
        this.zzb = context;
        this.zzc = executor;
        this.zza = zzclgVar;
        this.zze = zzfedVar;
        this.zzd = zzfckVar;
        this.zzi = zzfhfVar;
        this.zzf = zzceiVar;
        this.zzg = new FrameLayout(context);
        this.zzh = zzclgVar.zzz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized zzdad zzm(zzfeb zzfebVar) {
        zzfbt zzfbtVar = (zzfbt) zzfebVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzia)).booleanValue()) {
            zzcuc zzcucVar = new zzcuc(this.zzg);
            zzdaf zzdafVar = new zzdaf();
            zzdafVar.zze(this.zzb);
            zzdafVar.zzi(zzfbtVar.zza);
            zzdah zzdahVarZzj = zzdafVar.zzj();
            zzdgm zzdgmVar = new zzdgm();
            zzdgmVar.zzc(this.zzd, this.zzc);
            zzdgmVar.zzl(this.zzd, this.zzc);
            return zze(zzcucVar, zzdahVarZzj, zzdgmVar.zzn());
        }
        zzfck zzfckVarZzi = zzfck.zzi(this.zzd);
        zzdgm zzdgmVar2 = new zzdgm();
        zzdgmVar2.zzb(zzfckVarZzi, this.zzc);
        zzdgmVar2.zzg(zzfckVarZzi, this.zzc);
        zzdgmVar2.zzh(zzfckVarZzi, this.zzc);
        zzdgmVar2.zzi(zzfckVarZzi, this.zzc);
        zzdgmVar2.zzc(zzfckVarZzi, this.zzc);
        zzdgmVar2.zzl(zzfckVarZzi, this.zzc);
        zzdgmVar2.zzm(zzfckVarZzi);
        zzcuc zzcucVar2 = new zzcuc(this.zzg);
        zzdaf zzdafVar2 = new zzdaf();
        zzdafVar2.zze(this.zzb);
        zzdafVar2.zzi(zzfbtVar.zza);
        return zze(zzcucVar2, zzdafVar2.zzj(), zzdgmVar2.zzn());
    }

    @Override // com.google.android.gms.internal.ads.zzequ
    public final boolean zza() {
        ListenableFuture listenableFuture = this.zzj;
        return (listenableFuture == null || listenableFuture.isDone()) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0088  */
    /* JADX WARN: Code duplicated, block: B:8:0x0025  */
    @Override // com.google.android.gms.internal.ads.zzequ
    public final synchronized boolean zzb(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzeqs zzeqsVar, zzeqt zzeqtVar) throws RemoteException {
        boolean z;
        zzfmz zzfmzVar;
        if (((Boolean) zzbhy.zzd.zze()).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkG)).booleanValue()) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (this.zzf.zzc < ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkH)).intValue() || !z) {
            Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        }
        if (str == null) {
            zzcec.zzg("Ad unit ID should not be null for app open ad.");
            this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfbo
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzk();
                }
            });
            return false;
        }
        if (this.zzj != null) {
            return false;
        }
        if (((Boolean) zzbht.zzc.zze()).booleanValue()) {
            zzfed zzfedVar = this.zze;
            if (zzfedVar.zzd() != null) {
                zzfmz zzfmzVarZzh = ((zzctp) zzfedVar.zzd()).zzh();
                zzfmzVarZzh.zzh(7);
                zzfmzVarZzh.zzb(zzlVar.zzp);
                zzfmzVar = zzfmzVarZzh;
            } else {
                zzfmzVar = null;
            }
        } else {
            zzfmzVar = null;
        }
        zzfie.zza(this.zzb, zzlVar.zzf);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziN)).booleanValue() && zzlVar.zzf) {
            this.zza.zzk().zzn(true);
        }
        zzfhf zzfhfVar = this.zzi;
        zzfhfVar.zzs(str);
        zzfhfVar.zzr(com.google.android.gms.ads.internal.client.zzq.zzb());
        zzfhfVar.zzE(zzlVar);
        Context context = this.zzb;
        zzfhh zzfhhVarZzG = zzfhfVar.zzG();
        zzfmo zzfmoVarZzb = zzfmn.zzb(context, zzfmy.zzf(zzfhhVarZzG), 7, zzlVar);
        zzfbt zzfbtVar = new zzfbt(null);
        zzfbtVar.zza = zzfhhVarZzG;
        ListenableFuture listenableFutureZzc = this.zze.zzc(new zzfee(zzfbtVar, null), new zzfec() { // from class: com.google.android.gms.internal.ads.zzfbp
            @Override // com.google.android.gms.internal.ads.zzfec
            public final zzdad zza(zzfeb zzfebVar) {
                return this.zza.zzm(zzfebVar);
            }
        }, null);
        this.zzj = listenableFutureZzc;
        zzgen.zzr(listenableFutureZzc, new zzfbr(this, zzeqtVar, zzfmzVar, zzfmoVarZzb, zzfbtVar), this.zzc);
        return true;
    }

    protected abstract zzdad zze(zzcuc zzcucVar, zzdah zzdahVar, zzdgo zzdgoVar);

    final /* synthetic */ void zzk() {
        this.zzd.zzbK(zzfij.zzd(6, null, null));
    }

    public final void zzl(com.google.android.gms.ads.internal.client.zzw zzwVar) {
        this.zzi.zzt(zzwVar);
    }
}
