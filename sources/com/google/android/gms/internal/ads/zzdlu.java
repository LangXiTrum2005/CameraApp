package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdlu implements zzbng {
    private final WeakReference zza;

    /* synthetic */ zzdlu(zzdlx zzdlxVar, zzdlt zzdltVar) {
        this.zza = new WeakReference(zzdlxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final void zza(Object obj, Map map) {
        zzdlx zzdlxVar = (zzdlx) this.zza.get();
        if (zzdlxVar == null) {
            return;
        }
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
