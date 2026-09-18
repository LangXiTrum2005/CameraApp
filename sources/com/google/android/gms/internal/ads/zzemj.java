package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzemj {
    private final zzfhz zza;
    private final zzdtx zzb;
    private final zzdwf zzc;
    private final zzflw zzd;

    public zzemj(zzfhz zzfhzVar, zzdtx zzdtxVar, zzdwf zzdwfVar, zzflw zzflwVar) {
        this.zza = zzfhzVar;
        this.zzb = zzdtxVar;
        this.zzc = zzdwfVar;
        this.zzd = zzflwVar;
    }

    public final void zza(zzfgp zzfgpVar, zzfgm zzfgmVar, int i, @Nullable zzeir zzeirVar, long j) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziz)).booleanValue()) {
            zzflv zzflvVarZzb = zzflv.zzb("adapter_status");
            zzflvVarZzb.zzg(zzfgpVar);
            zzflvVarZzb.zzf(zzfgmVar);
            zzflvVarZzb.zza("adapter_l", String.valueOf(j));
            zzflvVarZzb.zza("sc", Integer.toString(i));
            if (zzeirVar != null) {
                zzflvVarZzb.zza("arec", Integer.toString(zzeirVar.zzb().zza));
                String strZza = this.zza.zza(zzeirVar.getMessage());
                if (strZza != null) {
                    zzflvVarZzb.zza("areec", strZza);
                }
            }
            zzdtw zzdtwVarZzb = this.zzb.zzb(zzfgmVar.zzu);
            if (zzdtwVarZzb != null) {
                zzflvVarZzb.zza("ancn", zzdtwVarZzb.zza);
                zzbvg zzbvgVar = zzdtwVarZzb.zzb;
                if (zzbvgVar != null) {
                    zzflvVarZzb.zza("adapter_v", zzbvgVar.toString());
                }
                zzbvg zzbvgVar2 = zzdtwVarZzb.zzc;
                if (zzbvgVar2 != null) {
                    zzflvVarZzb.zza("adapter_sv", zzbvgVar2.toString());
                }
            }
            this.zzd.zzb(zzflvVarZzb);
            return;
        }
        zzdwe zzdweVarZza = this.zzc.zza();
        zzdweVarZza.zze(zzfgpVar);
        zzdweVarZza.zzd(zzfgmVar);
        zzdweVarZza.zzb("action", "adapter_status");
        zzdweVarZza.zzb("adapter_l", String.valueOf(j));
        zzdweVarZza.zzb("sc", Integer.toString(i));
        if (zzeirVar != null) {
            zzdweVarZza.zzb("arec", Integer.toString(zzeirVar.zzb().zza));
            String strZza2 = this.zza.zza(zzeirVar.getMessage());
            if (strZza2 != null) {
                zzdweVarZza.zzb("areec", strZza2);
            }
        }
        zzdtw zzdtwVarZzb2 = this.zzb.zzb(zzfgmVar.zzu);
        if (zzdtwVarZzb2 != null) {
            zzdweVarZza.zzb("ancn", zzdtwVarZzb2.zza);
            zzbvg zzbvgVar3 = zzdtwVarZzb2.zzb;
            if (zzbvgVar3 != null) {
                zzdweVarZza.zzb("adapter_v", zzbvgVar3.toString());
            }
            zzbvg zzbvgVar4 = zzdtwVarZzb2.zzc;
            if (zzbvgVar4 != null) {
                zzdweVarZza.zzb("adapter_sv", zzbvgVar4.toString());
            }
        }
        zzdweVarZza.zzg();
    }
}
