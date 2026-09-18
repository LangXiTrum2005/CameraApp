package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhcq {
    private static final zzhcq zza = new zzhcq(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzhcq() {
        this(0, new int[8], new Object[8], true);
    }

    private zzhcq(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzhcq zzc() {
        return zza;
    }

    static zzhcq zze(zzhcq zzhcqVar, zzhcq zzhcqVar2) {
        int i = zzhcqVar.zzb + zzhcqVar2.zzb;
        int[] iArrCopyOf = Arrays.copyOf(zzhcqVar.zzc, i);
        System.arraycopy(zzhcqVar2.zzc, 0, iArrCopyOf, zzhcqVar.zzb, zzhcqVar2.zzb);
        Object[] objArrCopyOf = Arrays.copyOf(zzhcqVar.zzd, i);
        System.arraycopy(zzhcqVar2.zzd, 0, objArrCopyOf, zzhcqVar.zzb, zzhcqVar2.zzb);
        return new zzhcq(i, iArrCopyOf, objArrCopyOf, true);
    }

    static zzhcq zzf() {
        return new zzhcq(0, new int[8], new Object[8], true);
    }

    private final void zzl(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzhcq)) {
            return false;
        }
        zzhcq zzhcqVar = (zzhcq) obj;
        int i = this.zzb;
        if (i == zzhcqVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzhcqVar.zzc;
            for (int i2 = 0; i2 < i; i2++) {
                if (iArr[i2] == iArr2[i2]) {
                }
            }
            Object[] objArr = this.zzd;
            Object[] objArr2 = zzhcqVar.zzd;
            int i3 = this.zzb;
            for (int i4 = 0; i4 < i3; i4++) {
                if (objArr[i4].equals(objArr2[i4])) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = ((i2 * 31) + i3) * 31;
        Object[] objArr = this.zzd;
        int i6 = this.zzb;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    public final int zza() {
        int iZzz;
        int iZzA;
        int iZzz2;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 0) {
                if (i6 == 1) {
                    ((Long) this.zzd[i3]).longValue();
                    iZzz2 = zzgza.zzz(i5 << 3) + 8;
                } else if (i6 == 2) {
                    int i7 = i5 << 3;
                    zzgyl zzgylVar = (zzgyl) this.zzd[i3];
                    int iZzz3 = zzgza.zzz(i7);
                    int iZzd = zzgylVar.zzd();
                    iZzz2 = iZzz3 + zzgza.zzz(iZzd) + iZzd;
                } else if (i6 == 3) {
                    int iZzz4 = zzgza.zzz(i5 << 3);
                    iZzz = iZzz4 + iZzz4;
                    iZzA = ((zzhcq) this.zzd[i3]).zza();
                } else {
                    if (i6 != 5) {
                        throw new IllegalStateException(zzhag.zza());
                    }
                    ((Integer) this.zzd[i3]).intValue();
                    iZzz2 = zzgza.zzz(i5 << 3) + 4;
                }
                i2 += iZzz2;
            } else {
                int i8 = i5 << 3;
                long jLongValue = ((Long) this.zzd[i3]).longValue();
                iZzz = zzgza.zzz(i8);
                iZzA = zzgza.zzA(jLongValue);
            }
            iZzz2 = iZzz + iZzA;
            i2 += iZzz2;
        }
        this.zze = i2;
        return i2;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int iZzz = 0;
        for (int i2 = 0; i2 < this.zzb; i2++) {
            int i3 = this.zzc[i2] >>> 3;
            zzgyl zzgylVar = (zzgyl) this.zzd[i2];
            int iZzz2 = zzgza.zzz(8);
            int iZzz3 = zzgza.zzz(16) + zzgza.zzz(i3);
            int iZzz4 = zzgza.zzz(24);
            int iZzd = zzgylVar.zzd();
            iZzz += iZzz2 + iZzz2 + iZzz3 + iZzz4 + zzgza.zzz(iZzd) + iZzd;
        }
        this.zze = iZzz;
        return iZzz;
    }

    final zzhcq zzd(zzhcq zzhcqVar) {
        if (zzhcqVar.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzhcqVar.zzb;
        zzl(i);
        System.arraycopy(zzhcqVar.zzc, 0, this.zzc, this.zzb, zzhcqVar.zzb);
        System.arraycopy(zzhcqVar.zzd, 0, this.zzd, this.zzb, zzhcqVar.zzb);
        this.zzb = i;
        return this;
    }

    final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    final void zzi(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzhbg.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    final void zzj(int i, Object obj) {
        zzg();
        zzl(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    public final void zzk(zzgzb zzgzbVar) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzgzbVar.zzt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzgzbVar.zzm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzgzbVar.zzd(i4, (zzgyl) obj);
                } else if (i3 == 3) {
                    zzgzbVar.zzE(i4);
                    ((zzhcq) obj).zzk(zzgzbVar);
                    zzgzbVar.zzh(i4);
                } else {
                    if (i3 != 5) {
                        throw new RuntimeException(zzhag.zza());
                    }
                    zzgzbVar.zzk(i4, ((Integer) obj).intValue());
                }
            }
        }
    }
}
