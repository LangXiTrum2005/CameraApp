package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzrs {
    public final int zza;
    public final zzur zzb;
    private final CopyOnWriteArrayList zzc;

    public zzrs() {
        this(new CopyOnWriteArrayList(), 0, null);
    }

    private zzrs(CopyOnWriteArrayList copyOnWriteArrayList, int i, zzur zzurVar) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zzurVar;
    }

    public final zzrs zza(int i, zzur zzurVar) {
        return new zzrs(this.zzc, 0, zzurVar);
    }

    public final void zzb(Handler handler, zzrt zzrtVar) {
        this.zzc.add(new zzrr(handler, zzrtVar));
    }

    public final void zzc(zzrt zzrtVar) {
        for (zzrr zzrrVar : this.zzc) {
            if (zzrrVar.zzb == zzrtVar) {
                this.zzc.remove(zzrrVar);
            }
        }
    }
}
