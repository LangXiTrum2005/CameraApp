package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcvz {
    private final zzddm zza;
    private final zzdft zzb;

    public zzcvz(zzddm zzddmVar, zzdft zzdftVar) {
        this.zza = zzddmVar;
        this.zzb = zzdftVar;
    }

    public final zzddm zza() {
        return this.zza;
    }

    final zzdft zzb() {
        return this.zzb;
    }

    final zzdim zzc() {
        zzdft zzdftVar = this.zzb;
        return zzdftVar != null ? new zzdim(zzdftVar, zzcep.zzf) : new zzdim(new zzcvy(this), zzcep.zzf);
    }
}
