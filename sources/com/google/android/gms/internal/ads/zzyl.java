package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzyl extends zzyo {
    private zzyk zza;

    protected abstract Pair zzc(zzyk zzykVar, int[][][] iArr, int[] iArr2, zzur zzurVar, zzcx zzcxVar) throws zziz;

    @Override // com.google.android.gms.internal.ads.zzyo
    public final zzyp zzp(zzmh[] zzmhVarArr, zzws zzwsVar, zzur zzurVar, zzcx zzcxVar) throws zziz {
        boolean z;
        int[] iArr;
        int[] iArr2 = new int[3];
        zzcz[][] zzczVarArr = new zzcz[3][];
        int[][][] iArr3 = new int[3][][];
        for (int i = 0; i < 3; i++) {
            int i2 = zzwsVar.zzc;
            zzczVarArr[i] = new zzcz[i2];
            iArr3[i] = new int[i2][];
        }
        int i3 = 2;
        int[] iArr4 = new int[2];
        for (int i4 = 0; i4 < 2; i4++) {
            iArr4[i4] = zzmhVarArr[i4].zze();
        }
        int i5 = 0;
        while (i5 < zzwsVar.zzc) {
            zzcz zzczVarZzb = zzwsVar.zzb(i5);
            int i6 = zzczVarZzb.zzd;
            int i7 = i3;
            int i8 = 0;
            int i9 = 0;
            boolean z2 = true;
            while (i8 < i3) {
                zzmh zzmhVar = zzmhVarArr[i8];
                int i10 = 0;
                int iMax = 0;
                while (true) {
                    int i11 = zzczVarZzb.zzb;
                    if (i10 > 0) {
                        break;
                    }
                    iMax = Math.max(iMax, zzmhVar.zzX(zzczVarZzb.zzb(i10)) & 7);
                    i10++;
                }
                boolean z3 = iArr2[i8] == 0;
                if (iMax > i9) {
                    z2 = z3;
                    i7 = i8;
                    i9 = iMax;
                } else if (iMax == i9 && i6 == 5 && !z2 && z3) {
                    i7 = i8;
                    i9 = iMax;
                    z2 = true;
                }
                i8++;
                i3 = 2;
            }
            if (i7 == i3) {
                int i12 = zzczVarZzb.zzb;
                iArr = new int[1];
            } else {
                zzmh zzmhVar2 = zzmhVarArr[i7];
                int i13 = zzczVarZzb.zzb;
                int[] iArr5 = new int[1];
                int i14 = 0;
                while (true) {
                    int i15 = zzczVarZzb.zzb;
                    if (i14 > 0) {
                        break;
                    }
                    iArr5[i14] = zzmhVar2.zzX(zzczVarZzb.zzb(i14));
                    i14++;
                }
                iArr = iArr5;
            }
            int i16 = iArr2[i7];
            zzczVarArr[i7][i16] = zzczVarZzb;
            iArr3[i7][i16] = iArr;
            iArr2[i7] = i16 + 1;
            i5++;
            i3 = 2;
        }
        zzws[] zzwsVarArr = new zzws[i3];
        String[] strArr = new String[i3];
        int[] iArr6 = new int[i3];
        int i17 = 0;
        while (i17 < i3) {
            int i18 = iArr2[i17];
            zzwsVarArr[i17] = new zzws((zzcz[]) zzfy.zzL(zzczVarArr[i17], i18));
            iArr3[i17] = (int[][]) zzfy.zzL(iArr3[i17], i18);
            strArr[i17] = zzmhVarArr[i17].zzT();
            iArr6[i17] = zzmhVarArr[i17].zzbj();
            i17++;
            i3 = 2;
        }
        int i19 = i3;
        zzyk zzykVar = new zzyk(strArr, iArr6, zzwsVarArr, iArr4, iArr3, new zzws((zzcz[]) zzfy.zzL(zzczVarArr[i19], iArr2[i19])));
        Pair pairZzc = zzc(zzykVar, iArr3, iArr4, zzurVar, zzcxVar);
        zzym[] zzymVarArr = (zzym[]) pairZzc.second;
        List[] listArr = new List[zzymVarArr.length];
        for (int i20 = 0; i20 < zzymVarArr.length; i20++) {
            zzym zzymVar = zzymVarArr[i20];
            listArr[i20] = zzymVar != null ? zzgaa.zzm(zzymVar) : zzgaa.zzl();
        }
        zzfzx zzfzxVar = new zzfzx();
        for (int i21 = 0; i21 < 2; i21++) {
            zzws zzwsVarZzd = zzykVar.zzd(i21);
            List list = listArr[i21];
            for (int i22 = 0; i22 < zzwsVarZzd.zzc; i22++) {
                zzcz zzczVarZzb2 = zzwsVarZzd.zzb(i22);
                boolean z4 = zzykVar.zza(i21, i22, false) != 0;
                int i23 = zzczVarZzb2.zzb;
                int[] iArr7 = new int[1];
                boolean[] zArr = new boolean[1];
                int i24 = 0;
                while (true) {
                    int i25 = zzczVarZzb2.zzb;
                    if (i24 <= 0) {
                        iArr7[i24] = zzykVar.zzb(i21, i22, i24) & 7;
                        int i26 = 0;
                        while (true) {
                            if (i26 >= list.size()) {
                                z = false;
                                break;
                            }
                            zzym zzymVar2 = (zzym) list.get(i26);
                            if (zzymVar2.zze().equals(zzczVarZzb2) && zzymVar2.zzb(i24) != -1) {
                                z = true;
                                break;
                            }
                            i26++;
                        }
                        zArr[i24] = z;
                        i24++;
                    }
                }
                zzfzxVar.zzf(new zzdj(zzczVarZzb2, z4, iArr7, zArr));
            }
        }
        zzws zzwsVarZze = zzykVar.zze();
        for (int i27 = 0; i27 < zzwsVarZze.zzc; i27++) {
            zzcz zzczVarZzb3 = zzwsVarZze.zzb(i27);
            int i28 = zzczVarZzb3.zzb;
            int[] iArr8 = new int[1];
            Arrays.fill(iArr8, 0);
            int i29 = zzczVarZzb3.zzb;
            zzfzxVar.zzf(new zzdj(zzczVarZzb3, false, iArr8, new boolean[1]));
        }
        return new zzyp((zzmi[]) pairZzc.first, (zzyi[]) pairZzc.second, new zzdk(zzfzxVar.zzi()), zzykVar);
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final void zzq(Object obj) {
        this.zza = (zzyk) obj;
    }
}
