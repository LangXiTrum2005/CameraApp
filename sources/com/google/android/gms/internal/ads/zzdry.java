package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdry implements zzbng {
    final /* synthetic */ zzdrz zza;
    private final WeakReference zzb;
    private final String zzc;
    private final zzbng zzd;

    /* synthetic */ zzdry(zzdrz zzdrzVar, WeakReference weakReference, String str, zzbng zzbngVar, zzdrx zzdrxVar) {
        this.zza = zzdrzVar;
        this.zzb = weakReference;
        this.zzc = str;
        this.zzd = zzbngVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final void zza(Object obj, Map map) {
        Object obj2 = this.zzb.get();
        if (obj2 == null) {
            this.zza.zzk(this.zzc, this);
        } else {
            this.zzd.zza(obj2, map);
        }
    }
}
