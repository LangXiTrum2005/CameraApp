package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzboy implements zzgdu {
    final /* synthetic */ zzboq zza;

    zzboy(zzbpc zzbpcVar, zzboq zzboqVar) {
        this.zza = zzboqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdu
    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) throws Exception {
        zzceu zzceuVar = new zzceu();
        ((zzbow) obj).zze(this.zza, new zzbox(this, zzceuVar));
        return zzceuVar;
    }
}
