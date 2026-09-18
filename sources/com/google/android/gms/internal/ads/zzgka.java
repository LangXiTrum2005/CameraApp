package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgka {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxq zzb;
    private static final zzgom zzc;
    private static final zzgoi zzd;
    private static final zzgnl zze;
    private static final zzgnh zzf;

    static {
        zzgxq zzgxqVarZza = zzgpm.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzb = zzgxqVarZza;
        zzc = zzgom.zzb(new zzgok() { // from class: com.google.android.gms.internal.ads.zzgjw
            @Override // com.google.android.gms.internal.ads.zzgok
            public final zzgpc zza(zzggq zzggqVar) {
                return zzgka.zzd((zzgjv) zzggqVar);
            }
        }, zzgjv.class, zzgoy.class);
        zzd = zzgoi.zzb(new zzgog() { // from class: com.google.android.gms.internal.ads.zzgjx
            @Override // com.google.android.gms.internal.ads.zzgog
            public final zzggq zza(zzgpc zzgpcVar) {
                return zzgka.zzb((zzgoy) zzgpcVar);
            }
        }, zzgxqVarZza, zzgoy.class);
        zze = zzgnl.zzb(new zzgnj() { // from class: com.google.android.gms.internal.ads.zzgjy
            @Override // com.google.android.gms.internal.ads.zzgnj
            public final zzgpc zza(zzggc zzggcVar, zzghc zzghcVar) {
                return zzgka.zzc((zzgjm) zzggcVar, zzghcVar);
            }
        }, zzgjm.class, zzgox.class);
        zzf = zzgnh.zzb(new zzgnf() { // from class: com.google.android.gms.internal.ads.zzgjz
            @Override // com.google.android.gms.internal.ads.zzgnf
            public final zzggc zza(zzgpc zzgpcVar, zzghc zzghcVar) {
                return zzgka.zza((zzgox) zzgpcVar, zzghcVar);
            }
        }, zzgxqVarZza, zzgox.class);
    }

    public static /* synthetic */ zzgjm zza(zzgox zzgoxVar, zzghc zzghcVar) throws GeneralSecurityException {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseKey");
        }
        try {
            zzgtu zzgtuVarZze = zzgtu.zze(zzgoxVar.zze(), zzgzf.zza());
            if (zzgtuVarZze.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzgjs zzgjsVar = new zzgjs(null);
            zzgjsVar.zza(zzgtuVarZze.zzf().zzd());
            zzgjsVar.zzb(zzf(zzgoxVar.zzc()));
            zzgjv zzgjvVarZzc = zzgjsVar.zzc();
            zzgjk zzgjkVar = new zzgjk(null);
            zzgjkVar.zzc(zzgjvVarZzc);
            zzgjkVar.zzb(zzgxr.zzb(zzgtuVarZze.zzf().zzA(), zzghcVar));
            zzgjkVar.zza(zzgoxVar.zzf());
            return zzgjkVar.zzd();
        } catch (zzhag unused) {
            throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
        }
    }

    public static /* synthetic */ zzgjv zzb(zzgoy zzgoyVar) throws GeneralSecurityException {
        if (!zzgoyVar.zzc().zzh().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzh())));
        }
        try {
            zzgtx zzgtxVarZzf = zzgtx.zzf(zzgoyVar.zzc().zzg(), zzgzf.zza());
            if (zzgtxVarZzf.zzc() != 0) {
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            }
            zzgjs zzgjsVar = new zzgjs(null);
            zzgjsVar.zza(zzgtxVarZzf.zza());
            zzgjsVar.zzb(zzf(zzgoyVar.zzc().zzf()));
            return zzgjsVar.zzc();
        } catch (zzhag e) {
            throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzgjm zzgjmVar, zzghc zzghcVar) {
        zzgtt zzgttVarZzc = zzgtu.zzc();
        byte[] bArrZzd = zzgjmVar.zzc().zzd(zzghcVar);
        zzgttVarZzc.zza(zzgyl.zzv(bArrZzd, 0, bArrZzd.length));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey", ((zzgtu) zzgttVarZzc.zzal()).zzau(), zzgus.SYMMETRIC, zzg(zzgjmVar.zza().zzc()), zzgjmVar.zzd());
    }

    public static /* synthetic */ zzgoy zzd(zzgjv zzgjvVar) {
        zzgux zzguxVarZza = zzguy.zza();
        zzguxVarZza.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzgtw zzgtwVarZzd = zzgtx.zzd();
        zzgtwVarZzd.zza(zzgjvVar.zzb());
        zzguxVarZza.zzc(((zzgtx) zzgtwVarZzd.zzal()).zzau());
        zzguxVarZza.zza(zzg(zzgjvVar.zzc()));
        return zzgoy.zzb((zzguy) zzguxVarZza.zzal());
    }

    public static void zze(zzgoe zzgoeVar) throws GeneralSecurityException {
        zzgoeVar.zzj(zzc);
        zzgoeVar.zzi(zzd);
        zzgoeVar.zzh(zze);
        zzgoeVar.zzg(zzf);
    }

    private static zzgjt zzf(zzgvz zzgvzVar) throws GeneralSecurityException {
        zzgvz zzgvzVar2 = zzgvz.UNKNOWN_PREFIX;
        int iOrdinal = zzgvzVar.ordinal();
        if (iOrdinal == 1) {
            return zzgjt.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzgjt.zzc;
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzgvzVar.zza());
            }
        }
        return zzgjt.zzb;
    }

    private static zzgvz zzg(zzgjt zzgjtVar) throws GeneralSecurityException {
        if (zzgjt.zza.equals(zzgjtVar)) {
            return zzgvz.TINK;
        }
        if (zzgjt.zzb.equals(zzgjtVar)) {
            return zzgvz.CRUNCHY;
        }
        if (zzgjt.zzc.equals(zzgjtVar)) {
            return zzgvz.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(String.valueOf(zzgjtVar))));
    }
}
