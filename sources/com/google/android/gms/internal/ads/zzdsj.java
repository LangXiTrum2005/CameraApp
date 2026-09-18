package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdsj extends VideoController.VideoLifecycleCallbacks {
    private final zzdna zza;

    public zzdsj(zzdna zzdnaVar) {
        this.zza = zzdnaVar;
    }

    private static com.google.android.gms.ads.internal.client.zzdt zza(zzdna zzdnaVar) {
        com.google.android.gms.ads.internal.client.zzdq zzdqVarZzj = zzdnaVar.zzj();
        if (zzdqVarZzj == null) {
            return null;
        }
        try {
            return zzdqVarZzj.zzi();
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoEnd() {
        com.google.android.gms.ads.internal.client.zzdt zzdtVarZza = zza(this.zza);
        if (zzdtVarZza == null) {
            return;
        }
        try {
            zzdtVarZza.zze();
        } catch (RemoteException e) {
            zzcec.zzk("Unable to call onVideoEnd()", e);
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoPause() {
        com.google.android.gms.ads.internal.client.zzdt zzdtVarZza = zza(this.zza);
        if (zzdtVarZza == null) {
            return;
        }
        try {
            zzdtVarZza.zzg();
        } catch (RemoteException e) {
            zzcec.zzk("Unable to call onVideoEnd()", e);
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoStart() {
        com.google.android.gms.ads.internal.client.zzdt zzdtVarZza = zza(this.zza);
        if (zzdtVarZza == null) {
            return;
        }
        try {
            zzdtVarZza.zzi();
        } catch (RemoteException e) {
            zzcec.zzk("Unable to call onVideoEnd()", e);
        }
    }
}
