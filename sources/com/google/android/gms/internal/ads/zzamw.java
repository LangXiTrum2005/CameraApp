package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzamw implements zzamy {
    private final String zzb;
    private String zzc;
    private zzaea zzd;
    private int zzf;
    private int zzg;
    private long zzh;
    private zzam zzi;
    private int zzj;
    private final zzfp zza = new zzfp(new byte[18]);
    private int zze = 0;
    private long zzk = -9223372036854775807L;

    public zzamw(String str) {
        this.zzb = str;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:34:0x00fb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00fd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:37:0x0106  */
    /* JADX WARN: Code duplicated, block: B:38:0x010e  */
    /* JADX WARN: Code duplicated, block: B:40:0x0118  */
    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zza(zzfp zzfpVar) {
        int i;
        int i2;
        byte b;
        boolean z;
        int i3;
        int i4;
        byte b2;
        int i5;
        byte b3;
        int i6;
        zzek.zzb(this.zzd);
        while (zzfpVar.zzb() > 0) {
            int i7 = this.zze;
            if (i7 == 0) {
                while (zzfpVar.zzb() > 0) {
                    int i8 = this.zzg << 8;
                    this.zzg = i8;
                    int iZzm = i8 | zzfpVar.zzm();
                    this.zzg = iZzm;
                    int i9 = zzacr.zza;
                    if (iZzm == 2147385345 || iZzm == -25230976 || iZzm == 536864768 || iZzm == -14745368) {
                        byte[] bArrZzM = this.zza.zzM();
                        int i10 = this.zzg;
                        bArrZzM[0] = (byte) ((i10 >> 24) & 255);
                        bArrZzM[1] = (byte) ((i10 >> 16) & 255);
                        bArrZzM[2] = (byte) ((i10 >> 8) & 255);
                        bArrZzM[3] = (byte) (i10 & 255);
                        this.zzf = 4;
                        this.zzg = 0;
                        this.zze = 1;
                        break;
                    }
                }
            } else if (i7 != 1) {
                int iMin = Math.min(zzfpVar.zzb(), this.zzj - this.zzf);
                this.zzd.zzr(zzfpVar, iMin);
                int i11 = this.zzf + iMin;
                this.zzf = i11;
                if (i11 == this.zzj) {
                    zzek.zzf(this.zzk != -9223372036854775807L);
                    this.zzd.zzt(this.zzk, 1, this.zzj, 0, null);
                    this.zzk += this.zzh;
                    this.zze = 0;
                }
            } else {
                byte[] bArrZzM2 = this.zza.zzM();
                int iMin2 = Math.min(zzfpVar.zzb(), 18 - this.zzf);
                zzfpVar.zzG(bArrZzM2, this.zzf, iMin2);
                int i12 = this.zzf + iMin2;
                this.zzf = i12;
                if (i12 == 18) {
                    byte[] bArrZzM3 = this.zza.zzM();
                    if (this.zzi == null) {
                        zzam zzamVarZza = zzacr.zza(bArrZzM3, this.zzc, this.zzb, null);
                        this.zzi = zzamVarZza;
                        this.zzd.zzl(zzamVarZza);
                    }
                    int i13 = zzacr.zza;
                    byte b4 = bArrZzM3[0];
                    if (b4 != -2) {
                        if (b4 == -1) {
                            i6 = ((bArrZzM3[7] & 3) << 12) | ((bArrZzM3[6] & 255) << 4) | ((bArrZzM3[9] & 60) >> 2);
                        } else if (b4 != 31) {
                            i = (bArrZzM3[5] & 3) << 12;
                            i2 = (bArrZzM3[6] & 255) << 4;
                            b = bArrZzM3[7];
                        } else {
                            i6 = ((bArrZzM3[8] & 60) >> 2) | ((3 & bArrZzM3[6]) << 12) | ((bArrZzM3[7] & 255) << 4);
                        }
                        i3 = i6 + 1;
                        z = true;
                        if (z) {
                            i3 = (i3 * 16) / 14;
                        }
                        this.zzj = i3;
                        if (b4 != -2) {
                            if (b4 != -1) {
                                i4 = (bArrZzM3[4] & 7) << 4;
                                b3 = bArrZzM3[7];
                            } else if (b4 != 31) {
                                i4 = (bArrZzM3[4] & 1) << 6;
                                b2 = bArrZzM3[5];
                            } else {
                                i4 = (bArrZzM3[5] & 7) << 4;
                                b3 = bArrZzM3[6];
                            }
                            i5 = b3 & 60;
                            this.zzh = (int) ((((long) ((((i5 >> 2) | i4) + 1) * 32)) * 1000000) / ((long) this.zzi.zzA));
                            this.zza.zzK(0);
                            this.zzd.zzr(this.zza, 18);
                            this.zze = 2;
                        } else {
                            i4 = (bArrZzM3[5] & 1) << 6;
                            b2 = bArrZzM3[4];
                        }
                        i5 = b2 & 252;
                        this.zzh = (int) ((((long) ((((i5 >> 2) | i4) + 1) * 32)) * 1000000) / ((long) this.zzi.zzA));
                        this.zza.zzK(0);
                        this.zzd.zzr(this.zza, 18);
                        this.zze = 2;
                    } else {
                        i = (bArrZzM3[4] & 3) << 12;
                        i2 = (bArrZzM3[7] & 255) << 4;
                        b = bArrZzM3[6];
                    }
                    i3 = (i | i2 | ((b & 240) >> 4)) + 1;
                    z = false;
                    if (z) {
                        i3 = (i3 * 16) / 14;
                    }
                    this.zzj = i3;
                    if (b4 != -2) {
                        if (b4 != -1) {
                            i4 = (bArrZzM3[4] & 7) << 4;
                            b3 = bArrZzM3[7];
                        } else if (b4 != 31) {
                            i4 = (bArrZzM3[4] & 1) << 6;
                            b2 = bArrZzM3[5];
                        } else {
                            i4 = (bArrZzM3[5] & 7) << 4;
                            b3 = bArrZzM3[6];
                        }
                        i5 = b3 & 60;
                        this.zzh = (int) ((((long) ((((i5 >> 2) | i4) + 1) * 32)) * 1000000) / ((long) this.zzi.zzA));
                        this.zza.zzK(0);
                        this.zzd.zzr(this.zza, 18);
                        this.zze = 2;
                    } else {
                        i4 = (bArrZzM3[5] & 1) << 6;
                        b2 = bArrZzM3[4];
                    }
                    i5 = b2 & 252;
                    this.zzh = (int) ((((long) ((((i5 >> 2) | i4) + 1) * 32)) * 1000000) / ((long) this.zzi.zzA));
                    this.zza.zzK(0);
                    this.zzd.zzr(this.zza, 18);
                    this.zze = 2;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzb(zzacx zzacxVar, zzaok zzaokVar) {
        zzaokVar.zzc();
        this.zzc = zzaokVar.zzb();
        this.zzd = zzacxVar.zzw(zzaokVar.zza(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzc(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzd(long j, int i) {
        this.zzk = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zze() {
        this.zze = 0;
        this.zzf = 0;
        this.zzg = 0;
        this.zzk = -9223372036854775807L;
    }
}
