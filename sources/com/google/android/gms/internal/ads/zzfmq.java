package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfmq implements zzfmo {
    private final Context zza;
    private final int zzo;
    private long zzb = 0;
    private long zzc = -1;
    private boolean zzd = false;
    private int zzp = 2;
    private int zzq = 2;
    private int zze = 0;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";
    private String zzl = "";
    private boolean zzm = false;
    private boolean zzn = false;

    zzfmq(Context context, int i) {
        this.zza = context;
        this.zzo = i;
    }

    public final synchronized zzfmq zzH(int i) {
        this.zzp = i;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfmo
    public final /* bridge */ /* synthetic */ zzfmo zza(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzq(zzeVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfmo
    public final /* bridge */ /* synthetic */ zzfmo zzb(zzfgx zzfgxVar) {
        zzr(zzfgxVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfmo
    public final /* bridge */ /* synthetic */ zzfmo zzc(String str) {
        zzs(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfmo
    public final /* bridge */ /* synthetic */ zzfmo zzd(String str) {
        zzt(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfmo
    public final /* bridge */ /* synthetic */ zzfmo zze(String str) {
        zzu(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfmo
    public final /* bridge */ /* synthetic */ zzfmo zzf(boolean z) {
        zzv(z);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfmo
    public final /* bridge */ /* synthetic */ zzfmo zzg(Throwable th) {
        zzw(th);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfmo
    public final /* bridge */ /* synthetic */ zzfmo zzh() {
        zzx();
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfmo
    public final /* bridge */ /* synthetic */ zzfmo zzi() {
        zzy();
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfmo
    public final synchronized boolean zzj() {
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzfmo
    public final boolean zzk() {
        return !TextUtils.isEmpty(this.zzh);
    }

    @Override // com.google.android.gms.internal.ads.zzfmo
    public final synchronized zzfms zzl() {
        zzfmr zzfmrVar = null;
        if (this.zzm) {
            return null;
        }
        this.zzm = true;
        if (!this.zzn) {
            zzx();
        }
        if (this.zzc < 0) {
            zzy();
        }
        return new zzfms(this, zzfmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfmo
    public final /* bridge */ /* synthetic */ zzfmo zzm(int i) {
        zzH(i);
        return this;
    }

    public final synchronized zzfmq zzq(com.google.android.gms.ads.internal.client.zze zzeVar) {
        IBinder iBinder = zzeVar.zze;
        if (iBinder != null) {
            zzdaq zzdaqVar = (zzdaq) iBinder;
            String strZzk = zzdaqVar.zzk();
            if (!TextUtils.isEmpty(strZzk)) {
                this.zzf = strZzk;
            }
            String strZzi = zzdaqVar.zzi();
            if (!TextUtils.isEmpty(strZzi)) {
                this.zzg = strZzi;
            }
        }
        return this;
    }

    public final synchronized zzfmq zzr(zzfgx zzfgxVar) {
        if (!TextUtils.isEmpty(zzfgxVar.zzb.zzb)) {
            this.zzf = zzfgxVar.zzb.zzb;
        }
        for (zzfgm zzfgmVar : zzfgxVar.zza) {
            if (!TextUtils.isEmpty(zzfgmVar.zzac)) {
                this.zzg = zzfgmVar.zzac;
                break;
            }
        }
        return this;
    }

    public final synchronized zzfmq zzs(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziI)).booleanValue()) {
            this.zzl = str;
        }
        return this;
    }

    public final synchronized zzfmq zzt(String str) {
        this.zzh = str;
        return this;
    }

    public final synchronized zzfmq zzu(String str) {
        this.zzi = str;
        return this;
    }

    public final synchronized zzfmq zzv(boolean z) {
        this.zzd = z;
        return this;
    }

    public final synchronized zzfmq zzw(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziI)).booleanValue()) {
            this.zzk = zzbxw.zze(th);
            this.zzj = (String) zzfxr.zzc(zzfwp.zzc('\n')).zzd(zzbxw.zzd(th)).iterator().next();
        }
        return this;
    }

    public final synchronized zzfmq zzx() {
        Configuration configuration;
        this.zze = com.google.android.gms.ads.internal.zzt.zzq().zzm(this.zza);
        Resources resources = this.zza.getResources();
        int i = 2;
        if (resources != null && (configuration = resources.getConfiguration()) != null) {
            i = configuration.orientation == 2 ? 4 : 3;
        }
        this.zzq = i;
        this.zzb = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
        this.zzn = true;
        return this;
    }

    public final synchronized zzfmq zzy() {
        this.zzc = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
        return this;
    }
}
