package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzazu {
    private final int zza;
    private final zzazr zzb = new zzazw();

    public zzazu(int i) {
        this.zza = i;
    }

    public final String zza(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            sb.append(((String) arrayList.get(i)).toLowerCase(Locale.US));
            sb.append('\n');
        }
        String[] strArrSplit = sb.toString().split("\n");
        if (strArrSplit.length == 0) {
            return "";
        }
        zzazt zzaztVar = new zzazt();
        PriorityQueue priorityQueue = new PriorityQueue(this.zza, new zzazs(this));
        for (String str : strArrSplit) {
            String[] strArrZzb = zzazv.zzb(str, false);
            if (strArrZzb.length != 0) {
                zzazz.zzc(strArrZzb, this.zza, 6, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzaztVar.zzb.write(this.zzb.zzb(((zzazy) it.next()).zzb));
            } catch (IOException e) {
                zzcec.zzh("Error while writing hash to byteStream", e);
            }
        }
        return zzaztVar.toString();
    }
}
