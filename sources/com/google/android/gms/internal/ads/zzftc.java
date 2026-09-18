package com.google.android.gms.internal.ads;

import java.io.Closeable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzftc implements Closeable {
    public static zzfto zza() {
        return new zzfto();
    }

    public static zzfto zzb(final int i, zzftn zzftnVar) {
        return new zzfto(new zzfxu() { // from class: com.google.android.gms.internal.ads.zzfta
            @Override // com.google.android.gms.internal.ads.zzfxu
            public final Object zza() {
                return Integer.valueOf(i);
            }
        }, new zzfxu() { // from class: com.google.android.gms.internal.ads.zzftb
            @Override // com.google.android.gms.internal.ads.zzfxu
            public final Object zza() {
                return zzftc.zze();
            }
        }, zzftnVar);
    }

    public static zzfto zzc(zzfxu<Integer> zzfxuVar, zzfxu<Integer> zzfxuVar2, zzftn zzftnVar) {
        return new zzfto(zzfxuVar, zzfxuVar2, zzftnVar);
    }

    static /* synthetic */ Integer zze() {
        return -1;
    }
}
