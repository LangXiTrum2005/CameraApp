package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzabz {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final float zzj;
    public final String zzk;

    private zzabz(List list, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f, String str) {
        this.zza = list;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = i5;
        this.zzg = i6;
        this.zzh = i7;
        this.zzi = i8;
        this.zzj = f;
        this.zzk = str;
    }

    public static zzabz zza(zzfp zzfpVar) throws zzcc {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        String strZza;
        float f;
        try {
            zzfpVar.zzL(4);
            int iZzm = zzfpVar.zzm() & 3;
            int i8 = iZzm + 1;
            if (i8 == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iZzm2 = zzfpVar.zzm() & 31;
            for (int i9 = 0; i9 < iZzm2; i9++) {
                arrayList.add(zzb(zzfpVar));
            }
            int iZzm3 = zzfpVar.zzm();
            for (int i10 = 0; i10 < iZzm3; i10++) {
                arrayList.add(zzb(zzfpVar));
            }
            if (iZzm2 > 0) {
                zzgl zzglVarZze = zzgm.zze((byte[]) arrayList.get(0), iZzm + 2, ((byte[]) arrayList.get(0)).length);
                int i11 = zzglVarZze.zze;
                int i12 = zzglVarZze.zzf;
                int i13 = zzglVarZze.zzh + 8;
                int i14 = zzglVarZze.zzi + 8;
                int i15 = zzglVarZze.zzj;
                int i16 = zzglVarZze.zzk;
                int i17 = zzglVarZze.zzl;
                float f2 = zzglVarZze.zzg;
                strZza = zzem.zza(zzglVarZze.zza, zzglVarZze.zzb, zzglVarZze.zzc);
                i6 = i16;
                i7 = i17;
                f = f2;
                i3 = i13;
                i4 = i14;
                i5 = i15;
                i = i11;
                i2 = i12;
            } else {
                i = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                i6 = -1;
                i7 = -1;
                strZza = null;
                f = 1.0f;
            }
            return new zzabz(arrayList, i8, i, i2, i3, i4, i5, i6, i7, f, strZza);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw zzcc.zza("Error parsing AVC config", e);
        }
    }

    private static byte[] zzb(zzfp zzfpVar) {
        int iZzq = zzfpVar.zzq();
        int iZzd = zzfpVar.zzd();
        zzfpVar.zzL(iZzq);
        return zzem.zzc(zzfpVar.zzM(), iZzd, iZzq);
    }
}
