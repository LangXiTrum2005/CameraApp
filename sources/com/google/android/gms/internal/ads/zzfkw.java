package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfkw {
    public static final zzfld zza(Callable callable, Object obj, zzfle zzfleVar) {
        return zzb(callable, zzfleVar.zzb, obj, zzfleVar);
    }

    public static final zzfld zzb(Callable callable, zzgey zzgeyVar, Object obj, zzfle zzfleVar) {
        return new zzfld(zzfleVar, obj, zzfle.zza, Collections.emptyList(), zzgeyVar.zzb(callable));
    }

    public static final zzfld zzc(ListenableFuture listenableFuture, Object obj, zzfle zzfleVar) {
        return new zzfld(zzfleVar, obj, zzfle.zza, Collections.emptyList(), listenableFuture);
    }

    public static final zzfld zzd(final zzfkq zzfkqVar, zzgey zzgeyVar, Object obj, zzfle zzfleVar) {
        return zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzfkv
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                zzfkqVar.zza();
                return null;
            }
        }, zzgeyVar, obj, zzfleVar);
    }
}
