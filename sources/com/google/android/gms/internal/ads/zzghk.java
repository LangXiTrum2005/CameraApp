package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzghk implements zzgfs {
    private final zzggx zza;
    private final zzgrx zzb;
    private final zzgrx zzc;

    /* synthetic */ zzghk(zzggx zzggxVar, zzghj zzghjVar) {
        zzgrx zzgrxVarZza;
        this.zza = zzggxVar;
        if (zzggxVar.zzf()) {
            zzgry zzgryVarZzb = zzgnz.zza().zzb();
            zzgsd zzgsdVarZza = zzgns.zza(zzggxVar);
            this.zzb = zzgryVarZzb.zza(zzgsdVarZza, "aead", "encrypt");
            zzgrxVarZza = zzgryVarZzb.zza(zzgsdVarZza, "aead", "decrypt");
        } else {
            zzgrxVarZza = zzgns.zza;
            this.zzb = zzgrxVarZza;
        }
        this.zzc = zzgrxVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzgfs
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length > 5) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 5, length);
            for (zzggt zzggtVar : this.zza.zze(bArrCopyOf)) {
                try {
                    byte[] bArrZza = ((zzgfs) zzggtVar.zze()).zza(bArrCopyOfRange, bArr2);
                    zzggtVar.zza();
                    int length2 = bArrCopyOfRange.length;
                    return bArrZza;
                } catch (GeneralSecurityException unused) {
                }
            }
        }
        for (zzggt zzggtVar2 : this.zza.zze(zzgfx.zza)) {
            try {
                byte[] bArrZza2 = ((zzgfs) zzggtVar2.zze()).zza(bArr, bArr2);
                zzggtVar2.zza();
                int length3 = bArr.length;
                return bArrZza2;
            } catch (GeneralSecurityException unused2) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }
}
