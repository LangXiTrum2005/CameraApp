package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.regex.Pattern;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaln {
    private static final Pattern zzd = Pattern.compile("\\s+");
    private static final zzgaf zze = zzgaf.zzp(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "none");
    private static final zzgaf zzf = zzgaf.zzq("dot", "sesame", "circle");
    private static final zzgaf zzg = zzgaf.zzp("filled", "open");
    private static final zzgaf zzh = zzgaf.zzq("after", "before", "outside");
    public final int zza;
    public final int zzb;
    public final int zzc;

    private zzaln(int i, int i2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004e  */
    public static zzaln zza(String str) {
        byte b;
        int i;
        if (str == null) {
            return null;
        }
        String strZza = zzfwk.zza(str.trim());
        if (strZza.isEmpty()) {
            return null;
        }
        zzgaf zzgafVarZzm = zzgaf.zzm(TextUtils.split(strZza, zzd));
        String str2 = (String) zzgag.zza(zzgca.zzb(zzh, zzgafVarZzm), "outside");
        int iHashCode = str2.hashCode();
        int i2 = -1;
        int i3 = 0;
        if (iHashCode != -1106037339) {
            if (iHashCode == 92734940 && str2.equals("after")) {
                b = 0;
            } else {
                b = -1;
            }
        } else if (str2.equals("outside")) {
            b = 1;
        } else {
            b = -1;
        }
        if (b != 0) {
            i = b != 1 ? 1 : -2;
        } else {
            i = 2;
        }
        zzgbz zzgbzVarZzb = zzgca.zzb(zze, zzgafVarZzm);
        if (zzgbzVarZzb.isEmpty()) {
            zzgbz zzgbzVarZzb2 = zzgca.zzb(zzg, zzgafVarZzm);
            zzgbz zzgbzVarZzb3 = zzgca.zzb(zzf, zzgafVarZzm);
            if (!zzgbzVarZzb2.isEmpty() || !zzgbzVarZzb3.isEmpty()) {
                String str3 = (String) zzgag.zza(zzgbzVarZzb2, "filled");
                int i4 = (str3.hashCode() == 3417674 && str3.equals("open")) ? 2 : 1;
                String str4 = (String) zzgag.zza(zzgbzVarZzb3, "circle");
                int iHashCode2 = str4.hashCode();
                if (iHashCode2 != -905816648) {
                    if (iHashCode2 == 99657 && str4.equals("dot")) {
                        i2 = 0;
                    }
                } else if (str4.equals("sesame")) {
                    i2 = 1;
                }
                if (i2 == 0) {
                    i2 = 2;
                } else if (i2 != 1) {
                    i3 = i4;
                    i2 = 1;
                } else {
                    i2 = 3;
                }
                i3 = i4;
            }
        } else {
            String str5 = (String) zzgbzVarZzb.iterator().next();
            if (str5.hashCode() == 3387192 && str5.equals("none")) {
                i2 = 0;
            }
        }
        return new zzaln(i2, i3, i);
    }
}
