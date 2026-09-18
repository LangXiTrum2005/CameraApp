package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzepj implements zzeqt {
    final /* synthetic */ zzepk zza;

    zzepj(zzepk zzepkVar) {
        this.zza = zzepkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqt
    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzi = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcuf zzcufVar = (zzcuf) obj;
        synchronized (this.zza) {
            zzepk zzepkVar = this.zza;
            if (zzepkVar.zzi != null) {
                zzepkVar.zzi.zzb();
            }
            this.zza.zzi = zzcufVar;
            this.zza.zzi.zzj();
        }
    }
}
