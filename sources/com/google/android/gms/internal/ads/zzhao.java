package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhao extends zzhas {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzhao() {
        super(null);
    }

    /* synthetic */ zzhao(zzhan zzhanVar) {
        super(null);
    }

    private static List zzf(Object obj, long j, int i) {
        List list;
        List listZzd;
        List list2 = (List) zzhcz.zzh(obj, j);
        if (list2.isEmpty()) {
            if (list2 instanceof zzham) {
                listZzd = new zzhal(i);
            } else {
                listZzd = ((list2 instanceof zzhbm) && (list2 instanceof zzhad)) ? ((zzhad) list2).zzd(i) : new ArrayList(i);
            }
            zzhcz.zzv(obj, j, listZzd);
            return listZzd;
        }
        if (zza.isAssignableFrom(list2.getClass())) {
            ArrayList arrayList = new ArrayList(list2.size() + i);
            arrayList.addAll(list2);
            zzhcz.zzv(obj, j, arrayList);
            list = arrayList;
        } else {
            if (!(list2 instanceof zzhcu)) {
                if (!(list2 instanceof zzhbm) || !(list2 instanceof zzhad)) {
                    return list2;
                }
                zzhad zzhadVar = (zzhad) list2;
                if (zzhadVar.zzc()) {
                    return list2;
                }
                zzhad zzhadVarZzd = zzhadVar.zzd(list2.size() + i);
                zzhcz.zzv(obj, j, zzhadVarZzd);
                return zzhadVarZzd;
            }
            zzhal zzhalVar = new zzhal(list2.size() + i);
            zzhalVar.addAll(zzhalVar.size(), (zzhcu) list2);
            zzhcz.zzv(obj, j, zzhalVar);
            list = zzhalVar;
        }
        return list;
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    final List zza(Object obj, long j) {
        return zzf(obj, j, 10);
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    final void zzb(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzhcz.zzh(obj, j);
        if (list instanceof zzham) {
            objUnmodifiableList = ((zzham) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzhbm) && (list instanceof zzhad)) {
                zzhad zzhadVar = (zzhad) list;
                if (zzhadVar.zzc()) {
                    zzhadVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzhcz.zzv(obj, j, objUnmodifiableList);
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    final void zzc(Object obj, Object obj2, long j) {
        List list = (List) zzhcz.zzh(obj2, j);
        List listZzf = zzf(obj, j, list.size());
        int size = listZzf.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            listZzf.addAll(list);
        }
        if (size > 0) {
            list = listZzf;
        }
        zzhcz.zzv(obj, j, list);
    }
}
