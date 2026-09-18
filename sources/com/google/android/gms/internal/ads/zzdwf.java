package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class zzdwf {
    private final zzdwk zza;
    private final Executor zzb;
    private final Map zzc;

    public zzdwf(zzdwk zzdwkVar, Executor executor) {
        this.zza = zzdwkVar;
        this.zzc = zzdwkVar.zza();
        this.zzb = executor;
    }

    public final zzdwe zza() {
        zzdwe zzdweVar = new zzdwe(this);
        zzdwe.zza(zzdweVar);
        return zzdweVar;
    }

    public final void zze() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlb)).booleanValue()) {
            zzdwe zzdweVarZza = zza();
            zzdweVarZza.zzb("action", "pecr");
            zzdweVarZza.zzg();
        }
    }
}
