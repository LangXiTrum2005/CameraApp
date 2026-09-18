package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcby implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;

    public zzcby(zzhhu zzhhuVar, zzhhu zzhhuVar2) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcbx zzb() {
        return new zzcbx((Clock) this.zza.zzb(), (zzcbv) this.zzb.zzb());
    }
}
