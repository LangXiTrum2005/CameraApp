package com.google.android.gms.internal.ads;

import android.os.Handler;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzpt {
    private final Handler zza;
    private final zzpu zzb;

    public zzpt(Handler handler, zzpu zzpuVar) {
        this.zza = zzpuVar == null ? null : handler;
        this.zzb = zzpuVar;
    }

    public final void zza(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpn
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzj(exc);
                }
            });
        }
    }

    public final void zzb(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpo
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzk(exc);
                }
            });
        }
    }

    public final void zzc(final zzpv zzpvVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpl
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzl(zzpvVar);
                }
            });
        }
    }

    public final void zzd(final zzpv zzpvVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpm
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzm(zzpvVar);
                }
            });
        }
    }

    public final void zze(final String str, final long j, final long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpr
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzn(str, j, j2);
                }
            });
        }
    }

    public final void zzf(final String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzps
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzo(str);
                }
            });
        }
    }

    public final void zzg(final zzir zzirVar) {
        zzirVar.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpi
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzp(zzirVar);
                }
            });
        }
    }

    public final void zzh(final zzir zzirVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzph
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzq(zzirVar);
                }
            });
        }
    }

    public final void zzi(final zzam zzamVar, final zzis zzisVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpp
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzr(zzamVar, zzisVar);
                }
            });
        }
    }

    final /* synthetic */ void zzj(Exception exc) {
        int i = zzfy.zza;
        this.zzb.zza(exc);
    }

    final /* synthetic */ void zzk(Exception exc) {
        int i = zzfy.zza;
        this.zzb.zzh(exc);
    }

    final /* synthetic */ void zzl(zzpv zzpvVar) {
        int i = zzfy.zza;
        this.zzb.zzi(zzpvVar);
    }

    final /* synthetic */ void zzm(zzpv zzpvVar) {
        int i = zzfy.zza;
        this.zzb.zzj(zzpvVar);
    }

    final /* synthetic */ void zzn(String str, long j, long j2) {
        int i = zzfy.zza;
        this.zzb.zzb(str, j, j2);
    }

    final /* synthetic */ void zzo(String str) {
        int i = zzfy.zza;
        this.zzb.zzc(str);
    }

    final /* synthetic */ void zzp(zzir zzirVar) {
        zzirVar.zza();
        int i = zzfy.zza;
        this.zzb.zzd(zzirVar);
    }

    final /* synthetic */ void zzq(zzir zzirVar) {
        int i = zzfy.zza;
        this.zzb.zze(zzirVar);
    }

    final /* synthetic */ void zzr(zzam zzamVar, zzis zzisVar) {
        int i = zzfy.zza;
        this.zzb.zzf(zzamVar, zzisVar);
    }

    final /* synthetic */ void zzs(long j) {
        int i = zzfy.zza;
        this.zzb.zzg(j);
    }

    final /* synthetic */ void zzt(boolean z) {
        int i = zzfy.zza;
        this.zzb.zzn(z);
    }

    final /* synthetic */ void zzu(int i, long j, long j2) {
        int i2 = zzfy.zza;
        this.zzb.zzk(i, j, j2);
    }

    public final void zzv(final long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpj
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzs(j);
                }
            });
        }
    }

    public final void zzw(final boolean z) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpq
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzt(z);
                }
            });
        }
    }

    public final void zzx(final int i, final long j, final long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpk
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzu(i, j, j2);
                }
            });
        }
    }
}
