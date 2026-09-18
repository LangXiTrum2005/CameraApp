package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzid {
    private final MediaCodec.CryptoInfo zza;
    private final MediaCodec.CryptoInfo.Pattern zzb = zzf$$ExternalSyntheticApiModelOutline0.m(0, 0);

    static /* bridge */ /* synthetic */ void zza(zzid zzidVar, int i, int i2) {
        zzidVar.zzb.set(i, i2);
        zzidVar.zza.setPattern(zzidVar.zzb);
    }
}
