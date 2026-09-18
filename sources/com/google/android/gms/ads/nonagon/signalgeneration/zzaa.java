package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzbz;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzavi;
import com.google.android.gms.internal.ads.zzavj;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbhh;
import com.google.android.gms.internal.ads.zzbht;
import com.google.android.gms.internal.ads.zzbxi;
import com.google.android.gms.internal.ads.zzbxr;
import com.google.android.gms.internal.ads.zzccq;
import com.google.android.gms.internal.ads.zzccs;
import com.google.android.gms.internal.ads.zzccx;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzcei;
import com.google.android.gms.internal.ads.zzcep;
import com.google.android.gms.internal.ads.zzclg;
import com.google.android.gms.internal.ads.zzdaf;
import com.google.android.gms.internal.ads.zzdgm;
import com.google.android.gms.internal.ads.zzdrz;
import com.google.android.gms.internal.ads.zzdwa;
import com.google.android.gms.internal.ads.zzdwk;
import com.google.android.gms.internal.ads.zzfhf;
import com.google.android.gms.internal.ads.zzfhl;
import com.google.android.gms.internal.ads.zzfig;
import com.google.android.gms.internal.ads.zzfmn;
import com.google.android.gms.internal.ads.zzfmo;
import com.google.android.gms.internal.ads.zzfmz;
import com.google.android.gms.internal.ads.zzfnc;
import com.google.android.gms.internal.ads.zzfny;
import com.google.android.gms.internal.ads.zzfws;
import com.google.android.gms.internal.ads.zzfxt;
import com.google.android.gms.internal.ads.zzgdt;
import com.google.android.gms.internal.ads.zzgdu;
import com.google.android.gms.internal.ads.zzgee;
import com.google.android.gms.internal.ads.zzgen;
import com.google.android.gms.internal.ads.zzgey;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzaa extends zzccs {
    protected static final List zza = new ArrayList(Arrays.asList("/aclk", "/pcs/click", "/dbm/clk"));
    protected static final List zzb = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com"));
    protected static final List zzc = new ArrayList(Arrays.asList("/pagead/adview", "/pcs/view", "/pagead/conversion", "/dbm/ad"));
    protected static final List zzd = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"));
    public static final /* synthetic */ int zze = 0;
    private final zzcei zzB;
    private String zzC;
    private final List zzE;
    private final List zzF;
    private final List zzG;
    private final List zzH;
    private final zzbhh zzL;
    private final zzclg zzf;
    private Context zzg;
    private final zzavi zzh;
    private final zzfhl zzi;
    private final zzfig zzj;
    private final zzgey zzl;
    private final ScheduledExecutorService zzm;
    private zzbxr zzn;
    private final zzc zzr;
    private final zzdwk zzs;
    private final zzfny zzt;
    private zzdwa zzk = null;
    private Point zzo = new Point();
    private Point zzp = new Point();
    private final Set zzq = Collections.newSetFromMap(new WeakHashMap());
    private final AtomicInteger zzA = new AtomicInteger(0);
    private final AtomicBoolean zzI = new AtomicBoolean(false);
    private final AtomicBoolean zzJ = new AtomicBoolean(false);
    private final AtomicInteger zzK = new AtomicInteger(0);
    private final boolean zzu = ((Boolean) zzba.zzc().zza(zzbgc.zzhl)).booleanValue();
    private final boolean zzv = ((Boolean) zzba.zzc().zza(zzbgc.zzhk)).booleanValue();
    private final boolean zzw = ((Boolean) zzba.zzc().zza(zzbgc.zzhn)).booleanValue();
    private final boolean zzx = ((Boolean) zzba.zzc().zza(zzbgc.zzhp)).booleanValue();
    private final String zzy = (String) zzba.zzc().zza(zzbgc.zzho);
    private final String zzz = (String) zzba.zzc().zza(zzbgc.zzhq);
    private final String zzD = (String) zzba.zzc().zza(zzbgc.zzhr);

    public zzaa(zzclg zzclgVar, Context context, zzavi zzaviVar, zzfig zzfigVar, zzgey zzgeyVar, ScheduledExecutorService scheduledExecutorService, zzdwk zzdwkVar, zzfny zzfnyVar, zzcei zzceiVar, zzbhh zzbhhVar, zzfhl zzfhlVar) {
        List listZzad;
        this.zzf = zzclgVar;
        this.zzg = context;
        this.zzh = zzaviVar;
        this.zzi = zzfhlVar;
        this.zzj = zzfigVar;
        this.zzl = zzgeyVar;
        this.zzm = scheduledExecutorService;
        this.zzr = zzclgVar.zzn();
        this.zzs = zzdwkVar;
        this.zzt = zzfnyVar;
        this.zzB = zzceiVar;
        this.zzL = zzbhhVar;
        if (((Boolean) zzba.zzc().zza(zzbgc.zzhs)).booleanValue()) {
            this.zzE = zzad((String) zzba.zzc().zza(zzbgc.zzht));
            this.zzF = zzad((String) zzba.zzc().zza(zzbgc.zzhu));
            this.zzG = zzad((String) zzba.zzc().zza(zzbgc.zzhv));
            listZzad = zzad((String) zzba.zzc().zza(zzbgc.zzhw));
        } else {
            this.zzE = zza;
            this.zzF = zzb;
            this.zzG = zzc;
            listZzad = zzd;
        }
        this.zzH = listZzad;
    }

    static /* bridge */ /* synthetic */ void zzI(zzaa zzaaVar, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (zzaaVar.zzR((Uri) it.next())) {
                zzaaVar.zzA.getAndIncrement();
                return;
            }
        }
    }

    static /* bridge */ /* synthetic */ void zzK(final zzaa zzaaVar, final String str, final String str2, final zzdwa zzdwaVar) {
        if (((Boolean) zzba.zzc().zza(zzbgc.zzgX)).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbgc.zzhd)).booleanValue()) {
                zzcep.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzk
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzM(str, str2, zzdwaVar);
                    }
                });
            } else {
                zzaaVar.zzr.zzd(str, str2, zzdwaVar);
            }
        }
    }

    static final /* synthetic */ Uri zzT(Uri uri, String str) {
        return !TextUtils.isEmpty(str) ? zzac(uri, "nas", str) : uri;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:34:0x0083  */
    private final zzh zzU(Context context, String str, String str2, com.google.android.gms.ads.internal.client.zzq zzqVar, com.google.android.gms.ads.internal.client.zzl zzlVar) {
        byte b;
        zzfhf zzfhfVar = new zzfhf();
        if ("REWARDED".equals(str2)) {
            zzfhfVar.zzo().zza(2);
        } else if ("REWARDED_INTERSTITIAL".equals(str2)) {
            zzfhfVar.zzo().zza(3);
        }
        zzg zzgVarZzo = this.zzf.zzo();
        zzdaf zzdafVar = new zzdaf();
        zzdafVar.zze(context);
        if (str == null) {
            str = "adUnitId";
        }
        zzfhfVar.zzs(str);
        if (zzlVar == null) {
            zzlVar = new com.google.android.gms.ads.internal.client.zzm().zza();
        }
        zzfhfVar.zzE(zzlVar);
        if (zzqVar == null) {
            switch (str2) {
                case "NATIVE":
                    b = 3;
                    break;
                case "APP_OPEN_AD":
                    b = 4;
                    break;
                case "REWARDED":
                    b = 1;
                    break;
                case "REWARDED_INTERSTITIAL":
                    b = 2;
                    break;
                case "BANNER":
                    b = 0;
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                zzqVar = new com.google.android.gms.ads.internal.client.zzq(context, AdSize.BANNER);
            } else if (b == 1 || b == 2) {
                zzqVar = com.google.android.gms.ads.internal.client.zzq.zzd();
            } else if (b != 3) {
                zzqVar = b != 4 ? new com.google.android.gms.ads.internal.client.zzq() : com.google.android.gms.ads.internal.client.zzq.zzb();
            } else {
                zzqVar = com.google.android.gms.ads.internal.client.zzq.zzc();
            }
        }
        zzfhfVar.zzr(zzqVar);
        zzfhfVar.zzx(true);
        zzdafVar.zzi(zzfhfVar.zzG());
        zzgVarZzo.zza(zzdafVar.zzj());
        zzac zzacVar = new zzac();
        zzacVar.zza(str2);
        zzgVarZzo.zzb(new zzae(zzacVar, null));
        new zzdgm();
        zzh zzhVarZzc = zzgVarZzo.zzc();
        this.zzk = zzhVarZzc.zza();
        return zzhVarZzc;
    }

    private final ListenableFuture zzV(final String str) {
        final zzdrz[] zzdrzVarArr = new zzdrz[1];
        ListenableFuture listenableFutureZzn = zzgen.zzn(this.zzj.zza(), new zzgdu() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzl
            @Override // com.google.android.gms.internal.ads.zzgdu
            public final ListenableFuture zza(Object obj) {
                return this.zza.zzw(zzdrzVarArr, str, (zzdrz) obj);
            }
        }, this.zzl);
        listenableFutureZzn.addListener(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzm
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzL(zzdrzVarArr);
            }
        }, this.zzl);
        return zzgen.zze(zzgen.zzm((zzgee) zzgen.zzo(zzgee.zzu(listenableFutureZzn), ((Integer) zzba.zzc().zza(zzbgc.zzhE)).intValue(), TimeUnit.MILLISECONDS, this.zzm), new zzfws() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzs
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                int i = zzaa.zze;
                return ((JSONObject) obj).optString("nas");
            }
        }, this.zzl), Exception.class, new zzfws() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzt
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                int i = zzaa.zze;
                zzcec.zzh("", (Exception) obj);
                return null;
            }
        }, this.zzl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzW() {
        zzgen.zzr(((Boolean) zzba.zzc().zza(zzbgc.zzkB)).booleanValue() ? zzgen.zzk(new zzgdt() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzi
            @Override // com.google.android.gms.internal.ads.zzgdt
            public final ListenableFuture zza() {
                return this.zza.zzv();
            }
        }, zzcep.zza) : zzU(this.zzg, null, AdFormat.BANNER.name(), null, null).zzc(), new zzz(this), this.zzf.zzB());
    }

    private final void zzX() {
        if (((Boolean) zzba.zzc().zza(zzbgc.zzjp)).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbgc.zzjs)).booleanValue()) {
                return;
            }
            if (((Boolean) zzba.zzc().zza(zzbgc.zzjw)).booleanValue() && this.zzI.getAndSet(true)) {
                return;
            }
            zzW();
        }
    }

    private final void zzY(List list, final IObjectWrapper iObjectWrapper, zzbxi zzbxiVar, boolean z) {
        ListenableFuture listenableFutureZzb;
        if (!((Boolean) zzba.zzc().zza(zzbgc.zzhD)).booleanValue()) {
            zzcec.zzj("The updating URL feature is not enabled.");
            try {
                zzbxiVar.zze("The updating URL feature is not enabled.");
                return;
            } catch (RemoteException e) {
                zzcec.zzh("", e);
                return;
            }
        }
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (zzR((Uri) it.next())) {
                i++;
            }
        }
        if (i > 1) {
            zzcec.zzj("Multiple google urls found: ".concat(String.valueOf(String.valueOf(list))));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            final Uri uri = (Uri) it2.next();
            if (zzR(uri)) {
                listenableFutureZzb = this.zzl.zzb(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzn
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.zza.zzn(uri, iObjectWrapper);
                    }
                });
                if (zzab()) {
                    listenableFutureZzb = zzgen.zzn(listenableFutureZzb, new zzgdu() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzo
                        @Override // com.google.android.gms.internal.ads.zzgdu
                        public final ListenableFuture zza(Object obj) {
                            zzaa zzaaVar = this.zza;
                            return zzgen.zzm(zzaaVar.zzV("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new zzfws() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzp
                                @Override // com.google.android.gms.internal.ads.zzfws
                                public final Object apply(Object obj2) {
                                    return zzaa.zzT(uri, (String) obj2);
                                }
                            }, zzaaVar.zzl);
                        }
                    }, this.zzl);
                } else {
                    zzcec.zzi("Asset view map is empty.");
                }
            } else {
                zzcec.zzj("Not a Google URL: ".concat(String.valueOf(String.valueOf(uri))));
                listenableFutureZzb = zzgen.zzh(uri);
            }
            arrayList.add(listenableFutureZzb);
        }
        zzgen.zzr(zzgen.zzd(arrayList), new zzy(this, zzbxiVar, z), this.zzf.zzB());
    }

    private final void zzZ(final List list, final IObjectWrapper iObjectWrapper, zzbxi zzbxiVar, boolean z) {
        if (!((Boolean) zzba.zzc().zza(zzbgc.zzhD)).booleanValue()) {
            try {
                zzbxiVar.zze("The updating URL feature is not enabled.");
                return;
            } catch (RemoteException e) {
                zzcec.zzh("", e);
                return;
            }
        }
        ListenableFuture listenableFutureZzb = this.zzl.zzb(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzu
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzD(list, iObjectWrapper);
            }
        });
        if (zzab()) {
            listenableFutureZzb = zzgen.zzn(listenableFutureZzb, new zzgdu() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzv
                @Override // com.google.android.gms.internal.ads.zzgdu
                public final ListenableFuture zza(Object obj) {
                    return this.zza.zzx((ArrayList) obj);
                }
            }, this.zzl);
        } else {
            zzcec.zzi("Asset view map is empty.");
        }
        zzgen.zzr(listenableFutureZzb, new zzx(this, zzbxiVar, z), this.zzf.zzB());
    }

    private static boolean zzaa(Uri uri, List list, List list2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (host != null && path != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (path.contains((String) it.next())) {
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        if (host.endsWith((String) it2.next())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private final boolean zzab() {
        Map map;
        zzbxr zzbxrVar = this.zzn;
        return (zzbxrVar == null || (map = zzbxrVar.zzb) == null || map.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri zzac(Uri uri, String str, String str2) {
        String string = uri.toString();
        int iIndexOf = string.indexOf("&adurl=");
        if (iIndexOf == -1) {
            iIndexOf = string.indexOf("?adurl=");
        }
        if (iIndexOf == -1) {
            return uri.buildUpon().appendQueryParameter(str, str2).build();
        }
        int i = iIndexOf + 1;
        return Uri.parse(string.substring(0, i) + str + "=" + str2 + "&" + string.substring(i));
    }

    private static final List zzad(String str) {
        String[] strArrSplit = TextUtils.split(str, ",");
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArrSplit) {
            if (!zzfxt.zzd(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    static /* bridge */ /* synthetic */ zzfmz zzs(ListenableFuture listenableFuture, zzccx zzccxVar) {
        if (!zzfnc.zza() || !((Boolean) zzbht.zze.zze()).booleanValue()) {
            return null;
        }
        try {
            zzfmz zzfmzVarZzb = ((zzh) zzgen.zzp(listenableFuture)).zzb();
            zzfmzVarZzb.zzd(new ArrayList(Collections.singletonList(zzccxVar.zzb)));
            com.google.android.gms.ads.internal.client.zzl zzlVar = zzccxVar.zzd;
            zzfmzVarZzb.zzb(zzlVar == null ? "" : zzlVar.zzp);
            return zzfmzVarZzb;
        } catch (ExecutionException e) {
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "SignalGeneratorImpl.getConfiguredCriticalUserJourney");
            return null;
        }
    }

    final /* synthetic */ ArrayList zzC(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (!zzS(uri) || TextUtils.isEmpty(str)) {
                arrayList.add(uri);
            } else {
                arrayList.add(zzac(uri, "nas", str));
            }
        }
        return arrayList;
    }

    final /* synthetic */ ArrayList zzD(List list, IObjectWrapper iObjectWrapper) throws Exception {
        this.zzh.zzc();
        String strZzh = this.zzh.zzc().zzh(this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), null);
        if (TextUtils.isEmpty(strZzh)) {
            throw new Exception("Failed to get view signals.");
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (zzS(uri)) {
                arrayList.add(zzac(uri, "ms", strZzh));
            } else {
                zzcec.zzj("Not a Google URL: ".concat(String.valueOf(String.valueOf(uri))));
                arrayList.add(uri);
            }
        }
        if (arrayList.isEmpty()) {
            throw new Exception("Empty impression URLs result.");
        }
        return arrayList;
    }

    final /* synthetic */ void zzL(zzdrz[] zzdrzVarArr) {
        zzdrz zzdrzVar = zzdrzVarArr[0];
        if (zzdrzVar != null) {
            this.zzj.zzb(zzgen.zzh(zzdrzVar));
        }
    }

    final /* synthetic */ void zzM(String str, String str2, zzdwa zzdwaVar) {
        this.zzr.zzd(str, str2, zzdwaVar);
    }

    final boolean zzR(Uri uri) {
        return zzaa(uri, this.zzE, this.zzF);
    }

    final boolean zzS(Uri uri) {
        return zzaa(uri, this.zzG, this.zzH);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final IObjectWrapper zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) {
        if (!((Boolean) zzba.zzc().zza(zzbgc.zzjz)).booleanValue()) {
            return ObjectWrapper.wrap(null);
        }
        this.zzL.zzg((Context) ObjectWrapper.unwrap(iObjectWrapper), (CustomTabsClient) ObjectWrapper.unwrap(iObjectWrapper2), str, (CustomTabsCallback) ObjectWrapper.unwrap(iObjectWrapper3));
        return ObjectWrapper.wrap(this.zzL.zzb());
    }

    /* JADX WARN: Code duplicated, block: B:10:0x006b  */
    /* JADX WARN: Code duplicated, block: B:12:0x007d  */
    /* JADX WARN: Code duplicated, block: B:14:0x0093  */
    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzf(IObjectWrapper iObjectWrapper, final zzccx zzccxVar, zzccq zzccqVar) {
        ListenableFuture listenableFutureZzc;
        ListenableFuture listenableFuture;
        ListenableFuture listenableFutureZzb;
        ListenableFuture listenableFutureZzn;
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        this.zzg = context;
        zzfmo zzfmoVarZza = zzfmn.zza(context, 22);
        zzfmoVarZza.zzh();
        if ("UNKNOWN".equals(zzccxVar.zzb)) {
            List arrayList = new ArrayList();
            if (!((String) zzba.zzc().zza(zzbgc.zzhC)).isEmpty()) {
                arrayList = Arrays.asList(((String) zzba.zzc().zza(zzbgc.zzhC)).split(","));
            }
            if (arrayList.contains(zzf.zzb(zzccxVar.zzd))) {
                listenableFutureZzb = zzgen.zzg(new IllegalArgumentException("Unknown format is no longer supported."));
                listenableFutureZzn = zzgen.zzg(new IllegalArgumentException("Unknown format is no longer supported."));
            } else {
                if (((Boolean) zzba.zzc().zza(zzbgc.zzkB)).booleanValue()) {
                    listenableFutureZzb = zzcep.zza.zzb(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzq
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return this.zza.zzr(zzccxVar);
                        }
                    });
                    listenableFutureZzn = zzgen.zzn(listenableFutureZzb, new zzgdu() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzr
                        @Override // com.google.android.gms.internal.ads.zzgdu
                        public final ListenableFuture zza(Object obj) {
                            return ((zzh) obj).zzc();
                        }
                    }, zzcep.zza);
                } else {
                    zzh zzhVarZzU = zzU(this.zzg, zzccxVar.zza, zzccxVar.zzb, zzccxVar.zzc, zzccxVar.zzd);
                    ListenableFuture listenableFutureZzh = zzgen.zzh(zzhVarZzU);
                    listenableFutureZzc = zzhVarZzU.zzc();
                    listenableFuture = listenableFutureZzh;
                }
            }
            listenableFuture = listenableFutureZzb;
            listenableFutureZzc = listenableFutureZzn;
        } else {
            if (((Boolean) zzba.zzc().zza(zzbgc.zzkB)).booleanValue()) {
                listenableFutureZzb = zzcep.zza.zzb(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzq
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.zza.zzr(zzccxVar);
                    }
                });
                listenableFutureZzn = zzgen.zzn(listenableFutureZzb, new zzgdu() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzr
                    @Override // com.google.android.gms.internal.ads.zzgdu
                    public final ListenableFuture zza(Object obj) {
                        return ((zzh) obj).zzc();
                    }
                }, zzcep.zza);
                listenableFuture = listenableFutureZzb;
                listenableFutureZzc = listenableFutureZzn;
            } else {
                zzh zzhVarZzU2 = zzU(this.zzg, zzccxVar.zza, zzccxVar.zzb, zzccxVar.zzc, zzccxVar.zzd);
                ListenableFuture listenableFutureZzh2 = zzgen.zzh(zzhVarZzU2);
                listenableFutureZzc = zzhVarZzU2.zzc();
                listenableFuture = listenableFutureZzh2;
            }
        }
        zzgen.zzr(listenableFutureZzc, new zzw(this, listenableFuture, zzccxVar, zzccqVar, zzfmoVarZza, com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()), this.zzf.zzB());
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzg(zzbxr zzbxrVar) {
        this.zzn = zzbxrVar;
        this.zzj.zzc(1);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbxi zzbxiVar) {
        zzY(list, iObjectWrapper, zzbxiVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzi(List list, IObjectWrapper iObjectWrapper, zzbxi zzbxiVar) {
        zzZ(list, iObjectWrapper, zzbxiVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzj(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzba.zzc().zza(zzbgc.zzjo)).booleanValue()) {
            if (!((Boolean) zzba.zzc().zza(zzbgc.zzhB)).booleanValue()) {
                zzX();
            }
            WebView webView = (WebView) ObjectWrapper.unwrap(iObjectWrapper);
            if (webView == null) {
                zzcec.zzg("The webView cannot be null.");
                return;
            }
            if (this.zzq.contains(webView)) {
                zzcec.zzi("This webview has already been registered.");
                return;
            }
            this.zzq.add(webView);
            webView.addJavascriptInterface(new TaggingLibraryJsInterface(webView, this.zzh, this.zzs, this.zzt, this.zzi), "gmaSdk");
            if (((Boolean) zzba.zzc().zza(zzbgc.zzjy)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.zzo().zzs();
            }
            if (((Boolean) zzba.zzc().zza(zzbgc.zzhB)).booleanValue()) {
                zzX();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzk(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzba.zzc().zza(zzbgc.zzhD)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper);
            zzbxr zzbxrVar = this.zzn;
            this.zzo = zzbz.zza(motionEvent, zzbxrVar == null ? null : zzbxrVar.zza);
            if (motionEvent.getAction() == 0) {
                this.zzp = this.zzo;
            }
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            motionEventObtain.setLocation(this.zzo.x, this.zzo.y);
            this.zzh.zzd(motionEventObtain);
            motionEventObtain.recycle();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbxi zzbxiVar) {
        zzY(list, iObjectWrapper, zzbxiVar, false);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzm(List list, IObjectWrapper iObjectWrapper, zzbxi zzbxiVar) {
        zzZ(list, iObjectWrapper, zzbxiVar, false);
    }

    final /* synthetic */ Uri zzn(Uri uri, IObjectWrapper iObjectWrapper) throws Exception {
        zzfhl zzfhlVar;
        try {
            uri = (!((Boolean) zzba.zzc().zza(zzbgc.zzlr)).booleanValue() || (zzfhlVar = this.zzi) == null) ? this.zzh.zza(uri, this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), null) : zzfhlVar.zza(uri, this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), null);
        } catch (zzavj e) {
            zzcec.zzk("", e);
        }
        if (uri.getQueryParameter("ms") != null) {
            return uri;
        }
        throw new Exception("Failed to append spam signals to click url.");
    }

    final /* synthetic */ zzh zzr(zzccx zzccxVar) throws Exception {
        return zzU(this.zzg, zzccxVar.zza, zzccxVar.zzb, zzccxVar.zzc, zzccxVar.zzd);
    }

    final /* synthetic */ ListenableFuture zzv() throws Exception {
        return zzU(this.zzg, null, AdFormat.BANNER.name(), null, null).zzc();
    }

    final /* synthetic */ ListenableFuture zzw(zzdrz[] zzdrzVarArr, String str, zzdrz zzdrzVar) throws Exception {
        zzdrzVarArr[0] = zzdrzVar;
        Context context = this.zzg;
        zzbxr zzbxrVar = this.zzn;
        Map map = zzbxrVar.zzb;
        JSONObject jSONObjectZzd = zzbz.zzd(context, map, map, zzbxrVar.zza, null);
        JSONObject jSONObjectZzg = zzbz.zzg(this.zzg, this.zzn.zza);
        JSONObject jSONObjectZzf = zzbz.zzf(this.zzn.zza);
        JSONObject jSONObjectZze = zzbz.zze(this.zzg, this.zzn.zza);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("asset_view_signal", jSONObjectZzd);
        jSONObject.put("ad_view_signal", jSONObjectZzg);
        jSONObject.put("scroll_view_signal", jSONObjectZzf);
        jSONObject.put("lock_screen_signal", jSONObjectZze);
        if ("google.afma.nativeAds.getPublisherCustomRenderedClickSignals".equals(str)) {
            jSONObject.put("click_signal", zzbz.zzc(null, this.zzg, this.zzp, this.zzo));
        }
        return zzdrzVar.zzd(str, jSONObject);
    }

    final /* synthetic */ ListenableFuture zzx(final ArrayList arrayList) throws Exception {
        return zzgen.zzm(zzV("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzfws() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzj
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                return this.zza.zzC(arrayList, (String) obj);
            }
        }, this.zzl);
    }
}
