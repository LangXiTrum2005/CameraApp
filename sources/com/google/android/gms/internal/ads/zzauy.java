package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzauy implements zzfru {
    final /* synthetic */ zzfqr zza;

    zzauy(zzfqr zzfqrVar) {
        this.zza = zzfqrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfru
    public final void zza(int i, long j) {
        this.zza.zzd(i, System.currentTimeMillis() - j);
    }

    @Override // com.google.android.gms.internal.ads.zzfru
    public final void zzb(int i, long j, String str) {
        this.zza.zze(i, System.currentTimeMillis() - j, str);
    }
}
