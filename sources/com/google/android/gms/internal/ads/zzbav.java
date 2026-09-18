package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbav implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zzbax zza;

    zzbav(zzbax zzbaxVar) {
        this.zza = zzbaxVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.zza.zzc) {
            try {
                zzbax zzbaxVar = this.zza;
                if (zzbaxVar.zzd != null) {
                    zzbaxVar.zzf = zzbaxVar.zzd.zzq();
                }
            } catch (DeadObjectException e) {
                zzcec.zzh("Unable to obtain a cache service instance.", e);
                zzbax.zzh(this.zza);
            }
            this.zza.zzc.notifyAll();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        synchronized (this.zza.zzc) {
            this.zza.zzf = null;
            this.zza.zzc.notifyAll();
        }
    }
}
