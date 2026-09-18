package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzake {
    private zzaea zzb;
    private zzacx zzc;
    private zzajz zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private long zzk;
    private boolean zzl;
    private boolean zzm;
    private final zzajx zza = new zzajx();
    private zzakb zzj = new zzakb();

    protected abstract long zza(zzfp zzfpVar);

    protected void zzb(boolean z) {
        int i;
        if (z) {
            this.zzj = new zzakb();
            this.zzf = 0L;
            i = 0;
        } else {
            i = 1;
        }
        this.zzh = i;
        this.zze = -1L;
        this.zzg = 0L;
    }

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected abstract boolean zzc(zzfp zzfpVar, long j, zzakb zzakbVar) throws IOException;

    final int zze(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        zzek.zzb(this.zzb);
        int i = zzfy.zza;
        int i2 = this.zzh;
        if (i2 == 0) {
            while (this.zza.zze(zzacvVar)) {
                long jZzf = zzacvVar.zzf();
                long j = this.zzf;
                this.zzk = jZzf - j;
                if (zzc(this.zza.zza(), j, this.zzj)) {
                    this.zzf = zzacvVar.zzf();
                } else {
                    zzam zzamVar = this.zzj.zza;
                    this.zzi = zzamVar.zzA;
                    if (!this.zzm) {
                        this.zzb.zzl(zzamVar);
                        this.zzm = true;
                    }
                    zzajz zzajzVar = this.zzj.zzb;
                    if (zzajzVar != null) {
                        this.zzd = zzajzVar;
                    } else if (zzacvVar.zzd() == -1) {
                        this.zzd = new zzakd(null);
                    } else {
                        zzajy zzajyVarZzb = this.zza.zzb();
                        this.zzd = new zzajs(this, this.zzf, zzacvVar.zzd(), zzajyVarZzb.zzd + zzajyVarZzb.zze, zzajyVarZzb.zzb, (zzajyVarZzb.zza & 4) != 0);
                    }
                    this.zzh = 2;
                    this.zza.zzd();
                }
            }
            this.zzh = 3;
            return -1;
        }
        if (i2 == 1) {
            ((zzack) zzacvVar).zzo((int) this.zzf, false);
            this.zzh = 2;
            return 0;
        }
        if (i2 != 2) {
            return -1;
        }
        long jZzd = this.zzd.zzd(zzacvVar);
        if (jZzd >= 0) {
            zzadrVar.zza = jZzd;
            return 1;
        }
        if (jZzd < -1) {
            zzi(-(jZzd + 2));
        }
        if (!this.zzl) {
            zzadu zzaduVarZze = this.zzd.zze();
            zzek.zzb(zzaduVarZze);
            this.zzc.zzO(zzaduVarZze);
            this.zzl = true;
        }
        if (this.zzk <= 0 && !this.zza.zze(zzacvVar)) {
            this.zzh = 3;
            return -1;
        }
        this.zzk = 0L;
        zzfp zzfpVarZza = this.zza.zza();
        long jZza = zza(zzfpVarZza);
        if (jZza >= 0) {
            long j2 = this.zzg;
            if (j2 + jZza >= this.zze) {
                long jZzf2 = zzf(j2);
                zzady.zzb(this.zzb, zzfpVarZza, zzfpVarZza.zze());
                this.zzb.zzt(jZzf2, 1, zzfpVarZza.zze(), 0, null);
                this.zze = -1L;
            }
        }
        this.zzg += jZza;
        return 0;
    }

    protected final long zzf(long j) {
        return (j * 1000000) / ((long) this.zzi);
    }

    protected final long zzg(long j) {
        return (((long) this.zzi) * j) / 1000000;
    }

    final void zzh(zzacx zzacxVar, zzaea zzaeaVar) {
        this.zzc = zzacxVar;
        this.zzb = zzaeaVar;
        zzb(true);
    }

    protected void zzi(long j) {
        this.zzg = j;
    }

    final void zzj(long j, long j2) {
        this.zza.zzc();
        if (j == 0) {
            zzb(!this.zzl);
            return;
        }
        if (this.zzh != 0) {
            this.zze = zzg(j2);
            zzajz zzajzVar = this.zzd;
            int i = zzfy.zza;
            zzajzVar.zzg(this.zze);
            this.zzh = 2;
        }
    }
}
