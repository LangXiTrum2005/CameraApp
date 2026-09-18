package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaqt {
    long zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final long zze;
    final long zzf;
    final long zzg;
    final List zzh;

    /* JADX WARN: Illegal instructions before constructor call */
    zzaqt(String str, zzapj zzapjVar) {
        String str2 = zzapjVar.zzb;
        long j = zzapjVar.zzc;
        long j2 = zzapjVar.zzd;
        long j3 = zzapjVar.zze;
        long j4 = zzapjVar.zzf;
        List arrayList = zzapjVar.zzh;
        if (arrayList == null) {
            Map map = zzapjVar.zzg;
            arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new zzaps((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        this(str, str2, j, j2, j3, j4, arrayList);
    }

    static zzaqt zza(zzaqu zzaquVar) throws IOException {
        if (zzaqw.zze(zzaquVar) != 538247942) {
            throw new IOException();
        }
        String strZzh = zzaqw.zzh(zzaquVar);
        String strZzh2 = zzaqw.zzh(zzaquVar);
        long jZzf = zzaqw.zzf(zzaquVar);
        long jZzf2 = zzaqw.zzf(zzaquVar);
        long jZzf3 = zzaqw.zzf(zzaquVar);
        long jZzf4 = zzaqw.zzf(zzaquVar);
        int iZze = zzaqw.zze(zzaquVar);
        if (iZze < 0) {
            throw new IOException("readHeaderList size=" + iZze);
        }
        List listEmptyList = iZze == 0 ? Collections.emptyList() : new ArrayList();
        for (int i = 0; i < iZze; i++) {
            listEmptyList.add(new zzaps(zzaqw.zzh(zzaquVar).intern(), zzaqw.zzh(zzaquVar).intern()));
        }
        return new zzaqt(strZzh, strZzh2, jZzf, jZzf2, jZzf3, jZzf4, listEmptyList);
    }

    private zzaqt(String str, String str2, long j, long j2, long j3, long j4, List list) {
        this.zzb = str;
        this.zzc = true == "".equals(str2) ? null : str2;
        this.zzd = j;
        this.zze = j2;
        this.zzf = j3;
        this.zzg = j4;
        this.zzh = list;
    }
}
