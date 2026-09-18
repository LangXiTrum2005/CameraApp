package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaei implements zzacu {
    public static final zzadb zza = new zzadb() { // from class: com.google.android.gms.internal.ads.zzaeh
        @Override // com.google.android.gms.internal.ads.zzadb
        public final /* synthetic */ zzacu[] zza(Uri uri, Map map) {
            int i = zzada.zza;
            zzadb zzadbVar = zzaei.zza;
            return new zzacu[]{new zzaei(0)};
        }
    };
    private static final int[] zzb = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    private static final int[] zzc;
    private static final byte[] zzd;
    private static final byte[] zze;
    private static final int zzf;
    private final byte[] zzg;
    private boolean zzh;
    private long zzi;
    private int zzj;
    private int zzk;
    private boolean zzl;
    private int zzm;
    private int zzn;
    private long zzo;
    private zzacx zzp;
    private zzaea zzq;
    private zzadu zzr;
    private boolean zzs;

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        zzc = iArr;
        int i = zzfy.zza;
        zzd = "#!AMR\n".getBytes(zzfwq.zzc);
        zze = "#!AMR-WB\n".getBytes(zzfwq.zzc);
        zzf = iArr[8];
    }

    public zzaei() {
        this(0);
    }

    public zzaei(int i) {
        this.zzg = new byte[1];
        this.zzm = -1;
    }

    private static boolean zzf(zzacv zzacvVar, byte[] bArr) throws IOException {
        zzacvVar.zzj();
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        ((zzack) zzacvVar).zzm(bArr2, 0, length, false);
        return Arrays.equals(bArr2, bArr);
    }

    private final boolean zzg(zzacv zzacvVar) throws IOException {
        byte[] bArr = zzd;
        if (zzf(zzacvVar, bArr)) {
            this.zzh = false;
            ((zzack) zzacvVar).zzo(bArr.length, false);
            return true;
        }
        byte[] bArr2 = zze;
        if (!zzf(zzacvVar, bArr2)) {
            return false;
        }
        this.zzh = true;
        ((zzack) zzacvVar).zzo(bArr2.length, false);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        zzek.zzb(this.zzq);
        int i = zzfy.zza;
        if (zzacvVar.zzf() == 0 && !zzg(zzacvVar)) {
            throw zzcc.zza("Could not find AMR header.", null);
        }
        if (!this.zzs) {
            this.zzs = true;
            boolean z = this.zzh;
            String str = true != z ? "audio/3gpp" : "audio/amr-wb";
            int i2 = true != z ? 8000 : 16000;
            zzaea zzaeaVar = this.zzq;
            zzak zzakVar = new zzak();
            zzakVar.zzW(str);
            zzakVar.zzO(zzf);
            zzakVar.zzy(1);
            zzakVar.zzX(i2);
            zzaeaVar.zzl(zzakVar.zzac());
        }
        int iZza = zza(zzacvVar);
        if (this.zzl) {
            return iZza;
        }
        zzadt zzadtVar = new zzadt(-9223372036854775807L, 0L);
        this.zzr = zzadtVar;
        this.zzp.zzO(zzadtVar);
        this.zzl = true;
        return iZza;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        this.zzp = zzacxVar;
        this.zzq = zzacxVar.zzw(0, 1);
        zzacxVar.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j, long j2) {
        this.zzi = 0L;
        this.zzj = 0;
        this.zzk = 0;
        this.zzo = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        return zzg(zzacvVar);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Code duplicated, block: B:15:0x0033  */
    /* JADX WARN: Code duplicated, block: B:39:0x0085  */
    @RequiresNonNull({"trackOutput"})
    private final int zza(zzacv zzacvVar) throws IOException {
        int i = this.zzk;
        if (i == 0) {
            try {
                zzacvVar.zzj();
                ((zzack) zzacvVar).zzm(this.zzg, 0, 1, false);
                byte b = this.zzg[0];
                if ((b & 131) > 0) {
                    throw zzcc.zza("Invalid padding bits for frame header " + ((int) b), null);
                }
                int i2 = b >> 3;
                boolean z = this.zzh;
                int i3 = i2 & 15;
                if (!z) {
                    if (!z) {
                        if (i3 >= 12 && i3 <= 14) {
                        }
                    }
                    throw zzcc.zza("Illegal AMR " + (true != z ? "NB" : "WB") + " frame type " + i3, null);
                }
                if (i3 >= 10 && i3 <= 13) {
                    if (!z) {
                        if (i3 >= 12) {
                        }
                    }
                    if (true != z) {
                    }
                    throw zzcc.zza("Illegal AMR " + (true != z ? "NB" : "WB") + " frame type " + i3, null);
                }
                i = z ? zzc[i3] : zzb[i3];
                this.zzj = i;
                this.zzk = i;
                int i4 = this.zzm;
                if (i4 == -1) {
                    this.zzm = i;
                    i4 = i;
                }
                if (i4 == i) {
                    this.zzn++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int iZza = zzady.zza(this.zzq, zzacvVar, i, true);
        if (iZza == -1) {
            return -1;
        }
        int i5 = this.zzk - iZza;
        this.zzk = i5;
        if (i5 > 0) {
            return 0;
        }
        this.zzq.zzt(this.zzi, 1, this.zzj, 0, null);
        this.zzi += 20000;
        return 0;
    }
}
