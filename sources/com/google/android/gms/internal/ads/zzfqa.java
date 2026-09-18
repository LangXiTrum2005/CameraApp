package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfqa implements Runnable {
    zzfqa() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (zzfqd.zzc != null) {
            zzfqd.zzc.post(zzfqd.zzd);
            zzfqd.zzc.postDelayed(zzfqd.zze, 200L);
        }
    }
}
