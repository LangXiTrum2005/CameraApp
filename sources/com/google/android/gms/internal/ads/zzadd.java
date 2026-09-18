package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzadd {
    public static int zza(zzfp zzfpVar, int i) {
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return zzfpVar.zzm() + 1;
            case 7:
                return zzfpVar.zzq() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }

    public static long zzb(zzacv zzacvVar, zzadh zzadhVar) throws IOException {
        zzacvVar.zzj();
        zzack zzackVar = (zzack) zzacvVar;
        zzackVar.zzl(1, false);
        byte[] bArr = new byte[1];
        zzackVar.zzm(bArr, 0, 1, false);
        int i = bArr[0] & 1;
        boolean z = 1 == i;
        zzackVar.zzl(2, false);
        int i2 = 1 != i ? 6 : 7;
        zzfp zzfpVar = new zzfp(i2);
        zzfpVar.zzJ(zzacy.zza(zzacvVar, zzfpVar.zzM(), 0, i2));
        zzacvVar.zzj();
        zzadc zzadcVar = new zzadc();
        if (zzd(zzfpVar, zzadhVar, z, zzadcVar)) {
            return zzadcVar.zza;
        }
        throw zzcc.zza(null, null);
    }

    /* JADX WARN: Code duplicated, block: B:50:0x009b  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ae A[RETURN] */
    public static boolean zzc(zzfp zzfpVar, zzadh zzadhVar, int i, zzadc zzadcVar) {
        int iZza;
        int iZzd = zzfpVar.zzd();
        long jZzu = zzfpVar.zzu();
        long j = jZzu >>> 16;
        if (j != i) {
            return false;
        }
        boolean z = (j & 1) == 1;
        long j2 = jZzu >> 12;
        long j3 = jZzu >> 8;
        long j4 = jZzu >> 4;
        long j5 = jZzu >> 1;
        long j6 = jZzu & 1;
        int i2 = (int) (j4 & 15);
        if (i2 > 7 ? !(i2 > 10 || zzadhVar.zzg != 2) : i2 == zzadhVar.zzg - 1) {
            int i3 = (int) (j5 & 7);
            if ((i3 == 0 || i3 == zzadhVar.zzi) && j6 != 1 && zzd(zzfpVar, zzadhVar, z, zzadcVar) && (iZza = zza(zzfpVar, (int) (j2 & 15))) != -1 && iZza <= zzadhVar.zzb) {
                int i4 = zzadhVar.zze;
                int i5 = (int) (j3 & 15);
                if (i5 != 0) {
                    if (i5 <= 11) {
                        if (i5 == zzadhVar.zzf) {
                            if (zzfpVar.zzm() == zzfy.zze(zzfpVar.zzM(), iZzd, zzfpVar.zzd() - 1, 0)) {
                                return true;
                            }
                        }
                    } else if (i5 == 12) {
                        if (zzfpVar.zzm() * 1000 == i4) {
                            if (zzfpVar.zzm() == zzfy.zze(zzfpVar.zzM(), iZzd, zzfpVar.zzd() - 1, 0)) {
                                return true;
                            }
                        }
                    } else if (i5 <= 14) {
                        int iZzq = zzfpVar.zzq();
                        if (i5 == 14) {
                            iZzq *= 10;
                        }
                        if (iZzq == i4) {
                            if (zzfpVar.zzm() == zzfy.zze(zzfpVar.zzM(), iZzd, zzfpVar.zzd() - 1, 0)) {
                                return true;
                            }
                        }
                    }
                } else if (zzfpVar.zzm() == zzfy.zze(zzfpVar.zzM(), iZzd, zzfpVar.zzd() - 1, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean zzd(zzfp zzfpVar, zzadh zzadhVar, boolean z, zzadc zzadcVar) {
        try {
            long jZzw = zzfpVar.zzw();
            if (!z) {
                jZzw *= (long) zzadhVar.zzb;
            }
            zzadcVar.zza = jZzw;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
