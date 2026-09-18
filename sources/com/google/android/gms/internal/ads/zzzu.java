package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzzu implements zzaan {
    private zzzu() {
    }

    /* synthetic */ zzzu(zzzt zzztVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzaan
    public final boolean zza(long j, long j2, boolean z) {
        return j < -30000 && !z;
    }

    @Override // com.google.android.gms.internal.ads.zzaan
    public final boolean zzb(long j, long j2) {
        return j < -30000 && j2 > 100000;
    }

    @Override // com.google.android.gms.internal.ads.zzaan
    public final boolean zzc(long j, long j2, long j3, boolean z, boolean z2) {
        return false;
    }
}
