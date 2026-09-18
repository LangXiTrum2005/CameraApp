package com.google.android.gms.internal.play_billing;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.text.HtmlCompat;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.android.billingclient:billing@@6.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdi<T> implements zzdp<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzeq.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzdf zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzct zzl;
    private final zzeg zzm;
    private final zzbo zzn;
    private final int zzo;
    private final zzdk zzp;
    private final zzda zzq;

    private zzdi(int[] iArr, Object[] objArr, int i, int i2, zzdf zzdfVar, int i3, boolean z, int[] iArr2, int i4, int i5, zzdk zzdkVar, zzct zzctVar, zzeg zzegVar, zzbo zzboVar, zzda zzdaVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzo = i3;
        boolean z2 = false;
        if (zzboVar != null && zzboVar.zzc(zzdfVar)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i4;
        this.zzk = i5;
        this.zzp = zzdkVar;
        this.zzl = zzctVar;
        this.zzm = zzegVar;
        this.zzn = zzboVar;
        this.zzg = zzdfVar;
        this.zzq = zzdaVar;
    }

    private final zzce zzA(int i) {
        int i2 = i / 3;
        return (zzce) this.zzd[i2 + i2 + 1];
    }

    private final zzdp zzB(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzdp zzdpVar = (zzdp) this.zzd[i3];
        if (zzdpVar != null) {
            return zzdpVar;
        }
        zzdp zzdpVarZzb = zzdn.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzdpVarZzb;
        return zzdpVarZzb;
    }

    private final Object zzC(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzD(Object obj, int i) {
        zzdp zzdpVarZzB = zzB(i);
        int iZzy = zzy(i) & 1048575;
        if (!zzP(obj, i)) {
            return zzdpVarZzB.zze();
        }
        Object object = zzb.getObject(obj, iZzy);
        if (zzS(object)) {
            return object;
        }
        Object objZze = zzdpVarZzB.zze();
        if (object != null) {
            zzdpVarZzB.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzE(Object obj, int i, int i2) {
        zzdp zzdpVarZzB = zzB(i2);
        if (!zzT(obj, i, i2)) {
            return zzdpVarZzB.zze();
        }
        Object object = zzb.getObject(obj, zzy(i2) & 1048575);
        if (zzS(object)) {
            return object;
        }
        Object objZze = zzdpVarZzB.zze();
        if (object != null) {
            zzdpVarZzB.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzF(Class cls, String str) {
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

    private static void zzG(Object obj) {
        if (!zzS(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzH(Object obj, Object obj2, int i) {
        if (zzP(obj2, i)) {
            int iZzy = zzy(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzy;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzdp zzdpVarZzB = zzB(i);
            if (!zzP(obj, i)) {
                if (zzS(object)) {
                    Object objZze = zzdpVarZzB.zze();
                    zzdpVarZzB.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzJ(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzS(object2)) {
                Object objZze2 = zzdpVarZzB.zze();
                zzdpVarZzB.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzdpVarZzB.zzg(object2, object);
        }
    }

    private final void zzI(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzT(obj2, i2, i)) {
            int iZzy = zzy(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzy;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzdp zzdpVarZzB = zzB(i);
            if (!zzT(obj, i2, i)) {
                if (zzS(object)) {
                    Object objZze = zzdpVarZzB.zze();
                    zzdpVarZzB.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzK(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzS(object2)) {
                Object objZze2 = zzdpVarZzB.zze();
                zzdpVarZzB.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzdpVarZzB.zzg(object2, object);
        }
    }

    private final void zzJ(Object obj, int i) {
        int iZzv = zzv(i);
        long j = 1048575 & iZzv;
        if (j == 1048575) {
            return;
        }
        zzeq.zzq(obj, j, (1 << (iZzv >>> 20)) | zzeq.zzc(obj, j));
    }

    private final void zzK(Object obj, int i, int i2) {
        zzeq.zzq(obj, zzv(i2) & 1048575, i);
    }

    private final void zzL(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzy(i) & 1048575, obj2);
        zzJ(obj, i);
    }

    private final void zzM(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzy(i2) & 1048575, obj2);
        zzK(obj, i, i2);
    }

    private final void zzN(zzey zzeyVar, int i, Object obj, int i2) throws IOException {
        if (obj == null) {
            return;
        }
        throw null;
    }

    private final boolean zzO(Object obj, Object obj2, int i) {
        return zzP(obj, i) == zzP(obj2, i);
    }

    private final boolean zzP(Object obj, int i) {
        int iZzv = zzv(i);
        long j = iZzv & 1048575;
        if (j != 1048575) {
            return (zzeq.zzc(obj, j) & (1 << (iZzv >>> 20))) != 0;
        }
        int iZzy = zzy(i);
        long j2 = iZzy & 1048575;
        switch (zzx(iZzy)) {
            case 0:
                return Double.doubleToRawLongBits(zzeq.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzeq.zzb(obj, j2)) != 0;
            case 2:
                return zzeq.zzd(obj, j2) != 0;
            case 3:
                return zzeq.zzd(obj, j2) != 0;
            case 4:
                return zzeq.zzc(obj, j2) != 0;
            case 5:
                return zzeq.zzd(obj, j2) != 0;
            case 6:
                return zzeq.zzc(obj, j2) != 0;
            case 7:
                return zzeq.zzw(obj, j2);
            case 8:
                Object objZzf = zzeq.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzba) {
                    return !zzba.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzeq.zzf(obj, j2) != null;
            case 10:
                return !zzba.zzb.equals(zzeq.zzf(obj, j2));
            case 11:
                return zzeq.zzc(obj, j2) != 0;
            case 12:
                return zzeq.zzc(obj, j2) != 0;
            case 13:
                return zzeq.zzc(obj, j2) != 0;
            case 14:
                return zzeq.zzd(obj, j2) != 0;
            case 15:
                return zzeq.zzc(obj, j2) != 0;
            case 16:
                return zzeq.zzd(obj, j2) != 0;
            case 17:
                return zzeq.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzQ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzP(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzR(Object obj, int i, zzdp zzdpVar) {
        return zzdpVar.zzk(zzeq.zzf(obj, i & 1048575));
    }

    private static boolean zzS(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzcb) {
            return ((zzcb) obj).zzt();
        }
        return true;
    }

    private final boolean zzT(Object obj, int i, int i2) {
        return zzeq.zzc(obj, (long) (zzv(i2) & 1048575)) == i;
    }

    private static boolean zzU(Object obj, long j) {
        return ((Boolean) zzeq.zzf(obj, j)).booleanValue();
    }

    private static final void zzV(int i, Object obj, zzey zzeyVar) throws IOException {
        if (obj instanceof String) {
            zzeyVar.zzF(i, (String) obj);
        } else {
            zzeyVar.zzd(i, (zzba) obj);
        }
    }

    static zzeh zzd(Object obj) {
        zzcb zzcbVar = (zzcb) obj;
        zzeh zzehVar = zzcbVar.zzc;
        if (zzehVar != zzeh.zzc()) {
            return zzehVar;
        }
        zzeh zzehVarZzf = zzeh.zzf();
        zzcbVar.zzc = zzehVarZzf;
        return zzehVarZzf;
    }

    /* JADX WARN: Code duplicated, block: B:123:0x024f  */
    /* JADX WARN: Code duplicated, block: B:124:0x0252  */
    /* JADX WARN: Code duplicated, block: B:127:0x026a  */
    /* JADX WARN: Code duplicated, block: B:128:0x026d  */
    static zzdi zzl(Class cls, zzdc zzdcVar, zzdk zzdkVar, zzct zzctVar, zzeg zzegVar, zzbo zzboVar, zzda zzdaVar) {
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
        int i17;
        int i18;
        int iObjectFieldOffset;
        int i19;
        int i20;
        int iObjectFieldOffset2;
        Field fieldZzF;
        char cCharAt9;
        int i21;
        int i22;
        int i23;
        Object obj;
        Field fieldZzF2;
        int i24;
        Object obj2;
        Field fieldZzF3;
        int i25;
        char cCharAt10;
        int i26;
        char cCharAt11;
        int i27;
        char cCharAt12;
        int i28;
        char cCharAt13;
        if (!(zzdcVar instanceof zzdo)) {
            throw null;
        }
        zzdo zzdoVar = (zzdo) zzdcVar;
        String strZzd = zzdoVar.zzd();
        int length = strZzd.length();
        char c = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i29 = 1;
            while (true) {
                i = i29 + 1;
                if (strZzd.charAt(i29) < 55296) {
                    break;
                }
                i29 = i;
            }
        } else {
            i = 1;
        }
        int i30 = i + 1;
        int iCharAt3 = strZzd.charAt(i);
        if (iCharAt3 >= 55296) {
            int i31 = iCharAt3 & 8191;
            int i32 = 13;
            while (true) {
                i28 = i30 + 1;
                cCharAt13 = strZzd.charAt(i30);
                if (cCharAt13 < 55296) {
                    break;
                }
                i31 |= (cCharAt13 & 8191) << i32;
                i32 += 13;
                i30 = i28;
            }
            iCharAt3 = i31 | (cCharAt13 << i32);
            i30 = i28;
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
            int i33 = i30 + 1;
            int iCharAt4 = strZzd.charAt(i30);
            if (iCharAt4 >= 55296) {
                int i34 = iCharAt4 & 8191;
                int i35 = 13;
                while (true) {
                    i14 = i33 + 1;
                    cCharAt8 = strZzd.charAt(i33);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i34 |= (cCharAt8 & 8191) << i35;
                    i35 += 13;
                    i33 = i14;
                }
                iCharAt4 = i34 | (cCharAt8 << i35);
                i33 = i14;
            }
            int i36 = i33 + 1;
            int iCharAt5 = strZzd.charAt(i33);
            if (iCharAt5 >= 55296) {
                int i37 = iCharAt5 & 8191;
                int i38 = 13;
                while (true) {
                    i13 = i36 + 1;
                    cCharAt7 = strZzd.charAt(i36);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i37 |= (cCharAt7 & 8191) << i38;
                    i38 += 13;
                    i36 = i13;
                }
                iCharAt5 = i37 | (cCharAt7 << i38);
                i36 = i13;
            }
            int i39 = i36 + 1;
            int iCharAt6 = strZzd.charAt(i36);
            if (iCharAt6 >= 55296) {
                int i40 = iCharAt6 & 8191;
                int i41 = 13;
                while (true) {
                    i12 = i39 + 1;
                    cCharAt6 = strZzd.charAt(i39);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i40 |= (cCharAt6 & 8191) << i41;
                    i41 += 13;
                    i39 = i12;
                }
                iCharAt6 = i40 | (cCharAt6 << i41);
                i39 = i12;
            }
            int i42 = i39 + 1;
            int iCharAt7 = strZzd.charAt(i39);
            if (iCharAt7 >= 55296) {
                int i43 = iCharAt7 & 8191;
                int i44 = 13;
                while (true) {
                    i11 = i42 + 1;
                    cCharAt5 = strZzd.charAt(i42);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i43 |= (cCharAt5 & 8191) << i44;
                    i44 += 13;
                    i42 = i11;
                }
                iCharAt7 = i43 | (cCharAt5 << i44);
                i42 = i11;
            }
            int i45 = i42 + 1;
            iCharAt = strZzd.charAt(i42);
            if (iCharAt >= 55296) {
                int i46 = iCharAt & 8191;
                int i47 = 13;
                while (true) {
                    i10 = i45 + 1;
                    cCharAt4 = strZzd.charAt(i45);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i46 |= (cCharAt4 & 8191) << i47;
                    i47 += 13;
                    i45 = i10;
                }
                iCharAt = i46 | (cCharAt4 << i47);
                i45 = i10;
            }
            int i48 = i45 + 1;
            iCharAt2 = strZzd.charAt(i45);
            if (iCharAt2 >= 55296) {
                int i49 = iCharAt2 & 8191;
                int i50 = 13;
                while (true) {
                    i9 = i48 + 1;
                    cCharAt3 = strZzd.charAt(i48);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i49 |= (cCharAt3 & 8191) << i50;
                    i50 += 13;
                    i48 = i9;
                }
                iCharAt2 = i49 | (cCharAt3 << i50);
                i48 = i9;
            }
            int i51 = i48 + 1;
            int iCharAt8 = strZzd.charAt(i48);
            if (iCharAt8 >= 55296) {
                int i52 = iCharAt8 & 8191;
                int i53 = 13;
                while (true) {
                    i8 = i51 + 1;
                    cCharAt2 = strZzd.charAt(i51);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i52 |= (cCharAt2 & 8191) << i53;
                    i53 += 13;
                    i51 = i8;
                }
                iCharAt8 = i52 | (cCharAt2 << i53);
                i51 = i8;
            }
            int i54 = i51 + 1;
            int iCharAt9 = strZzd.charAt(i51);
            if (iCharAt9 >= 55296) {
                int i55 = iCharAt9 & 8191;
                int i56 = 13;
                while (true) {
                    i7 = i54 + 1;
                    cCharAt = strZzd.charAt(i54);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i55 |= (cCharAt & 8191) << i56;
                    i56 += 13;
                    i54 = i7;
                }
                iCharAt9 = i55 | (cCharAt << i56);
                i54 = i7;
            }
            i2 = iCharAt4 + iCharAt4 + iCharAt5;
            iArr = new int[iCharAt9 + iCharAt2 + iCharAt8];
            i3 = iCharAt6;
            i4 = iCharAt9;
            i5 = iCharAt4;
            i6 = iCharAt7;
            i30 = i54;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzdoVar.zze();
        Class<?> cls2 = zzdoVar.zza().getClass();
        int i57 = i4 + iCharAt2;
        int i58 = iCharAt + iCharAt;
        int[] iArr2 = new int[iCharAt * 3];
        Object[] objArr = new Object[i58];
        int i59 = 0;
        int i60 = 0;
        int i61 = i4;
        int i62 = i57;
        while (i30 < length) {
            int i63 = i30 + 1;
            int iCharAt10 = strZzd.charAt(i30);
            if (iCharAt10 >= c) {
                int i64 = iCharAt10 & 8191;
                int i65 = i63;
                int i66 = 13;
                while (true) {
                    i27 = i65 + 1;
                    cCharAt12 = strZzd.charAt(i65);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i64 |= (cCharAt12 & 8191) << i66;
                    i66 += 13;
                    i65 = i27;
                }
                iCharAt10 = i64 | (cCharAt12 << i66);
                i15 = i27;
            } else {
                i15 = i63;
            }
            int i67 = i15 + 1;
            int iCharAt11 = strZzd.charAt(i15);
            if (iCharAt11 >= c) {
                int i68 = iCharAt11 & 8191;
                int i69 = i67;
                int i70 = 13;
                while (true) {
                    i26 = i69 + 1;
                    cCharAt11 = strZzd.charAt(i69);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i68 |= (cCharAt11 & 8191) << i70;
                    i70 += 13;
                    i69 = i26;
                }
                iCharAt11 = i68 | (cCharAt11 << i70);
                i16 = i26;
            } else {
                i16 = i67;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i59] = i60;
                i59++;
            }
            int i71 = iCharAt11 & 255;
            if (i71 >= 51) {
                int i72 = i16 + 1;
                int iCharAt12 = strZzd.charAt(i16);
                char c2 = 55296;
                if (iCharAt12 >= 55296) {
                    int i73 = iCharAt12 & 8191;
                    int i74 = 13;
                    while (true) {
                        i25 = i72 + 1;
                        cCharAt10 = strZzd.charAt(i72);
                        if (cCharAt10 < c2) {
                            break;
                        }
                        i73 |= (cCharAt10 & 8191) << i74;
                        i74 += 13;
                        i72 = i25;
                        c2 = 55296;
                    }
                    iCharAt12 = i73 | (cCharAt10 << i74);
                    i72 = i25;
                }
                int i75 = i71 - 51;
                int i76 = i72;
                if (i75 == 9 || i75 == 17) {
                    int i77 = i60 / 3;
                    i22 = i2 + 1;
                    objArr[i77 + i77 + 1] = objArrZze[i2];
                } else {
                    if (i75 == 12 && (zzdoVar.zzc() == 1 || (iCharAt11 & 2048) != 0)) {
                        int i78 = i60 / 3;
                        i22 = i2 + 1;
                        objArr[i78 + i78 + 1] = objArrZze[i2];
                    }
                    i23 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i23];
                    if (obj instanceof Field) {
                        fieldZzF2 = (Field) obj;
                    } else {
                        fieldZzF2 = zzF(cls2, (String) obj);
                        objArrZze[i23] = fieldZzF2;
                    }
                    int i79 = i3;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzF2);
                    i24 = i23 + 1;
                    obj2 = objArrZze[i24];
                    if (obj2 instanceof Field) {
                        fieldZzF3 = (Field) obj2;
                    } else {
                        fieldZzF3 = zzF(cls2, (String) obj2);
                        objArrZze[i24] = fieldZzF3;
                    }
                    strZzd = strZzd;
                    i17 = i79;
                    i18 = i2;
                    i19 = i76;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzF3);
                    i20 = 0;
                }
                i2 = i22;
                i23 = iCharAt12 + iCharAt12;
                obj = objArrZze[i23];
                if (obj instanceof Field) {
                    fieldZzF2 = (Field) obj;
                } else {
                    fieldZzF2 = zzF(cls2, (String) obj);
                    objArrZze[i23] = fieldZzF2;
                }
                int i710 = i3;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzF2);
                i24 = i23 + 1;
                obj2 = objArrZze[i24];
                if (obj2 instanceof Field) {
                    fieldZzF3 = (Field) obj2;
                } else {
                    fieldZzF3 = zzF(cls2, (String) obj2);
                    objArrZze[i24] = fieldZzF3;
                }
                strZzd = strZzd;
                i17 = i710;
                i18 = i2;
                i19 = i76;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzF3);
                i20 = 0;
            } else {
                i17 = i3;
                i18 = i2 + 1;
                Field fieldZzF4 = zzF(cls2, (String) objArrZze[i2]);
                if (i71 == 9 || i71 == 17) {
                    i17 = i17;
                    int i80 = i60 / 3;
                    objArr[i80 + i80 + 1] = fieldZzF4.getType();
                } else {
                    if (i71 == 27 || i71 == 49) {
                        i17 = i17;
                        int i81 = i60 / 3;
                        i21 = i2 + 2;
                        objArr[i81 + i81 + 1] = objArrZze[i18];
                    } else if (i71 == 12 || i71 == 30 || i71 == 44) {
                        i17 = i17;
                        if (zzdoVar.zzc() == 1 || (iCharAt11 & 2048) != 0) {
                            int i82 = i60 / 3;
                            i21 = i2 + 2;
                            objArr[i82 + i82 + 1] = objArrZze[i18];
                        }
                    } else if (i71 == 50) {
                        int i83 = i61 + 1;
                        iArr[i61] = i60;
                        int i84 = i60 / 3;
                        int i85 = i2 + 2;
                        int i86 = i84 + i84;
                        objArr[i86] = objArrZze[i18];
                        if ((iCharAt11 & 2048) != 0) {
                            i18 = i2 + 3;
                            objArr[i86 + 1] = objArrZze[i85];
                            i61 = i83;
                        } else {
                            i61 = i83;
                            i18 = i85;
                        }
                    }
                    i18 = i21;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzF4);
                iObjectFieldOffset = 1048575;
                if ((iCharAt11 & 4096) == 0 || i71 > 17) {
                    i19 = i16;
                    i20 = 0;
                } else {
                    int i87 = i16 + 1;
                    int iCharAt13 = strZzd.charAt(i16);
                    if (iCharAt13 >= 55296) {
                        int i88 = iCharAt13 & 8191;
                        int i89 = 13;
                        while (true) {
                            i19 = i87 + 1;
                            cCharAt9 = strZzd.charAt(i87);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i88 |= (cCharAt9 & 8191) << i89;
                            i89 += 13;
                            i87 = i19;
                        }
                        iCharAt13 = i88 | (cCharAt9 << i89);
                    } else {
                        i19 = i87;
                    }
                    int i90 = i5 + i5 + (iCharAt13 / 32);
                    Object obj3 = objArrZze[i90];
                    if (obj3 instanceof Field) {
                        fieldZzF = (Field) obj3;
                    } else {
                        fieldZzF = zzF(cls2, (String) obj3);
                        objArrZze[i90] = fieldZzF;
                    }
                    i20 = iCharAt13 % 32;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzF);
                }
                if (i71 >= 18 && i71 <= 49) {
                    iArr[i62] = iObjectFieldOffset3;
                    i62++;
                }
                iObjectFieldOffset2 = iObjectFieldOffset3;
            }
            int i91 = i60 + 1;
            iArr2[i60] = iCharAt10;
            int i92 = i60 + 2;
            iArr2[i91] = iObjectFieldOffset2 | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | ((iCharAt11 & 512) != 0 ? 536870912 : 0) | (i71 << 20);
            i60 += 3;
            iArr2[i92] = (i20 << 20) | iObjectFieldOffset;
            i2 = i18;
            i30 = i19;
            length = length;
            i3 = i17;
            strZzd = strZzd;
            i6 = i6;
            c = 55296;
        }
        return new zzdi(iArr2, objArr, i3, i6, zzdoVar.zza(), zzdoVar.zzc(), false, iArr, i4, i57, zzdkVar, zzctVar, zzegVar, zzboVar, zzdaVar);
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzeq.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzeq.zzf(obj, j)).floatValue();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final int zzo(Object obj) {
        int i;
        int iZzx;
        int iZzx2;
        int iZzy;
        int iZzx3;
        int iZzx4;
        int iZzx5;
        int iZzx6;
        int iZzt;
        boolean z;
        int iZzc;
        int iZzh;
        int iZzx7;
        int iZzx8;
        int iZzx9;
        int iZzx10;
        int iZzx11;
        int iZzx12;
        int iZzx13;
        Unsafe unsafe = zzb;
        int i2 = 1048575;
        int i3 = 1048575;
        int i4 = 0;
        int iZzx14 = 0;
        int i5 = 0;
        while (i4 < this.zzc.length) {
            int iZzy2 = zzy(i4);
            int[] iArr = this.zzc;
            int i6 = iArr[i4];
            int iZzx15 = zzx(iZzy2);
            if (iZzx15 <= 17) {
                int i7 = iArr[i4 + 2];
                int i8 = i7 & i2;
                int i9 = i7 >>> 20;
                if (i8 != i3) {
                    i5 = unsafe.getInt(obj, i8);
                    i3 = i8;
                }
                i = 1 << i9;
            } else {
                i = 0;
            }
            long j = iZzy2 & i2;
            switch (iZzx15) {
                case 0:
                    if ((i5 & i) != 0) {
                        iZzx = zzbi.zzx(i6 << 3);
                        iZzx4 = iZzx + 8;
                        iZzx14 += iZzx4;
                    }
                    break;
                case 1:
                    if ((i5 & i) != 0) {
                        iZzx2 = zzbi.zzx(i6 << 3);
                        iZzx4 = iZzx2 + 4;
                        iZzx14 += iZzx4;
                    }
                    break;
                case 2:
                    if ((i5 & i) != 0) {
                        iZzy = zzbi.zzy(unsafe.getLong(obj, j));
                        iZzx3 = zzbi.zzx(i6 << 3);
                        iZzx14 += iZzx3 + iZzy;
                    }
                    break;
                case 3:
                    if ((i5 & i) != 0) {
                        iZzy = zzbi.zzy(unsafe.getLong(obj, j));
                        iZzx3 = zzbi.zzx(i6 << 3);
                        iZzx14 += iZzx3 + iZzy;
                    }
                    break;
                case 4:
                    if ((i5 & i) != 0) {
                        iZzy = zzbi.zzu(unsafe.getInt(obj, j));
                        iZzx3 = zzbi.zzx(i6 << 3);
                        iZzx14 += iZzx3 + iZzy;
                    }
                    break;
                case 5:
                    if ((i5 & i) != 0) {
                        iZzx = zzbi.zzx(i6 << 3);
                        iZzx4 = iZzx + 8;
                        iZzx14 += iZzx4;
                    }
                    break;
                case 6:
                    if ((i5 & i) != 0) {
                        iZzx2 = zzbi.zzx(i6 << 3);
                        iZzx4 = iZzx2 + 4;
                        iZzx14 += iZzx4;
                    }
                    break;
                case 7:
                    if ((i5 & i) != 0) {
                        iZzx4 = zzbi.zzx(i6 << 3) + 1;
                        iZzx14 += iZzx4;
                    }
                    break;
                case 8:
                    if ((i5 & i) != 0) {
                        Object object = unsafe.getObject(obj, j);
                        if (!(object instanceof zzba)) {
                            iZzy = zzbi.zzw((String) object);
                            iZzx3 = zzbi.zzx(i6 << 3);
                            iZzx14 += iZzx3 + iZzy;
                        } else {
                            int i10 = zzbi.zzb;
                            int iZzd = ((zzba) object).zzd();
                            iZzx5 = zzbi.zzx(iZzd) + iZzd;
                            iZzx6 = zzbi.zzx(i6 << 3);
                            iZzx4 = iZzx6 + iZzx5;
                            iZzx14 += iZzx4;
                        }
                    }
                    break;
                case 9:
                    if ((i5 & i) != 0) {
                        iZzx4 = zzdr.zzn(i6, unsafe.getObject(obj, j), zzB(i4));
                        iZzx14 += iZzx4;
                    }
                    break;
                case 10:
                    if ((i5 & i) != 0) {
                        zzba zzbaVar = (zzba) unsafe.getObject(obj, j);
                        int i11 = zzbi.zzb;
                        int iZzd2 = zzbaVar.zzd();
                        iZzx5 = zzbi.zzx(iZzd2) + iZzd2;
                        iZzx6 = zzbi.zzx(i6 << 3);
                        iZzx4 = iZzx6 + iZzx5;
                        iZzx14 += iZzx4;
                    }
                    break;
                case 11:
                    if ((i5 & i) != 0) {
                        iZzy = zzbi.zzx(unsafe.getInt(obj, j));
                        iZzx3 = zzbi.zzx(i6 << 3);
                        iZzx14 += iZzx3 + iZzy;
                    }
                    break;
                case 12:
                    if ((i5 & i) != 0) {
                        iZzy = zzbi.zzu(unsafe.getInt(obj, j));
                        iZzx3 = zzbi.zzx(i6 << 3);
                        iZzx14 += iZzx3 + iZzy;
                    }
                    break;
                case 13:
                    if ((i5 & i) != 0) {
                        iZzx2 = zzbi.zzx(i6 << 3);
                        iZzx4 = iZzx2 + 4;
                        iZzx14 += iZzx4;
                    }
                    break;
                case 14:
                    if ((i5 & i) != 0) {
                        iZzx = zzbi.zzx(i6 << 3);
                        iZzx4 = iZzx + 8;
                        iZzx14 += iZzx4;
                    }
                    break;
                case 15:
                    if ((i5 & i) != 0) {
                        int i12 = unsafe.getInt(obj, j);
                        iZzx3 = zzbi.zzx(i6 << 3);
                        iZzy = zzbi.zzx((i12 >> 31) ^ (i12 + i12));
                        iZzx14 += iZzx3 + iZzy;
                    }
                    break;
                case 16:
                    if ((i & i5) != 0) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzx14 += zzbi.zzx(i6 << 3) + zzbi.zzy((j2 >> 63) ^ (j2 + j2));
                    }
                    break;
                case 17:
                    if ((i5 & i) != 0) {
                        iZzx4 = zzbi.zzt(i6, (zzdf) unsafe.getObject(obj, j), zzB(i4));
                        iZzx14 += iZzx4;
                    }
                    break;
                case 18:
                    iZzx4 = zzdr.zzg(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzx4;
                    break;
                case 19:
                    iZzx4 = zzdr.zze(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzx4;
                    break;
                case 20:
                    iZzx4 = zzdr.zzl(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzx4;
                    break;
                case 21:
                    iZzx4 = zzdr.zzw(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzx4;
                    break;
                case 22:
                    iZzx4 = zzdr.zzj(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzx4;
                    break;
                case 23:
                    iZzx4 = zzdr.zzg(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzx4;
                    break;
                case 24:
                    iZzx4 = zzdr.zze(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzx4;
                    break;
                case 25:
                    iZzx4 = zzdr.zza(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzx4;
                    break;
                case 26:
                    iZzt = zzdr.zzt(i6, (List) unsafe.getObject(obj, j));
                    iZzx14 += iZzt;
                    break;
                case 27:
                    iZzt = zzdr.zzo(i6, (List) unsafe.getObject(obj, j), zzB(i4));
                    iZzx14 += iZzt;
                    break;
                case 28:
                    iZzt = zzdr.zzb(i6, (List) unsafe.getObject(obj, j));
                    iZzx14 += iZzt;
                    break;
                case 29:
                    iZzt = zzdr.zzu(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzt;
                    break;
                case 30:
                    z = false;
                    iZzc = zzdr.zzc(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzc;
                    break;
                case 31:
                    z = false;
                    iZzc = zzdr.zze(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzc;
                    break;
                case 32:
                    z = false;
                    iZzc = zzdr.zzg(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzc;
                    break;
                case 33:
                    z = false;
                    iZzc = zzdr.zzp(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzc;
                    break;
                case 34:
                    z = false;
                    iZzc = zzdr.zzr(i6, (List) unsafe.getObject(obj, j), false);
                    iZzx14 += iZzc;
                    break;
                case 35:
                    iZzh = zzdr.zzh((List) unsafe.getObject(obj, j));
                    if (iZzh > 0) {
                        iZzx7 = zzbi.zzx(iZzh);
                        iZzx8 = zzbi.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 36:
                    iZzh = zzdr.zzf((List) unsafe.getObject(obj, j));
                    if (iZzh > 0) {
                        iZzx7 = zzbi.zzx(iZzh);
                        iZzx8 = zzbi.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 37:
                    iZzh = zzdr.zzm((List) unsafe.getObject(obj, j));
                    if (iZzh > 0) {
                        iZzx7 = zzbi.zzx(iZzh);
                        iZzx8 = zzbi.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 38:
                    iZzh = zzdr.zzx((List) unsafe.getObject(obj, j));
                    if (iZzh > 0) {
                        iZzx7 = zzbi.zzx(iZzh);
                        iZzx8 = zzbi.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 39:
                    iZzh = zzdr.zzk((List) unsafe.getObject(obj, j));
                    if (iZzh > 0) {
                        iZzx7 = zzbi.zzx(iZzh);
                        iZzx8 = zzbi.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 40:
                    iZzh = zzdr.zzh((List) unsafe.getObject(obj, j));
                    if (iZzh > 0) {
                        iZzx7 = zzbi.zzx(iZzh);
                        iZzx8 = zzbi.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 41:
                    iZzh = zzdr.zzf((List) unsafe.getObject(obj, j));
                    if (iZzh > 0) {
                        iZzx7 = zzbi.zzx(iZzh);
                        iZzx8 = zzbi.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 42:
                    List list = (List) unsafe.getObject(obj, j);
                    int i13 = zzdr.zza;
                    iZzh = list.size();
                    if (iZzh > 0) {
                        iZzx7 = zzbi.zzx(iZzh);
                        iZzx8 = zzbi.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 43:
                    iZzh = zzdr.zzv((List) unsafe.getObject(obj, j));
                    if (iZzh > 0) {
                        iZzx7 = zzbi.zzx(iZzh);
                        iZzx8 = zzbi.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 44:
                    iZzh = zzdr.zzd((List) unsafe.getObject(obj, j));
                    if (iZzh > 0) {
                        iZzx7 = zzbi.zzx(iZzh);
                        iZzx8 = zzbi.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 45:
                    iZzh = zzdr.zzf((List) unsafe.getObject(obj, j));
                    if (iZzh > 0) {
                        iZzx7 = zzbi.zzx(iZzh);
                        iZzx8 = zzbi.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 46:
                    iZzh = zzdr.zzh((List) unsafe.getObject(obj, j));
                    if (iZzh > 0) {
                        iZzx7 = zzbi.zzx(iZzh);
                        iZzx8 = zzbi.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 47:
                    iZzh = zzdr.zzq((List) unsafe.getObject(obj, j));
                    if (iZzh > 0) {
                        iZzx7 = zzbi.zzx(iZzh);
                        iZzx8 = zzbi.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                    iZzh = zzdr.zzs((List) unsafe.getObject(obj, j));
                    if (iZzh > 0) {
                        iZzx7 = zzbi.zzx(iZzh);
                        iZzx8 = zzbi.zzx(i6 << 3);
                        iZzx9 = iZzx8 + iZzx7;
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    iZzt = zzdr.zzi(i6, (List) unsafe.getObject(obj, j), zzB(i4));
                    iZzx14 += iZzt;
                    break;
                case 50:
                    zzda.zza(i6, unsafe.getObject(obj, j), zzC(i4));
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzT(obj, i6, i4)) {
                        iZzx10 = zzbi.zzx(i6 << 3);
                        iZzt = iZzx10 + 8;
                        iZzx14 += iZzt;
                    }
                    break;
                case 52:
                    if (zzT(obj, i6, i4)) {
                        iZzx11 = zzbi.zzx(i6 << 3);
                        iZzt = iZzx11 + 4;
                        iZzx14 += iZzt;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (zzT(obj, i6, i4)) {
                        iZzh = zzbi.zzy(zzz(obj, j));
                        iZzx9 = zzbi.zzx(i6 << 3);
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (zzT(obj, i6, i4)) {
                        iZzh = zzbi.zzy(zzz(obj, j));
                        iZzx9 = zzbi.zzx(i6 << 3);
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (zzT(obj, i6, i4)) {
                        iZzh = zzbi.zzu(zzp(obj, j));
                        iZzx9 = zzbi.zzx(i6 << 3);
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 56:
                    if (zzT(obj, i6, i4)) {
                        iZzx10 = zzbi.zzx(i6 << 3);
                        iZzt = iZzx10 + 8;
                        iZzx14 += iZzt;
                    }
                    break;
                case 57:
                    if (zzT(obj, i6, i4)) {
                        iZzx11 = zzbi.zzx(i6 << 3);
                        iZzt = iZzx11 + 4;
                        iZzx14 += iZzt;
                    }
                    break;
                case 58:
                    if (zzT(obj, i6, i4)) {
                        iZzt = zzbi.zzx(i6 << 3) + 1;
                        iZzx14 += iZzt;
                    }
                    break;
                case 59:
                    if (zzT(obj, i6, i4)) {
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzba) {
                            int i14 = zzbi.zzb;
                            int iZzd3 = ((zzba) object2).zzd();
                            iZzx12 = zzbi.zzx(iZzd3) + iZzd3;
                            iZzx13 = zzbi.zzx(i6 << 3);
                            iZzt = iZzx13 + iZzx12;
                            iZzx14 += iZzt;
                        } else {
                            iZzh = zzbi.zzw((String) object2);
                            iZzx9 = zzbi.zzx(i6 << 3);
                            iZzx14 += iZzx9 + iZzh;
                        }
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzT(obj, i6, i4)) {
                        iZzt = zzdr.zzn(i6, unsafe.getObject(obj, j), zzB(i4));
                        iZzx14 += iZzt;
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzT(obj, i6, i4)) {
                        zzba zzbaVar2 = (zzba) unsafe.getObject(obj, j);
                        int i15 = zzbi.zzb;
                        int iZzd4 = zzbaVar2.zzd();
                        iZzx12 = zzbi.zzx(iZzd4) + iZzd4;
                        iZzx13 = zzbi.zzx(i6 << 3);
                        iZzt = iZzx13 + iZzx12;
                        iZzx14 += iZzt;
                    }
                    break;
                case 62:
                    if (zzT(obj, i6, i4)) {
                        iZzh = zzbi.zzx(zzp(obj, j));
                        iZzx9 = zzbi.zzx(i6 << 3);
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzT(obj, i6, i4)) {
                        iZzh = zzbi.zzu(zzp(obj, j));
                        iZzx9 = zzbi.zzx(i6 << 3);
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 64:
                    if (zzT(obj, i6, i4)) {
                        iZzx11 = zzbi.zzx(i6 << 3);
                        iZzt = iZzx11 + 4;
                        iZzx14 += iZzt;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (zzT(obj, i6, i4)) {
                        iZzx10 = zzbi.zzx(i6 << 3);
                        iZzt = iZzx10 + 8;
                        iZzx14 += iZzt;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (zzT(obj, i6, i4)) {
                        int iZzp = zzp(obj, j);
                        iZzx9 = zzbi.zzx(i6 << 3);
                        iZzh = zzbi.zzx((iZzp >> 31) ^ (iZzp + iZzp));
                        iZzx14 += iZzx9 + iZzh;
                    }
                    break;
                case 67:
                    if (zzT(obj, i6, i4)) {
                        long jZzz = zzz(obj, j);
                        iZzx14 += zzbi.zzx(i6 << 3) + zzbi.zzy((jZzz >> 63) ^ (jZzz + jZzz));
                    }
                    break;
                case 68:
                    if (zzT(obj, i6, i4)) {
                        iZzt = zzbi.zzt(i6, (zzdf) unsafe.getObject(obj, j), zzB(i4));
                        iZzx14 += iZzt;
                    }
                    break;
                default:
                    break;
            }
            i4 += 3;
            i2 = 1048575;
        }
        zzeg zzegVar = this.zzm;
        int iZza = iZzx14 + zzegVar.zza(zzegVar.zzd(obj));
        if (!this.zzh) {
            return iZza;
        }
        this.zzn.zza(obj);
        throw null;
    }

    private static int zzp(Object obj, long j) {
        return ((Integer) zzeq.zzf(obj, j)).intValue();
    }

    private final int zzq(Object obj, byte[] bArr, int i, int i2, int i3, long j, zzan zzanVar) throws IOException {
        Unsafe unsafe = zzb;
        Object objZzC = zzC(i3);
        Object object = unsafe.getObject(obj, j);
        if (!((zzcz) object).zze()) {
            zzcz zzczVarZzb = zzcz.zza().zzb();
            zzda.zzb(zzczVarZzb, object);
            unsafe.putObject(obj, j, zzczVarZzb);
        }
        throw null;
    }

    private final int zzr(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzan zzanVar) throws IOException {
        Unsafe unsafe = zzb;
        long j2 = this.zzc[i8 + 2] & 1048575;
        switch (i7) {
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Double.valueOf(Double.longBitsToDouble(zzao.zzp(bArr, i))));
                int i9 = i + 8;
                unsafe.putInt(obj, j2, i4);
                return i9;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Float.valueOf(Float.intBitsToFloat(zzao.zzb(bArr, i))));
                int i10 = i + 4;
                unsafe.putInt(obj, j2, i4);
                return i10;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                if (i5 != 0) {
                    return i;
                }
                int iZzm = zzao.zzm(bArr, i, zzanVar);
                unsafe.putObject(obj, j, Long.valueOf(zzanVar.zzb));
                unsafe.putInt(obj, j2, i4);
                return iZzm;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                int iZzj = zzao.zzj(bArr, i, zzanVar);
                unsafe.putObject(obj, j, Integer.valueOf(zzanVar.zza));
                unsafe.putInt(obj, j2, i4);
                return iZzj;
            case 56:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Long.valueOf(zzao.zzp(bArr, i)));
                int i11 = i + 8;
                unsafe.putInt(obj, j2, i4);
                return i11;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Integer.valueOf(zzao.zzb(bArr, i)));
                int i12 = i + 4;
                unsafe.putInt(obj, j2, i4);
                return i12;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                int iZzm2 = zzao.zzm(bArr, i, zzanVar);
                unsafe.putObject(obj, j, Boolean.valueOf(zzanVar.zzb != 0));
                unsafe.putInt(obj, j2, i4);
                return iZzm2;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iZzj2 = zzao.zzj(bArr, i, zzanVar);
                int i13 = zzanVar.zza;
                if (i13 == 0) {
                    unsafe.putObject(obj, j, "");
                } else {
                    if ((i6 & 536870912) != 0 && !zzev.zze(bArr, iZzj2, iZzj2 + i13)) {
                        throw zzci.zzc();
                    }
                    unsafe.putObject(obj, j, new String(bArr, iZzj2, i13, zzcg.zzb));
                    iZzj2 += i13;
                }
                unsafe.putInt(obj, j2, i4);
                return iZzj2;
            case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                if (i5 != 2) {
                    return i;
                }
                Object objZzE = zzE(obj, i4, i8);
                int iZzo = zzao.zzo(objZzE, zzB(i8), bArr, i, i2, zzanVar);
                zzM(obj, i4, i8, objZzE);
                return iZzo;
            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                if (i5 != 2) {
                    return i;
                }
                int iZza = zzao.zza(bArr, i, zzanVar);
                unsafe.putObject(obj, j, zzanVar.zzc);
                unsafe.putInt(obj, j2, i4);
                return iZza;
            case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                if (i5 != 0) {
                    return i;
                }
                int iZzj3 = zzao.zzj(bArr, i, zzanVar);
                int i14 = zzanVar.zza;
                zzce zzceVarZzA = zzA(i8);
                if (zzceVarZzA == null || zzceVarZzA.zza(i14)) {
                    unsafe.putObject(obj, j, Integer.valueOf(i14));
                    unsafe.putInt(obj, j2, i4);
                } else {
                    zzd(obj).zzj(i3, Long.valueOf(i14));
                }
                return iZzj3;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                if (i5 != 0) {
                    return i;
                }
                int iZzj4 = zzao.zzj(bArr, i, zzanVar);
                unsafe.putObject(obj, j, Integer.valueOf(zzbe.zzb(zzanVar.zza)));
                unsafe.putInt(obj, j2, i4);
                return iZzj4;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                int iZzm3 = zzao.zzm(bArr, i, zzanVar);
                unsafe.putObject(obj, j, Long.valueOf(zzbe.zzc(zzanVar.zzb)));
                unsafe.putInt(obj, j2, i4);
                return iZzm3;
            case 68:
                if (i5 != 3) {
                    return i;
                }
                Object objZzE2 = zzE(obj, i4, i8);
                int iZzn = zzao.zzn(objZzE2, zzB(i8), bArr, i, i2, (i3 & (-8)) | 4, zzanVar);
                zzM(obj, i4, i8, objZzE2);
                return iZzn;
            default:
                return i;
        }
    }

    private final int zzs(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zzan zzanVar) throws IOException {
        int i8;
        int i9;
        int i10;
        int i11;
        int iZzl;
        int iZzj = i;
        Unsafe unsafe = zzb;
        zzcf zzcfVarZzd = (zzcf) unsafe.getObject(obj, j2);
        if (!zzcfVarZzd.zzc()) {
            int size = zzcfVarZzd.size();
            zzcfVarZzd = zzcfVarZzd.zzd(size == 0 ? 10 : size + size);
            unsafe.putObject(obj, j2, zzcfVarZzd);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    zzbk zzbkVar = (zzbk) zzcfVarZzd;
                    int iZzj2 = zzao.zzj(bArr, iZzj, zzanVar);
                    int i12 = zzanVar.zza + iZzj2;
                    while (iZzj2 < i12) {
                        zzbkVar.zze(Double.longBitsToDouble(zzao.zzp(bArr, iZzj2)));
                        iZzj2 += 8;
                    }
                    if (iZzj2 == i12) {
                        return iZzj2;
                    }
                    throw zzci.zzg();
                }
                if (i5 == 1) {
                    zzbk zzbkVar2 = (zzbk) zzcfVarZzd;
                    zzbkVar2.zze(Double.longBitsToDouble(zzao.zzp(bArr, i)));
                    while (true) {
                        i8 = iZzj + 8;
                        if (i8 < i2) {
                            iZzj = zzao.zzj(bArr, i8, zzanVar);
                            if (i3 == zzanVar.zza) {
                                zzbkVar2.zze(Double.longBitsToDouble(zzao.zzp(bArr, iZzj)));
                            }
                        }
                    }
                    return i8;
                }
                break;
            case 19:
            case 36:
                if (i5 == 2) {
                    zzbu zzbuVar = (zzbu) zzcfVarZzd;
                    int iZzj3 = zzao.zzj(bArr, iZzj, zzanVar);
                    int i13 = zzanVar.zza + iZzj3;
                    while (iZzj3 < i13) {
                        zzbuVar.zze(Float.intBitsToFloat(zzao.zzb(bArr, iZzj3)));
                        iZzj3 += 4;
                    }
                    if (iZzj3 == i13) {
                        return iZzj3;
                    }
                    throw zzci.zzg();
                }
                if (i5 == 5) {
                    zzbu zzbuVar2 = (zzbu) zzcfVarZzd;
                    zzbuVar2.zze(Float.intBitsToFloat(zzao.zzb(bArr, i)));
                    while (true) {
                        i9 = iZzj + 4;
                        if (i9 < i2) {
                            iZzj = zzao.zzj(bArr, i9, zzanVar);
                            if (i3 == zzanVar.zza) {
                                zzbuVar2.zze(Float.intBitsToFloat(zzao.zzb(bArr, iZzj)));
                            }
                        }
                    }
                    return i9;
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    zzcu zzcuVar = (zzcu) zzcfVarZzd;
                    int iZzj4 = zzao.zzj(bArr, iZzj, zzanVar);
                    int i14 = zzanVar.zza + iZzj4;
                    while (iZzj4 < i14) {
                        iZzj4 = zzao.zzm(bArr, iZzj4, zzanVar);
                        zzcuVar.zzf(zzanVar.zzb);
                    }
                    if (iZzj4 == i14) {
                        return iZzj4;
                    }
                    throw zzci.zzg();
                }
                if (i5 == 0) {
                    zzcu zzcuVar2 = (zzcu) zzcfVarZzd;
                    int iZzm = zzao.zzm(bArr, iZzj, zzanVar);
                    zzcuVar2.zzf(zzanVar.zzb);
                    while (iZzm < i2) {
                        int iZzj5 = zzao.zzj(bArr, iZzm, zzanVar);
                        if (i3 != zzanVar.zza) {
                            return iZzm;
                        }
                        iZzm = zzao.zzm(bArr, iZzj5, zzanVar);
                        zzcuVar2.zzf(zzanVar.zzb);
                    }
                    return iZzm;
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return zzao.zzf(bArr, iZzj, zzcfVarZzd, zzanVar);
                }
                if (i5 == 0) {
                    return zzao.zzl(i3, bArr, i, i2, zzcfVarZzd, zzanVar);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    zzcu zzcuVar3 = (zzcu) zzcfVarZzd;
                    int iZzj6 = zzao.zzj(bArr, iZzj, zzanVar);
                    int i15 = zzanVar.zza + iZzj6;
                    while (iZzj6 < i15) {
                        zzcuVar3.zzf(zzao.zzp(bArr, iZzj6));
                        iZzj6 += 8;
                    }
                    if (iZzj6 == i15) {
                        return iZzj6;
                    }
                    throw zzci.zzg();
                }
                if (i5 == 1) {
                    zzcu zzcuVar4 = (zzcu) zzcfVarZzd;
                    zzcuVar4.zzf(zzao.zzp(bArr, i));
                    while (true) {
                        i10 = iZzj + 8;
                        if (i10 < i2) {
                            iZzj = zzao.zzj(bArr, i10, zzanVar);
                            if (i3 == zzanVar.zza) {
                                zzcuVar4.zzf(zzao.zzp(bArr, iZzj));
                            }
                        }
                    }
                    return i10;
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    zzcc zzccVar = (zzcc) zzcfVarZzd;
                    int iZzj7 = zzao.zzj(bArr, iZzj, zzanVar);
                    int i16 = zzanVar.zza + iZzj7;
                    while (iZzj7 < i16) {
                        zzccVar.zzf(zzao.zzb(bArr, iZzj7));
                        iZzj7 += 4;
                    }
                    if (iZzj7 == i16) {
                        return iZzj7;
                    }
                    throw zzci.zzg();
                }
                if (i5 == 5) {
                    zzcc zzccVar2 = (zzcc) zzcfVarZzd;
                    zzccVar2.zzf(zzao.zzb(bArr, i));
                    while (true) {
                        i11 = iZzj + 4;
                        if (i11 < i2) {
                            iZzj = zzao.zzj(bArr, i11, zzanVar);
                            if (i3 == zzanVar.zza) {
                                zzccVar2.zzf(zzao.zzb(bArr, iZzj));
                            }
                        }
                    }
                    return i11;
                }
                break;
            case 25:
            case 42:
                if (i5 == 2) {
                    zzap zzapVar = (zzap) zzcfVarZzd;
                    int iZzj8 = zzao.zzj(bArr, iZzj, zzanVar);
                    int i17 = zzanVar.zza + iZzj8;
                    while (iZzj8 < i17) {
                        iZzj8 = zzao.zzm(bArr, iZzj8, zzanVar);
                        zzapVar.zze(zzanVar.zzb != 0);
                    }
                    if (iZzj8 == i17) {
                        return iZzj8;
                    }
                    throw zzci.zzg();
                }
                if (i5 == 0) {
                    zzap zzapVar2 = (zzap) zzcfVarZzd;
                    int iZzm2 = zzao.zzm(bArr, iZzj, zzanVar);
                    zzapVar2.zze(zzanVar.zzb != 0);
                    while (iZzm2 < i2) {
                        int iZzj9 = zzao.zzj(bArr, iZzm2, zzanVar);
                        if (i3 != zzanVar.zza) {
                            return iZzm2;
                        }
                        iZzm2 = zzao.zzm(bArr, iZzj9, zzanVar);
                        zzapVar2.zze(zzanVar.zzb != 0);
                    }
                    return iZzm2;
                }
                break;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int iZzj10 = zzao.zzj(bArr, iZzj, zzanVar);
                        int i18 = zzanVar.zza;
                        if (i18 < 0) {
                            throw zzci.zzd();
                        }
                        if (i18 == 0) {
                            zzcfVarZzd.add("");
                        } else {
                            zzcfVarZzd.add(new String(bArr, iZzj10, i18, zzcg.zzb));
                            iZzj10 += i18;
                        }
                        while (iZzj10 < i2) {
                            int iZzj11 = zzao.zzj(bArr, iZzj10, zzanVar);
                            if (i3 != zzanVar.zza) {
                                return iZzj10;
                            }
                            iZzj10 = zzao.zzj(bArr, iZzj11, zzanVar);
                            int i19 = zzanVar.zza;
                            if (i19 < 0) {
                                throw zzci.zzd();
                            }
                            if (i19 == 0) {
                                zzcfVarZzd.add("");
                            } else {
                                zzcfVarZzd.add(new String(bArr, iZzj10, i19, zzcg.zzb));
                                iZzj10 += i19;
                            }
                        }
                        return iZzj10;
                    }
                    int iZzj12 = zzao.zzj(bArr, iZzj, zzanVar);
                    int i20 = zzanVar.zza;
                    if (i20 < 0) {
                        throw zzci.zzd();
                    }
                    if (i20 == 0) {
                        zzcfVarZzd.add("");
                    } else {
                        int i21 = iZzj12 + i20;
                        if (!zzev.zze(bArr, iZzj12, i21)) {
                            throw zzci.zzc();
                        }
                        zzcfVarZzd.add(new String(bArr, iZzj12, i20, zzcg.zzb));
                        iZzj12 = i21;
                    }
                    while (iZzj12 < i2) {
                        int iZzj13 = zzao.zzj(bArr, iZzj12, zzanVar);
                        if (i3 != zzanVar.zza) {
                            return iZzj12;
                        }
                        iZzj12 = zzao.zzj(bArr, iZzj13, zzanVar);
                        int i22 = zzanVar.zza;
                        if (i22 < 0) {
                            throw zzci.zzd();
                        }
                        if (i22 == 0) {
                            zzcfVarZzd.add("");
                        } else {
                            int i23 = iZzj12 + i22;
                            if (!zzev.zze(bArr, iZzj12, i23)) {
                                throw zzci.zzc();
                            }
                            zzcfVarZzd.add(new String(bArr, iZzj12, i22, zzcg.zzb));
                            iZzj12 = i23;
                        }
                    }
                    return iZzj12;
                }
                break;
            case 27:
                if (i5 == 2) {
                    return zzao.zze(zzB(i6), i3, bArr, i, i2, zzcfVarZzd, zzanVar);
                }
                break;
            case 28:
                if (i5 == 2) {
                    int iZzj14 = zzao.zzj(bArr, iZzj, zzanVar);
                    int i24 = zzanVar.zza;
                    if (i24 < 0) {
                        throw zzci.zzd();
                    }
                    if (i24 > bArr.length - iZzj14) {
                        throw zzci.zzg();
                    }
                    if (i24 == 0) {
                        zzcfVarZzd.add(zzba.zzb);
                    } else {
                        zzcfVarZzd.add(zzba.zzl(bArr, iZzj14, i24));
                        iZzj14 += i24;
                    }
                    while (iZzj14 < i2) {
                        int iZzj15 = zzao.zzj(bArr, iZzj14, zzanVar);
                        if (i3 != zzanVar.zza) {
                            return iZzj14;
                        }
                        iZzj14 = zzao.zzj(bArr, iZzj15, zzanVar);
                        int i25 = zzanVar.zza;
                        if (i25 < 0) {
                            throw zzci.zzd();
                        }
                        if (i25 > bArr.length - iZzj14) {
                            throw zzci.zzg();
                        }
                        if (i25 == 0) {
                            zzcfVarZzd.add(zzba.zzb);
                        } else {
                            zzcfVarZzd.add(zzba.zzl(bArr, iZzj14, i25));
                            iZzj14 += i25;
                        }
                    }
                    return iZzj14;
                }
                break;
            case 30:
            case 44:
                if (i5 == 2) {
                    iZzl = zzao.zzf(bArr, iZzj, zzcfVarZzd, zzanVar);
                } else if (i5 == 0) {
                    iZzl = zzao.zzl(i3, bArr, i, i2, zzcfVarZzd, zzanVar);
                }
                zzce zzceVarZzA = zzA(i6);
                zzeg zzegVar = this.zzm;
                int i26 = zzdr.zza;
                if (zzceVarZzA != null) {
                    Object objZzA = null;
                    if (zzcfVarZzd instanceof RandomAccess) {
                        int size2 = zzcfVarZzd.size();
                        int i27 = 0;
                        for (int i28 = 0; i28 < size2; i28++) {
                            Integer num = (Integer) zzcfVarZzd.get(i28);
                            int iIntValue = num.intValue();
                            if (zzceVarZzA.zza(iIntValue)) {
                                if (i28 != i27) {
                                    zzcfVarZzd.set(i27, num);
                                }
                                i27++;
                            } else {
                                objZzA = zzdr.zzA(obj, i4, iIntValue, objZzA, zzegVar);
                            }
                        }
                        if (i27 != size2) {
                            zzcfVarZzd.subList(i27, size2).clear();
                            return iZzl;
                        }
                    } else {
                        Iterator it = zzcfVarZzd.iterator();
                        while (it.hasNext()) {
                            int iIntValue2 = ((Integer) it.next()).intValue();
                            if (!zzceVarZzA.zza(iIntValue2)) {
                                objZzA = zzdr.zzA(obj, i4, iIntValue2, objZzA, zzegVar);
                                it.remove();
                            }
                        }
                    }
                }
                return iZzl;
            case 33:
            case 47:
                if (i5 == 2) {
                    zzcc zzccVar3 = (zzcc) zzcfVarZzd;
                    int iZzj16 = zzao.zzj(bArr, iZzj, zzanVar);
                    int i29 = zzanVar.zza + iZzj16;
                    while (iZzj16 < i29) {
                        iZzj16 = zzao.zzj(bArr, iZzj16, zzanVar);
                        zzccVar3.zzf(zzbe.zzb(zzanVar.zza));
                    }
                    if (iZzj16 == i29) {
                        return iZzj16;
                    }
                    throw zzci.zzg();
                }
                if (i5 == 0) {
                    zzcc zzccVar4 = (zzcc) zzcfVarZzd;
                    int iZzj17 = zzao.zzj(bArr, iZzj, zzanVar);
                    zzccVar4.zzf(zzbe.zzb(zzanVar.zza));
                    while (iZzj17 < i2) {
                        int iZzj18 = zzao.zzj(bArr, iZzj17, zzanVar);
                        if (i3 != zzanVar.zza) {
                            return iZzj17;
                        }
                        iZzj17 = zzao.zzj(bArr, iZzj18, zzanVar);
                        zzccVar4.zzf(zzbe.zzb(zzanVar.zza));
                    }
                    return iZzj17;
                }
                break;
            case 34:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                if (i5 == 2) {
                    zzcu zzcuVar5 = (zzcu) zzcfVarZzd;
                    int iZzj19 = zzao.zzj(bArr, iZzj, zzanVar);
                    int i30 = zzanVar.zza + iZzj19;
                    while (iZzj19 < i30) {
                        iZzj19 = zzao.zzm(bArr, iZzj19, zzanVar);
                        zzcuVar5.zzf(zzbe.zzc(zzanVar.zzb));
                    }
                    if (iZzj19 == i30) {
                        return iZzj19;
                    }
                    throw zzci.zzg();
                }
                if (i5 == 0) {
                    zzcu zzcuVar6 = (zzcu) zzcfVarZzd;
                    int iZzm3 = zzao.zzm(bArr, iZzj, zzanVar);
                    zzcuVar6.zzf(zzbe.zzc(zzanVar.zzb));
                    while (iZzm3 < i2) {
                        int iZzj20 = zzao.zzj(bArr, iZzm3, zzanVar);
                        if (i3 != zzanVar.zza) {
                            return iZzm3;
                        }
                        iZzm3 = zzao.zzm(bArr, iZzj20, zzanVar);
                        zzcuVar6.zzf(zzbe.zzc(zzanVar.zzb));
                    }
                    return iZzm3;
                }
                break;
            default:
                if (i5 == 3) {
                    zzdp zzdpVarZzB = zzB(i6);
                    int i31 = (i3 & (-8)) | 4;
                    int iZzc = zzao.zzc(zzdpVarZzB, bArr, i, i2, i31, zzanVar);
                    zzcfVarZzd.add(zzanVar.zzc);
                    while (iZzc < i2) {
                        int iZzj21 = zzao.zzj(bArr, iZzc, zzanVar);
                        if (i3 != zzanVar.zza) {
                            return iZzc;
                        }
                        iZzc = zzao.zzc(zzdpVarZzB, bArr, iZzj21, i2, i31, zzanVar);
                        zzcfVarZzd.add(zzanVar.zzc);
                    }
                    return iZzc;
                }
                break;
        }
        return iZzj;
    }

    private final int zzt(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzw(i, 0);
    }

    private final int zzu(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzw(i, i2);
    }

    private final int zzv(int i) {
        return this.zzc[i + 2];
    }

    private final int zzw(int i, int i2) {
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

    private static int zzx(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzy(int i) {
        return this.zzc[i + 1];
    }

    private static long zzz(Object obj, long j) {
        return ((Long) zzeq.zzf(obj, j)).longValue();
    }

    @Override // com.google.android.gms.internal.play_billing.zzdp
    public final int zza(Object obj) {
        int iZzx;
        int iZzx2;
        int iZzy;
        int iZzx3;
        int iZzx4;
        int iZzx5;
        int iZzx6;
        int iZzn;
        int iZzx7;
        int iZzy2;
        int iZzx8;
        int iZzx9;
        zzew zzewVar = zzew.DOUBLE;
        if (this.zzo - 1 == 0) {
            return zzo(obj);
        }
        Unsafe unsafe = zzb;
        int i = 0;
        for (int i2 = 0; i2 < this.zzc.length; i2 += 3) {
            int iZzy3 = zzy(i2);
            int iZzx10 = zzx(iZzy3);
            int i3 = this.zzc[i2];
            int i4 = iZzy3 & 1048575;
            if (iZzx10 >= zzbt.DOUBLE_LIST_PACKED.zza() && iZzx10 <= zzbt.SINT64_LIST_PACKED.zza()) {
                int i5 = this.zzc[i2 + 2];
            }
            long j = i4;
            switch (iZzx10) {
                case 0:
                    if (zzP(obj, i2)) {
                        iZzx = zzbi.zzx(i3 << 3);
                        iZzn = iZzx + 8;
                        i += iZzn;
                    }
                    break;
                case 1:
                    if (zzP(obj, i2)) {
                        iZzx2 = zzbi.zzx(i3 << 3);
                        iZzn = iZzx2 + 4;
                        i += iZzn;
                    }
                    break;
                case 2:
                    if (zzP(obj, i2)) {
                        iZzy = zzbi.zzy(zzeq.zzd(obj, j));
                        iZzx3 = zzbi.zzx(i3 << 3);
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 3:
                    if (zzP(obj, i2)) {
                        iZzy = zzbi.zzy(zzeq.zzd(obj, j));
                        iZzx3 = zzbi.zzx(i3 << 3);
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 4:
                    if (zzP(obj, i2)) {
                        iZzy = zzbi.zzu(zzeq.zzc(obj, j));
                        iZzx3 = zzbi.zzx(i3 << 3);
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 5:
                    if (zzP(obj, i2)) {
                        iZzx = zzbi.zzx(i3 << 3);
                        iZzn = iZzx + 8;
                        i += iZzn;
                    }
                    break;
                case 6:
                    if (zzP(obj, i2)) {
                        iZzx2 = zzbi.zzx(i3 << 3);
                        iZzn = iZzx2 + 4;
                        i += iZzn;
                    }
                    break;
                case 7:
                    if (zzP(obj, i2)) {
                        iZzx4 = zzbi.zzx(i3 << 3);
                        iZzn = iZzx4 + 1;
                        i += iZzn;
                    }
                    break;
                case 8:
                    if (zzP(obj, i2)) {
                        Object objZzf = zzeq.zzf(obj, j);
                        if (objZzf instanceof zzba) {
                            int i6 = i3 << 3;
                            int i7 = zzbi.zzb;
                            int iZzd = ((zzba) objZzf).zzd();
                            iZzx5 = zzbi.zzx(iZzd) + iZzd;
                            iZzx6 = zzbi.zzx(i6);
                            iZzn = iZzx6 + iZzx5;
                            i += iZzn;
                        } else {
                            iZzy = zzbi.zzw((String) objZzf);
                            iZzx3 = zzbi.zzx(i3 << 3);
                            i += iZzx3 + iZzy;
                        }
                    }
                    break;
                case 9:
                    if (zzP(obj, i2)) {
                        iZzn = zzdr.zzn(i3, zzeq.zzf(obj, j), zzB(i2));
                        i += iZzn;
                    }
                    break;
                case 10:
                    if (zzP(obj, i2)) {
                        zzba zzbaVar = (zzba) zzeq.zzf(obj, j);
                        int i8 = i3 << 3;
                        int i9 = zzbi.zzb;
                        int iZzd2 = zzbaVar.zzd();
                        iZzx5 = zzbi.zzx(iZzd2) + iZzd2;
                        iZzx6 = zzbi.zzx(i8);
                        iZzn = iZzx6 + iZzx5;
                        i += iZzn;
                    }
                    break;
                case 11:
                    if (zzP(obj, i2)) {
                        iZzy = zzbi.zzx(zzeq.zzc(obj, j));
                        iZzx3 = zzbi.zzx(i3 << 3);
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 12:
                    if (zzP(obj, i2)) {
                        iZzy = zzbi.zzu(zzeq.zzc(obj, j));
                        iZzx3 = zzbi.zzx(i3 << 3);
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 13:
                    if (zzP(obj, i2)) {
                        iZzx2 = zzbi.zzx(i3 << 3);
                        iZzn = iZzx2 + 4;
                        i += iZzn;
                    }
                    break;
                case 14:
                    if (zzP(obj, i2)) {
                        iZzx = zzbi.zzx(i3 << 3);
                        iZzn = iZzx + 8;
                        i += iZzn;
                    }
                    break;
                case 15:
                    if (zzP(obj, i2)) {
                        int iZzc = zzeq.zzc(obj, j);
                        iZzx3 = zzbi.zzx(i3 << 3);
                        iZzy = zzbi.zzx((iZzc >> 31) ^ (iZzc + iZzc));
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 16:
                    if (zzP(obj, i2)) {
                        long jZzd = zzeq.zzd(obj, j);
                        iZzx7 = zzbi.zzx(i3 << 3);
                        iZzy2 = zzbi.zzy((jZzd + jZzd) ^ (jZzd >> 63));
                        iZzn = iZzx7 + iZzy2;
                        i += iZzn;
                    }
                    break;
                case 17:
                    if (zzP(obj, i2)) {
                        iZzn = zzbi.zzt(i3, (zzdf) zzeq.zzf(obj, j), zzB(i2));
                        i += iZzn;
                    }
                    break;
                case 18:
                    iZzn = zzdr.zzg(i3, (List) zzeq.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 19:
                    iZzn = zzdr.zze(i3, (List) zzeq.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 20:
                    iZzn = zzdr.zzl(i3, (List) zzeq.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 21:
                    iZzn = zzdr.zzw(i3, (List) zzeq.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 22:
                    iZzn = zzdr.zzj(i3, (List) zzeq.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 23:
                    iZzn = zzdr.zzg(i3, (List) zzeq.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 24:
                    iZzn = zzdr.zze(i3, (List) zzeq.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 25:
                    iZzn = zzdr.zza(i3, (List) zzeq.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 26:
                    iZzn = zzdr.zzt(i3, (List) zzeq.zzf(obj, j));
                    i += iZzn;
                    break;
                case 27:
                    iZzn = zzdr.zzo(i3, (List) zzeq.zzf(obj, j), zzB(i2));
                    i += iZzn;
                    break;
                case 28:
                    iZzn = zzdr.zzb(i3, (List) zzeq.zzf(obj, j));
                    i += iZzn;
                    break;
                case 29:
                    iZzn = zzdr.zzu(i3, (List) zzeq.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 30:
                    iZzn = zzdr.zzc(i3, (List) zzeq.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 31:
                    iZzn = zzdr.zze(i3, (List) zzeq.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 32:
                    iZzn = zzdr.zzg(i3, (List) zzeq.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 33:
                    iZzn = zzdr.zzp(i3, (List) zzeq.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 34:
                    iZzn = zzdr.zzr(i3, (List) zzeq.zzf(obj, j), false);
                    i += iZzn;
                    break;
                case 35:
                    iZzy = zzdr.zzh((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        int i10 = i3 << 3;
                        iZzx8 = zzbi.zzx(iZzy);
                        iZzx9 = zzbi.zzx(i10);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 36:
                    iZzy = zzdr.zzf((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        int i11 = i3 << 3;
                        iZzx8 = zzbi.zzx(iZzy);
                        iZzx9 = zzbi.zzx(i11);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 37:
                    iZzy = zzdr.zzm((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        int i12 = i3 << 3;
                        iZzx8 = zzbi.zzx(iZzy);
                        iZzx9 = zzbi.zzx(i12);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 38:
                    iZzy = zzdr.zzx((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        int i13 = i3 << 3;
                        iZzx8 = zzbi.zzx(iZzy);
                        iZzx9 = zzbi.zzx(i13);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 39:
                    iZzy = zzdr.zzk((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        int i14 = i3 << 3;
                        iZzx8 = zzbi.zzx(iZzy);
                        iZzx9 = zzbi.zzx(i14);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 40:
                    iZzy = zzdr.zzh((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        int i15 = i3 << 3;
                        iZzx8 = zzbi.zzx(iZzy);
                        iZzx9 = zzbi.zzx(i15);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 41:
                    iZzy = zzdr.zzf((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        int i16 = i3 << 3;
                        iZzx8 = zzbi.zzx(iZzy);
                        iZzx9 = zzbi.zzx(i16);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 42:
                    List list = (List) unsafe.getObject(obj, j);
                    int i17 = zzdr.zza;
                    iZzy = list.size();
                    if (iZzy > 0) {
                        int i18 = i3 << 3;
                        iZzx8 = zzbi.zzx(iZzy);
                        iZzx9 = zzbi.zzx(i18);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 43:
                    iZzy = zzdr.zzv((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        int i19 = i3 << 3;
                        iZzx8 = zzbi.zzx(iZzy);
                        iZzx9 = zzbi.zzx(i19);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 44:
                    iZzy = zzdr.zzd((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        int i20 = i3 << 3;
                        iZzx8 = zzbi.zzx(iZzy);
                        iZzx9 = zzbi.zzx(i20);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 45:
                    iZzy = zzdr.zzf((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        int i21 = i3 << 3;
                        iZzx8 = zzbi.zzx(iZzy);
                        iZzx9 = zzbi.zzx(i21);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 46:
                    iZzy = zzdr.zzh((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        int i22 = i3 << 3;
                        iZzx8 = zzbi.zzx(iZzy);
                        iZzx9 = zzbi.zzx(i22);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 47:
                    iZzy = zzdr.zzq((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        int i23 = i3 << 3;
                        iZzx8 = zzbi.zzx(iZzy);
                        iZzx9 = zzbi.zzx(i23);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                    iZzy = zzdr.zzs((List) unsafe.getObject(obj, j));
                    if (iZzy > 0) {
                        int i24 = i3 << 3;
                        iZzx8 = zzbi.zzx(iZzy);
                        iZzx9 = zzbi.zzx(i24);
                        iZzx3 = iZzx9 + iZzx8;
                        i += iZzx3 + iZzy;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    iZzn = zzdr.zzi(i3, (List) zzeq.zzf(obj, j), zzB(i2));
                    i += iZzn;
                    break;
                case 50:
                    zzda.zza(i3, zzeq.zzf(obj, j), zzC(i2));
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzT(obj, i3, i2)) {
                        iZzx = zzbi.zzx(i3 << 3);
                        iZzn = iZzx + 8;
                        i += iZzn;
                    }
                    break;
                case 52:
                    if (zzT(obj, i3, i2)) {
                        iZzx2 = zzbi.zzx(i3 << 3);
                        iZzn = iZzx2 + 4;
                        i += iZzn;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (zzT(obj, i3, i2)) {
                        iZzy = zzbi.zzy(zzz(obj, j));
                        iZzx3 = zzbi.zzx(i3 << 3);
                        i += iZzx3 + iZzy;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (zzT(obj, i3, i2)) {
                        iZzy = zzbi.zzy(zzz(obj, j));
                        iZzx3 = zzbi.zzx(i3 << 3);
                        i += iZzx3 + iZzy;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (zzT(obj, i3, i2)) {
                        iZzy = zzbi.zzu(zzp(obj, j));
                        iZzx3 = zzbi.zzx(i3 << 3);
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 56:
                    if (zzT(obj, i3, i2)) {
                        iZzx = zzbi.zzx(i3 << 3);
                        iZzn = iZzx + 8;
                        i += iZzn;
                    }
                    break;
                case 57:
                    if (zzT(obj, i3, i2)) {
                        iZzx2 = zzbi.zzx(i3 << 3);
                        iZzn = iZzx2 + 4;
                        i += iZzn;
                    }
                    break;
                case 58:
                    if (zzT(obj, i3, i2)) {
                        iZzx4 = zzbi.zzx(i3 << 3);
                        iZzn = iZzx4 + 1;
                        i += iZzn;
                    }
                    break;
                case 59:
                    if (zzT(obj, i3, i2)) {
                        Object objZzf2 = zzeq.zzf(obj, j);
                        if (objZzf2 instanceof zzba) {
                            int i25 = i3 << 3;
                            int i26 = zzbi.zzb;
                            int iZzd3 = ((zzba) objZzf2).zzd();
                            iZzx5 = zzbi.zzx(iZzd3) + iZzd3;
                            iZzx6 = zzbi.zzx(i25);
                            iZzn = iZzx6 + iZzx5;
                            i += iZzn;
                        } else {
                            iZzy = zzbi.zzw((String) objZzf2);
                            iZzx3 = zzbi.zzx(i3 << 3);
                            i += iZzx3 + iZzy;
                        }
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzT(obj, i3, i2)) {
                        iZzn = zzdr.zzn(i3, zzeq.zzf(obj, j), zzB(i2));
                        i += iZzn;
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzT(obj, i3, i2)) {
                        zzba zzbaVar2 = (zzba) zzeq.zzf(obj, j);
                        int i27 = i3 << 3;
                        int i28 = zzbi.zzb;
                        int iZzd4 = zzbaVar2.zzd();
                        iZzx5 = zzbi.zzx(iZzd4) + iZzd4;
                        iZzx6 = zzbi.zzx(i27);
                        iZzn = iZzx6 + iZzx5;
                        i += iZzn;
                    }
                    break;
                case 62:
                    if (zzT(obj, i3, i2)) {
                        iZzy = zzbi.zzx(zzp(obj, j));
                        iZzx3 = zzbi.zzx(i3 << 3);
                        i += iZzx3 + iZzy;
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzT(obj, i3, i2)) {
                        iZzy = zzbi.zzu(zzp(obj, j));
                        iZzx3 = zzbi.zzx(i3 << 3);
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 64:
                    if (zzT(obj, i3, i2)) {
                        iZzx2 = zzbi.zzx(i3 << 3);
                        iZzn = iZzx2 + 4;
                        i += iZzn;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (zzT(obj, i3, i2)) {
                        iZzx = zzbi.zzx(i3 << 3);
                        iZzn = iZzx + 8;
                        i += iZzn;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (zzT(obj, i3, i2)) {
                        int iZzp = zzp(obj, j);
                        iZzx3 = zzbi.zzx(i3 << 3);
                        iZzy = zzbi.zzx((iZzp >> 31) ^ (iZzp + iZzp));
                        i += iZzx3 + iZzy;
                    }
                    break;
                case 67:
                    if (zzT(obj, i3, i2)) {
                        long jZzz = zzz(obj, j);
                        iZzx7 = zzbi.zzx(i3 << 3);
                        iZzy2 = zzbi.zzy((jZzz + jZzz) ^ (jZzz >> 63));
                        iZzn = iZzx7 + iZzy2;
                        i += iZzn;
                    }
                    break;
                case 68:
                    if (zzT(obj, i3, i2)) {
                        iZzn = zzbi.zzt(i3, (zzdf) zzeq.zzf(obj, j), zzB(i2));
                        i += iZzn;
                    }
                    break;
            }
        }
        zzeg zzegVar = this.zzm;
        return i + zzegVar.zza(zzegVar.zzd(obj));
    }

    @Override // com.google.android.gms.internal.play_billing.zzdp
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzy = zzy(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & iZzy;
            int iHashCode = 37;
            switch (zzx(iZzy)) {
                case 0:
                    i = i2 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzeq.zza(obj, j));
                    byte[] bArr = zzcg.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i2 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzeq.zzb(obj, j));
                    i2 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i2 * 53;
                    jDoubleToLongBits = zzeq.zzd(obj, j);
                    byte[] bArr2 = zzcg.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i2 * 53;
                    jDoubleToLongBits = zzeq.zzd(obj, j);
                    byte[] bArr3 = zzcg.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i2 * 53;
                    iFloatToIntBits = zzeq.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i2 * 53;
                    jDoubleToLongBits = zzeq.zzd(obj, j);
                    byte[] bArr4 = zzcg.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i2 * 53;
                    iFloatToIntBits = zzeq.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i2 * 53;
                    iFloatToIntBits = zzcg.zza(zzeq.zzw(obj, j));
                    i2 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i2 * 53;
                    iFloatToIntBits = ((String) zzeq.zzf(obj, j)).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 9:
                    Object objZzf = zzeq.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iFloatToIntBits = zzeq.zzf(obj, j).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i2 * 53;
                    iFloatToIntBits = zzeq.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i2 * 53;
                    iFloatToIntBits = zzeq.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i2 * 53;
                    iFloatToIntBits = zzeq.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i2 * 53;
                    jDoubleToLongBits = zzeq.zzd(obj, j);
                    byte[] bArr5 = zzcg.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i2 * 53;
                    iFloatToIntBits = zzeq.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i2 * 53;
                    jDoubleToLongBits = zzeq.zzd(obj, j);
                    byte[] bArr6 = zzcg.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 17:
                    Object objZzf2 = zzeq.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
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
                    i = i2 * 53;
                    iFloatToIntBits = zzeq.zzf(obj, j).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i2 * 53;
                    iFloatToIntBits = zzeq.zzf(obj, j).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                        byte[] bArr7 = zzcg.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzn(obj, j));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzz(obj, j);
                        byte[] bArr8 = zzcg.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzz(obj, j);
                        byte[] bArr9 = zzcg.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzz(obj, j);
                        byte[] bArr10 = zzcg.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzcg.zza(zzU(obj, j));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = ((String) zzeq.zzf(obj, j)).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzeq.zzf(obj, j).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzeq.zzf(obj, j).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzz(obj, j);
                        byte[] bArr11 = zzcg.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzz(obj, j);
                        byte[] bArr12 = zzcg.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzT(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzeq.zzf(obj, j).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
            }
        }
        int iHashCode2 = (i2 * 53) + this.zzm.zzd(obj).hashCode();
        if (!this.zzh) {
            return iHashCode2;
        }
        this.zzn.zza(obj);
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:110:0x0310 A[PHI: r0 r19 r22 r27 r31
  0x0310: PHI (r0v81 int) = (r0v75 int), (r0v78 int), (r0v83 int) binds: [B:122:0x0388, B:118:0x0360, B:109:0x030e] A[DONT_GENERATE, DONT_INLINE]
  0x0310: PHI (r19v5 int) = (r19v3 int), (r19v3 int), (r19v6 int) binds: [B:122:0x0388, B:118:0x0360, B:109:0x030e] A[DONT_GENERATE, DONT_INLINE]
  0x0310: PHI (r22v6 int) = (r22v4 int), (r22v4 int), (r22v8 int) binds: [B:122:0x0388, B:118:0x0360, B:109:0x030e] A[DONT_GENERATE, DONT_INLINE]
  0x0310: PHI (r27v8 sun.misc.Unsafe) = (r27v6 sun.misc.Unsafe), (r27v6 sun.misc.Unsafe), (r27v9 sun.misc.Unsafe) binds: [B:122:0x0388, B:118:0x0360, B:109:0x030e] A[DONT_GENERATE, DONT_INLINE]
  0x0310: PHI (r31v6 int) = (r31v4 int), (r31v4 int), (r31v7 int) binds: [B:122:0x0388, B:118:0x0360, B:109:0x030e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:112:0x032c A[PHI: r0 r19 r22 r27 r31
  0x032c: PHI (r0v79 int) = (r0v75 int), (r0v78 int), (r0v83 int) binds: [B:122:0x0388, B:118:0x0360, B:109:0x030e] A[DONT_GENERATE, DONT_INLINE]
  0x032c: PHI (r19v4 int) = (r19v3 int), (r19v3 int), (r19v6 int) binds: [B:122:0x0388, B:118:0x0360, B:109:0x030e] A[DONT_GENERATE, DONT_INLINE]
  0x032c: PHI (r22v5 int) = (r22v4 int), (r22v4 int), (r22v8 int) binds: [B:122:0x0388, B:118:0x0360, B:109:0x030e] A[DONT_GENERATE, DONT_INLINE]
  0x032c: PHI (r27v7 sun.misc.Unsafe) = (r27v6 sun.misc.Unsafe), (r27v6 sun.misc.Unsafe), (r27v9 sun.misc.Unsafe) binds: [B:122:0x0388, B:118:0x0360, B:109:0x030e] A[DONT_GENERATE, DONT_INLINE]
  0x032c: PHI (r31v5 int) = (r31v4 int), (r31v4 int), (r31v7 int) binds: [B:122:0x0388, B:118:0x0360, B:109:0x030e] A[DONT_GENERATE, DONT_INLINE]] */
    final int zzc(Object obj, byte[] bArr, int i, int i2, int i3, zzan zzanVar) throws IOException {
        Unsafe unsafe;
        int i4;
        Object obj2;
        zzdi<T> zzdiVar;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        zzan zzanVar2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        zzdi<T> zzdiVar2 = this;
        Object obj3 = obj;
        bArr = bArr;
        i2 = i2;
        int i24 = i3;
        zzan zzanVar3 = zzanVar;
        zzG(obj);
        Unsafe unsafe2 = zzb;
        int i25 = -1;
        int iZzi = i;
        int i26 = -1;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i30 = 1048575;
        while (true) {
            if (iZzi < i2) {
                int i31 = iZzi + 1;
                byte b = bArr[iZzi];
                if (b < 0) {
                    int iZzk = zzao.zzk(b, bArr, i31, zzanVar3);
                    i5 = zzanVar3.zza;
                    i31 = iZzk;
                } else {
                    i5 = b;
                }
                int i32 = i5 >>> 3;
                int iZzu = i32 > i26 ? zzdiVar2.zzu(i32, i27 / 3) : zzdiVar2.zzt(i32);
                if (iZzu == i25) {
                    i6 = i32;
                    i7 = i31;
                    i8 = i5;
                    i9 = i29;
                    i10 = i25;
                    unsafe = unsafe2;
                    i11 = i24;
                    i12 = 0;
                } else {
                    int i33 = i5 & 7;
                    int[] iArr = zzdiVar2.zzc;
                    int i34 = iArr[iZzu + 1];
                    int iZzx = zzx(i34);
                    int i35 = i31;
                    int i36 = i5;
                    long j = i34 & 1048575;
                    if (iZzx <= 17) {
                        int i37 = iArr[iZzu + 2];
                        int i38 = 1 << (i37 >>> 20);
                        int i39 = i37 & 1048575;
                        if (i39 != i30) {
                            if (i30 != 1048575) {
                                unsafe2.putInt(obj3, i30, i29);
                            }
                            i30 = i39;
                            i13 = unsafe2.getInt(obj3, i39);
                        } else {
                            i13 = i29;
                            i30 = i30;
                        }
                        switch (iZzx) {
                            case 0:
                                i14 = iZzu;
                                i15 = i32;
                                i16 = i35;
                                if (i33 == 1) {
                                    zzeq.zzo(obj3, j, Double.longBitsToDouble(zzao.zzp(bArr, i16)));
                                    iZzi = i16 + 8;
                                    i29 = i13 | i38;
                                    i27 = i14;
                                    i26 = i15;
                                    i28 = i36;
                                    i25 = -1;
                                    i24 = i3;
                                } else {
                                    i21 = i14;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                            case 1:
                                i14 = iZzu;
                                i15 = i32;
                                i16 = i35;
                                if (i33 == 5) {
                                    zzeq.zzp(obj3, j, Float.intBitsToFloat(zzao.zzb(bArr, i16)));
                                    iZzi = i16 + 4;
                                    i29 = i13 | i38;
                                    i27 = i14;
                                    i26 = i15;
                                    i28 = i36;
                                    i25 = -1;
                                    i24 = i3;
                                } else {
                                    i21 = i14;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                            case 2:
                            case 3:
                                i14 = iZzu;
                                i15 = i32;
                                i16 = i35;
                                if (i33 == 0) {
                                    int iZzm = zzao.zzm(bArr, i16, zzanVar3);
                                    unsafe2.putLong(obj, j, zzanVar3.zzb);
                                    i29 = i13 | i38;
                                    i27 = i14;
                                    i26 = i15;
                                    iZzi = iZzm;
                                    i28 = i36;
                                    i25 = -1;
                                    i24 = i3;
                                } else {
                                    i21 = i14;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                            case 4:
                            case 11:
                                i14 = iZzu;
                                i15 = i32;
                                i16 = i35;
                                if (i33 == 0) {
                                    iZzi = zzao.zzj(bArr, i16, zzanVar3);
                                    unsafe2.putInt(obj3, j, zzanVar3.zza);
                                    i29 = i13 | i38;
                                    i27 = i14;
                                    i26 = i15;
                                    i28 = i36;
                                    i25 = -1;
                                    i24 = i3;
                                } else {
                                    i21 = i14;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                            case 5:
                            case 14:
                                i14 = iZzu;
                                i15 = i32;
                                i17 = i35;
                                if (i33 == 1) {
                                    i16 = i17;
                                    unsafe2.putLong(obj, j, zzao.zzp(bArr, i17));
                                    iZzi = i16 + 8;
                                    i29 = i13 | i38;
                                    i27 = i14;
                                    i26 = i15;
                                    i28 = i36;
                                    i25 = -1;
                                    i24 = i3;
                                } else {
                                    i16 = i17;
                                    i21 = i14;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                            case 6:
                            case 13:
                                i14 = iZzu;
                                i15 = i32;
                                i17 = i35;
                                if (i33 == 5) {
                                    unsafe2.putInt(obj3, j, zzao.zzb(bArr, i17));
                                    iZzi = i17 + 4;
                                    i29 = i13 | i38;
                                    i27 = i14;
                                    i26 = i15;
                                    i28 = i36;
                                    i25 = -1;
                                    i24 = i3;
                                } else {
                                    i16 = i17;
                                    i21 = i14;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                            case 7:
                                i14 = iZzu;
                                i15 = i32;
                                i17 = i35;
                                if (i33 == 0) {
                                    iZzi = zzao.zzm(bArr, i17, zzanVar3);
                                    zzeq.zzm(obj3, j, zzanVar3.zzb != 0);
                                    i29 = i13 | i38;
                                    i27 = i14;
                                    i26 = i15;
                                    i28 = i36;
                                    i25 = -1;
                                    i24 = i3;
                                } else {
                                    i16 = i17;
                                    i21 = i14;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                            case 8:
                                i14 = iZzu;
                                i15 = i32;
                                i17 = i35;
                                if (i33 == 2) {
                                    iZzi = (i34 & 536870912) == 0 ? zzao.zzg(bArr, i17, zzanVar3) : zzao.zzh(bArr, i17, zzanVar3);
                                    unsafe2.putObject(obj3, j, zzanVar3.zzc);
                                    i29 = i13 | i38;
                                    i27 = i14;
                                    i26 = i15;
                                    i28 = i36;
                                    i25 = -1;
                                    i24 = i3;
                                } else {
                                    i16 = i17;
                                    i21 = i14;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                            case 9:
                                i14 = iZzu;
                                i15 = i32;
                                i17 = i35;
                                if (i33 == 2) {
                                    Object objZzD = zzdiVar2.zzD(obj3, i14);
                                    i36 = i36;
                                    iZzi = zzao.zzo(objZzD, zzdiVar2.zzB(i14), bArr, i17, i2, zzanVar);
                                    zzdiVar2.zzL(obj3, i14, objZzD);
                                    i29 = i13 | i38;
                                    i27 = i14;
                                    i26 = i15;
                                    i28 = i36;
                                    i25 = -1;
                                    i24 = i3;
                                } else {
                                    i36 = i36;
                                    i16 = i17;
                                    i21 = i14;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                            case 10:
                                i18 = iZzu;
                                i15 = i32;
                                i19 = i36;
                                i20 = i35;
                                if (i33 == 2) {
                                    iZzi = zzao.zza(bArr, i20, zzanVar3);
                                    unsafe2.putObject(obj3, j, zzanVar3.zzc);
                                    i29 = i13 | i38;
                                    i27 = i18;
                                    i26 = i15;
                                    i28 = i19;
                                    i25 = -1;
                                    i24 = i3;
                                } else {
                                    i21 = i18;
                                    i36 = i19;
                                    i16 = i20;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                            case 12:
                                i18 = iZzu;
                                i15 = i32;
                                i19 = i36;
                                i20 = i35;
                                if (i33 == 0) {
                                    iZzi = zzao.zzj(bArr, i20, zzanVar3);
                                    int i40 = zzanVar3.zza;
                                    zzce zzceVarZzA = zzdiVar2.zzA(i18);
                                    if (zzceVarZzA == null || zzceVarZzA.zza(i40)) {
                                        unsafe2.putInt(obj3, j, i40);
                                        i29 = i13 | i38;
                                        i27 = i18;
                                    } else {
                                        zzd(obj).zzj(i19, Long.valueOf(i40));
                                        i27 = i18;
                                        i29 = i13;
                                    }
                                    i26 = i15;
                                    i28 = i19;
                                    i25 = -1;
                                    i24 = i3;
                                } else {
                                    i21 = i18;
                                    i36 = i19;
                                    i16 = i20;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                            case 15:
                                i18 = iZzu;
                                i15 = i32;
                                i19 = i36;
                                i20 = i35;
                                if (i33 == 0) {
                                    iZzi = zzao.zzj(bArr, i20, zzanVar3);
                                    unsafe2.putInt(obj3, j, zzbe.zzb(zzanVar3.zza));
                                    i29 = i13 | i38;
                                    i27 = i18;
                                    i26 = i15;
                                    i28 = i19;
                                    i25 = -1;
                                    i24 = i3;
                                } else {
                                    i21 = i18;
                                    i36 = i19;
                                    i16 = i20;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                            case 16:
                                if (i33 == 0) {
                                    int iZzm2 = zzao.zzm(bArr, i35, zzanVar3);
                                    unsafe2.putLong(obj, j, zzbe.zzc(zzanVar3.zzb));
                                    i29 = i13 | i38;
                                    i27 = iZzu;
                                    i26 = i32;
                                    i28 = i36;
                                    iZzi = iZzm2;
                                    i25 = -1;
                                    i24 = i3;
                                } else {
                                    i15 = i32;
                                    i21 = iZzu;
                                    i16 = i35;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                            default:
                                i14 = iZzu;
                                i15 = i32;
                                i16 = i35;
                                if (i33 == 3) {
                                    Object objZzD2 = zzdiVar2.zzD(obj3, i14);
                                    iZzi = zzao.zzn(objZzD2, zzdiVar2.zzB(i14), bArr, i16, i2, (i15 << 3) | 4, zzanVar);
                                    zzdiVar2.zzL(obj3, i14, objZzD2);
                                    i29 = i13 | i38;
                                    i26 = i15;
                                    i27 = i14;
                                    i28 = i36;
                                    i25 = -1;
                                    bArr = bArr;
                                    i24 = i3;
                                } else {
                                    i21 = i14;
                                    i11 = i3;
                                    i9 = i13;
                                    unsafe = unsafe2;
                                    i6 = i15;
                                    i12 = i21;
                                    i7 = i16;
                                    i8 = i36;
                                    i30 = i30;
                                    i10 = -1;
                                }
                                break;
                        }
                    } else {
                        if (iZzx != 27) {
                            i9 = i29;
                            i22 = i30;
                            if (iZzx <= 49) {
                                i6 = i32;
                                i10 = -1;
                                unsafe = unsafe2;
                                i12 = iZzu;
                                iZzi = zzs(obj, bArr, i35, i2, i36, i32, i33, iZzu, i34, iZzx, j, zzanVar);
                                if (iZzi != i35) {
                                    zzdiVar2 = this;
                                    obj3 = obj;
                                    i26 = i6;
                                    i24 = i3;
                                    zzanVar3 = zzanVar;
                                    i25 = i10;
                                    i29 = i9;
                                    i28 = i36;
                                    i27 = i12;
                                    i30 = i22;
                                } else {
                                    i7 = iZzi;
                                    i8 = i36;
                                    i30 = i22;
                                    i11 = i3;
                                }
                                unsafe2 = unsafe;
                            } else {
                                i6 = i32;
                                unsafe = unsafe2;
                                i12 = iZzu;
                                i23 = i35;
                                i10 = -1;
                                if (iZzx != 50) {
                                    iZzi = zzr(obj, bArr, i23, i2, i36, i6, i33, i34, iZzx, j, i12, zzanVar);
                                    if (iZzi != i23) {
                                        zzdiVar2 = this;
                                        obj3 = obj;
                                        i26 = i6;
                                        i24 = i3;
                                        zzanVar3 = zzanVar;
                                        i25 = i10;
                                        i29 = i9;
                                        i28 = i36;
                                        i27 = i12;
                                        i30 = i22;
                                    } else {
                                        i7 = iZzi;
                                        i8 = i36;
                                        i30 = i22;
                                        i11 = i3;
                                    }
                                    unsafe2 = unsafe;
                                } else if (i33 == 2) {
                                    iZzi = zzq(obj, bArr, i23, i2, i12, j, zzanVar);
                                    if (iZzi != i23) {
                                        zzdiVar2 = this;
                                        obj3 = obj;
                                        i26 = i6;
                                        i24 = i3;
                                        zzanVar3 = zzanVar;
                                        i25 = i10;
                                        i29 = i9;
                                        i28 = i36;
                                        i27 = i12;
                                        i30 = i22;
                                    } else {
                                        i7 = iZzi;
                                        i8 = i36;
                                        i30 = i22;
                                        i11 = i3;
                                    }
                                    unsafe2 = unsafe;
                                }
                            }
                        } else if (i33 == 2) {
                            zzcf zzcfVarZzd = (zzcf) unsafe2.getObject(obj3, j);
                            if (!zzcfVarZzd.zzc()) {
                                int size = zzcfVarZzd.size();
                                zzcfVarZzd = zzcfVarZzd.zzd(size == 0 ? 10 : size + size);
                                unsafe2.putObject(obj3, j, zzcfVarZzd);
                            }
                            iZzi = zzao.zze(zzdiVar2.zzB(iZzu), i36, bArr, i35, i2, zzcfVarZzd, zzanVar);
                            i2 = i2;
                            i24 = i3;
                            i26 = i32;
                            i27 = iZzu;
                            i29 = i29;
                            i28 = i36;
                            i30 = i30;
                            i25 = -1;
                            bArr = bArr;
                        } else {
                            i9 = i29;
                            i22 = i30;
                            i6 = i32;
                            unsafe = unsafe2;
                            i12 = iZzu;
                            i23 = i35;
                            i10 = -1;
                        }
                        i11 = i3;
                        i7 = i23;
                        i8 = i36;
                        i30 = i22;
                    }
                }
                if (i8 != i11 || i11 == 0) {
                    int i41 = i11;
                    if (this.zzh) {
                        zzanVar2 = zzanVar;
                        zzbn zzbnVar = zzanVar2.zzd;
                        if (zzbnVar != zzbn.zza) {
                            i6 = i6;
                            if (zzbnVar.zzb(this.zzg, i6) != null) {
                                throw null;
                            }
                            iZzi = zzao.zzi(i8, bArr, i7, i2, zzd(obj), zzanVar);
                            obj = obj;
                        }
                        i28 = i8;
                        zzdiVar2 = this;
                        i26 = i6;
                        obj3 = obj;
                        i25 = i10;
                        i29 = i9;
                        i27 = i12;
                        i24 = i41;
                        zzanVar3 = zzanVar2;
                        unsafe2 = unsafe;
                    } else {
                        zzanVar2 = zzanVar;
                    }
                    iZzi = zzao.zzi(i8, bArr, i7, i2, zzd(obj), zzanVar);
                    i28 = i8;
                    zzdiVar2 = this;
                    i26 = i6;
                    obj3 = obj;
                    i25 = i10;
                    i29 = i9;
                    i27 = i12;
                    i24 = i41;
                    zzanVar3 = zzanVar2;
                    unsafe2 = unsafe;
                } else {
                    zzdiVar = this;
                    obj2 = obj;
                    i4 = i11;
                    iZzi = i7;
                    i28 = i8;
                    i29 = i9;
                }
            } else {
                unsafe = unsafe2;
                i4 = i24;
                obj2 = obj3;
                zzdiVar = zzdiVar2;
            }
        }
        if (i30 != 1048575) {
            unsafe.putInt(obj2, i30, i29);
        }
        for (int i42 = zzdiVar.zzj; i42 < zzdiVar.zzk; i42++) {
            int i43 = zzdiVar.zzi[i42];
            int i44 = zzdiVar.zzc[i43];
            Object objZzf = zzeq.zzf(obj2, zzdiVar.zzy(i43) & 1048575);
            if (objZzf != null && zzdiVar.zzA(i43) != null) {
                throw null;
            }
        }
        if (i4 == 0) {
            if (iZzi != i2) {
                throw zzci.zze();
            }
        } else if (iZzi > i2 || i28 != i4) {
            throw zzci.zze();
        }
        return iZzi;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdp
    public final Object zze() {
        return ((zzcb) this.zzg).zzi();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0072  */
    /* JADX WARN: Code duplicated, block: B:40:0x007f A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.play_billing.zzdp
    public final void zzf(Object obj) {
        if (zzS(obj)) {
            if (obj instanceof zzcb) {
                zzcb zzcbVar = (zzcb) obj;
                zzcbVar.zzq(Integer.MAX_VALUE);
                zzcbVar.zza = 0;
                zzcbVar.zzo();
            }
            int length = this.zzc.length;
            for (int i = 0; i < length; i += 3) {
                int iZzy = zzy(i);
                int i2 = 1048575 & iZzy;
                int iZzx = zzx(iZzy);
                long j = i2;
                if (iZzx != 9) {
                    if (iZzx != 60 && iZzx != 68) {
                        switch (iZzx) {
                            case 17:
                                if (zzP(obj, i)) {
                                    zzB(i).zzf(zzb.getObject(obj, j));
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
                                this.zzl.zza(obj, j);
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzcz) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (zzT(obj, this.zzc[i], i)) {
                        zzB(i).zzf(zzb.getObject(obj, j));
                    }
                } else if (zzP(obj, i)) {
                    zzB(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzm.zzg(obj);
            if (this.zzh) {
                this.zzn.zzb(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzdp
    public final void zzg(Object obj, Object obj2) {
        zzG(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzy = zzy(i);
            int i2 = this.zzc[i];
            long j = 1048575 & iZzy;
            switch (zzx(iZzy)) {
                case 0:
                    if (zzP(obj2, i)) {
                        zzeq.zzo(obj, j, zzeq.zza(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 1:
                    if (zzP(obj2, i)) {
                        zzeq.zzp(obj, j, zzeq.zzb(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 2:
                    if (zzP(obj2, i)) {
                        zzeq.zzr(obj, j, zzeq.zzd(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 3:
                    if (zzP(obj2, i)) {
                        zzeq.zzr(obj, j, zzeq.zzd(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 4:
                    if (zzP(obj2, i)) {
                        zzeq.zzq(obj, j, zzeq.zzc(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 5:
                    if (zzP(obj2, i)) {
                        zzeq.zzr(obj, j, zzeq.zzd(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 6:
                    if (zzP(obj2, i)) {
                        zzeq.zzq(obj, j, zzeq.zzc(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 7:
                    if (zzP(obj2, i)) {
                        zzeq.zzm(obj, j, zzeq.zzw(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 8:
                    if (zzP(obj2, i)) {
                        zzeq.zzs(obj, j, zzeq.zzf(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 9:
                    zzH(obj, obj2, i);
                    break;
                case 10:
                    if (zzP(obj2, i)) {
                        zzeq.zzs(obj, j, zzeq.zzf(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 11:
                    if (zzP(obj2, i)) {
                        zzeq.zzq(obj, j, zzeq.zzc(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 12:
                    if (zzP(obj2, i)) {
                        zzeq.zzq(obj, j, zzeq.zzc(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 13:
                    if (zzP(obj2, i)) {
                        zzeq.zzq(obj, j, zzeq.zzc(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 14:
                    if (zzP(obj2, i)) {
                        zzeq.zzr(obj, j, zzeq.zzd(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 15:
                    if (zzP(obj2, i)) {
                        zzeq.zzq(obj, j, zzeq.zzc(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 16:
                    if (zzP(obj2, i)) {
                        zzeq.zzr(obj, j, zzeq.zzd(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 17:
                    zzH(obj, obj2, i);
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
                    this.zzl.zzb(obj, obj2, j);
                    break;
                case 50:
                    int i3 = zzdr.zza;
                    zzeq.zzs(obj, j, zzda.zzb(zzeq.zzf(obj, j), zzeq.zzf(obj2, j)));
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
                    if (zzT(obj2, i2, i)) {
                        zzeq.zzs(obj, j, zzeq.zzf(obj2, j));
                        zzK(obj, i2, i);
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    zzI(obj, obj2, i);
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                case 62:
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                case 64:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                case 67:
                    if (zzT(obj2, i2, i)) {
                        zzeq.zzs(obj, j, zzeq.zzf(obj2, j));
                        zzK(obj, i2, i);
                    }
                    break;
                case 68:
                    zzI(obj, obj2, i);
                    break;
            }
        }
        zzdr.zzB(this.zzm, obj, obj2);
        if (this.zzh) {
            this.zzn.zza(obj2);
            throw null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:97:0x0296 A[PHI: r0 r18 r25 r26 r27
  0x0296: PHI (r0v61 int) = (r0v56 int), (r0v59 int), (r0v63 int) binds: [B:109:0x02fd, B:104:0x02d9, B:96:0x0294] A[DONT_GENERATE, DONT_INLINE]
  0x0296: PHI (r18v5 int) = (r18v3 int), (r18v3 int), (r18v6 int) binds: [B:109:0x02fd, B:104:0x02d9, B:96:0x0294] A[DONT_GENERATE, DONT_INLINE]
  0x0296: PHI (r25v3 int) = (r25v1 int), (r25v1 int), (r25v4 int) binds: [B:109:0x02fd, B:104:0x02d9, B:96:0x0294] A[DONT_GENERATE, DONT_INLINE]
  0x0296: PHI (r26v2 int) = (r26v0 int), (r26v0 int), (r26v3 int) binds: [B:109:0x02fd, B:104:0x02d9, B:96:0x0294] A[DONT_GENERATE, DONT_INLINE]
  0x0296: PHI (r27v7 sun.misc.Unsafe) = (r27v5 sun.misc.Unsafe), (r27v5 sun.misc.Unsafe), (r27v8 sun.misc.Unsafe) binds: [B:109:0x02fd, B:104:0x02d9, B:96:0x0294] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:98:0x02ac A[PHI: r0 r18 r25 r26 r27
  0x02ac: PHI (r0v60 int) = (r0v56 int), (r0v59 int), (r0v63 int) binds: [B:109:0x02fd, B:104:0x02d9, B:96:0x0294] A[DONT_GENERATE, DONT_INLINE]
  0x02ac: PHI (r18v4 int) = (r18v3 int), (r18v3 int), (r18v6 int) binds: [B:109:0x02fd, B:104:0x02d9, B:96:0x0294] A[DONT_GENERATE, DONT_INLINE]
  0x02ac: PHI (r25v2 int) = (r25v1 int), (r25v1 int), (r25v4 int) binds: [B:109:0x02fd, B:104:0x02d9, B:96:0x0294] A[DONT_GENERATE, DONT_INLINE]
  0x02ac: PHI (r26v1 int) = (r26v0 int), (r26v0 int), (r26v3 int) binds: [B:109:0x02fd, B:104:0x02d9, B:96:0x0294] A[DONT_GENERATE, DONT_INLINE]
  0x02ac: PHI (r27v6 sun.misc.Unsafe) = (r27v5 sun.misc.Unsafe), (r27v5 sun.misc.Unsafe), (r27v8 sun.misc.Unsafe) binds: [B:109:0x02fd, B:104:0x02d9, B:96:0x0294] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Failed to find 'out' block for switch in B:27:0x008d. Please report as an issue. */
    @Override // com.google.android.gms.internal.play_billing.zzdp
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzan zzanVar) throws IOException {
        int i3;
        int iZzk;
        int i4;
        int i5;
        int i6;
        Unsafe unsafe;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        this = this;
        obj = obj;
        bArr = bArr;
        i2 = i2;
        zzanVar = zzanVar;
        zzew zzewVar = zzew.DOUBLE;
        int i13 = -1;
        if (this.zzo - 1 == 0) {
            zzc(obj, bArr, i, i2, 0, zzanVar);
            return;
        }
        zzG(obj);
        Unsafe unsafe2 = zzb;
        int i14 = 1048575;
        int iZzi = i;
        int i15 = 1048575;
        int i16 = -1;
        int i17 = 0;
        int i18 = 0;
        while (iZzi < i2) {
            int i19 = iZzi + 1;
            byte b = bArr[iZzi];
            if (b < 0) {
                iZzk = zzao.zzk(b, bArr, i19, zzanVar);
                i3 = zzanVar.zza;
            } else {
                i3 = b;
                iZzk = i19;
            }
            int i20 = i3 >>> 3;
            int iZzu = i20 > i16 ? this.zzu(i20, i17 / 3) : this.zzt(i20);
            if (iZzu == i13) {
                i4 = iZzk;
                i5 = i20;
                i6 = i13;
                unsafe = unsafe2;
                i7 = 0;
            } else {
                int i21 = i3 & 7;
                int[] iArr = this.zzc;
                int i22 = iArr[iZzu + 1];
                int iZzx = zzx(i22);
                long j = i22 & i14;
                if (iZzx <= 17) {
                    int i23 = iArr[iZzu + 2];
                    int i24 = 1 << (i23 >>> 20);
                    int i25 = 1048575;
                    int i26 = i23 & 1048575;
                    if (i26 != i15) {
                        if (i15 != 1048575) {
                            unsafe2.putInt(obj, i15, i18);
                        }
                        if (i26 != 1048575) {
                            i18 = unsafe2.getInt(obj, i26);
                        }
                        i15 = i26;
                    }
                    switch (iZzx) {
                        case 0:
                            i8 = iZzu;
                            i5 = i20;
                            i9 = iZzk;
                            if (i21 != 1) {
                                i4 = i9;
                                unsafe = unsafe2;
                                i7 = i8;
                                i6 = -1;
                            } else {
                                zzeq.zzo(obj, j, Double.longBitsToDouble(zzao.zzp(bArr, i9)));
                                iZzi = i9 + 8;
                                i18 |= i24;
                                i17 = i8;
                                i16 = i5;
                                i14 = i25;
                                i13 = -1;
                                i2 = i2;
                            }
                            break;
                        case 1:
                            i8 = iZzu;
                            i5 = i20;
                            i9 = iZzk;
                            if (i21 != 5) {
                                i4 = i9;
                                unsafe = unsafe2;
                                i7 = i8;
                                i6 = -1;
                            } else {
                                zzeq.zzp(obj, j, Float.intBitsToFloat(zzao.zzb(bArr, i9)));
                                iZzi = i9 + 4;
                                i18 |= i24;
                                i17 = i8;
                                i16 = i5;
                                i14 = i25;
                                i13 = -1;
                                i2 = i2;
                            }
                            break;
                        case 2:
                        case 3:
                            i25 = 1048575;
                            i8 = iZzu;
                            i5 = i20;
                            i9 = iZzk;
                            if (i21 != 0) {
                                i4 = i9;
                                unsafe = unsafe2;
                                i7 = i8;
                                i6 = -1;
                            } else {
                                int iZzm = zzao.zzm(bArr, i9, zzanVar);
                                unsafe2.putLong(obj, j, zzanVar.zzb);
                                i18 |= i24;
                                i17 = i8;
                                iZzi = iZzm;
                                i16 = i5;
                                i14 = i25;
                                i13 = -1;
                                i2 = i2;
                            }
                            break;
                        case 4:
                        case 11:
                            i8 = iZzu;
                            i5 = i20;
                            i9 = iZzk;
                            if (i21 != 0) {
                                i4 = i9;
                                unsafe = unsafe2;
                                i7 = i8;
                                i6 = -1;
                            } else {
                                iZzi = zzao.zzj(bArr, i9, zzanVar);
                                unsafe2.putInt(obj, j, zzanVar.zza);
                                i18 |= i24;
                                i17 = i8;
                                i16 = i5;
                                i14 = i25;
                                i13 = -1;
                                i2 = i2;
                            }
                            break;
                        case 5:
                        case 14:
                            i8 = iZzu;
                            i5 = i20;
                            if (i21 != 1) {
                                i9 = iZzk;
                                i4 = i9;
                                unsafe = unsafe2;
                                i7 = i8;
                                i6 = -1;
                            } else {
                                unsafe2.putLong(obj, j, zzao.zzp(bArr, iZzk));
                                iZzi = iZzk + 8;
                                i18 |= i24;
                                i17 = i8;
                                i16 = i5;
                                i14 = i25;
                                i13 = -1;
                                i2 = i2;
                            }
                            break;
                        case 6:
                        case 13:
                            i8 = iZzu;
                            i5 = i20;
                            if (i21 != 5) {
                                i9 = iZzk;
                                i4 = i9;
                                unsafe = unsafe2;
                                i7 = i8;
                                i6 = -1;
                            } else {
                                unsafe2.putInt(obj, j, zzao.zzb(bArr, iZzk));
                                iZzi = iZzk + 4;
                                i18 |= i24;
                                i17 = i8;
                                i16 = i5;
                                i14 = i25;
                                i13 = -1;
                                i2 = i2;
                            }
                            break;
                        case 7:
                            i8 = iZzu;
                            i5 = i20;
                            if (i21 != 0) {
                                i9 = iZzk;
                                i4 = i9;
                                unsafe = unsafe2;
                                i7 = i8;
                                i6 = -1;
                            } else {
                                iZzi = zzao.zzm(bArr, iZzk, zzanVar);
                                zzeq.zzm(obj, j, zzanVar.zzb != 0);
                                i18 |= i24;
                                i17 = i8;
                                i16 = i5;
                                i14 = i25;
                                i13 = -1;
                                i2 = i2;
                            }
                            break;
                        case 8:
                            i8 = iZzu;
                            i5 = i20;
                            if (i21 != 2) {
                                i9 = iZzk;
                                i4 = i9;
                                unsafe = unsafe2;
                                i7 = i8;
                                i6 = -1;
                            } else {
                                iZzi = (i22 & 536870912) == 0 ? zzao.zzg(bArr, iZzk, zzanVar) : zzao.zzh(bArr, iZzk, zzanVar);
                                unsafe2.putObject(obj, j, zzanVar.zzc);
                                i18 |= i24;
                                i17 = i8;
                                i16 = i5;
                                i14 = i25;
                                i13 = -1;
                                i2 = i2;
                            }
                            break;
                        case 9:
                            i8 = iZzu;
                            i5 = i20;
                            if (i21 != 2) {
                                i9 = iZzk;
                                i4 = i9;
                                unsafe = unsafe2;
                                i7 = i8;
                                i6 = -1;
                            } else {
                                Object objZzD = this.zzD(obj, i8);
                                iZzi = zzao.zzo(objZzD, this.zzB(i8), bArr, iZzk, i2, zzanVar);
                                this.zzL(obj, i8, objZzD);
                                i18 |= i24;
                                i17 = i8;
                                i16 = i5;
                                i14 = i25;
                                i13 = -1;
                                i2 = i2;
                            }
                            break;
                        case 10:
                            i8 = iZzu;
                            i5 = i20;
                            if (i21 != 2) {
                                i9 = iZzk;
                                i4 = i9;
                                unsafe = unsafe2;
                                i7 = i8;
                                i6 = -1;
                            } else {
                                iZzi = zzao.zza(bArr, iZzk, zzanVar);
                                unsafe2.putObject(obj, j, zzanVar.zzc);
                                i18 |= i24;
                                i17 = i8;
                                i16 = i5;
                                i14 = i25;
                                i13 = -1;
                                i2 = i2;
                            }
                            break;
                        case 12:
                            i8 = iZzu;
                            i5 = i20;
                            if (i21 != 0) {
                                i9 = iZzk;
                                i4 = i9;
                                unsafe = unsafe2;
                                i7 = i8;
                                i6 = -1;
                            } else {
                                iZzi = zzao.zzj(bArr, iZzk, zzanVar);
                                unsafe2.putInt(obj, j, zzanVar.zza);
                                i18 |= i24;
                                i17 = i8;
                                i16 = i5;
                                i14 = i25;
                                i13 = -1;
                                i2 = i2;
                            }
                            break;
                        case 15:
                            i8 = iZzu;
                            i5 = i20;
                            if (i21 != 0) {
                                i9 = iZzk;
                                i4 = i9;
                                unsafe = unsafe2;
                                i7 = i8;
                                i6 = -1;
                            } else {
                                iZzi = zzao.zzj(bArr, iZzk, zzanVar);
                                unsafe2.putInt(obj, j, zzbe.zzb(zzanVar.zza));
                                i18 |= i24;
                                i17 = i8;
                                i16 = i5;
                                i14 = i25;
                                i13 = -1;
                                i2 = i2;
                            }
                            break;
                        case 16:
                            if (i21 != 0) {
                                i5 = i20;
                                i9 = iZzk;
                                i8 = iZzu;
                                i4 = i9;
                                unsafe = unsafe2;
                                i7 = i8;
                                i6 = -1;
                            } else {
                                int iZzm2 = zzao.zzm(bArr, iZzk, zzanVar);
                                i5 = i20;
                                i25 = 1048575;
                                unsafe2.putLong(obj, j, zzbe.zzc(zzanVar.zzb));
                                i18 |= i24;
                                i17 = iZzu;
                                iZzi = iZzm2;
                                i16 = i5;
                                i14 = i25;
                                i13 = -1;
                                i2 = i2;
                            }
                            break;
                        default:
                            i8 = iZzu;
                            i5 = i20;
                            i9 = iZzk;
                            i4 = i9;
                            unsafe = unsafe2;
                            i7 = i8;
                            i6 = -1;
                            break;
                    }
                } else {
                    i5 = i20;
                    int i27 = iZzk;
                    if (iZzx != 27) {
                        i7 = iZzu;
                        if (iZzx <= 49) {
                            i11 = i18;
                            i12 = i15;
                            unsafe = unsafe2;
                            i6 = -1;
                            iZzi = zzs(obj, bArr, i27, i2, i3, i5, i21, i7, i22, iZzx, j, zzanVar);
                            if (iZzi != i27) {
                                i13 = i6;
                                i16 = i5;
                                i17 = i7;
                                i18 = i11;
                                i15 = i12;
                            } else {
                                i4 = iZzi;
                                i18 = i11;
                                i15 = i12;
                            }
                        } else {
                            i10 = i27;
                            i11 = i18;
                            i12 = i15;
                            unsafe = unsafe2;
                            i6 = -1;
                            if (iZzx == 50) {
                                if (i21 == 2) {
                                    iZzi = zzq(obj, bArr, i10, i2, i7, j, zzanVar);
                                    if (iZzi != i10) {
                                        i13 = i6;
                                        i16 = i5;
                                        i17 = i7;
                                        i18 = i11;
                                        i15 = i12;
                                    } else {
                                        i4 = iZzi;
                                    }
                                }
                                i18 = i11;
                                i15 = i12;
                            } else {
                                iZzi = zzr(obj, bArr, i10, i2, i3, i5, i21, i22, iZzx, j, i7, zzanVar);
                                if (iZzi != i10) {
                                    i13 = i6;
                                    i16 = i5;
                                    i17 = i7;
                                    i18 = i11;
                                    i15 = i12;
                                } else {
                                    i4 = iZzi;
                                    i18 = i11;
                                    i15 = i12;
                                }
                            }
                        }
                        unsafe2 = unsafe;
                        i14 = 1048575;
                    } else if (i21 == 2) {
                        zzcf zzcfVarZzd = (zzcf) unsafe2.getObject(obj, j);
                        if (!zzcfVarZzd.zzc()) {
                            int size = zzcfVarZzd.size();
                            zzcfVarZzd = zzcfVarZzd.zzd(size == 0 ? 10 : size + size);
                            unsafe2.putObject(obj, j, zzcfVarZzd);
                        }
                        iZzi = zzao.zze(this.zzB(iZzu), i3, bArr, i27, i2, zzcfVarZzd, zzanVar);
                        i2 = i2;
                        i18 = i18;
                        i16 = i5;
                        i17 = iZzu;
                        i14 = 1048575;
                        i13 = -1;
                    } else {
                        i7 = iZzu;
                        i10 = i27;
                        i11 = i18;
                        i12 = i15;
                        unsafe = unsafe2;
                        i6 = -1;
                    }
                    i4 = i10;
                    i18 = i11;
                    i15 = i12;
                }
            }
            iZzi = zzao.zzi(i3, bArr, i4, i2, zzd(obj), zzanVar);
            i13 = i6;
            i16 = i5;
            i17 = i7;
            unsafe2 = unsafe;
            i14 = 1048575;
        }
        int i28 = i18;
        Unsafe unsafe3 = unsafe2;
        if (i15 != i14) {
            unsafe3.putInt(obj, i15, i28);
        }
        if (iZzi != i2) {
            throw zzci.zze();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.play_billing.zzdp
    public final void zzi(Object obj, zzey zzeyVar) throws IOException {
        int i;
        int i2;
        int i3;
        zzew zzewVar = zzew.DOUBLE;
        int i4 = 0;
        int i5 = 1048575;
        if (this.zzo - 1 != 0) {
            if (this.zzh) {
                this.zzn.zza(obj);
                throw null;
            }
            int length = this.zzc.length;
            for (int i6 = 0; i6 < length; i6 += 3) {
                int iZzy = zzy(i6);
                int i7 = this.zzc[i6];
                switch (zzx(iZzy)) {
                    case 0:
                        if (zzP(obj, i6)) {
                            zzeyVar.zzf(i7, zzeq.zza(obj, iZzy & 1048575));
                        }
                        break;
                    case 1:
                        if (zzP(obj, i6)) {
                            zzeyVar.zzo(i7, zzeq.zzb(obj, iZzy & 1048575));
                        }
                        break;
                    case 2:
                        if (zzP(obj, i6)) {
                            zzeyVar.zzt(i7, zzeq.zzd(obj, iZzy & 1048575));
                        }
                        break;
                    case 3:
                        if (zzP(obj, i6)) {
                            zzeyVar.zzJ(i7, zzeq.zzd(obj, iZzy & 1048575));
                        }
                        break;
                    case 4:
                        if (zzP(obj, i6)) {
                            zzeyVar.zzr(i7, zzeq.zzc(obj, iZzy & 1048575));
                        }
                        break;
                    case 5:
                        if (zzP(obj, i6)) {
                            zzeyVar.zzm(i7, zzeq.zzd(obj, iZzy & 1048575));
                        }
                        break;
                    case 6:
                        if (zzP(obj, i6)) {
                            zzeyVar.zzk(i7, zzeq.zzc(obj, iZzy & 1048575));
                        }
                        break;
                    case 7:
                        if (zzP(obj, i6)) {
                            zzeyVar.zzb(i7, zzeq.zzw(obj, iZzy & 1048575));
                        }
                        break;
                    case 8:
                        if (zzP(obj, i6)) {
                            zzV(i7, zzeq.zzf(obj, iZzy & 1048575), zzeyVar);
                        }
                        break;
                    case 9:
                        if (zzP(obj, i6)) {
                            zzeyVar.zzv(i7, zzeq.zzf(obj, iZzy & 1048575), zzB(i6));
                        }
                        break;
                    case 10:
                        if (zzP(obj, i6)) {
                            zzeyVar.zzd(i7, (zzba) zzeq.zzf(obj, iZzy & 1048575));
                        }
                        break;
                    case 11:
                        if (zzP(obj, i6)) {
                            zzeyVar.zzH(i7, zzeq.zzc(obj, iZzy & 1048575));
                        }
                        break;
                    case 12:
                        if (zzP(obj, i6)) {
                            zzeyVar.zzi(i7, zzeq.zzc(obj, iZzy & 1048575));
                        }
                        break;
                    case 13:
                        if (zzP(obj, i6)) {
                            zzeyVar.zzw(i7, zzeq.zzc(obj, iZzy & 1048575));
                        }
                        break;
                    case 14:
                        if (zzP(obj, i6)) {
                            zzeyVar.zzy(i7, zzeq.zzd(obj, iZzy & 1048575));
                        }
                        break;
                    case 15:
                        if (zzP(obj, i6)) {
                            zzeyVar.zzA(i7, zzeq.zzc(obj, iZzy & 1048575));
                        }
                        break;
                    case 16:
                        if (zzP(obj, i6)) {
                            zzeyVar.zzC(i7, zzeq.zzd(obj, iZzy & 1048575));
                        }
                        break;
                    case 17:
                        if (zzP(obj, i6)) {
                            zzeyVar.zzq(i7, zzeq.zzf(obj, iZzy & 1048575), zzB(i6));
                        }
                        break;
                    case 18:
                        zzdr.zzF(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, false);
                        break;
                    case 19:
                        zzdr.zzJ(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, false);
                        break;
                    case 20:
                        zzdr.zzM(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, false);
                        break;
                    case 21:
                        zzdr.zzU(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, false);
                        break;
                    case 22:
                        zzdr.zzL(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, false);
                        break;
                    case 23:
                        zzdr.zzI(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, false);
                        break;
                    case 24:
                        zzdr.zzH(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, false);
                        break;
                    case 25:
                        zzdr.zzD(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, false);
                        break;
                    case 26:
                        zzdr.zzS(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar);
                        break;
                    case 27:
                        zzdr.zzN(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, zzB(i6));
                        break;
                    case 28:
                        zzdr.zzE(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar);
                        break;
                    case 29:
                        zzdr.zzT(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, false);
                        break;
                    case 30:
                        zzdr.zzG(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, false);
                        break;
                    case 31:
                        zzdr.zzO(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, false);
                        break;
                    case 32:
                        zzdr.zzP(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, false);
                        break;
                    case 33:
                        zzdr.zzQ(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, false);
                        break;
                    case 34:
                        zzdr.zzR(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, false);
                        break;
                    case 35:
                        zzdr.zzF(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, true);
                        break;
                    case 36:
                        zzdr.zzJ(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, true);
                        break;
                    case 37:
                        zzdr.zzM(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, true);
                        break;
                    case 38:
                        zzdr.zzU(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, true);
                        break;
                    case 39:
                        zzdr.zzL(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, true);
                        break;
                    case 40:
                        zzdr.zzI(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, true);
                        break;
                    case 41:
                        zzdr.zzH(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, true);
                        break;
                    case 42:
                        zzdr.zzD(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, true);
                        break;
                    case 43:
                        zzdr.zzT(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, true);
                        break;
                    case 44:
                        zzdr.zzG(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, true);
                        break;
                    case 45:
                        zzdr.zzO(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, true);
                        break;
                    case 46:
                        zzdr.zzP(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, true);
                        break;
                    case 47:
                        zzdr.zzQ(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, true);
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                        zzdr.zzR(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, true);
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                        zzdr.zzK(i7, (List) zzeq.zzf(obj, iZzy & 1048575), zzeyVar, zzB(i6));
                        break;
                    case 50:
                        zzN(zzeyVar, i7, zzeq.zzf(obj, iZzy & 1048575), i6);
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                        if (zzT(obj, i7, i6)) {
                            zzeyVar.zzf(i7, zzm(obj, iZzy & 1048575));
                        }
                        break;
                    case 52:
                        if (zzT(obj, i7, i6)) {
                            zzeyVar.zzo(i7, zzn(obj, iZzy & 1048575));
                        }
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                        if (zzT(obj, i7, i6)) {
                            zzeyVar.zzt(i7, zzz(obj, iZzy & 1048575));
                        }
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                        if (zzT(obj, i7, i6)) {
                            zzeyVar.zzJ(i7, zzz(obj, iZzy & 1048575));
                        }
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                        if (zzT(obj, i7, i6)) {
                            zzeyVar.zzr(i7, zzp(obj, iZzy & 1048575));
                        }
                        break;
                    case 56:
                        if (zzT(obj, i7, i6)) {
                            zzeyVar.zzm(i7, zzz(obj, iZzy & 1048575));
                        }
                        break;
                    case 57:
                        if (zzT(obj, i7, i6)) {
                            zzeyVar.zzk(i7, zzp(obj, iZzy & 1048575));
                        }
                        break;
                    case 58:
                        if (zzT(obj, i7, i6)) {
                            zzeyVar.zzb(i7, zzU(obj, iZzy & 1048575));
                        }
                        break;
                    case 59:
                        if (zzT(obj, i7, i6)) {
                            zzV(i7, zzeq.zzf(obj, iZzy & 1048575), zzeyVar);
                        }
                        break;
                    case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                        if (zzT(obj, i7, i6)) {
                            zzeyVar.zzv(i7, zzeq.zzf(obj, iZzy & 1048575), zzB(i6));
                        }
                        break;
                    case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                        if (zzT(obj, i7, i6)) {
                            zzeyVar.zzd(i7, (zzba) zzeq.zzf(obj, iZzy & 1048575));
                        }
                        break;
                    case 62:
                        if (zzT(obj, i7, i6)) {
                            zzeyVar.zzH(i7, zzp(obj, iZzy & 1048575));
                        }
                        break;
                    case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                        if (zzT(obj, i7, i6)) {
                            zzeyVar.zzi(i7, zzp(obj, iZzy & 1048575));
                        }
                        break;
                    case 64:
                        if (zzT(obj, i7, i6)) {
                            zzeyVar.zzw(i7, zzp(obj, iZzy & 1048575));
                        }
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                        if (zzT(obj, i7, i6)) {
                            zzeyVar.zzy(i7, zzz(obj, iZzy & 1048575));
                        }
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                        if (zzT(obj, i7, i6)) {
                            zzeyVar.zzA(i7, zzp(obj, iZzy & 1048575));
                        }
                        break;
                    case 67:
                        if (zzT(obj, i7, i6)) {
                            zzeyVar.zzC(i7, zzz(obj, iZzy & 1048575));
                        }
                        break;
                    case 68:
                        if (zzT(obj, i7, i6)) {
                            zzeyVar.zzq(i7, zzeq.zzf(obj, iZzy & 1048575), zzB(i6));
                        }
                        break;
                }
            }
            zzeg zzegVar = this.zzm;
            zzegVar.zzi(zzegVar.zzd(obj), zzeyVar);
            return;
        }
        if (this.zzh) {
            this.zzn.zza(obj);
            throw null;
        }
        int length2 = this.zzc.length;
        Unsafe unsafe = zzb;
        int i8 = 0;
        int i9 = 0;
        int i10 = 1048575;
        while (i8 < length2) {
            int iZzy2 = zzy(i8);
            int[] iArr = this.zzc;
            int i11 = iArr[i8];
            int iZzx = zzx(iZzy2);
            if (iZzx <= 17) {
                int i12 = iArr[i8 + 2];
                int i13 = i12 & i5;
                if (i13 != i10) {
                    i9 = unsafe.getInt(obj, i13);
                    i10 = i13;
                }
                i = 1 << (i12 >>> 20);
            } else {
                i = i4;
            }
            long j = iZzy2 & i5;
            switch (iZzx) {
                case 0:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzeyVar.zzf(i11, zzeq.zza(obj, j));
                    }
                    break;
                case 1:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzeyVar.zzo(i11, zzeq.zzb(obj, j));
                    }
                    break;
                case 2:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzeyVar.zzt(i11, unsafe.getLong(obj, j));
                    }
                    break;
                case 3:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzeyVar.zzJ(i11, unsafe.getLong(obj, j));
                    }
                    break;
                case 4:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzeyVar.zzr(i11, unsafe.getInt(obj, j));
                    }
                    break;
                case 5:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzeyVar.zzm(i11, unsafe.getLong(obj, j));
                    }
                    break;
                case 6:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzeyVar.zzk(i11, unsafe.getInt(obj, j));
                    }
                    break;
                case 7:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzeyVar.zzb(i11, zzeq.zzw(obj, j));
                    }
                    break;
                case 8:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzV(i11, unsafe.getObject(obj, j), zzeyVar);
                    }
                    break;
                case 9:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzeyVar.zzv(i11, unsafe.getObject(obj, j), zzB(i8));
                    }
                    break;
                case 10:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzeyVar.zzd(i11, (zzba) unsafe.getObject(obj, j));
                    }
                    break;
                case 11:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzeyVar.zzH(i11, unsafe.getInt(obj, j));
                    }
                    break;
                case 12:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzeyVar.zzi(i11, unsafe.getInt(obj, j));
                    }
                    break;
                case 13:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzeyVar.zzw(i11, unsafe.getInt(obj, j));
                    }
                    break;
                case 14:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzeyVar.zzy(i11, unsafe.getLong(obj, j));
                    }
                    break;
                case 15:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzeyVar.zzA(i11, unsafe.getInt(obj, j));
                    }
                    break;
                case 16:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzeyVar.zzC(i11, unsafe.getLong(obj, j));
                    }
                    break;
                case 17:
                    i2 = 0;
                    if ((i9 & i) != 0) {
                        zzeyVar.zzq(i11, unsafe.getObject(obj, j), zzB(i8));
                    }
                    break;
                case 18:
                    i2 = 0;
                    zzdr.zzF(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, false);
                    break;
                case 19:
                    i2 = 0;
                    zzdr.zzJ(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, false);
                    break;
                case 20:
                    i2 = 0;
                    zzdr.zzM(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, false);
                    break;
                case 21:
                    i2 = 0;
                    zzdr.zzU(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, false);
                    break;
                case 22:
                    i2 = 0;
                    zzdr.zzL(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, false);
                    break;
                case 23:
                    i2 = 0;
                    zzdr.zzI(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, false);
                    break;
                case 24:
                    i2 = 0;
                    zzdr.zzH(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, false);
                    break;
                case 25:
                    i2 = 0;
                    zzdr.zzD(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, false);
                    break;
                case 26:
                    zzdr.zzS(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar);
                    i2 = 0;
                    break;
                case 27:
                    zzdr.zzN(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, zzB(i8));
                    i2 = 0;
                    break;
                case 28:
                    zzdr.zzE(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar);
                    i2 = 0;
                    break;
                case 29:
                    i3 = 0;
                    zzdr.zzT(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, false);
                    i2 = i3;
                    break;
                case 30:
                    i3 = 0;
                    zzdr.zzG(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, false);
                    i2 = i3;
                    break;
                case 31:
                    i3 = 0;
                    zzdr.zzO(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, false);
                    i2 = i3;
                    break;
                case 32:
                    i3 = 0;
                    zzdr.zzP(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, false);
                    i2 = i3;
                    break;
                case 33:
                    i3 = 0;
                    zzdr.zzQ(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, false);
                    i2 = i3;
                    break;
                case 34:
                    i3 = 0;
                    zzdr.zzR(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, false);
                    i2 = i3;
                    break;
                case 35:
                    zzdr.zzF(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, true);
                    i2 = 0;
                    break;
                case 36:
                    zzdr.zzJ(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, true);
                    i2 = 0;
                    break;
                case 37:
                    zzdr.zzM(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, true);
                    i2 = 0;
                    break;
                case 38:
                    zzdr.zzU(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, true);
                    i2 = 0;
                    break;
                case 39:
                    zzdr.zzL(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, true);
                    i2 = 0;
                    break;
                case 40:
                    zzdr.zzI(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, true);
                    i2 = 0;
                    break;
                case 41:
                    zzdr.zzH(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, true);
                    i2 = 0;
                    break;
                case 42:
                    zzdr.zzD(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, true);
                    i2 = 0;
                    break;
                case 43:
                    zzdr.zzT(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, true);
                    i2 = 0;
                    break;
                case 44:
                    zzdr.zzG(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, true);
                    i2 = 0;
                    break;
                case 45:
                    zzdr.zzO(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, true);
                    i2 = 0;
                    break;
                case 46:
                    zzdr.zzP(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, true);
                    i2 = 0;
                    break;
                case 47:
                    zzdr.zzQ(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, true);
                    i2 = 0;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                    zzdr.zzR(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, true);
                    i2 = 0;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    zzdr.zzK(this.zzc[i8], (List) unsafe.getObject(obj, j), zzeyVar, zzB(i8));
                    i2 = 0;
                    break;
                case 50:
                    zzN(zzeyVar, i11, unsafe.getObject(obj, j), i8);
                    i2 = 0;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzT(obj, i11, i8)) {
                        zzeyVar.zzf(i11, zzm(obj, j));
                    }
                    i2 = 0;
                    break;
                case 52:
                    if (zzT(obj, i11, i8)) {
                        zzeyVar.zzo(i11, zzn(obj, j));
                    }
                    i2 = 0;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (zzT(obj, i11, i8)) {
                        zzeyVar.zzt(i11, zzz(obj, j));
                    }
                    i2 = 0;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (zzT(obj, i11, i8)) {
                        zzeyVar.zzJ(i11, zzz(obj, j));
                    }
                    i2 = 0;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (zzT(obj, i11, i8)) {
                        zzeyVar.zzr(i11, zzp(obj, j));
                    }
                    i2 = 0;
                    break;
                case 56:
                    if (zzT(obj, i11, i8)) {
                        zzeyVar.zzm(i11, zzz(obj, j));
                    }
                    i2 = 0;
                    break;
                case 57:
                    if (zzT(obj, i11, i8)) {
                        zzeyVar.zzk(i11, zzp(obj, j));
                    }
                    i2 = 0;
                    break;
                case 58:
                    if (zzT(obj, i11, i8)) {
                        zzeyVar.zzb(i11, zzU(obj, j));
                    }
                    i2 = 0;
                    break;
                case 59:
                    if (zzT(obj, i11, i8)) {
                        zzV(i11, unsafe.getObject(obj, j), zzeyVar);
                    }
                    i2 = 0;
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzT(obj, i11, i8)) {
                        zzeyVar.zzv(i11, unsafe.getObject(obj, j), zzB(i8));
                    }
                    i2 = 0;
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzT(obj, i11, i8)) {
                        zzeyVar.zzd(i11, (zzba) unsafe.getObject(obj, j));
                    }
                    i2 = 0;
                    break;
                case 62:
                    if (zzT(obj, i11, i8)) {
                        zzeyVar.zzH(i11, zzp(obj, j));
                    }
                    i2 = 0;
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzT(obj, i11, i8)) {
                        zzeyVar.zzi(i11, zzp(obj, j));
                    }
                    i2 = 0;
                    break;
                case 64:
                    if (zzT(obj, i11, i8)) {
                        zzeyVar.zzw(i11, zzp(obj, j));
                    }
                    i2 = 0;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (zzT(obj, i11, i8)) {
                        zzeyVar.zzy(i11, zzz(obj, j));
                    }
                    i2 = 0;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (zzT(obj, i11, i8)) {
                        zzeyVar.zzA(i11, zzp(obj, j));
                    }
                    i2 = 0;
                    break;
                case 67:
                    if (zzT(obj, i11, i8)) {
                        zzeyVar.zzC(i11, zzz(obj, j));
                    }
                    i2 = 0;
                    break;
                case 68:
                    if (zzT(obj, i11, i8)) {
                        zzeyVar.zzq(i11, unsafe.getObject(obj, j), zzB(i8));
                    }
                    i2 = 0;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            i8 += 3;
            i4 = i2;
            i5 = 1048575;
        }
        zzeg zzegVar2 = this.zzm;
        zzegVar2.zzi(zzegVar2.zzd(obj), zzeyVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzdp
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzV;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int iZzy = zzy(i);
            long j = iZzy & 1048575;
            switch (zzx(iZzy)) {
                case 0:
                    if (!zzO(obj, obj2, i) || Double.doubleToLongBits(zzeq.zza(obj, j)) != Double.doubleToLongBits(zzeq.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzO(obj, obj2, i) || Float.floatToIntBits(zzeq.zzb(obj, j)) != Float.floatToIntBits(zzeq.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzO(obj, obj2, i) || zzeq.zzd(obj, j) != zzeq.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzO(obj, obj2, i) || zzeq.zzd(obj, j) != zzeq.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzO(obj, obj2, i) || zzeq.zzc(obj, j) != zzeq.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzO(obj, obj2, i) || zzeq.zzd(obj, j) != zzeq.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzO(obj, obj2, i) || zzeq.zzc(obj, j) != zzeq.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzO(obj, obj2, i) || zzeq.zzw(obj, j) != zzeq.zzw(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzO(obj, obj2, i) || !zzdr.zzV(zzeq.zzf(obj, j), zzeq.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzO(obj, obj2, i) || !zzdr.zzV(zzeq.zzf(obj, j), zzeq.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzO(obj, obj2, i) || !zzdr.zzV(zzeq.zzf(obj, j), zzeq.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzO(obj, obj2, i) || zzeq.zzc(obj, j) != zzeq.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzO(obj, obj2, i) || zzeq.zzc(obj, j) != zzeq.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzO(obj, obj2, i) || zzeq.zzc(obj, j) != zzeq.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzO(obj, obj2, i) || zzeq.zzd(obj, j) != zzeq.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzO(obj, obj2, i) || zzeq.zzc(obj, j) != zzeq.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzO(obj, obj2, i) || zzeq.zzd(obj, j) != zzeq.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzO(obj, obj2, i) || !zzdr.zzV(zzeq.zzf(obj, j), zzeq.zzf(obj2, j))) {
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
                    zZzV = zzdr.zzV(zzeq.zzf(obj, j), zzeq.zzf(obj2, j));
                    break;
                case 50:
                    zZzV = zzdr.zzV(zzeq.zzf(obj, j), zzeq.zzf(obj2, j));
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
                    long jZzv = zzv(i) & 1048575;
                    if (zzeq.zzc(obj, jZzv) != zzeq.zzc(obj2, jZzv) || !zzdr.zzV(zzeq.zzf(obj, j), zzeq.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzV) {
                return false;
            }
        }
        if (!this.zzm.zzd(obj).equals(this.zzm.zzd(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzn.zza(obj);
        this.zzn.zza(obj2);
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009e  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:50:0x00c3 A[LOOP:1: B:45:0x00b2->B:50:0x00c3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:66:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x00e1 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.play_billing.zzdp
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        List list;
        zzdp zzdpVarZzB;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i5 < this.zzj) {
            int i7 = this.zzi[i5];
            int i8 = this.zzc[i7];
            int iZzy = zzy(i7);
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
            if ((268435456 & iZzy) != 0 && !zzQ(obj, i7, i, i2, i11)) {
                return false;
            }
            int iZzx = zzx(iZzy);
            if (iZzx == 9 || iZzx == 17) {
                if (zzQ(obj, i7, i, i2, i11) && !zzR(obj, iZzy, zzB(i7))) {
                    return false;
                }
            } else if (iZzx == 27) {
                list = (List) zzeq.zzf(obj, iZzy & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzdpVarZzB = zzB(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzdpVarZzB.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzx == 60 || iZzx == 68) {
                if (zzT(obj, i8, i7) && !zzR(obj, iZzy, zzB(i7))) {
                    return false;
                }
            } else if (iZzx == 49) {
                list = (List) zzeq.zzf(obj, iZzy & 1048575);
                if (list.isEmpty()) {
                    zzdpVarZzB = zzB(i7);
                    while (i3 < list.size()) {
                        if (!zzdpVarZzB.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzx == 50 && !((zzcz) zzeq.zzf(obj, iZzy & 1048575)).isEmpty()) {
                throw null;
            }
            i5++;
            i6 = i;
            i4 = i2;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzn.zza(obj);
        throw null;
    }
}
