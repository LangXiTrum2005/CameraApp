package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzait implements zzair {
    private final int zza;
    private final int zzb;
    private final zzfp zzc;

    public zzait(zzain zzainVar, zzam zzamVar) {
        zzfp zzfpVar = zzainVar.zza;
        this.zzc = zzfpVar;
        zzfpVar.zzK(12);
        int iZzp = zzfpVar.zzp();
        if ("audio/raw".equals(zzamVar.zzm)) {
            int iZzl = zzfy.zzl(zzamVar.zzB, zzamVar.zzz);
            if (iZzp == 0 || iZzp % iZzl != 0) {
                zzff.zzf("AtomParsers", "Audio sample size mismatch. stsd sample size: " + iZzl + ", stsz sample size: " + iZzp);
                iZzp = iZzl;
            }
        }
        this.zza = iZzp == 0 ? -1 : iZzp;
        this.zzb = zzfpVar.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzair
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzair
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzair
    public final int zzc() {
        int i = this.zza;
        return i == -1 ? this.zzc.zzp() : i;
    }
}
