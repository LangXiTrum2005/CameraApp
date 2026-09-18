package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public final class zzbrx {
    static final com.google.android.gms.ads.internal.util.zzbd zza = new zzbrv();
    static final com.google.android.gms.ads.internal.util.zzbd zzb = new zzbrw();
    private final zzbrj zzc;

    public zzbrx(Context context, zzcei zzceiVar, String str, @Nullable zzfnc zzfncVar) {
        this.zzc = new zzbrj(context, zzceiVar, str, zza, zzb, zzfncVar);
    }

    public final zzbrn zza(String str, zzbrq zzbrqVar, zzbrp zzbrpVar) {
        return new zzbsb(this.zzc, str, zzbrqVar, zzbrpVar);
    }

    public final zzbsg zzb() {
        return new zzbsg(this.zzc);
    }
}
