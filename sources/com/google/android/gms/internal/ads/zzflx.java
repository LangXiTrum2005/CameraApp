package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzflx implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;
    private final zzhhu zzc;

    public zzflx(zzhhu zzhhuVar, zzhhu zzhhuVar2, zzhhu zzhhuVar3) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
        this.zzc = zzhhuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzhgx zzhgxVarZza = zzhhc.zza(zzhho.zza(this.zza));
        zzhgx zzhgxVarZza2 = zzhhc.zza(zzhho.zza(this.zzb));
        Object zzflzVar = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziA)).booleanValue() ? new zzflz((zzflw) zzhgxVarZza.zzb(), (ScheduledExecutorService) this.zzc.zzb()) : (zzflw) zzhgxVarZza2.zzb();
        zzhhl.zzb(zzflzVar);
        return zzflzVar;
    }
}
