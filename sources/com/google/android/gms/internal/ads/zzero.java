package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzero implements zzexq {
    private final zzgey zza;
    private final zzfhh zzb;
    private final zzfhw zzc;

    zzero(zzgey zzgeyVar, zzfhh zzfhhVar, zzfhw zzfhwVar) {
        this.zza = zzgeyVar;
        this.zzb = zzfhhVar;
        this.zzc = zzfhwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 5;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzern
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    final /* synthetic */ zzerp zzc() throws Exception {
        String strZza = null;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhi)).booleanValue() && "requester_type_2".equals(com.google.android.gms.ads.nonagon.signalgeneration.zzf.zzb(this.zzb.zzd))) {
            strZza = zzfhw.zza();
        }
        return new zzerp(strZza);
    }
}
