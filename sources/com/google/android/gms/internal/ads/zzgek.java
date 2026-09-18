package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgek implements Runnable {
    final Future zza;
    final zzgej zzb;

    zzgek(Future future, zzgej zzgejVar) {
        this.zza = future;
        this.zzb = zzgejVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable thZza;
        Object obj = this.zza;
        if ((obj instanceof zzgfq) && (thZza = zzgfr.zza((zzgfq) obj)) != null) {
            this.zzb.zza(thZza);
            return;
        }
        try {
            this.zzb.zzb(zzgen.zzp(this.zza));
        } catch (ExecutionException e) {
            this.zzb.zza(e.getCause());
        } catch (Throwable th) {
            this.zzb.zza(th);
        }
    }

    public final String toString() {
        zzfww zzfwwVarZza = zzfwx.zza(this);
        zzfwwVarZza.zza(this.zzb);
        return zzfwwVarZza.toString();
    }
}
