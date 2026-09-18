package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaij implements zzaii {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final long zzd;

    private zzaij(long[] jArr, long[] jArr2, long j, long j2) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j;
        this.zzd = j2;
    }

    public static zzaij zzb(long j, long j2, zzado zzadoVar, zzfp zzfpVar) {
        int iZzm;
        zzfpVar.zzL(10);
        int iZzg = zzfpVar.zzg();
        if (iZzg <= 0) {
            return null;
        }
        int i = zzadoVar.zzd;
        long jZzs = zzfy.zzs(iZzg, ((long) (i >= 32000 ? 1152 : 576)) * 1000000, i, RoundingMode.FLOOR);
        int iZzq = zzfpVar.zzq();
        int iZzq2 = zzfpVar.zzq();
        int iZzq3 = zzfpVar.zzq();
        zzfpVar.zzL(2);
        long j3 = j2 + ((long) zzadoVar.zzc);
        long[] jArr = new long[iZzq];
        long[] jArr2 = new long[iZzq];
        int i2 = 0;
        long j4 = j2;
        while (i2 < iZzq) {
            long j5 = j3;
            long j6 = jZzs;
            jArr[i2] = (((long) i2) * jZzs) / ((long) iZzq);
            jArr2[i2] = Math.max(j4, j5);
            if (iZzq3 == 1) {
                iZzm = zzfpVar.zzm();
            } else if (iZzq3 == 2) {
                iZzm = zzfpVar.zzq();
            } else if (iZzq3 == 3) {
                iZzm = zzfpVar.zzo();
            } else {
                if (iZzq3 != 4) {
                    return null;
                }
                iZzm = zzfpVar.zzp();
            }
            j4 += ((long) iZzm) * ((long) iZzq2);
            i2++;
            j3 = j5;
            iZzq = iZzq;
            jZzs = j6;
        }
        long j7 = jZzs;
        if (j != -1 && j != j4) {
            zzff.zzf("VbriSeeker", "VBRI data size mismatch: " + j + ", " + j4);
        }
        return new zzaij(jArr, jArr2, j7, j4);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final long zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzaii
    public final long zzd(long j) {
        return this.zza[zzfy.zzc(this.zzb, j, true, true)];
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j) {
        long[] jArr = this.zza;
        int iZzc = zzfy.zzc(jArr, j, true, true);
        zzadv zzadvVar = new zzadv(jArr[iZzc], this.zzb[iZzc]);
        if (zzadvVar.zzb < j) {
            long[] jArr2 = this.zza;
            if (iZzc != jArr2.length - 1) {
                int i = iZzc + 1;
                return new zzads(zzadvVar, new zzadv(jArr2[i], this.zzb[i]));
            }
        }
        return new zzads(zzadvVar, zzadvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return true;
    }
}
