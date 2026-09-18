package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgfc extends zzgdb.zzi implements Runnable {
    private final Runnable zza;

    public zzgfc(Runnable runnable) {
        runnable.getClass();
        this.zza = runnable;
    }

    @Override // com.google.android.gms.internal.ads.zzgdb
    protected final String zza() {
        return "task=[" + this.zza.toString() + "]";
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zza.run();
        } catch (Throwable th) {
            zzd(th);
            throw th;
        }
    }
}
