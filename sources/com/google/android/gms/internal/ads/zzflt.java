package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzflt {
    private final Executor zza;
    private final zzceh zzb;

    public zzflt(Executor executor, zzceh zzcehVar) {
        this.zza = executor;
        this.zzb = zzcehVar;
    }

    final /* synthetic */ void zza(String str) {
        this.zzb.zza(str);
    }

    public final void zzb(final String str) {
        this.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfls
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(str);
            }
        });
    }
}
