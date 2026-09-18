package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzya extends zzyc implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;

    /* JADX WARN: Multi-variable type inference failed */
    public zzya(int i, zzcz zzczVar, int i2, zzxu zzxuVar, int i3, String str) {
        int iZzb;
        super(i, zzczVar, i2);
        int i4 = 0;
        this.zzf = zzyg.zzo(i3, false);
        int i5 = this.zzd.zze;
        int i6 = zzxuVar.zzy;
        this.zzg = 1 == (i5 & 1);
        this.zzh = (i5 & 2) != 0;
        zzgaa zzgaaVarZzm = zzxuVar.zzw.isEmpty() ? zzgaa.zzm("") : zzxuVar.zzw;
        int i7 = 0;
        while (true) {
            if (i7 >= zzgaaVarZzm.size()) {
                i7 = Integer.MAX_VALUE;
                iZzb = 0;
                break;
            }
            zzam zzamVar = this.zzd;
            String str2 = (String) zzgaaVarZzm.get(i7);
            boolean z = zzxuVar.zzz;
            iZzb = zzyg.zzb(zzamVar, str2, false);
            if (iZzb > 0) {
                break;
            } else {
                i7++;
            }
        }
        this.zzi = i7;
        this.zzj = iZzb;
        int iZza = zzyg.zza(this.zzd.zzf, zzxuVar.zzx);
        this.zzk = iZza;
        this.zzm = (this.zzd.zzf & 1088) != 0;
        int iZzb2 = zzyg.zzb(this.zzd, str, zzyg.zzh(str) == null);
        this.zzl = iZzb2;
        boolean z2 = iZzb > 0 || (zzxuVar.zzw.isEmpty() && iZza > 0) || this.zzg || (this.zzh && iZzb2 > 0);
        if (zzyg.zzo(i3, zzxuVar.zzT) && z2) {
            i4 = 1;
        }
        this.zze = i4;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzya zzyaVar) {
        zzfzp zzfzpVarZzb = zzfzp.zzk().zze(this.zzf, zzyaVar.zzf).zzd(Integer.valueOf(this.zzi), Integer.valueOf(zzyaVar.zzi), zzgbj.zzc().zza()).zzb(this.zzj, zzyaVar.zzj).zzb(this.zzk, zzyaVar.zzk).zze(this.zzg, zzyaVar.zzg).zzd(Boolean.valueOf(this.zzh), Boolean.valueOf(zzyaVar.zzh), this.zzj == 0 ? zzgbj.zzc() : zzgbj.zzc().zza()).zzb(this.zzl, zzyaVar.zzl);
        if (this.zzk == 0) {
            zzfzpVarZzb = zzfzpVarZzb.zzf(this.zzm, zzyaVar.zzm);
        }
        return zzfzpVarZzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final int zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzyc
    public final /* bridge */ /* synthetic */ boolean zzc(zzyc zzycVar) {
        return false;
    }
}
