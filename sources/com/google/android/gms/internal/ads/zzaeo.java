package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaeo implements zzaej {
    public final int zza;
    public final int zzb;
    public final int zzc;

    private zzaeo(int i, int i2, int i3, int i4) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    public static zzaeo zzb(zzfp zzfpVar) {
        int iZzi = zzfpVar.zzi();
        zzfpVar.zzL(8);
        int iZzi2 = zzfpVar.zzi();
        int iZzi3 = zzfpVar.zzi();
        zzfpVar.zzL(4);
        int iZzi4 = zzfpVar.zzi();
        zzfpVar.zzL(12);
        return new zzaeo(iZzi, iZzi2, iZzi3, iZzi4);
    }

    @Override // com.google.android.gms.internal.ads.zzaej
    public final int zza() {
        return 1751742049;
    }
}
