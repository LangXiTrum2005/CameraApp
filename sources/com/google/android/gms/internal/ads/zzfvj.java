package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.remoteconfig.RemoteConfigConstants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfvj extends zzfvu {
    final /* synthetic */ zzfvs zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzfvq zzc;
    final /* synthetic */ TaskCompletionSource zzd;
    final /* synthetic */ zzfvl zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfvj(zzfvl zzfvlVar, TaskCompletionSource taskCompletionSource, zzfvs zzfvsVar, int i, zzfvq zzfvqVar, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zza = zzfvsVar;
        this.zzb = i;
        this.zzc = zzfvqVar;
        this.zzd = taskCompletionSource2;
        this.zze = zzfvlVar;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.gms.internal.ads.zzfum] */
    @Override // com.google.android.gms.internal.ads.zzfvu
    protected final void zza() {
        try {
            ?? Zze = this.zze.zza.zze();
            if (Zze == 0) {
                return;
            }
            zzfvs zzfvsVar = this.zza;
            String str = this.zze.zzd;
            int i = this.zzb;
            Bundle bundle = new Bundle();
            bundle.putString("sessionToken", zzfvsVar.zzb());
            bundle.putInt("displayMode", i);
            bundle.putString("callerPackage", str);
            bundle.putString(RemoteConfigConstants.RequestFieldKey.APP_ID, zzfvsVar.zza());
            Zze.zzg(bundle, new zzfvk(this.zze, this.zzc));
        } catch (RemoteException e) {
            zzfvl.zzb.zzb(e, "switchDisplayMode overlay display to %d from: %s", Integer.valueOf(this.zzb), this.zze.zzd);
            this.zzd.trySetException(new RuntimeException(e));
        }
    }
}
