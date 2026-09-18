package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzade {
    public static zzadg zzb(zzfp zzfpVar) {
        zzfpVar.zzL(1);
        int iZzo = zzfpVar.zzo();
        long jZzd = zzfpVar.zzd();
        long j = iZzo;
        int i = iZzo / 18;
        long[] jArrCopyOf = new long[i];
        long[] jArrCopyOf2 = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            long jZzt = zzfpVar.zzt();
            if (jZzt == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i2);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i2);
                break;
            }
            jArrCopyOf[i2] = jZzt;
            jArrCopyOf2[i2] = zzfpVar.zzt();
            zzfpVar.zzL(2);
        }
        zzfpVar.zzL((int) ((jZzd + j) - ((long) zzfpVar.zzd())));
        return new zzadg(jArrCopyOf, jArrCopyOf2);
    }

    public static zzby zza(zzacv zzacvVar, boolean z) throws IOException {
        zzby zzbyVarZza = new zzadm().zza(zzacvVar, z ? null : zzagq.zza);
        if (zzbyVarZza == null || zzbyVarZza.zza() == 0) {
            return null;
        }
        return zzbyVarZza;
    }
}
