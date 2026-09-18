package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzblv implements zzbng {
    private final zzblw zza;

    public zzblv(zzblw zzblwVar) {
        this.zza = zzblwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final void zza(Object obj, Map map) {
        if (this.zza == null) {
            return;
        }
        String str = (String) map.get(AppMeasurementSdk.ConditionalUserProperty.NAME);
        if (str == null) {
            zzcec.zzi("Ad metadata with no name parameter.");
            str = "";
        }
        Bundle bundleZza = null;
        if (map.containsKey("info")) {
            try {
                bundleZza = com.google.android.gms.ads.internal.util.zzbw.zza(new JSONObject((String) map.get("info")));
            } catch (JSONException e) {
                zzcec.zzh("Failed to convert ad metadata to JSON.", e);
            }
        }
        if (bundleZza == null) {
            zzcec.zzg("Failed to convert ad metadata to Bundle.");
        } else {
            this.zza.zza(str, bundleZza);
        }
    }
}
