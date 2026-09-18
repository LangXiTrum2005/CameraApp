package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzebb {
    private final ScheduledExecutorService zza;
    private final zzgey zzb;
    private final zzgey zzc;
    private final zzebs zzd;
    private final zzhgx zze;

    public zzebb(ScheduledExecutorService scheduledExecutorService, zzgey zzgeyVar, zzgey zzgeyVar2, zzebs zzebsVar, zzhgx zzhgxVar) {
        this.zza = scheduledExecutorService;
        this.zzb = zzgeyVar;
        this.zzc = zzgeyVar2;
        this.zzd = zzebsVar;
        this.zze = zzhgxVar;
    }

    final /* synthetic */ ListenableFuture zza(zzbze zzbzeVar, int i, Throwable th) throws Exception {
        return ((zzeem) this.zze.zzb()).zzd(zzbzeVar, i);
    }

    public final ListenableFuture zzb(final zzbze zzbzeVar) {
        ListenableFuture listenableFutureZzb;
        String str = zzbzeVar.zzd;
        com.google.android.gms.ads.internal.zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzt.zzB(str)) {
            listenableFutureZzb = zzgen.zzg(new zzecf(1));
        } else {
            listenableFutureZzb = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhA)).booleanValue() ? this.zzc.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeaz
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzc(zzbzeVar);
                }
            }) : this.zzd.zzb(zzbzeVar);
        }
        final int callingUid = Binder.getCallingUid();
        return zzgen.zzf((zzgee) zzgen.zzo(zzgee.zzu(listenableFutureZzb), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfx)).intValue(), TimeUnit.SECONDS, this.zza), Throwable.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzeba
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return this.zza.zza(zzbzeVar, callingUid, (Throwable) obj);
            }
        }, this.zzb);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ InputStream zzc(zzbze zzbzeVar) throws Exception {
        return (InputStream) this.zzd.zzb(zzbzeVar).get(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfx)).intValue(), TimeUnit.SECONDS);
    }
}
