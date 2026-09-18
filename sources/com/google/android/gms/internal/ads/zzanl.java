package com.google.android.gms.internal.ads;

import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzanl implements zzamy {
    private final String zza;
    private final zzfp zzb;
    private final zzfo zzc;
    private zzaea zzd;
    private String zze;
    private zzam zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private long zzk;
    private boolean zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private boolean zzp;
    private long zzq;
    private int zzr;
    private long zzs;
    private int zzt;
    private String zzu;

    public zzanl(String str) {
        this.zza = str;
        zzfp zzfpVar = new zzfp(1024);
        this.zzb = zzfpVar;
        byte[] bArrZzM = zzfpVar.zzM();
        this.zzc = new zzfo(bArrZzM, bArrZzM.length);
        this.zzk = -9223372036854775807L;
    }

    private final int zzf(zzfo zzfoVar) throws zzcc {
        int iZza = zzfoVar.zza();
        zzabr zzabrVarZzb = zzabs.zzb(zzfoVar, true);
        this.zzu = zzabrVarZzb.zzc;
        this.zzr = zzabrVarZzb.zza;
        this.zzt = zzabrVarZzb.zzb;
        return iZza - zzfoVar.zza();
    }

    private static long zzg(zzfo zzfoVar) {
        return zzfoVar.zzd((zzfoVar.zzd(2) + 1) * 8);
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zza(zzfp zzfpVar) throws zzcc {
        int i;
        int i2;
        int iZzd;
        boolean zZzo;
        zzek.zzb(this.zzd);
        while (zzfpVar.zzb() > 0) {
            int i3 = this.zzg;
            if (i3 != 0) {
                if (i3 == 1) {
                    int iZzm = zzfpVar.zzm();
                    if ((iZzm & 224) == 224) {
                        this.zzj = iZzm;
                        this.zzg = 2;
                    } else if (iZzm != 86) {
                        this.zzg = 0;
                    }
                } else if (i3 != 2) {
                    int iMin = Math.min(zzfpVar.zzb(), this.zzi - this.zzh);
                    zzfpVar.zzG(this.zzc.zza, this.zzh, iMin);
                    int i4 = this.zzh + iMin;
                    this.zzh = i4;
                    if (i4 == this.zzi) {
                        this.zzc.zzk(0);
                        zzfo zzfoVar = this.zzc;
                        if (zzfoVar.zzo()) {
                            if (this.zzl) {
                            }
                            this.zzg = 0;
                        } else {
                            this.zzl = true;
                            int iZzd2 = zzfoVar.zzd(1);
                            if (iZzd2 == 1) {
                                iZzd = zzfoVar.zzd(1);
                                i2 = 1;
                            } else {
                                i2 = iZzd2;
                                iZzd = 0;
                            }
                            this.zzm = iZzd;
                            if (iZzd != 0) {
                                throw zzcc.zza(null, null);
                            }
                            if (i2 == 1) {
                                zzg(zzfoVar);
                                i2 = 1;
                            }
                            if (!zzfoVar.zzo()) {
                                throw zzcc.zza(null, null);
                            }
                            this.zzn = zzfoVar.zzd(6);
                            int iZzd3 = zzfoVar.zzd(4);
                            int iZzd4 = zzfoVar.zzd(3);
                            if (iZzd3 != 0 || iZzd4 != 0) {
                                throw zzcc.zza(null, null);
                            }
                            if (i2 == 0) {
                                int iZzc = zzfoVar.zzc();
                                int iZzf = zzf(zzfoVar);
                                zzfoVar.zzk(iZzc);
                                byte[] bArr = new byte[(iZzf + 7) / 8];
                                zzfoVar.zzg(bArr, 0, iZzf);
                                zzak zzakVar = new zzak();
                                zzakVar.zzK(this.zze);
                                zzakVar.zzW("audio/mp4a-latm");
                                zzakVar.zzz(this.zzu);
                                zzakVar.zzy(this.zzt);
                                zzakVar.zzX(this.zzr);
                                zzakVar.zzL(Collections.singletonList(bArr));
                                zzakVar.zzN(this.zza);
                                zzam zzamVarZzac = zzakVar.zzac();
                                if (!zzamVarZzac.equals(this.zzf)) {
                                    this.zzf = zzamVarZzac;
                                    this.zzs = 1024000000 / ((long) zzamVarZzac.zzA);
                                    this.zzd.zzl(zzamVarZzac);
                                }
                            } else {
                                zzfoVar.zzm(((int) zzg(zzfoVar)) - zzf(zzfoVar));
                            }
                            int iZzd5 = zzfoVar.zzd(3);
                            this.zzo = iZzd5;
                            if (iZzd5 == 0) {
                                zzfoVar.zzm(8);
                            } else if (iZzd5 == 1) {
                                zzfoVar.zzm(9);
                            } else if (iZzd5 == 3 || iZzd5 == 4 || iZzd5 == 5) {
                                zzfoVar.zzm(6);
                            } else {
                                if (iZzd5 != 6 && iZzd5 != 7) {
                                    throw new IllegalStateException();
                                }
                                zzfoVar.zzm(1);
                            }
                            boolean zZzo2 = zzfoVar.zzo();
                            this.zzp = zZzo2;
                            this.zzq = 0L;
                            if (zZzo2) {
                                if (i2 != 1) {
                                    do {
                                        zZzo = zzfoVar.zzo();
                                        this.zzq = (this.zzq << 8) + ((long) zzfoVar.zzd(8));
                                    } while (zZzo);
                                } else {
                                    this.zzq = zzg(zzfoVar);
                                }
                            }
                            if (zzfoVar.zzo()) {
                                zzfoVar.zzm(8);
                            }
                        }
                        if (this.zzm != 0) {
                            throw zzcc.zza(null, null);
                        }
                        if (this.zzn != 0) {
                            throw zzcc.zza(null, null);
                        }
                        if (this.zzo != 0) {
                            throw zzcc.zza(null, null);
                        }
                        int i5 = 0;
                        while (true) {
                            int iZzd6 = zzfoVar.zzd(8);
                            i = i5 + iZzd6;
                            if (iZzd6 != 255) {
                                break;
                            } else {
                                i5 = i;
                            }
                        }
                        int iZzc2 = zzfoVar.zzc();
                        if ((iZzc2 & 7) == 0) {
                            this.zzb.zzK(iZzc2 >> 3);
                        } else {
                            zzfoVar.zzg(this.zzb.zzM(), 0, i * 8);
                            this.zzb.zzK(0);
                        }
                        this.zzd.zzr(this.zzb, i);
                        zzek.zzf(this.zzk != -9223372036854775807L);
                        this.zzd.zzt(this.zzk, 1, i, 0, null);
                        this.zzk += this.zzs;
                        if (this.zzp) {
                            zzfoVar.zzm((int) this.zzq);
                        }
                        this.zzg = 0;
                    } else {
                        continue;
                    }
                } else {
                    int iZzm2 = ((this.zzj & (-225)) << 8) | zzfpVar.zzm();
                    this.zzi = iZzm2;
                    zzfp zzfpVar2 = this.zzb;
                    if (iZzm2 > zzfpVar2.zzM().length) {
                        zzfpVar2.zzH(iZzm2);
                        zzfo zzfoVar2 = this.zzc;
                        byte[] bArrZzM = this.zzb.zzM();
                        zzfoVar2.zzj(bArrZzM, bArrZzM.length);
                    }
                    this.zzh = 0;
                    this.zzg = 3;
                }
            } else if (zzfpVar.zzm() == 86) {
                this.zzg = 1;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzb(zzacx zzacxVar, zzaok zzaokVar) {
        zzaokVar.zzc();
        this.zzd = zzacxVar.zzw(zzaokVar.zza(), 1);
        this.zze = zzaokVar.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzc(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzd(long j, int i) {
        this.zzk = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zze() {
        this.zzg = 0;
        this.zzk = -9223372036854775807L;
        this.zzl = false;
    }
}
