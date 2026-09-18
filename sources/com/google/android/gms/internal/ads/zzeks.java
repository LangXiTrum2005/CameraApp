package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzeks implements zzdkw {
    private final zzfgm zza;
    private final zzbus zzb;
    private final AdFormat zzc;
    private zzdbp zzd = null;

    zzeks(zzfgm zzfgmVar, zzbus zzbusVar, AdFormat adFormat) {
        this.zza = zzfgmVar;
        this.zzb = zzbusVar;
        this.zzc = adFormat;
    }

    @Override // com.google.android.gms.internal.ads.zzdkw
    public final void zza(boolean z, Context context, zzdbk zzdbkVar) throws zzdkv {
        boolean zZzs;
        try {
            AdFormat adFormat = AdFormat.BANNER;
            int iOrdinal = this.zzc.ordinal();
            if (iOrdinal == 1) {
                zZzs = this.zzb.zzs(ObjectWrapper.wrap(context));
            } else {
                if (iOrdinal != 2) {
                    if (iOrdinal == 5) {
                        zZzs = this.zzb.zzr(ObjectWrapper.wrap(context));
                    }
                    throw new zzdkv("Adapter failed to show.");
                }
                zZzs = this.zzb.zzt(ObjectWrapper.wrap(context));
            }
            if (zZzs) {
                if (this.zzd == null) {
                    return;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbw)).booleanValue() || this.zza.zzZ != 2) {
                    return;
                }
                this.zzd.zza();
                return;
            }
            throw new zzdkv("Adapter failed to show.");
        } catch (Throwable th) {
            throw new zzdkv(th);
        }
    }

    public final void zzb(zzdbp zzdbpVar) {
        this.zzd = zzdbpVar;
    }
}
