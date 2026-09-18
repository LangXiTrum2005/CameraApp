package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzano implements zzanx {
    private zzam zza;
    private zzfw zzb;
    private zzaea zzc;

    public zzano(String str) {
        zzak zzakVar = new zzak();
        zzakVar.zzW(str);
        this.zza = zzakVar.zzac();
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final void zza(zzfp zzfpVar) {
        zzek.zzb(this.zzb);
        int i = zzfy.zza;
        long jZze = this.zzb.zze();
        long jZzf = this.zzb.zzf();
        if (jZze == -9223372036854775807L || jZzf == -9223372036854775807L) {
            return;
        }
        zzam zzamVar = this.zza;
        if (jZzf != zzamVar.zzq) {
            zzak zzakVarZzb = zzamVar.zzb();
            zzakVarZzb.zzaa(jZzf);
            zzam zzamVarZzac = zzakVarZzb.zzac();
            this.zza = zzamVarZzac;
            this.zzc.zzl(zzamVarZzac);
        }
        int iZzb = zzfpVar.zzb();
        this.zzc.zzr(zzfpVar, iZzb);
        this.zzc.zzt(jZze, 1, iZzb, 0, null);
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final void zzb(zzfw zzfwVar, zzacx zzacxVar, zzaok zzaokVar) {
        this.zzb = zzfwVar;
        zzaokVar.zzc();
        zzaea zzaeaVarZzw = zzacxVar.zzw(zzaokVar.zza(), 5);
        this.zzc = zzaeaVarZzw;
        zzaeaVarZzw.zzl(this.zza);
    }
}
