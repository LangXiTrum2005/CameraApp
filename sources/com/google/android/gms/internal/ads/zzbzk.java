package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbzk implements Callable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbzm zzb;

    zzbzk(zzbzm zzbzmVar, Context context) {
        this.zza = context;
        this.zzb = zzbzmVar;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x003a  */
    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzbzj zzbzjVarZza;
        zzbzl zzbzlVar = (zzbzl) this.zzb.zza.get(this.zza);
        if (zzbzlVar != null) {
            if (zzbzlVar.zza + ((Long) zzbhq.zza.zze()).longValue() < com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()) {
                zzbzjVarZza = new zzbzi(this.zza).zza();
            } else {
                zzbzjVarZza = new zzbzi(this.zza, zzbzlVar.zzb).zza();
            }
        } else {
            zzbzjVarZza = new zzbzi(this.zza).zza();
        }
        zzbzm zzbzmVar = this.zzb;
        zzbzmVar.zza.put(this.zza, new zzbzl(zzbzmVar, zzbzjVarZza));
        return zzbzjVarZza;
    }
}
