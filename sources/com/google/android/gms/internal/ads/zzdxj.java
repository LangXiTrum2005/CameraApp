package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdxj {
    private Long zza;
    private final String zzb;
    private String zzc;
    private Integer zzd;
    private String zze;
    private Integer zzf;

    /* synthetic */ zzdxj(String str, zzdxi zzdxiVar) {
        this.zzb = str;
    }

    static /* bridge */ /* synthetic */ String zza(zzdxj zzdxjVar) {
        String str = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjI);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("objectId", zzdxjVar.zza);
            jSONObject.put("eventCategory", zzdxjVar.zzb);
            jSONObject.putOpt(NotificationCompat.CATEGORY_EVENT, zzdxjVar.zzc);
            jSONObject.putOpt("errorCode", zzdxjVar.zzd);
            jSONObject.putOpt("rewardType", zzdxjVar.zze);
            jSONObject.putOpt("rewardAmount", zzdxjVar.zzf);
        } catch (JSONException unused) {
            zzcec.zzj("Could not convert parameters to JSON.");
        }
        return str + "(\"h5adsEvent\"," + jSONObject.toString() + ");";
    }
}
