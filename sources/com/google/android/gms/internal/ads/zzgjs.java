package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgjs {

    @Nullable
    private Integer zza;
    private zzgjt zzb;

    private zzgjs() {
        this.zza = null;
        throw null;
    }

    /* synthetic */ zzgjs(zzgjr zzgjrVar) {
        this.zza = null;
        this.zzb = zzgjt.zzc;
    }

    public final zzgjs zzb(zzgjt zzgjtVar) {
        this.zzb = zzgjtVar;
        return this;
    }

    public final zzgjv zzc() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        }
        if (this.zzb != null) {
            return new zzgjv(num.intValue(), this.zzb, null);
        }
        throw new GeneralSecurityException("Variant is not set");
    }

    public final zzgjs zza(int i) throws GeneralSecurityException {
        if (i != 16 && i != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", Integer.valueOf(i)));
        }
        this.zza = Integer.valueOf(i);
        return this;
    }
}
