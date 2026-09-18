package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzelr {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final zzcwk zzc;
    private final zzemh zzd;
    private final zzfnu zze;
    private final zzgfg zzf = zzgfg.zze();
    private final AtomicBoolean zzg = new AtomicBoolean();
    private zzels zzh;
    private zzfgy zzi;

    zzelr(Executor executor, ScheduledExecutorService scheduledExecutorService, zzcwk zzcwkVar, zzemh zzemhVar, zzfnu zzfnuVar) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = zzcwkVar;
        this.zzd = zzemhVar;
        this.zze = zzfnuVar;
    }

    private final synchronized ListenableFuture zzd(zzfgm zzfgmVar) {
        Iterator it = zzfgmVar.zza.iterator();
        while (it.hasNext()) {
            zzein zzeinVarZza = this.zzc.zza(zzfgmVar.zzb, (String) it.next());
            if (zzeinVarZza != null && zzeinVarZza.zzb(this.zzi, zzfgmVar)) {
                return zzgen.zzo(zzeinVarZza.zza(this.zzi, zzfgmVar), zzfgmVar.zzS, TimeUnit.MILLISECONDS, this.zzb);
            }
        }
        return zzgen.zzg(new zzead(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zze(zzfgm zzfgmVar) {
        if (zzfgmVar == null) {
            return;
        }
        ListenableFuture listenableFutureZzd = zzd(zzfgmVar);
        this.zzd.zzf(this.zzi, zzfgmVar, listenableFutureZzd, this.zze);
        zzgen.zzr(listenableFutureZzd, new zzelq(this, zzfgmVar), this.zza);
    }

    public final synchronized ListenableFuture zzb(zzfgy zzfgyVar) {
        if (!this.zzg.getAndSet(true)) {
            if (zzfgyVar.zzb.zza.isEmpty()) {
                this.zzf.zzd(new zzeml(3, zzemo.zzc(zzfgyVar)));
            } else {
                this.zzi = zzfgyVar;
                this.zzh = new zzels(zzfgyVar, this.zzd, this.zzf);
                this.zzd.zzk(zzfgyVar.zzb.zza);
                while (this.zzh.zze()) {
                    zze(this.zzh.zza());
                }
            }
        }
        return this.zzf;
    }
}
