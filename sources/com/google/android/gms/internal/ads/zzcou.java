package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcou implements zzfes {
    private final zzcnc zza;
    private final zzcou zzb = this;
    private final zzhhm zzc;
    private final zzhhm zzd;
    private final zzhhm zze;
    private final zzhhm zzf;
    private final zzhhm zzg;
    private final zzhhm zzh;
    private final zzhhm zzi;

    /* synthetic */ zzcou(zzcnc zzcncVar, Context context, String str, com.google.android.gms.ads.internal.client.zzq zzqVar, zzcot zzcotVar) {
        this.zza = zzcncVar;
        zzhhd zzhhdVarZza = zzhhe.zza(context);
        this.zzc = zzhhdVarZza;
        zzhhd zzhhdVarZza2 = zzhhe.zza(zzqVar);
        this.zzd = zzhhdVarZza2;
        zzhhd zzhhdVarZza3 = zzhhe.zza(str);
        this.zze = zzhhdVarZza3;
        zzhhm zzhhmVarZzc = zzhhc.zzc(new zzeqf(zzcncVar.zzn));
        this.zzf = zzhhmVarZzc;
        zzhhm zzhhmVarZzc2 = zzhhc.zzc(new zzffq(zzcncVar.zzaI));
        this.zzg = zzhhmVarZzc2;
        zzhhm zzhhmVarZzc3 = zzhhc.zzc(new zzfeq(zzhhdVarZza, zzcncVar.zzo, zzcncVar.zzU, zzhhmVarZzc, zzhhmVarZzc2, zzfhj.zza()));
        this.zzh = zzhhmVarZzc3;
        this.zzi = zzhhc.zzc(new zzeqn(zzhhdVarZza, zzhhdVarZza2, zzhhdVarZza3, zzhhmVarZzc3, zzhhmVarZzc, zzhhmVarZzc2, zzcncVar.zzh, zzcncVar.zzV, zzcncVar.zzZ));
    }

    @Override // com.google.android.gms.internal.ads.zzfes
    public final zzeqm zza() {
        return (zzeqm) this.zzi.zzb();
    }
}
