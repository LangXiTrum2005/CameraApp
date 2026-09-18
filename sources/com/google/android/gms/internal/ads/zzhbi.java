package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhbi implements zzhby {
    private final zzhbe zza;
    private final zzhcp zzb;
    private final boolean zzc;
    private final zzgzg zzd;

    private zzhbi(zzhcp zzhcpVar, zzgzg zzgzgVar, zzhbe zzhbeVar) {
        this.zzb = zzhcpVar;
        this.zzc = zzgzgVar.zzh(zzhbeVar);
        this.zzd = zzgzgVar;
        this.zza = zzhbeVar;
    }

    static zzhbi zzc(zzhcp zzhcpVar, zzgzg zzgzgVar, zzhbe zzhbeVar) {
        return new zzhbi(zzhcpVar, zzgzgVar, zzhbeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final int zza(Object obj) {
        zzhcp zzhcpVar = this.zzb;
        int iZzb = zzhcpVar.zzb(zzhcpVar.zzd(obj));
        if (!this.zzc) {
            return iZzb;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final int zzb(Object obj) {
        int iHashCode = this.zzb.zzd(obj).hashCode();
        if (!this.zzc) {
            return iHashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final Object zze() {
        zzhbe zzhbeVar = this.zza;
        return zzhbeVar instanceof zzgzu ? ((zzgzu) zzhbeVar).zzaD() : zzhbeVar.zzaP().zzan();
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final void zzf(Object obj) {
        this.zzb.zzm(obj);
        this.zzd.zze(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final void zzg(Object obj, Object obj2) {
        zzhca.zzq(this.zzb, obj, obj2);
        if (this.zzc) {
            this.zzd.zza(obj2);
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final void zzh(Object obj, zzhbq zzhbqVar, zzgzf zzgzfVar) throws IOException {
        boolean zZzO;
        zzhcp zzhcpVar = this.zzb;
        Object objZzc = zzhcpVar.zzc(obj);
        zzgzg zzgzgVar = this.zzd;
        zzgzk zzgzkVarZzb = zzgzgVar.zzb(obj);
        while (zzhbqVar.zzc() != Integer.MAX_VALUE) {
            try {
                int iZzd = zzhbqVar.zzd();
                if (iZzd != 11) {
                    if ((iZzd & 7) == 2) {
                        Object objZzc2 = zzgzgVar.zzc(zzgzfVar, this.zza, iZzd >>> 3);
                        if (objZzc2 != null) {
                            zzgzgVar.zzf(zzhbqVar, objZzc2, zzgzfVar, zzgzkVarZzb);
                        } else {
                            zZzO = zzhcpVar.zzp(objZzc, zzhbqVar);
                        }
                    } else {
                        zZzO = zzhbqVar.zzO();
                    }
                    if (!zZzO) {
                        break;
                    }
                } else {
                    Object objZzc3 = null;
                    int iZzj = 0;
                    zzgyl zzgylVarZzp = null;
                    while (zzhbqVar.zzc() != Integer.MAX_VALUE) {
                        int iZzd2 = zzhbqVar.zzd();
                        if (iZzd2 == 16) {
                            iZzj = zzhbqVar.zzj();
                            objZzc3 = zzgzgVar.zzc(zzgzfVar, this.zza, iZzj);
                        } else if (iZzd2 == 26) {
                            if (objZzc3 != null) {
                                zzgzgVar.zzf(zzhbqVar, objZzc3, zzgzfVar, zzgzkVarZzb);
                            } else {
                                zzgylVarZzp = zzhbqVar.zzp();
                            }
                        } else if (!zzhbqVar.zzO()) {
                            break;
                        }
                    }
                    if (zzhbqVar.zzd() != 12) {
                        throw zzhag.zzb();
                    }
                    if (zzgylVarZzp != null) {
                        if (objZzc3 != null) {
                            zzgzgVar.zzg(zzgylVarZzp, objZzc3, zzgzfVar, zzgzkVarZzb);
                        } else {
                            zzhcpVar.zzk(objZzc, iZzj, zzgylVarZzp);
                        }
                    }
                }
            } catch (Throwable th) {
                zzhcpVar.zzn(obj, objZzc);
                throw th;
            }
        }
        zzhcpVar.zzn(obj, objZzc);
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzgxx zzgxxVar) throws IOException {
        zzgzu zzgzuVar = (zzgzu) obj;
        if (zzgzuVar.zzc == zzhcq.zzc()) {
            zzgzuVar.zzc = zzhcq.zzf();
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final boolean zzj(Object obj, Object obj2) {
        zzhcp zzhcpVar = this.zzb;
        if (!zzhcpVar.zzd(obj).equals(zzhcpVar.zzd(obj2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(obj);
        this.zzd.zza(obj2);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final boolean zzk(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzhby
    public final void zzm(Object obj, zzgzb zzgzbVar) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }
}
