package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzavb;
import com.google.android.gms.internal.ads.zzave;
import com.google.android.gms.internal.ads.zzavh;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzcdv;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzcei;
import com.google.android.gms.internal.ads.zzcep;
import com.google.android.gms.internal.ads.zzfqr;
import com.google.android.gms.internal.ads.zzfrt;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzi implements Runnable, zzave {
    protected boolean zza;
    private final boolean zzf;
    private final boolean zzg;
    private final Executor zzh;
    private final zzfqr zzi;
    private Context zzj;
    private final Context zzk;
    private zzcei zzl;
    private final zzcei zzm;
    private final boolean zzn;
    private int zzo;
    private final List zzc = new Vector();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    final CountDownLatch zzb = new CountDownLatch(1);

    public zzi(Context context, zzcei zzceiVar) {
        this.zzj = context;
        this.zzk = context;
        this.zzl = zzceiVar;
        this.zzm = zzceiVar;
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
        this.zzh = executorServiceNewCachedThreadPool;
        boolean zBooleanValue = ((Boolean) zzba.zzc().zza(zzbgc.zzcj)).booleanValue();
        this.zzn = zBooleanValue;
        this.zzi = zzfqr.zza(context, executorServiceNewCachedThreadPool, zBooleanValue);
        this.zzf = ((Boolean) zzba.zzc().zza(zzbgc.zzcf)).booleanValue();
        this.zzg = ((Boolean) zzba.zzc().zza(zzbgc.zzck)).booleanValue();
        if (((Boolean) zzba.zzc().zza(zzbgc.zzci)).booleanValue()) {
            this.zzo = 2;
        } else {
            this.zzo = 1;
        }
        if (!((Boolean) zzba.zzc().zza(zzbgc.zzdm)).booleanValue()) {
            this.zza = zzc();
        }
        if (((Boolean) zzba.zzc().zza(zzbgc.zzdf)).booleanValue()) {
            zzcep.zza.execute(this);
            return;
        }
        zzay.zzb();
        if (zzcdv.zzu()) {
            zzcep.zza.execute(this);
        } else {
            run();
        }
    }

    private final zzave zzj() {
        return zzi() == 2 ? (zzave) this.zze.get() : (zzave) this.zzd.get();
    }

    private final void zzm() {
        List list = this.zzc;
        zzave zzaveVarZzj = zzj();
        if (list.isEmpty() || zzaveVarZzj == null) {
            return;
        }
        for (Object[] objArr : this.zzc) {
            int length = objArr.length;
            if (length == 1) {
                zzaveVarZzj.zzk((MotionEvent) objArr[0]);
            } else if (length == 3) {
                zzaveVarZzj.zzl(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
            }
        }
        this.zzc.clear();
    }

    private final void zzp(boolean z) {
        this.zzd.set(zzavh.zzu(this.zzl.zza, zzq(this.zzj), z, this.zzo));
    }

    private static final Context zzq(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (((Boolean) zzba.zzc().zza(zzbgc.zzdm)).booleanValue()) {
                this.zza = zzc();
            }
            boolean z = this.zzl.zzd;
            final boolean z2 = false;
            if (!((Boolean) zzba.zzc().zza(zzbgc.zzaW)).booleanValue() && z) {
                z2 = true;
            }
            if (zzi() == 1) {
                zzp(z2);
                if (this.zzo == 2) {
                    this.zzh.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.zzg
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zzb(z2);
                        }
                    });
                }
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                try {
                    zzavb zzavbVarZza = zzavb.zza(this.zzl.zza, zzq(this.zzj), z2, this.zzn);
                    this.zze.set(zzavbVarZza);
                    if (this.zzg && !zzavbVarZza.zzr()) {
                        this.zzo = 1;
                        zzp(z2);
                    }
                } catch (NullPointerException e) {
                    this.zzo = 1;
                    zzp(z2);
                    this.zzi.zzc(2031, System.currentTimeMillis() - jCurrentTimeMillis, e);
                }
            }
            this.zzb.countDown();
            this.zzj = null;
            this.zzl = null;
        } catch (Throwable th) {
            this.zzb.countDown();
            this.zzj = null;
            this.zzl = null;
            throw th;
        }
    }

    final /* synthetic */ void zzb(boolean z) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            zzavb.zza(this.zzm.zza, zzq(this.zzk), z, this.zzn).zzp();
        } catch (NullPointerException e) {
            this.zzi.zzc(2027, System.currentTimeMillis() - jCurrentTimeMillis, e);
        }
    }

    protected final boolean zzc() {
        Context context = this.zzj;
        zzh zzhVar = new zzh(this);
        zzfqr zzfqrVar = this.zzi;
        return new zzfsn(this.zzj, zzfrt.zzb(context, zzfqrVar), zzhVar, ((Boolean) zzba.zzc().zza(zzbgc.zzcg)).booleanValue()).zzd(1);
    }

    public final boolean zzd() {
        try {
            this.zzb.await();
            return true;
        } catch (InterruptedException e) {
            zzcec.zzk("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final String zze(Context context, String str, View view) {
        return zzf(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final String zzf(Context context, String str, View view, Activity activity) {
        if (!zzd()) {
            return "";
        }
        zzave zzaveVarZzj = zzj();
        if (((Boolean) zzba.zzc().zza(zzbgc.zzkh)).booleanValue()) {
            zzt.zzp();
            com.google.android.gms.ads.internal.util.zzt.zzI(view, 4, null);
        }
        if (zzaveVarZzj == null) {
            return "";
        }
        zzm();
        return zzaveVarZzj.zzf(zzq(context), str, view, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final String zzg(Context context) {
        zzave zzaveVarZzj;
        if (!zzd() || (zzaveVarZzj = zzj()) == null) {
            return "";
        }
        zzm();
        return zzaveVarZzj.zzg(zzq(context));
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final String zzh(Context context, View view, Activity activity) {
        if (!((Boolean) zzba.zzc().zza(zzbgc.zzkg)).booleanValue()) {
            zzave zzaveVarZzj = zzj();
            if (((Boolean) zzba.zzc().zza(zzbgc.zzkh)).booleanValue()) {
                zzt.zzp();
                com.google.android.gms.ads.internal.util.zzt.zzI(view, 2, null);
            }
            return zzaveVarZzj != null ? zzaveVarZzj.zzh(context, view, activity) : "";
        }
        if (!zzd()) {
            return "";
        }
        zzave zzaveVarZzj2 = zzj();
        if (((Boolean) zzba.zzc().zza(zzbgc.zzkh)).booleanValue()) {
            zzt.zzp();
            com.google.android.gms.ads.internal.util.zzt.zzI(view, 2, null);
        }
        return zzaveVarZzj2 != null ? zzaveVarZzj2.zzh(context, view, activity) : "";
    }

    protected final int zzi() {
        if (!this.zzf || this.zza) {
            return this.zzo;
        }
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final void zzk(MotionEvent motionEvent) {
        zzave zzaveVarZzj = zzj();
        if (zzaveVarZzj == null) {
            this.zzc.add(new Object[]{motionEvent});
        } else {
            zzm();
            zzaveVarZzj.zzk(motionEvent);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final void zzl(int i, int i2, int i3) {
        zzave zzaveVarZzj = zzj();
        if (zzaveVarZzj == null) {
            this.zzc.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        } else {
            zzm();
            zzaveVarZzj.zzl(i, i2, i3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzave zzaveVarZzj;
        if (!zzd() || (zzaveVarZzj = zzj()) == null) {
            return;
        }
        zzaveVarZzj.zzn(stackTraceElementArr);
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final void zzo(View view) {
        zzave zzaveVarZzj = zzj();
        if (zzaveVarZzj != null) {
            zzaveVarZzj.zzo(view);
        }
    }
}
