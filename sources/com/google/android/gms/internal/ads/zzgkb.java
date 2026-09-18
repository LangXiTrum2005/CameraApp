package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgkb extends zzghh {
    private final zzgkg zza;
    private final zzgxr zzb;
    private final zzgxq zzc;

    @Nullable
    private final Integer zzd;

    private zzgkb(zzgkg zzgkgVar, zzgxr zzgxrVar, zzgxq zzgxqVar, @Nullable Integer num) {
        this.zza = zzgkgVar;
        this.zzb = zzgxrVar;
        this.zzc = zzgxqVar;
        this.zzd = num;
    }

    public static zzgkb zza(zzgkf zzgkfVar, zzgxr zzgxrVar, @Nullable Integer num) throws GeneralSecurityException {
        zzgxq zzgxqVarZzb;
        zzgkf zzgkfVar2 = zzgkf.zzc;
        if (zzgkfVar != zzgkfVar2 && num == null) {
            throw new GeneralSecurityException("For given Variant " + zzgkfVar.toString() + " the value of idRequirement must be non-null");
        }
        if (zzgkfVar == zzgkfVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (zzgxrVar.zza() != 32) {
            throw new GeneralSecurityException("ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zzgxrVar.zza());
        }
        zzgkg zzgkgVarZzc = zzgkg.zzc(zzgkfVar);
        if (zzgkgVarZzc.zzb() == zzgkfVar2) {
            zzgxqVarZzb = zzgxq.zzb(new byte[0]);
        } else if (zzgkgVarZzc.zzb() == zzgkf.zzb) {
            zzgxqVarZzb = zzgxq.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
        } else {
            if (zzgkgVarZzc.zzb() != zzgkf.zza) {
                throw new IllegalStateException("Unknown Variant: ".concat(zzgkgVarZzc.zzb().toString()));
            }
            zzgxqVarZzb = zzgxq.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        }
        return new zzgkb(zzgkgVarZzc, zzgxrVar, zzgxqVarZzb, num);
    }

    public final zzgkg zzb() {
        return this.zza;
    }

    public final zzgxq zzc() {
        return this.zzc;
    }

    public final zzgxr zzd() {
        return this.zzb;
    }

    @Nullable
    public final Integer zze() {
        return this.zzd;
    }
}
