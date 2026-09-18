package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzajs implements zzajz {
    private final zzajy zza;
    private final long zzb;
    private final long zzc;
    private final zzake zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;

    public zzajs(zzake zzakeVar, long j, long j2, long j3, long j4, boolean z) {
        zzek.zzd(j >= 0 && j2 > j);
        this.zzd = zzakeVar;
        this.zzb = j;
        this.zzc = j2;
        if (j3 == j2 - j || z) {
            this.zzf = j4;
            this.zze = 4;
        } else {
            this.zze = 0;
        }
        this.zza = new zzajy();
    }

    @Override // com.google.android.gms.internal.ads.zzajz
    public final /* bridge */ /* synthetic */ zzadu zze() {
        zzajq zzajqVar = null;
        if (this.zzf != 0) {
            return new zzajr(this, zzajqVar);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzajz
    public final void zzg(long j) {
        this.zzh = Math.max(0L, Math.min(j, this.zzf - 1));
        this.zze = 2;
        this.zzi = this.zzb;
        this.zzj = this.zzc;
        this.zzk = 0L;
        this.zzl = this.zzf;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001d  */
    @Override // com.google.android.gms.internal.ads.zzajz
    public final long zzd(zzacv zzacvVar) throws IOException {
        long jMax;
        int i = this.zze;
        if (i == 0) {
            long jZzf = zzacvVar.zzf();
            this.zzg = jZzf;
            this.zze = 1;
            long j = this.zzc - 65307;
            if (j > jZzf) {
                return j;
            }
        } else if (i != 1) {
            if (i == 2) {
                long j2 = this.zzi;
                long j3 = this.zzj;
                if (j2 == j3) {
                    jMax = -1;
                } else {
                    long jZzf2 = zzacvVar.zzf();
                    if (this.zza.zzc(zzacvVar, j3)) {
                        this.zza.zzb(zzacvVar, false);
                        zzacvVar.zzj();
                        long j4 = this.zzh;
                        zzajy zzajyVar = this.zza;
                        long j5 = zzajyVar.zzb;
                        long j6 = j4 - j5;
                        int i2 = zzajyVar.zzd + zzajyVar.zze;
                        if (j6 < 0 || j6 >= 72000) {
                            if (j6 < 0) {
                                this.zzj = jZzf2;
                                this.zzl = j5;
                            } else {
                                this.zzi = zzacvVar.zzf() + ((long) i2);
                                this.zzk = j5;
                            }
                            long j7 = this.zzj;
                            long j8 = this.zzi;
                            long j9 = j7 - j8;
                            if (j9 < 100000) {
                                this.zzj = j8;
                                jMax = j8;
                            } else {
                                jMax = Math.max(j8, Math.min((zzacvVar.zzf() - (((long) i2) * (j6 <= 0 ? 2L : 1L))) + ((j6 * j9) / (this.zzl - this.zzk)), j7 - 1));
                            }
                        } else {
                            jMax = -1;
                        }
                    } else {
                        jMax = this.zzi;
                        if (jMax == jZzf2) {
                            throw new IOException("No ogg page can be found.");
                        }
                    }
                }
                if (jMax != -1) {
                    return jMax;
                }
                this.zze = 3;
            } else if (i != 3) {
                return -1L;
            }
            while (true) {
                this.zza.zzc(zzacvVar, -1L);
                this.zza.zzb(zzacvVar, false);
                zzajy zzajyVar2 = this.zza;
                if (zzajyVar2.zzb > this.zzh) {
                    zzacvVar.zzj();
                    this.zze = 4;
                    return -(this.zzk + 2);
                }
                ((zzack) zzacvVar).zzo(zzajyVar2.zzd + zzajyVar2.zze, false);
                this.zzi = zzacvVar.zzf();
                this.zzk = this.zza.zzb;
            }
        }
        this.zza.zza();
        if (!this.zza.zzc(zzacvVar, -1L)) {
            throw new EOFException();
        }
        this.zza.zzb(zzacvVar, false);
        zzajy zzajyVar3 = this.zza;
        ((zzack) zzacvVar).zzo(zzajyVar3.zzd + zzajyVar3.zze, false);
        long j10 = this.zza.zzb;
        while (true) {
            zzajy zzajyVar4 = this.zza;
            if ((zzajyVar4.zza & 4) == 4 || !zzajyVar4.zzc(zzacvVar, -1L) || zzacvVar.zzf() >= this.zzc || !this.zza.zzb(zzacvVar, true)) {
                break;
            }
            zzajy zzajyVar5 = this.zza;
            if (!zzacy.zze(zzacvVar, zzajyVar5.zzd + zzajyVar5.zze)) {
                break;
            }
            j10 = this.zza.zzb;
        }
        this.zzf = j10;
        this.zze = 4;
        return this.zzg;
    }
}
