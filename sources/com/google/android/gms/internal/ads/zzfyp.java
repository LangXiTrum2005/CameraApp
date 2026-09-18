package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
class zzfyp implements Iterator {
    final Iterator zza;
    final Collection zzb;
    final /* synthetic */ zzfyq zzc;

    zzfyp(zzfyq zzfyqVar) {
        this.zzc = zzfyqVar;
        this.zzb = zzfyqVar.zzb;
        Collection collection = zzfyqVar.zzb;
        this.zza = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    zzfyp(zzfyq zzfyqVar, Iterator it) {
        this.zzc = zzfyqVar;
        this.zzb = zzfyqVar.zzb;
        this.zza = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        zza();
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zza.remove();
        this.zzc.zze.zzb--;
        this.zzc.zzc();
    }

    final void zza() {
        this.zzc.zzb();
        if (this.zzc.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }
}
