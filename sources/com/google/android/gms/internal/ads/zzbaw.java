package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbaw implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzbax zza;

    zzbaw(zzbax zzbaxVar) {
        this.zza = zzbaxVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zza.zzc) {
            this.zza.zzf = null;
            zzbax zzbaxVar = this.zza;
            if (zzbaxVar.zzd != null) {
                zzbaxVar.zzd = null;
            }
            this.zza.zzc.notifyAll();
        }
    }
}
