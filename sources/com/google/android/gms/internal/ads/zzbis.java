package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbis {
    private static final AtomicReference zzb = new AtomicReference();
    private static final AtomicReference zzc = new AtomicReference();
    static final AtomicBoolean zza = new AtomicBoolean();

    static zzbiq zza() {
        return (zzbiq) zzb.get();
    }

    static zzbir zzb() {
        return (zzbir) zzc.get();
    }

    public static void zzc(zzbiq zzbiqVar) {
        zzb.set(zzbiqVar);
    }
}
