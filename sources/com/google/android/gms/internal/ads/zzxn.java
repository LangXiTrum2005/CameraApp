package com.google.android.gms.internal.ads;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzxn extends zzyc implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final String zzg;
    private final zzxu zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;
    private final int zzn;
    private final int zzo;
    private final boolean zzp;
    private final int zzq;
    private final int zzr;
    private final int zzs;
    private final int zzt;
    private final boolean zzu;
    private final boolean zzv;

    /* JADX WARN: Multi-variable type inference failed */
    public zzxn(int i, zzcz zzczVar, int i2, zzxu zzxuVar, int i3, boolean z, zzfxf zzfxfVar, int i4) {
        int i5;
        int iZzb;
        int iZzb2;
        boolean z2;
        super(i, zzczVar, i2);
        this.zzh = zzxuVar;
        int i6 = 1;
        int i7 = true != zzxuVar.zzR ? 16 : 24;
        boolean z3 = zzxuVar.zzN;
        this.zzg = zzyg.zzh(this.zzd.zzd);
        this.zzi = zzyg.zzo(i3, false);
        int i8 = 0;
        while (true) {
            i5 = Integer.MAX_VALUE;
            if (i8 >= zzxuVar.zzq.size()) {
                iZzb = 0;
                i8 = Integer.MAX_VALUE;
                break;
            } else {
                iZzb = zzyg.zzb(this.zzd, (String) zzxuVar.zzq.get(i8), false);
                if (iZzb > 0) {
                    break;
                } else {
                    i8++;
                }
            }
        }
        this.zzk = i8;
        this.zzj = iZzb;
        int i9 = this.zzd.zzf;
        int i10 = zzxuVar.zzr;
        this.zzl = zzyg.zza(i9, 0);
        zzam zzamVar = this.zzd;
        int i11 = zzamVar.zzf;
        this.zzm = i11 == 0 || (i11 & 1) != 0;
        this.zzp = 1 == (zzamVar.zze & 1);
        this.zzq = zzamVar.zzz;
        this.zzr = zzamVar.zzA;
        this.zzs = zzamVar.zzi;
        if (zzamVar.zzi != -1) {
            int i12 = zzxuVar.zzt;
        }
        if (zzamVar.zzz != -1) {
            int i13 = zzxuVar.zzs;
        }
        this.zzf = zzfxfVar.zza(zzamVar);
        Configuration configuration = Resources.getSystem().getConfiguration();
        String[] strArrSplit = zzfy.zza >= 24 ? configuration.getLocales().toLanguageTags().split(",", -1) : new String[]{configuration.locale.toLanguageTag()};
        for (int i14 = 0; i14 < strArrSplit.length; i14++) {
            strArrSplit[i14] = zzfy.zzC(strArrSplit[i14]);
        }
        int i15 = 0;
        while (true) {
            if (i15 >= strArrSplit.length) {
                iZzb2 = 0;
                i15 = Integer.MAX_VALUE;
                break;
            } else {
                iZzb2 = zzyg.zzb(this.zzd, strArrSplit[i15], false);
                if (iZzb2 > 0) {
                    break;
                } else {
                    i15++;
                }
            }
        }
        this.zzn = i15;
        this.zzo = iZzb2;
        for (int i16 = 0; i16 < zzxuVar.zzu.size(); i16++) {
            String str = this.zzd.zzm;
            if (str != null && str.equals(zzxuVar.zzu.get(i16))) {
                i5 = i16;
                break;
            }
        }
        this.zzt = i5;
        this.zzu = (i3 & 384) == 128;
        this.zzv = (i3 & 64) == 64;
        zzxu zzxuVar2 = this.zzh;
        if (zzyg.zzo(i3, zzxuVar2.zzT) && ((z2 = this.zzf) || zzxuVar2.zzM)) {
            zzde zzdeVar = zzxuVar2.zzv;
            if (zzyg.zzo(i3, false) && z2 && this.zzd.zzi != -1) {
                boolean z4 = zzxuVar2.zzC;
                boolean z5 = zzxuVar2.zzB;
                if ((zzxuVar2.zzV || !z) && (i7 & i3) != 0) {
                    i6 = 2;
                }
            }
        } else {
            i6 = 0;
        }
        this.zze = i6;
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final /* bridge */ /* synthetic */ boolean zzc(zzyc zzycVar) {
        String str;
        zzxn zzxnVar = (zzxn) zzycVar;
        boolean z = this.zzh.zzP;
        zzam zzamVar = this.zzd;
        int i = zzamVar.zzz;
        if (i == -1) {
            return false;
        }
        zzam zzamVar2 = zzxnVar.zzd;
        if (i != zzamVar2.zzz || (str = zzamVar.zzm) == null || !TextUtils.equals(str, zzamVar2.zzm)) {
            return false;
        }
        zzxu zzxuVar = this.zzh;
        boolean z2 = zzxuVar.zzO;
        int i2 = this.zzd.zzA;
        if (i2 == -1 || i2 != zzxnVar.zzd.zzA) {
            return false;
        }
        boolean z3 = zzxuVar.zzQ;
        return this.zzu == zzxnVar.zzu && this.zzv == zzxnVar.zzv;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzxn zzxnVar) {
        zzgbj zzgbjVarZza = (this.zzf && this.zzi) ? zzyg.zzc : zzyg.zzc.zza();
        zzfzp zzfzpVarZzd = zzfzp.zzk().zze(this.zzi, zzxnVar.zzi).zzd(Integer.valueOf(this.zzk), Integer.valueOf(zzxnVar.zzk), zzgbj.zzc().zza()).zzb(this.zzj, zzxnVar.zzj).zzb(this.zzl, zzxnVar.zzl).zze(this.zzp, zzxnVar.zzp).zze(this.zzm, zzxnVar.zzm).zzd(Integer.valueOf(this.zzn), Integer.valueOf(zzxnVar.zzn), zzgbj.zzc().zza()).zzb(this.zzo, zzxnVar.zzo).zze(this.zzf, zzxnVar.zzf).zzd(Integer.valueOf(this.zzt), Integer.valueOf(zzxnVar.zzt), zzgbj.zzc().zza());
        Integer numValueOf = Integer.valueOf(this.zzs);
        Integer numValueOf2 = Integer.valueOf(zzxnVar.zzs);
        boolean z = this.zzh.zzB;
        zzfzp zzfzpVarZzd2 = zzfzpVarZzd.zzd(numValueOf, numValueOf2, zzyg.zzd).zze(this.zzu, zzxnVar.zzu).zze(this.zzv, zzxnVar.zzv).zzd(Integer.valueOf(this.zzq), Integer.valueOf(zzxnVar.zzq), zzgbjVarZza).zzd(Integer.valueOf(this.zzr), Integer.valueOf(zzxnVar.zzr), zzgbjVarZza);
        Integer numValueOf3 = Integer.valueOf(this.zzs);
        Integer numValueOf4 = Integer.valueOf(zzxnVar.zzs);
        if (!zzfy.zzF(this.zzg, zzxnVar.zzg)) {
            zzgbjVarZza = zzyg.zzd;
        }
        return zzfzpVarZzd2.zzd(numValueOf3, numValueOf4, zzgbjVarZza).zza();
    }
}
