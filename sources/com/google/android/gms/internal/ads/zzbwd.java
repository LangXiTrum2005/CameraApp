package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbwd extends zzbkp {
    final /* synthetic */ zzbwg zza;

    /* synthetic */ zzbwd(zzbwg zzbwgVar, zzbwc zzbwcVar) {
        this.zza = zzbwgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkq
    public final void zze(zzbkg zzbkgVar, String str) {
        zzbwg zzbwgVar = this.zza;
        if (zzbwgVar.zzb == null) {
            return;
        }
        zzbwgVar.zzb.onCustomClick(zzbwgVar.zzf(zzbkgVar), str);
    }
}
