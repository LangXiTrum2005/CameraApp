package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaxc implements Callable {
    private final zzawj zza;
    private final zzasg zzb;

    public zzaxc(zzawj zzawjVar, zzasg zzasgVar) {
        this.zza = zzawjVar;
        this.zzb = zzasgVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        if (this.zza.zzl() != null) {
            this.zza.zzl().get();
        }
        zzatd zzatdVarZzc = this.zza.zzc();
        if (zzatdVarZzc == null) {
            return null;
        }
        try {
            synchronized (this.zzb) {
                try {
                    zzasg zzasgVar = this.zzb;
                    byte[] bArrZzax = zzatdVarZzc.zzax();
                    zzasgVar.zzak(bArrZzax, 0, bArrZzax.length, zzgzf.zza());
                } catch (Throwable th) {
                    throw th;
                }
            }
            return null;
        } catch (zzhag | NullPointerException unused) {
            return null;
        }
    }
}
