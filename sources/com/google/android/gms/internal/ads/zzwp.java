package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzwp implements zzup, zzuo {
    private final zzup zza;
    private final long zzb;
    private zzuo zzc;

    public zzwp(zzup zzupVar, long j) {
        this.zza = zzupVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zza(long j, zzmj zzmjVar) {
        long j2 = this.zzb;
        return this.zza.zza(j - j2, zzmjVar) + j2;
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final long zzb() {
        long jZzb = this.zza.zzb();
        if (jZzb == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jZzb + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final long zzc() {
        long jZzc = this.zza.zzc();
        if (jZzc == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jZzc + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zzd() {
        long jZzd = this.zza.zzd();
        if (jZzd == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return jZzd + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zze(long j) {
        long j2 = this.zzb;
        return this.zza.zze(j - j2) + j2;
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zzf(zzyi[] zzyiVarArr, boolean[] zArr, zzwh[] zzwhVarArr, boolean[] zArr2, long j) {
        zzwh[] zzwhVarArr2 = new zzwh[zzwhVarArr.length];
        int i = 0;
        while (true) {
            zzwh zzwhVarZzc = null;
            if (i >= zzwhVarArr.length) {
                break;
            }
            zzwo zzwoVar = (zzwo) zzwhVarArr[i];
            if (zzwoVar != null) {
                zzwhVarZzc = zzwoVar.zzc();
            }
            zzwhVarArr2[i] = zzwhVarZzc;
            i++;
        }
        long jZzf = this.zza.zzf(zzyiVarArr, zArr, zzwhVarArr2, zArr2, j - this.zzb);
        for (int i2 = 0; i2 < zzwhVarArr.length; i2++) {
            zzwh zzwhVar = zzwhVarArr2[i2];
            if (zzwhVar == null) {
                zzwhVarArr[i2] = null;
            } else {
                zzwh zzwhVar2 = zzwhVarArr[i2];
                if (zzwhVar2 == null || ((zzwo) zzwhVar2).zzc() != zzwhVar) {
                    zzwhVarArr[i2] = new zzwo(zzwhVar, this.zzb);
                }
            }
        }
        return jZzf + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final /* bridge */ /* synthetic */ void zzg(zzwj zzwjVar) {
        zzuo zzuoVar = this.zzc;
        zzuoVar.getClass();
        zzuoVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final zzws zzh() {
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final void zzj(long j, boolean z) {
        this.zza.zzj(j - this.zzb, false);
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final void zzk() throws IOException {
        this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final void zzl(zzuo zzuoVar, long j) {
        this.zzc = zzuoVar;
        this.zza.zzl(this, j - this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final void zzm(long j) {
        this.zza.zzm(j - this.zzb);
    }

    public final zzup zzn() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final boolean zzo(zzlg zzlgVar) {
        long j = zzlgVar.zza;
        long j2 = this.zzb;
        zzle zzleVarZza = zzlgVar.zza();
        zzleVarZza.zze(j - j2);
        return this.zza.zzo(zzleVarZza.zzg());
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final boolean zzp() {
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzuo
    public final void zzi(zzup zzupVar) {
        zzuo zzuoVar = this.zzc;
        zzuoVar.getClass();
        zzuoVar.zzi(this);
    }
}
