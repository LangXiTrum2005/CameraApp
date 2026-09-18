package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgns {
    public static final zzgrx zza = new zzgnr(null);

    public static zzgsd zza(zzggx zzggxVar) {
        zzgge zzggeVar;
        zzgrz zzgrzVar = new zzgrz();
        zzgrzVar.zzb(zzggxVar.zzb());
        Iterator it = zzggxVar.zzd().iterator();
        while (it.hasNext()) {
            for (zzggt zzggtVar : (List) it.next()) {
                int iZzh = zzggtVar.zzh() - 2;
                if (iZzh == 1) {
                    zzggeVar = zzgge.zza;
                } else if (iZzh == 2) {
                    zzggeVar = zzgge.zzb;
                } else {
                    if (iZzh != 3) {
                        throw new IllegalStateException("Unknown key status");
                    }
                    zzggeVar = zzgge.zzc;
                }
                int iZza = zzggtVar.zza();
                String strZzf = zzggtVar.zzf();
                if (strZzf.startsWith("type.googleapis.com/google.crypto.")) {
                    strZzf = strZzf.substring(34);
                }
                zzgrzVar.zza(zzggeVar, iZza, strZzf, zzggtVar.zzc().name());
            }
        }
        if (zzggxVar.zza() != null) {
            zzgrzVar.zzc(zzggxVar.zza().zza());
        }
        try {
            return zzgrzVar.zzd();
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
