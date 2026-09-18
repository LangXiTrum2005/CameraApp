package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzach {
    public static void zza(long j, zzfp zzfpVar, zzaea[] zzaeaVarArr) {
        int iZzg;
        while (true) {
            if (zzfpVar.zzb() <= 1) {
                return;
            }
            int iZzc = zzc(zzfpVar);
            int iZzc2 = zzc(zzfpVar);
            int iZzd = zzfpVar.zzd() + iZzc2;
            if (iZzc2 == -1 || iZzc2 > zzfpVar.zzb()) {
                zzff.zzf("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                iZzd = zzfpVar.zze();
            } else if (iZzc == 4 && iZzc2 >= 8) {
                int iZzm = zzfpVar.zzm();
                int iZzq = zzfpVar.zzq();
                if (iZzq == 49) {
                    iZzg = zzfpVar.zzg();
                    iZzq = 49;
                } else {
                    iZzg = 0;
                }
                int iZzm2 = zzfpVar.zzm();
                if (iZzq == 47) {
                    zzfpVar.zzL(1);
                    iZzq = 47;
                }
                boolean z = iZzm == 181 && (iZzq == 49 || iZzq == 47) && iZzm2 == 3;
                if (iZzq == 49) {
                    z &= iZzg == 1195456820;
                }
                if (z) {
                    zzb(j, zzfpVar, zzaeaVarArr);
                }
            }
            zzfpVar.zzK(iZzd);
        }
    }

    public static void zzb(long j, zzfp zzfpVar, zzaea[] zzaeaVarArr) {
        int iZzm = zzfpVar.zzm();
        if ((iZzm & 64) != 0) {
            int i = iZzm & 31;
            zzfpVar.zzL(1);
            int iZzd = zzfpVar.zzd();
            for (zzaea zzaeaVar : zzaeaVarArr) {
                int i2 = i * 3;
                zzfpVar.zzK(iZzd);
                zzaeaVar.zzr(zzfpVar, i2);
                zzek.zzf(j != -9223372036854775807L);
                zzaeaVar.zzt(j, 1, i2, 0, null);
            }
        }
    }

    private static int zzc(zzfp zzfpVar) {
        int i = 0;
        while (zzfpVar.zzb() != 0) {
            int iZzm = zzfpVar.zzm();
            i += iZzm;
            if (iZzm != 255) {
                return i;
            }
        }
        return -1;
    }
}
