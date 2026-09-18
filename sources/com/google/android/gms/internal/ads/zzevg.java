package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzevg implements zzexq {
    private final zzfgl zza;

    zzevg(zzfgl zzfglVar) {
        this.zza = zzfglVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 25;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        return zzgen.zzh(new zzevh(this.zza));
    }
}
