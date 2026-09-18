package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgrs {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxq zzb;
    private static final zzgna zzc;
    private static final zzgna zzd;
    private static final zzgom zze;
    private static final zzgoi zzf;
    private static final zzgnl zzg;
    private static final zzgnh zzh;

    static {
        zzgxq zzgxqVarZza = zzgpm.zza("type.googleapis.com/google.crypto.tink.HmacKey");
        zzb = zzgxqVarZza;
        zzgmy zzgmyVarZza = zzgna.zza();
        zzgmyVarZza.zza(zzgvz.RAW, zzgqv.zzd);
        zzgmyVarZza.zza(zzgvz.TINK, zzgqv.zza);
        zzgmyVarZza.zza(zzgvz.LEGACY, zzgqv.zzc);
        zzgmyVarZza.zza(zzgvz.CRUNCHY, zzgqv.zzb);
        zzc = zzgmyVarZza.zzb();
        zzgmy zzgmyVarZza2 = zzgna.zza();
        zzgmyVarZza2.zza(zzguf.SHA1, zzgqu.zza);
        zzgmyVarZza2.zza(zzguf.SHA224, zzgqu.zzb);
        zzgmyVarZza2.zza(zzguf.SHA256, zzgqu.zzc);
        zzgmyVarZza2.zza(zzguf.SHA384, zzgqu.zzd);
        zzgmyVarZza2.zza(zzguf.SHA512, zzgqu.zze);
        zzd = zzgmyVarZza2.zzb();
        zze = zzgom.zzb(new zzgok() { // from class: com.google.android.gms.internal.ads.zzgro
            @Override // com.google.android.gms.internal.ads.zzgok
            public final zzgpc zza(zzggq zzggqVar) {
                return zzgrs.zzb((zzgqx) zzggqVar);
            }
        }, zzgqx.class, zzgoy.class);
        zzf = zzgoi.zzb(new zzgog() { // from class: com.google.android.gms.internal.ads.zzgrp
            @Override // com.google.android.gms.internal.ads.zzgog
            public final zzggq zza(zzgpc zzgpcVar) {
                return zzgrs.zzd((zzgoy) zzgpcVar);
            }
        }, zzgxqVarZza, zzgoy.class);
        zzg = zzgnl.zzb(new zzgnj() { // from class: com.google.android.gms.internal.ads.zzgrq
            @Override // com.google.android.gms.internal.ads.zzgnj
            public final zzgpc zza(zzggc zzggcVar, zzghc zzghcVar) {
                return zzgrs.zza((zzgqm) zzggcVar, zzghcVar);
            }
        }, zzgqm.class, zzgox.class);
        zzh = zzgnh.zzb(new zzgnf() { // from class: com.google.android.gms.internal.ads.zzgrr
            @Override // com.google.android.gms.internal.ads.zzgnf
            public final zzggc zza(zzgpc zzgpcVar, zzghc zzghcVar) {
                return zzgrs.zzc((zzgox) zzgpcVar, zzghcVar);
            }
        }, zzgxqVarZza, zzgox.class);
    }

    public static /* synthetic */ zzgox zza(zzgqm zzgqmVar, zzghc zzghcVar) {
        zzguh zzguhVarZzc = zzgui.zzc();
        zzguhVarZzc.zzb(zzf(zzgqmVar.zzd()));
        byte[] bArrZzd = zzgqmVar.zze().zzd(zzghcVar);
        zzguhVarZzc.zza(zzgyl.zzv(bArrZzd, 0, bArrZzd.length));
        return zzgox.zza("type.googleapis.com/google.crypto.tink.HmacKey", ((zzgui) zzguhVarZzc.zzal()).zzau(), zzgus.SYMMETRIC, (zzgvz) zzc.zzb(zzgqmVar.zzd().zzg()), zzgqmVar.zzf());
    }

    public static /* synthetic */ zzgoy zzb(zzgqx zzgqxVar) {
        zzgux zzguxVarZza = zzguy.zza();
        zzguxVarZza.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zzguk zzgukVarZzd = zzgul.zzd();
        zzgukVarZzd.zzb(zzf(zzgqxVar));
        zzgukVarZzd.zza(zzgqxVar.zzc());
        zzguxVarZza.zzc(((zzgul) zzgukVarZzd.zzal()).zzau());
        zzguxVarZza.zza((zzgvz) zzc.zzb(zzgqxVar.zzg()));
        return zzgoy.zzb((zzguy) zzguxVarZza.zzal());
    }

    public static /* synthetic */ zzgqm zzc(zzgox zzgoxVar, zzghc zzghcVar) throws GeneralSecurityException {
        if (!zzgoxVar.zzg().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
        }
        try {
            zzgui zzguiVarZzf = zzgui.zzf(zzgoxVar.zze(), zzgzf.zza());
            if (zzguiVarZzf.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzgqt zzgqtVarZze = zzgqx.zze();
            zzgqtVarZze.zzb(zzguiVarZzf.zzh().zzd());
            zzgqtVarZze.zzc(zzguiVarZzf.zzg().zza());
            zzgqtVarZze.zza((zzgqu) zzd.zzc(zzguiVarZzf.zzg().zzc()));
            zzgqtVarZze.zzd((zzgqv) zzc.zzc(zzgoxVar.zzc()));
            zzgqx zzgqxVarZze = zzgqtVarZze.zze();
            zzgqk zzgqkVarZza = zzgqm.zza();
            zzgqkVarZza.zzc(zzgqxVarZze);
            zzgqkVarZza.zzb(zzgxr.zzb(zzguiVarZzf.zzh().zzA(), zzghcVar));
            zzgqkVarZza.zza(zzgoxVar.zzf());
            return zzgqkVarZza.zzd();
        } catch (zzhag | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing HmacKey failed");
        }
    }

    public static /* synthetic */ zzgqx zzd(zzgoy zzgoyVar) throws GeneralSecurityException {
        if (!zzgoyVar.zzc().zzh().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: ".concat(String.valueOf(zzgoyVar.zzc().zzh())));
        }
        try {
            zzgul zzgulVarZzg = zzgul.zzg(zzgoyVar.zzc().zzg(), zzgzf.zza());
            if (zzgulVarZzg.zzc() != 0) {
                throw new GeneralSecurityException("Parsing HmacParameters failed: unknown Version " + zzgulVarZzg.zzc());
            }
            zzgqt zzgqtVarZze = zzgqx.zze();
            zzgqtVarZze.zzb(zzgulVarZzg.zza());
            zzgqtVarZze.zzc(zzgulVarZzg.zzh().zza());
            zzgqtVarZze.zza((zzgqu) zzd.zzc(zzgulVarZzg.zzh().zzc()));
            zzgqtVarZze.zzd((zzgqv) zzc.zzc(zzgoyVar.zzc().zzf()));
            return zzgqtVarZze.zze();
        } catch (zzhag e) {
            throw new GeneralSecurityException("Parsing HmacParameters failed: ", e);
        }
    }

    public static void zze(zzgoe zzgoeVar) throws GeneralSecurityException {
        zzgoeVar.zzj(zze);
        zzgoeVar.zzi(zzf);
        zzgoeVar.zzh(zzg);
        zzgoeVar.zzg(zzh);
    }

    private static zzguo zzf(zzgqx zzgqxVar) throws GeneralSecurityException {
        zzgun zzgunVarZzd = zzguo.zzd();
        zzgunVarZzd.zzb(zzgqxVar.zzb());
        zzgunVarZzd.zza((zzguf) zzd.zzb(zzgqxVar.zzf()));
        return (zzguo) zzgunVarZzd.zzal();
    }
}
