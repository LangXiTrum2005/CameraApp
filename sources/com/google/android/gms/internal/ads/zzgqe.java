package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgqe {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxq zzb;
    private static final zzgom zzc;
    private static final zzgoi zzd;
    private static final zzgnl zze;
    private static final zzgnh zzf;

    static {
        zzgxq zzgxqVarZza = zzgpm.zza("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzb = zzgxqVarZza;
        zzc = zzgom.zzb(new zzgok() { // from class: com.google.android.gms.internal.ads.zzgqa
            @Override // com.google.android.gms.internal.ads.zzgok
            public final zzgpc zza(zzggq zzggqVar) {
                return zzgqe.zzb((zzgpz) zzggqVar);
            }
        }, zzgpz.class, zzgoy.class);
        zzd = zzgoi.zzb(new zzgog() { // from class: com.google.android.gms.internal.ads.zzgqb
            @Override // com.google.android.gms.internal.ads.zzgog
            public final zzggq zza(zzgpc zzgpcVar) {
                return zzgqe.zzd((zzgoy) zzgpcVar);
            }
        }, zzgxqVarZza, zzgoy.class);
        zze = zzgnl.zzb(new zzgnj() { // from class: com.google.android.gms.internal.ads.zzgqc
            @Override // com.google.android.gms.internal.ads.zzgnj
            public final zzgpc zza(zzggc zzggcVar, zzghc zzghcVar) {
                return zzgqe.zza((zzgpq) zzggcVar, zzghcVar);
            }
        }, zzgpq.class, zzgox.class);
        zzf = zzgnh.zzb(new zzgnf() { // from class: com.google.android.gms.internal.ads.zzgqd
            @Override // com.google.android.gms.internal.ads.zzgnf
            public final zzggc zza(zzgpc zzgpcVar, zzghc zzghcVar) {
                return zzgqe.zzc((zzgox) zzgpcVar, zzghcVar);
            }
        }, zzgxqVarZza, zzgox.class);
    }

    public static /* synthetic */ zzgox zza(zzgpq zzgpqVar, zzghc zzghcVar) {
        zzgsg zzgsgVarZzc = zzgsh.zzc();
        zzgsgVarZzc.zzb(zzg(zzgpqVar.zza()));
        byte[] bArrZzd = zzgpqVar.zzd().zzd(zzghcVar);
        zzgsgVarZzc.zza(zzgyl.zzv(bArrZzd, 0, bArrZzd.length));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.AesCmacKey", ((zzgsh) zzgsgVarZzc.zzal()).zzau(), zzgus.SYMMETRIC, zzh(zzgpqVar.zza().zze()), zzgpqVar.zze());
    }

    public static /* synthetic */ zzgoy zzb(zzgpz zzgpzVar) {
        zzgux zzguxVarZza = zzguy.zza();
        zzguxVarZza.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzgsj zzgsjVarZzc = zzgsk.zzc();
        zzgsjVarZzc.zzb(zzg(zzgpzVar));
        zzgsjVarZzc.zza(zzgpzVar.zzc());
        zzguxVarZza.zzc(((zzgsk) zzgsjVarZzc.zzal()).zzau());
        zzguxVarZza.zza(zzh(zzgpzVar.zze()));
        return zzgoy.zzb((zzguy) zzguxVarZza.zzal());
    }

    public static /* synthetic */ zzgpq zzc(zzgox zzgoxVar, zzghc zzghcVar) throws GeneralSecurityException {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseKey");
        }
        try {
            zzgsh zzgshVarZze = zzgsh.zze(zzgoxVar.zze(), zzgzf.zza());
            if (zzgshVarZze.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzgpw zzgpwVar = new zzgpw(null);
            zzgpwVar.zza(zzgshVarZze.zzg().zzd());
            zzgpwVar.zzb(zzgshVarZze.zzf().zza());
            zzgpwVar.zzc(zzf(zzgoxVar.zzc()));
            zzgpz zzgpzVarZzd = zzgpwVar.zzd();
            zzgpo zzgpoVar = new zzgpo(null);
            zzgpoVar.zzc(zzgpzVarZzd);
            zzgpoVar.zza(zzgxr.zzb(zzgshVarZze.zzg().zzA(), zzghcVar));
            zzgpoVar.zzb(zzgoxVar.zzf());
            return zzgpoVar.zzd();
        } catch (zzhag | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing AesCmacKey failed");
        }
    }

    public static /* synthetic */ zzgpz zzd(zzgoy zzgoyVar) throws GeneralSecurityException {
        if (!zzgoyVar.zzc().zzh().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzh())));
        }
        try {
            zzgsk zzgskVarZze = zzgsk.zze(zzgoyVar.zzc().zzg(), zzgzf.zza());
            zzgpw zzgpwVar = new zzgpw(null);
            zzgpwVar.zza(zzgskVarZze.zza());
            zzgpwVar.zzb(zzgskVarZze.zzf().zza());
            zzgpwVar.zzc(zzf(zzgoyVar.zzc().zzf()));
            return zzgpwVar.zzd();
        } catch (zzhag e) {
            throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e);
        }
    }

    public static void zze(zzgoe zzgoeVar) throws GeneralSecurityException {
        zzgoeVar.zzj(zzc);
        zzgoeVar.zzi(zzd);
        zzgoeVar.zzh(zze);
        zzgoeVar.zzg(zzf);
    }

    private static zzgpx zzf(zzgvz zzgvzVar) throws GeneralSecurityException {
        zzgvz zzgvzVar2 = zzgvz.UNKNOWN_PREFIX;
        int iOrdinal = zzgvzVar.ordinal();
        if (iOrdinal == 1) {
            return zzgpx.zza;
        }
        if (iOrdinal == 2) {
            return zzgpx.zzc;
        }
        if (iOrdinal == 3) {
            return zzgpx.zzd;
        }
        if (iOrdinal == 4) {
            return zzgpx.zzb;
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgvzVar.zza());
    }

    private static zzgsn zzg(zzgpz zzgpzVar) {
        zzgsm zzgsmVarZzc = zzgsn.zzc();
        zzgsmVarZzc.zza(zzgpzVar.zzb());
        return (zzgsn) zzgsmVarZzc.zzal();
    }

    private static zzgvz zzh(zzgpx zzgpxVar) throws GeneralSecurityException {
        if (zzgpx.zza.equals(zzgpxVar)) {
            return zzgvz.TINK;
        }
        if (zzgpx.zzb.equals(zzgpxVar)) {
            return zzgvz.CRUNCHY;
        }
        if (zzgpx.zzd.equals(zzgpxVar)) {
            return zzgvz.RAW;
        }
        if (zzgpx.zzc.equals(zzgpxVar)) {
            return zzgvz.LEGACY;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzgpxVar))));
    }
}
