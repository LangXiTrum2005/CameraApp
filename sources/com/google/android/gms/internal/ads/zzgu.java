package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Base64;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
import java.net.URLDecoder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgu extends zzgq {
    private zzhb zza;
    private byte[] zzb;
    private int zzc;
    private int zzd;

    public zzgu() {
        super(false);
    }

    @Override // com.google.android.gms.internal.ads.zzu
    public final int zza(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.zzd;
        if (i3 == 0) {
            return -1;
        }
        int iMin = Math.min(i2, i3);
        byte[] bArr2 = this.zzb;
        int i4 = zzfy.zza;
        System.arraycopy(bArr2, this.zzc, bArr, i, iMin);
        this.zzc += iMin;
        this.zzd -= iMin;
        zzg(iMin);
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final long zzb(zzhb zzhbVar) throws IOException {
        zzi(zzhbVar);
        this.zza = zzhbVar;
        Uri uriNormalizeScheme = zzhbVar.zza.normalizeScheme();
        String scheme = uriNormalizeScheme.getScheme();
        zzek.zze(Constants.ScionAnalytics.MessageType.DATA_MESSAGE.equals(scheme), "Unsupported scheme: ".concat(String.valueOf(scheme)));
        String schemeSpecificPart = uriNormalizeScheme.getSchemeSpecificPart();
        int i = zzfy.zza;
        String[] strArrSplit = schemeSpecificPart.split(",", -1);
        if (strArrSplit.length != 2) {
            throw zzcc.zzb("Unexpected URI format: ".concat(String.valueOf(String.valueOf(uriNormalizeScheme))), null);
        }
        String str = strArrSplit[1];
        if (strArrSplit[0].contains(";base64")) {
            try {
                this.zzb = Base64.decode(str, 0);
            } catch (IllegalArgumentException e) {
                throw zzcc.zzb("Error while parsing Base64 encoded string: ".concat(String.valueOf(str)), e);
            }
        } else {
            this.zzb = URLDecoder.decode(str, zzfwq.zza.name()).getBytes(zzfwq.zzc);
        }
        long j = zzhbVar.zzf;
        int length = this.zzb.length;
        if (j > length) {
            this.zzb = null;
            throw new zzgx(2008);
        }
        int i2 = (int) j;
        this.zzc = i2;
        int i3 = length - i2;
        this.zzd = i3;
        long j2 = zzhbVar.zzg;
        if (j2 != -1) {
            this.zzd = (int) Math.min(i3, j2);
        }
        zzj(zzhbVar);
        long j3 = zzhbVar.zzg;
        return j3 != -1 ? j3 : this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final Uri zzc() {
        zzhb zzhbVar = this.zza;
        if (zzhbVar != null) {
            return zzhbVar.zza;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzd() {
        if (this.zzb != null) {
            this.zzb = null;
            zzh();
        }
        this.zza = null;
    }
}
