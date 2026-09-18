package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcnw implements zzfdb {
    private final Context zza;
    private final com.google.android.gms.ads.internal.client.zzq zzb;
    private final String zzc;
    private final zzcnc zzd;
    private final zzcnw zze = this;
    private final zzhhm zzf;
    private final zzhhm zzg;
    private final zzhhm zzh;
    private final zzhhm zzi;
    private final zzhhm zzj;
    private final zzhhm zzk;

    /* synthetic */ zzcnw(zzcnc zzcncVar, Context context, String str, com.google.android.gms.ads.internal.client.zzq zzqVar, zzcnv zzcnvVar) {
        this.zzd = zzcncVar;
        this.zza = context;
        this.zzb = zzqVar;
        this.zzc = str;
        zzhhd zzhhdVarZza = zzhhe.zza(context);
        this.zzf = zzhhdVarZza;
        zzhhd zzhhdVarZza2 = zzhhe.zza(zzqVar);
        this.zzg = zzhhdVarZza2;
        zzhhm zzhhmVarZzc = zzhhc.zzc(new zzeqf(zzcncVar.zzn));
        this.zzh = zzhhmVarZzc;
        zzhhm zzhhmVarZzc2 = zzhhc.zzc(zzeqk.zza());
        this.zzi = zzhhmVarZzc2;
        zzhhm zzhhmVarZzc3 = zzhhc.zzc(zzdfv.zza());
        this.zzj = zzhhmVarZzc3;
        this.zzk = zzhhc.zzc(new zzfcz(zzhhdVarZza, zzcncVar.zzo, zzhhdVarZza2, zzcncVar.zzU, zzhhmVarZzc, zzhhmVarZzc2, zzfhj.zza(), zzhhmVarZzc3));
    }

    @Override // com.google.android.gms.internal.ads.zzfdb
    public final zzepk zza() {
        zzfcy zzfcyVar = (zzfcy) this.zzk.zzb();
        zzeqe zzeqeVar = (zzeqe) this.zzh.zzb();
        zzcei zzceiVarZzd = this.zzd.zza.zzd();
        zzhhl.zzb(zzceiVarZzd);
        return new zzepk(this.zza, this.zzb, this.zzc, zzfcyVar, zzeqeVar, zzceiVarZzd, (zzdwf) this.zzd.zzZ.zzb());
    }
}
