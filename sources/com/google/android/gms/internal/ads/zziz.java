package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zziz extends zzce {

    @Deprecated
    public static final zzn zzd = new zzn() { // from class: com.google.android.gms.internal.ads.zziy
    };
    private static final String zzl = Integer.toString(PointerIconCompat.TYPE_CONTEXT_MENU, 36);
    private static final String zzm = Integer.toString(PointerIconCompat.TYPE_HAND, 36);
    private static final String zzn = Integer.toString(PointerIconCompat.TYPE_HELP, 36);
    private static final String zzo = Integer.toString(PointerIconCompat.TYPE_WAIT, 36);
    private static final String zzp = Integer.toString(1005, 36);
    private static final String zzq = Integer.toString(PointerIconCompat.TYPE_CELL, 36);
    public final int zze;
    public final String zzf;
    public final int zzg;
    public final zzam zzh;
    public final int zzi;
    public final zzur zzj;
    final boolean zzk;

    private zziz(int i, Throwable th, int i2) {
        this(i, th, null, i2, null, -1, null, 4, false);
    }

    public static zziz zzb(Throwable th, String str, int i, zzam zzamVar, int i2, boolean z, int i3) {
        return new zziz(1, th, null, i3, str, i, zzamVar, zzamVar == null ? 4 : i2, z);
    }

    public static zziz zzc(IOException iOException, int i) {
        return new zziz(0, iOException, i);
    }

    public static zziz zzd(RuntimeException runtimeException, int i) {
        return new zziz(2, runtimeException, i);
    }

    final zziz zza(zzur zzurVar) {
        String message = getMessage();
        int i = zzfy.zza;
        return new zziz(message, getCause(), this.zzb, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, zzurVar, this.zzc, this.zzk);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private zziz(int i, Throwable th, String str, int i2, String str2, int i3, zzam zzamVar, int i4, boolean z) {
        String str3;
        String str4;
        if (i == 0) {
            str3 = "Source error";
        } else if (i != 1) {
            str3 = "Unexpected runtime error";
        } else {
            String strValueOf = String.valueOf(zzamVar);
            int i5 = zzfy.zza;
            if (i4 == 0) {
                str4 = "NO";
            } else if (i4 == 1) {
                str4 = "NO_UNSUPPORTED_TYPE";
            } else if (i4 == 2) {
                str4 = "NO_UNSUPPORTED_DRM";
            } else if (i4 == 3) {
                str4 = "NO_EXCEEDS_CAPABILITIES";
            } else {
                if (i4 != 4) {
                    throw new IllegalStateException();
                }
                str4 = "YES";
            }
            str3 = str2 + " error, index=" + i3 + ", format=" + strValueOf + ", format_supported=" + str4;
        }
        this(TextUtils.isEmpty(null) ? str3 : str3.concat(": null"), th, i2, i, str2, i3, zzamVar, i4, null, SystemClock.elapsedRealtime(), z);
    }

    private zziz(String str, Throwable th, int i, int i2, String str2, int i3, zzam zzamVar, int i4, zzur zzurVar, long j, boolean z) {
        int i5;
        boolean z2;
        super(str, th, i, j);
        if (z) {
            i5 = i2;
            if (i5 == 1) {
                i5 = 1;
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            i5 = i2;
            z2 = true;
        }
        zzek.zzd(z2);
        zzek.zzd(th != null);
        this.zze = i5;
        this.zzf = str2;
        this.zzg = i3;
        this.zzh = zzamVar;
        this.zzi = i4;
        this.zzj = zzurVar;
        this.zzk = z;
    }
}
