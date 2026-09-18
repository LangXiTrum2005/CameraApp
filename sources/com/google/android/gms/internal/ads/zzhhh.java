package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhhh extends zzhgz {
    private static final zzhhm zza = zzhhe.zza(Collections.emptyMap());

    /* synthetic */ zzhhh(Map map, zzhhf zzhhfVar) {
        super(map);
    }

    public static zzhhg zzc(int i) {
        return new zzhhg(i, null);
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final Map zzb() {
        LinkedHashMap linkedHashMapZzb = zzhha.zzb(zza().size());
        for (Map.Entry entry : zza().entrySet()) {
            linkedHashMapZzb.put(entry.getKey(), ((zzhhm) entry.getValue()).zzb());
        }
        return Collections.unmodifiableMap(linkedHashMapZzb);
    }
}
