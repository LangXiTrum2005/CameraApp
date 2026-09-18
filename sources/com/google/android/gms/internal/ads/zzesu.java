package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzesu implements zzexq {
    final zzcdl zza;
    AppSetIdClient zzb;
    private final ScheduledExecutorService zzc;
    private final zzgey zzd;
    private final Context zze;

    zzesu(Context context, zzcdl zzcdlVar, ScheduledExecutorService scheduledExecutorService, zzgey zzgeyVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcG)).booleanValue()) {
            this.zzb = AppSet.getClient(context);
        }
        this.zze = context;
        this.zza = zzcdlVar;
        this.zzc = scheduledExecutorService;
        this.zzd = zzgeyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 11;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcC)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcH)).booleanValue()) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcD)).booleanValue()) {
                    return zzgen.zzm(zzfui.zza(this.zzb.getAppSetIdInfo(), null), new zzfws() { // from class: com.google.android.gms.internal.ads.zzesr
                        @Override // com.google.android.gms.internal.ads.zzfws
                        public final Object apply(Object obj) {
                            AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
                            return new zzesv(appSetIdInfo.getId(), appSetIdInfo.getScope());
                        }
                    }, zzcep.zzf);
                }
                Task<AppSetIdInfo> taskZza = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcG)).booleanValue() ? zzfim.zza(this.zze) : this.zzb.getAppSetIdInfo();
                if (taskZza == null) {
                    return zzgen.zzh(new zzesv(null, -1));
                }
                ListenableFuture listenableFutureZzn = zzgen.zzn(zzfui.zza(taskZza, null), new zzgdu() { // from class: com.google.android.gms.internal.ads.zzess
                    @Override // com.google.android.gms.internal.ads.zzgdu
                    public final ListenableFuture zza(Object obj) {
                        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
                        return appSetIdInfo == null ? zzgen.zzh(new zzesv(null, -1)) : zzgen.zzh(new zzesv(appSetIdInfo.getId(), appSetIdInfo.getScope()));
                    }
                }, zzcep.zzf);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcE)).booleanValue()) {
                    listenableFutureZzn = zzgen.zzo(listenableFutureZzn, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcF)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
                }
                return zzgen.zze(listenableFutureZzn, Exception.class, new zzfws() { // from class: com.google.android.gms.internal.ads.zzest
                    @Override // com.google.android.gms.internal.ads.zzfws
                    public final Object apply(Object obj) {
                        this.zza.zza.zzw((Exception) obj, "AppSetIdInfoSignal");
                        return new zzesv(null, -1);
                    }
                }, this.zzd);
            }
        }
        return zzgen.zzh(new zzesv(null, -1));
    }
}
