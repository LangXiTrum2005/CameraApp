package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
class zzfyh implements Iterator {
    final Iterator zza;

    @CheckForNull
    Object zzb = null;

    @CheckForNull
    Collection zzc = null;
    Iterator zzd = zzgai.INSTANCE;
    final /* synthetic */ zzfyt zze;

    zzfyh(zzfyt zzfytVar) {
        this.zze = zzfytVar;
        this.zza = zzfytVar.zza.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext() || this.zzd.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.zzd.hasNext()) {
            Map.Entry entry = (Map.Entry) this.zza.next();
            this.zzb = entry.getKey();
            Collection collection = (Collection) entry.getValue();
            this.zzc = collection;
            this.zzd = collection.iterator();
        }
        return this.zzd.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zzd.remove();
        if (((Collection) Objects.requireNonNull(this.zzc)).isEmpty()) {
            this.zza.remove();
        }
        this.zze.zzb--;
    }
}
