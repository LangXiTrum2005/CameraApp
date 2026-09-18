package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzgds extends zzgdb.zzi {
    private static final zzgdo zzba;
    private static final zzgex zzbb = new zzgex(zzgds.class);
    private volatile int remaining;

    @CheckForNull
    private volatile Set<Throwable> seenExceptions = null;

    static {
        zzgdo zzgdrVar;
        Throwable th;
        zzgdq zzgdqVar = null;
        try {
            zzgdrVar = new zzgdp(AtomicReferenceFieldUpdater.newUpdater(zzgds.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(zzgds.class, "remaining"));
            th = null;
        } catch (Throwable th2) {
            zzgdrVar = new zzgdr(zzgdqVar);
            th = th2;
        }
        zzba = zzgdrVar;
        if (th != null) {
            zzbb.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    zzgds(int i) {
        this.remaining = i;
    }

    final int zzA() {
        return zzba.zza(this);
    }

    final Set zzC() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        zze(setNewSetFromMap);
        zzba.zzb(this, null, setNewSetFromMap);
        return (Set) Objects.requireNonNull(this.seenExceptions);
    }

    final void zzF() {
        this.seenExceptions = null;
    }

    abstract void zze(Set set);
}
