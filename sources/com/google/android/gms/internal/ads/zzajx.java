package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzajx {
    private final zzajy zza = new zzajy();
    private final zzfp zzb = new zzfp(new byte[65025], 0);
    private int zzc = -1;
    private int zzd;
    private boolean zze;

    zzajx() {
    }

    private final int zzf(int i) {
        int i2;
        int i3 = 0;
        this.zzd = 0;
        do {
            int i4 = this.zzd;
            int i5 = i + i4;
            zzajy zzajyVar = this.zza;
            if (i5 >= zzajyVar.zzc) {
                break;
            }
            this.zzd = i4 + 1;
            i2 = zzajyVar.zzf[i5];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public final zzfp zza() {
        return this.zzb;
    }

    public final zzajy zzb() {
        return this.zza;
    }

    public final void zzc() {
        this.zza.zza();
        this.zzb.zzH(0);
        this.zzc = -1;
        this.zze = false;
    }

    public final void zzd() {
        zzfp zzfpVar = this.zzb;
        if (zzfpVar.zzM().length == 65025) {
            return;
        }
        zzfpVar.zzI(Arrays.copyOf(zzfpVar.zzM(), Math.max(65025, zzfpVar.zze())), this.zzb.zze());
    }

    public final boolean zze(zzacv zzacvVar) throws IOException {
        if (this.zze) {
            this.zze = false;
            this.zzb.zzH(0);
        }
        while (true) {
            if (this.zze) {
                return true;
            }
            int i = this.zzc;
            if (i < 0) {
                if (!this.zza.zzc(zzacvVar, -1L) || !this.zza.zzb(zzacvVar, true)) {
                    return false;
                }
                zzajy zzajyVar = this.zza;
                int iZzf = zzajyVar.zzd;
                if ((zzajyVar.zza & 1) == 1 && this.zzb.zze() == 0) {
                    iZzf += zzf(0);
                    i = this.zzd;
                } else {
                    i = 0;
                }
                if (!zzacy.zze(zzacvVar, iZzf)) {
                    return false;
                }
                this.zzc = i;
            }
            int iZzf2 = zzf(i);
            int i2 = this.zzc + this.zzd;
            if (iZzf2 > 0) {
                zzfp zzfpVar = this.zzb;
                zzfpVar.zzE(zzfpVar.zze() + iZzf2);
                zzfp zzfpVar2 = this.zzb;
                if (!zzacy.zzd(zzacvVar, zzfpVar2.zzM(), zzfpVar2.zze(), iZzf2)) {
                    return false;
                }
                zzfp zzfpVar3 = this.zzb;
                zzfpVar3.zzJ(zzfpVar3.zze() + iZzf2);
                this.zze = this.zza.zzf[i2 + (-1)] != 255;
            }
            if (i2 == this.zza.zzc) {
                i2 = -1;
            }
            this.zzc = i2;
        }
    }
}
