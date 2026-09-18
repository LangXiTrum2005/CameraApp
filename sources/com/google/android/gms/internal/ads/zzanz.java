package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzanz {
    private final List zza;
    private final zzaea[] zzb;

    public zzanz(List list) {
        this.zza = list;
        this.zzb = new zzaea[list.size()];
    }

    public final void zza(long j, zzfp zzfpVar) {
        zzach.zza(j, zzfpVar, this.zzb);
    }

    public final void zzb(zzacx zzacxVar, zzaok zzaokVar) {
        for (int i = 0; i < this.zzb.length; i++) {
            zzaokVar.zzc();
            zzaea zzaeaVarZzw = zzacxVar.zzw(zzaokVar.zza(), 3);
            zzam zzamVar = (zzam) this.zza.get(i);
            String str = zzamVar.zzm;
            boolean z = true;
            if (!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) {
                z = false;
            }
            zzek.zze(z, "Invalid closed caption MIME type provided: ".concat(String.valueOf(str)));
            String strZzb = zzamVar.zzb;
            if (strZzb == null) {
                strZzb = zzaokVar.zzb();
            }
            zzak zzakVar = new zzak();
            zzakVar.zzK(strZzb);
            zzakVar.zzW(str);
            zzakVar.zzY(zzamVar.zze);
            zzakVar.zzN(zzamVar.zzd);
            zzakVar.zzw(zzamVar.zzE);
            zzakVar.zzL(zzamVar.zzo);
            zzaeaVarZzw.zzl(zzakVar.zzac());
            this.zzb[i] = zzaeaVarZzw;
        }
    }
}
