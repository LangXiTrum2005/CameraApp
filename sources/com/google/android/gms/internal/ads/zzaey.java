package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaey extends zzacg {
    public zzaey(final zzadh zzadhVar, int i, long j, long j2) {
        long j3;
        Objects.requireNonNull(zzadhVar);
        zzacd zzacdVar = new zzacd() { // from class: com.google.android.gms.internal.ads.zzaev
            @Override // com.google.android.gms.internal.ads.zzacd
            public final long zza(long j4) {
                return zzadhVar.zzb(j4);
            }
        };
        zzaex zzaexVar = new zzaex(zzadhVar, i, null);
        long jZza = zzadhVar.zza();
        long j4 = zzadhVar.zzj;
        int i2 = zzadhVar.zzd;
        if (i2 > 0) {
            j3 = ((((long) i2) + ((long) zzadhVar.zzc)) / 2) + 1;
        } else {
            int i3 = zzadhVar.zza;
            long j5 = 4096;
            if (i3 == zzadhVar.zzb && i3 > 0) {
                j5 = i3;
            }
            j3 = (((j5 * ((long) zzadhVar.zzg)) * ((long) zzadhVar.zzh)) / 8) + 64;
        }
        super(zzacdVar, zzaexVar, jZza, 0L, j4, j, j2, j3, Math.max(6, zzadhVar.zzc));
    }
}
