package com.google.android.gms.internal.ads;

import androidx.core.view.InputDeviceCompat;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzany implements zzaol {
    private final zzanx zza;
    private final zzfp zzb = new zzfp(32);
    private int zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    public zzany(zzanx zzanxVar) {
        this.zza = zzanxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaol
    public final void zza(zzfp zzfpVar, int i) {
        int iZzd;
        int i2 = i & 1;
        if (i2 != 0) {
            iZzd = zzfpVar.zzd() + zzfpVar.zzm();
        } else {
            iZzd = -1;
        }
        if (this.zzf) {
            if (i2 == 0) {
                return;
            }
            this.zzf = false;
            zzfpVar.zzK(iZzd);
            this.zzd = 0;
        }
        while (zzfpVar.zzb() > 0) {
            int i3 = this.zzd;
            if (i3 < 3) {
                if (i3 == 0) {
                    int iZzm = zzfpVar.zzm();
                    zzfpVar.zzK(zzfpVar.zzd() - 1);
                    if (iZzm == 255) {
                        this.zzf = true;
                        return;
                    }
                }
                int iMin = Math.min(zzfpVar.zzb(), 3 - this.zzd);
                zzfpVar.zzG(this.zzb.zzM(), this.zzd, iMin);
                int i4 = this.zzd + iMin;
                this.zzd = i4;
                if (i4 == 3) {
                    this.zzb.zzK(0);
                    this.zzb.zzJ(3);
                    this.zzb.zzL(1);
                    zzfp zzfpVar2 = this.zzb;
                    int iZzm2 = zzfpVar2.zzm();
                    boolean z = (iZzm2 & 128) != 0;
                    int iZzm3 = zzfpVar2.zzm();
                    this.zze = z;
                    this.zzc = (iZzm3 | ((iZzm2 & 15) << 8)) + 3;
                    int iZzc = this.zzb.zzc();
                    int i5 = this.zzc;
                    if (iZzc < i5) {
                        int iZzc2 = this.zzb.zzc();
                        this.zzb.zzE(Math.min(InputDeviceCompat.SOURCE_TOUCHSCREEN, Math.max(i5, iZzc2 + iZzc2)));
                    }
                }
            } else {
                int iMin2 = Math.min(zzfpVar.zzb(), this.zzc - i3);
                zzfpVar.zzG(this.zzb.zzM(), this.zzd, iMin2);
                int i6 = this.zzd + iMin2;
                this.zzd = i6;
                int i7 = this.zzc;
                if (i6 != i7) {
                    continue;
                } else {
                    if (!this.zze) {
                        this.zzb.zzJ(i7);
                    } else {
                        if (zzfy.zzd(this.zzb.zzM(), 0, i7, -1) != 0) {
                            this.zzf = true;
                            return;
                        }
                        this.zzb.zzJ(this.zzc - 4);
                    }
                    this.zzb.zzK(0);
                    this.zza.zza(this.zzb);
                    this.zzd = 0;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaol
    public final void zzb(zzfw zzfwVar, zzacx zzacxVar, zzaok zzaokVar) {
        this.zza.zzb(zzfwVar, zzacxVar, zzaokVar);
        this.zzf = true;
    }

    @Override // com.google.android.gms.internal.ads.zzaol
    public final void zzc() {
        this.zzf = true;
    }
}
