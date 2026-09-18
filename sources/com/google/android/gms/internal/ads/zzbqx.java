package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbqx implements Runnable {
    final /* synthetic */ zzbri zza;
    final /* synthetic */ zzbqe zzb;
    final /* synthetic */ ArrayList zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzbrj zze;

    zzbqx(zzbrj zzbrjVar, zzbri zzbriVar, zzbqe zzbqeVar, ArrayList arrayList, long j) {
        this.zza = zzbriVar;
        this.zzb = zzbqeVar;
        this.zzc = arrayList;
        this.zzd = j;
        this.zze = zzbrjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Trying to acquire lock");
        synchronized (this.zze.zza) {
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Lock acquired");
            if (this.zza.zze() != -1 && this.zza.zze() != 1) {
                this.zza.zzg();
                zzgey zzgeyVar = zzcep.zze;
                final zzbqe zzbqeVar = this.zzb;
                Objects.requireNonNull(zzbqeVar);
                zzgeyVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbqw
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzbqeVar.zzc();
                    }
                });
                String strValueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzd));
                int iZze = this.zza.zze();
                int i = this.zze.zzi;
                if (this.zzc.isEmpty()) {
                    str = ". Still waiting for the engine to be loaded";
                } else {
                    str = ". While waiting for the /jsLoaded gmsg, observed the loadNewJavascriptEngine latency is " + String.valueOf(this.zzc.get(0));
                }
                com.google.android.gms.ads.internal.util.zze.zza("Could not finish the full JS engine loading in " + strValueOf + " ms. JS engine session reference status(fullLoadTimeout) is " + iZze + ". Update status(fullLoadTimeout) is " + i + str + " ms. Total latency(fullLoadTimeout) is " + (com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() - this.zzd) + " ms at timeout. Rejecting.");
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Lock released");
                return;
            }
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Lock released, the promise is already settled");
        }
    }
}
