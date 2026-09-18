package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaov {
    public static Pair zza(zzacv zzacvVar) throws IOException {
        zzacvVar.zzj();
        zzaou zzaouVarZzd = zzd(1684108385, zzacvVar, new zzfp(8));
        ((zzack) zzacvVar).zzo(8, false);
        return Pair.create(Long.valueOf(zzacvVar.zzf()), Long.valueOf(zzaouVarZzd.zzb));
    }

    public static zzaot zzb(zzacv zzacvVar) throws IOException {
        byte[] bArr;
        zzfp zzfpVar = new zzfp(16);
        zzaou zzaouVarZzd = zzd(1718449184, zzacvVar, zzfpVar);
        zzek.zzf(zzaouVarZzd.zzb >= 16);
        zzack zzackVar = (zzack) zzacvVar;
        zzackVar.zzm(zzfpVar.zzM(), 0, 16, false);
        zzfpVar.zzK(0);
        int iZzk = zzfpVar.zzk();
        int iZzk2 = zzfpVar.zzk();
        int iZzj = zzfpVar.zzj();
        int iZzj2 = zzfpVar.zzj();
        int iZzk3 = zzfpVar.zzk();
        int iZzk4 = zzfpVar.zzk();
        int i = ((int) zzaouVarZzd.zzb) - 16;
        if (i > 0) {
            byte[] bArr2 = new byte[i];
            zzackVar.zzm(bArr2, 0, i, false);
            bArr = bArr2;
        } else {
            bArr = zzfy.zzf;
        }
        zzackVar.zzo((int) (zzacvVar.zze() - zzacvVar.zzf()), false);
        return new zzaot(iZzk, iZzk2, iZzj, iZzj2, iZzk3, iZzk4, bArr);
    }

    public static boolean zzc(zzacv zzacvVar) throws IOException {
        zzfp zzfpVar = new zzfp(8);
        int i = zzaou.zza(zzacvVar, zzfpVar).zza;
        if (i != 1380533830 && i != 1380333108) {
            return false;
        }
        ((zzack) zzacvVar).zzm(zzfpVar.zzM(), 0, 4, false);
        zzfpVar.zzK(0);
        int iZzg = zzfpVar.zzg();
        if (iZzg == 1463899717) {
            return true;
        }
        zzff.zzc("WavHeaderReader", "Unsupported form type: " + iZzg);
        return false;
    }

    private static zzaou zzd(int i, zzacv zzacvVar, zzfp zzfpVar) throws IOException {
        zzaou zzaouVarZza = zzaou.zza(zzacvVar, zzfpVar);
        while (true) {
            int i2 = zzaouVarZza.zza;
            if (i2 == i) {
                return zzaouVarZza;
            }
            zzff.zzf("WavHeaderReader", "Ignoring unknown WAV chunk: " + i2);
            long j = zzaouVarZza.zzb + 8;
            if (j > 2147483647L) {
                throw zzcc.zzc("Chunk is too large (~2GB+) to skip; id: " + zzaouVarZza.zza);
            }
            ((zzack) zzacvVar).zzo((int) j, false);
            zzaouVarZza = zzaou.zza(zzacvVar, zzfpVar);
        }
    }
}
