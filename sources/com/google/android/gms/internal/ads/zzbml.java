package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbml implements zzbng {
    zzbml() {
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObjectZza;
        zzcjk zzcjkVar = (zzcjk) obj;
        zzbja zzbjaVarZzK = zzcjkVar.zzK();
        if (zzbjaVarZzK == null || (jSONObjectZza = zzbjaVarZzK.zza()) == null) {
            zzcjkVar.zze("nativeAdViewSignalsReady", new JSONObject());
        } else {
            zzcjkVar.zze("nativeAdViewSignalsReady", jSONObjectZza);
        }
    }
}
