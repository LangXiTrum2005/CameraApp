package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzetn implements zzexq {
    private final zzfdk zza;

    zzetn(zzfdk zzfdkVar) {
        this.zza = zzfdkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 15;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        zzfdk zzfdkVar = this.zza;
        zzexp zzexpVar = null;
        if (zzfdkVar != null && zzfdkVar.zza() != null && !zzfdkVar.zza().isEmpty()) {
            zzexpVar = new zzexp() { // from class: com.google.android.gms.internal.ads.zzetm
                @Override // com.google.android.gms.internal.ads.zzexp
                public final void zzj(Object obj) {
                    this.zza.zzc((Bundle) obj);
                }
            };
        }
        return zzgen.zzh(zzexpVar);
    }

    final /* synthetic */ void zzc(Bundle bundle) {
        bundle.putString("key_schema", this.zza.zza());
    }
}
