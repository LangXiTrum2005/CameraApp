package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbvp implements View.OnClickListener {
    final /* synthetic */ zzbvq zza;

    zzbvp(zzbvq zzbvqVar) {
        this.zza = zzbvqVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zza.zza(true);
    }
}
