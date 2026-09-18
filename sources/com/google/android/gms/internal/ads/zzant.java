package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzant {
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzfw zza = new zzfw(0);
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private final zzfp zzb = new zzfp();

    zzant() {
    }

    public static long zzc(zzfp zzfpVar) {
        int iZzd = zzfpVar.zzd();
        if (zzfpVar.zzb() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        zzfpVar.zzG(bArr, 0, 9);
        zzfpVar.zzK(iZzd);
        byte b = bArr[0];
        if ((b & 196) != 68) {
            return -9223372036854775807L;
        }
        byte b2 = bArr[2];
        if ((b2 & 4) != 4) {
            return -9223372036854775807L;
        }
        byte b3 = bArr[4];
        if ((b3 & 4) != 4 || (bArr[5] & 1) != 1 || (bArr[8] & 3) != 3) {
            return -9223372036854775807L;
        }
        long j = b;
        long j2 = b2;
        long j3 = (248 & j2) >> 3;
        long j4 = (j2 & 3) << 13;
        return j4 | ((bArr[1] & 255) << 20) | ((j & 3) << 28) | (((j & 56) >> 3) << 30) | (j3 << 15) | ((((long) bArr[3]) & 255) << 5) | ((((long) b3) & 248) >> 3);
    }

    private final int zzf(zzacv zzacvVar) {
        byte[] bArr = zzfy.zzf;
        int length = bArr.length;
        this.zzb.zzI(bArr, 0);
        this.zzc = true;
        zzacvVar.zzj();
        return 0;
    }

    private static final int zzg(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public final int zza(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        long j = -9223372036854775807L;
        if (!this.zze) {
            long jZzd = zzacvVar.zzd();
            int iMin = (int) Math.min(20000L, jZzd);
            long j2 = jZzd - ((long) iMin);
            if (zzacvVar.zzf() != j2) {
                zzadrVar.zza = j2;
                return 1;
            }
            this.zzb.zzH(iMin);
            zzacvVar.zzj();
            ((zzack) zzacvVar).zzm(this.zzb.zzM(), 0, iMin, false);
            zzfp zzfpVar = this.zzb;
            int iZzd = zzfpVar.zzd();
            for (int iZze = zzfpVar.zze() - 4; iZze >= iZzd; iZze--) {
                if (zzg(zzfpVar.zzM(), iZze) == 442) {
                    zzfpVar.zzK(iZze + 4);
                    long jZzc = zzc(zzfpVar);
                    if (jZzc != -9223372036854775807L) {
                        j = jZzc;
                        break;
                    }
                }
            }
            this.zzg = j;
            this.zze = true;
        } else {
            if (this.zzg == -9223372036854775807L) {
                zzf(zzacvVar);
                return 0;
            }
            if (this.zzd) {
                long j3 = this.zzf;
                if (j3 == -9223372036854775807L) {
                    zzf(zzacvVar);
                    return 0;
                }
                zzfw zzfwVar = this.zza;
                this.zzh = zzfwVar.zzc(this.zzg) - zzfwVar.zzb(j3);
                zzf(zzacvVar);
                return 0;
            }
            int iMin2 = (int) Math.min(20000L, zzacvVar.zzd());
            if (zzacvVar.zzf() != 0) {
                zzadrVar.zza = 0L;
                return 1;
            }
            this.zzb.zzH(iMin2);
            zzacvVar.zzj();
            ((zzack) zzacvVar).zzm(this.zzb.zzM(), 0, iMin2, false);
            zzfp zzfpVar2 = this.zzb;
            int iZze2 = zzfpVar2.zze();
            for (int iZzd2 = zzfpVar2.zzd(); iZzd2 < iZze2 - 3; iZzd2++) {
                if (zzg(zzfpVar2.zzM(), iZzd2) == 442) {
                    zzfpVar2.zzK(iZzd2 + 4);
                    long jZzc2 = zzc(zzfpVar2);
                    if (jZzc2 != -9223372036854775807L) {
                        j = jZzc2;
                        break;
                    }
                }
            }
            this.zzf = j;
            this.zzd = true;
        }
        return 0;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzfw zzd() {
        return this.zza;
    }

    public final boolean zze() {
        return this.zzc;
    }
}
