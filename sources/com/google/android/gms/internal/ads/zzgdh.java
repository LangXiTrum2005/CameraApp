package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgdh extends zzgdj {
    zzgdh(ListenableFuture listenableFuture, zzgdu zzgduVar) {
        super(listenableFuture, zzgduVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) throws Exception {
        zzgdu zzgduVar = (zzgdu) obj;
        ListenableFuture listenableFutureZza = zzgduVar.zza(obj2);
        zzfxe.zzd(listenableFutureZza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgduVar);
        return listenableFutureZza;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    final /* synthetic */ void zzf(Object obj) {
        zzs((ListenableFuture) obj);
    }
}
