package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfiw implements zzfiv {
    private final ConcurrentHashMap zza;
    private final zzfjc zzb;
    private final zzfiy zzc = new zzfiy();

    public zzfiw(zzfjc zzfjcVar) {
        this.zza = new ConcurrentHashMap(zzfjcVar.zzd);
        this.zzb = zzfjcVar;
    }

    private final void zzf() {
        Parcelable.Creator<zzfjc> creator = zzfjc.CREATOR;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgs)).booleanValue()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.zzb.zzb);
            sb.append(" PoolCollection");
            sb.append(this.zzc.zzb());
            int i = 0;
            for (Map.Entry entry : this.zza.entrySet()) {
                i++;
                sb.append(i);
                sb.append(". ");
                sb.append(entry.getValue());
                sb.append("#");
                sb.append(((zzfjf) entry.getKey()).hashCode());
                sb.append("    ");
                for (int i2 = 0; i2 < ((zzfiu) entry.getValue()).zzb(); i2++) {
                    sb.append("[O]");
                }
                for (int iZzb = ((zzfiu) entry.getValue()).zzb(); iZzb < this.zzb.zzd; iZzb++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(((zzfiu) entry.getValue()).zzg());
                sb.append("\n");
            }
            while (i < this.zzb.zzc) {
                i++;
                sb.append(i);
                sb.append(".\n");
            }
            zzcec.zze(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfiv
    public final zzfjc zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfiv
    public final synchronized zzfje zzb(zzfjf zzfjfVar) {
        zzfje zzfjeVarZze;
        zzfiu zzfiuVar = (zzfiu) this.zza.get(zzfjfVar);
        if (zzfiuVar != null) {
            zzfjeVarZze = zzfiuVar.zze();
            if (zzfjeVarZze == null) {
                this.zzc.zze();
            }
            zzfjs zzfjsVarZzf = zzfiuVar.zzf();
            if (zzfjeVarZze != null) {
                zzbce zzbceVarZza = zzbck.zza();
                zzbcc zzbccVarZza = zzbcd.zza();
                zzbccVarZza.zzd(2);
                zzbcg zzbcgVarZza = zzbch.zza();
                zzbcgVarZza.zza(zzfjsVarZzf.zza);
                zzbcgVarZza.zzb(zzfjsVarZzf.zzb);
                zzbccVarZza.zza(zzbcgVarZza);
                zzbceVarZza.zza(zzbccVarZza);
                zzfjeVarZze.zza.zzb().zzc().zzi((zzbck) zzbceVarZza.zzal());
            }
            zzf();
        } else {
            this.zzc.zzf();
            zzf();
            zzfjeVarZze = null;
        }
        return zzfjeVarZze;
    }

    @Override // com.google.android.gms.internal.ads.zzfiv
    @Deprecated
    public final zzfjf zzc(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, com.google.android.gms.ads.internal.client.zzw zzwVar) {
        return new zzfjg(zzlVar, str, new zzbzi(this.zzb.zza).zza().zzk, this.zzb.zzf, zzwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfiv
    public final synchronized boolean zzd(zzfjf zzfjfVar, zzfje zzfjeVar) {
        boolean zZzh;
        zzfiu zzfiuVar = (zzfiu) this.zza.get(zzfjfVar);
        zzfjeVar.zzd = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
        if (zzfiuVar == null) {
            zzfjc zzfjcVar = this.zzb;
            zzfiu zzfiuVar2 = new zzfiu(zzfjcVar.zzd, zzfjcVar.zze * 1000);
            if (this.zza.size() == this.zzb.zzc) {
                int i = this.zzb.zzg;
                int i2 = i - 1;
                zzfjf zzfjfVar2 = null;
                if (i == 0) {
                    throw null;
                }
                long jZzc = Long.MAX_VALUE;
                if (i2 == 0) {
                    for (Map.Entry entry : this.zza.entrySet()) {
                        if (((zzfiu) entry.getValue()).zzc() < jZzc) {
                            jZzc = ((zzfiu) entry.getValue()).zzc();
                            zzfjfVar2 = (zzfjf) entry.getKey();
                        }
                    }
                    if (zzfjfVar2 != null) {
                        this.zza.remove(zzfjfVar2);
                    }
                } else if (i2 == 1) {
                    for (Map.Entry entry2 : this.zza.entrySet()) {
                        if (((zzfiu) entry2.getValue()).zzd() < jZzc) {
                            jZzc = ((zzfiu) entry2.getValue()).zzd();
                            zzfjfVar2 = (zzfjf) entry2.getKey();
                        }
                    }
                    if (zzfjfVar2 != null) {
                        this.zza.remove(zzfjfVar2);
                    }
                } else if (i2 == 2) {
                    int iZza = Integer.MAX_VALUE;
                    for (Map.Entry entry3 : this.zza.entrySet()) {
                        if (((zzfiu) entry3.getValue()).zza() < iZza) {
                            iZza = ((zzfiu) entry3.getValue()).zza();
                            zzfjfVar2 = (zzfjf) entry3.getKey();
                        }
                    }
                    if (zzfjfVar2 != null) {
                        this.zza.remove(zzfjfVar2);
                    }
                }
                this.zzc.zzg();
            }
            this.zza.put(zzfjfVar, zzfiuVar2);
            this.zzc.zzd();
            zzfiuVar = zzfiuVar2;
        }
        zZzh = zzfiuVar.zzh(zzfjeVar);
        this.zzc.zzc();
        zzfix zzfixVarZza = this.zzc.zza();
        zzfjs zzfjsVarZzf = zzfiuVar.zzf();
        if (zzfjeVar != null) {
            zzbce zzbceVarZza = zzbck.zza();
            zzbcc zzbccVarZza = zzbcd.zza();
            zzbccVarZza.zzd(2);
            zzbci zzbciVarZza = zzbcj.zza();
            zzbciVarZza.zza(zzfixVarZza.zza);
            zzbciVarZza.zzb(zzfixVarZza.zzb);
            zzbciVarZza.zzc(zzfjsVarZzf.zzb);
            zzbccVarZza.zzc(zzbciVarZza);
            zzbceVarZza.zza(zzbccVarZza);
            zzfjeVar.zza.zzb().zzc().zzj((zzbck) zzbceVarZza.zzal());
        }
        zzf();
        return zZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzfiv
    public final synchronized boolean zze(zzfjf zzfjfVar) {
        zzfiu zzfiuVar = (zzfiu) this.zza.get(zzfjfVar);
        if (zzfiuVar == null) {
            return true;
        }
        return zzfiuVar.zzb() < this.zzb.zzd;
    }
}
