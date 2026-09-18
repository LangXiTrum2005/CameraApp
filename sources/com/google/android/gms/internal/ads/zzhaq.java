package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhaq extends zzhas {
    private zzhaq() {
        super(null);
    }

    /* synthetic */ zzhaq(zzhap zzhapVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    final List zza(Object obj, long j) {
        zzhad zzhadVar = (zzhad) zzhcz.zzh(obj, j);
        if (zzhadVar.zzc()) {
            return zzhadVar;
        }
        int size = zzhadVar.size();
        zzhad zzhadVarZzd = zzhadVar.zzd(size == 0 ? 10 : size + size);
        zzhcz.zzv(obj, j, zzhadVarZzd);
        return zzhadVarZzd;
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    final void zzb(Object obj, long j) {
        ((zzhad) zzhcz.zzh(obj, j)).zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzhas
    final void zzc(Object obj, Object obj2, long j) {
        zzhad zzhadVarZzd = (zzhad) zzhcz.zzh(obj, j);
        zzhad zzhadVar = (zzhad) zzhcz.zzh(obj2, j);
        int size = zzhadVarZzd.size();
        int size2 = zzhadVar.size();
        if (size > 0 && size2 > 0) {
            if (!zzhadVarZzd.zzc()) {
                zzhadVarZzd = zzhadVarZzd.zzd(size2 + size);
            }
            zzhadVarZzd.addAll(zzhadVar);
        }
        if (size > 0) {
            zzhadVar = zzhadVarZzd;
        }
        zzhcz.zzv(obj, j, zzhadVar);
    }
}
