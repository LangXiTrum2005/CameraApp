package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgca {
    static int zza(Set set) {
        Iterator it = set.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    public static zzgbz zzb(Set set, Set set2) {
        zzfxe.zzc(set, "set1");
        zzfxe.zzc(set2, "set2");
        return new zzgbu(set, set2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.Collection, java.util.Set] */
    public static Set zzc(Set set, zzfxf zzfxfVar) {
        if (!(set instanceof SortedSet)) {
            if (!(set instanceof zzgbv)) {
                set.getClass();
                return new zzgbv(set, zzfxfVar);
            }
            zzgbv zzgbvVar = (zzgbv) set;
            return new zzgbv(zzgbvVar.zza, zzfxi.zza(zzgbvVar.zzb, zzfxfVar));
        }
        SortedSet sortedSet = (SortedSet) set;
        if (!(sortedSet instanceof zzgbv)) {
            sortedSet.getClass();
            return new zzgbw(sortedSet, zzfxfVar);
        }
        zzgbv zzgbvVar2 = (zzgbv) sortedSet;
        return new zzgbw((SortedSet) zzgbvVar2.zza, zzfxi.zza(zzgbvVar2.zzb, zzfxfVar));
    }

    static boolean zzd(Set set, @CheckForNull Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size() && set.containsAll(set2)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    static boolean zzf(Set set, Iterator it) {
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= set.remove(it.next());
        }
        return zRemove;
    }

    static boolean zze(Set set, Collection collection) {
        collection.getClass();
        if (collection instanceof zzgbg) {
            collection = ((zzgbg) collection).zza();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return zzf(set, collection.iterator());
        }
        Iterator it = set.iterator();
        collection.getClass();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }
}
