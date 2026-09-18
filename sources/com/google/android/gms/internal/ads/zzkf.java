package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.metrics.LogSessionId;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkf {
    public static zzpb zza(Context context, zzko zzkoVar, boolean z) {
        zzox zzoxVarZzb = zzox.zzb(context);
        if (zzoxVarZzb == null) {
            zzff.zzf("ExoPlayerImpl", "MediaMetricsService unavailable.");
            return new zzpb(LogSessionId.LOG_SESSION_ID_NONE);
        }
        if (z) {
            zzkoVar.zzz(zzoxVarZzb);
        }
        return new zzpb(zzoxVarZzb.zza());
    }
}
