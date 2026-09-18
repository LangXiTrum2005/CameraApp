package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgiv {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxq zzb;
    private static final zzgom zzc;
    private static final zzgoi zzd;
    private static final zzgnl zze;
    private static final zzgnh zzf;

    static {
        zzgxq zzgxqVarZza = zzgpm.zza("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = zzgxqVarZza;
        zzc = zzgom.zzb(new zzgok() { // from class: com.google.android.gms.internal.ads.zzgir
            @Override // com.google.android.gms.internal.ads.zzgok
            public final zzgpc zza(zzggq zzggqVar) {
                return zzgiv.zzd((zzgiq) zzggqVar);
            }
        }, zzgiq.class, zzgoy.class);
        zzd = zzgoi.zzb(new zzgog() { // from class: com.google.android.gms.internal.ads.zzgis
            @Override // com.google.android.gms.internal.ads.zzgog
            public final zzggq zza(zzgpc zzgpcVar) {
                return zzgiv.zzb((zzgoy) zzgpcVar);
            }
        }, zzgxqVarZza, zzgoy.class);
        zze = zzgnl.zzb(new zzgnj() { // from class: com.google.android.gms.internal.ads.zzgit
            @Override // com.google.android.gms.internal.ads.zzgnj
            public final zzgpc zza(zzggc zzggcVar, zzghc zzghcVar) {
                return zzgiv.zzc((zzgii) zzggcVar, zzghcVar);
            }
        }, zzgii.class, zzgox.class);
        zzf = zzgnh.zzb(new zzgnf() { // from class: com.google.android.gms.internal.ads.zzgiu
            @Override // com.google.android.gms.internal.ads.zzgnf
            public final zzggc zza(zzgpc zzgpcVar, zzghc zzghcVar) {
                return zzgiv.zza((zzgox) zzgpcVar, zzghcVar);
            }
        }, zzgxqVarZza, zzgox.class);
    }

    public static /* synthetic */ zzgii zza(zzgox zzgoxVar, zzghc zzghcVar) throws GeneralSecurityException {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseKey");
        }
        try {
            zzgtf zzgtfVarZze = zzgtf.zze(zzgoxVar.zze(), zzgzf.zza());
            if (zzgtfVarZze.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzgin zzginVar = new zzgin(null);
            zzginVar.zzb(zzgtfVarZze.zzg().zzd());
            zzginVar.zza(zzgtfVarZze.zzf().zza());
            zzginVar.zzc(16);
            zzginVar.zzd(zzf(zzgoxVar.zzc()));
            zzgiq zzgiqVarZze = zzginVar.zze();
            zzgig zzgigVar = new zzgig(null);
            zzgigVar.zzc(zzgiqVarZze);
            zzgigVar.zzb(zzgxr.zzb(zzgtfVarZze.zzg().zzA(), zzghcVar));
            zzgigVar.zza(zzgoxVar.zzf());
            return zzgigVar.zzd();
        } catch (zzhag unused) {
            throw new GeneralSecurityException("Parsing AesEaxcKey failed");
        }
    }

    public static /* synthetic */ zzgiq zzb(zzgoy zzgoyVar) throws GeneralSecurityException {
        if (!zzgoyVar.zzc().zzh().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzh())));
        }
        try {
            zzgti zzgtiVarZze = zzgti.zze(zzgoyVar.zzc().zzg(), zzgzf.zza());
            zzgin zzginVar = new zzgin(null);
            zzginVar.zzb(zzgtiVarZze.zza());
            zzginVar.zza(zzgtiVarZze.zzf().zza());
            zzginVar.zzc(16);
            zzginVar.zzd(zzf(zzgoyVar.zzc().zzf()));
            return zzginVar.zze();
        } catch (zzhag e) {
            throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzgii zzgiiVar, zzghc zzghcVar) {
        zzgte zzgteVarZzc = zzgtf.zzc();
        zzgteVarZzc.zzb(zzg(zzgiiVar.zza()));
        byte[] bArrZzd = zzgiiVar.zzc().zzd(zzghcVar);
        zzgteVarZzc.zza(zzgyl.zzv(bArrZzd, 0, bArrZzd.length));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.AesEaxKey", ((zzgtf) zzgteVarZzc.zzal()).zzau(), zzgus.SYMMETRIC, zzh(zzgiiVar.zza().zzd()), zzgiiVar.zzd());
    }

    public static /* synthetic */ zzgoy zzd(zzgiq zzgiqVar) {
        zzgux zzguxVarZza = zzguy.zza();
        zzguxVarZza.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzgth zzgthVarZzc = zzgti.zzc();
        zzgthVarZzc.zzb(zzg(zzgiqVar));
        zzgthVarZzc.zza(zzgiqVar.zzc());
        zzguxVarZza.zzc(((zzgti) zzgthVarZzc.zzal()).zzau());
        zzguxVarZza.zza(zzh(zzgiqVar.zzd()));
        return zzgoy.zzb((zzguy) zzguxVarZza.zzal());
    }

    public static void zze(zzgoe zzgoeVar) throws GeneralSecurityException {
        zzgoeVar.zzj(zzc);
        zzgoeVar.zzi(zzd);
        zzgoeVar.zzh(zze);
        zzgoeVar.zzg(zzf);
    }

    private static zzgio zzf(zzgvz zzgvzVar) throws GeneralSecurityException {
        zzgvz zzgvzVar2 = zzgvz.UNKNOWN_PREFIX;
        int iOrdinal = zzgvzVar.ordinal();
        if (iOrdinal == 1) {
            return zzgio.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzgio.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgvzVar.zza());
            }
        }
        return zzgio.zzb;
    }

    private static zzgtl zzg(zzgiq zzgiqVar) throws GeneralSecurityException {
        zzgtk zzgtkVarZzc = zzgtl.zzc();
        zzgtkVarZzc.zza(zzgiqVar.zzb());
        return (zzgtl) zzgtkVarZzc.zzal();
    }

    private static zzgvz zzh(zzgio zzgioVar) throws GeneralSecurityException {
        if (zzgio.zza.equals(zzgioVar)) {
            return zzgvz.TINK;
        }
        if (zzgio.zzb.equals(zzgioVar)) {
            return zzgvz.CRUNCHY;
        }
        if (zzgio.zzc.equals(zzgioVar)) {
            return zzgvz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzgioVar))));
    }
}
