package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzabs {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] zzc = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static zzabr zza(byte[] bArr) throws zzcc {
        return zzb(new zzfo(bArr, bArr.length), false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ae, code lost:
    
        if (r11 != 3) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzabr zzb(com.google.android.gms.internal.ads.zzfo r11, boolean r12) throws com.google.android.gms.internal.ads.zzcc {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabs.zzb(com.google.android.gms.internal.ads.zzfo, boolean):com.google.android.gms.internal.ads.zzabr");
    }

    private static int zzc(zzfo zzfoVar) {
        int iZzd = zzfoVar.zzd(5);
        return iZzd == 31 ? zzfoVar.zzd(6) + 32 : iZzd;
    }

    private static int zzd(zzfo zzfoVar) throws zzcc {
        int iZzd = zzfoVar.zzd(4);
        if (iZzd == 15) {
            if (zzfoVar.zza() >= 24) {
                return zzfoVar.zzd(24);
            }
            throw zzcc.zza("AAC header insufficient data", null);
        }
        if (iZzd < 13) {
            return zzb[iZzd];
        }
        throw zzcc.zza("AAC header wrong Sampling Frequency Index", null);
    }
}
