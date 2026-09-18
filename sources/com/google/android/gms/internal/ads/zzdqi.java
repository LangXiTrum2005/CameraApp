package com.google.android.gms.internal.ads;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdqi {
    private final Executor zza;
    private final zzdqd zzb;

    public zzdqi(Executor executor, zzdqd zzdqdVar) {
        this.zza = executor;
        this.zzb = zzdqdVar;
    }

    public final ListenableFuture zza(JSONObject jSONObject, String str) {
        ListenableFuture listenableFutureZzh;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("custom_assets");
        if (jSONArrayOptJSONArray == null) {
            return zzgen.zzh(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArrayOptJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject == null) {
                listenableFutureZzh = zzgen.zzh(null);
            } else {
                final String strOptString = jSONObjectOptJSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.NAME);
                if (strOptString == null) {
                    listenableFutureZzh = zzgen.zzh(null);
                } else {
                    String strOptString2 = jSONObjectOptJSONObject.optString("type");
                    listenableFutureZzh = TypedValues.Custom.S_STRING.equals(strOptString2) ? zzgen.zzh(new zzdqh(strOptString, jSONObjectOptJSONObject.optString("string_value"))) : "image".equals(strOptString2) ? zzgen.zzm(this.zzb.zze(jSONObjectOptJSONObject, "image_value"), new zzfws() { // from class: com.google.android.gms.internal.ads.zzdqf
                        @Override // com.google.android.gms.internal.ads.zzfws
                        public final Object apply(Object obj) {
                            return new zzdqh(strOptString, (zzbiz) obj);
                        }
                    }, this.zza) : zzgen.zzh(null);
                }
            }
            arrayList.add(listenableFutureZzh);
        }
        return zzgen.zzm(zzgen.zzd(arrayList), new zzfws() { // from class: com.google.android.gms.internal.ads.zzdqg
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                ArrayList arrayList2 = new ArrayList();
                for (zzdqh zzdqhVar : (List) obj) {
                    if (zzdqhVar != null) {
                        arrayList2.add(zzdqhVar);
                    }
                }
                return arrayList2;
            }
        }, this.zza);
    }
}
