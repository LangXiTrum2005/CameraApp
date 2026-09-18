package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzemo implements zzgdu {
    private final zzflm zza;
    private final zzdaz zzb;
    private final zzfnu zzc;
    private final zzfny zzd;
    private final Executor zze;
    private final ScheduledExecutorService zzf;
    private final zzcwk zzg;
    private final zzemh zzh;
    private final zzeis zzi;
    private final Context zzj;
    private final zzfmz zzk;
    private final zzelr zzl;

    zzemo(Context context, zzflm zzflmVar, zzemh zzemhVar, zzdaz zzdazVar, zzfnu zzfnuVar, zzfny zzfnyVar, zzcwk zzcwkVar, Executor executor, ScheduledExecutorService scheduledExecutorService, zzeis zzeisVar, zzfmz zzfmzVar, zzelr zzelrVar) {
        this.zzj = context;
        this.zza = zzflmVar;
        this.zzh = zzemhVar;
        this.zzb = zzdazVar;
        this.zzc = zzfnuVar;
        this.zzd = zzfnyVar;
        this.zzg = zzcwkVar;
        this.zze = executor;
        this.zzf = scheduledExecutorService;
        this.zzi = zzeisVar;
        this.zzk = zzfmzVar;
        this.zzl = zzelrVar;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0054  */
    static String zzc(zzfgy zzfgyVar) {
        String str = "No fill.";
        String str2 = true != ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfu)).booleanValue() ? "No ad config." : "No fill.";
        int i = zzfgyVar.zzb.zzb.zze;
        if (i == 0) {
            str = str2;
        } else if (i >= 200 && i < 300) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzft)).booleanValue()) {
                str = str2;
            }
        } else if (i < 300 || i >= 400) {
            str = "Received error HTTP response code: " + i;
        } else {
            str = "No location header to follow redirect or too many redirects.";
        }
        zzfgo zzfgoVar = zzfgyVar.zzb.zzb.zzi;
        return zzfgoVar != null ? zzfgoVar.zza() : str;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0066  */
    /* JADX WARN: Code duplicated, block: B:19:0x0074  */
    /* JADX WARN: Code duplicated, block: B:22:0x008b  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a2 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzgdu
    public final /* synthetic */ ListenableFuture zza(Object obj) throws Exception {
        Iterator it;
        zzein zzeinVarZza;
        int i;
        final zzfgy zzfgyVar = (zzfgy) obj;
        String strZzc = zzc(zzfgyVar);
        this.zzi.zzi(zzfgyVar.zzb.zzb);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzih)).booleanValue() && (i = zzfgyVar.zzb.zzb.zze) != 0 && (i < 200 || i >= 300)) {
            return zzgen.zzg(new zzeml(3, strZzc));
        }
        zzfgp zzfgpVar = zzfgyVar.zzb.zzb;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzds)).booleanValue()) {
            for (zzfgm zzfgmVar : zzfgyVar.zzb.zza) {
                this.zzi.zzd(zzfgmVar);
                it = zzfgmVar.zza.iterator();
                while (true) {
                    if (it.hasNext()) {
                        this.zzi.zzf(zzfgmVar, 0L, zzfij.zzd(1, null, null));
                        break;
                        break;
                    }
                    zzeinVarZza = this.zzg.zza(zzfgmVar.zzb, (String) it.next());
                    if (zzeinVarZza == null) {
                    }
                }
            }
        } else {
            String str = zzfgpVar.zzo;
            if (TextUtils.isEmpty(str)) {
                while (r0.hasNext()) {
                    this.zzi.zzd(zzfgmVar);
                    it = zzfgmVar.zza.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            this.zzi.zzf(zzfgmVar, 0L, zzfij.zzd(1, null, null));
                            break;
                        }
                        zzeinVarZza = this.zzg.zza(zzfgmVar.zzb, (String) it.next());
                        if (zzeinVarZza == null && zzeinVarZza.zzb(zzfgyVar, zzfgmVar)) {
                            break;
                        }
                    }
                }
            } else {
                this.zzi.zzh(str, zzfgyVar.zzb.zza);
            }
        }
        this.zzb.zzo(new zzcsi(zzfgyVar, this.zzd, this.zzc), this.zze);
        if (zzfgyVar.zzb.zzb.zzp > 1) {
            return this.zzl.zzb(zzfgyVar);
        }
        zzfkr zzfkrVarZza = zzfkw.zzc(zzgen.zzg(new zzeml(3, zzc(zzfgyVar))), zzflg.RENDER_CONFIG_INIT, this.zza).zza();
        this.zzh.zzl();
        int i2 = 0;
        for (final zzfgm zzfgmVar2 : zzfgyVar.zzb.zza) {
            for (String str2 : zzfgmVar2.zza) {
                final zzein zzeinVarZza2 = this.zzg.zza(zzfgmVar2.zzb, str2);
                if (zzeinVarZza2 != null && zzeinVarZza2.zzb(zzfgyVar, zzfgmVar2)) {
                    zzfkrVarZza = this.zza.zzb(zzflg.RENDER_CONFIG_WATERFALL, zzfkrVarZza).zzh("render-config-" + i2 + "-" + str2).zzc(Throwable.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzemm
                        @Override // com.google.android.gms.internal.ads.zzgdu
                        public final ListenableFuture zza(Object obj2) {
                            return this.zza.zzb(zzfgmVar2, zzfgyVar, zzeinVarZza2, (Throwable) obj2);
                        }
                    }).zza();
                    break;
                }
            }
            i2++;
        }
        final zzemh zzemhVar = this.zzh;
        Objects.requireNonNull(zzemhVar);
        zzfkrVarZza.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzemn
            @Override // java.lang.Runnable
            public final void run() {
                zzemhVar.zzj();
            }
        }, this.zze);
        return zzfkrVarZza;
    }

    final /* synthetic */ ListenableFuture zzb(zzfgm zzfgmVar, zzfgy zzfgyVar, zzein zzeinVar, Throwable th) throws Exception {
        zzfmo zzfmoVarZza = zzfmn.zza(this.zzj, 12);
        zzfmoVarZza.zzd(zzfgmVar.zzF);
        zzfmoVarZza.zzh();
        ListenableFuture listenableFutureZzo = zzgen.zzo(zzeinVar.zza(zzfgyVar, zzfgmVar), zzfgmVar.zzS, TimeUnit.MILLISECONDS, this.zzf);
        this.zzh.zzf(zzfgyVar, zzfgmVar, listenableFutureZzo, this.zzc);
        zzfmy.zza(listenableFutureZzo, this.zzk, zzfmoVarZza);
        return listenableFutureZzo;
    }
}
