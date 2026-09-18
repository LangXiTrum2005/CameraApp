package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzakg extends zzake {
    private zzakf zza;
    private int zzb;
    private boolean zzc;
    private zzaef zzd;
    private zzaed zze;

    zzakg() {
    }

    @Override // com.google.android.gms.internal.ads.zzake
    protected final long zza(zzfp zzfpVar) {
        if ((zzfpVar.zzM()[0] & 1) == 1) {
            return -1L;
        }
        byte b = zzfpVar.zzM()[0];
        zzakf zzakfVar = this.zza;
        zzek.zzb(zzakfVar);
        int i = !zzakfVar.zzd[(b >> 1) & (255 >>> (8 - zzakfVar.zze))].zza ? zzakfVar.zza.zze : zzakfVar.zza.zzf;
        int i2 = this.zzc ? (this.zzb + i) / 4 : 0;
        if (zzfpVar.zzc() < zzfpVar.zze() + 4) {
            byte[] bArrCopyOf = Arrays.copyOf(zzfpVar.zzM(), zzfpVar.zze() + 4);
            zzfpVar.zzI(bArrCopyOf, bArrCopyOf.length);
        } else {
            zzfpVar.zzJ(zzfpVar.zze() + 4);
        }
        long j = i2;
        byte[] bArrZzM = zzfpVar.zzM();
        bArrZzM[zzfpVar.zze() - 4] = (byte) (j & 255);
        bArrZzM[zzfpVar.zze() - 3] = (byte) ((j >>> 8) & 255);
        bArrZzM[zzfpVar.zze() - 2] = (byte) ((j >>> 16) & 255);
        bArrZzM[zzfpVar.zze() - 1] = (byte) ((j >>> 24) & 255);
        this.zzc = true;
        this.zzb = i;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzake
    protected final void zzb(boolean z) {
        super.zzb(z);
        if (z) {
            this.zza = null;
            this.zzd = null;
            this.zze = null;
        }
        this.zzb = 0;
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzake
    protected final void zzi(long j) {
        super.zzi(j);
        this.zzc = j != 0;
        zzaef zzaefVar = this.zzd;
        this.zzb = zzaefVar != null ? zzaefVar.zze : 0;
    }

    /* JADX WARN: Code duplicated, block: B:167:0x03b7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:169:0x03b9  */
    @Override // com.google.android.gms.internal.ads.zzake
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected final boolean zzc(zzfp zzfpVar, long j, zzakb zzakbVar) throws IOException {
        zzakf zzakfVar;
        int i;
        int iZzb;
        int i2;
        int i3;
        if (this.zza != null) {
            zzakbVar.zza.getClass();
            return false;
        }
        zzaef zzaefVar = this.zzd;
        int i4 = 4;
        if (zzaefVar != null) {
            zzaed zzaedVar = this.zze;
            if (zzaedVar == null) {
                this.zze = zzaeg.zzc(zzfpVar, true, true);
            } else {
                byte[] bArr = new byte[zzfpVar.zze()];
                System.arraycopy(zzfpVar.zzM(), 0, bArr, 0, zzfpVar.zze());
                int i5 = zzaefVar.zza;
                int i6 = 5;
                zzaeg.zzd(5, zzfpVar, false);
                int iZzm = zzfpVar.zzm() + 1;
                zzaec zzaecVar = new zzaec(zzfpVar.zzM());
                zzaecVar.zzc(zzfpVar.zzd() * 8);
                int i7 = 0;
                while (true) {
                    int i8 = 2;
                    int i9 = 16;
                    if (i7 >= iZzm) {
                        zzaef zzaefVar2 = zzaefVar;
                        int i10 = 6;
                        int iZzb2 = zzaecVar.zzb(6) + 1;
                        for (int i11 = 0; i11 < iZzb2; i11++) {
                            if (zzaecVar.zzb(16) != 0) {
                                throw zzcc.zza("placeholder of time domain transforms not zeroed out", null);
                            }
                        }
                        int i12 = 1;
                        int iZzb3 = zzaecVar.zzb(6) + 1;
                        int i13 = 0;
                        while (true) {
                            int i14 = 3;
                            if (i13 >= iZzb3) {
                                int i15 = 1;
                                int iZzb4 = zzaecVar.zzb(i10) + 1;
                                int i16 = 0;
                                while (i16 < iZzb4) {
                                    if (zzaecVar.zzb(16) > 2) {
                                        throw zzcc.zza("residueType greater than 2 is not decodable", null);
                                    }
                                    zzaecVar.zzc(24);
                                    zzaecVar.zzc(24);
                                    zzaecVar.zzc(24);
                                    int iZzb5 = zzaecVar.zzb(i10) + i15;
                                    int i17 = 8;
                                    zzaecVar.zzc(8);
                                    int[] iArr = new int[iZzb5];
                                    for (int i18 = 0; i18 < iZzb5; i18++) {
                                        iArr[i18] = ((zzaecVar.zzd() ? zzaecVar.zzb(5) : 0) * 8) + zzaecVar.zzb(3);
                                    }
                                    int i19 = 0;
                                    while (i19 < iZzb5) {
                                        int i20 = 0;
                                        while (i20 < i17) {
                                            if ((iArr[i19] & (1 << i20)) != 0) {
                                                zzaecVar.zzc(i17);
                                            }
                                            i20++;
                                            i17 = 8;
                                        }
                                        i19++;
                                        i17 = 8;
                                    }
                                    i16++;
                                    i10 = 6;
                                    i15 = 1;
                                }
                                int iZzb6 = zzaecVar.zzb(i10) + 1;
                                for (int i21 = 0; i21 < iZzb6; i21++) {
                                    int iZzb7 = zzaecVar.zzb(16);
                                    if (iZzb7 != 0) {
                                        zzff.zzc("VorbisUtil", "mapping type other than 0 not supported: " + iZzb7);
                                    } else {
                                        if (zzaecVar.zzd()) {
                                            i = 1;
                                            iZzb = zzaecVar.zzb(4) + 1;
                                        } else {
                                            i = 1;
                                            iZzb = 1;
                                        }
                                        if (zzaecVar.zzd()) {
                                            int iZzb8 = zzaecVar.zzb(8) + i;
                                            for (int i22 = 0; i22 < iZzb8; i22++) {
                                                int i23 = i5 - 1;
                                                zzaecVar.zzc(zzaeg.zza(i23));
                                                zzaecVar.zzc(zzaeg.zza(i23));
                                            }
                                        }
                                        if (zzaecVar.zzb(2) != 0) {
                                            throw zzcc.zza("to reserved bits must be zero after mapping coupling steps", null);
                                        }
                                        if (iZzb > 1) {
                                            for (int i24 = 0; i24 < i5; i24++) {
                                                zzaecVar.zzc(4);
                                            }
                                        }
                                        for (int i25 = 0; i25 < iZzb; i25++) {
                                            zzaecVar.zzc(8);
                                            zzaecVar.zzc(8);
                                            zzaecVar.zzc(8);
                                        }
                                    }
                                }
                                int iZzb9 = zzaecVar.zzb(6);
                                int i26 = iZzb9 + 1;
                                zzaee[] zzaeeVarArr = new zzaee[i26];
                                for (int i27 = 0; i27 < i26; i27++) {
                                    zzaeeVarArr[i27] = new zzaee(zzaecVar.zzd(), zzaecVar.zzb(16), zzaecVar.zzb(16), zzaecVar.zzb(8));
                                }
                                if (!zzaecVar.zzd()) {
                                    throw zzcc.zza("framing bit after modes not set as expected", null);
                                }
                                zzakfVar = new zzakf(zzaefVar2, zzaedVar, bArr, zzaeeVarArr, zzaeg.zza(iZzb9));
                                break;
                            }
                            int iZzb10 = zzaecVar.zzb(i9);
                            if (iZzb10 == 0) {
                                i2 = iZzb3;
                                int i28 = 8;
                                zzaecVar.zzc(8);
                                zzaecVar.zzc(16);
                                zzaecVar.zzc(16);
                                zzaecVar.zzc(6);
                                zzaecVar.zzc(8);
                                int iZzb11 = zzaecVar.zzb(4) + 1;
                                int i29 = 0;
                                while (i29 < iZzb11) {
                                    zzaecVar.zzc(i28);
                                    i29++;
                                    i28 = 8;
                                }
                            } else {
                                if (iZzb10 != i12) {
                                    throw zzcc.zza("floor type greater than 1 not decodable: " + iZzb10, null);
                                }
                                int iZzb12 = zzaecVar.zzb(i6);
                                int[] iArr2 = new int[iZzb12];
                                int i30 = -1;
                                for (int i31 = 0; i31 < iZzb12; i31++) {
                                    int iZzb13 = zzaecVar.zzb(4);
                                    iArr2[i31] = iZzb13;
                                    if (iZzb13 > i30) {
                                        i30 = iZzb13;
                                    }
                                }
                                int i32 = i30 + 1;
                                int[] iArr3 = new int[i32];
                                int i33 = 0;
                                while (i33 < i32) {
                                    iArr3[i33] = zzaecVar.zzb(i14) + 1;
                                    int iZzb14 = zzaecVar.zzb(i8);
                                    if (iZzb14 > 0) {
                                        i3 = 8;
                                        zzaecVar.zzc(8);
                                    } else {
                                        i3 = 8;
                                    }
                                    int i34 = iZzb3;
                                    int i35 = 0;
                                    for (int i36 = 1; i35 < (i36 << iZzb14); i36 = 1) {
                                        zzaecVar.zzc(i3);
                                        i35++;
                                        i3 = 8;
                                    }
                                    i33++;
                                    iZzb3 = i34;
                                    i8 = 2;
                                    i14 = 3;
                                }
                                i2 = iZzb3;
                                zzaecVar.zzc(i8);
                                int iZzb15 = zzaecVar.zzb(4);
                                int i37 = 0;
                                int i38 = 0;
                                for (int i39 = 0; i39 < iZzb12; i39++) {
                                    i37 += iArr3[iArr2[i39]];
                                    while (i38 < i37) {
                                        zzaecVar.zzc(iZzb15);
                                        i38++;
                                    }
                                }
                            }
                            i13++;
                            iZzb3 = i2;
                            i10 = 6;
                            i8 = 2;
                            i9 = 16;
                            i12 = 1;
                            i6 = 5;
                        }
                    } else {
                        if (zzaecVar.zzb(24) != 5653314) {
                            throw zzcc.zza("expected code book to start with [0x56, 0x43, 0x42] at " + zzaecVar.zza(), null);
                        }
                        int iZzb16 = zzaecVar.zzb(16);
                        int iZzb17 = zzaecVar.zzb(24);
                        if (zzaecVar.zzd()) {
                            zzaecVar.zzc(5);
                            for (int iZzb18 = 0; iZzb18 < iZzb17; iZzb18 += zzaecVar.zzb(zzaeg.zza(iZzb17 - iZzb18))) {
                            }
                        } else {
                            boolean zZzd = zzaecVar.zzd();
                            for (int i40 = 0; i40 < iZzb17; i40++) {
                                if (!zZzd) {
                                    zzaecVar.zzc(5);
                                } else if (zzaecVar.zzd()) {
                                    zzaecVar.zzc(5);
                                }
                            }
                        }
                        int iZzb19 = zzaecVar.zzb(i4);
                        if (iZzb19 > 2) {
                            throw zzcc.zza("lookup type greater than 2 not decodable: " + iZzb19, null);
                        }
                        if (iZzb19 != 1) {
                            if (iZzb19 != 2) {
                                zzaefVar = zzaefVar;
                            }
                            i7++;
                            zzaefVar = zzaefVar;
                            i4 = 4;
                        } else {
                            i8 = iZzb19;
                        }
                        zzaecVar.zzc(32);
                        zzaecVar.zzc(32);
                        int iZzb20 = zzaecVar.zzb(i4) + 1;
                        zzaecVar.zzc(1);
                        zzaecVar.zzc((int) ((i8 == 1 ? iZzb16 != 0 ? (long) Math.floor(Math.pow(iZzb17, 1.0d / ((double) iZzb16))) : 0L : ((long) iZzb16) * ((long) iZzb17)) * ((long) iZzb20)));
                        i7++;
                        zzaefVar = zzaefVar;
                        i4 = 4;
                    }
                }
            }
            this.zza = zzakfVar;
            if (zzakfVar == null) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            zzaef zzaefVar3 = zzakfVar.zza;
            arrayList.add(zzaefVar3.zzg);
            arrayList.add(zzakfVar.zzc);
            zzby zzbyVarZzb = zzaeg.zzb(zzgaa.zzk(zzakfVar.zzb.zzb));
            zzak zzakVar = new zzak();
            zzakVar.zzW("audio/vorbis");
            zzakVar.zzx(zzaefVar3.zzd);
            zzakVar.zzR(zzaefVar3.zzc);
            zzakVar.zzy(zzaefVar3.zza);
            zzakVar.zzX(zzaefVar3.zzb);
            zzakVar.zzL(arrayList);
            zzakVar.zzP(zzbyVarZzb);
            zzakbVar.zza = zzakVar.zzac();
            return true;
        }
        zzaeg.zzd(1, zzfpVar, false);
        int iZzj = zzfpVar.zzj();
        int iZzm2 = zzfpVar.zzm();
        int iZzj2 = zzfpVar.zzj();
        int iZzi = zzfpVar.zzi();
        int i41 = iZzi <= 0 ? -1 : iZzi;
        int iZzi2 = zzfpVar.zzi();
        int i42 = iZzi2 <= 0 ? -1 : iZzi2;
        int iZzi3 = zzfpVar.zzi();
        int i43 = iZzi3 <= 0 ? -1 : iZzi3;
        int iZzm3 = zzfpVar.zzm();
        this.zzd = new zzaef(iZzj, iZzm2, iZzj2, i41, i42, i43, (int) Math.pow(2.0d, iZzm3 & 15), (int) Math.pow(2.0d, (iZzm3 & 240) >> 4), 1 == (zzfpVar.zzm() & 1), Arrays.copyOf(zzfpVar.zzM(), zzfpVar.zze()));
        zzakfVar = null;
        this.zza = zzakfVar;
        if (zzakfVar == null) {
            return true;
        }
        ArrayList arrayList2 = new ArrayList();
        zzaef zzaefVar4 = zzakfVar.zza;
        arrayList2.add(zzaefVar4.zzg);
        arrayList2.add(zzakfVar.zzc);
        zzby zzbyVarZzb2 = zzaeg.zzb(zzgaa.zzk(zzakfVar.zzb.zzb));
        zzak zzakVar2 = new zzak();
        zzakVar2.zzW("audio/vorbis");
        zzakVar2.zzx(zzaefVar4.zzd);
        zzakVar2.zzR(zzaefVar4.zzc);
        zzakVar2.zzy(zzaefVar4.zza);
        zzakVar2.zzX(zzaefVar4.zzb);
        zzakVar2.zzL(arrayList2);
        zzakVar2.zzP(zzbyVarZzb2);
        zzakbVar.zza = zzakVar2.zzac();
        return true;
    }
}
