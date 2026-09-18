package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzeqo implements zzeqt {
    final /* synthetic */ zzeqp zza;

    zzeqo(zzeqp zzeqpVar) {
        this.zza = zzeqpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqt
    public final void zza() {
        synchronized (this.zza) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        synchronized (this.zza) {
            this.zza.zzc = ((zzcwh) obj).zzl();
            ((zzcwh) obj).zzj();
        }
    }
}
