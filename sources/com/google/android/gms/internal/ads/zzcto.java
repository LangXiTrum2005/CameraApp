package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcto {
    private final zzflw zza;
    private final zzdwf zzb;
    private final zzfgy zzc;

    public zzcto(zzdwf zzdwfVar, zzfgy zzfgyVar, zzflw zzflwVar) {
        this.zza = zzflwVar;
        this.zzb = zzdwfVar;
        this.zzc = zzfgyVar;
    }

    private static String zzb(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return "h";
        }
        if (i2 == 1) {
            return "bb";
        }
        if (i2 == 2) {
            return "cc";
        }
        if (i2 != 3) {
            return i2 != 4 ? "u" : "ac";
        }
        return "cb";
    }

    public final void zza(long j, int i) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziz)).booleanValue()) {
            zzflw zzflwVar = this.zza;
            zzfgy zzfgyVar = this.zzc;
            zzflv zzflvVarZzb = zzflv.zzb("ad_closed");
            zzflvVarZzb.zzg(zzfgyVar.zzb.zzb);
            zzflvVarZzb.zza("show_time", String.valueOf(j));
            zzflvVarZzb.zza(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
            zzflvVarZzb.zza("acr", zzb(i));
            zzflwVar.zzb(zzflvVarZzb);
            return;
        }
        zzdwf zzdwfVar = this.zzb;
        zzfgy zzfgyVar2 = this.zzc;
        zzdwe zzdweVarZza = zzdwfVar.zza();
        zzdweVarZza.zze(zzfgyVar2.zzb.zzb);
        zzdweVarZza.zzb("action", "ad_closed");
        zzdweVarZza.zzb("show_time", String.valueOf(j));
        zzdweVarZza.zzb(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
        zzdweVarZza.zzb("acr", zzb(i));
        zzdweVarZza.zzg();
    }
}
