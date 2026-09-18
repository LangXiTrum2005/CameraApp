package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzcvl implements Runnable {
    public final /* synthetic */ AtomicReference zza;

    public /* synthetic */ zzcvl(AtomicReference atomicReference) {
        this.zza = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcvn.zzi(this.zza);
    }
}
