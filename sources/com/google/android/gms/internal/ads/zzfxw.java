package com.google.android.gms.internal.ads;

import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfxw implements zzfxu {
    private static final zzfxu zza = new zzfxu() { // from class: com.google.android.gms.internal.ads.zzfxv
        @Override // com.google.android.gms.internal.ads.zzfxu
        public final Object zza() {
            throw new IllegalStateException();
        }
    };
    private volatile zzfxu zzb;

    @CheckForNull
    private Object zzc;

    zzfxw(zzfxu zzfxuVar) {
        this.zzb = zzfxuVar;
    }

    public final String toString() {
        Object obj = this.zzb;
        if (obj == zza) {
            obj = "<supplier that returned " + String.valueOf(this.zzc) + ">";
        }
        return "Suppliers.memoize(" + String.valueOf(obj) + ")";
    }

    @Override // com.google.android.gms.internal.ads.zzfxu
    public final Object zza() {
        zzfxu zzfxuVar = this.zzb;
        zzfxu zzfxuVar2 = zza;
        if (zzfxuVar != zzfxuVar2) {
            synchronized (this) {
                if (this.zzb != zzfxuVar2) {
                    Object objZza = this.zzb.zza();
                    this.zzc = objZza;
                    this.zzb = zzfxuVar2;
                    return objZza;
                }
            }
        }
        return this.zzc;
    }
}
