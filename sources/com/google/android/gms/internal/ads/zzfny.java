package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfny {
    private final Context zza;
    private final Executor zzb;
    private final zzceh zzc;
    private final zzfnc zzd;

    zzfny(Context context, Executor executor, zzceh zzcehVar, zzfnc zzfncVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcehVar;
        this.zzd = zzfncVar;
    }

    final /* synthetic */ void zza(String str) {
        this.zzc.zza(str);
    }

    final /* synthetic */ void zzb(String str, zzfmz zzfmzVar) {
        zzfmo zzfmoVarZza = zzfmn.zza(this.zza, 14);
        zzfmoVarZza.zzh();
        zzfmoVarZza.zzf(this.zzc.zza(str));
        if (zzfmzVar == null) {
            this.zzd.zzb(zzfmoVarZza.zzl());
        } else {
            zzfmzVar.zza(zzfmoVarZza);
            zzfmzVar.zzg();
        }
    }

    public final void zzc(final String str, final zzfmz zzfmzVar) {
        if (zzfnc.zza() && ((Boolean) zzbht.zzd.zze()).booleanValue()) {
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfnx
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzb(str, zzfmzVar);
                }
            });
        } else {
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfnw
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zza(str);
                }
            });
        }
    }

    public final void zzd(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzc((String) it.next(), null);
        }
    }
}
