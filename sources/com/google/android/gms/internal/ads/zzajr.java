package com.google.android.gms.internal.ads;

import java.math.BigInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzajr implements zzadu {
    final /* synthetic */ zzajs zza;

    /* synthetic */ zzajr(zzajs zzajsVar, zzajq zzajqVar) {
        this.zza = zzajsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        zzajs zzajsVar = this.zza;
        return zzajsVar.zzd.zzf(zzajsVar.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j) {
        zzajs zzajsVar = this.zza;
        long jZzg = zzajsVar.zzd.zzg(j);
        long j2 = zzajsVar.zzb;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(jZzg);
        zzajs zzajsVar2 = this.zza;
        long jLongValue = j2 + bigIntegerValueOf.multiply(BigInteger.valueOf(zzajsVar2.zzc - zzajsVar2.zzb)).divide(BigInteger.valueOf(this.zza.zzf)).longValue();
        zzajs zzajsVar3 = this.zza;
        zzadv zzadvVar = new zzadv(j, Math.max(zzajsVar3.zzb, Math.min(jLongValue - 30000, zzajsVar3.zzc - 1)));
        return new zzads(zzadvVar, zzadvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return true;
    }
}
