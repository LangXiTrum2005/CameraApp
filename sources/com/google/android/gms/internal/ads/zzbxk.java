package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbxk {
    private static zzcct zza;
    private final Context zzb;
    private final AdFormat zzc;
    private final com.google.android.gms.ads.internal.client.zzdx zzd;
    private final String zze;

    public zzbxk(Context context, AdFormat adFormat, com.google.android.gms.ads.internal.client.zzdx zzdxVar, String str) {
        this.zzb = context;
        this.zzc = adFormat;
        this.zzd = zzdxVar;
        this.zze = str;
    }

    public static zzcct zza(Context context) {
        zzcct zzcctVar;
        synchronized (zzbxk.class) {
            if (zza == null) {
                zza = com.google.android.gms.ads.internal.client.zzay.zza().zzr(context, new zzbsr());
            }
            zzcctVar = zza;
        }
        return zzcctVar;
    }

    public final void zzb(QueryInfoGenerationCallback queryInfoGenerationCallback) {
        com.google.android.gms.ads.internal.client.zzl zzlVarZza;
        zzcct zzcctVarZza = zza(this.zzb);
        if (zzcctVarZza == null) {
            queryInfoGenerationCallback.onFailure("Internal Error, query info generator is null.");
            return;
        }
        Context context = this.zzb;
        com.google.android.gms.ads.internal.client.zzdx zzdxVar = this.zzd;
        IObjectWrapper iObjectWrapperWrap = ObjectWrapper.wrap(context);
        if (zzdxVar == null) {
            zzlVarZza = new com.google.android.gms.ads.internal.client.zzm().zza();
        } else {
            zzlVarZza = com.google.android.gms.ads.internal.client.zzp.zza.zza(this.zzb, zzdxVar);
        }
        try {
            zzcctVarZza.zzf(iObjectWrapperWrap, new zzccx(this.zze, this.zzc.name(), null, zzlVarZza), new zzbxj(this, queryInfoGenerationCallback));
        } catch (RemoteException unused) {
            queryInfoGenerationCallback.onFailure("Internal Error.");
        }
    }
}
