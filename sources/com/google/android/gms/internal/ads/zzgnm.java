package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgnm implements zzggd {
    final String zza;
    final Class zzb;
    final zzgus zzc;
    final zzhbl zzd;

    zzgnm(String str, Class cls, zzgus zzgusVar, zzhbl zzhblVar) {
        this.zzd = zzhblVar;
        this.zza = str;
        this.zzb = cls;
        this.zzc = zzgusVar;
    }

    public static zzggd zzd(String str, Class cls, zzgus zzgusVar, zzhbl zzhblVar) {
        return new zzgnm(str, cls, zzgusVar, zzhblVar);
    }

    @Override // com.google.android.gms.internal.ads.zzggd
    public final zzgut zza(zzgyl zzgylVar) throws GeneralSecurityException {
        zzgux zzguxVarZza = zzguy.zza();
        zzguxVarZza.zzb(this.zza);
        zzguxVarZza.zzc(zzgylVar);
        zzguxVarZza.zza(zzgvz.RAW);
        zzgpc zzgpcVarZze = zzgoe.zzd().zze(zzgnu.zzb().zza(zzgoe.zzd().zzc(zzgoy.zza((zzguy) zzguxVarZza.zzal())), null), zzgox.class, zzggb.zza());
        zzguq zzguqVarZza = zzgut.zza();
        zzgox zzgoxVar = (zzgox) zzgpcVarZze;
        zzguqVarZza.zzb(zzgoxVar.zzg());
        zzguqVarZza.zzc(zzgoxVar.zze());
        zzguqVarZza.zza(zzgoxVar.zzb());
        return (zzgut) zzguqVarZza.zzal();
    }

    @Override // com.google.android.gms.internal.ads.zzggd
    public final Class zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzggd
    public final Object zzc(zzgyl zzgylVar) throws GeneralSecurityException {
        return zzgob.zza().zzc(zzgoe.zzd().zza(zzgox.zza(this.zza, zzgylVar, this.zzc, zzgvz.RAW, null), zzggb.zza()), this.zzb);
    }
}
