package com.google.android.gms.internal.ads;

import android.util.Pair;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzum extends zzwu {
    private final boolean zzb;
    private final zzcw zzc;
    private final zzcu zzd;
    private zzuk zze;
    private zzuj zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    public zzum(zzut zzutVar, boolean z) {
        boolean z2;
        super(zzutVar);
        if (z) {
            zzutVar.zzv();
            z2 = true;
        } else {
            z2 = false;
        }
        this.zzb = z2;
        this.zzc = new zzcw();
        this.zzd = new zzcu();
        zzutVar.zzM();
        this.zze = zzuk.zzq(zzutVar.zzJ());
    }

    private final Object zzK(Object obj) {
        return (this.zze.zzf == null || !obj.equals(zzuk.zzd)) ? obj : this.zze.zzf;
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    private final void zzL(long j) {
        zzuj zzujVar = this.zzf;
        int iZza = this.zze.zza(zzujVar.zza.zza);
        if (iZza == -1) {
            return;
        }
        zzuk zzukVar = this.zze;
        zzcu zzcuVar = this.zzd;
        zzukVar.zzd(iZza, zzcuVar, false);
        long j2 = zzcuVar.zze;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        zzujVar.zzs(j);
    }

    public final zzcx zzC() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    protected final zzur zzD(zzur zzurVar) {
        Object obj = this.zze.zzf;
        Object obj2 = zzurVar.zza;
        if (obj != null && this.zze.zzf.equals(obj2)) {
            obj2 = zzuk.zzd;
        }
        return zzurVar.zza(obj2);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0062  */
    @Override // com.google.android.gms.internal.ads.zzwu
    protected final void zzE(zzcx zzcxVar) {
        long j;
        zzur zzurVarZza = null;
        if (this.zzh) {
            this.zze = this.zze.zzp(zzcxVar);
            zzuj zzujVar = this.zzf;
            if (zzujVar != null) {
                zzL(zzujVar.zzn());
            }
        } else if (zzcxVar.zzo()) {
            this.zze = this.zzi ? this.zze.zzp(zzcxVar) : zzuk.zzr(zzcxVar, zzcw.zza, zzuk.zzd);
        } else {
            zzcxVar.zze(0, this.zzc, 0L);
            Object obj = this.zzc.zzc;
            zzuj zzujVar2 = this.zzf;
            if (zzujVar2 != null) {
                long jZzq = zzujVar2.zzq();
                this.zze.zzn(zzujVar2.zza.zza, this.zzd);
                this.zze.zze(0, this.zzc, 0L);
                if (jZzq != 0) {
                    j = jZzq;
                } else {
                    j = 0;
                }
            } else {
                j = 0;
            }
            Pair pairZzl = zzcxVar.zzl(this.zzc, this.zzd, 0, j);
            Object obj2 = pairZzl.first;
            long jLongValue = ((Long) pairZzl.second).longValue();
            this.zze = this.zzi ? this.zze.zzp(zzcxVar) : zzuk.zzr(zzcxVar, obj, obj2);
            zzuj zzujVar3 = this.zzf;
            if (zzujVar3 != null) {
                zzL(jLongValue);
                zzur zzurVar = zzujVar3.zza;
                zzurVarZza = zzurVar.zza(zzK(zzurVar.zza));
            }
        }
        this.zzi = true;
        this.zzh = true;
        zzo(this.zze);
        if (zzurVarZza != null) {
            zzuj zzujVar4 = this.zzf;
            zzujVar4.getClass();
            zzujVar4.zzr(zzurVarZza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zzF() {
        if (this.zzb) {
            return;
        }
        this.zzg = true;
        zzB(null, ((zzwu) this).zza);
    }

    @Override // com.google.android.gms.internal.ads.zzwu, com.google.android.gms.internal.ads.zzut
    public final void zzG(zzup zzupVar) {
        ((zzuj) zzupVar).zzt();
        if (zzupVar == this.zzf) {
            this.zzf = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwu, com.google.android.gms.internal.ads.zzut
    /* JADX INFO: renamed from: zzH, reason: merged with bridge method [inline-methods] */
    public final zzuj zzI(zzur zzurVar, zzyx zzyxVar, long j) {
        zzuj zzujVar = new zzuj(zzurVar, zzyxVar, j);
        zzujVar.zzu(this.zza);
        if (this.zzh) {
            zzujVar.zzr(zzurVar.zza(zzK(zzurVar.zza)));
        } else {
            this.zzf = zzujVar;
            if (!this.zzg) {
                this.zzg = true;
                zzB(null, ((zzwu) this).zza);
            }
        }
        return zzujVar;
    }

    @Override // com.google.android.gms.internal.ads.zzua, com.google.android.gms.internal.ads.zzts
    public final void zzq() {
        this.zzh = false;
        this.zzg = false;
        super.zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzts, com.google.android.gms.internal.ads.zzut
    public final void zzt(zzbp zzbpVar) {
        if (this.zzi) {
            this.zze = this.zze.zzp(new zzwq(this.zze.zzc, zzbpVar));
        } else {
            this.zze = zzuk.zzq(zzbpVar);
        }
        this.zza.zzt(zzbpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzua, com.google.android.gms.internal.ads.zzut
    public final void zzz() {
    }
}
