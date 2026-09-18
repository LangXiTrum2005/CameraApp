package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaep implements zzaej {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;

    private zzaep(int i, int i2, int i3, int i4, int i5, int i6) {
        this.zza = i;
        this.zzb = i3;
        this.zzc = i4;
        this.zzd = i5;
        this.zze = i6;
    }

    public static zzaep zzb(zzfp zzfpVar) {
        int iZzi = zzfpVar.zzi();
        zzfpVar.zzL(12);
        int iZzi2 = zzfpVar.zzi();
        int iZzi3 = zzfpVar.zzi();
        int iZzi4 = zzfpVar.zzi();
        zzfpVar.zzL(4);
        int iZzi5 = zzfpVar.zzi();
        int iZzi6 = zzfpVar.zzi();
        zzfpVar.zzL(8);
        return new zzaep(iZzi, iZzi2, iZzi3, iZzi4, iZzi5, iZzi6);
    }

    @Override // com.google.android.gms.internal.ads.zzaej
    public final int zza() {
        return 1752331379;
    }
}
