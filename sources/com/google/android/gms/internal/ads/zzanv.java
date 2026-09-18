package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzanv {
    private final zzamy zza;
    private final zzfw zzb;
    private final zzfo zzc = new zzfo(new byte[64], 64);
    private boolean zzd;
    private boolean zze;
    private boolean zzf;

    public zzanv(zzamy zzamyVar, zzfw zzfwVar) {
        this.zza = zzamyVar;
        this.zzb = zzfwVar;
    }

    public final void zza(zzfp zzfpVar) throws zzcc {
        long jZzb;
        zzfpVar.zzG(this.zzc.zza, 0, 3);
        this.zzc.zzk(0);
        this.zzc.zzm(8);
        this.zzd = this.zzc.zzo();
        this.zze = this.zzc.zzo();
        this.zzc.zzm(6);
        zzfo zzfoVar = this.zzc;
        zzfpVar.zzG(zzfoVar.zza, 0, zzfoVar.zzd(8));
        this.zzc.zzk(0);
        if (this.zzd) {
            this.zzc.zzm(4);
            long jZzd = this.zzc.zzd(3);
            this.zzc.zzm(1);
            int iZzd = this.zzc.zzd(15) << 15;
            this.zzc.zzm(1);
            long jZzd2 = this.zzc.zzd(15);
            this.zzc.zzm(1);
            if (!this.zzf && this.zze) {
                this.zzc.zzm(4);
                long jZzd3 = ((long) this.zzc.zzd(3)) << 30;
                this.zzc.zzm(1);
                int iZzd2 = this.zzc.zzd(15) << 15;
                this.zzc.zzm(1);
                long jZzd4 = this.zzc.zzd(15);
                this.zzc.zzm(1);
                this.zzb.zzb(((long) iZzd2) | jZzd3 | jZzd4);
                this.zzf = true;
            }
            jZzb = this.zzb.zzb((jZzd << 30) | ((long) iZzd) | jZzd2);
        } else {
            jZzb = 0;
        }
        this.zza.zzd(jZzb, 4);
        this.zza.zza(zzfpVar);
        this.zza.zzc(false);
    }

    public final void zzb() {
        this.zzf = false;
        this.zza.zze();
    }
}
