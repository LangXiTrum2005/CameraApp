package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbht;
import com.google.android.gms.internal.ads.zzccq;
import com.google.android.gms.internal.ads.zzccx;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzdwa;
import com.google.android.gms.internal.ads.zzdwk;
import com.google.android.gms.internal.ads.zzfmo;
import com.google.android.gms.internal.ads.zzfmz;
import com.google.android.gms.internal.ads.zzgej;
import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzw implements zzgej {
    final /* synthetic */ ListenableFuture zza;
    final /* synthetic */ zzccx zzb;
    final /* synthetic */ zzccq zzc;
    final /* synthetic */ zzfmo zzd;
    final /* synthetic */ long zze;
    final /* synthetic */ zzaa zzf;

    zzw(zzaa zzaaVar, ListenableFuture listenableFuture, zzccx zzccxVar, zzccq zzccqVar, zzfmo zzfmoVar, long j) {
        this.zza = listenableFuture;
        this.zzb = zzccxVar;
        this.zzc = zzccqVar;
        this.zzd = zzfmoVar;
        this.zze = j;
        this.zzf = zzaaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final void zza(Throwable th) {
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() - this.zze;
        String message = th.getMessage();
        com.google.android.gms.ads.internal.zzt.zzo().zzw(th, "SignalGeneratorImpl.generateSignals");
        zzaa zzaaVar = this.zzf;
        zzf.zzc(zzaaVar.zzs, zzaaVar.zzk, "sgf", new Pair("sgf_reason", message), new Pair("tqgt", String.valueOf(jCurrentTimeMillis)));
        zzfmz zzfmzVarZzs = zzaa.zzs(this.zza, this.zzb);
        if (((Boolean) zzbht.zze.zze()).booleanValue() && zzfmzVarZzs != null) {
            zzfmo zzfmoVar = this.zzd;
            zzfmoVar.zzg(th);
            zzfmoVar.zzf(false);
            zzfmzVarZzs.zza(zzfmoVar);
            zzfmzVarZzs.zzg();
        }
        try {
            if (!"Unknown format is no longer supported.".equals(message)) {
                message = "Internal error. " + message;
            }
            this.zzc.zzb(message);
        } catch (RemoteException e) {
            zzcec.zzh("", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgej
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzam zzamVar = (zzam) obj;
        zzfmz zzfmzVarZzs = zzaa.zzs(this.zza, this.zzb);
        this.zzf.zzJ.set(true);
        if (!((Boolean) zzba.zzc().zza(zzbgc.zzhD)).booleanValue()) {
            try {
                this.zzc.zzb("QueryInfo generation has been disabled.");
            } catch (RemoteException e) {
                zzcec.zzg("QueryInfo generation has been disabled.".concat(e.toString()));
            }
            if (!((Boolean) zzbht.zze.zze()).booleanValue() || zzfmzVarZzs == null) {
                return;
            }
            zzfmo zzfmoVar = this.zzd;
            zzfmoVar.zzc("QueryInfo generation has been disabled.");
            zzfmoVar.zzf(false);
            zzfmzVarZzs.zza(zzfmoVar);
            zzfmzVarZzs.zzg();
            return;
        }
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() - this.zze;
        try {
            if (zzamVar == null) {
                this.zzc.zzc(null, null, null);
                zzaa zzaaVar = this.zzf;
                zzf.zzc(zzaaVar.zzs, zzaaVar.zzk, "sgs", new Pair("rid", "-1"));
                this.zzd.zzf(true);
                if (!((Boolean) zzbht.zze.zze()).booleanValue() || zzfmzVarZzs == null) {
                    return;
                }
                zzfmzVarZzs.zza(this.zzd);
                zzfmzVarZzs.zzg();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(zzamVar.zzb);
                String strOptString = jSONObject.optString("request_id", "");
                if (TextUtils.isEmpty(strOptString)) {
                    zzcec.zzj("The request ID is empty in request JSON.");
                    this.zzc.zzb("Internal error: request ID is empty in request JSON.");
                    zzaa zzaaVar2 = this.zzf;
                    zzf.zzc(zzaaVar2.zzs, zzaaVar2.zzk, "sgf", new Pair("sgf_reason", "rid_missing"));
                    zzfmo zzfmoVar2 = this.zzd;
                    zzfmoVar2.zzc("Request ID empty");
                    zzfmoVar2.zzf(false);
                    if (!((Boolean) zzbht.zze.zze()).booleanValue() || zzfmzVarZzs == null) {
                        return;
                    }
                    zzfmzVarZzs.zza(this.zzd);
                    zzfmzVarZzs.zzg();
                    return;
                }
                zzaa zzaaVar3 = this.zzf;
                zzaa.zzK(zzaaVar3, strOptString, zzamVar.zzb, zzaaVar3.zzk);
                Bundle bundle = zzamVar.zzc;
                zzaa zzaaVar4 = this.zzf;
                if (zzaaVar4.zzx && bundle != null && bundle.getInt(zzaaVar4.zzz, -1) == -1) {
                    zzaa zzaaVar5 = this.zzf;
                    bundle.putInt(zzaaVar5.zzz, zzaaVar5.zzA.get());
                }
                zzaa zzaaVar6 = this.zzf;
                if (zzaaVar6.zzw && bundle != null && TextUtils.isEmpty(bundle.getString(zzaaVar6.zzy))) {
                    if (TextUtils.isEmpty(this.zzf.zzC)) {
                        zzaa zzaaVar7 = this.zzf;
                        com.google.android.gms.ads.internal.util.zzt zztVarZzp = com.google.android.gms.ads.internal.zzt.zzp();
                        zzaa zzaaVar8 = this.zzf;
                        zzaaVar7.zzC = zztVarZzp.zzc(zzaaVar8.zzg, zzaaVar8.zzB.zza);
                    }
                    zzaa zzaaVar9 = this.zzf;
                    bundle.putString(zzaaVar9.zzy, zzaaVar9.zzC);
                }
                this.zzc.zzc(zzamVar.zza, zzamVar.zzb, bundle);
                zzaa zzaaVar10 = this.zzf;
                zzdwk zzdwkVar = zzaaVar10.zzs;
                zzdwa zzdwaVar = zzaaVar10.zzk;
                Pair pair = new Pair("tqgt", String.valueOf(jCurrentTimeMillis));
                String str = "na";
                if (((Boolean) zzba.zzc().zza(zzbgc.zzju)).booleanValue()) {
                    try {
                        str = jSONObject.getJSONObject("extras").getBoolean("accept_3p_cookie") ? "1" : "0";
                    } catch (JSONException e2) {
                        zzcec.zzh("Error retrieving JSONObject from the requestJson, ", e2);
                    }
                }
                zzf.zzc(zzdwkVar, zzdwaVar, "sgs", pair, new Pair("tpc", str));
                this.zzd.zzf(true);
                if (!((Boolean) zzbht.zze.zze()).booleanValue() || zzfmzVarZzs == null) {
                    return;
                }
                zzfmzVarZzs.zza(this.zzd);
                zzfmzVarZzs.zzg();
            } catch (JSONException e3) {
                zzcec.zzj("Failed to create JSON object from the request string.");
                this.zzc.zzb("Internal error for request JSON: " + e3.toString());
                zzaa zzaaVar11 = this.zzf;
                zzf.zzc(zzaaVar11.zzs, zzaaVar11.zzk, "sgf", new Pair("sgf_reason", "request_invalid"));
                zzfmo zzfmoVar3 = this.zzd;
                zzfmoVar3.zzg(e3);
                zzfmoVar3.zzf(false);
                com.google.android.gms.ads.internal.zzt.zzo().zzw(e3, "SignalGeneratorImpl.generateSignals.onSuccess");
                if (!((Boolean) zzbht.zze.zze()).booleanValue() || zzfmzVarZzs == null) {
                    return;
                }
                zzfmzVarZzs.zza(this.zzd);
                zzfmzVarZzs.zzg();
            }
        } catch (RemoteException e4) {
            zzfmo zzfmoVar4 = this.zzd;
            zzfmoVar4.zzg(e4);
            zzfmoVar4.zzf(false);
            zzcec.zzh("", e4);
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e4, "SignalGeneratorImpl.generateSignals.onSuccess");
        } finally {
            if (((Boolean) zzbht.zze.zze()).booleanValue() && zzfmzVarZzs != null) {
                zzfmzVarZzs.zza(this.zzd);
                zzfmzVarZzs.zzg();
            }
        }
    }
}
