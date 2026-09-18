package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
class zzfyq extends AbstractCollection {
    final Object zza;
    Collection zzb;

    @CheckForNull
    final zzfyq zzc;

    @CheckForNull
    final Collection zzd;
    final /* synthetic */ zzfyt zze;

    zzfyq(zzfyt zzfytVar, Object obj, @CheckForNull Collection collection, zzfyq zzfyqVar) {
        this.zze = zzfytVar;
        this.zza = obj;
        this.zzb = collection;
        this.zzc = zzfyqVar;
        this.zzd = zzfyqVar == null ? null : zzfyqVar.zzb;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        zzb();
        boolean zIsEmpty = this.zzb.isEmpty();
        boolean zAdd = this.zzb.add(obj);
        if (zAdd) {
            this.zze.zzb++;
            if (zIsEmpty) {
                zza();
                return true;
            }
        }
        return zAdd;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = this.zzb.addAll(collection);
        if (!zAddAll) {
            return zAddAll;
        }
        int size2 = this.zzb.size();
        this.zze.zzb += size2 - size;
        if (size != 0) {
            return zAddAll;
        }
        zza();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        int size = size();
        if (size == 0) {
            return;
        }
        this.zzb.clear();
        this.zze.zzb -= size;
        zzc();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        zzb();
        return this.zzb.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean containsAll(Collection collection) {
        zzb();
        return this.zzb.containsAll(collection);
    }

    @Override // java.util.Collection
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        zzb();
        return this.zzb.equals(obj);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        zzb();
        return this.zzb.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        zzb();
        return new zzfyp(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(@CheckForNull Object obj) {
        zzb();
        boolean zRemove = this.zzb.remove(obj);
        if (zRemove) {
            this.zze.zzb--;
            zzc();
        }
        return zRemove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zRemoveAll = this.zzb.removeAll(collection);
        if (zRemoveAll) {
            int size2 = this.zzb.size();
            this.zze.zzb += size2 - size;
            zzc();
        }
        return zRemoveAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        zzb();
        return this.zzb.size();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        zzb();
        return this.zzb.toString();
    }

    final void zza() {
        zzfyq zzfyqVar = this.zzc;
        if (zzfyqVar != null) {
            zzfyqVar.zza();
            return;
        }
        zzfyt zzfytVar = this.zze;
        zzfytVar.zza.put(this.zza, this.zzb);
    }

    final void zzb() {
        zzfyq zzfyqVar = this.zzc;
        if (zzfyqVar != null) {
            zzfyqVar.zzb();
            zzfyq zzfyqVar2 = this.zzc;
            if (zzfyqVar2.zzb != this.zzd) {
                throw new ConcurrentModificationException();
            }
            return;
        }
        if (this.zzb.isEmpty()) {
            zzfyt zzfytVar = this.zze;
            Collection collection = (Collection) zzfytVar.zza.get(this.zza);
            if (collection != null) {
                this.zzb = collection;
            }
        }
    }

    final void zzc() {
        zzfyq zzfyqVar = this.zzc;
        if (zzfyqVar != null) {
            zzfyqVar.zzc();
        } else if (this.zzb.isEmpty()) {
            zzfyt zzfytVar = this.zze;
            zzfytVar.zza.remove(this.zza);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        int size = size();
        boolean zRetainAll = this.zzb.retainAll(collection);
        if (zRetainAll) {
            int size2 = this.zzb.size();
            this.zze.zzb += size2 - size;
            zzc();
        }
        return zRetainAll;
    }
}
