package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfdj implements zzfed {
    private final zzfed zza;
    private final zzfed zzb;
    private final zzfjr zzc;
    private final String zzd;
    private zzdae zze;
    private final Executor zzf;

    public zzfdj(zzfed zzfedVar, zzfed zzfedVar2, zzfjr zzfjrVar, String str, Executor executor) {
        this.zza = zzfedVar;
        this.zzb = zzfedVar2;
        this.zzc = zzfjrVar;
        this.zzd = str;
        this.zzf = executor;
    }

    private final ListenableFuture zzg(zzfje zzfjeVar, zzfee zzfeeVar) {
        zzdae zzdaeVar = zzfjeVar.zza;
        this.zze = zzdaeVar;
        if (zzfjeVar.zzc != null) {
            if (zzdaeVar.zzf() != null) {
                zzfjeVar.zzc.zzo().zzl(zzfjeVar.zza.zzf());
            }
            return zzgen.zzh(zzfjeVar.zzc);
        }
        zzdaeVar.zzb().zzl(zzfjeVar.zzb);
        return ((zzfdt) this.zza).zzb(zzfeeVar, null, zzfjeVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfed
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzdae zzd() {
        return this.zze;
    }

    final /* synthetic */ ListenableFuture zzb(zzfee zzfeeVar, zzfdi zzfdiVar, zzfec zzfecVar, zzdae zzdaeVar, zzfdo zzfdoVar) throws Exception {
        if (zzfdoVar != null) {
            zzfdi zzfdiVar2 = new zzfdi(zzfdiVar.zza, zzfdiVar.zzb, zzfdiVar.zzc, zzfdiVar.zzd, zzfdiVar.zze, zzfdiVar.zzf, zzfdoVar.zza);
            if (zzfdoVar.zzc != null) {
                this.zze = null;
                this.zzc.zze(zzfdiVar2);
                return zzg(zzfdoVar.zzc, zzfeeVar);
            }
            ListenableFuture listenableFutureZza = this.zzc.zza(zzfdiVar2);
            if (listenableFutureZza != null) {
                this.zze = null;
                return zzgen.zzn(listenableFutureZza, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzfdf
                    @Override // com.google.android.gms.internal.ads.zzgdu
                    public final ListenableFuture zza(Object obj) {
                        return this.zza.zze((zzfjo) obj);
                    }
                }, this.zzf);
            }
            this.zzc.zze(zzfdiVar2);
            zzfeeVar = new zzfee(zzfeeVar.zzb, zzfdoVar.zzb);
        }
        ListenableFuture listenableFutureZzb = ((zzfdt) this.zza).zzb(zzfeeVar, zzfecVar, zzdaeVar);
        this.zze = zzdaeVar;
        return listenableFutureZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfed
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfee zzfeeVar, zzfec zzfecVar, Object obj) {
        return zzf(zzfeeVar, zzfecVar, null);
    }

    final /* synthetic */ ListenableFuture zze(zzfjo zzfjoVar) throws Exception {
        zzfjq zzfjqVar;
        if (zzfjoVar == null || zzfjoVar.zza == null || (zzfjqVar = zzfjoVar.zzb) == null) {
            throw new zzead(1, "Empty prefetch");
        }
        zzbce zzbceVarZza = zzbck.zza();
        zzbcc zzbccVarZza = zzbcd.zza();
        zzbccVarZza.zzd(2);
        zzbccVarZza.zzb(zzbch.zzd());
        zzbceVarZza.zza(zzbccVarZza);
        zzfjoVar.zza.zza.zzb().zzc().zzm((zzbck) zzbceVarZza.zzal());
        return zzg(zzfjoVar.zza, ((zzfdi) zzfjqVar).zzb);
    }

    public final synchronized ListenableFuture zzf(final zzfee zzfeeVar, final zzfec zzfecVar, zzdae zzdaeVar) {
        zzdad zzdadVarZza = zzfecVar.zza(zzfeeVar.zzb);
        zzdadVarZza.zza(new zzfdk(this.zzd));
        final zzdae zzdaeVar2 = (zzdae) zzdadVarZza.zzh();
        zzdaeVar2.zzg();
        zzdaeVar2.zzg();
        com.google.android.gms.ads.internal.client.zzl zzlVar = zzdaeVar2.zzg().zzd;
        if (zzlVar.zzs == null && zzlVar.zzx == null) {
            zzfhh zzfhhVarZzg = zzdaeVar2.zzg();
            final zzfdi zzfdiVar = new zzfdi(zzfecVar, zzfeeVar, zzfhhVarZzg.zzd, zzfhhVarZzg.zzf, this.zzf, zzfhhVarZzg.zzj, null);
            return zzgen.zzn(zzgee.zzu(((zzfdp) this.zzb).zzb(zzfeeVar, zzfecVar, zzdaeVar2)), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzfdg
                @Override // com.google.android.gms.internal.ads.zzgdu
                public final ListenableFuture zza(Object obj) {
                    return this.zza.zzb(zzfeeVar, zzfdiVar, zzfecVar, zzdaeVar2, (zzfdo) obj);
                }
            }, this.zzf);
        }
        this.zze = zzdaeVar2;
        return ((zzfdt) this.zza).zzb(zzfeeVar, zzfecVar, zzdaeVar2);
    }
}
