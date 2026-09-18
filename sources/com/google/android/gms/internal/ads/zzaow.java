package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaow implements zzadu {
    private final zzaot zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;

    public zzaow(zzaot zzaotVar, int i, long j, long j2) {
        this.zza = zzaotVar;
        this.zzb = i;
        this.zzc = j;
        long j3 = (j2 - j) / ((long) zzaotVar.zzd);
        this.zzd = j3;
        this.zze = zzb(j3);
    }

    private final long zzb(long j) {
        return zzfy.zzs(j * ((long) this.zzb), 1000000L, this.zza.zzc, RoundingMode.FLOOR);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j) {
        long jMax = Math.max(0L, Math.min((((long) this.zza.zzc) * j) / (((long) this.zzb) * 1000000), this.zzd - 1));
        long j2 = ((long) this.zza.zzd) * jMax;
        long jZzb = zzb(jMax);
        zzadv zzadvVar = new zzadv(jZzb, this.zzc + j2);
        if (jZzb >= j || jMax == this.zzd - 1) {
            return new zzads(zzadvVar, zzadvVar);
        }
        long j3 = jMax + 1;
        return new zzads(zzadvVar, new zzadv(zzb(j3), this.zzc + (j3 * ((long) this.zza.zzd))));
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return true;
    }
}
