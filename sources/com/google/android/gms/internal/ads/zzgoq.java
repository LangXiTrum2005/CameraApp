package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgoq {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzgoq(Class cls, Class cls2, zzgop zzgopVar) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzgoq zzb(zzgoo zzgooVar, Class cls, Class cls2) {
        return new zzgon(cls, cls2, zzgooVar);
    }

    public abstract Object zza(zzggc zzggcVar) throws GeneralSecurityException;

    public final Class zzc() {
        return this.zza;
    }

    public final Class zzd() {
        return this.zzb;
    }
}
