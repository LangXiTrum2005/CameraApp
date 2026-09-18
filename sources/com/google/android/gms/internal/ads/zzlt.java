package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlt implements zzvb, zzrt {
    final /* synthetic */ zzlx zza;
    private final zzlv zzb;

    public zzlt(zzlx zzlxVar, zzlv zzlvVar) {
        this.zza = zzlxVar;
        this.zzb = zzlvVar;
    }

    private final Pair zzf(int i, zzur zzurVar) {
        zzur zzurVarZza;
        zzur zzurVar2 = null;
        if (zzurVar != null) {
            zzlv zzlvVar = this.zzb;
            int i2 = 0;
            while (true) {
                if (i2 >= zzlvVar.zzc.size()) {
                    zzurVarZza = null;
                    break;
                }
                if (((zzur) zzlvVar.zzc.get(i2)).zzd == zzurVar.zzd) {
                    zzurVarZza = zzurVar.zza(Pair.create(zzlvVar.zzb, zzurVar.zza));
                    break;
                }
                i2++;
            }
            if (zzurVarZza == null) {
                return null;
            }
            zzurVar2 = zzurVarZza;
        }
        return Pair.create(Integer.valueOf(this.zzb.zzd), zzurVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final void zzae(int i, zzur zzurVar, final zzun zzunVar) {
        final Pair pairZzf = zzf(0, zzurVar);
        if (pairZzf != null) {
            this.zza.zzi.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlr
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzae(((Integer) pair.first).intValue(), (zzur) pair.second, zzunVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final void zzaf(int i, zzur zzurVar, final zzui zzuiVar, final zzun zzunVar) {
        final Pair pairZzf = zzf(0, zzurVar);
        if (pairZzf != null) {
            this.zza.zzi.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlp
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzaf(((Integer) pair.first).intValue(), (zzur) pair.second, zzuiVar, zzunVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final void zzag(int i, zzur zzurVar, final zzui zzuiVar, final zzun zzunVar) {
        final Pair pairZzf = zzf(0, zzurVar);
        if (pairZzf != null) {
            this.zza.zzi.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzls
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzag(((Integer) pair.first).intValue(), (zzur) pair.second, zzuiVar, zzunVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final void zzah(int i, zzur zzurVar, final zzui zzuiVar, final zzun zzunVar, final IOException iOException, final boolean z) {
        final Pair pairZzf = zzf(0, zzurVar);
        if (pairZzf != null) {
            this.zza.zzi.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlo
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzah(((Integer) pair.first).intValue(), (zzur) pair.second, zzuiVar, zzunVar, iOException, z);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvb
    public final void zzai(int i, zzur zzurVar, final zzui zzuiVar, final zzun zzunVar) {
        final Pair pairZzf = zzf(0, zzurVar);
        if (pairZzf != null) {
            this.zza.zzi.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlq
                @Override // java.lang.Runnable
                public final void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzh.zzai(((Integer) pair.first).intValue(), (zzur) pair.second, zzuiVar, zzunVar);
                }
            });
        }
    }
}
