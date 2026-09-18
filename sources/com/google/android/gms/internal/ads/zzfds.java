package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfds implements zzfed {
    private zzdae zza;

    @Override // com.google.android.gms.internal.ads.zzfed
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzdae zzd() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfed
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfee zzfeeVar, zzfec zzfecVar, Object obj) {
        return zzb(zzfeeVar, zzfecVar, null);
    }

    public final synchronized ListenableFuture zzb(zzfee zzfeeVar, zzfec zzfecVar, zzdae zzdaeVar) {
        zzcxp zzcxpVarZzb;
        try {
            if (zzdaeVar != null) {
                this.zza = zzdaeVar;
            } else {
                this.zza = (zzdae) zzfecVar.zza(zzfeeVar.zzb).zzh();
            }
            zzcxpVarZzb = this.zza.zzb();
        } catch (Throwable th) {
            throw th;
        }
        return zzcxpVarZzb.zzi(zzcxpVarZzb.zzj());
    }
}
