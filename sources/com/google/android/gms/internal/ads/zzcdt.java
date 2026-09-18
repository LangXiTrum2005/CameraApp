package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcdt extends Thread {
    final /* synthetic */ String zza;

    zzcdt(zzcdv zzcdvVar, String str) {
        this.zza = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        new zzceh(null).zza(this.zza);
    }
}
