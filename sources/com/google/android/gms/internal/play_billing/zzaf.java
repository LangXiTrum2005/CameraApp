package com.google.android.gms.internal.play_billing;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.android.billingclient:billing@@6.0.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaf extends zzx {
    static final zzx zza = new zzaf(null, new Object[0], 0);
    final transient Object[] zzb;

    @CheckForNull
    private final transient Object zzc;
    private final transient int zzd;

    private zzaf(@CheckForNull Object obj, Object[] objArr, int i) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r5v4, types: [int[]] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v4 */
    static zzaf zzf(int i, Object[] objArr, zzw zzwVar) {
        int iHighestOneBit;
        short[] sArr;
        ?? r2;
        ?? r6;
        int i2 = i;
        Object[] objArrCopyOf = objArr;
        if (i2 == 0) {
            return (zzaf) zza;
        }
        zzv zzvVar = null;
        ?? r3 = 0;
        zzv zzvVar2 = null;
        zzv zzvVar3 = null;
        if (i2 == 1) {
            Object obj = objArrCopyOf[0];
            obj.getClass();
            Object obj2 = objArrCopyOf[1];
            obj2.getClass();
            zzp.zza(obj, obj2);
            return new zzaf(null, objArrCopyOf, 1);
        }
        zzm.zzb(i2, objArrCopyOf.length >> 1, FirebaseAnalytics.Param.INDEX);
        char c = 2;
        int iMax = Math.max(i2, 2);
        if (iMax < 751619276) {
            iHighestOneBit = Integer.highestOneBit(iMax - 1);
            do {
                iHighestOneBit += iHighestOneBit;
            } while (((double) iHighestOneBit) * 0.7d < iMax);
        } else {
            iHighestOneBit = 1073741824;
            if (iMax >= 1073741824) {
                throw new IllegalArgumentException("collection too large");
            }
        }
        if (i2 == 1) {
            Object obj3 = objArrCopyOf[0];
            obj3.getClass();
            Object obj4 = objArrCopyOf[1];
            obj4.getClass();
            zzp.zza(obj3, obj4);
        } else {
            int i3 = iHighestOneBit - 1;
            byte b = -1;
            if (iHighestOneBit <= 128) {
                byte[] bArr = new byte[iHighestOneBit];
                Arrays.fill(bArr, (byte) -1);
                int i4 = 0;
                for (int i5 = 0; i5 < i2; i5++) {
                    int i6 = i4 + i4;
                    int i7 = i5 + i5;
                    Object obj5 = objArrCopyOf[i7];
                    obj5.getClass();
                    Object obj6 = objArrCopyOf[i7 ^ 1];
                    obj6.getClass();
                    zzp.zza(obj5, obj6);
                    int iZza = zzq.zza(obj5.hashCode());
                    while (true) {
                        int i8 = iZza & i3;
                        int i9 = bArr[i8] & 255;
                        if (i9 == 255) {
                            bArr[i8] = (byte) i6;
                            if (i4 < i5) {
                                objArrCopyOf[i6] = obj5;
                                objArrCopyOf[i6 ^ 1] = obj6;
                            }
                            i4++;
                            break;
                        }
                        if (obj5.equals(objArrCopyOf[i9 == true ? 1 : 0])) {
                            int i10 = ~i9;
                            Object obj7 = objArrCopyOf[i10 == true ? 1 : 0];
                            obj7.getClass();
                            zzv zzvVar4 = new zzv(obj5, obj6, obj7);
                            objArrCopyOf[i10 == true ? 1 : 0] = obj6;
                            zzvVar2 = zzvVar4;
                            break;
                        }
                        iZza = i8 + 1;
                    }
                }
                if (i4 == i2) {
                    r2 = bArr;
                    c = 2;
                    r3 = r2;
                } else {
                    r3 = new Object[]{bArr, Integer.valueOf(i4), zzvVar2};
                    c = 2;
                }
            } else if (iHighestOneBit <= 32768) {
                sArr = new short[iHighestOneBit];
                Arrays.fill(sArr, (short) -1);
                int i11 = 0;
                for (int i12 = 0; i12 < i2; i12++) {
                    int i13 = i11 + i11;
                    int i14 = i12 + i12;
                    Object obj8 = objArrCopyOf[i14];
                    obj8.getClass();
                    Object obj9 = objArrCopyOf[i14 ^ 1];
                    obj9.getClass();
                    zzp.zza(obj8, obj9);
                    int iZza2 = zzq.zza(obj8.hashCode());
                    while (true) {
                        int i15 = iZza2 & i3;
                        char c2 = (char) sArr[i15];
                        if (c2 == 65535) {
                            sArr[i15] = (short) i13;
                            if (i11 < i12) {
                                objArrCopyOf[i13] = obj8;
                                objArrCopyOf[i13 ^ 1] = obj9;
                            }
                            i11++;
                            break;
                        }
                        if (obj8.equals(objArrCopyOf[c2])) {
                            int i16 = c2 ^ 1;
                            Object obj10 = objArrCopyOf[i16 == true ? 1 : 0];
                            obj10.getClass();
                            zzv zzvVar5 = new zzv(obj8, obj9, obj10);
                            objArrCopyOf[i16 == true ? 1 : 0] = obj9;
                            zzvVar3 = zzvVar5;
                            break;
                        }
                        iZza2 = i15 + 1;
                    }
                }
                if (i11 != i2) {
                    c = 2;
                    r6 = new Object[]{sArr, Integer.valueOf(i11), zzvVar3};
                    r3 = r6;
                }
                r2 = sArr;
                c = 2;
                r3 = r2;
            } else {
                sArr = new int[iHighestOneBit];
                Arrays.fill((int[]) sArr, -1);
                int i17 = 0;
                int i18 = 0;
                while (i17 < i2) {
                    int i19 = i18 + i18;
                    int i20 = i17 + i17;
                    Object obj11 = objArrCopyOf[i20];
                    obj11.getClass();
                    Object obj12 = objArrCopyOf[i20 ^ 1];
                    obj12.getClass();
                    zzp.zza(obj11, obj12);
                    int iZza3 = zzq.zza(obj11.hashCode());
                    while (true) {
                        int i21 = iZza3 & i3;
                        ?? r15 = sArr[i21];
                        if (r15 == b) {
                            sArr[i21] = i19;
                            if (i18 < i17) {
                                objArrCopyOf[i19] = obj11;
                                objArrCopyOf[i19 ^ 1] = obj12;
                            }
                            i18++;
                            break;
                        }
                        if (obj11.equals(objArrCopyOf[r15])) {
                            int i22 = r15 ^ 1;
                            Object obj13 = objArrCopyOf[i22 == true ? 1 : 0];
                            obj13.getClass();
                            zzv zzvVar6 = new zzv(obj11, obj12, obj13);
                            objArrCopyOf[i22 == true ? 1 : 0] = obj12;
                            zzvVar = zzvVar6;
                            break;
                        }
                        iZza3 = i21 + 1;
                        b = -1;
                    }
                    i17++;
                    b = -1;
                }
                if (i18 != i2) {
                    c = 2;
                    r6 = new Object[]{sArr, Integer.valueOf(i18), zzvVar};
                    r3 = r6;
                }
                r2 = sArr;
                c = 2;
                r3 = r2;
            }
        }
        boolean z = r3 instanceof Object[];
        ?? r4 = r3;
        if (z) {
            Object[] objArr2 = (Object[]) r3;
            zzwVar.zzc = (zzv) objArr2[c];
            Object obj14 = objArr2[0];
            int iIntValue = ((Integer) objArr2[1]).intValue();
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue + iIntValue);
            r4 = obj14;
            i2 = iIntValue;
        }
        return new zzaf(r4, objArrCopyOf, i2);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0009 A[EDGE_INSN: B:43:0x0009->B:4:0x0009 BREAK  A[LOOP:0: B:15:0x0038->B:21:0x004e], EDGE_INSN: B:45:0x0009->B:4:0x0009 BREAK  A[LOOP:1: B:25:0x0063->B:31:0x007a], EDGE_INSN: B:47:0x0009->B:4:0x0009 BREAK  A[LOOP:2: B:33:0x0089->B:42:0x00a0]] */
    @Override // com.google.android.gms.internal.play_billing.zzx, java.util.Map
    @CheckForNull
    public final Object get(@CheckForNull Object obj) {
        Object obj2;
        Object obj3 = this.zzc;
        Object[] objArr = this.zzb;
        int i = this.zzd;
        if (obj == null) {
            obj2 = null;
        } else if (i == 1) {
            Object obj4 = objArr[0];
            obj4.getClass();
            if (obj4.equals(obj)) {
                obj2 = objArr[1];
                obj2.getClass();
            } else {
                obj2 = null;
            }
        } else if (obj3 == null) {
            obj2 = null;
        } else if (obj3 instanceof byte[]) {
            byte[] bArr = (byte[]) obj3;
            int length = bArr.length - 1;
            int iZza = zzq.zza(obj.hashCode());
            while (true) {
                int i2 = iZza & length;
                int i3 = bArr[i2] & 255;
                if (i3 == 255) {
                    break;
                }
                if (obj.equals(objArr[i3])) {
                    obj2 = objArr[i3 ^ 1];
                } else {
                    iZza = i2 + 1;
                }
            }
            obj2 = null;
        } else if (obj3 instanceof short[]) {
            short[] sArr = (short[]) obj3;
            int length2 = sArr.length - 1;
            int iZza2 = zzq.zza(obj.hashCode());
            while (true) {
                int i4 = iZza2 & length2;
                char c = (char) sArr[i4];
                if (c == 65535) {
                    break;
                }
                if (obj.equals(objArr[c])) {
                    obj2 = objArr[c ^ 1];
                } else {
                    iZza2 = i4 + 1;
                }
            }
            obj2 = null;
        } else {
            int[] iArr = (int[]) obj3;
            int length3 = iArr.length - 1;
            int iZza3 = zzq.zza(obj.hashCode());
            while (true) {
                int i5 = iZza3 & length3;
                int i6 = iArr[i5];
                if (i6 == -1) {
                    break;
                }
                if (obj.equals(objArr[i6])) {
                    obj2 = objArr[i6 ^ 1];
                } else {
                    iZza3 = i5 + 1;
                }
            }
            obj2 = null;
        }
        if (obj2 == null) {
            return null;
        }
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.play_billing.zzx
    final zzr zza() {
        return new zzae(this.zzb, 1, this.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzx
    final zzy zzc() {
        return new zzac(this, this.zzb, 0, this.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzx
    final zzy zzd() {
        return new zzad(this, new zzae(this.zzb, 0, this.zzd));
    }
}
