package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgkt extends zzghh {
    private final zzgku zza;

    private zzgkt(zzgku zzgkuVar) {
        this.zza = zzgkuVar;
    }

    public static zzgkt zza(zzgku zzgkuVar) throws GeneralSecurityException {
        return new zzgkt(zzgkuVar);
    }

    public final zzgku zzb() {
        return this.zza;
    }
}
