package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzebg implements zzece {
    private static final Pattern zza = Pattern.compile("Received error HTTP response code: (.*)");
    private final zzeah zzb;
    private final zzgey zzc;
    private final zzfhh zzd;
    private final ScheduledExecutorService zze;
    private final zzegc zzf;
    private final zzfmz zzg;
    private final Context zzh;

    zzebg(Context context, zzfhh zzfhhVar, zzeah zzeahVar, zzgey zzgeyVar, ScheduledExecutorService scheduledExecutorService, zzegc zzegcVar, zzfmz zzfmzVar) {
        this.zzh = context;
        this.zzd = zzfhhVar;
        this.zzb = zzeahVar;
        this.zzc = zzgeyVar;
        this.zze = scheduledExecutorService;
        this.zzf = zzegcVar;
        this.zzg = zzfmzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzece
    public final ListenableFuture zzb(zzbze zzbzeVar) {
        Context context = this.zzh;
        ListenableFuture listenableFutureZzb = this.zzb.zzb(zzbzeVar);
        zzfmo zzfmoVarZza = zzfmn.zza(context, 11);
        zzfmy.zzd(listenableFutureZzb, zzfmoVarZza);
        ListenableFuture listenableFutureZzn = zzgen.zzn(listenableFutureZzb, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzebd
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzc((InputStream) obj);
            }
        }, this.zzc);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfv)).booleanValue()) {
            listenableFutureZzn = zzgen.zzf(zzgen.zzo(listenableFutureZzn, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfx)).intValue(), TimeUnit.SECONDS, this.zze), TimeoutException.class, new zzgdu() { // from class: com.google.android.gms.internal.ads.zzebe
                @Override // com.google.android.gms.internal.ads.zzgdu
                public final ListenableFuture zza(Object obj) {
                    return zzgen.zzg(new zzead(5));
                }
            }, zzcep.zzf);
        }
        zzfmy.zza(listenableFutureZzn, this.zzg, zzfmoVarZza);
        zzgen.zzr(listenableFutureZzn, new zzebf(this), zzcep.zzf);
        return listenableFutureZzn;
    }

    final /* synthetic */ ListenableFuture zzc(InputStream inputStream) throws Exception {
        return zzgen.zzh(new zzfgy(new zzfgv(this.zzd), zzfgx.zza(new InputStreamReader(inputStream))));
    }
}
