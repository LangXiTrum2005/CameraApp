package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzglk {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxq zzb;
    private static final zzgom zzc;
    private static final zzgoi zzd;
    private static final zzgnl zze;
    private static final zzgnh zzf;

    static {
        zzgxq zzgxqVarZza = zzgpm.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zzb = zzgxqVarZza;
        zzc = zzgom.zzb(new zzgok() { // from class: com.google.android.gms.internal.ads.zzglg
            @Override // com.google.android.gms.internal.ads.zzgok
            public final zzgpc zza(zzggq zzggqVar) {
                return zzglk.zzd((zzglf) zzggqVar);
            }
        }, zzglf.class, zzgoy.class);
        zzd = zzgoi.zzb(new zzgog() { // from class: com.google.android.gms.internal.ads.zzglh
            @Override // com.google.android.gms.internal.ads.zzgog
            public final zzggq zza(zzgpc zzgpcVar) {
                return zzglk.zzb((zzgoy) zzgpcVar);
            }
        }, zzgxqVarZza, zzgoy.class);
        zze = zzgnl.zzb(new zzgnj() { // from class: com.google.android.gms.internal.ads.zzgli
            @Override // com.google.android.gms.internal.ads.zzgnj
            public final zzgpc zza(zzggc zzggcVar, zzghc zzghcVar) {
                return zzglk.zzc((zzgla) zzggcVar, zzghcVar);
            }
        }, zzgla.class, zzgox.class);
        zzf = zzgnh.zzb(new zzgnf() { // from class: com.google.android.gms.internal.ads.zzglj
            @Override // com.google.android.gms.internal.ads.zzgnf
            public final zzggc zza(zzgpc zzgpcVar, zzghc zzghcVar) {
                return zzglk.zza((zzgox) zzgpcVar, zzghcVar);
            }
        }, zzgxqVarZza, zzgox.class);
    }

    public static /* synthetic */ zzgla zza(zzgox zzgoxVar, zzghc zzghcVar) throws GeneralSecurityException {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseKey");
        }
        try {
            zzgvu zzgvuVarZze = zzgvu.zze(zzgoxVar.zze(), zzgzf.zza());
            if (zzgoxVar.zzc() != zzgvz.RAW) {
                throw new GeneralSecurityException("KmsEnvelopeAeadKeys are only accepted with OutputPrefixType RAW, got " + String.valueOf(zzgvuVarZze));
            }
            if (zzgvuVarZze.zza() == 0) {
                return zzgla.zza(zzf(zzgvuVarZze.zzf()));
            }
            throw new GeneralSecurityException("KmsEnvelopeAeadKeys are only accepted with version 0, got " + String.valueOf(zzgvuVarZze));
        } catch (zzhag e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKey failed: ", e);
        }
    }

    public static /* synthetic */ zzglf zzb(zzgoy zzgoyVar) throws GeneralSecurityException {
        if (!zzgoyVar.zzc().zzh().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzh())));
        }
        try {
            return zzf(zzgvx.zzf(zzgoyVar.zzc().zzg(), zzgzf.zza()));
        } catch (zzhag e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
        }
    }

    public static /* synthetic */ zzgox zzc(zzgla zzglaVar, zzghc zzghcVar) {
        zzgvt zzgvtVarZzc = zzgvu.zzc();
        zzgvtVarZzc.zza(zzg(zzglaVar.zzb()));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", ((zzgvu) zzgvtVarZzc.zzal()).zzau(), zzgus.REMOTE, zzgvz.RAW, null);
    }

    public static /* synthetic */ zzgoy zzd(zzglf zzglfVar) {
        zzgux zzguxVarZza = zzguy.zza();
        zzguxVarZza.zzb("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zzguxVarZza.zzc(zzg(zzglfVar).zzau());
        zzguxVarZza.zza(zzgvz.RAW);
        return zzgoy.zzb((zzguy) zzguxVarZza.zzal());
    }

    public static void zze(zzgoe zzgoeVar) throws GeneralSecurityException {
        zzgoeVar.zzj(zzc);
        zzgoeVar.zzi(zzd);
        zzgoeVar.zzh(zze);
        zzgoeVar.zzg(zzf);
    }

    private static zzglf zzf(zzgvx zzgvxVar) throws GeneralSecurityException {
        zzgld zzgldVar;
        zzgux zzguxVarZza = zzguy.zza();
        zzguxVarZza.zzb(zzgvxVar.zza().zzh());
        zzguxVarZza.zzc(zzgvxVar.zza().zzg());
        zzguxVarZza.zza(zzgvz.RAW);
        zzggq zzggqVarZza = zzghe.zza(((zzguy) zzguxVarZza.zzal()).zzax());
        if (zzggqVarZza instanceof zzgji) {
            zzgldVar = zzgld.zza;
        } else if (zzggqVarZza instanceof zzgkg) {
            zzgldVar = zzgld.zzc;
        } else if (zzggqVarZza instanceof zzgly) {
            zzgldVar = zzgld.zzb;
        } else if (zzggqVarZza instanceof zzghz) {
            zzgldVar = zzgld.zzd;
        } else if (zzggqVarZza instanceof zzgiq) {
            zzgldVar = zzgld.zze;
        } else {
            if (!(zzggqVarZza instanceof zzgjv)) {
                throw new GeneralSecurityException("Unsupported DEK parameters when parsing ".concat(zzggqVarZza.toString()));
            }
            zzgldVar = zzgld.zzf;
        }
        zzglc zzglcVar = new zzglc(null);
        zzglcVar.zzc(zzgvxVar.zzg());
        zzglcVar.zza((zzghi) zzggqVarZza);
        zzglcVar.zzb(zzgldVar);
        return zzglcVar.zzd();
    }

    private static zzgvx zzg(zzglf zzglfVar) throws GeneralSecurityException {
        try {
            zzguy zzguyVarZze = zzguy.zze(zzghe.zzb(zzglfVar.zzb()), zzgzf.zza());
            zzgvw zzgvwVarZzc = zzgvx.zzc();
            zzgvwVarZzc.zzb(zzglfVar.zzc());
            zzgvwVarZzc.zza(zzguyVarZze);
            return (zzgvx) zzgvwVarZzc.zzal();
        } catch (zzhag e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
        }
    }
}
