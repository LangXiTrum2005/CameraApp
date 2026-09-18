package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzedt extends zzedw {
    private zzbyi zzh;

    zzedt(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zze = context;
        this.zzf = com.google.android.gms.ads.internal.zzt.zzt().zzb();
        this.zzg = scheduledExecutorService;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final synchronized void onConnected(Bundle bundle) {
        if (this.zzc) {
            return;
        }
        this.zzc = true;
        try {
            try {
                this.zzd.zzp().zzf(this.zzh, new zzedv(this));
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.zzt.zzo().zzw(th, "RemoteAdsServiceSignalClientTask.onConnected");
                this.zza.zzd(th);
            }
        } catch (RemoteException unused) {
            this.zza.zzd(new zzecf(1));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzedw, com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        String str = String.format(Locale.US, "Remote ad service connection suspended, cause: %d.", Integer.valueOf(i));
        zzcec.zze(str);
        this.zza.zzd(new zzecf(1, str));
    }

    public final synchronized ListenableFuture zza(zzbyi zzbyiVar, long j) {
        if (this.zzb) {
            return zzgen.zzo(this.zza, j, TimeUnit.MILLISECONDS, this.zzg);
        }
        this.zzb = true;
        this.zzh = zzbyiVar;
        zzb();
        ListenableFuture listenableFutureZzo = zzgen.zzo(this.zza, j, TimeUnit.MILLISECONDS, this.zzg);
        listenableFutureZzo.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeds
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzc();
            }
        }, zzcep.zzf);
        return listenableFutureZzo;
    }
}
