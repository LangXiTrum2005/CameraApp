package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaqn implements zzapz {
    private final Map zza = new HashMap();
    private final zzapm zzb;
    private final BlockingQueue zzc;
    private final zzapr zzd;

    zzaqn(zzapm zzapmVar, BlockingQueue blockingQueue, zzapr zzaprVar) {
        this.zzd = zzaprVar;
        this.zzb = zzapmVar;
        this.zzc = blockingQueue;
    }

    @Override // com.google.android.gms.internal.ads.zzapz
    public final synchronized void zza(zzaqa zzaqaVar) {
        Map map = this.zza;
        String strZzj = zzaqaVar.zzj();
        List list = (List) map.remove(strZzj);
        if (list == null || list.isEmpty()) {
            return;
        }
        if (zzaqm.zzb) {
            zzaqm.zzd("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), strZzj);
        }
        zzaqa zzaqaVar2 = (zzaqa) list.remove(0);
        this.zza.put(strZzj, list);
        zzaqaVar2.zzu(this);
        try {
            this.zzc.put(zzaqaVar2);
        } catch (InterruptedException e) {
            zzaqm.zzb("Couldn't add request to queue. %s", e.toString());
            Thread.currentThread().interrupt();
            this.zzb.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapz
    public final void zzb(zzaqa zzaqaVar, zzaqg zzaqgVar) {
        List list;
        zzapj zzapjVar = zzaqgVar.zzb;
        if (zzapjVar == null || zzapjVar.zza(System.currentTimeMillis())) {
            zza(zzaqaVar);
            return;
        }
        String strZzj = zzaqaVar.zzj();
        synchronized (this) {
            list = (List) this.zza.remove(strZzj);
        }
        if (list != null) {
            if (zzaqm.zzb) {
                zzaqm.zzd("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), strZzj);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.zzd.zzb((zzaqa) it.next(), zzaqgVar, null);
            }
        }
    }

    final synchronized boolean zzc(zzaqa zzaqaVar) {
        Map map = this.zza;
        String strZzj = zzaqaVar.zzj();
        if (!map.containsKey(strZzj)) {
            this.zza.put(strZzj, null);
            zzaqaVar.zzu(this);
            if (zzaqm.zzb) {
                zzaqm.zza("new request, sending to network %s", strZzj);
            }
            return false;
        }
        List arrayList = (List) this.zza.get(strZzj);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        zzaqaVar.zzm("waiting-for-response");
        arrayList.add(zzaqaVar);
        this.zza.put(strZzj, arrayList);
        if (zzaqm.zzb) {
            zzaqm.zza("Request for cacheKey=%s is in flight, putting on hold.", strZzj);
        }
        return true;
    }
}
