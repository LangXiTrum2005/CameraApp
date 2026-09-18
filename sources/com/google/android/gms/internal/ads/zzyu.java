package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzyu {
    private final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public final void zza(Handler handler, zzyv zzyvVar) {
        zzc(zzyvVar);
        this.zza.add(new zzyt(handler, zzyvVar));
    }

    public final void zzb(final int i, final long j, final long j2) {
        for (final zzyt zzytVar : this.zza) {
            if (!zzytVar.zzc) {
                zzytVar.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzys
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzytVar.zzb.zzX(i, j, j2);
                    }
                });
            }
        }
    }

    public final void zzc(zzyv zzyvVar) {
        for (zzyt zzytVar : this.zza) {
            if (zzytVar.zzb == zzyvVar) {
                zzytVar.zzc();
                this.zza.remove(zzytVar);
            }
        }
    }
}
