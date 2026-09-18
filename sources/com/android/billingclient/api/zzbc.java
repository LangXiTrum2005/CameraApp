package com.android.billingclient.api;

/* JADX INFO: compiled from: com.android.billingclient:billing@@6.0.1 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbc {
    private boolean zza;

    private zzbc() {
    }

    /* synthetic */ zzbc(zzbb zzbbVar) {
    }

    public final zzbc zza() {
        this.zza = true;
        return this;
    }

    public final zzbe zzb() {
        if (this.zza) {
            return new zzbe(true, false, null);
        }
        throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
    }
}
