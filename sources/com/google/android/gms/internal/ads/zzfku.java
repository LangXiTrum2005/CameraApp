package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfku {
    final /* synthetic */ zzfle zza;
    private final Object zzb;
    private final List zzc;

    /* synthetic */ zzfku(zzfle zzfleVar, Object obj, List list, zzfkt zzfktVar) {
        this.zza = zzfleVar;
        this.zzb = obj;
        this.zzc = list;
    }

    public final zzfld zza(Callable callable) {
        zzgem zzgemVarZzb = zzgen.zzb(this.zzc);
        ListenableFuture listenableFutureZza = zzgemVarZzb.zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzfks
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return null;
            }
        }, zzcep.zzf);
        ListenableFuture listenableFutureZza2 = zzgemVarZzb.zza(callable, this.zza.zzb);
        return new zzfld(this.zza, this.zzb, listenableFutureZza, this.zzc, listenableFutureZza2);
    }
}
