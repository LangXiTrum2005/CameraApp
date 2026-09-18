package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import javax.annotation.CheckForNull;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgdb<V> extends zzgfq implements ListenableFuture<V> {
    private static final Object zzaZ;
    private static final zza zzbc;
    static final boolean zzd;
    static final zzgex zze;

    @CheckForNull
    private volatile zzd listeners;

    @CheckForNull
    private volatile Object value;

    @CheckForNull
    private volatile zzk waiters;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
    abstract class zza {
        /* synthetic */ zza(zzgda zzgdaVar) {
        }

        abstract zzd zza(zzgdb zzgdbVar, zzd zzdVar);

        abstract zzk zzb(zzgdb zzgdbVar, zzk zzkVar);

        abstract void zzc(zzk zzkVar, @CheckForNull zzk zzkVar2);

        abstract void zzd(zzk zzkVar, Thread thread);

        abstract boolean zze(zzgdb zzgdbVar, @CheckForNull zzd zzdVar, zzd zzdVar2);

        abstract boolean zzf(zzgdb zzgdbVar, @CheckForNull Object obj, Object obj2);

        abstract boolean zzg(zzgdb zzgdbVar, @CheckForNull zzk zzkVar, @CheckForNull zzk zzkVar2);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
    final class zzb {

        @CheckForNull
        static final zzb zza;

        @CheckForNull
        static final zzb zzb;
        final boolean zzc;

        @CheckForNull
        final Throwable zzd;

        static {
            if (zzgdb.zzd) {
                zzb = null;
                zza = null;
            } else {
                zzb = new zzb(false, null);
                zza = new zzb(true, null);
            }
        }

        zzb(boolean z, @CheckForNull Throwable th) {
            this.zzc = z;
            this.zzd = th;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
    final class zzc {
        static final zzc zza = new zzc(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.android.gms.internal.ads.zzgdb.zzc.1
            {
                super("Failure occurred while trying to finish a future.");
            }

            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable zzb;

        zzc(Throwable th) {
            th.getClass();
            this.zzb = th;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
    final class zzd {
        static final zzd zza = new zzd();

        @CheckForNull
        zzd next;

        @CheckForNull
        final Runnable zzb;

        @CheckForNull
        final Executor zzc;

        zzd() {
            this.zzb = null;
            this.zzc = null;
        }

        zzd(Runnable runnable, Executor executor) {
            this.zzb = runnable;
            this.zzc = executor;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
    final class zze extends zza {
        final AtomicReferenceFieldUpdater<zzk, Thread> zza;
        final AtomicReferenceFieldUpdater<zzk, zzk> zzb;
        final AtomicReferenceFieldUpdater<zzgdb, zzk> zzc;
        final AtomicReferenceFieldUpdater<zzgdb, zzd> zzd;
        final AtomicReferenceFieldUpdater<zzgdb, Object> zze;

        zze(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super(null);
            this.zza = atomicReferenceFieldUpdater;
            this.zzb = atomicReferenceFieldUpdater2;
            this.zzc = atomicReferenceFieldUpdater3;
            this.zzd = atomicReferenceFieldUpdater4;
            this.zze = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        final zzd zza(zzgdb zzgdbVar, zzd zzdVar) {
            return this.zzd.getAndSet(zzgdbVar, zzdVar);
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        final zzk zzb(zzgdb zzgdbVar, zzk zzkVar) {
            return this.zzc.getAndSet(zzgdbVar, zzkVar);
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        final void zzc(zzk zzkVar, @CheckForNull zzk zzkVar2) {
            this.zzb.lazySet(zzkVar, zzkVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        final void zzd(zzk zzkVar, Thread thread) {
            this.zza.lazySet(zzkVar, thread);
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        final boolean zze(zzgdb zzgdbVar, @CheckForNull zzd zzdVar, zzd zzdVar2) {
            return zzgdc.zza(this.zzd, zzgdbVar, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        final boolean zzf(zzgdb zzgdbVar, @CheckForNull Object obj, Object obj2) {
            return zzgdc.zza(this.zze, zzgdbVar, obj, obj2);
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        final boolean zzg(zzgdb zzgdbVar, @CheckForNull zzk zzkVar, @CheckForNull zzk zzkVar2) {
            return zzgdc.zza(this.zzc, zzgdbVar, zzkVar, zzkVar2);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
    final class zzf<V> implements Runnable {
        final zzgdb<V> zza;
        final ListenableFuture<? extends V> zzb;

        zzf(zzgdb zzgdbVar, ListenableFuture listenableFuture) {
            this.zza = zzgdbVar;
            this.zzb = listenableFuture;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (((zzgdb) this.zza).value != this) {
                return;
            }
            ListenableFuture<? extends V> listenableFuture = this.zzb;
            if (zzgdb.zzbc.zzf(this.zza, this, zzgdb.zze(listenableFuture))) {
                zzgdb.zzx(this.zza, false);
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
    final class zzg extends zza {
        private zzg() {
            super(null);
        }

        /* synthetic */ zzg(zzgdd zzgddVar) {
            super(null);
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        final zzd zza(zzgdb zzgdbVar, zzd zzdVar) {
            zzd zzdVar2;
            synchronized (zzgdbVar) {
                zzdVar2 = zzgdbVar.listeners;
                if (zzdVar2 != zzdVar) {
                    zzgdbVar.listeners = zzdVar;
                }
            }
            return zzdVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        final zzk zzb(zzgdb zzgdbVar, zzk zzkVar) {
            zzk zzkVar2;
            synchronized (zzgdbVar) {
                zzkVar2 = zzgdbVar.waiters;
                if (zzkVar2 != zzkVar) {
                    zzgdbVar.waiters = zzkVar;
                }
            }
            return zzkVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        final void zzc(zzk zzkVar, @CheckForNull zzk zzkVar2) {
            zzkVar.next = zzkVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        final void zzd(zzk zzkVar, Thread thread) {
            zzkVar.thread = thread;
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        final boolean zze(zzgdb zzgdbVar, @CheckForNull zzd zzdVar, zzd zzdVar2) {
            synchronized (zzgdbVar) {
                if (zzgdbVar.listeners != zzdVar) {
                    return false;
                }
                zzgdbVar.listeners = zzdVar2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        final boolean zzf(zzgdb zzgdbVar, @CheckForNull Object obj, Object obj2) {
            synchronized (zzgdbVar) {
                if (zzgdbVar.value != obj) {
                    return false;
                }
                zzgdbVar.value = obj2;
                return true;
            }
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        final boolean zzg(zzgdb zzgdbVar, @CheckForNull zzk zzkVar, @CheckForNull zzk zzkVar2) {
            synchronized (zzgdbVar) {
                if (zzgdbVar.waiters != zzkVar) {
                    return false;
                }
                zzgdbVar.waiters = zzkVar2;
                return true;
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
    interface zzh<V> extends ListenableFuture<V> {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
    abstract class zzi<V> extends zzgdb<V> implements zzh<V> {
        zzi() {
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
    final class zzj extends zza {
        static final Unsafe zza;
        static final long zzb;
        static final long zzc;
        static final long zzd;
        static final long zze;
        static final long zzf;

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (SecurityException unused) {
                    unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.android.gms.internal.ads.zzgdb.zzj.1
                        @Override // java.security.PrivilegedExceptionAction
                        public final /* bridge */ /* synthetic */ Unsafe run() throws Exception {
                            for (Field field : Unsafe.class.getDeclaredFields()) {
                                field.setAccessible(true);
                                Object obj = field.get(null);
                                if (Unsafe.class.isInstance(obj)) {
                                    return (Unsafe) Unsafe.class.cast(obj);
                                }
                            }
                            throw new NoSuchFieldError("the Unsafe");
                        }
                    });
                }
                try {
                    zzc = unsafe.objectFieldOffset(zzgdb.class.getDeclaredField("waiters"));
                    zzb = unsafe.objectFieldOffset(zzgdb.class.getDeclaredField("listeners"));
                    zzd = unsafe.objectFieldOffset(zzgdb.class.getDeclaredField("value"));
                    zze = unsafe.objectFieldOffset(zzk.class.getDeclaredField("thread"));
                    zzf = unsafe.objectFieldOffset(zzk.class.getDeclaredField("next"));
                    zza = unsafe;
                } catch (NoSuchFieldException e) {
                    throw new RuntimeException(e);
                }
            } catch (PrivilegedActionException e2) {
                throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
            }
        }

        private zzj() {
            super(null);
        }

        /* synthetic */ zzj(zzgdf zzgdfVar) {
            super(null);
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        final zzd zza(zzgdb zzgdbVar, zzd zzdVar) {
            zzd zzdVar2;
            do {
                zzdVar2 = zzgdbVar.listeners;
                if (zzdVar == zzdVar2) {
                    break;
                }
            } while (!zze(zzgdbVar, zzdVar2, zzdVar));
            return zzdVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        final zzk zzb(zzgdb zzgdbVar, zzk zzkVar) {
            zzk zzkVar2;
            do {
                zzkVar2 = zzgdbVar.waiters;
                if (zzkVar == zzkVar2) {
                    break;
                }
            } while (!zzg(zzgdbVar, zzkVar2, zzkVar));
            return zzkVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        final void zzc(zzk zzkVar, @CheckForNull zzk zzkVar2) {
            zza.putObject(zzkVar, zzf, zzkVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        final void zzd(zzk zzkVar, Thread thread) {
            zza.putObject(zzkVar, zze, thread);
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        final boolean zze(zzgdb zzgdbVar, @CheckForNull zzd zzdVar, zzd zzdVar2) {
            return zzgde.zza(zza, zzgdbVar, zzb, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        final boolean zzf(zzgdb zzgdbVar, @CheckForNull Object obj, Object obj2) {
            return zzgde.zza(zza, zzgdbVar, zzd, obj, obj2);
        }

        @Override // com.google.android.gms.internal.ads.zzgdb.zza
        final boolean zzg(zzgdb zzgdbVar, @CheckForNull zzk zzkVar, @CheckForNull zzk zzkVar2) {
            return zzgde.zza(zza, zzgdbVar, zzc, zzkVar, zzkVar2);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
    final class zzk {
        static final zzk zza = new zzk(false);

        @CheckForNull
        volatile zzk next;

        @CheckForNull
        volatile Thread thread;

        zzk() {
            zzgdb.zzbc.zzd(this, Thread.currentThread());
        }

        zzk(boolean z) {
        }
    }

    static {
        boolean z;
        Throwable th;
        Throwable th2;
        zza zzgVar;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        zzd = z;
        zze = new zzgex(zzgdb.class);
        byte b = 0;
        try {
            zzgVar = new zzj(null);
            th2 = null;
            th = null;
        } catch (Error | Exception e) {
            try {
                th2 = e;
                zzgVar = new zze(AtomicReferenceFieldUpdater.newUpdater(zzk.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(zzk.class, zzk.class, "next"), AtomicReferenceFieldUpdater.newUpdater(zzgdb.class, zzk.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(zzgdb.class, zzd.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(zzgdb.class, Object.class, "value"));
                th = null;
            } catch (Error | Exception e2) {
                th = e2;
                th2 = e;
                zzgVar = new zzg(b == true ? 1 : 0);
            }
        }
        zzbc = zzgVar;
        if (th != null) {
            zzgex zzgexVar = zze;
            zzgexVar.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            zzgexVar.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
        zzaZ = new Object();
    }

    protected zzgdb() {
    }

    private static final Object zzA(Object obj) throws ExecutionException {
        if (obj instanceof zzb) {
            Throwable th = ((zzb) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).zzb);
        }
        if (obj == zzaZ) {
            return null;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static Object zze(ListenableFuture listenableFuture) {
        Throwable thZzl;
        if (listenableFuture instanceof zzh) {
            Object zzbVar = ((zzgdb) listenableFuture).value;
            if (zzbVar instanceof zzb) {
                zzb zzbVar2 = (zzb) zzbVar;
                if (zzbVar2.zzc) {
                    Throwable th = zzbVar2.zzd;
                    zzbVar = th != null ? new zzb(false, th) : zzb.zzb;
                }
            }
            return Objects.requireNonNull(zzbVar);
        }
        if ((listenableFuture instanceof zzgfq) && (thZzl = ((zzgfq) listenableFuture).zzl()) != null) {
            return new zzc(thZzl);
        }
        boolean zIsCancelled = listenableFuture.isCancelled();
        if ((!zzd) && zIsCancelled) {
            return Objects.requireNonNull(zzb.zzb);
        }
        try {
            Object objZzf = zzf(listenableFuture);
            if (!zIsCancelled) {
                return objZzf == null ? zzaZ : objZzf;
            }
            return new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + String.valueOf(listenableFuture)));
        } catch (Error e) {
            e = e;
            return new zzc(e);
        } catch (CancellationException e2) {
            return !zIsCancelled ? new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(String.valueOf(listenableFuture))), e2)) : new zzb(false, e2);
        } catch (ExecutionException e3) {
            return zIsCancelled ? new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(String.valueOf(listenableFuture))), e3)) : new zzc(e3.getCause());
        } catch (Exception e4) {
            e = e4;
            return new zzc(e);
        }
    }

    private static Object zzf(Future future) throws ExecutionException {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    private final void zzu(StringBuilder sb) {
        try {
            Object objZzf = zzf(this);
            sb.append("SUCCESS, result=[");
            if (objZzf == null) {
                sb.append("null");
            } else if (objZzf == this) {
                sb.append("this future");
            } else {
                sb.append(objZzf.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(objZzf)));
            }
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (ExecutionException e) {
            sb.append("FAILURE, cause=[");
            sb.append(e.getCause());
            sb.append("]");
        } catch (Exception e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        }
    }

    private final void zzv(StringBuilder sb) {
        String strConcat;
        int length = sb.length();
        sb.append("PENDING");
        Object obj = this.value;
        if (obj instanceof zzf) {
            sb.append(", setFuture=[");
            zzw(sb, ((zzf) obj).zzb);
            sb.append("]");
        } else {
            try {
                strConcat = zzfxt.zza(zza());
            } catch (Exception | StackOverflowError e) {
                strConcat = "Exception thrown from implementation: ".concat(String.valueOf(String.valueOf(e.getClass())));
            }
            if (strConcat != null) {
                sb.append(", info=[");
                sb.append(strConcat);
                sb.append("]");
            }
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            zzu(sb);
        }
    }

    private final void zzw(StringBuilder sb, @CheckForNull Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (Exception | StackOverflowError e) {
            sb.append("Exception thrown from implementation: ");
            sb.append(e.getClass());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzx(zzgdb zzgdbVar, boolean z) {
        zzd zzdVar = null;
        while (true) {
            for (zzk zzkVarZzb = zzbc.zzb(zzgdbVar, zzk.zza); zzkVarZzb != null; zzkVarZzb = zzkVarZzb.next) {
                Thread thread = zzkVarZzb.thread;
                if (thread != null) {
                    zzkVarZzb.thread = null;
                    LockSupport.unpark(thread);
                }
            }
            if (z) {
                zzgdbVar.zzq();
            }
            zzgdbVar.zzb();
            zzd zzdVar2 = zzdVar;
            zzd zzdVarZza = zzbc.zza(zzgdbVar, zzd.zza);
            zzd zzdVar3 = zzdVar2;
            while (zzdVarZza != null) {
                zzd zzdVar4 = zzdVarZza.next;
                zzdVarZza.next = zzdVar3;
                zzdVar3 = zzdVarZza;
                zzdVarZza = zzdVar4;
            }
            while (zzdVar3 != null) {
                zzdVar = zzdVar3.next;
                Runnable runnable = (Runnable) Objects.requireNonNull(zzdVar3.zzb);
                if (runnable instanceof zzf) {
                    zzf zzfVar = (zzf) runnable;
                    zzgdbVar = zzfVar.zza;
                    if (zzgdbVar.value == zzfVar) {
                        if (zzbc.zzf(zzgdbVar, zzfVar, zze(zzfVar.zzb))) {
                            z = false;
                        }
                    } else {
                        continue;
                    }
                } else {
                    zzy(runnable, (Executor) Objects.requireNonNull(zzdVar3.zzc));
                }
                zzdVar3 = zzdVar;
            }
            return;
        }
    }

    private static void zzy(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e) {
            zze.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + String.valueOf(runnable) + " with executor " + String.valueOf(executor), (Throwable) e);
        }
    }

    private final void zzz(zzk zzkVar) {
        zzkVar.thread = null;
        while (true) {
            zzk zzkVar2 = this.waiters;
            if (zzkVar2 != zzk.zza) {
                zzk zzkVar3 = null;
                while (zzkVar2 != null) {
                    zzk zzkVar4 = zzkVar2.next;
                    if (zzkVar2.thread != null) {
                        zzkVar3 = zzkVar2;
                    } else if (zzkVar3 != null) {
                        zzkVar3.next = zzkVar4;
                        if (zzkVar3.thread == null) {
                        }
                    } else if (!zzbc.zzg(this, zzkVar2, zzkVar4)) {
                    }
                    zzkVar2 = zzkVar4;
                }
                return;
            }
            return;
        }
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        zzd zzdVar;
        zzfxe.zzc(runnable, "Runnable was null.");
        zzfxe.zzc(executor, "Executor was null.");
        if (!isDone() && (zzdVar = this.listeners) != zzd.zza) {
            zzd zzdVar2 = new zzd(runnable, executor);
            do {
                zzdVar2.next = zzdVar;
                if (zzbc.zze(this, zzdVar, zzdVar2)) {
                    return;
                } else {
                    zzdVar = this.listeners;
                }
            } while (zzdVar != zzd.zza);
        }
        zzy(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        Object objRequireNonNull;
        Object obj = this.value;
        if (!(obj instanceof zzf) && !(obj == null)) {
            return false;
        }
        if (zzd) {
            objRequireNonNull = new zzb(z, new CancellationException("Future.cancel() was called."));
        } else {
            objRequireNonNull = Objects.requireNonNull(z ? zzb.zza : zzb.zzb);
        }
        zzgdb<V> zzgdbVar = this;
        boolean z2 = false;
        while (true) {
            if (zzbc.zzf(zzgdbVar, obj, objRequireNonNull)) {
                zzx(zzgdbVar, z);
                if (obj instanceof zzf) {
                    ListenableFuture<? extends V> listenableFuture = ((zzf) obj).zzb;
                    if (listenableFuture instanceof zzh) {
                        zzgdbVar = (zzgdb) listenableFuture;
                        obj = zzgdbVar.value;
                        if ((obj == null) | (obj instanceof zzf)) {
                            z2 = true;
                        }
                    } else {
                        listenableFuture.cancel(z);
                    }
                }
                return true;
            }
            obj = zzgdbVar.value;
            if (!(obj instanceof zzf)) {
                return z2;
            }
        }
    }

    @Override // java.util.concurrent.Future
    public Object get() throws ExecutionException, InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.value;
        if ((obj2 != null) && (!(obj2 instanceof zzf))) {
            return zzA(obj2);
        }
        zzk zzkVar = this.waiters;
        if (zzkVar != zzk.zza) {
            zzk zzkVar2 = new zzk();
            do {
                zza zzaVar = zzbc;
                zzaVar.zzc(zzkVar2, zzkVar);
                if (zzaVar.zzg(this, zzkVar, zzkVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            zzz(zzkVar2);
                            throw new InterruptedException();
                        }
                        obj = this.value;
                    } while (!((obj != null) & (!(obj instanceof zzf))));
                    return zzA(obj);
                }
                zzkVar = this.waiters;
            } while (zzkVar != zzk.zza);
        }
        return zzA(Objects.requireNonNull(this.value));
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.value instanceof zzb;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object obj = this.value;
        return (obj != null) & (!(obj instanceof zzf));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zzu(sb);
        } else {
            zzv(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    protected String zza() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    protected void zzb() {
    }

    protected boolean zzc(Object obj) {
        if (obj == null) {
            obj = zzaZ;
        }
        if (!zzbc.zzf(this, null, obj)) {
            return false;
        }
        zzx(this, false);
        return true;
    }

    protected boolean zzd(Throwable th) {
        th.getClass();
        if (!zzbc.zzf(this, null, new zzc(th))) {
            return false;
        }
        zzx(this, false);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgfq
    @CheckForNull
    protected final Throwable zzl() {
        if (!(this instanceof zzh)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof zzc) {
            return ((zzc) obj).zzb;
        }
        return null;
    }

    protected void zzq() {
    }

    final void zzr(@CheckForNull Future future) {
        if ((future != null) && isCancelled()) {
            future.cancel(zzt());
        }
    }

    protected final boolean zzt() {
        Object obj = this.value;
        return (obj instanceof zzb) && ((zzb) obj).zzc;
    }

    protected final boolean zzs(ListenableFuture listenableFuture) {
        zzc zzcVar;
        listenableFuture.getClass();
        Object obj = this.value;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!zzbc.zzf(this, null, zze(listenableFuture))) {
                    return false;
                }
                zzx(this, false);
                return true;
            }
            zzf zzfVar = new zzf(this, listenableFuture);
            if (zzbc.zzf(this, null, zzfVar)) {
                try {
                    listenableFuture.addListener(zzfVar, zzgeb.INSTANCE);
                } catch (Throwable th) {
                    try {
                        zzcVar = new zzc(th);
                    } catch (Error | Exception unused) {
                        zzcVar = zzc.zza;
                    }
                    zzbc.zzf(this, zzfVar, zzcVar);
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof zzb) {
            listenableFuture.cancel(((zzb) obj).zzc);
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            boolean z = true;
            if ((obj != null) & (!(obj instanceof zzf))) {
                return zzA(obj);
            }
            long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                zzk zzkVar = this.waiters;
                if (zzkVar != zzk.zza) {
                    zzk zzkVar2 = new zzk();
                    while (true) {
                        zza zzaVar = zzbc;
                        zzaVar.zzc(zzkVar2, zzkVar);
                        if (zzaVar.zzg(this, zzkVar, zzkVar2)) {
                            do {
                                LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                                if (Thread.interrupted()) {
                                    zzz(zzkVar2);
                                    throw new InterruptedException();
                                }
                                Object obj2 = this.value;
                                if (!((obj2 != null) & (!(obj2 instanceof zzf)))) {
                                    nanos = jNanoTime - System.nanoTime();
                                } else {
                                    return zzA(obj2);
                                }
                            } while (nanos >= 1000);
                            zzz(zzkVar2);
                            break;
                        }
                        zzkVar = this.waiters;
                        if (zzkVar == zzk.zza) {
                        }
                    }
                }
                return zzA(Objects.requireNonNull(this.value));
            }
            while (nanos > 0) {
                Object obj3 = this.value;
                if (!((obj3 != null) & (!(obj3 instanceof zzf)))) {
                    if (!Thread.interrupted()) {
                        nanos = jNanoTime - System.nanoTime();
                    } else {
                        throw new InterruptedException();
                    }
                } else {
                    return zzA(obj3);
                }
            }
            String string = toString();
            String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
            String strConcat = "Waited " + j + " " + timeUnit.toString().toLowerCase(Locale.ROOT);
            if (nanos + 1000 < 0) {
                String strConcat2 = strConcat.concat(" (plus ");
                long j2 = -nanos;
                long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
                long nanos2 = j2 - timeUnit.toNanos(jConvert);
                if (jConvert != 0 && nanos2 <= 1000) {
                    z = false;
                }
                if (jConvert > 0) {
                    String strConcat3 = strConcat2 + jConvert + " " + lowerCase;
                    if (z) {
                        strConcat3 = strConcat3.concat(",");
                    }
                    strConcat2 = strConcat3.concat(" ");
                }
                if (z) {
                    strConcat2 = strConcat2 + nanos2 + " nanoseconds ";
                }
                strConcat = strConcat2.concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(strConcat.concat(" but future completed as timeout expired"));
            }
            throw new TimeoutException(strConcat + " for " + string);
        }
        throw new InterruptedException();
    }
}
