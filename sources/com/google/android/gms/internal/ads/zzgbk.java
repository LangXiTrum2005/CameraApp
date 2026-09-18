package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgbk extends zzgaa {
    static final zzgaa zza = new zzgbk(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzgbk(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzfxe.zza(i, this.zzc, FirebaseAnalytics.Param.INDEX);
        return Objects.requireNonNull(this.zzb[i]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgaa, com.google.android.gms.internal.ads.zzfzv
    final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, i, this.zzc);
        return i + this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfzv
    final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzfzv
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfzv
    final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfzv
    final Object[] zzg() {
        return this.zzb;
    }
}
