package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzedo implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;
    private final zzhhu zzc;
    private final zzhhu zzd;
    private final zzhhu zze;
    private final zzhhu zzf;
    private final zzhhu zzg;
    private final zzhhu zzh;
    private final zzhhu zzi;

    public zzedo(zzhhu zzhhuVar, zzhhu zzhhuVar2, zzhhu zzhhuVar3, zzhhu zzhhuVar4, zzhhu zzhhuVar5, zzhhu zzhhuVar6, zzhhu zzhhuVar7, zzhhu zzhhuVar8, zzhhu zzhhuVar9) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
        this.zzc = zzhhuVar3;
        this.zzd = zzhhuVar4;
        this.zze = zzhhuVar5;
        this.zzf = zzhhuVar6;
        this.zzg = zzhhuVar7;
        this.zzh = zzhhuVar8;
        this.zzi = zzhhuVar9;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzedn zzb() {
        zzddq zzddqVarZzb = ((zzddr) this.zza).zzb();
        zzecv zzecvVarZzb = ((zzecw) this.zzb).zzb();
        zzflm zzflmVar = (zzflm) this.zzc.zzb();
        zzfhh zzfhhVarZza = ((zzdao) this.zzd).zza();
        zzcei zzceiVarZza = ((zzcly) this.zze).zza();
        zzfnc zzfncVar = (zzfnc) this.zzf.zzb();
        zzfmz zzfmzVar = (zzfmz) this.zzg.zzb();
        Context contextZza = ((zzclm) this.zzh).zza();
        zzgey zzgeyVar = zzcep.zza;
        zzhhl.zzb(zzgeyVar);
        return new zzedn(zzddqVarZzb, zzecvVarZzb, zzflmVar, zzfhhVarZza, zzceiVarZza, zzfncVar, zzfmzVar, contextZza, zzgeyVar);
    }
}
