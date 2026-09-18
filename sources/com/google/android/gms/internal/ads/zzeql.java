package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzeql implements zzeqt {
    final /* synthetic */ zzeqm zza;

    zzeql(zzeqm zzeqmVar) {
        this.zza = zzeqmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqt
    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzj = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdjn zzdjnVar = (zzdjn) obj;
        synchronized (this.zza) {
            this.zza.zzj = zzdjnVar;
            this.zza.zzj.zzj();
        }
    }
}
