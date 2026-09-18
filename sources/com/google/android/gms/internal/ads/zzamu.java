package com.google.android.gms.internal.ads;

import androidx.core.view.MotionEventCompat;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzamu implements zzamy {
    private static final byte[] zza = {73, 68, 51};
    private final boolean zzb;
    private final zzfo zzc = new zzfo(new byte[7], 7);
    private final zzfp zzd = new zzfp(Arrays.copyOf(zza, 10));
    private final String zze;
    private String zzf;
    private zzaea zzg;
    private zzaea zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private boolean zzl;
    private boolean zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private boolean zzq;
    private long zzr;
    private int zzs;
    private long zzt;
    private zzaea zzu;
    private long zzv;

    public zzamu(boolean z, String str) {
        zzh();
        this.zzn = -1;
        this.zzo = -1;
        this.zzr = -9223372036854775807L;
        this.zzt = -9223372036854775807L;
        this.zzb = z;
        this.zze = str;
    }

    public static boolean zzf(int i) {
        return (i & 65526) == 65520;
    }

    private final void zzg() {
        this.zzm = false;
        zzh();
    }

    private final void zzh() {
        this.zzi = 0;
        this.zzj = 0;
        this.zzk = 256;
    }

    private final void zzi() {
        this.zzi = 3;
        this.zzj = 0;
    }

    private final void zzj(zzaea zzaeaVar, long j, int i, int i2) {
        this.zzi = 4;
        this.zzj = i;
        this.zzu = zzaeaVar;
        this.zzv = j;
        this.zzs = i2;
    }

    private final boolean zzk(zzfp zzfpVar, byte[] bArr, int i) {
        int iMin = Math.min(zzfpVar.zzb(), i - this.zzj);
        zzfpVar.zzG(bArr, this.zzj, iMin);
        int i2 = this.zzj + iMin;
        this.zzj = i2;
        return i2 == i;
    }

    private static final boolean zzl(byte b, byte b2) {
        return zzf((b2 & 255) | MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    }

    private static final boolean zzm(zzfp zzfpVar, byte[] bArr, int i) {
        if (zzfpVar.zzb() < i) {
            return false;
        }
        zzfpVar.zzG(bArr, 0, i);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x027e  */
    /* JADX WARN: Code duplicated, block: B:109:0x0287  */
    /* JADX WARN: Code duplicated, block: B:111:0x028b  */
    /* JADX WARN: Code duplicated, block: B:113:0x028f  */
    /* JADX WARN: Code duplicated, block: B:115:0x0293  */
    /* JADX WARN: Code duplicated, block: B:146:0x025c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:147:0x025c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:148:0x025c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:153:0x02a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:0x02c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:0x02be A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:0x02b8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:170:0x02a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:171:0x0297 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:74:0x0212  */
    /* JADX WARN: Code duplicated, block: B:76:0x0222  */
    /* JADX WARN: Code duplicated, block: B:78:0x022d  */
    /* JADX WARN: Code duplicated, block: B:80:0x0231  */
    /* JADX WARN: Code duplicated, block: B:82:0x0235  */
    /* JADX WARN: Code duplicated, block: B:87:0x0244  */
    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zza(zzfp zzfpVar) throws zzcc {
        int i;
        int i2;
        int i3;
        char c;
        boolean z;
        int i4;
        int iZzd;
        byte[] bArrZzM;
        int iZze;
        int i5;
        byte b;
        int i6;
        int i7;
        int i8;
        byte b2;
        this.zzg.getClass();
        int i9 = zzfy.zza;
        while (zzfpVar.zzb() > 0) {
            int i10 = this.zzi;
            int i11 = 13;
            char c2 = 7;
            int i12 = 2;
            if (i10 == 0) {
                byte[] bArrZzM2 = zzfpVar.zzM();
                int iZzd2 = zzfpVar.zzd();
                int iZze2 = zzfpVar.zze();
                while (true) {
                    if (iZzd2 < iZze2) {
                        int i13 = iZzd2 + 1;
                        byte b3 = bArrZzM2[iZzd2];
                        int i14 = b3 & 255;
                        if (this.zzk == 512 && zzl((byte) -1, (byte) i14)) {
                            if (!this.zzm) {
                                int i15 = iZzd2 - 1;
                                zzfpVar.zzK(iZzd2);
                                if (zzm(zzfpVar, this.zzc.zza, 1)) {
                                    this.zzc.zzk(4);
                                    int iZzd3 = this.zzc.zzd(1);
                                    int i16 = this.zzn;
                                    if (i16 != -1 && iZzd3 != i16) {
                                        c2 = 7;
                                    } else if (this.zzo == -1) {
                                        if (zzm(zzfpVar, this.zzc.zza, 4)) {
                                            this.zzc.zzk(14);
                                            iZzd = this.zzc.zzd(i11);
                                            c2 = 7;
                                            if (iZzd >= 7) {
                                                bArrZzM = zzfpVar.zzM();
                                                iZze = zzfpVar.zze();
                                                i5 = i15 + iZzd;
                                                if (i5 >= iZze) {
                                                    b = bArrZzM[i5];
                                                    if (b == -1) {
                                                        i8 = i5 + 1;
                                                        if (i8 != iZze) {
                                                            b2 = bArrZzM[i8];
                                                            if (zzl((byte) -1, b2) || ((b2 & 8) >> 3) != iZzd3) {
                                                            }
                                                        }
                                                    } else if (b == 73 || ((i6 = i5 + 1) != iZze && (bArrZzM[i6] != 68 || ((i7 = i5 + 2) != iZze && bArrZzM[i7] != 51)))) {
                                                    }
                                                }
                                            }
                                        }
                                    } else if (zzm(zzfpVar, this.zzc.zza, 1)) {
                                        this.zzc.zzk(i12);
                                        if (this.zzc.zzd(4) == this.zzo) {
                                            zzfpVar.zzK(iZzd2 + 1);
                                            if (zzm(zzfpVar, this.zzc.zza, 4)) {
                                                this.zzc.zzk(14);
                                                iZzd = this.zzc.zzd(i11);
                                                c2 = 7;
                                                if (iZzd >= 7) {
                                                    bArrZzM = zzfpVar.zzM();
                                                    iZze = zzfpVar.zze();
                                                    i5 = i15 + iZzd;
                                                    if (i5 >= iZze) {
                                                        b = bArrZzM[i5];
                                                        if (b == -1) {
                                                            i8 = i5 + 1;
                                                            if (i8 != iZze) {
                                                                b2 = bArrZzM[i8];
                                                                if (zzl((byte) -1, b2)) {
                                                                }
                                                            }
                                                        } else if (b == 73) {
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            c2 = 7;
                                        }
                                    }
                                } else {
                                    c2 = c2;
                                }
                                i = this.zzk;
                                i2 = i | i14;
                                if (i2 != 329) {
                                    i3 = 2;
                                    c = 3;
                                    z = false;
                                    i4 = 768;
                                } else if (i2 != 511) {
                                    i3 = 2;
                                    c = 3;
                                    z = false;
                                    i4 = 512;
                                } else if (i2 != 836) {
                                    i3 = 2;
                                    c = 3;
                                    z = false;
                                    i4 = 1024;
                                } else if (i2 != 1075) {
                                    this.zzi = 2;
                                    this.zzj = 3;
                                    this.zzs = 0;
                                    this.zzd.zzK(0);
                                    zzfpVar.zzK(i13);
                                } else if (i != 256) {
                                    this.zzk = 256;
                                    i11 = 13;
                                    i12 = 2;
                                } else {
                                    i3 = 2;
                                    c = 3;
                                    z = false;
                                    iZzd2 = i13;
                                    i12 = i3;
                                    i11 = 13;
                                }
                                this.zzk = i4;
                                iZzd2 = i13;
                                i12 = i3;
                                i11 = 13;
                            }
                            this.zzp = (b3 & 8) >> 3;
                            this.zzl = 1 == ((b3 & 1) ^ 1);
                            if (this.zzm) {
                                zzi();
                            } else {
                                this.zzi = 1;
                                this.zzj = 0;
                            }
                            zzfpVar.zzK(i13);
                        } else {
                            c2 = c2;
                            i = this.zzk;
                            i2 = i | i14;
                            if (i2 != 329) {
                                i3 = 2;
                                c = 3;
                                z = false;
                                i4 = 768;
                            } else if (i2 != 511) {
                                i3 = 2;
                                c = 3;
                                z = false;
                                i4 = 512;
                            } else if (i2 != 836) {
                                i3 = 2;
                                c = 3;
                                z = false;
                                i4 = 1024;
                            } else if (i2 != 1075) {
                                this.zzi = 2;
                                this.zzj = 3;
                                this.zzs = 0;
                                this.zzd.zzK(0);
                                zzfpVar.zzK(i13);
                            } else if (i != 256) {
                                this.zzk = 256;
                                i11 = 13;
                                i12 = 2;
                            } else {
                                i3 = 2;
                                c = 3;
                                z = false;
                                iZzd2 = i13;
                                i12 = i3;
                                i11 = 13;
                            }
                            this.zzk = i4;
                            iZzd2 = i13;
                            i12 = i3;
                            i11 = 13;
                        }
                    } else {
                        zzfpVar.zzK(iZzd2);
                    }
                }
            } else if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        int iMin = Math.min(zzfpVar.zzb(), this.zzs - this.zzj);
                        this.zzu.zzr(zzfpVar, iMin);
                        int i17 = this.zzj + iMin;
                        this.zzj = i17;
                        if (i17 == this.zzs) {
                            zzek.zzf(this.zzt != -9223372036854775807L);
                            this.zzu.zzt(this.zzt, 1, this.zzs, 0, null);
                            this.zzt += this.zzv;
                            zzh();
                        }
                    } else {
                        if (zzk(zzfpVar, this.zzc.zza, true != this.zzl ? 5 : 7)) {
                            this.zzc.zzk(0);
                            if (this.zzq) {
                                this.zzc.zzm(10);
                            } else {
                                int iZzd4 = this.zzc.zzd(2) + 1;
                                if (iZzd4 != 2) {
                                    zzff.zzf("AdtsReader", "Detected audio object type: " + iZzd4 + ", but assuming AAC LC.");
                                }
                                this.zzc.zzm(5);
                                int iZzd5 = this.zzc.zzd(3);
                                int i18 = this.zzo;
                                int i19 = zzabs.zza;
                                byte[] bArr = {(byte) (((i18 >> 1) & 7) | 16), (byte) (((iZzd5 << 3) & 120) | ((i18 << 7) & 128))};
                                zzabr zzabrVarZza = zzabs.zza(bArr);
                                zzak zzakVar = new zzak();
                                zzakVar.zzK(this.zzf);
                                zzakVar.zzW("audio/mp4a-latm");
                                zzakVar.zzz(zzabrVarZza.zzc);
                                zzakVar.zzy(zzabrVarZza.zzb);
                                zzakVar.zzX(zzabrVarZza.zza);
                                zzakVar.zzL(Collections.singletonList(bArr));
                                zzakVar.zzN(this.zze);
                                zzam zzamVarZzac = zzakVar.zzac();
                                this.zzr = 1024000000 / ((long) zzamVarZzac.zzA);
                                this.zzg.zzl(zzamVarZzac);
                                this.zzq = true;
                            }
                            this.zzc.zzm(4);
                            int iZzd6 = this.zzc.zzd(13);
                            zzj(this.zzg, this.zzr, 0, this.zzl ? iZzd6 - 9 : iZzd6 - 7);
                        }
                    }
                } else if (zzk(zzfpVar, this.zzd.zzM(), 10)) {
                    this.zzh.zzr(this.zzd, 10);
                    this.zzd.zzK(6);
                    zzj(this.zzh, 0L, 10, this.zzd.zzl() + 10);
                }
            } else if (zzfpVar.zzb() != 0) {
                zzfo zzfoVar = this.zzc;
                zzfoVar.zza[0] = zzfpVar.zzM()[zzfpVar.zzd()];
                zzfoVar.zzk(2);
                int iZzd7 = this.zzc.zzd(4);
                int i20 = this.zzo;
                if (i20 == -1 || iZzd7 == i20) {
                    if (!this.zzm) {
                        this.zzm = true;
                        this.zzn = this.zzp;
                        this.zzo = iZzd7;
                    }
                    zzi();
                } else {
                    zzg();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzb(zzacx zzacxVar, zzaok zzaokVar) {
        zzaokVar.zzc();
        this.zzf = zzaokVar.zzb();
        zzaea zzaeaVarZzw = zzacxVar.zzw(zzaokVar.zza(), 1);
        this.zzg = zzaeaVarZzw;
        this.zzu = zzaeaVarZzw;
        if (!this.zzb) {
            this.zzh = new zzact();
            return;
        }
        zzaokVar.zzc();
        zzaea zzaeaVarZzw2 = zzacxVar.zzw(zzaokVar.zza(), 5);
        this.zzh = zzaeaVarZzw2;
        zzak zzakVar = new zzak();
        zzakVar.zzK(zzaokVar.zzb());
        zzakVar.zzW("application/id3");
        zzaeaVarZzw2.zzl(zzakVar.zzac());
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzc(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzd(long j, int i) {
        this.zzt = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zze() {
        this.zzt = -9223372036854775807L;
        zzg();
    }
}
