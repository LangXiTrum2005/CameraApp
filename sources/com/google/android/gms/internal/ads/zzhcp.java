package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzhcp {
    zzhcp() {
    }

    abstract int zza(Object obj);

    abstract int zzb(Object obj);

    abstract Object zzc(Object obj);

    abstract Object zzd(Object obj);

    abstract Object zze(Object obj, Object obj2);

    abstract Object zzf();

    abstract Object zzg(Object obj);

    abstract void zzh(Object obj, int i, int i2);

    abstract void zzi(Object obj, int i, long j);

    abstract void zzj(Object obj, int i, Object obj2);

    abstract void zzk(Object obj, int i, zzgyl zzgylVar);

    abstract void zzl(Object obj, int i, long j);

    abstract void zzm(Object obj);

    abstract void zzn(Object obj, Object obj2);

    abstract void zzo(Object obj, Object obj2);

    abstract boolean zzq(zzhbq zzhbqVar);

    abstract void zzr(Object obj, zzgzb zzgzbVar) throws IOException;

    final boolean zzp(Object obj, zzhbq zzhbqVar) throws IOException {
        int iZzd = zzhbqVar.zzd();
        int i = iZzd >>> 3;
        int i2 = iZzd & 7;
        if (i2 == 0) {
            zzl(obj, i, zzhbqVar.zzl());
            return true;
        }
        if (i2 == 1) {
            zzi(obj, i, zzhbqVar.zzk());
            return true;
        }
        if (i2 == 2) {
            zzk(obj, i, zzhbqVar.zzp());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzhag.zza();
            }
            zzh(obj, i, zzhbqVar.zzf());
            return true;
        }
        Object objZzf = zzf();
        int i3 = i << 3;
        while (zzhbqVar.zzc() != Integer.MAX_VALUE && zzp(objZzf, zzhbqVar)) {
        }
        if ((4 | i3) != zzhbqVar.zzd()) {
            throw zzhag.zzb();
        }
        zzg(objZzf);
        zzj(obj, i, objZzf);
        return true;
    }
}
