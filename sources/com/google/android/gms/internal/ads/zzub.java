package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzub implements zzwj {
    protected final zzwj[] zza;

    public zzub(zzwj[] zzwjVarArr) {
        this.zza = zzwjVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public final long zzb() {
        long jMin = Long.MAX_VALUE;
        for (zzwj zzwjVar : this.zza) {
            long jZzb = zzwjVar.zzb();
            if (jZzb != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jZzb);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public final long zzc() {
        long jMin = Long.MAX_VALUE;
        for (zzwj zzwjVar : this.zza) {
            long jZzc = zzwjVar.zzc();
            if (jZzc != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jZzc);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public final void zzm(long j) {
        for (zzwj zzwjVar : this.zza) {
            zzwjVar.zzm(j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public final boolean zzo(zzlg zzlgVar) {
        boolean zZzo;
        boolean z = false;
        do {
            long jZzc = zzc();
            long j = Long.MIN_VALUE;
            if (jZzc == Long.MIN_VALUE) {
                break;
            }
            zzwj[] zzwjVarArr = this.zza;
            int length = zzwjVarArr.length;
            int i = 0;
            zZzo = false;
            while (i < length) {
                zzwj zzwjVar = zzwjVarArr[i];
                long jZzc2 = zzwjVar.zzc();
                boolean z2 = jZzc2 != j && jZzc2 <= zzlgVar.zza;
                if (jZzc2 == jZzc || z2) {
                    zZzo |= zzwjVar.zzo(zzlgVar);
                }
                i++;
                j = Long.MIN_VALUE;
            }
            z |= zZzo;
        } while (zZzo);
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public final boolean zzp() {
        for (zzwj zzwjVar : this.zza) {
            if (zzwjVar.zzp()) {
                return true;
            }
        }
        return false;
    }
}
