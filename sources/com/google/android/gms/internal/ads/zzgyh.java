package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
class zzgyh extends zzgyg {
    protected final byte[] zza;

    zzgyh(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgyl) || zzd() != ((zzgyl) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzgyh)) {
            return obj.equals(this);
        }
        zzgyh zzgyhVar = (zzgyh) obj;
        int iZzr = zzr();
        int iZzr2 = zzgyhVar.zzr();
        if (iZzr == 0 || iZzr2 == 0 || iZzr == iZzr2) {
            return zzg(zzgyhVar, 0, zzd());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    byte zzb(int i) {
        return this.zza[i];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    protected void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, i, bArr, i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzgyg
    final boolean zzg(zzgyl zzgylVar, int i, int i2) {
        if (i2 > zzgylVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + i2 + zzd());
        }
        int i3 = i + i2;
        if (i3 > zzgylVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + zzgylVar.zzd());
        }
        if (!(zzgylVar instanceof zzgyh)) {
            return zzgylVar.zzk(i, i3).equals(zzk(0, i2));
        }
        zzgyh zzgyhVar = (zzgyh) zzgylVar;
        byte[] bArr = this.zza;
        byte[] bArr2 = zzgyhVar.zza;
        int iZzc = zzc() + i2;
        int iZzc2 = zzc();
        int iZzc3 = zzgyhVar.zzc() + i;
        while (iZzc2 < iZzc) {
            if (bArr[iZzc2] != bArr2[iZzc3]) {
                return false;
            }
            iZzc2++;
            iZzc3++;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    protected final int zzi(int i, int i2, int i3) {
        return zzhae.zzb(i, this.zza, zzc() + i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    protected final int zzj(int i, int i2, int i3) {
        int iZzc = zzc() + i2;
        return zzhde.zzf(i, this.zza, iZzc, i3 + iZzc);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final zzgyl zzk(int i, int i2) {
        int iZzq = zzq(i, i2, zzd());
        return iZzq == 0 ? zzgyl.zzb : new zzgye(this.zza, zzc() + i, iZzq);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final zzgyt zzl() {
        return zzgyt.zzI(this.zza, zzc(), zzd(), true);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    protected final String zzm(Charset charset) {
        return new String(this.zza, zzc(), zzd(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final ByteBuffer zzn() {
        return ByteBuffer.wrap(this.zza, zzc(), zzd()).asReadOnlyBuffer();
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    final void zzo(zzgya zzgyaVar) throws IOException {
        zzgyaVar.zza(this.zza, zzc(), zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzgyl
    public final boolean zzp() {
        int iZzc = zzc();
        return zzhde.zzj(this.zza, iZzc, zzd() + iZzc);
    }
}
