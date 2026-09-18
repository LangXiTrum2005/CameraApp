package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.remoteconfig.RemoteConfigConstants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfvi extends zzfvu {
    final /* synthetic */ zzfvc zza;
    final /* synthetic */ zzfvq zzb;
    final /* synthetic */ TaskCompletionSource zzc;
    final /* synthetic */ zzfvl zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfvi(zzfvl zzfvlVar, TaskCompletionSource taskCompletionSource, zzfvc zzfvcVar, zzfvq zzfvqVar, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zza = zzfvcVar;
        this.zzb = zzfvqVar;
        this.zzc = taskCompletionSource2;
        this.zzd = zzfvlVar;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.gms.internal.ads.zzfum] */
    @Override // com.google.android.gms.internal.ads.zzfvu
    protected final void zza() {
        try {
            ?? Zze = this.zzd.zza.zze();
            if (Zze == 0) {
                return;
            }
            zzfvc zzfvcVar = this.zza;
            String str = this.zzd.zzd;
            Bundle bundle = new Bundle();
            bundle.putString("sessionToken", zzfvcVar.zzb());
            bundle.putString("callerPackage", str);
            bundle.putString(RemoteConfigConstants.RequestFieldKey.APP_ID, zzfvcVar.zza());
            Zze.zze(bundle, new zzfvk(this.zzd, this.zzb));
        } catch (RemoteException e) {
            zzfvl.zzb.zzb(e, "dismiss overlay display from: %s", this.zzd.zzd);
            this.zzc.trySetException(new RuntimeException(e));
        }
    }
}
