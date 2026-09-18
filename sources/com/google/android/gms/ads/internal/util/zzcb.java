package com.google.android.gms.ads.internal.util;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzcb {
    private long zza;
    private long zzb = Long.MIN_VALUE;
    private final Object zzc = new Object();

    public zzcb(long j) {
        this.zza = j;
    }

    public final void zza(long j) {
        synchronized (this.zzc) {
            this.zza = j;
        }
    }

    public final boolean zzb() {
        synchronized (this.zzc) {
            long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
            if (this.zzb + this.zza > jElapsedRealtime) {
                return false;
            }
            this.zzb = jElapsedRealtime;
            return true;
        }
    }
}
