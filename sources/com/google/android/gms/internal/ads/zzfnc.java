package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.RemoteException;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfnc implements Runnable {
    public static Boolean zzb;
    private final Context zze;
    private final zzcei zzf;
    private int zzi;
    private final zzdtx zzj;
    private final List zzk;
    private final zzefb zzm;
    private final zzbzq zzn;
    public static final Object zza = new Object();
    private static final Object zzc = new Object();
    private static final Object zzd = new Object();
    private final zzfnh zzg = zzfnk.zzc();
    private String zzh = "";
    private boolean zzl = false;

    public zzfnc(Context context, zzcei zzceiVar, zzdtx zzdtxVar, zzefb zzefbVar, zzbzq zzbzqVar) {
        this.zze = context;
        this.zzf = zzceiVar;
        this.zzj = zzdtxVar;
        this.zzm = zzefbVar;
        this.zzn = zzbzqVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziJ)).booleanValue()) {
            this.zzk = com.google.android.gms.ads.internal.util.zzt.zzd();
        } else {
            this.zzk = zzgaa.zzl();
        }
    }

    public static boolean zza() {
        boolean zBooleanValue;
        synchronized (zza) {
            if (zzb == null) {
                if (((Boolean) zzbht.zzb.zze()).booleanValue()) {
                    zzb = Boolean.valueOf(Math.random() < ((Double) zzbht.zza.zze()).doubleValue());
                } else {
                    zzb = false;
                }
            }
            zBooleanValue = zzb.booleanValue();
        }
        return zBooleanValue;
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte[] bArrZzax;
        if (zza()) {
            Object obj = zzc;
            synchronized (obj) {
                if (this.zzg.zza() == 0) {
                    return;
                }
                try {
                    synchronized (obj) {
                        bArrZzax = ((zzfnk) this.zzg.zzal()).zzax();
                        this.zzg.zzc();
                    }
                    new zzefa(this.zze, this.zzf.zza, this.zzn, Binder.getCallingUid()).zza(new zzeey((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziD), 60000, new HashMap(), bArrZzax, "application/x-protobuf", false));
                } catch (Exception e) {
                    if ((e instanceof zzead) && ((zzead) e).zza() == 3) {
                        return;
                    }
                    com.google.android.gms.ads.internal.zzt.zzo().zzv(e, "CuiMonitor.sendCuiPing");
                }
            }
        }
    }

    public final void zzb(final zzfms zzfmsVar) {
        zzcep.zza.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfnb
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzc(zzfmsVar);
            }
        });
    }

    final /* synthetic */ void zzc(zzfms zzfmsVar) {
        synchronized (zzd) {
            if (!this.zzl) {
                this.zzl = true;
                if (zza()) {
                    try {
                        com.google.android.gms.ads.internal.zzt.zzp();
                        this.zzh = com.google.android.gms.ads.internal.util.zzt.zzp(this.zze);
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "CuiMonitor.gettingAppIdFromManifest");
                    }
                    this.zzi = GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zze);
                    int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziE)).intValue();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlk)).booleanValue()) {
                        long j = iIntValue;
                        zzcep.zzd.scheduleWithFixedDelay(this, j, j, TimeUnit.MILLISECONDS);
                    } else {
                        long j2 = iIntValue;
                        zzcep.zzd.scheduleAtFixedRate(this, j2, j2, TimeUnit.MILLISECONDS);
                    }
                }
            }
        }
        if (zza() && zzfmsVar != null) {
            synchronized (zzc) {
                if (this.zzg.zza() >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziF)).intValue()) {
                    return;
                }
                zzfne zzfneVarZza = zzfnf.zza();
                zzfneVarZza.zzt(zzfmsVar.zzl());
                zzfneVarZza.zzp(zzfmsVar.zzk());
                zzfneVarZza.zzg(zzfmsVar.zzb());
                zzfneVarZza.zzv(3);
                zzfneVarZza.zzm(this.zzf.zza);
                zzfneVarZza.zzb(this.zzh);
                zzfneVarZza.zzk(Build.VERSION.RELEASE);
                zzfneVarZza.zzq(Build.VERSION.SDK_INT);
                zzfneVarZza.zzu(zzfmsVar.zzn());
                zzfneVarZza.zzj(zzfmsVar.zza());
                zzfneVarZza.zze(this.zzi);
                zzfneVarZza.zzs(zzfmsVar.zzm());
                zzfneVarZza.zzc(zzfmsVar.zzd());
                zzfneVarZza.zzf(zzfmsVar.zzf());
                zzfneVarZza.zzh(zzfmsVar.zzg());
                zzfneVarZza.zzi(this.zzj.zzc(zzfmsVar.zzg()));
                zzfneVarZza.zzl(zzfmsVar.zzh());
                zzfneVarZza.zzd(zzfmsVar.zze());
                zzfneVarZza.zzr(zzfmsVar.zzj());
                zzfneVarZza.zzn(zzfmsVar.zzi());
                zzfneVarZza.zzo(zzfmsVar.zzc());
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziJ)).booleanValue()) {
                    zzfneVarZza.zza(this.zzk);
                }
                zzfnh zzfnhVar = this.zzg;
                zzfni zzfniVarZza = zzfnj.zza();
                zzfniVarZza.zza(zzfneVarZza);
                zzfnhVar.zzb(zzfniVarZza);
            }
        }
    }
}
