package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdah {
    private final Context zza;
    private final zzfhh zzb;
    private final Bundle zzc;
    private final zzfgz zzd;
    private final zzczz zze;
    private final zzeis zzf;

    /* synthetic */ zzdah(zzdaf zzdafVar, zzdag zzdagVar) {
        this.zza = zzdafVar.zza;
        this.zzb = zzdafVar.zzb;
        this.zzc = zzdafVar.zzc;
        this.zzd = zzdafVar.zzd;
        this.zze = zzdafVar.zze;
        this.zzf = zzdafVar.zzf;
    }

    final Context zza(Context context) {
        return this.zza;
    }

    final Bundle zzb() {
        return this.zzc;
    }

    final zzczz zzc() {
        return this.zze;
    }

    final zzdaf zzd() {
        zzdaf zzdafVar = new zzdaf();
        zzdafVar.zze(this.zza);
        zzdafVar.zzi(this.zzb);
        zzdafVar.zzf(this.zzc);
        zzdafVar.zzg(this.zze);
        zzdafVar.zzd(this.zzf);
        return zzdafVar;
    }

    final zzeis zze(String str) {
        zzeis zzeisVar = this.zzf;
        return zzeisVar != null ? zzeisVar : new zzeis(str);
    }

    final zzfgz zzf() {
        return this.zzd;
    }

    final zzfhh zzg() {
        return this.zzb;
    }
}
