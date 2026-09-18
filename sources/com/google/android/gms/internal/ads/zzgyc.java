package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgyc implements Comparator {
    zzgyc() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzgyl zzgylVar = (zzgyl) obj;
        zzgyl zzgylVar2 = (zzgyl) obj2;
        zzgyf it = zzgylVar.iterator();
        zzgyf it2 = zzgylVar2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            int iCompareTo = Integer.valueOf(it.zza() & 255).compareTo(Integer.valueOf(it2.zza() & 255));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return Integer.valueOf(zzgylVar.zzd()).compareTo(Integer.valueOf(zzgylVar2.zzd()));
    }
}
