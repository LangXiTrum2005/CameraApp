package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzajc implements zzacu {

    @Deprecated
    public static final zzadb zza = new zzadb() { // from class: com.google.android.gms.internal.ads.zzaiy
        @Override // com.google.android.gms.internal.ads.zzadb
        public final /* synthetic */ zzacu[] zza(Uri uri, Map map) {
            int i = zzada.zza;
            zzadb zzadbVar = zzajc.zza;
            return new zzacu[]{new zzajc()};
        }
    };
    private static final byte[] zzb = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final zzam zzc;
    private int zzA;
    private int zzB;
    private int zzC;
    private boolean zzD;
    private zzacx zzE;
    private zzaea[] zzF;
    private zzaea[] zzG;
    private boolean zzH;
    private final zzakp zzd;
    private final List zze;
    private final SparseArray zzf;
    private final zzfp zzg;
    private final zzfp zzh;
    private final zzfp zzi;
    private final byte[] zzj;
    private final zzfp zzk;
    private final zzafu zzl;
    private final zzfp zzm;
    private final ArrayDeque zzn;
    private final ArrayDeque zzo;
    private int zzp;
    private int zzq;
    private long zzr;
    private int zzs;
    private zzfp zzt;
    private long zzu;
    private int zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private zzajb zzz;

    static {
        zzak zzakVar = new zzak();
        zzakVar.zzW("application/x-emsg");
        zzc = zzakVar.zzac();
    }

    @Deprecated
    public zzajc() {
        this(zzakp.zza, 32, null, null, zzgaa.zzl(), null);
    }

    private static int zza(int i) throws zzcc {
        if (i >= 0) {
            return i;
        }
        throw zzcc.zza("Unexpected negative value: " + i, null);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0031  */
    private static zzae zzf(List list) {
        zzaji zzajiVar;
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            zzain zzainVar = (zzain) list.get(i);
            if (zzainVar.zzd == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArrZzM = zzainVar.zza.zzM();
                zzfp zzfpVar = new zzfp(bArrZzM);
                if (zzfpVar.zze() < 32) {
                    zzajiVar = null;
                } else {
                    zzfpVar.zzK(0);
                    if (zzfpVar.zzg() == zzfpVar.zzb() + 4 && zzfpVar.zzg() == 1886614376) {
                        int iZze = zzaio.zze(zzfpVar.zzg());
                        if (iZze > 1) {
                            zzff.zzf("PsshAtomUtil", "Unsupported pssh version: " + iZze);
                        } else {
                            UUID uuid = new UUID(zzfpVar.zzt(), zzfpVar.zzt());
                            if (iZze == 1) {
                                zzfpVar.zzL(zzfpVar.zzp() * 16);
                            }
                            int iZzp = zzfpVar.zzp();
                            if (iZzp == zzfpVar.zzb()) {
                                byte[] bArr = new byte[iZzp];
                                zzfpVar.zzG(bArr, 0, iZzp);
                                zzajiVar = new zzaji(uuid, iZze, bArr);
                            }
                        }
                        zzajiVar = null;
                    } else {
                        zzajiVar = null;
                    }
                }
                UUID uuid2 = zzajiVar == null ? null : zzajiVar.zza;
                if (uuid2 == null) {
                    zzff.zzf("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new zzad(uuid2, null, "video/mp4", bArrZzM));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new zzae(arrayList);
    }

    private final void zzg() {
        this.zzp = 0;
        this.zzs = 0;
    }

    private static void zzh(zzfp zzfpVar, int i, zzajo zzajoVar) throws zzcc {
        zzfpVar.zzK(i + 8);
        int iZzg = zzfpVar.zzg();
        if ((iZzg & 1) != 0) {
            throw zzcc.zzc("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (iZzg & 2) != 0;
        int iZzp = zzfpVar.zzp();
        if (iZzp == 0) {
            Arrays.fill(zzajoVar.zzl, 0, zzajoVar.zze, false);
            return;
        }
        int i2 = zzajoVar.zze;
        if (iZzp != i2) {
            throw zzcc.zza("Senc sample count " + iZzp + " is different from fragment sample count" + i2, null);
        }
        Arrays.fill(zzajoVar.zzl, 0, iZzp, z);
        zzajoVar.zza(zzfpVar.zzb());
        zzfp zzfpVar2 = zzajoVar.zzn;
        zzfpVar.zzG(zzfpVar2.zzM(), 0, zzfpVar2.zze());
        zzajoVar.zzn.zzK(0);
        zzajoVar.zzo = false;
    }

    /* JADX WARN: Code duplicated, block: B:122:0x0338 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:123:0x033a  */
    /* JADX WARN: Code duplicated, block: B:124:0x0343  */
    /* JADX WARN: Code duplicated, block: B:127:0x034c  */
    /* JADX WARN: Code duplicated, block: B:128:0x0355  */
    /* JADX WARN: Code duplicated, block: B:131:0x035e  */
    /* JADX WARN: Code duplicated, block: B:132:0x0367  */
    /* JADX WARN: Code duplicated, block: B:134:0x036b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:135:0x036d  */
    /* JADX WARN: Code duplicated, block: B:136:0x0371  */
    /* JADX WARN: Code duplicated, block: B:137:0x0372 A[PHI: r12
  0x0372: PHI (r12v12 int) = (r12v10 int), (r12v13 int) binds: [B:133:0x0369, B:136:0x0371] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:139:0x0376  */
    /* JADX WARN: Code duplicated, block: B:140:0x0381  */
    /* JADX WARN: Code duplicated, block: B:143:0x039d  */
    /* JADX WARN: Code duplicated, block: B:146:0x03af  */
    /* JADX WARN: Code duplicated, block: B:147:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:255:0x0623  */
    private final void zzi(long j) throws zzcc {
        zzajc zzajcVar;
        SparseArray sparseArray;
        zzaim zzaimVar;
        int i;
        int i2;
        int i3;
        byte[] bArr;
        int i4;
        byte[] bArr2;
        byte[] bArr3;
        int i5;
        boolean z;
        zzajo zzajoVar;
        int i6;
        zzaim zzaimVar2;
        int i7;
        boolean z2;
        long j2;
        int[] iArr;
        long[] jArr;
        boolean[] zArr;
        int i8;
        long j3;
        long j4;
        int iZzg;
        int iZzg2;
        int i9;
        int iZzg3;
        int iZzg4;
        long jZzs;
        boolean z3;
        long[] jArr2;
        final zzajc zzajcVar2 = this;
        while (!zzajcVar2.zzn.isEmpty() && ((zzaim) zzajcVar2.zzn.peek()).zza == j) {
            zzaim zzaimVar3 = (zzaim) zzajcVar2.zzn.pop();
            int i10 = zzaimVar3.zzd;
            int i11 = 12;
            int i12 = 8;
            if (i10 == 1836019574) {
                zzae zzaeVarZzf = zzf(zzaimVar3.zzb);
                zzaim zzaimVarZza = zzaimVar3.zza(1836475768);
                zzaimVarZza.getClass();
                SparseArray sparseArray2 = new SparseArray();
                int size = zzaimVarZza.zzb.size();
                long jZzu = -9223372036854775807L;
                int i13 = 0;
                while (i13 < size) {
                    zzain zzainVar = (zzain) zzaimVarZza.zzb.get(i13);
                    int i14 = zzainVar.zzd;
                    if (i14 == 1953654136) {
                        zzfp zzfpVar = zzainVar.zza;
                        zzfpVar.zzK(i11);
                        Pair pairCreate = Pair.create(Integer.valueOf(zzfpVar.zzg()), new zzaix(zzfpVar.zzg() - 1, zzfpVar.zzg(), zzfpVar.zzg(), zzfpVar.zzg()));
                        sparseArray2.put(((Integer) pairCreate.first).intValue(), (zzaix) pairCreate.second);
                    } else if (i14 == 1835362404) {
                        zzfp zzfpVar2 = zzainVar.zza;
                        zzfpVar2.zzK(8);
                        jZzu = zzaio.zze(zzfpVar2.zzg()) == 0 ? zzfpVar2.zzu() : zzfpVar2.zzv();
                    }
                    i13++;
                    i11 = 12;
                }
                List listZzd = zzaiw.zzd(zzaimVar3, new zzadk(), jZzu, zzaeVarZzf, false, false, new zzfws() { // from class: com.google.android.gms.internal.ads.zzaiz
                    @Override // com.google.android.gms.internal.ads.zzfws
                    public final Object apply(Object obj) {
                        return (zzajm) obj;
                    }
                });
                int size2 = listZzd.size();
                if (zzajcVar2.zzf.size() == 0) {
                    for (int i15 = 0; i15 < size2; i15++) {
                        zzajp zzajpVar = (zzajp) listZzd.get(i15);
                        zzajm zzajmVar = zzajpVar.zza;
                        zzajcVar2.zzf.put(zzajmVar.zza, new zzajb(zzajcVar2.zzE.zzw(i15, zzajmVar.zzb), zzajpVar, zzj(sparseArray2, zzajmVar.zza)));
                        zzajcVar2.zzx = Math.max(zzajcVar2.zzx, zzajmVar.zze);
                    }
                    zzajcVar2.zzE.zzD();
                } else {
                    zzek.zzf(zzajcVar2.zzf.size() == size2);
                    for (int i16 = 0; i16 < size2; i16++) {
                        zzajp zzajpVar2 = (zzajp) listZzd.get(i16);
                        zzajm zzajmVar2 = zzajpVar2.zza;
                        ((zzajb) zzajcVar2.zzf.get(zzajmVar2.zza)).zzh(zzajpVar2, zzj(sparseArray2, zzajmVar2.zza));
                    }
                }
            } else {
                if (i10 == 1836019558) {
                    SparseArray sparseArray3 = zzajcVar2.zzf;
                    byte[] bArr4 = zzajcVar2.zzj;
                    int size3 = zzaimVar3.zzc.size();
                    int i17 = 0;
                    while (i17 < size3) {
                        zzaim zzaimVar4 = (zzaim) zzaimVar3.zzc.get(i17);
                        if (zzaimVar4.zzd == 1953653094) {
                            zzain zzainVarZzb = zzaimVar4.zzb(1952868452);
                            zzainVarZzb.getClass();
                            zzfp zzfpVar3 = zzainVarZzb.zza;
                            zzfpVar3.zzK(i12);
                            int iZzg5 = zzfpVar3.zzg();
                            zzajb zzajbVar = (zzajb) sparseArray3.get(zzfpVar3.zzg());
                            if (zzajbVar == null) {
                                zzajbVar = null;
                            } else {
                                if ((iZzg5 & 1) != 0) {
                                    long jZzv = zzfpVar3.zzv();
                                    zzajo zzajoVar2 = zzajbVar.zzb;
                                    zzajoVar2.zzb = jZzv;
                                    zzajoVar2.zzc = jZzv;
                                }
                                zzaix zzaixVar = zzajbVar.zze;
                                zzajbVar.zzb.zza = new zzaix((iZzg5 & 2) != 0 ? zzfpVar3.zzg() - 1 : zzaixVar.zza, (iZzg5 & 8) != 0 ? zzfpVar3.zzg() : zzaixVar.zzb, (iZzg5 & 16) != 0 ? zzfpVar3.zzg() : zzaixVar.zzc, (iZzg5 & 32) != 0 ? zzfpVar3.zzg() : zzaixVar.zzd);
                            }
                            if (zzajbVar == null) {
                                sparseArray = sparseArray3;
                                zzaimVar = zzaimVar3;
                                i = size3;
                                i2 = i12;
                                i3 = i17;
                                bArr = bArr4;
                            } else {
                                zzajo zzajoVar3 = zzajbVar.zzb;
                                long j5 = zzajoVar3.zzp;
                                boolean z4 = zzajoVar3.zzq;
                                zzajbVar.zzi();
                                zzajbVar.zzl = true;
                                zzain zzainVarZzb2 = zzaimVar4.zzb(1952867444);
                                if (zzainVarZzb2 != null) {
                                    zzfp zzfpVar4 = zzainVarZzb2.zza;
                                    zzfpVar4.zzK(i12);
                                    zzajoVar3.zzp = zzaio.zze(zzfpVar4.zzg()) == 1 ? zzfpVar4.zzv() : zzfpVar4.zzu();
                                    zzajoVar3.zzq = true;
                                } else {
                                    zzajoVar3.zzp = j5;
                                    zzajoVar3.zzq = z4;
                                }
                                List list = zzaimVar4.zzb;
                                int size4 = list.size();
                                int i18 = 0;
                                int i19 = 0;
                                int i20 = 0;
                                while (true) {
                                    i4 = 1953658222;
                                    if (i18 >= size4) {
                                        break;
                                    }
                                    zzain zzainVar2 = (zzain) list.get(i18);
                                    SparseArray sparseArray4 = sparseArray3;
                                    if (zzainVar2.zzd == 1953658222) {
                                        zzfp zzfpVar5 = zzainVar2.zza;
                                        zzfpVar5.zzK(12);
                                        int iZzp = zzfpVar5.zzp();
                                        if (iZzp > 0) {
                                            i20 += iZzp;
                                            i19++;
                                        }
                                    }
                                    i18++;
                                    sparseArray3 = sparseArray4;
                                }
                                sparseArray = sparseArray3;
                                zzajbVar.zzh = 0;
                                zzajbVar.zzg = 0;
                                zzajbVar.zzf = 0;
                                zzajo zzajoVar4 = zzajbVar.zzb;
                                zzajoVar4.zzd = i19;
                                zzajoVar4.zze = i20;
                                if (zzajoVar4.zzg.length < i19) {
                                    zzajoVar4.zzf = new long[i19];
                                    zzajoVar4.zzg = new int[i19];
                                }
                                if (zzajoVar4.zzh.length < i20) {
                                    int i21 = (i20 * 125) / 100;
                                    zzajoVar4.zzh = new int[i21];
                                    zzajoVar4.zzi = new long[i21];
                                    zzajoVar4.zzj = new boolean[i21];
                                    zzajoVar4.zzl = new boolean[i21];
                                }
                                int i22 = 0;
                                int i23 = 0;
                                int i24 = 0;
                                while (i22 < size4) {
                                    zzain zzainVar3 = (zzain) list.get(i22);
                                    if (zzainVar3.zzd == i4) {
                                        int i25 = i23 + 1;
                                        zzfp zzfpVar6 = zzainVar3.zza;
                                        zzfpVar6.zzK(8);
                                        int iZzg6 = zzfpVar6.zzg();
                                        zzajm zzajmVar3 = zzajbVar.zzd.zza;
                                        zzajo zzajoVar5 = zzajbVar.zzb;
                                        zzaix zzaixVar2 = zzajoVar5.zza;
                                        int i26 = zzfy.zza;
                                        zzajoVar5.zzg[i23] = zzfpVar6.zzp();
                                        long[] jArr3 = zzajoVar5.zzf;
                                        long j6 = zzajoVar5.zzb;
                                        jArr3[i23] = j6;
                                        if ((iZzg6 & 1) != 0) {
                                            jArr3[i23] = j6 + ((long) zzfpVar6.zzg());
                                        }
                                        boolean z5 = (iZzg6 & 4) != 0;
                                        int iZzg7 = zzaixVar2.zzd;
                                        if (z5) {
                                            iZzg7 = zzfpVar6.zzg();
                                        }
                                        int i27 = iZzg6 & 256;
                                        int i28 = iZzg6 & 512;
                                        int i29 = iZzg6 & 1024;
                                        int i30 = iZzg6 & 2048;
                                        int i31 = iZzg7;
                                        long[] jArr4 = zzajmVar3.zzh;
                                        if (jArr4 != null) {
                                            i6 = i17;
                                            zzaimVar2 = zzaimVar4;
                                            if (jArr4.length != 1 || (jArr2 = zzajmVar3.zzi) == null) {
                                                z2 = z5;
                                                i7 = i30;
                                            } else {
                                                long j7 = jArr4[0];
                                                if (j7 == 0) {
                                                    z2 = z5;
                                                    i7 = i30;
                                                } else {
                                                    long jZzs2 = zzfy.zzs(j7 + jArr2[0], 1000000L, zzajmVar3.zzd, RoundingMode.FLOOR);
                                                    z2 = z5;
                                                    i7 = i30;
                                                    if (jZzs2 < zzajmVar3.zze) {
                                                    }
                                                    iArr = zzajoVar5.zzh;
                                                    jArr = zzajoVar5.zzi;
                                                    zArr = zzajoVar5.zzj;
                                                    i8 = zzajoVar5.zzg[i23] + i24;
                                                    zzajo zzajoVar6 = zzajoVar3;
                                                    j3 = zzajmVar3.zzc;
                                                    zzajoVar = zzajoVar6;
                                                    j4 = zzajoVar5.zzp;
                                                    while (i24 < i8) {
                                                        if (i27 != 0) {
                                                            iZzg = zzfpVar6.zzg();
                                                        } else {
                                                            iZzg = zzaixVar2.zzb;
                                                        }
                                                        zza(iZzg);
                                                        if (i28 != 0) {
                                                            iZzg2 = zzfpVar6.zzg();
                                                        } else {
                                                            iZzg2 = zzaixVar2.zzc;
                                                        }
                                                        zza(iZzg2);
                                                        if (i29 != 0) {
                                                            i9 = i8;
                                                            iZzg3 = zzfpVar6.zzg();
                                                        } else {
                                                            i9 = i8;
                                                            if (i24 != 0) {
                                                                iZzg3 = zzaixVar2.zzd;
                                                            } else if (z2) {
                                                                iZzg3 = i31;
                                                                i24 = 0;
                                                            } else {
                                                                i24 = 0;
                                                                iZzg3 = zzaixVar2.zzd;
                                                            }
                                                        }
                                                        if (i7 != 0) {
                                                            iZzg4 = zzfpVar6.zzg();
                                                        } else {
                                                            iZzg4 = 0;
                                                        }
                                                        jZzs = zzfy.zzs((((long) iZzg4) + j4) - j2, 1000000L, j3, RoundingMode.FLOOR);
                                                        jArr[i24] = jZzs;
                                                        long j8 = j3;
                                                        if (!zzajoVar5.zzq) {
                                                            jArr[i24] = jZzs + zzajbVar.zzd.zzh;
                                                        }
                                                        iArr[i24] = iZzg2;
                                                        if (1 != (((iZzg3 >> 16) & 1) ^ 1)) {
                                                            z3 = false;
                                                        } else {
                                                            z3 = true;
                                                        }
                                                        zArr[i24] = z3;
                                                        j4 += (long) iZzg;
                                                        i24++;
                                                        j3 = j8;
                                                        i27 = i27;
                                                        i28 = i28;
                                                        i8 = i9;
                                                        z2 = z2;
                                                        zzaixVar2 = zzaixVar2;
                                                    }
                                                    int i32 = i8;
                                                    zzajoVar5.zzp = j4;
                                                    i23 = i25;
                                                    i24 = i32;
                                                }
                                                j2 = zzajmVar3.zzi[0];
                                                iArr = zzajoVar5.zzh;
                                                jArr = zzajoVar5.zzi;
                                                zArr = zzajoVar5.zzj;
                                                i8 = zzajoVar5.zzg[i23] + i24;
                                                zzajo zzajoVar7 = zzajoVar3;
                                                j3 = zzajmVar3.zzc;
                                                zzajoVar = zzajoVar7;
                                                j4 = zzajoVar5.zzp;
                                                while (i24 < i8) {
                                                    if (i27 != 0) {
                                                        iZzg = zzfpVar6.zzg();
                                                    } else {
                                                        iZzg = zzaixVar2.zzb;
                                                    }
                                                    zza(iZzg);
                                                    if (i28 != 0) {
                                                        iZzg2 = zzfpVar6.zzg();
                                                    } else {
                                                        iZzg2 = zzaixVar2.zzc;
                                                    }
                                                    zza(iZzg2);
                                                    if (i29 != 0) {
                                                        i9 = i8;
                                                        iZzg3 = zzfpVar6.zzg();
                                                    } else {
                                                        i9 = i8;
                                                        if (i24 != 0) {
                                                            iZzg3 = zzaixVar2.zzd;
                                                        } else if (z2) {
                                                            iZzg3 = i31;
                                                            i24 = 0;
                                                        } else {
                                                            i24 = 0;
                                                            iZzg3 = zzaixVar2.zzd;
                                                        }
                                                    }
                                                    if (i7 != 0) {
                                                        iZzg4 = zzfpVar6.zzg();
                                                    } else {
                                                        iZzg4 = 0;
                                                    }
                                                    jZzs = zzfy.zzs((((long) iZzg4) + j4) - j2, 1000000L, j3, RoundingMode.FLOOR);
                                                    jArr[i24] = jZzs;
                                                    long j9 = j3;
                                                    if (!zzajoVar5.zzq) {
                                                        jArr[i24] = jZzs + zzajbVar.zzd.zzh;
                                                    }
                                                    iArr[i24] = iZzg2;
                                                    if (1 != (((iZzg3 >> 16) & 1) ^ 1)) {
                                                        z3 = false;
                                                    } else {
                                                        z3 = true;
                                                    }
                                                    zArr[i24] = z3;
                                                    j4 += (long) iZzg;
                                                    i24++;
                                                    j3 = j9;
                                                    i27 = i27;
                                                    i28 = i28;
                                                    i8 = i9;
                                                    z2 = z2;
                                                    zzaixVar2 = zzaixVar2;
                                                }
                                                int i33 = i8;
                                                zzajoVar5.zzp = j4;
                                                i23 = i25;
                                                i24 = i33;
                                            }
                                        } else {
                                            i6 = i17;
                                            i7 = i30;
                                            zzaimVar2 = zzaimVar4;
                                            z2 = z5;
                                        }
                                        j2 = 0;
                                        iArr = zzajoVar5.zzh;
                                        jArr = zzajoVar5.zzi;
                                        zArr = zzajoVar5.zzj;
                                        i8 = zzajoVar5.zzg[i23] + i24;
                                        zzajo zzajoVar8 = zzajoVar3;
                                        j3 = zzajmVar3.zzc;
                                        zzajoVar = zzajoVar8;
                                        j4 = zzajoVar5.zzp;
                                        while (i24 < i8) {
                                            if (i27 != 0) {
                                                iZzg = zzfpVar6.zzg();
                                            } else {
                                                iZzg = zzaixVar2.zzb;
                                            }
                                            zza(iZzg);
                                            if (i28 != 0) {
                                                iZzg2 = zzfpVar6.zzg();
                                            } else {
                                                iZzg2 = zzaixVar2.zzc;
                                            }
                                            zza(iZzg2);
                                            if (i29 != 0) {
                                                i9 = i8;
                                                iZzg3 = zzfpVar6.zzg();
                                            } else {
                                                i9 = i8;
                                                if (i24 != 0) {
                                                    iZzg3 = zzaixVar2.zzd;
                                                } else if (z2) {
                                                    iZzg3 = i31;
                                                    i24 = 0;
                                                } else {
                                                    i24 = 0;
                                                    iZzg3 = zzaixVar2.zzd;
                                                }
                                            }
                                            if (i7 != 0) {
                                                iZzg4 = zzfpVar6.zzg();
                                            } else {
                                                iZzg4 = 0;
                                            }
                                            jZzs = zzfy.zzs((((long) iZzg4) + j4) - j2, 1000000L, j3, RoundingMode.FLOOR);
                                            jArr[i24] = jZzs;
                                            long j10 = j3;
                                            if (!zzajoVar5.zzq) {
                                                jArr[i24] = jZzs + zzajbVar.zzd.zzh;
                                            }
                                            iArr[i24] = iZzg2;
                                            if (1 != (((iZzg3 >> 16) & 1) ^ 1)) {
                                                z3 = false;
                                            } else {
                                                z3 = true;
                                            }
                                            zArr[i24] = z3;
                                            j4 += (long) iZzg;
                                            i24++;
                                            j3 = j10;
                                            i27 = i27;
                                            i28 = i28;
                                            i8 = i9;
                                            z2 = z2;
                                            zzaixVar2 = zzaixVar2;
                                        }
                                        int i34 = i8;
                                        zzajoVar5.zzp = j4;
                                        i23 = i25;
                                        i24 = i34;
                                    } else {
                                        i22 = i22;
                                        zzajoVar = zzajoVar3;
                                        i6 = i17;
                                        zzaimVar2 = zzaimVar4;
                                    }
                                    i22++;
                                    list = list;
                                    size3 = size3;
                                    size4 = size4;
                                    zzaimVar3 = zzaimVar3;
                                    bArr4 = bArr4;
                                    i17 = i6;
                                    zzaimVar4 = zzaimVar2;
                                    zzajoVar3 = zzajoVar;
                                    i4 = 1953658222;
                                }
                                zzaimVar = zzaimVar3;
                                byte[] bArr5 = bArr4;
                                zzajo zzajoVar9 = zzajoVar3;
                                i = size3;
                                i3 = i17;
                                zzaim zzaimVar5 = zzaimVar4;
                                zzajm zzajmVar4 = zzajbVar.zzd.zza;
                                zzaix zzaixVar3 = zzajoVar9.zza;
                                zzaixVar3.getClass();
                                zzajn zzajnVarZza = zzajmVar4.zza(zzaixVar3.zza);
                                zzain zzainVarZzb3 = zzaimVar5.zzb(1935763834);
                                if (zzainVarZzb3 != null) {
                                    zzajnVarZza.getClass();
                                    zzfp zzfpVar7 = zzainVarZzb3.zza;
                                    zzfpVar7.zzK(8);
                                    if ((zzfpVar7.zzg() & 1) == 1) {
                                        zzfpVar7.zzL(8);
                                    }
                                    int iZzm = zzfpVar7.zzm();
                                    int iZzp2 = zzfpVar7.zzp();
                                    int i35 = zzajoVar9.zze;
                                    if (iZzp2 > i35) {
                                        throw zzcc.zza("Saiz sample count " + iZzp2 + " is greater than fragment sample count" + i35, null);
                                    }
                                    int i36 = zzajnVarZza.zzd;
                                    if (iZzm == 0) {
                                        boolean[] zArr2 = zzajoVar9.zzl;
                                        i5 = 0;
                                        for (int i37 = 0; i37 < iZzp2; i37++) {
                                            int iZzm2 = zzfpVar7.zzm();
                                            i5 += iZzm2;
                                            zArr2[i37] = iZzm2 > i36;
                                        }
                                        z = false;
                                    } else {
                                        boolean z6 = iZzm > i36;
                                        i5 = iZzm * iZzp2;
                                        z = false;
                                        Arrays.fill(zzajoVar9.zzl, 0, iZzp2, z6);
                                    }
                                    Arrays.fill(zzajoVar9.zzl, iZzp2, zzajoVar9.zze, z);
                                    if (i5 > 0) {
                                        zzajoVar9.zza(i5);
                                    }
                                }
                                zzain zzainVarZzb4 = zzaimVar5.zzb(1935763823);
                                if (zzainVarZzb4 != null) {
                                    zzfp zzfpVar8 = zzainVarZzb4.zza;
                                    zzfpVar8.zzK(8);
                                    int iZzg8 = zzfpVar8.zzg();
                                    if ((iZzg8 & 1) == 1) {
                                        zzfpVar8.zzL(8);
                                    }
                                    int iZzp3 = zzfpVar8.zzp();
                                    if (iZzp3 != 1) {
                                        throw zzcc.zza("Unexpected saio entry count: " + iZzp3, null);
                                    }
                                    zzajoVar9.zzc += zzaio.zze(iZzg8) == 0 ? zzfpVar8.zzu() : zzfpVar8.zzv();
                                }
                                zzain zzainVarZzb5 = zzaimVar5.zzb(1936027235);
                                if (zzainVarZzb5 != null) {
                                    zzh(zzainVarZzb5.zza, 0, zzajoVar9);
                                }
                                String str = zzajnVarZza != null ? zzajnVarZza.zzb : null;
                                zzfp zzfpVar9 = null;
                                zzfp zzfpVar10 = null;
                                for (int i38 = 0; i38 < zzaimVar5.zzb.size(); i38++) {
                                    zzain zzainVar4 = (zzain) zzaimVar5.zzb.get(i38);
                                    zzfp zzfpVar11 = zzainVar4.zza;
                                    int i39 = zzainVar4.zzd;
                                    if (i39 == 1935828848) {
                                        zzfpVar11.zzK(12);
                                        if (zzfpVar11.zzg() == 1936025959) {
                                            zzfpVar9 = zzfpVar11;
                                        }
                                    } else if (i39 == 1936158820) {
                                        zzfpVar11.zzK(12);
                                        if (zzfpVar11.zzg() == 1936025959) {
                                            zzfpVar10 = zzfpVar11;
                                        }
                                    }
                                }
                                if (zzfpVar9 != null && zzfpVar10 != null) {
                                    zzfpVar9.zzK(8);
                                    int iZze = zzaio.zze(zzfpVar9.zzg());
                                    zzfpVar9.zzL(4);
                                    if (iZze == 1) {
                                        zzfpVar9.zzL(4);
                                    }
                                    if (zzfpVar9.zzg() != 1) {
                                        throw zzcc.zzc("Entry count in sbgp != 1 (unsupported).");
                                    }
                                    zzfpVar10.zzK(8);
                                    int iZze2 = zzaio.zze(zzfpVar10.zzg());
                                    zzfpVar10.zzL(4);
                                    if (iZze2 == 1) {
                                        if (zzfpVar10.zzu() == 0) {
                                            throw zzcc.zzc("Variable length description in sgpd found (unsupported)");
                                        }
                                    } else if (iZze2 >= 2) {
                                        zzfpVar10.zzL(4);
                                    }
                                    if (zzfpVar10.zzu() != 1) {
                                        throw zzcc.zzc("Entry count in sgpd != 1 (unsupported).");
                                    }
                                    zzfpVar10.zzL(1);
                                    int iZzm3 = zzfpVar10.zzm();
                                    int i40 = (iZzm3 & 240) >> 4;
                                    int i41 = iZzm3 & 15;
                                    if (zzfpVar10.zzm() == 1) {
                                        int iZzm4 = zzfpVar10.zzm();
                                        byte[] bArr6 = new byte[16];
                                        zzfpVar10.zzG(bArr6, 0, 16);
                                        if (iZzm4 == 0) {
                                            int iZzm5 = zzfpVar10.zzm();
                                            byte[] bArr7 = new byte[iZzm5];
                                            zzfpVar10.zzG(bArr7, 0, iZzm5);
                                            bArr3 = bArr7;
                                        } else {
                                            bArr3 = null;
                                        }
                                        zzajoVar9.zzk = true;
                                        zzajoVar9.zzm = new zzajn(true, str, iZzm4, bArr6, i40, i41, bArr3);
                                    }
                                }
                                int size5 = zzaimVar5.zzb.size();
                                int i42 = 0;
                                while (i42 < size5) {
                                    zzain zzainVar5 = (zzain) zzaimVar5.zzb.get(i42);
                                    if (zzainVar5.zzd == 1970628964) {
                                        zzfp zzfpVar12 = zzainVar5.zza;
                                        zzfpVar12.zzK(8);
                                        bArr2 = bArr5;
                                        zzfpVar12.zzG(bArr2, 0, 16);
                                        if (Arrays.equals(bArr2, zzb)) {
                                            zzh(zzfpVar12, 16, zzajoVar9);
                                        }
                                    } else {
                                        bArr2 = bArr5;
                                    }
                                    i42++;
                                    bArr5 = bArr2;
                                }
                                bArr = bArr5;
                                i2 = 8;
                            }
                        } else {
                            sparseArray = sparseArray3;
                            zzaimVar = zzaimVar3;
                            i = size3;
                            i2 = i12;
                            i3 = i17;
                            bArr = bArr4;
                        }
                        i12 = i2;
                        bArr4 = bArr;
                        size3 = i;
                        zzaimVar3 = zzaimVar;
                        i17 = i3 + 1;
                        sparseArray3 = sparseArray;
                    }
                    zzae zzaeVarZzf2 = zzf(zzaimVar3.zzb);
                    zzajcVar = this;
                    if (zzaeVarZzf2 != null) {
                        int size6 = zzajcVar.zzf.size();
                        for (int i43 = 0; i43 < size6; i43++) {
                            zzajb zzajbVar2 = (zzajb) zzajcVar.zzf.valueAt(i43);
                            zzajm zzajmVar5 = zzajbVar2.zzd.zza;
                            zzaix zzaixVar4 = zzajbVar2.zzb.zza;
                            int i44 = zzfy.zza;
                            zzajn zzajnVarZza2 = zzajmVar5.zza(zzaixVar4.zza);
                            zzae zzaeVarZzb = zzaeVarZzf2.zzb(zzajnVarZza2 != null ? zzajnVarZza2.zzb : null);
                            zzak zzakVarZzb = zzajbVar2.zzd.zza.zzf.zzb();
                            zzakVarZzb.zzE(zzaeVarZzb);
                            zzajbVar2.zza.zzl(zzakVarZzb.zzac());
                        }
                    }
                    if (zzajcVar.zzw != -9223372036854775807L) {
                        int size7 = zzajcVar.zzf.size();
                        for (int i45 = 0; i45 < size7; i45++) {
                            zzajb zzajbVar3 = (zzajb) zzajcVar.zzf.valueAt(i45);
                            long j11 = zzajcVar.zzw;
                            int i46 = zzajbVar3.zzf;
                            while (true) {
                                zzajo zzajoVar10 = zzajbVar3.zzb;
                                if (i46 >= zzajoVar10.zze || zzajoVar10.zzi[i46] > j11) {
                                    break;
                                }
                                if (zzajoVar10.zzj[i46]) {
                                    zzajbVar3.zzi = i46;
                                }
                                i46++;
                            }
                        }
                        zzajcVar.zzw = -9223372036854775807L;
                    }
                } else {
                    zzajcVar = zzajcVar2;
                    if (!zzajcVar.zzn.isEmpty()) {
                        ((zzaim) zzajcVar.zzn.peek()).zzc(zzaimVar3);
                    }
                }
                zzajcVar2 = zzajcVar;
            }
        }
        zzg();
    }

    private static final zzaix zzj(SparseArray sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return (zzaix) sparseArray.valueAt(0);
        }
        zzaix zzaixVar = (zzaix) sparseArray.get(i);
        zzaixVar.getClass();
        return zzaixVar;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x025a  */
    /* JADX WARN: Code duplicated, block: B:105:0x026f  */
    /* JADX WARN: Code duplicated, block: B:108:0x0276  */
    /* JADX WARN: Code duplicated, block: B:111:0x0293  */
    /* JADX WARN: Code duplicated, block: B:391:0x0234 A[EDGE_INSN: B:391:0x0234->B:96:0x0234 BREAK  A[LOOP:7: B:63:0x013f->B:65:0x0145], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:397:0x01ce A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x013f A[LOOP:7: B:63:0x013f->B:65:0x0145, LOOP_START] */
    /* JADX WARN: Code duplicated, block: B:65:0x0145 A[LOOP:7: B:63:0x013f->B:65:0x0145, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:66:0x0150  */
    /* JADX WARN: Code duplicated, block: B:69:0x0168  */
    /* JADX WARN: Code duplicated, block: B:71:0x016e  */
    /* JADX WARN: Code duplicated, block: B:73:0x0181  */
    /* JADX WARN: Code duplicated, block: B:75:0x019a  */
    /* JADX WARN: Code duplicated, block: B:86:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:90:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:92:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:93:0x021e  */
    /* JADX WARN: Code duplicated, block: B:98:0x023e  */
    /* JADX WARN: Code duplicated, block: B:99:0x0243  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        int i;
        ?? r9;
        zzajb zzajbVar;
        zzajm zzajmVar;
        zzaea zzaeaVar;
        long jZze;
        int i2;
        byte[] bArrZzM;
        int i3;
        int i4;
        int i5;
        int iZzf;
        int iZzg;
        boolean z;
        String str;
        zzajn zzajnVarZzf;
        zzadz zzadzVar;
        int i6;
        zzaja zzajaVar;
        long j;
        int i7;
        int i8;
        int i9;
        int iZzc;
        long jZzs;
        long jZzs2;
        String str2;
        String str3;
        long jZzu;
        long j2;
        long jZzv;
        long jZzv2;
        while (true) {
            int i10 = this.zzp;
            i = 1;
            r9 = 0;
            if (i10 == 0) {
                if (this.zzs == 0) {
                    if (!zzacvVar.zzn(this.zzm.zzM(), 0, 8, true)) {
                        return -1;
                    }
                    this.zzs = 8;
                    this.zzm.zzK(0);
                    this.zzr = this.zzm.zzu();
                    this.zzq = this.zzm.zzg();
                }
                long j3 = this.zzr;
                if (j3 == 1) {
                    ((zzack) zzacvVar).zzn(this.zzm.zzM(), 8, 8, false);
                    this.zzs += 8;
                    this.zzr = this.zzm.zzv();
                } else if (j3 == 0) {
                    long jZzd = zzacvVar.zzd();
                    if (jZzd == -1) {
                        jZzd = !this.zzn.isEmpty() ? ((zzaim) this.zzn.peek()).zza : -1L;
                    }
                    if (jZzd != -1) {
                        this.zzr = (jZzd - zzacvVar.zzf()) + ((long) this.zzs);
                    }
                }
                long j4 = this.zzr;
                long j5 = this.zzs;
                if (j4 < j5) {
                    throw zzcc.zzc("Atom size less than header length (unsupported).");
                }
                long jZzf = zzacvVar.zzf() - j5;
                int i11 = this.zzq;
                if ((i11 == 1836019558 || i11 == 1835295092) && !this.zzH) {
                    this.zzE.zzO(new zzadt(this.zzx, jZzf));
                    this.zzH = true;
                }
                if (this.zzq == 1836019558) {
                    int size = this.zzf.size();
                    for (int i12 = 0; i12 < size; i12++) {
                        zzajo zzajoVar = ((zzajb) this.zzf.valueAt(i12)).zzb;
                        zzajoVar.zzc = jZzf;
                        zzajoVar.zzb = jZzf;
                    }
                }
                int i13 = this.zzq;
                if (i13 == 1835295092) {
                    this.zzz = null;
                    this.zzu = jZzf + this.zzr;
                    this.zzp = 2;
                } else if (i13 == 1836019574 || i13 == 1953653099 || i13 == 1835297121 || i13 == 1835626086 || i13 == 1937007212 || i13 == 1836019558 || i13 == 1953653094 || i13 == 1836475768 || i13 == 1701082227) {
                    long jZzf2 = (zzacvVar.zzf() + this.zzr) - 8;
                    this.zzn.push(new zzaim(i13, jZzf2));
                    if (this.zzr == this.zzs) {
                        zzi(jZzf2);
                    } else {
                        zzg();
                    }
                } else if (i13 == 1751411826 || i13 == 1835296868 || i13 == 1836476516 || i13 == 1936286840 || i13 == 1937011556 || i13 == 1937011827 || i13 == 1668576371 || i13 == 1937011555 || i13 == 1937011578 || i13 == 1937013298 || i13 == 1937007471 || i13 == 1668232756 || i13 == 1937011571 || i13 == 1952867444 || i13 == 1952868452 || i13 == 1953196132 || i13 == 1953654136 || i13 == 1953658222 || i13 == 1886614376 || i13 == 1935763834 || i13 == 1935763823 || i13 == 1936027235 || i13 == 1970628964 || i13 == 1935828848 || i13 == 1936158820 || i13 == 1701606260 || i13 == 1835362404 || i13 == 1701671783) {
                    if (this.zzs != 8) {
                        throw zzcc.zzc("Leaf atom defines extended atom size (unsupported).");
                    }
                    if (this.zzr > 2147483647L) {
                        throw zzcc.zzc("Leaf atom with length > 2147483647 (unsupported).");
                    }
                    zzfp zzfpVar = new zzfp((int) this.zzr);
                    System.arraycopy(this.zzm.zzM(), 0, zzfpVar.zzM(), 0, 8);
                    this.zzt = zzfpVar;
                    this.zzp = 1;
                } else {
                    if (this.zzr > 2147483647L) {
                        throw zzcc.zzc("Skipping atom with length > 2147483647 (unsupported).");
                    }
                    this.zzt = null;
                    this.zzp = 1;
                }
            } else if (i10 != 1) {
                long j6 = Long.MAX_VALUE;
                if (i10 != 2) {
                    zzajbVar = this.zzz;
                    if (zzajbVar != null) {
                        break;
                    }
                    SparseArray sparseArray = this.zzf;
                    int size2 = sparseArray.size();
                    long j7 = Long.MAX_VALUE;
                    zzajb zzajbVar2 = null;
                    for (int i14 = 0; i14 < size2; i14++) {
                        zzajb zzajbVar3 = (zzajb) sparseArray.valueAt(i14);
                        if ((zzajbVar3.zzl || zzajbVar3.zzf != zzajbVar3.zzd.zzb) && (!zzajbVar3.zzl || zzajbVar3.zzh != zzajbVar3.zzb.zzd)) {
                            long jZzd2 = zzajbVar3.zzd();
                            if (jZzd2 < j7) {
                                zzajbVar2 = zzajbVar3;
                                j7 = jZzd2;
                            }
                        }
                    }
                    if (zzajbVar2 != null) {
                        int iZzd = (int) (zzajbVar2.zzd() - zzacvVar.zzf());
                        if (iZzd < 0) {
                            zzff.zzf("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                            iZzd = 0;
                        }
                        ((zzack) zzacvVar).zzo(iZzd, false);
                        this.zzz = zzajbVar2;
                        zzajbVar = zzajbVar2;
                        break;
                    }
                    int iZzf2 = (int) (this.zzu - zzacvVar.zzf());
                    if (iZzf2 < 0) {
                        throw zzcc.zza("Offset to end of mdat was negative.", null);
                    }
                    ((zzack) zzacvVar).zzo(iZzf2, false);
                    zzg();
                } else {
                    int size3 = this.zzf.size();
                    zzajb zzajbVar4 = null;
                    for (int i15 = 0; i15 < size3; i15++) {
                        zzajo zzajoVar2 = ((zzajb) this.zzf.valueAt(i15)).zzb;
                        if (zzajoVar2.zzo) {
                            long j8 = zzajoVar2.zzc;
                            if (j8 < j6) {
                                zzajbVar4 = (zzajb) this.zzf.valueAt(i15);
                                j6 = j8;
                            }
                        }
                    }
                    if (zzajbVar4 == null) {
                        this.zzp = 3;
                    } else {
                        int iZzf3 = (int) (j6 - zzacvVar.zzf());
                        if (iZzf3 < 0) {
                            throw zzcc.zza("Offset to encryption data was negative.", null);
                        }
                        zzack zzackVar = (zzack) zzacvVar;
                        zzackVar.zzo(iZzf3, false);
                        zzajo zzajoVar3 = zzajbVar4.zzb;
                        zzfp zzfpVar2 = zzajoVar3.zzn;
                        zzackVar.zzn(zzfpVar2.zzM(), 0, zzfpVar2.zze(), false);
                        zzajoVar3.zzn.zzK(0);
                        zzajoVar3.zzo = false;
                    }
                }
            } else {
                int i16 = ((int) this.zzr) - this.zzs;
                zzfp zzfpVar3 = this.zzt;
                if (zzfpVar3 != null) {
                    ((zzack) zzacvVar).zzn(zzfpVar3.zzM(), 8, i16, false);
                    zzain zzainVar = new zzain(this.zzq, zzfpVar3);
                    long jZzf3 = zzacvVar.zzf();
                    if (this.zzn.isEmpty()) {
                        int i17 = zzainVar.zzd;
                        if (i17 == 1936286840) {
                            zzfp zzfpVar4 = zzainVar.zza;
                            zzfpVar4.zzK(8);
                            int iZze = zzaio.zze(zzfpVar4.zzg());
                            zzfpVar4.zzL(4);
                            long jZzu2 = zzfpVar4.zzu();
                            if (iZze == 0) {
                                jZzv = zzfpVar4.zzu();
                                jZzv2 = zzfpVar4.zzu();
                            } else {
                                jZzv = zzfpVar4.zzv();
                                jZzv2 = zzfpVar4.zzv();
                            }
                            long j9 = jZzf3 + jZzv2;
                            long jZzs3 = zzfy.zzs(jZzv, 1000000L, jZzu2, RoundingMode.FLOOR);
                            zzfpVar4.zzL(2);
                            int iZzq = zzfpVar4.zzq();
                            int[] iArr = new int[iZzq];
                            long[] jArr = new long[iZzq];
                            long[] jArr2 = new long[iZzq];
                            long[] jArr3 = new long[iZzq];
                            long jZzs4 = jZzs3;
                            int i18 = 0;
                            while (i18 < iZzq) {
                                int iZzg2 = zzfpVar4.zzg();
                                if ((iZzg2 & Integer.MIN_VALUE) != 0) {
                                    throw zzcc.zza("Unhandled indirect reference", null);
                                }
                                long jZzu3 = zzfpVar4.zzu();
                                iArr[i18] = iZzg2 & Integer.MAX_VALUE;
                                jArr[i18] = j9;
                                jArr3[i18] = jZzs4;
                                long j10 = jZzv + jZzu3;
                                long[] jArr4 = jArr3;
                                int i19 = i18;
                                long[] jArr5 = jArr2;
                                int[] iArr2 = iArr;
                                jZzs4 = zzfy.zzs(j10, 1000000L, jZzu2, RoundingMode.FLOOR);
                                jArr5[i19] = jZzs4 - jArr4[i19];
                                zzfpVar4.zzL(4);
                                j9 += (long) iArr2[i19];
                                i18 = i19 + 1;
                                iArr = iArr2;
                                jArr2 = jArr5;
                                jArr3 = jArr4;
                                jZzv = j10;
                                jArr = jArr;
                            }
                            Pair pairCreate = Pair.create(Long.valueOf(jZzs3), new zzaci(iArr, jArr, jArr2, jArr3));
                            this.zzy = ((Long) pairCreate.first).longValue();
                            this.zzE.zzO((zzadu) pairCreate.second);
                            this.zzH = true;
                        } else if (i17 == 1701671783) {
                            zzfp zzfpVar5 = zzainVar.zza;
                            if (this.zzF.length != 0) {
                                zzfpVar5.zzK(8);
                                int iZze2 = zzaio.zze(zzfpVar5.zzg());
                                if (iZze2 == 0) {
                                    String strZzx = zzfpVar5.zzx((char) 0);
                                    strZzx.getClass();
                                    String strZzx2 = zzfpVar5.zzx((char) 0);
                                    strZzx2.getClass();
                                    long jZzu4 = zzfpVar5.zzu();
                                    jZzs = zzfy.zzs(zzfpVar5.zzu(), 1000000L, jZzu4, RoundingMode.FLOOR);
                                    long j11 = this.zzy;
                                    long j12 = j11 != -9223372036854775807L ? j11 + jZzs : -9223372036854775807L;
                                    jZzs2 = zzfy.zzs(zzfpVar5.zzu(), 1000L, jZzu4, RoundingMode.FLOOR);
                                    str2 = strZzx;
                                    str3 = strZzx2;
                                    jZzu = zzfpVar5.zzu();
                                    j2 = j12;
                                } else if (iZze2 != 1) {
                                    zzff.zzf("FragmentedMp4Extractor", "Skipping unsupported emsg version: " + iZze2);
                                } else {
                                    long jZzu5 = zzfpVar5.zzu();
                                    long jZzs5 = zzfy.zzs(zzfpVar5.zzv(), 1000000L, jZzu5, RoundingMode.FLOOR);
                                    long jZzs6 = zzfy.zzs(zzfpVar5.zzu(), 1000L, jZzu5, RoundingMode.FLOOR);
                                    long jZzu6 = zzfpVar5.zzu();
                                    String strZzx3 = zzfpVar5.zzx((char) 0);
                                    strZzx3.getClass();
                                    String strZzx4 = zzfpVar5.zzx((char) 0);
                                    strZzx4.getClass();
                                    jZzs2 = jZzs6;
                                    jZzu = jZzu6;
                                    str2 = strZzx3;
                                    str3 = strZzx4;
                                    j2 = jZzs5;
                                    jZzs = -9223372036854775807L;
                                }
                                byte[] bArr = new byte[zzfpVar5.zzb()];
                                zzfpVar5.zzG(bArr, 0, zzfpVar5.zzb());
                                zzfp zzfpVar6 = new zzfp(this.zzl.zza(new zzaft(str2, str3, jZzs2, jZzu, bArr)));
                                int iZzb = zzfpVar6.zzb();
                                for (zzaea zzaeaVar2 : this.zzF) {
                                    zzfpVar6.zzK(0);
                                    zzaeaVar2.zzr(zzfpVar6, iZzb);
                                }
                                if (j2 == -9223372036854775807L) {
                                    this.zzo.addLast(new zzaja(jZzs, true, iZzb));
                                    this.zzv += iZzb;
                                } else if (this.zzo.isEmpty()) {
                                    for (zzaea zzaeaVar3 : this.zzF) {
                                        zzaeaVar3.zzt(j2, 1, iZzb, 0, null);
                                    }
                                } else {
                                    this.zzo.addLast(new zzaja(j2, false, iZzb));
                                    this.zzv += iZzb;
                                }
                            }
                        }
                    } else {
                        ((zzaim) this.zzn.peek()).zzd(zzainVar);
                    }
                } else {
                    ((zzack) zzacvVar).zzo(i16, false);
                }
                zzi(zzacvVar.zzf());
            }
        }
        int i20 = 6;
        if (this.zzp == 3) {
            int iZzb2 = zzajbVar.zzb();
            this.zzA = iZzb2;
            if (zzajbVar.zzf < zzajbVar.zzi) {
                ((zzack) zzacvVar).zzo(iZzb2, false);
                zzajn zzajnVarZzf2 = zzajbVar.zzf();
                if (zzajnVarZzf2 != null) {
                    zzfp zzfpVar7 = zzajbVar.zzb.zzn;
                    int i21 = zzajnVarZzf2.zzd;
                    if (i21 != 0) {
                        zzfpVar7.zzL(i21);
                    }
                    if (zzajbVar.zzb.zzb(zzajbVar.zzf)) {
                        zzfpVar7.zzL(zzfpVar7.zzq() * 6);
                    }
                }
                if (!zzajbVar.zzk()) {
                    this.zzz = null;
                }
                i6 = 3;
            } else {
                if (zzajbVar.zzd.zza.zzg == 1) {
                    this.zzA = iZzb2 - 8;
                    ((zzack) zzacvVar).zzo(8, false);
                }
                if ("audio/ac4".equals(zzajbVar.zzd.zza.zzf.zzm)) {
                    this.zzB = zzajbVar.zzc(this.zzA, 7);
                    zzaby.zzb(this.zzA, this.zzk);
                    zzajbVar.zza.zzr(this.zzk, 7);
                    iZzc = this.zzB + 7;
                    this.zzB = iZzc;
                } else {
                    iZzc = zzajbVar.zzc(this.zzA, 0);
                    this.zzB = iZzc;
                }
                this.zzA += iZzc;
                this.zzp = 4;
                this.zzC = 0;
                zzajmVar = zzajbVar.zzd.zza;
                zzaeaVar = zzajbVar.zza;
                jZze = zzajbVar.zze();
                i2 = zzajmVar.zzj;
                if (i2 == 0) {
                    while (true) {
                        i8 = this.zzB;
                        i9 = this.zzA;
                        if (i8 < i9) {
                            break;
                        }
                        this.zzB += zzaeaVar.zzf(zzacvVar, i9 - i8, false);
                    }
                } else {
                    bArrZzM = this.zzh.zzM();
                    bArrZzM[0] = 0;
                    bArrZzM[1] = 0;
                    bArrZzM[2] = 0;
                    i3 = i2 + 1;
                    i4 = 4 - i2;
                    while (this.zzB < this.zzA) {
                        i5 = this.zzC;
                        if (i5 == 0) {
                            ((zzack) zzacvVar).zzn(bArrZzM, i4, i3, r9);
                            this.zzh.zzK(r9);
                            iZzg = this.zzh.zzg();
                            if (iZzg > 0) {
                                throw zzcc.zza("Invalid NAL length", null);
                            }
                            this.zzC = iZzg - 1;
                            this.zzg.zzK(r9);
                            zzaeaVar.zzr(this.zzg, 4);
                            zzaeaVar.zzr(this.zzh, i);
                            if (this.zzG.length > 0) {
                                str = zzajmVar.zzf.zzm;
                                int i22 = bArrZzM[4];
                                byte[] bArr2 = zzgm.zza;
                                if (("video/avc".equals(str) || (i22 & 31) != i20) && !("video/hevc".equals(str) && ((i22 & 126) >> i) == 39)) {
                                    z = 0;
                                } else {
                                    z = i;
                                }
                            } else {
                                z = 0;
                            }
                            this.zzD = z;
                            this.zzB += 5;
                            this.zzA += i4;
                        } else {
                            if (this.zzD) {
                                this.zzi.zzH(i5);
                                ((zzack) zzacvVar).zzn(this.zzi.zzM(), 0, this.zzC, false);
                                zzaeaVar.zzr(this.zzi, this.zzC);
                                iZzf = this.zzC;
                                zzfp zzfpVar8 = this.zzi;
                                int iZzb3 = zzgm.zzb(zzfpVar8.zzM(), zzfpVar8.zze());
                                this.zzi.zzK("video/hevc".equals(zzajmVar.zzf.zzm) ? 1 : 0);
                                this.zzi.zzJ(iZzb3);
                                zzach.zza(jZze, this.zzi, this.zzG);
                            } else {
                                iZzf = zzaeaVar.zzf(zzacvVar, i5, false);
                            }
                            this.zzB += iZzf;
                            this.zzC -= iZzf;
                            i20 = 6;
                            i = 1;
                        }
                        r9 = 0;
                    }
                }
                int iZza = zzajbVar.zza();
                zzajnVarZzf = zzajbVar.zzf();
                if (zzajnVarZzf != null) {
                    zzadzVar = zzajnVarZzf.zzc;
                } else {
                    zzadzVar = null;
                }
                zzaeaVar.zzt(jZze, iZza, this.zzA, 0, zzadzVar);
                while (!this.zzo.isEmpty()) {
                    zzajaVar = (zzaja) this.zzo.removeFirst();
                    this.zzv -= zzajaVar.zzc;
                    j = zzajaVar.zza;
                    if (zzajaVar.zzb) {
                        j += jZze;
                    }
                    for (zzaea zzaeaVar4 : this.zzF) {
                        zzaeaVar4.zzt(j, 1, zzajaVar.zzc, this.zzv, null);
                    }
                }
                if (!zzajbVar.zzk()) {
                    this.zzz = null;
                }
                i6 = 3;
            }
        } else {
            zzajmVar = zzajbVar.zzd.zza;
            zzaeaVar = zzajbVar.zza;
            jZze = zzajbVar.zze();
            i2 = zzajmVar.zzj;
            if (i2 == 0) {
                while (true) {
                    i8 = this.zzB;
                    i9 = this.zzA;
                    if (i8 < i9) {
                        break;
                        break;
                    }
                    this.zzB += zzaeaVar.zzf(zzacvVar, i9 - i8, false);
                }
            } else {
                bArrZzM = this.zzh.zzM();
                bArrZzM[0] = 0;
                bArrZzM[1] = 0;
                bArrZzM[2] = 0;
                i3 = i2 + 1;
                i4 = 4 - i2;
                while (this.zzB < this.zzA) {
                    i5 = this.zzC;
                    if (i5 == 0) {
                        ((zzack) zzacvVar).zzn(bArrZzM, i4, i3, r9);
                        this.zzh.zzK(r9);
                        iZzg = this.zzh.zzg();
                        if (iZzg > 0) {
                            throw zzcc.zza("Invalid NAL length", null);
                        }
                        this.zzC = iZzg - 1;
                        this.zzg.zzK(r9);
                        zzaeaVar.zzr(this.zzg, 4);
                        zzaeaVar.zzr(this.zzh, i);
                        if (this.zzG.length > 0) {
                            str = zzajmVar.zzf.zzm;
                            int i23 = bArrZzM[4];
                            byte[] bArr3 = zzgm.zza;
                            if ("video/avc".equals(str)) {
                                z = 0;
                            } else {
                                z = 0;
                            }
                        } else {
                            z = 0;
                        }
                        this.zzD = z;
                        this.zzB += 5;
                        this.zzA += i4;
                    } else {
                        if (this.zzD) {
                            this.zzi.zzH(i5);
                            ((zzack) zzacvVar).zzn(this.zzi.zzM(), 0, this.zzC, false);
                            zzaeaVar.zzr(this.zzi, this.zzC);
                            iZzf = this.zzC;
                            zzfp zzfpVar9 = this.zzi;
                            int iZzb4 = zzgm.zzb(zzfpVar9.zzM(), zzfpVar9.zze());
                            this.zzi.zzK("video/hevc".equals(zzajmVar.zzf.zzm) ? 1 : 0);
                            this.zzi.zzJ(iZzb4);
                            zzach.zza(jZze, this.zzi, this.zzG);
                        } else {
                            iZzf = zzaeaVar.zzf(zzacvVar, i5, false);
                        }
                        this.zzB += iZzf;
                        this.zzC -= iZzf;
                        i20 = 6;
                        i = 1;
                    }
                    r9 = 0;
                }
            }
            int iZza2 = zzajbVar.zza();
            zzajnVarZzf = zzajbVar.zzf();
            if (zzajnVarZzf != null) {
                zzadzVar = zzajnVarZzf.zzc;
            } else {
                zzadzVar = null;
            }
            zzaeaVar.zzt(jZze, iZza2, this.zzA, 0, zzadzVar);
            while (!this.zzo.isEmpty()) {
                zzajaVar = (zzaja) this.zzo.removeFirst();
                this.zzv -= zzajaVar.zzc;
                j = zzajaVar.zza;
                if (zzajaVar.zzb) {
                    j += jZze;
                }
                while (i7 < r6) {
                    zzaeaVar4.zzt(j, 1, zzajaVar.zzc, this.zzv, null);
                }
            }
            if (!zzajbVar.zzk()) {
                this.zzz = null;
            }
            i6 = 3;
        }
        this.zzp = i6;
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        this.zzE = zzacxVar;
        zzg();
        zzaea[] zzaeaVarArr = new zzaea[2];
        this.zzF = zzaeaVarArr;
        int i = 0;
        zzaea[] zzaeaVarArr2 = (zzaea[]) zzfy.zzL(zzaeaVarArr, 0);
        this.zzF = zzaeaVarArr2;
        for (zzaea zzaeaVar : zzaeaVarArr2) {
            zzaeaVar.zzl(zzc);
        }
        this.zzG = new zzaea[this.zze.size()];
        int i2 = 100;
        while (i < this.zzG.length) {
            int i3 = i2 + 1;
            zzaea zzaeaVarZzw = this.zzE.zzw(i2, 3);
            zzaeaVarZzw.zzl((zzam) this.zze.get(i));
            this.zzG[i] = zzaeaVarZzw;
            i++;
            i2 = i3;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j, long j2) {
        int size = this.zzf.size();
        for (int i = 0; i < size; i++) {
            ((zzajb) this.zzf.valueAt(i)).zzi();
        }
        this.zzo.clear();
        this.zzv = 0;
        this.zzw = j2;
        this.zzn.clear();
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        return zzajl.zza(zzacvVar);
    }

    public zzajc(zzakp zzakpVar, int i, zzfw zzfwVar, zzajm zzajmVar, List list, zzaea zzaeaVar) {
        this.zzd = zzakpVar;
        this.zze = Collections.unmodifiableList(list);
        this.zzl = new zzafu();
        this.zzm = new zzfp(16);
        this.zzg = new zzfp(zzgm.zza);
        this.zzh = new zzfp(5);
        this.zzi = new zzfp();
        byte[] bArr = new byte[16];
        this.zzj = bArr;
        this.zzk = new zzfp(bArr);
        this.zzn = new ArrayDeque();
        this.zzo = new ArrayDeque();
        this.zzf = new SparseArray();
        this.zzx = -9223372036854775807L;
        this.zzw = -9223372036854775807L;
        this.zzy = -9223372036854775807L;
        this.zzE = zzacx.zza;
        this.zzF = new zzaea[0];
        this.zzG = new zzaea[0];
    }
}
