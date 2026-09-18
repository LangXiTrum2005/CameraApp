package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhdc extends zzhdb {
    zzhdc() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        if (r13[r14] <= (-65)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0047, code lost:
    
        if (r13[r14] <= (-65)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0080, code lost:
    
        if (r13[r14] <= (-65)) goto L11;
     */
    @Override // com.google.android.gms.internal.ads.zzhdb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int zza(int r12, byte[] r13, int r14, int r15) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhdc.zza(int, byte[], int, int):int");
    }

    @Override // com.google.android.gms.internal.ads.zzhdb
    final String zzb(byte[] bArr, int i, int i2) throws zzhag {
        int i3;
        int length = bArr.length;
        if ((((length - i) - i2) | i | i2) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i4 = i + i2;
        char[] cArr = new char[i2];
        int i5 = 0;
        while (i < i4) {
            byte b = bArr[i];
            if (!zzhda.zzd(b)) {
                break;
            }
            i++;
            cArr[i5] = (char) b;
            i5++;
        }
        while (i < i4) {
            int i6 = i + 1;
            byte b2 = bArr[i];
            if (zzhda.zzd(b2)) {
                cArr[i5] = (char) b2;
                i5++;
                i = i6;
                while (i < i4) {
                    byte b3 = bArr[i];
                    if (!zzhda.zzd(b3)) {
                        break;
                    }
                    i++;
                    cArr[i5] = (char) b3;
                    i5++;
                }
            } else {
                if (zzhda.zzf(b2)) {
                    if (i6 >= i4) {
                        throw zzhag.zzd();
                    }
                    i3 = i5 + 1;
                    i += 2;
                    zzhda.zzc(b2, bArr[i6], cArr, i5);
                } else if (zzhda.zze(b2)) {
                    if (i6 >= i4 - 1) {
                        throw zzhag.zzd();
                    }
                    i3 = i5 + 1;
                    int i7 = i + 2;
                    i += 3;
                    zzhda.zzb(b2, bArr[i6], bArr[i7], cArr, i5);
                } else {
                    if (i6 >= i4 - 2) {
                        throw zzhag.zzd();
                    }
                    byte b4 = bArr[i6];
                    int i8 = i + 3;
                    byte b5 = bArr[i + 2];
                    i += 4;
                    zzhda.zza(b2, b4, b5, bArr[i8], cArr, i5);
                    i5 += 2;
                }
                i5 = i3;
            }
        }
        return new String(cArr, 0, i5);
    }
}
