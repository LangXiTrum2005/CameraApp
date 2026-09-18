package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcze implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;

    public zzcze(zzhhu zzhhuVar, zzhhu zzhhuVar2) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcyk zzcykVar = (zzcyk) this.zza.zzb();
        zzgey zzgeyVar = zzcep.zza;
        zzhhl.zzb(zzgeyVar);
        zzgaf zzgafVarZzo = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfC)).booleanValue() ? zzgaf.zzo(new zzdim(zzcykVar, zzgeyVar)) : zzgaf.zzn();
        zzhhl.zzb(zzgafVarZzo);
        return zzgafVarZzo;
    }
}
