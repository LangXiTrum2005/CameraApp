package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdpq {
    private final zzgey zza;
    private final zzdqd zzb;
    private final zzdqi zzc;

    public zzdpq(zzgey zzgeyVar, zzdqd zzdqdVar, zzdqi zzdqiVar) {
        this.zza = zzgeyVar;
        this.zzb = zzdqdVar;
        this.zzc = zzdqiVar;
    }

    public final ListenableFuture zza(final zzfgy zzfgyVar, final zzfgm zzfgmVar, final JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        ListenableFuture listenableFutureZzn;
        final ListenableFuture listenableFutureZzb = this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdpo
            @Override // java.util.concurrent.Callable
            public final Object call() throws zzeml {
                zzdna zzdnaVar = new zzdna();
                JSONObject jSONObject2 = jSONObject;
                zzdnaVar.zzaa(jSONObject2.optInt("template_id", -1));
                zzdnaVar.zzK(jSONObject2.optString("custom_template_id"));
                JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("omid_settings");
                String strOptString = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("omid_partner_name") : null;
                zzfgy zzfgyVar2 = zzfgyVar;
                zzdnaVar.zzV(strOptString);
                zzfhh zzfhhVar = zzfgyVar2.zza.zza;
                if (!zzfhhVar.zzg.contains(Integer.toString(zzdnaVar.zzc()))) {
                    throw new zzeml(1, "Invalid template ID: " + zzdnaVar.zzc());
                }
                if (zzdnaVar.zzc() == 3) {
                    if (zzdnaVar.zzA() == null) {
                        throw new zzeml(1, "No custom template id for custom template ad response.");
                    }
                    if (!zzfhhVar.zzh.contains(zzdnaVar.zzA())) {
                        throw new zzeml(1, "Unexpected custom template id in the response.");
                    }
                }
                zzfgm zzfgmVar2 = zzfgmVar;
                zzdnaVar.zzY(jSONObject2.optDouble("rating", -1.0d));
                String strOptString2 = jSONObject2.optString("headline", null);
                if (zzfgmVar2.zzN) {
                    com.google.android.gms.ads.internal.zzt.zzp();
                    strOptString2 = com.google.android.gms.ads.internal.util.zzt.zzx() + " : " + strOptString2;
                }
                zzdnaVar.zzZ("headline", strOptString2);
                zzdnaVar.zzZ("body", jSONObject2.optString("body", null));
                zzdnaVar.zzZ("call_to_action", jSONObject2.optString("call_to_action", null));
                zzdnaVar.zzZ("store", jSONObject2.optString("store", null));
                zzdnaVar.zzZ(FirebaseAnalytics.Param.PRICE, jSONObject2.optString(FirebaseAnalytics.Param.PRICE, null));
                zzdnaVar.zzZ("advertiser", jSONObject2.optString("advertiser", null));
                return zzdnaVar;
            }
        });
        final ListenableFuture listenableFutureZzf = this.zzb.zzf(jSONObject, "images");
        zzfgp zzfgpVar = zzfgyVar.zzb.zzb;
        zzdqd zzdqdVar = this.zzb;
        final ListenableFuture listenableFutureZzg = zzdqdVar.zzg(jSONObject, "images", zzfgmVar, zzfgpVar);
        final ListenableFuture listenableFutureZze = zzdqdVar.zze(jSONObject, "secondary_image");
        final ListenableFuture listenableFutureZze2 = zzdqdVar.zze(jSONObject, "app_icon");
        final ListenableFuture listenableFutureZzd = zzdqdVar.zzd(jSONObject, "attribution");
        final ListenableFuture listenableFutureZzh = this.zzb.zzh(jSONObject, zzfgmVar, zzfgyVar.zzb.zzb);
        final ListenableFuture listenableFutureZza = this.zzc.zza(jSONObject, "custom_assets");
        if (jSONObject.optBoolean("enable_omid") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("omid_settings")) != null) {
            final String strOptString = jSONObjectOptJSONObject.optString("omid_html");
            if (TextUtils.isEmpty(strOptString)) {
                listenableFutureZzn = zzgen.zzh(null);
            } else {
                final zzdqd zzdqdVar2 = this.zzb;
                listenableFutureZzn = zzgen.zzn(zzgen.zzh(null), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzdps
                    @Override // com.google.android.gms.internal.ads.zzgdu
                    public final ListenableFuture zza(Object obj) {
                        return zzdqdVar2.zzc(strOptString, obj);
                    }
                }, zzcep.zze);
            }
        } else {
            listenableFutureZzn = zzgen.zzh(null);
        }
        final ListenableFuture listenableFuture = listenableFutureZzn;
        ArrayList arrayList = new ArrayList();
        arrayList.add(listenableFutureZzb);
        arrayList.add(listenableFutureZzf);
        arrayList.add(listenableFutureZzg);
        arrayList.add(listenableFutureZze);
        arrayList.add(listenableFutureZze2);
        arrayList.add(listenableFutureZzd);
        arrayList.add(listenableFutureZzh);
        arrayList.add(listenableFutureZza);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfa)).booleanValue()) {
            arrayList.add(listenableFuture);
        }
        return zzgen.zza(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdpp
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdna zzdnaVar = (zzdna) listenableFutureZzb.get();
                zzdnaVar.zzP((List) listenableFutureZzf.get());
                zzdnaVar.zzM((zzbjm) listenableFutureZze2.get());
                zzdnaVar.zzQ((zzbjm) listenableFutureZze.get());
                zzdnaVar.zzJ((zzbjf) listenableFutureZzd.get());
                JSONObject jSONObject2 = jSONObject;
                zzdnaVar.zzS(zzdqd.zzj(jSONObject2));
                zzdnaVar.zzL(zzdqd.zzi(jSONObject2));
                zzcjk zzcjkVar = (zzcjk) listenableFutureZzh.get();
                if (zzcjkVar != null) {
                    zzdnaVar.zzad(zzcjkVar);
                    zzdnaVar.zzac(zzcjkVar.zzF());
                    zzdnaVar.zzab(zzcjkVar.zzq());
                }
                zzcjk zzcjkVar2 = (zzcjk) listenableFutureZzg.get();
                if (zzcjkVar2 != null) {
                    zzdnaVar.zzO(zzcjkVar2);
                    zzdnaVar.zzae(zzcjkVar2.zzF());
                }
                ListenableFuture listenableFuture2 = listenableFuture;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfa)).booleanValue()) {
                    zzdnaVar.zzU(listenableFuture2);
                    zzdnaVar.zzX(new zzceu());
                } else {
                    zzcjk zzcjkVar3 = (zzcjk) listenableFuture2.get();
                    if (zzcjkVar3 != null) {
                        zzdnaVar.zzT(zzcjkVar3);
                    }
                }
                for (zzdqh zzdqhVar : (List) listenableFutureZza.get()) {
                    if (zzdqhVar.zza != 1) {
                        zzdnaVar.zzN(zzdqhVar.zzb, zzdqhVar.zzd);
                    } else {
                        zzdnaVar.zzZ(zzdqhVar.zzb, zzdqhVar.zzc);
                    }
                }
                return zzdnaVar;
            }
        }, this.zza);
    }
}
