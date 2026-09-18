package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzpd {
    public static final zzpd zza = new zzpd(new int[]{2}, 10);
    private static final zzgaa zzb = zzgaa.zzo(2, 5, 6);
    private static final zzgad zzc;
    private final int[] zzd;
    private final int zze;

    static {
        zzgac zzgacVar = new zzgac();
        zzgacVar.zza(5, 6);
        zzgacVar.zza(17, 6);
        zzgacVar.zza(7, 6);
        zzgacVar.zza(30, 10);
        zzgacVar.zza(18, 6);
        zzgacVar.zza(6, 8);
        zzgacVar.zza(8, 8);
        zzgacVar.zza(14, 8);
        zzc = zzgacVar.zzc();
    }

    public zzpd(int[] iArr, int i) {
        int[] iArrCopyOf = Arrays.copyOf(iArr, 1);
        this.zzd = iArrCopyOf;
        Arrays.sort(iArrCopyOf);
        this.zze = 10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzpd)) {
            return false;
        }
        zzpd zzpdVar = (zzpd) obj;
        if (!Arrays.equals(this.zzd, zzpdVar.zzd)) {
            return false;
        }
        int i = zzpdVar.zze;
        return true;
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.zzd) * 31) + 10;
    }

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=10, supportedEncodings=" + Arrays.toString(this.zzd) + "]";
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002c  */
    /* JADX WARN: Code duplicated, block: B:14:0x0032  */
    /* JADX WARN: Code duplicated, block: B:15:0x0034  */
    /* JADX WARN: Code duplicated, block: B:16:0x0036 A[PHI: r0
  0x0036: PHI (r0v3 int) = (r0v2 int), (r0v6 int) binds: [B:11:0x002a, B:14:0x0032] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:18:0x003a  */
    /* JADX WARN: Code duplicated, block: B:51:0x009e  */
    public final Pair zza(zzam zzamVar, zzk zzkVar) {
        String str = zzamVar.zzm;
        str.getClass();
        int iZza = zzcb.zza(str, zzamVar.zzj);
        zzgad zzgadVar = zzc;
        if (!zzgadVar.containsKey(Integer.valueOf(iZza))) {
            return null;
        }
        int i = 6;
        if (iZza != 18) {
            if (iZza != 8) {
                if (iZza == 30 && !zzc(30)) {
                    iZza = 7;
                }
            } else if (zzc(8)) {
                iZza = 8;
                if (iZza == 30) {
                    iZza = 7;
                }
            } else {
                iZza = 7;
            }
        } else if (zzc(18)) {
            iZza = 18;
            if (iZza != 8) {
                if (iZza == 30) {
                    iZza = 7;
                }
            } else if (zzc(8)) {
                iZza = 8;
                if (iZza == 30) {
                    iZza = 7;
                }
            } else {
                iZza = 7;
            }
        } else {
            iZza = 6;
        }
        if (!zzc(iZza)) {
            return null;
        }
        int iIntValue = zzamVar.zzz;
        if (iIntValue == -1 || iZza == 18) {
            int i2 = zzamVar.zzA;
            if (i2 == -1) {
                i2 = 48000;
            }
            if (zzfy.zza >= 29) {
                iIntValue = zzpc.zza(iZza, i2, zzkVar);
            } else {
                Integer num = (Integer) zzgadVar.getOrDefault(Integer.valueOf(iZza), 0);
                num.getClass();
                iIntValue = num.intValue();
            }
        } else if (zzamVar.zzm.equals("audio/vnd.dts.uhd;profile=p2")) {
            if (iIntValue > 10) {
                return null;
            }
        } else if (iIntValue > 10) {
            return null;
        }
        if (zzfy.zza > 28) {
            i = iIntValue;
        } else if (iIntValue == 7) {
            i = 8;
        } else if (iIntValue != 3 && iIntValue != 4 && iIntValue != 5) {
            i = iIntValue;
        }
        if (zzfy.zza <= 26 && "fugu".equals(zzfy.zzb) && i == 1) {
            i = 2;
        }
        int iZzg = zzfy.zzg(i);
        if (iZzg != 0) {
            return Pair.create(Integer.valueOf(iZza), Integer.valueOf(iZzg));
        }
        return null;
    }

    public final boolean zzc(int i) {
        return Arrays.binarySearch(this.zzd, i) >= 0;
    }
}
