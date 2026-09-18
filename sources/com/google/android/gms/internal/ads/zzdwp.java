package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdwp {
    private final String zze;
    private final zzdwk zzf;
    private final List zzb = new ArrayList();
    private boolean zzc = false;
    private boolean zzd = false;
    private final com.google.android.gms.ads.internal.util.zzg zza = com.google.android.gms.ads.internal.zzt.zzo().zzi();

    public zzdwp(String str, zzdwk zzdwkVar) {
        this.zze = str;
        this.zzf = zzdwkVar;
    }

    private final Map zzg() {
        Map mapZza = this.zzf.zza();
        mapZza.put("tms", Long.toString(com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime(), 10));
        mapZza.put("tid", this.zza.zzQ() ? "" : this.zze);
        return mapZza;
    }

    public final synchronized void zza(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbZ)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziz)).booleanValue()) {
                Map mapZzg = zzg();
                mapZzg.put("action", "aaia");
                mapZzg.put("aair", "MalformedJson");
                this.zzb.add(mapZzg);
            }
        }
    }

    public final synchronized void zzb(String str, String str2) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbZ)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziz)).booleanValue()) {
                Map mapZzg = zzg();
                mapZzg.put("action", "adapter_init_finished");
                mapZzg.put("ancn", str);
                mapZzg.put("rqe", str2);
                this.zzb.add(mapZzg);
            }
        }
    }

    public final synchronized void zzc(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbZ)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziz)).booleanValue()) {
                Map mapZzg = zzg();
                mapZzg.put("action", "adapter_init_started");
                mapZzg.put("ancn", str);
                this.zzb.add(mapZzg);
            }
        }
    }

    public final synchronized void zzd(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbZ)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziz)).booleanValue()) {
                Map mapZzg = zzg();
                mapZzg.put("action", "adapter_init_finished");
                mapZzg.put("ancn", str);
                this.zzb.add(mapZzg);
            }
        }
    }

    public final synchronized void zze() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbZ)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziz)).booleanValue() && !this.zzd) {
                Map mapZzg = zzg();
                mapZzg.put("action", "init_finished");
                this.zzb.add(mapZzg);
                Iterator it = this.zzb.iterator();
                while (it.hasNext()) {
                    this.zzf.zzf((Map) it.next());
                }
                this.zzd = true;
            }
        }
    }

    public final synchronized void zzf() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbZ)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziz)).booleanValue() && !this.zzc) {
                Map mapZzg = zzg();
                mapZzg.put("action", "init_started");
                this.zzb.add(mapZzg);
                this.zzc = true;
            }
        }
    }
}
