package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgea extends zzgdm {

    @CheckForNull
    private zzgdz zza;

    zzgea(zzfzv zzfzvVar, boolean z, Executor executor, Callable callable) {
        super(zzfzvVar, z, false);
        this.zza = new zzgdy(this, callable, executor);
        zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzgdm
    final void zzf(int i, @CheckForNull Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzgdb
    protected final void zzq() {
        zzgdz zzgdzVar = this.zza;
        if (zzgdzVar != null) {
            zzgdzVar.zzh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdm
    final void zzu() {
        zzgdz zzgdzVar = this.zza;
        if (zzgdzVar != null) {
            zzgdzVar.zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdm
    final void zzy(int i) {
        super.zzy(i);
        if (i == 1) {
            this.zza = null;
        }
    }
}
