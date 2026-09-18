package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcmu extends zzezd {
    private final zzfak zza;
    private final zzcnc zzb;
    private final zzcmu zzc = this;
    private final zzhhm zzd;
    private final zzhhm zze;
    private final zzhhm zzf;
    private final zzhhm zzg;
    private final zzhhm zzh;
    private final zzhhm zzi;
    private final zzhhm zzj;
    private final zzhhm zzk;
    private final zzhhm zzl;
    private final zzhhm zzm;
    private final zzhhm zzn;

    /* synthetic */ zzcmu(zzcnc zzcncVar, zzfak zzfakVar, zzcmt zzcmtVar) {
        this.zzb = zzcncVar;
        this.zza = zzfakVar;
        zzfam zzfamVar = new zzfam(zzfakVar);
        this.zzd = zzfamVar;
        zzhhm zzhhmVarZzc = zzhhc.zzc(zzdve.zza());
        this.zze = zzhhmVarZzc;
        zzhhm zzhhmVarZzc2 = zzhhc.zzc(zzdvc.zza());
        this.zzf = zzhhmVarZzc2;
        zzhhm zzhhmVarZzc3 = zzhhc.zzc(zzdvg.zza());
        this.zzg = zzhhmVarZzc3;
        zzhhm zzhhmVarZzc4 = zzhhc.zzc(zzdvi.zza());
        this.zzh = zzhhmVarZzc4;
        zzhhg zzhhgVarZzc = zzhhh.zzc(4);
        zzhhgVarZzc.zzb(zzflg.GMS_SIGNALS, zzhhmVarZzc);
        zzhhgVarZzc.zzb(zzflg.BUILD_URL, zzhhmVarZzc2);
        zzhhgVarZzc.zzb(zzflg.HTTP, zzhhmVarZzc3);
        zzhhgVarZzc.zzb(zzflg.PRE_PROCESS, zzhhmVarZzc4);
        zzhhh zzhhhVarZzc = zzhhgVarZzc.zzc();
        this.zzi = zzhhhVarZzc;
        zzhhm zzhhmVarZzc5 = zzhhc.zzc(new zzdvj(zzfamVar, zzcncVar.zzg, zzfkh.zza(), zzhhhVarZzc));
        this.zzj = zzhhmVarZzc5;
        zzhhq zzhhqVarZza = zzhhr.zza(0, 1);
        zzhhqVarZza.zza(zzhhmVarZzc5);
        zzhhr zzhhrVarZzc = zzhhqVarZza.zzc();
        this.zzk = zzhhrVarZzc;
        zzflp zzflpVar = new zzflp(zzhhrVarZzc);
        this.zzl = zzflpVar;
        this.zzm = zzhhc.zzc(new zzflo(zzfkh.zza(), zzcncVar.zzm, zzflpVar));
        this.zzn = zzhhc.zzc(new zzfna(zzcncVar.zzG));
    }

    @Override // com.google.android.gms.internal.ads.zzezd
    public final zzext zza() {
        Context contextZza = this.zzb.zza.zza();
        zzhhl.zzb(contextZza);
        zzccz zzcczVar = new zzccz();
        zzgey zzgeyVar = zzcep.zza;
        zzhhl.zzb(zzgeyVar);
        zzfae zzfaeVar = new zzfae(zzcczVar, zzgeyVar, zzfal.zza(this.zza));
        zzgey zzgeyVar2 = zzcep.zza;
        zzhhl.zzb(zzgeyVar2);
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zzb.zzm.zzb();
        zzfmz zzfmzVar = (zzfmz) this.zzn.zzb();
        zzdwf zzdwfVar = (zzdwf) this.zzb.zzZ.zzb();
        HashSet hashSet = new HashSet();
        hashSet.add(new zzevy(zzfaeVar, 0L, scheduledExecutorService));
        return new zzext(contextZza, zzgeyVar2, hashSet, zzfmzVar, zzdwfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzezd
    public final zzflm zzb() {
        return (zzflm) this.zzm.zzb();
    }
}
