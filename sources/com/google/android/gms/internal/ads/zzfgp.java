package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfgp {
    public final List zza;
    public final String zzb;
    public final int zzc;
    public final String zzd;
    public final int zze;
    public final long zzf;
    public final boolean zzg;
    public final String zzh;
    public final zzfgo zzi;
    public final Bundle zzj;
    public final String zzk;
    public final String zzl;
    public final String zzm;
    public final JSONObject zzn;
    public final String zzo;
    public final int zzp;

    zzfgp(JsonReader jsonReader) throws IllegalStateException, JSONException, IOException, NumberFormatException {
        List listEmptyList = Collections.emptyList();
        Bundle bundle = new Bundle();
        JSONObject jSONObject = new JSONObject();
        jsonReader.beginObject();
        String strNextString = "";
        String strNextString2 = "";
        String strNextString3 = strNextString2;
        String strNextString4 = strNextString3;
        String strNextString5 = strNextString4;
        boolean zNextBoolean = false;
        int iNextInt = 0;
        int iNextInt2 = 0;
        zzfgo zzfgoVar = null;
        long jNextLong = 0;
        int iMax = 1;
        String strNextString6 = strNextString5;
        String strNextString7 = strNextString6;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            String str = strNextString5;
            if ("nofill_urls".equals(strNextName)) {
                listEmptyList = com.google.android.gms.ads.internal.util.zzbw.zzd(jsonReader);
            } else if ("refresh_interval".equals(strNextName)) {
                iNextInt = jsonReader.nextInt();
            } else if ("gws_query_id".equals(strNextName)) {
                strNextString = jsonReader.nextString();
            } else if ("analytics_query_ad_event_id".equals(strNextName)) {
                strNextString6 = jsonReader.nextString();
            } else if ("is_idless".equals(strNextName)) {
                zNextBoolean = jsonReader.nextBoolean();
            } else if ("response_code".equals(strNextName)) {
                iNextInt2 = jsonReader.nextInt();
            } else if ("latency".equals(strNextName)) {
                jNextLong = jsonReader.nextLong();
            } else {
                JSONObject jSONObject2 = jSONObject;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzig)).booleanValue() && "public_error".equals(strNextName) && jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                    zzfgoVar = new zzfgo(jsonReader);
                } else if ("bidding_data".equals(strNextName)) {
                    strNextString7 = jsonReader.nextString();
                } else {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjU)).booleanValue() && Objects.equals(strNextName, "topics_should_record_observation")) {
                        jsonReader.nextBoolean();
                    } else {
                        if ("adapter_response_replacement_key".equals(strNextName)) {
                            strNextString5 = jsonReader.nextString();
                        } else if ("response_info_extras".equals(strNextName)) {
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgQ)).booleanValue()) {
                                try {
                                    Bundle bundleZza = com.google.android.gms.ads.internal.util.zzbw.zza(com.google.android.gms.ads.internal.util.zzbw.zzh(jsonReader));
                                    if (bundleZza != null) {
                                        bundle = bundleZza;
                                    }
                                } catch (IOException | JSONException unused) {
                                    strNextString5 = str;
                                    jSONObject = jSONObject2;
                                } catch (IllegalStateException unused2) {
                                    jsonReader.skipValue();
                                    strNextString5 = str;
                                    jSONObject = jSONObject2;
                                }
                            } else {
                                jsonReader.skipValue();
                            }
                        } else if ("adRequestPostBody".equals(strNextName)) {
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjg)).booleanValue()) {
                                strNextString3 = jsonReader.nextString();
                            } else {
                                jsonReader.skipValue();
                            }
                        } else if ("adRequestUrl".equals(strNextName)) {
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjg)).booleanValue()) {
                                strNextString2 = jsonReader.nextString();
                            } else {
                                jsonReader.skipValue();
                            }
                        } else {
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjh)).booleanValue() && Objects.equals(strNextName, "adResponseBody")) {
                                strNextString4 = jsonReader.nextString();
                            } else {
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjh)).booleanValue() && Objects.equals(strNextName, "adResponseHeaders")) {
                                    jSONObject = com.google.android.gms.ads.internal.util.zzbw.zzh(jsonReader);
                                } else {
                                    if (Objects.equals(strNextName, "max_parallel_renderers")) {
                                        iMax = Math.max(1, jsonReader.nextInt());
                                    } else {
                                        jsonReader.skipValue();
                                    }
                                    strNextString5 = str;
                                    jSONObject = jSONObject2;
                                }
                            }
                        }
                        jSONObject = jSONObject2;
                    }
                    strNextString5 = str;
                    jSONObject = jSONObject2;
                }
                strNextString5 = str;
                jSONObject = jSONObject2;
            }
            strNextString5 = str;
        }
        jsonReader.endObject();
        this.zza = listEmptyList;
        this.zzc = iNextInt;
        this.zzb = strNextString;
        this.zzd = strNextString6;
        this.zze = iNextInt2;
        this.zzf = jNextLong;
        this.zzi = zzfgoVar;
        this.zzg = zNextBoolean;
        this.zzh = strNextString7;
        this.zzj = bundle;
        this.zzk = strNextString2;
        this.zzl = strNextString3;
        this.zzm = strNextString4;
        this.zzn = jSONObject;
        this.zzo = strNextString5;
        this.zzp = ((Long) zzbif.zza.zze()).longValue() > 0 ? ((Long) zzbif.zza.zze()).intValue() : iMax;
    }
}
