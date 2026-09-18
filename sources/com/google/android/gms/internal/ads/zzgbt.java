package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgbt extends zzfyb {
    final Iterator zza;
    final /* synthetic */ zzgbu zzb;

    zzgbt(zzgbu zzgbuVar) {
        this.zzb = zzgbuVar;
        this.zza = zzgbuVar.zza.iterator();
    }

    @Override // com.google.android.gms.internal.ads.zzfyb
    @CheckForNull
    protected final Object zza() {
        while (this.zza.hasNext()) {
            Iterator it = this.zza;
            Set set = this.zzb.zzb;
            Object next = it.next();
            if (set.contains(next)) {
                return next;
            }
        }
        zzb();
        return null;
    }
}
