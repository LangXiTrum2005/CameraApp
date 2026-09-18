package com.google.android.gms.internal.ads;

import android.util.Base64;
import com.bumptech.glide.load.Key;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfhw {
    public zzfhw() {
        try {
            zzghg.zza();
        } catch (GeneralSecurityException e) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed to Configure Aead. ".concat(e.toString()));
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "CryptoUtils.registerAead");
        }
    }

    public static final String zza() {
        zzgyi zzgyiVarZzt = zzgyl.zzt();
        try {
            zzgfv.zzb(zzggm.zzc(zzggf.zza(zzgoa.zzb().zza("AES128_GCM"))), zzgfu.zzb(zzgyiVarZzt));
        } catch (IOException | GeneralSecurityException e) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed to generate key".concat(e.toString()));
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "CryptoUtils.generateKey");
        }
        String strEncodeToString = Base64.encodeToString(zzgyiVarZzt.zzb().zzA(), 11);
        zzgyiVarZzt.zzc();
        return strEncodeToString;
    }

    @Nullable
    public static final String zzb(byte[] bArr, byte[] bArr2, String str, zzdwa zzdwaVar) {
        zzggm zzggmVarZzc = zzc(str);
        if (zzggmVarZzc == null) {
            return null;
        }
        try {
            byte[] bArrZza = ((zzgfs) zzggmVarZzc.zze(zzgpb.zza(), zzgfs.class)).zza(bArr, bArr2);
            zzdwaVar.zza().put("ds", "1");
            return new String(bArrZza, Key.STRING_CHARSET_NAME);
        } catch (UnsupportedEncodingException | UnsupportedOperationException | GeneralSecurityException e) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed to decrypt ".concat(e.toString()));
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "CryptoUtils.decrypt");
            zzdwaVar.zza().put("dsf", e.toString());
            return null;
        }
    }

    @Nullable
    private static final zzggm zzc(String str) {
        try {
            return zzgfv.zza(zzgft.zzb(Base64.decode(str, 11)));
        } catch (IOException | GeneralSecurityException e) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed to get keysethandle".concat(e.toString()));
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "CryptoUtils.getHandle");
            return null;
        }
    }
}
