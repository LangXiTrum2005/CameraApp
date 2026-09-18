package com.google.android.gms.internal.ads;

import com.google.firebase.messaging.Constants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdyh extends zzbpg {
    final /* synthetic */ Object zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzfmo zzd;
    final /* synthetic */ zzceu zze;
    final /* synthetic */ zzdyi zzf;

    zzdyh(zzdyi zzdyiVar, Object obj, String str, long j, zzfmo zzfmoVar, zzceu zzceuVar) {
        this.zza = obj;
        this.zzb = str;
        this.zzc = j;
        this.zzd = zzfmoVar;
        this.zze = zzceuVar;
        this.zzf = zzdyiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbph
    public final void zze(String str) {
        synchronized (this.zza) {
            this.zzf.zzv(this.zzb, false, str, (int) (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - this.zzc));
            this.zzf.zzl.zzb(this.zzb, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
            this.zzf.zzo.zzb(this.zzb, Constants.IPC_BUNDLE_KEY_SEND_ERROR);
            zzfnc zzfncVar = this.zzf.zzp;
            zzfmo zzfmoVar = this.zzd;
            zzfmoVar.zzc(str);
            zzfmoVar.zzf(false);
            zzfncVar.zzb(zzfmoVar.zzl());
            this.zze.zzc(false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbph
    public final void zzf() {
        synchronized (this.zza) {
            this.zzf.zzv(this.zzb, true, "", (int) (com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - this.zzc));
            this.zzf.zzl.zzd(this.zzb);
            this.zzf.zzo.zzd(this.zzb);
            zzfnc zzfncVar = this.zzf.zzp;
            zzfmo zzfmoVar = this.zzd;
            zzfmoVar.zzf(true);
            zzfncVar.zzb(zzfmoVar.zzl());
            this.zze.zzc(true);
        }
    }
}
