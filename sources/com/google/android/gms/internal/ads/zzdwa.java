package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class zzdwa {
    private final ConcurrentHashMap zza;
    private final zzcdp zzb;
    private final zzfhh zzc;
    private final String zzd;
    private final String zze;

    public zzdwa(zzdwk zzdwkVar, zzcdp zzcdpVar, zzfhh zzfhhVar, String str, String str2) {
        ConcurrentHashMap concurrentHashMapZzc = zzdwkVar.zzc();
        this.zza = concurrentHashMapZzc;
        this.zzb = zzcdpVar;
        this.zzc = zzfhhVar;
        this.zzd = str;
        this.zze = str2;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzha)).booleanValue()) {
            int iZze = com.google.android.gms.ads.nonagon.signalgeneration.zzf.zze(zzfhhVar);
            int i = iZze - 1;
            if (i == 0) {
                concurrentHashMapZzc.put("scar", "false");
                return;
            }
            if (i == 1) {
                concurrentHashMapZzc.put("se", "query_g");
            } else if (i == 2) {
                concurrentHashMapZzc.put("se", "r_adinfo");
            } else if (i != 3) {
                concurrentHashMapZzc.put("se", "r_both");
            } else {
                concurrentHashMapZzc.put("se", "r_adstring");
            }
            concurrentHashMapZzc.put("scar", "true");
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhz)).booleanValue()) {
                concurrentHashMapZzc.put(FirebaseAnalytics.Param.AD_FORMAT, str2);
            }
            if (iZze == 2) {
                concurrentHashMapZzc.put("rid", str);
            }
            zzd("ragent", zzfhhVar.zzd.zzp);
            zzd("rtype", com.google.android.gms.ads.nonagon.signalgeneration.zzf.zza(com.google.android.gms.ads.nonagon.signalgeneration.zzf.zzb(zzfhhVar.zzd)));
        }
    }

    private final void zzd(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.zza.put(str, str2);
    }

    public final Map zza() {
        return this.zza;
    }

    public final void zzb(zzfgy zzfgyVar) {
        if (!zzfgyVar.zzb.zza.isEmpty()) {
            switch (((zzfgm) zzfgyVar.zzb.zza.get(0)).zzb) {
                case 1:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "banner");
                    break;
                case 2:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "interstitial");
                    break;
                case 3:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "native_express");
                    break;
                case 4:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "native_advanced");
                    break;
                case 5:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "rewarded");
                    break;
                case 6:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
                    this.zza.put("as", true != this.zzb.zzm() ? "0" : "1");
                    break;
                default:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, EnvironmentCompat.MEDIA_UNKNOWN);
                    break;
            }
        }
        zzd("gqi", zzfgyVar.zzb.zzb.zzb);
    }

    public final void zzc(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zza.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zza.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
    }
}
