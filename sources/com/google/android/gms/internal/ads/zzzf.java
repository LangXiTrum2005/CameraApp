package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzzf extends Handler implements Runnable {
    final /* synthetic */ zzzk zza;
    private final zzzg zzb;
    private final long zzc;
    private zzzc zzd;
    private IOException zze;
    private int zzf;
    private Thread zzg;
    private boolean zzh;
    private volatile boolean zzi;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzzf(zzzk zzzkVar, Looper looper, zzzg zzzgVar, zzzc zzzcVar, int i, long j) {
        super(looper);
        this.zza = zzzkVar;
        this.zzb = zzzgVar;
        this.zzd = zzzcVar;
        this.zzc = j;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.zzi) {
            return;
        }
        if (message.what == 0) {
            zzd();
            return;
        }
        if (message.what == 3) {
            throw ((Error) message.obj);
        }
        this.zza.zzf = null;
        long j = this.zzc;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = jElapsedRealtime - j;
        zzzc zzzcVar = this.zzd;
        zzzcVar.getClass();
        if (this.zzh) {
            zzzcVar.zzJ(this.zzb, jElapsedRealtime, j2, false);
            return;
        }
        int i = message.what;
        if (i == 1) {
            try {
                zzzcVar.zzK(this.zzb, jElapsedRealtime, j2);
                return;
            } catch (RuntimeException e) {
                zzff.zzd("LoadTask", "Unexpected exception handling load completed", e);
                this.zza.zzg = new zzzj(e);
                return;
            }
        }
        if (i != 2) {
            return;
        }
        IOException iOException = (IOException) message.obj;
        this.zze = iOException;
        int i2 = this.zzf + 1;
        this.zzf = i2;
        zzze zzzeVarZzu = zzzcVar.zzu(this.zzb, jElapsedRealtime, j2, iOException, i2);
        if (zzzeVarZzu.zza == 3) {
            this.zza.zzg = this.zze;
        } else if (zzzeVarZzu.zza != 2) {
            if (zzzeVarZzu.zza == 1) {
                this.zzf = 1;
            }
            zzc(zzzeVarZzu.zzb != -9223372036854775807L ? zzzeVarZzu.zzb : Math.min((this.zzf - 1) * 1000, 5000));
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        try {
            synchronized (this) {
                z = !this.zzh;
                this.zzg = Thread.currentThread();
            }
            if (z) {
                String str = "load:" + this.zzb.getClass().getSimpleName();
                int i = zzfy.zza;
                Trace.beginSection(str);
                try {
                    this.zzb.zzh();
                    Trace.endSection();
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            }
            synchronized (this) {
                this.zzg = null;
                Thread.interrupted();
            }
            if (this.zzi) {
                return;
            }
            sendEmptyMessage(1);
        } catch (IOException e) {
            if (this.zzi) {
                return;
            }
            obtainMessage(2, e).sendToTarget();
        } catch (OutOfMemoryError e2) {
            if (this.zzi) {
                return;
            }
            zzff.zzd("LoadTask", "OutOfMemory error loading stream", e2);
            obtainMessage(2, new zzzj(e2)).sendToTarget();
        } catch (Error e3) {
            if (!this.zzi) {
                zzff.zzd("LoadTask", "Unexpected error loading stream", e3);
                obtainMessage(3, e3).sendToTarget();
            }
            throw e3;
        } catch (Exception e4) {
            if (this.zzi) {
                return;
            }
            zzff.zzd("LoadTask", "Unexpected exception loading stream", e4);
            obtainMessage(2, new zzzj(e4)).sendToTarget();
        }
    }

    public final void zza(boolean z) {
        this.zzi = z;
        this.zze = null;
        if (hasMessages(0)) {
            this.zzh = true;
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            synchronized (this) {
                this.zzh = true;
                this.zzb.zzg();
                Thread thread = this.zzg;
                if (thread != null) {
                    thread.interrupt();
                }
            }
        }
        if (z) {
            this.zza.zzf = null;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            zzzc zzzcVar = this.zzd;
            zzzcVar.getClass();
            zzzcVar.zzJ(this.zzb, jElapsedRealtime, jElapsedRealtime - this.zzc, true);
            this.zzd = null;
        }
    }

    public final void zzb(int i) throws IOException {
        IOException iOException = this.zze;
        if (iOException != null && this.zzf > i) {
            throw iOException;
        }
    }

    public final void zzc(long j) {
        zzek.zzf(this.zza.zzf == null);
        this.zza.zzf = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            zzd();
        }
    }

    private final void zzd() {
        this.zze = null;
        zzzk zzzkVar = this.zza;
        ExecutorService executorService = zzzkVar.zze;
        zzzf zzzfVar = zzzkVar.zzf;
        zzzfVar.getClass();
        executorService.execute(zzzfVar);
    }
}
