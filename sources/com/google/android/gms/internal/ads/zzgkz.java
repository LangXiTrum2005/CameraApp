package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgkz {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxq zzb;
    private static final zzgom zzc;
    private static final zzgoi zzd;
    private static final zzgnl zze;
    private static final zzgnh zzf;

    static {
        zzgxq zzgxqVarZza = zzgpm.zza("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        zzb = zzgxqVarZza;
        zzc = zzgom.zzb(new zzgok() { // from class: com.google.android.gms.internal.ads.zzgkv
            @Override // com.google.android.gms.internal.ads.zzgok
            public final zzgpc zza(zzggq zzggqVar) {
                int i = zzgkz.zza;
                zzgux zzguxVarZza = zzguy.zza();
                zzguxVarZza.zzb("type.googleapis.com/google.crypto.tink.KmsAeadKey");
                zzgvq zzgvqVarZza = zzgvr.zza();
                zzgvqVarZza.zza(((zzgku) zzggqVar).zzc());
                zzguxVarZza.zzc(((zzgvr) zzgvqVarZza.zzal()).zzau());
                zzguxVarZza.zza(zzgvz.RAW);
                return zzgoy.zzb((zzguy) zzguxVarZza.zzal());
            }
        }, zzgku.class, zzgoy.class);
        zzd = zzgoi.zzb(new zzgog() { // from class: com.google.android.gms.internal.ads.zzgkw
            @Override // com.google.android.gms.internal.ads.zzgog
            public final zzggq zza(zzgpc zzgpcVar) throws GeneralSecurityException {
                int i = zzgkz.zza;
                zzgoy zzgoyVar = (zzgoy) zzgpcVar;
                if (!zzgoyVar.zzc().zzh().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
                    throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzh())));
                }
                try {
                    zzgvr zzgvrVarZze = zzgvr.zze(((zzgoy) zzgpcVar).zzc().zzg(), zzgzf.zza());
                    if (zzgoyVar.zzc().zzf() == zzgvz.RAW) {
                        return zzgku.zzb(zzgvrVarZze.zzf());
                    }
                    throw new GeneralSecurityException("Only key templates with RAW are accepted, but got " + String.valueOf(zzgoyVar.zzc().zzf()) + " with format " + String.valueOf(zzgvrVarZze));
                } catch (zzhag e) {
                    throw new GeneralSecurityException("Parsing KmsAeadKeyFormat failed: ", e);
                }
            }
        }, zzgxqVarZza, zzgoy.class);
        zze = zzgnl.zzb(new zzgnj() { // from class: com.google.android.gms.internal.ads.zzgkx
            @Override // com.google.android.gms.internal.ads.zzgnj
            public final zzgpc zza(zzggc zzggcVar, zzghc zzghcVar) {
                int i = zzgkz.zza;
                zzgvn zzgvnVarZzc = zzgvo.zzc();
                zzgvq zzgvqVarZza = zzgvr.zza();
                zzgvqVarZza.zza(((zzgkt) zzggcVar).zzb().zzc());
                zzgvnVarZzc.zza((zzgvr) zzgvqVarZza.zzal());
                return zzgox.zza("type.googleapis.com/google.crypto.tink.KmsAeadKey", ((zzgvo) zzgvnVarZzc.zzal()).zzau(), zzgus.REMOTE, zzgvz.RAW, null);
            }
        }, zzgkt.class, zzgox.class);
        zzf = zzgnh.zzb(new zzgnf() { // from class: com.google.android.gms.internal.ads.zzgky
            @Override // com.google.android.gms.internal.ads.zzgnf
            public final zzggc zza(zzgpc zzgpcVar, zzghc zzghcVar) throws GeneralSecurityException {
                int i = zzgkz.zza;
                zzgox zzgoxVar = (zzgox) zzgpcVar;
                if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
                    throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseKey");
                }
                if (zzgoxVar.zzc() != zzgvz.RAW) {
                    throw new GeneralSecurityException("KmsAeadKey are only accepted with RAW, got ".concat(String.valueOf(String.valueOf(zzgoxVar.zzc()))));
                }
                try {
                    zzgvo zzgvoVarZze = zzgvo.zze(((zzgox) zzgpcVar).zze(), zzgzf.zza());
                    if (zzgvoVarZze.zza() == 0) {
                        return zzgkt.zza(zzgku.zzb(zzgvoVarZze.zzf().zzf()));
                    }
                    throw new GeneralSecurityException("KmsAeadKey are only accepted with version 0, got " + String.valueOf(zzgvoVarZze));
                } catch (zzhag e) {
                    throw new GeneralSecurityException("Parsing KmsAeadKey failed: ", e);
                }
            }
        }, zzgxqVarZza, zzgox.class);
    }

    public static void zza(zzgoe zzgoeVar) throws GeneralSecurityException {
        zzgoeVar.zzj(zzc);
        zzgoeVar.zzi(zzd);
        zzgoeVar.zzh(zze);
        zzgoeVar.zzg(zzf);
    }
}
