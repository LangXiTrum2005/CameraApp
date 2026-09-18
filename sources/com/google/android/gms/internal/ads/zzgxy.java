package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.io.IOException;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgxy {
    static int zza(byte[] bArr, int i, zzgxx zzgxxVar) throws zzhag {
        int iZzh = zzh(bArr, i, zzgxxVar);
        int i2 = zzgxxVar.zza;
        if (i2 < 0) {
            throw zzhag.zzf();
        }
        if (i2 > bArr.length - iZzh) {
            throw zzhag.zzj();
        }
        if (i2 == 0) {
            zzgxxVar.zzc = zzgyl.zzb;
            return iZzh;
        }
        zzgxxVar.zzc = zzgyl.zzv(bArr, iZzh, i2);
        return iZzh + i2;
    }

    static int zzb(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    static int zzc(zzhby zzhbyVar, byte[] bArr, int i, int i2, int i3, zzgxx zzgxxVar) throws IOException {
        Object objZze = zzhbyVar.zze();
        int iZzl = zzl(objZze, zzhbyVar, bArr, i, i2, i3, zzgxxVar);
        zzhbyVar.zzf(objZze);
        zzgxxVar.zzc = objZze;
        return iZzl;
    }

    static int zzd(zzhby zzhbyVar, byte[] bArr, int i, int i2, zzgxx zzgxxVar) throws IOException {
        Object objZze = zzhbyVar.zze();
        int iZzm = zzm(objZze, zzhbyVar, bArr, i, i2, zzgxxVar);
        zzhbyVar.zzf(objZze);
        zzgxxVar.zzc = objZze;
        return iZzm;
    }

    static int zze(zzhby zzhbyVar, int i, byte[] bArr, int i2, int i3, zzhad zzhadVar, zzgxx zzgxxVar) throws IOException {
        int iZzd = zzd(zzhbyVar, bArr, i2, i3, zzgxxVar);
        zzhadVar.add(zzgxxVar.zzc);
        while (iZzd < i3) {
            int iZzh = zzh(bArr, iZzd, zzgxxVar);
            if (i != zzgxxVar.zza) {
                break;
            }
            iZzd = zzd(zzhbyVar, bArr, iZzh, i3, zzgxxVar);
            zzhadVar.add(zzgxxVar.zzc);
        }
        return iZzd;
    }

    static int zzf(byte[] bArr, int i, zzhad zzhadVar, zzgxx zzgxxVar) throws IOException {
        zzgzv zzgzvVar = (zzgzv) zzhadVar;
        int iZzh = zzh(bArr, i, zzgxxVar);
        int i2 = zzgxxVar.zza + iZzh;
        while (iZzh < i2) {
            iZzh = zzh(bArr, iZzh, zzgxxVar);
            zzgzvVar.zzh(zzgxxVar.zza);
        }
        if (iZzh == i2) {
            return iZzh;
        }
        throw zzhag.zzj();
    }

    static int zzg(int i, byte[] bArr, int i2, int i3, zzhcq zzhcqVar, zzgxx zzgxxVar) throws zzhag {
        if ((i >>> 3) == 0) {
            throw zzhag.zzc();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzk = zzk(bArr, i2, zzgxxVar);
            zzhcqVar.zzj(i, Long.valueOf(zzgxxVar.zzb));
            return iZzk;
        }
        if (i4 == 1) {
            zzhcqVar.zzj(i, Long.valueOf(zzn(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzh = zzh(bArr, i2, zzgxxVar);
            int i5 = zzgxxVar.zza;
            if (i5 < 0) {
                throw zzhag.zzf();
            }
            if (i5 > bArr.length - iZzh) {
                throw zzhag.zzj();
            }
            if (i5 == 0) {
                zzhcqVar.zzj(i, zzgyl.zzb);
            } else {
                zzhcqVar.zzj(i, zzgyl.zzv(bArr, iZzh, i5));
            }
            return iZzh + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw zzhag.zzc();
            }
            zzhcqVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzhcq zzhcqVarZzf = zzhcq.zzf();
        int i7 = 0;
        while (i2 < i3) {
            int iZzh2 = zzh(bArr, i2, zzgxxVar);
            int i8 = zzgxxVar.zza;
            i7 = i8;
            if (i8 == i6) {
                i2 = iZzh2;
                break;
            }
            int iZzg = zzg(i7, bArr, iZzh2, i3, zzhcqVarZzf, zzgxxVar);
            i7 = i8;
            i2 = iZzg;
        }
        if (i2 > i3 || i7 != i6) {
            throw zzhag.zzg();
        }
        zzhcqVar.zzj(i, zzhcqVarZzf);
        return i2;
    }

    static int zzh(byte[] bArr, int i, zzgxx zzgxxVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzi(b, bArr, i2, zzgxxVar);
        }
        zzgxxVar.zza = b;
        return i2;
    }

    static int zzi(int i, byte[] bArr, int i2, zzgxx zzgxxVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & WorkQueueKt.MASK;
        if (b >= 0) {
            zzgxxVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzgxxVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzgxxVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzgxxVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzgxxVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzj(int i, byte[] bArr, int i2, int i3, zzhad zzhadVar, zzgxx zzgxxVar) {
        zzgzv zzgzvVar = (zzgzv) zzhadVar;
        int iZzh = zzh(bArr, i2, zzgxxVar);
        zzgzvVar.zzh(zzgxxVar.zza);
        while (iZzh < i3) {
            int iZzh2 = zzh(bArr, iZzh, zzgxxVar);
            if (i != zzgxxVar.zza) {
                break;
            }
            iZzh = zzh(bArr, iZzh2, zzgxxVar);
            zzgzvVar.zzh(zzgxxVar.zza);
        }
        return iZzh;
    }

    static int zzk(byte[] bArr, int i, zzgxx zzgxxVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzgxxVar.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & 127)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & 127)) << i4;
            b = b2;
            i3 = i5;
        }
        zzgxxVar.zzb = j2;
        return i3;
    }

    static int zzl(Object obj, zzhby zzhbyVar, byte[] bArr, int i, int i2, int i3, zzgxx zzgxxVar) throws IOException {
        int iZzc = ((zzhbh) zzhbyVar).zzc(obj, bArr, i, i2, i3, zzgxxVar);
        zzgxxVar.zzc = obj;
        return iZzc;
    }

    static int zzm(Object obj, zzhby zzhbyVar, byte[] bArr, int i, int i2, zzgxx zzgxxVar) throws IOException {
        int iZzi = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzi = zzi(i3, bArr, iZzi, zzgxxVar);
            i3 = zzgxxVar.zza;
        }
        int i4 = iZzi;
        if (i3 < 0 || i3 > i2 - i4) {
            throw zzhag.zzj();
        }
        int i5 = i3 + i4;
        zzhbyVar.zzi(obj, bArr, i4, i5, zzgxxVar);
        zzgxxVar.zzc = obj;
        return i5;
    }

    static long zzn(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }
}
