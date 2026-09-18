package com.google.android.gms.ads.internal.overlay;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzf implements View.OnClickListener {
    final /* synthetic */ zzm zza;

    zzf(zzm zzmVar) {
        this.zza = zzmVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        zzm zzmVar = this.zza;
        zzmVar.zzn = 2;
        zzmVar.zzb.finish();
    }
}
