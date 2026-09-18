package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzakl {
    public static void zza(zzakm zzakmVar, zzakq zzakqVar, zzep zzepVar) {
        for (int i = 0; i < zzakmVar.zza(); i++) {
            long jZzb = zzakmVar.zzb(i);
            List listZzc = zzakmVar.zzc(jZzb);
            if (!listZzc.isEmpty()) {
                if (i == zzakmVar.zza() - 1) {
                    throw new IllegalStateException();
                }
                zzepVar.zza(new zzakj(listZzc, jZzb, zzakmVar.zzb(i + 1) - zzakmVar.zzb(i)));
            }
        }
    }
}
