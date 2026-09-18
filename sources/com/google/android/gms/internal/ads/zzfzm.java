package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfzm extends zzfzp {
    zzfzm() {
        super(null);
    }

    static final zzfzp zzg(int i) {
        if (i < 0) {
            return zzfzp.zzb;
        }
        return i > 0 ? zzfzp.zzc : zzfzp.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final zzfzp zzb(int i, int i2) {
        int i3;
        if (i < i2) {
            i3 = -1;
        } else {
            i3 = i > i2 ? 1 : 0;
        }
        return zzg(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final zzfzp zzc(long j, long j2) {
        int i;
        if (j < j2) {
            i = -1;
        } else {
            i = j > j2 ? 1 : 0;
        }
        return zzg(i);
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final zzfzp zzd(Object obj, Object obj2, Comparator comparator) {
        return zzg(comparator.compare(obj, obj2));
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final zzfzp zze(boolean z, boolean z2) {
        return zzg(zzgcs.zza(z, z2));
    }

    @Override // com.google.android.gms.internal.ads.zzfzp
    public final zzfzp zzf(boolean z, boolean z2) {
        return zzg(zzgcs.zza(z2, z));
    }
}
