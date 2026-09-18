package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzesf {
    private final AtomicBoolean zza = new AtomicBoolean(false);
    private zzese zzb;

    final zzese zza() {
        return this.zzb;
    }

    final void zzb(zzese zzeseVar) {
        this.zzb = zzeseVar;
    }

    public final void zzc(boolean z) {
        this.zza.set(true);
    }

    public final boolean zzd() {
        return this.zza.get();
    }
}
