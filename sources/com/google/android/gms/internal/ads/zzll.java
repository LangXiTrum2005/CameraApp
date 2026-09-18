package com.google.android.gms.internal.ads;

import android.util.Pair;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzll {
    private final zzcu zza = new zzcu();
    private final zzcw zzb = new zzcw();
    private final zzmp zzc;
    private final zzew zzd;
    private long zze;
    private int zzf;
    private boolean zzg;
    private zzli zzh;
    private zzli zzi;
    private zzli zzj;
    private int zzk;
    private Object zzl;
    private long zzm;
    private final zzkr zzn;

    public zzll(zzmp zzmpVar, zzew zzewVar, zzkr zzkrVar) {
        this.zzc = zzmpVar;
        this.zzd = zzewVar;
        this.zzn = zzkrVar;
    }

    private final boolean zzA(zzcx zzcxVar, zzur zzurVar) {
        if (zzC(zzurVar)) {
            return zzcxVar.zze(zzcxVar.zzn(zzurVar.zza, this.zza).zzd, this.zzb, 0L).zzq == zzcxVar.zza(zzurVar.zza);
        }
        return false;
    }

    private final boolean zzB(zzcx zzcxVar) {
        zzli zzliVarZzg = this.zzh;
        if (zzliVarZzg == null) {
            return true;
        }
        int iZza = zzcxVar.zza(zzliVarZzg.zzb);
        while (true) {
            iZza = zzcxVar.zzi(iZza, this.zza, this.zzb, this.zzf, this.zzg);
            while (true) {
                zzliVarZzg.getClass();
                if (zzliVarZzg.zzg() == null || zzliVarZzg.zzf.zzg) {
                    break;
                }
                zzliVarZzg = zzliVarZzg.zzg();
            }
            zzli zzliVarZzg2 = zzliVarZzg.zzg();
            if (iZza == -1 || zzliVarZzg2 == null || zzcxVar.zza(zzliVarZzg2.zzb) != iZza) {
                break;
            }
            zzliVarZzg = zzliVarZzg2;
        }
        boolean zZzn = zzn(zzliVarZzg);
        zzliVarZzg.zzf = zzh(zzcxVar, zzliVarZzg.zzf);
        return !zZzn;
    }

    private static final boolean zzC(zzur zzurVar) {
        return !zzurVar.zzb() && zzurVar.zze == -1;
    }

    private final long zzs(zzcx zzcxVar, Object obj, int i) {
        zzcxVar.zzn(obj, this.zza);
        this.zza.zzi(i);
        this.zza.zzk(i);
        return 0L;
    }

    private final zzlj zzt(zzcx zzcxVar, zzli zzliVar, long j) {
        long j2;
        zzlj zzljVar = zzliVar.zzf;
        long jZze = (zzliVar.zze() + zzljVar.zze) - j;
        if (zzljVar.zzg) {
            long j3 = 0;
            int iZzi = zzcxVar.zzi(zzcxVar.zza(zzljVar.zza.zza), this.zza, this.zzb, this.zzf, this.zzg);
            if (iZzi != -1) {
                int i = zzcxVar.zzd(iZzi, this.zza, true).zzd;
                Object obj = this.zza.zzc;
                obj.getClass();
                long j4 = zzljVar.zza.zzd;
                if (zzcxVar.zze(i, this.zzb, 0L).zzp == iZzi) {
                    Pair pairZzm = zzcxVar.zzm(this.zzb, this.zza, i, -9223372036854775807L, Math.max(0L, jZze));
                    if (pairZzm != null) {
                        obj = pairZzm.first;
                        long jLongValue = ((Long) pairZzm.second).longValue();
                        zzli zzliVarZzg = zzliVar.zzg();
                        if (zzliVarZzg == null || !zzliVarZzg.zzb.equals(obj)) {
                            j4 = this.zze;
                            this.zze = 1 + j4;
                        } else {
                            j4 = zzliVarZzg.zzf.zza.zzd;
                        }
                        j2 = jLongValue;
                        j3 = -9223372036854775807L;
                    }
                } else {
                    j2 = 0;
                }
                zzur zzurVarZzx = zzx(zzcxVar, obj, j2, j4, this.zzb, this.zza);
                if (j3 != -9223372036854775807L && zzljVar.zzc != -9223372036854775807L) {
                    zzcxVar.zzn(zzljVar.zza.zza, this.zza).zzb();
                    this.zza.zzg();
                }
                return zzu(zzcxVar, zzurVarZzx, j3, j2);
            }
        } else {
            zzur zzurVar = zzljVar.zza;
            zzcxVar.zzn(zzurVar.zza, this.zza);
            if (!zzurVar.zzb()) {
                int i2 = zzurVar.zze;
                if (i2 != -1) {
                    this.zza.zzm(i2);
                }
                zzcu zzcuVar = this.zza;
                int i3 = zzurVar.zze;
                int iZze = zzcuVar.zze(i3);
                zzcuVar.zzn(i3);
                if (iZze != this.zza.zza(zzurVar.zze)) {
                    return zzv(zzcxVar, zzurVar.zza, zzurVar.zze, iZze, zzljVar.zze, zzurVar.zzd);
                }
                zzs(zzcxVar, zzurVar.zza, zzurVar.zze);
                return zzw(zzcxVar, zzurVar.zza, 0L, zzljVar.zze, zzurVar.zzd);
            }
            int i4 = zzurVar.zzb;
            if (this.zza.zza(i4) != -1) {
                int iZzf = this.zza.zzf(i4, zzurVar.zzc);
                if (iZzf < 0) {
                    return zzv(zzcxVar, zzurVar.zza, i4, iZzf, zzljVar.zzc, zzurVar.zzd);
                }
                long jLongValue2 = zzljVar.zzc;
                if (jLongValue2 == -9223372036854775807L) {
                    zzcw zzcwVar = this.zzb;
                    zzcu zzcuVar2 = this.zza;
                    Pair pairZzm2 = zzcxVar.zzm(zzcwVar, zzcuVar2, zzcuVar2.zzd, -9223372036854775807L, Math.max(0L, jZze));
                    if (pairZzm2 != null) {
                        jLongValue2 = ((Long) pairZzm2.second).longValue();
                    }
                }
                zzs(zzcxVar, zzurVar.zza, zzurVar.zzb);
                return zzw(zzcxVar, zzurVar.zza, Math.max(0L, jLongValue2), zzljVar.zzc, zzurVar.zzd);
            }
        }
        return null;
    }

    private final zzlj zzu(zzcx zzcxVar, zzur zzurVar, long j, long j2) {
        zzcxVar.zzn(zzurVar.zza, this.zza);
        return zzurVar.zzb() ? zzv(zzcxVar, zzurVar.zza, zzurVar.zzb, zzurVar.zzc, j, zzurVar.zzd) : zzw(zzcxVar, zzurVar.zza, j2, j, zzurVar.zzd);
    }

    private final zzlj zzv(zzcx zzcxVar, Object obj, int i, int i2, long j, long j2) {
        zzur zzurVar = new zzur(obj, i, i2, j2);
        long jZzh = zzcxVar.zzn(zzurVar.zza, this.zza).zzh(zzurVar.zzb, zzurVar.zzc);
        if (i2 == this.zza.zze(i)) {
            this.zza.zzj();
        }
        this.zza.zzn(zzurVar.zzb);
        return new zzlj(zzurVar, (jZzh == -9223372036854775807L || jZzh > 0) ? 0L : Math.max(0L, (-1) + jZzh), j, -9223372036854775807L, jZzh, false, false, false, false);
    }

    private final zzlj zzw(zzcx zzcxVar, Object obj, long j, long j2, long j3) {
        long j4;
        long j5;
        long j6;
        long jMax = j;
        zzcxVar.zzn(obj, this.zza);
        int iZzc = this.zza.zzc(jMax);
        if (iZzc != -1) {
            this.zza.zzm(iZzc);
        }
        if (iZzc == -1) {
            this.zza.zzb();
        } else {
            this.zza.zzn(iZzc);
        }
        zzur zzurVar = new zzur(obj, j3, iZzc);
        boolean zZzC = zzC(zzurVar);
        boolean zZzA = zzA(zzcxVar, zzurVar);
        boolean zZzz = zzz(zzcxVar, zzurVar, zZzC);
        if (iZzc != -1) {
            this.zza.zzn(iZzc);
        }
        if (iZzc != -1) {
            this.zza.zzi(iZzc);
            j4 = 0;
        } else {
            j4 = -9223372036854775807L;
        }
        if (j4 != -9223372036854775807L) {
            j5 = 0;
            j6 = 0;
        } else {
            j5 = j4;
            j6 = this.zza.zze;
        }
        if (j6 != -9223372036854775807L && jMax >= j6) {
            jMax = Math.max(0L, j6 - 1);
        }
        return new zzlj(zzurVar, jMax, j2, j5, j6, false, zZzC, zZzA, zZzz);
    }

    private static zzur zzx(zzcx zzcxVar, Object obj, long j, long j2, zzcw zzcwVar, zzcu zzcuVar) {
        zzcxVar.zzn(obj, zzcuVar);
        zzcxVar.zze(zzcuVar.zzd, zzcwVar, 0L);
        zzcxVar.zza(obj);
        zzcuVar.zzb();
        zzcxVar.zzn(obj, zzcuVar);
        int iZzd = zzcuVar.zzd(j);
        return iZzd == -1 ? new zzur(obj, j2, zzcuVar.zzc(j)) : new zzur(obj, iZzd, zzcuVar.zze(iZzd), j2);
    }

    private final void zzy() {
        final zzfzx zzfzxVar = new zzfzx();
        for (zzli zzliVarZzg = this.zzh; zzliVarZzg != null; zzliVarZzg = zzliVarZzg.zzg()) {
            zzfzxVar.zzf(zzliVarZzg.zzf.zza);
        }
        zzli zzliVar = this.zzi;
        final zzur zzurVar = zzliVar == null ? null : zzliVar.zzf.zza;
        this.zzd.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlk
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzk(zzfzxVar, zzurVar);
            }
        });
    }

    private final boolean zzz(zzcx zzcxVar, zzur zzurVar, boolean z) {
        int iZza = zzcxVar.zza(zzurVar.zza);
        return !zzcxVar.zze(zzcxVar.zzd(iZza, this.zza, false).zzd, this.zzb, 0L).zzj && zzcxVar.zzi(iZza, this.zza, this.zzb, this.zzf, this.zzg) == -1 && z;
    }

    public final zzli zza() {
        zzli zzliVar = this.zzh;
        if (zzliVar == null) {
            return null;
        }
        if (zzliVar == this.zzi) {
            this.zzi = zzliVar.zzg();
        }
        zzliVar.zzn();
        int i = this.zzk - 1;
        this.zzk = i;
        if (i == 0) {
            this.zzj = null;
            zzli zzliVar2 = this.zzh;
            this.zzl = zzliVar2.zzb;
            this.zzm = zzliVar2.zzf.zza.zzd;
        }
        this.zzh = this.zzh.zzg();
        zzy();
        return this.zzh;
    }

    public final zzli zzb() {
        zzli zzliVar = this.zzi;
        zzek.zzb(zzliVar);
        this.zzi = zzliVar.zzg();
        zzy();
        zzli zzliVar2 = this.zzi;
        zzek.zzb(zzliVar2);
        return zzliVar2;
    }

    public final zzli zzd() {
        return this.zzj;
    }

    public final zzli zze() {
        return this.zzh;
    }

    public final zzli zzf() {
        return this.zzi;
    }

    public final zzlj zzg(long j, zzly zzlyVar) {
        zzli zzliVar = this.zzj;
        return zzliVar == null ? zzu(zzlyVar.zza, zzlyVar.zzb, zzlyVar.zzc, zzlyVar.zzr) : zzt(zzlyVar.zza, zzliVar, j);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005d  */
    /* JADX WARN: Code duplicated, block: B:20:0x0065  */
    /* JADX WARN: Code duplicated, block: B:22:0x0069  */
    public final zzlj zzh(zzcx zzcxVar, zzlj zzljVar) {
        long j;
        long jZzh;
        long j2;
        long j3;
        int i;
        int i2;
        zzur zzurVar = zzljVar.zza;
        boolean zZzC = zzC(zzurVar);
        boolean zZzA = zzA(zzcxVar, zzurVar);
        boolean zZzz = zzz(zzcxVar, zzurVar, zZzC);
        zzcxVar.zzn(zzljVar.zza.zza, this.zza);
        if (zzurVar.zzb() || (i2 = zzurVar.zze) == -1) {
            j = -9223372036854775807L;
        } else {
            this.zza.zzi(i2);
            j = 0;
        }
        if (!zzurVar.zzb()) {
            if (j != -9223372036854775807L) {
                j2 = 0;
                j3 = 0;
            } else {
                jZzh = this.zza.zze;
            }
            if (zzurVar.zzb()) {
                this.zza.zzn(zzurVar.zzb);
            } else {
                i = zzurVar.zze;
                if (i != -1) {
                    this.zza.zzn(i);
                }
            }
            return new zzlj(zzurVar, zzljVar.zzb, zzljVar.zzc, j2, j3, false, zZzC, zZzA, zZzz);
        }
        jZzh = this.zza.zzh(zzurVar.zzb, zzurVar.zzc);
        j2 = j;
        j3 = jZzh;
        if (zzurVar.zzb()) {
            this.zza.zzn(zzurVar.zzb);
        } else {
            i = zzurVar.zze;
            if (i != -1) {
                this.zza.zzn(i);
            }
        }
        return new zzlj(zzurVar, zzljVar.zzb, zzljVar.zzc, j2, j3, false, zZzC, zZzA, zZzz);
    }

    public final zzur zzi(zzcx zzcxVar, Object obj, long j) {
        long j2;
        int iZza;
        int i = zzcxVar.zzn(obj, this.zza).zzd;
        Object obj2 = this.zzl;
        if (obj2 == null || (iZza = zzcxVar.zza(obj2)) == -1 || zzcxVar.zzd(iZza, this.zza, false).zzd != i) {
            zzli zzliVarZzg = this.zzh;
            while (true) {
                if (zzliVarZzg == null) {
                    zzli zzliVarZzg2 = this.zzh;
                    while (true) {
                        if (zzliVarZzg2 != null) {
                            int iZza2 = zzcxVar.zza(zzliVarZzg2.zzb);
                            if (iZza2 != -1 && zzcxVar.zzd(iZza2, this.zza, false).zzd == i) {
                                j2 = zzliVarZzg2.zzf.zza.zzd;
                                break;
                            }
                            zzliVarZzg2 = zzliVarZzg2.zzg();
                        } else {
                            j2 = this.zze;
                            this.zze = 1 + j2;
                            if (this.zzh != null) {
                                break;
                            }
                            this.zzl = obj;
                            this.zzm = j2;
                            break;
                        }
                    }
                } else {
                    if (zzliVarZzg.zzb.equals(obj)) {
                        j2 = zzliVarZzg.zzf.zza.zzd;
                        break;
                    }
                    zzliVarZzg = zzliVarZzg.zzg();
                }
            }
        } else {
            j2 = this.zzm;
        }
        long j3 = j2;
        zzcxVar.zzn(obj, this.zza);
        zzcxVar.zze(this.zza.zzd, this.zzb, 0L);
        int iZza3 = zzcxVar.zza(obj);
        Object obj3 = obj;
        while (true) {
            zzcw zzcwVar = this.zzb;
            if (iZza3 < zzcwVar.zzp) {
                return zzx(zzcxVar, obj3, j, j3, zzcwVar, this.zza);
            }
            zzcxVar.zzd(iZza3, this.zza, true);
            this.zza.zzb();
            zzcu zzcuVar = this.zza;
            if (zzcuVar.zzd(zzcuVar.zze) != -1) {
                obj3 = this.zza.zzc;
                obj3.getClass();
            }
            iZza3--;
        }
    }

    public final void zzj() {
        if (this.zzk == 0) {
            return;
        }
        zzli zzliVarZzg = this.zzh;
        zzek.zzb(zzliVarZzg);
        this.zzl = zzliVarZzg.zzb;
        this.zzm = zzliVarZzg.zzf.zza.zzd;
        while (zzliVarZzg != null) {
            zzliVarZzg.zzn();
            zzliVarZzg = zzliVarZzg.zzg();
        }
        this.zzh = null;
        this.zzj = null;
        this.zzi = null;
        this.zzk = 0;
        zzy();
    }

    final /* synthetic */ void zzk(zzfzx zzfzxVar, zzur zzurVar) {
        this.zzc.zzS(zzfzxVar.zzi(), zzurVar);
    }

    public final void zzl(long j) {
        zzli zzliVar = this.zzj;
        if (zzliVar != null) {
            zzliVar.zzm(j);
        }
    }

    public final boolean zzm(zzup zzupVar) {
        zzli zzliVar = this.zzj;
        return zzliVar != null && zzliVar.zza == zzupVar;
    }

    public final boolean zzn(zzli zzliVar) {
        zzek.zzb(zzliVar);
        boolean z = false;
        if (zzliVar.equals(this.zzj)) {
            return false;
        }
        this.zzj = zzliVar;
        while (zzliVar.zzg() != null) {
            zzliVar = zzliVar.zzg();
            zzliVar.getClass();
            if (zzliVar == this.zzi) {
                this.zzi = this.zzh;
                z = true;
            }
            zzliVar.zzn();
            this.zzk--;
        }
        zzli zzliVar2 = this.zzj;
        zzliVar2.getClass();
        zzliVar2.zzo(null);
        zzy();
        return z;
    }

    public final boolean zzo() {
        zzli zzliVar = this.zzj;
        if (zzliVar == null) {
            return true;
        }
        if (zzliVar.zzf.zzi || !zzliVar.zzr() || this.zzj.zzf.zze == -9223372036854775807L) {
            return false;
        }
        return this.zzk < 100;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x007b  */
    public final boolean zzp(zzcx zzcxVar, long j, long j2) {
        zzlj zzljVarZzh;
        boolean z;
        zzli zzliVar = null;
        for (zzli zzliVarZzg = this.zzh; zzliVarZzg != null; zzliVarZzg = zzliVarZzg.zzg()) {
            zzlj zzljVar = zzliVarZzg.zzf;
            if (zzliVar == null) {
                zzljVarZzh = zzh(zzcxVar, zzljVar);
            } else {
                zzlj zzljVarZzt = zzt(zzcxVar, zzliVar, j);
                if (zzljVarZzt == null) {
                    return !zzn(zzliVar);
                }
                if (zzljVar.zzb != zzljVarZzt.zzb || !zzljVar.zza.equals(zzljVarZzt.zza)) {
                    return !zzn(zzliVar);
                }
                zzljVarZzh = zzljVarZzt;
            }
            zzliVarZzg.zzf = zzljVarZzh.zza(zzljVar.zzc);
            long j3 = zzljVar.zze;
            long j4 = zzljVarZzh.zze;
            if (j3 != -9223372036854775807L && j3 != j4) {
                zzliVarZzg.zzq();
                long j5 = zzljVarZzh.zze;
                long jZze = j5 == -9223372036854775807L ? Long.MAX_VALUE : j5 + zzliVarZzg.zze();
                if (zzliVarZzg == this.zzi) {
                    boolean z2 = zzliVarZzg.zzf.zzf;
                    if (j2 == Long.MIN_VALUE || j2 >= jZze) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                return (zzn(zzliVarZzg) || z) ? false : true;
            }
            zzliVar = zzliVarZzg;
        }
        return true;
    }

    public final boolean zzq(zzcx zzcxVar, int i) {
        this.zzf = i;
        return zzB(zzcxVar);
    }

    public final boolean zzr(zzcx zzcxVar, boolean z) {
        this.zzg = z;
        return zzB(zzcxVar);
    }

    public final zzli zzc(zzlj zzljVar) {
        zzli zzliVar = this.zzj;
        zzli zzliVarZzd = zzkz.zzd(this.zzn.zza, zzljVar, zzliVar == null ? 1000000000000L : (zzliVar.zze() + zzliVar.zzf.zze) - zzljVar.zzb);
        zzli zzliVar2 = this.zzj;
        if (zzliVar2 != null) {
            zzliVar2.zzo(zzliVarZzd);
        } else {
            this.zzh = zzliVarZzd;
            this.zzi = zzliVarZzd;
        }
        this.zzl = null;
        this.zzj = zzliVarZzd;
        this.zzk++;
        zzy();
        return zzliVarZzd;
    }
}
