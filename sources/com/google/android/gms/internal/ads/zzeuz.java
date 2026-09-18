package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeuz implements zzexq {
    private final zzgey zza;
    private final zzdzd zzb;

    zzeuz(zzgey zzgeyVar, zzdzd zzdzdVar) {
        this.zza = zzgeyVar;
        this.zzb = zzdzdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 23;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeuy
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    final /* synthetic */ zzeva zzc() throws Exception {
        zzdzd zzdzdVar = this.zzb;
        String strZzc = zzdzdVar.zzc();
        boolean zZzq = zzdzdVar.zzq();
        boolean zZzl = com.google.android.gms.ads.internal.zzt.zzs().zzl();
        zzdzd zzdzdVar2 = this.zzb;
        return new zzeva(strZzc, zZzq, zZzl, zzdzdVar2.zzo(), zzdzdVar2.zzr());
    }
}
