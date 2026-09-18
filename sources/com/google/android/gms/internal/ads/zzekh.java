package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzekh implements zzein {
    private final zzcvc zza;
    private final zzejo zzb;
    private final zzgey zzc;
    private final zzdaz zzd;
    private final ScheduledExecutorService zze;
    private final zzdwa zzf;

    public zzekh(zzcvc zzcvcVar, zzejo zzejoVar, zzdaz zzdazVar, ScheduledExecutorService scheduledExecutorService, zzgey zzgeyVar, zzdwa zzdwaVar) {
        this.zza = zzcvcVar;
        this.zzb = zzejoVar;
        this.zzd = zzdazVar;
        this.zze = scheduledExecutorService;
        this.zzc = zzgeyVar;
        this.zzf = zzdwaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzein
    public final ListenableFuture zza(final zzfgy zzfgyVar, final zzfgm zzfgmVar) {
        return this.zzc.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzekf
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc(zzfgyVar, zzfgmVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzein
    public final boolean zzb(zzfgy zzfgyVar, zzfgm zzfgmVar) {
        zzbld zzbldVarZza = zzfgyVar.zza.zza.zza();
        boolean zZzb = this.zzb.zzb(zzfgyVar, zzfgmVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlq)).booleanValue()) {
            this.zzf.zza().put("has_dbl", zzbldVarZza != null ? "1" : "0");
            this.zzf.zza().put("crdb", true != zZzb ? "0" : "1");
        }
        return zzbldVarZza != null && zZzb;
    }

    final /* synthetic */ zzcuf zzc(final zzfgy zzfgyVar, final zzfgm zzfgmVar) throws Exception {
        return this.zza.zzb(new zzcwx(zzfgyVar, zzfgmVar, null), new zzcvp(zzfgyVar.zza.zza.zza(), new Runnable() { // from class: com.google.android.gms.internal.ads.zzeke
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzf(zzfgyVar, zzfgmVar);
            }
        })).zza();
    }

    final /* synthetic */ void zzf(zzfgy zzfgyVar, zzfgm zzfgmVar) {
        zzgen.zzr(zzgen.zzo(this.zzb.zza(zzfgyVar, zzfgmVar), zzfgmVar.zzS, TimeUnit.SECONDS, this.zze), new zzekg(this), this.zzc);
    }
}
