package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbmo implements zzbng {
    zzbmo() {
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcjk zzcjkVar = (zzcjk) obj;
        if (TextUtils.isEmpty((CharSequence) map.get(RemoteConfigConstants.RequestFieldKey.APP_ID))) {
            com.google.android.gms.ads.internal.util.zze.zza("Missing App Id, cannot show LMD Overlay without it");
            return;
        }
        zzfvm zzfvmVarZzl = zzfvn.zzl();
        zzfvmVarZzl.zzb((String) map.get(RemoteConfigConstants.RequestFieldKey.APP_ID));
        zzfvmVarZzl.zzh(zzcjkVar.getWidth());
        zzfvmVarZzl.zzg(zzcjkVar.zzF().getWindowToken());
        if (map.containsKey("gravityX") && map.containsKey("gravityY")) {
            zzfvmVarZzl.zzd(Integer.parseInt((String) map.get("gravityX")) | Integer.parseInt((String) map.get("gravityY")));
        } else {
            zzfvmVarZzl.zzd(81);
        }
        if (map.containsKey("verticalMargin")) {
            zzfvmVarZzl.zze(Float.parseFloat((String) map.get("verticalMargin")));
        } else {
            zzfvmVarZzl.zze(0.02f);
        }
        if (map.containsKey("enifd")) {
            zzfvmVarZzl.zza((String) map.get("enifd"));
        }
        try {
            com.google.android.gms.ads.internal.zzt.zzj().zzj(zzcjkVar, zzfvmVarZzl.zzi());
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "DefaultGmsgHandlers.ShowLMDOverlay");
            com.google.android.gms.ads.internal.util.zze.zza("Missing parameters for LMD Overlay show request");
        }
    }
}
