package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfrc {
    private final Context zza;
    private final Looper zzb;

    public zzfrc(Context context, Looper looper) {
        this.zza = context;
        this.zzb = looper;
    }

    public final void zza(String str) {
        zzfrq zzfrqVarZza = zzfrs.zza();
        zzfrqVarZza.zza(this.zza.getPackageName());
        zzfrqVarZza.zzc(2);
        zzfrn zzfrnVarZza = zzfro.zza();
        zzfrnVarZza.zza(str);
        zzfrnVarZza.zzb(2);
        zzfrqVarZza.zzb(zzfrnVarZza);
        new zzfrd(this.zza, this.zzb, (zzfrs) zzfrqVarZza.zzal()).zza();
    }
}
