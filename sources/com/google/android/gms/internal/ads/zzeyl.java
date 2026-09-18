package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeyl implements zzexq {
    private final Context zza;
    private final ScheduledExecutorService zzb;
    private final Executor zzc;
    private final int zzd;
    private final boolean zze;
    private final boolean zzf;
    private final zzcdc zzg;

    zzeyl(zzcdc zzcdcVar, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor, int i, boolean z, boolean z2) {
        this.zzg = zzcdcVar;
        this.zza = context;
        this.zzb = scheduledExecutorService;
        this.zzc = executor;
        this.zzd = i;
        this.zze = z;
        this.zzf = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 40;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaU)).booleanValue()) {
            return zzgen.zzg(new Exception("Did not ad Ad ID into query param."));
        }
        return zzgen.zze((zzgee) zzgen.zzo(zzgen.zzm(zzgee.zzu(this.zzg.zza(this.zza, this.zzd)), new zzfws() { // from class: com.google.android.gms.internal.ads.zzeyj
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                return this.zza.zzc((AdvertisingIdClient.Info) obj);
            }
        }, this.zzc), ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaV)).longValue(), TimeUnit.MILLISECONDS, this.zzb), Throwable.class, new zzfws() { // from class: com.google.android.gms.internal.ads.zzeyk
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                return this.zza.zzd((Throwable) obj);
            }
        }, this.zzc);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0031 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:6:0x001b  */
    /* JADX WARN: Code duplicated, block: B:8:0x001f  */
    final /* synthetic */ zzeym zzc(AdvertisingIdClient.Info info) {
        zzfub zzfubVar = new zzfub();
        if (!this.zze) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcR)).booleanValue()) {
                zzfubVar = zzfue.zzj(this.zza).zzi((String) Objects.requireNonNull(((AdvertisingIdClient.Info) Objects.requireNonNull(info)).getId()), this.zza.getPackageName(), ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcY)).longValue(), this.zzf);
            } else if (this.zze) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcS)).booleanValue()) {
                    try {
                        zzfubVar = zzfue.zzj(this.zza).zzi((String) Objects.requireNonNull(((AdvertisingIdClient.Info) Objects.requireNonNull(info)).getId()), this.zza.getPackageName(), ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcY)).longValue(), this.zzf);
                    } catch (IOException | IllegalArgumentException e) {
                        com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "AdIdInfoSignalSource.getPaidV1");
                        zzfubVar = new zzfub();
                    }
                }
            }
        } else if (this.zze) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcS)).booleanValue()) {
                zzfubVar = zzfue.zzj(this.zza).zzi((String) Objects.requireNonNull(((AdvertisingIdClient.Info) Objects.requireNonNull(info)).getId()), this.zza.getPackageName(), ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcY)).longValue(), this.zzf);
            }
        }
        return new zzeym(info, null, zzfubVar);
    }

    final /* synthetic */ zzeym zzd(Throwable th) {
        com.google.android.gms.ads.internal.client.zzay.zzb();
        ContentResolver contentResolver = this.zza.getContentResolver();
        return new zzeym(null, contentResolver == null ? null : Settings.Secure.getString(contentResolver, "android_id"), new zzfub());
    }
}
