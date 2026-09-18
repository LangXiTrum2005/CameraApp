package com.google.android.gms.internal.ads;

import android.os.IBinder;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfwa extends zzfvu {
    final /* synthetic */ IBinder zza;
    final /* synthetic */ zzfwd zzb;

    zzfwa(zzfwd zzfwdVar, IBinder iBinder) {
        this.zza = iBinder;
        this.zzb = zzfwdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvu
    public final void zza() {
        this.zzb.zza.zzn = zzful.zzb(this.zza);
        zzfwe.zzq(this.zzb.zza);
        this.zzb.zza.zzh = false;
        Iterator it = this.zzb.zza.zze.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.zzb.zza.zze.clear();
    }
}
