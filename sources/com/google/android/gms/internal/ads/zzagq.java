package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzagq {
    public static final zzago zza = new zzago() { // from class: com.google.android.gms.internal.ads.zzagn
    };

    /* JADX WARN: Code duplicated, block: B:30:0x0090  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ac A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:40:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:52:0x0102  */
    /* JADX WARN: Code duplicated, block: B:58:0x010c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x00fc A[SYNTHETIC] */
    public static final zzby zza(byte[] bArr, int i, zzago zzagoVar, zzafr zzafrVar) {
        boolean z;
        zzagp zzagpVar;
        int i2;
        int iZze;
        zzagr zzagrVarZzf;
        ArrayList arrayList = new ArrayList();
        zzfp zzfpVar = new zzfp(bArr, i);
        boolean z2 = false;
        if (zzfpVar.zzb() < 10) {
            zzff.zzf("Id3Decoder", "Data too short to be an ID3 tag");
        } else {
            int iZzo = zzfpVar.zzo();
            if (iZzo == 4801587) {
                int iZzm = zzfpVar.zzm();
                zzfpVar.zzL(1);
                int iZzm2 = zzfpVar.zzm();
                int iZzl = zzfpVar.zzl();
                if (iZzm != 2) {
                    if (iZzm == 3) {
                        if ((iZzm2 & 64) != 0) {
                            int iZzg = zzfpVar.zzg();
                            zzfpVar.zzL(iZzg);
                            iZzl -= iZzg + 4;
                        }
                    } else if (iZzm == 4) {
                        if ((iZzm2 & 64) != 0) {
                            int iZzl2 = zzfpVar.zzl();
                            zzfpVar.zzL(iZzl2 - 4);
                            iZzl -= iZzl2;
                        }
                        if ((iZzm2 & 16) != 0) {
                            iZzl -= 10;
                        }
                    } else {
                        zzff.zzf("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + iZzm);
                    }
                    if (iZzm < 4) {
                        z = false;
                    } else {
                        z = false;
                    }
                    zzagpVar = new zzagp(iZzm, z, iZzl);
                } else if ((iZzm2 & 64) != 0) {
                    zzff.zzf("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                } else {
                    if (iZzm < 4 || (iZzm2 & 128) == 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    zzagpVar = new zzagp(iZzm, z, iZzl);
                }
                if (zzagpVar == null) {
                    return null;
                }
                int iZzd = zzfpVar.zzd();
                i2 = zzagpVar.zza == 2 ? 6 : 10;
                iZze = zzagpVar.zzc;
                if (zzagpVar.zzb) {
                    iZze = zze(zzfpVar, zzagpVar.zzc);
                }
                zzfpVar.zzJ(iZzd + iZze);
                if (!zzk(zzfpVar, zzagpVar.zza, i2, false)) {
                    if (zzagpVar.zza == 4 || !zzk(zzfpVar, 4, i2, true)) {
                        zzff.zzf("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + zzagpVar.zza);
                        return null;
                    }
                    z2 = true;
                }
                while (zzfpVar.zzb() >= i2) {
                    zzagrVarZzf = zzf(zzagpVar.zza, zzfpVar, z2, i2, zzagoVar);
                    if (zzagrVarZzf != null) {
                        arrayList.add(zzagrVarZzf);
                    }
                }
                return new zzby(arrayList);
            }
            zzff.zzf("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x".concat(String.valueOf(String.format("%06X", Integer.valueOf(iZzo)))));
        }
        zzagpVar = null;
        if (zzagpVar == null) {
            return null;
        }
        int iZzd2 = zzfpVar.zzd();
        if (zzagpVar.zza == 2) {
        }
        iZze = zzagpVar.zzc;
        if (zzagpVar.zzb) {
            iZze = zze(zzfpVar, zzagpVar.zzc);
        }
        zzfpVar.zzJ(iZzd2 + iZze);
        if (!zzk(zzfpVar, zzagpVar.zza, i2, false)) {
            if (zzagpVar.zza == 4) {
            }
            zzff.zzf("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + zzagpVar.zza);
            return null;
        }
        while (zzfpVar.zzb() >= i2) {
            zzagrVarZzf = zzf(zzagpVar.zza, zzfpVar, z2, i2, zzagoVar);
            if (zzagrVarZzf != null) {
                arrayList.add(zzagrVarZzf);
            }
        }
        return new zzby(arrayList);
    }

    private static int zzb(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static int zzc(byte[] bArr, int i, int i2) {
        int iZzd = zzd(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return iZzd;
        }
        while (true) {
            int length = bArr.length;
            if (iZzd >= length - 1) {
                return length;
            }
            int i3 = iZzd + 1;
            if ((iZzd - i) % 2 == 0 && bArr[i3] == 0) {
                return iZzd;
            }
            iZzd = zzd(bArr, i3);
        }
    }

    private static int zzd(byte[] bArr, int i) {
        while (true) {
            int length = bArr.length;
            if (i >= length) {
                return length;
            }
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
    }

    private static int zze(zzfp zzfpVar, int i) {
        byte[] bArrZzM = zzfpVar.zzM();
        int iZzd = zzfpVar.zzd();
        int i2 = iZzd;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= iZzd + i) {
                return i;
            }
            if ((bArrZzM[i2] & 255) == 255 && bArrZzM[i3] == 0) {
                System.arraycopy(bArrZzM, i2 + 2, bArrZzM, i3, (i - (i2 - iZzd)) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 15261. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private static com.google.android.gms.internal.ads.zzagr zzf(int r35, com.google.android.gms.internal.ads.zzfp r36, boolean r37, int r38, com.google.android.gms.internal.ads.zzago r39) {
        /*
            Method dump skipped, instruction units count: 1526
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagq.zzf(int, com.google.android.gms.internal.ads.zzfp, boolean, int, com.google.android.gms.internal.ads.zzago):com.google.android.gms.internal.ads.zzagr");
    }

    private static zzgaa zzg(byte[] bArr, int i, int i2) {
        if (i2 >= bArr.length) {
            return zzgaa.zzm("");
        }
        zzfzx zzfzxVar = new zzfzx();
        int iZzc = zzc(bArr, i2, i);
        while (i2 < iZzc) {
            zzfzxVar.zzf(new String(bArr, i2, iZzc - i2, zzj(i)));
            i2 = zzb(i) + iZzc;
            iZzc = zzc(bArr, i2, i);
        }
        zzgaa zzgaaVarZzi = zzfzxVar.zzi();
        return zzgaaVarZzi.isEmpty() ? zzgaa.zzm("") : zzgaaVarZzi;
    }

    private static String zzh(byte[] bArr, int i, int i2, Charset charset) {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, charset);
    }

    private static String zzi(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    /* JADX WARN: Code duplicated, block: B:23:0x006a A[Catch: all -> 0x00a8, TryCatch #0 {all -> 0x00a8, blocks: (B:3:0x0008, B:7:0x0015, B:18:0x003d, B:21:0x0048, B:23:0x006a, B:27:0x0070, B:39:0x008c, B:40:0x008e, B:43:0x0094, B:46:0x009e, B:29:0x007a, B:33:0x0081, B:8:0x0022), top: B:53:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x006e  */
    /* JADX WARN: Code duplicated, block: B:26:0x006f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0078 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:29:0x007a A[Catch: all -> 0x00a8, TryCatch #0 {all -> 0x00a8, blocks: (B:3:0x0008, B:7:0x0015, B:18:0x003d, B:21:0x0048, B:23:0x006a, B:27:0x0070, B:39:0x008c, B:40:0x008e, B:43:0x0094, B:46:0x009e, B:29:0x007a, B:33:0x0081, B:8:0x0022), top: B:53:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x007e  */
    /* JADX WARN: Code duplicated, block: B:32:0x0080  */
    /* JADX WARN: Code duplicated, block: B:35:0x0085  */
    /* JADX WARN: Code duplicated, block: B:36:0x0086  */
    /* JADX WARN: Code duplicated, block: B:37:0x0088  */
    /* JADX WARN: Code duplicated, block: B:39:0x008c A[Catch: all -> 0x00a8, TryCatch #0 {all -> 0x00a8, blocks: (B:3:0x0008, B:7:0x0015, B:18:0x003d, B:21:0x0048, B:23:0x006a, B:27:0x0070, B:39:0x008c, B:40:0x008e, B:43:0x0094, B:46:0x009e, B:29:0x007a, B:33:0x0081, B:8:0x0022), top: B:53:0x0008 }] */
    private static boolean zzk(zzfp zzfpVar, int i, int i2, boolean z) {
        boolean z2;
        int iZzo;
        long jZzo;
        int iZzq;
        int i3;
        int iZzd = zzfpVar.zzd();
        while (true) {
            try {
                z2 = true;
                z2 = true;
                int i4 = 1;
                int i5 = 1;
                if (zzfpVar.zzb() >= i2) {
                    if (i >= 3) {
                        iZzo = zzfpVar.zzg();
                        jZzo = zzfpVar.zzu();
                        iZzq = zzfpVar.zzq();
                    } else {
                        iZzo = zzfpVar.zzo();
                        jZzo = zzfpVar.zzo();
                        iZzq = 0;
                    }
                    if (iZzo != 0 || jZzo != 0 || iZzq != 0) {
                        if (i != 4 || z) {
                            if (i == 4) {
                                if ((iZzq & 64) != 0) {
                                    i4 = 0;
                                }
                                int i6 = i4;
                                i5 = iZzq & 1;
                                i3 = i6;
                            } else if (i == 3) {
                                if ((iZzq & 32) != 0) {
                                    i3 = 1;
                                } else {
                                    i3 = 0;
                                }
                                if ((iZzq & 128) != 0) {
                                    i5 = 0;
                                }
                            } else {
                                i3 = 0;
                                i5 = 0;
                            }
                            if (i5 != 0) {
                                i3 += 4;
                            }
                            if (jZzo >= i3 && zzfpVar.zzb() >= jZzo) {
                                zzfpVar.zzL((int) jZzo);
                            }
                        } else if ((8421504 & jZzo) == 0) {
                            long j = ((jZzo >> 16) & 255) << 14;
                            jZzo = ((jZzo >> 24) << 21) | j | (jZzo & 255) | (((jZzo >> 8) & 255) << 7);
                            if (i == 4) {
                                if ((iZzq & 64) != 0) {
                                    i4 = 0;
                                }
                                int i7 = i4;
                                i5 = iZzq & 1;
                                i3 = i7;
                            } else if (i == 3) {
                                if ((iZzq & 32) != 0) {
                                    i3 = 1;
                                } else {
                                    i3 = 0;
                                }
                                if ((iZzq & 128) != 0) {
                                    i5 = 0;
                                }
                            } else {
                                i3 = 0;
                                i5 = 0;
                            }
                            if (i5 != 0) {
                                i3 += 4;
                            }
                            if (jZzo >= i3) {
                                zzfpVar.zzL((int) jZzo);
                            }
                        }
                        z2 = false;
                        break;
                    }
                    break;
                }
                break;
            } catch (Throwable th) {
                zzfpVar.zzK(iZzd);
                throw th;
            }
        }
        zzfpVar.zzK(iZzd);
        return z2;
    }

    private static byte[] zzl(byte[] bArr, int i, int i2) {
        return i2 <= i ? zzfy.zzf : Arrays.copyOfRange(bArr, i, i2);
    }

    private static Charset zzj(int i) {
        if (i == 1) {
            return zzfwq.zzf;
        }
        if (i != 2) {
            return i != 3 ? zzfwq.zzb : zzfwq.zzc;
        }
        return zzfwq.zzd;
    }
}
