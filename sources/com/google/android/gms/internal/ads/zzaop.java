package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaop implements zzaoq {
    private static final int[] zza = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
    private static final int[] zzb = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
    private final zzacx zzc;
    private final zzaea zzd;
    private final zzaot zze;
    private final int zzf;
    private final byte[] zzg;
    private final zzfp zzh;
    private final int zzi;
    private final zzam zzj;
    private int zzk;
    private long zzl;
    private int zzm;
    private long zzn;

    public zzaop(zzacx zzacxVar, zzaea zzaeaVar, zzaot zzaotVar) throws zzcc {
        this.zzc = zzacxVar;
        this.zzd = zzaeaVar;
        this.zze = zzaotVar;
        int iMax = Math.max(1, zzaotVar.zzc / 10);
        this.zzi = iMax;
        zzfp zzfpVar = new zzfp(zzaotVar.zzf);
        zzfpVar.zzk();
        int iZzk = zzfpVar.zzk();
        this.zzf = iZzk;
        int i = zzaotVar.zzb;
        int i2 = (((zzaotVar.zzd - (i * 4)) * 8) / (zzaotVar.zze * i)) + 1;
        if (iZzk != i2) {
            throw zzcc.zza("Expected frames per block: " + i2 + "; got: " + iZzk, null);
        }
        int i3 = zzfy.zza;
        int i4 = ((iMax + iZzk) - 1) / iZzk;
        this.zzg = new byte[zzaotVar.zzd * i4];
        this.zzh = new zzfp(i4 * (iZzk + iZzk) * i);
        int i5 = ((zzaotVar.zzc * zzaotVar.zzd) * 8) / iZzk;
        zzak zzakVar = new zzak();
        zzakVar.zzW("audio/raw");
        zzakVar.zzx(i5);
        zzakVar.zzR(i5);
        zzakVar.zzO((iMax + iMax) * i);
        zzakVar.zzy(zzaotVar.zzb);
        zzakVar.zzX(zzaotVar.zzc);
        zzakVar.zzQ(2);
        this.zzj = zzakVar.zzac();
    }

    private final int zzd(int i) {
        int i2 = this.zze.zzb;
        return i / (i2 + i2);
    }

    private final int zze(int i) {
        return (i + i) * this.zze.zzb;
    }

    private final void zzf(int i) {
        long jZzs = this.zzl + zzfy.zzs(this.zzn, 1000000L, this.zze.zzc, RoundingMode.FLOOR);
        int iZze = zze(i);
        this.zzd.zzt(jZzs, 1, iZze, this.zzm - iZze, null);
        this.zzn += (long) i;
        this.zzm -= iZze;
    }

    @Override // com.google.android.gms.internal.ads.zzaoq
    public final void zza(int i, long j) {
        this.zzc.zzO(new zzaow(this.zze, this.zzf, i, j));
        this.zzd.zzl(this.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzaoq
    public final void zzb(long j) {
        this.zzk = 0;
        this.zzl = j;
        this.zzm = 0;
        this.zzn = 0L;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003e A[LOOP:0: B:6:0x0023->B:12:0x003e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:41:0x0044 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x0020 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0025  */
    /* JADX WARN: Code duplicated, block: B:9:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003b -> B:4:0x0020). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.google.android.gms.internal.ads.zzaoq
    public final boolean zzc(com.google.android.gms.internal.ads.zzacv r21, long r22) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaop.zzc(com.google.android.gms.internal.ads.zzacv, long):boolean");
    }
}
