package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfcy implements zzequ {
    private final Context zza;
    private final Executor zzb;
    private final zzclg zzc;
    private final zzeqe zzd;
    private final zzeqi zze;
    private final ViewGroup zzf;
    private zzbha zzg;
    private final zzddm zzh;
    private final zzfnc zzi;
    private final zzdft zzj;
    private final zzfhf zzk;
    private ListenableFuture zzl;

    public zzfcy(Context context, Executor executor, com.google.android.gms.ads.internal.client.zzq zzqVar, zzclg zzclgVar, zzeqe zzeqeVar, zzeqi zzeqiVar, zzfhf zzfhfVar, zzdft zzdftVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzclgVar;
        this.zzd = zzeqeVar;
        this.zze = zzeqiVar;
        this.zzk = zzfhfVar;
        this.zzh = zzclgVar.zzf();
        this.zzi = zzclgVar.zzz();
        this.zzf = new FrameLayout(context);
        this.zzj = zzdftVar;
        zzfhfVar.zzr(zzqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzequ
    public final boolean zza() {
        ListenableFuture listenableFuture = this.zzl;
        return (listenableFuture == null || listenableFuture.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzequ
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzeqs zzeqsVar, zzeqt zzeqtVar) throws RemoteException {
        zzcvc zzcvcVarZzk;
        zzfmz zzfmzVar;
        if (str == null) {
            zzcec.zzg("Ad unit ID should not be null for banner ad.");
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfcu
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzm();
                }
            });
            return false;
        }
        if (!zza()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziN)).booleanValue() && zzlVar.zzf) {
                this.zzc.zzk().zzn(true);
            }
            zzfhf zzfhfVar = this.zzk;
            zzfhfVar.zzs(str);
            zzfhfVar.zzE(zzlVar);
            Context context = this.zza;
            zzfhh zzfhhVarZzG = zzfhfVar.zzG();
            zzfmo zzfmoVarZzb = zzfmn.zzb(context, zzfmy.zzf(zzfhhVarZzG), 3, zzlVar);
            if (!((Boolean) zzbig.zze.zze()).booleanValue() || !this.zzk.zzg().zzk) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhZ)).booleanValue()) {
                    zzcvb zzcvbVarZze = this.zzc.zze();
                    zzdaf zzdafVar = new zzdaf();
                    zzdafVar.zze(this.zza);
                    zzdafVar.zzi(zzfhhVarZzG);
                    zzcvbVarZze.zzi(zzdafVar.zzj());
                    zzdgm zzdgmVar = new zzdgm();
                    zzdgmVar.zzj(this.zzd, this.zzb);
                    zzdgmVar.zzk(this.zzd, this.zzb);
                    zzcvbVarZze.zzf(zzdgmVar.zzn());
                    zzcvbVarZze.zze(new zzeon(this.zzg));
                    zzcvbVarZze.zzd(new zzdlf(zzdnl.zza, null));
                    zzcvbVarZze.zzg(new zzcvz(this.zzh, this.zzj));
                    zzcvbVarZze.zzc(new zzcuc(this.zzf));
                    zzcvcVarZzk = zzcvbVarZze.zzh();
                } else {
                    zzcvb zzcvbVarZze2 = this.zzc.zze();
                    zzdaf zzdafVar2 = new zzdaf();
                    zzdafVar2.zze(this.zza);
                    zzdafVar2.zzi(zzfhhVarZzG);
                    zzcvbVarZze2.zzi(zzdafVar2.zzj());
                    zzdgm zzdgmVar2 = new zzdgm();
                    zzdgmVar2.zzj(this.zzd, this.zzb);
                    zzdgmVar2.zza(this.zzd, this.zzb);
                    zzdgmVar2.zza(this.zze, this.zzb);
                    zzdgmVar2.zzl(this.zzd, this.zzb);
                    zzdgmVar2.zzd(this.zzd, this.zzb);
                    zzdgmVar2.zze(this.zzd, this.zzb);
                    zzdgmVar2.zzf(this.zzd, this.zzb);
                    zzdgmVar2.zzb(this.zzd, this.zzb);
                    zzdgmVar2.zzk(this.zzd, this.zzb);
                    zzdgmVar2.zzi(this.zzd, this.zzb);
                    zzcvbVarZze2.zzf(zzdgmVar2.zzn());
                    zzcvbVarZze2.zze(new zzeon(this.zzg));
                    zzcvbVarZze2.zzd(new zzdlf(zzdnl.zza, null));
                    zzcvbVarZze2.zzg(new zzcvz(this.zzh, this.zzj));
                    zzcvbVarZze2.zzc(new zzcuc(this.zzf));
                    zzcvcVarZzk = zzcvbVarZze2.zzh();
                }
                zzcvc zzcvcVar = zzcvcVarZzk;
                if (((Boolean) zzbht.zzc.zze()).booleanValue()) {
                    zzfmz zzfmzVarZzj = zzcvcVar.zzj();
                    zzfmzVarZzj.zzh(3);
                    zzfmzVarZzj.zzb(zzlVar.zzp);
                    zzfmzVar = zzfmzVarZzj;
                } else {
                    zzfmzVar = null;
                }
                zzcxp zzcxpVarZzd = zzcvcVar.zzd();
                ListenableFuture listenableFutureZzi = zzcxpVarZzd.zzi(zzcxpVarZzd.zzj());
                this.zzl = listenableFutureZzi;
                zzgen.zzr(listenableFutureZzi, new zzfcx(this, zzeqtVar, zzfmzVar, zzfmoVarZzb, zzcvcVar), this.zzb);
                return true;
            }
            zzeqe zzeqeVar = this.zzd;
            if (zzeqeVar != null) {
                zzeqeVar.zzbK(zzfij.zzd(7, null, null));
            }
        }
        return false;
    }

    public final ViewGroup zzd() {
        return this.zzf;
    }

    public final zzfhf zzi() {
        return this.zzk;
    }

    final /* synthetic */ void zzm() {
        this.zzd.zzbK(zzfij.zzd(6, null, null));
    }

    public final void zzn() {
        this.zzh.zzd(this.zzj.zzc());
    }

    public final void zzo(com.google.android.gms.ads.internal.client.zzbe zzbeVar) {
        this.zze.zza(zzbeVar);
    }

    public final void zzp(zzddn zzddnVar) {
        this.zzh.zzo(zzddnVar, this.zzb);
    }

    public final void zzq(zzbha zzbhaVar) {
        this.zzg = zzbhaVar;
    }

    public final boolean zzr() {
        Object parent = this.zzf.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        com.google.android.gms.ads.internal.zzt.zzp();
        return com.google.android.gms.ads.internal.util.zzt.zzV(view, view.getContext());
    }
}
