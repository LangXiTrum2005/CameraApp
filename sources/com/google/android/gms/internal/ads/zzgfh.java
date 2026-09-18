package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgfh implements Runnable {

    @CheckForNull
    zzgfk zza;

    zzgfh(zzgfk zzgfkVar) {
        this.zza = zzgfkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture listenableFuture;
        zzgfk zzgfkVar = this.zza;
        if (zzgfkVar == null || (listenableFuture = zzgfkVar.zza) == null) {
            return;
        }
        this.zza = null;
        if (listenableFuture.isDone()) {
            zzgfkVar.zzs(listenableFuture);
            return;
        }
        try {
            ScheduledFuture scheduledFuture = zzgfkVar.zzb;
            zzgfkVar.zzb = null;
            String str = "Timed out";
            if (scheduledFuture != null) {
                try {
                    long jAbs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                    if (jAbs > 10) {
                        str = "Timed out (timeout delayed by " + jAbs + " ms after scheduled time)";
                    }
                } catch (Throwable th) {
                    zzgfkVar.zzd(new zzgfj(str, null));
                    throw th;
                }
            }
            zzgfkVar.zzd(new zzgfj(str + ": " + listenableFuture.toString(), null));
            listenableFuture.cancel(true);
        } catch (Throwable th2) {
            listenableFuture.cancel(true);
            throw th2;
        }
    }
}
