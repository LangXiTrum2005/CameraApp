package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzacr {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] zzc = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] zzd = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static zzam zza(byte[] bArr, String str, String str2, zzae zzaeVar) {
        zzfo zzfoVar;
        if (bArr[0] == 127) {
            zzfoVar = new zzfo(bArr, bArr.length);
        } else {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            byte b = bArrCopyOf[0];
            if (b == -2 || b == -1) {
                for (int i = 0; i < bArrCopyOf.length - 1; i += 2) {
                    byte b2 = bArrCopyOf[i];
                    int i2 = i + 1;
                    bArrCopyOf[i] = bArrCopyOf[i2];
                    bArrCopyOf[i2] = b2;
                }
            }
            int length = bArrCopyOf.length;
            zzfoVar = new zzfo(bArrCopyOf, length);
            if (bArrCopyOf[0] == 31) {
                zzfo zzfoVar2 = new zzfo(bArrCopyOf, length);
                while (zzfoVar2.zza() >= 16) {
                    zzfoVar2.zzm(2);
                    zzfoVar.zzf(zzfoVar2.zzd(14), 14);
                }
            }
            zzfoVar.zzj(bArrCopyOf, bArrCopyOf.length);
        }
        zzfoVar.zzm(60);
        int i3 = zzb[zzfoVar.zzd(6)];
        int i4 = zzc[zzfoVar.zzd(4)];
        int iZzd = zzfoVar.zzd(5);
        int i5 = iZzd < 29 ? (zzd[iZzd] * 1000) / 2 : -1;
        zzfoVar.zzm(10);
        int i6 = i3 + (zzfoVar.zzd(2) > 0 ? 1 : 0);
        zzak zzakVar = new zzak();
        zzakVar.zzK(str);
        zzakVar.zzW("audio/vnd.dts");
        zzakVar.zzx(i5);
        zzakVar.zzy(i6);
        zzakVar.zzX(i4);
        zzakVar.zzE(null);
        zzakVar.zzN(str2);
        return zzakVar.zzac();
    }
}
