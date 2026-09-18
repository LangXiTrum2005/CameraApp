package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzbqb {
    public static void zza(zzbqc zzbqcVar, String str, Map map) {
        try {
            zzbqcVar.zze(str, com.google.android.gms.ads.internal.client.zzay.zzb().zzi(map));
        } catch (JSONException unused) {
            zzcec.zzj("Could not convert parameters to JSON.");
        }
    }

    public static void zzb(zzbqc zzbqcVar, String str, JSONObject jSONObject) {
        String string = jSONObject.toString();
        StringBuilder sb = new StringBuilder("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("',");
        sb.append(string);
        sb.append(");");
        zzcec.zze("Dispatching AFMA event: ".concat(sb.toString()));
        zzbqcVar.zza(sb.toString());
    }

    public static void zzc(zzbqc zzbqcVar, String str, String str2) {
        zzbqcVar.zza(str + "(" + str2 + ");");
    }

    public static void zzd(zzbqc zzbqcVar, String str, JSONObject jSONObject) {
        zzbqcVar.zzb(str, jSONObject.toString());
    }
}
