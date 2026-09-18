package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcdh extends com.google.android.gms.ads.internal.util.zzb {
    final /* synthetic */ zzcdl zza;

    zzcdh(zzcdl zzcdlVar) {
        this.zza = zzcdlVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        zzcdl zzcdlVar = this.zza;
        zzbgi zzbgiVar = new zzbgi(zzcdlVar.zze, zzcdlVar.zzf.zza);
        synchronized (this.zza.zza) {
            try {
                com.google.android.gms.ads.internal.zzt.zze();
                zzbgl.zza(this.zza.zzh, zzbgiVar);
            } catch (IllegalArgumentException e) {
                zzcec.zzk("Cannot config CSI reporter.", e);
            }
        }
    }
}
