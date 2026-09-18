package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzwa {
    private final zzfp zza = new zzfp(32);
    private zzvz zzb;
    private zzvz zzc;
    private zzvz zzd;
    private long zze;
    private final zzyx zzf;

    public zzwa(zzyx zzyxVar) {
        this.zzf = zzyxVar;
        zzvz zzvzVar = new zzvz(0L, 65536);
        this.zzb = zzvzVar;
        this.zzc = zzvzVar;
        this.zzd = zzvzVar;
    }

    private final int zzi(int i) {
        zzvz zzvzVar = this.zzd;
        if (zzvzVar.zzc == null) {
            zzyq zzyqVarZzb = this.zzf.zzb();
            zzvz zzvzVar2 = new zzvz(this.zzd.zzb, 65536);
            zzvzVar.zzc = zzyqVarZzb;
            zzvzVar.zzd = zzvzVar2;
        }
        return Math.min(i, (int) (this.zzd.zzb - this.zze));
    }

    private static zzvz zzj(zzvz zzvzVar, long j) {
        while (j >= zzvzVar.zzb) {
            zzvzVar = zzvzVar.zzd;
        }
        return zzvzVar;
    }

    private static zzvz zzk(zzvz zzvzVar, long j, ByteBuffer byteBuffer, int i) {
        zzvz zzvzVarZzj = zzj(zzvzVar, j);
        while (i > 0) {
            int iMin = Math.min(i, (int) (zzvzVarZzj.zzb - j));
            byteBuffer.put(zzvzVarZzj.zzc.zza, zzvzVarZzj.zza(j), iMin);
            i -= iMin;
            j += (long) iMin;
            if (j == zzvzVarZzj.zzb) {
                zzvzVarZzj = zzvzVarZzj.zzd;
            }
        }
        return zzvzVarZzj;
    }

    private static zzvz zzl(zzvz zzvzVar, long j, byte[] bArr, int i) {
        zzvz zzvzVarZzj = zzj(zzvzVar, j);
        int i2 = i;
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (zzvzVarZzj.zzb - j));
            System.arraycopy(zzvzVarZzj.zzc.zza, zzvzVarZzj.zza(j), bArr, i - i2, iMin);
            i2 -= iMin;
            j += (long) iMin;
            if (j == zzvzVarZzj.zzb) {
                zzvzVarZzj = zzvzVarZzj.zzd;
            }
        }
        return zzvzVarZzj;
    }

    private static zzvz zzm(zzvz zzvzVar, zzih zzihVar, zzwc zzwcVar, zzfp zzfpVar) {
        zzvz zzvzVarZzl;
        if (zzihVar.zzk()) {
            long j = zzwcVar.zzb;
            int iZzq = 1;
            zzfpVar.zzH(1);
            zzvz zzvzVarZzl2 = zzl(zzvzVar, j, zzfpVar.zzM(), 1);
            long j2 = j + 1;
            byte b = zzfpVar.zzM()[0];
            int i = b & 128;
            int i2 = b & 127;
            zzie zzieVar = zzihVar.zzb;
            byte[] bArr = zzieVar.zza;
            if (bArr == null) {
                zzieVar.zza = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            boolean z = i != 0;
            zzvzVarZzl = zzl(zzvzVarZzl2, j2, zzieVar.zza, i2);
            long j3 = j2 + ((long) i2);
            if (z) {
                zzfpVar.zzH(2);
                zzvzVarZzl = zzl(zzvzVarZzl, j3, zzfpVar.zzM(), 2);
                j3 += 2;
                iZzq = zzfpVar.zzq();
            }
            int i3 = iZzq;
            int[] iArr = zzieVar.zzd;
            if (iArr == null || iArr.length < i3) {
                iArr = new int[i3];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = zzieVar.zze;
            if (iArr3 == null || iArr3.length < i3) {
                iArr3 = new int[i3];
            }
            int[] iArr4 = iArr3;
            if (z) {
                int i4 = i3 * 6;
                zzfpVar.zzH(i4);
                zzvzVarZzl = zzl(zzvzVarZzl, j3, zzfpVar.zzM(), i4);
                j3 += (long) i4;
                zzfpVar.zzK(0);
                for (int i5 = 0; i5 < i3; i5++) {
                    iArr2[i5] = zzfpVar.zzq();
                    iArr4[i5] = zzfpVar.zzp();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = zzwcVar.zza - ((int) (j3 - zzwcVar.zzb));
            }
            zzadz zzadzVar = zzwcVar.zzc;
            int i6 = zzfy.zza;
            zzieVar.zzc(i3, iArr2, iArr4, zzadzVar.zzb, zzieVar.zza, zzadzVar.zza, zzadzVar.zzc, zzadzVar.zzd);
            long j4 = zzwcVar.zzb;
            int i7 = (int) (j3 - j4);
            zzwcVar.zzb = j4 + ((long) i7);
            zzwcVar.zza -= i7;
        } else {
            zzvzVarZzl = zzvzVar;
        }
        if (!zzihVar.zze()) {
            zzihVar.zzi(zzwcVar.zza);
            return zzk(zzvzVarZzl, zzwcVar.zzb, zzihVar.zzc, zzwcVar.zza);
        }
        zzfpVar.zzH(4);
        zzvz zzvzVarZzl3 = zzl(zzvzVarZzl, zzwcVar.zzb, zzfpVar.zzM(), 4);
        int iZzp = zzfpVar.zzp();
        zzwcVar.zzb += 4;
        zzwcVar.zza -= 4;
        zzihVar.zzi(iZzp);
        zzvz zzvzVarZzk = zzk(zzvzVarZzl3, zzwcVar.zzb, zzihVar.zzc, iZzp);
        zzwcVar.zzb += (long) iZzp;
        int i8 = zzwcVar.zza - iZzp;
        zzwcVar.zza = i8;
        ByteBuffer byteBuffer = zzihVar.zzf;
        if (byteBuffer == null || byteBuffer.capacity() < i8) {
            zzihVar.zzf = ByteBuffer.allocate(i8);
        } else {
            zzihVar.zzf.clear();
        }
        return zzk(zzvzVarZzk, zzwcVar.zzb, zzihVar.zzf, zzwcVar.zza);
    }

    private final void zzn(int i) {
        long j = this.zze + ((long) i);
        this.zze = j;
        zzvz zzvzVar = this.zzd;
        if (j == zzvzVar.zzb) {
            this.zzd = zzvzVar.zzd;
        }
    }

    public final int zza(zzu zzuVar, int i, boolean z) throws IOException {
        int iZzi = zzi(i);
        zzvz zzvzVar = this.zzd;
        int iZza = zzuVar.zza(zzvzVar.zzc.zza, zzvzVar.zza(this.zze), iZzi);
        if (iZza != -1) {
            zzn(iZza);
            return iZza;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public final long zzb() {
        return this.zze;
    }

    public final void zzc(long j) {
        zzvz zzvzVar;
        if (j != -1) {
            while (true) {
                zzvzVar = this.zzb;
                if (j < zzvzVar.zzb) {
                    break;
                }
                this.zzf.zzc(zzvzVar.zzc);
                this.zzb = this.zzb.zzb();
            }
            if (this.zzc.zza < zzvzVar.zza) {
                this.zzc = zzvzVar;
            }
        }
    }

    public final void zzd(zzih zzihVar, zzwc zzwcVar) {
        zzm(this.zzc, zzihVar, zzwcVar, this.zza);
    }

    public final void zze(zzih zzihVar, zzwc zzwcVar) {
        this.zzc = zzm(this.zzc, zzihVar, zzwcVar, this.zza);
    }

    public final void zzf() {
        zzvz zzvzVar = this.zzb;
        if (zzvzVar.zzc != null) {
            this.zzf.zzd(zzvzVar);
            zzvzVar.zzb();
        }
        this.zzb.zze(0L, 65536);
        zzvz zzvzVar2 = this.zzb;
        this.zzc = zzvzVar2;
        this.zzd = zzvzVar2;
        this.zze = 0L;
        this.zzf.zzg();
    }

    public final void zzg() {
        this.zzc = this.zzb;
    }

    public final void zzh(zzfp zzfpVar, int i) {
        while (i > 0) {
            int iZzi = zzi(i);
            zzvz zzvzVar = this.zzd;
            zzfpVar.zzG(zzvzVar.zzc.zza, zzvzVar.zza(this.zze), iZzi);
            i -= iZzi;
            zzn(iZzi);
        }
    }
}
