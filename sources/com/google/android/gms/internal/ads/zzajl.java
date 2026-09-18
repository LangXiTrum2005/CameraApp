package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzajl {
    private static final int[] zza = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean zza(zzacv zzacvVar) throws IOException {
        return zzc(zzacvVar, true, false);
    }

    public static boolean zzb(zzacv zzacvVar, boolean z) throws IOException {
        return zzc(zzacvVar, false, z);
    }

    /* JADX WARN: Code duplicated, block: B:104:0x00e3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x00fd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:71:0x00fa A[LOOP:2: B:66:0x00f1->B:71:0x00fa, LOOP_END] */
    private static boolean zzc(zzacv zzacvVar, boolean z, boolean z2) throws IOException {
        boolean z3;
        long jZzt;
        int i;
        zzfp zzfpVar;
        int i2;
        int[] iArr;
        int i3;
        long jZzd = zzacvVar.zzd();
        long j = -1;
        long j2 = 4096;
        if (jZzd != -1 && jZzd <= 4096) {
            j2 = jZzd;
        }
        zzfp zzfpVar2 = new zzfp(64);
        int i4 = (int) j2;
        boolean z4 = false;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i5 < i4) {
                zzfpVar2.zzH(8);
                if (!zzacvVar.zzm(zzfpVar2.zzM(), z4 ? 1 : 0, 8, true)) {
                    z3 = z4 ? 1 : 0;
                    break;
                }
                long jZzu = zzfpVar2.zzu();
                int iZzg = zzfpVar2.zzg();
                if (jZzu == 1) {
                    zzacvVar.zzh(zzfpVar2.zzM(), 8, 8);
                    i = 16;
                    zzfpVar2.zzJ(16);
                    jZzt = zzfpVar2.zzt();
                } else {
                    if (jZzu == 0) {
                        long jZzd2 = zzacvVar.zzd();
                        if (jZzd2 != j) {
                            jZzu = (jZzd2 - zzacvVar.zze()) + 8;
                        }
                    }
                    jZzt = jZzu;
                    i = 8;
                }
                long j3 = i;
                if (jZzt < j3) {
                    return z4;
                }
                i5 += i;
                if (iZzg == 1836019574) {
                    i4 += (int) jZzt;
                    if (jZzd != -1 && i4 > jZzd) {
                        i4 = (int) jZzd;
                    }
                    j = -1;
                } else {
                    if (iZzg == 1836019558 || iZzg == 1836475768) {
                        z3 = true;
                        break;
                    }
                    i6 = ((iZzg == 1835295092 ? z4 ? 1 : 0 : 1) ^ 1) | i6;
                    zzfp zzfpVar3 = zzfpVar2;
                    if ((((long) i5) + jZzt) - j3 < i4) {
                        int i7 = (int) (jZzt - j3);
                        i5 += i7;
                        if (iZzg != 1718909296) {
                            zzfpVar = zzfpVar3;
                            if (i7 != 0) {
                                zzacvVar.zzg(i7);
                            }
                        } else {
                            if (i7 < 8) {
                                return false;
                            }
                            zzfpVar = zzfpVar3;
                            zzfpVar.zzH(i7);
                            zzacvVar.zzh(zzfpVar.zzM(), 0, i7);
                            int i8 = i7 >> 2;
                            int i9 = 0;
                            while (true) {
                                if (i9 >= i8) {
                                    i2 = i6;
                                    break;
                                }
                                if (i9 != 1) {
                                    int iZzg2 = zzfpVar.zzg();
                                    if ((iZzg2 >>> 8) != 3368816) {
                                        if (iZzg2 != 1751476579) {
                                            iArr = zza;
                                            i3 = 0;
                                            while (true) {
                                                if (i3 < 29) {
                                                    continue;
                                                } else if (iArr[i3] == iZzg2) {
                                                    i3++;
                                                }
                                            }
                                        } else if (!z2) {
                                            iZzg2 = 1751476579;
                                            iArr = zza;
                                            i3 = 0;
                                            while (true) {
                                                if (i3 < 29) {
                                                    continue;
                                                } else if (iArr[i3] == iZzg2) {
                                                    i3++;
                                                }
                                            }
                                        }
                                    }
                                    i2 = 1;
                                    break;
                                }
                                zzfpVar.zzL(4);
                                i9++;
                            }
                            if (i2 == 0) {
                                return false;
                            }
                            i6 = i2;
                        }
                        zzfpVar2 = zzfpVar;
                        j = -1;
                        z4 = false;
                    }
                }
            }
            z3 = false;
            break;
        }
        return i6 != 0 && z == z3;
    }
}
