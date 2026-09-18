package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaon {
    private final List zza;
    private final zzaea[] zzb;

    public zzaon(List list) {
        this.zza = list;
        this.zzb = new zzaea[list.size()];
    }

    public final void zza(long j, zzfp zzfpVar) {
        if (zzfpVar.zzb() < 9) {
            return;
        }
        int iZzg = zzfpVar.zzg();
        int iZzg2 = zzfpVar.zzg();
        int iZzm = zzfpVar.zzm();
        if (iZzg == 434 && iZzg2 == 1195456820 && iZzm == 3) {
            zzach.zzb(j, zzfpVar, this.zzb);
        }
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
            zzak zzakVar = new zzak();
            zzakVar.zzK(zzaokVar.zzb());
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
