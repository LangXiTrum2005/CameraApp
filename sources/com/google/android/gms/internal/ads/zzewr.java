package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzewr implements zzexq {
    final String zza;
    private final zzgey zzb;
    private final ScheduledExecutorService zzc;
    private final zzepa zzd;
    private final Context zze;
    private final zzfhh zzf;
    private final zzeow zzg;
    private final zzdua zzh;
    private final zzdyk zzi;

    zzewr(zzgey zzgeyVar, ScheduledExecutorService scheduledExecutorService, String str, zzepa zzepaVar, Context context, zzfhh zzfhhVar, zzeow zzeowVar, zzdua zzduaVar, zzdyk zzdykVar) {
        this.zzb = zzgeyVar;
        this.zzc = scheduledExecutorService;
        this.zza = str;
        this.zzd = zzepaVar;
        this.zze = context;
        this.zzf = zzfhhVar;
        this.zzg = zzeowVar;
        this.zzh = zzduaVar;
        this.zzi = zzdykVar;
    }

    public static /* synthetic */ ListenableFuture zzc(zzewr zzewrVar) {
        String lowerCase = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkr)).booleanValue() ? zzewrVar.zzf.zzf.toLowerCase(Locale.ROOT) : zzewrVar.zzf.zzf;
        final Bundle bundleZzg = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbD)).booleanValue() ? zzewrVar.zzi.zzg() : new Bundle();
        final ArrayList arrayList = new ArrayList();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbM)).booleanValue()) {
            zzewrVar.zzi(arrayList, zzewrVar.zzd.zza(zzewrVar.zza, lowerCase));
        } else {
            for (Map.Entry entry : ((zzgad) zzewrVar.zzd.zzb(zzewrVar.zza, lowerCase)).entrySet()) {
                String str = (String) entry.getKey();
                arrayList.add(zzewrVar.zzg(str, (List) entry.getValue(), zzewrVar.zzf(str), true, true));
            }
            zzewrVar.zzi(arrayList, zzewrVar.zzd.zzc());
        }
        return zzgen.zzb(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzewm
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                JSONArray jSONArray = new JSONArray();
                for (ListenableFuture listenableFuture : arrayList) {
                    if (((JSONObject) listenableFuture.get()) != null) {
                        jSONArray.put(listenableFuture.get());
                    }
                }
                if (jSONArray.length() == 0) {
                    return null;
                }
                return new zzews(jSONArray.toString(), bundleZzg);
            }
        }, zzewrVar.zzb);
    }

    private final Bundle zzf(String str) {
        Bundle bundle = this.zzf.zzd.zzm;
        if (bundle != null) {
            return bundle.getBundle(str);
        }
        return null;
    }

    private final zzgee zzg(final String str, final List list, final Bundle bundle, final boolean z, final boolean z2) {
        zzgee zzgeeVarZzu = zzgee.zzu(zzgen.zzk(new zzgdt() { // from class: com.google.android.gms.internal.ads.zzewo
            @Override // com.google.android.gms.internal.ads.zzgdt
            public final ListenableFuture zza() {
                return this.zza.zzd(str, list, bundle, z, z2);
            }
        }, this.zzb));
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbz)).booleanValue()) {
            zzgeeVarZzu = (zzgee) zzgen.zzo(zzgeeVarZzu, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbs)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
        }
        return (zzgee) zzgen.zze(zzgeeVarZzu, Throwable.class, new zzfws() { // from class: com.google.android.gms.internal.ads.zzewp
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                zzcec.zzg("Error calling adapter: ".concat(String.valueOf(str)));
                return null;
            }
        }, this.zzb);
    }

    private final void zzh(zzbus zzbusVar, Bundle bundle, List list, zzepd zzepdVar) throws RemoteException {
        zzbusVar.zzh(ObjectWrapper.wrap(this.zze), this.zza, bundle, (Bundle) list.get(0), this.zzf.zze, zzepdVar);
    }

    private final void zzi(List list, Map map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            zzepe zzepeVar = (zzepe) ((Map.Entry) it.next()).getValue();
            String str = zzepeVar.zza;
            list.add(zzg(str, Collections.singletonList(zzepeVar.zze), zzf(str), zzepeVar.zzb, zzepeVar.zzc));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 32;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        zzfhh zzfhhVar = this.zzf;
        if (zzfhhVar.zzq) {
            if (!Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbF)).split(",")).contains(com.google.android.gms.ads.nonagon.signalgeneration.zzf.zza(com.google.android.gms.ads.nonagon.signalgeneration.zzf.zzb(zzfhhVar.zzd)))) {
                return zzgen.zzh(new zzews(new JSONArray().toString(), new Bundle()));
            }
        }
        return zzgen.zzk(new zzgdt() { // from class: com.google.android.gms.internal.ads.zzewl
            @Override // com.google.android.gms.internal.ads.zzgdt
            public final ListenableFuture zza() {
                return zzewr.zzc(this.zza);
            }
        }, this.zzb);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    final /* synthetic */ ListenableFuture zzd(String str, final List list, final Bundle bundle, boolean z, boolean z2) throws Exception {
        zzbus zzbusVarZzb;
        final zzceu zzceuVar = new zzceu();
        if (z2) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbE)).booleanValue()) {
                try {
                    zzbusVarZzb = this.zzh.zzb(str);
                } catch (RemoteException e) {
                    zzcec.zzh("Couldn't create RTB adapter : ", e);
                    zzbusVarZzb = null;
                }
            } else {
                this.zzg.zzb(str);
                zzbusVarZzb = this.zzg.zza(str);
            }
        } else {
            zzbusVarZzb = this.zzh.zzb(str);
        }
        if (zzbusVarZzb == null) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbu)).booleanValue()) {
                throw null;
            }
            zzepd.zzb(str, zzceuVar);
        } else {
            final zzepd zzepdVar = new zzepd(str, zzbusVarZzb, zzceuVar, com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime());
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbz)).booleanValue()) {
                this.zzc.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzewq
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzepdVar.zzc();
                    }
                }, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbs)).longValue(), TimeUnit.MILLISECONDS);
            }
            if (z) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbG)).booleanValue()) {
                    final zzbus zzbusVar = zzbusVarZzb;
                    this.zzb.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzewn
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zze(zzbusVar, bundle, list, zzepdVar, zzceuVar);
                        }
                    });
                } else {
                    zzh(zzbusVarZzb, bundle, list, zzepdVar);
                }
            } else {
                zzepdVar.zzd();
            }
        }
        return zzceuVar;
    }

    final /* synthetic */ void zze(zzbus zzbusVar, Bundle bundle, List list, zzepd zzepdVar, zzceu zzceuVar) {
        try {
            zzh(zzbusVar, bundle, list, zzepdVar);
        } catch (RemoteException e) {
            zzceuVar.zzd(e);
        }
    }
}
