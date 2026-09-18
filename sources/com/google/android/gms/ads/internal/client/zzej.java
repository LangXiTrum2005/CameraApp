package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnAdInspectorClosedListener;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.internal.ads.zzbpd;
import com.google.android.gms.internal.ads.zzbpl;
import com.google.android.gms.internal.ads.zzbpm;
import com.google.android.gms.internal.ads.zzbsn;
import com.google.android.gms.internal.ads.zzbsr;
import com.google.android.gms.internal.ads.zzcdr;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzfxt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzej {
    private static zzej zza;
    private zzco zzg;
    private final Object zzb = new Object();
    private boolean zzd = false;
    private boolean zze = false;
    private final Object zzf = new Object();
    private OnAdInspectorClosedListener zzh = null;
    private RequestConfiguration zzi = new RequestConfiguration.Builder().build();
    private final ArrayList zzc = new ArrayList();

    private zzej() {
    }

    private final void zzA(Context context) {
        if (this.zzg == null) {
            this.zzg = (zzco) new zzaq(zzay.zza(), context).zzd(context, false);
        }
    }

    private final void zzB(RequestConfiguration requestConfiguration) {
        try {
            this.zzg.zzu(new zzff(requestConfiguration));
        } catch (RemoteException e) {
            zzcec.zzh("Unable to set request configuration parcel.", e);
        }
    }

    public static zzej zzf() {
        zzej zzejVar;
        synchronized (zzej.class) {
            if (zza == null) {
                zza = new zzej();
            }
            zzejVar = zza;
        }
        return zzejVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InitializationStatus zzy(List list) {
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzbpd zzbpdVar = (zzbpd) it.next();
            map.put(zzbpdVar.zza, new zzbpl(zzbpdVar.zzb ? AdapterStatus.State.READY : AdapterStatus.State.NOT_READY, zzbpdVar.zzd, zzbpdVar.zzc));
        }
        return new zzbpm(map);
    }

    private final void zzz(Context context, String str) {
        try {
            zzbsn.zza().zzb(context, null);
            this.zzg.zzk();
            this.zzg.zzl(null, ObjectWrapper.wrap(null));
        } catch (RemoteException e) {
            zzcec.zzk("MobileAdsSettingManager initialization failed", e);
        }
    }

    public final RequestConfiguration zzc() {
        return this.zzi;
    }

    public final InitializationStatus zze() {
        InitializationStatus initializationStatusZzy;
        synchronized (this.zzf) {
            Preconditions.checkState(this.zzg != null, "MobileAds.initialize() must be called prior to getting initialization status.");
            try {
                initializationStatusZzy = zzy(this.zzg.zzg());
            } catch (RemoteException unused) {
                zzcec.zzg("Unable to get Initialization status.");
                return new InitializationStatus() { // from class: com.google.android.gms.ads.internal.client.zzeb
                    @Override // com.google.android.gms.ads.initialization.InitializationStatus
                    public final Map getAdapterStatusMap() {
                        HashMap map = new HashMap();
                        map.put("com.google.android.gms.ads.MobileAds", new zzee(this.zza));
                        return map;
                    }
                };
            }
        }
        return initializationStatusZzy;
    }

    public final String zzh() {
        String strZzc;
        synchronized (this.zzf) {
            Preconditions.checkState(this.zzg != null, "MobileAds.initialize() must be called prior to getting version string.");
            try {
                strZzc = zzfxt.zzc(this.zzg.zzf());
            } catch (RemoteException e) {
                zzcec.zzh("Unable to get internal version.", e);
                return "";
            }
        }
        return strZzc;
    }

    public final void zzl(Context context) {
        synchronized (this.zzf) {
            zzA(context);
            try {
                this.zzg.zzi();
            } catch (RemoteException unused) {
                zzcec.zzg("Unable to disable mediation adapter initialization.");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0099 A[Catch: all -> 0x005e, TryCatch #2 {, blocks: (B:24:0x0030, B:26:0x0050, B:34:0x0066, B:36:0x0077, B:38:0x0089, B:45:0x00cc, B:39:0x0099, B:41:0x00a7, B:43:0x00b9, B:44:0x00c4, B:28:0x0058, B:33:0x0061), top: B:54:0x0030, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00a7 A[Catch: all -> 0x005e, TryCatch #2 {, blocks: (B:24:0x0030, B:26:0x0050, B:34:0x0066, B:36:0x0077, B:38:0x0089, B:45:0x00cc, B:39:0x0099, B:41:0x00a7, B:43:0x00b9, B:44:0x00c4, B:28:0x0058, B:33:0x0061), top: B:54:0x0030, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00b9 A[Catch: all -> 0x005e, TryCatch #2 {, blocks: (B:24:0x0030, B:26:0x0050, B:34:0x0066, B:36:0x0077, B:38:0x0089, B:45:0x00cc, B:39:0x0099, B:41:0x00a7, B:43:0x00b9, B:44:0x00c4, B:28:0x0058, B:33:0x0061), top: B:54:0x0030, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00c4 A[Catch: all -> 0x005e, TryCatch #2 {, blocks: (B:24:0x0030, B:26:0x0050, B:34:0x0066, B:36:0x0077, B:38:0x0089, B:45:0x00cc, B:39:0x0099, B:41:0x00a7, B:43:0x00b9, B:44:0x00c4, B:28:0x0058, B:33:0x0061), top: B:54:0x0030, inners: #0 }] */
    public final void zzm(final Context context, String str, OnInitializationCompleteListener onInitializationCompleteListener) {
        synchronized (this.zzb) {
            if (this.zzd) {
                if (onInitializationCompleteListener != null) {
                    this.zzc.add(onInitializationCompleteListener);
                }
                return;
            }
            if (this.zze) {
                if (onInitializationCompleteListener != null) {
                    onInitializationCompleteListener.onInitializationComplete(zze());
                }
                return;
            }
            this.zzd = true;
            if (onInitializationCompleteListener != null) {
                this.zzc.add(onInitializationCompleteListener);
            }
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null.");
            }
            synchronized (this.zzf) {
                zzeh zzehVar = null;
                byte b = 0;
                byte b2 = 0;
                try {
                    zzA(context);
                    this.zzg.zzs(new zzei(this, zzehVar));
                    this.zzg.zzo(new zzbsr());
                    if (this.zzi.getTagForChildDirectedTreatment() != -1 || this.zzi.getTagForUnderAgeOfConsent() != -1) {
                        zzB(this.zzi);
                    }
                } catch (RemoteException e) {
                    zzcec.zzk("MobileAdsSettingManager initialization failed", e);
                }
                zzbgc.zza(context);
                if (((Boolean) zzbhy.zza.zze()).booleanValue()) {
                    if (((Boolean) zzba.zzc().zza(zzbgc.zzkF)).booleanValue()) {
                        zzcec.zze("Initializing on bg thread");
                        ThreadPoolExecutor threadPoolExecutor = zzcdr.zza;
                        final byte b3 = b2 == true ? 1 : 0;
                        threadPoolExecutor.execute(new Runnable(context, b3) { // from class: com.google.android.gms.ads.internal.client.zzec
                            public final /* synthetic */ Context zzb;

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zza.zzn(this.zzb, null);
                            }
                        });
                    } else if (((Boolean) zzbhy.zzb.zze()).booleanValue()) {
                        if (((Boolean) zzba.zzc().zza(zzbgc.zzkF)).booleanValue()) {
                            ExecutorService executorService = zzcdr.zzb;
                            final byte b4 = b == true ? 1 : 0;
                            executorService.execute(new Runnable(context, b4) { // from class: com.google.android.gms.ads.internal.client.zzed
                                public final /* synthetic */ Context zzb;

                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.zza.zzo(this.zzb, null);
                                }
                            });
                        } else {
                            zzcec.zze("Initializing on calling thread");
                            zzz(context, null);
                        }
                    } else {
                        zzcec.zze("Initializing on calling thread");
                        zzz(context, null);
                    }
                } else if (((Boolean) zzbhy.zzb.zze()).booleanValue()) {
                    if (((Boolean) zzba.zzc().zza(zzbgc.zzkF)).booleanValue()) {
                        ExecutorService executorService2 = zzcdr.zzb;
                        final String b5 = b == true ? 1 : 0;
                        executorService2.execute(new Runnable(context, b5) { // from class: com.google.android.gms.ads.internal.client.zzed
                            public final /* synthetic */ Context zzb;

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zza.zzo(this.zzb, null);
                            }
                        });
                    } else {
                        zzcec.zze("Initializing on calling thread");
                        zzz(context, null);
                    }
                } else {
                    zzcec.zze("Initializing on calling thread");
                    zzz(context, null);
                }
            }
        }
    }

    final /* synthetic */ void zzn(Context context, String str) {
        synchronized (this.zzf) {
            zzz(context, null);
        }
    }

    final /* synthetic */ void zzo(Context context, String str) {
        synchronized (this.zzf) {
            zzz(context, null);
        }
    }

    public final void zzp(Context context, OnAdInspectorClosedListener onAdInspectorClosedListener) {
        synchronized (this.zzf) {
            zzA(context);
            this.zzh = onAdInspectorClosedListener;
            try {
                this.zzg.zzm(new zzeg(null));
            } catch (RemoteException unused) {
                zzcec.zzg("Unable to open the ad inspector.");
                if (onAdInspectorClosedListener != null) {
                    onAdInspectorClosedListener.onAdInspectorClosed(new AdInspectorError(0, "Ad inspector had an internal error.", MobileAds.ERROR_DOMAIN));
                }
            }
        }
    }

    public final void zzq(Context context, String str) {
        synchronized (this.zzf) {
            Preconditions.checkState(this.zzg != null, "MobileAds.initialize() must be called prior to opening debug menu.");
            try {
                this.zzg.zzn(ObjectWrapper.wrap(context), str);
            } catch (RemoteException e) {
                zzcec.zzh("Unable to open debug menu.", e);
            }
        }
    }

    public final void zzr(Class cls) {
        synchronized (this.zzf) {
            try {
                this.zzg.zzh(cls.getCanonicalName());
            } catch (RemoteException e) {
                zzcec.zzh("Unable to register RtbAdapter", e);
            }
        }
    }

    public final void zzs(boolean z) {
        synchronized (this.zzf) {
            Preconditions.checkState(this.zzg != null, "MobileAds.initialize() must be called prior to setting app muted state.");
            try {
                this.zzg.zzp(z);
            } catch (RemoteException e) {
                zzcec.zzh("Unable to set app mute state.", e);
            }
        }
    }

    public final void zzt(float f) {
        boolean z = true;
        Preconditions.checkArgument(f >= 0.0f && f <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        synchronized (this.zzf) {
            if (this.zzg == null) {
                z = false;
            }
            Preconditions.checkState(z, "MobileAds.initialize() must be called prior to setting the app volume.");
            try {
                this.zzg.zzq(f);
            } catch (RemoteException e) {
                zzcec.zzh("Unable to set app volume.", e);
            }
        }
    }

    public final void zzu(String str) {
        synchronized (this.zzf) {
            Preconditions.checkState(this.zzg != null, "MobileAds.initialize() must be called prior to setting the plugin.");
            try {
                this.zzg.zzt(str);
            } catch (RemoteException e) {
                zzcec.zzh("Unable to set plugin.", e);
            }
        }
    }

    public final void zzv(RequestConfiguration requestConfiguration) {
        Preconditions.checkArgument(requestConfiguration != null, "Null passed to setRequestConfiguration.");
        synchronized (this.zzf) {
            RequestConfiguration requestConfiguration2 = this.zzi;
            this.zzi = requestConfiguration;
            if (this.zzg == null) {
                return;
            }
            if (requestConfiguration2.getTagForChildDirectedTreatment() != requestConfiguration.getTagForChildDirectedTreatment() || requestConfiguration2.getTagForUnderAgeOfConsent() != requestConfiguration.getTagForUnderAgeOfConsent()) {
                zzB(requestConfiguration);
            }
        }
    }

    public final boolean zzx(boolean z) {
        synchronized (this.zzf) {
            Preconditions.checkState(this.zzg != null, "MobileAds.initialize() must be called prior to enable/disable the publisher first-party ID.");
            try {
                this.zzg.zzj(z);
            } catch (RemoteException e) {
                zzcec.zzh("Unable to " + (z ? "enable" : "disable") + " the publisher first-party ID.", e);
                return false;
            }
        }
        return true;
    }

    public final float zza() {
        synchronized (this.zzf) {
            zzco zzcoVar = this.zzg;
            float fZze = 1.0f;
            if (zzcoVar == null) {
                return 1.0f;
            }
            try {
                fZze = zzcoVar.zze();
            } catch (RemoteException e) {
                zzcec.zzh("Unable to get app volume.", e);
            }
            return fZze;
        }
    }

    public final boolean zzw() {
        synchronized (this.zzf) {
            zzco zzcoVar = this.zzg;
            boolean zZzv = false;
            if (zzcoVar == null) {
                return false;
            }
            try {
                zZzv = zzcoVar.zzv();
            } catch (RemoteException e) {
                zzcec.zzh("Unable to get app mute state.", e);
            }
            return zZzv;
        }
    }
}
