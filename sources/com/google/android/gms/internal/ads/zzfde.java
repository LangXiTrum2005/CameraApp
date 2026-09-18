package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfde implements zzfed {
    private zzdae zza;
    private final Executor zzb = zzgfe.zzb();

    public final zzdae zza() {
        return this.zza;
    }

    public final ListenableFuture zzb(zzfee zzfeeVar, zzfec zzfecVar, zzdae zzdaeVar) {
        zzdad zzdadVarZza = zzfecVar.zza(zzfeeVar.zzb);
        zzdadVarZza.zzb(new zzfeh(true));
        zzdae zzdaeVar2 = (zzdae) zzdadVarZza.zzh();
        this.zza = zzdaeVar2;
        final zzcxp zzcxpVarZzb = zzdaeVar2.zzb();
        final zzfje zzfjeVar = new zzfje();
        return zzgen.zzm(zzgen.zzn(zzgee.zzu(zzcxpVarZzb.zzj()), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzfdc
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                zzfgy zzfgyVar = (zzfgy) obj;
                zzfjeVar.zzb = zzfgyVar;
                Iterator it = zzfgyVar.zzb.zza.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Iterator it2 = ((zzfgm) it.next()).zza.iterator();
                    while (it2.hasNext()) {
                        if (!((String) it2.next()).contains("FirstPartyRenderer")) {
                            return zzgen.zzh(null);
                        }
                        z = true;
                    }
                }
                if (z) {
                    return zzcxpVarZzb.zzi(zzgen.zzh(zzfgyVar));
                }
                return zzgen.zzh(null);
            }
        }, this.zzb), new zzfws() { // from class: com.google.android.gms.internal.ads.zzfdd
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                zzfje zzfjeVar2 = zzfjeVar;
                zzfjeVar2.zzc = (zzcwh) obj;
                return zzfjeVar2;
            }
        }, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzfed
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfee zzfeeVar, zzfec zzfecVar, Object obj) {
        return zzb(zzfeeVar, zzfecVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfed
    public final /* synthetic */ Object zzd() {
        return this.zza;
    }
}
