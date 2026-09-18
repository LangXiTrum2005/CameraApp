package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaek implements zzadu {
    final /* synthetic */ zzaen zza;
    private final long zzb;

    public zzaek(zzaen zzaenVar, long j) {
        this.zza = zzaenVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j) {
        zzads zzadsVarZza = this.zza.zzg[0].zza(j);
        int i = 1;
        while (true) {
            zzaen zzaenVar = this.zza;
            if (i >= zzaenVar.zzg.length) {
                return zzadsVarZza;
            }
            zzads zzadsVarZza2 = zzaenVar.zzg[i].zza(j);
            if (zzadsVarZza2.zza.zzc < zzadsVarZza.zza.zzc) {
                zzadsVarZza = zzadsVarZza2;
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return true;
    }
}
