package com.google.android.gms.internal.ads;

import androidx.core.view.PointerIconCompat;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.perf.util.Constants;
import com.google.logging.type.LogSeverity;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaby {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {2002, Constants.MAX_URL_LENGTH, 1920, 1601, 1600, PointerIconCompat.TYPE_CONTEXT_MENU, 1000, 960, LogSeverity.EMERGENCY_VALUE, LogSeverity.EMERGENCY_VALUE, 480, LogSeverity.WARNING_VALUE, LogSeverity.WARNING_VALUE, 2048};

    /* JADX WARN: Code duplicated, block: B:47:0x0098  */
    /* JADX WARN: Code duplicated, block: B:49:0x009c  */
    public static zzabx zza(zzfo zzfoVar) {
        int i;
        int i2;
        int iZzd;
        int iZzd2 = zzfoVar.zzd(16);
        int iZzd3 = zzfoVar.zzd(16);
        if (iZzd3 == 65535) {
            iZzd3 = zzfoVar.zzd(24);
            i = 7;
        } else {
            i = 4;
        }
        int i3 = iZzd3 + i;
        if (iZzd2 == 44097) {
            i3 += 2;
        }
        int i4 = i3;
        int iZzd4 = zzfoVar.zzd(2);
        int i5 = 0;
        if (iZzd4 == 3) {
            int i6 = 0;
            while (true) {
                iZzd = i6 + zzfoVar.zzd(2);
                if (!zzfoVar.zzo()) {
                    break;
                }
                i6 = (iZzd + 1) << 2;
            }
            iZzd4 = iZzd + 3;
        }
        int i7 = iZzd4;
        int iZzd5 = zzfoVar.zzd(10);
        if (zzfoVar.zzo() && zzfoVar.zzd(3) > 0) {
            zzfoVar.zzm(2);
        }
        int i8 = true != zzfoVar.zzo() ? 44100 : 48000;
        int iZzd6 = zzfoVar.zzd(4);
        if (i8 == 44100 && iZzd6 == 13) {
            i2 = zzb[13];
        } else {
            if (i8 == 48000 && iZzd6 < 14) {
                i5 = zzb[iZzd6];
                int i9 = iZzd5 % 5;
                if (i9 == 1) {
                    if (iZzd6 != 3 || iZzd6 == 8) {
                        i5++;
                    }
                } else if (i9 != 2) {
                    if (i9 != 3) {
                        if (i9 == 4 && (iZzd6 == 3 || iZzd6 == 8 || iZzd6 == 11)) {
                            i5++;
                        }
                    } else if (iZzd6 != 3) {
                        i5++;
                    } else {
                        i5++;
                    }
                } else if (iZzd6 == 8 || iZzd6 == 11) {
                    i5++;
                }
            }
            i2 = i5;
        }
        return new zzabx(i7, 2, i8, i4, i2, null);
    }

    public static void zzb(int i, zzfp zzfpVar) {
        zzfpVar.zzH(7);
        byte[] bArrZzM = zzfpVar.zzM();
        bArrZzM[0] = -84;
        bArrZzM[1] = SignedBytes.MAX_POWER_OF_TWO;
        bArrZzM[2] = -1;
        bArrZzM[3] = -1;
        bArrZzM[4] = (byte) ((i >> 16) & 255);
        bArrZzM[5] = (byte) ((i >> 8) & 255);
        bArrZzM[6] = (byte) (i & 255);
    }
}
