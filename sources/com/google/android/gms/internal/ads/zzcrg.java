package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcrg implements zzcqw {
    private final zzdzd zza;

    zzcrg(zzdzd zzdzdVar) {
        this.zza = zzdzdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcqw
    public final void zza(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjd)).booleanValue()) {
                this.zza.zzm(jSONObject);
            }
        }
    }
}
