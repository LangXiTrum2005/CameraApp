package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfae implements zzexq {
    final zzgey zza;
    final String zzb;
    final zzccz zzc;

    public zzfae(zzccz zzcczVar, zzgey zzgeyVar, String str) {
        this.zzc = zzcczVar;
        this.zza = zzgeyVar;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 47;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        final ListenableFuture listenableFutureZzh = zzgen.zzh(null);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfP)).booleanValue()) {
            listenableFutureZzh = zzgen.zzh(null);
        }
        final ListenableFuture listenableFutureZzh2 = zzgen.zzh(null);
        return zzgen.zzc(listenableFutureZzh, listenableFutureZzh2).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzfad
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzfaf((String) listenableFutureZzh.get(), (String) listenableFutureZzh2.get());
            }
        }, zzcep.zza);
    }
}
