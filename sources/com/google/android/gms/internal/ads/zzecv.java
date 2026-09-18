package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzecv {
    private final zzgey zza;
    private final zzgey zzb;
    private final zzedq zzc;
    private final zzhgx zzd;

    zzecv(zzgey zzgeyVar, zzgey zzgeyVar2, zzedq zzedqVar, zzhgx zzhgxVar) {
        this.zza = zzgeyVar;
        this.zzb = zzgeyVar2;
        this.zzc = zzedqVar;
        this.zzd = zzhgxVar;
    }

    final /* synthetic */ ListenableFuture zza(zzbym zzbymVar) throws Exception {
        return this.zzc.zza(zzbymVar, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkX)).longValue());
    }

    final /* synthetic */ ListenableFuture zzb(zzbym zzbymVar, int i, zzecf zzecfVar) throws Exception {
        return ((zzeew) this.zzd.zzb()).zzb(zzbymVar, i);
    }

    public final ListenableFuture zzc(final zzbym zzbymVar) {
        ListenableFuture listenableFutureZzf;
        String str = zzbymVar.zzf;
        com.google.android.gms.ads.internal.zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzt.zzB(str)) {
            listenableFutureZzf = zzgen.zzg(new zzecf(1, "Ads service proxy force local"));
        } else {
            listenableFutureZzf = zzgen.zzf(zzgen.zzk(new zzgdt() { // from class: com.google.android.gms.internal.ads.zzecs
                @Override // com.google.android.gms.internal.ads.zzgdt
                public final ListenableFuture zza() {
                    return this.zza.zza(zzbymVar);
                }
            }, this.zza), ExecutionException.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzect
                @Override // com.google.android.gms.internal.ads.zzgdu
                public final ListenableFuture zza(Object obj) {
                    ExecutionException executionException = (ExecutionException) obj;
                    Throwable cause = executionException.getCause();
                    ExecutionException cause2 = executionException;
                    if (cause != null) {
                        cause2 = executionException.getCause();
                    }
                    return zzgen.zzg(cause2);
                }
            }, this.zzb);
        }
        final int callingUid = Binder.getCallingUid();
        return zzgen.zzf(listenableFutureZzf, zzecf.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzecu
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzb(zzbymVar, callingUid, (zzecf) obj);
            }
        }, this.zzb);
    }
}
