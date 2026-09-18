package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdll implements zzhhd {
    private final zzhhu zza;

    public zzdll(zzhhu zzhhuVar) {
        this.zza = zzhhuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton = ((zzdli) this.zza).zza().zze() != null ? Collections.singleton("banner") : Collections.emptySet();
        zzhhl.zzb(setSingleton);
        return setSingleton;
    }
}
