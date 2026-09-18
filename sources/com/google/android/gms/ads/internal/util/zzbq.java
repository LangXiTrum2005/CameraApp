package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.ads.zzapi;
import com.google.android.gms.internal.ads.zzaqd;
import com.google.android.gms.internal.ads.zzarg;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzceb;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzceu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
@ParametersAreNonnullByDefault
public final class zzbq {
    private static zzaqd zzb;
    private static final Object zzc = new Object();

    @Deprecated
    public static final zzbl zza = new zzbi();

    /* JADX WARN: Code duplicated, block: B:14:0x0034 A[Catch: all -> 0x003d, TryCatch #0 {, blocks: (B:7:0x0010, B:9:0x0014, B:11:0x001d, B:13:0x002f, B:15:0x0039, B:14:0x0034, B:16:0x003b), top: B:21:0x0010 }] */
    public zzbq(Context context) {
        zzaqd zzaqdVarZza;
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        synchronized (zzc) {
            if (zzb == null) {
                zzbgc.zza(context);
                if (ClientLibraryUtils.isPackageSide()) {
                    zzaqdVarZza = zzarg.zza(context, null);
                } else {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzer)).booleanValue()) {
                        zzaqdVarZza = zzaz.zzb(context);
                    } else {
                        zzaqdVarZza = zzarg.zza(context, null);
                    }
                }
                zzb = zzaqdVarZza;
            }
        }
    }

    public final ListenableFuture zza(String str) {
        zzceu zzceuVar = new zzceu();
        zzb.zza(new zzbp(str, null, zzceuVar));
        return zzceuVar;
    }

    public final ListenableFuture zzb(int i, String str, Map map, byte[] bArr) {
        zzbn zzbnVar = new zzbn(null);
        zzbj zzbjVar = new zzbj(this, str, zzbnVar);
        zzceb zzcebVar = new zzceb(null);
        zzbk zzbkVar = new zzbk(this, i, str, zzbnVar, zzbjVar, bArr, map, zzcebVar);
        if (zzceb.zzk()) {
            try {
                zzcebVar.zzd(str, "GET", zzbkVar.zzl(), zzbkVar.zzx());
            } catch (zzapi e) {
                zzcec.zzj(e.getMessage());
            }
        }
        zzb.zza(zzbkVar);
        return zzbnVar;
    }
}
