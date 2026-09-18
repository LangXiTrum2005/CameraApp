package com.google.android.gms.internal.ads;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhbh<T> implements zzhby<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhcz.zzi();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzhbe zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzhas zzm;
    private final zzhcp zzn;
    private final zzgzg zzo;
    private final zzhbj zzp;
    private final zzhaz zzq;

    private zzhbh(int[] iArr, Object[] objArr, int i, int i2, zzhbe zzhbeVar, int i3, boolean z, int[] iArr2, int i4, int i5, zzhbj zzhbjVar, zzhas zzhasVar, zzhcp zzhcpVar, zzgzg zzgzgVar, zzhaz zzhazVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzhbeVar instanceof zzgzu;
        boolean z2 = false;
        if (zzgzgVar != null && zzgzgVar.zzh(zzhbeVar)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzj = iArr2;
        this.zzk = i4;
        this.zzl = i5;
        this.zzp = zzhbjVar;
        this.zzm = zzhasVar;
        this.zzn = zzhcpVar;
        this.zzo = zzgzgVar;
        this.zzg = zzhbeVar;
        this.zzq = zzhazVar;
    }

    private final Object zzA(Object obj, int i) {
        zzhby zzhbyVarZzx = zzx(i);
        int iZzu = zzu(i) & 1048575;
        if (!zzN(obj, i)) {
            return zzhbyVarZzx.zze();
        }
        Object object = zzb.getObject(obj, iZzu);
        if (zzQ(object)) {
            return object;
        }
        Object objZze = zzhbyVarZzx.zze();
        if (object != null) {
            zzhbyVarZzx.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzB(Object obj, int i, int i2) {
        zzhby zzhbyVarZzx = zzx(i2);
        if (!zzR(obj, i, i2)) {
            return zzhbyVarZzx.zze();
        }
        Object object = zzb.getObject(obj, zzu(i2) & 1048575);
        if (zzQ(object)) {
            return object;
        }
        Object objZze = zzhbyVarZzx.zze();
        if (object != null) {
            zzhbyVarZzx.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void zzD(Object obj) {
        if (!zzQ(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzE(Object obj, Object obj2, int i) {
        if (zzN(obj2, i)) {
            int iZzu = zzu(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzu;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzhby zzhbyVarZzx = zzx(i);
            if (!zzN(obj, i)) {
                if (zzQ(object)) {
                    Object objZze = zzhbyVarZzx.zze();
                    zzhbyVarZzx.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzH(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzQ(object2)) {
                Object objZze2 = zzhbyVarZzx.zze();
                zzhbyVarZzx.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzhbyVarZzx.zzg(object2, object);
        }
    }

    private final void zzF(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzR(obj2, i2, i)) {
            int iZzu = zzu(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzu;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzhby zzhbyVarZzx = zzx(i);
            if (!zzR(obj, i2, i)) {
                if (zzQ(object)) {
                    Object objZze = zzhbyVarZzx.zze();
                    zzhbyVarZzx.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzI(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzQ(object2)) {
                Object objZze2 = zzhbyVarZzx.zze();
                zzhbyVarZzx.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzhbyVarZzx.zzg(object2, object);
        }
    }

    private final void zzG(Object obj, int i, zzhbq zzhbqVar) throws IOException {
        long j = i & 1048575;
        if (zzM(i)) {
            zzhcz.zzv(obj, j, zzhbqVar.zzs());
        } else if (this.zzi) {
            zzhcz.zzv(obj, j, zzhbqVar.zzr());
        } else {
            zzhcz.zzv(obj, j, zzhbqVar.zzp());
        }
    }

    private final void zzH(Object obj, int i) {
        int iZzr = zzr(i);
        long j = 1048575 & iZzr;
        if (j == 1048575) {
            return;
        }
        zzhcz.zzt(obj, j, (1 << (iZzr >>> 20)) | zzhcz.zzd(obj, j));
    }

    private final void zzI(Object obj, int i, int i2) {
        zzhcz.zzt(obj, zzr(i2) & 1048575, i);
    }

    private final void zzJ(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzu(i) & 1048575, obj2);
        zzH(obj, i);
    }

    private final void zzK(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzu(i2) & 1048575, obj2);
        zzI(obj, i, i2);
    }

    private final boolean zzL(Object obj, Object obj2, int i) {
        return zzN(obj, i) == zzN(obj2, i);
    }

    private static boolean zzM(int i) {
        return (i & 536870912) != 0;
    }

    private final boolean zzN(Object obj, int i) {
        int iZzr = zzr(i);
        long j = iZzr & 1048575;
        if (j != 1048575) {
            return (zzhcz.zzd(obj, j) & (1 << (iZzr >>> 20))) != 0;
        }
        int iZzu = zzu(i);
        long j2 = iZzu & 1048575;
        switch (zzt(iZzu)) {
            case 0:
                return Double.doubleToRawLongBits(zzhcz.zzb(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhcz.zzc(obj, j2)) != 0;
            case 2:
                return zzhcz.zzf(obj, j2) != 0;
            case 3:
                return zzhcz.zzf(obj, j2) != 0;
            case 4:
                return zzhcz.zzd(obj, j2) != 0;
            case 5:
                return zzhcz.zzf(obj, j2) != 0;
            case 6:
                return zzhcz.zzd(obj, j2) != 0;
            case 7:
                return zzhcz.zzz(obj, j2);
            case 8:
                Object objZzh = zzhcz.zzh(obj, j2);
                if (objZzh instanceof String) {
                    return !((String) objZzh).isEmpty();
                }
                if (objZzh instanceof zzgyl) {
                    return !zzgyl.zzb.equals(objZzh);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhcz.zzh(obj, j2) != null;
            case 10:
                return !zzgyl.zzb.equals(zzhcz.zzh(obj, j2));
            case 11:
                return zzhcz.zzd(obj, j2) != 0;
            case 12:
                return zzhcz.zzd(obj, j2) != 0;
            case 13:
                return zzhcz.zzd(obj, j2) != 0;
            case 14:
                return zzhcz.zzf(obj, j2) != 0;
            case 15:
                return zzhcz.zzd(obj, j2) != 0;
            case 16:
                return zzhcz.zzf(obj, j2) != 0;
            case 17:
                return zzhcz.zzh(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzO(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzN(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzP(Object obj, int i, zzhby zzhbyVar) {
        return zzhbyVar.zzk(zzhcz.zzh(obj, i & 1048575));
    }

    private static boolean zzQ(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzgzu) {
            return ((zzgzu) obj).zzaY();
        }
        return true;
    }

    private final boolean zzR(Object obj, int i, int i2) {
        return zzhcz.zzd(obj, (long) (zzr(i2) & 1048575)) == i;
    }

    private static boolean zzS(Object obj, long j) {
        return ((Boolean) zzhcz.zzh(obj, j)).booleanValue();
    }

    private static final void zzT(int i, Object obj, zzgzb zzgzbVar) throws IOException {
        if (obj instanceof String) {
            zzgzbVar.zzF(i, (String) obj);
        } else {
            zzgzbVar.zzd(i, (zzgyl) obj);
        }
    }

    static zzhcq zzd(Object obj) {
        zzgzu zzgzuVar = (zzgzu) obj;
        zzhcq zzhcqVar = zzgzuVar.zzc;
        if (zzhcqVar != zzhcq.zzc()) {
            return zzhcqVar;
        }
        zzhcq zzhcqVarZzf = zzhcq.zzf();
        zzgzuVar.zzc = zzhcqVarZzf;
        return zzhcqVarZzf;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0265  */
    /* JADX WARN: Code duplicated, block: B:126:0x0268  */
    /* JADX WARN: Code duplicated, block: B:129:0x027f  */
    /* JADX WARN: Code duplicated, block: B:130:0x0282  */
    static zzhbh zzl(Class cls, zzhbb zzhbbVar, zzhbj zzhbjVar, zzhas zzhasVar, zzhcp zzhcpVar, zzgzg zzgzgVar, zzhaz zzhazVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int i2;
        int[] iArr;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        char cCharAt;
        int i8;
        char cCharAt2;
        int i9;
        char cCharAt3;
        int i10;
        char cCharAt4;
        int i11;
        char cCharAt5;
        int i12;
        char cCharAt6;
        int i13;
        char cCharAt7;
        int i14;
        char cCharAt8;
        int i15;
        int i16;
        int iObjectFieldOffset;
        int i17;
        int i18;
        int i19;
        int iObjectFieldOffset2;
        Field fieldZzC;
        char cCharAt9;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        Object obj;
        Field fieldZzC2;
        int i25;
        Object obj2;
        Field fieldZzC3;
        int i26;
        char cCharAt10;
        int i27;
        char cCharAt11;
        int i28;
        char cCharAt12;
        int i29;
        char cCharAt13;
        if (!(zzhbbVar instanceof zzhbp)) {
            throw null;
        }
        zzhbp zzhbpVar = (zzhbp) zzhbbVar;
        String strZzd = zzhbpVar.zzd();
        int length = strZzd.length();
        char c = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i30 = 1;
            while (true) {
                i = i30 + 1;
                if (strZzd.charAt(i30) < 55296) {
                    break;
                }
                i30 = i;
            }
        } else {
            i = 1;
        }
        int i31 = i + 1;
        int iCharAt3 = strZzd.charAt(i);
        if (iCharAt3 >= 55296) {
            int i32 = iCharAt3 & 8191;
            int i33 = 13;
            while (true) {
                i29 = i31 + 1;
                cCharAt13 = strZzd.charAt(i31);
                if (cCharAt13 < 55296) {
                    break;
                }
                i32 |= (cCharAt13 & 8191) << i33;
                i33 += 13;
                i31 = i29;
            }
            iCharAt3 = i32 | (cCharAt13 << i33);
            i31 = i29;
        }
        if (iCharAt3 == 0) {
            iCharAt = 0;
            iCharAt2 = 0;
            i3 = 0;
            i6 = 0;
            i2 = 0;
            i4 = 0;
            iArr = zza;
            i5 = 0;
        } else {
            int i34 = i31 + 1;
            int iCharAt4 = strZzd.charAt(i31);
            if (iCharAt4 >= 55296) {
                int i35 = iCharAt4 & 8191;
                int i36 = 13;
                while (true) {
                    i14 = i34 + 1;
                    cCharAt8 = strZzd.charAt(i34);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i35 |= (cCharAt8 & 8191) << i36;
                    i36 += 13;
                    i34 = i14;
                }
                iCharAt4 = i35 | (cCharAt8 << i36);
                i34 = i14;
            }
            int i37 = i34 + 1;
            int iCharAt5 = strZzd.charAt(i34);
            if (iCharAt5 >= 55296) {
                int i38 = iCharAt5 & 8191;
                int i39 = 13;
                while (true) {
                    i13 = i37 + 1;
                    cCharAt7 = strZzd.charAt(i37);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i38 |= (cCharAt7 & 8191) << i39;
                    i39 += 13;
                    i37 = i13;
                }
                iCharAt5 = i38 | (cCharAt7 << i39);
                i37 = i13;
            }
            int i40 = i37 + 1;
            int iCharAt6 = strZzd.charAt(i37);
            if (iCharAt6 >= 55296) {
                int i41 = iCharAt6 & 8191;
                int i42 = 13;
                while (true) {
                    i12 = i40 + 1;
                    cCharAt6 = strZzd.charAt(i40);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i41 |= (cCharAt6 & 8191) << i42;
                    i42 += 13;
                    i40 = i12;
                }
                iCharAt6 = i41 | (cCharAt6 << i42);
                i40 = i12;
            }
            int i43 = i40 + 1;
            int iCharAt7 = strZzd.charAt(i40);
            if (iCharAt7 >= 55296) {
                int i44 = iCharAt7 & 8191;
                int i45 = 13;
                while (true) {
                    i11 = i43 + 1;
                    cCharAt5 = strZzd.charAt(i43);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i44 |= (cCharAt5 & 8191) << i45;
                    i45 += 13;
                    i43 = i11;
                }
                iCharAt7 = i44 | (cCharAt5 << i45);
                i43 = i11;
            }
            int i46 = i43 + 1;
            iCharAt = strZzd.charAt(i43);
            if (iCharAt >= 55296) {
                int i47 = iCharAt & 8191;
                int i48 = 13;
                while (true) {
                    i10 = i46 + 1;
                    cCharAt4 = strZzd.charAt(i46);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i47 |= (cCharAt4 & 8191) << i48;
                    i48 += 13;
                    i46 = i10;
                }
                iCharAt = i47 | (cCharAt4 << i48);
                i46 = i10;
            }
            int i49 = i46 + 1;
            iCharAt2 = strZzd.charAt(i46);
            if (iCharAt2 >= 55296) {
                int i50 = iCharAt2 & 8191;
                int i51 = 13;
                while (true) {
                    i9 = i49 + 1;
                    cCharAt3 = strZzd.charAt(i49);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt3 & 8191) << i51;
                    i51 += 13;
                    i49 = i9;
                }
                iCharAt2 = i50 | (cCharAt3 << i51);
                i49 = i9;
            }
            int i52 = i49 + 1;
            int iCharAt8 = strZzd.charAt(i49);
            if (iCharAt8 >= 55296) {
                int i53 = iCharAt8 & 8191;
                int i54 = 13;
                while (true) {
                    i8 = i52 + 1;
                    cCharAt2 = strZzd.charAt(i52);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i53 |= (cCharAt2 & 8191) << i54;
                    i54 += 13;
                    i52 = i8;
                }
                iCharAt8 = i53 | (cCharAt2 << i54);
                i52 = i8;
            }
            int i55 = i52 + 1;
            int iCharAt9 = strZzd.charAt(i52);
            if (iCharAt9 >= 55296) {
                int i56 = iCharAt9 & 8191;
                int i57 = 13;
                while (true) {
                    i7 = i55 + 1;
                    cCharAt = strZzd.charAt(i55);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i56 |= (cCharAt & 8191) << i57;
                    i57 += 13;
                    i55 = i7;
                }
                iCharAt9 = i56 | (cCharAt << i57);
                i55 = i7;
            }
            i2 = iCharAt4 + iCharAt4 + iCharAt5;
            iArr = new int[iCharAt9 + iCharAt2 + iCharAt8];
            i3 = iCharAt6;
            i4 = iCharAt9;
            i5 = iCharAt4;
            i6 = iCharAt7;
            i31 = i55;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzhbpVar.zze();
        Class<?> cls2 = zzhbpVar.zza().getClass();
        int i58 = i4 + iCharAt2;
        int i59 = iCharAt + iCharAt;
        int[] iArr2 = new int[iCharAt * 3];
        Object[] objArr = new Object[i59];
        int i60 = 0;
        int i61 = 0;
        int i62 = i4;
        int i63 = i58;
        while (i31 < length) {
            int i64 = i31 + 1;
            int iCharAt10 = strZzd.charAt(i31);
            if (iCharAt10 >= c) {
                int i65 = iCharAt10 & 8191;
                int i66 = i64;
                int i67 = 13;
                while (true) {
                    i28 = i66 + 1;
                    cCharAt12 = strZzd.charAt(i66);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i65 |= (cCharAt12 & 8191) << i67;
                    i67 += 13;
                    i66 = i28;
                }
                iCharAt10 = i65 | (cCharAt12 << i67);
                i15 = i28;
            } else {
                i15 = i64;
            }
            int i68 = i15 + 1;
            int iCharAt11 = strZzd.charAt(i15);
            if (iCharAt11 >= c) {
                int i69 = iCharAt11 & 8191;
                int i70 = i68;
                int i71 = 13;
                while (true) {
                    i27 = i70 + 1;
                    cCharAt11 = strZzd.charAt(i70);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i69 |= (cCharAt11 & 8191) << i71;
                    i71 += 13;
                    i70 = i27;
                }
                iCharAt11 = i69 | (cCharAt11 << i71);
                i16 = i27;
            } else {
                i16 = i68;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i60] = i61;
                i60++;
            }
            int i72 = iCharAt11 & 255;
            int i73 = iCharAt11 & 2048;
            int i74 = length;
            if (i72 >= 51) {
                int i75 = i16 + 1;
                int iCharAt12 = strZzd.charAt(i16);
                char c2 = 55296;
                if (iCharAt12 >= 55296) {
                    int i76 = 13;
                    int i77 = iCharAt12 & 8191;
                    int i78 = i75;
                    while (true) {
                        i26 = i78 + 1;
                        cCharAt10 = strZzd.charAt(i78);
                        if (cCharAt10 < c2) {
                            break;
                        }
                        i77 |= (cCharAt10 & 8191) << i76;
                        i76 += 13;
                        i78 = i26;
                        c2 = 55296;
                    }
                    iCharAt12 = i77 | (cCharAt10 << i76);
                    i22 = i26;
                } else {
                    i22 = i75;
                }
                int i79 = i22;
                int i80 = i72 - 51;
                if (i80 == 9 || i80 == 17) {
                    i23 = i2 + 1;
                    int i81 = i61 / 3;
                    objArr[i81 + i81 + 1] = objArrZze[i2];
                } else {
                    if (i80 == 12) {
                        if (zzhbpVar.zzc() == 1 || i73 != 0) {
                            i23 = i2 + 1;
                            int i82 = i61 / 3;
                            objArr[i82 + i82 + 1] = objArrZze[i2];
                        } else {
                            i73 = 0;
                        }
                    }
                    i24 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i24];
                    if (obj instanceof Field) {
                        fieldZzC2 = (Field) obj;
                    } else {
                        fieldZzC2 = zzC(cls2, (String) obj);
                        objArrZze[i24] = fieldZzC2;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzC2);
                    i25 = i24 + 1;
                    obj2 = objArrZze[i25];
                    if (obj2 instanceof Field) {
                        fieldZzC3 = (Field) obj2;
                    } else {
                        fieldZzC3 = zzC(cls2, (String) obj2);
                        objArrZze[i25] = fieldZzC3;
                    }
                    zzhbpVar = zzhbpVar;
                    strZzd = strZzd;
                    i19 = i2;
                    i17 = i79;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzC3);
                    i18 = 0;
                }
                i2 = i23;
                i24 = iCharAt12 + iCharAt12;
                obj = objArrZze[i24];
                if (obj instanceof Field) {
                    fieldZzC2 = (Field) obj;
                } else {
                    fieldZzC2 = zzC(cls2, (String) obj);
                    objArrZze[i24] = fieldZzC2;
                }
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzC2);
                i25 = i24 + 1;
                obj2 = objArrZze[i25];
                if (obj2 instanceof Field) {
                    fieldZzC3 = (Field) obj2;
                } else {
                    fieldZzC3 = zzC(cls2, (String) obj2);
                    objArrZze[i25] = fieldZzC3;
                }
                zzhbpVar = zzhbpVar;
                strZzd = strZzd;
                i19 = i2;
                i17 = i79;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzC3);
                i18 = 0;
            } else {
                int i83 = i2 + 1;
                Field fieldZzC4 = zzC(cls2, (String) objArrZze[i2]);
                if (i72 == 9 || i72 == 17) {
                    zzhbpVar = zzhbpVar;
                    int i84 = i61 / 3;
                    objArr[i84 + i84 + 1] = fieldZzC4.getType();
                } else {
                    if (i72 == 27) {
                        i20 = 1;
                        i21 = i2 + 2;
                    } else if (i72 == 49) {
                        i21 = i2 + 2;
                        i20 = 1;
                    } else if (i72 == 12 || i72 == 30 || i72 == 44) {
                        zzhbpVar = zzhbpVar;
                        if (zzhbpVar.zzc() == 1 || i73 != 0) {
                            i21 = i2 + 2;
                            int i85 = i61 / 3;
                            objArr[i85 + i85 + 1] = objArrZze[i83];
                            i83 = i21;
                        } else {
                            i73 = 0;
                        }
                    } else {
                        if (i72 == 50) {
                            int i86 = i2 + 2;
                            int i87 = i62 + 1;
                            iArr[i62] = i61;
                            int i88 = i61 / 3;
                            int i89 = i88 + i88;
                            objArr[i89] = objArrZze[i83];
                            if (i73 != 0) {
                                i83 = i2 + 3;
                                objArr[i89 + 1] = objArrZze[i86];
                                i62 = i87;
                            } else {
                                i83 = i86;
                                i62 = i87;
                                i73 = 0;
                            }
                        }
                        zzhbpVar = zzhbpVar;
                    }
                    int i90 = i61 / 3;
                    objArr[i90 + i90 + i20] = objArrZze[i83];
                    i83 = i21;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzC4);
                iObjectFieldOffset = 1048575;
                if ((iCharAt11 & 4096) == 0 || i72 > 17) {
                    i17 = i16;
                    i18 = 0;
                } else {
                    int i91 = i16 + 1;
                    int iCharAt13 = strZzd.charAt(i16);
                    if (iCharAt13 >= 55296) {
                        int i92 = iCharAt13 & 8191;
                        int i93 = 13;
                        while (true) {
                            i17 = i91 + 1;
                            cCharAt9 = strZzd.charAt(i91);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i92 |= (cCharAt9 & 8191) << i93;
                            i93 += 13;
                            i91 = i17;
                        }
                        iCharAt13 = i92 | (cCharAt9 << i93);
                    } else {
                        i17 = i91;
                    }
                    int i94 = i5 + i5 + (iCharAt13 / 32);
                    Object obj3 = objArrZze[i94];
                    if (obj3 instanceof Field) {
                        fieldZzC = (Field) obj3;
                    } else {
                        fieldZzC = zzC(cls2, (String) obj3);
                        objArrZze[i94] = fieldZzC;
                    }
                    i18 = iCharAt13 % 32;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzC);
                }
                if (i72 >= 18 && i72 <= 49) {
                    iArr[i63] = iObjectFieldOffset3;
                    i63++;
                }
                i19 = i83;
                iObjectFieldOffset2 = iObjectFieldOffset3;
            }
            int i95 = i61 + 1;
            iArr2[i61] = iCharAt10;
            int i96 = i61 + 2;
            iArr2[i95] = iObjectFieldOffset2 | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | ((iCharAt11 & 512) != 0 ? 536870912 : 0) | (i73 != 0 ? Integer.MIN_VALUE : 0) | (i72 << 20);
            i61 += 3;
            iArr2[i96] = (i18 << 20) | iObjectFieldOffset;
            i2 = i19;
            i31 = i17;
            length = i74;
            zzhbpVar = zzhbpVar;
            strZzd = strZzd;
            i6 = i6;
            i3 = i3;
            c = 55296;
        }
        zzhbp zzhbpVar2 = zzhbpVar;
        return new zzhbh(iArr2, objArr, i3, i6, zzhbpVar2.zza(), zzhbpVar2.zzc(), false, iArr, i4, i58, zzhbjVar, zzhasVar, zzhcpVar, zzgzgVar, zzhazVar);
    }

    private static double zzn(Object obj, long j) {
        return ((Double) zzhcz.zzh(obj, j)).doubleValue();
    }

    private static float zzo(Object obj, long j) {
        return ((Float) zzhcz.zzh(obj, j)).floatValue();
    }

    private static int zzp(Object obj, long j) {
        return ((Integer) zzhcz.zzh(obj, j)).intValue();
    }

    private final int zzq(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzs(i, 0);
    }

    private final int zzr(int i) {
        return this.zzc[i + 2];
    }

    private final int zzs(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzt(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzu(int i) {
        return this.zzc[i + 1];
    }

    private static long zzv(Object obj, long j) {
        return ((Long) zzhcz.zzh(obj, j)).longValue();
    }

    private final zzgzy zzw(int i) {
        int i2 = i / 3;
        return (zzgzy) this.zzd[i2 + i2 + 1];
    }

    private final zzhby zzx(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzhby zzhbyVar = (zzhby) objArr[i3];
        if (zzhbyVar != null) {
            return zzhbyVar;
        }
        zzhby zzhbyVarZzb = zzhbn.zza().zzb((Class) objArr[i3 + 1]);
        this.zzd[i3] = zzhbyVarZzb;
        return zzhbyVarZzb;
    }

    private final Object zzy(Object obj, int i, Object obj2, zzhcp zzhcpVar, Object obj3) {
        int i2 = this.zzc[i];
        Object objZzh = zzhcz.zzh(obj, zzu(i) & 1048575);
        if (objZzh == null || zzw(i) == null) {
            return obj2;
        }
        throw null;
    }

    private final Object zzz(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    /* JADX WARN: Code duplicated, block: B:137:0x038b  */
    /* JADX WARN: Code duplicated, block: B:207:0x054d  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v108, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v109, types: [com.google.android.gms.internal.ads.zzham] */
    /* JADX WARN: Type inference failed for: r0v111, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v113, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v130 */
    /* JADX WARN: Type inference failed for: r0v178, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v248, types: [int] */
    /* JADX WARN: Type inference failed for: r0v256 */
    /* JADX WARN: Type inference failed for: r0v258 */
    /* JADX WARN: Type inference failed for: r0v259 */
    /* JADX WARN: Type inference failed for: r0v260 */
    /* JADX WARN: Type inference failed for: r0v261 */
    /* JADX WARN: Type inference failed for: r0v262 */
    /* JADX WARN: Type inference failed for: r0v263 */
    /* JADX WARN: Type inference failed for: r0v264 */
    /* JADX WARN: Type inference failed for: r0v265 */
    /* JADX WARN: Type inference failed for: r0v266 */
    /* JADX WARN: Type inference failed for: r0v267 */
    /* JADX WARN: Type inference failed for: r0v268 */
    /* JADX WARN: Type inference failed for: r0v269 */
    /* JADX WARN: Type inference failed for: r0v270 */
    /* JADX WARN: Type inference failed for: r0v271 */
    /* JADX WARN: Type inference failed for: r0v272 */
    /* JADX WARN: Type inference failed for: r0v273 */
    /* JADX WARN: Type inference failed for: r0v274 */
    /* JADX WARN: Type inference failed for: r0v275 */
    /* JADX WARN: Type inference failed for: r12v3, types: [int] */
    /* JADX WARN: Type inference failed for: r12v4, types: [int] */
    /* JADX WARN: Type inference failed for: r12v5, types: [int] */
    /* JADX WARN: Type inference failed for: r12v6, types: [int] */
    /* JADX WARN: Type inference failed for: r12v8, types: [int] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v112, types: [int] */
    /* JADX WARN: Type inference failed for: r1v115, types: [int] */
    /* JADX WARN: Type inference failed for: r1v154 */
    /* JADX WARN: Type inference failed for: r1v157 */
    /* JADX WARN: Type inference failed for: r1v158 */
    /* JADX WARN: Type inference failed for: r1v160 */
    /* JADX WARN: Type inference failed for: r1v161 */
    /* JADX WARN: Type inference failed for: r1v162 */
    /* JADX WARN: Type inference failed for: r1v72, types: [int] */
    /* JADX WARN: Type inference failed for: r1v74 */
    /* JADX WARN: Type inference failed for: r2v26, types: [int] */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32, types: [int] */
    /* JADX WARN: Type inference failed for: r2v36, types: [int] */
    /* JADX WARN: Type inference failed for: r2v40, types: [int] */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49, types: [int] */
    /* JADX WARN: Type inference failed for: r2v83 */
    /* JADX WARN: Type inference failed for: r2v84 */
    /* JADX WARN: Type inference failed for: r2v85 */
    /* JADX WARN: Type inference failed for: r2v86 */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23, types: [int] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26, types: [int] */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v35, types: [int] */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v42, types: [int] */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v50 */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30, types: [int] */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v37, types: [int] */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v58 */
    /* JADX WARN: Type inference failed for: r4v59 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.gms.internal.ads.zzhby
    public final int zza(Object obj) {
        int i;
        ?? r15;
        ?? r5;
        int iZzz;
        int iZzz2;
        int iZzz3;
        int iZzA;
        int iZzz4;
        int iZzz5;
        int iZzd;
        int iZzz6;
        ?? Zzg;
        int size;
        int iZzz7;
        int iZzy;
        int iZzy2;
        ?? r3;
        int iZzx;
        ?? Zzz;
        ?? Zzh;
        int iZze;
        int iZzz8;
        int iZzz9;
        ?? r4;
        ?? r6;
        ?? r1;
        Unsafe unsafe = zzb;
        boolean z = false;
        int i2 = 1048575;
        ?? r2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (i3 < this.zzc.length) {
            int iZzu = zzu(i3);
            int iZzt = zzt(iZzu);
            int[] iArr = this.zzc;
            int i6 = iArr[i3];
            int i7 = iArr[i3 + 2];
            int i8 = i7 & i2;
            if (iZzt <= 17) {
                if (i8 != i5) {
                    r1 = i8 == i2 ? z : unsafe.getInt(obj, i8);
                    i5 = i8;
                }
                i = i5;
                r15 = r1;
                r5 = 1 << (i7 >>> 20);
            } else {
                r1 = r2;
                i = i5;
                r15 = r2 == true ? 1 : 0;
                r5 = z;
            }
            int i9 = iZzu & i2;
            if (iZzt >= zzgzl.DOUBLE_LIST_PACKED.zza()) {
                zzgzl.SINT64_LIST_PACKED.zza();
            }
            long j = i9;
            switch (iZzt) {
                case 0:
                    if (zzO(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        iZzz = zzgza.zzz(i6 << 3);
                        Zzh = iZzz + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 1:
                    if (zzO(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        iZzz2 = zzgza.zzz(i6 << 3);
                        Zzh = iZzz2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 2:
                    if (zzO(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzz3 = zzgza.zzz(i6 << 3);
                        iZzA = zzgza.zzA(j2);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 3:
                    if (zzO(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        long j3 = unsafe.getLong(obj, j);
                        iZzz3 = zzgza.zzz(i6 << 3);
                        iZzA = zzgza.zzA(j3);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 4:
                    if (zzO(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        long j4 = unsafe.getInt(obj, j);
                        iZzz3 = zzgza.zzz(i6 << 3);
                        iZzA = zzgza.zzA(j4);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 5:
                    if (zzO(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        iZzz = zzgza.zzz(i6 << 3);
                        Zzh = iZzz + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 6:
                    if (zzO(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        iZzz2 = zzgza.zzz(i6 << 3);
                        Zzh = iZzz2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 7:
                    if (zzO(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        iZzz4 = zzgza.zzz(i6 << 3);
                        Zzh = iZzz4 + 1;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 8:
                    if (zzO(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        int i10 = i6 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzgyl) {
                            iZzz5 = zzgza.zzz(i10);
                            iZzd = ((zzgyl) object).zzd();
                            iZzz6 = zzgza.zzz(iZzd);
                            Zzh = iZzz5 + iZzz6 + iZzd;
                            i4 += Zzh;
                        } else {
                            iZzz3 = zzgza.zzz(i10);
                            iZzA = zzgza.zzy((String) object);
                            Zzh = iZzz3 + iZzA;
                            i4 += Zzh;
                        }
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 9:
                    if (zzO(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        Zzh = zzhca.zzh(i6, unsafe.getObject(obj, j), zzx(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 10:
                    if (zzO(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        zzgyl zzgylVar = (zzgyl) unsafe.getObject(obj, j);
                        iZzz5 = zzgza.zzz(i6 << 3);
                        iZzd = zzgylVar.zzd();
                        iZzz6 = zzgza.zzz(iZzd);
                        Zzh = iZzz5 + iZzz6 + iZzd;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 11:
                    if (zzO(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        int i11 = unsafe.getInt(obj, j);
                        iZzz3 = zzgza.zzz(i6 << 3);
                        iZzA = zzgza.zzz(i11);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 12:
                    if (zzO(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        long j5 = unsafe.getInt(obj, j);
                        iZzz3 = zzgza.zzz(i6 << 3);
                        iZzA = zzgza.zzA(j5);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 13:
                    if (zzO(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        iZzz2 = zzgza.zzz(i6 << 3);
                        Zzh = iZzz2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 14:
                    if (zzO(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        iZzz = zzgza.zzz(i6 << 3);
                        Zzh = iZzz + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 15:
                    if (zzO(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        int i12 = unsafe.getInt(obj, j);
                        iZzz3 = zzgza.zzz(i6 << 3);
                        iZzA = zzgza.zzz((i12 >> 31) ^ (i12 + i12));
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 16:
                    if (zzO(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        long j6 = unsafe.getLong(obj, j);
                        iZzz3 = zzgza.zzz(i6 << 3);
                        iZzA = zzgza.zzA((j6 >> 63) ^ (j6 + j6));
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 17:
                    if (zzO(obj, i3, i, r15 == true ? 1 : 0, r5)) {
                        Zzh = zzgza.zzw(i6, (zzhbe) unsafe.getObject(obj, j), zzx(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 18:
                    Zzh = zzhca.zzd(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 19:
                    Zzh = zzhca.zzb(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i13 = zzhca.zza;
                    if (list.size() == 0) {
                        Zzg = z;
                    } else {
                        Zzg = zzhca.zzg(list) + (list.size() * zzgza.zzz(i6 << 3));
                    }
                    i4 += Zzg;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i14 = zzhca.zza;
                    size = list2.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzz3 = zzhca.zzl(list2);
                        iZzz7 = zzgza.zzz(i6 << 3);
                        iZzA = size * iZzz7;
                        Zzh = iZzz3 + iZzA;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i15 = zzhca.zza;
                    size = list3.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzz3 = zzhca.zzf(list3);
                        iZzz7 = zzgza.zzz(i6 << 3);
                        iZzA = size * iZzz7;
                        Zzh = iZzz3 + iZzA;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 23:
                    Zzh = zzhca.zzd(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 24:
                    Zzh = zzhca.zzb(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i16 = zzhca.zza;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        Zzh = z;
                    } else {
                        Zzh = size2 * (zzgza.zzz(i6 << 3) + 1);
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 26:
                    ?? r0 = (List) unsafe.getObject(obj, j);
                    int i17 = zzhca.zza;
                    int size3 = r0.size();
                    if (size3 == 0) {
                        Zzg = z;
                    } else {
                        int iZzz10 = zzgza.zzz(i6 << 3) * size3;
                        if (r0 instanceof zzham) {
                            ?? r7 = (zzham) r0;
                            for (?? r8 = z; r8 < size3; r8++) {
                                Object objZzf = r7.zzf(r8);
                                if (objZzf instanceof zzgyl) {
                                    Zzg = iZzz10;
                                    int iZzd2 = ((zzgyl) objZzf).zzd();
                                    iZzy2 = Zzg + zzgza.zzz(iZzd2) + iZzd2;
                                } else {
                                    Zzg = iZzz10;
                                    iZzy2 = Zzg + zzgza.zzy((String) objZzf);
                                }
                                Zzg = iZzy2;
                            }
                            Zzg = iZzz10;
                        } else {
                            for (?? r9 = z; r9 < size3; r9++) {
                                Object obj2 = r0.get(r9);
                                if (obj2 instanceof zzgyl) {
                                    Zzg = iZzz10;
                                    int iZzd3 = ((zzgyl) obj2).zzd();
                                    iZzy = Zzg + zzgza.zzz(iZzd3) + iZzd3;
                                } else {
                                    Zzg = iZzz10;
                                    iZzy = Zzg + zzgza.zzy((String) obj2);
                                }
                                Zzg = iZzy;
                            }
                            Zzg = iZzz10;
                        }
                    }
                    i4 += Zzg;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 27:
                    ?? r10 = (List) unsafe.getObject(obj, j);
                    zzhby zzhbyVarZzx = zzx(i3);
                    int i18 = zzhca.zza;
                    int size4 = r10.size();
                    if (size4 == 0) {
                        r3 = z;
                    } else {
                        int iZzz11 = zzgza.zzz(i6 << 3) * size4;
                        for (?? r11 = z; r11 < size4; r11++) {
                            Object obj3 = r10.get(r11);
                            if (obj3 instanceof zzhak) {
                                r3 = iZzz11;
                                int iZza = ((zzhak) obj3).zza();
                                iZzx = (r3 == true ? 1 : 0) + zzgza.zzz(iZza) + iZza;
                            } else {
                                r3 = iZzz11;
                                iZzx = (r3 == true ? 1 : 0) + zzgza.zzx((zzhbe) obj3, zzhbyVarZzx);
                            }
                            r3 = iZzx;
                        }
                        r3 = iZzz11;
                    }
                    i4 += r3;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 28:
                    ?? r12 = (List) unsafe.getObject(obj, j);
                    int i19 = zzhca.zza;
                    int size5 = r12.size();
                    if (size5 == 0) {
                        Zzz = z;
                    } else {
                        Zzz = size5 * zzgza.zzz(i6 << 3);
                        for (?? r13 = z; r13 < r12.size(); r13++) {
                            int iZzd4 = ((zzgyl) r12.get(r13)).zzd();
                            Zzz += zzgza.zzz(iZzd4) + iZzd4;
                        }
                    }
                    i4 += Zzz;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 29:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i20 = zzhca.zza;
                    size = list5.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzz3 = zzhca.zzk(list5);
                        iZzz7 = zzgza.zzz(i6 << 3);
                        iZzA = size * iZzz7;
                        Zzh = iZzz3 + iZzA;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 30:
                    List list6 = (List) unsafe.getObject(obj, j);
                    int i21 = zzhca.zza;
                    size = list6.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzz3 = zzhca.zza(list6);
                        iZzz7 = zzgza.zzz(i6 << 3);
                        iZzA = size * iZzz7;
                        Zzh = iZzz3 + iZzA;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 31:
                    Zzh = zzhca.zzb(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 32:
                    Zzh = zzhca.zzd(i6, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 33:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i22 = zzhca.zza;
                    size = list7.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzz3 = zzhca.zzi(list7);
                        iZzz7 = zzgza.zzz(i6 << 3);
                        iZzA = size * iZzz7;
                        Zzh = iZzz3 + iZzA;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 34:
                    List list8 = (List) unsafe.getObject(obj, j);
                    int i23 = zzhca.zza;
                    size = list8.size();
                    if (size == 0) {
                        Zzh = z;
                    } else {
                        iZzz3 = zzhca.zzj(list8);
                        iZzz7 = zzgza.zzz(i6 << 3);
                        iZzA = size * iZzz7;
                        Zzh = iZzz3 + iZzA;
                    }
                    i4 += Zzh;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 35:
                    iZze = zzhca.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzgza.zzz(i6 << 3);
                        iZzz9 = zzgza.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 36:
                    iZze = zzhca.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzgza.zzz(i6 << 3);
                        iZzz9 = zzgza.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 37:
                    iZze = zzhca.zzg((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzgza.zzz(i6 << 3);
                        iZzz9 = zzgza.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 38:
                    iZze = zzhca.zzl((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzgza.zzz(i6 << 3);
                        iZzz9 = zzgza.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 39:
                    iZze = zzhca.zzf((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzgza.zzz(i6 << 3);
                        iZzz9 = zzgza.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 40:
                    iZze = zzhca.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzgza.zzz(i6 << 3);
                        iZzz9 = zzgza.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 41:
                    iZze = zzhca.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzgza.zzz(i6 << 3);
                        iZzz9 = zzgza.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 42:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i24 = zzhca.zza;
                    iZze = list9.size();
                    if (iZze > 0) {
                        iZzz8 = zzgza.zzz(i6 << 3);
                        iZzz9 = zzgza.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 43:
                    iZze = zzhca.zzk((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzgza.zzz(i6 << 3);
                        iZzz9 = zzgza.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 44:
                    iZze = zzhca.zza((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzgza.zzz(i6 << 3);
                        iZzz9 = zzgza.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 45:
                    iZze = zzhca.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzgza.zzz(i6 << 3);
                        iZzz9 = zzgza.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 46:
                    iZze = zzhca.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzgza.zzz(i6 << 3);
                        iZzz9 = zzgza.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 47:
                    iZze = zzhca.zzi((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzgza.zzz(i6 << 3);
                        iZzz9 = zzgza.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                    iZze = zzhca.zzj((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzz8 = zzgza.zzz(i6 << 3);
                        iZzz9 = zzgza.zzz(iZze);
                        Zzz = iZzz8 + iZzz9 + iZze;
                        i4 += Zzz;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    ?? r14 = (List) unsafe.getObject(obj, j);
                    zzhby zzhbyVarZzx2 = zzx(i3);
                    int i25 = zzhca.zza;
                    int size6 = r14.size();
                    if (size6 == 0) {
                        r4 = z;
                    } else {
                        boolean z2 = z;
                        r4 = z2;
                        while (r6 < size6) {
                            r6 = z2;
                            int iZzw = zzgza.zzw(i6, (zzhbe) r14.get(r6), zzhbyVarZzx2);
                            r6++;
                            r4 = (r4 == true ? 1 : 0) + iZzw;
                        }
                        r6 = z2;
                    }
                    i4 += r4;
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 50:
                    zzhay zzhayVar = (zzhay) unsafe.getObject(obj, j);
                    if (zzhayVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzhayVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzR(obj, i6, i3)) {
                        iZzz = zzgza.zzz(i6 << 3);
                        Zzh = iZzz + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 52:
                    if (zzR(obj, i6, i3)) {
                        iZzz2 = zzgza.zzz(i6 << 3);
                        Zzh = iZzz2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (zzR(obj, i6, i3)) {
                        long jZzv = zzv(obj, j);
                        iZzz3 = zzgza.zzz(i6 << 3);
                        iZzA = zzgza.zzA(jZzv);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (zzR(obj, i6, i3)) {
                        long jZzv2 = zzv(obj, j);
                        iZzz3 = zzgza.zzz(i6 << 3);
                        iZzA = zzgza.zzA(jZzv2);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (zzR(obj, i6, i3)) {
                        long jZzp = zzp(obj, j);
                        iZzz3 = zzgza.zzz(i6 << 3);
                        iZzA = zzgza.zzA(jZzp);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 56:
                    if (zzR(obj, i6, i3)) {
                        iZzz = zzgza.zzz(i6 << 3);
                        Zzh = iZzz + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 57:
                    if (zzR(obj, i6, i3)) {
                        iZzz2 = zzgza.zzz(i6 << 3);
                        Zzh = iZzz2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 58:
                    if (zzR(obj, i6, i3)) {
                        iZzz4 = zzgza.zzz(i6 << 3);
                        Zzh = iZzz4 + 1;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 59:
                    if (zzR(obj, i6, i3)) {
                        int i26 = i6 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzgyl) {
                            iZzz5 = zzgza.zzz(i26);
                            iZzd = ((zzgyl) object2).zzd();
                            iZzz6 = zzgza.zzz(iZzd);
                            Zzh = iZzz5 + iZzz6 + iZzd;
                            i4 += Zzh;
                        } else {
                            iZzz3 = zzgza.zzz(i26);
                            iZzA = zzgza.zzy((String) object2);
                            Zzh = iZzz3 + iZzA;
                            i4 += Zzh;
                        }
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzR(obj, i6, i3)) {
                        Zzh = zzhca.zzh(i6, unsafe.getObject(obj, j), zzx(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzR(obj, i6, i3)) {
                        zzgyl zzgylVar2 = (zzgyl) unsafe.getObject(obj, j);
                        iZzz5 = zzgza.zzz(i6 << 3);
                        iZzd = zzgylVar2.zzd();
                        iZzz6 = zzgza.zzz(iZzd);
                        Zzh = iZzz5 + iZzz6 + iZzd;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 62:
                    if (zzR(obj, i6, i3)) {
                        int iZzp = zzp(obj, j);
                        iZzz3 = zzgza.zzz(i6 << 3);
                        iZzA = zzgza.zzz(iZzp);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzR(obj, i6, i3)) {
                        long jZzp2 = zzp(obj, j);
                        iZzz3 = zzgza.zzz(i6 << 3);
                        iZzA = zzgza.zzA(jZzp2);
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 64:
                    if (zzR(obj, i6, i3)) {
                        iZzz2 = zzgza.zzz(i6 << 3);
                        Zzh = iZzz2 + 4;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (zzR(obj, i6, i3)) {
                        iZzz = zzgza.zzz(i6 << 3);
                        Zzh = iZzz + 8;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (zzR(obj, i6, i3)) {
                        int iZzp2 = zzp(obj, j);
                        iZzz3 = zzgza.zzz(i6 << 3);
                        iZzA = zzgza.zzz((iZzp2 >> 31) ^ (iZzp2 + iZzp2));
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 67:
                    if (zzR(obj, i6, i3)) {
                        long jZzv3 = zzv(obj, j);
                        iZzz3 = zzgza.zzz(i6 << 3);
                        iZzA = zzgza.zzA((jZzv3 >> 63) ^ (jZzv3 + jZzv3));
                        Zzh = iZzz3 + iZzA;
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                case 68:
                    if (zzR(obj, i6, i3)) {
                        Zzh = zzgza.zzw(i6, (zzhbe) unsafe.getObject(obj, j), zzx(i3));
                        i4 += Zzh;
                    }
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
                default:
                    i3 += 3;
                    i5 = i;
                    r2 = r15;
                    z = false;
                    i2 = 1048575;
                    break;
            }
        }
        zzhcp zzhcpVar = this.zzn;
        int iZza2 = i4 + zzhcpVar.zza(zzhcpVar.zzd(obj));
        if (!this.zzh) {
            return iZza2;
        }
        this.zzo.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzc.length; i4 += 3) {
            int iZzu = zzu(i4);
            int[] iArr = this.zzc;
            int i5 = 1048575 & iZzu;
            int iZzt = zzt(iZzu);
            int i6 = iArr[i4];
            long j = i5;
            int iHashCode = 37;
            switch (iZzt) {
                case 0:
                    i = i3 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzhcz.zzb(obj, j));
                    byte[] bArr = zzhae.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i3 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzhcz.zzc(obj, j));
                    i3 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i3 * 53;
                    jDoubleToLongBits = zzhcz.zzf(obj, j);
                    byte[] bArr2 = zzhae.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i3 * 53;
                    jDoubleToLongBits = zzhcz.zzf(obj, j);
                    byte[] bArr3 = zzhae.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i3 * 53;
                    iFloatToIntBits = zzhcz.zzd(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i3 * 53;
                    jDoubleToLongBits = zzhcz.zzf(obj, j);
                    byte[] bArr4 = zzhae.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i3 * 53;
                    iFloatToIntBits = zzhcz.zzd(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i3 * 53;
                    iFloatToIntBits = zzhae.zza(zzhcz.zzz(obj, j));
                    i3 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i3 * 53;
                    iFloatToIntBits = ((String) zzhcz.zzh(obj, j)).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 9:
                    i2 = i3 * 53;
                    Object objZzh = zzhcz.zzh(obj, j);
                    if (objZzh != null) {
                        iHashCode = objZzh.hashCode();
                    }
                    i3 = i2 + iHashCode;
                    break;
                case 10:
                    i = i3 * 53;
                    iFloatToIntBits = zzhcz.zzh(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i3 * 53;
                    iFloatToIntBits = zzhcz.zzd(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i3 * 53;
                    iFloatToIntBits = zzhcz.zzd(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i3 * 53;
                    iFloatToIntBits = zzhcz.zzd(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i3 * 53;
                    jDoubleToLongBits = zzhcz.zzf(obj, j);
                    byte[] bArr5 = zzhae.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i3 * 53;
                    iFloatToIntBits = zzhcz.zzd(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i3 * 53;
                    jDoubleToLongBits = zzhcz.zzf(obj, j);
                    byte[] bArr6 = zzhae.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 17:
                    i2 = i3 * 53;
                    Object objZzh2 = zzhcz.zzh(obj, j);
                    if (objZzh2 != null) {
                        iHashCode = objZzh2.hashCode();
                    }
                    i3 = i2 + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    i = i3 * 53;
                    iFloatToIntBits = zzhcz.zzh(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i3 * 53;
                    iFloatToIntBits = zzhcz.zzh(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzn(obj, j));
                        byte[] bArr7 = zzhae.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzo(obj, j));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr8 = zzhae.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr9 = zzhae.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr10 = zzhae.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzhae.zza(zzS(obj, j));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = ((String) zzhcz.zzh(obj, j)).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzhcz.zzh(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzhcz.zzh(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr11 = zzhae.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr12 = zzhae.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzhcz.zzh(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
            }
        }
        int iHashCode2 = (i3 * 53) + this.zzn.zzd(obj).hashCode();
        if (!this.zzh) {
            return iHashCode2;
        }
        this.zzo.zza(obj);
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:379:0x0833 A[PHI: r7 r8 r9 r10 r11 r14
  0x0833: PHI (r7v24 int) = (r7v6 int), (r7v8 int), (r7v9 int), (r7v14 int), (r7v18 int), (r7v22 int), (r7v28 int) binds: [B:368:0x07ea, B:352:0x0794, B:336:0x0745, B:261:0x05f1, B:212:0x0526, B:179:0x0494, B:138:0x038f] A[DONT_GENERATE, DONT_INLINE]
  0x0833: PHI (r8v98 int) = (r8v41 int), (r8v43 int), (r8v44 int), (r8v73 int), (r8v89 int), (r8v96 int), (r8v101 int) binds: [B:368:0x07ea, B:352:0x0794, B:336:0x0745, B:261:0x05f1, B:212:0x0526, B:179:0x0494, B:138:0x038f] A[DONT_GENERATE, DONT_INLINE]
  0x0833: PHI (r9v63 int) = (r9v35 int), (r9v37 int), (r9v38 int), (r9v51 int), (r9v59 int), (r9v61 int), (r9v66 int) binds: [B:368:0x07ea, B:352:0x0794, B:336:0x0745, B:261:0x05f1, B:212:0x0526, B:179:0x0494, B:138:0x038f] A[DONT_GENERATE, DONT_INLINE]
  0x0833: PHI (r10v72 int) = (r10v40 int), (r10v42 int), (r10v43 int), (r10v45 int), (r10v57 int), (r10v64 int), (r10v76 int) binds: [B:368:0x07ea, B:352:0x0794, B:336:0x0745, B:261:0x05f1, B:212:0x0526, B:179:0x0494, B:138:0x038f] A[DONT_GENERATE, DONT_INLINE]
  0x0833: PHI (r11v42 int) = (r11v20 int), (r11v22 int), (r11v23 int), (r11v25 int), (r11v34 int), (r11v40 int), (r11v46 int) binds: [B:368:0x07ea, B:352:0x0794, B:336:0x0745, B:261:0x05f1, B:212:0x0526, B:179:0x0494, B:138:0x038f] A[DONT_GENERATE, DONT_INLINE]
  0x0833: PHI (r14v44 sun.misc.Unsafe) = 
  (r14v23 sun.misc.Unsafe)
  (r14v25 sun.misc.Unsafe)
  (r14v26 sun.misc.Unsafe)
  (r14v28 sun.misc.Unsafe)
  (r14v36 sun.misc.Unsafe)
  (r14v42 sun.misc.Unsafe)
  (r14v47 sun.misc.Unsafe)
 binds: [B:368:0x07ea, B:352:0x0794, B:336:0x0745, B:261:0x05f1, B:212:0x0526, B:179:0x0494, B:138:0x038f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:465:0x0ae0 A[PHI: r8 r10 r11 r12 r36
  0x0ae0: PHI (r8v123 com.google.android.gms.internal.ads.zzgxx) = 
  (r8v104 com.google.android.gms.internal.ads.zzgxx)
  (r8v105 com.google.android.gms.internal.ads.zzgxx)
  (r8v106 com.google.android.gms.internal.ads.zzgxx)
  (r8v107 com.google.android.gms.internal.ads.zzgxx)
  (r8v108 com.google.android.gms.internal.ads.zzgxx)
  (r8v109 com.google.android.gms.internal.ads.zzgxx)
  (r8v110 com.google.android.gms.internal.ads.zzgxx)
  (r8v111 com.google.android.gms.internal.ads.zzgxx)
  (r8v112 com.google.android.gms.internal.ads.zzgxx)
  (r8v116 com.google.android.gms.internal.ads.zzgxx)
  (r8v124 com.google.android.gms.internal.ads.zzgxx)
 binds: [B:463:0x0ac9, B:460:0x0aa7, B:457:0x0a89, B:454:0x0a6b, B:451:0x0a4d, B:448:0x0a2e, B:441:0x0a06, B:439:0x09f8, B:424:0x09ad, B:420:0x097a, B:396:0x08a5] A[DONT_GENERATE, DONT_INLINE]
  0x0ae0: PHI (r10v101 int) = 
  (r10v80 int)
  (r10v81 int)
  (r10v82 int)
  (r10v83 int)
  (r10v84 int)
  (r10v85 int)
  (r10v86 int)
  (r10v87 int)
  (r10v88 int)
  (r10v94 int)
  (r10v102 int)
 binds: [B:463:0x0ac9, B:460:0x0aa7, B:457:0x0a89, B:454:0x0a6b, B:451:0x0a4d, B:448:0x0a2e, B:441:0x0a06, B:439:0x09f8, B:424:0x09ad, B:420:0x097a, B:396:0x08a5] A[DONT_GENERATE, DONT_INLINE]
  0x0ae0: PHI (r11v64 int) = 
  (r11v48 int)
  (r11v49 int)
  (r11v50 int)
  (r11v51 int)
  (r11v52 int)
  (r11v53 int)
  (r11v54 int)
  (r11v55 int)
  (r11v56 int)
  (r11v59 int)
  (r11v65 int)
 binds: [B:463:0x0ac9, B:460:0x0aa7, B:457:0x0a89, B:454:0x0a6b, B:451:0x0a4d, B:448:0x0a2e, B:441:0x0a06, B:439:0x09f8, B:424:0x09ad, B:420:0x097a, B:396:0x08a5] A[DONT_GENERATE, DONT_INLINE]
  0x0ae0: PHI (r12v34 int) = 
  (r12v15 int)
  (r12v16 int)
  (r12v17 int)
  (r12v18 int)
  (r12v19 int)
  (r12v20 int)
  (r12v21 int)
  (r12v22 int)
  (r12v23 int)
  (r12v27 int)
  (r12v35 int)
 binds: [B:463:0x0ac9, B:460:0x0aa7, B:457:0x0a89, B:454:0x0a6b, B:451:0x0a4d, B:448:0x0a2e, B:441:0x0a06, B:439:0x09f8, B:424:0x09ad, B:420:0x097a, B:396:0x08a5] A[DONT_GENERATE, DONT_INLINE]
  0x0ae0: PHI (r36v21 int) = 
  (r36v3 int)
  (r36v4 int)
  (r36v5 int)
  (r36v6 int)
  (r36v7 int)
  (r36v8 int)
  (r36v9 int)
  (r36v10 int)
  (r36v14 int)
  (r36v16 int)
  (r36v22 int)
 binds: [B:463:0x0ac9, B:460:0x0aa7, B:457:0x0a89, B:454:0x0a6b, B:451:0x0a4d, B:448:0x0a2e, B:441:0x0a06, B:439:0x09f8, B:424:0x09ad, B:420:0x097a, B:396:0x08a5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:537:0x0836 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:540:0x0ae3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:580:0x0847 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:583:0x0af6 A[SYNTHETIC] */
    final int zzc(Object obj, byte[] bArr, int i, int i2, int i3, zzgxx zzgxxVar) throws IOException {
        zzhbh<T> zzhbhVar;
        int i4;
        int i5;
        Unsafe unsafe;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Unsafe unsafe2;
        zzgxx zzgxxVar2;
        int i14;
        int i15;
        int i16;
        zzgzf zzgzfVar;
        int i17;
        int i18;
        int i19;
        int i20;
        int iZzk;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        Unsafe unsafe3;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        Unsafe unsafe4;
        int i36;
        int iZzf;
        Object obj2;
        int i37;
        int iZzj;
        int i38;
        int i39;
        int i40;
        zzhbh<T> zzhbhVar2 = this;
        Object obj3 = obj;
        i2 = i2;
        i3 = i3;
        zzgxx zzgxxVar3 = zzgxxVar;
        zzD(obj);
        Unsafe unsafe5 = zzb;
        int i41 = -1;
        int iZzg = i;
        int i42 = -1;
        int i43 = 0;
        int i44 = 0;
        int i45 = 0;
        int i46 = 1048575;
        while (true) {
            if (iZzg < i2) {
                int i47 = iZzg + 1;
                int i48 = bArr[iZzg];
                if (i48 < 0) {
                    int iZzi = zzgxy.zzi(i48, bArr, i47, zzgxxVar3);
                    i9 = zzgxxVar3.zza;
                    i47 = iZzi;
                } else {
                    i9 = i48;
                }
                int i49 = i9 >>> 3;
                int iZzs = i49 > i42 ? (i49 < zzhbhVar2.zze || i49 > zzhbhVar2.zzf) ? i41 : zzhbhVar2.zzs(i49, i43 / 3) : zzhbhVar2.zzq(i49);
                if (iZzs != i41) {
                    int i50 = i9 & 7;
                    int[] iArr = zzhbhVar2.zzc;
                    int i51 = iArr[iZzs + 1];
                    int i52 = i49;
                    int iZzt = zzt(i51);
                    long j = i51 & 1048575;
                    int i53 = i9;
                    if (iZzt <= 17) {
                        int i54 = iArr[iZzs + 2];
                        int i55 = 1 << (i54 >>> 20);
                        int i56 = 1048575;
                        int i57 = i54 & 1048575;
                        if (i57 != i46) {
                            if (i46 != 1048575) {
                                unsafe5.putInt(obj3, i46, i45);
                                i56 = 1048575;
                            }
                            i45 = i57 == i56 ? 0 : unsafe5.getInt(obj3, i57);
                            i12 = i57;
                        } else {
                            i12 = i46;
                        }
                        switch (iZzt) {
                            case 0:
                                i17 = iZzs;
                                i18 = i52;
                                i19 = i53;
                                if (i50 == 1) {
                                    iZzg = i47 + 8;
                                    i45 |= i55;
                                    zzhcz.zzr(obj3, j, Double.longBitsToDouble(zzgxy.zzn(bArr, i47)));
                                    i2 = i2;
                                    i3 = i3;
                                    i44 = i19;
                                    i42 = i18;
                                    i43 = i17;
                                    i46 = i12;
                                    i41 = -1;
                                } else {
                                    i45 = i45;
                                    i23 = i19;
                                    i52 = i18;
                                    i24 = i17;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgxxVar2 = zzgxxVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i58 = i47;
                                    i44 = i23;
                                    i10 = i58;
                                }
                                break;
                            case 1:
                                i17 = iZzs;
                                i18 = i52;
                                i19 = i53;
                                if (i50 == 5) {
                                    iZzg = i47 + 4;
                                    i45 |= i55;
                                    zzhcz.zzs(obj3, j, Float.intBitsToFloat(zzgxy.zzb(bArr, i47)));
                                    i2 = i2;
                                    i3 = i3;
                                    i44 = i19;
                                    i42 = i18;
                                    i43 = i17;
                                    i46 = i12;
                                    i41 = -1;
                                } else {
                                    i45 = i45;
                                    i23 = i19;
                                    i52 = i18;
                                    i24 = i17;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgxxVar2 = zzgxxVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i59 = i47;
                                    i44 = i23;
                                    i10 = i59;
                                }
                                break;
                            case 2:
                            case 3:
                                i17 = iZzs;
                                i18 = i52;
                                i19 = i53;
                                if (i50 == 0) {
                                    i20 = i45 | i55;
                                    iZzk = zzgxy.zzk(bArr, i47, zzgxxVar3);
                                    unsafe5.putLong(obj, j, zzgxxVar3.zzb);
                                    i2 = i2;
                                    i3 = i3;
                                    i44 = i19;
                                    i42 = i18;
                                    i43 = i17;
                                    i45 = i20;
                                    iZzg = iZzk;
                                    i46 = i12;
                                    i41 = -1;
                                } else {
                                    i45 = i45;
                                    i23 = i19;
                                    i52 = i18;
                                    i24 = i17;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgxxVar2 = zzgxxVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i510 = i47;
                                    i44 = i23;
                                    i10 = i510;
                                }
                                break;
                            case 4:
                            case 11:
                                i17 = iZzs;
                                i18 = i52;
                                i19 = i53;
                                if (i50 == 0) {
                                    i45 |= i55;
                                    iZzg = zzgxy.zzh(bArr, i47, zzgxxVar3);
                                    unsafe5.putInt(obj3, j, zzgxxVar3.zza);
                                    i2 = i2;
                                    i3 = i3;
                                    i44 = i19;
                                    i42 = i18;
                                    i43 = i17;
                                    i46 = i12;
                                    i41 = -1;
                                } else {
                                    i45 = i45;
                                    i23 = i19;
                                    i52 = i18;
                                    i24 = i17;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgxxVar2 = zzgxxVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i511 = i47;
                                    i44 = i23;
                                    i10 = i511;
                                }
                                break;
                            case 5:
                            case 14:
                                i17 = iZzs;
                                i18 = i52;
                                i19 = i53;
                                if (i50 == 1) {
                                    iZzk = i47 + 8;
                                    i20 = i45 | i55;
                                    unsafe5.putLong(obj, j, zzgxy.zzn(bArr, i47));
                                    i2 = i2;
                                    i3 = i3;
                                    i44 = i19;
                                    i42 = i18;
                                    i43 = i17;
                                    i45 = i20;
                                    iZzg = iZzk;
                                    i46 = i12;
                                    i41 = -1;
                                } else {
                                    i45 = i45;
                                    i23 = i19;
                                    i52 = i18;
                                    i24 = i17;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgxxVar2 = zzgxxVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i512 = i47;
                                    i44 = i23;
                                    i10 = i512;
                                }
                                break;
                            case 6:
                            case 13:
                                i17 = iZzs;
                                i18 = i52;
                                i19 = i53;
                                if (i50 == 5) {
                                    iZzg = i47 + 4;
                                    i45 |= i55;
                                    unsafe5.putInt(obj3, j, zzgxy.zzb(bArr, i47));
                                    i2 = i2;
                                    i3 = i3;
                                    i44 = i19;
                                    i42 = i18;
                                    i43 = i17;
                                    i46 = i12;
                                    i41 = -1;
                                } else {
                                    i45 = i45;
                                    i23 = i19;
                                    i52 = i18;
                                    i24 = i17;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgxxVar2 = zzgxxVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i513 = i47;
                                    i44 = i23;
                                    i10 = i513;
                                }
                                break;
                            case 7:
                                i17 = iZzs;
                                i18 = i52;
                                i19 = i53;
                                if (i50 == 0) {
                                    i45 |= i55;
                                    iZzg = zzgxy.zzk(bArr, i47, zzgxxVar3);
                                    zzhcz.zzp(obj3, j, zzgxxVar3.zzb != 0);
                                    i2 = i2;
                                    i3 = i3;
                                    i44 = i19;
                                    i42 = i18;
                                    i43 = i17;
                                    i46 = i12;
                                    i41 = -1;
                                } else {
                                    i45 = i45;
                                    i23 = i19;
                                    i52 = i18;
                                    i24 = i17;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgxxVar2 = zzgxxVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i514 = i47;
                                    i44 = i23;
                                    i10 = i514;
                                }
                                break;
                            case 8:
                                i17 = iZzs;
                                i18 = i52;
                                i19 = i53;
                                if (i50 == 2) {
                                    if (zzM(i51)) {
                                        iZzg = zzgxy.zzh(bArr, i47, zzgxxVar3);
                                        i21 = zzgxxVar3.zza;
                                        if (i21 < 0) {
                                            throw zzhag.zzf();
                                        }
                                        i22 = i45 | i55;
                                        if (i21 == 0) {
                                            zzgxxVar3.zzc = "";
                                        } else {
                                            zzgxxVar3.zzc = zzhde.zzh(bArr, iZzg, i21);
                                            iZzg += i21;
                                        }
                                    } else {
                                        iZzg = zzgxy.zzh(bArr, i47, zzgxxVar3);
                                        i21 = zzgxxVar3.zza;
                                        if (i21 < 0) {
                                            throw zzhag.zzf();
                                        }
                                        i22 = i45 | i55;
                                        if (i21 == 0) {
                                            zzgxxVar3.zzc = "";
                                        } else {
                                            zzgxxVar3.zzc = new String(bArr, iZzg, i21, zzhae.zzb);
                                            iZzg += i21;
                                        }
                                    }
                                    i45 = i22;
                                    unsafe5.putObject(obj3, j, zzgxxVar3.zzc);
                                    i2 = i2;
                                    i3 = i3;
                                    i44 = i19;
                                    i42 = i18;
                                    i43 = i17;
                                    i46 = i12;
                                    i41 = -1;
                                } else {
                                    i45 = i45;
                                    i23 = i19;
                                    i52 = i18;
                                    i24 = i17;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgxxVar2 = zzgxxVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i515 = i47;
                                    i44 = i23;
                                    i10 = i515;
                                }
                                break;
                            case 9:
                                i17 = iZzs;
                                i18 = i52;
                                i19 = i53;
                                if (i50 == 2) {
                                    Object objZzA = zzhbhVar2.zzA(obj3, i17);
                                    iZzg = zzgxy.zzm(objZzA, zzhbhVar2.zzx(i17), bArr, i47, i2, zzgxxVar);
                                    zzhbhVar2.zzJ(obj3, i17, objZzA);
                                    i2 = i2;
                                    i44 = i19;
                                    i42 = i18;
                                    i43 = i17;
                                    i45 |= i55;
                                    i46 = i12;
                                    i41 = -1;
                                    i3 = i3;
                                } else {
                                    i45 = i45;
                                    i23 = i19;
                                    i52 = i18;
                                    i24 = i17;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgxxVar2 = zzgxxVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i516 = i47;
                                    i44 = i23;
                                    i10 = i516;
                                }
                                break;
                            case 10:
                                i17 = iZzs;
                                i18 = i52;
                                i19 = i53;
                                if (i50 == 2) {
                                    i45 |= i55;
                                    iZzg = zzgxy.zza(bArr, i47, zzgxxVar3);
                                    unsafe5.putObject(obj3, j, zzgxxVar3.zzc);
                                    i2 = i2;
                                    i3 = i3;
                                    i44 = i19;
                                    i42 = i18;
                                    i43 = i17;
                                    i46 = i12;
                                    i41 = -1;
                                } else {
                                    i45 = i45;
                                    i23 = i19;
                                    i52 = i18;
                                    i24 = i17;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgxxVar2 = zzgxxVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i517 = i47;
                                    i44 = i23;
                                    i10 = i517;
                                }
                                break;
                            case 12:
                                i17 = iZzs;
                                i18 = i52;
                                if (i50 == 0) {
                                    iZzg = zzgxy.zzh(bArr, i47, zzgxxVar3);
                                    int i60 = zzgxxVar3.zza;
                                    zzgzy zzgzyVarZzw = zzhbhVar2.zzw(i17);
                                    if ((i51 & Integer.MIN_VALUE) == 0 || zzgzyVarZzw == null || zzgzyVarZzw.zza(i60)) {
                                        i19 = i53;
                                        i45 |= i55;
                                        unsafe5.putInt(obj3, j, i60);
                                    } else {
                                        i19 = i53;
                                        zzd(obj).zzj(i19, Long.valueOf(i60));
                                    }
                                    i2 = i2;
                                    i3 = i3;
                                    i44 = i19;
                                    i42 = i18;
                                    i43 = i17;
                                    i46 = i12;
                                    i41 = -1;
                                } else {
                                    i52 = i18;
                                    i24 = i17;
                                    i23 = i53;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgxxVar2 = zzgxxVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i518 = i47;
                                    i44 = i23;
                                    i10 = i518;
                                }
                                break;
                            case 15:
                                i17 = iZzs;
                                i18 = i52;
                                if (i50 == 0) {
                                    i45 |= i55;
                                    iZzg = zzgxy.zzh(bArr, i47, zzgxxVar3);
                                    unsafe5.putInt(obj3, j, zzgyt.zzF(zzgxxVar3.zza));
                                    i42 = i18;
                                    i43 = i17;
                                    i44 = i53;
                                    i46 = i12;
                                    i41 = -1;
                                } else {
                                    i52 = i18;
                                    i24 = i17;
                                    i23 = i53;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgxxVar2 = zzgxxVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i519 = i47;
                                    i44 = i23;
                                    i10 = i519;
                                }
                                break;
                            case 16:
                                if (i50 == 0) {
                                    int i61 = i45 | i55;
                                    int iZzk2 = zzgxy.zzk(bArr, i47, zzgxxVar3);
                                    i18 = i52;
                                    i17 = iZzs;
                                    unsafe5.putLong(obj, j, zzgyt.zzG(zzgxxVar3.zzb));
                                    iZzg = iZzk2;
                                    i45 = i61;
                                    i42 = i18;
                                    i43 = i17;
                                    i44 = i53;
                                    i46 = i12;
                                    i41 = -1;
                                } else {
                                    i24 = iZzs;
                                    i23 = i53;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgxxVar2 = zzgxxVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i5110 = i47;
                                    i44 = i23;
                                    i10 = i5110;
                                }
                                break;
                            default:
                                i17 = iZzs;
                                i18 = i52;
                                i19 = i53;
                                if (i50 == 3) {
                                    int i62 = i45 | i55;
                                    Object objZzA2 = zzhbhVar2.zzA(obj3, i17);
                                    int iZzl = zzgxy.zzl(objZzA2, zzhbhVar2.zzx(i17), bArr, i47, i2, (i18 << 3) | 4, zzgxxVar);
                                    zzhbhVar2.zzJ(obj3, i17, objZzA2);
                                    i3 = i3;
                                    zzgxxVar3 = zzgxxVar3;
                                    i2 = i2;
                                    unsafe5 = unsafe5;
                                    iZzg = iZzl;
                                    i41 = -1;
                                    i46 = i12;
                                    i45 = i62;
                                    i44 = i19;
                                    i43 = i17;
                                    i42 = i18;
                                } else {
                                    i45 = i45;
                                    i23 = i19;
                                    i52 = i18;
                                    i24 = i17;
                                    i13 = -1;
                                    i4 = i3;
                                    i11 = i45;
                                    i14 = i24;
                                    i5 = i2;
                                    zzgxxVar2 = zzgxxVar3;
                                    i15 = i52;
                                    unsafe2 = unsafe5;
                                    int i5111 = i47;
                                    i44 = i23;
                                    i10 = i5111;
                                }
                                break;
                        }
                    } else {
                        i11 = i45;
                        i12 = i46;
                        Unsafe unsafe6 = unsafe5;
                        i13 = -1;
                        int i63 = i2;
                        if (iZzt != 27) {
                            unsafe2 = unsafe6;
                            if (iZzt <= 49) {
                                long j2 = i51;
                                Unsafe unsafe7 = zzb;
                                zzhad zzhadVarZzd = (zzhad) unsafe7.getObject(obj3, j);
                                if (!zzhadVarZzd.zzc()) {
                                    int size = zzhadVarZzd.size();
                                    zzhadVarZzd = zzhadVarZzd.zzd(size != 0 ? size + size : 10);
                                    unsafe7.putObject(obj3, j, zzhadVarZzd);
                                }
                                zzhad zzhadVar = zzhadVarZzd;
                                switch (iZzt) {
                                    case 18:
                                    case 35:
                                        i28 = i53;
                                        i47 = i47;
                                        i29 = iZzs;
                                        unsafe3 = unsafe2;
                                        i30 = i52;
                                        i31 = i63;
                                        if (i50 == 2) {
                                            zzgzc zzgzcVar = (zzgzc) zzhadVar;
                                            iZzg = zzgxy.zzh(bArr, i47, zzgxxVar3);
                                            int i64 = zzgxxVar3.zza + iZzg;
                                            while (iZzg < i64) {
                                                zzgzcVar.zze(Double.longBitsToDouble(zzgxy.zzn(bArr, iZzg)));
                                                iZzg += 8;
                                            }
                                            if (iZzg != i64) {
                                                throw zzhag.zzj();
                                            }
                                        } else if (i50 == 1) {
                                            i32 = i47 + 8;
                                            zzgzc zzgzcVar2 = (zzgzc) zzhadVar;
                                            zzgzcVar2.zze(Double.longBitsToDouble(zzgxy.zzn(bArr, i47)));
                                            while (i32 < i31) {
                                                int iZzh = zzgxy.zzh(bArr, i32, zzgxxVar3);
                                                if (i28 == zzgxxVar3.zza) {
                                                    zzgzcVar2.zze(Double.longBitsToDouble(zzgxy.zzn(bArr, iZzh)));
                                                    i32 = iZzh + 8;
                                                } else {
                                                    iZzg = i32;
                                                }
                                            }
                                            iZzg = i32;
                                        } else {
                                            iZzg = i47;
                                        }
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgxxVar2 = zzgxxVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                    case 19:
                                    case 36:
                                        i28 = i53;
                                        i47 = i47;
                                        i29 = iZzs;
                                        unsafe3 = unsafe2;
                                        i30 = i52;
                                        i31 = i63;
                                        if (i50 == 2) {
                                            zzgzm zzgzmVar = (zzgzm) zzhadVar;
                                            iZzg = zzgxy.zzh(bArr, i47, zzgxxVar3);
                                            int i65 = zzgxxVar3.zza + iZzg;
                                            while (iZzg < i65) {
                                                zzgzmVar.zze(Float.intBitsToFloat(zzgxy.zzb(bArr, iZzg)));
                                                iZzg += 4;
                                            }
                                            if (iZzg != i65) {
                                                throw zzhag.zzj();
                                            }
                                        } else if (i50 == 5) {
                                            i32 = i47 + 4;
                                            zzgzm zzgzmVar2 = (zzgzm) zzhadVar;
                                            zzgzmVar2.zze(Float.intBitsToFloat(zzgxy.zzb(bArr, i47)));
                                            while (i32 < i31) {
                                                int iZzh2 = zzgxy.zzh(bArr, i32, zzgxxVar3);
                                                if (i28 == zzgxxVar3.zza) {
                                                    zzgzmVar2.zze(Float.intBitsToFloat(zzgxy.zzb(bArr, iZzh2)));
                                                    i32 = iZzh2 + 4;
                                                } else {
                                                    iZzg = i32;
                                                }
                                            }
                                            iZzg = i32;
                                        } else {
                                            iZzg = i47;
                                        }
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgxxVar2 = zzgxxVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                    case 20:
                                    case 21:
                                    case 37:
                                    case 38:
                                        i28 = i53;
                                        i47 = i47;
                                        i29 = iZzs;
                                        unsafe3 = unsafe2;
                                        i30 = i52;
                                        i31 = i63;
                                        if (i50 == 2) {
                                            zzhat zzhatVar = (zzhat) zzhadVar;
                                            iZzg = zzgxy.zzh(bArr, i47, zzgxxVar3);
                                            int i66 = zzgxxVar3.zza + iZzg;
                                            while (iZzg < i66) {
                                                iZzg = zzgxy.zzk(bArr, iZzg, zzgxxVar3);
                                                zzhatVar.zzg(zzgxxVar3.zzb);
                                            }
                                            if (iZzg != i66) {
                                                throw zzhag.zzj();
                                            }
                                        } else if (i50 == 0) {
                                            zzhat zzhatVar2 = (zzhat) zzhadVar;
                                            iZzg = zzgxy.zzk(bArr, i47, zzgxxVar3);
                                            zzhatVar2.zzg(zzgxxVar3.zzb);
                                            while (iZzg < i31) {
                                                int iZzh3 = zzgxy.zzh(bArr, iZzg, zzgxxVar3);
                                                if (i28 == zzgxxVar3.zza) {
                                                    iZzg = zzgxy.zzk(bArr, iZzh3, zzgxxVar3);
                                                    zzhatVar2.zzg(zzgxxVar3.zzb);
                                                }
                                            }
                                        } else {
                                            iZzg = i47;
                                        }
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgxxVar2 = zzgxxVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                    case 22:
                                    case 29:
                                    case 39:
                                    case 43:
                                        i28 = i53;
                                        i33 = i47;
                                        i34 = i63;
                                        i35 = iZzs;
                                        unsafe4 = unsafe2;
                                        i36 = i52;
                                        if (i50 == 2) {
                                            iZzf = zzgxy.zzf(bArr, i33, zzhadVar, zzgxxVar3);
                                            i47 = i33;
                                            iZzg = iZzf;
                                            i30 = i36;
                                            i31 = i34;
                                            i29 = i35;
                                            unsafe3 = unsafe4;
                                        } else if (i50 == 0) {
                                            i47 = i33;
                                            i30 = i36;
                                            i31 = i34;
                                            i29 = i35;
                                            unsafe3 = unsafe4;
                                            iZzg = zzgxy.zzj(i28, bArr, i47, i2, zzhadVar, zzgxxVar);
                                        } else {
                                            i47 = i33;
                                            i30 = i36;
                                            i31 = i34;
                                            i29 = i35;
                                            unsafe3 = unsafe4;
                                            iZzg = i47;
                                        }
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgxxVar2 = zzgxxVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                    case 23:
                                    case 32:
                                    case 40:
                                    case 46:
                                        i28 = i53;
                                        i33 = i47;
                                        i34 = i63;
                                        i35 = iZzs;
                                        unsafe4 = unsafe2;
                                        i36 = i52;
                                        if (i50 != 2) {
                                            if (i50 == 1) {
                                                iZzf = i33 + 8;
                                                zzhat zzhatVar3 = (zzhat) zzhadVar;
                                                zzhatVar3.zzg(zzgxy.zzn(bArr, i33));
                                                while (iZzf < i34) {
                                                    int iZzh4 = zzgxy.zzh(bArr, iZzf, zzgxxVar3);
                                                    if (i28 == zzgxxVar3.zza) {
                                                        zzhatVar3.zzg(zzgxy.zzn(bArr, iZzh4));
                                                        iZzf = iZzh4 + 8;
                                                    }
                                                }
                                            }
                                            i47 = i33;
                                            i30 = i36;
                                            i31 = i34;
                                            i29 = i35;
                                            unsafe3 = unsafe4;
                                            iZzg = i47;
                                            if (iZzg != i47) {
                                                i3 = i3;
                                                i44 = i28;
                                                i42 = i30;
                                                i43 = i29;
                                                unsafe5 = unsafe3;
                                                i41 = -1;
                                                i45 = i11;
                                                i46 = i12;
                                                obj3 = obj;
                                                i2 = i31;
                                            } else {
                                                i10 = iZzg;
                                                i44 = i28;
                                                i15 = i30;
                                                i14 = i29;
                                                zzgxxVar2 = zzgxxVar3;
                                                unsafe2 = unsafe3;
                                                obj3 = obj;
                                                i5 = i31;
                                                i4 = i3;
                                            }
                                        } else {
                                            zzhat zzhatVar4 = (zzhat) zzhadVar;
                                            iZzf = zzgxy.zzh(bArr, i33, zzgxxVar3);
                                            int i67 = zzgxxVar3.zza + iZzf;
                                            while (iZzf < i67) {
                                                zzhatVar4.zzg(zzgxy.zzn(bArr, iZzf));
                                                iZzf += 8;
                                            }
                                            if (iZzf != i67) {
                                                throw zzhag.zzj();
                                            }
                                        }
                                        i47 = i33;
                                        iZzg = iZzf;
                                        i30 = i36;
                                        i31 = i34;
                                        i29 = i35;
                                        unsafe3 = unsafe4;
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgxxVar2 = zzgxxVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                    case 24:
                                    case 31:
                                    case 41:
                                    case 45:
                                        i28 = i53;
                                        i33 = i47;
                                        i34 = i63;
                                        i35 = iZzs;
                                        unsafe4 = unsafe2;
                                        i36 = i52;
                                        if (i50 != 2) {
                                            if (i50 == 5) {
                                                iZzf = i33 + 4;
                                                zzgzv zzgzvVar = (zzgzv) zzhadVar;
                                                zzgzvVar.zzh(zzgxy.zzb(bArr, i33));
                                                while (iZzf < i34) {
                                                    int iZzh5 = zzgxy.zzh(bArr, iZzf, zzgxxVar3);
                                                    if (i28 == zzgxxVar3.zza) {
                                                        zzgzvVar.zzh(zzgxy.zzb(bArr, iZzh5));
                                                        iZzf = iZzh5 + 4;
                                                    }
                                                }
                                            }
                                            i47 = i33;
                                            i30 = i36;
                                            i31 = i34;
                                            i29 = i35;
                                            unsafe3 = unsafe4;
                                            iZzg = i47;
                                            if (iZzg != i47) {
                                                i3 = i3;
                                                i44 = i28;
                                                i42 = i30;
                                                i43 = i29;
                                                unsafe5 = unsafe3;
                                                i41 = -1;
                                                i45 = i11;
                                                i46 = i12;
                                                obj3 = obj;
                                                i2 = i31;
                                            } else {
                                                i10 = iZzg;
                                                i44 = i28;
                                                i15 = i30;
                                                i14 = i29;
                                                zzgxxVar2 = zzgxxVar3;
                                                unsafe2 = unsafe3;
                                                obj3 = obj;
                                                i5 = i31;
                                                i4 = i3;
                                            }
                                        } else {
                                            zzgzv zzgzvVar2 = (zzgzv) zzhadVar;
                                            iZzf = zzgxy.zzh(bArr, i33, zzgxxVar3);
                                            int i68 = zzgxxVar3.zza + iZzf;
                                            while (iZzf < i68) {
                                                zzgzvVar2.zzh(zzgxy.zzb(bArr, iZzf));
                                                iZzf += 4;
                                            }
                                            if (iZzf != i68) {
                                                throw zzhag.zzj();
                                            }
                                        }
                                        i47 = i33;
                                        iZzg = iZzf;
                                        i30 = i36;
                                        i31 = i34;
                                        i29 = i35;
                                        unsafe3 = unsafe4;
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgxxVar2 = zzgxxVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                    case 25:
                                    case 42:
                                        i28 = i53;
                                        i33 = i47;
                                        i34 = i63;
                                        i35 = iZzs;
                                        unsafe4 = unsafe2;
                                        i36 = i52;
                                        if (i50 != 2) {
                                            if (i50 == 0) {
                                                zzgxz zzgxzVar = (zzgxz) zzhadVar;
                                                iZzf = zzgxy.zzk(bArr, i33, zzgxxVar3);
                                                zzgxzVar.zze(zzgxxVar3.zzb != 0);
                                                while (iZzf < i34) {
                                                    int iZzh6 = zzgxy.zzh(bArr, iZzf, zzgxxVar3);
                                                    if (i28 == zzgxxVar3.zza) {
                                                        iZzf = zzgxy.zzk(bArr, iZzh6, zzgxxVar3);
                                                        zzgxzVar.zze(zzgxxVar3.zzb != 0);
                                                    }
                                                }
                                            }
                                            i47 = i33;
                                            i30 = i36;
                                            i31 = i34;
                                            i29 = i35;
                                            unsafe3 = unsafe4;
                                            iZzg = i47;
                                            if (iZzg != i47) {
                                                i3 = i3;
                                                i44 = i28;
                                                i42 = i30;
                                                i43 = i29;
                                                unsafe5 = unsafe3;
                                                i41 = -1;
                                                i45 = i11;
                                                i46 = i12;
                                                obj3 = obj;
                                                i2 = i31;
                                            } else {
                                                i10 = iZzg;
                                                i44 = i28;
                                                i15 = i30;
                                                i14 = i29;
                                                zzgxxVar2 = zzgxxVar3;
                                                unsafe2 = unsafe3;
                                                obj3 = obj;
                                                i5 = i31;
                                                i4 = i3;
                                            }
                                        } else {
                                            zzgxz zzgxzVar2 = (zzgxz) zzhadVar;
                                            iZzf = zzgxy.zzh(bArr, i33, zzgxxVar3);
                                            int i69 = zzgxxVar3.zza + iZzf;
                                            while (iZzf < i69) {
                                                iZzf = zzgxy.zzk(bArr, iZzf, zzgxxVar3);
                                                zzgxzVar2.zze(zzgxxVar3.zzb != 0);
                                            }
                                            if (iZzf != i69) {
                                                throw zzhag.zzj();
                                            }
                                        }
                                        i47 = i33;
                                        iZzg = iZzf;
                                        i30 = i36;
                                        i31 = i34;
                                        i29 = i35;
                                        unsafe3 = unsafe4;
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgxxVar2 = zzgxxVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                    case 26:
                                        i28 = i53;
                                        i33 = i47;
                                        i34 = i63;
                                        i35 = iZzs;
                                        unsafe4 = unsafe2;
                                        i36 = i52;
                                        if (i50 == 2) {
                                            if ((j2 & 536870912) == 0) {
                                                iZzf = zzgxy.zzh(bArr, i33, zzgxxVar3);
                                                int i70 = zzgxxVar3.zza;
                                                if (i70 < 0) {
                                                    throw zzhag.zzf();
                                                }
                                                if (i70 == 0) {
                                                    obj2 = "";
                                                    zzhadVar.add(obj2);
                                                } else {
                                                    obj2 = "";
                                                    zzhadVar.add(new String(bArr, iZzf, i70, zzhae.zzb));
                                                    iZzf += i70;
                                                }
                                                while (iZzf < i34) {
                                                    int iZzh7 = zzgxy.zzh(bArr, iZzf, zzgxxVar3);
                                                    if (i28 == zzgxxVar3.zza) {
                                                        iZzf = zzgxy.zzh(bArr, iZzh7, zzgxxVar3);
                                                        int i71 = zzgxxVar3.zza;
                                                        if (i71 < 0) {
                                                            throw zzhag.zzf();
                                                        }
                                                        if (i71 == 0) {
                                                            zzhadVar.add(obj2);
                                                        } else {
                                                            zzhadVar.add(new String(bArr, iZzf, i71, zzhae.zzb));
                                                            iZzf += i71;
                                                        }
                                                    }
                                                }
                                            } else {
                                                iZzf = zzgxy.zzh(bArr, i33, zzgxxVar3);
                                                int i72 = zzgxxVar3.zza;
                                                if (i72 < 0) {
                                                    throw zzhag.zzf();
                                                }
                                                if (i72 == 0) {
                                                    zzhadVar.add("");
                                                } else {
                                                    int i73 = iZzf + i72;
                                                    if (!zzhde.zzj(bArr, iZzf, i73)) {
                                                        throw zzhag.zzd();
                                                    }
                                                    zzhadVar.add(new String(bArr, iZzf, i72, zzhae.zzb));
                                                    iZzf = i73;
                                                }
                                                while (iZzf < i34) {
                                                    int iZzh8 = zzgxy.zzh(bArr, iZzf, zzgxxVar3);
                                                    if (i28 == zzgxxVar3.zza) {
                                                        iZzf = zzgxy.zzh(bArr, iZzh8, zzgxxVar3);
                                                        int i74 = zzgxxVar3.zza;
                                                        if (i74 < 0) {
                                                            throw zzhag.zzf();
                                                        }
                                                        if (i74 == 0) {
                                                            zzhadVar.add("");
                                                        } else {
                                                            int i75 = iZzf + i74;
                                                            if (!zzhde.zzj(bArr, iZzf, i75)) {
                                                                throw zzhag.zzd();
                                                            }
                                                            zzhadVar.add(new String(bArr, iZzf, i74, zzhae.zzb));
                                                            iZzf = i75;
                                                        }
                                                    }
                                                }
                                            }
                                            i47 = i33;
                                            iZzg = iZzf;
                                            i30 = i36;
                                            i31 = i34;
                                            i29 = i35;
                                            unsafe3 = unsafe4;
                                            if (iZzg != i47) {
                                                i3 = i3;
                                                i44 = i28;
                                                i42 = i30;
                                                i43 = i29;
                                                unsafe5 = unsafe3;
                                                i41 = -1;
                                                i45 = i11;
                                                i46 = i12;
                                                obj3 = obj;
                                                i2 = i31;
                                            } else {
                                                i10 = iZzg;
                                                i44 = i28;
                                                i15 = i30;
                                                i14 = i29;
                                                zzgxxVar2 = zzgxxVar3;
                                                unsafe2 = unsafe3;
                                                obj3 = obj;
                                                i5 = i31;
                                                i4 = i3;
                                            }
                                        }
                                        i47 = i33;
                                        i30 = i36;
                                        i31 = i34;
                                        i29 = i35;
                                        unsafe3 = unsafe4;
                                        iZzg = i47;
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgxxVar2 = zzgxxVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                    case 27:
                                        i37 = i53;
                                        i47 = i47;
                                        i63 = i63;
                                        unsafe2 = unsafe2;
                                        if (i50 == 2) {
                                            i28 = i37;
                                            int iZze = zzgxy.zze(zzhbhVar2.zzx(iZzs), i37, bArr, i47, i2, zzhadVar, zzgxxVar);
                                            zzgxxVar3 = zzgxxVar3;
                                            i31 = i63;
                                            i29 = iZzs;
                                            unsafe3 = unsafe2;
                                            iZzg = iZze;
                                            i30 = i52;
                                        } else {
                                            i28 = i37;
                                            unsafe3 = unsafe2;
                                            i30 = i52;
                                            int i76 = i63;
                                            i29 = iZzs;
                                            i31 = i76;
                                            iZzg = i47;
                                        }
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgxxVar2 = zzgxxVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                    case 28:
                                        i37 = i53;
                                        i47 = i47;
                                        i63 = i63;
                                        unsafe2 = unsafe2;
                                        if (i50 == 2) {
                                            iZzg = zzgxy.zzh(bArr, i47, zzgxxVar3);
                                            int i77 = zzgxxVar3.zza;
                                            if (i77 < 0) {
                                                throw zzhag.zzf();
                                            }
                                            if (i77 > bArr.length - iZzg) {
                                                throw zzhag.zzj();
                                            }
                                            if (i77 == 0) {
                                                zzhadVar.add(zzgyl.zzb);
                                            } else {
                                                zzhadVar.add(zzgyl.zzv(bArr, iZzg, i77));
                                                iZzg += i77;
                                            }
                                            while (iZzg < i63) {
                                                int iZzh9 = zzgxy.zzh(bArr, iZzg, zzgxxVar3);
                                                if (i37 != zzgxxVar3.zza) {
                                                    i28 = i37;
                                                    unsafe3 = unsafe2;
                                                    i30 = i52;
                                                    int i78 = i63;
                                                    i29 = iZzs;
                                                    i31 = i78;
                                                    if (iZzg != i47) {
                                                        i3 = i3;
                                                        i44 = i28;
                                                        i42 = i30;
                                                        i43 = i29;
                                                        unsafe5 = unsafe3;
                                                        i41 = -1;
                                                        i45 = i11;
                                                        i46 = i12;
                                                        obj3 = obj;
                                                        i2 = i31;
                                                    } else {
                                                        i10 = iZzg;
                                                        i44 = i28;
                                                        i15 = i30;
                                                        i14 = i29;
                                                        zzgxxVar2 = zzgxxVar3;
                                                        unsafe2 = unsafe3;
                                                        obj3 = obj;
                                                        i5 = i31;
                                                        i4 = i3;
                                                    }
                                                    break;
                                                } else {
                                                    iZzg = zzgxy.zzh(bArr, iZzh9, zzgxxVar3);
                                                    int i79 = zzgxxVar3.zza;
                                                    if (i79 < 0) {
                                                        throw zzhag.zzf();
                                                    }
                                                    if (i79 > bArr.length - iZzg) {
                                                        throw zzhag.zzj();
                                                    }
                                                    if (i79 == 0) {
                                                        zzhadVar.add(zzgyl.zzb);
                                                    } else {
                                                        zzhadVar.add(zzgyl.zzv(bArr, iZzg, i79));
                                                        iZzg += i79;
                                                    }
                                                }
                                            }
                                            i28 = i37;
                                            unsafe3 = unsafe2;
                                            i30 = i52;
                                            int i710 = i63;
                                            i29 = iZzs;
                                            i31 = i710;
                                            if (iZzg != i47) {
                                                i3 = i3;
                                                i44 = i28;
                                                i42 = i30;
                                                i43 = i29;
                                                unsafe5 = unsafe3;
                                                i41 = -1;
                                                i45 = i11;
                                                i46 = i12;
                                                obj3 = obj;
                                                i2 = i31;
                                            } else {
                                                i10 = iZzg;
                                                i44 = i28;
                                                i15 = i30;
                                                i14 = i29;
                                                zzgxxVar2 = zzgxxVar3;
                                                unsafe2 = unsafe3;
                                                obj3 = obj;
                                                i5 = i31;
                                                i4 = i3;
                                            }
                                        }
                                        i28 = i37;
                                        unsafe3 = unsafe2;
                                        i30 = i52;
                                        int i711 = i63;
                                        i29 = iZzs;
                                        i31 = i711;
                                        iZzg = i47;
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgxxVar2 = zzgxxVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                    case 30:
                                    case 44:
                                        if (i50 != 2) {
                                            if (i50 == 0) {
                                                iZzj = zzgxy.zzj(i53, bArr, i47, i2, zzhadVar, zzgxxVar);
                                            }
                                            i28 = i53;
                                            i47 = i47;
                                            i29 = iZzs;
                                            unsafe3 = unsafe2;
                                            i30 = i52;
                                            i31 = i63;
                                            iZzg = i47;
                                            if (iZzg != i47) {
                                                i3 = i3;
                                                i44 = i28;
                                                i42 = i30;
                                                i43 = i29;
                                                unsafe5 = unsafe3;
                                                i41 = -1;
                                                i45 = i11;
                                                i46 = i12;
                                                obj3 = obj;
                                                i2 = i31;
                                            } else {
                                                i10 = iZzg;
                                                i44 = i28;
                                                i15 = i30;
                                                i14 = i29;
                                                zzgxxVar2 = zzgxxVar3;
                                                unsafe2 = unsafe3;
                                                obj3 = obj;
                                                i5 = i31;
                                                i4 = i3;
                                            }
                                        } else {
                                            iZzj = zzgxy.zzf(bArr, i47, zzhadVar, zzgxxVar3);
                                        }
                                        int i80 = iZzj;
                                        zzhca.zzo(obj, i52, zzhadVar, zzhbhVar2.zzw(iZzs), null, zzhbhVar2.zzn);
                                        i28 = i53;
                                        iZzg = i80;
                                        unsafe3 = unsafe2;
                                        i30 = i52;
                                        int i712 = i63;
                                        i29 = iZzs;
                                        i31 = i712;
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgxxVar2 = zzgxxVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                    case 33:
                                    case 47:
                                        if (i50 != 2) {
                                            if (i50 == 0) {
                                                zzgzv zzgzvVar3 = (zzgzv) zzhadVar;
                                                iZzg = zzgxy.zzh(bArr, i47, zzgxxVar3);
                                                zzgzvVar3.zzh(zzgyt.zzF(zzgxxVar3.zza));
                                                while (iZzg < i63) {
                                                    int iZzh10 = zzgxy.zzh(bArr, iZzg, zzgxxVar3);
                                                    if (i53 == zzgxxVar3.zza) {
                                                        iZzg = zzgxy.zzh(bArr, iZzh10, zzgxxVar3);
                                                        zzgzvVar3.zzh(zzgyt.zzF(zzgxxVar3.zza));
                                                    }
                                                }
                                            }
                                            i28 = i53;
                                            i47 = i47;
                                            i29 = iZzs;
                                            unsafe3 = unsafe2;
                                            i30 = i52;
                                            i31 = i63;
                                            iZzg = i47;
                                            if (iZzg != i47) {
                                                i3 = i3;
                                                i44 = i28;
                                                i42 = i30;
                                                i43 = i29;
                                                unsafe5 = unsafe3;
                                                i41 = -1;
                                                i45 = i11;
                                                i46 = i12;
                                                obj3 = obj;
                                                i2 = i31;
                                            } else {
                                                i10 = iZzg;
                                                i44 = i28;
                                                i15 = i30;
                                                i14 = i29;
                                                zzgxxVar2 = zzgxxVar3;
                                                unsafe2 = unsafe3;
                                                obj3 = obj;
                                                i5 = i31;
                                                i4 = i3;
                                            }
                                        } else {
                                            zzgzv zzgzvVar4 = (zzgzv) zzhadVar;
                                            iZzg = zzgxy.zzh(bArr, i47, zzgxxVar3);
                                            int i81 = zzgxxVar3.zza + iZzg;
                                            while (iZzg < i81) {
                                                iZzg = zzgxy.zzh(bArr, iZzg, zzgxxVar3);
                                                zzgzvVar4.zzh(zzgyt.zzF(zzgxxVar3.zza));
                                            }
                                            if (iZzg != i81) {
                                                throw zzhag.zzj();
                                            }
                                        }
                                        i28 = i53;
                                        i47 = i47;
                                        i29 = iZzs;
                                        unsafe3 = unsafe2;
                                        i30 = i52;
                                        i31 = i63;
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgxxVar2 = zzgxxVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                    case 34:
                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                                        if (i50 != 2) {
                                            if (i50 == 0) {
                                                zzhat zzhatVar5 = (zzhat) zzhadVar;
                                                iZzg = zzgxy.zzk(bArr, i47, zzgxxVar3);
                                                zzhatVar5.zzg(zzgyt.zzG(zzgxxVar3.zzb));
                                                while (iZzg < i63) {
                                                    int iZzh11 = zzgxy.zzh(bArr, iZzg, zzgxxVar3);
                                                    if (i53 == zzgxxVar3.zza) {
                                                        iZzg = zzgxy.zzk(bArr, iZzh11, zzgxxVar3);
                                                        zzhatVar5.zzg(zzgyt.zzG(zzgxxVar3.zzb));
                                                    }
                                                }
                                            }
                                            i28 = i53;
                                            i47 = i47;
                                            i29 = iZzs;
                                            unsafe3 = unsafe2;
                                            i30 = i52;
                                            i31 = i63;
                                            iZzg = i47;
                                            if (iZzg != i47) {
                                                i3 = i3;
                                                i44 = i28;
                                                i42 = i30;
                                                i43 = i29;
                                                unsafe5 = unsafe3;
                                                i41 = -1;
                                                i45 = i11;
                                                i46 = i12;
                                                obj3 = obj;
                                                i2 = i31;
                                            } else {
                                                i10 = iZzg;
                                                i44 = i28;
                                                i15 = i30;
                                                i14 = i29;
                                                zzgxxVar2 = zzgxxVar3;
                                                unsafe2 = unsafe3;
                                                obj3 = obj;
                                                i5 = i31;
                                                i4 = i3;
                                            }
                                        } else {
                                            zzhat zzhatVar6 = (zzhat) zzhadVar;
                                            iZzg = zzgxy.zzh(bArr, i47, zzgxxVar3);
                                            int i82 = zzgxxVar3.zza + iZzg;
                                            while (iZzg < i82) {
                                                iZzg = zzgxy.zzk(bArr, iZzg, zzgxxVar3);
                                                zzhatVar6.zzg(zzgyt.zzG(zzgxxVar3.zzb));
                                            }
                                            if (iZzg != i82) {
                                                throw zzhag.zzj();
                                            }
                                        }
                                        i28 = i53;
                                        i47 = i47;
                                        i29 = iZzs;
                                        unsafe3 = unsafe2;
                                        i30 = i52;
                                        i31 = i63;
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgxxVar2 = zzgxxVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                    default:
                                        i28 = i53;
                                        i47 = i47;
                                        i29 = iZzs;
                                        unsafe3 = unsafe2;
                                        i30 = i52;
                                        i31 = i63;
                                        if (i50 == 3) {
                                            int i83 = (i28 & (-8)) | 4;
                                            zzhby zzhbyVarZzx = zzhbhVar2.zzx(i29);
                                            iZzg = zzgxy.zzc(zzhbyVarZzx, bArr, i47, i2, i83, zzgxxVar);
                                            zzhadVar.add(zzgxxVar3.zzc);
                                            while (iZzg < i31) {
                                                int iZzh12 = zzgxy.zzh(bArr, iZzg, zzgxxVar3);
                                                if (i28 == zzgxxVar3.zza) {
                                                    iZzg = zzgxy.zzc(zzhbyVarZzx, bArr, iZzh12, i2, i83, zzgxxVar);
                                                    zzhadVar.add(zzgxxVar3.zzc);
                                                }
                                            }
                                        } else {
                                            iZzg = i47;
                                        }
                                        if (iZzg != i47) {
                                            i3 = i3;
                                            i44 = i28;
                                            i42 = i30;
                                            i43 = i29;
                                            unsafe5 = unsafe3;
                                            i41 = -1;
                                            i45 = i11;
                                            i46 = i12;
                                            obj3 = obj;
                                            i2 = i31;
                                        } else {
                                            i10 = iZzg;
                                            i44 = i28;
                                            i15 = i30;
                                            i14 = i29;
                                            zzgxxVar2 = zzgxxVar3;
                                            unsafe2 = unsafe3;
                                            obj3 = obj;
                                            i5 = i31;
                                            i4 = i3;
                                        }
                                        break;
                                }
                            } else {
                                i27 = iZzs;
                                i26 = i52;
                                i25 = i47;
                                if (iZzt != 50) {
                                    i44 = i53;
                                    obj3 = obj;
                                    Unsafe unsafe8 = zzb;
                                    long j3 = iArr[i27 + 2] & 1048575;
                                    switch (iZzt) {
                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                            i5 = i2;
                                            i38 = i27;
                                            i15 = i26;
                                            zzgxxVar2 = zzgxxVar3;
                                            i39 = i25;
                                            if (i50 == 1) {
                                                iZzg = i39 + 8;
                                                unsafe8.putObject(obj3, j, Double.valueOf(Double.longBitsToDouble(zzgxy.zzn(bArr, i39))));
                                                unsafe8.putInt(obj3, j3, i15);
                                            } else {
                                                iZzg = i39;
                                            }
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzhbhVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgxxVar3 = zzgxxVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                        case 52:
                                            i5 = i2;
                                            i38 = i27;
                                            i15 = i26;
                                            zzgxxVar2 = zzgxxVar3;
                                            i39 = i25;
                                            if (i50 == 5) {
                                                iZzg = i39 + 4;
                                                unsafe8.putObject(obj3, j, Float.valueOf(Float.intBitsToFloat(zzgxy.zzb(bArr, i39))));
                                                unsafe8.putInt(obj3, j3, i15);
                                            } else {
                                                iZzg = i39;
                                            }
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzhbhVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgxxVar3 = zzgxxVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                                            i5 = i2;
                                            i38 = i27;
                                            i15 = i26;
                                            zzgxxVar2 = zzgxxVar3;
                                            i39 = i25;
                                            if (i50 == 0) {
                                                iZzg = zzgxy.zzk(bArr, i39, zzgxxVar2);
                                                unsafe8.putObject(obj3, j, Long.valueOf(zzgxxVar2.zzb));
                                                unsafe8.putInt(obj3, j3, i15);
                                            } else {
                                                iZzg = i39;
                                            }
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzhbhVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgxxVar3 = zzgxxVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                        case 62:
                                            i5 = i2;
                                            i38 = i27;
                                            i15 = i26;
                                            zzgxxVar2 = zzgxxVar3;
                                            i39 = i25;
                                            if (i50 == 0) {
                                                iZzg = zzgxy.zzh(bArr, i39, zzgxxVar2);
                                                unsafe8.putObject(obj3, j, Integer.valueOf(zzgxxVar2.zza));
                                                unsafe8.putInt(obj3, j3, i15);
                                            } else {
                                                iZzg = i39;
                                            }
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzhbhVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgxxVar3 = zzgxxVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                        case 56:
                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                                            i5 = i2;
                                            i38 = i27;
                                            i15 = i26;
                                            zzgxxVar2 = zzgxxVar3;
                                            i39 = i25;
                                            if (i50 == 1) {
                                                iZzg = i39 + 8;
                                                unsafe8.putObject(obj3, j, Long.valueOf(zzgxy.zzn(bArr, i39)));
                                                unsafe8.putInt(obj3, j3, i15);
                                            } else {
                                                iZzg = i39;
                                            }
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzhbhVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgxxVar3 = zzgxxVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                        case 57:
                                        case 64:
                                            i5 = i2;
                                            i38 = i27;
                                            i15 = i26;
                                            zzgxxVar2 = zzgxxVar3;
                                            i39 = i25;
                                            if (i50 == 5) {
                                                iZzg = i39 + 4;
                                                unsafe8.putObject(obj3, j, Integer.valueOf(zzgxy.zzb(bArr, i39)));
                                                unsafe8.putInt(obj3, j3, i15);
                                            } else {
                                                iZzg = i39;
                                            }
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzhbhVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgxxVar3 = zzgxxVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                        case 58:
                                            i5 = i2;
                                            i38 = i27;
                                            i15 = i26;
                                            zzgxxVar2 = zzgxxVar3;
                                            i39 = i25;
                                            if (i50 == 0) {
                                                iZzg = zzgxy.zzk(bArr, i39, zzgxxVar2);
                                                unsafe8.putObject(obj3, j, Boolean.valueOf(zzgxxVar2.zzb != 0));
                                                unsafe8.putInt(obj3, j3, i15);
                                            } else {
                                                iZzg = i39;
                                            }
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzhbhVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgxxVar3 = zzgxxVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                        case 59:
                                            i5 = i2;
                                            i38 = i27;
                                            i15 = i26;
                                            zzgxxVar2 = zzgxxVar3;
                                            i39 = i25;
                                            if (i50 == 2) {
                                                int iZzh13 = zzgxy.zzh(bArr, i39, zzgxxVar2);
                                                int i84 = zzgxxVar2.zza;
                                                if (i84 == 0) {
                                                    unsafe8.putObject(obj3, j, "");
                                                } else {
                                                    int i85 = iZzh13 + i84;
                                                    if ((i51 & 536870912) != 0 && !zzhde.zzj(bArr, iZzh13, i85)) {
                                                        throw zzhag.zzd();
                                                    }
                                                    unsafe8.putObject(obj3, j, new String(bArr, iZzh13, i84, zzhae.zzb));
                                                    iZzh13 = i85;
                                                }
                                                unsafe8.putInt(obj3, j3, i15);
                                                iZzg = iZzh13;
                                            } else {
                                                i38 = i38;
                                                iZzg = i39;
                                            }
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzhbhVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgxxVar3 = zzgxxVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                        case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                                            zzgxxVar2 = zzgxxVar3;
                                            i39 = i25;
                                            if (i50 == 2) {
                                                Object objZzB = zzB(obj3, i26, i27);
                                                i15 = i26;
                                                iZzg = zzgxy.zzm(objZzB, zzx(i27), bArr, i39, i2, zzgxxVar);
                                                zzK(obj3, i15, i27, objZzB);
                                                i38 = i27;
                                                i5 = i2;
                                            } else {
                                                i15 = i26;
                                                i5 = i2;
                                                i38 = i27;
                                                iZzg = i39;
                                            }
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzhbhVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgxxVar3 = zzgxxVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                        case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                            i40 = i26;
                                            zzgxxVar2 = zzgxxVar3;
                                            i39 = i25;
                                            if (i50 == 2) {
                                                iZzg = zzgxy.zza(bArr, i39, zzgxxVar2);
                                                unsafe8.putObject(obj3, j, zzgxxVar2.zzc);
                                                unsafe8.putInt(obj3, j3, i40);
                                                i5 = i2;
                                                i38 = i27;
                                                i15 = i40;
                                                if (iZzg == i39) {
                                                    i44 = i44;
                                                    zzhbhVar2 = this;
                                                    i43 = i38;
                                                    i3 = i3;
                                                    zzgxxVar3 = zzgxxVar2;
                                                    i2 = i5;
                                                    i42 = i15;
                                                    i41 = -1;
                                                    i45 = i11;
                                                    unsafe5 = unsafe2;
                                                    i46 = i12;
                                                } else {
                                                    i44 = i44;
                                                    i14 = i38;
                                                    i4 = i3;
                                                    i10 = iZzg;
                                                }
                                            }
                                            i5 = i2;
                                            i38 = i27;
                                            i15 = i40;
                                            iZzg = i39;
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzhbhVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgxxVar3 = zzgxxVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                        case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                            i40 = i26;
                                            zzgxxVar2 = zzgxxVar3;
                                            i39 = i25;
                                            if (i50 == 0) {
                                                iZzg = zzgxy.zzh(bArr, i39, zzgxxVar2);
                                                int i86 = zzgxxVar2.zza;
                                                zzgzy zzgzyVarZzw2 = zzw(i27);
                                                if (zzgzyVarZzw2 == null || zzgzyVarZzw2.zza(i86)) {
                                                    unsafe8.putObject(obj3, j, Integer.valueOf(i86));
                                                    unsafe8.putInt(obj3, j3, i40);
                                                } else {
                                                    zzd(obj).zzj(i44, Long.valueOf(i86));
                                                }
                                                i5 = i2;
                                                i38 = i27;
                                                i15 = i40;
                                                if (iZzg == i39) {
                                                    i44 = i44;
                                                    zzhbhVar2 = this;
                                                    i43 = i38;
                                                    i3 = i3;
                                                    zzgxxVar3 = zzgxxVar2;
                                                    i2 = i5;
                                                    i42 = i15;
                                                    i41 = -1;
                                                    i45 = i11;
                                                    unsafe5 = unsafe2;
                                                    i46 = i12;
                                                } else {
                                                    i44 = i44;
                                                    i14 = i38;
                                                    i4 = i3;
                                                    i10 = iZzg;
                                                }
                                            }
                                            i5 = i2;
                                            i38 = i27;
                                            i15 = i40;
                                            iZzg = i39;
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzhbhVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgxxVar3 = zzgxxVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                            i40 = i26;
                                            zzgxxVar2 = zzgxxVar3;
                                            i39 = i25;
                                            if (i50 == 0) {
                                                iZzg = zzgxy.zzh(bArr, i39, zzgxxVar2);
                                                unsafe8.putObject(obj3, j, Integer.valueOf(zzgyt.zzF(zzgxxVar2.zza)));
                                                unsafe8.putInt(obj3, j3, i40);
                                                i5 = i2;
                                                i38 = i27;
                                                i15 = i40;
                                                if (iZzg == i39) {
                                                    i44 = i44;
                                                    zzhbhVar2 = this;
                                                    i43 = i38;
                                                    i3 = i3;
                                                    zzgxxVar3 = zzgxxVar2;
                                                    i2 = i5;
                                                    i42 = i15;
                                                    i41 = -1;
                                                    i45 = i11;
                                                    unsafe5 = unsafe2;
                                                    i46 = i12;
                                                } else {
                                                    i44 = i44;
                                                    i14 = i38;
                                                    i4 = i3;
                                                    i10 = iZzg;
                                                }
                                            }
                                            i5 = i2;
                                            i38 = i27;
                                            i15 = i40;
                                            iZzg = i39;
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzhbhVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgxxVar3 = zzgxxVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                        case 67:
                                            i40 = i26;
                                            zzgxxVar2 = zzgxxVar3;
                                            i39 = i25;
                                            if (i50 == 0) {
                                                int iZzk3 = zzgxy.zzk(bArr, i39, zzgxxVar2);
                                                unsafe8.putObject(obj3, j, Long.valueOf(zzgyt.zzG(zzgxxVar2.zzb)));
                                                unsafe8.putInt(obj3, j3, i40);
                                                iZzg = iZzk3;
                                                i5 = i2;
                                                i38 = i27;
                                                i15 = i40;
                                                if (iZzg == i39) {
                                                    i44 = i44;
                                                    zzhbhVar2 = this;
                                                    i43 = i38;
                                                    i3 = i3;
                                                    zzgxxVar3 = zzgxxVar2;
                                                    i2 = i5;
                                                    i42 = i15;
                                                    i41 = -1;
                                                    i45 = i11;
                                                    unsafe5 = unsafe2;
                                                    i46 = i12;
                                                } else {
                                                    i44 = i44;
                                                    i14 = i38;
                                                    i4 = i3;
                                                    i10 = iZzg;
                                                }
                                            }
                                            i5 = i2;
                                            i38 = i27;
                                            i15 = i40;
                                            iZzg = i39;
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzhbhVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgxxVar3 = zzgxxVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                        case 68:
                                            if (i50 != 3) {
                                                break;
                                            } else {
                                                Object objZzB2 = zzB(obj3, i26, i27);
                                                zzgxx zzgxxVar4 = zzgxxVar3;
                                                int iZzl2 = zzgxy.zzl(objZzB2, zzx(i27), bArr, i25, i2, (i44 & (-8)) | 4, zzgxxVar);
                                                zzK(obj3, i26, i27, objZzB2);
                                                i5 = i2;
                                                i39 = i25;
                                                i38 = i27;
                                                i15 = i26;
                                                iZzg = iZzl2;
                                                zzgxxVar2 = zzgxxVar4;
                                            }
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                                break;
                                            } else {
                                                i44 = i44;
                                                zzhbhVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgxxVar3 = zzgxxVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                                break;
                                            }
                                        default:
                                            i5 = i2;
                                            i38 = i27;
                                            i15 = i26;
                                            zzgxxVar2 = zzgxxVar3;
                                            i39 = i25;
                                            iZzg = i39;
                                            if (iZzg == i39) {
                                                i44 = i44;
                                                zzhbhVar2 = this;
                                                i43 = i38;
                                                i3 = i3;
                                                zzgxxVar3 = zzgxxVar2;
                                                i2 = i5;
                                                i42 = i15;
                                                i41 = -1;
                                                i45 = i11;
                                                unsafe5 = unsafe2;
                                                i46 = i12;
                                            } else {
                                                i44 = i44;
                                                i14 = i38;
                                                i4 = i3;
                                                i10 = iZzg;
                                            }
                                            break;
                                    }
                                } else {
                                    if (i50 == 2) {
                                        Unsafe unsafe9 = zzb;
                                        Object objZzz = zzhbhVar2.zzz(i27);
                                        Object object = unsafe9.getObject(obj, j);
                                        if (zzhaz.zza(object)) {
                                            zzhay zzhayVarZzb = zzhay.zza().zzb();
                                            zzhaz.zzb(zzhayVarZzb, object);
                                            unsafe9.putObject(obj, j, zzhayVarZzb);
                                        }
                                        throw null;
                                    }
                                    i44 = i53;
                                    obj3 = obj;
                                    i4 = i3;
                                    i14 = i27;
                                    i5 = i63;
                                    i10 = i25;
                                    i15 = i26;
                                    zzgxxVar2 = zzgxxVar3;
                                }
                            }
                        } else if (i50 == 2) {
                            zzhad zzhadVarZzd2 = (zzhad) unsafe6.getObject(obj3, j);
                            if (!zzhadVarZzd2.zzc()) {
                                int size2 = zzhadVarZzd2.size();
                                zzhadVarZzd2 = zzhadVarZzd2.zzd(size2 != 0 ? size2 + size2 : 10);
                                unsafe6.putObject(obj3, j, zzhadVarZzd2);
                            }
                            i42 = i52;
                            int iZze2 = zzgxy.zze(zzhbhVar2.zzx(iZzs), i53, bArr, i47, i2, zzhadVarZzd2, zzgxxVar);
                            i3 = i3;
                            zzgxxVar3 = zzgxxVar3;
                            i2 = i63;
                            unsafe5 = unsafe6;
                            i41 = -1;
                            i45 = i11;
                            i46 = i12;
                            i44 = i53;
                            i43 = iZzs;
                            iZzg = iZze2;
                        } else {
                            i25 = i47;
                            i26 = i52;
                            i44 = i53;
                            unsafe2 = unsafe6;
                            i27 = iZzs;
                            i4 = i3;
                            i14 = i27;
                            i5 = i63;
                            i10 = i25;
                            i15 = i26;
                            zzgxxVar2 = zzgxxVar3;
                        }
                    }
                } else {
                    i10 = i47;
                    i11 = i45;
                    i12 = i46;
                    i44 = i9;
                    i13 = i41;
                    unsafe2 = unsafe5;
                    zzgxxVar2 = zzgxxVar3;
                    i4 = i3;
                    i5 = i2;
                    i14 = 0;
                    i15 = i49;
                }
                if (i44 != i4 || i4 == 0) {
                    if (!this.zzh || (zzgzfVar = zzgxxVar2.zzd) == zzgzf.zza) {
                        i16 = i44;
                        iZzg = zzgxy.zzg(i16, bArr, i10, i2, zzd(obj), zzgxxVar);
                    } else {
                        if (zzgzfVar.zzc(this.zzg, i15) != null) {
                            throw null;
                        }
                        i16 = i44;
                        iZzg = zzgxy.zzg(i44, bArr, i10, i2, zzd(obj), zzgxxVar);
                    }
                    i43 = i14;
                    i42 = i15;
                    zzhbhVar2 = this;
                    i44 = i16;
                    unsafe5 = unsafe2;
                    i45 = i11;
                    i46 = i12;
                    zzgxxVar3 = zzgxxVar2;
                    i3 = i4;
                    i2 = i5;
                    i41 = i13;
                } else {
                    i8 = 1048575;
                    zzhbhVar = this;
                    i6 = i10;
                    i7 = i44;
                    i45 = i11;
                    unsafe = unsafe2;
                    i46 = i12;
                }
            } else {
                zzhbhVar = zzhbhVar2;
                i4 = i3;
                i5 = i2;
                unsafe = unsafe5;
                i6 = iZzg;
                i7 = i44;
                i8 = 1048575;
            }
        }
        if (i46 != i8) {
            unsafe.putInt(obj3, i46, i45);
        }
        for (int i87 = zzhbhVar.zzk; i87 < zzhbhVar.zzl; i87++) {
            zzy(obj, zzhbhVar.zzj[i87], null, zzhbhVar.zzn, obj);
        }
        if (i4 == 0) {
            if (i6 != i5) {
                throw zzhag.zzg();
            }
        } else if (i6 > i5 || i7 != i4) {
            throw zzhag.zzg();
        }
        return i6;
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final Object zze() {
        return ((zzgzu) this.zzg).zzaD();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0073  */
    /* JADX WARN: Code duplicated, block: B:41:0x0080 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhby
    public final void zzf(Object obj) {
        if (zzQ(obj)) {
            if (obj instanceof zzgzu) {
                zzgzu zzgzuVar = (zzgzu) obj;
                zzgzuVar.zzaV(Integer.MAX_VALUE);
                zzgzuVar.zza = 0;
                zzgzuVar.zzaT();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int iZzu = zzu(i);
                int i2 = 1048575 & iZzu;
                int iZzt = zzt(iZzu);
                long j = i2;
                if (iZzt != 9) {
                    if (iZzt != 60 && iZzt != 68) {
                        switch (iZzt) {
                            case 17:
                                if (zzN(obj, i)) {
                                    zzx(i).zzf(zzb.getObject(obj, j));
                                }
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                this.zzm.zzb(obj, j);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzhay) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (zzR(obj, this.zzc[i], i)) {
                        zzx(i).zzf(zzb.getObject(obj, j));
                    }
                } else if (zzN(obj, i)) {
                    zzx(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzn.zzm(obj);
            if (this.zzh) {
                this.zzo.zze(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final void zzg(Object obj, Object obj2) {
        zzD(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzu = zzu(i);
            int i2 = 1048575 & iZzu;
            int[] iArr = this.zzc;
            int iZzt = zzt(iZzu);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzt) {
                case 0:
                    if (zzN(obj2, i)) {
                        zzhcz.zzr(obj, j, zzhcz.zzb(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 1:
                    if (zzN(obj2, i)) {
                        zzhcz.zzs(obj, j, zzhcz.zzc(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 2:
                    if (zzN(obj2, i)) {
                        zzhcz.zzu(obj, j, zzhcz.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 3:
                    if (zzN(obj2, i)) {
                        zzhcz.zzu(obj, j, zzhcz.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 4:
                    if (zzN(obj2, i)) {
                        zzhcz.zzt(obj, j, zzhcz.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 5:
                    if (zzN(obj2, i)) {
                        zzhcz.zzu(obj, j, zzhcz.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 6:
                    if (zzN(obj2, i)) {
                        zzhcz.zzt(obj, j, zzhcz.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 7:
                    if (zzN(obj2, i)) {
                        zzhcz.zzp(obj, j, zzhcz.zzz(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 8:
                    if (zzN(obj2, i)) {
                        zzhcz.zzv(obj, j, zzhcz.zzh(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 9:
                    zzE(obj, obj2, i);
                    break;
                case 10:
                    if (zzN(obj2, i)) {
                        zzhcz.zzv(obj, j, zzhcz.zzh(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 11:
                    if (zzN(obj2, i)) {
                        zzhcz.zzt(obj, j, zzhcz.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 12:
                    if (zzN(obj2, i)) {
                        zzhcz.zzt(obj, j, zzhcz.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 13:
                    if (zzN(obj2, i)) {
                        zzhcz.zzt(obj, j, zzhcz.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 14:
                    if (zzN(obj2, i)) {
                        zzhcz.zzu(obj, j, zzhcz.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 15:
                    if (zzN(obj2, i)) {
                        zzhcz.zzt(obj, j, zzhcz.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 16:
                    if (zzN(obj2, i)) {
                        zzhcz.zzu(obj, j, zzhcz.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 17:
                    zzE(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    this.zzm.zzc(obj, obj2, j);
                    break;
                case 50:
                    int i4 = zzhca.zza;
                    zzhcz.zzv(obj, j, zzhaz.zzb(zzhcz.zzh(obj, j), zzhcz.zzh(obj2, j)));
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                case 52:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzR(obj2, i3, i)) {
                        zzhcz.zzv(obj, j, zzhcz.zzh(obj2, j));
                        zzI(obj, i3, i);
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    zzF(obj, obj2, i);
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                case 62:
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                case 64:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                case 67:
                    if (zzR(obj2, i3, i)) {
                        zzhcz.zzv(obj, j, zzhcz.zzh(obj2, j));
                        zzI(obj, i3, i);
                    }
                    break;
                case 68:
                    zzF(obj, obj2, i);
                    break;
            }
        }
        zzhca.zzq(this.zzn, obj, obj2);
        if (this.zzh) {
            this.zzo.zza(obj2);
            throw null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:161:0x0611 A[Catch: all -> 0x0606, TryCatch #4 {all -> 0x0606, blocks: (B:148:0x05e5, B:159:0x060c, B:161:0x0611, B:162:0x0616), top: B:189:0x05e5 }] */
    /* JADX WARN: Code duplicated, block: B:167:0x0622 A[LOOP:3: B:165:0x061e->B:167:0x0622, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:169:0x0636  */
    /* JADX WARN: Code duplicated, block: B:179:0x0649 A[LOOP:2: B:177:0x0645->B:179:0x0649, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:181:0x065d  */
    /* JADX WARN: Code duplicated, block: B:207:0x061c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:216:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhby
    public final void zzh(Object obj, zzhbq zzhbqVar, zzgzf zzgzfVar) throws Throwable {
        Object obj2;
        zzhcp zzhcpVar;
        int i;
        zzhcp zzhcpVar2;
        Object obj3;
        zzgzg zzgzgVar;
        zzgzf zzgzfVar2;
        int i2;
        Object obj4;
        Object obj5 = obj;
        zzgzf zzgzfVar3 = zzgzfVar;
        zzgzfVar.getClass();
        zzD(obj);
        zzhcp zzhcpVar3 = this.zzn;
        zzgzg zzgzgVar2 = this.zzo;
        Object objZzy = null;
        zzgzk zzgzkVarZzb = null;
        while (true) {
            try {
                int iZzc = zzhbqVar.zzc();
                int iZzq = zzq(iZzc);
                if (iZzq >= 0) {
                    zzhcpVar = zzhcpVar3;
                    obj5 = obj5;
                    try {
                        int iZzu = zzu(iZzq);
                        try {
                            switch (zzt(iZzu)) {
                                case 0:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzr(obj5, iZzu & 1048575, zzhbqVar.zza());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 1:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzs(obj5, iZzu & 1048575, zzhbqVar.zzb());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 2:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzu(obj5, iZzu & 1048575, zzhbqVar.zzl());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 3:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzu(obj5, iZzu & 1048575, zzhbqVar.zzo());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 4:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzt(obj5, iZzu & 1048575, zzhbqVar.zzg());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 5:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzu(obj5, iZzu & 1048575, zzhbqVar.zzk());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 6:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzt(obj5, iZzu & 1048575, zzhbqVar.zzf());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 7:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzp(obj5, iZzu & 1048575, zzhbqVar.zzN());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 8:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzG(obj5, iZzu, zzhbqVar);
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 9:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbe zzhbeVar = (zzhbe) zzA(obj5, iZzq);
                                    zzhbqVar.zzu(zzhbeVar, zzx(iZzq), zzgzfVar2);
                                    zzJ(obj5, iZzq, zzhbeVar);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 10:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzv(obj5, iZzu & 1048575, zzhbqVar.zzp());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 11:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzt(obj5, iZzu & 1048575, zzhbqVar.zzj());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 12:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    int iZze = zzhbqVar.zze();
                                    zzgzy zzgzyVarZzw = zzw(iZzq);
                                    if (zzgzyVarZzw != null && !zzgzyVarZzw.zza(iZze)) {
                                        objZzy = zzhca.zzp(obj5, iZzc, iZze, obj4, zzhcpVar);
                                        zzgzgVar2 = zzgzgVar;
                                        zzgzfVar3 = zzgzfVar2;
                                        zzhcpVar3 = zzhcpVar;
                                    }
                                    zzhcz.zzt(obj5, iZzu & 1048575, iZze);
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 13:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzt(obj5, iZzu & 1048575, zzhbqVar.zzh());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 14:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzu(obj5, iZzu & 1048575, zzhbqVar.zzm());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 15:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzt(obj5, iZzu & 1048575, zzhbqVar.zzi());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 16:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhcz.zzu(obj5, iZzu & 1048575, zzhbqVar.zzn());
                                    zzH(obj5, iZzq);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 17:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbe zzhbeVar2 = (zzhbe) zzA(obj5, iZzq);
                                    zzhbqVar.zzt(zzhbeVar2, zzx(iZzq), zzgzfVar2);
                                    zzJ(obj5, iZzq, zzhbeVar2);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 18:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzx(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 19:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzB(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 20:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzE(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 21:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzM(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 22:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzD(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 23:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzA(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 24:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzz(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 25:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzv(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 26:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    if (zzM(iZzu)) {
                                        ((zzgyu) zzhbqVar).zzK(this.zzm.zza(obj5, iZzu & 1048575), true);
                                    } else {
                                        ((zzgyu) zzhbqVar).zzK(this.zzm.zza(obj5, iZzu & 1048575), false);
                                    }
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 27:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzF(this.zzm.zza(obj5, iZzu & 1048575), zzx(iZzq), zzgzfVar2);
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 28:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzw(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 29:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzL(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 30:
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    List listZza = this.zzm.zza(obj5, iZzu & 1048575);
                                    zzhbqVar.zzy(listZza);
                                    objZzy = zzhca.zzo(obj, iZzc, listZza, zzw(iZzq), objZzy, zzhcpVar);
                                    zzgzgVar2 = zzgzgVar;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 31:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzG(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 32:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzH(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 33:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzI(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 34:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzJ(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 35:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzx(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 36:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzB(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 37:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzE(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 38:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzM(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 39:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzD(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 40:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzA(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 41:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzz(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 42:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzv(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 43:
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzhbqVar.zzL(this.zzm.zza(obj5, iZzu & 1048575));
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 44:
                                    List listZza2 = this.zzm.zza(obj5, iZzu & 1048575);
                                    zzhbqVar.zzy(listZza2);
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    objZzy = zzhca.zzo(obj, iZzc, listZza2, zzw(iZzq), objZzy, zzhcpVar);
                                    zzgzgVar2 = zzgzgVar;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 45:
                                    zzhbqVar.zzG(this.zzm.zza(obj5, iZzu & 1048575));
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 46:
                                    zzhbqVar.zzH(this.zzm.zza(obj5, iZzu & 1048575));
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 47:
                                    zzhbqVar.zzI(this.zzm.zza(obj5, iZzu & 1048575));
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                                    zzhbqVar.zzJ(this.zzm.zza(obj5, iZzu & 1048575));
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                    zzhbqVar.zzC(this.zzm.zza(obj5, iZzu & 1048575), zzx(iZzq), zzgzfVar3);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 50:
                                    Object objZzz = zzz(iZzq);
                                    long jZzu = zzu(iZzq) & 1048575;
                                    Object objZzh = zzhcz.zzh(obj5, jZzu);
                                    if (objZzh == null) {
                                        objZzh = zzhay.zza().zzb();
                                        zzhcz.zzv(obj5, jZzu, objZzh);
                                    } else if (zzhaz.zza(objZzh)) {
                                        Object objZzb = zzhay.zza().zzb();
                                        zzhaz.zzb(objZzb, objZzh);
                                        zzhcz.zzv(obj5, jZzu, objZzb);
                                        objZzh = objZzb;
                                    }
                                    throw null;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                    zzhcz.zzv(obj5, iZzu & 1048575, Double.valueOf(zzhbqVar.zza()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 52:
                                    zzhcz.zzv(obj5, iZzu & 1048575, Float.valueOf(zzhbqVar.zzb()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                    zzhcz.zzv(obj5, iZzu & 1048575, Long.valueOf(zzhbqVar.zzl()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                                    zzhcz.zzv(obj5, iZzu & 1048575, Long.valueOf(zzhbqVar.zzo()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                    zzhcz.zzv(obj5, iZzu & 1048575, Integer.valueOf(zzhbqVar.zzg()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 56:
                                    zzhcz.zzv(obj5, iZzu & 1048575, Long.valueOf(zzhbqVar.zzk()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 57:
                                    zzhcz.zzv(obj5, iZzu & 1048575, Integer.valueOf(zzhbqVar.zzf()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 58:
                                    zzhcz.zzv(obj5, iZzu & 1048575, Boolean.valueOf(zzhbqVar.zzN()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 59:
                                    zzG(obj5, iZzu, zzhbqVar);
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                                    zzhbe zzhbeVar3 = (zzhbe) zzB(obj5, iZzc, iZzq);
                                    zzhbqVar.zzu(zzhbeVar3, zzx(iZzq), zzgzfVar3);
                                    zzK(obj5, iZzc, iZzq, zzhbeVar3);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                    zzhcz.zzv(obj5, iZzu & 1048575, zzhbqVar.zzp());
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 62:
                                    zzhcz.zzv(obj5, iZzu & 1048575, Integer.valueOf(zzhbqVar.zzj()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                    int iZze2 = zzhbqVar.zze();
                                    zzgzy zzgzyVarZzw2 = zzw(iZzq);
                                    if (zzgzyVarZzw2 == null || zzgzyVarZzw2.zza(iZze2)) {
                                        zzhcz.zzv(obj5, iZzu & 1048575, Integer.valueOf(iZze2));
                                        zzI(obj5, iZzc, iZzq);
                                        obj4 = objZzy;
                                        zzgzgVar = zzgzgVar2;
                                        zzgzfVar2 = zzgzfVar3;
                                        zzgzgVar2 = zzgzgVar;
                                        objZzy = obj4;
                                        zzgzfVar3 = zzgzfVar2;
                                    } else {
                                        objZzy = zzhca.zzp(obj5, iZzc, iZze2, objZzy, zzhcpVar);
                                        obj5 = obj5;
                                    }
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 64:
                                    zzhcz.zzv(obj5, iZzu & 1048575, Integer.valueOf(zzhbqVar.zzh()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                                    zzhcz.zzv(obj5, iZzu & 1048575, Long.valueOf(zzhbqVar.zzm()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                    zzhcz.zzv(obj5, iZzu & 1048575, Integer.valueOf(zzhbqVar.zzi()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 67:
                                    zzhcz.zzv(obj5, iZzu & 1048575, Long.valueOf(zzhbqVar.zzn()));
                                    zzI(obj5, iZzc, iZzq);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                case 68:
                                    zzhbe zzhbeVar4 = (zzhbe) zzB(obj5, iZzc, iZzq);
                                    zzhbqVar.zzt(zzhbeVar4, zzx(iZzq), zzgzfVar3);
                                    zzK(obj5, iZzc, iZzq, zzhbeVar4);
                                    obj4 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    zzgzgVar2 = zzgzgVar;
                                    objZzy = obj4;
                                    zzgzfVar3 = zzgzfVar2;
                                    zzhcpVar3 = zzhcpVar;
                                    break;
                                default:
                                    obj2 = objZzy;
                                    zzgzgVar = zzgzgVar2;
                                    zzgzfVar2 = zzgzfVar3;
                                    if (obj2 == null) {
                                        try {
                                            objZzy = zzhcpVar.zzc(obj5);
                                        } catch (zzhaf unused) {
                                            objZzy = obj2;
                                            zzhcpVar.zzq(zzhbqVar);
                                            if (objZzy == null) {
                                                objZzy = zzhcpVar.zzc(obj5);
                                            }
                                            if (!zzhcpVar.zzp(objZzy, zzhbqVar)) {
                                                for (i2 = this.zzk; i2 < this.zzl; i2++) {
                                                    objZzy = zzy(obj, this.zzj[i2], objZzy, zzhcpVar, obj);
                                                }
                                                if (objZzy != null) {
                                                    zzhcpVar.zzn(obj5, objZzy);
                                                }
                                            }
                                            zzgzgVar2 = zzgzgVar;
                                            zzgzfVar3 = zzgzfVar2;
                                            zzhcpVar3 = zzhcpVar;
                                        } catch (Throwable th) {
                                            th = th;
                                            objZzy = obj2;
                                        }
                                    } else {
                                        objZzy = obj2;
                                    }
                                    try {
                                        try {
                                            if (!zzhcpVar.zzp(objZzy, zzhbqVar)) {
                                                for (int i3 = this.zzk; i3 < this.zzl; i3++) {
                                                    objZzy = zzy(obj, this.zzj[i3], objZzy, zzhcpVar, obj);
                                                }
                                            }
                                        } catch (zzhaf unused2) {
                                            zzhcpVar.zzq(zzhbqVar);
                                            if (objZzy == null) {
                                                objZzy = zzhcpVar.zzc(obj5);
                                            }
                                            if (!zzhcpVar.zzp(objZzy, zzhbqVar)) {
                                                while (i2 < this.zzl) {
                                                    objZzy = zzy(obj, this.zzj[i2], objZzy, zzhcpVar, obj);
                                                }
                                                if (objZzy != null) {
                                                    zzhcpVar.zzn(obj5, objZzy);
                                                }
                                            }
                                        }
                                        zzgzgVar2 = zzgzgVar;
                                        zzgzfVar3 = zzgzfVar2;
                                        zzhcpVar3 = zzhcpVar;
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                    break;
                            }
                        } catch (zzhaf unused3) {
                            obj2 = objZzy;
                            zzgzgVar = zzgzgVar2;
                            zzgzfVar2 = zzgzfVar3;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        obj2 = objZzy;
                    }
                } else if (iZzc == Integer.MAX_VALUE) {
                    for (int i4 = this.zzk; i4 < this.zzl; i4++) {
                        objZzy = zzy(obj, this.zzj[i4], objZzy, zzhcpVar3, obj);
                    }
                    zzhcpVar = zzhcpVar3;
                    obj5 = obj5;
                } else {
                    try {
                        Object objZzc = !this.zzh ? null : zzgzgVar2.zzc(zzgzfVar3, this.zzg, iZzc);
                        if (objZzc != null) {
                            if (zzgzkVarZzb == null) {
                                zzgzkVarZzb = zzgzgVar2.zzb(obj5);
                            }
                            zzgzk zzgzkVar = zzgzkVarZzb;
                            zzhcpVar2 = zzhcpVar3;
                            obj3 = obj5;
                            try {
                                objZzy = zzgzgVar2.zzd(obj, zzhbqVar, objZzc, zzgzfVar, zzgzkVar, objZzy, zzhcpVar2);
                                zzgzkVarZzb = zzgzkVar;
                            } catch (Throwable th4) {
                                th = th4;
                                obj5 = obj3;
                                zzhcpVar = zzhcpVar2;
                                obj2 = objZzy;
                                objZzy = obj2;
                                for (i = this.zzk; i < this.zzl; i++) {
                                    objZzy = zzy(obj, this.zzj[i], objZzy, zzhcpVar, obj);
                                }
                                if (objZzy != null) {
                                    zzhcpVar.zzn(obj5, objZzy);
                                }
                                throw th;
                            }
                        } else {
                            zzhcpVar2 = zzhcpVar3;
                            obj3 = obj5;
                            zzhcpVar2.zzq(zzhbqVar);
                            if (objZzy == null) {
                                objZzy = zzhcpVar2.zzc(obj3);
                            }
                            try {
                                if (!zzhcpVar2.zzp(objZzy, zzhbqVar)) {
                                    int i5 = this.zzk;
                                    while (i5 < this.zzl) {
                                        zzhcp zzhcpVar4 = zzhcpVar2;
                                        objZzy = zzy(obj, this.zzj[i5], objZzy, zzhcpVar4, obj);
                                        i5++;
                                        obj3 = obj3;
                                        zzhcpVar2 = zzhcpVar4;
                                    }
                                    obj5 = obj3;
                                    zzhcpVar = zzhcpVar2;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                obj5 = obj3;
                                zzhcpVar = zzhcpVar2;
                            }
                        }
                        obj5 = obj3;
                        zzhcpVar3 = zzhcpVar2;
                    } catch (Throwable th6) {
                        th = th6;
                        zzhcpVar = zzhcpVar3;
                        obj5 = obj5;
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                obj2 = objZzy;
                zzhcpVar = zzhcpVar3;
                obj5 = obj5;
            }
            objZzy = obj2;
            while (i < this.zzl) {
                objZzy = zzy(obj, this.zzj[i], objZzy, zzhcpVar, obj);
            }
            if (objZzy != null) {
                zzhcpVar.zzn(obj5, objZzy);
            }
            throw th;
        }
        if (objZzy != null) {
            zzhcpVar.zzn(obj5, objZzy);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzgxx zzgxxVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzgxxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzs;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzu = zzu(i);
            long j = iZzu & 1048575;
            switch (zzt(iZzu)) {
                case 0:
                    if (!zzL(obj, obj2, i) || Double.doubleToLongBits(zzhcz.zzb(obj, j)) != Double.doubleToLongBits(zzhcz.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzL(obj, obj2, i) || Float.floatToIntBits(zzhcz.zzc(obj, j)) != Float.floatToIntBits(zzhcz.zzc(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzL(obj, obj2, i) || zzhcz.zzf(obj, j) != zzhcz.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzL(obj, obj2, i) || zzhcz.zzf(obj, j) != zzhcz.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzL(obj, obj2, i) || zzhcz.zzd(obj, j) != zzhcz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzL(obj, obj2, i) || zzhcz.zzf(obj, j) != zzhcz.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzL(obj, obj2, i) || zzhcz.zzd(obj, j) != zzhcz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzL(obj, obj2, i) || zzhcz.zzz(obj, j) != zzhcz.zzz(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzL(obj, obj2, i) || !zzhca.zzs(zzhcz.zzh(obj, j), zzhcz.zzh(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzL(obj, obj2, i) || !zzhca.zzs(zzhcz.zzh(obj, j), zzhcz.zzh(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzL(obj, obj2, i) || !zzhca.zzs(zzhcz.zzh(obj, j), zzhcz.zzh(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzL(obj, obj2, i) || zzhcz.zzd(obj, j) != zzhcz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzL(obj, obj2, i) || zzhcz.zzd(obj, j) != zzhcz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzL(obj, obj2, i) || zzhcz.zzd(obj, j) != zzhcz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzL(obj, obj2, i) || zzhcz.zzf(obj, j) != zzhcz.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzL(obj, obj2, i) || zzhcz.zzd(obj, j) != zzhcz.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzL(obj, obj2, i) || zzhcz.zzf(obj, j) != zzhcz.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzL(obj, obj2, i) || !zzhca.zzs(zzhcz.zzh(obj, j), zzhcz.zzh(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    zZzs = zzhca.zzs(zzhcz.zzh(obj, j), zzhcz.zzh(obj2, j));
                    break;
                case 50:
                    zZzs = zzhca.zzs(zzhcz.zzh(obj, j), zzhcz.zzh(obj2, j));
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                case 52:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                case 56:
                case 57:
                case 58:
                case 59:
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                case 62:
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                case 64:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                case 67:
                case 68:
                    long jZzr = zzr(i) & 1048575;
                    if (zzhcz.zzd(obj, jZzr) != zzhcz.zzd(obj2, jZzr) || !zzhca.zzs(zzhcz.zzh(obj, j), zzhcz.zzh(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzs) {
                return false;
            }
        }
        if (!this.zzn.zzd(obj).equals(this.zzn.zzd(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        this.zzo.zza(obj2);
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009e  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c3 A[LOOP:1: B:45:0x00b2->B:50:0x00c3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:66:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x00e1 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhby
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        List list;
        zzhby zzhbyVarZzx;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i5 < this.zzk) {
            int[] iArr = this.zzj;
            int[] iArr2 = this.zzc;
            int i7 = iArr[i5];
            int i8 = iArr2[i7];
            int iZzu = zzu(i7);
            int i9 = this.zzc[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i6) {
                if (i10 != 1048575) {
                    i4 = zzb.getInt(obj, i10);
                }
                i2 = i4;
                i = i10;
            } else {
                i = i6;
                i2 = i4;
            }
            if ((268435456 & iZzu) != 0 && !zzO(obj, i7, i, i2, i11)) {
                return false;
            }
            int iZzt = zzt(iZzu);
            if (iZzt == 9 || iZzt == 17) {
                if (zzO(obj, i7, i, i2, i11) && !zzP(obj, iZzu, zzx(i7))) {
                    return false;
                }
            } else if (iZzt == 27) {
                list = (List) zzhcz.zzh(obj, iZzu & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzhbyVarZzx = zzx(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzhbyVarZzx.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzt == 60 || iZzt == 68) {
                if (zzR(obj, i8, i7) && !zzP(obj, iZzu, zzx(i7))) {
                    return false;
                }
            } else if (iZzt == 49) {
                list = (List) zzhcz.zzh(obj, iZzu & 1048575);
                if (list.isEmpty()) {
                    zzhbyVarZzx = zzx(i7);
                    while (i3 < list.size()) {
                        if (!zzhbyVarZzx.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzt == 50 && !((zzhay) zzhcz.zzh(obj, iZzu & 1048575)).isEmpty()) {
                throw null;
            }
            i5++;
            i6 = i;
            i4 = i2;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final void zzm(Object obj, zzgzb zzgzbVar) throws IOException {
        int i;
        int i2;
        int i3;
        if (this.zzh) {
            this.zzo.zza(obj);
            throw null;
        }
        int[] iArr = this.zzc;
        Unsafe unsafe = zzb;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        while (i7 < iArr.length) {
            int iZzu = zzu(i7);
            int[] iArr2 = this.zzc;
            int iZzt = zzt(iZzu);
            int i8 = iArr2[i7];
            if (iZzt <= 17) {
                int i9 = iArr2[i7 + 2];
                int i10 = i9 & i4;
                if (i10 != i5) {
                    i6 = i10 == i4 ? 0 : unsafe.getInt(obj, i10);
                    i5 = i10;
                }
                i = i5;
                i2 = i6;
                i3 = 1 << (i9 >>> 20);
            } else {
                i = i5;
                i2 = i6;
                i3 = 0;
            }
            long j = iZzu & i4;
            switch (iZzt) {
                case 0:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzf(i8, zzhcz.zzb(obj, j));
                    }
                    break;
                case 1:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzo(i8, zzhcz.zzc(obj, j));
                    }
                    break;
                case 2:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzt(i8, unsafe.getLong(obj, j));
                    }
                    break;
                case 3:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzJ(i8, unsafe.getLong(obj, j));
                    }
                    break;
                case 4:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzr(i8, unsafe.getInt(obj, j));
                    }
                    break;
                case 5:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzm(i8, unsafe.getLong(obj, j));
                    }
                    break;
                case 6:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzk(i8, unsafe.getInt(obj, j));
                    }
                    break;
                case 7:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzb(i8, zzhcz.zzz(obj, j));
                    }
                    break;
                case 8:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzT(i8, unsafe.getObject(obj, j), zzgzbVar);
                    }
                    break;
                case 9:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzv(i8, unsafe.getObject(obj, j), zzx(i7));
                    }
                    break;
                case 10:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzd(i8, (zzgyl) unsafe.getObject(obj, j));
                    }
                    break;
                case 11:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzH(i8, unsafe.getInt(obj, j));
                    }
                    break;
                case 12:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzi(i8, unsafe.getInt(obj, j));
                    }
                    break;
                case 13:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzw(i8, unsafe.getInt(obj, j));
                    }
                    break;
                case 14:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzy(i8, unsafe.getLong(obj, j));
                    }
                    break;
                case 15:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzA(i8, unsafe.getInt(obj, j));
                    }
                    break;
                case 16:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzC(i8, unsafe.getLong(obj, j));
                    }
                    break;
                case 17:
                    if (zzO(obj, i7, i, i2, i3)) {
                        zzgzbVar.zzq(i8, unsafe.getObject(obj, j), zzx(i7));
                    }
                    break;
                case 18:
                    zzhca.zzu(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 19:
                    zzhca.zzy(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 20:
                    zzhca.zzA(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 21:
                    zzhca.zzG(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 22:
                    zzhca.zzz(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 23:
                    zzhca.zzx(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 24:
                    zzhca.zzw(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 25:
                    zzhca.zzt(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 26:
                    int i11 = this.zzc[i7];
                    List list = (List) unsafe.getObject(obj, j);
                    int i12 = zzhca.zza;
                    if (list != null && !list.isEmpty()) {
                        zzgzbVar.zzG(i11, list);
                    }
                    break;
                case 27:
                    int i13 = this.zzc[i7];
                    List list2 = (List) unsafe.getObject(obj, j);
                    zzhby zzhbyVarZzx = zzx(i7);
                    int i14 = zzhca.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i15 = 0; i15 < list2.size(); i15++) {
                            zzgzbVar.zzv(i13, list2.get(i15), zzhbyVarZzx);
                        }
                    }
                    break;
                case 28:
                    int i16 = this.zzc[i7];
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i17 = zzhca.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzgzbVar.zze(i16, list3);
                    }
                    break;
                case 29:
                    zzhca.zzF(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 30:
                    zzhca.zzv(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 31:
                    zzhca.zzB(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 32:
                    zzhca.zzC(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 33:
                    zzhca.zzD(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 34:
                    zzhca.zzE(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, false);
                    break;
                case 35:
                    zzhca.zzu(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case 36:
                    zzhca.zzy(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case 37:
                    zzhca.zzA(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case 38:
                    zzhca.zzG(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case 39:
                    zzhca.zzz(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case 40:
                    zzhca.zzx(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case 41:
                    zzhca.zzw(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case 42:
                    zzhca.zzt(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case 43:
                    zzhca.zzF(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case 44:
                    zzhca.zzv(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case 45:
                    zzhca.zzB(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case 46:
                    zzhca.zzC(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case 47:
                    zzhca.zzD(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                    zzhca.zzE(this.zzc[i7], (List) unsafe.getObject(obj, j), zzgzbVar, true);
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    int i18 = this.zzc[i7];
                    List list4 = (List) unsafe.getObject(obj, j);
                    zzhby zzhbyVarZzx2 = zzx(i7);
                    int i19 = zzhca.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i20 = 0; i20 < list4.size(); i20++) {
                            zzgzbVar.zzq(i18, list4.get(i20), zzhbyVarZzx2);
                        }
                    }
                    break;
                case 50:
                    if (unsafe.getObject(obj, j) != null) {
                        throw null;
                    }
                    break;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzf(i8, zzn(obj, j));
                    }
                    break;
                case 52:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzo(i8, zzo(obj, j));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzt(i8, zzv(obj, j));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzJ(i8, zzv(obj, j));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzr(i8, zzp(obj, j));
                    }
                    break;
                case 56:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzm(i8, zzv(obj, j));
                    }
                    break;
                case 57:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzk(i8, zzp(obj, j));
                    }
                    break;
                case 58:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzb(i8, zzS(obj, j));
                    }
                    break;
                case 59:
                    if (zzR(obj, i8, i7)) {
                        zzT(i8, unsafe.getObject(obj, j), zzgzbVar);
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzv(i8, unsafe.getObject(obj, j), zzx(i7));
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzd(i8, (zzgyl) unsafe.getObject(obj, j));
                    }
                    break;
                case 62:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzH(i8, zzp(obj, j));
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzi(i8, zzp(obj, j));
                    }
                    break;
                case 64:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzw(i8, zzp(obj, j));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzy(i8, zzv(obj, j));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzA(i8, zzp(obj, j));
                    }
                    break;
                case 67:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzC(i8, zzv(obj, j));
                    }
                    break;
                case 68:
                    if (zzR(obj, i8, i7)) {
                        zzgzbVar.zzq(i8, unsafe.getObject(obj, j), zzx(i7));
                    }
                    break;
            }
            i7 += 3;
            i5 = i;
            i6 = i2;
            i4 = 1048575;
        }
        zzhcp zzhcpVar = this.zzn;
        zzhcpVar.zzr(zzhcpVar.zzd(obj), zzgzbVar);
    }
}
