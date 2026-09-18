package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzccc extends zzcci {
    private final Clock zzb;
    private final zzccc zzc = this;
    private final zzhhm zzd;
    private final zzhhm zze;
    private final zzhhm zzf;
    private final zzhhm zzg;
    private final zzhhm zzh;
    private final zzhhm zzi;
    private final zzhhm zzj;
    private final zzhhm zzk;

    /* synthetic */ zzccc(Context context, Clock clock, com.google.android.gms.ads.internal.util.zzg zzgVar, zzcch zzcchVar, zzccb zzccbVar) {
        this.zzb = clock;
        zzhhd zzhhdVarZza = zzhhe.zza(context);
        this.zzd = zzhhdVarZza;
        zzhhd zzhhdVarZza2 = zzhhe.zza(zzgVar);
        this.zze = zzhhdVarZza2;
        zzhhd zzhhdVarZza3 = zzhhe.zza(zzcchVar);
        this.zzf = zzhhdVarZza3;
        this.zzg = zzhhc.zzc(new zzcbu(zzhhdVarZza, zzhhdVarZza2, zzhhdVarZza3));
        zzhhd zzhhdVarZza4 = zzhhe.zza(clock);
        this.zzh = zzhhdVarZza4;
        zzhhm zzhhmVarZzc = zzhhc.zzc(new zzcbw(zzhhdVarZza4, zzhhdVarZza2, zzhhdVarZza3));
        this.zzi = zzhhmVarZzc;
        zzcby zzcbyVar = new zzcby(zzhhdVarZza4, zzhhmVarZzc);
        this.zzj = zzcbyVar;
        this.zzk = zzhhc.zzc(new zzccn(zzhhdVarZza, zzcbyVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    final zzcbt zza() {
        return (zzcbt) this.zzg.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    final zzcbx zzb() {
        return new zzcbx(this.zzb, (zzcbv) this.zzi.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzcci
    final zzccm zzc() {
        return (zzccm) this.zzk.zzb();
    }
}
