package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzgdm extends zzgds {
    private static final zzgex zza = new zzgex(zzgdm.class);

    @CheckForNull
    private zzfzv zzb;
    private final boolean zzc;
    private final boolean zzf;

    zzgdm(zzfzv zzfzvVar, boolean z, boolean z2) {
        super(zzfzvVar.size());
        zzfzvVar.getClass();
        this.zzb = zzfzvVar;
        this.zzc = z;
        this.zzf = z2;
    }

    private final void zzG(int i, Future future) {
        try {
            zzf(i, zzgen.zzp(future));
        } catch (ExecutionException e) {
            zzI(e.getCause());
        } catch (Throwable th) {
            zzI(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzH, reason: merged with bridge method [inline-methods] */
    public final void zzx(@CheckForNull zzfzv zzfzvVar) {
        int iZzA = zzA();
        int i = 0;
        zzfxe.zzj(iZzA >= 0, "Less than 0 remaining futures");
        if (iZzA == 0) {
            if (zzfzvVar != null) {
                zzgce it = zzfzvVar.iterator();
                while (it.hasNext()) {
                    Future future = (Future) it.next();
                    if (!future.isCancelled()) {
                        zzG(i, future);
                    }
                    i++;
                }
            }
            zzF();
            zzu();
            zzy(2);
        }
    }

    private static void zzJ(Throwable th) {
        zza.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", true != (th instanceof Error) ? "Got more than one input Future failure. Logging failures after the first" : "Input Future failed with Error", th);
    }

    private static boolean zzK(Set set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgdb
    @CheckForNull
    protected final String zza() {
        zzfzv zzfzvVar = this.zzb;
        return zzfzvVar != null ? "futures=".concat(zzfzvVar.toString()) : super.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgdb
    protected final void zzb() {
        zzfzv zzfzvVar = this.zzb;
        zzy(1);
        if ((zzfzvVar != null) && isCancelled()) {
            boolean zZzt = zzt();
            zzgce it = zzfzvVar.iterator();
            while (it.hasNext()) {
                ((Future) it.next()).cancel(zZzt);
            }
        }
    }

    abstract void zzf(int i, Object obj);

    abstract void zzu();

    final void zzv() {
        Objects.requireNonNull(this.zzb);
        if (this.zzb.isEmpty()) {
            zzu();
            return;
        }
        if (!this.zzc) {
            final zzfzv zzfzvVar = this.zzf ? this.zzb : null;
            Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzgdl
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzx(zzfzvVar);
                }
            };
            zzgce it = this.zzb.iterator();
            while (it.hasNext()) {
                ((ListenableFuture) it.next()).addListener(runnable, zzgeb.INSTANCE);
            }
            return;
        }
        zzgce it2 = this.zzb.iterator();
        final int i = 0;
        while (it2.hasNext()) {
            final ListenableFuture listenableFuture = (ListenableFuture) it2.next();
            listenableFuture.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgdk
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzw(listenableFuture, i);
                }
            }, zzgeb.INSTANCE);
            i++;
        }
    }

    final /* synthetic */ void zzw(ListenableFuture listenableFuture, int i) {
        try {
            if (listenableFuture.isCancelled()) {
                this.zzb = null;
                cancel(false);
            } else {
                zzG(i, listenableFuture);
            }
        } finally {
            zzx(null);
        }
    }

    void zzy(int i) {
        this.zzb = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgds
    final void zze(Set set) {
        set.getClass();
        if (isCancelled()) {
            return;
        }
        zzK(set, (Throwable) Objects.requireNonNull(zzl()));
    }

    private final void zzI(Throwable th) {
        th.getClass();
        if (this.zzc && !zzd(th) && zzK(zzC(), th)) {
            zzJ(th);
        } else if (th instanceof Error) {
            zzJ(th);
        }
    }
}
