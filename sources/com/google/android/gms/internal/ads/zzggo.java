package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class zzggo {
    private static final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    @Deprecated
    public static zzggn zza(String str) throws GeneralSecurityException {
        for (zzggn zzggnVar : zza) {
            if (zzggnVar.zza()) {
                return zzggnVar;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: ".concat(String.valueOf(str)));
    }
}
