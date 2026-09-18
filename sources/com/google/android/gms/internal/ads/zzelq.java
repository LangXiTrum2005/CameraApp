package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzelq implements zzgej {
    final /* synthetic */ zzfgm zza;
    final /* synthetic */ zzelr zzb;

    zzelq(zzelr zzelrVar, zzfgm zzfgmVar) {
        this.zza = zzfgmVar;
        this.zzb = zzelrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        synchronized (this.zzb) {
            this.zzb.zzh.zzb(th, this.zza);
            if (this.zzb.zzh.zze()) {
                zzelr zzelrVar = this.zzb;
                zzelrVar.zze(zzelrVar.zzh.zza());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzemi zzemiVar = (zzemi) obj;
        synchronized (this.zzb) {
            this.zzb.zzh.zzc(zzemiVar, this.zza);
            if (this.zzb.zzh.zze()) {
                zzelr zzelrVar = this.zzb;
                zzelrVar.zze(zzelrVar.zzh.zza());
            }
        }
    }
}
