package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdmb implements zzhhd {
    private final zzdlz zza;

    public zzdmb(zzdlz zzdlzVar) {
        this.zza = zzdlzVar;
    }

    public final JSONObject zza() {
        JSONObject jSONObjectZzb = this.zza.zzb();
        zzhhl.zzb(jSONObjectZzb);
        return jSONObjectZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* synthetic */ Object zzb() {
        JSONObject jSONObjectZzb = this.zza.zzb();
        zzhhl.zzb(jSONObjectZzb);
        return jSONObjectZzb;
    }
}
