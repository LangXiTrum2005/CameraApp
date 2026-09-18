package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdls implements zzbng {
    private final WeakReference zza;

    /* synthetic */ zzdls(zzdlx zzdlxVar, zzdlr zzdlrVar) {
        this.zza = new WeakReference(zzdlxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final void zza(Object obj, Map map) {
        zzdlx zzdlxVar = (zzdlx) this.zza.get();
        if (zzdlxVar != null && "_ac".equals((String) map.get("eventName"))) {
            zzdlxVar.zzh.onAdClicked();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkm)).booleanValue()) {
                zzdlxVar.zzi.zzs();
                if (TextUtils.isEmpty((CharSequence) map.get("sccg"))) {
                    return;
                }
                zzdlxVar.zzi.zzbo();
            }
        }
    }
}
