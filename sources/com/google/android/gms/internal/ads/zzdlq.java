package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdlq implements zzhhd {
    private final zzhhu zza;
    private final zzhhu zzb;
    private final zzhhu zzc;
    private final zzhhu zzd;
    private final zzhhu zze;
    private final zzhhu zzf;

    public zzdlq(zzhhu zzhhuVar, zzhhu zzhhuVar2, zzhhu zzhhuVar3, zzhhu zzhhuVar4, zzhhu zzhhuVar5, zzhhu zzhhuVar6) {
        this.zza = zzhhuVar;
        this.zzb = zzhhuVar2;
        this.zzc = zzhhuVar3;
        this.zzd = zzhhuVar4;
        this.zze = zzhhuVar5;
        this.zzf = zzhhuVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzclg zzclgVar = (zzclg) this.zza.zzb();
        zzdaf zzdafVarZza = ((zzdap) this.zzb).zza();
        zzdgo zzdgoVarZza = ((zzdhi) this.zzc).zza();
        zzdlf zzdlfVarZza = ((zzdlh) this.zzd).zza();
        zzddm zzddmVarZzb = ((zzcue) this.zze).zzb();
        zzemh zzemhVar = (zzemh) this.zzf.zzb();
        zzcvb zzcvbVarZze = zzclgVar.zze();
        zzcvbVarZze.zzi(zzdafVarZza.zzj());
        zzcvbVarZze.zzf(zzdgoVarZza);
        zzcvbVarZze.zzd(zzdlfVarZza);
        zzcvbVarZze.zze(new zzeon(null));
        zzcvbVarZze.zzg(new zzcvz(zzddmVarZzb, null));
        zzcvbVarZze.zzc(new zzcuc(null));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdv)).booleanValue()) {
            zzcvbVarZze.zzj(zzemq.zzb(zzemhVar));
        }
        zzcwk zzcwkVarZzc = zzcvbVarZze.zzh().zzc();
        zzhhl.zzb(zzcwkVarZzc);
        return zzcwkVarZzc;
    }
}
