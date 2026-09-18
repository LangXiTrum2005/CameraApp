package com.google.android.gms.internal.ads;

import android.app.AppOpsManager$OnOpActiveChangedListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzawr implements AppOpsManager$OnOpActiveChangedListener {
    final /* synthetic */ zzaws zza;

    zzawr(zzaws zzawsVar) {
        this.zza = zzawsVar;
    }

    public final void onOpActiveChanged(String str, int i, String str2, boolean z) {
        if (z) {
            this.zza.zzb = System.currentTimeMillis();
            this.zza.zze = true;
            return;
        }
        zzaws zzawsVar = this.zza;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (zzawsVar.zzc > 0) {
            zzaws zzawsVar2 = this.zza;
            if (jCurrentTimeMillis >= zzawsVar2.zzc) {
                zzawsVar2.zzd = jCurrentTimeMillis - zzawsVar2.zzc;
            }
        }
        this.zza.zze = false;
    }
}
