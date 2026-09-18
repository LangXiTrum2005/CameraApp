package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgms {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxq zzb;
    private static final zzgom zzc;
    private static final zzgoi zzd;
    private static final zzgnl zze;
    private static final zzgnh zzf;

    static {
        zzgxq zzgxqVarZza = zzgpm.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zzb = zzgxqVarZza;
        zzc = zzgom.zzb(new zzgok() { // from class: com.google.android.gms.internal.ads.zzgmo
            @Override // com.google.android.gms.internal.ads.zzgok
            public final zzgpc zza(zzggq zzggqVar) {
                return zzgms.zzd((zzgly) zzggqVar);
            }
        }, zzgly.class, zzgoy.class);
        zzd = zzgoi.zzb(new zzgog() { // from class: com.google.android.gms.internal.ads.zzgmp
            @Override // com.google.android.gms.internal.ads.zzgog
            public final zzggq zza(zzgpc zzgpcVar) {
                return zzgms.zzb((zzgoy) zzgpcVar);
            }
        }, zzgxqVarZza, zzgoy.class);
        zze = zzgnl.zzb(new zzgnj() { // from class: com.google.android.gms.internal.ads.zzgmq
            @Override // com.google.android.gms.internal.ads.zzgnj
            public final zzgpc zza(zzggc zzggcVar, zzghc zzghcVar) {
                return zzgms.zzc((zzgls) zzggcVar, zzghcVar);
            }
        }, zzgls.class, zzgox.class);
        zzf = zzgnh.zzb(new zzgnf() { // from class: com.google.android.gms.internal.ads.zzgmr
            @Override // com.google.android.gms.internal.ads.zzgnf
            public final zzggc zza(zzgpc zzgpcVar, zzghc zzghcVar) {
                return zzgms.zza((zzgox) zzgpcVar, zzghcVar);
            }
        }, zzgxqVarZza, zzgox.class);
    }

    public static /* synthetic */ zzgls zza(zzgox zzgoxVar, zzghc zzghcVar) throws GeneralSecurityException {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseKey");
        }
        try {
            zzgwf zzgwfVarZze = zzgwf.zze(zzgoxVar.zze(), zzgzf.zza());
            if (zzgwfVarZze.zza() == 0) {
                return zzgls.zza(zzf(zzgoxVar.zzc()), zzgxr.zzb(zzgwfVarZze.zzf().zzA(), zzghcVar), zzgoxVar.zzf());
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzhag unused) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
        }
    }

    public static /* synthetic */ zzgly zzb(zzgoy zzgoyVar) throws GeneralSecurityException {
        if (!zzgoyVar.zzc().zzh().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzh())));
        }
        try {
            if (zzgwi.zze(zzgoyVar.zzc().zzg(), zzgzf.zza()).zza() == 0) {
                return zzgly.zzc(zzf(zzgoyVar.zzc().zzf()));
            }
            throw new GeneralSecurityException("Only version 0 parameters are accepted");
        } catch (zzhag e) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Parameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzgls zzglsVar, zzghc zzghcVar) {
        zzgwe zzgweVarZzc = zzgwf.zzc();
        byte[] bArrZzd = zzglsVar.zzd().zzd(zzghcVar);
        zzgweVarZzc.zza(zzgyl.zzv(bArrZzd, 0, bArrZzd.length));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", ((zzgwf) zzgweVarZzc.zzal()).zzau(), zzgus.SYMMETRIC, zzg(zzglsVar.zzb().zzb()), zzglsVar.zze());
    }

    public static /* synthetic */ zzgoy zzd(zzgly zzglyVar) {
        zzgux zzguxVarZza = zzguy.zza();
        zzguxVarZza.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zzguxVarZza.zzc(zzgwi.zzd().zzau());
        zzguxVarZza.zza(zzg(zzglyVar.zzb()));
        return zzgoy.zzb((zzguy) zzguxVarZza.zzal());
    }

    public static void zze(zzgoe zzgoeVar) throws GeneralSecurityException {
        zzgoeVar.zzj(zzc);
        zzgoeVar.zzi(zzd);
        zzgoeVar.zzh(zze);
        zzgoeVar.zzg(zzf);
    }

    private static zzglx zzf(zzgvz zzgvzVar) throws GeneralSecurityException {
        zzgvz zzgvzVar2 = zzgvz.UNKNOWN_PREFIX;
        int iOrdinal = zzgvzVar.ordinal();
        if (iOrdinal == 1) {
            return zzglx.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzglx.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgvzVar.zza());
            }
        }
        return zzglx.zzb;
    }

    private static zzgvz zzg(zzglx zzglxVar) throws GeneralSecurityException {
        if (zzglx.zza.equals(zzglxVar)) {
            return zzgvz.TINK;
        }
        if (zzglx.zzb.equals(zzglxVar)) {
            return zzgvz.CRUNCHY;
        }
        if (zzglx.zzc.equals(zzglxVar)) {
            return zzgvz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzglxVar.toString()));
    }
}
