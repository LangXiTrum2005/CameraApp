package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzext {
    private final Context zza;
    private final Set zzb;
    private final Executor zzc;
    private final zzfmz zzd;
    private final zzdwf zze;
    private long zzf = 0;
    private int zzg = 0;

    public zzext(Context context, Executor executor, Set set, zzfmz zzfmzVar, zzdwf zzdwfVar) {
        this.zza = context;
        this.zzc = executor;
        this.zzb = set;
        this.zzd = zzfmzVar;
        this.zze = zzdwfVar;
    }

    public final ListenableFuture zza(final Object obj) {
        zzfmo zzfmoVarZza = zzfmn.zza(this.zza, 8);
        zzfmoVarZza.zzh();
        final ArrayList arrayList = new ArrayList(this.zzb.size());
        List arrayList2 = new ArrayList();
        if (!((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlh)).isEmpty()) {
            arrayList2 = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlh)).split(","));
        }
        this.zzf = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
        for (final zzexq zzexqVar : this.zzb) {
            if (!arrayList2.contains(String.valueOf(zzexqVar.zza()))) {
                final long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
                ListenableFuture listenableFutureZzb = zzexqVar.zzb();
                listenableFutureZzb.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzexr
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzb(jElapsedRealtime, zzexqVar);
                    }
                }, zzcep.zzf);
                arrayList.add(listenableFutureZzb);
            }
        }
        ListenableFuture listenableFutureZza = zzgen.zzb(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzexs
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Iterator it = arrayList.iterator();
                while (true) {
                    Object obj2 = obj;
                    if (!it.hasNext()) {
                        return obj2;
                    }
                    zzexp zzexpVar = (zzexp) ((ListenableFuture) it.next()).get();
                    if (zzexpVar != null) {
                        zzexpVar.zzj(obj2);
                    }
                }
            }
        }, this.zzc);
        if (zzfnc.zza()) {
            zzfmy.zza(listenableFutureZza, this.zzd, zzfmoVarZza);
        }
        return listenableFutureZza;
    }

    public final void zzb(long j, zzexq zzexqVar) {
        long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - j;
        if (((Boolean) zzbid.zza.zze()).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zza("Signal runtime (ms) : " + zzfxt.zzc(zzexqVar.getClass().getCanonicalName()) + " = " + jElapsedRealtime);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzca)).booleanValue()) {
            zzdwe zzdweVarZza = this.zze.zza();
            zzdweVarZza.zzb("action", "lat_ms");
            zzdweVarZza.zzb("lat_grp", "sig_lat_grp");
            zzdweVarZza.zzb("lat_id", String.valueOf(zzexqVar.zza()));
            zzdweVarZza.zzb("clat_ms", String.valueOf(jElapsedRealtime));
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcb)).booleanValue()) {
                synchronized (this) {
                    this.zzg++;
                }
                zzdweVarZza.zzb("seq_num", com.google.android.gms.ads.internal.zzt.zzo().zzh().zzd());
                synchronized (this) {
                    if (this.zzg == this.zzb.size() && this.zzf != 0) {
                        this.zzg = 0;
                        String strValueOf = String.valueOf(com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - this.zzf);
                        if (zzexqVar.zza() <= 39 || zzexqVar.zza() >= 52) {
                            zzdweVarZza.zzb("lat_clsg", strValueOf);
                        } else {
                            zzdweVarZza.zzb("lat_gmssg", strValueOf);
                        }
                    }
                }
            }
            zzdweVarZza.zzh();
        }
    }
}
