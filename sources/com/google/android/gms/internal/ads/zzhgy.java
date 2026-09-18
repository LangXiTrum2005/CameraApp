package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzhgy {
    final LinkedHashMap zza;

    zzhgy(int i) {
        this.zza = zzhha.zzb(i);
    }

    final zzhgy zza(Object obj, zzhhm zzhhmVar) {
        zzhhl.zza(obj, "key");
        zzhhl.zza(zzhhmVar, "provider");
        this.zza.put(obj, zzhhmVar);
        return this;
    }
}
