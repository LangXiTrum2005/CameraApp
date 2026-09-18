package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfzd extends AbstractSet {
    final /* synthetic */ zzfzj zza;

    zzfzd(zzfzj zzfzjVar) {
        this.zza = zzfzjVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        Map mapZzl = this.zza.zzl();
        if (mapZzl != null) {
            return mapZzl.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int iZzw = this.zza.zzw(entry.getKey());
            if (iZzw != -1 && zzfwy.zza(zzfzj.zzj(this.zza, iZzw), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        zzfzj zzfzjVar = this.zza;
        Map mapZzl = zzfzjVar.zzl();
        return mapZzl != null ? mapZzl.entrySet().iterator() : new zzfzb(zzfzjVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@CheckForNull Object obj) {
        Map mapZzl = this.zza.zzl();
        if (mapZzl != null) {
            return mapZzl.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        zzfzj zzfzjVar = this.zza;
        if (zzfzjVar.zzr()) {
            return false;
        }
        int iZzv = zzfzjVar.zzv();
        Object key = entry.getKey();
        Object value = entry.getValue();
        zzfzj zzfzjVar2 = this.zza;
        int iZzb = zzfzk.zzb(key, value, iZzv, Objects.requireNonNull(zzfzjVar2.zze), zzfzjVar2.zzA(), zzfzjVar2.zzB(), zzfzjVar2.zzC());
        if (iZzb == -1) {
            return false;
        }
        this.zza.zzq(iZzb, iZzv);
        this.zza.zzg--;
        this.zza.zzo();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }
}
