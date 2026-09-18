package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzale {
    private final zzfp zza = new zzfp();
    private final int[] zzb = new int[256];
    private boolean zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    static /* bridge */ /* synthetic */ void zzb(zzale zzaleVar, zzfp zzfpVar, int i) {
        int iZzo;
        if (i < 4) {
            return;
        }
        zzfpVar.zzL(3);
        int i2 = i - 4;
        if ((zzfpVar.zzm() & 128) != 0) {
            if (i2 < 7 || (iZzo = zzfpVar.zzo()) < 4) {
                return;
            }
            zzaleVar.zzh = zzfpVar.zzq();
            zzaleVar.zzi = zzfpVar.zzq();
            zzaleVar.zza.zzH(iZzo - 4);
            i2 = i - 11;
        }
        zzfp zzfpVar2 = zzaleVar.zza;
        int iZzd = zzfpVar2.zzd();
        int iZze = zzfpVar2.zze();
        if (iZzd >= iZze || i2 <= 0) {
            return;
        }
        int iMin = Math.min(i2, iZze - iZzd);
        zzfpVar.zzG(zzfpVar2.zzM(), iZzd, iMin);
        zzaleVar.zza.zzK(iZzd + iMin);
    }

    static /* bridge */ /* synthetic */ void zzc(zzale zzaleVar, zzfp zzfpVar, int i) {
        if (i < 19) {
            return;
        }
        zzaleVar.zzd = zzfpVar.zzq();
        zzaleVar.zze = zzfpVar.zzq();
        zzfpVar.zzL(11);
        zzaleVar.zzf = zzfpVar.zzq();
        zzaleVar.zzg = zzfpVar.zzq();
    }

    static /* bridge */ /* synthetic */ void zzd(zzale zzaleVar, zzfp zzfpVar, int i) {
        if (i % 5 != 2) {
            return;
        }
        zzfpVar.zzL(2);
        int i2 = 0;
        Arrays.fill(zzaleVar.zzb, 0);
        int i3 = i / 5;
        int i4 = 0;
        while (i4 < i3) {
            int iZzm = zzfpVar.zzm();
            int iZzm2 = zzfpVar.zzm();
            int iZzm3 = zzfpVar.zzm();
            int iZzm4 = zzfpVar.zzm();
            int iZzm5 = zzfpVar.zzm();
            double d = iZzm2;
            int[] iArr = zzaleVar.zzb;
            double d2 = iZzm3 - 128;
            int iMax = Math.max(i2, Math.min((int) ((1.402d * d2) + d), 255)) << 16;
            double d3 = iZzm4 - 128;
            iArr[iZzm] = Math.max(0, Math.min((int) (d + (d3 * 1.772d)), 255)) | (iZzm5 << 24) | iMax | (Math.max(0, Math.min((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 255)) << 8);
            i4++;
            i2 = 0;
        }
        zzaleVar.zzc = true;
    }

    public final zzec zza() {
        int i;
        if (this.zzd == 0 || this.zze == 0 || this.zzh == 0 || this.zzi == 0) {
            return null;
        }
        zzfp zzfpVar = this.zza;
        if (zzfpVar.zze() == 0 || zzfpVar.zzd() != zzfpVar.zze() || !this.zzc) {
            return null;
        }
        zzfpVar.zzK(0);
        int i2 = this.zzh * this.zzi;
        int[] iArr = new int[i2];
        int i3 = 0;
        while (i3 < i2) {
            int iZzm = this.zza.zzm();
            if (iZzm != 0) {
                i = i3 + 1;
                iArr[i3] = this.zzb[iZzm];
            } else {
                int iZzm2 = this.zza.zzm();
                if (iZzm2 != 0) {
                    int iZzm3 = iZzm2 & 63;
                    if ((iZzm2 & 64) != 0) {
                        iZzm3 = (iZzm3 << 8) | this.zza.zzm();
                    }
                    i = iZzm3 + i3;
                    Arrays.fill(iArr, i3, i, (iZzm2 & 128) == 0 ? 0 : this.zzb[this.zza.zzm()]);
                }
            }
            i3 = i;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, this.zzh, this.zzi, Bitmap.Config.ARGB_8888);
        zzea zzeaVar = new zzea();
        zzeaVar.zzc(bitmapCreateBitmap);
        zzeaVar.zzh(this.zzf / this.zzd);
        zzeaVar.zzi(0);
        zzeaVar.zze(this.zzg / this.zze, 0);
        zzeaVar.zzf(0);
        zzeaVar.zzk(this.zzh / this.zzd);
        zzeaVar.zzd(this.zzi / this.zze);
        return zzeaVar.zzp();
    }

    public final void zze() {
        this.zzd = 0;
        this.zze = 0;
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = 0;
        this.zza.zzH(0);
        this.zzc = false;
    }
}
