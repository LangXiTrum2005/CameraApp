package com.google.android.gms.internal.ads;

import android.media.metrics.LogSessionId;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzsw {
    public static void zza(zzsp zzspVar, zzpb zzpbVar) {
        LogSessionId logSessionIdZza = zzpbVar.zza();
        if (logSessionIdZza.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
            return;
        }
        zzspVar.zzb.setString("log-session-id", logSessionIdZza.getStringId());
    }
}
