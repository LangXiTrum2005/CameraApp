package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfcr implements zzeqt {
    final /* synthetic */ zzfcs zza;

    zzfcr(zzfcs zzfcsVar) {
        this.zza = zzfcsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeqt
    public final void zza() {
        synchronized (this.zza) {
            this.zza.zza = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeqt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzctz zzctzVar = (zzctz) obj;
        synchronized (this.zza) {
            zzctz zzctzVar2 = this.zza.zza;
            if (zzctzVar2 != null) {
                zzctzVar2.zzb();
            }
            zzfcs zzfcsVar = this.zza;
            zzfcsVar.zza = zzctzVar;
            zzctzVar.zzc(zzfcsVar);
            zzfcs zzfcsVar2 = this.zza;
            zzfcsVar2.zzg.zzk(new zzcua(zzctzVar, zzfcsVar2, zzfcsVar2.zzg, zzfcsVar2.zzi));
            zzctzVar.zzj();
        }
    }
}
