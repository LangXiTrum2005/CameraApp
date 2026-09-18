package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfdt implements zzfed {
    private final zzfed zza;
    private zzdae zzb;

    public zzfdt(zzfed zzfedVar) {
        this.zza = zzfedVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfed
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzdae zzd() {
        return this.zzb;
    }

    public final synchronized ListenableFuture zzb(zzfee zzfeeVar, zzfec zzfecVar, zzdae zzdaeVar) {
        this.zzb = zzdaeVar;
        if (zzfeeVar.zza == null) {
            return ((zzfds) this.zza).zzb(zzfeeVar, zzfecVar, zzdaeVar);
        }
        zzcxp zzcxpVarZzb = this.zzb.zzb();
        return zzcxpVarZzb.zzi(zzcxpVarZzb.zzk(zzgen.zzh(zzfeeVar.zza)));
    }

    @Override // com.google.android.gms.internal.ads.zzfed
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfee zzfeeVar, zzfec zzfecVar, Object obj) {
        return zzb(zzfeeVar, zzfecVar, null);
    }
}
