package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcog implements zzdxh {
    private final Long zza;
    private final String zzb;
    private final zzcnc zzc;
    private final zzcok zzd;
    private final zzcog zze = this;

    /* synthetic */ zzcog(zzcnc zzcncVar, zzcok zzcokVar, Long l, String str, zzcof zzcofVar) {
        this.zzc = zzcncVar;
        this.zzd = zzcokVar;
        this.zza = l;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdxh
    public final zzdxr zza() {
        zzcok zzcokVar = this.zzd;
        return zzdxs.zza(this.zza.longValue(), zzcokVar.zza, zzdxl.zzc(zzcokVar.zzb), this.zzc, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzdxh
    public final zzdxv zzb() {
        zzcok zzcokVar = this.zzd;
        return zzdxw.zza(this.zza.longValue(), zzcokVar.zza, zzdxl.zzc(zzcokVar.zzb), this.zzc, this.zzb);
    }
}
