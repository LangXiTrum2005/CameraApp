package com.google.android.gms.internal.ads;

import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgdr extends zzgdo {
    private zzgdr() {
        super(null);
    }

    /* synthetic */ zzgdr(zzgdq zzgdqVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.ads.zzgdo
    final int zza(zzgds zzgdsVar) {
        int i;
        synchronized (zzgdsVar) {
            i = zzgdsVar.remaining - 1;
            zzgdsVar.remaining = i;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzgdo
    final void zzb(zzgds zzgdsVar, @CheckForNull Set set, Set set2) {
        synchronized (zzgdsVar) {
            if (zzgdsVar.seenExceptions == null) {
                zzgdsVar.seenExceptions = set2;
            }
        }
    }
}
