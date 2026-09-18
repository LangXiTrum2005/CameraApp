package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzavh;
import com.google.android.gms.internal.ads.zzavi;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzo implements Callable {
    final /* synthetic */ zzs zza;

    zzo(zzs zzsVar) {
        this.zza = zzsVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzs zzsVar = this.zza;
        return new zzavi(zzavh.zzt(zzsVar.zza.zza, zzsVar.zzd, false));
    }
}
