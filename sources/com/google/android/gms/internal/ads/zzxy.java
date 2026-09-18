package com.google.android.gms.internal.ads;

import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzxy implements Spatializer$OnSpatializerStateChangedListener {
    final /* synthetic */ zzyg zza;

    zzxy(zzxz zzxzVar, zzyg zzygVar) {
        this.zza = zzygVar;
    }

    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
        this.zza.zzv();
    }

    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
        this.zza.zzv();
    }
}
