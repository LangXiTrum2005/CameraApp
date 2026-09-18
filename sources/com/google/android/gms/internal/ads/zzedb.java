package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzedb {
    private final zzgey zza;
    private final zzgey zzb;
    private final zzedt zzc;

    zzedb(zzgey zzgeyVar, zzgey zzgeyVar2, zzedt zzedtVar) {
        this.zza = zzgeyVar;
        this.zzb = zzgeyVar2;
        this.zzc = zzedtVar;
    }

    final /* synthetic */ ListenableFuture zza(zzbyi zzbyiVar) throws Exception {
        return this.zzc.zza(zzbyiVar, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkW)).longValue());
    }

    public final ListenableFuture zzb(final zzbyi zzbyiVar) {
        ListenableFuture listenableFutureZzf;
        String str = zzbyiVar.zzb;
        com.google.android.gms.ads.internal.zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzt.zzB(str)) {
            listenableFutureZzf = zzgen.zzg(new zzecf(1, "Ads signal service force local"));
        } else {
            listenableFutureZzf = zzgen.zzf(zzgen.zzk(new zzgdt() { // from class: com.google.android.gms.internal.ads.zzecx
                @Override // com.google.android.gms.internal.ads.zzgdt
                public final ListenableFuture zza() {
                    return this.zza.zza(zzbyiVar);
                }
            }, this.zza), ExecutionException.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzecy
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
        return zzgen.zzn(zzgen.zzf(zzgee.zzu(listenableFutureZzf), zzecf.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzecz
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzgen.zzh(null);
            }
        }, this.zzb), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzeda
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                InputStream inputStream = (InputStream) obj;
                JSONObject jSONObject = new JSONObject();
                if (inputStream == null) {
                    return zzgen.zzh(jSONObject);
                }
                try {
                    com.google.android.gms.ads.internal.zzt.zzp();
                    jSONObject = new JSONObject(com.google.android.gms.ads.internal.util.zzt.zzM(new InputStreamReader(inputStream)));
                } catch (IOException | JSONException e) {
                    com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "AdsServiceSignalTask.startAdsServiceSignalTask");
                }
                return zzgen.zzh(jSONObject);
            }
        }, this.zzb);
    }
}
