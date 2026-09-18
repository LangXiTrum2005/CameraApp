package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcln implements zzhhd {
    private final zzclj zza;

    public zzcln(zzclj zzcljVar) {
        this.zza = zzcljVar;
    }

    public final WeakReference zza() {
        WeakReference weakReferenceZzf = this.zza.zzf();
        zzhhl.zzb(weakReferenceZzf);
        return weakReferenceZzf;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* synthetic */ Object zzb() {
        WeakReference weakReferenceZzf = this.zza.zzf();
        zzhhl.zzb(weakReferenceZzf);
        return weakReferenceZzf;
    }
}
