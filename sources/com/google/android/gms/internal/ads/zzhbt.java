package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhbt {
    private final ArrayDeque zza = new ArrayDeque();

    private zzhbt() {
    }

    static /* bridge */ /* synthetic */ zzgyl zza(zzhbt zzhbtVar, zzgyl zzgylVar, zzgyl zzgylVar2) {
        zzhbtVar.zzb(zzgylVar);
        zzhbtVar.zzb(zzgylVar2);
        zzgyl zzhbxVar = (zzgyl) zzhbtVar.zza.pop();
        while (!zzhbtVar.zza.isEmpty()) {
            zzhbxVar = new zzhbx((zzgyl) zzhbtVar.zza.pop(), zzhbxVar);
        }
        return zzhbxVar;
    }

    private final void zzb(zzgyl zzgylVar) {
        zzhbw zzhbwVar;
        if (!zzgylVar.zzh()) {
            if (!(zzgylVar instanceof zzhbx)) {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(String.valueOf(zzgylVar.getClass()))));
            }
            zzhbx zzhbxVar = (zzhbx) zzgylVar;
            zzb(zzhbxVar.zzd);
            zzb(zzhbxVar.zze);
            return;
        }
        int iZzc = zzc(zzgylVar.zzd());
        ArrayDeque arrayDeque = this.zza;
        int iZzc2 = zzhbx.zzc(iZzc + 1);
        if (arrayDeque.isEmpty() || ((zzgyl) this.zza.peek()).zzd() >= iZzc2) {
            this.zza.push(zzgylVar);
            return;
        }
        int iZzc3 = zzhbx.zzc(iZzc);
        zzgyl zzhbxVar2 = (zzgyl) this.zza.pop();
        while (true) {
            zzhbwVar = null;
            if (this.zza.isEmpty() || ((zzgyl) this.zza.peek()).zzd() >= iZzc3) {
                break;
            } else {
                zzhbxVar2 = new zzhbx((zzgyl) this.zza.pop(), zzhbxVar2);
            }
        }
        zzhbx zzhbxVar3 = new zzhbx(zzhbxVar2, zzgylVar);
        while (!this.zza.isEmpty()) {
            int iZzc4 = zzc(zzhbxVar3.zzd()) + 1;
            ArrayDeque arrayDeque2 = this.zza;
            if (((zzgyl) arrayDeque2.peek()).zzd() >= zzhbx.zzc(iZzc4)) {
                break;
            } else {
                zzhbxVar3 = new zzhbx((zzgyl) this.zza.pop(), zzhbxVar3);
            }
        }
        this.zza.push(zzhbxVar3);
    }

    private static final int zzc(int i) {
        int iBinarySearch = Arrays.binarySearch(zzhbx.zza, i);
        return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
    }

    /* synthetic */ zzhbt(zzhbs zzhbsVar) {
    }
}
