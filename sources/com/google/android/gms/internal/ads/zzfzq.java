package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfzq extends zzfzr implements Map {
    protected zzfzq() {
    }

    @Override // java.util.Map
    public final void clear() {
        zzb().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(@CheckForNull Object obj) {
        return zzb().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(@CheckForNull Object obj) {
        return zzb().containsValue(obj);
    }

    @Override // java.util.Map
    public Set entrySet() {
        return zzb().entrySet();
    }

    @Override // java.util.Map
    public boolean equals(@CheckForNull Object obj) {
        return obj == this || zzb().equals(obj);
    }

    @Override // java.util.Map
    @CheckForNull
    public Object get(@CheckForNull Object obj) {
        return zzb().get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return zzb().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return zzb().isEmpty();
    }

    @Override // java.util.Map
    public Set keySet() {
        return zzb().keySet();
    }

    @Override // java.util.Map
    @CheckForNull
    public final Object put(Object obj, Object obj2) {
        return zzb().put(obj, obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        zzb().putAll(map);
    }

    @Override // java.util.Map
    @CheckForNull
    public final Object remove(@CheckForNull Object obj) {
        return zzb().remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return zzb().size();
    }

    @Override // java.util.Map
    public final Collection values() {
        return zzb().values();
    }

    @Override // com.google.android.gms.internal.ads.zzfzr
    protected /* bridge */ /* synthetic */ Object zza() {
        throw null;
    }

    protected abstract Map zzb();

    protected final int zzc() {
        return zzgca.zza(entrySet());
    }

    protected final boolean zzd(@CheckForNull Object obj) {
        zzgaq zzgaqVar = new zzgaq(entrySet().iterator());
        if (obj == null) {
            while (zzgaqVar.hasNext()) {
                if (zzgaqVar.next() == null) {
                    return true;
                }
            }
        } else {
            while (zzgaqVar.hasNext()) {
                if (obj.equals(zzgaqVar.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    protected final boolean zze(@CheckForNull Object obj) {
        return zzgav.zzb(this, obj);
    }
}
