package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhbn {
    private static final zzhbn zza = new zzhbn();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzhbz zzb = new zzhaw();

    private zzhbn() {
    }

    public static zzhbn zza() {
        return zza;
    }

    public final zzhby zzb(Class cls) {
        zzhae.zzc(cls, "messageType");
        zzhby zzhbyVarZza = (zzhby) this.zzc.get(cls);
        if (zzhbyVarZza == null) {
            zzhbyVarZza = this.zzb.zza(cls);
            zzhae.zzc(cls, "messageType");
            zzhby zzhbyVar = (zzhby) this.zzc.putIfAbsent(cls, zzhbyVarZza);
            if (zzhbyVar != null) {
                return zzhbyVar;
            }
        }
        return zzhbyVarZza;
    }
}
