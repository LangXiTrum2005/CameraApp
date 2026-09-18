package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfdz {
    private final zzfiv zza;
    private final zzdae zzb;
    private final Executor zzc;
    private zzfdy zzd;

    public zzfdz(zzfiv zzfivVar, zzdae zzdaeVar, Executor executor) {
        this.zza = zzfivVar;
        this.zzb = zzdaeVar;
        this.zzc = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public final zzfjf zze() {
        zzfhh zzfhhVarZzg = this.zzb.zzg();
        return this.zza.zzc(zzfhhVarZzg.zzd, zzfhhVarZzg.zzf, zzfhhVarZzg.zzj);
    }

    public final ListenableFuture zzc() {
        ListenableFuture listenableFutureZze;
        zzfdy zzfdyVar = this.zzd;
        if (zzfdyVar != null) {
            return zzgen.zzh(zzfdyVar);
        }
        if (((Boolean) zzbih.zza.zze()).booleanValue()) {
            listenableFutureZze = zzgen.zze(zzgen.zzm(zzgee.zzu(this.zzb.zzb().zze(this.zza.zza())), new zzfdw(this), this.zzc), zzecf.class, new zzfdv(this), this.zzc);
        } else {
            zzfdy zzfdyVar2 = new zzfdy(null, zze(), null);
            this.zzd = zzfdyVar2;
            listenableFutureZze = zzgen.zzh(zzfdyVar2);
        }
        return zzgen.zzm(listenableFutureZze, new zzfws() { // from class: com.google.android.gms.internal.ads.zzfdu
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                return (zzfdy) obj;
            }
        }, this.zzc);
    }
}
