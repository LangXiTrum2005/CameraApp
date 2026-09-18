package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdrw implements Callable {
    private final com.google.android.gms.ads.internal.zza zza;
    private final zzcjx zzb;
    private final Context zzc;
    private final zzdwf zzd;
    private final zzflw zze;
    private final zzehh zzf;
    private final Executor zzg;
    private final zzavi zzh;
    private final zzcei zzi;
    private final zzfny zzj;
    private final zzehs zzk;
    private final zzfhl zzl;

    public zzdrw(Context context, Executor executor, zzavi zzaviVar, zzcei zzceiVar, com.google.android.gms.ads.internal.zza zzaVar, zzcjx zzcjxVar, zzehh zzehhVar, zzfny zzfnyVar, zzdwf zzdwfVar, zzflw zzflwVar, zzehs zzehsVar, zzfhl zzfhlVar) {
        this.zzc = context;
        this.zzg = executor;
        this.zzh = zzaviVar;
        this.zzi = zzceiVar;
        this.zza = zzaVar;
        this.zzb = zzcjxVar;
        this.zzf = zzehhVar;
        this.zzj = zzfnyVar;
        this.zzd = zzdwfVar;
        this.zze = zzflwVar;
        this.zzk = zzehsVar;
        this.zzl = zzfhlVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzdrz zzdrzVar = new zzdrz(this);
        zzdrzVar.zzh();
        return zzdrzVar;
    }
}
