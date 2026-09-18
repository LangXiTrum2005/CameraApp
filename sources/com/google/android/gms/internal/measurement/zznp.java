package com.google.android.gms.internal.measurement;

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

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zznp<T> implements zznx<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzop.zzq();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zznm zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzoi zzl;
    private final zzls zzm;

    private zznp(int[] iArr, Object[] objArr, int i, int i2, zznm zznmVar, boolean z, int[] iArr2, int i3, int i4, zznr zznrVar, zzmy zzmyVar, zzoi zzoiVar, zzls zzlsVar, zznh zznhVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzlsVar != null && (zznmVar instanceof zzmc)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = zzoiVar;
        this.zzm = zzlsVar;
        this.zzg = zznmVar;
    }

    private static boolean zzA(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzmf) {
            return ((zzmf) obj).zzcf();
        }
        return true;
    }

    private static void zzB(Object obj) {
        if (zzA(obj)) {
            return;
        }
        String strValueOf = String.valueOf(obj);
        String.valueOf(strValueOf);
        throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(strValueOf)));
    }

    private static double zzC(Object obj, long j) {
        return ((Double) zzop.zzn(obj, j)).doubleValue();
    }

    private static float zzD(Object obj, long j) {
        return ((Float) zzop.zzn(obj, j)).floatValue();
    }

    private static int zzE(Object obj, long j) {
        return ((Integer) zzop.zzn(obj, j)).intValue();
    }

    private static long zzF(Object obj, long j) {
        return ((Long) zzop.zzn(obj, j)).longValue();
    }

    private static boolean zzG(Object obj, long j) {
        return ((Boolean) zzop.zzn(obj, j)).booleanValue();
    }

    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzJ(obj, i) == zzJ(obj2, i);
    }

    private final boolean zzI(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzJ(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zzJ(Object obj, int i) {
        int iZzy = zzy(i);
        long j = iZzy & 1048575;
        if (j != 1048575) {
            return (zzop.zzd(obj, j) & (1 << (iZzy >>> 20))) != 0;
        }
        int iZzx = zzx(i);
        long j2 = iZzx & 1048575;
        switch (zzz(iZzx)) {
            case 0:
                return Double.doubleToRawLongBits(zzop.zzl(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzop.zzj(obj, j2)) != 0;
            case 2:
                return zzop.zzf(obj, j2) != 0;
            case 3:
                return zzop.zzf(obj, j2) != 0;
            case 4:
                return zzop.zzd(obj, j2) != 0;
            case 5:
                return zzop.zzf(obj, j2) != 0;
            case 6:
                return zzop.zzd(obj, j2) != 0;
            case 7:
                return zzop.zzh(obj, j2);
            case 8:
                Object objZzn = zzop.zzn(obj, j2);
                if (objZzn instanceof String) {
                    return !((String) objZzn).isEmpty();
                }
                if (objZzn instanceof zzlh) {
                    return !zzlh.zzb.equals(objZzn);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzop.zzn(obj, j2) != null;
            case 10:
                return !zzlh.zzb.equals(zzop.zzn(obj, j2));
            case 11:
                return zzop.zzd(obj, j2) != 0;
            case 12:
                return zzop.zzd(obj, j2) != 0;
            case 13:
                return zzop.zzd(obj, j2) != 0;
            case 14:
                return zzop.zzf(obj, j2) != 0;
            case 15:
                return zzop.zzd(obj, j2) != 0;
            case 16:
                return zzop.zzf(obj, j2) != 0;
            case 17:
                return zzop.zzn(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final void zzK(Object obj, int i) {
        int iZzy = zzy(i);
        long j = 1048575 & iZzy;
        if (j == 1048575) {
            return;
        }
        zzop.zze(obj, j, (1 << (iZzy >>> 20)) | zzop.zzd(obj, j));
    }

    private final boolean zzL(Object obj, int i, int i2) {
        return zzop.zzd(obj, (long) (zzy(i2) & 1048575)) == i;
    }

    private final void zzM(Object obj, int i, int i2) {
        zzop.zze(obj, zzy(i2) & 1048575, i);
    }

    private final int zzN(int i, int i2) {
        int[] iArr = this.zzc;
        int length = (iArr.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
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

    private static final int zzO(byte[] bArr, int i, int i2, zzot zzotVar, Class cls, zzkw zzkwVar) throws IOException {
        int i3;
        zzot zzotVar2 = zzot.DOUBLE;
        switch (zzotVar) {
            case DOUBLE:
                i3 = i + 8;
                zzkwVar.zzc = Double.valueOf(Double.longBitsToDouble(zzkx.zze(bArr, i)));
                break;
            case FLOAT:
                i3 = i + 4;
                zzkwVar.zzc = Float.valueOf(Float.intBitsToFloat(zzkx.zzd(bArr, i)));
                break;
            case INT64:
            case UINT64:
                int iZzc = zzkx.zzc(bArr, i, zzkwVar);
                zzkwVar.zzc = Long.valueOf(zzkwVar.zzb);
                return iZzc;
            case INT32:
            case UINT32:
            case ENUM:
                int iZza = zzkx.zza(bArr, i, zzkwVar);
                zzkwVar.zzc = Integer.valueOf(zzkwVar.zza);
                return iZza;
            case FIXED64:
            case SFIXED64:
                i3 = i + 8;
                zzkwVar.zzc = Long.valueOf(zzkx.zze(bArr, i));
                break;
            case FIXED32:
            case SFIXED32:
                i3 = i + 4;
                zzkwVar.zzc = Integer.valueOf(zzkx.zzd(bArr, i));
                break;
            case BOOL:
                int iZzc2 = zzkx.zzc(bArr, i, zzkwVar);
                zzkwVar.zzc = Boolean.valueOf(zzkwVar.zzb != 0);
                return iZzc2;
            case STRING:
                return zzkx.zzf(bArr, i, zzkwVar);
            case GROUP:
            default:
                throw new RuntimeException("unsupported field type.");
            case MESSAGE:
                return zzkx.zzh(zznu.zza().zzb(cls), bArr, i, i2, zzkwVar);
            case BYTES:
                return zzkx.zzg(bArr, i, zzkwVar);
            case SINT32:
                int iZza2 = zzkx.zza(bArr, i, zzkwVar);
                zzkwVar.zzc = Integer.valueOf(zzlj.zzb(zzkwVar.zza));
                return iZza2;
            case SINT64:
                int iZzc3 = zzkx.zzc(bArr, i, zzkwVar);
                zzkwVar.zzc = Long.valueOf(zzlj.zzc(zzkwVar.zzb));
                return iZzc3;
        }
        return i3;
    }

    private static final void zzP(int i, Object obj, zzov zzovVar) throws IOException {
        if (obj instanceof String) {
            zzovVar.zzm(i, (String) obj);
        } else {
            zzovVar.zzn(i, (zzlh) obj);
        }
    }

    static zzoj zzg(Object obj) {
        zzmf zzmfVar = (zzmf) obj;
        zzoj zzojVar = zzmfVar.zzc;
        if (zzojVar != zzoj.zza()) {
            return zzojVar;
        }
        zzoj zzojVarZzb = zzoj.zzb();
        zzmfVar.zzc = zzojVarZzb;
        return zzojVarZzb;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0265  */
    /* JADX WARN: Code duplicated, block: B:126:0x0268  */
    /* JADX WARN: Code duplicated, block: B:129:0x027f  */
    /* JADX WARN: Code duplicated, block: B:130:0x0282  */
    /* JADX WARN: Code duplicated, block: B:169:0x0345  */
    /* JADX WARN: Code duplicated, block: B:183:0x0391  */
    /* JADX WARN: Code duplicated, block: B:186:0x039a  */
    static zznp zzl(Class cls, zznj zznjVar, zznr zznrVar, zzmy zzmyVar, zzoi zzoiVar, zzls zzlsVar, zznh zznhVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int i2;
        int i3;
        int i4;
        int[] iArr;
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
        int iObjectFieldOffset2;
        int i19;
        int i20;
        int i21;
        Field fieldZzm;
        int i22;
        char cCharAt9;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        Object obj;
        Field fieldZzm2;
        int i28;
        Object obj2;
        Field fieldZzm3;
        int i29;
        char cCharAt10;
        int i30;
        char cCharAt11;
        int i31;
        char cCharAt12;
        int i32;
        char cCharAt13;
        if (!(zznjVar instanceof zznw)) {
            throw null;
        }
        zznw zznwVar = (zznw) zznjVar;
        String strZzd = zznwVar.zzd();
        int length = strZzd.length();
        char c = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i33 = 1;
            while (true) {
                i = i33 + 1;
                if (strZzd.charAt(i33) < 55296) {
                    break;
                }
                i33 = i;
            }
        } else {
            i = 1;
        }
        int i34 = i + 1;
        int iCharAt3 = strZzd.charAt(i);
        if (iCharAt3 >= 55296) {
            int i35 = iCharAt3 & 8191;
            int i36 = 13;
            while (true) {
                i32 = i34 + 1;
                cCharAt13 = strZzd.charAt(i34);
                if (cCharAt13 < 55296) {
                    break;
                }
                i35 |= (cCharAt13 & 8191) << i36;
                i36 += 13;
                i34 = i32;
            }
            iCharAt3 = i35 | (cCharAt13 << i36);
            i34 = i32;
        }
        if (iCharAt3 == 0) {
            i4 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            i2 = 0;
            i5 = 0;
            i3 = 0;
            iArr = zza;
            i6 = 0;
        } else {
            int i37 = i34 + 1;
            int iCharAt4 = strZzd.charAt(i34);
            if (iCharAt4 >= 55296) {
                int i38 = iCharAt4 & 8191;
                int i39 = 13;
                while (true) {
                    i14 = i37 + 1;
                    cCharAt8 = strZzd.charAt(i37);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i38 |= (cCharAt8 & 8191) << i39;
                    i39 += 13;
                    i37 = i14;
                }
                iCharAt4 = i38 | (cCharAt8 << i39);
                i37 = i14;
            }
            int i40 = i37 + 1;
            int iCharAt5 = strZzd.charAt(i37);
            if (iCharAt5 >= 55296) {
                int i41 = iCharAt5 & 8191;
                int i42 = 13;
                while (true) {
                    i13 = i40 + 1;
                    cCharAt7 = strZzd.charAt(i40);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i41 |= (cCharAt7 & 8191) << i42;
                    i42 += 13;
                    i40 = i13;
                }
                iCharAt5 = i41 | (cCharAt7 << i42);
                i40 = i13;
            }
            int i43 = i40 + 1;
            int iCharAt6 = strZzd.charAt(i40);
            if (iCharAt6 >= 55296) {
                int i44 = iCharAt6 & 8191;
                int i45 = 13;
                while (true) {
                    i12 = i43 + 1;
                    cCharAt6 = strZzd.charAt(i43);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i44 |= (cCharAt6 & 8191) << i45;
                    i45 += 13;
                    i43 = i12;
                }
                iCharAt6 = i44 | (cCharAt6 << i45);
                i43 = i12;
            }
            int i46 = i43 + 1;
            int iCharAt7 = strZzd.charAt(i43);
            if (iCharAt7 >= 55296) {
                int i47 = iCharAt7 & 8191;
                int i48 = 13;
                while (true) {
                    i11 = i46 + 1;
                    cCharAt5 = strZzd.charAt(i46);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i47 |= (cCharAt5 & 8191) << i48;
                    i48 += 13;
                    i46 = i11;
                }
                iCharAt7 = i47 | (cCharAt5 << i48);
                i46 = i11;
            }
            int i49 = i46 + 1;
            iCharAt = strZzd.charAt(i46);
            if (iCharAt >= 55296) {
                int i50 = iCharAt & 8191;
                int i51 = 13;
                while (true) {
                    i10 = i49 + 1;
                    cCharAt4 = strZzd.charAt(i49);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt4 & 8191) << i51;
                    i51 += 13;
                    i49 = i10;
                }
                iCharAt = i50 | (cCharAt4 << i51);
                i49 = i10;
            }
            int i52 = i49 + 1;
            iCharAt2 = strZzd.charAt(i49);
            if (iCharAt2 >= 55296) {
                int i53 = iCharAt2 & 8191;
                int i54 = 13;
                while (true) {
                    i9 = i52 + 1;
                    cCharAt3 = strZzd.charAt(i52);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i53 |= (cCharAt3 & 8191) << i54;
                    i54 += 13;
                    i52 = i9;
                }
                iCharAt2 = i53 | (cCharAt3 << i54);
                i52 = i9;
            }
            int i55 = i52 + 1;
            int iCharAt8 = strZzd.charAt(i52);
            if (iCharAt8 >= 55296) {
                int i56 = iCharAt8 & 8191;
                int i57 = 13;
                while (true) {
                    i8 = i55 + 1;
                    cCharAt2 = strZzd.charAt(i55);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i56 |= (cCharAt2 & 8191) << i57;
                    i57 += 13;
                    i55 = i8;
                }
                iCharAt8 = i56 | (cCharAt2 << i57);
                i55 = i8;
            }
            int i58 = i55 + 1;
            int iCharAt9 = strZzd.charAt(i55);
            if (iCharAt9 >= 55296) {
                int i59 = iCharAt9 & 8191;
                int i60 = 13;
                while (true) {
                    i7 = i58 + 1;
                    cCharAt = strZzd.charAt(i58);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i59 |= (cCharAt & 8191) << i60;
                    i60 += 13;
                    i58 = i7;
                }
                iCharAt9 = i59 | (cCharAt << i60);
                i58 = i7;
            }
            int i61 = iCharAt4 + iCharAt4 + iCharAt5;
            int[] iArr2 = new int[iCharAt9 + iCharAt2 + iCharAt8];
            i2 = iCharAt6;
            i3 = iCharAt9;
            i4 = i61;
            iArr = iArr2;
            i5 = iCharAt7;
            i6 = iCharAt4;
            i34 = i58;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zznwVar.zze();
        Class<?> cls2 = zznwVar.zzb().getClass();
        int i62 = i3 + iCharAt2;
        int i63 = iCharAt + iCharAt;
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr = new Object[i63];
        int i64 = i3;
        int i65 = i62;
        int i66 = 0;
        int i67 = 0;
        while (i34 < length) {
            int i68 = i34 + 1;
            int iCharAt10 = strZzd.charAt(i34);
            if (iCharAt10 >= c) {
                int i69 = iCharAt10 & 8191;
                int i70 = i68;
                int i71 = 13;
                while (true) {
                    i31 = i70 + 1;
                    cCharAt12 = strZzd.charAt(i70);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i69 |= (cCharAt12 & 8191) << i71;
                    i71 += 13;
                    i70 = i31;
                }
                iCharAt10 = i69 | (cCharAt12 << i71);
                i15 = i31;
            } else {
                i15 = i68;
            }
            int i72 = i15 + 1;
            int iCharAt11 = strZzd.charAt(i15);
            if (iCharAt11 >= c) {
                int i73 = iCharAt11 & 8191;
                int i74 = i72;
                int i75 = 13;
                while (true) {
                    i30 = i74 + 1;
                    cCharAt11 = strZzd.charAt(i74);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i73 |= (cCharAt11 & 8191) << i75;
                    i75 += 13;
                    i74 = i30;
                }
                iCharAt11 = i73 | (cCharAt11 << i75);
                i16 = i30;
            } else {
                i16 = i72;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i66] = i67;
                i66++;
            }
            int i76 = iCharAt11 & 255;
            int i77 = length;
            int i78 = iCharAt11 & 2048;
            int i79 = i5;
            if (i76 >= 51) {
                int i80 = i16 + 1;
                int iCharAt12 = strZzd.charAt(i16);
                if (iCharAt12 >= 55296) {
                    int i81 = iCharAt12 & 8191;
                    int i82 = i80;
                    int i83 = 13;
                    while (true) {
                        i29 = i82 + 1;
                        cCharAt10 = strZzd.charAt(i82);
                        i17 = i2;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i81 |= (cCharAt10 & 8191) << i83;
                        i83 += 13;
                        i82 = i29;
                        i2 = i17;
                    }
                    iCharAt12 = i81 | (cCharAt10 << i83);
                    i25 = i29;
                } else {
                    i17 = i2;
                    i25 = i80;
                }
                int i84 = i76 - 51;
                int i85 = i25;
                if (i84 == 9 || i84 == 17) {
                    i26 = i4 + 1;
                    int i86 = i67 / 3;
                    objArr[i86 + i86 + 1] = objArrZze[i4];
                } else {
                    if (i84 == 12) {
                        if (zznwVar.zzc() == 1 || i78 != 0) {
                            i26 = i4 + 1;
                            int i87 = i67 / 3;
                            objArr[i87 + i87 + 1] = objArrZze[i4];
                        } else {
                            i78 = 0;
                        }
                    }
                    i27 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i27];
                    if (obj instanceof Field) {
                        fieldZzm2 = (Field) obj;
                    } else {
                        fieldZzm2 = zzm(cls2, (String) obj);
                        objArrZze[i27] = fieldZzm2;
                    }
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzm2);
                    i28 = i27 + 1;
                    obj2 = objArrZze[i28];
                    int i88 = i78;
                    if (obj2 instanceof Field) {
                        fieldZzm3 = (Field) obj2;
                    } else {
                        fieldZzm3 = zzm(cls2, (String) obj2);
                        objArrZze[i28] = fieldZzm3;
                    }
                    i18 = i4;
                    i19 = i85;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzm3);
                    i20 = 0;
                    strZzd = strZzd;
                    zznwVar = zznwVar;
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i21 = i88;
                }
                i4 = i26;
                i27 = iCharAt12 + iCharAt12;
                obj = objArrZze[i27];
                if (obj instanceof Field) {
                    fieldZzm2 = (Field) obj;
                } else {
                    fieldZzm2 = zzm(cls2, (String) obj);
                    objArrZze[i27] = fieldZzm2;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzm2);
                i28 = i27 + 1;
                obj2 = objArrZze[i28];
                int i89 = i78;
                if (obj2 instanceof Field) {
                    fieldZzm3 = (Field) obj2;
                } else {
                    fieldZzm3 = zzm(cls2, (String) obj2);
                    objArrZze[i28] = fieldZzm3;
                }
                i18 = i4;
                i19 = i85;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzm3);
                i20 = 0;
                strZzd = strZzd;
                zznwVar = zznwVar;
                iObjectFieldOffset = iObjectFieldOffset4;
                i21 = i89;
            } else {
                i17 = i2;
                i18 = i4 + 1;
                Field fieldZzm4 = zzm(cls2, (String) objArrZze[i4]);
                if (i76 == 9 || i76 == 17) {
                    int i90 = i67 / 3;
                    objArr[i90 + i90 + 1] = fieldZzm4.getType();
                } else {
                    if (i76 != 27) {
                        if (i76 == 49) {
                            i24 = i4 + 2;
                            i23 = 1;
                        } else if (i76 == 12 || i76 == 30 || i76 == 44) {
                            zznwVar = zznwVar;
                            if (zznwVar.zzc() == 1 || i78 != 0) {
                                i24 = i4 + 2;
                                int i91 = i67 / 3;
                                objArr[i91 + i91 + 1] = objArrZze[i18];
                                i18 = i24;
                            } else {
                                i78 = 0;
                            }
                        } else if (i76 == 50) {
                            int i92 = i4 + 2;
                            int i93 = i64 + 1;
                            iArr[i64] = i67;
                            int i94 = i67 / 3;
                            int i95 = i94 + i94;
                            objArr[i95] = objArrZze[i18];
                            if (i78 != 0) {
                                i18 = i4 + 3;
                                objArr[i95 + 1] = objArrZze[i92];
                                i64 = i93;
                                zznwVar = zznwVar;
                            } else {
                                i18 = i92;
                                i64 = i93;
                                i78 = 0;
                            }
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzm4);
                        iObjectFieldOffset2 = 1048575;
                        if ((iCharAt11 & 4096) != 0 || i76 > 17) {
                            i19 = i16;
                            i20 = 0;
                        } else {
                            int i96 = i16 + 1;
                            int iCharAt13 = strZzd.charAt(i16);
                            if (iCharAt13 >= 55296) {
                                int i97 = iCharAt13 & 8191;
                                int i98 = 13;
                                while (true) {
                                    i22 = i96 + 1;
                                    cCharAt9 = strZzd.charAt(i96);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i97 |= (cCharAt9 & 8191) << i98;
                                    i98 += 13;
                                    i96 = i22;
                                }
                                iCharAt13 = i97 | (cCharAt9 << i98);
                                i96 = i22;
                            }
                            int i99 = i6 + i6 + (iCharAt13 / 32);
                            Object obj3 = objArrZze[i99];
                            i19 = i96;
                            if (obj3 instanceof Field) {
                                fieldZzm = (Field) obj3;
                            } else {
                                fieldZzm = zzm(cls2, (String) obj3);
                                objArrZze[i99] = fieldZzm;
                            }
                            i20 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzm);
                        }
                        if (i76 >= 18 && i76 <= 49) {
                            iArr[i65] = iObjectFieldOffset;
                            i65++;
                        }
                        i21 = i78;
                    } else {
                        i23 = 1;
                        i24 = i4 + 2;
                    }
                    int i100 = i67 / 3;
                    objArr[i100 + i100 + i23] = objArrZze[i18];
                    i18 = i24;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzm4);
                    iObjectFieldOffset2 = 1048575;
                    if ((iCharAt11 & 4096) != 0) {
                        i19 = i16;
                        i20 = 0;
                    } else {
                        i19 = i16;
                        i20 = 0;
                    }
                    if (i76 >= 18) {
                        iArr[i65] = iObjectFieldOffset;
                        i65++;
                    }
                    i21 = i78;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzm4);
                iObjectFieldOffset2 = 1048575;
                if ((iCharAt11 & 4096) != 0) {
                    i19 = i16;
                    i20 = 0;
                } else {
                    i19 = i16;
                    i20 = 0;
                }
                if (i76 >= 18) {
                    iArr[i65] = iObjectFieldOffset;
                    i65++;
                }
                i21 = i78;
            }
            int i101 = i67 + 1;
            iArr3[i67] = iCharAt10;
            int i102 = i67 + 2;
            Class<?> cls3 = cls2;
            iArr3[i101] = iObjectFieldOffset | (i21 != 0 ? Integer.MIN_VALUE : 0) | ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i76 << 20);
            i67 += 3;
            iArr3[i102] = (i20 << 20) | iObjectFieldOffset2;
            strZzd = strZzd;
            i4 = i18;
            length = i77;
            i5 = i79;
            cls2 = cls3;
            zznwVar = zznwVar;
            i34 = i19;
            i2 = i17;
            c = 55296;
        }
        return new zznp(iArr3, objArr, i2, i5, zznwVar.zzb(), false, iArr, i3, i62, zznrVar, zzmyVar, zzoiVar, zzlsVar, zznhVar);
    }

    private static Field zzm(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(name).length() + 29 + String.valueOf(string).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(string);
            throw new RuntimeException(sb.toString(), e);
        }
    }

    private final void zzn(Object obj, Object obj2, int i) {
        if (zzJ(obj2, i)) {
            int iZzx = zzx(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzx;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                int i2 = this.zzc[i];
                String string = obj2.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 38 + string.length());
                sb.append("Source subfield ");
                sb.append(i2);
                sb.append(" is present but null: ");
                sb.append(string);
                throw new IllegalStateException(sb.toString());
            }
            zznx zznxVarZzp = zzp(i);
            if (!zzJ(obj, i)) {
                if (zzA(object)) {
                    Object objZza = zznxVarZzp.zza();
                    zznxVarZzp.zzd(objZza, object);
                    unsafe.putObject(obj, j, objZza);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzK(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzA(object2)) {
                Object objZza2 = zznxVarZzp.zza();
                zznxVarZzp.zzd(objZza2, object2);
                unsafe.putObject(obj, j, objZza2);
                object2 = objZza2;
            }
            zznxVarZzp.zzd(object2, object);
        }
    }

    private final void zzo(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzL(obj2, i2, i)) {
            int iZzx = zzx(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzx;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                int i3 = iArr[i];
                String string = obj2.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 38 + string.length());
                sb.append("Source subfield ");
                sb.append(i3);
                sb.append(" is present but null: ");
                sb.append(string);
                throw new IllegalStateException(sb.toString());
            }
            zznx zznxVarZzp = zzp(i);
            if (!zzL(obj, i2, i)) {
                if (zzA(object)) {
                    Object objZza = zznxVarZzp.zza();
                    zznxVarZzp.zzd(objZza, object);
                    unsafe.putObject(obj, j, objZza);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzM(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzA(object2)) {
                Object objZza2 = zznxVarZzp.zza();
                zznxVarZzp.zzd(objZza2, object2);
                unsafe.putObject(obj, j, objZza2);
                object2 = objZza2;
            }
            zznxVarZzp.zzd(object2, object);
        }
    }

    private final zznx zzp(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zznx zznxVar = (zznx) objArr[i3];
        if (zznxVar != null) {
            return zznxVar;
        }
        zznx zznxVarZzb = zznu.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zznxVarZzb;
        return zznxVarZzb;
    }

    private final Object zzq(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final zzmk zzr(int i) {
        int i2 = i / 3;
        return (zzmk) this.zzd[i2 + i2 + 1];
    }

    private final Object zzs(Object obj, int i) {
        zznx zznxVarZzp = zzp(i);
        int iZzx = zzx(i) & 1048575;
        if (!zzJ(obj, i)) {
            return zznxVarZzp.zza();
        }
        Object object = zzb.getObject(obj, iZzx);
        if (zzA(object)) {
            return object;
        }
        Object objZza = zznxVarZzp.zza();
        if (object != null) {
            zznxVarZzp.zzd(objZza, object);
        }
        return objZza;
    }

    private final void zzt(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzx(i) & 1048575, obj2);
        zzK(obj, i);
    }

    private final Object zzu(Object obj, int i, int i2) {
        zznx zznxVarZzp = zzp(i2);
        if (!zzL(obj, i, i2)) {
            return zznxVarZzp.zza();
        }
        Object object = zzb.getObject(obj, zzx(i2) & 1048575);
        if (zzA(object)) {
            return object;
        }
        Object objZza = zznxVarZzp.zza();
        if (object != null) {
            zznxVarZzp.zzd(objZza, object);
        }
        return objZza;
    }

    private final void zzv(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzx(i2) & 1048575, obj2);
        zzM(obj, i, i2);
    }

    private static boolean zzw(Object obj, int i, zznx zznxVar) {
        return zznxVar.zzk(zzop.zzn(obj, i & 1048575));
    }

    private final int zzx(int i) {
        return this.zzc[i + 1];
    }

    private final int zzy(int i) {
        return this.zzc[i + 2];
    }

    private static int zzz(int i) {
        return (i >>> 20) & 255;
    }

    @Override // com.google.android.gms.internal.measurement.zznx
    public final Object zza() {
        return ((zzmf) this.zzg).zzch();
    }

    @Override // com.google.android.gms.internal.measurement.zznx
    public final boolean zzb(Object obj, Object obj2) {
        boolean zZzB;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzx = zzx(i);
            long j = iZzx & 1048575;
            switch (zzz(iZzx)) {
                case 0:
                    if (!zzH(obj, obj2, i) || Double.doubleToLongBits(zzop.zzl(obj, j)) != Double.doubleToLongBits(zzop.zzl(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzH(obj, obj2, i) || Float.floatToIntBits(zzop.zzj(obj, j)) != Float.floatToIntBits(zzop.zzj(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzH(obj, obj2, i) || zzop.zzf(obj, j) != zzop.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzH(obj, obj2, i) || zzop.zzf(obj, j) != zzop.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzH(obj, obj2, i) || zzop.zzd(obj, j) != zzop.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzH(obj, obj2, i) || zzop.zzf(obj, j) != zzop.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzH(obj, obj2, i) || zzop.zzd(obj, j) != zzop.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzH(obj, obj2, i) || zzop.zzh(obj, j) != zzop.zzh(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzH(obj, obj2, i) || !zznz.zzB(zzop.zzn(obj, j), zzop.zzn(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzH(obj, obj2, i) || !zznz.zzB(zzop.zzn(obj, j), zzop.zzn(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzH(obj, obj2, i) || !zznz.zzB(zzop.zzn(obj, j), zzop.zzn(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzH(obj, obj2, i) || zzop.zzd(obj, j) != zzop.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzH(obj, obj2, i) || zzop.zzd(obj, j) != zzop.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzH(obj, obj2, i) || zzop.zzd(obj, j) != zzop.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzH(obj, obj2, i) || zzop.zzf(obj, j) != zzop.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzH(obj, obj2, i) || zzop.zzd(obj, j) != zzop.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzH(obj, obj2, i) || zzop.zzf(obj, j) != zzop.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzH(obj, obj2, i) || !zznz.zzB(zzop.zzn(obj, j), zzop.zzn(obj2, j))) {
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
                    zZzB = zznz.zzB(zzop.zzn(obj, j), zzop.zzn(obj2, j));
                    break;
                case 50:
                    zZzB = zznz.zzB(zzop.zzn(obj, j), zzop.zzn(obj2, j));
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
                    long jZzy = zzy(i) & 1048575;
                    if (zzop.zzd(obj, jZzy) != zzop.zzd(obj2, jZzy) || !zznz.zzB(zzop.zzn(obj, j), zzop.zzn(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzB) {
                return false;
            }
        }
        if (!((zzmf) obj).zzc.equals(((zzmf) obj2).zzc)) {
            return false;
        }
        if (this.zzh) {
            return ((zzmc) obj).zzb.equals(((zzmc) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zznx
    public final int zzc(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i3 >= iArr.length) {
                int iHashCode = (i4 * 53) + ((zzmf) obj).zzc.hashCode();
                return this.zzh ? (iHashCode * 53) + ((zzmc) obj).zzb.zza.hashCode() : iHashCode;
            }
            int iZzx = zzx(i3);
            int i5 = 1048575 & iZzx;
            int iZzz = zzz(iZzx);
            int i6 = iArr[i3];
            long j = i5;
            int iHashCode2 = 37;
            switch (iZzz) {
                case 0:
                    i = i4 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzop.zzl(obj, j));
                    byte[] bArr = zzmp.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i4 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzop.zzj(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i4 * 53;
                    jDoubleToLongBits = zzop.zzf(obj, j);
                    byte[] bArr2 = zzmp.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i4 * 53;
                    jDoubleToLongBits = zzop.zzf(obj, j);
                    byte[] bArr3 = zzmp.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i4 * 53;
                    iFloatToIntBits = zzop.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i4 * 53;
                    jDoubleToLongBits = zzop.zzf(obj, j);
                    byte[] bArr4 = zzmp.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i4 * 53;
                    iFloatToIntBits = zzop.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i4 * 53;
                    iFloatToIntBits = zzmp.zzb(zzop.zzh(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i4 * 53;
                    iFloatToIntBits = ((String) zzop.zzn(obj, j)).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 9:
                    i2 = i4 * 53;
                    Object objZzn = zzop.zzn(obj, j);
                    if (objZzn != null) {
                        iHashCode2 = objZzn.hashCode();
                    }
                    i4 = i2 + iHashCode2;
                    break;
                case 10:
                    i = i4 * 53;
                    iFloatToIntBits = zzop.zzn(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i4 * 53;
                    iFloatToIntBits = zzop.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i4 * 53;
                    iFloatToIntBits = zzop.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i4 * 53;
                    iFloatToIntBits = zzop.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i4 * 53;
                    jDoubleToLongBits = zzop.zzf(obj, j);
                    byte[] bArr5 = zzmp.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i4 * 53;
                    iFloatToIntBits = zzop.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i4 * 53;
                    jDoubleToLongBits = zzop.zzf(obj, j);
                    byte[] bArr6 = zzmp.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 17:
                    i2 = i4 * 53;
                    Object objZzn2 = zzop.zzn(obj, j);
                    if (objZzn2 != null) {
                        iHashCode2 = objZzn2.hashCode();
                    }
                    i4 = i2 + iHashCode2;
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
                    i = i4 * 53;
                    iFloatToIntBits = zzop.zzn(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i4 * 53;
                    iFloatToIntBits = zzop.zzn(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzL(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzC(obj, j));
                        byte[] bArr7 = zzmp.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzL(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzD(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (zzL(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzF(obj, j);
                        byte[] bArr8 = zzmp.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (zzL(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzF(obj, j);
                        byte[] bArr9 = zzmp.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (zzL(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzE(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzL(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzF(obj, j);
                        byte[] bArr10 = zzmp.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzL(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzE(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzL(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzmp.zzb(zzG(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzL(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = ((String) zzop.zzn(obj, j)).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzL(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzop.zzn(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzL(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzop.zzn(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzL(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzE(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzL(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzE(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzL(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzE(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (zzL(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzF(obj, j);
                        byte[] bArr11 = zzmp.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (zzL(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzE(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzL(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzF(obj, j);
                        byte[] bArr12 = zzmp.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzL(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzop.zzn(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
            }
            i3 += 3;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zznx
    public final void zzd(Object obj, Object obj2) {
        zzB(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i >= iArr.length) {
                zznz.zzD(this.zzl, obj, obj2);
                if (this.zzh) {
                    zznz.zzC(this.zzm, obj, obj2);
                    return;
                }
                return;
            }
            int iZzx = zzx(i);
            int i2 = 1048575 & iZzx;
            int iZzz = zzz(iZzx);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzz) {
                case 0:
                    if (zzJ(obj2, i)) {
                        zzop.zzm(obj, j, zzop.zzl(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 1:
                    if (zzJ(obj2, i)) {
                        zzop.zzk(obj, j, zzop.zzj(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 2:
                    if (zzJ(obj2, i)) {
                        zzop.zzg(obj, j, zzop.zzf(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 3:
                    if (zzJ(obj2, i)) {
                        zzop.zzg(obj, j, zzop.zzf(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 4:
                    if (zzJ(obj2, i)) {
                        zzop.zze(obj, j, zzop.zzd(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 5:
                    if (zzJ(obj2, i)) {
                        zzop.zzg(obj, j, zzop.zzf(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 6:
                    if (zzJ(obj2, i)) {
                        zzop.zze(obj, j, zzop.zzd(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 7:
                    if (zzJ(obj2, i)) {
                        zzop.zzi(obj, j, zzop.zzh(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 8:
                    if (zzJ(obj2, i)) {
                        zzop.zzo(obj, j, zzop.zzn(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 9:
                    zzn(obj, obj2, i);
                    break;
                case 10:
                    if (zzJ(obj2, i)) {
                        zzop.zzo(obj, j, zzop.zzn(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 11:
                    if (zzJ(obj2, i)) {
                        zzop.zze(obj, j, zzop.zzd(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 12:
                    if (zzJ(obj2, i)) {
                        zzop.zze(obj, j, zzop.zzd(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 13:
                    if (zzJ(obj2, i)) {
                        zzop.zze(obj, j, zzop.zzd(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 14:
                    if (zzJ(obj2, i)) {
                        zzop.zzg(obj, j, zzop.zzf(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 15:
                    if (zzJ(obj2, i)) {
                        zzop.zze(obj, j, zzop.zzd(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 16:
                    if (zzJ(obj2, i)) {
                        zzop.zzg(obj, j, zzop.zzf(obj2, j));
                        zzK(obj, i);
                    }
                    break;
                case 17:
                    zzn(obj, obj2, i);
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
                    zzmo zzmoVarZzg = (zzmo) zzop.zzn(obj, j);
                    zzmo zzmoVar = (zzmo) zzop.zzn(obj2, j);
                    int size = zzmoVarZzg.size();
                    int size2 = zzmoVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzmoVarZzg.zza()) {
                            zzmoVarZzg = zzmoVarZzg.zzg(size2 + size);
                        }
                        zzmoVarZzg.addAll(zzmoVar);
                    }
                    if (size > 0) {
                        zzmoVar = zzmoVarZzg;
                    }
                    zzop.zzo(obj, j, zzmoVar);
                    break;
                case 50:
                    int i4 = zznz.zza;
                    zzop.zzo(obj, j, zznh.zza(zzop.zzn(obj, j), zzop.zzn(obj2, j)));
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
                    if (zzL(obj2, i3, i)) {
                        zzop.zzo(obj, j, zzop.zzn(obj2, j));
                        zzM(obj, i3, i);
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    zzo(obj, obj2, i);
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                case 62:
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                case 64:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                case 67:
                    if (zzL(obj2, i3, i)) {
                        zzop.zzo(obj, j, zzop.zzn(obj2, j));
                        zzM(obj, i3, i);
                    }
                    break;
                case 68:
                    zzo(obj, obj2, i);
                    break;
            }
            i += 3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:137:0x0392  */
    /* JADX WARN: Code duplicated, block: B:207:0x0553  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v115, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v118, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v120, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v137 */
    /* JADX WARN: Type inference failed for: r0v185, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v253, types: [int] */
    /* JADX WARN: Type inference failed for: r0v261 */
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
    /* JADX WARN: Type inference failed for: r0v276 */
    /* JADX WARN: Type inference failed for: r0v277 */
    /* JADX WARN: Type inference failed for: r0v278 */
    /* JADX WARN: Type inference failed for: r0v279 */
    /* JADX WARN: Type inference failed for: r0v280 */
    /* JADX WARN: Type inference failed for: r12v4, types: [int] */
    /* JADX WARN: Type inference failed for: r12v5, types: [int] */
    /* JADX WARN: Type inference failed for: r12v6, types: [int] */
    /* JADX WARN: Type inference failed for: r12v7, types: [int] */
    /* JADX WARN: Type inference failed for: r12v9, types: [int] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v118, types: [int] */
    /* JADX WARN: Type inference failed for: r1v121, types: [int] */
    /* JADX WARN: Type inference failed for: r1v158 */
    /* JADX WARN: Type inference failed for: r1v161 */
    /* JADX WARN: Type inference failed for: r1v162 */
    /* JADX WARN: Type inference failed for: r1v164 */
    /* JADX WARN: Type inference failed for: r1v165 */
    /* JADX WARN: Type inference failed for: r1v166 */
    /* JADX WARN: Type inference failed for: r1v78, types: [int] */
    /* JADX WARN: Type inference failed for: r1v80 */
    /* JADX WARN: Type inference failed for: r2v31, types: [int] */
    /* JADX WARN: Type inference failed for: r2v39, types: [int] */
    /* JADX WARN: Type inference failed for: r2v43, types: [int] */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52, types: [int] */
    /* JADX WARN: Type inference failed for: r2v80 */
    /* JADX WARN: Type inference failed for: r2v81, types: [int] */
    /* JADX WARN: Type inference failed for: r2v83 */
    /* JADX WARN: Type inference failed for: r2v84, types: [int] */
    /* JADX WARN: Type inference failed for: r2v94 */
    /* JADX WARN: Type inference failed for: r2v95 */
    /* JADX WARN: Type inference failed for: r2v96 */
    /* JADX WARN: Type inference failed for: r2v97 */
    /* JADX WARN: Type inference failed for: r2v98 */
    /* JADX WARN: Type inference failed for: r2v99 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28, types: [int] */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31, types: [int] */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v40, types: [int] */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v47, types: [int] */
    /* JADX WARN: Type inference failed for: r3v57 */
    /* JADX WARN: Type inference failed for: r3v58 */
    /* JADX WARN: Type inference failed for: r3v59 */
    /* JADX WARN: Type inference failed for: r3v60 */
    /* JADX WARN: Type inference failed for: r3v61 */
    /* JADX WARN: Type inference failed for: r3v62 */
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
    /* JADX WARN: Type inference failed for: r4v59 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v60 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.gms.internal.measurement.zznx
    public final int zze(Object obj) {
        int i;
        ?? r16;
        ?? r5;
        int iZzz;
        int iZzz2;
        int iZzz3;
        int iZzA;
        int iZzz4;
        int iZzz5;
        int iZzc;
        int iZzz6;
        ?? Zzo;
        int size;
        int iZzz7;
        int iZzB;
        int iZzB2;
        ?? r3;
        int iZzD;
        ?? Zzz;
        ?? Zzz2;
        int iZzx;
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
        while (true) {
            int[] iArr = this.zzc;
            if (i3 >= iArr.length) {
                int iZzi = i4 + ((zzmf) obj).zzc.zzi();
                if (!this.zzh) {
                    return iZzi;
                }
                zzoe zzoeVar = ((zzmc) obj).zzb.zza;
                int iZzc2 = zzoeVar.zzc();
                int iZzj = 0;
                for (int i6 = 0; i6 < iZzc2; i6++) {
                    Map.Entry entryZzd = zzoeVar.zzd(i6);
                    iZzj += zzlw.zzj((zzlv) ((zzob) entryZzd).zza(), entryZzd.getValue());
                }
                for (Map.Entry entry : zzoeVar.zze()) {
                    iZzj += zzlw.zzj((zzlv) entry.getKey(), entry.getValue());
                }
                return iZzi + iZzj;
            }
            int iZzx2 = zzx(i3);
            int iZzz10 = zzz(iZzx2);
            int i7 = iArr[i3];
            int i8 = iArr[i3 + 2];
            int i9 = i8 & i2;
            if (iZzz10 <= 17) {
                if (i9 != i5) {
                    r1 = i9 == i2 ? z : unsafe.getInt(obj, i9);
                    i5 = i9;
                }
                i = i5;
                r16 = r1;
                r5 = 1 << (i8 >>> 20);
            } else {
                r1 = r2;
                i = i5;
                r16 = r2 == true ? 1 : 0;
                r5 = z;
            }
            int i10 = iZzx2 & i2;
            if (iZzz10 >= zzlx.DOUBLE_LIST_PACKED.zza()) {
                zzlx.SINT64_LIST_PACKED.zza();
            }
            long j = i10;
            switch (iZzz10) {
                case 0:
                    if (zzI(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz = zzlm.zzz(i7 << 3);
                        Zzz2 = iZzz + 8;
                        i4 += Zzz2;
                    }
                    break;
                case 1:
                    if (zzI(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz2 = zzlm.zzz(i7 << 3);
                        Zzz2 = iZzz2 + 4;
                        i4 += Zzz2;
                    }
                    break;
                case 2:
                    if (zzI(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzz3 = zzlm.zzz(i7 << 3);
                        iZzA = zzlm.zzA(j2);
                        Zzz2 = iZzz3 + iZzA;
                        i4 += Zzz2;
                    }
                    break;
                case 3:
                    if (zzI(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j3 = unsafe.getLong(obj, j);
                        iZzz3 = zzlm.zzz(i7 << 3);
                        iZzA = zzlm.zzA(j3);
                        Zzz2 = iZzz3 + iZzA;
                        i4 += Zzz2;
                    }
                    break;
                case 4:
                    if (zzI(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j4 = unsafe.getInt(obj, j);
                        iZzz3 = zzlm.zzz(i7 << 3);
                        iZzA = zzlm.zzA(j4);
                        Zzz2 = iZzz3 + iZzA;
                        i4 += Zzz2;
                    }
                    break;
                case 5:
                    if (zzI(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz = zzlm.zzz(i7 << 3);
                        Zzz2 = iZzz + 8;
                        i4 += Zzz2;
                    }
                    break;
                case 6:
                    if (zzI(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz2 = zzlm.zzz(i7 << 3);
                        Zzz2 = iZzz2 + 4;
                        i4 += Zzz2;
                    }
                    break;
                case 7:
                    if (zzI(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz4 = zzlm.zzz(i7 << 3);
                        Zzz2 = iZzz4 + 1;
                        i4 += Zzz2;
                    }
                    break;
                case 8:
                    if (zzI(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        int i11 = i7 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzlh) {
                            iZzz5 = zzlm.zzz(i11);
                            iZzc = ((zzlh) object).zzc();
                            iZzz6 = zzlm.zzz(iZzc);
                            Zzz2 = iZzz5 + iZzz6 + iZzc;
                            i4 += Zzz2;
                        } else {
                            iZzz3 = zzlm.zzz(i11);
                            iZzA = zzlm.zzB((String) object);
                            Zzz2 = iZzz3 + iZzA;
                            i4 += Zzz2;
                        }
                    }
                    break;
                case 9:
                    if (zzI(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        Zzz2 = zznz.zzz(i7, unsafe.getObject(obj, j), zzp(i3));
                        i4 += Zzz2;
                    }
                    break;
                case 10:
                    if (zzI(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        zzlh zzlhVar = (zzlh) unsafe.getObject(obj, j);
                        iZzz5 = zzlm.zzz(i7 << 3);
                        iZzc = zzlhVar.zzc();
                        iZzz6 = zzlm.zzz(iZzc);
                        Zzz2 = iZzz5 + iZzz6 + iZzc;
                        i4 += Zzz2;
                    }
                    break;
                case 11:
                    if (zzI(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        int i12 = unsafe.getInt(obj, j);
                        iZzz3 = zzlm.zzz(i7 << 3);
                        iZzA = zzlm.zzz(i12);
                        Zzz2 = iZzz3 + iZzA;
                        i4 += Zzz2;
                    }
                    break;
                case 12:
                    if (zzI(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j5 = unsafe.getInt(obj, j);
                        iZzz3 = zzlm.zzz(i7 << 3);
                        iZzA = zzlm.zzA(j5);
                        Zzz2 = iZzz3 + iZzA;
                        i4 += Zzz2;
                    }
                    break;
                case 13:
                    if (zzI(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz2 = zzlm.zzz(i7 << 3);
                        Zzz2 = iZzz2 + 4;
                        i4 += Zzz2;
                    }
                    break;
                case 14:
                    if (zzI(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        iZzz = zzlm.zzz(i7 << 3);
                        Zzz2 = iZzz + 8;
                        i4 += Zzz2;
                    }
                    break;
                case 15:
                    if (zzI(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        int i13 = unsafe.getInt(obj, j);
                        iZzz3 = zzlm.zzz(i7 << 3);
                        iZzA = zzlm.zzz((i13 >> 31) ^ (i13 + i13));
                        Zzz2 = iZzz3 + iZzA;
                        i4 += Zzz2;
                    }
                    break;
                case 16:
                    if (zzI(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        long j6 = unsafe.getLong(obj, j);
                        iZzz3 = zzlm.zzz(i7 << 3);
                        iZzA = zzlm.zzA((j6 >> 63) ^ (j6 + j6));
                        Zzz2 = iZzz3 + iZzA;
                        i4 += Zzz2;
                    }
                    break;
                case 17:
                    if (zzI(obj, i3, i, r16 == true ? 1 : 0, r5)) {
                        Zzz2 = zzlm.zzG(i7, (zznm) unsafe.getObject(obj, j), zzp(i3));
                        i4 += Zzz2;
                    }
                    break;
                case 18:
                    Zzz2 = zznz.zzy(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzz2;
                    break;
                case 19:
                    Zzz2 = zznz.zzw(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzz2;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i14 = zznz.zza;
                    if (list.size() == 0) {
                        Zzo = z;
                    } else {
                        Zzo = zznz.zzo(list) + (list.size() * zzlm.zzz(i7 << 3));
                    }
                    i4 += Zzo;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i15 = zznz.zza;
                    size = list2.size();
                    if (size == 0) {
                        Zzz2 = z;
                    } else {
                        iZzz3 = zznz.zzp(list2);
                        iZzz7 = zzlm.zzz(i7 << 3);
                        iZzA = size * iZzz7;
                        Zzz2 = iZzz3 + iZzA;
                    }
                    i4 += Zzz2;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i16 = zznz.zza;
                    size = list3.size();
                    if (size == 0) {
                        Zzz2 = z;
                    } else {
                        iZzz3 = zznz.zzs(list3);
                        iZzz7 = zzlm.zzz(i7 << 3);
                        iZzA = size * iZzz7;
                        Zzz2 = iZzz3 + iZzA;
                    }
                    i4 += Zzz2;
                    break;
                case 23:
                    Zzz2 = zznz.zzy(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzz2;
                    break;
                case 24:
                    Zzz2 = zznz.zzw(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzz2;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i17 = zznz.zza;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        Zzz2 = z;
                    } else {
                        Zzz2 = size2 * (zzlm.zzz(i7 << 3) + 1);
                    }
                    i4 += Zzz2;
                    break;
                case 26:
                    ?? r0 = (List) unsafe.getObject(obj, j);
                    int i18 = zznz.zza;
                    int size3 = r0.size();
                    if (size3 == 0) {
                        Zzo = z;
                    } else {
                        int iZzz11 = zzlm.zzz(i7 << 3) * size3;
                        if (r0 instanceof zzmx) {
                            zzmx zzmxVar = (zzmx) r0;
                            for (?? r7 = z; r7 < size3; r7++) {
                                Object objZzc = zzmxVar.zzc();
                                if (objZzc instanceof zzlh) {
                                    Zzo = iZzz11;
                                    int iZzc3 = ((zzlh) objZzc).zzc();
                                    iZzB2 = Zzo + zzlm.zzz(iZzc3) + iZzc3;
                                } else {
                                    Zzo = iZzz11;
                                    iZzB2 = Zzo + zzlm.zzB((String) objZzc);
                                }
                                Zzo = iZzB2;
                            }
                            Zzo = iZzz11;
                        } else {
                            for (?? r8 = z; r8 < size3; r8++) {
                                Object obj2 = r0.get(r8);
                                if (obj2 instanceof zzlh) {
                                    Zzo = iZzz11;
                                    int iZzc4 = ((zzlh) obj2).zzc();
                                    iZzB = Zzo + zzlm.zzz(iZzc4) + iZzc4;
                                } else {
                                    Zzo = iZzz11;
                                    iZzB = Zzo + zzlm.zzB((String) obj2);
                                }
                                Zzo = iZzB;
                            }
                            Zzo = iZzz11;
                        }
                    }
                    i4 += Zzo;
                    break;
                case 27:
                    ?? r9 = (List) unsafe.getObject(obj, j);
                    zznx zznxVarZzp = zzp(i3);
                    int i19 = zznz.zza;
                    int size4 = r9.size();
                    if (size4 == 0) {
                        r3 = z;
                    } else {
                        int iZzz12 = zzlm.zzz(i7 << 3) * size4;
                        for (?? r10 = z; r10 < size4; r10++) {
                            Object obj3 = r9.get(r10);
                            if (obj3 instanceof zzmw) {
                                r3 = iZzz12;
                                int iZzb = ((zzmw) obj3).zzb();
                                iZzD = (r3 == true ? 1 : 0) + zzlm.zzz(iZzb) + iZzb;
                            } else {
                                r3 = iZzz12;
                                iZzD = (r3 == true ? 1 : 0) + zzlm.zzD((zznm) obj3, zznxVarZzp);
                            }
                            r3 = iZzD;
                        }
                        r3 = iZzz12;
                    }
                    i4 += r3;
                    break;
                case 28:
                    ?? r11 = (List) unsafe.getObject(obj, j);
                    int i20 = zznz.zza;
                    int size5 = r11.size();
                    if (size5 == 0) {
                        Zzz = z;
                    } else {
                        Zzz = size5 * zzlm.zzz(i7 << 3);
                        for (?? r12 = z; r12 < r11.size(); r12++) {
                            int iZzc5 = ((zzlh) r11.get(r12)).zzc();
                            Zzz += zzlm.zzz(iZzc5) + iZzc5;
                        }
                    }
                    i4 += Zzz;
                    break;
                case 29:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i21 = zznz.zza;
                    size = list5.size();
                    if (size == 0) {
                        Zzz2 = z;
                    } else {
                        iZzz3 = zznz.zzt(list5);
                        iZzz7 = zzlm.zzz(i7 << 3);
                        iZzA = size * iZzz7;
                        Zzz2 = iZzz3 + iZzA;
                    }
                    i4 += Zzz2;
                    break;
                case 30:
                    List list6 = (List) unsafe.getObject(obj, j);
                    int i22 = zznz.zza;
                    size = list6.size();
                    if (size == 0) {
                        Zzz2 = z;
                    } else {
                        iZzz3 = zznz.zzr(list6);
                        iZzz7 = zzlm.zzz(i7 << 3);
                        iZzA = size * iZzz7;
                        Zzz2 = iZzz3 + iZzA;
                    }
                    i4 += Zzz2;
                    break;
                case 31:
                    Zzz2 = zznz.zzw(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzz2;
                    break;
                case 32:
                    Zzz2 = zznz.zzy(i7, (List) unsafe.getObject(obj, j), z);
                    i4 += Zzz2;
                    break;
                case 33:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i23 = zznz.zza;
                    size = list7.size();
                    if (size == 0) {
                        Zzz2 = z;
                    } else {
                        iZzz3 = zznz.zzu(list7);
                        iZzz7 = zzlm.zzz(i7 << 3);
                        iZzA = size * iZzz7;
                        Zzz2 = iZzz3 + iZzA;
                    }
                    i4 += Zzz2;
                    break;
                case 34:
                    List list8 = (List) unsafe.getObject(obj, j);
                    int i24 = zznz.zza;
                    size = list8.size();
                    if (size == 0) {
                        Zzz2 = z;
                    } else {
                        iZzz3 = zznz.zzq(list8);
                        iZzz7 = zzlm.zzz(i7 << 3);
                        iZzA = size * iZzz7;
                        Zzz2 = iZzz3 + iZzA;
                    }
                    i4 += Zzz2;
                    break;
                case 35:
                    iZzx = zznz.zzx((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzz8 = zzlm.zzz(i7 << 3);
                        iZzz9 = zzlm.zzz(iZzx);
                        Zzz = iZzz8 + iZzz9 + iZzx;
                        i4 += Zzz;
                    }
                    break;
                case 36:
                    iZzx = zznz.zzv((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzz8 = zzlm.zzz(i7 << 3);
                        iZzz9 = zzlm.zzz(iZzx);
                        Zzz = iZzz8 + iZzz9 + iZzx;
                        i4 += Zzz;
                    }
                    break;
                case 37:
                    iZzx = zznz.zzo((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzz8 = zzlm.zzz(i7 << 3);
                        iZzz9 = zzlm.zzz(iZzx);
                        Zzz = iZzz8 + iZzz9 + iZzx;
                        i4 += Zzz;
                    }
                    break;
                case 38:
                    iZzx = zznz.zzp((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzz8 = zzlm.zzz(i7 << 3);
                        iZzz9 = zzlm.zzz(iZzx);
                        Zzz = iZzz8 + iZzz9 + iZzx;
                        i4 += Zzz;
                    }
                    break;
                case 39:
                    iZzx = zznz.zzs((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzz8 = zzlm.zzz(i7 << 3);
                        iZzz9 = zzlm.zzz(iZzx);
                        Zzz = iZzz8 + iZzz9 + iZzx;
                        i4 += Zzz;
                    }
                    break;
                case 40:
                    iZzx = zznz.zzx((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzz8 = zzlm.zzz(i7 << 3);
                        iZzz9 = zzlm.zzz(iZzx);
                        Zzz = iZzz8 + iZzz9 + iZzx;
                        i4 += Zzz;
                    }
                    break;
                case 41:
                    iZzx = zznz.zzv((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzz8 = zzlm.zzz(i7 << 3);
                        iZzz9 = zzlm.zzz(iZzx);
                        Zzz = iZzz8 + iZzz9 + iZzx;
                        i4 += Zzz;
                    }
                    break;
                case 42:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i25 = zznz.zza;
                    iZzx = list9.size();
                    if (iZzx > 0) {
                        iZzz8 = zzlm.zzz(i7 << 3);
                        iZzz9 = zzlm.zzz(iZzx);
                        Zzz = iZzz8 + iZzz9 + iZzx;
                        i4 += Zzz;
                    }
                    break;
                case 43:
                    iZzx = zznz.zzt((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzz8 = zzlm.zzz(i7 << 3);
                        iZzz9 = zzlm.zzz(iZzx);
                        Zzz = iZzz8 + iZzz9 + iZzx;
                        i4 += Zzz;
                    }
                    break;
                case 44:
                    iZzx = zznz.zzr((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzz8 = zzlm.zzz(i7 << 3);
                        iZzz9 = zzlm.zzz(iZzx);
                        Zzz = iZzz8 + iZzz9 + iZzx;
                        i4 += Zzz;
                    }
                    break;
                case 45:
                    iZzx = zznz.zzv((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzz8 = zzlm.zzz(i7 << 3);
                        iZzz9 = zzlm.zzz(iZzx);
                        Zzz = iZzz8 + iZzz9 + iZzx;
                        i4 += Zzz;
                    }
                    break;
                case 46:
                    iZzx = zznz.zzx((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzz8 = zzlm.zzz(i7 << 3);
                        iZzz9 = zzlm.zzz(iZzx);
                        Zzz = iZzz8 + iZzz9 + iZzx;
                        i4 += Zzz;
                    }
                    break;
                case 47:
                    iZzx = zznz.zzu((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzz8 = zzlm.zzz(i7 << 3);
                        iZzz9 = zzlm.zzz(iZzx);
                        Zzz = iZzz8 + iZzz9 + iZzx;
                        i4 += Zzz;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                    iZzx = zznz.zzq((List) unsafe.getObject(obj, j));
                    if (iZzx > 0) {
                        iZzz8 = zzlm.zzz(i7 << 3);
                        iZzz9 = zzlm.zzz(iZzx);
                        Zzz = iZzz8 + iZzz9 + iZzx;
                        i4 += Zzz;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    ?? r13 = (List) unsafe.getObject(obj, j);
                    zznx zznxVarZzp2 = zzp(i3);
                    int i26 = zznz.zza;
                    int size6 = r13.size();
                    if (size6 == 0) {
                        r4 = z;
                    } else {
                        boolean z2 = z;
                        r4 = z2;
                        while (r6 < size6) {
                            r6 = z2;
                            int iZzG = zzlm.zzG(i7, (zznm) r13.get(r6), zznxVarZzp2);
                            r6++;
                            r4 = (r4 == true ? 1 : 0) + iZzG;
                        }
                        r6 = z2;
                    }
                    i4 += r4;
                    break;
                case 50:
                    zzng zzngVar = (zzng) unsafe.getObject(obj, j);
                    zznf zznfVar = (zznf) zzq(i3);
                    if (zzngVar.isEmpty()) {
                        Zzo = z;
                    } else {
                        Zzo = z;
                        for (Map.Entry entry2 : zzngVar.entrySet()) {
                            Zzo += zznfVar.zzd(i7, entry2.getKey(), entry2.getValue());
                        }
                    }
                    i4 += Zzo;
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzL(obj, i7, i3)) {
                        iZzz = zzlm.zzz(i7 << 3);
                        Zzz2 = iZzz + 8;
                        i4 += Zzz2;
                    }
                    break;
                case 52:
                    if (zzL(obj, i7, i3)) {
                        iZzz2 = zzlm.zzz(i7 << 3);
                        Zzz2 = iZzz2 + 4;
                        i4 += Zzz2;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (zzL(obj, i7, i3)) {
                        long jZzF = zzF(obj, j);
                        iZzz3 = zzlm.zzz(i7 << 3);
                        iZzA = zzlm.zzA(jZzF);
                        Zzz2 = iZzz3 + iZzA;
                        i4 += Zzz2;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (zzL(obj, i7, i3)) {
                        long jZzF2 = zzF(obj, j);
                        iZzz3 = zzlm.zzz(i7 << 3);
                        iZzA = zzlm.zzA(jZzF2);
                        Zzz2 = iZzz3 + iZzA;
                        i4 += Zzz2;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (zzL(obj, i7, i3)) {
                        long jZzE = zzE(obj, j);
                        iZzz3 = zzlm.zzz(i7 << 3);
                        iZzA = zzlm.zzA(jZzE);
                        Zzz2 = iZzz3 + iZzA;
                        i4 += Zzz2;
                    }
                    break;
                case 56:
                    if (zzL(obj, i7, i3)) {
                        iZzz = zzlm.zzz(i7 << 3);
                        Zzz2 = iZzz + 8;
                        i4 += Zzz2;
                    }
                    break;
                case 57:
                    if (zzL(obj, i7, i3)) {
                        iZzz2 = zzlm.zzz(i7 << 3);
                        Zzz2 = iZzz2 + 4;
                        i4 += Zzz2;
                    }
                    break;
                case 58:
                    if (zzL(obj, i7, i3)) {
                        iZzz4 = zzlm.zzz(i7 << 3);
                        Zzz2 = iZzz4 + 1;
                        i4 += Zzz2;
                    }
                    break;
                case 59:
                    if (zzL(obj, i7, i3)) {
                        int i27 = i7 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzlh) {
                            iZzz5 = zzlm.zzz(i27);
                            iZzc = ((zzlh) object2).zzc();
                            iZzz6 = zzlm.zzz(iZzc);
                            Zzz2 = iZzz5 + iZzz6 + iZzc;
                            i4 += Zzz2;
                        } else {
                            iZzz3 = zzlm.zzz(i27);
                            iZzA = zzlm.zzB((String) object2);
                            Zzz2 = iZzz3 + iZzA;
                            i4 += Zzz2;
                        }
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzL(obj, i7, i3)) {
                        Zzz2 = zznz.zzz(i7, unsafe.getObject(obj, j), zzp(i3));
                        i4 += Zzz2;
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzL(obj, i7, i3)) {
                        zzlh zzlhVar2 = (zzlh) unsafe.getObject(obj, j);
                        iZzz5 = zzlm.zzz(i7 << 3);
                        iZzc = zzlhVar2.zzc();
                        iZzz6 = zzlm.zzz(iZzc);
                        Zzz2 = iZzz5 + iZzz6 + iZzc;
                        i4 += Zzz2;
                    }
                    break;
                case 62:
                    if (zzL(obj, i7, i3)) {
                        int iZzE = zzE(obj, j);
                        iZzz3 = zzlm.zzz(i7 << 3);
                        iZzA = zzlm.zzz(iZzE);
                        Zzz2 = iZzz3 + iZzA;
                        i4 += Zzz2;
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzL(obj, i7, i3)) {
                        long jZzE2 = zzE(obj, j);
                        iZzz3 = zzlm.zzz(i7 << 3);
                        iZzA = zzlm.zzA(jZzE2);
                        Zzz2 = iZzz3 + iZzA;
                        i4 += Zzz2;
                    }
                    break;
                case 64:
                    if (zzL(obj, i7, i3)) {
                        iZzz2 = zzlm.zzz(i7 << 3);
                        Zzz2 = iZzz2 + 4;
                        i4 += Zzz2;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (zzL(obj, i7, i3)) {
                        iZzz = zzlm.zzz(i7 << 3);
                        Zzz2 = iZzz + 8;
                        i4 += Zzz2;
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (zzL(obj, i7, i3)) {
                        int iZzE2 = zzE(obj, j);
                        iZzz3 = zzlm.zzz(i7 << 3);
                        iZzA = zzlm.zzz((iZzE2 >> 31) ^ (iZzE2 + iZzE2));
                        Zzz2 = iZzz3 + iZzA;
                        i4 += Zzz2;
                    }
                    break;
                case 67:
                    if (zzL(obj, i7, i3)) {
                        long jZzF3 = zzF(obj, j);
                        iZzz3 = zzlm.zzz(i7 << 3);
                        iZzA = zzlm.zzA((jZzF3 >> 63) ^ (jZzF3 + jZzF3));
                        Zzz2 = iZzz3 + iZzA;
                        i4 += Zzz2;
                    }
                    break;
                case 68:
                    if (zzL(obj, i7, i3)) {
                        Zzz2 = zzlm.zzG(i7, (zznm) unsafe.getObject(obj, j), zzp(i3));
                        i4 += Zzz2;
                    }
                    break;
            }
            i3 += 3;
            i5 = i;
            r2 = r16;
            z = false;
            i2 = 1048575;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    @Override // com.google.android.gms.internal.measurement.zznx
    public final void zzf(Object obj, zzov zzovVar) throws IOException {
        Map.Entry entry;
        int i;
        int i2;
        int i3;
        Map.Entry entry2;
        if (this.zzh) {
            zzlw zzlwVar = ((zzmc) obj).zzb;
            if (zzlwVar.zza.isEmpty()) {
                entry = null;
            } else {
                entry = (Map.Entry) zzlwVar.zzc().next();
            }
        } else {
            entry = null;
        }
        int[] iArr = this.zzc;
        Unsafe unsafe = zzb;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        while (i7 < iArr.length) {
            int iZzx = zzx(i7);
            int iZzz = zzz(iZzx);
            int i8 = iArr[i7];
            if (iZzz <= 17) {
                int i9 = iArr[i7 + 2];
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
            if (entry != null) {
                throw null;
            }
            long j = iZzx & i4;
            switch (iZzz) {
                case 0:
                    entry2 = entry;
                    if (zzI(obj, i7, i, i2, i3)) {
                        zzovVar.zzf(i8, zzop.zzl(obj, j));
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 1:
                    entry2 = entry;
                    if (zzI(obj, i7, i, i2, i3)) {
                        zzovVar.zze(i8, zzop.zzj(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 2:
                    entry2 = entry;
                    if (zzI(obj, i7, i, i2, i3)) {
                        zzovVar.zzc(i8, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 3:
                    entry2 = entry;
                    if (zzI(obj, i7, i, i2, i3)) {
                        zzovVar.zzh(i8, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 4:
                    entry2 = entry;
                    if (zzI(obj, i7, i, i2, i3)) {
                        zzovVar.zzi(i8, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 5:
                    entry2 = entry;
                    if (zzI(obj, i7, i, i2, i3)) {
                        zzovVar.zzj(i8, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 6:
                    entry2 = entry;
                    if (zzI(obj, i7, i, i2, i3)) {
                        zzovVar.zzk(i8, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 7:
                    entry2 = entry;
                    if (zzI(obj, i7, i, i2, i3)) {
                        zzovVar.zzl(i8, zzop.zzh(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 8:
                    entry2 = entry;
                    if (zzI(obj, i7, i, i2, i3)) {
                        zzP(i8, unsafe.getObject(obj, j), zzovVar);
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 9:
                    entry2 = entry;
                    if (zzI(obj, i7, i, i2, i3)) {
                        zzovVar.zzr(i8, unsafe.getObject(obj, j), zzp(i7));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 10:
                    entry2 = entry;
                    if (zzI(obj, i7, i, i2, i3)) {
                        zzovVar.zzn(i8, (zzlh) unsafe.getObject(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 11:
                    entry2 = entry;
                    if (zzI(obj, i7, i, i2, i3)) {
                        zzovVar.zzo(i8, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 12:
                    entry2 = entry;
                    if (zzI(obj, i7, i, i2, i3)) {
                        zzovVar.zzg(i8, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 13:
                    entry2 = entry;
                    if (zzI(obj, i7, i, i2, i3)) {
                        zzovVar.zzb(i8, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 14:
                    entry2 = entry;
                    if (zzI(obj, i7, i, i2, i3)) {
                        zzovVar.zzd(i8, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 15:
                    entry2 = entry;
                    if (zzI(obj, i7, i, i2, i3)) {
                        zzovVar.zzp(i8, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 16:
                    entry2 = entry;
                    if (zzI(obj, i7, i, i2, i3)) {
                        zzovVar.zzq(i8, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 17:
                    entry2 = entry;
                    if (zzI(obj, i7, i, i2, i3)) {
                        zzovVar.zzs(i8, unsafe.getObject(obj, j), zzp(i7));
                    } else {
                        continue;
                    }
                    i7 += 3;
                    i5 = i;
                    entry = entry2;
                    i6 = i2;
                    i4 = 1048575;
                    break;
                case 18:
                    zznz.zza(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, false);
                    break;
                case 19:
                    zznz.zzb(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, false);
                    break;
                case 20:
                    zznz.zzc(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, false);
                    break;
                case 21:
                    zznz.zzd(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, false);
                    break;
                case 22:
                    zznz.zzh(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, false);
                    break;
                case 23:
                    zznz.zzf(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, false);
                    break;
                case 24:
                    zznz.zzk(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, false);
                    break;
                case 25:
                    zznz.zzn(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, false);
                    break;
                case 26:
                    int i11 = iArr[i7];
                    List list = (List) unsafe.getObject(obj, j);
                    int i12 = zznz.zza;
                    if (list != null && !list.isEmpty()) {
                        zzovVar.zzF(i11, list);
                    }
                    break;
                case 27:
                    int i13 = iArr[i7];
                    List list2 = (List) unsafe.getObject(obj, j);
                    zznx zznxVarZzp = zzp(i7);
                    int i14 = zznz.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i15 = 0; i15 < list2.size(); i15++) {
                            ((zzln) zzovVar).zzr(i13, list2.get(i15), zznxVarZzp);
                        }
                    }
                    break;
                case 28:
                    int i16 = iArr[i7];
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i17 = zznz.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzovVar.zzG(i16, list3);
                    }
                    break;
                case 29:
                    zznz.zzi(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, false);
                    break;
                case 30:
                    zznz.zzm(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, false);
                    break;
                case 31:
                    zznz.zzl(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, false);
                    break;
                case 32:
                    zznz.zzg(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, false);
                    break;
                case 33:
                    zznz.zzj(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, false);
                    break;
                case 34:
                    zznz.zze(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, false);
                    break;
                case 35:
                    zznz.zza(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, true);
                    break;
                case 36:
                    zznz.zzb(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, true);
                    break;
                case 37:
                    zznz.zzc(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, true);
                    break;
                case 38:
                    zznz.zzd(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, true);
                    break;
                case 39:
                    zznz.zzh(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, true);
                    break;
                case 40:
                    zznz.zzf(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, true);
                    break;
                case 41:
                    zznz.zzk(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, true);
                    break;
                case 42:
                    zznz.zzn(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, true);
                    break;
                case 43:
                    zznz.zzi(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, true);
                    break;
                case 44:
                    zznz.zzm(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, true);
                    break;
                case 45:
                    zznz.zzl(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, true);
                    break;
                case 46:
                    zznz.zzg(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, true);
                    break;
                case 47:
                    zznz.zzj(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, true);
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                    zznz.zze(iArr[i7], (List) unsafe.getObject(obj, j), zzovVar, true);
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                    int i18 = iArr[i7];
                    List list4 = (List) unsafe.getObject(obj, j);
                    zznx zznxVarZzp2 = zzp(i7);
                    int i19 = zznz.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i20 = 0; i20 < list4.size(); i20++) {
                            ((zzln) zzovVar).zzs(i18, list4.get(i20), zznxVarZzp2);
                        }
                    }
                    break;
                case 50:
                    Object object = unsafe.getObject(obj, j);
                    if (object != null) {
                        zzovVar.zzM(i8, ((zznf) zzq(i7)).zze(), (zzng) object);
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    if (zzL(obj, i8, i7)) {
                        zzovVar.zzf(i8, zzC(obj, j));
                    }
                    break;
                case 52:
                    if (zzL(obj, i8, i7)) {
                        zzovVar.zze(i8, zzD(obj, j));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                    if (zzL(obj, i8, i7)) {
                        zzovVar.zzc(i8, zzF(obj, j));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    if (zzL(obj, i8, i7)) {
                        zzovVar.zzh(i8, zzF(obj, j));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (zzL(obj, i8, i7)) {
                        zzovVar.zzi(i8, zzE(obj, j));
                    }
                    break;
                case 56:
                    if (zzL(obj, i8, i7)) {
                        zzovVar.zzj(i8, zzF(obj, j));
                    }
                    break;
                case 57:
                    if (zzL(obj, i8, i7)) {
                        zzovVar.zzk(i8, zzE(obj, j));
                    }
                    break;
                case 58:
                    if (zzL(obj, i8, i7)) {
                        zzovVar.zzl(i8, zzG(obj, j));
                    }
                    break;
                case 59:
                    if (zzL(obj, i8, i7)) {
                        zzP(i8, unsafe.getObject(obj, j), zzovVar);
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzL(obj, i8, i7)) {
                        zzovVar.zzr(i8, unsafe.getObject(obj, j), zzp(i7));
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzL(obj, i8, i7)) {
                        zzovVar.zzn(i8, (zzlh) unsafe.getObject(obj, j));
                    }
                    break;
                case 62:
                    if (zzL(obj, i8, i7)) {
                        zzovVar.zzo(i8, zzE(obj, j));
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzL(obj, i8, i7)) {
                        zzovVar.zzg(i8, zzE(obj, j));
                    }
                    break;
                case 64:
                    if (zzL(obj, i8, i7)) {
                        zzovVar.zzb(i8, zzE(obj, j));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (zzL(obj, i8, i7)) {
                        zzovVar.zzd(i8, zzF(obj, j));
                    }
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (zzL(obj, i8, i7)) {
                        zzovVar.zzp(i8, zzE(obj, j));
                    }
                    break;
                case 67:
                    if (zzL(obj, i8, i7)) {
                        zzovVar.zzq(i8, zzF(obj, j));
                    }
                    break;
                case 68:
                    if (zzL(obj, i8, i7)) {
                        zzovVar.zzs(i8, unsafe.getObject(obj, j), zzp(i7));
                    }
                    break;
            }
            entry2 = entry;
            i7 += 3;
            i5 = i;
            entry = entry2;
            i6 = i2;
            i4 = 1048575;
        }
        Map.Entry entry3 = entry;
        if (entry3 != null) {
            throw null;
        }
        ((zzmf) obj).zzc.zzg(zzovVar);
    }

    /* JADX WARN: Code duplicated, block: B:118:0x0356  */
    /* JADX WARN: Code duplicated, block: B:120:0x0362  */
    /* JADX WARN: Code duplicated, block: B:122:0x0368  */
    /* JADX WARN: Code duplicated, block: B:123:0x036b  */
    /* JADX WARN: Code duplicated, block: B:126:0x0393  */
    /* JADX WARN: Code duplicated, block: B:127:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:131:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:132:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:134:0x03d3  */
    /* JADX WARN: Code duplicated, block: B:136:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:137:0x0401  */
    /* JADX WARN: Code duplicated, block: B:139:0x0404  */
    /* JADX WARN: Code duplicated, block: B:141:0x0413 A[LOOP:4: B:140:0x0411->B:141:0x0413, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:143:0x0423  */
    /* JADX WARN: Code duplicated, block: B:146:0x042d  */
    /* JADX WARN: Code duplicated, block: B:148:0x0431  */
    /* JADX WARN: Code duplicated, block: B:150:0x0446  */
    /* JADX WARN: Code duplicated, block: B:152:0x044e A[LOOP:5: B:149:0x0444->B:152:0x044e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:153:0x045c  */
    /* JADX WARN: Code duplicated, block: B:154:0x045f  */
    /* JADX WARN: Code duplicated, block: B:156:0x0466  */
    /* JADX WARN: Code duplicated, block: B:158:0x0473 A[LOOP:6: B:157:0x0471->B:158:0x0473, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:163:0x048a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:164:0x048c  */
    /* JADX WARN: Code duplicated, block: B:166:0x049f  */
    /* JADX WARN: Code duplicated, block: B:168:0x04a7 A[LOOP:7: B:165:0x049d->B:168:0x04a7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:171:0x04c9  */
    /* JADX WARN: Code duplicated, block: B:173:0x04d0  */
    /* JADX WARN: Code duplicated, block: B:174:0x04d7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:175:0x04d9  */
    /* JADX WARN: Code duplicated, block: B:178:0x04f2  */
    /* JADX WARN: Code duplicated, block: B:180:0x04f6  */
    /* JADX WARN: Code duplicated, block: B:182:0x0502  */
    /* JADX WARN: Code duplicated, block: B:184:0x0516 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:185:0x0518  */
    /* JADX WARN: Code duplicated, block: B:187:0x0520  */
    /* JADX WARN: Code duplicated, block: B:191:0x0535  */
    /* JADX WARN: Code duplicated, block: B:192:0x053d  */
    /* JADX WARN: Code duplicated, block: B:195:0x054f  */
    /* JADX WARN: Code duplicated, block: B:198:0x0567  */
    /* JADX WARN: Code duplicated, block: B:201:0x0577  */
    /* JADX WARN: Code duplicated, block: B:202:0x0581  */
    /* JADX WARN: Code duplicated, block: B:204:0x058e  */
    /* JADX WARN: Code duplicated, block: B:206:0x0596  */
    /* JADX WARN: Code duplicated, block: B:208:0x059a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:209:0x059c  */
    /* JADX WARN: Code duplicated, block: B:210:0x05a2  */
    /* JADX WARN: Code duplicated, block: B:213:0x05ac  */
    /* JADX WARN: Code duplicated, block: B:215:0x05b4  */
    /* JADX WARN: Code duplicated, block: B:217:0x05bc  */
    /* JADX WARN: Code duplicated, block: B:219:0x05c0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:231:0x05ec  */
    /* JADX WARN: Code duplicated, block: B:232:0x05f2  */
    /* JADX WARN: Code duplicated, block: B:234:0x05ff  */
    /* JADX WARN: Code duplicated, block: B:236:0x0619  */
    /* JADX WARN: Code duplicated, block: B:237:0x061b A[PHI: r7 r8 r11 r13 r29 r30
  0x061b: PHI (r7v73 int) = (r7v49 int), (r7v50 int), (r7v51 int), (r7v52 int), (r7v54 int), (r7v55 int), (r7v57 int), (r7v64 int), (r7v75 int) binds: [B:410:0x096a, B:390:0x08f6, B:370:0x088a, B:359:0x0847, B:349:0x080d, B:329:0x07a6, B:301:0x0730, B:236:0x0619, B:135:0x03e0] A[DONT_GENERATE, DONT_INLINE]
  0x061b: PHI (r8v92 int) = (r8v69 int), (r8v70 int), (r8v71 int), (r8v72 int), (r8v73 int), (r8v74 int), (r8v76 int), (r8v79 int), (r8v95 int) binds: [B:410:0x096a, B:390:0x08f6, B:370:0x088a, B:359:0x0847, B:349:0x080d, B:329:0x07a6, B:301:0x0730, B:236:0x0619, B:135:0x03e0] A[DONT_GENERATE, DONT_INLINE]
  0x061b: PHI (r11v50 int) = 
  (r11v30 int)
  (r11v31 int)
  (r11v32 int)
  (r11v33 int)
  (r11v34 int)
  (r11v35 int)
  (r11v37 int)
  (r11v40 int)
  (r11v54 int)
 binds: [B:410:0x096a, B:390:0x08f6, B:370:0x088a, B:359:0x0847, B:349:0x080d, B:329:0x07a6, B:301:0x0730, B:236:0x0619, B:135:0x03e0] A[DONT_GENERATE, DONT_INLINE]
  0x061b: PHI (r13v73 com.google.android.gms.internal.measurement.zznp<T>) = 
  (r13v52 com.google.android.gms.internal.measurement.zznp<T>)
  (r13v53 com.google.android.gms.internal.measurement.zznp<T>)
  (r13v54 com.google.android.gms.internal.measurement.zznp<T>)
  (r13v55 com.google.android.gms.internal.measurement.zznp<T>)
  (r13v56 com.google.android.gms.internal.measurement.zznp<T>)
  (r13v57 com.google.android.gms.internal.measurement.zznp<T>)
  (r13v59 com.google.android.gms.internal.measurement.zznp<T>)
  (r13v62 com.google.android.gms.internal.measurement.zznp<T>)
  (r13v77 com.google.android.gms.internal.measurement.zznp<T>)
 binds: [B:410:0x096a, B:390:0x08f6, B:370:0x088a, B:359:0x0847, B:349:0x080d, B:329:0x07a6, B:301:0x0730, B:236:0x0619, B:135:0x03e0] A[DONT_GENERATE, DONT_INLINE]
  0x061b: PHI (r29v27 sun.misc.Unsafe) = 
  (r29v5 sun.misc.Unsafe)
  (r29v6 sun.misc.Unsafe)
  (r29v7 sun.misc.Unsafe)
  (r29v8 sun.misc.Unsafe)
  (r29v9 sun.misc.Unsafe)
  (r29v10 sun.misc.Unsafe)
  (r29v12 sun.misc.Unsafe)
  (r29v15 sun.misc.Unsafe)
  (r29v29 sun.misc.Unsafe)
 binds: [B:410:0x096a, B:390:0x08f6, B:370:0x088a, B:359:0x0847, B:349:0x080d, B:329:0x07a6, B:301:0x0730, B:236:0x0619, B:135:0x03e0] A[DONT_GENERATE, DONT_INLINE]
  0x061b: PHI (r30v47 java.lang.String) = 
  (r30v29 java.lang.String)
  (r30v30 java.lang.String)
  (r30v31 java.lang.String)
  (r30v32 java.lang.String)
  (r30v33 java.lang.String)
  (r30v34 java.lang.String)
  (r30v36 java.lang.String)
  (r30v39 java.lang.String)
  (r30v49 java.lang.String)
 binds: [B:410:0x096a, B:390:0x08f6, B:370:0x088a, B:359:0x0847, B:349:0x080d, B:329:0x07a6, B:301:0x0730, B:236:0x0619, B:135:0x03e0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:238:0x061f  */
    /* JADX WARN: Code duplicated, block: B:240:0x062e  */
    /* JADX WARN: Code duplicated, block: B:242:0x0637  */
    /* JADX WARN: Code duplicated, block: B:244:0x063f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:245:0x0641  */
    /* JADX WARN: Code duplicated, block: B:246:0x0647  */
    /* JADX WARN: Code duplicated, block: B:249:0x0656  */
    /* JADX WARN: Code duplicated, block: B:251:0x065e  */
    /* JADX WARN: Code duplicated, block: B:253:0x0666 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:260:0x0683  */
    /* JADX WARN: Code duplicated, block: B:262:0x068d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:263:0x068f  */
    /* JADX WARN: Code duplicated, block: B:264:0x0693  */
    /* JADX WARN: Code duplicated, block: B:266:0x069b  */
    /* JADX WARN: Code duplicated, block: B:269:0x06ab  */
    /* JADX WARN: Code duplicated, block: B:271:0x06b3  */
    /* JADX WARN: Code duplicated, block: B:273:0x06bb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:277:0x06c9  */
    /* JADX WARN: Code duplicated, block: B:27:0x006b  */
    /* JADX WARN: Code duplicated, block: B:287:0x06f5  */
    /* JADX WARN: Code duplicated, block: B:288:0x06f9  */
    /* JADX WARN: Code duplicated, block: B:290:0x0708  */
    /* JADX WARN: Code duplicated, block: B:292:0x0715  */
    /* JADX WARN: Code duplicated, block: B:294:0x071f  */
    /* JADX WARN: Code duplicated, block: B:295:0x0721  */
    /* JADX WARN: Code duplicated, block: B:301:0x0730 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:302:0x0732  */
    /* JADX WARN: Code duplicated, block: B:304:0x0740  */
    /* JADX WARN: Code duplicated, block: B:305:0x0742  */
    /* JADX WARN: Code duplicated, block: B:308:0x0748  */
    /* JADX WARN: Code duplicated, block: B:310:0x0750  */
    /* JADX WARN: Code duplicated, block: B:312:0x075a  */
    /* JADX WARN: Code duplicated, block: B:313:0x075c  */
    /* JADX WARN: Code duplicated, block: B:315:0x0761  */
    /* JADX WARN: Code duplicated, block: B:317:0x0770  */
    /* JADX WARN: Code duplicated, block: B:319:0x077f  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:321:0x078b A[LOOP:15: B:320:0x0789->B:321:0x078b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:328:0x07a5  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:330:0x07a8  */
    /* JADX WARN: Code duplicated, block: B:332:0x07b7  */
    /* JADX WARN: Code duplicated, block: B:334:0x07bf A[LOOP:16: B:331:0x07b5->B:334:0x07bf, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:335:0x07c9  */
    /* JADX WARN: Code duplicated, block: B:337:0x07d8  */
    /* JADX WARN: Code duplicated, block: B:339:0x07e7  */
    /* JADX WARN: Code duplicated, block: B:341:0x07f3 A[LOOP:17: B:340:0x07f1->B:341:0x07f3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:348:0x080c  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:350:0x080f  */
    /* JADX WARN: Code duplicated, block: B:352:0x081e  */
    /* JADX WARN: Code duplicated, block: B:354:0x0826 A[LOOP:18: B:351:0x081c->B:354:0x0826, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:355:0x0830  */
    /* JADX WARN: Code duplicated, block: B:357:0x083f  */
    /* JADX WARN: Code duplicated, block: B:359:0x0847 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:360:0x0849  */
    /* JADX WARN: Code duplicated, block: B:361:0x085b  */
    /* JADX WARN: Code duplicated, block: B:363:0x086a  */
    /* JADX WARN: Code duplicated, block: B:365:0x0877 A[LOOP:19: B:364:0x0875->B:365:0x0877, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:36:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:370:0x088a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:371:0x088c  */
    /* JADX WARN: Code duplicated, block: B:373:0x089b  */
    /* JADX WARN: Code duplicated, block: B:375:0x08a3 A[LOOP:20: B:372:0x0899->B:375:0x08a3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:376:0x08ad  */
    /* JADX WARN: Code duplicated, block: B:378:0x08bc  */
    /* JADX WARN: Code duplicated, block: B:380:0x08cb  */
    /* JADX WARN: Code duplicated, block: B:382:0x08d7 A[LOOP:21: B:381:0x08d5->B:382:0x08d7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:389:0x08f5  */
    /* JADX WARN: Code duplicated, block: B:391:0x08f8  */
    /* JADX WARN: Code duplicated, block: B:393:0x090b  */
    /* JADX WARN: Code duplicated, block: B:395:0x0913 A[LOOP:22: B:392:0x0909->B:395:0x0913, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:396:0x0921  */
    /* JADX WARN: Code duplicated, block: B:398:0x0930  */
    /* JADX WARN: Code duplicated, block: B:400:0x093f  */
    /* JADX WARN: Code duplicated, block: B:402:0x094b A[LOOP:23: B:401:0x0949->B:402:0x094b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:409:0x0969  */
    /* JADX WARN: Code duplicated, block: B:40:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:411:0x096c  */
    /* JADX WARN: Code duplicated, block: B:413:0x097f  */
    /* JADX WARN: Code duplicated, block: B:415:0x0987 A[LOOP:24: B:412:0x097d->B:415:0x0987, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:417:0x0997  */
    /* JADX WARN: Code duplicated, block: B:419:0x099f A[LOOP:1: B:416:0x0995->B:419:0x099f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:426:0x09e5  */
    /* JADX WARN: Code duplicated, block: B:428:0x09e8  */
    /* JADX WARN: Code duplicated, block: B:430:0x09fb  */
    /* JADX WARN: Code duplicated, block: B:468:0x0b09  */
    /* JADX WARN: Code duplicated, block: B:469:0x0b16  */
    /* JADX WARN: Code duplicated, block: B:471:0x0b19  */
    /* JADX WARN: Code duplicated, block: B:472:0x0b43  */
    /* JADX WARN: Code duplicated, block: B:473:0x0b4e  */
    /* JADX WARN: Code duplicated, block: B:475:0x0b5a  */
    /* JADX WARN: Code duplicated, block: B:476:0x0b71  */
    /* JADX WARN: Code duplicated, block: B:478:0x0b7d  */
    /* JADX WARN: Code duplicated, block: B:481:0x0b9d  */
    /* JADX WARN: Code duplicated, block: B:483:0x0ba9  */
    /* JADX WARN: Code duplicated, block: B:489:0x0bcb  */
    /* JADX WARN: Code duplicated, block: B:490:0x0bd8  */
    /* JADX WARN: Code duplicated, block: B:491:0x0bdc  */
    /* JADX WARN: Code duplicated, block: B:493:0x0be8  */
    /* JADX WARN: Code duplicated, block: B:494:0x0bf6  */
    /* JADX WARN: Code duplicated, block: B:496:0x0c02  */
    /* JADX WARN: Code duplicated, block: B:498:0x0c1d  */
    /* JADX WARN: Code duplicated, block: B:500:0x0c29  */
    /* JADX WARN: Code duplicated, block: B:502:0x0c31  */
    /* JADX WARN: Code duplicated, block: B:503:0x0c39  */
    /* JADX WARN: Code duplicated, block: B:512:0x0c63 A[PHI: r1 r8 r10 r13 r30
  0x0c63: PHI (r1v62 com.google.android.gms.internal.measurement.zznp<T>) = 
  (r1v59 com.google.android.gms.internal.measurement.zznp<T>)
  (r1v60 com.google.android.gms.internal.measurement.zznp<T>)
  (r1v61 com.google.android.gms.internal.measurement.zznp<T>)
  (r1v64 com.google.android.gms.internal.measurement.zznp<T>)
 binds: [B:499:0x0c27, B:495:0x0c00, B:492:0x0be6, B:490:0x0bd8] A[DONT_GENERATE, DONT_INLINE]
  0x0c63: PHI (r8v41 int) = (r8v38 int), (r8v39 int), (r8v40 int), (r8v43 int) binds: [B:499:0x0c27, B:495:0x0c00, B:492:0x0be6, B:490:0x0bd8] A[DONT_GENERATE, DONT_INLINE]
  0x0c63: PHI (r10v36 java.lang.Object) = (r10v33 java.lang.Object), (r10v34 java.lang.Object), (r10v35 java.lang.Object), (r10v38 java.lang.Object) binds: [B:499:0x0c27, B:495:0x0c00, B:492:0x0be6, B:490:0x0bd8] A[DONT_GENERATE, DONT_INLINE]
  0x0c63: PHI (r13v30 int) = (r13v27 int), (r13v28 int), (r13v29 int), (r13v32 int) binds: [B:499:0x0c27, B:495:0x0c00, B:492:0x0be6, B:490:0x0bd8] A[DONT_GENERATE, DONT_INLINE]
  0x0c63: PHI (r30v17 java.lang.String) = (r30v14 java.lang.String), (r30v15 java.lang.String), (r30v16 java.lang.String), (r30v19 java.lang.String) binds: [B:499:0x0c27, B:495:0x0c00, B:492:0x0be6, B:490:0x0bd8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:513:0x0c67  */
    /* JADX WARN: Code duplicated, block: B:515:0x0c74  */
    /* JADX WARN: Code duplicated, block: B:517:0x0c7e  */
    /* JADX WARN: Code duplicated, block: B:518:0x0c80  */
    /* JADX WARN: Code duplicated, block: B:520:0x0c8d  */
    /* JADX WARN: Code duplicated, block: B:522:0x0c9b  */
    /* JADX WARN: Code duplicated, block: B:523:0x0cad  */
    /* JADX WARN: Code duplicated, block: B:525:0x0cbb  */
    /* JADX WARN: Code duplicated, block: B:526:0x0ccd  */
    /* JADX WARN: Code duplicated, block: B:528:0x0cda  */
    /* JADX WARN: Code duplicated, block: B:529:0x0cec  */
    /* JADX WARN: Code duplicated, block: B:531:0x0cf9  */
    /* JADX WARN: Code duplicated, block: B:532:0x0d0a  */
    /* JADX WARN: Code duplicated, block: B:534:0x0d18  */
    /* JADX WARN: Code duplicated, block: B:535:0x0d2d  */
    /* JADX WARN: Code duplicated, block: B:537:0x0d3b  */
    /* JADX WARN: Code duplicated, block: B:538:0x0d50 A[PHI: r1 r8 r10 r13 r18 r30
  0x0d50: PHI (r1v72 com.google.android.gms.internal.measurement.zznp<T>) = 
  (r1v52 com.google.android.gms.internal.measurement.zznp<T>)
  (r1v53 com.google.android.gms.internal.measurement.zznp<T>)
  (r1v54 com.google.android.gms.internal.measurement.zznp<T>)
  (r1v55 com.google.android.gms.internal.measurement.zznp<T>)
  (r1v56 com.google.android.gms.internal.measurement.zznp<T>)
  (r1v57 com.google.android.gms.internal.measurement.zznp<T>)
  (r1v58 com.google.android.gms.internal.measurement.zznp<T>)
  (r1v62 com.google.android.gms.internal.measurement.zznp<T>)
  (r1v67 com.google.android.gms.internal.measurement.zznp<T>)
  (r1v73 com.google.android.gms.internal.measurement.zznp<T>)
 binds: [B:536:0x0d39, B:533:0x0d16, B:530:0x0cf7, B:527:0x0cd8, B:524:0x0cb9, B:521:0x0c99, B:514:0x0c72, B:512:0x0c63, B:480:0x0b97, B:468:0x0b09] A[DONT_GENERATE, DONT_INLINE]
  0x0d50: PHI (r8v54 int) = 
  (r8v31 int)
  (r8v32 int)
  (r8v33 int)
  (r8v34 int)
  (r8v35 int)
  (r8v36 int)
  (r8v37 int)
  (r8v41 int)
  (r8v49 int)
  (r8v55 int)
 binds: [B:536:0x0d39, B:533:0x0d16, B:530:0x0cf7, B:527:0x0cd8, B:524:0x0cb9, B:521:0x0c99, B:514:0x0c72, B:512:0x0c63, B:480:0x0b97, B:468:0x0b09] A[DONT_GENERATE, DONT_INLINE]
  0x0d50: PHI (r10v46 java.lang.Object) = 
  (r10v26 java.lang.Object)
  (r10v27 java.lang.Object)
  (r10v28 java.lang.Object)
  (r10v29 java.lang.Object)
  (r10v30 java.lang.Object)
  (r10v31 java.lang.Object)
  (r10v32 java.lang.Object)
  (r10v36 java.lang.Object)
  (r10v41 java.lang.Object)
  (r10v47 java.lang.Object)
 binds: [B:536:0x0d39, B:533:0x0d16, B:530:0x0cf7, B:527:0x0cd8, B:524:0x0cb9, B:521:0x0c99, B:514:0x0c72, B:512:0x0c63, B:480:0x0b97, B:468:0x0b09] A[DONT_GENERATE, DONT_INLINE]
  0x0d50: PHI (r13v40 int) = 
  (r13v20 int)
  (r13v21 int)
  (r13v22 int)
  (r13v23 int)
  (r13v24 int)
  (r13v25 int)
  (r13v26 int)
  (r13v30 int)
  (r13v35 int)
  (r13v41 int)
 binds: [B:536:0x0d39, B:533:0x0d16, B:530:0x0cf7, B:527:0x0cd8, B:524:0x0cb9, B:521:0x0c99, B:514:0x0c72, B:512:0x0c63, B:480:0x0b97, B:468:0x0b09] A[DONT_GENERATE, DONT_INLINE]
  0x0d50: PHI (r18v41 int) = 
  (r18v26 int)
  (r18v27 int)
  (r18v28 int)
  (r18v29 int)
  (r18v30 int)
  (r18v31 int)
  (r18v32 int)
  (r18v36 int)
  (r18v38 int)
  (r18v42 int)
 binds: [B:536:0x0d39, B:533:0x0d16, B:530:0x0cf7, B:527:0x0cd8, B:524:0x0cb9, B:521:0x0c99, B:514:0x0c72, B:512:0x0c63, B:480:0x0b97, B:468:0x0b09] A[DONT_GENERATE, DONT_INLINE]
  0x0d50: PHI (r30v27 java.lang.String) = 
  (r30v7 java.lang.String)
  (r30v8 java.lang.String)
  (r30v9 java.lang.String)
  (r30v10 java.lang.String)
  (r30v11 java.lang.String)
  (r30v12 java.lang.String)
  (r30v13 java.lang.String)
  (r30v17 java.lang.String)
  (r30v22 java.lang.String)
  (r30v28 java.lang.String)
 binds: [B:536:0x0d39, B:533:0x0d16, B:530:0x0cf7, B:527:0x0cd8, B:524:0x0cb9, B:521:0x0c99, B:514:0x0c72, B:512:0x0c63, B:480:0x0b97, B:468:0x0b09] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:540:0x0d53  */
    /* JADX WARN: Code duplicated, block: B:541:0x0d5a  */
    /* JADX WARN: Code duplicated, block: B:547:0x0d6e  */
    /* JADX WARN: Code duplicated, block: B:549:0x0d78  */
    /* JADX WARN: Code duplicated, block: B:551:0x0d82  */
    /* JADX WARN: Code duplicated, block: B:554:0x0d96  */
    /* JADX WARN: Code duplicated, block: B:58:0x0185  */
    /* JADX WARN: Code duplicated, block: B:603:0x00f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:604:0x0133 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:605:0x015a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:606:0x01a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:607:0x01fd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:608:0x0246 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:609:0x026b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:610:0x0289 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:611:0x02a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:612:0x02c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:613:0x02f1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:614:0x0312 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:615:0x0427 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:616:0x0484 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:617:0x05e6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:618:0x05e0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:619:0x05d6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:620:0x05d0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:621:0x067d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:622:0x0677 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:623:0x06ef A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:624:0x06e7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:625:0x06de A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:626:0x06d6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:627:0x072a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:628:0x079f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:629:0x0799 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:630:0x0806 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:631:0x0800 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:632:0x0884 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:633:0x08ef A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:634:0x08e9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:635:0x0963 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:636:0x095d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:637:0x09b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:644:0x0d92 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:645:0x03ab A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:646:0x005b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:647:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:648:0x014f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:649:0x0190 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:650:0x01ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:651:0x01eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:652:0x0235 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:653:0x0259 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:654:0x0277 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:655:0x0298 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:656:0x02b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:657:0x02df A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:658:0x0300 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:659:0x011d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:660:0x0af5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:661:0x0ae3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:662:0x018b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:664:0x0353 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:665:0x033f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:666:0x00f6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:667:0x0128 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:668:0x018b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:669:0x01e8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:670:0x032d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:671:0x022d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:672:0x032d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:673:0x032d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:674:0x032d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:675:0x032d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:676:0x032d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:677:0x032d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:678:0x032d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:679:0x0093 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:680:0x09d1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:681:0x09c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:688:0x09b3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:697:0x04b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:700:0x04b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:705:0x055f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:707:0x0549 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:710:0x05dc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:711:0x05c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:712:0x05c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:718:0x06e4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:719:0x066c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:720:0x0668 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:725:0x06c1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:727:0x06e4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:728:0x06bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:737:0x0843 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x0201  */
    /* JADX WARN: Code duplicated, block: B:742:0x0843 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:744:0x0843 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:748:0x0843 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x020a  */
    /* JADX WARN: Code duplicated, block: B:751:0x0843 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:754:0x0843 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x0212  */
    /* JADX WARN: Code duplicated, block: B:78:0x0216  */
    /* JADX WARN: Code duplicated, block: B:79:0x021b  */
    /* JADX WARN: Code duplicated, block: B:88:0x0251  */
    /* JADX WARN: Code duplicated, block: B:89:0x0253  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r3v202 */
    /* JADX WARN: Type inference failed for: r3v203 */
    /* JADX WARN: Type inference failed for: r3v204 */
    /* JADX WARN: Type inference failed for: r3v205 */
    /* JADX WARN: Type inference failed for: r3v206 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.google.android.gms.internal.measurement.zzoj] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    final int zzh(Object obj, byte[] bArr, int i, int i2, int i3, zzkw zzkwVar) throws IOException {
        Object obj2;
        String str;
        Unsafe unsafe;
        zzmk zzmkVarZzr;
        int i4;
        int iZzb;
        int i5;
        int iZzN;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        zzlr zzlrVar;
        zznm zznmVar;
        int i12;
        int[] iArr;
        int i13;
        int i14;
        int iZzz;
        long j;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        zznp<T> zznpVar;
        int i23;
        int i24;
        int iZzc;
        boolean z;
        int i25;
        int i26;
        zznp<T> zznpVar2;
        int i27;
        int i28;
        zznp<T> zznpVar3;
        Unsafe unsafe2;
        int i29;
        String str2;
        int i30;
        zzmo zzmoVarZzg;
        int size;
        int i31;
        long j2;
        boolean z2;
        int i32;
        int i33;
        int i34;
        zzmk zzmkVarZzr2;
        int i35;
        Unsafe unsafe3;
        Object object;
        int i36;
        zzne zzneVar;
        zzng zzngVar;
        Object obj3;
        long j3;
        zzmo zzmoVar;
        zzmo zzmoVar2;
        int i37;
        Unsafe unsafe4;
        int i38;
        int i39;
        zznp<T> zznpVar4;
        zzlo zzloVar;
        int iZza;
        zzlo zzloVar2;
        int i40;
        int i41;
        zzly zzlyVar;
        int iZza2;
        zzly zzlyVar2;
        int i42;
        int i43;
        zzna zznaVar;
        int iZza3;
        zzna zznaVar2;
        int i44;
        int i45;
        zzna zznaVar3;
        int iZza4;
        zzna zznaVar4;
        int i46;
        int i47;
        zzmg zzmgVar;
        int iZza5;
        zzmg zzmgVar2;
        int i48;
        int i49;
        zzky zzkyVar;
        boolean z3;
        int iZza6;
        boolean z4;
        zzky zzkyVar2;
        int i50;
        boolean z5;
        int i51;
        int iZza7;
        int i52;
        int i53;
        int iZza8;
        int i54;
        int i55;
        int i56;
        Object obj4;
        int iZza9;
        int i57;
        int iZza10;
        int i58;
        int iZza11;
        int i59;
        int iZzl;
        zzmk zzmkVarZzr3;
        zzoi zzoiVar;
        int i60;
        int i61;
        Iterator it;
        Object objZzE;
        int iIntValue;
        int size2;
        Object objZzE2;
        int i62;
        int i63;
        Integer num;
        int iIntValue2;
        int i64;
        zzmg zzmgVar3;
        int iZza12;
        zzmg zzmgVar4;
        int i65;
        zzna zznaVar5;
        int iZza13;
        zzna zznaVar6;
        int i66;
        int i67;
        zznx zznxVarZzp;
        int iZza14;
        zznp<T> zznpVar5 = this;
        Object obj5 = obj;
        i2 = i2;
        i3 = i3;
        zzB(obj);
        Unsafe unsafe5 = zzb;
        int iZzo = i;
        int i68 = -1;
        int i69 = 0;
        int i70 = 0;
        int i71 = 0;
        int i72 = 1048575;
        while (true) {
            if (iZzo < i2) {
                int i73 = iZzo + 1;
                int i74 = bArr[iZzo];
                if (i74 < 0) {
                    iZzb = zzkx.zzb(i74, bArr, i73, zzkwVar);
                    i4 = zzkwVar.zza;
                } else {
                    i4 = i74;
                    iZzb = i73;
                }
                int i75 = i4 >>> 3;
                if (i75 > i68) {
                    iZzN = (i75 < zznpVar5.zze || i75 > zznpVar5.zzf) ? -1 : zznpVar5.zzN(i75, i69 / 3);
                } else {
                    if (i75 < zznpVar5.zze || i75 > zznpVar5.zzf) {
                        i5 = -1;
                        iZzN = -1;
                    } else {
                        iZzN = zznpVar5.zzN(i75, 0);
                    }
                    if (iZzN == i5) {
                        obj2 = obj5;
                        i6 = iZzb;
                        i7 = i71;
                        i8 = i72;
                        str = "Failed to parse the message.";
                        unsafe = unsafe5;
                        i9 = i75;
                        i10 = 0;
                        i11 = i4;
                    } else {
                        i12 = i4 & 7;
                        iArr = zznpVar5.zzc;
                        i13 = i4;
                        i14 = iArr[iZzN + 1];
                        iZzz = zzz(i14);
                        j = i14 & 1048575;
                        i15 = i75;
                        if (iZzz <= 17) {
                            int i76 = iArr[iZzN + 2];
                            i16 = 1 << (i76 >>> 20);
                            i17 = 1048575;
                            i18 = i76 & 1048575;
                            i19 = iZzb;
                            if (i18 != i72) {
                                if (i72 != 1048575) {
                                    unsafe5.putInt(obj5, i72, i71);
                                    i17 = 1048575;
                                }
                                if (i18 == i17) {
                                    i71 = 0;
                                } else {
                                    i71 = unsafe5.getInt(obj5, i18);
                                }
                            } else {
                                i18 = i72;
                            }
                            switch (iZzz) {
                                case 0:
                                    zznpVar = this;
                                    i20 = i18;
                                    i23 = i19;
                                    i10 = iZzN;
                                    i22 = i13 == true ? 1 : 0;
                                    if (i12 == 1) {
                                        zznpVar2 = zznpVar;
                                        i3 = i3;
                                        obj2 = obj5;
                                        i11 = i22;
                                        i7 = i71;
                                        i6 = i23;
                                        unsafe = unsafe5;
                                        zznpVar5 = zznpVar2;
                                        i8 = i20;
                                        str = "Failed to parse the message.";
                                        i9 = i15;
                                    } else {
                                        iZzo = i23 + 8;
                                        i71 |= i16;
                                        zzop.zzm(obj5, j, Double.longBitsToDouble(zzkx.zze(bArr, i23)));
                                        i70 = i22;
                                        zznpVar5 = zznpVar;
                                        i69 = i10;
                                        i72 = i20;
                                        i68 = i15;
                                    }
                                    break;
                                case 1:
                                    zznpVar = this;
                                    i20 = i18;
                                    i23 = i19;
                                    i10 = iZzN;
                                    i22 = i13 == true ? 1 : 0;
                                    if (i12 == 5) {
                                        zznpVar2 = zznpVar;
                                        i3 = i3;
                                        obj2 = obj5;
                                        i11 = i22;
                                        i7 = i71;
                                        i6 = i23;
                                        unsafe = unsafe5;
                                        zznpVar5 = zznpVar2;
                                        i8 = i20;
                                        str = "Failed to parse the message.";
                                        i9 = i15;
                                    } else {
                                        iZzo = i23 + 4;
                                        i71 |= i16;
                                        zzop.zzk(obj5, j, Float.intBitsToFloat(zzkx.zzd(bArr, i23)));
                                        i70 = i22;
                                        zznpVar5 = zznpVar;
                                        i69 = i10;
                                        i72 = i20;
                                        i68 = i15;
                                    }
                                    break;
                                case 2:
                                case 3:
                                    zznpVar = this;
                                    i20 = i18;
                                    i23 = i19;
                                    i10 = iZzN;
                                    i22 = i13 == true ? 1 : 0;
                                    if (i12 == 0) {
                                        zznpVar2 = zznpVar;
                                        i3 = i3;
                                        obj2 = obj5;
                                        i11 = i22;
                                        i7 = i71;
                                        i6 = i23;
                                        unsafe = unsafe5;
                                        zznpVar5 = zznpVar2;
                                        i8 = i20;
                                        str = "Failed to parse the message.";
                                        i9 = i15;
                                    } else {
                                        i24 = i16 | i71;
                                        iZzc = zzkx.zzc(bArr, i23, zzkwVar);
                                        unsafe5.putLong(obj, j, zzkwVar.zzb);
                                        i70 = i22;
                                        zznpVar5 = zznpVar;
                                        i69 = i10;
                                        i71 = i24;
                                        iZzo = iZzc;
                                        i72 = i20;
                                        i68 = i15;
                                    }
                                    break;
                                case 4:
                                case 11:
                                    zznpVar = this;
                                    i20 = i18;
                                    i23 = i19;
                                    i10 = iZzN;
                                    i22 = i13 == true ? 1 : 0;
                                    if (i12 == 0) {
                                        zznpVar2 = zznpVar;
                                        i3 = i3;
                                        obj2 = obj5;
                                        i11 = i22;
                                        i7 = i71;
                                        i6 = i23;
                                        unsafe = unsafe5;
                                        zznpVar5 = zznpVar2;
                                        i8 = i20;
                                        str = "Failed to parse the message.";
                                        i9 = i15;
                                    } else {
                                        i71 |= i16;
                                        iZzo = zzkx.zza(bArr, i23, zzkwVar);
                                        unsafe5.putInt(obj5, j, zzkwVar.zza);
                                        i70 = i22;
                                        zznpVar5 = zznpVar;
                                        i69 = i10;
                                        i72 = i20;
                                        i68 = i15;
                                    }
                                    break;
                                case 5:
                                case 14:
                                    zznpVar = this;
                                    i20 = i18;
                                    i23 = i19;
                                    i10 = iZzN;
                                    i22 = i13 == true ? 1 : 0;
                                    if (i12 == 1) {
                                        zznpVar2 = zznpVar;
                                        i3 = i3;
                                        obj2 = obj5;
                                        i11 = i22;
                                        i7 = i71;
                                        i6 = i23;
                                        unsafe = unsafe5;
                                        zznpVar5 = zznpVar2;
                                        i8 = i20;
                                        str = "Failed to parse the message.";
                                        i9 = i15;
                                    } else {
                                        iZzc = i23 + 8;
                                        i24 = i16 | i71;
                                        unsafe5.putLong(obj, j, zzkx.zze(bArr, i23));
                                        i70 = i22;
                                        zznpVar5 = zznpVar;
                                        i69 = i10;
                                        i71 = i24;
                                        iZzo = iZzc;
                                        i72 = i20;
                                        i68 = i15;
                                    }
                                    break;
                                case 6:
                                case 13:
                                    zznpVar = this;
                                    i20 = i18;
                                    i23 = i19;
                                    i10 = iZzN;
                                    i22 = i13 == true ? 1 : 0;
                                    if (i12 == 5) {
                                        zznpVar2 = zznpVar;
                                        i3 = i3;
                                        obj2 = obj5;
                                        i11 = i22;
                                        i7 = i71;
                                        i6 = i23;
                                        unsafe = unsafe5;
                                        zznpVar5 = zznpVar2;
                                        i8 = i20;
                                        str = "Failed to parse the message.";
                                        i9 = i15;
                                    } else {
                                        iZzo = i23 + 4;
                                        i71 |= i16;
                                        unsafe5.putInt(obj5, j, zzkx.zzd(bArr, i23));
                                        i70 = i22;
                                        zznpVar5 = zznpVar;
                                        i69 = i10;
                                        i72 = i20;
                                        i68 = i15;
                                    }
                                    break;
                                case 7:
                                    zznpVar = this;
                                    i20 = i18;
                                    i23 = i19;
                                    i10 = iZzN;
                                    i22 = i13 == true ? 1 : 0;
                                    if (i12 == 0) {
                                        zznpVar2 = zznpVar;
                                        i3 = i3;
                                        obj2 = obj5;
                                        i11 = i22;
                                        i7 = i71;
                                        i6 = i23;
                                        unsafe = unsafe5;
                                        zznpVar5 = zznpVar2;
                                        i8 = i20;
                                        str = "Failed to parse the message.";
                                        i9 = i15;
                                    } else {
                                        i71 |= i16;
                                        iZzo = zzkx.zzc(bArr, i23, zzkwVar);
                                        if (zzkwVar.zzb != 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        zzop.zzi(obj5, j, z);
                                        i70 = i22;
                                        zznpVar5 = zznpVar;
                                        i69 = i10;
                                        i72 = i20;
                                        i68 = i15;
                                    }
                                    break;
                                case 8:
                                    zznpVar = this;
                                    i20 = i18;
                                    i23 = i19;
                                    i10 = iZzN;
                                    i22 = i13 == true ? 1 : 0;
                                    if (i12 == 2) {
                                        zznpVar2 = zznpVar;
                                        i3 = i3;
                                        obj2 = obj5;
                                        i11 = i22;
                                        i7 = i71;
                                        i6 = i23;
                                        unsafe = unsafe5;
                                        zznpVar5 = zznpVar2;
                                        i8 = i20;
                                        str = "Failed to parse the message.";
                                        i9 = i15;
                                    } else {
                                        if ((i14 & 536870912) != 0) {
                                            i71 |= i16;
                                            iZzo = zzkx.zzf(bArr, i23, zzkwVar);
                                        } else {
                                            iZzo = zzkx.zza(bArr, i23, zzkwVar);
                                            i25 = zzkwVar.zza;
                                            if (i25 >= 0) {
                                                throw new zzmr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                            }
                                            int i77 = i71 | i16;
                                            if (i25 == 0) {
                                                zzkwVar.zzc = "";
                                            } else {
                                                zzkwVar.zzc = new String(bArr, iZzo, i25, zzmp.zza);
                                                iZzo += i25;
                                            }
                                            i71 = i77;
                                        }
                                        unsafe5.putObject(obj5, j, zzkwVar.zzc);
                                        i70 = i22;
                                        zznpVar5 = zznpVar;
                                        i69 = i10;
                                        i72 = i20;
                                        i68 = i15;
                                    }
                                    break;
                                case 9:
                                    zznpVar = this;
                                    i20 = i18;
                                    i26 = i19;
                                    i10 = iZzN;
                                    i22 = i13 == true ? 1 : 0;
                                    if (i12 == 2) {
                                        Object objZzs = zznpVar.zzs(obj5, i10);
                                        iZzo = zzkx.zzj(objZzs, zznpVar.zzp(i10), bArr, i26, i2, zzkwVar);
                                        zznpVar.zzt(obj5, i10, objZzs);
                                        i70 = i22 == true ? 1 : 0;
                                        zznpVar5 = zznpVar;
                                        i71 |= i16;
                                        i69 = i10;
                                        i72 = i20;
                                        i68 = i15;
                                        i2 = i2;
                                    }
                                    i23 = i26;
                                    zznpVar2 = zznpVar;
                                    i3 = i3;
                                    obj2 = obj5;
                                    i11 = i22;
                                    i7 = i71;
                                    i6 = i23;
                                    unsafe = unsafe5;
                                    zznpVar5 = zznpVar2;
                                    i8 = i20;
                                    str = "Failed to parse the message.";
                                    i9 = i15;
                                    break;
                                case 10:
                                    zznpVar = this;
                                    i20 = i18;
                                    i26 = i19;
                                    i10 = iZzN;
                                    i22 = i13 == true ? 1 : 0;
                                    if (i12 == 2) {
                                        i23 = i26;
                                        zznpVar2 = zznpVar;
                                        i3 = i3;
                                        obj2 = obj5;
                                        i11 = i22;
                                        i7 = i71;
                                        i6 = i23;
                                        unsafe = unsafe5;
                                        zznpVar5 = zznpVar2;
                                        i8 = i20;
                                        str = "Failed to parse the message.";
                                        i9 = i15;
                                    } else {
                                        i71 |= i16;
                                        iZzo = zzkx.zzg(bArr, i26, zzkwVar);
                                        unsafe5.putObject(obj5, j, zzkwVar.zzc);
                                        i70 = i22;
                                        zznpVar5 = zznpVar;
                                        i69 = i10;
                                        i72 = i20;
                                        i68 = i15;
                                    }
                                    break;
                                case 12:
                                    i20 = i18;
                                    i21 = i19;
                                    i22 = i13 == true ? 1 : 0;
                                    i10 = iZzN;
                                    if (i12 == 0) {
                                        zznpVar2 = this;
                                        i23 = i21;
                                        i3 = i3;
                                        obj2 = obj5;
                                        i11 = i22;
                                        i7 = i71;
                                        i6 = i23;
                                        unsafe = unsafe5;
                                        zznpVar5 = zznpVar2;
                                        i8 = i20;
                                        str = "Failed to parse the message.";
                                        i9 = i15;
                                    } else {
                                        iZzo = zzkx.zza(bArr, i21, zzkwVar);
                                        i27 = zzkwVar.zza;
                                        zznpVar = this;
                                        zzmk zzmkVarZzr4 = zznpVar.zzr(i10);
                                        if ((i14 & Integer.MIN_VALUE) != 0 || zzmkVarZzr4 == null || zzmkVarZzr4.zza(i27)) {
                                            i71 |= i16;
                                            unsafe5.putInt(obj5, j, i27);
                                        } else {
                                            zzg(obj).zzk(i22 == true ? 1 : 0, Long.valueOf(i27));
                                        }
                                        i70 = i22;
                                        zznpVar5 = zznpVar;
                                        i69 = i10;
                                        i72 = i20;
                                        i68 = i15;
                                    }
                                    break;
                                case 15:
                                    i20 = i18;
                                    i21 = i19;
                                    i22 = i13 == true ? 1 : 0;
                                    i10 = iZzN;
                                    if (i12 == 0) {
                                        zznpVar2 = this;
                                        i23 = i21;
                                        i3 = i3;
                                        obj2 = obj5;
                                        i11 = i22;
                                        i7 = i71;
                                        i6 = i23;
                                        unsafe = unsafe5;
                                        zznpVar5 = zznpVar2;
                                        i8 = i20;
                                        str = "Failed to parse the message.";
                                        i9 = i15;
                                    } else {
                                        i71 |= i16;
                                        iZzo = zzkx.zza(bArr, i21, zzkwVar);
                                        unsafe5.putInt(obj5, j, zzlj.zzb(zzkwVar.zza));
                                        i70 = i22 == true ? 1 : 0;
                                        i69 = i10;
                                        i72 = i20;
                                        i68 = i15;
                                        zznpVar5 = this;
                                    }
                                    break;
                                case 16:
                                    if (i12 == 0) {
                                        i20 = i18;
                                        i21 = i19;
                                        i22 = i13 == true ? 1 : 0;
                                        i10 = iZzN;
                                        zznpVar2 = this;
                                        i23 = i21;
                                        i3 = i3;
                                        obj2 = obj5;
                                        i11 = i22;
                                        i7 = i71;
                                        i6 = i23;
                                        unsafe = unsafe5;
                                        zznpVar5 = zznpVar2;
                                        i8 = i20;
                                        str = "Failed to parse the message.";
                                        i9 = i15;
                                    } else {
                                        int i78 = i71 | i16;
                                        int iZzc2 = zzkx.zzc(bArr, i19, zzkwVar);
                                        i20 = i18;
                                        unsafe5.putLong(obj, j, zzlj.zzc(zzkwVar.zzb));
                                        i70 = i13 == true ? 1 : 0;
                                        i71 = i78;
                                        i69 = iZzN;
                                        iZzo = iZzc2;
                                        i72 = i20;
                                        i68 = i15;
                                        zznpVar5 = this;
                                    }
                                    break;
                                default:
                                    zznpVar = this;
                                    i20 = i18;
                                    i23 = i19;
                                    i10 = iZzN;
                                    i22 = i13 == true ? 1 : 0;
                                    if (i12 == 3) {
                                        Object objZzs2 = zznpVar.zzs(obj5, i10);
                                        iZzo = zzkx.zzk(objZzs2, zznpVar.zzp(i10), bArr, i23, i2, (i15 << 3) | 4, zzkwVar);
                                        zznpVar.zzt(obj5, i10, objZzs2);
                                        i70 = i22 == true ? 1 : 0;
                                        i71 |= i16;
                                        i69 = i10;
                                        zznpVar5 = zznpVar;
                                        i72 = i20;
                                        i68 = i15;
                                        i2 = i2;
                                    }
                                    zznpVar2 = zznpVar;
                                    i3 = i3;
                                    obj2 = obj5;
                                    i11 = i22;
                                    i7 = i71;
                                    i6 = i23;
                                    unsafe = unsafe5;
                                    zznpVar5 = zznpVar2;
                                    i8 = i20;
                                    str = "Failed to parse the message.";
                                    i9 = i15;
                                    break;
                            }
                        } else {
                            i28 = iZzb;
                            i10 = iZzN;
                            i8 = i72;
                            zznpVar3 = zznpVar5;
                            i7 = i71;
                            if (iZzz == 27) {
                                if (i12 == 2) {
                                    zzmoVarZzg = (zzmo) unsafe5.getObject(obj5, j);
                                    if (!zzmoVarZzg.zza()) {
                                        size = zzmoVarZzg.size();
                                        if (size == 0) {
                                            i31 = 10;
                                        } else {
                                            i31 = size + size;
                                        }
                                        zzmoVarZzg = zzmoVarZzg.zzg(i31);
                                        unsafe5.putObject(obj5, j, zzmoVarZzg);
                                    }
                                    iZzo = zzkx.zzn(zznpVar3.zzp(i10), i13 == true ? 1 : 0, bArr, i28, i2, zzmoVarZzg, zzkwVar);
                                    i3 = i3;
                                    i70 = i13 == true ? 1 : 0;
                                    zznpVar5 = zznpVar3;
                                    i69 = i10;
                                    i71 = i7;
                                    i68 = i15;
                                    i72 = i8;
                                } else {
                                    unsafe2 = unsafe5;
                                    i29 = i28;
                                    str2 = "Failed to parse the message.";
                                    i30 = i15;
                                }
                                i2 = i2;
                            } else if (iZzz <= 49) {
                                j3 = i14;
                                zzmoVar = (zzmo) unsafe5.getObject(obj5, j);
                                if (zzmoVar.zza()) {
                                    zzmoVar2 = zzmoVar;
                                } else {
                                    int size3 = zzmoVar.size();
                                    zzmo zzmoVarZzg2 = zzmoVar.zzg(size3 + size3);
                                    unsafe5.putObject(obj5, j, zzmoVarZzg2);
                                    zzmoVar2 = zzmoVarZzg2;
                                }
                                switch (iZzz) {
                                    case 18:
                                    case 35:
                                        i37 = i2;
                                        unsafe4 = unsafe5;
                                        i38 = i28;
                                        str = "Failed to parse the message.";
                                        i39 = i15;
                                        zznpVar4 = this;
                                        if (i12 == 2) {
                                            if (i12 == 1) {
                                                iZzo = i38 + 8;
                                                int i79 = zzkx.zza;
                                                zzloVar = (zzlo) zzmoVar2;
                                                zzloVar.zzf(Double.longBitsToDouble(zzkx.zze(bArr, i38)));
                                                while (iZzo < i37) {
                                                    iZza = zzkx.zza(bArr, iZzo, zzkwVar);
                                                    if (i13 == zzkwVar.zza) {
                                                        zzloVar.zzf(Double.longBitsToDouble(zzkx.zze(bArr, iZza)));
                                                        iZzo = iZza + 8;
                                                    }
                                                }
                                            }
                                            i45 = i39;
                                            iZzo = i38;
                                            if (iZzo != i38) {
                                                i3 = i3;
                                                obj2 = obj5;
                                                i11 = i13 == true ? 1 : 0;
                                                i6 = iZzo;
                                                zznpVar5 = zznpVar4;
                                                unsafe = unsafe4;
                                                i9 = i45;
                                            } else {
                                                i3 = i3;
                                                i70 = i13 == true ? 1 : 0;
                                                i2 = i37;
                                                zznpVar5 = zznpVar4;
                                                i69 = i10;
                                                i71 = i7;
                                                i72 = i8;
                                                unsafe5 = unsafe4;
                                                i68 = i45;
                                            }
                                        } else {
                                            int i80 = zzkx.zza;
                                            zzloVar2 = (zzlo) zzmoVar2;
                                            iZzo = zzkx.zza(bArr, i38, zzkwVar);
                                            i40 = zzkwVar.zza;
                                            i41 = iZzo + i40;
                                            if (i41 <= bArr.length) {
                                                throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzloVar2.zzh(zzloVar2.size() + (i40 / 8));
                                            while (iZzo < i41) {
                                                zzloVar2.zzf(Double.longBitsToDouble(zzkx.zze(bArr, iZzo)));
                                                iZzo += 8;
                                            }
                                            if (iZzo != i41) {
                                                throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i45 = i39;
                                        if (iZzo != i38) {
                                            i3 = i3;
                                            obj2 = obj5;
                                            i11 = i13 == true ? 1 : 0;
                                            i6 = iZzo;
                                            zznpVar5 = zznpVar4;
                                            unsafe = unsafe4;
                                            i9 = i45;
                                        } else {
                                            i3 = i3;
                                            i70 = i13 == true ? 1 : 0;
                                            i2 = i37;
                                            zznpVar5 = zznpVar4;
                                            i69 = i10;
                                            i71 = i7;
                                            i72 = i8;
                                            unsafe5 = unsafe4;
                                            i68 = i45;
                                        }
                                        break;
                                    case 19:
                                    case 36:
                                        i37 = i2;
                                        unsafe4 = unsafe5;
                                        i38 = i28;
                                        str = "Failed to parse the message.";
                                        i39 = i15;
                                        zznpVar4 = this;
                                        if (i12 == 2) {
                                            if (i12 == 5) {
                                                iZzo = i38 + 4;
                                                int i81 = zzkx.zza;
                                                zzlyVar = (zzly) zzmoVar2;
                                                zzlyVar.zzf(Float.intBitsToFloat(zzkx.zzd(bArr, i38)));
                                                while (iZzo < i37) {
                                                    iZza2 = zzkx.zza(bArr, iZzo, zzkwVar);
                                                    if (i13 == zzkwVar.zza) {
                                                        zzlyVar.zzf(Float.intBitsToFloat(zzkx.zzd(bArr, iZza2)));
                                                        iZzo = iZza2 + 4;
                                                    }
                                                }
                                            }
                                            i45 = i39;
                                            iZzo = i38;
                                            if (iZzo != i38) {
                                                i3 = i3;
                                                obj2 = obj5;
                                                i11 = i13 == true ? 1 : 0;
                                                i6 = iZzo;
                                                zznpVar5 = zznpVar4;
                                                unsafe = unsafe4;
                                                i9 = i45;
                                            } else {
                                                i3 = i3;
                                                i70 = i13 == true ? 1 : 0;
                                                i2 = i37;
                                                zznpVar5 = zznpVar4;
                                                i69 = i10;
                                                i71 = i7;
                                                i72 = i8;
                                                unsafe5 = unsafe4;
                                                i68 = i45;
                                            }
                                        } else {
                                            int i82 = zzkx.zza;
                                            zzlyVar2 = (zzly) zzmoVar2;
                                            iZzo = zzkx.zza(bArr, i38, zzkwVar);
                                            i42 = zzkwVar.zza;
                                            i43 = iZzo + i42;
                                            if (i43 <= bArr.length) {
                                                throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzlyVar2.zzh(zzlyVar2.size() + (i42 / 4));
                                            while (iZzo < i43) {
                                                zzlyVar2.zzf(Float.intBitsToFloat(zzkx.zzd(bArr, iZzo)));
                                                iZzo += 4;
                                            }
                                            if (iZzo != i43) {
                                                throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i45 = i39;
                                        if (iZzo != i38) {
                                            i3 = i3;
                                            obj2 = obj5;
                                            i11 = i13 == true ? 1 : 0;
                                            i6 = iZzo;
                                            zznpVar5 = zznpVar4;
                                            unsafe = unsafe4;
                                            i9 = i45;
                                        } else {
                                            i3 = i3;
                                            i70 = i13 == true ? 1 : 0;
                                            i2 = i37;
                                            zznpVar5 = zznpVar4;
                                            i69 = i10;
                                            i71 = i7;
                                            i72 = i8;
                                            unsafe5 = unsafe4;
                                            i68 = i45;
                                        }
                                        break;
                                    case 20:
                                    case 21:
                                    case 37:
                                    case 38:
                                        i37 = i2;
                                        unsafe4 = unsafe5;
                                        i38 = i28;
                                        str = "Failed to parse the message.";
                                        i39 = i15;
                                        zznpVar4 = this;
                                        if (i12 == 2) {
                                            if (i12 == 0) {
                                                int i83 = zzkx.zza;
                                                zznaVar = (zzna) zzmoVar2;
                                                iZzo = zzkx.zzc(bArr, i38, zzkwVar);
                                                zznaVar.zzf(zzkwVar.zzb);
                                                while (iZzo < i37) {
                                                    iZza3 = zzkx.zza(bArr, iZzo, zzkwVar);
                                                    if (i13 == zzkwVar.zza) {
                                                        iZzo = zzkx.zzc(bArr, iZza3, zzkwVar);
                                                        zznaVar.zzf(zzkwVar.zzb);
                                                    }
                                                }
                                            }
                                            i45 = i39;
                                            iZzo = i38;
                                            if (iZzo != i38) {
                                                i3 = i3;
                                                obj2 = obj5;
                                                i11 = i13 == true ? 1 : 0;
                                                i6 = iZzo;
                                                zznpVar5 = zznpVar4;
                                                unsafe = unsafe4;
                                                i9 = i45;
                                            } else {
                                                i3 = i3;
                                                i70 = i13 == true ? 1 : 0;
                                                i2 = i37;
                                                zznpVar5 = zznpVar4;
                                                i69 = i10;
                                                i71 = i7;
                                                i72 = i8;
                                                unsafe5 = unsafe4;
                                                i68 = i45;
                                            }
                                        } else {
                                            int i84 = zzkx.zza;
                                            zznaVar2 = (zzna) zzmoVar2;
                                            iZzo = zzkx.zza(bArr, i38, zzkwVar);
                                            i44 = zzkwVar.zza + iZzo;
                                            while (iZzo < i44) {
                                                iZzo = zzkx.zzc(bArr, iZzo, zzkwVar);
                                                zznaVar2.zzf(zzkwVar.zzb);
                                            }
                                            if (iZzo != i44) {
                                                throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i45 = i39;
                                        if (iZzo != i38) {
                                            i3 = i3;
                                            obj2 = obj5;
                                            i11 = i13 == true ? 1 : 0;
                                            i6 = iZzo;
                                            zznpVar5 = zznpVar4;
                                            unsafe = unsafe4;
                                            i9 = i45;
                                        } else {
                                            i3 = i3;
                                            i70 = i13 == true ? 1 : 0;
                                            i2 = i37;
                                            zznpVar5 = zznpVar4;
                                            i69 = i10;
                                            i71 = i7;
                                            i72 = i8;
                                            unsafe5 = unsafe4;
                                            i68 = i45;
                                        }
                                        break;
                                    case 22:
                                    case 29:
                                    case 39:
                                    case 43:
                                        i37 = i2;
                                        unsafe4 = unsafe5;
                                        i38 = i28;
                                        str = "Failed to parse the message.";
                                        i39 = i15;
                                        zznpVar4 = this;
                                        if (i12 == 2) {
                                            iZzo = zzkx.zzm(bArr, i38, zzmoVar2, zzkwVar);
                                            i45 = i39;
                                        } else if (i12 == 0) {
                                            iZzo = zzkx.zzl(i13 == true ? 1 : 0, bArr, i38, i2, zzmoVar2, zzkwVar);
                                            i45 = i39;
                                        } else {
                                            i45 = i39;
                                            iZzo = i38;
                                        }
                                        if (iZzo != i38) {
                                            i3 = i3;
                                            obj2 = obj5;
                                            i11 = i13 == true ? 1 : 0;
                                            i6 = iZzo;
                                            zznpVar5 = zznpVar4;
                                            unsafe = unsafe4;
                                            i9 = i45;
                                        } else {
                                            i3 = i3;
                                            i70 = i13 == true ? 1 : 0;
                                            i2 = i37;
                                            zznpVar5 = zznpVar4;
                                            i69 = i10;
                                            i71 = i7;
                                            i72 = i8;
                                            unsafe5 = unsafe4;
                                            i68 = i45;
                                        }
                                        break;
                                    case 23:
                                    case 32:
                                    case 40:
                                    case 46:
                                        i37 = i2;
                                        unsafe4 = unsafe5;
                                        i38 = i28;
                                        str = "Failed to parse the message.";
                                        i39 = i15;
                                        zznpVar4 = this;
                                        if (i12 == 2) {
                                            if (i12 == 1) {
                                                iZzo = i38 + 8;
                                                int i85 = zzkx.zza;
                                                zznaVar3 = (zzna) zzmoVar2;
                                                zznaVar3.zzf(zzkx.zze(bArr, i38));
                                                while (iZzo < i37) {
                                                    iZza4 = zzkx.zza(bArr, iZzo, zzkwVar);
                                                    if (i13 == zzkwVar.zza) {
                                                        zznaVar3.zzf(zzkx.zze(bArr, iZza4));
                                                        iZzo = iZza4 + 8;
                                                    }
                                                }
                                            }
                                            i45 = i39;
                                            iZzo = i38;
                                            if (iZzo != i38) {
                                                i3 = i3;
                                                obj2 = obj5;
                                                i11 = i13 == true ? 1 : 0;
                                                i6 = iZzo;
                                                zznpVar5 = zznpVar4;
                                                unsafe = unsafe4;
                                                i9 = i45;
                                            } else {
                                                i3 = i3;
                                                i70 = i13 == true ? 1 : 0;
                                                i2 = i37;
                                                zznpVar5 = zznpVar4;
                                                i69 = i10;
                                                i71 = i7;
                                                i72 = i8;
                                                unsafe5 = unsafe4;
                                                i68 = i45;
                                            }
                                        } else {
                                            int i86 = zzkx.zza;
                                            zznaVar4 = (zzna) zzmoVar2;
                                            iZzo = zzkx.zza(bArr, i38, zzkwVar);
                                            i46 = zzkwVar.zza;
                                            i47 = iZzo + i46;
                                            if (i47 <= bArr.length) {
                                                throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zznaVar4.zzh(zznaVar4.size() + (i46 / 8));
                                            while (iZzo < i47) {
                                                zznaVar4.zzf(zzkx.zze(bArr, iZzo));
                                                iZzo += 8;
                                            }
                                            if (iZzo != i47) {
                                                throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i45 = i39;
                                        if (iZzo != i38) {
                                            i3 = i3;
                                            obj2 = obj5;
                                            i11 = i13 == true ? 1 : 0;
                                            i6 = iZzo;
                                            zznpVar5 = zznpVar4;
                                            unsafe = unsafe4;
                                            i9 = i45;
                                        } else {
                                            i3 = i3;
                                            i70 = i13 == true ? 1 : 0;
                                            i2 = i37;
                                            zznpVar5 = zznpVar4;
                                            i69 = i10;
                                            i71 = i7;
                                            i72 = i8;
                                            unsafe5 = unsafe4;
                                            i68 = i45;
                                        }
                                        break;
                                    case 24:
                                    case 31:
                                    case 41:
                                    case 45:
                                        i37 = i2;
                                        unsafe4 = unsafe5;
                                        i38 = i28;
                                        str = "Failed to parse the message.";
                                        i39 = i15;
                                        zznpVar4 = this;
                                        if (i12 == 2) {
                                            if (i12 == 5) {
                                                iZzo = i38 + 4;
                                                int i87 = zzkx.zza;
                                                zzmgVar = (zzmg) zzmoVar2;
                                                zzmgVar.zzh(zzkx.zzd(bArr, i38));
                                                while (iZzo < i37) {
                                                    iZza5 = zzkx.zza(bArr, iZzo, zzkwVar);
                                                    if (i13 == zzkwVar.zza) {
                                                        zzmgVar.zzh(zzkx.zzd(bArr, iZza5));
                                                        iZzo = iZza5 + 4;
                                                    }
                                                }
                                            }
                                            i45 = i39;
                                            iZzo = i38;
                                            if (iZzo != i38) {
                                                i3 = i3;
                                                obj2 = obj5;
                                                i11 = i13 == true ? 1 : 0;
                                                i6 = iZzo;
                                                zznpVar5 = zznpVar4;
                                                unsafe = unsafe4;
                                                i9 = i45;
                                            } else {
                                                i3 = i3;
                                                i70 = i13 == true ? 1 : 0;
                                                i2 = i37;
                                                zznpVar5 = zznpVar4;
                                                i69 = i10;
                                                i71 = i7;
                                                i72 = i8;
                                                unsafe5 = unsafe4;
                                                i68 = i45;
                                            }
                                        } else {
                                            int i88 = zzkx.zza;
                                            zzmgVar2 = (zzmg) zzmoVar2;
                                            iZzo = zzkx.zza(bArr, i38, zzkwVar);
                                            i48 = zzkwVar.zza;
                                            i49 = iZzo + i48;
                                            if (i49 <= bArr.length) {
                                                throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                            zzmgVar2.zzi(zzmgVar2.size() + (i48 / 4));
                                            while (iZzo < i49) {
                                                zzmgVar2.zzh(zzkx.zzd(bArr, iZzo));
                                                iZzo += 4;
                                            }
                                            if (iZzo != i49) {
                                                throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i45 = i39;
                                        if (iZzo != i38) {
                                            i3 = i3;
                                            obj2 = obj5;
                                            i11 = i13 == true ? 1 : 0;
                                            i6 = iZzo;
                                            zznpVar5 = zznpVar4;
                                            unsafe = unsafe4;
                                            i9 = i45;
                                        } else {
                                            i3 = i3;
                                            i70 = i13 == true ? 1 : 0;
                                            i2 = i37;
                                            zznpVar5 = zznpVar4;
                                            i69 = i10;
                                            i71 = i7;
                                            i72 = i8;
                                            unsafe5 = unsafe4;
                                            i68 = i45;
                                        }
                                        break;
                                    case 25:
                                    case 42:
                                        i37 = i2;
                                        unsafe4 = unsafe5;
                                        i38 = i28;
                                        str = "Failed to parse the message.";
                                        i39 = i15;
                                        zznpVar4 = this;
                                        if (i12 == 2) {
                                            if (i12 == 0) {
                                                int i89 = zzkx.zza;
                                                zzkyVar = (zzky) zzmoVar2;
                                                iZzo = zzkx.zzc(bArr, i38, zzkwVar);
                                                if (zzkwVar.zzb != 0) {
                                                    z3 = true;
                                                } else {
                                                    z3 = false;
                                                }
                                                zzkyVar.zzf(z3);
                                                while (iZzo < i37) {
                                                    iZza6 = zzkx.zza(bArr, iZzo, zzkwVar);
                                                    if (i13 == zzkwVar.zza) {
                                                        iZzo = zzkx.zzc(bArr, iZza6, zzkwVar);
                                                        if (zzkwVar.zzb != 0) {
                                                            z4 = true;
                                                        } else {
                                                            z4 = false;
                                                        }
                                                        zzkyVar.zzf(z4);
                                                    }
                                                }
                                            }
                                            i45 = i39;
                                            iZzo = i38;
                                            if (iZzo != i38) {
                                                i3 = i3;
                                                obj2 = obj5;
                                                i11 = i13 == true ? 1 : 0;
                                                i6 = iZzo;
                                                zznpVar5 = zznpVar4;
                                                unsafe = unsafe4;
                                                i9 = i45;
                                            } else {
                                                i3 = i3;
                                                i70 = i13 == true ? 1 : 0;
                                                i2 = i37;
                                                zznpVar5 = zznpVar4;
                                                i69 = i10;
                                                i71 = i7;
                                                i72 = i8;
                                                unsafe5 = unsafe4;
                                                i68 = i45;
                                            }
                                        } else {
                                            int i90 = zzkx.zza;
                                            zzkyVar2 = (zzky) zzmoVar2;
                                            iZzo = zzkx.zza(bArr, i38, zzkwVar);
                                            i50 = zzkwVar.zza + iZzo;
                                            while (iZzo < i50) {
                                                iZzo = zzkx.zzc(bArr, iZzo, zzkwVar);
                                                if (zzkwVar.zzb != 0) {
                                                    z5 = true;
                                                } else {
                                                    z5 = false;
                                                }
                                                zzkyVar2.zzf(z5);
                                            }
                                            if (iZzo != i50) {
                                                throw new zzmr("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                            }
                                        }
                                        i45 = i39;
                                        if (iZzo != i38) {
                                            i3 = i3;
                                            obj2 = obj5;
                                            i11 = i13 == true ? 1 : 0;
                                            i6 = iZzo;
                                            zznpVar5 = zznpVar4;
                                            unsafe = unsafe4;
                                            i9 = i45;
                                        } else {
                                            i3 = i3;
                                            i70 = i13 == true ? 1 : 0;
                                            i2 = i37;
                                            zznpVar5 = zznpVar4;
                                            i69 = i10;
                                            i71 = i7;
                                            i72 = i8;
                                            unsafe5 = unsafe4;
                                            i68 = i45;
                                        }
                                        break;
                                    case 26:
                                        i37 = i2;
                                        unsafe4 = unsafe5;
                                        i38 = i28;
                                        str = "Failed to parse the message.";
                                        i51 = i15;
                                        zznpVar4 = this;
                                        if (i12 == 2) {
                                            i45 = i51;
                                            iZzo = i38;
                                            if (iZzo != i38) {
                                                i3 = i3;
                                                obj2 = obj5;
                                                i11 = i13 == true ? 1 : 0;
                                                i6 = iZzo;
                                                zznpVar5 = zznpVar4;
                                                unsafe = unsafe4;
                                                i9 = i45;
                                            } else {
                                                i3 = i3;
                                                i70 = i13 == true ? 1 : 0;
                                                i2 = i37;
                                                zznpVar5 = zznpVar4;
                                                i69 = i10;
                                                i71 = i7;
                                                i72 = i8;
                                                unsafe5 = unsafe4;
                                                i68 = i45;
                                            }
                                        } else {
                                            if ((j3 & 536870912) == 0) {
                                                iZza7 = zzkx.zza(bArr, i38, zzkwVar);
                                                i56 = zzkwVar.zza;
                                                if (i56 >= 0) {
                                                    throw new zzmr("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i56 == 0) {
                                                    obj4 = "";
                                                    zzmoVar2.add(obj4);
                                                } else {
                                                    obj4 = 
                                                    /*  JADX ERROR: Method code generation error
                                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0647: MOVE (r6v64 'obj4' java.lang.Object) = (r6v40 java.lang.Object) in method: com.google.android.gms.internal.measurement.zznp.zzh(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzkw):int, file: classes3.dex
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                        	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:267)
                                                        	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:90)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:157)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:140)
                                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:175)
                                                        	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                                                        	at java.base/java.util.ArrayList.forEach(Unknown Source)
                                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                                                        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                                                        	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                                                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                                        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                                                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                                                        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:414)
                                                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:402)
                                                        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:352)
                                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r6v40 java.lang.Object
                                                        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                                                        */
                                                    /*
                                                        Method dump skipped, instruction units count: 3880
                                                        To view this dump change 'Code comments level' option to 'DEBUG'
                                                    */
                                                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zznp.zzh(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzkw):int");
                                                }

                                                @Override // com.google.android.gms.internal.measurement.zznx
                                                public final void zzi(Object obj, byte[] bArr, int i, int i2, zzkw zzkwVar) throws IOException {
                                                    zzh(obj, bArr, i, i2, 0, zzkwVar);
                                                }

                                                /* JADX WARN: Code duplicated, block: B:26:0x006f  */
                                                /* JADX WARN: Code duplicated, block: B:28:0x0075  */
                                                /* JADX WARN: Code duplicated, block: B:41:0x0082 A[SYNTHETIC] */
                                                @Override // com.google.android.gms.internal.measurement.zznx
                                                public final void zzj(Object obj) {
                                                    if (zzA(obj)) {
                                                        if (obj instanceof zzmf) {
                                                            zzmf zzmfVar = (zzmf) obj;
                                                            zzmfVar.zzcm(Integer.MAX_VALUE);
                                                            zzmfVar.zza = 0;
                                                            zzmfVar.zzcg();
                                                        }
                                                        int[] iArr = this.zzc;
                                                        for (int i = 0; i < iArr.length; i += 3) {
                                                            int iZzx = zzx(i);
                                                            int i2 = 1048575 & iZzx;
                                                            int iZzz = zzz(iZzx);
                                                            long j = i2;
                                                            if (iZzz != 9) {
                                                                if (iZzz != 60 && iZzz != 68) {
                                                                    switch (iZzz) {
                                                                        case 17:
                                                                            if (zzJ(obj, i)) {
                                                                                zzp(i).zzj(zzb.getObject(obj, j));
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
                                                                            ((zzmo) zzop.zzn(obj, j)).zzb();
                                                                            break;
                                                                        case 50:
                                                                            Unsafe unsafe = zzb;
                                                                            Object object = unsafe.getObject(obj, j);
                                                                            if (object != null) {
                                                                                ((zzng) object).zzd();
                                                                                unsafe.putObject(obj, j, object);
                                                                            }
                                                                            break;
                                                                    }
                                                                } else if (zzL(obj, iArr[i], i)) {
                                                                    zzp(i).zzj(zzb.getObject(obj, j));
                                                                }
                                                            } else if (zzJ(obj, i)) {
                                                                zzp(i).zzj(zzb.getObject(obj, j));
                                                            }
                                                        }
                                                        this.zzl.zzb(obj);
                                                        if (this.zzh) {
                                                            this.zzm.zza(obj);
                                                        }
                                                    }
                                                }

                                                /* JADX WARN: Code duplicated, block: B:50:0x00cc  */
                                                /* JADX WARN: Code duplicated, block: B:52:0x00db  */
                                                /* JADX WARN: Code duplicated, block: B:55:0x00e6  */
                                                /* JADX WARN: Code duplicated, block: B:58:0x00f1 A[LOOP:2: B:53:0x00e0->B:58:0x00f1, LOOP_END] */
                                                /* JADX WARN: Code duplicated, block: B:75:0x00f0 A[SYNTHETIC] */
                                                /* JADX WARN: Code duplicated, block: B:82:0x010e A[SYNTHETIC] */
                                                @Override // com.google.android.gms.internal.measurement.zznx
                                                public final boolean zzk(Object obj) {
                                                    int i;
                                                    int i2;
                                                    List list;
                                                    zznx zznxVarZzp;
                                                    int i3;
                                                    int i4 = 0;
                                                    int i5 = 0;
                                                    int i6 = 1048575;
                                                    while (i5 < this.zzj) {
                                                        int[] iArr = this.zzi;
                                                        int[] iArr2 = this.zzc;
                                                        int i7 = iArr[i5];
                                                        int i8 = iArr2[i7];
                                                        int iZzx = zzx(i7);
                                                        int i9 = iArr2[i7 + 2];
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
                                                        if ((268435456 & iZzx) != 0 && !zzI(obj, i7, i, i2, i11)) {
                                                            return false;
                                                        }
                                                        int iZzz = zzz(iZzx);
                                                        if (iZzz == 9 || iZzz == 17) {
                                                            if (zzI(obj, i7, i, i2, i11) && !zzw(obj, iZzx, zzp(i7))) {
                                                                return false;
                                                            }
                                                        } else if (iZzz == 27) {
                                                            list = (List) zzop.zzn(obj, iZzx & 1048575);
                                                            if (list.isEmpty()) {
                                                                continue;
                                                            } else {
                                                                zznxVarZzp = zzp(i7);
                                                                for (i3 = 0; i3 < list.size(); i3++) {
                                                                    if (!zznxVarZzp.zzk(list.get(i3))) {
                                                                        return false;
                                                                    }
                                                                }
                                                            }
                                                        } else if (iZzz == 60 || iZzz == 68) {
                                                            if (zzL(obj, i8, i7) && !zzw(obj, iZzx, zzp(i7))) {
                                                                return false;
                                                            }
                                                        } else if (iZzz == 49) {
                                                            list = (List) zzop.zzn(obj, iZzx & 1048575);
                                                            if (list.isEmpty()) {
                                                                zznxVarZzp = zzp(i7);
                                                                while (i3 < list.size()) {
                                                                    if (!zznxVarZzp.zzk(list.get(i3))) {
                                                                        return false;
                                                                    }
                                                                }
                                                            } else {
                                                                continue;
                                                            }
                                                        } else if (iZzz != 50) {
                                                            continue;
                                                        } else {
                                                            zzng zzngVar = (zzng) zzop.zzn(obj, iZzx & 1048575);
                                                            if (!zzngVar.isEmpty() && ((zznf) zzq(i7)).zze().zzc.zza() == zzou.MESSAGE) {
                                                                zznx zznxVarZzb = null;
                                                                for (Object obj2 : zzngVar.values()) {
                                                                    if (zznxVarZzb == null) {
                                                                        zznxVarZzb = zznu.zza().zzb(obj2.getClass());
                                                                    }
                                                                    if (!zznxVarZzb.zzk(obj2)) {
                                                                        return false;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        i5++;
                                                        i6 = i;
                                                        i4 = i2;
                                                    }
                                                    return !this.zzh || ((zzmc) obj).zzb.zze();
                                                }
                                            }
