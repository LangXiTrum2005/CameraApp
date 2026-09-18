package com.google.android.gms.internal.ads;

import androidx.core.location.LocationRequestCompat;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzabv {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 3, 6};
    private static final int[] zzc = {48000, 44100, 32000};
    private static final int[] zzd = {24000, 22050, 16000};
    private static final int[] zze = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzf = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] zzg = {69, 87, LocationRequestCompat.QUALITY_LOW_POWER, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static int zza(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return zzb[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return 1536;
    }

    public static int zzb(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) <= 10) {
            byte b = bArr[4];
            return zzf((b & 192) >> 6, b & 63);
        }
        int i = bArr[2] & 7;
        int i2 = ((bArr[3] & 255) | (i << 8)) + 1;
        return i2 + i2;
    }

    public static zzam zzc(zzfp zzfpVar, String str, String str2, zzae zzaeVar) {
        zzfo zzfoVar = new zzfo();
        zzfoVar.zzi(zzfpVar);
        int i = zzc[zzfoVar.zzd(2)];
        zzfoVar.zzm(8);
        int i2 = zze[zzfoVar.zzd(3)];
        if (zzfoVar.zzd(1) != 0) {
            i2++;
        }
        int i3 = zzf[zzfoVar.zzd(5)] * 1000;
        zzfoVar.zze();
        zzfpVar.zzK(zzfoVar.zzb());
        zzak zzakVar = new zzak();
        zzakVar.zzK(str);
        zzakVar.zzW("audio/ac3");
        zzakVar.zzy(i2);
        zzakVar.zzX(i);
        zzakVar.zzE(zzaeVar);
        zzakVar.zzN(str2);
        zzakVar.zzx(i3);
        zzakVar.zzR(i3);
        return zzakVar.zzac();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0062  */
    public static zzam zzd(zzfp zzfpVar, String str, String str2, zzae zzaeVar) {
        String str3;
        zzfo zzfoVar = new zzfo();
        zzfoVar.zzi(zzfpVar);
        int iZzd = zzfoVar.zzd(13) * 1000;
        zzfoVar.zzm(3);
        int i = zzc[zzfoVar.zzd(2)];
        zzfoVar.zzm(10);
        int i2 = zze[zzfoVar.zzd(3)];
        if (zzfoVar.zzd(1) != 0) {
            i2++;
        }
        zzfoVar.zzm(3);
        int iZzd2 = zzfoVar.zzd(4);
        zzfoVar.zzm(1);
        if (iZzd2 > 0) {
            zzfoVar.zzm(6);
            if (zzfoVar.zzd(1) != 0) {
                i2 += 2;
            }
            zzfoVar.zzm(1);
        }
        if (zzfoVar.zza() > 7) {
            zzfoVar.zzm(7);
            if (zzfoVar.zzd(1) != 0) {
                str3 = "audio/eac3-joc";
            } else {
                str3 = "audio/eac3";
            }
        } else {
            str3 = "audio/eac3";
        }
        zzfoVar.zze();
        zzfpVar.zzK(zzfoVar.zzb());
        zzak zzakVar = new zzak();
        zzakVar.zzK(str);
        zzakVar.zzW(str3);
        zzakVar.zzy(i2);
        zzakVar.zzX(i);
        zzakVar.zzE(zzaeVar);
        zzakVar.zzN(str2);
        zzakVar.zzR(iZzd);
        return zzakVar.zzac();
    }

    public static zzabu zze(zzfo zzfoVar) {
        int i;
        int i2;
        String str;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int iZzc = zzfoVar.zzc();
        zzfoVar.zzm(40);
        int iZzd = zzfoVar.zzd(5);
        zzfoVar.zzk(iZzc);
        int i12 = -1;
        if (iZzd > 10) {
            zzfoVar.zzm(16);
            int iZzd2 = zzfoVar.zzd(2);
            if (iZzd2 == 0) {
                i12 = 0;
            } else if (iZzd2 == 1) {
                i12 = 1;
            } else if (iZzd2 == 2) {
                i12 = 2;
            }
            zzfoVar.zzm(3);
            int iZzd3 = zzfoVar.zzd(11) + 1;
            int iZzd4 = zzfoVar.zzd(2);
            if (iZzd4 == 3) {
                i8 = zzd[zzfoVar.zzd(2)];
                i9 = 6;
                i7 = 3;
            } else {
                int iZzd5 = zzfoVar.zzd(2);
                int i13 = zzb[iZzd5];
                i7 = iZzd5;
                i8 = zzc[iZzd4];
                i9 = i13;
            }
            int i14 = iZzd3 + iZzd3;
            int i15 = (i14 * i8) / (i9 * 32);
            int iZzd6 = zzfoVar.zzd(3);
            boolean zZzo = zzfoVar.zzo();
            i = zze[iZzd6] + (zZzo ? 1 : 0);
            zzfoVar.zzm(10);
            if (zzfoVar.zzo()) {
                zzfoVar.zzm(8);
            }
            if (iZzd6 == 0) {
                zzfoVar.zzm(5);
                if (zzfoVar.zzo()) {
                    zzfoVar.zzm(8);
                }
                i10 = 0;
                iZzd6 = 0;
            } else {
                i10 = iZzd6;
            }
            if (i12 == 1) {
                if (zzfoVar.zzo()) {
                    zzfoVar.zzm(16);
                }
                i11 = 1;
            } else {
                i11 = i12;
            }
            if (zzfoVar.zzo()) {
                if (i10 > 2) {
                    zzfoVar.zzm(2);
                }
                if ((i10 & 1) != 0 && i10 > 2) {
                    zzfoVar.zzm(6);
                }
                if ((i10 & 4) != 0) {
                    zzfoVar.zzm(6);
                }
                if (zZzo && zzfoVar.zzo()) {
                    zzfoVar.zzm(5);
                }
                if (i11 == 0) {
                    if (zzfoVar.zzo()) {
                        zzfoVar.zzm(6);
                    }
                    if (i10 == 0 && zzfoVar.zzo()) {
                        zzfoVar.zzm(6);
                    }
                    if (zzfoVar.zzo()) {
                        zzfoVar.zzm(6);
                    }
                    int iZzd7 = zzfoVar.zzd(2);
                    if (iZzd7 == 1) {
                        zzfoVar.zzm(5);
                    } else if (iZzd7 == 2) {
                        zzfoVar.zzm(12);
                    } else if (iZzd7 == 3) {
                        int iZzd8 = zzfoVar.zzd(5);
                        if (zzfoVar.zzo()) {
                            zzfoVar.zzm(5);
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(4);
                            }
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(4);
                            }
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(4);
                            }
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(4);
                            }
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(4);
                            }
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(4);
                            }
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(4);
                            }
                            if (zzfoVar.zzo()) {
                                if (zzfoVar.zzo()) {
                                    zzfoVar.zzm(4);
                                }
                                if (zzfoVar.zzo()) {
                                    zzfoVar.zzm(4);
                                }
                            }
                        }
                        if (zzfoVar.zzo()) {
                            zzfoVar.zzm(5);
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(7);
                                if (zzfoVar.zzo()) {
                                    zzfoVar.zzm(8);
                                }
                            }
                        }
                        zzfoVar.zzm((iZzd8 + 2) * 8);
                        zzfoVar.zze();
                    }
                    if (i10 < 2) {
                        if (zzfoVar.zzo()) {
                            zzfoVar.zzm(14);
                        }
                        if (iZzd6 == 0 && zzfoVar.zzo()) {
                            zzfoVar.zzm(14);
                        }
                    }
                    if (!zzfoVar.zzo()) {
                        i11 = 0;
                    } else if (i7 == 0) {
                        zzfoVar.zzm(5);
                        i11 = 0;
                        i7 = 0;
                    } else {
                        for (int i16 = 0; i16 < i9; i16++) {
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(5);
                            }
                        }
                        i11 = 0;
                    }
                }
            }
            if (zzfoVar.zzo()) {
                zzfoVar.zzm(5);
                if (i10 == 2) {
                    zzfoVar.zzm(4);
                    i10 = 2;
                }
                if (i10 >= 6) {
                    zzfoVar.zzm(2);
                }
                if (zzfoVar.zzo()) {
                    zzfoVar.zzm(8);
                }
                if (i10 == 0 && zzfoVar.zzo()) {
                    zzfoVar.zzm(8);
                }
                if (iZzd4 < 3) {
                    zzfoVar.zzl();
                }
            }
            if (i11 == 0 && i7 != 3) {
                zzfoVar.zzl();
            }
            if (i11 == 2 && (i7 == 3 || zzfoVar.zzo())) {
                zzfoVar.zzm(6);
            }
            str = (zzfoVar.zzo() && zzfoVar.zzd(6) == 1 && zzfoVar.zzd(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i2 = i12;
            i4 = i14;
            i5 = i8;
            i6 = i9 * 256;
            i3 = i15;
        } else {
            zzfoVar.zzm(32);
            int iZzd9 = zzfoVar.zzd(2);
            String str2 = iZzd9 == 3 ? null : "audio/ac3";
            int iZzd10 = zzfoVar.zzd(6);
            int i17 = zzf[iZzd10 / 2] * 1000;
            int iZzf = zzf(iZzd9, iZzd10);
            zzfoVar.zzm(8);
            int iZzd11 = zzfoVar.zzd(3);
            if ((iZzd11 & 1) != 0 && iZzd11 != 1) {
                zzfoVar.zzm(2);
            }
            if ((iZzd11 & 4) != 0) {
                zzfoVar.zzm(2);
            }
            if (iZzd11 == 2) {
                zzfoVar.zzm(2);
            }
            int i18 = iZzd9 < 3 ? zzc[iZzd9] : -1;
            i = zze[iZzd11] + (zzfoVar.zzo() ? 1 : 0);
            i2 = -1;
            str = str2;
            i3 = i17;
            i4 = iZzf;
            i5 = i18;
            i6 = 1536;
        }
        return new zzabu(str, i2, i, i5, i4, i6, i3, null);
    }

    private static int zzf(int i, int i2) {
        int i3;
        if (i < 0 || i >= 3 || i2 < 0 || (i3 = i2 >> 1) >= 19) {
            return -1;
        }
        int i4 = zzc[i];
        if (i4 == 44100) {
            int i5 = zzg[i3] + (i2 & 1);
            return i5 + i5;
        }
        int i6 = zzf[i3];
        return i4 == 32000 ? i6 * 6 : i6 * 4;
    }
}
