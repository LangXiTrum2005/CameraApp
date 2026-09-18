package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfba {
    public static zzexq zza(zzfae zzfaeVar, zzevq zzevqVar, ScheduledExecutorService scheduledExecutorService, int i) {
        zzexq zzexqVar = zzfaeVar;
        if (i == 0) {
            zzexqVar = zzevqVar;
        }
        return new zzevy(zzexqVar, 0L, scheduledExecutorService);
    }

    public static zzexq zzb(zzfao zzfaoVar, ScheduledExecutorService scheduledExecutorService) {
        return new zzevy(zzfaoVar, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdZ)).longValue(), scheduledExecutorService);
    }

    public static zzexq zzc(zzfbj zzfbjVar, ScheduledExecutorService scheduledExecutorService) {
        return new zzevy(zzfbjVar, 0L, scheduledExecutorService);
    }
}
