package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzyg extends zzyl implements zzmg {
    public static final /* synthetic */ int zzb = 0;
    private static final zzgbj zzc = zzgbj.zzb(new Comparator() { // from class: com.google.android.gms.internal.ads.zzxc
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            Integer num = (Integer) obj;
            Integer num2 = (Integer) obj2;
            int i = zzyg.zzb;
            if (num.intValue() == -1) {
                return num2.intValue() == -1 ? 0 : -1;
            }
            if (num2.intValue() == -1) {
                return 1;
            }
            return num.intValue() - num2.intValue();
        }
    });
    private static final zzgbj zzd = zzgbj.zzb(new Comparator() { // from class: com.google.android.gms.internal.ads.zzxe
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int i = zzyg.zzb;
            return 0;
        }
    });
    public final Context zza;
    private final Object zze;
    private final boolean zzf;
    private zzxu zzg;
    private zzxz zzh;
    private zzk zzi;
    private final zzwy zzj;

    public zzyg(Context context) {
        zzwy zzwyVar = new zzwy();
        zzxu zzxuVarZzd = zzxu.zzd(context);
        this.zze = new Object();
        this.zza = context != null ? context.getApplicationContext() : null;
        this.zzj = zzwyVar;
        this.zzg = zzxuVarZzd;
        this.zzi = zzk.zza;
        boolean z = false;
        if (context != null && zzfy.zzJ(context)) {
            z = true;
        }
        this.zzf = z;
        if (!z && context != null && zzfy.zza >= 32) {
            this.zzh = zzxz.zza(context);
        }
        if (this.zzg.zzS && context == null) {
            zzff.zzf("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    static /* bridge */ /* synthetic */ int zza(int i, int i2) {
        if (i == 0 || i != i2) {
            return Integer.bitCount(i & i2);
        }
        return Integer.MAX_VALUE;
    }

    protected static int zzb(zzam zzamVar, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(zzamVar.zzd)) {
            return 4;
        }
        String strZzh = zzh(str);
        String strZzh2 = zzh(zzamVar.zzd);
        if (strZzh2 == null || strZzh == null) {
            return (z && strZzh2 == null) ? 1 : 0;
        }
        if (strZzh2.startsWith(strZzh) || strZzh.startsWith(strZzh2)) {
            return 3;
        }
        int i = zzfy.zza;
        return strZzh2.split("-", 2)[0].equals(strZzh.split("-", 2)[0]) ? 2 : 0;
    }

    protected static String zzh(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x004c  */
    public static /* synthetic */ boolean zzm(zzyg zzygVar, zzam zzamVar) {
        boolean z;
        byte b;
        zzxz zzxzVar;
        zzxz zzxzVar2;
        synchronized (zzygVar.zze) {
            z = true;
            if (zzygVar.zzg.zzS && !zzygVar.zzf && zzamVar.zzz > 2) {
                String str = zzamVar.zzm;
                if (str != null) {
                    switch (str) {
                        case "audio/eac3-joc":
                            b = 2;
                            break;
                        case "audio/ac3":
                            b = 0;
                            break;
                        case "audio/ac4":
                            b = 3;
                            break;
                        case "audio/eac3":
                            b = 1;
                            break;
                        default:
                            b = -1;
                            break;
                    }
                    if ((b != 0 && b != 1 && b != 2 && b != 3) || (zzfy.zza >= 32 && (zzxzVar = zzygVar.zzh) != null && zzxzVar.zzg())) {
                    }
                }
                if (zzfy.zza < 32 || (zzxzVar2 = zzygVar.zzh) == null || !zzxzVar2.zzg() || !zzxzVar2.zze() || !zzygVar.zzh.zzf() || !zzygVar.zzh.zzd(zzygVar.zzi, zzamVar)) {
                    z = false;
                }
            }
        }
        return z;
    }

    protected static boolean zzo(int i, boolean z) {
        int i2 = i & 7;
        if (i2 != 4) {
            return z && i2 == 3;
        }
        return true;
    }

    private static void zzu(zzws zzwsVar, zzdg zzdgVar, Map map) {
        for (int i = 0; i < zzwsVar.zzc; i++) {
            if (((zzdb) zzdgVar.zzD.get(zzwsVar.zzb(i))) != null) {
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzv() {
        boolean z;
        zzxz zzxzVar;
        synchronized (this.zze) {
            z = false;
            if (this.zzg.zzS && !this.zzf && zzfy.zza >= 32 && (zzxzVar = this.zzh) != null && zzxzVar.zzg()) {
                z = true;
            }
        }
        if (z) {
            zzt();
        }
    }

    private static final Pair zzw(int i, zzyk zzykVar, int[][][] iArr, zzyb zzybVar, Comparator comparator) {
        int i2;
        List arrayList;
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < 2; i3++) {
            if (i == zzykVar.zzc(i3)) {
                zzws zzwsVarZzd = zzykVar.zzd(i3);
                for (int i4 = 0; i4 < zzwsVarZzd.zzc; i4++) {
                    zzcz zzczVarZzb = zzwsVarZzd.zzb(i4);
                    List listZza = zzybVar.zza(i3, zzczVarZzb, iArr[i3][i4]);
                    int i5 = zzczVarZzb.zzb;
                    int i6 = 1;
                    boolean[] zArr = new boolean[1];
                    int i7 = 0;
                    while (true) {
                        int i8 = zzczVarZzb.zzb;
                        if (i7 <= 0) {
                            int i9 = i7 + 1;
                            zzyc zzycVar = (zzyc) listZza.get(i7);
                            int iZzb = zzycVar.zzb();
                            if (zArr[i7] || iZzb == 0) {
                                i2 = i6;
                            } else {
                                if (iZzb == i6) {
                                    arrayList = zzgaa.zzm(zzycVar);
                                    i2 = i6;
                                } else {
                                    arrayList = new ArrayList();
                                    arrayList.add(zzycVar);
                                    int i10 = i9;
                                    while (true) {
                                        int i11 = zzczVarZzb.zzb;
                                        if (i10 > 0) {
                                            break;
                                        }
                                        zzyc zzycVar2 = (zzyc) listZza.get(i10);
                                        if (zzycVar2.zzb() == 2 && zzycVar.zzc(zzycVar2)) {
                                            arrayList.add(zzycVar2);
                                            zArr[i10] = true;
                                        }
                                        i10++;
                                    }
                                    i2 = 1;
                                }
                                arrayList2.add(arrayList);
                            }
                            i6 = i2;
                            i7 = i9;
                        }
                    }
                }
            }
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList2, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i12 = 0; i12 < list.size(); i12++) {
            iArr2[i12] = ((zzyc) list.get(i12)).zzc;
        }
        zzyc zzycVar3 = (zzyc) list.get(0);
        return Pair.create(new zzyh(zzycVar3.zzb, iArr2, 0), Integer.valueOf(zzycVar3.zza));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzyl
    protected final Pair zzc(zzyk zzykVar, int[][][] iArr, final int[] iArr2, zzur zzurVar, zzcx zzcxVar) throws zziz {
        final zzxu zzxuVar;
        Pair pairZzw;
        int i;
        final boolean z;
        int[] iArr3;
        int length;
        zzxz zzxzVar;
        synchronized (this.zze) {
            zzxuVar = this.zzg;
            if (zzxuVar.zzS && zzfy.zza >= 32 && (zzxzVar = this.zzh) != null) {
                Looper looperMyLooper = Looper.myLooper();
                zzek.zzb(looperMyLooper);
                zzxzVar.zzb(this, looperMyLooper);
            }
        }
        int i2 = 2;
        zzyh[] zzyhVarArr = new zzyh[2];
        zzde zzdeVar = zzxuVar.zzv;
        Pair pairZzw2 = zzw(2, zzykVar, iArr, new zzyb() { // from class: com.google.android.gms.internal.ads.zzxk
            /* JADX WARN: Code duplicated, block: B:22:0x0040  */
            @Override // com.google.android.gms.internal.ads.zzyb
            public final List zza(int i3, zzcz zzczVar, int[] iArr4) {
                int i4;
                int i5;
                int i6;
                Point point;
                int i7 = zzyg.zzb;
                zzxu zzxuVar2 = zzxuVar;
                int i8 = iArr2[i3];
                int i9 = zzxuVar2.zzl;
                int i10 = zzxuVar2.zzm;
                boolean z2 = zzxuVar2.zzn;
                int i11 = -1;
                int i12 = 0;
                int i13 = Integer.MAX_VALUE;
                if (i9 == Integer.MAX_VALUE) {
                    i13 = Integer.MAX_VALUE;
                } else if (i10 != Integer.MAX_VALUE) {
                    char c = 0;
                    int i14 = Integer.MAX_VALUE;
                    while (true) {
                        int i15 = zzczVar.zzb;
                        if (c > 0) {
                            break;
                        }
                        zzam zzamVarZzb = zzczVar.zzb(i12);
                        int i16 = zzamVarZzb.zzr;
                        if (i16 > 0 && (i4 = zzamVarZzb.zzs) > 0) {
                            if (z2) {
                                if ((i16 <= i4 ? i12 : 1) != (i9 <= i10 ? i12 : 1)) {
                                    i6 = i9;
                                    i5 = i10;
                                } else {
                                    i5 = i9;
                                    i6 = i10;
                                }
                            } else {
                                i5 = i9;
                                i6 = i10;
                            }
                            int i17 = i16 * i6;
                            int i18 = i4 * i5;
                            if (i17 >= i18) {
                                int i19 = zzfy.zza;
                                point = new Point(i5, ((i18 + i16) - 1) / i16);
                            } else {
                                int i20 = zzfy.zza;
                                point = new Point(((i17 + i4) - 1) / i4, i6);
                            }
                            int i21 = zzamVarZzb.zzr;
                            int i22 = zzamVarZzb.zzs * i21;
                            if (i21 >= ((int) (point.x * 0.98f)) && zzamVarZzb.zzs >= ((int) (point.y * 0.98f)) && i22 < i14) {
                                i14 = i22;
                            }
                        }
                        c = 1;
                        i12 = 0;
                    }
                    i13 = i14;
                }
                zzfzx zzfzxVar = new zzfzx();
                char c2 = 0;
                while (true) {
                    int i23 = zzczVar.zzb;
                    if (c2 > 0) {
                        return zzfzxVar.zzi();
                    }
                    int iZza = zzczVar.zzb(0).zza();
                    zzfzxVar.zzf(new zzyf(i3, zzczVar, 0, zzxuVar2, iArr4[0], i8, i13 == Integer.MAX_VALUE || (iZza != i11 && iZza <= i13)));
                    c2 = 1;
                    i11 = -1;
                }
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxl
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                List list = (List) obj;
                List list2 = (List) obj2;
                return zzfzp.zzk().zzd((zzyf) Collections.max(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zzyd
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzyf.zzd((zzyf) obj3, (zzyf) obj4);
                    }
                }), (zzyf) Collections.max(list2, new Comparator() { // from class: com.google.android.gms.internal.ads.zzyd
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzyf.zzd((zzyf) obj3, (zzyf) obj4);
                    }
                }), new Comparator() { // from class: com.google.android.gms.internal.ads.zzyd
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzyf.zzd((zzyf) obj3, (zzyf) obj4);
                    }
                }).zzb(list.size(), list2.size()).zzd((zzyf) Collections.max(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zzye
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzyf.zza((zzyf) obj3, (zzyf) obj4);
                    }
                }), (zzyf) Collections.max(list2, new Comparator() { // from class: com.google.android.gms.internal.ads.zzye
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzyf.zza((zzyf) obj3, (zzyf) obj4);
                    }
                }), new Comparator() { // from class: com.google.android.gms.internal.ads.zzye
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzyf.zza((zzyf) obj3, (zzyf) obj4);
                    }
                }).zza();
            }
        });
        boolean z2 = zzxuVar.zzA;
        int i3 = 4;
        if (pairZzw2 == null) {
            zzde zzdeVar2 = zzxuVar.zzv;
            pairZzw = zzw(4, zzykVar, iArr, new zzyb() { // from class: com.google.android.gms.internal.ads.zzxf
                @Override // com.google.android.gms.internal.ads.zzyb
                public final List zza(int i4, zzcz zzczVar, int[] iArr4) {
                    int i5 = zzyg.zzb;
                    zzfzx zzfzxVar = new zzfzx();
                    int i6 = 0;
                    while (true) {
                        int i7 = zzczVar.zzb;
                        if (i6 > 0) {
                            return zzfzxVar.zzi();
                        }
                        zzfzxVar.zzf(new zzxo(i4, zzczVar, i6, zzxuVar, iArr4[i6]));
                        i6++;
                    }
                }
            }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxg
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ((zzxo) ((List) obj).get(0)).zza((zzxo) ((List) obj2).get(0));
                }
            });
        } else {
            pairZzw = null;
        }
        if (pairZzw != null) {
            zzyhVarArr[((Integer) pairZzw.second).intValue()] = (zzyh) pairZzw.first;
        } else if (pairZzw2 != null) {
            zzyhVarArr[((Integer) pairZzw2.second).intValue()] = (zzyh) pairZzw2.first;
        }
        int i4 = 0;
        while (true) {
            i = 1;
            if (i4 >= 2) {
                z = false;
                break;
            }
            if (zzykVar.zzc(i4) == 2 && zzykVar.zzd(i4).zzc > 0) {
                z = true;
                break;
            }
            i4++;
        }
        Pair pairZzw3 = zzw(1, zzykVar, iArr, new zzyb() { // from class: com.google.android.gms.internal.ads.zzxi
            @Override // com.google.android.gms.internal.ads.zzyb
            public final List zza(int i5, zzcz zzczVar, int[] iArr4) {
                final zzyg zzygVar = this.zza;
                zzfxf zzfxfVar = new zzfxf() { // from class: com.google.android.gms.internal.ads.zzxh
                    @Override // com.google.android.gms.internal.ads.zzfxf
                    public final boolean zza(Object obj) {
                        return zzyg.zzm(zzygVar, (zzam) obj);
                    }
                };
                int i6 = iArr2[i5];
                zzfzx zzfzxVar = new zzfzx();
                int i7 = 0;
                while (true) {
                    int i8 = zzczVar.zzb;
                    if (i7 > 0) {
                        return zzfzxVar.zzi();
                    }
                    zzfzxVar.zzf(new zzxn(i5, zzczVar, i7, zzxuVar, iArr4[i7], z, zzfxfVar, i6));
                    i7++;
                }
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxj
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((zzxn) Collections.max((List) obj)).zza((zzxn) Collections.max((List) obj2));
            }
        });
        if (pairZzw3 != null) {
            zzyhVarArr[((Integer) pairZzw3.second).intValue()] = (zzyh) pairZzw3.first;
        }
        final String str = pairZzw3 == null ? null : ((zzyh) pairZzw3.first).zza.zzb(((zzyh) pairZzw3.first).zzb[0]).zzd;
        zzde zzdeVar3 = zzxuVar.zzv;
        int i5 = 3;
        Pair pairZzw4 = zzw(3, zzykVar, iArr, new zzyb() { // from class: com.google.android.gms.internal.ads.zzxm
            @Override // com.google.android.gms.internal.ads.zzyb
            public final List zza(int i6, zzcz zzczVar, int[] iArr4) {
                int i7 = zzyg.zzb;
                zzfzx zzfzxVar = new zzfzx();
                int i8 = 0;
                while (true) {
                    int i9 = zzczVar.zzb;
                    if (i8 > 0) {
                        return zzfzxVar.zzi();
                    }
                    int i10 = i8;
                    zzfzxVar.zzf(new zzya(i6, zzczVar, i10, zzxuVar, iArr4[i8], str));
                    i8++;
                }
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxd
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((zzya) ((List) obj).get(0)).zza((zzya) ((List) obj2).get(0));
            }
        });
        if (pairZzw4 != null) {
            zzyhVarArr[((Integer) pairZzw4.second).intValue()] = (zzyh) pairZzw4.first;
        }
        int i6 = 0;
        while (i6 < i2) {
            int iZzc = zzykVar.zzc(i6);
            if (iZzc != i2 && iZzc != i && iZzc != i5 && iZzc != i3) {
                zzws zzwsVarZzd = zzykVar.zzd(i6);
                int[][] iArr4 = iArr[i6];
                zzde zzdeVar4 = zzxuVar.zzv;
                int i7 = 0;
                zzcz zzczVar = null;
                zzxp zzxpVar = null;
                while (i7 < zzwsVarZzd.zzc) {
                    zzcz zzczVarZzb = zzwsVarZzd.zzb(i7);
                    int[] iArr5 = iArr4[i7];
                    zzxp zzxpVar2 = zzxpVar;
                    char c = 0;
                    while (true) {
                        int i8 = zzczVarZzb.zzb;
                        if (c <= 0) {
                            if (zzo(iArr5[0], zzxuVar.zzT)) {
                                zzxp zzxpVar3 = new zzxp(zzczVarZzb.zzb(0), iArr5[0]);
                                if (zzxpVar2 == null || zzxpVar3.compareTo(zzxpVar2) > 0) {
                                    zzczVar = zzczVarZzb;
                                    zzxpVar2 = zzxpVar3;
                                }
                            }
                            c = 1;
                        }
                    }
                    i7++;
                    zzxpVar = zzxpVar2;
                }
                zzyhVarArr[i6] = zzczVar == null ? null : new zzyh(zzczVar, new int[]{0}, 0);
            }
            i6++;
            i2 = 2;
            i3 = 4;
            i = 1;
            i5 = 3;
        }
        HashMap map = new HashMap();
        int i9 = 2;
        for (int i10 = 0; i10 < 2; i10++) {
            zzu(zzykVar.zzd(i10), zzxuVar, map);
        }
        zzu(zzykVar.zze(), zzxuVar, map);
        for (int i11 = 0; i11 < 2; i11++) {
            if (((zzdb) map.get(Integer.valueOf(zzykVar.zzc(i11)))) != null) {
                throw null;
            }
        }
        int i12 = 0;
        while (i12 < i9) {
            zzws zzwsVarZzd2 = zzykVar.zzd(i12);
            if (zzxuVar.zzg(i12, zzwsVarZzd2)) {
                if (zzxuVar.zze(i12, zzwsVarZzd2) != null) {
                    throw null;
                }
                zzyhVarArr[i12] = null;
            }
            i12++;
            i9 = 2;
        }
        int i13 = 0;
        for (int i14 = i9; i13 < i14; i14 = 2) {
            int iZzc2 = zzykVar.zzc(i13);
            if (zzxuVar.zzf(i13) || zzxuVar.zzE.contains(Integer.valueOf(iZzc2))) {
                zzyhVarArr[i13] = null;
            }
            i13++;
        }
        zzwy zzwyVar = this.zzj;
        zzyw zzywVarZzr = zzr();
        zzgaa zzgaaVarZzf = zzwz.zzf(zzyhVarArr);
        int i15 = 2;
        zzyi[] zzyiVarArr = new zzyi[2];
        int i16 = 0;
        while (i16 < i15) {
            zzyh zzyhVar = zzyhVarArr[i16];
            if (zzyhVar != null && (length = (iArr3 = zzyhVar.zzb).length) != 0) {
                zzyiVarArr[i16] = length == 1 ? new zzyj(zzyhVar.zza, iArr3[0], 0, 0, null) : zzwyVar.zza(zzyhVar.zza, iArr3, 0, zzywVarZzr, (zzgaa) zzgaaVarZzf.get(i16));
            }
            i16++;
            i15 = 2;
        }
        zzmi[] zzmiVarArr = new zzmi[i15];
        for (int i17 = 0; i17 < i15; i17++) {
            zzmiVarArr[i17] = (zzxuVar.zzf(i17) || zzxuVar.zzE.contains(Integer.valueOf(zzykVar.zzc(i17))) || (zzykVar.zzc(i17) != -2 && zzyiVarArr[i17] == null)) ? null : zzmi.zza;
        }
        boolean z3 = zzxuVar.zzU;
        zzde zzdeVar5 = zzxuVar.zzv;
        return Pair.create(zzmiVarArr, zzyiVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final zzmg zzd() {
        return this;
    }

    public final zzxu zze() {
        zzxu zzxuVar;
        synchronized (this.zze) {
            zzxuVar = this.zzg;
        }
        return zzxuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final void zzj() {
        zzxz zzxzVar;
        synchronized (this.zze) {
            if (zzfy.zza >= 32 && (zzxzVar = this.zzh) != null) {
                zzxzVar.zzc();
            }
        }
        super.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final void zzk(zzk zzkVar) {
        boolean z;
        synchronized (this.zze) {
            z = !this.zzi.equals(zzkVar);
            this.zzi = zzkVar;
        }
        if (z) {
            zzv();
        }
    }

    public final void zzl(zzxs zzxsVar) {
        boolean z;
        zzxu zzxuVar = new zzxu(zzxsVar);
        synchronized (this.zze) {
            z = !this.zzg.equals(zzxuVar);
            this.zzg = zzxuVar;
        }
        if (z) {
            if (zzxuVar.zzS && this.zza == null) {
                zzff.zzf("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
            }
            zzt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final boolean zzn() {
        return true;
    }
}
