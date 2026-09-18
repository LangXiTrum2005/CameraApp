package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzejs implements zzeit {
    private final Context zza;
    private final zzcvc zzb;
    private final Executor zzc;

    public zzejs(Context context, zzcvc zzcvcVar, Executor executor) {
        this.zza = context;
        this.zzb = zzcvcVar;
        this.zzc = executor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzeit
    public final /* bridge */ /* synthetic */ Object zza(zzfgy zzfgyVar, final zzfgm zzfgmVar, zzeiq zzeiqVar) throws zzeml, zzfho {
        final View viewZza;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhI)).booleanValue() && zzfgmVar.zzah) {
            zzbte zzbteVarZzc = ((zzfif) zzeiqVar.zzb).zzc();
            if (zzbteVarZzc == null) {
                zzcec.zzg("getInterscrollerAd should not be null after loadInterscrollerAd loaded ad.");
                throw new zzfho(new Exception("getInterscrollerAd should not be null after loadInterscrollerAd loaded ad."));
            }
            try {
                viewZza = (View) ObjectWrapper.unwrap(zzbteVarZzc.zze());
                boolean zZzf = zzbteVarZzc.zzf();
                if (viewZza == null) {
                    throw new zzfho(new Exception("BannerAdapterWrapper interscrollerView should not be null"));
                }
                if (zZzf) {
                    try {
                        viewZza = (View) zzgen.zzn(zzgen.zzh(null), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzejq
                            @Override // com.google.android.gms.internal.ads.zzgdu
                            public final ListenableFuture zza(Object obj) {
                                return this.zza.zzc(viewZza, zzfgmVar, obj);
                            }
                        }, zzcep.zze).get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new zzfho(e);
                    }
                }
            } catch (RemoteException e2) {
                throw new zzfho(e2);
            }
        } else {
            viewZza = ((zzfif) zzeiqVar.zzb).zza();
        }
        zzcvc zzcvcVar = this.zzb;
        zzcwx zzcwxVar = new zzcwx(zzfgyVar, zzfgmVar, zzeiqVar.zza);
        final zzfif zzfifVar = (zzfif) zzeiqVar.zzb;
        Objects.requireNonNull(zzfifVar);
        zzcug zzcugVarZza = zzcvcVar.zza(zzcwxVar, new zzcum(viewZza, null, new zzcwf() { // from class: com.google.android.gms.internal.ads.zzejr
            @Override // com.google.android.gms.internal.ads.zzcwf
            public final com.google.android.gms.ads.internal.client.zzdq zza() {
                return zzfifVar.zzb();
            }
        }, (zzfgn) zzfgmVar.zzv.get(0)));
        zzcugVarZza.zzg().zza(viewZza);
        zzcugVarZza.zzd().zzo(new zzcrv((zzfif) zzeiqVar.zzb), this.zzc);
        ((zzekj) zzeiqVar.zzc).zzc(zzcugVarZza.zzj());
        return zzcugVarZza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final void zzb(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar) throws zzfho {
        com.google.android.gms.ads.internal.client.zzq zzqVar;
        com.google.android.gms.ads.internal.client.zzq zzqVar2 = zzfgyVar.zza.zza.zze;
        if (zzqVar2.zzn) {
            zzqVar = new com.google.android.gms.ads.internal.client.zzq(this.zza, com.google.android.gms.ads.zzb.zzd(zzqVar2.zze, zzqVar2.zzb));
        } else {
            zzqVar = (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhI)).booleanValue() && zzfgmVar.zzah) ? new com.google.android.gms.ads.internal.client.zzq(this.zza, com.google.android.gms.ads.zzb.zze(zzqVar2.zze, zzqVar2.zzb)) : zzfhn.zza(this.zza, zzfgmVar.zzv);
        }
        com.google.android.gms.ads.internal.client.zzq zzqVar3 = zzqVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhI)).booleanValue() && zzfgmVar.zzah) {
            Object obj = zzeiqVar.zzb;
            ((zzfif) obj).zzn(this.zza, zzqVar3, zzfgyVar.zza.zza.zzd, zzfgmVar.zzw.toString(), com.google.android.gms.ads.internal.util.zzbw.zzl(zzfgmVar.zzt), (zzbtb) zzeiqVar.zzc);
            return;
        }
        Object obj2 = zzeiqVar.zzb;
        ((zzfif) obj2).zzm(this.zza, zzqVar3, zzfgyVar.zza.zza.zzd, zzfgmVar.zzw.toString(), com.google.android.gms.ads.internal.util.zzbw.zzl(zzfgmVar.zzt), (zzbtb) zzeiqVar.zzc);
    }

    final /* synthetic */ ListenableFuture zzc(View view, zzfgm zzfgmVar, Object obj) throws Exception {
        return zzgen.zzh(zzcvt.zza(this.zza, view, zzfgmVar));
    }
}
