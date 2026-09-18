package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.math.RoundingMode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaor implements zzaoq {
    private final zzacx zza;
    private final zzaea zzb;
    private final zzaot zzc;
    private final zzam zzd;
    private final int zze;
    private long zzf;
    private int zzg;
    private long zzh;

    public zzaor(zzacx zzacxVar, zzaea zzaeaVar, zzaot zzaotVar, String str, int i) throws zzcc {
        this.zza = zzacxVar;
        this.zzb = zzaeaVar;
        this.zzc = zzaotVar;
        int i2 = zzaotVar.zzb * zzaotVar.zze;
        int i3 = zzaotVar.zzd;
        int i4 = i2 / 8;
        if (i3 != i4) {
            throw zzcc.zza("Expected block size: " + i4 + "; got: " + i3, null);
        }
        int i5 = zzaotVar.zzc * i4;
        int i6 = i5 * 8;
        int iMax = Math.max(i4, i5 / 10);
        this.zze = iMax;
        zzak zzakVar = new zzak();
        zzakVar.zzW(str);
        zzakVar.zzx(i6);
        zzakVar.zzR(i6);
        zzakVar.zzO(iMax);
        zzakVar.zzy(zzaotVar.zzb);
        zzakVar.zzX(zzaotVar.zzc);
        zzakVar.zzQ(i);
        this.zzd = zzakVar.zzac();
    }

    @Override // com.google.android.gms.internal.ads.zzaoq
    public final void zza(int i, long j) {
        this.zza.zzO(new zzaow(this.zzc, 1, i, j));
        this.zzb.zzl(this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzaoq
    public final void zzb(long j) {
        this.zzf = j;
        this.zzg = 0;
        this.zzh = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzaoq
    public final boolean zzc(zzacv zzacvVar, long j) throws IOException {
        int i;
        int i2;
        long j2 = j;
        while (j2 > 0 && (i = this.zzg) < (i2 = this.zze)) {
            int iZza = zzady.zza(this.zzb, zzacvVar, (int) Math.min(i2 - i, j2), true);
            if (iZza == -1) {
                j2 = 0;
            } else {
                this.zzg += iZza;
                j2 -= (long) iZza;
            }
        }
        zzaot zzaotVar = this.zzc;
        int i3 = this.zzg;
        int i4 = zzaotVar.zzd;
        int i5 = i3 / i4;
        if (i5 > 0) {
            long jZzs = this.zzf + zzfy.zzs(this.zzh, 1000000L, zzaotVar.zzc, RoundingMode.FLOOR);
            int i6 = i5 * i4;
            int i7 = this.zzg - i6;
            this.zzb.zzt(jZzs, 1, i6, i7, null);
            this.zzh += (long) i5;
            this.zzg = i7;
        }
        return j2 <= 0;
    }
}
