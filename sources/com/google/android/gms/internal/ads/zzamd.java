package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzamd {
    private static final Comparator zza = new Comparator() { // from class: com.google.android.gms.internal.ads.zzamb
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Integer.compare(((zzamd) obj).zzb.zzb, ((zzamd) obj2).zzb.zzb);
        }
    };
    private final zzame zzb;
    private final int zzc;

    /* synthetic */ zzamd(zzame zzameVar, int i, zzamc zzamcVar) {
        this.zzb = zzameVar;
        this.zzc = i;
    }
}
