package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.MobileAds;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdvo implements zzdfp, com.google.android.gms.ads.internal.client.zza, zzdbr, zzdbb {
    private final Context zza;
    private final zzfhz zzb;
    private final zzdwf zzc;
    private final zzfgy zzd;
    private final zzfgm zze;
    private final zzehh zzf;
    private Boolean zzg;
    private final boolean zzh = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgR)).booleanValue();

    public zzdvo(Context context, zzfhz zzfhzVar, zzdwf zzdwfVar, zzfgy zzfgyVar, zzfgm zzfgmVar, zzehh zzehhVar) {
        this.zza = context;
        this.zzb = zzfhzVar;
        this.zzc = zzdwfVar;
        this.zzd = zzfgyVar;
        this.zze = zzfgmVar;
        this.zzf = zzehhVar;
    }

    private final zzdwe zzd(String str) {
        zzdwe zzdweVarZza = this.zzc.zza();
        zzdweVarZza.zze(this.zzd.zzb.zzb);
        zzdweVarZza.zzd(this.zze);
        zzdweVarZza.zzb("action", str);
        if (!this.zze.zzu.isEmpty()) {
            zzdweVarZza.zzb("ancn", (String) this.zze.zzu.get(0));
        }
        if (this.zze.zzaj) {
            zzdweVarZza.zzb("device_connectivity", true != com.google.android.gms.ads.internal.zzt.zzo().zzz(this.zza) ? "offline" : CustomTabsCallback.ONLINE_EXTRAS_KEY);
            zzdweVarZza.zzb("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()));
            zzdweVarZza.zzb("offline_ad", "1");
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzha)).booleanValue()) {
            boolean z = com.google.android.gms.ads.nonagon.signalgeneration.zzf.zze(this.zzd.zza.zza) != 1;
            zzdweVarZza.zzb("scar", String.valueOf(z));
            if (z) {
                com.google.android.gms.ads.internal.client.zzl zzlVar = this.zzd.zza.zza.zzd;
                zzdweVarZza.zzc("ragent", zzlVar.zzp);
                zzdweVarZza.zzc("rtype", com.google.android.gms.ads.nonagon.signalgeneration.zzf.zza(com.google.android.gms.ads.nonagon.signalgeneration.zzf.zzb(zzlVar)));
            }
        }
        return zzdweVarZza;
    }

    private final void zze(zzdwe zzdweVar) {
        if (!this.zze.zzaj) {
            zzdweVar.zzg();
            return;
        }
        this.zzf.zzd(new zzehj(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis(), this.zzd.zzb.zzb.zzb, zzdweVar.zzf(), 2));
    }

    private final boolean zzf() {
        String strZzp;
        if (this.zzg == null) {
            synchronized (this) {
                if (this.zzg == null) {
                    String str = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbt);
                    com.google.android.gms.ads.internal.zzt.zzp();
                    try {
                        strZzp = com.google.android.gms.ads.internal.util.zzt.zzp(this.zza);
                    } catch (RemoteException unused) {
                        strZzp = null;
                    }
                    boolean zMatches = false;
                    if (str != null && strZzp != null) {
                        try {
                            zMatches = Pattern.matches(str, strZzp);
                        } catch (RuntimeException e) {
                            com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "CsiActionsListener.isPatternMatched");
                        }
                    }
                    this.zzg = Boolean.valueOf(zMatches);
                }
            }
        }
        return this.zzg.booleanValue();
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        if (this.zze.zzaj) {
            zze(zzd("click"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbb
    public final void zza(com.google.android.gms.ads.internal.client.zze zzeVar) {
        com.google.android.gms.ads.internal.client.zze zzeVar2;
        if (this.zzh) {
            zzdwe zzdweVarZzd = zzd("ifts");
            zzdweVarZzd.zzb("reason", "adapter");
            int i = zzeVar.zza;
            String str = zzeVar.zzb;
            if (zzeVar.zzc.equals(MobileAds.ERROR_DOMAIN) && (zzeVar2 = zzeVar.zzd) != null && !zzeVar2.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                com.google.android.gms.ads.internal.client.zze zzeVar3 = zzeVar.zzd;
                i = zzeVar3.zza;
                str = zzeVar3.zzb;
            }
            if (i >= 0) {
                zzdweVarZzd.zzb("arec", String.valueOf(i));
            }
            String strZza = this.zzb.zza(str);
            if (strZza != null) {
                zzdweVarZzd.zzb("areec", strZza);
            }
            zzdweVarZzd.zzg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbb
    public final void zzb() {
        if (this.zzh) {
            zzdwe zzdweVarZzd = zzd("ifts");
            zzdweVarZzd.zzb("reason", "blocked");
            zzdweVarZzd.zzg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbb
    public final void zzc(zzdkv zzdkvVar) {
        if (this.zzh) {
            zzdwe zzdweVarZzd = zzd("ifts");
            zzdweVarZzd.zzb("reason", "exception");
            if (!TextUtils.isEmpty(zzdkvVar.getMessage())) {
                zzdweVarZzd.zzb(NotificationCompat.CATEGORY_MESSAGE, zzdkvVar.getMessage());
            }
            zzdweVarZzd.zzg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfp
    public final void zzi() {
        if (zzf()) {
            zzd("adapter_shown").zzg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfp
    public final void zzj() {
        if (zzf()) {
            zzd("adapter_impression").zzg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbr
    public final void zzq() {
        if (zzf() || this.zze.zzaj) {
            zze(zzd("impression"));
        }
    }
}
