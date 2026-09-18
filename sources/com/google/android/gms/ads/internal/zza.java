package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzcfs;
import com.google.android.gms.internal.ads.zzcgd;
import com.google.android.gms.internal.ads.zzchi;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zza {
    public final zzcfs zza;
    public final zzchi zzb;

    public zza(zzchi zzchiVar, zzcfs zzcfsVar) {
        this.zzb = zzchiVar;
        this.zza = zzcfsVar;
    }

    public static zza zza() {
        return new zza(new zzchi(), new zzcgd());
    }
}
