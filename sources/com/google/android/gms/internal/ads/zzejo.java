package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzejo implements zzein {
    private final zzcvc zza;
    private final Context zzb;
    private final zzdtk zzc;
    private final zzfhh zzd;
    private final Executor zze;
    private final zzfws zzf;

    public zzejo(zzcvc zzcvcVar, Context context, Executor executor, zzdtk zzdtkVar, zzfhh zzfhhVar, zzfws zzfwsVar) {
        this.zzb = context;
        this.zza = zzcvcVar;
        this.zze = executor;
        this.zzc = zzdtkVar;
        this.zzd = zzfhhVar;
        this.zzf = zzfwsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzein
    public final ListenableFuture zza(final zzfgy zzfgyVar, final zzfgm zzfgmVar) {
        return zzgen.zzn(zzgen.zzh(null), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzejn
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzc(zzfgyVar, zzfgmVar, obj);
            }
        }, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzein
    public final boolean zzb(zzfgy zzfgyVar, zzfgm zzfgmVar) {
        zzfgr zzfgrVar = zzfgmVar.zzt;
        return (zzfgrVar == null || zzfgrVar.zza == null) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ ListenableFuture zzc(zzfgy zzfgyVar, zzfgm zzfgmVar, Object obj) throws Exception {
        View zzdtnVar;
        com.google.android.gms.ads.internal.client.zzq zzqVarZza = zzfhn.zza(this.zzb, zzfgmVar.zzv);
        final zzcjk zzcjkVarZza = this.zzc.zza(zzqVarZza, zzfgmVar, zzfgyVar.zzb.zzb);
        zzcjkVarZza.zzaa(zzfgmVar.zzX);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhI)).booleanValue() && zzfgmVar.zzah) {
            zzdtnVar = zzcvt.zza(this.zzb, (View) zzcjkVarZza, zzfgmVar);
        } else {
            zzdtnVar = new zzdtn(this.zzb, (View) zzcjkVarZza, (com.google.android.gms.ads.internal.util.zzau) this.zzf.apply(zzfgmVar));
        }
        zzcvc zzcvcVar = this.zza;
        zzcwx zzcwxVar = new zzcwx(zzfgyVar, zzfgmVar, null);
        Objects.requireNonNull(zzcjkVarZza);
        final zzcug zzcugVarZza = zzcvcVar.zza(zzcwxVar, new zzcum(zzdtnVar, zzcjkVarZza, new zzcwf() { // from class: com.google.android.gms.internal.ads.zzeji
            @Override // com.google.android.gms.internal.ads.zzcwf
            public final com.google.android.gms.ads.internal.client.zzdq zza() {
                return zzcjkVarZza.zzq();
            }
        }, zzfhn.zzb(zzqVarZza)));
        zzcugVarZza.zzh().zzi(zzcjkVarZza, false, null);
        zzcugVarZza.zzc().zzo(new zzdbr() { // from class: com.google.android.gms.internal.ads.zzejj
            @Override // com.google.android.gms.internal.ads.zzdbr
            public final void zzq() {
                zzcjk zzcjkVar = zzcjkVarZza;
                if (zzcjkVar.zzN() != null) {
                    zzcjkVar.zzN().zzr();
                }
            }
        }, zzcep.zzf);
        zzcugVarZza.zzh();
        zzfgr zzfgrVar = zzfgmVar.zzt;
        ListenableFuture listenableFutureZzj = zzdtj.zzj(zzcjkVarZza, zzfgrVar.zzb, zzfgrVar.zza);
        if (zzfgmVar.zzN) {
            Objects.requireNonNull(zzcjkVarZza);
            listenableFutureZzj.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzejk
                @Override // java.lang.Runnable
                public final void run() {
                    zzcjkVarZza.zzaf();
                }
            }, this.zze);
        }
        listenableFutureZzj.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzejl
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd(zzcjkVarZza);
            }
        }, this.zze);
        return zzgen.zzm(listenableFutureZzj, new zzfws() { // from class: com.google.android.gms.internal.ads.zzejm
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj2) {
                return zzcugVarZza.zza();
            }
        }, zzcep.zzf);
    }

    final /* synthetic */ void zzd(zzcjk zzcjkVar) {
        zzcjkVar.zzZ();
        zzcki zzckiVarZzq = zzcjkVar.zzq();
        com.google.android.gms.ads.internal.client.zzfk zzfkVar = this.zzd.zza;
        if (zzfkVar != null && zzckiVarZzq != null) {
            zzckiVarZzq.zzs(zzfkVar);
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbi)).booleanValue() || zzcjkVar.isAttachedToWindow()) {
            return;
        }
        zzcjkVar.onPause();
        zzcjkVar.zzas(true);
    }
}
