package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgqy {

    @Deprecated
    static final zzgwc zza;

    @Deprecated
    static final zzgwc zzb;

    @Deprecated
    static final zzgwc zzc;

    static {
        zzgwc zzgwcVarZzc = zzgwc.zzc();
        zza = zzgwcVarZzc;
        zzb = zzgwcVarZzc;
        zzc = zzgwcVarZzc;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzgre.zzd();
        zzgqi.zzd();
        zzgqr.zza(true);
        if (zzgmw.zzb()) {
            return;
        }
        zzgpu.zzd(true);
    }
}
