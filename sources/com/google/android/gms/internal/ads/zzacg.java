package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzacg {
    protected final zzaca zza;
    protected final zzacf zzb;
    protected zzacc zzc;
    private final int zzd;

    protected zzacg(zzacd zzacdVar, zzacf zzacfVar, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.zzb = zzacfVar;
        this.zzd = i;
        this.zza = new zzaca(zzacdVar, j, 0L, j3, j4, j5, j6);
    }

    protected static final int zzf(zzacv zzacvVar, long j, zzadr zzadrVar) {
        if (j == zzacvVar.zzf()) {
            return 0;
        }
        zzadrVar.zza = j;
        return 1;
    }

    protected static final boolean zzg(zzacv zzacvVar, long j) throws IOException {
        long jZzf = j - zzacvVar.zzf();
        if (jZzf < 0 || jZzf > 262144) {
            return false;
        }
        ((zzack) zzacvVar).zzo((int) jZzf, false);
        return true;
    }

    public final int zza(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        while (true) {
            zzacc zzaccVar = this.zzc;
            zzek.zzb(zzaccVar);
            long j = zzaccVar.zzf;
            long j2 = zzaccVar.zzg - j;
            int i = this.zzd;
            long j3 = zzaccVar.zzh;
            if (j2 <= i) {
                zzc(false, j);
                return zzf(zzacvVar, j, zzadrVar);
            }
            if (!zzg(zzacvVar, j3)) {
                return zzf(zzacvVar, j3, zzadrVar);
            }
            zzacvVar.zzj();
            zzace zzaceVarZza = this.zzb.zza(zzacvVar, zzaccVar.zzb);
            int i2 = zzaceVarZza.zzb;
            if (i2 == -3) {
                zzc(false, j3);
                return zzf(zzacvVar, j3, zzadrVar);
            }
            if (i2 == -2) {
                zzacc.zzh(zzaccVar, zzaceVarZza.zzc, zzaceVarZza.zzd);
            } else {
                if (i2 != -1) {
                    zzg(zzacvVar, zzaceVarZza.zzd);
                    zzc(true, zzaceVarZza.zzd);
                    return zzf(zzacvVar, zzaceVarZza.zzd, zzadrVar);
                }
                zzacc.zzg(zzaccVar, zzaceVarZza.zzc, zzaceVarZza.zzd);
            }
        }
    }

    public final zzadu zzb() {
        return this.zza;
    }

    protected final void zzc(boolean z, long j) {
        this.zzc = null;
        this.zzb.zzb();
    }

    public final void zzd(long j) {
        zzacc zzaccVar = this.zzc;
        if (zzaccVar == null || zzaccVar.zza != j) {
            zzaca zzacaVar = this.zza;
            this.zzc = new zzacc(j, zzacaVar.zzf(j), 0L, zzacaVar.zzc, zzacaVar.zzd, zzacaVar.zze, zzacaVar.zzf);
        }
    }

    public final boolean zze() {
        return this.zzc != null;
    }
}
