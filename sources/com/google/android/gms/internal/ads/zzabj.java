package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.SystemClock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzabj {
    private final Handler zza;
    private final zzabk zzb;

    public zzabj(Handler handler, zzabk zzabkVar) {
        this.zza = zzabkVar == null ? null : handler;
        this.zzb = zzabkVar;
    }

    public final void zza(final String str, final long j, final long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaaz
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzg(str, j, j2);
                }
            });
        }
    }

    public final void zzb(final String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabi
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzh(str);
                }
            });
        }
    }

    public final void zzc(final zzir zzirVar) {
        zzirVar.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabh
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzi(zzirVar);
                }
            });
        }
    }

    public final void zzd(final int i, final long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabb
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzj(i, j);
                }
            });
        }
    }

    public final void zze(final zzir zzirVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabf
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzk(zzirVar);
                }
            });
        }
    }

    public final void zzf(final zzam zzamVar, final zzis zzisVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabg
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzl(zzamVar, zzisVar);
                }
            });
        }
    }

    final /* synthetic */ void zzg(String str, long j, long j2) {
        int i = zzfy.zza;
        this.zzb.zzp(str, j, j2);
    }

    final /* synthetic */ void zzh(String str) {
        int i = zzfy.zza;
        this.zzb.zzq(str);
    }

    final /* synthetic */ void zzi(zzir zzirVar) {
        zzirVar.zza();
        int i = zzfy.zza;
        this.zzb.zzr(zzirVar);
    }

    final /* synthetic */ void zzj(int i, long j) {
        int i2 = zzfy.zza;
        this.zzb.zzl(i, j);
    }

    final /* synthetic */ void zzk(zzir zzirVar) {
        int i = zzfy.zza;
        this.zzb.zzs(zzirVar);
    }

    final /* synthetic */ void zzl(zzam zzamVar, zzis zzisVar) {
        int i = zzfy.zza;
        this.zzb.zzu(zzamVar, zzisVar);
    }

    final /* synthetic */ void zzm(Object obj, long j) {
        int i = zzfy.zza;
        this.zzb.zzm(obj, j);
    }

    final /* synthetic */ void zzn(long j, int i) {
        int i2 = zzfy.zza;
        this.zzb.zzt(j, i);
    }

    final /* synthetic */ void zzo(Exception exc) {
        int i = zzfy.zza;
        this.zzb.zzo(exc);
    }

    final /* synthetic */ void zzp(zzdp zzdpVar) {
        int i = zzfy.zza;
        this.zzb.zzv(zzdpVar);
    }

    public final void zzq(final Object obj) {
        Handler handler = this.zza;
        if (handler != null) {
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabc
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzm(obj, jElapsedRealtime);
                }
            });
        }
    }

    public final void zzr(final long j, final int i) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabd
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzn(j, i);
                }
            });
        }
    }

    public final void zzs(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabe
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzo(exc);
                }
            });
        }
    }

    public final void zzt(final zzdp zzdpVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaba
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzp(zzdpVar);
                }
            });
        }
    }
}
