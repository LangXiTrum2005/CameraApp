package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzawd implements zzfsq {
    private final zzfqt zza;
    private final zzfrk zzb;
    private final zzawq zzc;
    private final zzawc zzd;
    private final zzavm zze;
    private final zzaws zzf;
    private final zzawk zzg;
    private final zzawb zzh;

    zzawd(zzfqt zzfqtVar, zzfrk zzfrkVar, zzawq zzawqVar, zzawc zzawcVar, zzavm zzavmVar, zzaws zzawsVar, zzawk zzawkVar, zzawb zzawbVar) {
        this.zza = zzfqtVar;
        this.zzb = zzfrkVar;
        this.zzc = zzawqVar;
        this.zzd = zzawcVar;
        this.zze = zzavmVar;
        this.zzf = zzawsVar;
        this.zzg = zzawkVar;
        this.zzh = zzawbVar;
    }

    private final Map zze() {
        HashMap map = new HashMap();
        zzfqt zzfqtVar = this.zza;
        zzatd zzatdVarZzb = this.zzb.zzb();
        map.put("v", zzfqtVar.zzb());
        map.put("gms", Boolean.valueOf(this.zza.zzc()));
        map.put("int", zzatdVarZzb.zzh());
        map.put("up", Boolean.valueOf(this.zzd.zza()));
        map.put("t", new Throwable());
        zzawk zzawkVar = this.zzg;
        if (zzawkVar != null) {
            map.put("tcq", Long.valueOf(zzawkVar.zzc()));
            map.put("tpq", Long.valueOf(this.zzg.zzg()));
            map.put("tcv", Long.valueOf(this.zzg.zzd()));
            map.put("tpv", Long.valueOf(this.zzg.zzh()));
            map.put("tchv", Long.valueOf(this.zzg.zzb()));
            map.put("tphv", Long.valueOf(this.zzg.zzf()));
            map.put("tcc", Long.valueOf(this.zzg.zza()));
            map.put("tpc", Long.valueOf(this.zzg.zze()));
        }
        return map;
    }

    @Override // com.google.android.gms.internal.ads.zzfsq
    public final Map zza() {
        zzawq zzawqVar = this.zzc;
        Map mapZze = zze();
        mapZze.put("lts", Long.valueOf(zzawqVar.zza()));
        return mapZze;
    }

    @Override // com.google.android.gms.internal.ads.zzfsq
    public final Map zzb() {
        Map mapZze = zze();
        zzatd zzatdVarZza = this.zzb.zza();
        mapZze.put("gai", Boolean.valueOf(this.zza.zzd()));
        mapZze.put("did", zzatdVarZza.zzg());
        mapZze.put("dst", Integer.valueOf(zzatdVarZza.zzal() - 1));
        mapZze.put("doo", Boolean.valueOf(zzatdVarZza.zzai()));
        zzavm zzavmVar = this.zze;
        if (zzavmVar != null) {
            mapZze.put("nt", Long.valueOf(zzavmVar.zza()));
        }
        zzaws zzawsVar = this.zzf;
        if (zzawsVar != null) {
            mapZze.put("vs", Long.valueOf(zzawsVar.zzc()));
            mapZze.put("vf", Long.valueOf(this.zzf.zzb()));
        }
        return mapZze;
    }

    @Override // com.google.android.gms.internal.ads.zzfsq
    public final Map zzc() {
        zzawb zzawbVar = this.zzh;
        Map mapZze = zze();
        if (zzawbVar != null) {
            mapZze.put("vst", zzawbVar.zza());
        }
        return mapZze;
    }

    final void zzd(View view) {
        this.zzc.zzd(view);
    }
}
