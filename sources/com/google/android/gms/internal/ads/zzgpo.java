package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgpo {

    @Nullable
    private zzgpz zza = null;

    @Nullable
    private zzgxr zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzgpo() {
    }

    /* synthetic */ zzgpo(zzgpn zzgpnVar) {
    }

    public final zzgpo zza(zzgxr zzgxrVar) throws GeneralSecurityException {
        this.zzb = zzgxrVar;
        return this;
    }

    public final zzgpo zzb(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgpo zzc(zzgpz zzgpzVar) {
        this.zza = zzgpzVar;
        return this;
    }

    public final zzgpq zzd() throws GeneralSecurityException {
        zzgxr zzgxrVar;
        zzgxq zzgxqVarZzb;
        zzgpz zzgpzVar = this.zza;
        if (zzgpzVar == null || (zzgxrVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzgpzVar.zzc() != zzgxrVar.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzgpzVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zze() == zzgpx.zzd) {
            zzgxqVarZzb = zzgxq.zzb(new byte[0]);
        } else if (this.zza.zze() == zzgpx.zzc || this.zza.zze() == zzgpx.zzb) {
            zzgxqVarZzb = zzgxq.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
        } else {
            if (this.zza.zze() != zzgpx.zza) {
                throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: ".concat(String.valueOf(String.valueOf(this.zza.zze()))));
            }
            zzgxqVarZzb = zzgxq.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
        }
        return new zzgpq(this.zza, this.zzb, zzgxqVarZzb, this.zzc, null);
    }
}
