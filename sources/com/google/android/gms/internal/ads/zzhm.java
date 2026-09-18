package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import com.google.firebase.perf.util.Constants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhm extends zzgq {
    private RandomAccessFile zza;
    private Uri zzb;
    private long zzc;
    private boolean zzd;

    public zzhm() {
        super(false);
    }

    @Override // com.google.android.gms.internal.ads.zzu
    public final int zza(byte[] bArr, int i, int i2) throws zzhl {
        if (i2 == 0) {
            return 0;
        }
        if (this.zzc == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.zza;
            int i3 = zzfy.zza;
            int i4 = randomAccessFile.read(bArr, i, (int) Math.min(this.zzc, i2));
            if (i4 > 0) {
                this.zzc -= (long) i4;
                zzg(i4);
            }
            return i4;
        } catch (IOException e) {
            throw new zzhl(e, Constants.MAX_URL_LENGTH);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final long zzb(zzhb zzhbVar) throws zzhl {
        Uri uri = zzhbVar.zza;
        this.zzb = uri;
        zzi(zzhbVar);
        try {
            String path = uri.getPath();
            path.getClass();
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
            this.zza = randomAccessFile;
            try {
                randomAccessFile.seek(zzhbVar.zzf);
                long length = zzhbVar.zzg;
                if (length == -1) {
                    length = this.zza.length() - zzhbVar.zzf;
                }
                this.zzc = length;
                if (length < 0) {
                    throw new zzhl(null, null, 2008);
                }
                this.zzd = true;
                zzj(zzhbVar);
                return this.zzc;
            } catch (IOException e) {
                throw new zzhl(e, Constants.MAX_URL_LENGTH);
            }
        } catch (FileNotFoundException e2) {
            if (!TextUtils.isEmpty(uri.getQuery()) || !TextUtils.isEmpty(uri.getFragment())) {
                throw new zzhl(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e2, PointerIconCompat.TYPE_WAIT);
            }
            int i = zzfy.zza;
            throw new zzhl(e2, true != zzhk.zzb(e2.getCause()) ? 2005 : 2006);
        } catch (SecurityException e3) {
            throw new zzhl(e3, 2006);
        } catch (RuntimeException e4) {
            throw new zzhl(e4, Constants.MAX_URL_LENGTH);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final Uri zzc() {
        return this.zzb;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0017 */
    @Override // com.google.android.gms.internal.ads.zzgw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzd() throws com.google.android.gms.internal.ads.zzhl {
        /*
            r5 = this;
            r0 = 0
            r5.zzb = r0
            r1 = 0
            java.io.RandomAccessFile r2 = r5.zza     // Catch: java.lang.Throwable -> L17 java.io.IOException -> L19
            if (r2 == 0) goto Lb
            r2.close()     // Catch: java.lang.Throwable -> L17 java.io.IOException -> L19
        Lb:
            r5.zza = r0
            boolean r0 = r5.zzd
            if (r0 == 0) goto L16
            r5.zzd = r1
            r5.zzh()
        L16:
            return
        L17:
            r2 = move-exception
            goto L22
        L19:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzhl r3 = new com.google.android.gms.internal.ads.zzhl     // Catch: java.lang.Throwable -> L17
            r4 = 2000(0x7d0, float:2.803E-42)
            r3.<init>(r2, r4)     // Catch: java.lang.Throwable -> L17
            throw r3     // Catch: java.lang.Throwable -> L17
        L22:
            r5.zza = r0
            boolean r0 = r5.zzd
            if (r0 != 0) goto L29
            goto L2e
        L29:
            r5.zzd = r1
            r5.zzh()
        L2e:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhm.zzd():void");
    }
}
