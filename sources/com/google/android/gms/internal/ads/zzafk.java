package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzafk implements zzacu {
    private zzacx zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private zzahe zzg;
    private zzacv zzh;
    private zzafn zzi;
    private zzajh zzj;
    private final zzfp zza = new zzfp(6);
    private long zzf = -1;

    private final int zza(zzacv zzacvVar) throws IOException {
        this.zza.zzH(2);
        ((zzack) zzacvVar).zzm(this.zza.zzM(), 0, 2, false);
        return this.zza.zzq();
    }

    private final void zzf() {
        zzg(new zzbx[0]);
        zzacx zzacxVar = this.zzb;
        zzacxVar.getClass();
        zzacxVar.zzD();
        this.zzb.zzO(new zzadt(-9223372036854775807L, 0L));
        this.zzc = 6;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00e8  */
    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        int i;
        String strZzx;
        zzafm zzafmVarZza;
        zzahe zzaheVar;
        long j;
        int i2 = this.zzc;
        if (i2 == 0) {
            this.zza.zzH(2);
            ((zzack) zzacvVar).zzn(this.zza.zzM(), 0, 2, false);
            int iZzq = this.zza.zzq();
            this.zzd = iZzq;
            if (iZzq == 65498) {
                if (this.zzf != -1) {
                    this.zzc = 4;
                    return 0;
                }
                zzf();
                return 0;
            }
            if ((iZzq >= 65488 && iZzq <= 65497) || iZzq == 65281) {
                return 0;
            }
            this.zzc = 1;
            return 0;
        }
        if (i2 == 1) {
            this.zza.zzH(2);
            ((zzack) zzacvVar).zzn(this.zza.zzM(), 0, 2, false);
            this.zze = this.zza.zzq() - 2;
            this.zzc = 2;
            return 0;
        }
        if (i2 != 2) {
            if (i2 != 4) {
                if (i2 != 5) {
                    if (i2 == 6) {
                        return -1;
                    }
                    throw new IllegalStateException();
                }
                if (this.zzi == null || zzacvVar != this.zzh) {
                    this.zzh = zzacvVar;
                    this.zzi = new zzafn(zzacvVar, this.zzf);
                }
                zzajh zzajhVar = this.zzj;
                zzajhVar.getClass();
                int iZzb = zzajhVar.zzb(this.zzi, zzadrVar);
                if (iZzb == 1) {
                    zzadrVar.zza += this.zzf;
                }
                return iZzb;
            }
            long jZzf = zzacvVar.zzf();
            long j2 = this.zzf;
            if (jZzf != j2) {
                zzadrVar.zza = j2;
                return 1;
            }
            if (zzacvVar.zzm(this.zza.zzM(), 0, 1, true)) {
                zzacvVar.zzj();
                if (this.zzj == null) {
                    this.zzj = new zzajh(zzakp.zza, 8);
                }
                zzafn zzafnVar = new zzafn(zzacvVar, this.zzf);
                this.zzi = zzafnVar;
                if (this.zzj.zze(zzafnVar)) {
                    zzajh zzajhVar2 = this.zzj;
                    long j3 = this.zzf;
                    zzacx zzacxVar = this.zzb;
                    zzacxVar.getClass();
                    zzajhVar2.zzc(new zzafp(j3, zzacxVar));
                    zzahe zzaheVar2 = this.zzg;
                    zzaheVar2.getClass();
                    zzg(zzaheVar2);
                    this.zzc = 5;
                } else {
                    zzf();
                }
            } else {
                zzf();
            }
            return 0;
        }
        if (this.zzd == 65505) {
            zzfp zzfpVar = new zzfp(this.zze);
            ((zzack) zzacvVar).zzn(zzfpVar.zzM(), 0, this.zze, false);
            if (this.zzg == null && "http://ns.adobe.com/xap/1.0/".equals(zzfpVar.zzx((char) 0)) && (strZzx = zzfpVar.zzx((char) 0)) != null) {
                long jZzd = zzacvVar.zzd();
                if (jZzd == -1 || (zzafmVarZza = zzafq.zza(strZzx)) == null || zzafmVarZza.zzb.size() < 2) {
                    zzaheVar = null;
                } else {
                    long j4 = -1;
                    long j5 = -1;
                    long j6 = -1;
                    long j7 = -1;
                    boolean zEquals = false;
                    for (int size = zzafmVarZza.zzb.size() - 1; size >= 0; size--) {
                        zzafl zzaflVar = (zzafl) zzafmVarZza.zzb.get(size);
                        zEquals |= "video/mp4".equals(zzaflVar.zza);
                        if (size == 0) {
                            jZzd -= zzaflVar.zzd;
                            j = 0;
                        } else {
                            j = jZzd - zzaflVar.zzc;
                        }
                        long j8 = jZzd;
                        jZzd = j;
                        if (zEquals && jZzd != j8) {
                            j7 = j8 - jZzd;
                            j6 = jZzd;
                            zEquals = false;
                        }
                        if (size == 0) {
                            j5 = j8;
                        }
                        if (size == 0) {
                            j4 = jZzd;
                        }
                    }
                    if (j6 == -1 || j7 == -1 || j4 == -1 || j5 == -1) {
                        zzaheVar = null;
                    } else {
                        zzaheVar = new zzahe(j4, j5, zzafmVarZza.zza, j6, j7);
                    }
                }
                this.zzg = zzaheVar;
                if (zzaheVar != null) {
                    this.zzf = zzaheVar.zzd;
                }
                i = 0;
            } else {
                i = 0;
            }
        } else {
            i = 0;
            ((zzack) zzacvVar).zzo(this.zze, false);
        }
        this.zzc = i;
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        this.zzb = zzacxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        if (zza(zzacvVar) != 65496) {
            return false;
        }
        int iZza = zza(zzacvVar);
        this.zzd = iZza;
        if (iZza == 65504) {
            this.zza.zzH(2);
            zzack zzackVar = (zzack) zzacvVar;
            zzackVar.zzm(this.zza.zzM(), 0, 2, false);
            zzackVar.zzl(this.zza.zzq() - 2, false);
            iZza = zza(zzacvVar);
            this.zzd = iZza;
        }
        if (iZza == 65505) {
            zzack zzackVar2 = (zzack) zzacvVar;
            zzackVar2.zzl(2, false);
            this.zza.zzH(6);
            zzackVar2.zzm(this.zza.zzM(), 0, 6, false);
            if (this.zza.zzu() == 1165519206 && this.zza.zzq() == 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j, long j2) {
        if (j == 0) {
            this.zzc = 0;
            this.zzj = null;
        } else if (this.zzc == 5) {
            zzajh zzajhVar = this.zzj;
            zzajhVar.getClass();
            zzajhVar.zzd(j, j2);
        }
    }

    private final void zzg(zzbx... zzbxVarArr) {
        zzacx zzacxVar = this.zzb;
        zzacxVar.getClass();
        zzaea zzaeaVarZzw = zzacxVar.zzw(1024, 4);
        zzak zzakVar = new zzak();
        zzakVar.zzB("image/jpeg");
        zzakVar.zzP(new zzby(-9223372036854775807L, zzbxVarArr));
        zzaeaVarZzw.zzl(zzakVar.zzac());
    }
}
