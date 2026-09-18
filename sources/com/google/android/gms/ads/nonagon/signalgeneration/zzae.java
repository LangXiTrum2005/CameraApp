package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzbbz;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzae {
    private final String zza;

    /* synthetic */ zzae(zzac zzacVar, zzad zzadVar) {
        this.zza = zzacVar.zza;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x0035  */
    public final zzbbz zza() {
        byte b;
        switch (this.zza) {
            case "NATIVE":
                b = 2;
                break;
            case "INTERSTITIAL":
                b = 1;
                break;
            case "REWARDED":
                b = 3;
                break;
            case "BANNER":
                b = 0;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            return zzbbz.BANNER;
        }
        if (b == 1) {
            return zzbbz.INTERSTITIAL;
        }
        if (b != 2) {
            return b != 3 ? zzbbz.AD_INITIATER_UNSPECIFIED : zzbbz.REWARD_BASED_VIDEO_AD;
        }
        return zzbbz.AD_LOADER;
    }

    public final String zzb() {
        return this.zza.toLowerCase(Locale.ROOT);
    }

    public final Set zzc() {
        HashSet hashSet = new HashSet();
        hashSet.add(this.zza.toLowerCase(Locale.ROOT));
        return hashSet;
    }
}
