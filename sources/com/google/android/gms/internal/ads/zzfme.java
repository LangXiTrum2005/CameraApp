package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfme {
    private final Context zza;
    private final String zzb;
    private final String zzc;

    public zzfme(Context context, zzcei zzceiVar) {
        this.zza = context;
        this.zzb = context.getPackageName();
        this.zzc = zzceiVar.zza;
    }

    public final void zza(Map map) {
        map.put("s", "gmob_sdk");
        map.put("v", "3");
        map.put("os", Build.VERSION.RELEASE);
        map.put("api_v", Build.VERSION.SDK);
        com.google.android.gms.ads.internal.zzt.zzp();
        map.put("device", com.google.android.gms.ads.internal.util.zzt.zzr());
        map.put("app", this.zzb);
        com.google.android.gms.ads.internal.zzt.zzp();
        map.put("is_lite_sdk", true != com.google.android.gms.ads.internal.util.zzt.zzD(this.zza) ? "0" : "1");
        zzbfu zzbfuVar = zzbgc.zza;
        List listZzb = com.google.android.gms.ads.internal.client.zzba.zza().zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgU)).booleanValue()) {
            listZzb.addAll(com.google.android.gms.ads.internal.zzt.zzo().zzi().zzh().zzd());
        }
        map.put("e", TextUtils.join(",", listZzb));
        map.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, this.zzc);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkL)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzp();
            map.put("is_bstar", true == com.google.android.gms.ads.internal.util.zzt.zzA(this.zza) ? "1" : "0");
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjn)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcc)).booleanValue()) {
                map.put("plugin", zzfxt.zzc(com.google.android.gms.ads.internal.zzt.zzo().zzn()));
            }
        }
    }
}
