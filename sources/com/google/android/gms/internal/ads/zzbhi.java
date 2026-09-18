package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbhi implements zzhhd {
    private final zzhhu zza;

    public zzbhi(zzhhu zzhhuVar) {
        this.zza = zzhhuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzbhh zzb() {
        return new zzbhh((ScheduledExecutorService) this.zza.zzb());
    }
}
