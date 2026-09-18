package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzfzp {
    private static final zzfzp zza = new zzfzm();
    private static final zzfzp zzb = new zzfzn(-1);
    private static final zzfzp zzc = new zzfzn(1);

    /* synthetic */ zzfzp(zzfzo zzfzoVar) {
    }

    public static zzfzp zzk() {
        return zza;
    }

    public abstract int zza();

    public abstract zzfzp zzb(int i, int i2);

    public abstract zzfzp zzc(long j, long j2);

    public abstract zzfzp zzd(Object obj, Object obj2, Comparator comparator);

    public abstract zzfzp zze(boolean z, boolean z2);

    public abstract zzfzp zzf(boolean z, boolean z2);
}
