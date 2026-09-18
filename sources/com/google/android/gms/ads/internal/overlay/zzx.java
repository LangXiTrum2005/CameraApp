package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzcep;
import com.google.android.gms.internal.ads.zzcjk;
import com.google.android.gms.internal.ads.zzfvb;
import com.google.android.gms.internal.ads.zzfvc;
import com.google.android.gms.internal.ads.zzfvd;
import com.google.android.gms.internal.ads.zzfve;
import com.google.android.gms.internal.ads.zzfvn;
import com.google.android.gms.internal.ads.zzfvp;
import com.google.android.gms.internal.ads.zzfvq;
import com.google.android.gms.internal.ads.zzfvr;
import com.google.android.gms.internal.ads.zzfvs;
import com.google.android.gms.internal.ads.zzfwh;
import com.google.firebase.messaging.Constants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzx {
    private zzfvq zzf;
    private zzcjk zzc = null;
    private boolean zze = false;
    private String zza = null;
    private zzfvd zzd = null;
    private String zzb = null;

    private final zzfvs zzl() {
        zzfvr zzfvrVarZzc = zzfvs.zzc();
        if (!((Boolean) zzba.zzc().zza(zzbgc.zzkR)).booleanValue() || TextUtils.isEmpty(this.zzb)) {
            String str = this.zza;
            if (str != null) {
                zzfvrVarZzc.zzb(str);
            } else {
                zzf("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzfvrVarZzc.zza(this.zzb);
        }
        return zzfvrVarZzc.zzc();
    }

    private final void zzm() {
        if (this.zzf == null) {
            this.zzf = new zzw(this);
        }
    }

    public final synchronized void zza(zzcjk zzcjkVar, Context context) {
        this.zzc = zzcjkVar;
        if (!zzk(context)) {
            zzf("Unable to bind", "on_play_store_bind");
            return;
        }
        HashMap map = new HashMap();
        map.put("action", "fetch_completed");
        zze("on_play_store_bind", map);
    }

    public final void zzb() {
        zzfvd zzfvdVar;
        if (!this.zze || (zzfvdVar = this.zzd) == null) {
            com.google.android.gms.ads.internal.util.zze.zza("LastMileDelivery not connected");
        } else {
            zzfvdVar.zza(zzl(), this.zzf);
            zzd("onLMDOverlayCollapse");
        }
    }

    public final void zzc() {
        zzfvd zzfvdVar;
        if (!this.zze || (zzfvdVar = this.zzd) == null) {
            com.google.android.gms.ads.internal.util.zze.zza("LastMileDelivery not connected");
            return;
        }
        zzfvb zzfvbVarZzc = zzfvc.zzc();
        if (!((Boolean) zzba.zzc().zza(zzbgc.zzkR)).booleanValue() || TextUtils.isEmpty(this.zzb)) {
            String str = this.zza;
            if (str != null) {
                zzfvbVarZzc.zzb(str);
            } else {
                zzf("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzfvbVarZzc.zza(this.zzb);
        }
        zzfvdVar.zzb(zzfvbVarZzc.zzc(), this.zzf);
    }

    final void zzd(String str) {
        zze(str, new HashMap());
    }

    final void zze(final String str, final Map map) {
        zzcep.zze.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzv
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzh(str, map);
            }
        });
    }

    final void zzf(String str, String str2) {
        com.google.android.gms.ads.internal.util.zze.zza(str);
        if (this.zzc != null) {
            HashMap map = new HashMap();
            map.put("message", str);
            map.put("action", str2);
            zze("onError", map);
        }
    }

    public final void zzg() {
        zzfvd zzfvdVar;
        if (!this.zze || (zzfvdVar = this.zzd) == null) {
            com.google.android.gms.ads.internal.util.zze.zza("LastMileDelivery not connected");
        } else {
            zzfvdVar.zzc(zzl(), this.zzf);
            zzd("onLMDOverlayExpand");
        }
    }

    final /* synthetic */ void zzh(String str, Map map) {
        zzcjk zzcjkVar = this.zzc;
        if (zzcjkVar != null) {
            zzcjkVar.zzd(str, map);
        }
    }

    final void zzi(zzfvp zzfvpVar) {
        if (!TextUtils.isEmpty(zzfvpVar.zzb())) {
            if (!((Boolean) zzba.zzc().zza(zzbgc.zzkR)).booleanValue()) {
                this.zza = zzfvpVar.zzb();
            }
        }
        switch (zzfvpVar.zza()) {
            case 8152:
                zzd("onLMDOverlayOpened");
                break;
            case 8153:
                zzd("onLMDOverlayClicked");
                break;
            case 8155:
                zzd("onLMDOverlayClose");
                break;
            case 8157:
                this.zza = null;
                this.zzb = null;
                this.zze = false;
                break;
            case 8160:
            case 8161:
            case 8162:
                HashMap map = new HashMap();
                map.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, String.valueOf(zzfvpVar.zza()));
                zze("onLMDOverlayFailedToOpen", map);
                break;
        }
    }

    public final void zzj(zzcjk zzcjkVar, zzfvn zzfvnVar) {
        if (zzcjkVar == null) {
            zzf("adWebview missing", "onLMDShow");
            return;
        }
        this.zzc = zzcjkVar;
        if (!this.zze && !zzk(zzcjkVar.getContext())) {
            zzf("LMDOverlay not bound", "on_play_store_bind");
            return;
        }
        if (((Boolean) zzba.zzc().zza(zzbgc.zzkR)).booleanValue()) {
            this.zzb = zzfvnVar.zzg();
        }
        zzm();
        zzfvd zzfvdVar = this.zzd;
        if (zzfvdVar != null) {
            zzfvdVar.zzd(zzfvnVar, this.zzf);
        }
    }

    public final synchronized boolean zzk(Context context) {
        if (!zzfwh.zza(context)) {
            return false;
        }
        try {
            this.zzd = zzfve.zza(context);
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.util.zze.zza("Error connecting LMD Overlay service");
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "LastMileDeliveryOverlay.bindLastMileDeliveryService");
        }
        if (this.zzd == null) {
            this.zze = false;
            return false;
        }
        zzm();
        this.zze = true;
        return true;
    }
}
