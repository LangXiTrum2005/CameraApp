package com.google.android.gms.internal.ads;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.photolab.vintage.util.picker.PhotoPicker;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhbx extends zzgyl {
    static final int[] zza = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, PhotoPicker.REQUEST_CODE, 377, TypedValues.Motion.TYPE_QUANTIZE_MOTIONSTEPS, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zzc;
    private final zzgyl zzd;
    private final zzgyl zze;
    private final int zzf;
    private final int zzg;

    private zzhbx(zzgyl zzgylVar, zzgyl zzgylVar2) {
        this.zzd = zzgylVar;
        this.zze = zzgylVar2;
        int iZzd = zzgylVar.zzd();
        this.zzf = iZzd;
        this.zzc = iZzd + zzgylVar2.zzd();
        this.zzg = Math.max(zzgylVar.zzf(), zzgylVar2.zzf()) + 1;
    }

    static zzgyl zzC(zzgyl zzgylVar, zzgyl zzgylVar2) {
        if (zzgylVar2.zzd() == 0) {
            return zzgylVar;
        }
        if (zzgylVar.zzd() == 0) {
            return zzgylVar2;
        }
        int iZzd = zzgylVar.zzd() + zzgylVar2.zzd();
        if (iZzd < 128) {
            return zzD(zzgylVar, zzgylVar2);
        }
        if (zzgylVar instanceof zzhbx) {
            zzhbx zzhbxVar = (zzhbx) zzgylVar;
            if (zzhbxVar.zze.zzd() + zzgylVar2.zzd() < 128) {
                return new zzhbx(zzhbxVar.zzd, zzD(zzhbxVar.zze, zzgylVar2));
            }
            if (zzhbxVar.zzd.zzf() > zzhbxVar.zze.zzf() && zzhbxVar.zzg > zzgylVar2.zzf()) {
                return new zzhbx(zzhbxVar.zzd, new zzhbx(zzhbxVar.zze, zzgylVar2));
            }
        }
        return iZzd >= zzc(Math.max(zzgylVar.zzf(), zzgylVar2.zzf()) + 1) ? new zzhbx(zzgylVar, zzgylVar2) : zzhbt.zza(new zzhbt(null), zzgylVar, zzgylVar2);
    }

    private static zzgyl zzD(zzgyl zzgylVar, zzgyl zzgylVar2) {
        int iZzd = zzgylVar.zzd();
        int iZzd2 = zzgylVar2.zzd();
        byte[] bArr = new byte[iZzd + iZzd2];
        zzgylVar.zzz(bArr, 0, 0, iZzd);
        zzgylVar2.zzz(bArr, 0, iZzd, iZzd2);
        return new zzgyh(bArr);
    }

    static int zzc(int i) {
        int[] iArr = zza;
        int length = iArr.length;
        if (i >= 47) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgyl)) {
            return false;
        }
        zzgyl zzgylVar = (zzgyl) obj;
        if (this.zzc != zzgylVar.zzd()) {
            return false;
        }
        if (this.zzc == 0) {
            return true;
        }
        int iZzr = zzr();
        int iZzr2 = zzgylVar.zzr();
        if (iZzr != 0 && iZzr2 != 0 && iZzr != iZzr2) {
            return false;
        }
        zzhbu zzhbuVar = null;
        zzhbv zzhbvVar = new zzhbv(this, zzhbuVar);
        zzgyg zzgygVarZza = zzhbvVar.next();
        zzhbv zzhbvVar2 = new zzhbv(zzgylVar, zzhbuVar);
        zzgyg zzgygVarZza2 = zzhbvVar2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int iZzd = zzgygVarZza.zzd() - i;
            int iZzd2 = zzgygVarZza2.zzd() - i2;
            int iMin = Math.min(iZzd, iZzd2);
            if (!(i == 0 ? zzgygVarZza.zzg(zzgygVarZza2, i2, iMin) : zzgygVarZza2.zzg(zzgygVarZza, i, iMin))) {
                return false;
            }
            i3 += iMin;
            int i4 = this.zzc;
            if (i3 >= i4) {
                if (i3 == i4) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == iZzd) {
                zzgygVarZza = zzhbvVar.next();
                i = 0;
            } else {
                i += iMin;
            }
            if (iMin == iZzd2) {
                zzgygVarZza = zzgygVarZza;
                zzgygVarZza2 = zzhbvVar2.next();
                i2 = 0;
            } else {
                zzgygVarZza = zzgygVarZza;
                i2 += iMin;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgyl, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzhbr(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final byte zza(int i) {
        zzy(i, this.zzc);
        return zzb(i);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    final byte zzb(int i) {
        int i2 = this.zzf;
        return i < i2 ? this.zzd.zzb(i) : this.zze.zzb(i - i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    protected final void zze(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            this.zzd.zze(bArr, i, i2, i3);
        } else {
            if (i >= i5) {
                this.zze.zze(bArr, i - i5, i2, i3);
                return;
            }
            int i6 = i5 - i;
            this.zzd.zze(bArr, i, i2, i6);
            this.zze.zze(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    protected final int zzf() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    protected final boolean zzh() {
        return this.zzc >= zzc(this.zzg);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    protected final int zzi(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            return this.zzd.zzi(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zze.zzi(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zze.zzi(this.zzd.zzi(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    protected final int zzj(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            return this.zzd.zzj(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zze.zzj(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zze.zzj(this.zzd.zzj(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final zzgyl zzk(int i, int i2) {
        int iZzq = zzq(i, i2, this.zzc);
        if (iZzq == 0) {
            return zzgyl.zzb;
        }
        if (iZzq == this.zzc) {
            return this;
        }
        int i3 = this.zzf;
        if (i2 <= i3) {
            return this.zzd.zzk(i, i2);
        }
        if (i >= i3) {
            return this.zze.zzk(i - i3, i2 - i3);
        }
        zzgyl zzgylVar = this.zzd;
        return new zzhbx(zzgylVar.zzk(i, zzgylVar.zzd()), this.zze.zzk(0, i2 - this.zzf));
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final zzgyt zzl() {
        ArrayList<ByteBuffer> arrayList = new ArrayList();
        byte b = 0;
        zzhbv zzhbvVar = new zzhbv(this, null);
        while (zzhbvVar.hasNext()) {
            arrayList.add(zzhbvVar.next().zzn());
        }
        int i = zzgyt.zzd;
        int i2 = 0;
        int iRemaining = 0;
        for (ByteBuffer byteBuffer : arrayList) {
            iRemaining += byteBuffer.remaining();
            i2 = byteBuffer.hasArray() ? i2 | 1 : byteBuffer.isDirect() ? i2 | 2 : i2 | 4;
        }
        return i2 == 2 ? new zzgyp(arrayList, iRemaining, true, b == true ? 1 : 0) : zzgyt.zzH(new zzhah(arrayList), 4096);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    protected final String zzm(Charset charset) {
        return new String(zzA(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final ByteBuffer zzn() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    final void zzo(zzgya zzgyaVar) throws IOException {
        this.zzd.zzo(zzgyaVar);
        this.zze.zzo(zzgyaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final boolean zzp() {
        zzgyl zzgylVar = this.zzd;
        zzgyl zzgylVar2 = this.zze;
        return zzgylVar2.zzj(zzgylVar.zzj(0, 0, this.zzf), 0, zzgylVar2.zzd()) == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    /* JADX INFO: renamed from: zzs */
    public final zzgyf iterator() {
        return new zzhbr(this);
    }
}
