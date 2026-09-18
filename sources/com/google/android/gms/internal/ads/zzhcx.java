package com.google.android.gms.internal.ads;

import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhcx extends zzhcy {
    zzhcx(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.ads.zzhcy
    public final byte zza(long j) {
        return Memory.peekByte(j);
    }

    @Override // com.google.android.gms.internal.ads.zzhcy
    public final double zzb(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.ads.zzhcy
    public final float zzc(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    @Override // com.google.android.gms.internal.ads.zzhcy
    public final void zzd(long j, byte[] bArr, long j2, long j3) {
        Memory.peekByteArray(j, bArr, (int) j2, (int) j3);
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.ads.zzhcz.zzk(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.ads.zzhcz.zzl(java.lang.Object, long, boolean):void */
    /* JADX WARN: Method inline failed with exception
    java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 2
    	at java.base/java.util.ArrayList.shiftTailOverGap(Unknown Source)
    	at java.base/java.util.ArrayList.removeIf(Unknown Source)
     */
    /* JADX WARN: Unknown register number '(r5v0 boolean)' in method call: com.google.android.gms.internal.ads.zzhcz.zzl(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.ads.zzhcy
    public final void zze(Object obj, long j, boolean z) {
        if (zzhcz.zzb) {
            zzhcz.zzk(obj, j, z);
        } else {
            zzhcz.zzl(obj, j, z);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcy
    public final void zzf(Object obj, long j, byte b) {
        if (zzhcz.zzb) {
            zzhcz.zzG(obj, j, b);
        } else {
            zzhcz.zzH(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcy
    public final void zzg(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.ads.zzhcy
    public final void zzh(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.ads.zzhcy
    public final boolean zzi(Object obj, long j) {
        return zzhcz.zzb ? zzhcz.zzw(obj, j) : zzhcz.zzx(obj, j);
    }
}
