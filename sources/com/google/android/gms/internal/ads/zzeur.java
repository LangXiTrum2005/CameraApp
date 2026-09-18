package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeur implements zzexq {
    private final zzgey zza;
    private final zzfhh zzb;

    zzeur(zzgey zzgeyVar, zzfhh zzfhhVar) {
        this.zza = zzgeyVar;
        this.zzb = zzfhhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 21;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeuq
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    final /* synthetic */ zzeus zzc() throws Exception {
        return new zzeus("requester_type_2".equals(com.google.android.gms.ads.nonagon.signalgeneration.zzf.zzb(this.zzb.zzd)));
    }
}
