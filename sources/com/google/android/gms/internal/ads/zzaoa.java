package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaoa implements zzacf {
    private final zzfw zza;
    private final zzfp zzb = new zzfp();
    private final int zzc;

    public zzaoa(int i, zzfw zzfwVar, int i2) {
        this.zzc = i;
        this.zza = zzfwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final zzace zza(zzacv zzacvVar, long j) throws IOException {
        int iZza;
        int iZza2;
        long jZzf = zzacvVar.zzf();
        int iMin = (int) Math.min(112800L, zzacvVar.zzd() - jZzf);
        this.zzb.zzH(iMin);
        ((zzack) zzacvVar).zzm(this.zzb.zzM(), 0, iMin, false);
        zzfp zzfpVar = this.zzb;
        int iZze = zzfpVar.zze();
        long j2 = -1;
        long j3 = -9223372036854775807L;
        long j4 = -1;
        while (zzfpVar.zzb() >= 188 && (iZza2 = (iZza = zzaom.zza(zzfpVar.zzM(), zzfpVar.zzd(), iZze)) + 188) <= iZze) {
            long jZzb = zzaom.zzb(zzfpVar, iZza, this.zzc);
            if (jZzb != -9223372036854775807L) {
                long jZzb2 = this.zza.zzb(jZzb);
                if (jZzb2 <= j) {
                    j4 = iZza;
                    if (100000 + jZzb2 <= j) {
                        j3 = jZzb2;
                    }
                } else if (j3 == -9223372036854775807L) {
                    return zzace.zzd(jZzb2, jZzf);
                }
                return zzace.zze(jZzf + j4);
            }
            zzfpVar.zzK(iZza2);
            j2 = iZza2;
        }
        return j3 != -9223372036854775807L ? zzace.zzf(j3, jZzf + j2) : zzace.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzacf
    public final void zzb() {
        byte[] bArr = zzfy.zzf;
        int length = bArr.length;
        this.zzb.zzI(bArr, 0);
    }
}
