package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgrt implements zzggp {
    private final zzggp zza;
    private final zzgvz zzb;
    private final byte[] zzc;

    private zzgrt(zzggp zzggpVar, zzgvz zzgvzVar, byte[] bArr) {
        this.zza = zzggpVar;
        this.zzb = zzgvzVar;
        this.zzc = bArr;
    }

    public static zzggp zza(zzgno zzgnoVar) throws GeneralSecurityException {
        byte[] bArrArray;
        zzgox zzgoxVarZza = zzgnoVar.zza(zzggb.zza());
        zzguq zzguqVarZza = zzgut.zza();
        zzguqVarZza.zzb(zzgoxVarZza.zzg());
        zzguqVarZza.zzc(zzgoxVarZza.zze());
        zzguqVarZza.zza(zzgoxVarZza.zzb());
        zzggp zzggpVar = (zzggp) zzghb.zzc((zzgut) zzguqVarZza.zzal(), zzggp.class);
        zzgvz zzgvzVarZzc = zzgoxVarZza.zzc();
        zzgvz zzgvzVar = zzgvz.UNKNOWN_PREFIX;
        int iOrdinal = zzgvzVarZzc.ordinal();
        if (iOrdinal == 1) {
            bArrArray = ByteBuffer.allocate(5).put((byte) 1).putInt(zzgnoVar.zzb().intValue()).array();
        } else if (iOrdinal == 2) {
            bArrArray = ByteBuffer.allocate(5).put((byte) 0).putInt(zzgnoVar.zzb().intValue()).array();
        } else if (iOrdinal != 3) {
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("unknown output prefix type");
            }
            bArrArray = ByteBuffer.allocate(5).put((byte) 0).putInt(zzgnoVar.zzb().intValue()).array();
        } else {
            bArrArray = new byte[0];
        }
        return new zzgrt(zzggpVar, zzgvzVarZzc, bArrArray);
    }
}
