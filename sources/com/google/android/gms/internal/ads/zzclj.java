package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzclj {
    private final zzcei zza;
    private final Context zzb;
    private final WeakReference zzc;

    /* synthetic */ zzclj(zzclh zzclhVar, zzcli zzcliVar) {
        this.zza = zzclhVar.zza;
        this.zzb = zzclhVar.zzb;
        this.zzc = zzclhVar.zzc;
    }

    final Context zza() {
        return this.zzb;
    }

    public final zzavi zzb() {
        return new zzavi(new com.google.android.gms.ads.internal.zzi(this.zzb, this.zza));
    }

    final zzbiu zzc() {
        return new zzbiu(this.zzb);
    }

    final zzcei zzd() {
        return this.zza;
    }

    final String zze() {
        return com.google.android.gms.ads.internal.zzt.zzp().zzc(this.zzb, this.zza.zza);
    }

    final WeakReference zzf() {
        return this.zzc;
    }
}
