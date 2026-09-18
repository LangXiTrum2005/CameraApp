package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdyy {
    private final zzdyi zza;
    private final zzdtx zzb;
    private final Object zzc = new Object();
    private final List zzd = new ArrayList();
    private boolean zze;

    zzdyy(zzdyi zzdyiVar, zzdtx zzdtxVar) {
        this.zza = zzdyiVar;
        this.zzb = zzdtxVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd(List list) {
        zzdtw zzdtwVarZza;
        zzdtw zzdtwVarZza2;
        zzbvg zzbvgVar;
        synchronized (this.zzc) {
            if (this.zze) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzbpd zzbpdVar = (zzbpd) it.next();
                String string = (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjj)).booleanValue() || (zzdtwVarZza2 = this.zzb.zza(zzbpdVar.zza)) == null || (zzbvgVar = zzdtwVarZza2.zzc) == null) ? "" : zzbvgVar.toString();
                String str = string;
                boolean z = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjk)).booleanValue() && (zzdtwVarZza = this.zzb.zza(zzbpdVar.zza)) != null && zzdtwVarZza.zzd;
                List list2 = this.zzd;
                String str2 = zzbpdVar.zza;
                list2.add(new zzdyx(str2, str, this.zzb.zzc(str2), zzbpdVar.zzb ? 1 : 0, zzbpdVar.zzd, zzbpdVar.zzc, z));
            }
            this.zze = true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002f A[Catch: all -> 0x003f, LOOP:0: B:13:0x0029->B:15:0x002f, LOOP_END, TryCatch #0 {, blocks: (B:4:0x0008, B:6:0x000c, B:8:0x0014, B:9:0x001e, B:10:0x0021, B:12:0x0023, B:13:0x0029, B:15:0x002f, B:16:0x003d), top: B:21:0x0008 }] */
    public final JSONArray zza() throws JSONException {
        Iterator it;
        JSONArray jSONArray = new JSONArray();
        synchronized (this.zzc) {
            if (this.zze) {
                it = this.zzd.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((zzdyx) it.next()).zza());
                }
            } else if (this.zza.zzt()) {
                zzd(this.zza.zzg());
                it = this.zzd.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((zzdyx) it.next()).zza());
                }
            } else {
                zzc();
            }
        }
        return jSONArray;
    }

    public final void zzc() {
        this.zza.zzs(new zzdyw(this));
    }
}
