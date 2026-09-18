package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgm {
    public static final byte[] zza = {0, 0, 0, 1};
    public static final float[] zzb = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object zzc = new Object();
    private static int[] zzd = new int[10];

    public static int zza(byte[] bArr, int i, int i2, boolean[] zArr) {
        int i3 = i2 - i;
        zzek.zzf(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            zzf(zArr);
            return i - 3;
        }
        if (i3 > 1 && zArr[1] && bArr[i] == 1) {
            zzf(zArr);
            return i - 2;
        }
        if (i3 > 2 && zArr[2] && bArr[i] == 0 && bArr[i + 1] == 1) {
            zzf(zArr);
            return i - 1;
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            byte b = bArr[i5];
            if ((b & 254) == 0) {
                int i6 = i5 - 2;
                if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && b == 1) {
                    zzf(zArr);
                    return i6;
                }
                i5 = i6;
            }
            i5 += 3;
        }
        zArr[0] = i3 <= 2 ? !(i3 != 2 ? !(zArr[1] && bArr[i4] == 1) : !(zArr[2] && bArr[i2 + (-2)] == 0 && bArr[i4] == 1)) : bArr[i2 + (-3)] == 0 && bArr[i2 + (-2)] == 0 && bArr[i4] == 1;
        zArr[1] = i3 <= 1 ? zArr[2] && bArr[i4] == 0 : bArr[i2 + (-2)] == 0 && bArr[i4] == 0;
        zArr[2] = bArr[i4] == 0;
        return i2;
    }

    public static zzgj zzc(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int iZzb;
        int i6;
        int i7;
        zzgn zzgnVar = new zzgn(bArr, i, i2);
        int i8 = 4;
        zzgnVar.zze(4);
        int iZza = zzgnVar.zza(3);
        zzgnVar.zzd();
        int iZza2 = zzgnVar.zza(2);
        boolean zZzf = zzgnVar.zzf();
        int iZza3 = zzgnVar.zza(5);
        int i9 = 0;
        for (int i10 = 0; i10 < 32; i10++) {
            if (zzgnVar.zzf()) {
                i9 |= 1 << i10;
            }
        }
        int i11 = 6;
        int[] iArr = new int[6];
        for (int i12 = 0; i12 < 6; i12++) {
            iArr[i12] = zzgnVar.zza(8);
        }
        int iZza4 = zzgnVar.zza(8);
        int i13 = 0;
        for (int i14 = 0; i14 < iZza; i14++) {
            if (zzgnVar.zzf()) {
                i13 += 89;
            }
            if (zzgnVar.zzf()) {
                i13 += 8;
            }
        }
        zzgnVar.zze(i13);
        if (iZza > 0) {
            int i15 = 8 - iZza;
            zzgnVar.zze(i15 + i15);
        }
        int iZzc = zzgnVar.zzc();
        int iZzc2 = zzgnVar.zzc();
        if (iZzc2 == 3) {
            zzgnVar.zzd();
            iZzc2 = 3;
        }
        int iZzc3 = zzgnVar.zzc();
        int iZzc4 = zzgnVar.zzc();
        if (zzgnVar.zzf()) {
            int iZzc5 = zzgnVar.zzc();
            int iZzc6 = zzgnVar.zzc();
            int iZzc7 = zzgnVar.zzc();
            int iZzc8 = zzgnVar.zzc();
            if (iZzc2 == 1) {
                i7 = 2;
            } else if (iZzc2 == 2) {
                iZzc2 = 2;
                i7 = 2;
            } else {
                i7 = 1;
            }
            iZzc3 -= i7 * (iZzc5 + iZzc6);
            iZzc4 -= (iZzc2 == 1 ? 2 : 1) * (iZzc7 + iZzc8);
        }
        int i16 = iZzc3;
        int i17 = iZzc2;
        int i18 = iZzc4;
        int iZzc9 = zzgnVar.zzc();
        int iZzc10 = zzgnVar.zzc();
        int iZzc11 = zzgnVar.zzc();
        for (int i19 = true != zzgnVar.zzf() ? iZza : 0; i19 <= iZza; i19++) {
            zzgnVar.zzc();
            zzgnVar.zzc();
            zzgnVar.zzc();
        }
        zzgnVar.zzc();
        zzgnVar.zzc();
        zzgnVar.zzc();
        zzgnVar.zzc();
        zzgnVar.zzc();
        zzgnVar.zzc();
        if (zzgnVar.zzf() && zzgnVar.zzf()) {
            int i20 = 0;
            while (i20 < i8) {
                int i21 = 0;
                while (i21 < i11) {
                    if (zzgnVar.zzf()) {
                        int iMin = Math.min(64, 1 << ((i20 + i20) + 4));
                        if (i20 > 1) {
                            zzgnVar.zzb();
                        }
                        for (int i22 = 0; i22 < iMin; i22++) {
                            zzgnVar.zzb();
                        }
                    } else {
                        zzgnVar.zzc();
                    }
                    i21 += i20 == 3 ? 3 : 1;
                    i11 = 6;
                }
                i20++;
                i8 = 4;
                i11 = 6;
            }
        }
        zzgnVar.zze(2);
        if (zzgnVar.zzf()) {
            zzgnVar.zze(8);
            zzgnVar.zzc();
            zzgnVar.zzc();
            zzgnVar.zzd();
        }
        int iZzc12 = zzgnVar.zzc();
        int i23 = 0;
        int[] iArr2 = new int[0];
        int[] iArrCopyOf = new int[0];
        int i24 = -1;
        int i25 = -1;
        int i26 = -1;
        while (i23 < iZzc12) {
            if (i23 == 0 || !zzgnVar.zzf()) {
                int iZzc13 = zzgnVar.zzc();
                int iZzc14 = zzgnVar.zzc();
                int[] iArr3 = new int[iZzc13];
                int i27 = 0;
                while (i27 < iZzc13) {
                    iArr3[i27] = (i27 > 0 ? iArr3[i27 - 1] : 0) - (zzgnVar.zzc() + 1);
                    zzgnVar.zzd();
                    i27++;
                }
                int[] iArr4 = new int[iZzc14];
                int i28 = 0;
                while (i28 < iZzc14) {
                    iArr4[i28] = (i28 > 0 ? iArr4[i28 - 1] : 0) + zzgnVar.zzc() + 1;
                    zzgnVar.zzd();
                    i28++;
                }
                i26 = iZzc14;
                iArrCopyOf = iArr4;
                i25 = iZzc13;
                iArr2 = iArr3;
            } else {
                int i29 = i25 + i26;
                boolean zZzf2 = zzgnVar.zzf();
                int iZzc15 = zzgnVar.zzc() + 1;
                int i30 = 1 - ((zZzf2 ? 1 : 0) + (zZzf2 ? 1 : 0));
                int i31 = i29 + 1;
                boolean[] zArr = new boolean[i31];
                for (int i32 = 0; i32 <= i29; i32++) {
                    if (zzgnVar.zzf()) {
                        zArr[i32] = true;
                    } else {
                        zArr[i32] = zzgnVar.zzf();
                    }
                }
                int i33 = i26 - 1;
                int[] iArr5 = new int[i31];
                int[] iArr6 = new int[i31];
                int i34 = 0;
                while (true) {
                    i6 = i30 * iZzc15;
                    if (i33 < 0) {
                        break;
                    }
                    int i35 = iArrCopyOf[i33] + i6;
                    if (i35 < 0 && zArr[i25 + i33]) {
                        iArr5[i34] = i35;
                        i34++;
                    }
                    i33--;
                }
                if (i6 < 0 && zArr[i29]) {
                    iArr5[i34] = i6;
                    i34++;
                }
                int i36 = i34;
                for (int i37 = 0; i37 < i25; i37++) {
                    int i38 = iArr2[i37] + i6;
                    if (i38 < 0 && zArr[i37]) {
                        iArr5[i36] = i38;
                        i36++;
                    }
                }
                int[] iArrCopyOf2 = Arrays.copyOf(iArr5, i36);
                int i39 = 0;
                for (int i40 = i25 - 1; i40 >= 0; i40--) {
                    int i41 = iArr2[i40] + i6;
                    if (i41 > 0 && zArr[i40]) {
                        iArr6[i39] = i41;
                        i39++;
                    }
                }
                if (i6 > 0 && zArr[i29]) {
                    iArr6[i39] = i6;
                    i39++;
                }
                int i42 = i39;
                for (int i43 = 0; i43 < i26; i43++) {
                    int i44 = iArrCopyOf[i43] + i6;
                    if (i44 > 0 && zArr[i25 + i43]) {
                        iArr6[i42] = i44;
                        i42++;
                    }
                }
                iArrCopyOf = Arrays.copyOf(iArr6, i42);
                i26 = i42;
                iArr2 = iArrCopyOf2;
                i25 = i36;
            }
            i23++;
            i17 = i17;
            i9 = i9;
            iZzc12 = iZzc12;
            iArr = iArr;
        }
        int i45 = i9;
        int i46 = i17;
        int[] iArr7 = iArr;
        if (zzgnVar.zzf()) {
            int iZzc16 = zzgnVar.zzc();
            for (int i47 = 0; i47 < iZzc16; i47++) {
                zzgnVar.zze(iZzc11 + 5);
            }
        }
        zzgnVar.zze(2);
        float f = 1.0f;
        if (zzgnVar.zzf()) {
            if (zzgnVar.zzf()) {
                int iZza5 = zzgnVar.zza(8);
                if (iZza5 == 255) {
                    int iZza6 = zzgnVar.zza(16);
                    int iZza7 = zzgnVar.zza(16);
                    if (iZza6 != 0 && iZza7 != 0) {
                        f = iZza6 / iZza7;
                    }
                } else if (iZza5 < 17) {
                    f = zzb[iZza5];
                } else {
                    zzff.zzf("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iZza5);
                }
            }
            if (zzgnVar.zzf()) {
                zzgnVar.zzd();
            }
            if (zzgnVar.zzf()) {
                zzgnVar.zze(3);
                int i48 = true != zzgnVar.zzf() ? 2 : 1;
                if (zzgnVar.zzf()) {
                    int iZza8 = zzgnVar.zza(8);
                    int iZza9 = zzgnVar.zza(8);
                    zzgnVar.zze(8);
                    int iZza10 = zzt.zza(iZza8);
                    iZzb = zzt.zzb(iZza9);
                    i4 = iZza10;
                } else {
                    i4 = -1;
                    iZzb = -1;
                }
                i24 = i48;
            } else {
                i4 = -1;
                iZzb = -1;
            }
            if (zzgnVar.zzf()) {
                zzgnVar.zzc();
                zzgnVar.zzc();
            }
            zzgnVar.zzd();
            if (zzgnVar.zzf()) {
                i18 += i18;
            }
            i5 = iZzb;
            i3 = i18;
        } else {
            i3 = i18;
            i4 = -1;
            i5 = -1;
        }
        return new zzgj(iZza2, zZzf, iZza3, i45, i46, iZzc9, iZzc10, iArr7, iZza4, iZzc, i16, i3, f, i4, i24, i5);
    }

    public static zzgk zzd(byte[] bArr, int i, int i2) {
        zzgn zzgnVar = new zzgn(bArr, 4, i2);
        int iZzc = zzgnVar.zzc();
        int iZzc2 = zzgnVar.zzc();
        zzgnVar.zzd();
        return new zzgk(iZzc, iZzc2, zzgnVar.zzf());
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:104:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:105:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:106:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:107:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:112:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:0x009e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0055  */
    /* JADX WARN: Code duplicated, block: B:27:0x005b  */
    /* JADX WARN: Code duplicated, block: B:30:0x006e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x0070  */
    /* JADX WARN: Code duplicated, block: B:32:0x0072  */
    /* JADX WARN: Code duplicated, block: B:35:0x0077  */
    /* JADX WARN: Code duplicated, block: B:37:0x007d  */
    /* JADX WARN: Code duplicated, block: B:39:0x0080  */
    /* JADX WARN: Code duplicated, block: B:40:0x0083  */
    /* JADX WARN: Code duplicated, block: B:43:0x008c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x008e  */
    /* JADX WARN: Code duplicated, block: B:46:0x009c  */
    /* JADX WARN: Code duplicated, block: B:63:0x0104  */
    /* JADX WARN: Code duplicated, block: B:66:0x0117  */
    /* JADX WARN: Code duplicated, block: B:69:0x012a  */
    /* JADX WARN: Code duplicated, block: B:71:0x012d  */
    /* JADX WARN: Code duplicated, block: B:72:0x0131  */
    /* JADX WARN: Code duplicated, block: B:74:0x0136  */
    /* JADX WARN: Code duplicated, block: B:75:0x0139  */
    /* JADX WARN: Code duplicated, block: B:80:0x0150  */
    /* JADX WARN: Code duplicated, block: B:82:0x0156  */
    /* JADX WARN: Code duplicated, block: B:84:0x0160  */
    /* JADX WARN: Code duplicated, block: B:88:0x0172  */
    /* JADX WARN: Code duplicated, block: B:90:0x0176  */
    /* JADX WARN: Code duplicated, block: B:91:0x017b  */
    /* JADX WARN: Code duplicated, block: B:92:0x018e  */
    /* JADX WARN: Code duplicated, block: B:95:0x0196  */
    /* JADX WARN: Code duplicated, block: B:98:0x019f  */
    /* JADX WARN: Instruction removed from duplicated block: B:91:0x017b, please report this as an issue */
    public static zzgl zze(byte[] bArr, int i, int i2) {
        int iZzc;
        int i3;
        boolean zZzf;
        int i4;
        int i5;
        boolean z;
        int i6;
        int i7;
        int i8;
        int iZzb;
        int i9;
        int i10;
        int iZzc2;
        boolean z2;
        boolean zZzf2;
        int i11;
        int i12;
        int i13;
        int iZza;
        int i14;
        int iZzb2;
        float f;
        float f2;
        int iZza2;
        int iZza3;
        int i15;
        int i16;
        int i17;
        zzgn zzgnVar = new zzgn(bArr, i, i2);
        int i18 = 8;
        int iZza4 = zzgnVar.zza(8);
        int iZza5 = zzgnVar.zza(8);
        int iZza6 = zzgnVar.zza(8);
        int iZzc3 = zzgnVar.zzc();
        int i19 = 1;
        if (iZza4 == 100 || iZza4 == 110 || iZza4 == 122 || iZza4 == 244 || iZza4 == 44 || iZza4 == 83 || iZza4 == 86 || iZza4 == 118 || iZza4 == 128) {
            iZzc = zzgnVar.zzc();
            if (iZzc == 3) {
                zZzf = zzgnVar.zzf();
                i3 = 3;
            } else {
                i3 = iZzc;
                zZzf = false;
            }
            int iZzc4 = zzgnVar.zzc();
            int iZzc5 = zzgnVar.zzc();
            zzgnVar.zzd();
            if (zzgnVar.zzf()) {
                if (i3 != 3) {
                    i6 = 8;
                } else {
                    i6 = 12;
                }
                i7 = 0;
                while (i7 < i6) {
                    if (!zzgnVar.zzf()) {
                        if (i7 < 6) {
                            i8 = 16;
                        } else {
                            i8 = 64;
                        }
                        iZzb = i18;
                        i9 = iZzb;
                        for (i10 = 0; i10 < i8; i10++) {
                            if (iZzb != 0) {
                                iZzb = ((i9 + zzgnVar.zzb()) + 256) % 256;
                            }
                            if (iZzb != 0) {
                                i9 = iZzb;
                            }
                        }
                    }
                    i7++;
                    i18 = 8;
                }
            }
            i4 = iZzc4;
            i5 = iZzc5;
            z = zZzf;
        } else if (iZza4 == 138) {
            iZza4 = 138;
            iZzc = zzgnVar.zzc();
            if (iZzc == 3) {
                zZzf = zzgnVar.zzf();
                i3 = 3;
            } else {
                i3 = iZzc;
                zZzf = false;
            }
            int iZzc6 = zzgnVar.zzc();
            int iZzc7 = zzgnVar.zzc();
            zzgnVar.zzd();
            if (zzgnVar.zzf()) {
                if (i3 != 3) {
                    i6 = 8;
                } else {
                    i6 = 12;
                }
                i7 = 0;
                while (i7 < i6) {
                    if (!zzgnVar.zzf()) {
                        if (i7 < 6) {
                            i8 = 16;
                        } else {
                            i8 = 64;
                        }
                        iZzb = i18;
                        i9 = iZzb;
                        while (i10 < i8) {
                            if (iZzb != 0) {
                                iZzb = ((i9 + zzgnVar.zzb()) + 256) % 256;
                            }
                            if (iZzb != 0) {
                                i9 = iZzb;
                            }
                        }
                    }
                    i7++;
                    i18 = 8;
                }
            }
            i4 = iZzc6;
            i5 = iZzc7;
            z = zZzf;
        } else {
            iZzc = 1;
            i4 = 0;
            i5 = 0;
            z = false;
        }
        int iZzc8 = zzgnVar.zzc() + 4;
        int iZzc9 = zzgnVar.zzc();
        if (iZzc9 != 0) {
            if (iZzc9 == 1) {
                boolean zZzf3 = zzgnVar.zzf();
                zzgnVar.zzb();
                zzgnVar.zzb();
                long jZzc = zzgnVar.zzc();
                iZza5 = iZza5;
                for (int i20 = 0; i20 < jZzc; i20++) {
                    zzgnVar.zzc();
                }
                z2 = zZzf3;
                iZzc9 = 1;
                iZzc2 = 0;
            } else {
                iZzc2 = 0;
            }
            int iZzc10 = zzgnVar.zzc();
            zzgnVar.zzd();
            int iZzc11 = zzgnVar.zzc() + 1;
            int iZzc12 = zzgnVar.zzc() + 1;
            zZzf2 = zzgnVar.zzf();
            i11 = 2 - (zZzf2 ? 1 : 0);
            if (!zZzf2) {
                zzgnVar.zzd();
            }
            zzgnVar.zzd();
            i12 = iZzc11 * 16;
            i13 = iZzc12 * i11 * 16;
            if (zzgnVar.zzf()) {
                int iZzc13 = zzgnVar.zzc();
                int iZzc14 = zzgnVar.zzc();
                int iZzc15 = zzgnVar.zzc();
                int iZzc16 = zzgnVar.zzc();
                if (iZzc != 0) {
                    if (iZzc == 3) {
                        i16 = 1;
                        i15 = 1;
                    } else {
                        i15 = 2;
                        i16 = 1;
                    }
                    if (iZzc == i16) {
                        i17 = 2;
                    } else {
                        i17 = 1;
                    }
                    i11 *= i17;
                    i19 = i15;
                }
                i12 -= (iZzc13 + iZzc14) * i19;
                i13 -= (iZzc15 + iZzc16) * i11;
            }
            int i21 = i12;
            int i22 = i13;
            if (zzgnVar.zzf()) {
                if (zzgnVar.zzf()) {
                    iZza2 = zzgnVar.zza(8);
                    if (iZza2 == 255) {
                        iZza3 = zzgnVar.zza(16);
                        int iZza7 = zzgnVar.zza(16);
                        if (iZza3 != 0 || iZza7 == 0) {
                            f2 = 1.0f;
                        } else {
                            f2 = iZza3 / iZza7;
                        }
                    } else if (iZza2 < 17) {
                        f2 = zzb[iZza2];
                    } else {
                        zzff.zzf("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iZza2);
                        f2 = 1.0f;
                    }
                } else {
                    f2 = 1.0f;
                }
                if (zzgnVar.zzf()) {
                    zzgnVar.zzd();
                }
                if (zzgnVar.zzf()) {
                    zzgnVar.zze(3);
                    i14 = true == zzgnVar.zzf() ? 1 : 2;
                    if (zzgnVar.zzf()) {
                        int iZza8 = zzgnVar.zza(8);
                        int iZza9 = zzgnVar.zza(8);
                        zzgnVar.zze(8);
                        iZza = zzt.zza(iZza8);
                        iZzb2 = zzt.zzb(iZza9);
                        f = f2;
                    } else {
                        f = f2;
                        iZza = -1;
                        iZzb2 = -1;
                    }
                } else {
                    f = f2;
                    iZza = -1;
                    i14 = -1;
                    iZzb2 = -1;
                }
            } else {
                iZza = -1;
                i14 = -1;
                iZzb2 = -1;
                f = 1.0f;
            }
            return new zzgl(iZza4, iZza5, iZza6, iZzc3, iZzc10, i21, i22, f, i4, i5, z, zZzf2, iZzc8, iZzc9, iZzc2, z2, iZza, i14, iZzb2);
        }
        iZzc2 = zzgnVar.zzc() + 4;
        z2 = false;
        int iZzc17 = zzgnVar.zzc();
        zzgnVar.zzd();
        int iZzc18 = zzgnVar.zzc() + 1;
        int iZzc19 = zzgnVar.zzc() + 1;
        zZzf2 = zzgnVar.zzf();
        i11 = 2 - (zZzf2 ? 1 : 0);
        if (!zZzf2) {
            zzgnVar.zzd();
        }
        zzgnVar.zzd();
        i12 = iZzc18 * 16;
        i13 = iZzc19 * i11 * 16;
        if (zzgnVar.zzf()) {
            int iZzc110 = zzgnVar.zzc();
            int iZzc111 = zzgnVar.zzc();
            int iZzc112 = zzgnVar.zzc();
            int iZzc113 = zzgnVar.zzc();
            if (iZzc != 0) {
                if (iZzc == 3) {
                    i16 = 1;
                    i15 = 1;
                } else {
                    i15 = 2;
                    i16 = 1;
                }
                if (iZzc == i16) {
                    i17 = 2;
                } else {
                    i17 = 1;
                }
                i11 *= i17;
                i19 = i15;
            }
            i12 -= (iZzc110 + iZzc111) * i19;
            i13 -= (iZzc112 + iZzc113) * i11;
        }
        int i23 = i12;
        int i24 = i13;
        if (zzgnVar.zzf()) {
            if (zzgnVar.zzf()) {
                f2 = 1.0f;
            } else {
                iZza2 = zzgnVar.zza(8);
                if (iZza2 == 255) {
                    iZza3 = zzgnVar.zza(16);
                    int iZza10 = zzgnVar.zza(16);
                    if (iZza3 != 0) {
                        f2 = 1.0f;
                    } else {
                        f2 = 1.0f;
                    }
                } else if (iZza2 < 17) {
                    f2 = zzb[iZza2];
                } else {
                    zzff.zzf("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iZza2);
                    f2 = 1.0f;
                }
            }
            if (zzgnVar.zzf()) {
                zzgnVar.zzd();
            }
            if (zzgnVar.zzf()) {
                zzgnVar.zze(3);
                if (true == zzgnVar.zzf()) {
                }
                if (zzgnVar.zzf()) {
                    int iZza11 = zzgnVar.zza(8);
                    int iZza12 = zzgnVar.zza(8);
                    zzgnVar.zze(8);
                    iZza = zzt.zza(iZza11);
                    iZzb2 = zzt.zzb(iZza12);
                    f = f2;
                } else {
                    f = f2;
                    iZza = -1;
                    iZzb2 = -1;
                }
            } else {
                f = f2;
                iZza = -1;
                i14 = -1;
                iZzb2 = -1;
            }
        } else {
            iZza = -1;
            i14 = -1;
            iZzb2 = -1;
            f = 1.0f;
        }
        return new zzgl(iZza4, iZza5, iZza6, iZzc3, iZzc17, i23, i24, f, i4, i5, z, zZzf2, iZzc8, iZzc9, iZzc2, z2, iZza, i14, iZzb2);
    }

    public static void zzf(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static int zzb(byte[] bArr, int i) {
        int i2;
        synchronized (zzc) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                while (true) {
                    try {
                        if (i3 >= i - 2) {
                            i3 = i;
                            break;
                        }
                        int i5 = i3 + 1;
                        if (bArr[i3] == 0 && bArr[i5] == 0 && bArr[i3 + 2] == 3) {
                            break;
                        }
                        i3 = i5;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i3 < i) {
                    int[] iArr = zzd;
                    int length = iArr.length;
                    if (length <= i4) {
                        zzd = Arrays.copyOf(iArr, length + length);
                    }
                    zzd[i4] = i3;
                    i3 += 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = zzd[i8] - i6;
                System.arraycopy(bArr, i6, bArr, i7, i9);
                int i10 = i7 + i9;
                int i11 = i10 + 1;
                bArr[i10] = 0;
                i7 = i10 + 2;
                bArr[i11] = 0;
                i6 += i9 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i7, i2 - i7);
        }
        return i2;
    }
}
