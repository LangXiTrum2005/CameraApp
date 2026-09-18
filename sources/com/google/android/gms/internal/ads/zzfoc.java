package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfoc {
    private boolean zza;

    final void zza(Context context) {
        zzfpt.zzb(context, "Application Context cannot be null");
        if (this.zza) {
            return;
        }
        this.zza = true;
        zzfpc.zzb().zzd(context);
        zzfou.zza().zzd(context);
        zzfpn.zzb(context);
        zzfpo.zzd(context);
        zzfpr.zza(context);
        zzfoz.zzb().zzc(context);
        zzfot.zza().zzd(context);
    }

    final boolean zzb() {
        return this.zza;
    }
}
