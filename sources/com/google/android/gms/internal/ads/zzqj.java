package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzqj {
    private Boolean zza;

    public zzqj() {
    }

    public zzqj(Context context) {
    }

    public final zzpg zza(zzam zzamVar, zzk zzkVar) {
        zzamVar.getClass();
        zzkVar.getClass();
        if (zzfy.zza < 29 || zzamVar.zzA == -1) {
            return zzpg.zza;
        }
        Boolean bool = this.zza;
        if (bool != null) {
            bool.booleanValue();
        } else {
            Boolean bool2 = false;
            this.zza = bool2;
            bool2.booleanValue();
        }
        String str = zzamVar.zzm;
        str.getClass();
        int iZza = zzcb.zza(str, zzamVar.zzj);
        if (iZza == 0 || zzfy.zza < zzfy.zzf(iZza)) {
            return zzpg.zza;
        }
        int iZzg = zzfy.zzg(zzamVar.zzz);
        if (iZzg == 0) {
            return zzpg.zza;
        }
        try {
            AudioFormat audioFormatZzv = zzfy.zzv(zzamVar.zzA, iZzg, iZza);
            return zzfy.zza >= 31 ? zzqi.zza(audioFormatZzv, zzkVar.zza().zza, false) : zzqh.zza(audioFormatZzv, zzkVar.zza().zza, false);
        } catch (IllegalArgumentException unused) {
            return zzpg.zza;
        }
    }
}
