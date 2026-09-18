package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgmd {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxq zzb;
    private static final zzgom zzc;
    private static final zzgoi zzd;
    private static final zzgnl zze;
    private static final zzgnh zzf;

    static {
        zzgxq zzgxqVarZza = zzgpm.zza("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzb = zzgxqVarZza;
        zzc = zzgom.zzb(new zzgok() { // from class: com.google.android.gms.internal.ads.zzglz
            @Override // com.google.android.gms.internal.ads.zzgok
            public final zzgpc zza(zzggq zzggqVar) {
                return zzgmd.zzd((zzgji) zzggqVar);
            }
        }, zzgji.class, zzgoy.class);
        zzd = zzgoi.zzb(new zzgog() { // from class: com.google.android.gms.internal.ads.zzgma
            @Override // com.google.android.gms.internal.ads.zzgog
            public final zzggq zza(zzgpc zzgpcVar) {
                return zzgmd.zzb((zzgoy) zzgpcVar);
            }
        }, zzgxqVarZza, zzgoy.class);
        zze = zzgnl.zzb(new zzgnj() { // from class: com.google.android.gms.internal.ads.zzgmb
            @Override // com.google.android.gms.internal.ads.zzgnj
            public final zzgpc zza(zzggc zzggcVar, zzghc zzghcVar) {
                return zzgmd.zzc((zzgiz) zzggcVar, zzghcVar);
            }
        }, zzgiz.class, zzgox.class);
        zzf = zzgnh.zzb(new zzgnf() { // from class: com.google.android.gms.internal.ads.zzgmc
            @Override // com.google.android.gms.internal.ads.zzgnf
            public final zzggc zza(zzgpc zzgpcVar, zzghc zzghcVar) {
                return zzgmd.zza((zzgox) zzgpcVar, zzghcVar);
            }
        }, zzgxqVarZza, zzgox.class);
    }

    public static /* synthetic */ zzgiz zza(zzgox zzgoxVar, zzghc zzghcVar) throws GeneralSecurityException {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseKey");
        }
        try {
            zzgto zzgtoVarZze = zzgto.zze(zzgoxVar.zze(), zzgzf.zza());
            if (zzgtoVarZze.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzgjf zzgjfVarZzc = zzgji.zzc();
            zzgjfVarZzc.zzb(zzgtoVarZze.zzf().zzd());
            zzgjfVarZzc.zza(12);
            zzgjfVarZzc.zzc(16);
            zzgjfVarZzc.zzd(zzf(zzgoxVar.zzc()));
            zzgji zzgjiVarZze = zzgjfVarZzc.zze();
            zzgix zzgixVarZza = zzgiz.zza();
            zzgixVarZza.zzc(zzgjiVarZze);
            zzgixVarZza.zzb(zzgxr.zzb(zzgtoVarZze.zzf().zzA(), zzghcVar));
            zzgixVarZza.zza(zzgoxVar.zzf());
            return zzgixVarZza.zzd();
        } catch (zzhag unused) {
            throw new GeneralSecurityException("Parsing AesGcmKey failed");
        }
    }

    public static /* synthetic */ zzgji zzb(zzgoy zzgoyVar) throws GeneralSecurityException {
        if (!zzgoyVar.zzc().zzh().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzh())));
        }
        try {
            zzgtr zzgtrVarZzf = zzgtr.zzf(zzgoyVar.zzc().zzg(), zzgzf.zza());
            if (zzgtrVarZzf.zzc() != 0) {
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            }
            zzgjf zzgjfVarZzc = zzgji.zzc();
            zzgjfVarZzc.zzb(zzgtrVarZzf.zza());
            zzgjfVarZzc.zza(12);
            zzgjfVarZzc.zzc(16);
            zzgjfVarZzc.zzd(zzf(zzgoyVar.zzc().zzf()));
            return zzgjfVarZzc.zze();
        } catch (zzhag e) {
            throw new GeneralSecurityException("Parsing AesGcmParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzgiz zzgizVar, zzghc zzghcVar) {
        zzgtn zzgtnVarZzc = zzgto.zzc();
        byte[] bArrZzd = zzgizVar.zzd().zzd(zzghcVar);
        zzgtnVarZzc.zza(zzgyl.zzv(bArrZzd, 0, bArrZzd.length));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.AesGcmKey", ((zzgto) zzgtnVarZzc.zzal()).zzau(), zzgus.SYMMETRIC, zzg(zzgizVar.zzb().zzd()), zzgizVar.zze());
    }

    public static /* synthetic */ zzgoy zzd(zzgji zzgjiVar) {
        zzgux zzguxVarZza = zzguy.zza();
        zzguxVarZza.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzgtq zzgtqVarZzd = zzgtr.zzd();
        zzgtqVarZzd.zza(zzgjiVar.zzb());
        zzguxVarZza.zzc(((zzgtr) zzgtqVarZzd.zzal()).zzau());
        zzguxVarZza.zza(zzg(zzgjiVar.zzd()));
        return zzgoy.zzb((zzguy) zzguxVarZza.zzal());
    }

    public static void zze(zzgoe zzgoeVar) throws GeneralSecurityException {
        zzgoeVar.zzj(zzc);
        zzgoeVar.zzi(zzd);
        zzgoeVar.zzh(zze);
        zzgoeVar.zzg(zzf);
    }

    private static zzgjg zzf(zzgvz zzgvzVar) throws GeneralSecurityException {
        zzgvz zzgvzVar2 = zzgvz.UNKNOWN_PREFIX;
        int iOrdinal = zzgvzVar.ordinal();
        if (iOrdinal == 1) {
            return zzgjg.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzgjg.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgvzVar.zza());
            }
        }
        return zzgjg.zzb;
    }

    private static zzgvz zzg(zzgjg zzgjgVar) throws GeneralSecurityException {
        if (zzgjg.zza.equals(zzgjgVar)) {
            return zzgvz.TINK;
        }
        if (zzgjg.zzb.equals(zzgjgVar)) {
            return zzgvz.CRUNCHY;
        }
        if (zzgjg.zzc.equals(zzgjgVar)) {
            return zzgvz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzgjgVar))));
    }
}
