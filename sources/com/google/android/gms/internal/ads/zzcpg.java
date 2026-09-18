package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcpg implements com.google.android.gms.ads.nonagon.signalgeneration.zzg {
    private final zzcnc zza;
    private zzdah zzb;
    private com.google.android.gms.ads.nonagon.signalgeneration.zzae zzc;

    /* synthetic */ zzcpg(zzcnc zzcncVar, zzcpf zzcpfVar) {
        this.zza = zzcncVar;
    }

    @Override // com.google.android.gms.ads.nonagon.signalgeneration.zzg
    public final /* synthetic */ com.google.android.gms.ads.nonagon.signalgeneration.zzg zza(zzdah zzdahVar) {
        this.zzb = zzdahVar;
        return this;
    }

    @Override // com.google.android.gms.ads.nonagon.signalgeneration.zzg
    public final /* synthetic */ com.google.android.gms.ads.nonagon.signalgeneration.zzg zzb(com.google.android.gms.ads.nonagon.signalgeneration.zzae zzaeVar) {
        this.zzc = zzaeVar;
        return this;
    }

    @Override // com.google.android.gms.ads.nonagon.signalgeneration.zzg
    public final com.google.android.gms.ads.nonagon.signalgeneration.zzh zzc() {
        zzhhl.zzc(this.zzb, zzdah.class);
        zzhhl.zzc(this.zzc, com.google.android.gms.ads.nonagon.signalgeneration.zzae.class);
        return new zzcpi(this.zza, this.zzc, new zzcxr(), new zzdwt(), this.zzb, null, null, null);
    }
}
