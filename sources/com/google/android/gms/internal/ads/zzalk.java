package com.google.android.gms.internal.ads;

import android.graphics.Color;
import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzalk {
    public final String zza;
    public final int zzb;
    public final Integer zzc;
    public final Integer zzd;
    public final float zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final int zzj;

    private zzalk(String str, int i, Integer num, Integer num2, float f, boolean z, boolean z2, boolean z3, boolean z4, int i2) {
        this.zza = str;
        this.zzb = i;
        this.zzc = num;
        this.zzd = num2;
        this.zze = f;
        this.zzf = z;
        this.zzg = z2;
        this.zzh = z3;
        this.zzi = z4;
        this.zzj = i2;
    }

    public static zzalk zzb(String str, zzali zzaliVar) {
        int i;
        zzek.zzd(str.startsWith("Style:"));
        String[] strArrSplit = TextUtils.split(str.substring(6), ",");
        int length = strArrSplit.length;
        int i2 = zzaliVar.zzk;
        if (length != i2) {
            zzff.zzf("SsaStyle", String.format(Locale.US, "Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(i2), Integer.valueOf(length), str));
            return null;
        }
        try {
            String strTrim = strArrSplit[zzaliVar.zza].trim();
            int i3 = zzaliVar.zzb;
            int iZzd = i3 != -1 ? zzd(strArrSplit[i3].trim()) : -1;
            int i4 = zzaliVar.zzc;
            Integer numZzc = i4 != -1 ? zzc(strArrSplit[i4].trim()) : null;
            int i5 = zzaliVar.zzd;
            Integer numZzc2 = i5 != -1 ? zzc(strArrSplit[i5].trim()) : null;
            int i6 = zzaliVar.zze;
            float f = -3.4028235E38f;
            if (i6 != -1) {
                String strTrim2 = strArrSplit[i6].trim();
                try {
                    f = Float.parseFloat(strTrim2);
                } catch (NumberFormatException e) {
                    zzff.zzg("SsaStyle", "Failed to parse font size: '" + strTrim2 + "'", e);
                }
            }
            int i7 = zzaliVar.zzf;
            boolean z = i7 != -1 && zze(strArrSplit[i7].trim());
            int i8 = zzaliVar.zzg;
            boolean z2 = i8 != -1 && zze(strArrSplit[i8].trim());
            int i9 = zzaliVar.zzh;
            boolean z3 = i9 != -1 && zze(strArrSplit[i9].trim());
            int i10 = zzaliVar.zzi;
            boolean z4 = i10 != -1 && zze(strArrSplit[i10].trim());
            int i11 = zzaliVar.zzj;
            if (i11 != -1) {
                String strTrim3 = strArrSplit[i11].trim();
                try {
                    int i12 = Integer.parseInt(strTrim3.trim());
                    if (i12 == 1 || i12 == 3) {
                        i = i12;
                    } else {
                        zzff.zzf("SsaStyle", "Ignoring unknown BorderStyle: ".concat(String.valueOf(strTrim3)));
                        i = -1;
                    }
                } catch (NumberFormatException unused) {
                }
            } else {
                i = -1;
            }
            return new zzalk(strTrim, iZzd, numZzc, numZzc2, f, z, z2, z3, z4, i);
        } catch (RuntimeException e2) {
            zzff.zzg("SsaStyle", "Skipping malformed 'Style:' line: '" + str + "'", e2);
            return null;
        }
    }

    public static Integer zzc(String str) {
        try {
            long j = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            zzek.zzd(j <= 4294967295L);
            return Integer.valueOf(Color.argb(zzgcu.zza(((j >> 24) & 255) ^ 255), zzgcu.zza(j & 255), zzgcu.zza((j >> 8) & 255), zzgcu.zza((j >> 16) & 255)));
        } catch (IllegalArgumentException e) {
            zzff.zzg("SsaStyle", "Failed to parse color expression: '" + str + "'", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzd(String str) {
        try {
            int i = Integer.parseInt(str.trim());
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    return i;
                default:
                    zzff.zzf("SsaStyle", "Ignoring unknown alignment: ".concat(String.valueOf(str)));
                    return -1;
            }
        } catch (NumberFormatException unused) {
        }
    }

    private static boolean zze(String str) {
        try {
            int i = Integer.parseInt(str);
            return i == 1 || i == -1;
        } catch (NumberFormatException e) {
            zzff.zzg("SsaStyle", "Failed to parse boolean value: '" + str + "'", e);
            return false;
        }
    }
}
