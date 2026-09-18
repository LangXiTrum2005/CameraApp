package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeuc implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;

    public zzeuc(zzhhu zzhhuVar, zzhhu zzhhuVar2) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgaf zzgafVarZzn;
        zzets zzetsVarZza = zzetu.zza();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zzb.zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdV)).booleanValue()) {
            zzgafVarZzn = zzgaf.zzo(new zzevy(zzetsVarZza, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdW)).intValue(), scheduledExecutorService));
        } else {
            zzgafVarZzn = zzgaf.zzn();
        }
        zzhhl.zzb(zzgafVarZzn);
        return zzgafVarZzn;
    }
}
