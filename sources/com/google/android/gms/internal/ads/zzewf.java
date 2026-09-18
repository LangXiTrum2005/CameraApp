package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzewf implements zzexq {
    private final Context zza;
    private final zzgey zzb;
    private final zzfhh zzc;
    private final zzcei zzd;

    zzewf(Context context, zzgey zzgeyVar, zzfhh zzfhhVar, zzcei zzceiVar) {
        this.zza = context;
        this.zzb = zzgeyVar;
        this.zzc = zzfhhVar;
        this.zzd = zzceiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 53;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        return this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzewe
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0042 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:11:0x0044 A[Catch: IOException -> 0x0122, TryCatch #0 {IOException -> 0x0122, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:8:0x0030, B:13:0x0056, B:14:0x007a, B:16:0x008c, B:18:0x00a2, B:20:0x00ab, B:25:0x00d1, B:27:0x00eb, B:28:0x010f, B:30:0x011a, B:23:0x00bf, B:11:0x0044), top: B:35:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:13:0x0056 A[Catch: IOException -> 0x0122, TryCatch #0 {IOException -> 0x0122, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:8:0x0030, B:13:0x0056, B:14:0x007a, B:16:0x008c, B:18:0x00a2, B:20:0x00ab, B:25:0x00d1, B:27:0x00eb, B:28:0x010f, B:30:0x011a, B:23:0x00bf, B:11:0x0044), top: B:35:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x00bd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x00bf A[Catch: IOException -> 0x0122, TryCatch #0 {IOException -> 0x0122, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:8:0x0030, B:13:0x0056, B:14:0x007a, B:16:0x008c, B:18:0x00a2, B:20:0x00ab, B:25:0x00d1, B:27:0x00eb, B:28:0x010f, B:30:0x011a, B:23:0x00bf, B:11:0x0044), top: B:35:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x00d1 A[Catch: IOException -> 0x0122, TryCatch #0 {IOException -> 0x0122, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:8:0x0030, B:13:0x0056, B:14:0x007a, B:16:0x008c, B:18:0x00a2, B:20:0x00ab, B:25:0x00d1, B:27:0x00eb, B:28:0x010f, B:30:0x011a, B:23:0x00bf, B:11:0x0044), top: B:35:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x00eb A[Catch: IOException -> 0x0122, TryCatch #0 {IOException -> 0x0122, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:8:0x0030, B:13:0x0056, B:14:0x007a, B:16:0x008c, B:18:0x00a2, B:20:0x00ab, B:25:0x00d1, B:27:0x00eb, B:28:0x010f, B:30:0x011a, B:23:0x00bf, B:11:0x0044), top: B:35:0x0000 }] */
    final /* synthetic */ zzewg zzc() throws Exception {
        zzfub zzfubVar;
        boolean z;
        boolean zZzp;
        zzfuf zzfufVarZzi;
        try {
            Context context = this.zza;
            boolean zZzb = this.zzc.zzb();
            zzfub zzfubVar2 = new zzfub();
            zzfub zzfubVar3 = new zzfub();
            boolean zZzo = true;
            if (zZzb) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcO)).booleanValue()) {
                    return new zzewg(true);
                }
            }
            if (!zZzb) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcK)).booleanValue()) {
                    zzfubVar2 = zzfue.zzj(context).zzh(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcY)).longValue(), com.google.android.gms.ads.internal.zzt.zzo().zzi().zzQ());
                } else if (zZzb) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcM)).booleanValue()) {
                        zzfubVar2 = zzfue.zzj(context).zzh(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcY)).longValue(), com.google.android.gms.ads.internal.zzt.zzo().zzi().zzQ());
                    }
                }
            } else if (zZzb) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcM)).booleanValue()) {
                    zzfubVar2 = zzfue.zzj(context).zzh(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcY)).longValue(), com.google.android.gms.ads.internal.zzt.zzo().zzi().zzQ());
                }
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcV)).booleanValue()) {
                if (this.zzd.zzc < ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcU)).intValue()) {
                    zzfuf.zzi(context).zzj();
                }
            }
            if (zZzb) {
                if (zZzb) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcN)).booleanValue()) {
                        zzfufVarZzi = zzfuf.zzi(context);
                        if (this.zzd.zzc >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcU)).intValue()) {
                            zzfubVar3 = zzfufVarZzi.zzh(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcZ)).longValue(), com.google.android.gms.ads.internal.zzt.zzo().zzi().zzQ());
                            zZzo = zzfufVarZzi.zzo();
                        }
                        zZzp = zzfufVarZzi.zzp();
                        zzfubVar = zzfubVar3;
                        z = zZzo;
                    }
                }
                zzfubVar = zzfubVar3;
                z = true;
                zZzp = true;
            } else {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcL)).booleanValue()) {
                    zzfufVarZzi = zzfuf.zzi(context);
                    if (this.zzd.zzc >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcU)).intValue()) {
                        zzfubVar3 = zzfufVarZzi.zzh(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcZ)).longValue(), com.google.android.gms.ads.internal.zzt.zzo().zzi().zzQ());
                        zZzo = zzfufVarZzi.zzo();
                    }
                    zZzp = zzfufVarZzi.zzp();
                    zzfubVar = zzfubVar3;
                    z = zZzo;
                } else {
                    if (zZzb) {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcN)).booleanValue()) {
                            zzfufVarZzi = zzfuf.zzi(context);
                            if (this.zzd.zzc >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcU)).intValue()) {
                                zzfubVar3 = zzfufVarZzi.zzh(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcZ)).longValue(), com.google.android.gms.ads.internal.zzt.zzo().zzi().zzQ());
                                zZzo = zzfufVarZzi.zzo();
                            }
                            zZzp = zzfufVarZzi.zzp();
                            zzfubVar = zzfubVar3;
                            z = zZzo;
                        }
                    }
                    zzfubVar = zzfubVar3;
                    z = true;
                    zZzp = true;
                }
            }
            return new zzewg(zzfubVar2, zzfubVar, z, zZzp, zZzb);
        } catch (IOException e) {
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "PerAppIdSignal");
            return new zzewg(this.zzc.zzb());
        }
    }
}
