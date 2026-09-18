package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdjx implements zzhhd {
    private final zzdjr zza;
    private final zzhhu zzb;
    private final zzhhu zzc;
    private final zzhhu zzd;
    private final zzhhu zze;

    public zzdjx(zzdjr zzdjrVar, zzhhu zzhhuVar, zzhhu zzhhuVar2, zzhhu zzhhuVar3, zzhhu zzhhuVar4) {
        this.zza = zzdjrVar;
        this.zzb = zzhhuVar;
        this.zzc = zzhhuVar2;
        this.zzd = zzhhuVar3;
        this.zze = zzhhuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        final Context context = (Context) this.zzb.zzb();
        final zzcei zzceiVarZza = ((zzcly) this.zzc).zza();
        final zzfgm zzfgmVarZza = ((zzcwy) this.zzd).zza();
        final zzfhh zzfhhVarZza = ((zzdao) this.zze).zza();
        return new zzdim(new zzdcl() { // from class: com.google.android.gms.internal.ads.zzdjp
            @Override // com.google.android.gms.internal.ads.zzdcl
            public final void zzr() {
                com.google.android.gms.ads.internal.zzt.zzs().zzn(context, zzceiVarZza.zza, zzfgmVarZza.zzD.toString(), zzfhhVarZza.zzf);
            }
        }, zzcep.zzf);
    }
}
