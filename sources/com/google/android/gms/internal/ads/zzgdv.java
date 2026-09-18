package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgdv extends zzgdx {
    zzgdv(zzfzv zzfzvVar, boolean z) {
        super(zzfzvVar, z);
        zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzgdx
    public final /* bridge */ /* synthetic */ Object zzG(List list) {
        ArrayList arrayListZza = zzgao.zza(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzgdw zzgdwVar = (zzgdw) it.next();
            arrayListZza.add(zzgdwVar != null ? zzgdwVar.zza : null);
        }
        return Collections.unmodifiableList(arrayListZza);
    }
}
