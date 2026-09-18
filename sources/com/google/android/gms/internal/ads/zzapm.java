package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzapm extends Thread {
    private static final boolean zza = zzaqm.zzb;
    private final BlockingQueue zzb;
    private final BlockingQueue zzc;
    private final zzapk zzd;
    private volatile boolean zze = false;
    private final zzaqn zzf;
    private final zzapr zzg;

    public zzapm(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, zzapk zzapkVar, zzapr zzaprVar) {
        this.zzb = blockingQueue;
        this.zzc = blockingQueue2;
        this.zzd = zzapkVar;
        this.zzg = zzaprVar;
        this.zzf = new zzaqn(this, blockingQueue2, zzaprVar);
    }

    private void zzc() throws InterruptedException {
        zzaqa zzaqaVar = (zzaqa) this.zzb.take();
        zzaqaVar.zzm("cache-queue-take");
        zzaqaVar.zzt(1);
        try {
            zzaqaVar.zzw();
            zzapj zzapjVarZza = this.zzd.zza(zzaqaVar.zzj());
            if (zzapjVarZza == null) {
                zzaqaVar.zzm("cache-miss");
                if (!this.zzf.zzc(zzaqaVar)) {
                    this.zzc.put(zzaqaVar);
                }
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (zzapjVarZza.zza(jCurrentTimeMillis)) {
                    zzaqaVar.zzm("cache-hit-expired");
                    zzaqaVar.zze(zzapjVarZza);
                    if (!this.zzf.zzc(zzaqaVar)) {
                        this.zzc.put(zzaqaVar);
                    }
                } else {
                    zzaqaVar.zzm("cache-hit");
                    zzaqg zzaqgVarZzh = zzaqaVar.zzh(new zzapw(zzapjVarZza.zza, zzapjVarZza.zzg));
                    zzaqaVar.zzm("cache-hit-parsed");
                    if (!zzaqgVarZzh.zzc()) {
                        zzaqaVar.zzm("cache-parsing-failed");
                        this.zzd.zzc(zzaqaVar.zzj(), true);
                        zzaqaVar.zze(null);
                        if (!this.zzf.zzc(zzaqaVar)) {
                            this.zzc.put(zzaqaVar);
                        }
                    } else if (zzapjVarZza.zzf < jCurrentTimeMillis) {
                        zzaqaVar.zzm("cache-hit-refresh-needed");
                        zzaqaVar.zze(zzapjVarZza);
                        zzaqgVarZzh.zzd = true;
                        if (this.zzf.zzc(zzaqaVar)) {
                            this.zzg.zzb(zzaqaVar, zzaqgVarZzh, null);
                        } else {
                            this.zzg.zzb(zzaqaVar, zzaqgVarZzh, new zzapl(this, zzaqaVar));
                        }
                    } else {
                        this.zzg.zzb(zzaqaVar, zzaqgVarZzh, null);
                    }
                }
            }
        } finally {
            zzaqaVar.zzt(2);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (zza) {
            zzaqm.zzd("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzd.zzb();
        while (true) {
            try {
                zzc();
            } catch (InterruptedException unused) {
                if (this.zze) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzaqm.zzb("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zzb() {
        this.zze = true;
        interrupt();
    }
}
