package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzblo extends zzbkp {
    final /* synthetic */ zzblr zza;

    /* synthetic */ zzblo(zzblr zzblrVar, zzbln zzblnVar) {
        this.zza = zzblrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkq
    public final void zze(zzbkg zzbkgVar, String str) {
        zzblr zzblrVar = this.zza;
        if (zzblrVar.zzb == null) {
            return;
        }
        zzblrVar.zzb.zzb(zzblrVar.zzf(zzbkgVar), str);
    }
}
