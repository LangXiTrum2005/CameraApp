package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhaz {
    zzhaz() {
    }

    public static final boolean zza(Object obj) {
        return !((zzhay) obj).zze();
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzhay zzhayVarZzb = (zzhay) obj;
        zzhay zzhayVar = (zzhay) obj2;
        if (!zzhayVar.isEmpty()) {
            if (!zzhayVarZzb.zze()) {
                zzhayVarZzb = zzhayVarZzb.zzb();
            }
            zzhayVarZzb.zzd(zzhayVar);
        }
        return zzhayVarZzb;
    }
}
