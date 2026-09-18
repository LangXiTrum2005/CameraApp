package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaoc {
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzfw zza = new zzfw(0);
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private final zzfp zzb = new zzfp();

    zzaoc(int i) {
    }

    private final int zze(zzacv zzacvVar) {
        byte[] bArr = zzfy.zzf;
        int length = bArr.length;
        this.zzb.zzI(bArr, 0);
        this.zzc = true;
        zzacvVar.zzj();
        return 0;
    }

    public final int zza(zzacv zzacvVar, zzadr zzadrVar, int i) throws IOException {
        if (i <= 0) {
            zze(zzacvVar);
            return 0;
        }
        long j = -9223372036854775807L;
        if (!this.zze) {
            long jZzd = zzacvVar.zzd();
            int iMin = (int) Math.min(112800L, jZzd);
            long j2 = jZzd - ((long) iMin);
            if (zzacvVar.zzf() == j2) {
                this.zzb.zzH(iMin);
                zzacvVar.zzj();
                ((zzack) zzacvVar).zzm(this.zzb.zzM(), 0, iMin, false);
                zzfp zzfpVar = this.zzb;
                int iZzd = zzfpVar.zzd();
                int iZze = zzfpVar.zze();
                for (int i2 = iZze - 188; i2 >= iZzd; i2--) {
                    byte[] bArrZzM = zzfpVar.zzM();
                    int i3 = 0;
                    for (int i4 = -4; i4 <= 4; i4++) {
                        int i5 = (i4 * 188) + i2;
                        if (i5 >= iZzd && i5 < iZze && bArrZzM[i5] == 71) {
                            i3++;
                            if (i3 == 5) {
                                long jZzb = zzaom.zzb(zzfpVar, i2, i);
                                if (jZzb == -9223372036854775807L) {
                                    break;
                                }
                                j = jZzb;
                                break;
                            }
                        } else {
                            i3 = 0;
                        }
                    }
                }
                this.zzg = j;
                this.zze = true;
                return 0;
            }
            zzadrVar.zza = j2;
        } else {
            if (this.zzg == -9223372036854775807L) {
                zze(zzacvVar);
                return 0;
            }
            if (this.zzd) {
                long j3 = this.zzf;
                if (j3 == -9223372036854775807L) {
                    zze(zzacvVar);
                    return 0;
                }
                zzfw zzfwVar = this.zza;
                this.zzh = zzfwVar.zzc(this.zzg) - zzfwVar.zzb(j3);
                zze(zzacvVar);
                return 0;
            }
            int iMin2 = (int) Math.min(112800L, zzacvVar.zzd());
            if (zzacvVar.zzf() == 0) {
                this.zzb.zzH(iMin2);
                zzacvVar.zzj();
                ((zzack) zzacvVar).zzm(this.zzb.zzM(), 0, iMin2, false);
                zzfp zzfpVar2 = this.zzb;
                int iZze2 = zzfpVar2.zze();
                for (int iZzd2 = zzfpVar2.zzd(); iZzd2 < iZze2; iZzd2++) {
                    if (zzfpVar2.zzM()[iZzd2] == 71) {
                        long jZzb2 = zzaom.zzb(zzfpVar2, iZzd2, i);
                        if (jZzb2 != -9223372036854775807L) {
                            j = jZzb2;
                            break;
                        }
                    }
                }
                this.zzf = j;
                this.zzd = true;
                return 0;
            }
            zzadrVar.zza = 0L;
        }
        return 1;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzfw zzc() {
        return this.zza;
    }

    public final boolean zzd() {
        return this.zzc;
    }
}
