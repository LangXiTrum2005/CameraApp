package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdua {
    private final zzfid zza;
    private final zzdtx zzb;

    zzdua(zzfid zzfidVar, zzdtx zzdtxVar) {
        this.zza = zzfidVar;
        this.zzb = zzdtxVar;
    }

    final zzbsv zza() throws RemoteException {
        zzbsv zzbsvVarZzb = this.zza.zzb();
        if (zzbsvVarZzb != null) {
            return zzbsvVarZzb;
        }
        zzcec.zzj("Unexpected call to adapter creator.");
        throw new RemoteException();
    }

    public final zzbus zzb(String str) throws RemoteException {
        zzbus zzbusVarZzc = zza().zzc(str);
        this.zzb.zze(str, zzbusVarZzc);
        return zzbusVarZzc;
    }

    public final zzfif zzc(String str, JSONObject jSONObject) throws zzfho {
        zzbsy zzbsyVarZzb;
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                zzbsyVarZzb = new zzbtv(new AdMobAdapter());
            } else if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(str)) {
                zzbsyVarZzb = new zzbtv(new zzbvk());
            } else {
                zzbsv zzbsvVarZza = zza();
                if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                    try {
                        String string = jSONObject.getString("class_name");
                        if (zzbsvVarZza.zze(string)) {
                            zzbsyVarZzb = zzbsvVarZza.zzb("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
                        } else {
                            zzbsyVarZzb = zzbsvVarZza.zzd(string) ? zzbsvVarZza.zzb(string) : zzbsvVarZza.zzb("com.google.ads.mediation.customevent.CustomEventAdapter");
                        }
                    } catch (JSONException e) {
                        zzcec.zzh("Invalid custom event.", e);
                        zzbsyVarZzb = zzbsvVarZza.zzb(str);
                    }
                } else {
                    zzbsyVarZzb = zzbsvVarZza.zzb(str);
                }
            }
            zzfif zzfifVar = new zzfif(zzbsyVarZzb);
            this.zzb.zzd(str, zzfifVar);
            return zzfifVar;
        } catch (Throwable th) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjk)).booleanValue()) {
                this.zzb.zzd(str, null);
            }
            throw new zzfho(th);
        }
    }

    public final boolean zzd() {
        return this.zza.zzb() != null;
    }
}
