package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcpv extends com.google.android.gms.ads.internal.client.zzcn {
    private final Context zza;
    private final zzcei zzb;
    private final zzdua zzc;
    private final zzeip zzd;
    private final zzepa zze;
    private final zzdyi zzf;
    private final zzcch zzg;
    private final zzduf zzh;
    private final zzdzd zzi;
    private final zzbiu zzj;
    private final zzfnc zzk;
    private final zzfid zzl;
    private final zzbgd zzm;
    private boolean zzn = false;

    zzcpv(Context context, zzcei zzceiVar, zzdua zzduaVar, zzeip zzeipVar, zzepa zzepaVar, zzdyi zzdyiVar, zzcch zzcchVar, zzduf zzdufVar, zzdzd zzdzdVar, zzbiu zzbiuVar, zzfnc zzfncVar, zzfid zzfidVar, zzbgd zzbgdVar) {
        this.zza = context;
        this.zzb = zzceiVar;
        this.zzc = zzduaVar;
        this.zzd = zzeipVar;
        this.zze = zzepaVar;
        this.zzf = zzdyiVar;
        this.zzg = zzcchVar;
        this.zzh = zzdufVar;
        this.zzi = zzdzdVar;
        this.zzj = zzbiuVar;
        this.zzk = zzfncVar;
        this.zzl = zzfidVar;
        this.zzm = zzbgdVar;
    }

    final void zzb() {
        if (com.google.android.gms.ads.internal.zzt.zzo().zzi().zzP()) {
            String strZzl = com.google.android.gms.ads.internal.zzt.zzo().zzi().zzl();
            if (com.google.android.gms.ads.internal.zzt.zzs().zzj(this.zza, strZzl, this.zzb.zza)) {
                return;
            }
            com.google.android.gms.ads.internal.zzt.zzo().zzi().zzB(false);
            com.google.android.gms.ads.internal.zzt.zzo().zzi().zzA("");
        }
    }

    final void zzc(Runnable runnable) {
        Preconditions.checkMainThread("Adapters must be initialized on the main thread.");
        Map mapZze = com.google.android.gms.ads.internal.zzt.zzo().zzi().zzh().zze();
        if (mapZze.isEmpty()) {
            return;
        }
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                zzcec.zzk("Could not initialize rewarded ads.", th);
                return;
            }
        }
        if (this.zzc.zzd()) {
            HashMap map = new HashMap();
            Iterator it = mapZze.values().iterator();
            while (it.hasNext()) {
                for (zzbso zzbsoVar : ((zzbsp) it.next()).zza) {
                    String str = zzbsoVar.zzk;
                    for (String str2 : zzbsoVar.zzc) {
                        if (!map.containsKey(str2)) {
                            map.put(str2, new ArrayList());
                        }
                        if (str != null) {
                            ((List) map.get(str2)).add(str);
                        }
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : map.entrySet()) {
                String str3 = (String) entry.getKey();
                try {
                    zzeiq zzeiqVarZza = this.zzd.zza(str3, jSONObject);
                    if (zzeiqVarZza != null) {
                        zzfif zzfifVar = (zzfif) zzeiqVarZza.zzb;
                        if (!zzfifVar.zzC() && zzfifVar.zzB()) {
                            zzfifVar.zzj(this.zza, (zzekk) zzeiqVarZza.zzc, (List) entry.getValue());
                            zzcec.zze("Initialized rewarded video mediation adapter " + str3);
                        }
                    }
                } catch (zzfho e) {
                    zzcec.zzk("Failed to initialize rewarded video mediation adapter \"" + str3 + "\"", e);
                }
            }
        }
    }

    final /* synthetic */ void zzd() {
        zzfim.zzb(this.zza, true);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final synchronized float zze() {
        return com.google.android.gms.ads.internal.zzt.zzr().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final String zzf() {
        return this.zzb.zza;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final List zzg() throws RemoteException {
        return this.zzf.zzg();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzh(String str) {
        this.zze.zzg(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzi() {
        this.zzf.zzl();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final synchronized void zzk() {
        if (this.zzn) {
            zzcec.zzj("Mobile ads is initialized already.");
            return;
        }
        zzbgc.zza(this.zza);
        this.zzm.zza();
        com.google.android.gms.ads.internal.zzt.zzo().zzu(this.zza, this.zzb);
        com.google.android.gms.ads.internal.zzt.zzc().zzi(this.zza);
        this.zzn = true;
        this.zzf.zzr();
        this.zze.zze();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdT)).booleanValue()) {
            this.zzh.zzc();
        }
        this.zzi.zzg();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjc)).booleanValue()) {
            zzcep.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcpq
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzb();
                }
            });
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkt)).booleanValue()) {
            zzcep.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcps
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzw();
                }
            });
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcG)).booleanValue()) {
            zzcep.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcpr
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzd();
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzl(String str, IObjectWrapper iObjectWrapper) {
        String strZzp;
        Runnable runnable;
        zzbgc.zza(this.zza);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdX)).booleanValue()) {
            try {
                com.google.android.gms.ads.internal.zzt.zzp();
                strZzp = com.google.android.gms.ads.internal.util.zzt.zzp(this.zza);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "NonagonMobileAdsSettingManager_AppId");
                strZzp = "";
            }
        } else {
            strZzp = "";
        }
        boolean z = true;
        String str2 = true == TextUtils.isEmpty(strZzp) ? str : strZzp;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdR)).booleanValue() | ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaQ)).booleanValue();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaQ)).booleanValue()) {
            final Runnable runnable2 = (Runnable) ObjectWrapper.unwrap(iObjectWrapper);
            runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzcpt
                @Override // java.lang.Runnable
                public final void run() {
                    zzgey zzgeyVar = zzcep.zze;
                    final zzcpv zzcpvVar = this.zza;
                    final Runnable runnable3 = runnable2;
                    zzgeyVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcpu
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzcpvVar.zzc(runnable3);
                        }
                    });
                }
            };
        } else {
            runnable = null;
            z = zBooleanValue;
        }
        Runnable runnable3 = runnable;
        if (z) {
            com.google.android.gms.ads.internal.zzt.zza().zza(this.zza, this.zzb, str2, runnable3, this.zzk);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzm(com.google.android.gms.ads.internal.client.zzda zzdaVar) throws RemoteException {
        this.zzi.zzh(zzdaVar, zzdzc.API);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzn(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzcec.zzg("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (context == null) {
            zzcec.zzg("Context is null. Failed to open debug menu.");
            return;
        }
        com.google.android.gms.ads.internal.util.zzau zzauVar = new com.google.android.gms.ads.internal.util.zzau(context);
        zzauVar.zzn(str);
        zzauVar.zzo(this.zzb.zza);
        zzauVar.zzr();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzo(zzbsv zzbsvVar) throws RemoteException {
        this.zzl.zzf(zzbsvVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final synchronized void zzp(boolean z) {
        com.google.android.gms.ads.internal.zzt.zzr().zzc(z);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final synchronized void zzq(float f) {
        com.google.android.gms.ads.internal.zzt.zzr().zzd(f);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final synchronized void zzr(String str) {
        zzbgc.zza(this.zza);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdR)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.zza().zza(this.zza, this.zzb, str, null, this.zzk);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzs(zzbpk zzbpkVar) throws RemoteException {
        this.zzf.zzs(zzbpkVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzt(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjn)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzo().zzy(str);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzu(com.google.android.gms.ads.internal.client.zzff zzffVar) throws RemoteException {
        this.zzg.zzn(this.zza, zzffVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final synchronized boolean zzv() {
        return com.google.android.gms.ads.internal.zzt.zzr().zze();
    }

    final /* synthetic */ void zzw() {
        this.zzj.zza(new zzbyb());
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzj(boolean z) throws RemoteException {
        try {
            zzfuf.zzi(this.zza).zzn(z);
        } catch (IOException e) {
            throw new RemoteException(e.getMessage());
        }
    }
}
