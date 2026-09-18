package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzflb implements zzgej {
    final /* synthetic */ zzfkr zza;
    final /* synthetic */ zzfld zzb;

    zzflb(zzfld zzfldVar, zzfkr zzfkrVar) {
        this.zza = zzfkrVar;
        this.zzb = zzfldVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        this.zzb.zza.zzd.zzb(this.zza, th);
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zzb(Object obj) {
        this.zzb.zza.zzd.zzd(this.zza);
    }
}
