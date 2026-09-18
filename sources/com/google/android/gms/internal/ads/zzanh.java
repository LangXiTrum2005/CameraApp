package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzanh implements zzamy {
    private final zzanz zza;
    private long zze;
    private String zzg;
    private zzaea zzh;
    private zzang zzi;
    private boolean zzj;
    private boolean zzl;
    private final boolean[] zzf = new boolean[3];
    private final zzann zzb = new zzann(7, 128);
    private final zzann zzc = new zzann(8, 128);
    private final zzann zzd = new zzann(6, 128);
    private long zzk = -9223372036854775807L;
    private final zzfp zzm = new zzfp();

    public zzanh(zzanz zzanzVar, boolean z, boolean z2) {
        this.zza = zzanzVar;
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzf(byte[] bArr, int i, int i2) {
        if (!this.zzj) {
            this.zzb.zza(bArr, i, i2);
            this.zzc.zza(bArr, i, i2);
        }
        this.zzd.zza(bArr, i, i2);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0052  */
    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zza(zzfp zzfpVar) {
        int i;
        int i2;
        zzek.zzb(this.zzh);
        int i3 = zzfy.zza;
        int iZzd = zzfpVar.zzd();
        int iZze = zzfpVar.zze();
        byte[] bArrZzM = zzfpVar.zzM();
        this.zze += (long) zzfpVar.zzb();
        this.zzh.zzr(zzfpVar, zzfpVar.zzb());
        while (true) {
            int iZza = zzgm.zza(bArrZzM, iZzd, iZze, this.zzf);
            if (iZza == iZze) {
                zzf(bArrZzM, iZzd, iZze);
                return;
            }
            int i4 = iZza + 3;
            int i5 = bArrZzM[i4] & Ascii.US;
            int i6 = iZza - iZzd;
            if (i6 > 0) {
                zzf(bArrZzM, iZzd, iZza);
            }
            int i7 = iZze - iZza;
            long j = this.zze - ((long) i7);
            int i8 = i6 < 0 ? -i6 : 0;
            long j2 = this.zzk;
            if (this.zzj) {
                i = iZze;
                i2 = i4;
            } else {
                this.zzb.zzd(i8);
                this.zzc.zzd(i8);
                if (this.zzj) {
                    i = iZze;
                    i2 = i4;
                    zzann zzannVar = this.zzb;
                    if (zzannVar.zze()) {
                        this.zzi.zzc(zzgm.zze(zzannVar.zza, 4, zzannVar.zzb));
                        this.zzb.zzb();
                    } else {
                        zzann zzannVar2 = this.zzc;
                        if (zzannVar2.zze()) {
                            this.zzi.zzb(zzgm.zzd(zzannVar2.zza, 4, zzannVar2.zzb));
                            this.zzc.zzb();
                        }
                    }
                } else if (this.zzb.zze() && this.zzc.zze()) {
                    ArrayList arrayList = new ArrayList();
                    zzann zzannVar3 = this.zzb;
                    arrayList.add(Arrays.copyOf(zzannVar3.zza, zzannVar3.zzb));
                    zzann zzannVar4 = this.zzc;
                    arrayList.add(Arrays.copyOf(zzannVar4.zza, zzannVar4.zzb));
                    zzann zzannVar5 = this.zzb;
                    zzgl zzglVarZze = zzgm.zze(zzannVar5.zza, 4, zzannVar5.zzb);
                    zzann zzannVar6 = this.zzc;
                    zzgk zzgkVarZzd = zzgm.zzd(zzannVar6.zza, 4, zzannVar6.zzb);
                    i2 = i4;
                    String strZza = zzem.zza(zzglVarZze.zza, zzglVarZze.zzb, zzglVarZze.zzc);
                    zzaea zzaeaVar = this.zzh;
                    zzak zzakVar = new zzak();
                    i = iZze;
                    zzakVar.zzK(this.zzg);
                    zzakVar.zzW("video/avc");
                    zzakVar.zzz(strZza);
                    zzakVar.zzab(zzglVarZze.zze);
                    zzakVar.zzI(zzglVarZze.zzf);
                    zzr zzrVar = new zzr();
                    zzrVar.zzc(zzglVarZze.zzj);
                    zzrVar.zzb(zzglVarZze.zzk);
                    zzrVar.zzd(zzglVarZze.zzl);
                    zzrVar.zzf(zzglVarZze.zzh + 8);
                    zzrVar.zza(zzglVarZze.zzi + 8);
                    zzakVar.zzA(zzrVar.zzg());
                    zzakVar.zzS(zzglVarZze.zzg);
                    zzakVar.zzL(arrayList);
                    zzaeaVar.zzl(zzakVar.zzac());
                    this.zzj = true;
                    this.zzi.zzc(zzglVarZze);
                    this.zzi.zzb(zzgkVarZzd);
                    this.zzb.zzb();
                    this.zzc.zzb();
                } else {
                    i = iZze;
                    i2 = i4;
                }
            }
            if (this.zzd.zzd(i8)) {
                zzann zzannVar7 = this.zzd;
                this.zzm.zzI(this.zzd.zza, zzgm.zzb(zzannVar7.zza, zzannVar7.zzb));
                this.zzm.zzK(4);
                this.zza.zza(j2, this.zzm);
            }
            if (this.zzi.zzf(j, i7, this.zzj)) {
                this.zzl = false;
            }
            long j3 = this.zzk;
            if (!this.zzj) {
                this.zzb.zzc(i5);
                this.zzc.zzc(i5);
            }
            this.zzd.zzc(i5);
            this.zzi.zze(j, i5, j3, this.zzl);
            iZzd = i2;
            iZze = i;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzb(zzacx zzacxVar, zzaok zzaokVar) {
        zzaokVar.zzc();
        this.zzg = zzaokVar.zzb();
        zzaea zzaeaVarZzw = zzacxVar.zzw(zzaokVar.zza(), 2);
        this.zzh = zzaeaVarZzw;
        this.zzi = new zzang(zzaeaVarZzw, false, false);
        this.zza.zzb(zzacxVar, zzaokVar);
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzc(boolean z) {
        zzek.zzb(this.zzh);
        int i = zzfy.zza;
        if (z) {
            this.zzi.zza(this.zze);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzd(long j, int i) {
        this.zzk = j;
        int i2 = i & 2;
        this.zzl = (i2 != 0) | this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zze() {
        this.zze = 0L;
        this.zzl = false;
        this.zzk = -9223372036854775807L;
        zzgm.zzf(this.zzf);
        this.zzb.zzb();
        this.zzc.zzb();
        this.zzd.zzb();
        zzang zzangVar = this.zzi;
        if (zzangVar != null) {
            zzangVar.zzd();
        }
    }
}
