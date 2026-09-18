package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdkg implements zzhhd {
    private final zzhhu zza;

    public zzdkg(zzhhu zzhhuVar) {
        this.zza = zzhhuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton = Collections.singleton(new zzdim((zzdkz) this.zza.zzb(), zzcep.zzf));
        zzhhl.zzb(setSingleton);
        return setSingleton;
    }
}
