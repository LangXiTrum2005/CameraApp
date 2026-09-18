package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcnm implements zzfbn {
    private final zzcnc zza;
    private final zzcnm zzb = this;
    private final zzhhm zzc;
    private final zzhhm zzd;
    private final zzhhm zze;
    private final zzhhm zzf;
    private final zzhhm zzg;
    private final zzhhm zzh;

    /* synthetic */ zzcnm(zzcnc zzcncVar, Context context, String str, zzcnl zzcnlVar) {
        this.zza = zzcncVar;
        zzhhd zzhhdVarZza = zzhhe.zza(context);
        this.zzc = zzhhdVarZza;
        zzhhd zzhhdVarZza2 = zzhhe.zza(str);
        this.zzd = zzhhdVarZza2;
        zzfef zzfefVar = new zzfef(zzhhdVarZza, zzcncVar.zzaI, zzcncVar.zzaJ);
        this.zze = zzfefVar;
        zzhhm zzhhmVarZzc = zzhhc.zzc(new zzfcl(zzcncVar.zzaI));
        this.zzf = zzhhmVarZzc;
        zzhhm zzhhmVarZzc2 = zzhhc.zzc(new zzfcn(zzhhdVarZza, zzcncVar.zzo, zzcncVar.zzU, zzfefVar, zzhhmVarZzc, zzfhj.zza(), zzcncVar.zzh));
        this.zzg = zzhhmVarZzc2;
        this.zzh = zzhhc.zzc(new zzfct(zzcncVar.zzU, zzhhdVarZza, zzhhdVarZza2, zzhhmVarZzc2, zzhhmVarZzc, zzcncVar.zzh, zzcncVar.zzZ));
    }

    @Override // com.google.android.gms.internal.ads.zzfbn
    public final zzfcs zza() {
        return (zzfcs) this.zzh.zzb();
    }
}
