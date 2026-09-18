package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzcec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzev implements Runnable {
    final /* synthetic */ zzew zza;

    zzev(zzew zzewVar) {
        this.zza = zzewVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzew zzewVar = this.zza;
        if (zzewVar.zza != null) {
            try {
                zzewVar.zza.zze(1);
            } catch (RemoteException e) {
                zzcec.zzk("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
