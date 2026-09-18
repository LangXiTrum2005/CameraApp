package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdtx {
    private final Map zza = new HashMap();

    zzdtx() {
    }

    @Nullable
    public final synchronized zzdtw zza(String str) {
        return (zzdtw) this.zza.get(str);
    }

    @Nullable
    public final zzdtw zzb(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzdtw zzdtwVarZza = zza((String) it.next());
            if (zzdtwVarZza != null) {
                return zzdtwVarZza;
            }
        }
        return null;
    }

    public final String zzc(String str) {
        zzbvg zzbvgVar;
        zzdtw zzdtwVarZza = zza(str);
        return (zzdtwVarZza == null || (zzbvgVar = zzdtwVarZza.zzb) == null) ? "" : zzbvgVar.toString();
    }

    final synchronized void zzd(String str, @Nullable zzfif zzfifVar) {
        zzbvg zzbvgVarZze;
        if (this.zza.containsKey(str)) {
            return;
        }
        zzbvg zzbvgVarZzf = null;
        if (zzfifVar == null) {
            zzbvgVarZze = null;
        } else {
            try {
                zzbvgVarZze = zzfifVar.zze();
            } catch (zzfho unused) {
                zzbvgVarZze = null;
            }
        }
        if (zzfifVar != null) {
            try {
                zzbvgVarZzf = zzfifVar.zzf();
            } catch (zzfho unused2) {
            }
        }
        boolean z = true;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjk)).booleanValue()) {
            if (zzfifVar == null) {
                z = false;
            } else {
                try {
                    zzfifVar.zzC();
                } catch (zzfho unused3) {
                    z = false;
                }
            }
        }
        this.zza.put(str, new zzdtw(str, zzbvgVarZze, zzbvgVarZzf, z));
    }

    final synchronized void zze(String str, zzbus zzbusVar) {
        if (this.zza.containsKey(str)) {
            return;
        }
        try {
            this.zza.put(str, new zzdtw(str, zzbusVar.zzf(), zzbusVar.zzg(), true));
        } catch (Throwable unused) {
        }
    }
}
