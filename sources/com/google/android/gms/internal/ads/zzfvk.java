package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfvk extends zzfun {
    final /* synthetic */ zzfvl zza;
    private final zzfvq zzb;

    zzfvk(zzfvl zzfvlVar, zzfvq zzfvqVar) {
        this.zza = zzfvlVar;
        this.zzb = zzfvqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfuo
    public final void zzb(Bundle bundle) {
        int i = bundle.getInt("statusCode", 8150);
        String string = bundle.getString("sessionToken");
        zzfvo zzfvoVarZzc = zzfvp.zzc();
        zzfvoVarZzc.zzb(i);
        if (string != null) {
            zzfvoVarZzc.zza(string);
        }
        this.zzb.zza(zzfvoVarZzc.zzc());
        if (i == 8157) {
            this.zza.zzc();
        }
    }
}
