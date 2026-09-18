package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgbp extends zzgad {
    static final zzgad zza = new zzgbp(null, new Object[0], 0);
    final transient Object[] zzb;

    @CheckForNull
    private final transient Object zzc;
    private final transient int zzd;

    private zzgbp(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r3v34 */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r5v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v7 */
    static zzgbp zzj(int i, Object[] objArr, zzgac zzgacVar) {
        short[] sArr;
        char c;
        char c2;
        ?? r3;
        ?? r6;
        ?? r4;
        int i2 = i;
        Object[] objArrCopyOf = objArr;
        if (i2 == 0) {
            return (zzgbp) zza;
        }
        zzgab zzgabVar = null;
        ?? r5 = 0;
        zzgab zzgabVar2 = null;
        zzgab zzgabVar3 = null;
        int i3 = 1;
        if (i2 == 1) {
            zzfyx.zzb(Objects.requireNonNull(objArrCopyOf[0]), Objects.requireNonNull(objArrCopyOf[1]));
            return new zzgbp(null, objArrCopyOf, 1);
        }
        zzfxe.zzb(i2, objArrCopyOf.length >> 1, FirebaseAnalytics.Param.INDEX);
        int iZzh = zzgaf.zzh(i);
        if (i2 == 1) {
            zzfyx.zzb(Objects.requireNonNull(objArrCopyOf[0]), Objects.requireNonNull(objArrCopyOf[1]));
            i2 = 1;
            c = 1;
            c2 = 2;
        } else {
            int i4 = iZzh - 1;
            byte b = -1;
            if (iZzh <= 128) {
                byte[] bArr = new byte[iZzh];
                Arrays.fill(bArr, (byte) -1);
                int i5 = 0;
                int i6 = 0;
                while (i5 < i2) {
                    int i7 = i6 + i6;
                    int i8 = i5 + i5;
                    Object objRequireNonNull = Objects.requireNonNull(objArrCopyOf[i8]);
                    Object objRequireNonNull2 = Objects.requireNonNull(objArrCopyOf[i8 ^ i3]);
                    zzfyx.zzb(objRequireNonNull, objRequireNonNull2);
                    int iZza = zzfzs.zza(objRequireNonNull.hashCode());
                    while (true) {
                        int i9 = iZza & i4;
                        int i10 = bArr[i9] & 255;
                        if (i10 == 255) {
                            bArr[i9] = (byte) i7;
                            if (i6 < i5) {
                                objArrCopyOf[i7] = objRequireNonNull;
                                objArrCopyOf[i7 ^ 1] = objRequireNonNull2;
                            }
                            i6++;
                            break;
                        }
                        if (objRequireNonNull.equals(objArrCopyOf[i10 == true ? 1 : 0])) {
                            int i11 = ~i10;
                            zzgab zzgabVar4 = new zzgab(objRequireNonNull, objRequireNonNull2, Objects.requireNonNull(objArrCopyOf[i11 == true ? 1 : 0]));
                            objArrCopyOf[i11 == true ? 1 : 0] = objRequireNonNull2;
                            zzgabVar2 = zzgabVar4;
                            break;
                        }
                        iZza = i9 + 1;
                    }
                    i5++;
                    i3 = 1;
                }
                if (i6 == i2) {
                    r3 = bArr;
                } else {
                    r4 = new Object[]{bArr, Integer.valueOf(i6), zzgabVar2};
                    c2 = 2;
                }
                c = 1;
                r5 = r4;
            } else {
                if (iZzh <= 32768) {
                    sArr = new short[iZzh];
                    Arrays.fill(sArr, (short) -1);
                    int i12 = 0;
                    for (int i13 = 0; i13 < i2; i13++) {
                        int i14 = i12 + i12;
                        int i15 = i13 + i13;
                        Object objRequireNonNull3 = Objects.requireNonNull(objArrCopyOf[i15]);
                        Object objRequireNonNull4 = Objects.requireNonNull(objArrCopyOf[i15 ^ 1]);
                        zzfyx.zzb(objRequireNonNull3, objRequireNonNull4);
                        int iZza2 = zzfzs.zza(objRequireNonNull3.hashCode());
                        while (true) {
                            int i16 = iZza2 & i4;
                            char c3 = (char) sArr[i16];
                            if (c3 == 65535) {
                                sArr[i16] = (short) i14;
                                if (i12 < i13) {
                                    objArrCopyOf[i14] = objRequireNonNull3;
                                    objArrCopyOf[i14 ^ 1] = objRequireNonNull4;
                                }
                                i12++;
                                break;
                            }
                            if (objRequireNonNull3.equals(objArrCopyOf[c3])) {
                                int i17 = c3 ^ 1;
                                zzgab zzgabVar5 = new zzgab(objRequireNonNull3, objRequireNonNull4, Objects.requireNonNull(objArrCopyOf[i17 == true ? 1 : 0]));
                                objArrCopyOf[i17 == true ? 1 : 0] = objRequireNonNull4;
                                zzgabVar3 = zzgabVar5;
                                break;
                            }
                            iZza2 = i16 + 1;
                        }
                    }
                    if (i12 != i2) {
                        Integer numValueOf = Integer.valueOf(i12);
                        c = 1;
                        c2 = 2;
                        r6 = new Object[]{sArr, numValueOf, zzgabVar3};
                        r5 = r6;
                    }
                    r3 = sArr;
                } else {
                    int i18 = 1;
                    sArr = new int[iZzh];
                    Arrays.fill((int[]) sArr, -1);
                    int i19 = 0;
                    int i20 = 0;
                    while (i19 < i2) {
                        int i21 = i20 + i20;
                        int i22 = i19 + i19;
                        Object objRequireNonNull5 = Objects.requireNonNull(objArrCopyOf[i22]);
                        Object objRequireNonNull6 = Objects.requireNonNull(objArrCopyOf[i22 ^ i18]);
                        zzfyx.zzb(objRequireNonNull5, objRequireNonNull6);
                        int iZza3 = zzfzs.zza(objRequireNonNull5.hashCode());
                        while (true) {
                            int i23 = iZza3 & i4;
                            ?? r15 = sArr[i23];
                            if (r15 == b) {
                                sArr[i23] = i21;
                                if (i20 < i19) {
                                    objArrCopyOf[i21] = objRequireNonNull5;
                                    objArrCopyOf[i21 ^ 1] = objRequireNonNull6;
                                }
                                i20++;
                                break;
                            }
                            if (objRequireNonNull5.equals(objArrCopyOf[r15])) {
                                int i24 = r15 ^ 1;
                                zzgab zzgabVar6 = new zzgab(objRequireNonNull5, objRequireNonNull6, Objects.requireNonNull(objArrCopyOf[i24 == true ? 1 : 0]));
                                objArrCopyOf[i24 == true ? 1 : 0] = objRequireNonNull6;
                                zzgabVar = zzgabVar6;
                                break;
                            }
                            iZza3 = i23 + 1;
                            b = -1;
                        }
                        i19++;
                        i18 = 1;
                        b = -1;
                    }
                    if (i20 != i2) {
                        c = 1;
                        c2 = 2;
                        r6 = new Object[]{sArr, Integer.valueOf(i20), zzgabVar};
                        r5 = r6;
                    }
                    r3 = sArr;
                }
                c = 1;
                r5 = r4;
            }
            c2 = 2;
            r4 = r3;
            c = 1;
            r5 = r4;
        }
        boolean z = r5 instanceof Object[];
        ?? r7 = r5;
        if (z) {
            Object[] objArr2 = (Object[]) r5;
            zzgab zzgabVar7 = (zzgab) objArr2[c2];
            if (zzgacVar == null) {
                throw zzgabVar7.zza();
            }
            zzgacVar.zzc = zzgabVar7;
            Object obj = objArr2[0];
            int iIntValue = ((Integer) objArr2[c]).intValue();
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue + iIntValue);
            r7 = obj;
            i2 = iIntValue;
        }
        return new zzgbp(r7, objArrCopyOf, i2);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0003  */
    @Override // com.google.android.gms.internal.ads.zzgad, java.util.Map
    @CheckForNull
    public final Object get(@CheckForNull Object obj) {
        Object objRequireNonNull;
        if (obj == null) {
            objRequireNonNull = null;
        } else {
            int i = this.zzd;
            Object[] objArr = this.zzb;
            if (i != 1) {
                Object obj2 = this.zzc;
                if (obj2 == null) {
                    objRequireNonNull = null;
                } else if (obj2 instanceof byte[]) {
                    byte[] bArr = (byte[]) obj2;
                    int length = bArr.length - 1;
                    int iZza = zzfzs.zza(obj.hashCode());
                    while (true) {
                        int i2 = iZza & length;
                        int i3 = bArr[i2] & 255;
                        if (i3 == 255) {
                            break;
                        }
                        if (obj.equals(objArr[i3])) {
                            objRequireNonNull = objArr[i3 ^ 1];
                        } else {
                            iZza = i2 + 1;
                        }
                    }
                    objRequireNonNull = null;
                } else if (obj2 instanceof short[]) {
                    short[] sArr = (short[]) obj2;
                    int length2 = sArr.length - 1;
                    int iZza2 = zzfzs.zza(obj.hashCode());
                    while (true) {
                        int i4 = iZza2 & length2;
                        char c = (char) sArr[i4];
                        if (c == 65535) {
                            break;
                        }
                        if (obj.equals(objArr[c])) {
                            objRequireNonNull = objArr[c ^ 1];
                        } else {
                            iZza2 = i4 + 1;
                        }
                    }
                    objRequireNonNull = null;
                } else {
                    int[] iArr = (int[]) obj2;
                    int length3 = iArr.length - 1;
                    int iZza3 = zzfzs.zza(obj.hashCode());
                    while (true) {
                        int i5 = iZza3 & length3;
                        int i6 = iArr[i5];
                        if (i6 == -1) {
                            break;
                        }
                        if (obj.equals(objArr[i6])) {
                            objRequireNonNull = objArr[i6 ^ 1];
                        } else {
                            iZza3 = i5 + 1;
                        }
                    }
                    objRequireNonNull = null;
                }
            } else if (Objects.requireNonNull(objArr[0]).equals(obj)) {
                objRequireNonNull = Objects.requireNonNull(objArr[1]);
            } else {
                objRequireNonNull = null;
            }
        }
        if (objRequireNonNull == null) {
            return null;
        }
        return objRequireNonNull;
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgad
    final zzfzv zza() {
        return new zzgbo(this.zzb, 1, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzgad
    final zzgaf zzf() {
        return new zzgbm(this, this.zzb, 0, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzgad
    final zzgaf zzg() {
        return new zzgbn(this, new zzgbo(this.zzb, 0, this.zzd));
    }
}
