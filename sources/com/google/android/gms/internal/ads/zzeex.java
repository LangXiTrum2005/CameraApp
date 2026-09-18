package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeex implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;
    private final zzhhu zzc;
    private final zzhhu zzd;
    private final zzhhu zze;
    private final zzhhu zzf;
    private final zzhhu zzg;

    public zzeex(zzhhu zzhhuVar, zzhhu zzhhuVar2, zzhhu zzhhuVar3, zzhhu zzhhuVar4, zzhhu zzhhuVar5, zzhhu zzhhuVar6, zzhhu zzhhuVar7) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
        this.zzc = zzhhuVar3;
        this.zzd = zzhhuVar4;
        this.zze = zzhhuVar5;
        this.zzf = zzhhuVar6;
        this.zzg = zzhhuVar7;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.google.android.gms.internal.ads.zzeze, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzezc, java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* synthetic */ Object zzb() {
        Context contextZza = ((zzclm) this.zza).zza();
        zzhhu zzhhuVar = this.zzc;
        ?? Zzb = this.zzb.zzb();
        ?? Zzb2 = zzhhuVar.zzb();
        zzefb zzefbVar = new zzefb();
        zzefe zzefeVarZzb = ((zzeff) this.zze).zzb();
        zzgey zzgeyVar = zzcep.zza;
        zzhhl.zzb(zzgeyVar);
        return new zzeew(contextZza, Zzb, Zzb2, zzefbVar, zzefeVarZzb, zzgeyVar, new zzbzq());
    }
}
