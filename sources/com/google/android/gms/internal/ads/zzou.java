package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzou {
    final /* synthetic */ zzov zza;
    private final String zzb;
    private int zzc;
    private long zzd;
    private zzur zze;
    private boolean zzf;
    private boolean zzg;

    public zzou(zzov zzovVar, String str, int i, zzur zzurVar) {
        this.zza = zzovVar;
        this.zzb = str;
        this.zzc = i;
        this.zzd = zzurVar == null ? -1L : zzurVar.zzd;
        if (zzurVar == null || !zzurVar.zzb()) {
            return;
        }
        this.zze = zzurVar;
    }

    public final void zzg(int i, zzur zzurVar) {
        if (this.zzd == -1 && i == this.zzc && zzurVar != null) {
            zzov zzovVar = this.zza;
            long j = zzurVar.zzd;
            if (j >= zzovVar.zzl()) {
                this.zzd = j;
            }
        }
    }

    public final boolean zzj(int i, zzur zzurVar) {
        if (zzurVar == null) {
            return i == this.zzc;
        }
        zzur zzurVar2 = this.zze;
        if (zzurVar2 == null) {
            return !zzurVar.zzb() && zzurVar.zzd == this.zzd;
        }
        return zzurVar.zzd == zzurVar2.zzd && zzurVar.zzb == zzurVar2.zzb && zzurVar.zzc == zzurVar2.zzc;
    }

    public final boolean zzk(zzmq zzmqVar) {
        zzur zzurVar = zzmqVar.zzd;
        if (zzurVar == null) {
            return this.zzc != zzmqVar.zzc;
        }
        long j = this.zzd;
        if (j == -1) {
            return false;
        }
        if (zzurVar.zzd > j) {
            return true;
        }
        if (this.zze == null) {
            return false;
        }
        zzcx zzcxVar = zzmqVar.zzb;
        int iZza = zzcxVar.zza(zzurVar.zza);
        int iZza2 = zzcxVar.zza(this.zze.zza);
        zzur zzurVar2 = zzmqVar.zzd;
        if (zzurVar2.zzd < this.zze.zzd || iZza < iZza2) {
            return false;
        }
        if (iZza > iZza2) {
            return true;
        }
        if (!zzurVar2.zzb()) {
            int i = zzmqVar.zzd.zze;
            return i == -1 || i > this.zze.zzb;
        }
        zzur zzurVar3 = zzmqVar.zzd;
        int i2 = zzurVar3.zzb;
        int i3 = zzurVar3.zzc;
        zzur zzurVar4 = this.zze;
        int i4 = zzurVar4.zzb;
        if (i2 <= i4) {
            return i2 == i4 && i3 > zzurVar4.zzc;
        }
        return true;
    }

    public final boolean zzl(zzcx zzcxVar, zzcx zzcxVar2) {
        int i = this.zzc;
        if (i < zzcxVar.zzc()) {
            zzcxVar.zze(i, this.zza.zzc, 0L);
            int i2 = this.zza.zzc.zzp;
            while (true) {
                if (i2 > this.zza.zzc.zzq) {
                    i = -1;
                    break;
                }
                int iZza = zzcxVar2.zza(zzcxVar.zzf(i2));
                if (iZza != -1) {
                    i = zzcxVar2.zzd(iZza, this.zza.zzd, false).zzd;
                    break;
                }
                i2++;
            }
        } else if (i >= zzcxVar2.zzc()) {
            i = -1;
            break;
        }
        this.zzc = i;
        if (i == -1) {
            return false;
        }
        zzur zzurVar = this.zze;
        return zzurVar == null || zzcxVar2.zza(zzurVar.zza) != -1;
    }
}
