package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbnl implements zzbng {
    private final Context zza;

    public zzbnl(Context context) {
        this.zza = context;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0051  */
    @Override // com.google.android.gms.internal.ads.zzbng
    public final void zza(Object obj, Map map) {
        byte b;
        if (com.google.android.gms.ads.internal.zzt.zzn().zzp(this.zza)) {
            String str = (String) map.get("eventName");
            String str2 = (String) map.get("eventId");
            int iHashCode = str.hashCode();
            if (iHashCode != 94399) {
                if (iHashCode != 94401) {
                    if (iHashCode == 94407 && str.equals("_ai")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                } else if (str.equals("_ac")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str.equals("_aa")) {
                b = 2;
            } else {
                b = -1;
            }
            if (b == 0) {
                com.google.android.gms.ads.internal.zzt.zzn().zzj(this.zza, str2);
            } else if (b == 1) {
                com.google.android.gms.ads.internal.zzt.zzn().zzk(this.zza, str2);
            } else if (b != 2) {
                zzcec.zzg("logScionEvent gmsg contained unsupported eventName");
            } else {
                com.google.android.gms.ads.internal.zzt.zzn().zzh(this.zza, str2);
            }
        }
    }
}
