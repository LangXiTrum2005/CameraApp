package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzazh implements Runnable {
    final /* synthetic */ zzazi zza;

    zzazh(zzazi zzaziVar) {
        this.zza = zzaziVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza.zzc) {
            zzazi zzaziVar = this.zza;
            if (zzaziVar.zzd && zzaziVar.zze) {
                zzaziVar.zzd = false;
                zzcec.zze("App went background");
                Iterator it = this.zza.zzf.iterator();
                while (it.hasNext()) {
                    try {
                        ((zzazj) it.next()).zza(false);
                    } catch (Exception e) {
                        zzcec.zzh("", e);
                    }
                }
            } else {
                zzcec.zze("App is still foreground");
            }
        }
    }
}
