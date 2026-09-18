package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzexn implements zzexq {
    private final zzgey zza;
    private final Context zzb;

    zzexn(zzgey zzgeyVar, Context context) {
        this.zza = zzgeyVar;
        this.zzb = context;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 37;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzexl
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    final /* synthetic */ zzexp zzc() throws Exception {
        final Bundle bundleZzb = com.google.android.gms.ads.internal.util.zzad.zzb(this.zzb, (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgf));
        if (bundleZzb.isEmpty()) {
            return null;
        }
        return new zzexp() { // from class: com.google.android.gms.internal.ads.zzexm
            @Override // com.google.android.gms.internal.ads.zzexp
            public final void zzj(Object obj) {
                ((Bundle) obj).putBundle("shared_pref", bundleZzb);
            }
        };
    }
}
