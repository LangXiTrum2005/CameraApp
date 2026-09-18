package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzgee extends zzgeo {
    zzgee() {
    }

    public static zzgee zzu(ListenableFuture listenableFuture) {
        return listenableFuture instanceof zzgee ? (zzgee) listenableFuture : new zzgef(listenableFuture);
    }
}
