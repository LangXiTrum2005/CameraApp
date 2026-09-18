package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgad implements Map, Serializable {

    @CheckForNull
    private transient zzgaf zza;

    @CheckForNull
    private transient zzgaf zzb;

    @CheckForNull
    private transient zzfzv zzc;

    zzgad() {
    }

    public static zzgad zzc(Map map) {
        Set setEntrySet = map.entrySet();
        zzgac zzgacVar = new zzgac(setEntrySet instanceof Collection ? setEntrySet.size() : 4);
        zzgacVar.zzb(setEntrySet);
        return zzgacVar.zzc();
    }

    public static zzgad zzd() {
        return zzgbp.zza;
    }

    public static zzgad zze(Object obj, Object obj2) {
        zzfyx.zzb("dialog_not_shown_reason", obj2);
        return zzgbp.zzj(1, new Object[]{"dialog_not_shown_reason", obj2}, null);
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(@CheckForNull Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public final boolean equals(@CheckForNull Object obj) {
        return zzgav.zzb(this, obj);
    }

    @Override // java.util.Map
    @CheckForNull
    public abstract Object get(@CheckForNull Object obj);

    @Override // java.util.Map
    @CheckForNull
    public final Object getOrDefault(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return zzgca.zza(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final Object remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        zzfyx.zza(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, 1073741824L));
        sb.append('{');
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }

    abstract zzfzv zza();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzfzv values() {
        zzfzv zzfzvVar = this.zzc;
        if (zzfzvVar != null) {
            return zzfzvVar;
        }
        zzfzv zzfzvVarZza = zza();
        this.zzc = zzfzvVarZza;
        return zzfzvVarZza;
    }

    abstract zzgaf zzf();

    abstract zzgaf zzg();

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final zzgaf entrySet() {
        zzgaf zzgafVar = this.zza;
        if (zzgafVar != null) {
            return zzgafVar;
        }
        zzgaf zzgafVarZzf = zzf();
        this.zza = zzgafVarZzf;
        return zzgafVarZzf;
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final zzgaf keySet() {
        zzgaf zzgafVar = this.zzb;
        if (zzgafVar != null) {
            return zzgafVar;
        }
        zzgaf zzgafVarZzg = zzg();
        this.zzb = zzgafVarZzg;
        return zzgafVarZzg;
    }
}
