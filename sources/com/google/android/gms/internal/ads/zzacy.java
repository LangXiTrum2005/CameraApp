package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzacy {
    public static int zza(zzacv zzacvVar, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int iZzb = zzacvVar.zzb(bArr, i + i3, i2 - i3);
            if (iZzb == -1) {
                break;
            }
            i3 += iZzb;
        }
        return i3;
    }

    @Pure
    public static void zzb(boolean z, String str) throws zzcc {
        if (!z) {
            throw zzcc.zza(str, null);
        }
    }

    public static boolean zzc(zzacv zzacvVar, byte[] bArr, int i, int i2, boolean z) throws IOException {
        try {
            return zzacvVar.zzm(bArr, 0, i2, z);
        } catch (EOFException e) {
            if (z) {
                return false;
            }
            throw e;
        }
    }

    public static boolean zzd(zzacv zzacvVar, byte[] bArr, int i, int i2) throws IOException {
        try {
            ((zzack) zzacvVar).zzn(bArr, i, i2, false);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean zze(zzacv zzacvVar, int i) throws IOException {
        try {
            ((zzack) zzacvVar).zzo(i, false);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
