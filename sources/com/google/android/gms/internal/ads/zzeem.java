package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeem extends zzbyp {
    private final Context zza;
    private final zzgey zzb;
    private final zzefe zzc;
    private final zzcqs zzd;
    private final ArrayDeque zze;
    private final zzfnc zzf;
    private final zzbzq zzg;
    private final zzefb zzh;

    public zzeem(Context context, zzgey zzgeyVar, zzbzq zzbzqVar, zzcqs zzcqsVar, zzefe zzefeVar, ArrayDeque arrayDeque, zzefb zzefbVar, zzfnc zzfncVar) {
        zzbgc.zza(context);
        this.zza = context;
        this.zzb = zzgeyVar;
        this.zzg = zzbzqVar;
        this.zzc = zzefeVar;
        this.zzd = zzcqsVar;
        this.zze = arrayDeque;
        this.zzh = zzefbVar;
        this.zzf = zzfncVar;
    }

    private final synchronized zzeej zzk(String str) {
        Iterator it = this.zze.iterator();
        while (it.hasNext()) {
            zzeej zzeejVar = (zzeej) it.next();
            if (zzeejVar.zzc.equals(str)) {
                it.remove();
                return zzeejVar;
            }
        }
        return null;
    }

    private static ListenableFuture zzl(ListenableFuture listenableFuture, zzflm zzflmVar, zzbrx zzbrxVar, zzfmz zzfmzVar, zzfmo zzfmoVar) {
        zzbrn zzbrnVarZza = zzbrxVar.zza("AFMA_getAdDictionary", zzbru.zza, new zzbrp() { // from class: com.google.android.gms.internal.ads.zzeef
            @Override // com.google.android.gms.internal.ads.zzbrp
            public final Object zza(JSONObject jSONObject) {
                return new zzbzh(jSONObject);
            }
        });
        zzfmy.zzd(listenableFuture, zzfmoVar);
        zzfkr zzfkrVarZza = zzflmVar.zzb(zzflg.BUILD_URL, listenableFuture).zzf(zzbrnVarZza).zza();
        zzfmy.zzc(zzfkrVarZza, zzfmzVar, zzfmoVar);
        return zzfkrVarZza;
    }

    private static ListenableFuture zzm(zzbze zzbzeVar, zzflm zzflmVar, final zzeyo zzeyoVar) {
        zzgdu zzgduVar = new zzgdu() { // from class: com.google.android.gms.internal.ads.zzedz
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzeyoVar.zzb().zza(com.google.android.gms.ads.internal.client.zzay.zzb().zzh((Bundle) obj));
            }
        };
        return zzflmVar.zzb(zzflg.GMS_SIGNALS, zzgen.zzh(zzbzeVar.zza)).zzf(zzgduVar).zze(new zzfkp() { // from class: com.google.android.gms.internal.ads.zzeea
            @Override // com.google.android.gms.internal.ads.zzfkp
            public final Object zza(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                com.google.android.gms.ads.internal.util.zze.zza("Ad request signals:");
                com.google.android.gms.ads.internal.util.zze.zza(jSONObject.toString(2));
                return jSONObject;
            }
        }).zza();
    }

    private final synchronized void zzn(zzeej zzeejVar) {
        zzo();
        this.zze.addLast(zzeejVar);
    }

    private final synchronized void zzo() {
        int iIntValue = ((Long) zzbih.zzc.zze()).intValue();
        while (this.zze.size() >= iIntValue) {
            this.zze.removeFirst();
        }
    }

    private final void zzp(ListenableFuture listenableFuture, zzbza zzbzaVar) {
        zzgen.zzr(zzgen.zzn(listenableFuture, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzedx
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return zzgen.zzh(zzfii.zza((InputStream) obj));
            }
        }, zzcep.zza), new zzeei(this, zzbzaVar), zzcep.zzf);
    }

    public final ListenableFuture zzb(final zzbze zzbzeVar, int i) {
        if (!((Boolean) zzbih.zza.zze()).booleanValue()) {
            return zzgen.zzg(new Exception("Split request is disabled."));
        }
        zzfjc zzfjcVar = zzbzeVar.zzi;
        if (zzfjcVar == null) {
            return zzgen.zzg(new Exception("Pool configuration missing from request."));
        }
        if (zzfjcVar.zzc == 0 || zzfjcVar.zzd == 0) {
            return zzgen.zzg(new Exception("Caching is disabled."));
        }
        zzbrx zzbrxVarZzb = com.google.android.gms.ads.internal.zzt.zzf().zzb(this.zza, zzcei.zza(), this.zzf);
        zzeyo zzeyoVarZzq = this.zzd.zzq(zzbzeVar, i);
        zzflm zzflmVarZzc = zzeyoVarZzq.zzc();
        final ListenableFuture listenableFutureZzm = zzm(zzbzeVar, zzflmVarZzc, zzeyoVarZzq);
        zzfmz zzfmzVarZzd = zzeyoVarZzq.zzd();
        final zzfmo zzfmoVarZza = zzfmn.zza(this.zza, 9);
        final ListenableFuture listenableFutureZzl = zzl(listenableFutureZzm, zzflmVarZzc, zzbrxVarZzb, zzfmzVarZzd, zzfmoVarZza);
        return zzflmVarZzc.zza(zzflg.GET_URL_AND_CACHE_KEY, listenableFutureZzm, listenableFutureZzl).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeed
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzj(listenableFutureZzl, listenableFutureZzm, zzbzeVar, zzfmoVarZza);
            }
        }).zza();
    }

    public final ListenableFuture zzc(zzbze zzbzeVar, int i) {
        zzeej zzeejVarZzk;
        zzfkr zzfkrVarZza;
        zzbrx zzbrxVarZzb = com.google.android.gms.ads.internal.zzt.zzf().zzb(this.zza, zzcei.zza(), this.zzf);
        zzeyo zzeyoVarZzq = this.zzd.zzq(zzbzeVar, i);
        zzbrn zzbrnVarZza = zzbrxVarZzb.zza("google.afma.response.normalize", zzeel.zza, zzbru.zzb);
        if (((Boolean) zzbih.zza.zze()).booleanValue()) {
            zzeejVarZzk = zzk(zzbzeVar.zzh);
            if (zzeejVarZzk == null) {
                com.google.android.gms.ads.internal.util.zze.zza("Request contained a PoolKey but no matching parameters were found.");
            }
        } else {
            String str = zzbzeVar.zzj;
            zzeejVarZzk = null;
            if (str != null && !str.isEmpty()) {
                com.google.android.gms.ads.internal.util.zze.zza("Request contained a PoolKey but split request is disabled.");
            }
        }
        zzfmo zzfmoVarZza = zzeejVarZzk == null ? zzfmn.zza(this.zza, 9) : zzeejVarZzk.zze;
        zzfmz zzfmzVarZzd = zzeyoVarZzq.zzd();
        zzfmzVarZzd.zzd(zzbzeVar.zza.getStringArrayList("ad_types"));
        zzefd zzefdVar = new zzefd(zzbzeVar.zzg, zzfmzVarZzd, zzfmoVarZza);
        zzefa zzefaVar = new zzefa(this.zza, zzbzeVar.zzb.zza, this.zzg, i);
        zzflm zzflmVarZzc = zzeyoVarZzq.zzc();
        zzfmo zzfmoVarZza2 = zzfmn.zza(this.zza, 11);
        if (zzeejVarZzk == null) {
            final ListenableFuture listenableFutureZzm = zzm(zzbzeVar, zzflmVarZzc, zzeyoVarZzq);
            final ListenableFuture listenableFutureZzl = zzl(listenableFutureZzm, zzflmVarZzc, zzbrxVarZzb, zzfmzVarZzd, zzfmoVarZza);
            zzfmo zzfmoVarZza3 = zzfmn.zza(this.zza, 10);
            final zzfkr zzfkrVarZza2 = zzflmVarZzc.zza(zzflg.HTTP, listenableFutureZzl, listenableFutureZzm).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeeb
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new zzefc((JSONObject) listenableFutureZzm.get(), (zzbzh) listenableFutureZzl.get());
                }
            }).zze(zzefdVar).zze(new zzfmu(zzfmoVarZza3)).zze(zzefaVar).zza();
            zzfmy.zza(zzfkrVarZza2, zzfmzVarZzd, zzfmoVarZza3);
            zzfmy.zzd(zzfkrVarZza2, zzfmoVarZza2);
            zzfkrVarZza = zzflmVarZzc.zza(zzflg.PRE_PROCESS, listenableFutureZzm, listenableFutureZzl, zzfkrVarZza2).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeec
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new zzeel((zzeez) zzfkrVarZza2.get(), (JSONObject) listenableFutureZzm.get(), (zzbzh) listenableFutureZzl.get());
                }
            }).zzf(zzbrnVarZza).zza();
        } else {
            zzefc zzefcVar = new zzefc(zzeejVarZzk.zzb, zzeejVarZzk.zza);
            zzfmo zzfmoVarZza4 = zzfmn.zza(this.zza, 10);
            final zzfkr zzfkrVarZza3 = zzflmVarZzc.zzb(zzflg.HTTP, zzgen.zzh(zzefcVar)).zze(zzefdVar).zze(new zzfmu(zzfmoVarZza4)).zze(zzefaVar).zza();
            zzfmy.zza(zzfkrVarZza3, zzfmzVarZzd, zzfmoVarZza4);
            final ListenableFuture listenableFutureZzh = zzgen.zzh(zzeejVarZzk);
            zzfmy.zzd(zzfkrVarZza3, zzfmoVarZza2);
            zzfkrVarZza = zzflmVarZzc.zza(zzflg.PRE_PROCESS, zzfkrVarZza3, listenableFutureZzh).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzedy
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzeez zzeezVar = (zzeez) zzfkrVarZza3.get();
                    ListenableFuture listenableFuture = listenableFutureZzh;
                    return new zzeel(zzeezVar, ((zzeej) listenableFuture.get()).zzb, ((zzeej) listenableFuture.get()).zza);
                }
            }).zzf(zzbrnVarZza).zza();
        }
        zzfmy.zza(zzfkrVarZza, zzfmzVarZzd, zzfmoVarZza2);
        return zzfkrVarZza;
    }

    public final ListenableFuture zzd(zzbze zzbzeVar, int i) {
        zzbrx zzbrxVarZzb = com.google.android.gms.ads.internal.zzt.zzf().zzb(this.zza, zzcei.zza(), this.zzf);
        if (!((Boolean) zzbim.zza.zze()).booleanValue()) {
            return zzgen.zzg(new Exception("Signal collection disabled."));
        }
        zzeyo zzeyoVarZzq = this.zzd.zzq(zzbzeVar, i);
        final zzext zzextVarZza = zzeyoVarZzq.zza();
        zzbrn zzbrnVarZza = zzbrxVarZzb.zza("google.afma.request.getSignals", zzbru.zza, zzbru.zzb);
        zzfmo zzfmoVarZza = zzfmn.zza(this.zza, 22);
        zzfkr zzfkrVarZza = zzeyoVarZzq.zzc().zzb(zzflg.GET_SIGNALS, zzgen.zzh(zzbzeVar.zza)).zze(new zzfmu(zzfmoVarZza)).zzf(new zzgdu() { // from class: com.google.android.gms.internal.ads.zzeeg
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) throws JSONException {
                return zzextVarZza.zza(com.google.android.gms.ads.internal.client.zzay.zzb().zzh((Bundle) obj));
            }
        }).zzb(zzflg.JS_SIGNALS).zzf(zzbrnVarZza).zza();
        zzfmz zzfmzVarZzd = zzeyoVarZzq.zzd();
        zzfmzVarZzd.zzd(zzbzeVar.zza.getStringArrayList("ad_types"));
        zzfmy.zzb(zzfkrVarZza, zzfmzVarZzd, zzfmoVarZza);
        if (((Boolean) zzbia.zze.zze()).booleanValue()) {
            zzefe zzefeVar = this.zzc;
            Objects.requireNonNull(zzefeVar);
            zzfkrVarZza.addListener(new zzeee(zzefeVar), this.zzb);
        }
        return zzfkrVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzbyq
    public final void zze(zzbze zzbzeVar, zzbza zzbzaVar) {
        zzp(zzb(zzbzeVar, Binder.getCallingUid()), zzbzaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbyq
    public final void zzf(zzbze zzbzeVar, zzbza zzbzaVar) {
        zzp(zzd(zzbzeVar, Binder.getCallingUid()), zzbzaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbyq
    public final void zzg(zzbze zzbzeVar, zzbza zzbzaVar) {
        ListenableFuture listenableFutureZzc = zzc(zzbzeVar, Binder.getCallingUid());
        zzp(listenableFutureZzc, zzbzaVar);
        if (((Boolean) zzbia.zzc.zze()).booleanValue()) {
            zzefe zzefeVar = this.zzc;
            Objects.requireNonNull(zzefeVar);
            listenableFutureZzc.addListener(new zzeee(zzefeVar), this.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbyq
    public final void zzh(String str, zzbza zzbzaVar) {
        zzp(zzi(str), zzbzaVar);
    }

    public final ListenableFuture zzi(String str) {
        if (((Boolean) zzbih.zza.zze()).booleanValue()) {
            return zzk(str) == null ? zzgen.zzg(new Exception("URL to be removed not found for cache key: ".concat(String.valueOf(str)))) : zzgen.zzh(new zzeeh(this));
        }
        return zzgen.zzg(new Exception("Split request is disabled."));
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ InputStream zzj(ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzbze zzbzeVar, zzfmo zzfmoVar) throws Exception {
        String strZzc = ((zzbzh) listenableFuture.get()).zzc();
        zzn(new zzeej((zzbzh) listenableFuture.get(), (JSONObject) listenableFuture2.get(), zzbzeVar.zzh, strZzc, zzfmoVar));
        return new ByteArrayInputStream(strZzc.getBytes(zzfwq.zzc));
    }
}
