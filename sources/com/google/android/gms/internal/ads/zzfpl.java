package com.google.android.gms.internal.ads;

import android.webkit.WebView;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfpl implements Runnable {
    final /* synthetic */ zzfpm zza;
    private final WebView zzb;

    zzfpl(zzfpm zzfpmVar) {
        this.zza = zzfpmVar;
        this.zzb = zzfpmVar.zza;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.destroy();
    }
}
