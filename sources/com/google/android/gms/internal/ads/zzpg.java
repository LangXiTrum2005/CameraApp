package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzpg {
    public static final zzpg zza = new zzpe().zzd();
    public final boolean zzb;
    public final boolean zzc;
    public final boolean zzd;

    /* synthetic */ zzpg(zzpe zzpeVar, zzpf zzpfVar) {
        this.zzb = zzpeVar.zza;
        this.zzc = zzpeVar.zzb;
        this.zzd = zzpeVar.zzc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzpg zzpgVar = (zzpg) obj;
            if (this.zzb == zzpgVar.zzb && this.zzc == zzpgVar.zzc && this.zzd == zzpgVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        boolean z = this.zzb;
        boolean z2 = this.zzc;
        return ((z ? 1 : 0) << 2) + (z2 ? 1 : 0) + (z2 ? 1 : 0) + (this.zzd ? 1 : 0);
    }
}
