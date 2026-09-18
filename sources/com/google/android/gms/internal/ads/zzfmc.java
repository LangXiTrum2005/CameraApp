package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfmc implements zzflw {
    private final zzfmg zza;
    private final zzfme zzb;
    private final zzflt zzc;

    public zzfmc(zzflt zzfltVar, zzfmg zzfmgVar, zzfme zzfmeVar) {
        this.zzc = zzfltVar;
        this.zza = zzfmgVar;
        this.zzb = zzfmeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzflw
    public final String zza(zzflv zzflvVar) {
        zzfme zzfmeVar = this.zzb;
        Map mapZzj = zzflvVar.zzj();
        zzfmeVar.zza(mapZzj);
        return this.zza.zza(mapZzj);
    }

    @Override // com.google.android.gms.internal.ads.zzflw
    public final void zzb(zzflv zzflvVar) {
        this.zzc.zzb(zza(zzflvVar));
    }
}
