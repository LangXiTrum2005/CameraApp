package com.google.android.gms.internal.ads;

import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfww {
    private final String zza;
    private final zzfwu zzb;
    private zzfwu zzc;

    /* synthetic */ zzfww(String str, zzfwv zzfwvVar) {
        zzfwu zzfwuVar = new zzfwu();
        this.zzb = zzfwuVar;
        this.zzc = zzfwuVar;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzfwu zzfwuVar = this.zzb.zzb;
        String str = "";
        while (zzfwuVar != null) {
            Object obj = zzfwuVar.zza;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String strDeepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
            }
            zzfwuVar = zzfwuVar.zzb;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzfww zza(@CheckForNull Object obj) {
        zzfwu zzfwuVar = new zzfwu();
        this.zzc.zzb = zzfwuVar;
        this.zzc = zzfwuVar;
        zzfwuVar.zza = obj;
        return this;
    }
}
