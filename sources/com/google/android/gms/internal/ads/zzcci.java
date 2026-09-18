package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzcci {
    static zzcci zza;

    public static synchronized zzcci zzd(Context context) {
        zzcci zzcciVar = zza;
        if (zzcciVar != null) {
            return zzcciVar;
        }
        Context applicationContext = context.getApplicationContext();
        zzbgc.zza(applicationContext);
        com.google.android.gms.ads.internal.util.zzg zzgVarZzi = com.google.android.gms.ads.internal.zzt.zzo().zzi();
        zzgVarZzi.zzr(applicationContext);
        zzcca zzccaVar = new zzcca(null);
        zzccaVar.zzb(applicationContext);
        zzccaVar.zzc(com.google.android.gms.ads.internal.zzt.zzB());
        zzccaVar.zza(zzgVarZzi);
        zzccaVar.zzd(com.google.android.gms.ads.internal.zzt.zzn());
        zzcci zzcciVarZze = zzccaVar.zze();
        zza = zzcciVarZze;
        zzcciVarZze.zza().zza();
        zzccm zzccmVarZzc = zza.zzc();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaq)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzp();
            Map mapZzu = com.google.android.gms.ads.internal.util.zzt.zzu((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzas));
            Iterator it = mapZzu.keySet().iterator();
            while (it.hasNext()) {
                zzccmVarZzc.zzc((String) it.next());
            }
            zzccmVarZzc.zzd(new zzcck(zzccmVarZzc, mapZzu));
        }
        return zza;
    }

    abstract zzcbt zza();

    abstract zzcbx zzb();

    abstract zzccm zzc();
}
