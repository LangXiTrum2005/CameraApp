package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdld implements zzcwk {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final zzhhu zzd;
    private final zzdnl zze;

    zzdld(Map map, Map map2, Map map3, zzhhu zzhhuVar, zzdnl zzdnlVar) {
        this.zza = map;
        this.zzb = map2;
        this.zzc = map3;
        this.zzd = zzhhuVar;
        this.zze = zzdnlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcwk
    public final zzein zza(int i, String str) {
        zzein zzeinVarZza;
        zzein zzeinVar = (zzein) this.zza.get(str);
        if (zzeinVar != null) {
            return zzeinVar;
        }
        if (i != 1) {
            if (i != 4) {
                return null;
            }
            zzelb zzelbVar = (zzelb) this.zzc.get(str);
            if (zzelbVar != null) {
                return new zzeio(zzelbVar, new zzfws() { // from class: com.google.android.gms.internal.ads.zzcwm
                    @Override // com.google.android.gms.internal.ads.zzfws
                    public final Object apply(Object obj) {
                        return new zzcwp((List) obj);
                    }
                });
            }
            zzeinVarZza = (zzein) this.zzb.get(str);
            if (zzeinVarZza == null) {
                return null;
            }
        } else if (this.zze.zze() == null || (zzeinVarZza = ((zzcwk) this.zzd.zzb()).zza(i, str)) == null) {
            return null;
        }
        return new zzeio(zzeinVarZza, new zzfws() { // from class: com.google.android.gms.internal.ads.zzcwn
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                return new zzcwp((zzcwh) obj);
            }
        });
    }
}
