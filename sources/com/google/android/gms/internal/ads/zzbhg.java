package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import org.json.JSONException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbhg extends QueryInfoGenerationCallback {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbhh zzb;

    zzbhg(zzbhh zzbhhVar, String str) {
        this.zza = str;
        this.zzb = zzbhhVar;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onFailure(String str) {
        zzcec.zzj("Failed to generate query info for Custom Tab error: ".concat(String.valueOf(str)));
        try {
            zzbhh zzbhhVar = this.zzb;
            zzbhhVar.zzd.postMessage(zzbhhVar.zzc(this.zza, str).toString(), null);
        } catch (JSONException e) {
            zzcec.zzh("Error creating PACT Error Response JSON: ", e);
        }
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onSuccess(QueryInfo queryInfo) {
        String query = queryInfo.getQuery();
        try {
            zzbhh zzbhhVar = this.zzb;
            zzbhhVar.zzd.postMessage(zzbhhVar.zzd(this.zza, query).toString(), null);
        } catch (JSONException e) {
            zzcec.zzh("Error creating PACT Signal Response JSON: ", e);
        }
    }
}
