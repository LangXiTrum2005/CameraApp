package com.google.android.gms.internal.ads;

import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdmg implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;

    public zzdmg(zzhhu zzhhuVar, zzhhu zzhhuVar2) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcei zzceiVarZza = ((zzcly) this.zza).zza();
        com.google.android.gms.ads.internal.zzt.zzp();
        return new zzaym(UUID.randomUUID().toString(), zzceiVarZza, "native", new JSONObject(), false, true);
    }
}
