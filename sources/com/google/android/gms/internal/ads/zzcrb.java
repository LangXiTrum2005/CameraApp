package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcrb implements zzcqv {
    private final zzdzd zza;

    zzcrb(zzdzd zzdzdVar) {
        this.zza = zzdzdVar;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0033  */
    @Override // com.google.android.gms.internal.ads.zzcqv
    public final void zza(Map map) {
        byte b;
        String str = (String) map.get("gesture");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int iHashCode = str.hashCode();
        if (iHashCode != 97520651) {
            if (iHashCode == 109399814 && str.equals("shake")) {
                b = 0;
            } else {
                b = -1;
            }
        } else if (str.equals("flick")) {
            b = 1;
        } else {
            b = -1;
        }
        if (b == 0) {
            this.zza.zzl(zzdyz.SHAKE);
        } else if (b != 1) {
            this.zza.zzl(zzdyz.NONE);
        } else {
            this.zza.zzl(zzdyz.FLICK);
        }
    }
}
