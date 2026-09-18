package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzand implements zzamy {
    private static final float[] zza = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    private final zzaon zzb;
    private final zzfp zzc;
    private final boolean[] zzd;
    private final zzanb zze;
    private final zzann zzf;
    private zzanc zzg;
    private long zzh;
    private String zzi;
    private zzaea zzj;
    private boolean zzk;
    private long zzl;

    public zzand() {
        this(null);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x010e  */
    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zza(zzfp zzfpVar) {
        int i;
        int i2;
        zzek.zzb(this.zzg);
        zzek.zzb(this.zzj);
        int iZzd = zzfpVar.zzd();
        int iZze = zzfpVar.zze();
        byte[] bArrZzM = zzfpVar.zzM();
        this.zzh += (long) zzfpVar.zzb();
        this.zzj.zzr(zzfpVar, zzfpVar.zzb());
        while (true) {
            int iZza = zzgm.zza(bArrZzM, iZzd, iZze, this.zzd);
            if (iZza == iZze) {
                break;
            }
            int i3 = iZza + 3;
            int i4 = zzfpVar.zzM()[i3] & 255;
            int i5 = iZza - iZzd;
            if (!this.zzk) {
                if (i5 > 0) {
                    this.zze.zza(bArrZzM, iZzd, iZza);
                }
                if (this.zze.zzc(i4, i5 < 0 ? -i5 : 0)) {
                    zzaea zzaeaVar = this.zzj;
                    zzanb zzanbVar = this.zze;
                    int i6 = zzanbVar.zzb;
                    String str = this.zzi;
                    str.getClass();
                    byte[] bArrCopyOf = Arrays.copyOf(zzanbVar.zzc, zzanbVar.zza);
                    zzfo zzfoVar = new zzfo(bArrCopyOf, bArrCopyOf.length);
                    zzfoVar.zzn(i6);
                    zzfoVar.zzn(4);
                    zzfoVar.zzl();
                    zzfoVar.zzm(8);
                    if (zzfoVar.zzo()) {
                        zzfoVar.zzm(4);
                        zzfoVar.zzm(3);
                    }
                    int iZzd2 = zzfoVar.zzd(4);
                    float f = 1.0f;
                    if (iZzd2 == 15) {
                        int iZzd3 = zzfoVar.zzd(8);
                        int iZzd4 = zzfoVar.zzd(8);
                        if (iZzd4 == 0) {
                            zzff.zzf("H263Reader", "Invalid aspect ratio");
                        } else {
                            f = iZzd3 / iZzd4;
                        }
                    } else if (iZzd2 < 7) {
                        f = zza[iZzd2];
                    } else {
                        zzff.zzf("H263Reader", "Invalid aspect ratio");
                    }
                    float f2 = f;
                    if (zzfoVar.zzo()) {
                        zzfoVar.zzm(2);
                        zzfoVar.zzm(1);
                        if (zzfoVar.zzo()) {
                            zzfoVar.zzm(15);
                            zzfoVar.zzl();
                            zzfoVar.zzm(15);
                            zzfoVar.zzl();
                            zzfoVar.zzm(15);
                            zzfoVar.zzl();
                            zzfoVar.zzm(3);
                            zzfoVar.zzm(11);
                            zzfoVar.zzl();
                            zzfoVar.zzm(15);
                            zzfoVar.zzl();
                            i2 = 2;
                        } else {
                            i2 = 2;
                        }
                    } else {
                        i2 = 2;
                    }
                    if (zzfoVar.zzd(i2) != 0) {
                        zzff.zzf("H263Reader", "Unhandled video object layer shape");
                    }
                    zzfoVar.zzl();
                    int iZzd5 = zzfoVar.zzd(16);
                    zzfoVar.zzl();
                    if (zzfoVar.zzo()) {
                        if (iZzd5 == 0) {
                            zzff.zzf("H263Reader", "Invalid vop_increment_time_resolution");
                        } else {
                            int i7 = iZzd5 - 1;
                            int i8 = 0;
                            while (i7 > 0) {
                                i7 >>= 1;
                                i8++;
                            }
                            zzfoVar.zzm(i8);
                        }
                    }
                    zzfoVar.zzl();
                    int iZzd6 = zzfoVar.zzd(13);
                    zzfoVar.zzl();
                    int iZzd7 = zzfoVar.zzd(13);
                    zzfoVar.zzl();
                    zzfoVar.zzl();
                    zzak zzakVar = new zzak();
                    zzakVar.zzK(str);
                    zzakVar.zzW("video/mp4v-es");
                    zzakVar.zzab(iZzd6);
                    zzakVar.zzI(iZzd7);
                    zzakVar.zzS(f2);
                    zzakVar.zzL(Collections.singletonList(bArrCopyOf));
                    zzaeaVar.zzl(zzakVar.zzac());
                    this.zzk = true;
                }
            }
            this.zzg.zza(bArrZzM, iZzd, iZza);
            zzann zzannVar = this.zzf;
            if (i5 > 0) {
                zzannVar.zza(bArrZzM, iZzd, iZza);
                i = 0;
            } else {
                i = -i5;
            }
            if (this.zzf.zzd(i)) {
                zzann zzannVar2 = this.zzf;
                int iZzb = zzgm.zzb(zzannVar2.zza, zzannVar2.zzb);
                zzfp zzfpVar2 = this.zzc;
                int i9 = zzfy.zza;
                zzfpVar2.zzI(this.zzf.zza, iZzb);
                this.zzb.zza(this.zzl, this.zzc);
            }
            if (i4 == 178) {
                if (zzfpVar.zzM()[iZza + 2] == 1) {
                    this.zzf.zzc(178);
                }
                i4 = 178;
            }
            int i10 = iZze - iZza;
            this.zzg.zzb(this.zzh - ((long) i10), i10, this.zzk);
            this.zzg.zzc(i4, this.zzl);
            iZzd = i3;
        }
        if (!this.zzk) {
            this.zze.zza(bArrZzM, iZzd, iZze);
        }
        this.zzg.zza(bArrZzM, iZzd, iZze);
        this.zzf.zza(bArrZzM, iZzd, iZze);
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzb(zzacx zzacxVar, zzaok zzaokVar) {
        zzaokVar.zzc();
        this.zzi = zzaokVar.zzb();
        zzaea zzaeaVarZzw = zzacxVar.zzw(zzaokVar.zza(), 2);
        this.zzj = zzaeaVarZzw;
        this.zzg = new zzanc(zzaeaVarZzw);
        this.zzb.zzb(zzacxVar, zzaokVar);
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzc(boolean z) {
        zzek.zzb(this.zzg);
        if (z) {
            this.zzg.zzb(this.zzh, 0, this.zzk);
            this.zzg.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzd(long j, int i) {
        this.zzl = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zze() {
        zzgm.zzf(this.zzd);
        this.zze.zzb();
        zzanc zzancVar = this.zzg;
        if (zzancVar != null) {
            zzancVar.zzd();
        }
        this.zzf.zzb();
        this.zzh = 0L;
        this.zzl = -9223372036854775807L;
    }

    zzand(zzaon zzaonVar) {
        this.zzb = zzaonVar;
        this.zzd = new boolean[4];
        this.zze = new zzanb(128);
        this.zzl = -9223372036854775807L;
        this.zzf = new zzann(178, 128);
        this.zzc = new zzfp();
    }
}
