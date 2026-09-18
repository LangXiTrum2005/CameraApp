package com.google.android.gms.internal.ads;

import java.util.Collections;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzanj implements zzamy {
    private final zzanz zza;
    private String zzb;
    private zzaea zzc;
    private zzani zzd;
    private boolean zze;
    private long zzl;
    private final boolean[] zzf = new boolean[3];
    private final zzann zzg = new zzann(32, 128);
    private final zzann zzh = new zzann(33, 128);
    private final zzann zzi = new zzann(34, 128);
    private final zzann zzj = new zzann(39, 128);
    private final zzann zzk = new zzann(40, 128);
    private long zzm = -9223372036854775807L;
    private final zzfp zzn = new zzfp();

    public zzanj(zzanz zzanzVar) {
        this.zza = zzanzVar;
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzf(byte[] bArr, int i, int i2) {
        this.zzd.zzc(bArr, i, i2);
        if (!this.zze) {
            this.zzg.zza(bArr, i, i2);
            this.zzh.zza(bArr, i, i2);
            this.zzi.zza(bArr, i, i2);
        }
        this.zzj.zza(bArr, i, i2);
        this.zzk.zza(bArr, i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0139  */
    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zza(zzfp zzfpVar) {
        zzek.zzb(this.zzc);
        int i = zzfy.zza;
        while (zzfpVar.zzb() > 0) {
            int iZzd = zzfpVar.zzd();
            int iZze = zzfpVar.zze();
            byte[] bArrZzM = zzfpVar.zzM();
            this.zzl += (long) zzfpVar.zzb();
            this.zzc.zzr(zzfpVar, zzfpVar.zzb());
            while (iZzd < iZze) {
                int iZza = zzgm.zza(bArrZzM, iZzd, iZze, this.zzf);
                if (iZza == iZze) {
                    zzf(bArrZzM, iZzd, iZze);
                    return;
                }
                int i2 = iZza + 3;
                int i3 = bArrZzM[i2] & 126;
                int i4 = iZza - iZzd;
                if (i4 > 0) {
                    zzf(bArrZzM, iZzd, iZza);
                }
                int i5 = iZze - iZza;
                long j = this.zzl - ((long) i5);
                int i6 = i4 < 0 ? -i4 : 0;
                long j2 = this.zzm;
                this.zzd.zzb(j, i5, this.zze);
                if (!this.zze) {
                    this.zzg.zzd(i6);
                    this.zzh.zzd(i6);
                    this.zzi.zzd(i6);
                    zzann zzannVar = this.zzg;
                    if (zzannVar.zze()) {
                        zzann zzannVar2 = this.zzh;
                        if (zzannVar2.zze()) {
                            zzann zzannVar3 = this.zzi;
                            if (zzannVar3.zze()) {
                                zzaea zzaeaVar = this.zzc;
                                String str = this.zzb;
                                int i7 = zzannVar.zzb;
                                byte[] bArr = new byte[zzannVar2.zzb + i7 + zzannVar3.zzb];
                                System.arraycopy(zzannVar.zza, 0, bArr, 0, i7);
                                System.arraycopy(zzannVar2.zza, 0, bArr, zzannVar.zzb, zzannVar2.zzb);
                                System.arraycopy(zzannVar3.zza, 0, bArr, zzannVar.zzb + zzannVar2.zzb, zzannVar3.zzb);
                                zzgj zzgjVarZzc = zzgm.zzc(zzannVar2.zza, 5, zzannVar2.zzb);
                                String strZzb = zzem.zzb(zzgjVarZzc.zza, zzgjVarZzc.zzb, zzgjVarZzc.zzc, zzgjVarZzc.zzd, zzgjVarZzc.zzg, zzgjVarZzc.zzh);
                                zzak zzakVar = new zzak();
                                zzakVar.zzK(str);
                                zzakVar.zzW("video/hevc");
                                zzakVar.zzz(strZzb);
                                zzakVar.zzab(zzgjVarZzc.zzi);
                                zzakVar.zzI(zzgjVarZzc.zzj);
                                zzr zzrVar = new zzr();
                                zzrVar.zzc(zzgjVarZzc.zzl);
                                zzrVar.zzb(zzgjVarZzc.zzm);
                                zzrVar.zzd(zzgjVarZzc.zzn);
                                zzrVar.zzf(zzgjVarZzc.zze + 8);
                                zzrVar.zza(zzgjVarZzc.zzf + 8);
                                zzakVar.zzA(zzrVar.zzg());
                                zzakVar.zzS(zzgjVarZzc.zzk);
                                zzakVar.zzL(Collections.singletonList(bArr));
                                zzaeaVar.zzl(zzakVar.zzac());
                                this.zze = true;
                            }
                        }
                    }
                }
                if (this.zzj.zzd(i6)) {
                    zzann zzannVar4 = this.zzj;
                    this.zzn.zzI(this.zzj.zza, zzgm.zzb(zzannVar4.zza, zzannVar4.zzb));
                    this.zzn.zzL(5);
                    this.zza.zza(j2, this.zzn);
                }
                if (this.zzk.zzd(i6)) {
                    zzann zzannVar5 = this.zzk;
                    this.zzn.zzI(this.zzk.zza, zzgm.zzb(zzannVar5.zza, zzannVar5.zzb));
                    this.zzn.zzL(5);
                    this.zza.zza(j2, this.zzn);
                }
                int i8 = i3 >> 1;
                this.zzd.zze(j, i5, i8, this.zzm, this.zze);
                if (!this.zze) {
                    this.zzg.zzc(i8);
                    this.zzh.zzc(i8);
                    this.zzi.zzc(i8);
                }
                this.zzj.zzc(i8);
                this.zzk.zzc(i8);
                iZzd = i2;
                iZze = iZze;
                bArrZzM = bArrZzM;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzb(zzacx zzacxVar, zzaok zzaokVar) {
        zzaokVar.zzc();
        this.zzb = zzaokVar.zzb();
        zzaea zzaeaVarZzw = zzacxVar.zzw(zzaokVar.zza(), 2);
        this.zzc = zzaeaVarZzw;
        this.zzd = new zzani(zzaeaVarZzw);
        this.zza.zzb(zzacxVar, zzaokVar);
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzc(boolean z) {
        zzek.zzb(this.zzc);
        int i = zzfy.zza;
        if (z) {
            this.zzd.zza(this.zzl);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzd(long j, int i) {
        this.zzm = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zze() {
        this.zzl = 0L;
        this.zzm = -9223372036854775807L;
        zzgm.zzf(this.zzf);
        this.zzg.zzb();
        this.zzh.zzb();
        this.zzi.zzb();
        this.zzj.zzb();
        this.zzk.zzb();
        zzani zzaniVar = this.zzd;
        if (zzaniVar != null) {
            zzaniVar.zzd();
        }
    }
}
