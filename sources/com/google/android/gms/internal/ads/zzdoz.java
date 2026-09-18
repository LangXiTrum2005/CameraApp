package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdoz implements zzdbr {
    private final zzdna zza;
    private final zzdnf zzb;
    private final Executor zzc;
    private final Executor zzd;

    public zzdoz(zzdna zzdnaVar, zzdnf zzdnfVar, Executor executor, Executor executor2) {
        this.zza = zzdnaVar;
        this.zzb = zzdnfVar;
        this.zzc = executor;
        this.zzd = executor2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(final zzcjk zzcjkVar) {
        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdox
            @Override // java.lang.Runnable
            public final void run() {
                zzcjkVar.zzd("onSdkImpression", new ArrayMap());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdbr
    public final void zzq() {
        if (this.zzb.zzd()) {
            zzdna zzdnaVar = this.zza;
            zzfod zzfodVarZzu = zzdnaVar.zzu();
            if (zzfodVarZzu == null && zzdnaVar.zzw() != null && ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfa)).booleanValue()) {
                zzdna zzdnaVar2 = this.zza;
                ListenableFuture listenableFutureZzw = zzdnaVar2.zzw();
                zzceu zzceuVarZzp = zzdnaVar2.zzp();
                if (listenableFutureZzw == null || zzceuVarZzp == null) {
                    return;
                }
                zzgen.zzr(zzgen.zzl(listenableFutureZzw, zzceuVarZzp), new zzdoy(this), this.zzd);
                return;
            }
            if (zzfodVarZzu != null) {
                zzdna zzdnaVar3 = this.zza;
                zzcjk zzcjkVarZzr = zzdnaVar3.zzr();
                zzcjk zzcjkVarZzs = zzdnaVar3.zzs();
                if (zzcjkVarZzr == null) {
                    zzcjkVarZzr = zzcjkVarZzs != null ? zzcjkVarZzs : null;
                }
                if (zzcjkVarZzr != null) {
                    zzb(zzcjkVarZzr);
                }
            }
        }
    }
}
