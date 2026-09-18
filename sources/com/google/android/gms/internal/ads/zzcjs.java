package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.TrafficStats;
import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.common.util.Predicate;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public class zzcjs extends WebViewClient implements zzcky {
    public static final /* synthetic */ int zzb = 0;
    private boolean zzA;
    private int zzB;
    private boolean zzC;
    private final zzehs zzE;
    private View.OnAttachStateChangeListener zzF;
    protected zzcbs zza;
    private final zzcjk zzc;
    private final zzbbp zzd;
    private com.google.android.gms.ads.internal.client.zza zzg;
    private com.google.android.gms.ads.internal.overlay.zzp zzh;
    private zzckw zzi;
    private zzckx zzj;
    private zzblw zzk;
    private zzbly zzl;
    private zzdiu zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private com.google.android.gms.ads.internal.overlay.zzaa zzv;
    private zzbvv zzw;
    private com.google.android.gms.ads.internal.zzb zzx;
    private boolean zzz;
    private final HashMap zze = new HashMap();
    private final Object zzf = new Object();
    private int zzp = 0;
    private String zzq = "";
    private String zzr = "";
    private zzbvq zzy = null;
    private final HashSet zzD = new HashSet(Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfE)).split(",")));

    public zzcjs(zzcjk zzcjkVar, zzbbp zzbbpVar, boolean z, zzbvv zzbvvVar, zzbvq zzbvqVar, zzehs zzehsVar) {
        this.zzd = zzbbpVar;
        this.zzc = zzcjkVar;
        this.zzs = z;
        this.zzw = zzbvvVar;
        this.zzE = zzehsVar;
    }

    private static WebResourceResponse zzO() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaJ)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    private final WebResourceResponse zzP(String str, Map map) throws IOException {
        URL url = new URL(str);
        try {
            TrafficStats.setThreadStatsTag(264);
            int i = 0;
            while (true) {
                i++;
                if (i > 20) {
                    TrafficStats.clearThreadStatsTag();
                    throw new IOException("Too many redirects (20)");
                }
                URLConnection uRLConnectionOpenConnection = url.openConnection();
                uRLConnectionOpenConnection.setConnectTimeout(10000);
                uRLConnectionOpenConnection.setReadTimeout(10000);
                for (Map.Entry entry : map.entrySet()) {
                    uRLConnectionOpenConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                    throw new IOException("Invalid protocol.");
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                com.google.android.gms.ads.internal.zzt.zzp().zzf(this.zzc.getContext(), this.zzc.zzn().zza, false, httpURLConnection, false, 60000);
                WebResourceResponse webResourceResponseZzb = null;
                zzceb zzcebVar = new zzceb(null);
                zzcebVar.zzc(httpURLConnection, null);
                int responseCode = httpURLConnection.getResponseCode();
                zzcebVar.zze(httpURLConnection, responseCode);
                if (responseCode < 300 || responseCode >= 400) {
                    com.google.android.gms.ads.internal.zzt.zzp();
                    com.google.android.gms.ads.internal.zzt.zzp();
                    String contentType = httpURLConnection.getContentType();
                    String strTrim = "";
                    String strTrim2 = TextUtils.isEmpty(contentType) ? "" : contentType.split(";")[0].trim();
                    com.google.android.gms.ads.internal.zzt.zzp();
                    String contentType2 = httpURLConnection.getContentType();
                    if (!TextUtils.isEmpty(contentType2)) {
                        String[] strArrSplit = contentType2.split(";");
                        if (strArrSplit.length != 1) {
                            for (int i2 = 1; i2 < strArrSplit.length; i2++) {
                                if (strArrSplit[i2].trim().startsWith("charset")) {
                                    String[] strArrSplit2 = strArrSplit[i2].trim().split("=");
                                    if (strArrSplit2.length > 1) {
                                        strTrim = strArrSplit2[1].trim();
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    String str2 = strTrim;
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    HashMap map2 = new HashMap(headerFields.size());
                    for (Map.Entry<String, List<String>> entry2 : headerFields.entrySet()) {
                        if (entry2.getKey() != null && entry2.getValue() != null && !entry2.getValue().isEmpty()) {
                            map2.put(entry2.getKey(), entry2.getValue().get(0));
                        }
                    }
                    webResourceResponseZzb = com.google.android.gms.ads.internal.zzt.zzq().zzb(strTrim2, str2, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), map2, httpURLConnection.getInputStream());
                } else {
                    String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                    if (headerField == null) {
                        throw new IOException("Missing Location header in redirect");
                    }
                    if (!headerField.startsWith("tel:")) {
                        URL url2 = new URL(url, headerField);
                        String protocol = url2.getProtocol();
                        if (protocol == null) {
                            zzcec.zzj("Protocol is null");
                            webResourceResponseZzb = zzO();
                        } else if (protocol.equals("http") || protocol.equals("https")) {
                            zzcec.zze("Redirecting to " + headerField);
                            httpURLConnection.disconnect();
                            url = url2;
                        } else {
                            zzcec.zzj("Unsupported scheme: " + protocol);
                            webResourceResponseZzb = zzO();
                        }
                    }
                }
                TrafficStats.clearThreadStatsTag();
                return webResourceResponseZzb;
            }
        } catch (Throwable th) {
            TrafficStats.clearThreadStatsTag();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzQ(Map map, List list, String str) {
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("Received GMSG: ".concat(str));
            for (String str2 : map.keySet()) {
                com.google.android.gms.ads.internal.util.zze.zza("  " + str2 + ": " + ((String) map.get(str2)));
            }
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((zzbng) it.next()).zza(this.zzc, map);
        }
    }

    private final void zzR() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.zzF;
        if (onAttachStateChangeListener == null) {
            return;
        }
        ((View) this.zzc).removeOnAttachStateChangeListener(onAttachStateChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzS(final View view, final zzcbs zzcbsVar, final int i) {
        if (!zzcbsVar.zzi() || i <= 0) {
            return;
        }
        zzcbsVar.zzg(view);
        if (zzcbsVar.zzi()) {
            com.google.android.gms.ads.internal.util.zzt.zza.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjl
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzp(view, zzcbsVar, i);
                }
            }, 100L);
        }
    }

    private static final boolean zzT(zzcjk zzcjkVar) {
        if (zzcjkVar.zzD() != null) {
            return zzcjkVar.zzD().zzaj;
        }
        return false;
    }

    private static final boolean zzU(boolean z, zzcjk zzcjkVar) {
        return (!z || zzcjkVar.zzO().zzi() || zzcjkVar.zzT().equals("interstitial_mb")) ? false : true;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        com.google.android.gms.ads.internal.client.zza zzaVar = this.zzg;
        if (zzaVar != null) {
            zzaVar.onAdClicked();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        com.google.android.gms.ads.internal.util.zze.zza("Loading resource: ".concat(String.valueOf(str)));
        Uri uri = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uri.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            zzj(uri);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.zzf) {
            if (this.zzc.zzaB()) {
                com.google.android.gms.ads.internal.util.zze.zza("Blank page loaded, 1...");
                this.zzc.zzV();
                return;
            }
            this.zzz = true;
            zzckx zzckxVar = this.zzj;
            if (zzckxVar != null) {
                zzckxVar.zza();
                this.zzj = null;
            }
            zzg();
            if (this.zzc.zzL() != null) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlm)).booleanValue()) {
                    this.zzc.zzL().zzG(str);
                }
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.zzo = true;
        this.zzp = i;
        this.zzq = str;
        this.zzr = str2;
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzc.zzaA(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzc(str, Collections.emptyMap());
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case WorkQueueKt.MASK /* 127 */:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.google.android.gms.ads.internal.util.zze.zza("AdWebView shouldOverrideUrlLoading: ".concat(String.valueOf(str)));
        Uri uriZza = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uriZza.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uriZza.getHost())) {
            zzj(uriZza);
        } else {
            if (this.zzn && webView == this.zzc.zzG()) {
                String scheme = uriZza.getScheme();
                if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    com.google.android.gms.ads.internal.client.zza zzaVar = this.zzg;
                    if (zzaVar != null) {
                        zzaVar.onAdClicked();
                        zzcbs zzcbsVar = this.zza;
                        if (zzcbsVar != null) {
                            zzcbsVar.zzh(str);
                        }
                        this.zzg = null;
                    }
                    zzdiu zzdiuVar = this.zzm;
                    if (zzdiuVar != null) {
                        zzdiuVar.zzs();
                        this.zzm = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (this.zzc.zzG().willNotDraw()) {
                zzcec.zzj("AdWebView unable to handle URL: ".concat(String.valueOf(str)));
            } else {
                try {
                    zzavi zzaviVarZzI = this.zzc.zzI();
                    zzfhl zzfhlVarZzQ = this.zzc.zzQ();
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlr)).booleanValue() || zzfhlVarZzQ == null) {
                        if (zzaviVarZzI != null && zzaviVarZzI.zzf(uriZza)) {
                            Context context = this.zzc.getContext();
                            zzcjk zzcjkVar = this.zzc;
                            uriZza = zzaviVarZzI.zza(uriZza, context, (View) zzcjkVar, zzcjkVar.zzi());
                        }
                    } else if (zzaviVarZzI != null && zzaviVarZzI.zzf(uriZza)) {
                        Context context2 = this.zzc.getContext();
                        zzcjk zzcjkVar2 = this.zzc;
                        uriZza = zzfhlVarZzQ.zza(uriZza, context2, (View) zzcjkVar2, zzcjkVar2.zzi());
                    }
                } catch (zzavj unused) {
                    zzcec.zzj("Unable to append parameter to URL: ".concat(String.valueOf(str)));
                }
                com.google.android.gms.ads.internal.zzb zzbVar = this.zzx;
                if (zzbVar == null || zzbVar.zzc()) {
                    zzu(new com.google.android.gms.ads.internal.overlay.zzc("android.intent.action.VIEW", uriZza.toString(), null, null, null, null, null, null), true);
                } else {
                    zzbVar.zzb(str);
                }
            }
        }
        return true;
    }

    public final void zzA(String str, zzbng zzbngVar) {
        synchronized (this.zzf) {
            List copyOnWriteArrayList = (List) this.zze.get(str);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList();
                this.zze.put(str, copyOnWriteArrayList);
            }
            copyOnWriteArrayList.add(zzbngVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final void zzB(zzckw zzckwVar) {
        this.zzi = zzckwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final void zzC(int i, int i2) {
        zzbvq zzbvqVar = this.zzy;
        if (zzbvqVar != null) {
            zzbvqVar.zze(i, i2);
        }
    }

    public final void zzD(boolean z) {
        this.zzn = false;
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final void zzE(boolean z) {
        synchronized (this.zzf) {
            this.zzu = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final void zzF() {
        synchronized (this.zzf) {
            this.zzn = false;
            this.zzs = true;
            zzcep.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjm
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzn();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final void zzG(boolean z) {
        synchronized (this.zzf) {
            this.zzt = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final void zzH(zzckx zzckxVar) {
        this.zzj = zzckxVar;
    }

    public final void zzI(String str, zzbng zzbngVar) {
        synchronized (this.zzf) {
            List list = (List) this.zze.get(str);
            if (list == null) {
                return;
            }
            list.remove(zzbngVar);
        }
    }

    public final void zzJ(String str, Predicate predicate) {
        synchronized (this.zzf) {
            List<zzbng> list = (List) this.zze.get(str);
            if (list == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (zzbng zzbngVar : list) {
                if (predicate.apply(zzbngVar)) {
                    arrayList.add(zzbngVar);
                }
            }
            list.removeAll(arrayList);
        }
    }

    public final boolean zzK() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzu;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final boolean zzL() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzs;
        }
        return z;
    }

    public final boolean zzM() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzt;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final void zzN(com.google.android.gms.ads.internal.client.zza zzaVar, zzblw zzblwVar, com.google.android.gms.ads.internal.overlay.zzp zzpVar, zzbly zzblyVar, com.google.android.gms.ads.internal.overlay.zzaa zzaaVar, boolean z, zzbni zzbniVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbvx zzbvxVar, zzcbs zzcbsVar, final zzehh zzehhVar, final zzfny zzfnyVar, zzdwf zzdwfVar, zzflw zzflwVar, zzbnz zzbnzVar, final zzdiu zzdiuVar, zzbny zzbnyVar, zzbns zzbnsVar, final zzcse zzcseVar) {
        com.google.android.gms.ads.internal.zzb zzbVar2 = zzbVar == null ? new com.google.android.gms.ads.internal.zzb(this.zzc.getContext(), zzcbsVar, null) : zzbVar;
        this.zzy = new zzbvq(this.zzc, zzbvxVar);
        this.zza = zzcbsVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaR)).booleanValue()) {
            zzA("/adMetadata", new zzblv(zzblwVar));
        }
        if (zzblyVar != null) {
            zzA("/appEvent", new zzblx(zzblyVar));
        }
        zzA("/backButton", zzbnf.zzj);
        zzA("/refresh", zzbnf.zzk);
        zzA("/canOpenApp", zzbnf.zzb);
        zzA("/canOpenURLs", zzbnf.zza);
        zzA("/canOpenIntents", zzbnf.zzc);
        zzA("/close", zzbnf.zzd);
        zzA("/customClose", zzbnf.zze);
        zzA("/instrument", zzbnf.zzn);
        zzA("/delayPageLoaded", zzbnf.zzp);
        zzA("/delayPageClosed", zzbnf.zzq);
        zzA("/getLocationInfo", zzbnf.zzr);
        zzA("/log", zzbnf.zzg);
        zzA("/mraid", new zzbnm(zzbVar2, this.zzy, zzbvxVar));
        zzbvv zzbvvVar = this.zzw;
        if (zzbvvVar != null) {
            zzA("/mraidLoaded", zzbvvVar);
        }
        com.google.android.gms.ads.internal.zzb zzbVar3 = zzbVar2;
        zzA("/open", new zzbnr(zzbVar2, this.zzy, zzehhVar, zzdwfVar, zzflwVar, zzcseVar));
        zzA("/precache", new zzchx());
        zzA("/touch", zzbnf.zzi);
        zzA("/video", zzbnf.zzl);
        zzA("/videoMeta", zzbnf.zzm);
        if (zzehhVar == null || zzfnyVar == null) {
            zzA("/click", new zzbme(zzdiuVar, zzcseVar));
            zzA("/httpTrack", zzbnf.zzf);
        } else {
            zzA("/click", new zzbng() { // from class: com.google.android.gms.internal.ads.zzfhp
                @Override // com.google.android.gms.internal.ads.zzbng
                public final void zza(Object obj, Map map) {
                    zzcjk zzcjkVar = (zzcjk) obj;
                    zzbnf.zzc(map, zzdiuVar);
                    String str = (String) map.get("u");
                    if (str == null) {
                        zzcec.zzj("URL missing from click GMSG.");
                        return;
                    }
                    zzehh zzehhVar2 = zzehhVar;
                    zzfny zzfnyVar2 = zzfnyVar;
                    zzgen.zzr(zzbnf.zza(zzcjkVar, str), new zzfhr(zzcjkVar, zzcseVar, zzfnyVar2, zzehhVar2), zzcep.zza);
                }
            });
            zzA("/httpTrack", new zzbng() { // from class: com.google.android.gms.internal.ads.zzfhq
                @Override // com.google.android.gms.internal.ads.zzbng
                public final void zza(Object obj, Map map) {
                    zzcjb zzcjbVar = (zzcjb) obj;
                    String str = (String) map.get("u");
                    if (str == null) {
                        zzcec.zzj("URL missing from httpTrack GMSG.");
                    } else if (zzcjbVar.zzD().zzaj) {
                        zzehhVar.zzd(new zzehj(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis(), ((zzckj) zzcjbVar).zzP().zzb, str, 2));
                    } else {
                        zzfnyVar.zzc(str, null);
                    }
                }
            });
        }
        if (com.google.android.gms.ads.internal.zzt.zzn().zzp(this.zzc.getContext())) {
            zzA("/logScionEvent", new zzbnl(this.zzc.getContext()));
        }
        if (zzbniVar != null) {
            zzA("/setInterstitialProperties", new zzbnh(zzbniVar));
        }
        if (zzbnzVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziN)).booleanValue()) {
                zzA("/inspectorNetworkExtras", zzbnzVar);
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjg)).booleanValue() && zzbnyVar != null) {
            zzA("/shareSheet", zzbnyVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjl)).booleanValue() && zzbnsVar != null) {
            zzA("/inspectorOutOfContextTest", zzbnsVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkT)).booleanValue()) {
            zzA("/bindPlayStoreOverlay", zzbnf.zzu);
            zzA("/presentPlayStoreOverlay", zzbnf.zzv);
            zzA("/expandPlayStoreOverlay", zzbnf.zzw);
            zzA("/collapsePlayStoreOverlay", zzbnf.zzx);
            zzA("/closePlayStoreOverlay", zzbnf.zzy);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzda)).booleanValue()) {
            zzA("/setPAIDPersonalizationEnabled", zzbnf.zzA);
            zzA("/resetPAID", zzbnf.zzz);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzll)).booleanValue()) {
            zzcjk zzcjkVar = this.zzc;
            if (zzcjkVar.zzD() != null && zzcjkVar.zzD().zzar) {
                zzA("/writeToLocalStorage", zzbnf.zzB);
                zzA("/clearLocalStorageKeys", zzbnf.zzC);
            }
        }
        this.zzg = zzaVar;
        this.zzh = zzpVar;
        this.zzk = zzblwVar;
        this.zzl = zzblyVar;
        this.zzv = zzaaVar;
        this.zzx = zzbVar3;
        this.zzm = zzdiuVar;
        this.zzn = z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zza() {
        synchronized (this.zzf) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzb() {
        synchronized (this.zzf) {
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdiu
    public final void zzbo() {
        zzdiu zzdiuVar = this.zzm;
        if (zzdiuVar != null) {
            zzdiuVar.zzbo();
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0081  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v9 */
    protected final WebResourceResponse zzc(String str, Map map) {
        int i;
        InputStream inputStreamZza;
        Long l;
        boolean z;
        InputStream inputStreamZzc;
        final boolean z2;
        boolean z3;
        final boolean z4;
        String str2;
        try {
            String strZzc = zzccj.zzc(str, this.zzc.getContext(), this.zzC);
            if (!strZzc.equals(str)) {
                return zzP(strZzc, map);
            }
            zzbbb zzbbbVarZza = zzbbb.zza(Uri.parse(str));
            if (zzbbbVarZza != null) {
                HashMap map2 = new HashMap();
                map2.put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
                Uri uri = Uri.parse(str);
                if (uri.getQueryParameterNames().contains("range")) {
                    List listZzf = zzfxr.zzc(zzfwp.zzc('-')).zzf(uri.getQueryParameter("range"));
                    if (listZzf.size() == 2) {
                        int i2 = Integer.parseInt((String) listZzf.get(0));
                        int i3 = Integer.parseInt((String) listZzf.get(1)) + 1;
                        if (i2 > 0) {
                            zzbbbVarZza.zzh = i2;
                        }
                        i = i3 - i2;
                    } else {
                        i = -1;
                    }
                } else {
                    i = -1;
                }
                final ?? r10 = "X-Afma-Gcache-HasAdditionalMetadataFromReadV2";
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzej)).booleanValue()) {
                    zzbbbVarZza.zzi = zzfxt.zzc(this.zzc.zzr());
                    zzbbbVarZza.zzj = this.zzc.zzf();
                    if (zzbbbVarZza.zzg) {
                        l = (Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzel);
                    } else {
                        l = (Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzek);
                    }
                    try {
                        long jLongValue = l.longValue();
                        long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
                        com.google.android.gms.ads.internal.zzt.zzd();
                        Future futureZza = zzbbm.zza(this.zzc.getContext(), zzbbbVarZza);
                        try {
                            zzbbn zzbbnVar = (zzbbn) futureZza.get(jLongValue, TimeUnit.MILLISECONDS);
                            try {
                                try {
                                    map2.put("X-Afma-Gcache-HasAdditionalMetadataFromReadV2", Boolean.toString(zzbbnVar.zzd()));
                                    map2.put("X-Afma-Gcache-IsGcacheHit", Boolean.toString(zzbbnVar.zzf()));
                                    map2.put("X-Afma-Gcache-IsDownloaded", Boolean.toString(zzbbnVar.zze()));
                                    map2.put("X-Afma-Gcache-CachedBytes", Long.toString(zzbbnVar.zza()));
                                    inputStreamZzc = zzbbnVar.zzc();
                                    if (i != -1) {
                                        try {
                                            inputStreamZzc = zzgci.zza(inputStreamZzc, i);
                                        } catch (InterruptedException unused) {
                                            z3 = true;
                                            z4 = true;
                                            futureZza.cancel(z3);
                                            Thread.currentThread().interrupt();
                                            final long jElapsedRealtime2 = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime;
                                            com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjo
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    this.zza.zzo(z4, jElapsedRealtime2);
                                                }
                                            });
                                            str2 = "Cache connection took " + jElapsedRealtime2 + "ms";
                                            r10 = z4;
                                        } catch (ExecutionException | TimeoutException unused2) {
                                            z = true;
                                            z2 = true;
                                            futureZza.cancel(z);
                                            final long jElapsedRealtime3 = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime;
                                            com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjo
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    this.zza.zzo(z2, jElapsedRealtime3);
                                                }
                                            });
                                            str2 = "Cache connection took " + jElapsedRealtime3 + "ms";
                                            r10 = z2;
                                        }
                                    }
                                    final long jElapsedRealtime4 = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime;
                                    final boolean z5 = true;
                                    com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjo
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            this.zza.zzo(z5, jElapsedRealtime4);
                                        }
                                    });
                                    str2 = "Cache connection took " + jElapsedRealtime4 + "ms";
                                } catch (InterruptedException unused3) {
                                    z3 = true;
                                    inputStreamZzc = null;
                                } catch (ExecutionException | TimeoutException unused4) {
                                    z = true;
                                    inputStreamZzc = null;
                                }
                                com.google.android.gms.ads.internal.util.zze.zza(str2);
                                inputStreamZza = inputStreamZzc;
                            } catch (Throwable th) {
                                th = th;
                                r10 = 1;
                                final long jElapsedRealtime5 = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime;
                                com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjo
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.zza.zzo(r10, jElapsedRealtime5);
                                    }
                                });
                                com.google.android.gms.ads.internal.util.zze.zza("Cache connection took " + jElapsedRealtime5 + "ms");
                                throw th;
                            }
                        } catch (InterruptedException unused5) {
                            z3 = true;
                            inputStreamZzc = null;
                            z4 = false;
                        } catch (ExecutionException | TimeoutException unused6) {
                            z = true;
                            inputStreamZzc = null;
                            z2 = false;
                        } catch (Throwable th2) {
                            th = th2;
                            r10 = 0;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else {
                    zzbay zzbayVarZzb = com.google.android.gms.ads.internal.zzt.zzc().zzb(zzbbbVarZza);
                    if (zzbayVarZzb == null || !zzbayVarZzb.zze()) {
                        inputStreamZza = null;
                    } else {
                        map2.put("X-Afma-Gcache-HasAdditionalMetadataFromReadV2", Boolean.toString(zzbayVarZzb.zzd()));
                        map2.put("X-Afma-Gcache-IsGcacheHit", Boolean.toString(zzbayVarZzb.zzg()));
                        map2.put("X-Afma-Gcache-IsDownloaded", Boolean.toString(zzbayVarZzb.zzf()));
                        map2.put("X-Afma-Gcache-CachedBytes", Long.toString(zzbayVarZzb.zza()));
                        InputStream inputStreamZzc2 = zzbayVarZzb.zzc();
                        inputStreamZza = i != -1 ? zzgci.zza(inputStreamZzc2, i) : inputStreamZzc2;
                    }
                }
                if (inputStreamZza != null) {
                    return new WebResourceResponse("", "", 200, "OK", map2, inputStreamZza);
                }
            }
            if (zzceb.zzk() && ((Boolean) zzbhw.zzb.zze()).booleanValue()) {
                return zzP(str, map);
            }
            return null;
        } catch (Exception | NoClassDefFoundError e) {
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "AdWebViewClient.interceptRequest");
            return zzO();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final com.google.android.gms.ads.internal.zzb zzd() {
        return this.zzx;
    }

    public final void zzg() {
        if (this.zzi != null && ((this.zzz && this.zzB <= 0) || this.zzA || this.zzo)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbQ)).booleanValue() && this.zzc.zzm() != null) {
                zzbgm.zza(this.zzc.zzm().zza(), this.zzc.zzk(), "awfllc");
            }
            zzckw zzckwVar = this.zzi;
            boolean z = false;
            if (!this.zzA && !this.zzo) {
                z = true;
            }
            zzckwVar.zza(z, this.zzp, this.zzq, this.zzr);
            this.zzi = null;
        }
        this.zzc.zzad();
    }

    public final void zzh() {
        zzcbs zzcbsVar = this.zza;
        if (zzcbsVar != null) {
            zzcbsVar.zze();
            this.zza = null;
        }
        zzR();
        synchronized (this.zzf) {
            this.zze.clear();
            this.zzg = null;
            this.zzh = null;
            this.zzi = null;
            this.zzj = null;
            this.zzk = null;
            this.zzl = null;
            this.zzn = false;
            this.zzs = false;
            this.zzt = false;
            this.zzv = null;
            this.zzx = null;
            this.zzw = null;
            zzbvq zzbvqVar = this.zzy;
            if (zzbvqVar != null) {
                zzbvqVar.zza(true);
                this.zzy = null;
            }
        }
    }

    public final void zzi(boolean z) {
        this.zzC = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final void zzj(Uri uri) {
        com.google.android.gms.ads.internal.util.zze.zza("Received GMSG: ".concat(String.valueOf(String.valueOf(uri))));
        HashMap map = this.zze;
        String path = uri.getPath();
        List list = (List) map.get(path);
        if (path == null || list == null) {
            com.google.android.gms.ads.internal.util.zze.zza("No GMSG handler found for GMSG: ".concat(String.valueOf(String.valueOf(uri))));
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgM)).booleanValue() || com.google.android.gms.ads.internal.zzt.zzo().zzg() == null) {
                return;
            }
            final String strSubstring = (path == null || path.length() < 2) ? "null" : path.substring(1);
            zzcep.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjn
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    int i = zzcjs.zzb;
                    com.google.android.gms.ads.internal.zzt.zzo().zzg().zze(strSubstring);
                }
            });
            return;
        }
        String encodedQuery = uri.getEncodedQuery();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfD)).booleanValue() && this.zzD.contains(path) && encodedQuery != null) {
            if (encodedQuery.length() >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfF)).intValue()) {
                com.google.android.gms.ads.internal.util.zze.zza("Parsing gmsg query params on BG thread: ".concat(path));
                zzgen.zzr(com.google.android.gms.ads.internal.zzt.zzp().zzb(uri), new zzcjq(this, list, path, uri), zzcep.zze);
                return;
            }
        }
        com.google.android.gms.ads.internal.zzt.zzp();
        zzQ(com.google.android.gms.ads.internal.util.zzt.zzO(uri), list, path);
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final void zzk() {
        zzbbp zzbbpVar = this.zzd;
        if (zzbbpVar != null) {
            zzbbpVar.zzc(10005);
        }
        this.zzA = true;
        this.zzp = 10004;
        this.zzq = "Page loaded delay cancel.";
        zzg();
        this.zzc.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final void zzl() {
        synchronized (this.zzf) {
        }
        this.zzB++;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final void zzm() {
        this.zzB--;
        zzg();
    }

    final /* synthetic */ void zzn() {
        this.zzc.zzab();
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = this.zzc.zzL();
        if (zzmVarZzL != null) {
            zzmVarZzL.zzz();
        }
    }

    final /* synthetic */ void zzo(boolean z, long j) {
        this.zzc.zzv(z, j);
    }

    final /* synthetic */ void zzp(View view, zzcbs zzcbsVar, int i) {
        zzS(view, zzcbsVar, i - 1);
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final void zzq(int i, int i2, boolean z) {
        zzbvv zzbvvVar = this.zzw;
        if (zzbvvVar != null) {
            zzbvvVar.zzb(i, i2);
        }
        zzbvq zzbvqVar = this.zzy;
        if (zzbvqVar != null) {
            zzbvqVar.zzd(i, i2, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final void zzr() {
        zzcbs zzcbsVar = this.zza;
        if (zzcbsVar != null) {
            WebView webViewZzG = this.zzc.zzG();
            if (ViewCompat.isAttachedToWindow(webViewZzG)) {
                zzS(webViewZzG, zzcbsVar, 10);
                return;
            }
            zzR();
            zzcjp zzcjpVar = new zzcjp(this, zzcbsVar);
            this.zzF = zzcjpVar;
            ((View) this.zzc).addOnAttachStateChangeListener(zzcjpVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdiu
    public final void zzs() {
        zzdiu zzdiuVar = this.zzm;
        if (zzdiuVar != null) {
            zzdiuVar.zzs();
        }
    }

    public final void zzu(com.google.android.gms.ads.internal.overlay.zzc zzcVar, boolean z) {
        zzcjk zzcjkVar = this.zzc;
        boolean zZzaC = zzcjkVar.zzaC();
        boolean zZzU = zzU(zZzaC, zzcjkVar);
        boolean z2 = true;
        if (!zZzU && z) {
            z2 = false;
        }
        com.google.android.gms.ads.internal.client.zza zzaVar = zZzU ? null : this.zzg;
        com.google.android.gms.ads.internal.overlay.zzp zzpVar = zZzaC ? null : this.zzh;
        com.google.android.gms.ads.internal.overlay.zzaa zzaaVar = this.zzv;
        zzcjk zzcjkVar2 = this.zzc;
        zzx(new AdOverlayInfoParcel(zzcVar, zzaVar, zzpVar, zzaaVar, zzcjkVar2.zzn(), zzcjkVar2, z2 ? null : this.zzm));
    }

    public final void zzv(String str, String str2, int i) {
        zzehs zzehsVar = this.zzE;
        zzcjk zzcjkVar = this.zzc;
        zzx(new AdOverlayInfoParcel(zzcjkVar, zzcjkVar.zzn(), str, str2, 14, zzehsVar));
    }

    public final void zzw(boolean z, int i, boolean z2) {
        zzcjk zzcjkVar = this.zzc;
        boolean zZzU = zzU(zzcjkVar.zzaC(), zzcjkVar);
        boolean z3 = true;
        if (!zZzU && z2) {
            z3 = false;
        }
        com.google.android.gms.ads.internal.client.zza zzaVar = zZzU ? null : this.zzg;
        com.google.android.gms.ads.internal.overlay.zzp zzpVar = this.zzh;
        com.google.android.gms.ads.internal.overlay.zzaa zzaaVar = this.zzv;
        zzcjk zzcjkVar2 = this.zzc;
        zzx(new AdOverlayInfoParcel(zzaVar, zzpVar, zzaaVar, zzcjkVar2, z, i, zzcjkVar2.zzn(), z3 ? null : this.zzm, zzT(this.zzc) ? this.zzE : null));
    }

    public final void zzx(AdOverlayInfoParcel adOverlayInfoParcel) {
        com.google.android.gms.ads.internal.overlay.zzc zzcVar;
        zzbvq zzbvqVar = this.zzy;
        boolean zZzf = zzbvqVar != null ? zzbvqVar.zzf() : false;
        com.google.android.gms.ads.internal.zzt.zzi();
        com.google.android.gms.ads.internal.overlay.zzn.zza(this.zzc.getContext(), adOverlayInfoParcel, !zZzf);
        zzcbs zzcbsVar = this.zza;
        if (zzcbsVar != null) {
            String str = adOverlayInfoParcel.zzl;
            if (str == null && (zzcVar = adOverlayInfoParcel.zza) != null) {
                str = zzcVar.zzb;
            }
            zzcbsVar.zzh(str);
        }
    }

    public final void zzy(boolean z, int i, String str, String str2, boolean z2) {
        zzcjk zzcjkVar = this.zzc;
        boolean zZzaC = zzcjkVar.zzaC();
        boolean zZzU = zzU(zZzaC, zzcjkVar);
        boolean z3 = true;
        if (!zZzU && z2) {
            z3 = false;
        }
        com.google.android.gms.ads.internal.client.zza zzaVar = zZzU ? null : this.zzg;
        zzcjr zzcjrVar = zZzaC ? null : new zzcjr(this.zzc, this.zzh);
        zzblw zzblwVar = this.zzk;
        zzbly zzblyVar = this.zzl;
        com.google.android.gms.ads.internal.overlay.zzaa zzaaVar = this.zzv;
        zzcjk zzcjkVar2 = this.zzc;
        zzx(new AdOverlayInfoParcel(zzaVar, zzcjrVar, zzblwVar, zzblyVar, zzaaVar, zzcjkVar2, z, i, str, str2, zzcjkVar2.zzn(), z3 ? null : this.zzm, zzT(this.zzc) ? this.zzE : null));
    }

    public final void zzz(boolean z, int i, String str, boolean z2, boolean z3) {
        zzcjk zzcjkVar = this.zzc;
        boolean zZzaC = zzcjkVar.zzaC();
        boolean zZzU = zzU(zZzaC, zzcjkVar);
        boolean z4 = true;
        if (!zZzU && z2) {
            z4 = false;
        }
        com.google.android.gms.ads.internal.client.zza zzaVar = zZzU ? null : this.zzg;
        zzcjr zzcjrVar = zZzaC ? null : new zzcjr(this.zzc, this.zzh);
        zzblw zzblwVar = this.zzk;
        zzbly zzblyVar = this.zzl;
        com.google.android.gms.ads.internal.overlay.zzaa zzaaVar = this.zzv;
        zzcjk zzcjkVar2 = this.zzc;
        zzx(new AdOverlayInfoParcel(zzaVar, zzcjrVar, zzblwVar, zzblyVar, zzaaVar, zzcjkVar2, z, i, str, zzcjkVar2.zzn(), z4 ? null : this.zzm, zzT(this.zzc) ? this.zzE : null, z3));
    }
}
