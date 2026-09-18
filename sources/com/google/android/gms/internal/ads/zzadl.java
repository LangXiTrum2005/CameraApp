package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzadl {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final float zzh;
    public final String zzi;

    private zzadl(List list, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f, String str) {
        this.zza = list;
        this.zzb = i;
        this.zzc = i4;
        this.zzd = i5;
        this.zze = i6;
        this.zzf = i7;
        this.zzg = i8;
        this.zzh = f;
        this.zzi = str;
    }

    public static zzadl zza(zzfp zzfpVar) throws zzcc {
        try {
            zzfpVar.zzL(21);
            int iZzm = zzfpVar.zzm() & 3;
            int iZzm2 = zzfpVar.zzm();
            int iZzd = zzfpVar.zzd();
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < iZzm2; i3++) {
                zzfpVar.zzL(1);
                int iZzq = zzfpVar.zzq();
                for (int i4 = 0; i4 < iZzq; i4++) {
                    int iZzq2 = zzfpVar.zzq();
                    i2 += iZzq2 + 4;
                    zzfpVar.zzL(iZzq2);
                }
            }
            zzfpVar.zzK(iZzd);
            byte[] bArr = new byte[i2];
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            int i9 = -1;
            int i10 = -1;
            int i11 = -1;
            String strZzb = null;
            float f = 1.0f;
            int i12 = 0;
            int i13 = 0;
            while (i12 < iZzm2) {
                int iZzm3 = zzfpVar.zzm() & 63;
                int iZzq3 = zzfpVar.zzq();
                int i14 = i;
                while (i14 < iZzq3) {
                    int iZzq4 = zzfpVar.zzq();
                    int i15 = iZzm2;
                    System.arraycopy(zzgm.zza, i, bArr, i13, 4);
                    int i16 = i13 + 4;
                    System.arraycopy(zzfpVar.zzM(), zzfpVar.zzd(), bArr, i16, iZzq4);
                    int i17 = i16 + iZzq4;
                    if (iZzm3 == 33 && i14 == 0) {
                        zzgj zzgjVarZzc = zzgm.zzc(bArr, i13 + 6, i17);
                        i5 = zzgjVarZzc.zzi;
                        i6 = zzgjVarZzc.zzj;
                        i7 = zzgjVarZzc.zze + 8;
                        i8 = zzgjVarZzc.zzf + 8;
                        int i18 = zzgjVarZzc.zzl;
                        int i19 = zzgjVarZzc.zzm;
                        int i20 = zzgjVarZzc.zzn;
                        float f2 = zzgjVarZzc.zzk;
                        strZzb = zzem.zzb(zzgjVarZzc.zza, zzgjVarZzc.zzb, zzgjVarZzc.zzc, zzgjVarZzc.zzd, zzgjVarZzc.zzg, zzgjVarZzc.zzh);
                        f = f2;
                        i9 = i18;
                        i10 = i19;
                        i11 = i20;
                        i14 = 0;
                    }
                    zzfpVar.zzL(iZzq4);
                    i14++;
                    iZzm2 = i15;
                    i13 = i17;
                    iZzm3 = iZzm3;
                    iZzq3 = iZzq3;
                    i = 0;
                }
                i12++;
                i = 0;
            }
            return new zzadl(i2 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), iZzm + 1, i5, i6, i7, i8, i9, i10, i11, f, strZzb);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw zzcc.zza("Error parsing HEVC config", e);
        }
    }
}
