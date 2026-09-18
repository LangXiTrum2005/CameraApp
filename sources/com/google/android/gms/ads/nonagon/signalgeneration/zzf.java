package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzcep;
import com.google.android.gms.internal.ads.zzdwa;
import com.google.android.gms.internal.ads.zzdwk;
import com.google.android.gms.internal.ads.zzfhh;
import com.google.firebase.ktx.BuildConfig;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzf {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:36:0x006c  */
    public static String zza(String str) {
        if (TextUtils.isEmpty(str)) {
            return BuildConfig.VERSION_NAME;
        }
        switch (str) {
            case "requester_type_0":
                return "0";
            case "requester_type_1":
                return "1";
            case "requester_type_2":
                return "2";
            case "requester_type_3":
                return "3";
            case "requester_type_4":
                return "4";
            case "requester_type_5":
                return "5";
            case "requester_type_6":
                return "6";
            case "requester_type_7":
                return "7";
            case "requester_type_8":
                return "8";
            default:
                return str;
        }
    }

    public static String zzb(com.google.android.gms.ads.internal.client.zzl zzlVar) {
        Bundle bundle;
        return (zzlVar == null || (bundle = zzlVar.zzc) == null) ? BuildConfig.VERSION_NAME : bundle.getString("query_info_type");
    }

    public static void zzc(final zzdwk zzdwkVar, final zzdwa zzdwaVar, final String str, final Pair... pairArr) {
        if (((Boolean) zzba.zzc().zza(zzbgc.zzha)).booleanValue()) {
            zzcep.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zze
                @Override // java.lang.Runnable
                public final void run() {
                    zzf.zzd(zzdwkVar, zzdwaVar, str, pairArr);
                }
            });
        }
    }

    static void zzd(zzdwk zzdwkVar, zzdwa zzdwaVar, String str, Pair... pairArr) {
        Map mapZzc = zzdwaVar == null ? zzdwkVar.zzc() : zzdwaVar.zza();
        zzf(mapZzc, "action", str);
        for (Pair pair : pairArr) {
            zzf(mapZzc, (String) pair.first, (String) pair.second);
        }
        zzdwkVar.zzf(mapZzc);
    }

    public static int zze(zzfhh zzfhhVar) {
        if (zzfhhVar.zzq) {
            return 2;
        }
        com.google.android.gms.ads.internal.client.zzl zzlVar = zzfhhVar.zzd;
        com.google.android.gms.ads.internal.client.zzc zzcVar = zzlVar.zzs;
        if (zzcVar == null && zzlVar.zzx == null) {
            return 1;
        }
        if (zzcVar == null || zzlVar.zzx == null) {
            return zzcVar != null ? 3 : 4;
        }
        return 5;
    }

    private static void zzf(Map map, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }
}
