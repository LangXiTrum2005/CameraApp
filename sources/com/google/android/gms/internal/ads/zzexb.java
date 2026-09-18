package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzexb implements zzexq {
    private final zzcch zza;
    private final zzgey zzb;
    private final Context zzc;

    public zzexb(zzcch zzcchVar, zzgey zzgeyVar, Context context) {
        this.zza = zzcchVar;
        this.zzb = zzgeyVar;
        this.zzc = context;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 34;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        return this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzexa
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    final /* synthetic */ zzexc zzc() throws Exception {
        if (!this.zza.zzp(this.zzc)) {
            return new zzexc(null, null, null, null, null);
        }
        String strZzd = this.zza.zzd(this.zzc);
        String str = strZzd == null ? "" : strZzd;
        String strZzb = this.zza.zzb(this.zzc);
        String str2 = strZzb == null ? "" : strZzb;
        String strZza = this.zza.zza(this.zzc);
        String str3 = strZza == null ? "" : strZza;
        Long l = null;
        String str4 = true != this.zza.zzp(this.zzc) ? null : "fa";
        if ("TIME_OUT".equals(str2)) {
            l = (Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaf);
        }
        return new zzexc(str, str2, str3, str4 == null ? "" : str4, l);
    }
}
