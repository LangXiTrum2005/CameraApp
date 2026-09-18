package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdkc implements zzhhd {
    private final zzdjr zza;
    private final zzhhu zzb;

    public zzdkc(zzdjr zzdjrVar, zzhhu zzhhuVar) {
        this.zza = zzdjrVar;
        this.zzb = zzhhuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setZzf = this.zza.zzf((zzczu) this.zzb.zzb());
        zzhhl.zzb(setZzf);
        return setZzf;
    }
}
