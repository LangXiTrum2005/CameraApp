package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfzi extends AbstractCollection {
    final /* synthetic */ zzfzj zza;

    zzfzi(zzfzj zzfzjVar) {
        this.zza = zzfzjVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        zzfzj zzfzjVar = this.zza;
        Map mapZzl = zzfzjVar.zzl();
        return mapZzl != null ? mapZzl.values().iterator() : new zzfzc(zzfzjVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.zza.size();
    }
}
