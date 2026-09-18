package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzduu implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;

    public zzduu(zzhhu zzhhuVar, zzhhu zzhhuVar2) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgey zzgeyVar = zzcep.zza;
        zzhhl.zzb(zzgeyVar);
        Set setSingleton = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeO)).booleanValue() ? Collections.singleton(new zzdim(((zzdvn) this.zzb).zzb(), zzgeyVar)) : Collections.emptySet();
        zzhhl.zzb(setSingleton);
        return setSingleton;
    }
}
