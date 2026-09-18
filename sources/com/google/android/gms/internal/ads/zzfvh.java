package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.remoteconfig.RemoteConfigConstants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfvh extends zzfvu {
    final /* synthetic */ zzfvn zza;
    final /* synthetic */ zzfvq zzb;
    final /* synthetic */ TaskCompletionSource zzc;
    final /* synthetic */ zzfvl zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfvh(zzfvl zzfvlVar, TaskCompletionSource taskCompletionSource, zzfvn zzfvnVar, zzfvq zzfvqVar, TaskCompletionSource taskCompletionSource2) {
        super(taskCompletionSource);
        this.zza = zzfvnVar;
        this.zzb = zzfvqVar;
        this.zzc = taskCompletionSource2;
        this.zzd = zzfvlVar;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [android.os.IInterface, com.google.android.gms.internal.ads.zzfum] */
    @Override // com.google.android.gms.internal.ads.zzfvu
    protected final void zza() {
        try {
            ?? Zze = this.zzd.zza.zze();
            if (Zze == 0) {
                return;
            }
            zzfvl zzfvlVar = this.zzd;
            String str = zzfvlVar.zzd;
            zzfvn zzfvnVar = this.zza;
            String str2 = zzfvlVar.zzd;
            Bundle bundle = new Bundle();
            bundle.putBinder("windowToken", zzfvnVar.zze());
            bundle.putString("adFieldEnifd", zzfvnVar.zzf());
            bundle.putInt("layoutGravity", zzfvnVar.zzc());
            bundle.putFloat("layoutVerticalMargin", zzfvnVar.zza());
            bundle.putInt("displayMode", 0);
            bundle.putInt("windowWidthPx", zzfvnVar.zzd());
            bundle.putString("deeplinkUrl", null);
            bundle.putBoolean("stableSessionToken", false);
            bundle.putString("callerPackage", str2);
            if (zzfvnVar.zzg() != null) {
                bundle.putString(RemoteConfigConstants.RequestFieldKey.APP_ID, zzfvnVar.zzg());
            }
            Zze.zzf(str, bundle, new zzfvk(this.zzd, this.zzb));
        } catch (RemoteException e) {
            zzfvl.zzb.zzb(e, "show overlay display from: %s", this.zzd.zzd);
            this.zzc.trySetException(new RuntimeException(e));
        }
    }
}
