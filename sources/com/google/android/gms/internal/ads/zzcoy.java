package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcoy implements zzfgg {
    private final zzcnc zza;
    private final zzcoy zzb = this;
    private final zzhhm zzc;
    private final zzhhm zzd;
    private final zzhhm zze;
    private final zzhhm zzf;
    private final zzhhm zzg;
    private final zzhhm zzh;
    private final zzhhm zzi;
    private final zzhhm zzj;

    /* synthetic */ zzcoy(zzcnc zzcncVar, Context context, String str, zzcox zzcoxVar) {
        this.zza = zzcncVar;
        zzhhd zzhhdVarZza = zzhhe.zza(context);
        this.zzc = zzhhdVarZza;
        zzfeg zzfegVar = new zzfeg(zzhhdVarZza, zzcncVar.zzaI, zzcncVar.zzaJ);
        this.zzd = zzfegVar;
        zzhhm zzhhmVarZzc = zzhhc.zzc(new zzffq(zzcncVar.zzaI));
        this.zze = zzhhmVarZzc;
        zzhhm zzhhmVarZzc2 = zzhhc.zzc(zzfhe.zza());
        this.zzf = zzhhmVarZzc2;
        zzhhm zzhhmVarZzc3 = zzhhc.zzc(new zzfga(zzhhdVarZza, zzcncVar.zzo, zzcncVar.zzU, zzfegVar, zzhhmVarZzc, zzfhj.zza(), zzhhmVarZzc2));
        this.zzg = zzhhmVarZzc3;
        this.zzh = zzhhc.zzc(new zzfgk(zzhhmVarZzc3, zzhhmVarZzc, zzhhmVarZzc2));
        zzhhd zzhhdVarZzc = zzhhe.zzc(str);
        this.zzi = zzhhdVarZzc;
        this.zzj = zzhhc.zzc(new zzfge(zzhhdVarZzc, zzhhmVarZzc3, zzhhdVarZza, zzhhmVarZzc, zzhhmVarZzc2, zzcncVar.zzh, zzcncVar.zzV, zzcncVar.zzZ));
    }

    @Override // com.google.android.gms.internal.ads.zzfgg
    public final zzfgd zza() {
        return (zzfgd) this.zzj.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzfgg
    public final zzfgj zzb() {
        return (zzfgj) this.zzh.zzb();
    }
}
