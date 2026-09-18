package com.google.android.gms.internal.ads;

import com.google.common.primitives.SignedBytes;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzamr implements zzamy {
    private final zzfo zza;
    private final zzfp zzb;
    private final String zzc;
    private String zzd;
    private zzaea zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private long zzi;
    private zzam zzj;
    private int zzk;
    private long zzl;

    public zzamr() {
        this(null);
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zza(zzfp zzfpVar) {
        zzek.zzb(this.zze);
        while (zzfpVar.zzb() > 0) {
            int i = this.zzf;
            if (i == 0) {
                while (true) {
                    if (zzfpVar.zzb() > 0) {
                        if (this.zzh) {
                            int iZzm = zzfpVar.zzm();
                            this.zzh = iZzm == 172;
                            byte b = SignedBytes.MAX_POWER_OF_TWO;
                            if (iZzm != 64) {
                                if (iZzm == 65) {
                                    iZzm = 65;
                                }
                            }
                            this.zzf = 1;
                            zzfp zzfpVar2 = this.zzb;
                            zzfpVar2.zzM()[0] = -84;
                            if (iZzm == 65) {
                                b = 65;
                            }
                            zzfpVar2.zzM()[1] = b;
                            this.zzg = 2;
                        } else {
                            this.zzh = zzfpVar.zzm() == 172;
                        }
                    }
                }
            } else if (i != 1) {
                int iMin = Math.min(zzfpVar.zzb(), this.zzk - this.zzg);
                this.zze.zzr(zzfpVar, iMin);
                int i2 = this.zzg + iMin;
                this.zzg = i2;
                if (i2 == this.zzk) {
                    zzek.zzf(this.zzl != -9223372036854775807L);
                    this.zze.zzt(this.zzl, 1, this.zzk, 0, null);
                    this.zzl += this.zzi;
                    this.zzf = 0;
                }
            } else {
                byte[] bArrZzM = this.zzb.zzM();
                int iMin2 = Math.min(zzfpVar.zzb(), 16 - this.zzg);
                zzfpVar.zzG(bArrZzM, this.zzg, iMin2);
                int i3 = this.zzg + iMin2;
                this.zzg = i3;
                if (i3 == 16) {
                    this.zza.zzk(0);
                    zzabx zzabxVarZza = zzaby.zza(this.zza);
                    zzam zzamVar = this.zzj;
                    if (zzamVar == null || zzamVar.zzz != 2 || zzabxVarZza.zza != zzamVar.zzA || !"audio/ac4".equals(zzamVar.zzm)) {
                        zzak zzakVar = new zzak();
                        zzakVar.zzK(this.zzd);
                        zzakVar.zzW("audio/ac4");
                        zzakVar.zzy(2);
                        zzakVar.zzX(zzabxVarZza.zza);
                        zzakVar.zzN(this.zzc);
                        zzam zzamVarZzac = zzakVar.zzac();
                        this.zzj = zzamVarZzac;
                        this.zze.zzl(zzamVarZzac);
                    }
                    this.zzk = zzabxVarZza.zzb;
                    this.zzi = (((long) zzabxVarZza.zzc) * 1000000) / ((long) this.zzj.zzA);
                    this.zzb.zzK(0);
                    this.zze.zzr(this.zzb, 16);
                    this.zzf = 2;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzb(zzacx zzacxVar, zzaok zzaokVar) {
        zzaokVar.zzc();
        this.zzd = zzaokVar.zzb();
        this.zze = zzacxVar.zzw(zzaokVar.zza(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzc(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzd(long j, int i) {
        this.zzl = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zze() {
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = false;
        this.zzl = -9223372036854775807L;
    }

    public zzamr(String str) {
        zzfo zzfoVar = new zzfo(new byte[16], 16);
        this.zza = zzfoVar;
        this.zzb = new zzfp(zzfoVar.zza);
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = false;
        this.zzl = -9223372036854775807L;
        this.zzc = str;
    }
}
