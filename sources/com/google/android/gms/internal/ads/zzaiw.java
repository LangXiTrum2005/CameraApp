package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.work.WorkRequest;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaiw {
    private static final byte[] zza;

    static {
        int i = zzfy.zza;
        zza = "OpusHead".getBytes(zzfwq.zzc);
    }

    public static zzby zza(zzaim zzaimVar) {
        zzgc zzgcVar;
        zzain zzainVarZzb = zzaimVar.zzb(1751411826);
        zzain zzainVarZzb2 = zzaimVar.zzb(1801812339);
        zzain zzainVarZzb3 = zzaimVar.zzb(1768715124);
        if (zzainVarZzb != null && zzainVarZzb2 != null && zzainVarZzb3 != null && zzg(zzainVarZzb.zza) == 1835299937) {
            zzfp zzfpVar = zzainVarZzb2.zza;
            zzfpVar.zzK(12);
            int iZzg = zzfpVar.zzg();
            String[] strArr = new String[iZzg];
            for (int i = 0; i < iZzg; i++) {
                int iZzg2 = zzfpVar.zzg();
                zzfpVar.zzL(4);
                strArr[i] = zzfpVar.zzA(iZzg2 - 8, zzfwq.zzc);
            }
            zzfp zzfpVar2 = zzainVarZzb3.zza;
            zzfpVar2.zzK(8);
            ArrayList arrayList = new ArrayList();
            while (zzfpVar2.zzb() > 8) {
                int iZzd = zzfpVar2.zzd() + zzfpVar2.zzg();
                int iZzg3 = zzfpVar2.zzg() - 1;
                if (iZzg3 < 0 || iZzg3 >= iZzg) {
                    zzff.zzf("AtomParsers", "Skipped metadata with unknown key index: " + iZzg3);
                } else {
                    String str = strArr[iZzg3];
                    int i2 = zzajd.zzb;
                    while (true) {
                        int iZzd2 = zzfpVar2.zzd();
                        if (iZzd2 >= iZzd) {
                            zzgcVar = null;
                            break;
                        }
                        int iZzg4 = zzfpVar2.zzg();
                        if (zzfpVar2.zzg() == 1684108385) {
                            int iZzg5 = zzfpVar2.zzg();
                            int iZzg6 = zzfpVar2.zzg();
                            int i3 = iZzg4 - 16;
                            byte[] bArr = new byte[i3];
                            zzfpVar2.zzG(bArr, 0, i3);
                            zzgcVar = new zzgc(str, bArr, iZzg6, iZzg5);
                            break;
                        }
                        zzfpVar2.zzK(iZzd2 + iZzg4);
                    }
                    if (zzgcVar != null) {
                        arrayList.add(zzgcVar);
                    }
                }
                zzfpVar2.zzK(iZzd);
            }
            if (!arrayList.isEmpty()) {
                return new zzby(arrayList);
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00da  */
    public static zzby zzb(zzain zzainVar) {
        int iZzn;
        zzfp zzfpVar = zzainVar.zza;
        zzfpVar.zzK(8);
        zzby zzbyVar = new zzby(-9223372036854775807L, new zzbx[0]);
        while (zzfpVar.zzb() >= 8) {
            int iZzd = zzfpVar.zzd();
            int iZzg = zzfpVar.zzg() + iZzd;
            int iZzg2 = zzfpVar.zzg();
            zzby zzbyVar2 = null;
            if (iZzg2 == 1835365473) {
                zzfpVar.zzK(iZzd);
                zzfpVar.zzL(8);
                zze(zzfpVar);
                while (zzfpVar.zzd() < iZzg) {
                    int iZzd2 = zzfpVar.zzd();
                    int iZzg3 = zzfpVar.zzg() + iZzd2;
                    if (zzfpVar.zzg() == 1768715124) {
                        zzfpVar.zzK(iZzd2);
                        zzfpVar.zzL(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzfpVar.zzd() < iZzg3) {
                            zzbx zzbxVarZza = zzajd.zza(zzfpVar);
                            if (zzbxVarZza != null) {
                                arrayList.add(zzbxVarZza);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            zzbyVar2 = new zzby(arrayList);
                            break;
                        }
                        break;
                    }
                    zzfpVar.zzK(iZzg3);
                }
                zzbyVar = zzbyVar.zzd(zzbyVar2);
            } else if (iZzg2 == 1936553057) {
                zzfpVar.zzK(iZzd);
                zzfpVar.zzL(12);
                while (zzfpVar.zzd() < iZzg) {
                    int iZzd3 = zzfpVar.zzd();
                    int iZzg4 = zzfpVar.zzg();
                    if (zzfpVar.zzg() == 1935766900) {
                        if (iZzg4 < 16) {
                            break;
                        }
                        zzfpVar.zzL(4);
                        int i = -1;
                        int i2 = 0;
                        for (int i3 = 0; i3 < 2; i3++) {
                            int iZzm = zzfpVar.zzm();
                            int iZzm2 = zzfpVar.zzm();
                            if (iZzm == 0) {
                                i = iZzm2;
                            } else if (iZzm == 1) {
                                i2 = iZzm2;
                            }
                        }
                        if (i == 12) {
                            iZzn = 240;
                        } else if (i == 13) {
                            iZzn = 120;
                        } else if (i == 21 && zzfpVar.zzb() >= 8 && zzfpVar.zzd() + 8 <= iZzg) {
                            int iZzg5 = zzfpVar.zzg();
                            int iZzg6 = zzfpVar.zzg();
                            if (iZzg5 < 12 || iZzg6 != 1936877170) {
                                iZzn = -2147483647;
                            } else {
                                iZzn = zzfpVar.zzn();
                            }
                        } else {
                            iZzn = -2147483647;
                        }
                        if (iZzn == -2147483647) {
                            break;
                        }
                        zzbyVar2 = new zzby(-9223372036854775807L, new zzahm(iZzn, i2));
                        break;
                    }
                    zzfpVar.zzK(iZzd3 + iZzg4);
                }
                zzbyVar = zzbyVar.zzd(zzbyVar2);
            } else if (iZzg2 == -1451722374) {
                zzbyVar = zzbyVar.zzd(zzi(zzfpVar));
            }
            zzfpVar.zzK(iZzg);
        }
        return zzbyVar;
    }

    public static zzgi zzc(zzfp zzfpVar) {
        long jZzt;
        long jZzt2;
        zzfpVar.zzK(8);
        if (zzaio.zze(zzfpVar.zzg()) == 0) {
            jZzt = zzfpVar.zzu();
            jZzt2 = zzfpVar.zzu();
        } else {
            jZzt = zzfpVar.zzt();
            jZzt2 = zzfpVar.zzt();
        }
        return new zzgi(jZzt, jZzt2, zzfpVar.zzu());
    }

    /* JADX WARN: Code duplicated, block: B:310:0x0625 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:311:0x0627  */
    /* JADX WARN: Code duplicated, block: B:312:0x062a  */
    /* JADX WARN: Code duplicated, block: B:356:0x071f  */
    /* JADX WARN: Code duplicated, block: B:357:0x0724  */
    /* JADX WARN: Code duplicated, block: B:360:0x072f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:361:0x0731  */
    /* JADX WARN: Code duplicated, block: B:362:0x0735  */
    /* JADX WARN: Code duplicated, block: B:364:0x0738  */
    /* JADX WARN: Code duplicated, block: B:367:0x0741  */
    /* JADX WARN: Code duplicated, block: B:370:0x0748  */
    /* JADX WARN: Code duplicated, block: B:372:0x0758  */
    /* JADX WARN: Code duplicated, block: B:374:0x075b  */
    /* JADX WARN: Code duplicated, block: B:376:0x075f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:377:0x0761  */
    /* JADX WARN: Code duplicated, block: B:378:0x0764  */
    /* JADX WARN: Code duplicated, block: B:379:0x0767  */
    /* JADX WARN: Code duplicated, block: B:380:0x0769  */
    /* JADX WARN: Code duplicated, block: B:384:0x0778  */
    /* JADX WARN: Code duplicated, block: B:385:0x077a  */
    /* JADX WARN: Code duplicated, block: B:519:0x0afd  */
    /* JADX WARN: Code duplicated, block: B:520:0x0b01  */
    /* JADX WARN: Code duplicated, block: B:62:0x011b  */
    /* JADX WARN: Code duplicated, block: B:63:0x011d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x011f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x0121  */
    /* JADX WARN: Code duplicated, block: B:66:0x0124  */
    /* JADX WARN: Code duplicated, block: B:67:0x0126  */
    /* JADX WARN: Code duplicated, block: B:68:0x0127 A[PHI: r10
  0x0127: PHI (r10v3 int) = (r10v1 int), (r10v5 int) binds: [B:62:0x011b, B:67:0x0126] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:70:0x012a  */
    /* JADX WARN: Code duplicated, block: B:76:0x0136  */
    /* JADX WARN: Instruction removed from duplicated block: B:367:0x0741, please report this as an issue */
    public static List zzd(zzaim zzaimVar, zzadk zzadkVar, long j, zzae zzaeVar, boolean z, boolean z2, zzfws zzfwsVar) throws zzcc {
        int i;
        long j2;
        int i2;
        int i3;
        ArrayList arrayList;
        zzaim zzaimVar2;
        long[] jArr;
        long[] jArr2;
        zzajm zzajmVar;
        Pair pairCreate;
        String str;
        zzae zzaeVarZzb;
        int i4;
        String str2;
        byte[] bArrCopyOfRange;
        String str3;
        byte[] bArrArray;
        int i5;
        int i6;
        int i7;
        int i8;
        float f;
        String str4;
        zzais zzaisVar;
        boolean z3;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean zZzo;
        boolean z4;
        zzt zztVarZzg;
        int iZzd;
        int iZzd2;
        int iZzd3;
        int i13;
        int iZzd4;
        int i14;
        int i15;
        List list;
        float f2;
        boolean z5;
        String str5;
        int i16;
        int i17;
        int i18;
        int i19;
        String str6;
        boolean z6;
        String str7;
        String str8;
        zzgaa zzgaaVarZzm;
        long j3;
        ArrayList arrayList2;
        ArrayList arrayList3 = new ArrayList();
        int i20 = 0;
        while (i20 < zzaimVar.zzc.size()) {
            zzaim zzaimVar3 = (zzaim) zzaimVar.zzc.get(i20);
            if (zzaimVar3.zzd != 1953653099) {
                arrayList2 = arrayList3;
                i3 = i20;
            } else {
                zzain zzainVarZzb = zzaimVar.zzb(1836476516);
                zzainVarZzb.getClass();
                zzaim zzaimVarZza = zzaimVar3.zza(1835297121);
                zzaimVarZza.getClass();
                zzain zzainVarZzb2 = zzaimVarZza.zzb(1751411826);
                zzainVarZzb2.getClass();
                int iZzg = zzg(zzainVarZzb2.zza);
                if (iZzg == 1936684398) {
                    i = 1;
                } else if (iZzg == 1986618469) {
                    i = 2;
                } else if (iZzg == 1952807028 || iZzg == 1935832172 || iZzg == 1937072756 || iZzg == 1668047728) {
                    i = 3;
                } else {
                    i = iZzg == 1835365473 ? 5 : -1;
                }
                if (i == -1) {
                    arrayList = arrayList3;
                    i3 = i20;
                    zzaimVar2 = zzaimVar3;
                    zzajmVar = null;
                } else {
                    zzain zzainVarZzb3 = zzaimVar3.zzb(1953196132);
                    zzainVarZzb3.getClass();
                    zzfp zzfpVar = zzainVarZzb3.zza;
                    zzfpVar.zzK(8);
                    int iZze = zzaio.zze(zzfpVar.zzg());
                    zzfpVar.zzL(iZze == 0 ? 8 : 16);
                    int iZzg2 = zzfpVar.zzg();
                    zzfpVar.zzL(4);
                    int iZzd5 = zzfpVar.zzd();
                    int i21 = 0;
                    while (true) {
                        int i22 = iZze == 0 ? 4 : 8;
                        if (i21 >= i22) {
                            zzfpVar.zzL(i22);
                        } else {
                            if (zzfpVar.zzM()[iZzd5 + i21] != -1) {
                                long jZzu = iZze == 0 ? zzfpVar.zzu() : zzfpVar.zzv();
                                if (jZzu != 0) {
                                    j2 = jZzu;
                                    break;
                                }
                                break;
                            }
                            i21++;
                        }
                        j2 = -9223372036854775807L;
                        break;
                    }
                    zzfpVar.zzL(16);
                    int iZzg3 = zzfpVar.zzg();
                    int iZzg4 = zzfpVar.zzg();
                    zzfpVar.zzL(4);
                    int iZzg5 = zzfpVar.zzg();
                    int iZzg6 = zzfpVar.zzg();
                    int i23 = 65536;
                    if (iZzg3 != 0) {
                        if (iZzg3 == 0) {
                            i23 = iZzg5;
                        } else if (iZzg4 != -65536) {
                            i23 = iZzg5;
                            iZzg3 = 0;
                        } else if (iZzg5 == 65536) {
                            iZzg4 = -65536;
                            i23 = iZzg5;
                            iZzg3 = 0;
                        } else if (iZzg6 == 0) {
                            i2 = 270;
                        } else {
                            iZzg4 = -65536;
                            iZzg3 = 0;
                        }
                        if (iZzg3 != -65536 && iZzg4 == 0 && i23 == 0 && iZzg6 == -65536) {
                            i2 = 180;
                        } else {
                            i2 = 0;
                        }
                    } else {
                        if (iZzg4 == 65536) {
                            if (iZzg5 == -65536) {
                                if (iZzg6 == 0) {
                                    i2 = 90;
                                } else {
                                    iZzg5 = -65536;
                                }
                            }
                            iZzg4 = 65536;
                        }
                        iZzg3 = 0;
                        if (iZzg3 == 0) {
                            i23 = iZzg5;
                        } else if (iZzg4 != -65536) {
                            i23 = iZzg5;
                            iZzg3 = 0;
                        } else if (iZzg5 == 65536) {
                            iZzg4 = -65536;
                            i23 = iZzg5;
                            iZzg3 = 0;
                        } else if (iZzg6 == 0) {
                            i2 = 270;
                        } else {
                            iZzg4 = -65536;
                            iZzg3 = 0;
                        }
                        if (iZzg3 != -65536) {
                            i2 = 0;
                        } else {
                            i2 = 0;
                        }
                    }
                    zzaiv zzaivVar = new zzaiv(iZzg2, j2, i2);
                    long j4 = j == -9223372036854775807L ? zzaivVar.zzb : j;
                    long j5 = zzc(zzainVarZzb.zza).zzc;
                    long jZzs = j4 != -9223372036854775807L ? zzfy.zzs(j4, 1000000L, j5, RoundingMode.FLOOR) : -9223372036854775807L;
                    zzaim zzaimVarZza2 = zzaimVarZza.zza(1835626086);
                    zzaimVarZza2.getClass();
                    zzaim zzaimVarZza3 = zzaimVarZza2.zza(1937007212);
                    zzaimVarZza3.getClass();
                    zzain zzainVarZzb4 = zzaimVarZza.zzb(1835296868);
                    zzainVarZzb4.getClass();
                    zzfp zzfpVar2 = zzainVarZzb4.zza;
                    zzfpVar2.zzK(8);
                    int iZze2 = zzaio.zze(zzfpVar2.zzg());
                    zzfpVar2.zzL(iZze2 == 0 ? 8 : 16);
                    int i24 = iZze2 == 0 ? 4 : 8;
                    long jZzu2 = zzfpVar2.zzu();
                    zzfpVar2.zzL(i24);
                    int iZzq = zzfpVar2.zzq();
                    StringBuilder sb = new StringBuilder();
                    sb.append((char) (((iZzq >> 10) & 31) + 96));
                    sb.append((char) (((iZzq >> 5) & 31) + 96));
                    sb.append((char) ((iZzq & 31) + 96));
                    Pair pairCreate2 = Pair.create(Long.valueOf(jZzu2), sb.toString());
                    zzain zzainVarZzb5 = zzaimVarZza3.zzb(1937011556);
                    if (zzainVarZzb5 == null) {
                        throw zzcc.zza("Malformed sample table (stbl) missing sample description (stsd)", null);
                    }
                    int i25 = zzaivVar.zza;
                    int i26 = zzaivVar.zzc;
                    String str9 = (String) pairCreate2.second;
                    zzfp zzfpVar3 = zzainVarZzb5.zza;
                    zzfpVar3.zzK(12);
                    int iZzg7 = zzfpVar3.zzg();
                    i3 = i20;
                    zzais zzaisVar2 = new zzais(iZzg7);
                    arrayList = arrayList3;
                    int i27 = 0;
                    while (i27 < iZzg7) {
                        zzaiv zzaivVar2 = zzaivVar;
                        int iZzd6 = zzfpVar3.zzd();
                        zzaim zzaimVar4 = zzaimVar3;
                        int iZzg8 = zzfpVar3.zzg();
                        zzacy.zzb(iZzg8 > 0, "childAtomSize must be positive");
                        int iZzg9 = zzfpVar3.zzg();
                        int i28 = iZzg7;
                        if (iZzg9 == 1635148593 || iZzg9 == 1635148595 || iZzg9 == 1701733238 || iZzg9 == 1831958048 || iZzg9 == 1836070006 || iZzg9 == 1752589105 || iZzg9 == 1751479857 || iZzg9 == 1932670515 || iZzg9 == 1211250227 || iZzg9 == 1987063864 || iZzg9 == 1987063865 || iZzg9 == 1635135537 || iZzg9 == 1685479798 || iZzg9 == 1685479729 || iZzg9 == 1685481573 || iZzg9 == 1685481521) {
                            str = str9;
                            int i29 = i26;
                            i = i;
                            int i30 = i25;
                            pairCreate2 = pairCreate2;
                            j5 = j5;
                            i28 = i28;
                            zzfpVar3.zzK(iZzd6 + 16);
                            zzfpVar3.zzL(16);
                            int iZzq2 = zzfpVar3.zzq();
                            int iZzq3 = zzfpVar3.zzq();
                            zzfpVar3.zzL(50);
                            int iZzd7 = zzfpVar3.zzd();
                            if (iZzg9 == 1701733238) {
                                Pair pairZzh = zzh(zzfpVar3, iZzd6, iZzg8);
                                if (pairZzh != null) {
                                    int iIntValue = ((Integer) pairZzh.first).intValue();
                                    zzaeVarZzb = zzaeVar == null ? null : zzaeVar.zzb(((zzajn) pairZzh.second).zzb);
                                    zzaisVar2.zza[i27] = (zzajn) pairZzh.second;
                                    iZzg9 = iIntValue;
                                } else {
                                    iZzg9 = 1701733238;
                                    zzaeVarZzb = zzaeVar;
                                }
                                zzfpVar3.zzK(iZzd7);
                            } else {
                                zzaeVarZzb = zzaeVar;
                            }
                            if (iZzg9 == 1831958048) {
                                int i31 = iZzg9;
                                str2 = "video/mpeg";
                                i4 = i31;
                            } else {
                                i4 = 1211250227;
                                if (iZzg9 == 1211250227) {
                                    str2 = "video/3gpp";
                                } else {
                                    i4 = iZzg9;
                                    str2 = null;
                                }
                            }
                            int i32 = iZzd7;
                            zzae zzaeVar2 = zzaeVarZzb;
                            float fZzp = 1.0f;
                            i27 = i27;
                            boolean z7 = false;
                            ByteBuffer byteBufferZzl = null;
                            String str10 = null;
                            byte[] bArr = null;
                            int iZzb = -1;
                            int iZza = -1;
                            zzaiq zzaiqVar = null;
                            int i33 = 8;
                            int i34 = 8;
                            int i35 = -1;
                            List listZzm = null;
                            int i36 = -1;
                            while (true) {
                                if (i32 - iZzd6 >= iZzg8) {
                                    bArrCopyOfRange = bArr;
                                    break;
                                }
                                zzfpVar3.zzK(i32);
                                int iZzd8 = zzfpVar3.zzd();
                                int iZzg10 = zzfpVar3.zzg();
                                if (iZzg10 == 0) {
                                    bArrCopyOfRange = bArr;
                                    if (zzfpVar3.zzd() - iZzd6 == iZzg8) {
                                        break;
                                    }
                                    i5 = 0;
                                } else {
                                    bArrCopyOfRange = bArr;
                                    i5 = iZzg10;
                                }
                                zzacy.zzb(i5 > 0, "childAtomSize must be positive");
                                int iZzg11 = zzfpVar3.zzg();
                                if (iZzg11 == 1635148611) {
                                    int i37 = iZzd8 + 8;
                                    zzacy.zzb(str2 == null, null);
                                    zzfpVar3.zzK(i37);
                                    zzabz zzabzVarZza = zzabz.zza(zzfpVar3);
                                    list = zzabzVarZza.zza;
                                    zzaisVar2.zzc = zzabzVarZza.zzb;
                                    if (z7) {
                                        f2 = fZzp;
                                        z6 = true;
                                    } else {
                                        f2 = zzabzVarZza.zzj;
                                        z6 = false;
                                    }
                                    str5 = zzabzVarZza.zzk;
                                    iZza = zzabzVarZza.zzg;
                                    i16 = zzabzVarZza.zzh;
                                    i17 = zzabzVarZza.zzi;
                                    z7 = z6;
                                    i18 = zzabzVarZza.zze;
                                    i19 = zzabzVarZza.zzf;
                                    str6 = "video/avc";
                                } else {
                                    if (iZzg11 == 1752589123) {
                                        int i38 = iZzd8 + 8;
                                        zzacy.zzb(str2 == null, null);
                                        zzfpVar3.zzK(i38);
                                        zzadl zzadlVarZza = zzadl.zza(zzfpVar3);
                                        list = zzadlVarZza.zza;
                                        zzaisVar2.zzc = zzadlVarZza.zzb;
                                        if (z7) {
                                            f2 = fZzp;
                                            z5 = true;
                                        } else {
                                            f2 = zzadlVarZza.zzh;
                                            z5 = false;
                                        }
                                        str5 = zzadlVarZza.zzi;
                                        iZza = zzadlVarZza.zze;
                                        i16 = zzadlVarZza.zzf;
                                        i17 = zzadlVarZza.zzg;
                                        z7 = z5;
                                        i18 = zzadlVarZza.zzc;
                                        i19 = zzadlVarZza.zzd;
                                        str6 = "video/hevc";
                                    } else if (iZzg11 == 1685480259 || iZzg11 == 1685485123) {
                                        i6 = i4;
                                        i7 = iZzq2;
                                        i8 = iZzq3;
                                        f = fZzp;
                                        str4 = str10;
                                        zzaisVar = zzaisVar2;
                                        zzacq zzacqVarZza = zzacq.zza(zzfpVar3);
                                        if (zzacqVarZza != null) {
                                            str2 = "video/dolby-vision";
                                            str10 = zzacqVarZza.zza;
                                            fZzp = f;
                                        } else {
                                            fZzp = f;
                                            str10 = str4;
                                        }
                                    } else if (iZzg11 == 1987076931) {
                                        zzacy.zzb(str2 == null, null);
                                        zzfpVar3.zzK(iZzd8 + 12);
                                        zzfpVar3.zzL(2);
                                        int iZzm = zzfpVar3.zzm();
                                        int i39 = iZzm >> 4;
                                        int i40 = iZzm & 1;
                                        int iZzm2 = zzfpVar3.zzm();
                                        int iZzm3 = zzfpVar3.zzm();
                                        iZza = zzt.zza(iZzm2);
                                        int i41 = 1 != i40 ? 2 : 1;
                                        int iZzb2 = zzt.zzb(iZzm3);
                                        i6 = i4;
                                        i35 = i41;
                                        i7 = iZzq2;
                                        i8 = iZzq3;
                                        i33 = i39;
                                        i34 = i33;
                                        str2 = i4 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                                        iZzb = iZzb2;
                                        zzaisVar = zzaisVar2;
                                    } else {
                                        i6 = i4;
                                        if (iZzg11 == 1635135811) {
                                            zzfpVar3.zzK(iZzd8 + 8);
                                            zzr zzrVar = new zzr();
                                            byte[] bArrZzM = zzfpVar3.zzM();
                                            zzfo zzfoVar = new zzfo(bArrZzM, bArrZzM.length);
                                            zzfoVar.zzk(zzfpVar3.zzd() * 8);
                                            zzfoVar.zzn(1);
                                            int iZzd9 = zzfoVar.zzd(3);
                                            zzfoVar.zzm(6);
                                            boolean zZzo2 = zzfoVar.zzo();
                                            boolean zZzo3 = zzfoVar.zzo();
                                            if (iZzd9 != 2) {
                                                i9 = 1;
                                                if (iZzd9 <= 2) {
                                                    if (true != zZzo2) {
                                                        i10 = 8;
                                                    } else {
                                                        i10 = 10;
                                                    }
                                                    zzrVar.zzf(i10);
                                                    zzrVar.zza(i10);
                                                }
                                            } else if (zZzo2) {
                                                int i42 = true != zZzo3 ? 10 : 12;
                                                zzrVar.zzf(i42);
                                                zzrVar.zza(i42);
                                                i9 = 1;
                                            } else {
                                                iZzd9 = 2;
                                                zZzo2 = false;
                                                i9 = 1;
                                                if (iZzd9 <= 2) {
                                                    if (true != zZzo2) {
                                                        i10 = 8;
                                                    } else {
                                                        i10 = 10;
                                                    }
                                                    zzrVar.zzf(i10);
                                                    zzrVar.zza(i10);
                                                }
                                            }
                                            zzfoVar.zzm(13);
                                            zzfoVar.zzl();
                                            int i43 = 4;
                                            int iZzd10 = zzfoVar.zzd(4);
                                            if (iZzd10 != i9) {
                                                zzff.zze("AtomParsers", "Unsupported obu_type: " + iZzd10);
                                                zztVarZzg = zzrVar.zzg();
                                            } else if (zzfoVar.zzo()) {
                                                zzff.zze("AtomParsers", "Unsupported obu_extension_flag");
                                                zztVarZzg = zzrVar.zzg();
                                            } else {
                                                boolean zZzo4 = zzfoVar.zzo();
                                                zzfoVar.zzl();
                                                if (!zZzo4 || zzfoVar.zzd(8) <= 127) {
                                                    int iZzd11 = zzfoVar.zzd(3);
                                                    zzfoVar.zzl();
                                                    if (zzfoVar.zzo()) {
                                                        zzff.zze("AtomParsers", "Unsupported reduced_still_picture_header");
                                                        zztVarZzg = zzrVar.zzg();
                                                    } else if (zzfoVar.zzo()) {
                                                        zzff.zze("AtomParsers", "Unsupported timing_info_present_flag");
                                                        zztVarZzg = zzrVar.zzg();
                                                    } else {
                                                        if (zzfoVar.zzo()) {
                                                            zzff.zze("AtomParsers", "Unsupported initial_display_delay_present_flag");
                                                            zztVarZzg = zzrVar.zzg();
                                                        } else {
                                                            int i44 = 5;
                                                            int iZzd12 = zzfoVar.zzd(5);
                                                            int i45 = 0;
                                                            while (i45 <= iZzd12) {
                                                                zzfoVar.zzm(12);
                                                                if (zzfoVar.zzd(i44) > 7) {
                                                                    zzfoVar.zzl();
                                                                }
                                                                i45++;
                                                                i44 = 5;
                                                                i43 = 4;
                                                            }
                                                            int i46 = i43;
                                                            int iZzd13 = zzfoVar.zzd(i46);
                                                            int iZzd14 = zzfoVar.zzd(i46);
                                                            zzfoVar.zzm(iZzd13 + 1);
                                                            zzfoVar.zzm(iZzd14 + 1);
                                                            if (zzfoVar.zzo()) {
                                                                zzfoVar.zzm(7);
                                                            }
                                                            zzfoVar.zzm(7);
                                                            boolean zZzo5 = zzfoVar.zzo();
                                                            if (zZzo5) {
                                                                zzfoVar.zzm(2);
                                                            }
                                                            if (zzfoVar.zzo()) {
                                                                i11 = 1;
                                                            } else {
                                                                i11 = 1;
                                                                if (zzfoVar.zzd(1) > 0) {
                                                                }
                                                                if (zZzo5) {
                                                                    i12 = 3;
                                                                    zzfoVar.zzm(3);
                                                                } else {
                                                                    i12 = 3;
                                                                }
                                                                zzfoVar.zzm(i12);
                                                                zZzo = zzfoVar.zzo();
                                                                if (iZzd11 == 2) {
                                                                    z4 = iZzd11 != 1;
                                                                    if (zzfoVar.zzo()) {
                                                                        iZzd = zzfoVar.zzd(8);
                                                                        iZzd2 = zzfoVar.zzd(8);
                                                                        iZzd3 = zzfoVar.zzd(8);
                                                                        if (z4) {
                                                                            i13 = 1;
                                                                        } else {
                                                                            i13 = 1;
                                                                            if (iZzd == 1) {
                                                                                i14 = 13;
                                                                                if (iZzd2 == 13) {
                                                                                    iZzd = 1;
                                                                                } else if (iZzd3 == 0) {
                                                                                    iZzd4 = 1;
                                                                                    iZzd = 1;
                                                                                } else {
                                                                                    iZzd = 1;
                                                                                    iZzd2 = 13;
                                                                                }
                                                                            }
                                                                            zzrVar.zzc(zzt.zza(iZzd));
                                                                            if (iZzd4 == i13) {
                                                                                i15 = 1;
                                                                            } else {
                                                                                i15 = 2;
                                                                            }
                                                                            zzrVar.zzb(i15);
                                                                            zzrVar.zzd(zzt.zzb(i14));
                                                                        }
                                                                        iZzd4 = zzfoVar.zzd(i13);
                                                                        i14 = iZzd2;
                                                                        zzrVar.zzc(zzt.zza(iZzd));
                                                                        if (iZzd4 == i13) {
                                                                            i15 = 1;
                                                                        } else {
                                                                            i15 = 2;
                                                                        }
                                                                        zzrVar.zzb(i15);
                                                                        zzrVar.zzd(zzt.zzb(i14));
                                                                    }
                                                                    zztVarZzg = zzrVar.zzg();
                                                                } else if (zZzo) {
                                                                    zzfoVar.zzl();
                                                                }
                                                                if (zzfoVar.zzo()) {
                                                                }
                                                                if (zzfoVar.zzo()) {
                                                                    iZzd = zzfoVar.zzd(8);
                                                                    iZzd2 = zzfoVar.zzd(8);
                                                                    iZzd3 = zzfoVar.zzd(8);
                                                                    if (z4) {
                                                                        i13 = 1;
                                                                        if (iZzd == 1) {
                                                                            i14 = 13;
                                                                            if (iZzd2 == 13) {
                                                                                iZzd = 1;
                                                                            } else if (iZzd3 == 0) {
                                                                                iZzd4 = 1;
                                                                                iZzd = 1;
                                                                            } else {
                                                                                iZzd = 1;
                                                                                iZzd2 = 13;
                                                                            }
                                                                        }
                                                                        zzrVar.zzc(zzt.zza(iZzd));
                                                                        if (iZzd4 == i13) {
                                                                            i15 = 1;
                                                                        } else {
                                                                            i15 = 2;
                                                                        }
                                                                        zzrVar.zzb(i15);
                                                                        zzrVar.zzd(zzt.zzb(i14));
                                                                    } else {
                                                                        i13 = 1;
                                                                    }
                                                                    iZzd4 = zzfoVar.zzd(i13);
                                                                    i14 = iZzd2;
                                                                    zzrVar.zzc(zzt.zza(iZzd));
                                                                    if (iZzd4 == i13) {
                                                                        i15 = 1;
                                                                    } else {
                                                                        i15 = 2;
                                                                    }
                                                                    zzrVar.zzb(i15);
                                                                    zzrVar.zzd(zzt.zzb(i14));
                                                                }
                                                                zztVarZzg = zzrVar.zzg();
                                                            }
                                                            if (!zzfoVar.zzo()) {
                                                                zzfoVar.zzm(i11);
                                                            }
                                                            if (zZzo5) {
                                                                i12 = 3;
                                                                zzfoVar.zzm(3);
                                                            } else {
                                                                i12 = 3;
                                                            }
                                                            zzfoVar.zzm(i12);
                                                            zZzo = zzfoVar.zzo();
                                                            if (iZzd11 == 2) {
                                                                if (iZzd11 != 1) {
                                                                }
                                                                if (zzfoVar.zzo()) {
                                                                    iZzd = zzfoVar.zzd(8);
                                                                    iZzd2 = zzfoVar.zzd(8);
                                                                    iZzd3 = zzfoVar.zzd(8);
                                                                    if (z4) {
                                                                        i13 = 1;
                                                                        if (iZzd == 1) {
                                                                            i14 = 13;
                                                                            if (iZzd2 == 13) {
                                                                                iZzd = 1;
                                                                            } else if (iZzd3 == 0) {
                                                                                iZzd4 = 1;
                                                                                iZzd = 1;
                                                                            } else {
                                                                                iZzd = 1;
                                                                                iZzd2 = 13;
                                                                            }
                                                                        }
                                                                        zzrVar.zzc(zzt.zza(iZzd));
                                                                        if (iZzd4 == i13) {
                                                                            i15 = 1;
                                                                        } else {
                                                                            i15 = 2;
                                                                        }
                                                                        zzrVar.zzb(i15);
                                                                        zzrVar.zzd(zzt.zzb(i14));
                                                                    } else {
                                                                        i13 = 1;
                                                                    }
                                                                    iZzd4 = zzfoVar.zzd(i13);
                                                                    i14 = iZzd2;
                                                                    zzrVar.zzc(zzt.zza(iZzd));
                                                                    if (iZzd4 == i13) {
                                                                        i15 = 1;
                                                                    } else {
                                                                        i15 = 2;
                                                                    }
                                                                    zzrVar.zzb(i15);
                                                                    zzrVar.zzd(zzt.zzb(i14));
                                                                }
                                                                zztVarZzg = zzrVar.zzg();
                                                            } else if (zZzo) {
                                                                zzfoVar.zzl();
                                                            }
                                                            if (zzfoVar.zzo()) {
                                                            }
                                                            if (zzfoVar.zzo()) {
                                                                iZzd = zzfoVar.zzd(8);
                                                                iZzd2 = zzfoVar.zzd(8);
                                                                iZzd3 = zzfoVar.zzd(8);
                                                                if (z4) {
                                                                    i13 = 1;
                                                                    if (iZzd == 1) {
                                                                        i14 = 13;
                                                                        if (iZzd2 == 13) {
                                                                            iZzd = 1;
                                                                        } else if (iZzd3 == 0) {
                                                                            iZzd4 = 1;
                                                                            iZzd = 1;
                                                                        } else {
                                                                            iZzd = 1;
                                                                            iZzd2 = 13;
                                                                        }
                                                                    }
                                                                    zzrVar.zzc(zzt.zza(iZzd));
                                                                    if (iZzd4 == i13) {
                                                                        i15 = 1;
                                                                    } else {
                                                                        i15 = 2;
                                                                    }
                                                                    zzrVar.zzb(i15);
                                                                    zzrVar.zzd(zzt.zzb(i14));
                                                                } else {
                                                                    i13 = 1;
                                                                }
                                                                iZzd4 = zzfoVar.zzd(i13);
                                                                i14 = iZzd2;
                                                                zzrVar.zzc(zzt.zza(iZzd));
                                                                if (iZzd4 == i13) {
                                                                    i15 = 1;
                                                                } else {
                                                                    i15 = 2;
                                                                }
                                                                zzrVar.zzb(i15);
                                                                zzrVar.zzd(zzt.zzb(i14));
                                                            }
                                                            zztVarZzg = zzrVar.zzg();
                                                        }
                                                        int i47 = zztVarZzg.zzf;
                                                        int i48 = zztVarZzg.zze;
                                                        iZza = zztVarZzg.zzd;
                                                        int i49 = zztVarZzg.zzi;
                                                        i34 = zztVarZzg.zzh;
                                                        i7 = iZzq2;
                                                        i8 = iZzq3;
                                                        i35 = i48;
                                                        i33 = i49;
                                                        zzaisVar = zzaisVar2;
                                                        iZzb = i47;
                                                        str2 = "video/av01";
                                                    }
                                                } else {
                                                    zzff.zze("AtomParsers", "Excessive obu_size");
                                                    zztVarZzg = zzrVar.zzg();
                                                }
                                            }
                                            i12 = 3;
                                            int i410 = zztVarZzg.zzf;
                                            int i411 = zztVarZzg.zze;
                                            iZza = zztVarZzg.zzd;
                                            int i412 = zztVarZzg.zzi;
                                            i34 = zztVarZzg.zzh;
                                            i7 = iZzq2;
                                            i8 = iZzq3;
                                            i35 = i411;
                                            i33 = i412;
                                            zzaisVar = zzaisVar2;
                                            iZzb = i410;
                                            str2 = "video/av01";
                                        } else if (iZzg11 == 1668050025) {
                                            if (byteBufferZzl == null) {
                                                byteBufferZzl = zzl();
                                            }
                                            byteBufferZzl.position(21);
                                            byteBufferZzl.putShort(zzfpVar3.zzD());
                                            byteBufferZzl.putShort(zzfpVar3.zzD());
                                            i7 = iZzq2;
                                            i8 = iZzq3;
                                            zzaisVar = zzaisVar2;
                                        } else {
                                            if (iZzg11 == 1835295606) {
                                                if (byteBufferZzl == null) {
                                                    byteBufferZzl = zzl();
                                                }
                                                short sZzD = zzfpVar3.zzD();
                                                short sZzD2 = zzfpVar3.zzD();
                                                short sZzD3 = zzfpVar3.zzD();
                                                short sZzD4 = zzfpVar3.zzD();
                                                zzaisVar = zzaisVar2;
                                                short sZzD5 = zzfpVar3.zzD();
                                                f = fZzp;
                                                short sZzD6 = zzfpVar3.zzD();
                                                i8 = iZzq3;
                                                short sZzD7 = zzfpVar3.zzD();
                                                i7 = iZzq2;
                                                short sZzD8 = zzfpVar3.zzD();
                                                long jZzu3 = zzfpVar3.zzu();
                                                long jZzu4 = zzfpVar3.zzu();
                                                str4 = str10;
                                                byteBufferZzl.position(1);
                                                byteBufferZzl.putShort(sZzD5);
                                                byteBufferZzl.putShort(sZzD6);
                                                byteBufferZzl.putShort(sZzD);
                                                byteBufferZzl.putShort(sZzD2);
                                                byteBufferZzl.putShort(sZzD3);
                                                byteBufferZzl.putShort(sZzD4);
                                                byteBufferZzl.putShort(sZzD7);
                                                byteBufferZzl.putShort(sZzD8);
                                                byteBufferZzl.putShort((short) (jZzu3 / WorkRequest.MIN_BACKOFF_MILLIS));
                                                byteBufferZzl.putShort((short) (jZzu4 / WorkRequest.MIN_BACKOFF_MILLIS));
                                            } else {
                                                i7 = iZzq2;
                                                i8 = iZzq3;
                                                f = fZzp;
                                                str4 = str10;
                                                zzaisVar = zzaisVar2;
                                                if (iZzg11 == 1681012275) {
                                                    zzacy.zzb(str2 == null, null);
                                                    str2 = "video/3gpp";
                                                } else if (iZzg11 == 1702061171) {
                                                    zzacy.zzb(str2 == null, null);
                                                    zzaiq zzaiqVarZzj = zzj(zzfpVar3, iZzd8);
                                                    str2 = zzaiqVarZzj.zza;
                                                    byte[] bArr2 = zzaiqVarZzj.zzb;
                                                    if (bArr2 != null) {
                                                        zzaiqVar = zzaiqVarZzj;
                                                        listZzm = zzgaa.zzm(bArr2);
                                                    } else {
                                                        zzaiqVar = zzaiqVarZzj;
                                                    }
                                                } else if (iZzg11 == 1885434736) {
                                                    zzfpVar3.zzK(iZzd8 + 8);
                                                    fZzp = zzfpVar3.zzp() / zzfpVar3.zzp();
                                                    str10 = str4;
                                                    z7 = true;
                                                } else if (iZzg11 == 1937126244) {
                                                    int i50 = iZzd8 + 8;
                                                    while (true) {
                                                        if (i50 - iZzd8 < i5) {
                                                            zzfpVar3.zzK(i50);
                                                            int iZzg12 = zzfpVar3.zzg() + i50;
                                                            if (zzfpVar3.zzg() == 1886547818) {
                                                                bArrCopyOfRange = Arrays.copyOfRange(zzfpVar3.zzM(), i50, iZzg12);
                                                            } else {
                                                                i50 = iZzg12;
                                                            }
                                                        } else {
                                                            fZzp = f;
                                                            str10 = str4;
                                                            bArrCopyOfRange = null;
                                                        }
                                                    }
                                                } else {
                                                    if (iZzg11 == 1936995172) {
                                                        int iZzm4 = zzfpVar3.zzm();
                                                        zzfpVar3.zzL(3);
                                                        if (iZzm4 == 0) {
                                                            int iZzm5 = zzfpVar3.zzm();
                                                            if (iZzm5 == 0) {
                                                                i36 = 0;
                                                            } else if (iZzm5 == 1) {
                                                                fZzp = f;
                                                                str10 = str4;
                                                                i36 = 1;
                                                            } else if (iZzm5 == 2) {
                                                                fZzp = f;
                                                                str10 = str4;
                                                                i36 = 2;
                                                            } else if (iZzm5 == 3) {
                                                                i36 = 3;
                                                            }
                                                            fZzp = f;
                                                            str10 = str4;
                                                        }
                                                    } else {
                                                        if (iZzg11 == 1668246642) {
                                                            if (iZza == -1) {
                                                                if (iZzb == -1) {
                                                                    int iZzg13 = zzfpVar3.zzg();
                                                                    if (iZzg13 == 1852009592 || iZzg13 == 1852009571) {
                                                                        int iZzq4 = zzfpVar3.zzq();
                                                                        int iZzq5 = zzfpVar3.zzq();
                                                                        zzfpVar3.zzL(2);
                                                                        if (i5 != 19) {
                                                                            z3 = false;
                                                                        } else if ((zzfpVar3.zzm() & 128) != 0) {
                                                                            i5 = 19;
                                                                            z3 = true;
                                                                        } else {
                                                                            i5 = 19;
                                                                            z3 = false;
                                                                        }
                                                                        int iZza2 = zzt.zza(iZzq4);
                                                                        int i51 = true != z3 ? 2 : 1;
                                                                        iZza = iZza2;
                                                                        iZzb = zzt.zzb(iZzq5);
                                                                        i35 = i51;
                                                                    } else {
                                                                        zzff.zzf("AtomParsers", "Unsupported color type: ".concat(zzaio.zzf(iZzg13)));
                                                                        iZzb = -1;
                                                                        iZza = -1;
                                                                    }
                                                                } else {
                                                                    iZza = -1;
                                                                }
                                                            }
                                                        }
                                                        fZzp = f;
                                                        str10 = str4;
                                                    }
                                                    fZzp = f;
                                                    str10 = str4;
                                                }
                                            }
                                            fZzp = f;
                                            str10 = str4;
                                        }
                                    }
                                    i32 += i5;
                                    iZzd6 = iZzd6;
                                    bArr = bArrCopyOfRange;
                                    iZzg8 = iZzg8;
                                    i4 = i6;
                                    zzaisVar2 = zzaisVar;
                                    iZzq3 = i8;
                                    iZzq2 = i7;
                                }
                                i6 = i4;
                                i7 = iZzq2;
                                i8 = iZzq3;
                                i34 = i18;
                                listZzm = list;
                                fZzp = f2;
                                str10 = str5;
                                i35 = i16;
                                zzaisVar = zzaisVar2;
                                iZzb = i17;
                                String str11 = str6;
                                i33 = i19;
                                str2 = str11;
                                i32 += i5;
                                iZzd6 = iZzd6;
                                bArr = bArrCopyOfRange;
                                iZzg8 = iZzg8;
                                i4 = i6;
                                zzaisVar2 = zzaisVar;
                                iZzq3 = i8;
                                iZzq2 = i7;
                            }
                            iZzd6 = iZzd6;
                            zzais zzaisVar3 = zzaisVar2;
                            iZzg8 = iZzg8;
                            if (str2 == null) {
                                i26 = i29;
                                i25 = i30;
                                zzaisVar2 = zzaisVar3;
                            } else {
                                zzak zzakVar = new zzak();
                                i25 = i30;
                                zzakVar.zzJ(i25);
                                zzakVar.zzW(str2);
                                zzakVar.zzz(str3);
                                zzakVar.zzab(iZzq2);
                                zzakVar.zzI(iZzq3);
                                zzakVar.zzS(fZzp);
                                i26 = i29;
                                zzakVar.zzV(i26);
                                zzakVar.zzT(bArrCopyOfRange);
                                zzakVar.zzZ(i36);
                                zzakVar.zzL(listZzm);
                                zzakVar.zzE(zzaeVar2);
                                zzr zzrVar2 = new zzr();
                                zzrVar2.zzc(iZza);
                                zzrVar2.zzb(i35);
                                zzrVar2.zzd(iZzb);
                                if (byteBufferZzl != null) {
                                    str3 = str10;
                                    bArrArray = byteBufferZzl.array();
                                } else {
                                    str3 = str10;
                                    bArrArray = null;
                                }
                                zzrVar2.zze(bArrArray);
                                zzrVar2.zzf(i34);
                                zzrVar2.zza(i33);
                                zzakVar.zzA(zzrVar2.zzg());
                                if (zzaiqVar != null) {
                                    zzakVar.zzx(zzgcu.zzc(zzaiqVar.zzc));
                                    zzakVar.zzR(zzgcu.zzc(zzaiqVar.zzd));
                                }
                                zzaisVar2 = zzaisVar3;
                                zzaisVar2.zzb = zzakVar.zzac();
                            }
                        } else if (iZzg9 == 1836069985 || iZzg9 == 1701733217 || iZzg9 == 1633889587 || iZzg9 == 1700998451 || iZzg9 == 1633889588 || iZzg9 == 1835823201 || iZzg9 == 1685353315 || iZzg9 == 1685353317 || iZzg9 == 1685353320 || iZzg9 == 1685353324 || iZzg9 == 1685353336 || iZzg9 == 1935764850 || iZzg9 == 1935767394 || iZzg9 == 1819304813 || iZzg9 == 1936684916 || iZzg9 == 1953984371 || iZzg9 == 778924082 || iZzg9 == 778924083 || iZzg9 == 1835557169 || iZzg9 == 1835560241 || iZzg9 == 1634492771 || iZzg9 == 1634492791 || iZzg9 == 1970037111 || iZzg9 == 1332770163 || iZzg9 == 1716281667) {
                            i28 = i28;
                            str = str9;
                            i = i;
                            pairCreate2 = pairCreate2;
                            j5 = j5;
                            zzm(zzfpVar3, iZzg9, iZzd6, iZzg8, i25, str, z2, zzaeVar, zzaisVar2, i27);
                            i27 = i27;
                            iZzd6 = iZzd6;
                            zzaisVar2 = zzaisVar2;
                            iZzg8 = iZzg8;
                            i26 = i26;
                            i25 = i25;
                        } else if (iZzg9 == 1414810956 || iZzg9 == 1954034535 || iZzg9 == 2004251764 || iZzg9 == 1937010800 || iZzg9 == 1664495672) {
                            zzfpVar3.zzK(iZzd6 + 16);
                            long j6 = Long.MAX_VALUE;
                            if (iZzg9 == 1414810956) {
                                str8 = "application/ttml+xml";
                            } else {
                                if (iZzg9 == 1954034535) {
                                    int i52 = iZzg8 - 16;
                                    byte[] bArr3 = new byte[i52];
                                    zzfpVar3.zzG(bArr3, 0, i52);
                                    zzgaaVarZzm = zzgaa.zzm(bArr3);
                                    str7 = "application/x-quicktime-tx3g";
                                    j3 = Long.MAX_VALUE;
                                } else if (iZzg9 == 2004251764) {
                                    str8 = "application/x-mp4-vtt";
                                } else {
                                    if (iZzg9 == 1937010800) {
                                        j6 = 0;
                                        str8 = "application/ttml+xml";
                                    } else {
                                        zzaisVar2.zzd = 1;
                                        str7 = "application/x-mp4-cea-608";
                                    }
                                    j3 = j6;
                                    zzgaaVarZzm = null;
                                }
                                zzak zzakVar2 = new zzak();
                                zzakVar2.zzJ(i25);
                                zzakVar2.zzW(str7);
                                zzakVar2.zzN(str9);
                                zzakVar2.zzaa(j3);
                                zzakVar2.zzL(zzgaaVarZzm);
                                zzaisVar2.zzb = zzakVar2.zzac();
                                str = str9;
                            }
                            str7 = str8;
                            j3 = j6;
                            zzgaaVarZzm = null;
                            zzak zzakVar3 = new zzak();
                            zzakVar3.zzJ(i25);
                            zzakVar3.zzW(str7);
                            zzakVar3.zzN(str9);
                            zzakVar3.zzaa(j3);
                            zzakVar3.zzL(zzgaaVarZzm);
                            zzaisVar2.zzb = zzakVar3.zzac();
                            str = str9;
                        } else {
                            if (iZzg9 == 1835365492) {
                                zzfpVar3.zzK(iZzd6 + 16);
                                zzfpVar3.zzx((char) 0);
                                String strZzx = zzfpVar3.zzx((char) 0);
                                if (strZzx != null) {
                                    zzak zzakVar4 = new zzak();
                                    zzakVar4.zzJ(i25);
                                    zzakVar4.zzW(strZzx);
                                    zzaisVar2.zzb = zzakVar4.zzac();
                                }
                            } else if (iZzg9 == 1667329389) {
                                zzak zzakVar5 = new zzak();
                                zzakVar5.zzJ(i25);
                                zzakVar5.zzW("application/x-camera-motion");
                                zzaisVar2.zzb = zzakVar5.zzac();
                            }
                            str = str9;
                        }
                        zzfpVar3.zzK(iZzd6 + iZzg8);
                        i27++;
                        zzaeVar = zzaeVar;
                        i26 = i26;
                        i25 = i25;
                        zzaisVar2 = zzaisVar2;
                        iZzg7 = i28;
                        i = i;
                        zzaivVar = zzaivVar2;
                        j5 = j5;
                        str9 = str;
                        zzaimVar3 = zzaimVar4;
                        pairCreate2 = pairCreate2;
                    }
                    int i53 = i;
                    Pair pair = pairCreate2;
                    long j7 = j5;
                    zzaiv zzaivVar3 = zzaivVar;
                    zzais zzaisVar4 = zzaisVar2;
                    zzaim zzaimVar5 = zzaimVar3;
                    if (z) {
                        zzaimVar2 = zzaimVar5;
                    } else {
                        zzaimVar2 = zzaimVar5;
                        zzaim zzaimVarZza4 = zzaimVar2.zza(1701082227);
                        if (zzaimVarZza4 != null) {
                            zzain zzainVarZzb6 = zzaimVarZza4.zzb(1701606260);
                            if (zzainVarZzb6 == null) {
                                pairCreate = null;
                            } else {
                                zzfp zzfpVar4 = zzainVarZzb6.zza;
                                zzfpVar4.zzK(8);
                                int iZze3 = zzaio.zze(zzfpVar4.zzg());
                                int iZzp = zzfpVar4.zzp();
                                long[] jArr3 = new long[iZzp];
                                long[] jArr4 = new long[iZzp];
                                for (int i54 = 0; i54 < iZzp; i54++) {
                                    jArr3[i54] = iZze3 == 1 ? zzfpVar4.zzv() : zzfpVar4.zzu();
                                    jArr4[i54] = iZze3 == 1 ? zzfpVar4.zzt() : zzfpVar4.zzg();
                                    if (zzfpVar4.zzD() != 1) {
                                        throw new IllegalArgumentException("Unsupported media rate.");
                                    }
                                    zzfpVar4.zzL(2);
                                }
                                pairCreate = Pair.create(jArr3, jArr4);
                            }
                            if (pairCreate != null) {
                                jArr = (long[]) pairCreate.first;
                                jArr2 = (long[]) pairCreate.second;
                            }
                        }
                        if (zzaisVar4.zzb == null) {
                            zzajmVar = null;
                        } else {
                            zzajmVar = new zzajm(zzaivVar3.zza, i53, ((Long) pair.first).longValue(), j7, jZzs, zzaisVar4.zzb, zzaisVar4.zzd, zzaisVar4.zza, zzaisVar4.zzc, jArr, jArr2);
                        }
                    }
                    jArr = null;
                    jArr2 = null;
                    if (zzaisVar4.zzb == null) {
                        zzajmVar = null;
                    } else {
                        zzajmVar = new zzajm(zzaivVar3.zza, i53, ((Long) pair.first).longValue(), j7, jZzs, zzaisVar4.zzb, zzaisVar4.zzd, zzaisVar4.zza, zzaisVar4.zzc, jArr, jArr2);
                    }
                }
                zzajm zzajmVar2 = (zzajm) zzfwsVar.apply(zzajmVar);
                if (zzajmVar2 != null) {
                    zzaim zzaimVarZza5 = zzaimVar2.zza(1835297121);
                    zzaimVarZza5.getClass();
                    zzaim zzaimVarZza6 = zzaimVarZza5.zza(1835626086);
                    zzaimVarZza6.getClass();
                    zzaim zzaimVarZza7 = zzaimVarZza6.zza(1937007212);
                    zzaimVarZza7.getClass();
                    zzajp zzajpVarZzk = zzk(zzajmVar2, zzaimVarZza7, zzadkVar);
                    arrayList2 = arrayList;
                    arrayList2.add(zzajpVarZzk);
                } else {
                    arrayList2 = arrayList;
                }
            }
            i20 = i3 + 1;
            arrayList3 = arrayList2;
        }
        return arrayList3;
    }

    public static void zze(zzfp zzfpVar) {
        int iZzd = zzfpVar.zzd();
        zzfpVar.zzL(4);
        if (zzfpVar.zzg() != 1751411826) {
            iZzd += 4;
        }
        zzfpVar.zzK(iZzd);
    }

    private static int zzf(zzfp zzfpVar) {
        int iZzm = zzfpVar.zzm();
        int i = iZzm & WorkQueueKt.MASK;
        while ((iZzm & 128) == 128) {
            iZzm = zzfpVar.zzm();
            i = (i << 7) | (iZzm & WorkQueueKt.MASK);
        }
        return i;
    }

    private static int zzg(zzfp zzfpVar) {
        zzfpVar.zzK(16);
        return zzfpVar.zzg();
    }

    private static Pair zzh(zzfp zzfpVar, int i, int i2) throws zzcc {
        zzajn zzajnVar;
        Pair pairCreate;
        int i3;
        int i4;
        byte[] bArr;
        int iZzd = zzfpVar.zzd();
        while (iZzd - i < i2) {
            zzfpVar.zzK(iZzd);
            int iZzg = zzfpVar.zzg();
            zzacy.zzb(iZzg > 0, "childAtomSize must be positive");
            if (zzfpVar.zzg() == 1936289382) {
                int i5 = iZzd + 8;
                int i6 = 0;
                int i7 = -1;
                String strZzA = null;
                Integer numValueOf = null;
                while (i5 - iZzd < iZzg) {
                    zzfpVar.zzK(i5);
                    int iZzg2 = zzfpVar.zzg();
                    int iZzg3 = zzfpVar.zzg();
                    if (iZzg3 == 1718775137) {
                        numValueOf = Integer.valueOf(zzfpVar.zzg());
                    } else if (iZzg3 == 1935894637) {
                        zzfpVar.zzL(4);
                        strZzA = zzfpVar.zzA(4, zzfwq.zzc);
                    } else if (iZzg3 == 1935894633) {
                        i7 = i5;
                        i6 = iZzg2;
                    }
                    i5 += iZzg2;
                }
                if ("cenc".equals(strZzA) || "cbc1".equals(strZzA) || "cens".equals(strZzA) || "cbcs".equals(strZzA)) {
                    zzacy.zzb(numValueOf != null, "frma atom is mandatory");
                    zzacy.zzb(i7 != -1, "schi atom is mandatory");
                    int i8 = i7 + 8;
                    while (true) {
                        if (i8 - i7 >= i6) {
                            zzajnVar = null;
                            break;
                        }
                        zzfpVar.zzK(i8);
                        int iZzg4 = zzfpVar.zzg();
                        if (zzfpVar.zzg() == 1952804451) {
                            int iZze = zzaio.zze(zzfpVar.zzg());
                            zzfpVar.zzL(1);
                            if (iZze == 0) {
                                zzfpVar.zzL(1);
                                i3 = 0;
                                i4 = 0;
                            } else {
                                int iZzm = zzfpVar.zzm();
                                int i9 = (iZzm & 240) >> 4;
                                i3 = iZzm & 15;
                                i4 = i9;
                            }
                            boolean z = zzfpVar.zzm() == 1;
                            int iZzm2 = zzfpVar.zzm();
                            byte[] bArr2 = new byte[16];
                            zzfpVar.zzG(bArr2, 0, 16);
                            if (z && iZzm2 == 0) {
                                int iZzm3 = zzfpVar.zzm();
                                byte[] bArr3 = new byte[iZzm3];
                                zzfpVar.zzG(bArr3, 0, iZzm3);
                                bArr = bArr3;
                            } else {
                                bArr = null;
                            }
                            zzajnVar = new zzajn(z, strZzA, iZzm2, bArr2, i4, i3, bArr);
                            break;
                        }
                        i8 += iZzg4;
                    }
                    zzacy.zzb(zzajnVar != null, "tenc atom is mandatory");
                    int i10 = zzfy.zza;
                    pairCreate = Pair.create(numValueOf, zzajnVar);
                } else {
                    pairCreate = null;
                }
                if (pairCreate != null) {
                    return pairCreate;
                }
            }
            iZzd += iZzg;
        }
        return null;
    }

    private static zzby zzi(zzfp zzfpVar) {
        short sZzD = zzfpVar.zzD();
        zzfpVar.zzL(2);
        String strZzA = zzfpVar.zzA(sZzD, zzfwq.zzc);
        int iMax = Math.max(strZzA.lastIndexOf(43), strZzA.lastIndexOf(45));
        try {
            return new zzby(-9223372036854775807L, new zzgf(Float.parseFloat(strZzA.substring(0, iMax)), Float.parseFloat(strZzA.substring(iMax, strZzA.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static zzaiq zzj(zzfp zzfpVar, int i) {
        zzfpVar.zzK(i + 12);
        zzfpVar.zzL(1);
        zzf(zzfpVar);
        zzfpVar.zzL(2);
        int iZzm = zzfpVar.zzm();
        if ((iZzm & 128) != 0) {
            zzfpVar.zzL(2);
        }
        if ((iZzm & 64) != 0) {
            zzfpVar.zzL(zzfpVar.zzm());
        }
        if ((iZzm & 32) != 0) {
            zzfpVar.zzL(2);
        }
        zzfpVar.zzL(1);
        zzf(zzfpVar);
        String strZzd = zzcb.zzd(zzfpVar.zzm());
        if ("audio/mpeg".equals(strZzd) || "audio/vnd.dts".equals(strZzd) || "audio/vnd.dts.hd".equals(strZzd)) {
            return new zzaiq(strZzd, null, -1L, -1L);
        }
        zzfpVar.zzL(4);
        long jZzu = zzfpVar.zzu();
        long jZzu2 = zzfpVar.zzu();
        zzfpVar.zzL(1);
        int iZzf = zzf(zzfpVar);
        byte[] bArr = new byte[iZzf];
        zzfpVar.zzG(bArr, 0, iZzf);
        return new zzaiq(strZzd, bArr, jZzu2 <= 0 ? -1L : jZzu2, jZzu > 0 ? jZzu : -1L);
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0271 A[DONT_INVERT, LOOP:12: B:103:0x0271->B:107:0x027b, LOOP_START, PHI: r16
  0x0271: PHI (r16v6 int) = (r16v2 int), (r16v7 int) binds: [B:102:0x026f, B:107:0x027b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:104:0x0273  */
    /* JADX WARN: Code duplicated, block: B:107:0x027b A[LOOP:12: B:103:0x0271->B:107:0x027b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:108:0x0281 A[EDGE_INSN: B:108:0x0281->B:109:0x0282 BREAK  A[LOOP:12: B:103:0x0271->B:107:0x027b]] */
    /* JADX WARN: Code duplicated, block: B:110:0x0284 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:111:0x0286 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:112:0x0288 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:113:0x028a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:114:0x028c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:115:0x028e  */
    /* JADX WARN: Code duplicated, block: B:116:0x0299  */
    /* JADX WARN: Code duplicated, block: B:117:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:118:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:119:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:122:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:124:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:127:0x0319  */
    /* JADX WARN: Code duplicated, block: B:128:0x031c  */
    /* JADX WARN: Code duplicated, block: B:133:0x0341  */
    /* JADX WARN: Code duplicated, block: B:135:0x0350  */
    /* JADX WARN: Code duplicated, block: B:162:0x040d  */
    /* JADX WARN: Code duplicated, block: B:165:0x0414  */
    /* JADX WARN: Code duplicated, block: B:167:0x041d  */
    /* JADX WARN: Code duplicated, block: B:170:0x0428 A[LOOP:4: B:168:0x0425->B:170:0x0428, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:173:0x0457  */
    /* JADX WARN: Code duplicated, block: B:176:0x045d  */
    /* JADX WARN: Code duplicated, block: B:177:0x045f  */
    /* JADX WARN: Code duplicated, block: B:181:0x0474  */
    /* JADX WARN: Code duplicated, block: B:183:0x047e  */
    /* JADX WARN: Code duplicated, block: B:191:0x04ba  */
    /* JADX WARN: Code duplicated, block: B:192:0x04bc  */
    /* JADX WARN: Code duplicated, block: B:194:0x04c3  */
    /* JADX WARN: Code duplicated, block: B:198:0x04e1  */
    /* JADX WARN: Code duplicated, block: B:199:0x04e3  */
    /* JADX WARN: Code duplicated, block: B:202:0x04e8  */
    /* JADX WARN: Code duplicated, block: B:203:0x04eb  */
    /* JADX WARN: Code duplicated, block: B:205:0x04ee  */
    /* JADX WARN: Code duplicated, block: B:206:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:209:0x04f6  */
    /* JADX WARN: Code duplicated, block: B:210:0x04f8  */
    /* JADX WARN: Code duplicated, block: B:212:0x04fc  */
    /* JADX WARN: Code duplicated, block: B:213:0x04ff  */
    /* JADX WARN: Code duplicated, block: B:217:0x050c  */
    /* JADX WARN: Code duplicated, block: B:219:0x051a  */
    /* JADX WARN: Code duplicated, block: B:220:0x052a  */
    /* JADX WARN: Code duplicated, block: B:223:0x0532  */
    /* JADX WARN: Code duplicated, block: B:225:0x0563  */
    /* JADX WARN: Code duplicated, block: B:226:0x056b  */
    /* JADX WARN: Code duplicated, block: B:243:0x04d8 A[EDGE_INSN: B:243:0x04d8->B:196:0x04d8 BREAK  A[LOOP:5: B:179:0x046d->B:195:0x04cc], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:253:0x01bf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:254:0x025f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:256:0x0241 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:258:0x01b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:259:0x01ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:261:0x01ef A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:262:0x0281 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:263:0x0279 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x0173 A[PHI: r9
  0x0173: PHI (r9v4 int) = (r9v3 int), (r9v3 int), (r9v35 int), (r9v3 int) binds: [B:36:0x00cf, B:43:0x00e9, B:60:0x0172, B:42:0x00e7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:64:0x018e  */
    /* JADX WARN: Code duplicated, block: B:66:0x0192  */
    /* JADX WARN: Code duplicated, block: B:68:0x0198 A[LOOP:10: B:65:0x0190->B:68:0x0198, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:73:0x01db A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:75:0x01e0 A[ADDED_TO_REGION, LOOP:11: B:75:0x01e0->B:77:0x01e4, LOOP_START, PHI: r16 r23 r25
  0x01e0: PHI (r16v8 int) = (r16v2 int), (r16v9 int) binds: [B:73:0x01db, B:77:0x01e4] A[DONT_GENERATE, DONT_INLINE]
  0x01e0: PHI (r23v2 int) = (r23v1 int), (r23v6 int) binds: [B:73:0x01db, B:77:0x01e4] A[DONT_GENERATE, DONT_INLINE]
  0x01e0: PHI (r25v2 int) = (r25v1 int), (r25v3 int) binds: [B:73:0x01db, B:77:0x01e4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:76:0x01e2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x01e4 A[LOOP:11: B:75:0x01e0->B:77:0x01e4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:83:0x0203  */
    /* JADX WARN: Code duplicated, block: B:84:0x0206  */
    /* JADX WARN: Code duplicated, block: B:87:0x020f  */
    /* JADX WARN: Code duplicated, block: B:88:0x0211  */
    /* JADX WARN: Code duplicated, block: B:91:0x0216  */
    /* JADX WARN: Code duplicated, block: B:93:0x021d  */
    /* JADX WARN: Code duplicated, block: B:96:0x0232 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:97:0x0234  */
    /* JADX WARN: Code duplicated, block: B:98:0x0240  */
    private static zzajp zzk(zzajm zzajmVar, zzaim zzaimVar, zzadk zzadkVar) throws zzcc {
        zzair zzaiuVar;
        boolean z;
        int iZzp;
        int iZzp2;
        int iZzp3;
        int iZza;
        long[] jArrCopyOf;
        int[] iArrCopyOf;
        long[] jArrCopyOf2;
        int[] iArrCopyOf2;
        int i;
        int i2;
        int i3;
        int iZzp4;
        int iZzg;
        int i4;
        long j;
        long j2;
        boolean z2;
        int i5;
        int i6;
        int i7;
        int i8;
        long[] jArr;
        int[] iArr;
        int i9;
        int[] iArr2;
        int i10;
        long j3;
        String str;
        boolean zZza;
        int i11;
        int iZzc;
        int i12;
        int i13;
        int iZzp5;
        long jZzs;
        long[] jArr2;
        int i14;
        long[] jArr3;
        int length;
        boolean z3;
        long[] jArr4;
        int[] iArr3;
        int[] iArr4;
        int i15;
        boolean z4;
        int i16;
        int i17;
        long[] jArr5;
        int i18;
        int[] iArr5;
        int i19;
        int i20;
        boolean z5;
        boolean z6;
        long[] jArr6;
        int[] iArr6;
        int i21;
        int[] iArr7;
        long[] jArr7;
        int i22;
        int i23;
        long j4;
        long j5;
        int i24;
        int i25;
        int[] iArr8;
        long jZzs2;
        long j6;
        boolean z7;
        int i26;
        int i27;
        int i28;
        int i29;
        boolean z8;
        long j7;
        int i30;
        int length2;
        zzain zzainVarZzb = zzaimVar.zzb(1937011578);
        if (zzainVarZzb != null) {
            zzaiuVar = new zzait(zzainVarZzb, zzajmVar.zzf);
        } else {
            zzain zzainVarZzb2 = zzaimVar.zzb(1937013298);
            if (zzainVarZzb2 == null) {
                throw zzcc.zza("Track has no sample table size information", null);
            }
            zzaiuVar = new zzaiu(zzainVarZzb2);
        }
        int iZzb = zzaiuVar.zzb();
        if (iZzb == 0) {
            return new zzajp(zzajmVar, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        zzain zzainVarZzb3 = zzaimVar.zzb(1937007471);
        if (zzainVarZzb3 == null) {
            zzainVarZzb3 = zzaimVar.zzb(1668232756);
            zzainVarZzb3.getClass();
            z = true;
        } else {
            z = false;
        }
        zzain zzainVarZzb4 = zzaimVar.zzb(1937011555);
        zzainVarZzb4.getClass();
        zzain zzainVarZzb5 = zzaimVar.zzb(1937011827);
        zzainVarZzb5.getClass();
        zzain zzainVarZzb6 = zzaimVar.zzb(1937011571);
        zzfp zzfpVar = zzainVarZzb6 != null ? zzainVarZzb6.zza : null;
        zzain zzainVarZzb7 = zzaimVar.zzb(1668576371);
        zzfp zzfpVar2 = zzainVarZzb7 != null ? zzainVarZzb7.zza : null;
        zzfp zzfpVar3 = zzainVarZzb5.zza;
        zzaip zzaipVar = new zzaip(zzainVarZzb4.zza, zzainVarZzb3.zza, z);
        zzfpVar3.zzK(12);
        int iZzp6 = zzfpVar3.zzp() - 1;
        int iZzp7 = zzfpVar3.zzp();
        int iZzp8 = zzfpVar3.zzp();
        if (zzfpVar2 != null) {
            zzfpVar2.zzK(12);
            iZzp = zzfpVar2.zzp();
        } else {
            iZzp = 0;
        }
        if (zzfpVar != null) {
            zzfpVar.zzK(12);
            iZzp2 = zzfpVar.zzp();
            if (iZzp2 > 0) {
                iZzp3 = zzfpVar.zzp() - 1;
            } else {
                zzfpVar = null;
            }
            iZza = zzaiuVar.zza();
            String str2 = zzajmVar.zzf.zzm;
            if (iZza != -1 || ((!"audio/raw".equals(str2) && !"audio/g711-mlaw".equals(str2) && !"audio/g711-alaw".equals(str2)) || iZzp6 != 0)) {
                jArrCopyOf = new long[iZzb];
                iArrCopyOf = new int[iZzb];
                jArrCopyOf2 = new long[iZzb];
                iArrCopyOf2 = new int[iZzb];
                i = iZzp6;
                i2 = 0;
                i3 = 0;
                iZzp4 = 0;
                iZzg = 0;
                i4 = 0;
                j = 0;
                j2 = 0;
                while (true) {
                    if (i2 < iZzb) {
                        iZzp7 = iZzp7;
                        break;
                    }
                    zZza = true;
                    while (true) {
                        if (i3 != 0) {
                            i11 = i3;
                            break;
                        }
                        zZza = zzaipVar.zza();
                        if (zZza) {
                            i11 = 0;
                            break;
                        }
                        int i31 = iZzp7;
                        long j8 = zzaipVar.zzd;
                        i3 = zzaipVar.zzc;
                        j = j8;
                        iZzp7 = i31;
                        iZzp8 = iZzp8;
                        iZzb = iZzb;
                    }
                    if (!zZza) {
                        zzff.zzf("AtomParsers", "Unexpected end of chunk data");
                        jArrCopyOf = Arrays.copyOf(jArrCopyOf, i2);
                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i2);
                        jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i2);
                        iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i2);
                        iZzb = i2;
                        break;
                    }
                    if (zzfpVar2 != null) {
                        while (iZzp4 == 0) {
                            if (iZzp > 0) {
                                iZzp4 = 0;
                                break;
                            }
                            iZzp--;
                            iZzp4 = zzfpVar2.zzp();
                            iZzg = zzfpVar2.zzg();
                        }
                        iZzp4--;
                    }
                    int i32 = iZzg;
                    jArrCopyOf[i2] = j;
                    iZzc = zzaiuVar.zzc();
                    iArrCopyOf[i2] = iZzc;
                    i12 = i4;
                    if (iZzc > i12) {
                        i4 = iZzc;
                    } else {
                        i4 = i12;
                    }
                    jArrCopyOf2[i2] = j2 + ((long) i32);
                    if (zzfpVar == null) {
                        i13 = 1;
                    } else {
                        i13 = 0;
                    }
                    iArrCopyOf2[i2] = i13;
                    if (i2 == iZzp3) {
                        iArrCopyOf2[i2] = 1;
                        iZzp2--;
                        if (iZzp2 > 0) {
                            zzfpVar.getClass();
                            iZzp3 = zzfpVar.zzp() - 1;
                        }
                    }
                    int i33 = iZzp3;
                    long[] jArr8 = jArrCopyOf2;
                    iZzp8 = iZzp8;
                    j2 += (long) iZzp8;
                    iZzp5 = iZzp7 - 1;
                    if (iZzp5 != 0) {
                        if (i > 0) {
                            iZzp5 = zzfpVar3.zzp();
                            i--;
                            iZzp8 = zzfpVar3.zzg();
                        } else {
                            iZzp5 = 0;
                        }
                    }
                    int[] iArr9 = iArrCopyOf;
                    j += (long) iArrCopyOf[i2];
                    int i34 = i11 - 1;
                    i2++;
                    iZzg = i32;
                    jArrCopyOf2 = jArr8;
                    jArrCopyOf = jArrCopyOf;
                    iZzb = iZzb;
                    iZzp7 = iZzp5;
                    iZzp3 = i33;
                    i3 = i34;
                    iArrCopyOf = iArr9;
                }
                long j9 = j2 + ((long) iZzg);
                if (zzfpVar2 != null) {
                    z2 = true;
                    break;
                }
                while (true) {
                    if (iZzp > 0) {
                        z2 = true;
                        break;
                    }
                    if (zzfpVar2.zzp() != 0) {
                        z2 = false;
                        break;
                    }
                    zzfpVar2.zzg();
                    iZzp--;
                }
                if (iZzp2 == 0) {
                    if (iZzp7 == 0) {
                        if (i3 == 0) {
                            if (i == 0) {
                                i8 = 0;
                                i6 = 0;
                            } else if (iZzp4 == 0) {
                                i8 = 0;
                                i6 = 0;
                                i7 = 0;
                                zzajmVar = zzajmVar;
                                z2 = z2;
                                jArrCopyOf = jArrCopyOf;
                            } else if (z2) {
                                zzajmVar = zzajmVar;
                                jArrCopyOf = jArrCopyOf;
                            } else {
                                i5 = 0;
                                i8 = 0;
                                z2 = false;
                                i6 = 0;
                                i7 = 0;
                                iZzp4 = 0;
                                zzajmVar = zzajmVar;
                                jArrCopyOf = jArrCopyOf;
                            }
                            jArr = jArrCopyOf;
                            iArr = iArrCopyOf2;
                            i9 = i4;
                            iArr2 = iArrCopyOf;
                            i10 = iZzb;
                            j3 = j9;
                        } else {
                            i8 = 0;
                            i6 = i3;
                        }
                        i7 = i;
                    } else {
                        zzajmVar = zzajmVar;
                        z2 = z2;
                        jArrCopyOf = jArrCopyOf;
                        i6 = i3;
                        i7 = i;
                        i8 = iZzp7;
                    }
                    i5 = 0;
                } else {
                    z2 = z2;
                    jArrCopyOf = jArrCopyOf;
                    i5 = iZzp2;
                    i6 = i3;
                    i7 = i;
                    iZzp4 = iZzp4;
                    i8 = iZzp7;
                    zzajmVar = zzajmVar;
                }
                int i35 = zzajmVar.zza;
                StringBuilder sb = new StringBuilder("Inconsistent stbl box for track ");
                sb.append(i35);
                sb.append(": remainingSynchronizationSamples ");
                sb.append(i5);
                sb.append(", remainingSamplesAtTimestampDelta ");
                sb.append(i8);
                sb.append(", remainingSamplesInChunk ");
                sb.append(i6);
                sb.append(", remainingTimestampDeltaChanges ");
                sb.append(i7);
                sb.append(", remainingSamplesAtTimestampOffset ");
                sb.append(iZzp4);
                if (true != z2) {
                    str = ", ctts invalid";
                } else {
                    str = "";
                }
                sb.append(str);
                zzff.zzf("AtomParsers", sb.toString());
                jArr = jArrCopyOf;
                iArr = iArrCopyOf2;
                i9 = i4;
                iArr2 = iArrCopyOf;
                i10 = iZzb;
                j3 = j9;
            } else if (iZzp == 0 && iZzp2 == 0) {
                int i36 = zzaipVar.zza;
                long[] jArr9 = new long[i36];
                int[] iArr10 = new int[i36];
                while (zzaipVar.zza()) {
                    int i37 = zzaipVar.zzb;
                    jArr9[i37] = zzaipVar.zzd;
                    iArr10[i37] = zzaipVar.zzc;
                }
                long j10 = iZzp8;
                int i38 = 8192 / iZza;
                int i39 = 0;
                for (int i40 = 0; i40 < i36; i40++) {
                    int i41 = iArr10[i40];
                    int i42 = zzfy.zza;
                    i39 += ((i41 + i38) - 1) / i38;
                }
                long[] jArr10 = new long[i39];
                int[] iArr11 = new int[i39];
                long[] jArr11 = new long[i39];
                int[] iArr12 = new int[i39];
                int i43 = 0;
                int i44 = 0;
                int iMax = 0;
                int i45 = 0;
                while (i43 < i36) {
                    int i46 = iArr10[i43];
                    long j11 = jArr9[i43];
                    int i47 = i36;
                    int i48 = i46;
                    while (i48 > 0) {
                        int iMin = Math.min(i38, i48);
                        jArr10[i45] = j11;
                        long[] jArr12 = jArr9;
                        int i49 = iZza * iMin;
                        iArr11[i45] = i49;
                        iMax = Math.max(iMax, i49);
                        jArr11[i45] = ((long) i44) * j10;
                        iArr12[i45] = 1;
                        j11 += (long) iArr11[i45];
                        i44 += iMin;
                        i48 -= iMin;
                        i45++;
                        jArr9 = jArr12;
                        iArr10 = iArr10;
                    }
                    i43++;
                    i36 = i47;
                }
                i10 = iZzb;
                j3 = j10 * ((long) i44);
                jArr = jArr10;
                iArr = iArr12;
                iArr2 = iArr11;
                jArrCopyOf2 = jArr11;
                i9 = iMax;
                zzajmVar = zzajmVar;
            } else {
                iZzp6 = 0;
                jArrCopyOf = new long[iZzb];
                iArrCopyOf = new int[iZzb];
                jArrCopyOf2 = new long[iZzb];
                iArrCopyOf2 = new int[iZzb];
                i = iZzp6;
                i2 = 0;
                i3 = 0;
                iZzp4 = 0;
                iZzg = 0;
                i4 = 0;
                j = 0;
                j2 = 0;
                while (true) {
                    if (i2 < iZzb) {
                        iZzp7 = iZzp7;
                        break;
                    }
                    zZza = true;
                    while (true) {
                        if (i3 != 0) {
                            i11 = i3;
                            break;
                        }
                        zZza = zzaipVar.zza();
                        if (zZza) {
                            i11 = 0;
                            break;
                        }
                        int i310 = iZzp7;
                        long j12 = zzaipVar.zzd;
                        i3 = zzaipVar.zzc;
                        j = j12;
                        iZzp7 = i310;
                        iZzp8 = iZzp8;
                        iZzb = iZzb;
                    }
                    if (!zZza) {
                        zzff.zzf("AtomParsers", "Unexpected end of chunk data");
                        jArrCopyOf = Arrays.copyOf(jArrCopyOf, i2);
                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i2);
                        jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i2);
                        iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i2);
                        iZzb = i2;
                        break;
                    }
                    if (zzfpVar2 != null) {
                        while (iZzp4 == 0) {
                            if (iZzp > 0) {
                                iZzp4 = 0;
                                break;
                            }
                            iZzp--;
                            iZzp4 = zzfpVar2.zzp();
                            iZzg = zzfpVar2.zzg();
                        }
                        iZzp4--;
                    }
                    int i311 = iZzg;
                    jArrCopyOf[i2] = j;
                    iZzc = zzaiuVar.zzc();
                    iArrCopyOf[i2] = iZzc;
                    i12 = i4;
                    if (iZzc > i12) {
                        i4 = iZzc;
                    } else {
                        i4 = i12;
                    }
                    jArrCopyOf2[i2] = j2 + ((long) i311);
                    if (zzfpVar == null) {
                        i13 = 1;
                    } else {
                        i13 = 0;
                    }
                    iArrCopyOf2[i2] = i13;
                    if (i2 == iZzp3) {
                        iArrCopyOf2[i2] = 1;
                        iZzp2--;
                        if (iZzp2 > 0) {
                            zzfpVar.getClass();
                            iZzp3 = zzfpVar.zzp() - 1;
                        }
                    }
                    int i312 = iZzp3;
                    long[] jArr13 = jArrCopyOf2;
                    iZzp8 = iZzp8;
                    j2 += (long) iZzp8;
                    iZzp5 = iZzp7 - 1;
                    if (iZzp5 != 0) {
                        if (i > 0) {
                            iZzp5 = zzfpVar3.zzp();
                            i--;
                            iZzp8 = zzfpVar3.zzg();
                        } else {
                            iZzp5 = 0;
                        }
                    }
                    int[] iArr13 = iArrCopyOf;
                    j += (long) iArrCopyOf[i2];
                    int i313 = i11 - 1;
                    i2++;
                    iZzg = i311;
                    jArrCopyOf2 = jArr13;
                    jArrCopyOf = jArrCopyOf;
                    iZzb = iZzb;
                    iZzp7 = iZzp5;
                    iZzp3 = i312;
                    i3 = i313;
                    iArrCopyOf = iArr13;
                }
                long j13 = j2 + ((long) iZzg);
                if (zzfpVar2 != null) {
                    z2 = true;
                    break;
                }
                while (true) {
                    if (iZzp > 0) {
                        z2 = true;
                        break;
                    }
                    if (zzfpVar2.zzp() != 0) {
                        z2 = false;
                        break;
                    }
                    zzfpVar2.zzg();
                    iZzp--;
                }
                if (iZzp2 == 0) {
                    if (iZzp7 == 0) {
                        if (i3 == 0) {
                            if (i == 0) {
                                i8 = 0;
                                i6 = 0;
                            } else if (iZzp4 == 0) {
                                i8 = 0;
                                i6 = 0;
                                i7 = 0;
                                zzajmVar = zzajmVar;
                                z2 = z2;
                                jArrCopyOf = jArrCopyOf;
                            } else if (z2) {
                                i5 = 0;
                                i8 = 0;
                                z2 = false;
                                i6 = 0;
                                i7 = 0;
                                iZzp4 = 0;
                                zzajmVar = zzajmVar;
                                jArrCopyOf = jArrCopyOf;
                            } else {
                                zzajmVar = zzajmVar;
                                jArrCopyOf = jArrCopyOf;
                            }
                            jArr = jArrCopyOf;
                            iArr = iArrCopyOf2;
                            i9 = i4;
                            iArr2 = iArrCopyOf;
                            i10 = iZzb;
                            j3 = j13;
                        } else {
                            i8 = 0;
                            i6 = i3;
                        }
                        i7 = i;
                    } else {
                        zzajmVar = zzajmVar;
                        z2 = z2;
                        jArrCopyOf = jArrCopyOf;
                        i6 = i3;
                        i7 = i;
                        i8 = iZzp7;
                    }
                    i5 = 0;
                } else {
                    z2 = z2;
                    jArrCopyOf = jArrCopyOf;
                    i5 = iZzp2;
                    i6 = i3;
                    i7 = i;
                    iZzp4 = iZzp4;
                    i8 = iZzp7;
                    zzajmVar = zzajmVar;
                }
                int i314 = zzajmVar.zza;
                StringBuilder sb2 = new StringBuilder("Inconsistent stbl box for track ");
                sb2.append(i314);
                sb2.append(": remainingSynchronizationSamples ");
                sb2.append(i5);
                sb2.append(", remainingSamplesAtTimestampDelta ");
                sb2.append(i8);
                sb2.append(", remainingSamplesInChunk ");
                sb2.append(i6);
                sb2.append(", remainingTimestampDeltaChanges ");
                sb2.append(i7);
                sb2.append(", remainingSamplesAtTimestampOffset ");
                sb2.append(iZzp4);
                if (true != z2) {
                    str = ", ctts invalid";
                } else {
                    str = "";
                }
                sb2.append(str);
                zzff.zzf("AtomParsers", sb2.toString());
                jArr = jArrCopyOf;
                iArr = iArrCopyOf2;
                i9 = i4;
                iArr2 = iArrCopyOf;
                i10 = iZzb;
                j3 = j13;
            }
            jZzs = zzfy.zzs(j3, 1000000L, zzajmVar.zzc, RoundingMode.FLOOR);
            jArr2 = zzajmVar.zzh;
            if (jArr2 == null) {
                zzfy.zzE(jArrCopyOf2, 1000000L, zzajmVar.zzc);
                return new zzajp(zzajmVar, jArr, iArr2, i9, jArrCopyOf2, iArr, jZzs);
            }
            if (jArr2.length == 1 || zzajmVar.zzb != 1 || (length2 = jArrCopyOf2.length) < 2) {
                i14 = i10;
            } else {
                long[] jArr14 = zzajmVar.zzi;
                jArr14.getClass();
                long j14 = jArr14[0];
                int i50 = i10;
                long jZzs3 = zzfy.zzs(jArr2[0], zzajmVar.zzc, zzajmVar.zzd, RoundingMode.FLOOR) + j14;
                int i51 = length2 - 1;
                int iMax2 = Math.max(0, Math.min(4, i51));
                int iMax3 = Math.max(0, Math.min(length2 - 4, i51));
                long j15 = jArrCopyOf2[0];
                if (j15 > j14 || j14 >= jArrCopyOf2[iMax2] || jArrCopyOf2[iMax3] >= jZzs3 || jZzs3 > j3) {
                    i14 = i50;
                } else {
                    long jZzs4 = zzfy.zzs(j14 - j15, zzajmVar.zzf.zzA, zzajmVar.zzc, RoundingMode.FLOOR);
                    i14 = i50;
                    long jZzs5 = zzfy.zzs(j3 - jZzs3, zzajmVar.zzf.zzA, zzajmVar.zzc, RoundingMode.FLOOR);
                    if (jZzs4 != 0) {
                        if (jZzs4 <= 2147483647L && jZzs5 <= 2147483647L) {
                            zzadkVar.zza = (int) jZzs4;
                            zzadkVar.zzb = (int) jZzs5;
                            zzfy.zzE(jArrCopyOf2, 1000000L, zzajmVar.zzc);
                            return new zzajp(zzajmVar, jArr, iArr2, i9, jArrCopyOf2, iArr, zzfy.zzs(zzajmVar.zzh[0], 1000000L, zzajmVar.zzd, RoundingMode.FLOOR));
                        }
                    } else if (jZzs5 != 0) {
                        jZzs4 = 0;
                        if (jZzs4 <= 2147483647L) {
                            zzadkVar.zza = (int) jZzs4;
                            zzadkVar.zzb = (int) jZzs5;
                            zzfy.zzE(jArrCopyOf2, 1000000L, zzajmVar.zzc);
                            return new zzajp(zzajmVar, jArr, iArr2, i9, jArrCopyOf2, iArr, zzfy.zzs(zzajmVar.zzh[0], 1000000L, zzajmVar.zzd, RoundingMode.FLOOR));
                        }
                    }
                }
            }
            jArr3 = zzajmVar.zzh;
            length = jArr3.length;
            if (length == 1) {
                if (jArr3[0] == 0) {
                    long[] jArr15 = zzajmVar.zzi;
                    jArr15.getClass();
                    j7 = jArr15[0];
                    for (i30 = 0; i30 < jArrCopyOf2.length; i30++) {
                        jArrCopyOf2[i30] = zzfy.zzs(jArrCopyOf2[i30] - j7, 1000000L, zzajmVar.zzc, RoundingMode.FLOOR);
                    }
                    return new zzajp(zzajmVar, jArr, iArr2, i9, jArrCopyOf2, iArr, zzfy.zzs(j3 - j7, 1000000L, zzajmVar.zzc, RoundingMode.FLOOR));
                }
                length = 1;
            }
            if (zzajmVar.zzb == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            jArr4 = zzajmVar.zzi;
            iArr3 = new int[length];
            iArr4 = new int[length];
            jArr4.getClass();
            i15 = 0;
            z4 = false;
            i16 = 0;
            i17 = 0;
            while (true) {
                jArr5 = zzajmVar.zzh;
                i18 = i9;
                if (i16 < jArr5.length) {
                    break;
                }
                int[] iArr14 = iArr2;
                j6 = jArr4[i16];
                if (j6 != -1) {
                    int i52 = i15;
                    boolean z9 = z4;
                    long jZzs6 = zzfy.zzs(jArr5[i16], zzajmVar.zzc, zzajmVar.zzd, RoundingMode.FLOOR);
                    i27 = 1;
                    iArr3[i16] = zzfy.zzc(jArrCopyOf2, j6, true, true);
                    iArr4[i16] = zzfy.zza(jArrCopyOf2, j6 + jZzs6, z3, false);
                    while (true) {
                        i28 = iArr3[i16];
                        i29 = iArr4[i16];
                        if (i28 >= i29 || (iArr[i28] & i27) != 0) {
                            break;
                        }
                        iArr3[i16] = i28 + 1;
                        i27 = 1;
                    }
                    i26 = i52 + (i29 - i28);
                    if (i17 != i28) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z7 = z9 | z8;
                    i17 = i29;
                } else {
                    z7 = z4;
                    i26 = i15;
                }
                i16++;
                i9 = i18;
                i15 = i26;
                iArr2 = iArr14;
                i14 = i14;
                z4 = z7;
            }
            iArr5 = iArr2;
            boolean z10 = z4;
            i19 = i15;
            i20 = 0;
            if (i19 != i14) {
                z5 = true;
            } else {
                z5 = false;
            }
            z6 = z10 | z5;
            if (z6) {
                jArr6 = new long[i19];
            } else {
                jArr6 = jArr;
            }
            if (z6) {
                iArr6 = new int[i19];
            } else {
                iArr6 = iArr5;
            }
            if (true == z6) {
                i21 = 0;
            } else {
                i21 = i18;
            }
            if (z6) {
                iArr7 = new int[i19];
            } else {
                iArr7 = iArr;
            }
            jArr7 = new long[i19];
            i22 = i21;
            i23 = 0;
            j4 = 0;
            while (i20 < zzajmVar.zzh.length) {
                j5 = zzajmVar.zzi[i20];
                i24 = iArr3[i20];
                int[] iArr15 = iArr3;
                i25 = iArr4[i20];
                int[] iArr16 = iArr4;
                if (z6) {
                    int i53 = i25 - i24;
                    System.arraycopy(jArr, i24, jArr6, i23, i53);
                    iArr8 = iArr5;
                    System.arraycopy(iArr8, i24, iArr6, i23, i53);
                    System.arraycopy(iArr, i24, iArr7, i23, i53);
                } else {
                    iArr8 = iArr5;
                }
                int i54 = i22;
                while (i24 < i25) {
                    int i55 = i25;
                    int i56 = i20;
                    long jZzs7 = zzfy.zzs(j4, 1000000L, zzajmVar.zzd, RoundingMode.FLOOR);
                    long[] jArr16 = jArrCopyOf2;
                    int[] iArr17 = iArr;
                    jZzs2 = zzfy.zzs(jArrCopyOf2[i24] - j5, 1000000L, zzajmVar.zzc, RoundingMode.FLOOR);
                    int[] iArr18 = iArr7;
                    long[] jArr17 = jArr6;
                    if (zzajmVar.zzb != 1) {
                        jZzs2 = Math.max(0L, jZzs2);
                    }
                    jArr7[i23] = jZzs7 + jZzs2;
                    if (!z6 && iArr6[i23] > i54) {
                        i54 = iArr8[i24];
                    }
                    i23++;
                    i24++;
                    i25 = i55;
                    iArr6 = iArr6;
                    i20 = i56;
                    jArrCopyOf2 = jArr16;
                    iArr = iArr17;
                    iArr7 = iArr18;
                    jArr6 = jArr17;
                }
                int i57 = i20;
                j4 += zzajmVar.zzh[i57];
                i20 = i57 + 1;
                i22 = i54;
                iArr5 = iArr8;
                iArr6 = iArr6;
                iArr3 = iArr15;
                jArrCopyOf2 = jArrCopyOf2;
                iArr4 = iArr16;
                jArr = jArr;
                iArr7 = iArr7;
                jArr6 = jArr6;
            }
            return new zzajp(zzajmVar, jArr6, iArr6, i22, jArr7, iArr7, zzfy.zzs(j4, 1000000L, zzajmVar.zzd, RoundingMode.FLOOR));
        }
        iZzp2 = 0;
        iZzp3 = -1;
        iZza = zzaiuVar.zza();
        String str3 = zzajmVar.zzf.zzm;
        if (iZza != -1) {
            jArrCopyOf = new long[iZzb];
            iArrCopyOf = new int[iZzb];
            jArrCopyOf2 = new long[iZzb];
            iArrCopyOf2 = new int[iZzb];
            i = iZzp6;
            i2 = 0;
            i3 = 0;
            iZzp4 = 0;
            iZzg = 0;
            i4 = 0;
            j = 0;
            j2 = 0;
            while (true) {
                if (i2 < iZzb) {
                    iZzp7 = iZzp7;
                    break;
                }
                zZza = true;
                while (true) {
                    if (i3 != 0) {
                        i11 = i3;
                        break;
                    }
                    zZza = zzaipVar.zza();
                    if (zZza) {
                        i11 = 0;
                        break;
                    }
                    int i315 = iZzp7;
                    long j16 = zzaipVar.zzd;
                    i3 = zzaipVar.zzc;
                    j = j16;
                    iZzp7 = i315;
                    iZzp8 = iZzp8;
                    iZzb = iZzb;
                }
                if (!zZza) {
                    zzff.zzf("AtomParsers", "Unexpected end of chunk data");
                    jArrCopyOf = Arrays.copyOf(jArrCopyOf, i2);
                    iArrCopyOf = Arrays.copyOf(iArrCopyOf, i2);
                    jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i2);
                    iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i2);
                    iZzb = i2;
                    break;
                }
                if (zzfpVar2 != null) {
                    while (iZzp4 == 0) {
                        if (iZzp > 0) {
                            iZzp4 = 0;
                            break;
                        }
                        iZzp--;
                        iZzp4 = zzfpVar2.zzp();
                        iZzg = zzfpVar2.zzg();
                    }
                    iZzp4--;
                }
                int i316 = iZzg;
                jArrCopyOf[i2] = j;
                iZzc = zzaiuVar.zzc();
                iArrCopyOf[i2] = iZzc;
                i12 = i4;
                if (iZzc > i12) {
                    i4 = iZzc;
                } else {
                    i4 = i12;
                }
                jArrCopyOf2[i2] = j2 + ((long) i316);
                if (zzfpVar == null) {
                    i13 = 1;
                } else {
                    i13 = 0;
                }
                iArrCopyOf2[i2] = i13;
                if (i2 == iZzp3) {
                    iArrCopyOf2[i2] = 1;
                    iZzp2--;
                    if (iZzp2 > 0) {
                        zzfpVar.getClass();
                        iZzp3 = zzfpVar.zzp() - 1;
                    }
                }
                int i317 = iZzp3;
                long[] jArr18 = jArrCopyOf2;
                iZzp8 = iZzp8;
                j2 += (long) iZzp8;
                iZzp5 = iZzp7 - 1;
                if (iZzp5 != 0) {
                    if (i > 0) {
                        iZzp5 = zzfpVar3.zzp();
                        i--;
                        iZzp8 = zzfpVar3.zzg();
                    } else {
                        iZzp5 = 0;
                    }
                }
                int[] iArr19 = iArrCopyOf;
                j += (long) iArrCopyOf[i2];
                int i318 = i11 - 1;
                i2++;
                iZzg = i316;
                jArrCopyOf2 = jArr18;
                jArrCopyOf = jArrCopyOf;
                iZzb = iZzb;
                iZzp7 = iZzp5;
                iZzp3 = i317;
                i3 = i318;
                iArrCopyOf = iArr19;
            }
            long j17 = j2 + ((long) iZzg);
            if (zzfpVar2 != null) {
                z2 = true;
                break;
            }
            while (true) {
                if (iZzp > 0) {
                    z2 = true;
                    break;
                }
                if (zzfpVar2.zzp() != 0) {
                    z2 = false;
                    break;
                }
                zzfpVar2.zzg();
                iZzp--;
            }
            if (iZzp2 == 0) {
                if (iZzp7 == 0) {
                    if (i3 == 0) {
                        if (i == 0) {
                            i8 = 0;
                            i6 = 0;
                        } else if (iZzp4 == 0) {
                            i8 = 0;
                            i6 = 0;
                            i7 = 0;
                            zzajmVar = zzajmVar;
                            z2 = z2;
                            jArrCopyOf = jArrCopyOf;
                        } else if (z2) {
                            i5 = 0;
                            i8 = 0;
                            z2 = false;
                            i6 = 0;
                            i7 = 0;
                            iZzp4 = 0;
                            zzajmVar = zzajmVar;
                            jArrCopyOf = jArrCopyOf;
                        } else {
                            zzajmVar = zzajmVar;
                            jArrCopyOf = jArrCopyOf;
                        }
                        jArr = jArrCopyOf;
                        iArr = iArrCopyOf2;
                        i9 = i4;
                        iArr2 = iArrCopyOf;
                        i10 = iZzb;
                        j3 = j17;
                    } else {
                        i8 = 0;
                        i6 = i3;
                    }
                    i7 = i;
                } else {
                    zzajmVar = zzajmVar;
                    z2 = z2;
                    jArrCopyOf = jArrCopyOf;
                    i6 = i3;
                    i7 = i;
                    i8 = iZzp7;
                }
                i5 = 0;
            } else {
                z2 = z2;
                jArrCopyOf = jArrCopyOf;
                i5 = iZzp2;
                i6 = i3;
                i7 = i;
                iZzp4 = iZzp4;
                i8 = iZzp7;
                zzajmVar = zzajmVar;
            }
            int i319 = zzajmVar.zza;
            StringBuilder sb3 = new StringBuilder("Inconsistent stbl box for track ");
            sb3.append(i319);
            sb3.append(": remainingSynchronizationSamples ");
            sb3.append(i5);
            sb3.append(", remainingSamplesAtTimestampDelta ");
            sb3.append(i8);
            sb3.append(", remainingSamplesInChunk ");
            sb3.append(i6);
            sb3.append(", remainingTimestampDeltaChanges ");
            sb3.append(i7);
            sb3.append(", remainingSamplesAtTimestampOffset ");
            sb3.append(iZzp4);
            if (true != z2) {
                str = ", ctts invalid";
            } else {
                str = "";
            }
            sb3.append(str);
            zzff.zzf("AtomParsers", sb3.toString());
            jArr = jArrCopyOf;
            iArr = iArrCopyOf2;
            i9 = i4;
            iArr2 = iArrCopyOf;
            i10 = iZzb;
            j3 = j17;
        } else {
            jArrCopyOf = new long[iZzb];
            iArrCopyOf = new int[iZzb];
            jArrCopyOf2 = new long[iZzb];
            iArrCopyOf2 = new int[iZzb];
            i = iZzp6;
            i2 = 0;
            i3 = 0;
            iZzp4 = 0;
            iZzg = 0;
            i4 = 0;
            j = 0;
            j2 = 0;
            while (true) {
                if (i2 < iZzb) {
                    iZzp7 = iZzp7;
                    break;
                }
                zZza = true;
                while (true) {
                    if (i3 != 0) {
                        i11 = i3;
                        break;
                    }
                    zZza = zzaipVar.zza();
                    if (zZza) {
                        i11 = 0;
                        break;
                    }
                    int i3110 = iZzp7;
                    long j18 = zzaipVar.zzd;
                    i3 = zzaipVar.zzc;
                    j = j18;
                    iZzp7 = i3110;
                    iZzp8 = iZzp8;
                    iZzb = iZzb;
                }
                if (!zZza) {
                    zzff.zzf("AtomParsers", "Unexpected end of chunk data");
                    jArrCopyOf = Arrays.copyOf(jArrCopyOf, i2);
                    iArrCopyOf = Arrays.copyOf(iArrCopyOf, i2);
                    jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i2);
                    iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i2);
                    iZzb = i2;
                    break;
                }
                if (zzfpVar2 != null) {
                    while (iZzp4 == 0) {
                        if (iZzp > 0) {
                            iZzp4 = 0;
                            break;
                        }
                        iZzp--;
                        iZzp4 = zzfpVar2.zzp();
                        iZzg = zzfpVar2.zzg();
                    }
                    iZzp4--;
                }
                int i3111 = iZzg;
                jArrCopyOf[i2] = j;
                iZzc = zzaiuVar.zzc();
                iArrCopyOf[i2] = iZzc;
                i12 = i4;
                if (iZzc > i12) {
                    i4 = iZzc;
                } else {
                    i4 = i12;
                }
                jArrCopyOf2[i2] = j2 + ((long) i3111);
                if (zzfpVar == null) {
                    i13 = 1;
                } else {
                    i13 = 0;
                }
                iArrCopyOf2[i2] = i13;
                if (i2 == iZzp3) {
                    iArrCopyOf2[i2] = 1;
                    iZzp2--;
                    if (iZzp2 > 0) {
                        zzfpVar.getClass();
                        iZzp3 = zzfpVar.zzp() - 1;
                    }
                }
                int i3112 = iZzp3;
                long[] jArr19 = jArrCopyOf2;
                iZzp8 = iZzp8;
                j2 += (long) iZzp8;
                iZzp5 = iZzp7 - 1;
                if (iZzp5 != 0) {
                    if (i > 0) {
                        iZzp5 = zzfpVar3.zzp();
                        i--;
                        iZzp8 = zzfpVar3.zzg();
                    } else {
                        iZzp5 = 0;
                    }
                }
                int[] iArr110 = iArrCopyOf;
                j += (long) iArrCopyOf[i2];
                int i3113 = i11 - 1;
                i2++;
                iZzg = i3111;
                jArrCopyOf2 = jArr19;
                jArrCopyOf = jArrCopyOf;
                iZzb = iZzb;
                iZzp7 = iZzp5;
                iZzp3 = i3112;
                i3 = i3113;
                iArrCopyOf = iArr110;
            }
            long j19 = j2 + ((long) iZzg);
            if (zzfpVar2 != null) {
                z2 = true;
                break;
            }
            while (true) {
                if (iZzp > 0) {
                    z2 = true;
                    break;
                }
                if (zzfpVar2.zzp() != 0) {
                    z2 = false;
                    break;
                }
                zzfpVar2.zzg();
                iZzp--;
            }
            if (iZzp2 == 0) {
                if (iZzp7 == 0) {
                    if (i3 == 0) {
                        if (i == 0) {
                            i8 = 0;
                            i6 = 0;
                        } else if (iZzp4 == 0) {
                            i8 = 0;
                            i6 = 0;
                            i7 = 0;
                            zzajmVar = zzajmVar;
                            z2 = z2;
                            jArrCopyOf = jArrCopyOf;
                        } else if (z2) {
                            i5 = 0;
                            i8 = 0;
                            z2 = false;
                            i6 = 0;
                            i7 = 0;
                            iZzp4 = 0;
                            zzajmVar = zzajmVar;
                            jArrCopyOf = jArrCopyOf;
                        } else {
                            zzajmVar = zzajmVar;
                            jArrCopyOf = jArrCopyOf;
                        }
                        jArr = jArrCopyOf;
                        iArr = iArrCopyOf2;
                        i9 = i4;
                        iArr2 = iArrCopyOf;
                        i10 = iZzb;
                        j3 = j19;
                    } else {
                        i8 = 0;
                        i6 = i3;
                    }
                    i7 = i;
                } else {
                    zzajmVar = zzajmVar;
                    z2 = z2;
                    jArrCopyOf = jArrCopyOf;
                    i6 = i3;
                    i7 = i;
                    i8 = iZzp7;
                }
                i5 = 0;
            } else {
                z2 = z2;
                jArrCopyOf = jArrCopyOf;
                i5 = iZzp2;
                i6 = i3;
                i7 = i;
                iZzp4 = iZzp4;
                i8 = iZzp7;
                zzajmVar = zzajmVar;
            }
            int i3114 = zzajmVar.zza;
            StringBuilder sb4 = new StringBuilder("Inconsistent stbl box for track ");
            sb4.append(i3114);
            sb4.append(": remainingSynchronizationSamples ");
            sb4.append(i5);
            sb4.append(", remainingSamplesAtTimestampDelta ");
            sb4.append(i8);
            sb4.append(", remainingSamplesInChunk ");
            sb4.append(i6);
            sb4.append(", remainingTimestampDeltaChanges ");
            sb4.append(i7);
            sb4.append(", remainingSamplesAtTimestampOffset ");
            sb4.append(iZzp4);
            if (true != z2) {
                str = ", ctts invalid";
            } else {
                str = "";
            }
            sb4.append(str);
            zzff.zzf("AtomParsers", sb4.toString());
            jArr = jArrCopyOf;
            iArr = iArrCopyOf2;
            i9 = i4;
            iArr2 = iArrCopyOf;
            i10 = iZzb;
            j3 = j19;
        }
        jZzs = zzfy.zzs(j3, 1000000L, zzajmVar.zzc, RoundingMode.FLOOR);
        jArr2 = zzajmVar.zzh;
        if (jArr2 == null) {
            zzfy.zzE(jArrCopyOf2, 1000000L, zzajmVar.zzc);
            return new zzajp(zzajmVar, jArr, iArr2, i9, jArrCopyOf2, iArr, jZzs);
        }
        if (jArr2.length == 1) {
            i14 = i10;
        } else {
            i14 = i10;
        }
        jArr3 = zzajmVar.zzh;
        length = jArr3.length;
        if (length == 1) {
            if (jArr3[0] == 0) {
                long[] jArr110 = zzajmVar.zzi;
                jArr110.getClass();
                j7 = jArr110[0];
                while (i30 < jArrCopyOf2.length) {
                    jArrCopyOf2[i30] = zzfy.zzs(jArrCopyOf2[i30] - j7, 1000000L, zzajmVar.zzc, RoundingMode.FLOOR);
                }
                return new zzajp(zzajmVar, jArr, iArr2, i9, jArrCopyOf2, iArr, zzfy.zzs(j3 - j7, 1000000L, zzajmVar.zzc, RoundingMode.FLOOR));
            }
            length = 1;
        }
        if (zzajmVar.zzb == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        jArr4 = zzajmVar.zzi;
        iArr3 = new int[length];
        iArr4 = new int[length];
        jArr4.getClass();
        i15 = 0;
        z4 = false;
        i16 = 0;
        i17 = 0;
        while (true) {
            jArr5 = zzajmVar.zzh;
            i18 = i9;
            if (i16 < jArr5.length) {
                break;
                break;
            }
            int[] iArr111 = iArr2;
            j6 = jArr4[i16];
            if (j6 != -1) {
                int i58 = i15;
                boolean z11 = z4;
                long jZzs8 = zzfy.zzs(jArr5[i16], zzajmVar.zzc, zzajmVar.zzd, RoundingMode.FLOOR);
                i27 = 1;
                iArr3[i16] = zzfy.zzc(jArrCopyOf2, j6, true, true);
                iArr4[i16] = zzfy.zza(jArrCopyOf2, j6 + jZzs8, z3, false);
                while (true) {
                    i28 = iArr3[i16];
                    i29 = iArr4[i16];
                    if (i28 >= i29) {
                        break;
                    }
                    break;
                    break;
                    iArr3[i16] = i28 + 1;
                    i27 = 1;
                }
                i26 = i58 + (i29 - i28);
                if (i17 != i28) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z7 = z11 | z8;
                i17 = i29;
            } else {
                z7 = z4;
                i26 = i15;
            }
            i16++;
            i9 = i18;
            i15 = i26;
            iArr2 = iArr111;
            i14 = i14;
            z4 = z7;
        }
        iArr5 = iArr2;
        boolean z12 = z4;
        i19 = i15;
        i20 = 0;
        if (i19 != i14) {
            z5 = true;
        } else {
            z5 = false;
        }
        z6 = z12 | z5;
        if (z6) {
            jArr6 = new long[i19];
        } else {
            jArr6 = jArr;
        }
        if (z6) {
            iArr6 = new int[i19];
        } else {
            iArr6 = iArr5;
        }
        if (true == z6) {
            i21 = 0;
        } else {
            i21 = i18;
        }
        if (z6) {
            iArr7 = new int[i19];
        } else {
            iArr7 = iArr;
        }
        jArr7 = new long[i19];
        i22 = i21;
        i23 = 0;
        j4 = 0;
        while (i20 < zzajmVar.zzh.length) {
            j5 = zzajmVar.zzi[i20];
            i24 = iArr3[i20];
            int[] iArr112 = iArr3;
            i25 = iArr4[i20];
            int[] iArr113 = iArr4;
            if (z6) {
                int i59 = i25 - i24;
                System.arraycopy(jArr, i24, jArr6, i23, i59);
                iArr8 = iArr5;
                System.arraycopy(iArr8, i24, iArr6, i23, i59);
                System.arraycopy(iArr, i24, iArr7, i23, i59);
            } else {
                iArr8 = iArr5;
            }
            int i510 = i22;
            while (i24 < i25) {
                int i511 = i25;
                int i512 = i20;
                long jZzs9 = zzfy.zzs(j4, 1000000L, zzajmVar.zzd, RoundingMode.FLOOR);
                long[] jArr111 = jArrCopyOf2;
                int[] iArr114 = iArr;
                jZzs2 = zzfy.zzs(jArrCopyOf2[i24] - j5, 1000000L, zzajmVar.zzc, RoundingMode.FLOOR);
                int[] iArr115 = iArr7;
                long[] jArr112 = jArr6;
                if (zzajmVar.zzb != 1) {
                    jZzs2 = Math.max(0L, jZzs2);
                }
                jArr7[i23] = jZzs9 + jZzs2;
                if (!z6) {
                }
                i23++;
                i24++;
                i25 = i511;
                iArr6 = iArr6;
                i20 = i512;
                jArrCopyOf2 = jArr111;
                iArr = iArr114;
                iArr7 = iArr115;
                jArr6 = jArr112;
            }
            int i513 = i20;
            j4 += zzajmVar.zzh[i513];
            i20 = i513 + 1;
            i22 = i510;
            iArr5 = iArr8;
            iArr6 = iArr6;
            iArr3 = iArr112;
            jArrCopyOf2 = jArrCopyOf2;
            iArr4 = iArr113;
            jArr = jArr;
            iArr7 = iArr7;
            jArr6 = jArr6;
        }
        return new zzajp(zzajmVar, jArr6, iArr6, i22, jArr7, iArr7, zzfy.zzs(j4, 1000000L, zzajmVar.zzd, RoundingMode.FLOOR));
    }

    private static ByteBuffer zzl() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    /* JADX WARN: Code duplicated, block: B:128:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:130:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:131:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:134:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:136:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:137:0x0200  */
    /* JADX WARN: Code duplicated, block: B:140:0x021d  */
    /* JADX WARN: Code duplicated, block: B:141:0x022c  */
    /* JADX WARN: Code duplicated, block: B:142:0x0237  */
    /* JADX WARN: Code duplicated, block: B:144:0x023e  */
    /* JADX WARN: Code duplicated, block: B:146:0x0249  */
    /* JADX WARN: Code duplicated, block: B:148:0x0251  */
    /* JADX WARN: Code duplicated, block: B:149:0x0262  */
    /* JADX WARN: Code duplicated, block: B:153:0x0279  */
    /* JADX WARN: Code duplicated, block: B:154:0x0284  */
    /* JADX WARN: Code duplicated, block: B:156:0x0289  */
    /* JADX WARN: Code duplicated, block: B:178:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:179:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:181:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:182:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:184:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:186:0x0326  */
    /* JADX WARN: Code duplicated, block: B:187:0x032a  */
    /* JADX WARN: Code duplicated, block: B:189:0x033e  */
    /* JADX WARN: Code duplicated, block: B:191:0x0343 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:192:0x0345  */
    /* JADX WARN: Code duplicated, block: B:195:0x0361  */
    /* JADX WARN: Code duplicated, block: B:210:0x0420  */
    /* JADX WARN: Code duplicated, block: B:211:0x0449  */
    /* JADX WARN: Code duplicated, block: B:213:0x0454  */
    /* JADX WARN: Code duplicated, block: B:215:0x0462  */
    /* JADX WARN: Code duplicated, block: B:217:0x046a  */
    /* JADX WARN: Code duplicated, block: B:226:0x0498  */
    /* JADX WARN: Code duplicated, block: B:228:0x04a0 A[LOOP:3: B:224:0x0492->B:228:0x04a0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:231:0x04c9  */
    /* JADX WARN: Code duplicated, block: B:233:0x04d4  */
    /* JADX WARN: Code duplicated, block: B:234:0x04df  */
    /* JADX WARN: Code duplicated, block: B:236:0x04e9  */
    /* JADX WARN: Code duplicated, block: B:238:0x04ee A[PHI: r2
  0x04ee: PHI (r2v5 int) = (r2v6 int), (r2v13 int), (r2v14 int) binds: [B:212:0x0452, B:210:0x0420, B:209:0x041c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:251:0x034d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:262:0x04a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:263:0x04ab A[EDGE_INSN: B:263:0x04ab->B:230:0x04ab BREAK  A[LOOP:3: B:224:0x0492->B:228:0x04a0], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x0080  */
    /* JADX WARN: Code duplicated, block: B:83:0x0138  */
    private static void zzm(zzfp zzfpVar, int i, int i2, int i3, int i4, String str, boolean z, zzae zzaeVar, zzais zzaisVar, int i5) throws zzcc {
        int iZzq;
        int iZzn;
        int iZzg;
        int iZzp;
        int i6;
        zzae zzaeVarZzb;
        String str2;
        int i7;
        String str3;
        List listZzm;
        zzaiq zzaiqVarZzj;
        int iZzg2;
        boolean z2;
        int iZzg3;
        int i8;
        int iZzd;
        int i9;
        int i10;
        String str4;
        byte[] bArr;
        String str5;
        String str6;
        zzfp zzfpVar2;
        int i11;
        int i12;
        int iZzm;
        int i13;
        String str7;
        boolean z3;
        int iZzm2;
        byte[] bArr2;
        int iZzm3;
        int i14;
        byte[] bArr3;
        zzfp zzfpVar3 = zzfpVar;
        int i15 = i2;
        int i16 = i3;
        zzfpVar3.zzK(i15 + 16);
        if (z) {
            iZzq = zzfpVar.zzq();
            zzfpVar3.zzL(6);
        } else {
            zzfpVar3.zzL(8);
            iZzq = 0;
        }
        if (iZzq == 0 || iZzq == 1) {
            int iZzq2 = zzfpVar.zzq();
            zzfpVar3.zzL(6);
            iZzn = zzfpVar.zzn();
            zzfpVar3.zzK(zzfpVar.zzd() - 4);
            iZzg = zzfpVar.zzg();
            if (iZzq == 1) {
                zzfpVar3.zzL(16);
            }
            iZzp = iZzq2;
            i6 = -1;
        } else {
            if (iZzq != 2) {
                return;
            }
            zzfpVar3.zzL(16);
            iZzn = (int) Math.round(Double.longBitsToDouble(zzfpVar.zzt()));
            iZzp = zzfpVar.zzp();
            zzfpVar3.zzL(4);
            int iZzp2 = zzfpVar.zzp();
            int iZzp3 = zzfpVar.zzp();
            int i17 = iZzp3 & 1;
            int i18 = iZzp3 & 2;
            if (i17 == 0) {
                if (iZzp2 == 8) {
                    i6 = 3;
                } else if (iZzp2 == 16) {
                    i6 = i18 != 0 ? 268435456 : 2;
                } else if (iZzp2 == 24) {
                    i6 = i18 != 0 ? 1342177280 : 21;
                } else if (iZzp2 == 32) {
                    i6 = i18 != 0 ? 1610612736 : 22;
                } else {
                    i6 = -1;
                }
            } else if (iZzp2 == 32) {
                i6 = 4;
            } else {
                i6 = -1;
            }
            zzfpVar3.zzL(8);
            iZzg = 0;
        }
        int iZzd2 = zzfpVar.zzd();
        int iIntValue = 1701733217;
        int i19 = i;
        if (i19 == 1701733217) {
            Pair pairZzh = zzh(zzfpVar3, i15, i16);
            if (pairZzh != null) {
                iIntValue = ((Integer) pairZzh.first).intValue();
                zzaeVarZzb = zzaeVar == null ? null : zzaeVar.zzb(((zzajn) pairZzh.second).zzb);
                zzaisVar.zza[i5] = (zzajn) pairZzh.second;
            } else {
                zzaeVarZzb = zzaeVar;
            }
            zzfpVar3.zzK(iZzd2);
            i19 = iIntValue;
        } else {
            zzaeVarZzb = zzaeVar;
        }
        String str8 = "audio/mhm1";
        if (i19 == 1633889587) {
            str2 = "audio/ac3";
        } else {
            if (i19 != 1700998451) {
                if (i19 == 1633889588) {
                    i7 = i6;
                    str2 = "audio/ac4";
                } else if (i19 == 1685353315) {
                    str2 = "audio/vnd.dts";
                } else if (i19 == 1685353320 || i19 == 1685353324) {
                    str2 = "audio/vnd.dts.hd";
                } else if (i19 == 1685353317) {
                    str2 = "audio/vnd.dts.hd;profile=lbr";
                } else if (i19 == 1685353336) {
                    str2 = "audio/vnd.dts.uhd;profile=p2";
                } else if (i19 == 1935764850) {
                    str2 = "audio/3gpp";
                } else if (i19 == 1935767394) {
                    str2 = "audio/amr-wb";
                } else if (i19 == 1936684916) {
                    str2 = "audio/raw";
                    i7 = 2;
                } else if (i19 == 1953984371) {
                    str2 = "audio/raw";
                    i7 = 268435456;
                } else if (i19 == 1819304813) {
                    if (i6 == -1) {
                        str2 = "audio/raw";
                        i7 = 2;
                    } else {
                        i7 = i6;
                        str2 = "audio/raw";
                    }
                } else if (i19 == 778924082 || i19 == 778924083) {
                    str2 = "audio/mpeg";
                } else if (i19 == 1835557169) {
                    str2 = "audio/mha1";
                } else if (i19 == 1835560241) {
                    i7 = i6;
                    str2 = "audio/mhm1";
                } else if (i19 == 1634492771) {
                    str2 = "audio/alac";
                } else if (i19 == 1634492791) {
                    str2 = "audio/g711-alaw";
                } else if (i19 == 1970037111) {
                    str2 = "audio/g711-mlaw";
                } else if (i19 == 1332770163) {
                    str2 = "audio/opus";
                } else if (i19 == 1716281667) {
                    str2 = "audio/flac";
                } else if (i19 == 1835823201) {
                    str2 = "audio/true-hd";
                } else {
                    i7 = i6;
                    str2 = null;
                }
                int i20 = i7;
                str3 = null;
                listZzm = null;
                zzaiqVarZzj = null;
                while (iZzd2 - i15 < i16) {
                    zzfpVar3.zzK(iZzd2);
                    iZzg2 = zzfpVar.zzg();
                    if (iZzg2 > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    String str9 = "childAtomSize must be positive";
                    zzacy.zzb(z2, "childAtomSize must be positive");
                    iZzg3 = zzfpVar.zzg();
                    i8 = iZzn;
                    if (iZzg3 == 1835557187) {
                        zzfpVar3.zzK(iZzd2 + 8);
                        zzfpVar3.zzL(1);
                        iZzm3 = zzfpVar.zzm();
                        zzfpVar3.zzL(1);
                        if (Objects.equals(str2, str8)) {
                            i14 = 0;
                            str6 = String.format("mhm1.%02X", Integer.valueOf(iZzm3));
                        } else {
                            i14 = 0;
                            str6 = String.format("mha1.%02X", Integer.valueOf(iZzm3));
                        }
                        int iZzq3 = zzfpVar.zzq();
                        bArr3 = new byte[iZzq3];
                        zzfpVar3.zzG(bArr3, i14, iZzq3);
                        if (listZzm == null) {
                            listZzm = zzgaa.zzm(bArr3);
                            iZzn = i8;
                            i10 = iZzg;
                        } else {
                            listZzm = zzgaa.zzn(bArr3, (byte[]) listZzm.get(i14));
                            iZzn = i8;
                            i10 = iZzg;
                        }
                    } else {
                        str8 = str8;
                        if (iZzg3 == 1835557200) {
                            zzfpVar3.zzK(iZzd2 + 8);
                            iZzm2 = zzfpVar.zzm();
                            if (iZzm2 > 0) {
                                bArr2 = new byte[iZzm2];
                                zzfpVar3.zzG(bArr2, 0, iZzm2);
                                if (listZzm == null) {
                                    listZzm = zzgaa.zzm(bArr2);
                                    str6 = str3;
                                    i10 = iZzg;
                                    iZzn = i8;
                                } else {
                                    listZzm = zzgaa.zzn((byte[]) listZzm.get(0), bArr2);
                                    str6 = str3;
                                    iZzn = i8;
                                    i10 = iZzg;
                                }
                            } else {
                                i8 = i8;
                                i10 = iZzg;
                                iZzn = i8;
                                str6 = str3;
                            }
                        } else {
                            if (iZzg3 == 1702061171) {
                                i8 = i8;
                                iZzd = iZzd2;
                                i9 = -1;
                            } else if (z || iZzg3 != 2002876005) {
                                if (iZzg3 == 1684103987) {
                                    zzfpVar3.zzK(iZzd2 + 8);
                                    zzaisVar.zzb = zzabv.zzc(zzfpVar3, Integer.toString(i4), str, zzaeVarZzb);
                                } else if (iZzg3 == 1684366131) {
                                    zzfpVar3.zzK(iZzd2 + 8);
                                    zzaisVar.zzb = zzabv.zzd(zzfpVar3, Integer.toString(i4), str, zzaeVarZzb);
                                } else if (iZzg3 == 1684103988) {
                                    zzfpVar3.zzK(iZzd2 + 8);
                                    String string = Integer.toString(i4);
                                    int i21 = zzaby.zza;
                                    zzfpVar3.zzL(1);
                                    iZzm = zzfpVar.zzm() & 32;
                                    zzak zzakVar = new zzak();
                                    zzakVar.zzK(string);
                                    zzakVar.zzW("audio/ac4");
                                    zzakVar.zzy(2);
                                    if (1 != (iZzm >> 5)) {
                                        i13 = 44100;
                                    } else {
                                        i13 = 48000;
                                    }
                                    zzakVar.zzX(i13);
                                    zzakVar.zzE(zzaeVarZzb);
                                    zzakVar.zzN(str);
                                    zzaisVar.zzb = zzakVar.zzac();
                                } else if (iZzg3 != 1684892784) {
                                    if (iZzg3 != 1684305011 || iZzg3 == 1969517683) {
                                        zzak zzakVar2 = new zzak();
                                        zzakVar2.zzJ(i4);
                                        zzakVar2.zzW(str2);
                                        zzakVar2.zzy(iZzp);
                                        i8 = i8;
                                        zzakVar2.zzX(i8);
                                        zzakVar2.zzE(zzaeVarZzb);
                                        zzakVar2.zzN(str);
                                        zzaisVar.zzb = zzakVar2.zzac();
                                    } else if (iZzg3 == 1682927731) {
                                        int i22 = iZzg2 - 8;
                                        byte[] bArr4 = zza;
                                        byte[] bArrCopyOf = Arrays.copyOf(bArr4, bArr4.length + i22);
                                        zzfpVar3.zzK(iZzd2 + 8);
                                        zzfpVar3.zzG(bArrCopyOf, bArr4.length, i22);
                                        listZzm = zzadq.zze(bArrCopyOf);
                                        str6 = str3;
                                        iZzn = i8;
                                        i10 = iZzg;
                                    } else if (iZzg3 == 1684425825) {
                                        byte[] bArr5 = new byte[iZzg2 - 8];
                                        bArr5[0] = 102;
                                        bArr5[1] = 76;
                                        bArr5[2] = 97;
                                        bArr5[3] = 67;
                                        zzfpVar3.zzK(iZzd2 + 12);
                                        zzfpVar3.zzG(bArr5, 4, iZzg2 - 12);
                                        listZzm = zzgaa.zzm(bArr5);
                                        str6 = str3;
                                        iZzn = i8;
                                        i10 = iZzg;
                                    } else {
                                        if (iZzg3 == 1634492771) {
                                            int i23 = iZzg2 - 12;
                                            byte[] bArr6 = new byte[i23];
                                            zzfpVar3.zzK(iZzd2 + 12);
                                            zzfpVar3.zzG(bArr6, 0, i23);
                                            int i24 = zzem.zza;
                                            zzfp zzfpVar4 = new zzfp(bArr6);
                                            zzfpVar4.zzK(9);
                                            int iZzm4 = zzfpVar4.zzm();
                                            zzfpVar4.zzK(20);
                                            Pair pairCreate = Pair.create(Integer.valueOf(zzfpVar4.zzp()), Integer.valueOf(iZzm4));
                                            int iIntValue2 = ((Integer) pairCreate.first).intValue();
                                            int iIntValue3 = ((Integer) pairCreate.second).intValue();
                                            listZzm = zzgaa.zzm(bArr6);
                                            iZzp = iIntValue3;
                                            iZzn = iIntValue2;
                                            i10 = iZzg;
                                        } else {
                                            i8 = i8;
                                        }
                                        str6 = str3;
                                    }
                                    i10 = iZzg;
                                    iZzn = i8;
                                    str6 = str3;
                                } else {
                                    if (iZzg > 0) {
                                        throw zzcc.zza("Invalid sample rate for Dolby TrueHD MLP stream: " + iZzg, null);
                                    }
                                    str6 = str3;
                                    iZzn = iZzg;
                                    i10 = iZzn;
                                    iZzp = 2;
                                }
                                i8 = i8;
                                i10 = iZzg;
                                iZzn = i8;
                                str6 = str3;
                            } else {
                                iZzd = zzfpVar.zzd();
                                if (iZzd >= iZzd2) {
                                    str7 = null;
                                    z3 = true;
                                } else {
                                    str7 = null;
                                    z3 = false;
                                }
                                zzacy.zzb(z3, str7);
                                while (true) {
                                    if (iZzd - iZzd2 >= iZzg2) {
                                        iZzd = -1;
                                        break;
                                    }
                                    zzfpVar3.zzK(iZzd);
                                    int iZzg4 = zzfpVar.zzg();
                                    zzacy.zzb(iZzg4 > 0, str9);
                                    String str10 = str9;
                                    if (zzfpVar.zzg() == 1702061171) {
                                        break;
                                    }
                                    iZzd += iZzg4;
                                    str9 = str10;
                                }
                                i9 = -1;
                            }
                            if (iZzd != i9) {
                                zzaiqVarZzj = zzj(zzfpVar3, iZzd);
                                str4 = zzaiqVarZzj.zza;
                                bArr = zzaiqVarZzj.zzb;
                                if (bArr != null) {
                                    i10 = iZzg;
                                } else if ("audio/vorbis".equals(str4)) {
                                    zzfpVar2 = new zzfp(bArr);
                                    zzfpVar2.zzL(1);
                                    i11 = 0;
                                    while (zzfpVar2.zzb() > 0 && zzfpVar2.zzf() == 255) {
                                        zzfpVar2.zzL(1);
                                        i11 += 255;
                                    }
                                    int iZzm5 = i11 + zzfpVar2.zzm();
                                    i12 = 0;
                                    while (true) {
                                        if (zzfpVar2.zzb() > 0) {
                                            i10 = iZzg;
                                            break;
                                        }
                                        i10 = iZzg;
                                        if (zzfpVar2.zzf() == 255) {
                                            break;
                                        }
                                        zzfpVar2.zzL(1);
                                        i12 += 255;
                                        iZzg = i10;
                                    }
                                    int iZzm6 = i12 + zzfpVar2.zzm();
                                    byte[] bArr7 = new byte[iZzm5];
                                    int iZzd3 = zzfpVar2.zzd();
                                    System.arraycopy(bArr, iZzd3, bArr7, 0, iZzm5);
                                    int i25 = iZzd3 + iZzm5 + iZzm6;
                                    int length = bArr.length - i25;
                                    byte[] bArr8 = new byte[length];
                                    System.arraycopy(bArr, i25, bArr8, 0, length);
                                    listZzm = zzgaa.zzn(bArr7, bArr8);
                                } else {
                                    i10 = iZzg;
                                    if ("audio/mp4a-latm".equals(str4)) {
                                        zzabr zzabrVarZza = zzabs.zza(bArr);
                                        iZzn = zzabrVarZza.zza;
                                        iZzp = zzabrVarZza.zzb;
                                        str5 = zzabrVarZza.zzc;
                                    } else {
                                        str5 = str3;
                                        iZzn = i8;
                                    }
                                    listZzm = zzgaa.zzm(bArr);
                                    str6 = str5;
                                    str2 = str4;
                                }
                                str2 = str4;
                            } else {
                                i10 = iZzg;
                            }
                            iZzn = i8;
                            str6 = str3;
                        }
                    }
                    iZzd2 += iZzg2;
                    zzfpVar3 = zzfpVar;
                    i15 = i2;
                    str3 = str6;
                    str8 = str8;
                    iZzg = i10;
                    i16 = i3;
                }
                int i26 = iZzn;
                if (zzaisVar.zzb == null || str2 == null) {
                }
                zzak zzakVar3 = new zzak();
                zzakVar3.zzJ(i4);
                zzakVar3.zzW(str2);
                zzakVar3.zzz(str3);
                zzakVar3.zzy(iZzp);
                zzakVar3.zzX(i26);
                zzakVar3.zzQ(i20);
                zzakVar3.zzL(listZzm);
                zzakVar3.zzE(zzaeVarZzb);
                zzakVar3.zzN(str);
                if (zzaiqVarZzj != null) {
                    zzakVar3.zzx(zzgcu.zzc(zzaiqVarZzj.zzc));
                    zzakVar3.zzR(zzgcu.zzc(zzaiqVarZzj.zzd));
                }
                zzaisVar.zzb = zzakVar3.zzac();
                return;
            }
            str2 = "audio/eac3";
        }
        i7 = i6;
        int i27 = i7;
        str3 = null;
        listZzm = null;
        zzaiqVarZzj = null;
        while (iZzd2 - i15 < i16) {
            zzfpVar3.zzK(iZzd2);
            iZzg2 = zzfpVar.zzg();
            if (iZzg2 > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            String str11 = "childAtomSize must be positive";
            zzacy.zzb(z2, "childAtomSize must be positive");
            iZzg3 = zzfpVar.zzg();
            i8 = iZzn;
            if (iZzg3 == 1835557187) {
                zzfpVar3.zzK(iZzd2 + 8);
                zzfpVar3.zzL(1);
                iZzm3 = zzfpVar.zzm();
                zzfpVar3.zzL(1);
                if (Objects.equals(str2, str8)) {
                    i14 = 0;
                    str6 = String.format("mhm1.%02X", Integer.valueOf(iZzm3));
                } else {
                    i14 = 0;
                    str6 = String.format("mha1.%02X", Integer.valueOf(iZzm3));
                }
                int iZzq4 = zzfpVar.zzq();
                bArr3 = new byte[iZzq4];
                zzfpVar3.zzG(bArr3, i14, iZzq4);
                if (listZzm == null) {
                    listZzm = zzgaa.zzm(bArr3);
                    iZzn = i8;
                    i10 = iZzg;
                } else {
                    listZzm = zzgaa.zzn(bArr3, (byte[]) listZzm.get(i14));
                    iZzn = i8;
                    i10 = iZzg;
                }
            } else {
                str8 = str8;
                if (iZzg3 == 1835557200) {
                    zzfpVar3.zzK(iZzd2 + 8);
                    iZzm2 = zzfpVar.zzm();
                    if (iZzm2 > 0) {
                        bArr2 = new byte[iZzm2];
                        zzfpVar3.zzG(bArr2, 0, iZzm2);
                        if (listZzm == null) {
                            listZzm = zzgaa.zzm(bArr2);
                            str6 = str3;
                            i10 = iZzg;
                            iZzn = i8;
                        } else {
                            listZzm = zzgaa.zzn((byte[]) listZzm.get(0), bArr2);
                            str6 = str3;
                            iZzn = i8;
                            i10 = iZzg;
                        }
                    } else {
                        i8 = i8;
                        i10 = iZzg;
                        iZzn = i8;
                        str6 = str3;
                    }
                } else {
                    if (iZzg3 == 1702061171) {
                        if (z) {
                        }
                        if (iZzg3 == 1684103987) {
                            zzfpVar3.zzK(iZzd2 + 8);
                            zzaisVar.zzb = zzabv.zzc(zzfpVar3, Integer.toString(i4), str, zzaeVarZzb);
                        } else if (iZzg3 == 1684366131) {
                            zzfpVar3.zzK(iZzd2 + 8);
                            zzaisVar.zzb = zzabv.zzd(zzfpVar3, Integer.toString(i4), str, zzaeVarZzb);
                        } else if (iZzg3 == 1684103988) {
                            zzfpVar3.zzK(iZzd2 + 8);
                            String string2 = Integer.toString(i4);
                            int i28 = zzaby.zza;
                            zzfpVar3.zzL(1);
                            iZzm = zzfpVar.zzm() & 32;
                            zzak zzakVar4 = new zzak();
                            zzakVar4.zzK(string2);
                            zzakVar4.zzW("audio/ac4");
                            zzakVar4.zzy(2);
                            if (1 != (iZzm >> 5)) {
                                i13 = 44100;
                            } else {
                                i13 = 48000;
                            }
                            zzakVar4.zzX(i13);
                            zzakVar4.zzE(zzaeVarZzb);
                            zzakVar4.zzN(str);
                            zzaisVar.zzb = zzakVar4.zzac();
                        } else if (iZzg3 != 1684892784) {
                            if (iZzg > 0) {
                                throw zzcc.zza("Invalid sample rate for Dolby TrueHD MLP stream: " + iZzg, null);
                            }
                            str6 = str3;
                            iZzn = iZzg;
                            i10 = iZzn;
                            iZzp = 2;
                        } else if (iZzg3 != 1684305011) {
                            zzak zzakVar5 = new zzak();
                            zzakVar5.zzJ(i4);
                            zzakVar5.zzW(str2);
                            zzakVar5.zzy(iZzp);
                            i8 = i8;
                            zzakVar5.zzX(i8);
                            zzakVar5.zzE(zzaeVarZzb);
                            zzakVar5.zzN(str);
                            zzaisVar.zzb = zzakVar5.zzac();
                            i10 = iZzg;
                            iZzn = i8;
                            str6 = str3;
                        } else {
                            zzak zzakVar6 = new zzak();
                            zzakVar6.zzJ(i4);
                            zzakVar6.zzW(str2);
                            zzakVar6.zzy(iZzp);
                            i8 = i8;
                            zzakVar6.zzX(i8);
                            zzakVar6.zzE(zzaeVarZzb);
                            zzakVar6.zzN(str);
                            zzaisVar.zzb = zzakVar6.zzac();
                            i10 = iZzg;
                            iZzn = i8;
                            str6 = str3;
                        }
                        i8 = i8;
                        i10 = iZzg;
                        iZzn = i8;
                        str6 = str3;
                    } else {
                        i8 = i8;
                        iZzd = iZzd2;
                        i9 = -1;
                    }
                    if (iZzd != i9) {
                        zzaiqVarZzj = zzj(zzfpVar3, iZzd);
                        str4 = zzaiqVarZzj.zza;
                        bArr = zzaiqVarZzj.zzb;
                        if (bArr != null) {
                            i10 = iZzg;
                        } else if ("audio/vorbis".equals(str4)) {
                            zzfpVar2 = new zzfp(bArr);
                            zzfpVar2.zzL(1);
                            i11 = 0;
                            while (zzfpVar2.zzb() > 0) {
                                zzfpVar2.zzL(1);
                                i11 += 255;
                            }
                            int iZzm7 = i11 + zzfpVar2.zzm();
                            i12 = 0;
                            while (true) {
                                if (zzfpVar2.zzb() > 0) {
                                    i10 = iZzg;
                                    break;
                                }
                                i10 = iZzg;
                                if (zzfpVar2.zzf() == 255) {
                                    break;
                                    break;
                                } else {
                                    zzfpVar2.zzL(1);
                                    i12 += 255;
                                    iZzg = i10;
                                }
                            }
                            int iZzm8 = i12 + zzfpVar2.zzm();
                            byte[] bArr9 = new byte[iZzm7];
                            int iZzd4 = zzfpVar2.zzd();
                            System.arraycopy(bArr, iZzd4, bArr9, 0, iZzm7);
                            int i29 = iZzd4 + iZzm7 + iZzm8;
                            int length2 = bArr.length - i29;
                            byte[] bArr10 = new byte[length2];
                            System.arraycopy(bArr, i29, bArr10, 0, length2);
                            listZzm = zzgaa.zzn(bArr9, bArr10);
                        } else {
                            i10 = iZzg;
                            if ("audio/mp4a-latm".equals(str4)) {
                                zzabr zzabrVarZza2 = zzabs.zza(bArr);
                                iZzn = zzabrVarZza2.zza;
                                iZzp = zzabrVarZza2.zzb;
                                str5 = zzabrVarZza2.zzc;
                            } else {
                                str5 = str3;
                                iZzn = i8;
                            }
                            listZzm = zzgaa.zzm(bArr);
                            str6 = str5;
                            str2 = str4;
                        }
                        str2 = str4;
                    } else {
                        i10 = iZzg;
                    }
                    iZzn = i8;
                    str6 = str3;
                }
            }
            iZzd2 += iZzg2;
            zzfpVar3 = zzfpVar;
            i15 = i2;
            str3 = str6;
            str8 = str8;
            iZzg = i10;
            i16 = i3;
        }
        int i210 = iZzn;
        if (zzaisVar.zzb == null) {
        }
    }
}
