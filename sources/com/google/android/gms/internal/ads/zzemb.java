package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzemb extends zzelw {
    private final zzclg zza;
    private final zzdaf zzb;
    private final zzeon zzc;
    private final zzdgo zzd;
    private final zzemh zze;
    private final zzeis zzf;

    public zzemb(zzclg zzclgVar, zzdaf zzdafVar, zzeon zzeonVar, zzdgo zzdgoVar, zzemh zzemhVar, zzeis zzeisVar) {
        this.zza = zzclgVar;
        this.zzb = zzdafVar;
        this.zzc = zzeonVar;
        this.zzd = zzdgoVar;
        this.zze = zzemhVar;
        this.zzf = zzeisVar;
    }

    @Override // com.google.android.gms.internal.ads.zzelw
    protected final ListenableFuture zzc(zzfhh zzfhhVar, Bundle bundle, zzfgm zzfgmVar, zzfgy zzfgyVar) {
        zzdaf zzdafVar = this.zzb;
        zzdafVar.zzi(zzfhhVar);
        zzdafVar.zzf(bundle);
        zzdafVar.zzg(new zzczz(zzfgyVar, zzfgmVar, this.zze));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzds)).booleanValue()) {
            this.zzb.zzd(this.zzf);
        }
        zzclg zzclgVar = this.zza;
        zzdaf zzdafVar2 = this.zzb;
        zzdkn zzdknVarZzg = zzclgVar.zzg();
        zzdknVarZzg.zze(zzdafVar2.zzj());
        zzdknVarZzg.zzd(this.zzd);
        zzdknVarZzg.zzc(this.zzc);
        zzcxp zzcxpVarZza = zzdknVarZzg.zzf().zza();
        return zzcxpVarZza.zzi(zzcxpVarZza.zzj());
    }
}
