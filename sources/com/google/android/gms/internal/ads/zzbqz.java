package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbqz implements zzcew {
    final /* synthetic */ zzbri zza;
    final /* synthetic */ zzfmo zzb;
    final /* synthetic */ zzbrj zzc;

    zzbqz(zzbrj zzbrjVar, zzbri zzbriVar, zzfmo zzfmoVar) {
        this.zza = zzbriVar;
        this.zzb = zzfmoVar;
        this.zzc = zzbrjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcew
    public final void zza() {
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (failure): Trying to acquire lock");
        synchronized (this.zzc.zza) {
            com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (failure): Lock acquired");
            this.zzc.zzi = 1;
            com.google.android.gms.ads.internal.util.zze.zza("Failed loading new engine. Marking new engine destroyable.");
            this.zza.zzb();
            if (((Boolean) zzbht.zzd.zze()).booleanValue()) {
                zzbrj zzbrjVar = this.zzc;
                if (zzbrjVar.zze != null) {
                    zzfnc zzfncVar = zzbrjVar.zze;
                    zzfmo zzfmoVar = this.zzb;
                    zzfmoVar.zzc("Failed loading new engine");
                    zzfmoVar.zzf(false);
                    zzfncVar.zzb(zzfmoVar.zzl());
                }
            }
        }
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (failure): Lock released");
    }
}
