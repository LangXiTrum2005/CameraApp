package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.os.EnvironmentCompat;
import com.bumptech.glide.load.Key;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzebl {
    private final zzclg zza;
    private final Context zzb;
    private final zzcei zzc;
    private final zzfhh zzd;
    private final Executor zze;
    private final String zzf;
    private final zzfmz zzg;
    private final zzfhw zzh;
    private final zzdwa zzi;

    public zzebl(zzclg zzclgVar, Context context, zzcei zzceiVar, zzfhh zzfhhVar, Executor executor, String str, zzfmz zzfmzVar, zzdwa zzdwaVar) {
        this.zza = zzclgVar;
        this.zzb = context;
        this.zzc = zzceiVar;
        this.zzd = zzfhhVar;
        this.zze = executor;
        this.zzf = str;
        this.zzg = zzfmzVar;
        this.zzh = zzclgVar.zzw();
        this.zzi = zzdwaVar;
    }

    private final ListenableFuture zzc(final String str, final String str2) {
        zzfmo zzfmoVarZza = zzfmn.zza(this.zzb, 11);
        zzfmoVarZza.zzh();
        final zzbrn zzbrnVarZza = com.google.android.gms.ads.internal.zzt.zzf().zza(this.zzb, this.zzc, this.zza.zzz()).zza("google.afma.response.normalize", zzbru.zza, zzbru.zza);
        ListenableFuture listenableFutureZzn = zzgen.zzn(zzgen.zzn(zzgen.zzn(zzgen.zzh(""), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzebi
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) throws JSONException {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                String str3 = str;
                String str4 = str2;
                try {
                    jSONObject3.put("headers", new JSONObject());
                    jSONObject3.put("body", str3);
                    jSONObject2.put("base_url", "");
                    jSONObject2.put("signals", new JSONObject(str4));
                    jSONObject.put("request", jSONObject2);
                    jSONObject.put("response", jSONObject3);
                    jSONObject.put("flags", new JSONObject());
                    return zzgen.zzh(jSONObject);
                } catch (JSONException e) {
                    throw new JSONException("Preloaded loader: ".concat(String.valueOf(String.valueOf(e.getCause()))));
                }
            }
        }, this.zze), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzebj
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzbrnVarZza.zzb((JSONObject) obj);
            }
        }, this.zze), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzebk
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzb((JSONObject) obj);
            }
        }, this.zze);
        zzfmy.zza(listenableFutureZzn, this.zzg, zzfmoVarZza);
        return listenableFutureZzn;
    }

    private final String zzd(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("ad_types");
            if (jSONArray != null && EnvironmentCompat.MEDIA_UNKNOWN.equals(jSONArray.getString(0))) {
                jSONObject.put("ad_types", new JSONArray().put(this.zzf));
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            zzcec.zzj("Failed to update the ad types for rendering. ".concat(e.toString()));
            return str;
        }
    }

    private static final String zze(String str) {
        try {
            return new JSONObject(str).optString("request_id", "");
        } catch (JSONException unused) {
            return "";
        }
    }

    public final ListenableFuture zza() {
        Boolean bool;
        String strZzb = this.zzd.zzd.zzx;
        if (!TextUtils.isEmpty(strZzb)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgX)).booleanValue()) {
                String strZze = zze(strZzb);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhi)).booleanValue() && strZze.isEmpty()) {
                    int iLastIndexOf = strZzb.lastIndexOf("&request_id=");
                    strZze = iLastIndexOf != -1 ? strZzb.substring(iLastIndexOf + 12) : "";
                }
                if (TextUtils.isEmpty(strZze)) {
                    return zzgen.zzg(new zzeml(15, "Invalid ad string."));
                }
                String strZzb2 = this.zza.zzn().zzb(strZze, this.zzi);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhi)).booleanValue()) {
                    zzdwa zzdwaVar = this.zzi;
                    if (!TextUtils.isEmpty(strZzb2)) {
                        try {
                            bool = new JSONObject(strZzb2).optString("is_gbid").equals("true");
                        } catch (JSONException unused) {
                        }
                        if (bool.booleanValue()) {
                            int iLastIndexOf2 = strZzb.lastIndexOf("&");
                            String string = null;
                            String strSubstring = iLastIndexOf2 != -1 ? strZzb.substring(0, iLastIndexOf2) : null;
                            if (!TextUtils.isEmpty(strSubstring)) {
                                try {
                                    byte[] bArrDecode = Base64.decode(strSubstring, 11);
                                    byte[] bytes = strZze.getBytes(Key.STRING_CHARSET_NAME);
                                    try {
                                        string = new JSONObject(strZzb2).getString("arek");
                                    } catch (JSONException e) {
                                        com.google.android.gms.ads.internal.util.zze.zza("Failed to get key from QueryJSONMap".concat(e.toString()));
                                        com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "CryptoUtils.getKeyFromQueryJsonMap");
                                    }
                                    strZzb = zzfhw.zzb(bArrDecode, bytes, string, zzdwaVar);
                                } catch (UnsupportedEncodingException e2) {
                                    com.google.android.gms.ads.internal.util.zze.zza("Failed to decode the adResponse. ".concat(e2.toString()));
                                    com.google.android.gms.ads.internal.zzt.zzo().zzw(e2, "PreloadedLoader.decryptAdResponseIfNecessary");
                                }
                            }
                        }
                    }
                }
                if (!TextUtils.isEmpty(strZzb2)) {
                    return zzc(strZzb, zzd(strZzb2));
                }
            }
        }
        com.google.android.gms.ads.internal.client.zzc zzcVar = this.zzd.zzd.zzs;
        if (zzcVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgV)).booleanValue()) {
                String str = zzcVar.zza;
                String str2 = zzcVar.zzb;
                String strZze2 = zze(str);
                String strZze3 = zze(str2);
                if (TextUtils.isEmpty(strZze3) || !strZze2.equals(strZze3)) {
                    this.zzi.zza().put("ridmm", "true");
                } else {
                    this.zza.zzn().zzf(strZze2);
                    this.zzi.zza().put("rid", strZze2);
                }
            }
            return zzc(zzcVar.zza, zzd(zzcVar.zzb));
        }
        return zzgen.zzg(new zzeml(14, "Mismatch request IDs."));
    }

    final /* synthetic */ ListenableFuture zzb(JSONObject jSONObject) throws Exception {
        return zzgen.zzh(new zzfgy(new zzfgv(this.zzd), zzfgx.zza(new StringReader(jSONObject.toString()))));
    }
}
