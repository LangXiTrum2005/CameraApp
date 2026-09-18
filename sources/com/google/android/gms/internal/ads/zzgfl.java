package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgfl extends zzgew {
    final /* synthetic */ zzgfn zza;
    private final zzgdt zzb;

    zzgfl(zzgfn zzgfnVar, zzgdt zzgdtVar) {
        this.zza = zzgfnVar;
        this.zzb = zzgdtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgew
    final /* bridge */ /* synthetic */ Object zza() throws Exception {
        zzgdt zzgdtVar = this.zzb;
        ListenableFuture listenableFutureZza = zzgdtVar.zza();
        zzfxe.zzd(listenableFutureZza, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgdtVar);
        return listenableFutureZza;
    }

    @Override // com.google.android.gms.internal.ads.zzgew
    final String zzb() {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgew
    final void zzd(Throwable th) {
        this.zza.zzd(th);
    }

    @Override // com.google.android.gms.internal.ads.zzgew
    final /* synthetic */ void zze(Object obj) {
        this.zza.zzs((ListenableFuture) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgew
    final boolean zzg() {
        return this.zza.isDone();
    }
}
