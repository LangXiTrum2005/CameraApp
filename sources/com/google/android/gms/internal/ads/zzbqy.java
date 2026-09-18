package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbqy implements zzcey {
    final /* synthetic */ zzbri zza;
    final /* synthetic */ zzfmo zzb;
    final /* synthetic */ zzbrj zzc;

    zzbqy(zzbrj zzbrjVar, zzbri zzbriVar, zzfmo zzfmoVar) {
        this.zza = zzbriVar;
        this.zzb = zzfmoVar;
        this.zzc = zzbrjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcey
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (success): Trying to acquire lock");
        synchronized (this.zzc.zza) {
            com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (success): Lock acquired");
            this.zzc.zzi = 0;
            zzbrj zzbrjVar = this.zzc;
            if (zzbrjVar.zzh != null && this.zza != zzbrjVar.zzh) {
                com.google.android.gms.ads.internal.util.zze.zza("New JS engine is loaded, marking previous one as destroyable.");
                this.zzc.zzh.zzb();
            }
            this.zzc.zzh = this.zza;
            if (((Boolean) zzbht.zzd.zze()).booleanValue()) {
                zzbrj zzbrjVar2 = this.zzc;
                if (zzbrjVar2.zze != null) {
                    zzfnc zzfncVar = zzbrjVar2.zze;
                    zzfmo zzfmoVar = this.zzb;
                    zzfmoVar.zzf(true);
                    zzfncVar.zzb(zzfmoVar.zzl());
                }
            }
        }
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (success): Lock released");
    }
}
