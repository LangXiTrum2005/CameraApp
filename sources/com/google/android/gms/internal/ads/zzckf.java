package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Looper;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bumptech.glide.load.Key;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzftt;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
final class zzckf extends WebView implements DownloadListener, ViewTreeObserver.OnGlobalLayoutListener, zzcjk {
    public static final /* synthetic */ int zza = 0;
    private zzcki zzA;
    private boolean zzB;
    private boolean zzC;
    private zzbja zzD;
    private zzbiy zzE;
    private zzbad zzF;
    private int zzG;
    private int zzH;
    private zzbgr zzI;
    private final zzbgr zzJ;
    private zzbgr zzK;
    private final zzbgs zzL;
    private int zzM;
    private com.google.android.gms.ads.internal.overlay.zzm zzN;
    private boolean zzO;
    private final com.google.android.gms.ads.internal.util.zzco zzP;
    private int zzQ;
    private int zzR;
    private int zzS;
    private int zzT;
    private Map zzU;
    private final WindowManager zzV;
    private final zzbbp zzW;
    private boolean zzX;
    private final zzckz zzb;
    private final zzavi zzc;
    private final zzfhl zzd;
    private final zzbhj zze;
    private final zzcei zzf;
    private com.google.android.gms.ads.internal.zzl zzg;
    private final com.google.android.gms.ads.internal.zza zzh;
    private final DisplayMetrics zzi;
    private final float zzj;
    private zzfgm zzk;
    private zzfgp zzl;
    private boolean zzm;
    private boolean zzn;
    private zzcjs zzo;
    private com.google.android.gms.ads.internal.overlay.zzm zzp;
    private zzfod zzq;
    private zzcla zzr;
    private final String zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private Boolean zzx;
    private boolean zzy;
    private final String zzz;

    protected zzckf(zzckz zzckzVar, zzcla zzclaVar, String str, boolean z, boolean z2, zzavi zzaviVar, zzbhj zzbhjVar, zzcei zzceiVar, zzbgu zzbguVar, com.google.android.gms.ads.internal.zzl zzlVar, com.google.android.gms.ads.internal.zza zzaVar, zzbbp zzbbpVar, zzfgm zzfgmVar, zzfgp zzfgpVar, zzfhl zzfhlVar) {
        zzfgp zzfgpVar2;
        super(zzckzVar);
        this.zzm = false;
        this.zzn = false;
        this.zzy = true;
        this.zzz = "";
        this.zzQ = -1;
        this.zzR = -1;
        this.zzS = -1;
        this.zzT = -1;
        this.zzb = zzckzVar;
        this.zzr = zzclaVar;
        this.zzs = str;
        this.zzv = z;
        this.zzc = zzaviVar;
        this.zzd = zzfhlVar;
        this.zze = zzbhjVar;
        this.zzf = zzceiVar;
        this.zzg = zzlVar;
        this.zzh = zzaVar;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        this.zzV = windowManager;
        com.google.android.gms.ads.internal.zzt.zzp();
        DisplayMetrics displayMetricsZzs = com.google.android.gms.ads.internal.util.zzt.zzs(windowManager);
        this.zzi = displayMetricsZzs;
        this.zzj = displayMetricsZzs.density;
        this.zzW = zzbbpVar;
        this.zzk = zzfgmVar;
        this.zzl = zzfgpVar;
        this.zzP = new com.google.android.gms.ads.internal.util.zzco(zzckzVar.zza(), this, this, null);
        this.zzX = false;
        setBackgroundColor(0);
        final WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            zzcec.zzh("Unable to enable Javascript.", e);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkZ)).booleanValue()) {
            settings.setMixedContentMode(1);
        } else {
            settings.setMixedContentMode(2);
        }
        settings.setUserAgentString(com.google.android.gms.ads.internal.zzt.zzp().zzc(zzckzVar, zzceiVar.zza));
        com.google.android.gms.ads.internal.zzt.zzp();
        final Context context = getContext();
        com.google.android.gms.ads.internal.util.zzch.zza(context, new Callable() { // from class: com.google.android.gms.ads.internal.util.zzk
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzftt zzfttVar = zzt.zza;
                String absolutePath = context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath();
                WebSettings webSettings = settings;
                webSettings.setDatabasePath(absolutePath);
                webSettings.setDatabaseEnabled(true);
                webSettings.setDomStorageEnabled(true);
                webSettings.setDisplayZoomControls(false);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setSupportZoom(true);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaK)).booleanValue()) {
                    webSettings.setTextZoom(100);
                }
                webSettings.setAllowContentAccess(false);
                return true;
            }
        });
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setMediaPlaybackRequiresUserGesture(false);
        setDownloadListener(this);
        zzaV();
        addJavascriptInterface(new zzckm(this, new zzckl(this)), "googleAdsJsInterface");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        zzbd();
        zzbgs zzbgsVar = new zzbgs(new zzbgu(true, "make_wv", this.zzs));
        this.zzL = zzbgsVar;
        zzbgsVar.zza().zzc(null);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbQ)).booleanValue() && (zzfgpVar2 = this.zzl) != null && zzfgpVar2.zzb != null) {
            zzbgsVar.zza().zzd("gqi", this.zzl.zzb);
        }
        zzbgsVar.zza();
        zzbgr zzbgrVarZzf = zzbgu.zzf();
        this.zzJ = zzbgrVarZzf;
        zzbgsVar.zzb("native:view_create", zzbgrVarZzf);
        this.zzK = null;
        this.zzI = null;
        com.google.android.gms.ads.internal.util.zzck.zza().zzb(zzckzVar);
        com.google.android.gms.ads.internal.zzt.zzo().zzt();
    }

    private final synchronized void zzaV() {
        zzfgm zzfgmVar = this.zzk;
        if (zzfgmVar != null && zzfgmVar.zzan) {
            zzcec.zze("Disabling hardware acceleration on an overlay.");
            zzaX();
            return;
        }
        if (!this.zzv && !this.zzr.zzi()) {
            zzcec.zze("Enabling hardware acceleration on an AdView.");
            zzaZ();
            return;
        }
        zzcec.zze("Enabling hardware acceleration on an overlay.");
        zzaZ();
    }

    private final synchronized void zzaW() {
        if (this.zzO) {
            return;
        }
        this.zzO = true;
        com.google.android.gms.ads.internal.zzt.zzo().zzr();
    }

    private final synchronized void zzaX() {
        if (!this.zzw) {
            setLayerType(1, null);
        }
        this.zzw = true;
    }

    private final void zzaY(boolean z) {
        HashMap map = new HashMap();
        map.put("isVisible", true != z ? "0" : "1");
        zzd("onAdVisibilityChanged", map);
    }

    private final synchronized void zzaZ() {
        if (this.zzw) {
            setLayerType(0, null);
        }
        this.zzw = false;
    }

    private final synchronized void zzba(String str) {
        try {
            super.loadUrl("about:blank");
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzt.zzo().zzw(th, "AdWebViewImpl.loadUrlUnsafe");
            zzcec.zzk("Could not call loadUrl in destroy(). ", th);
        }
    }

    private final void zzbb() {
        zzbgm.zza(this.zzL.zza(), this.zzJ, "aeh2");
    }

    private final synchronized void zzbc() {
        Map map = this.zzU;
        if (map != null) {
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                ((zzchw) it.next()).release();
            }
        }
        this.zzU = null;
    }

    private final void zzbd() {
        zzbgs zzbgsVar = this.zzL;
        if (zzbgsVar == null) {
            return;
        }
        zzbgu zzbguVarZza = zzbgsVar.zza();
        zzbgk zzbgkVarZzg = com.google.android.gms.ads.internal.zzt.zzo().zzg();
        if (zzbgkVarZzg != null) {
            zzbgkVarZzg.zzf(zzbguVarZza);
        }
    }

    private final synchronized void zzbe() {
        Boolean boolZzl = com.google.android.gms.ads.internal.zzt.zzo().zzl();
        this.zzx = boolZzl;
        if (boolZzl == null) {
            try {
                evaluateJavascript("(function(){})()", null);
                zzaT(true);
            } catch (IllegalStateException unused) {
                zzaT(false);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcjk
    public final synchronized void destroy() {
        zzbd();
        this.zzP.zza();
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzp;
        if (zzmVar != null) {
            zzmVar.zzb();
            this.zzp.zzm();
            this.zzp = null;
        }
        this.zzq = null;
        this.zzo.zzh();
        this.zzF = null;
        this.zzg = null;
        setOnClickListener(null);
        setOnTouchListener(null);
        if (this.zzu) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzy().zzd(this);
        zzbc();
        this.zzu = true;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkn)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zza("Destroying the WebView immediately...");
            zzV();
        } else {
            com.google.android.gms.ads.internal.util.zze.zza("Initiating WebView self destruct sequence in 3...");
            com.google.android.gms.ads.internal.util.zze.zza("Loading blank page in WebView, 2...");
            zzba("about:blank");
        }
    }

    @Override // android.webkit.WebView
    public final synchronized void evaluateJavascript(final String str, final ValueCallback valueCallback) {
        if (zzaB()) {
            zzcec.zzl("#004 The webview is destroyed. Ignoring action.", null);
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
                return;
            }
            return;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzko)).booleanValue() || Looper.getMainLooper().getThread() == Thread.currentThread()) {
            super.evaluateJavascript(str, valueCallback);
        } else {
            zzcep.zze.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzckb
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzaR(str, valueCallback);
                }
            });
        }
    }

    protected final void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.zzu) {
                    this.zzo.zzh();
                    com.google.android.gms.ads.internal.zzt.zzy().zzd(this);
                    zzbc();
                    zzaW();
                }
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcjk
    public final synchronized void loadData(String str, String str2, String str3) {
        if (zzaB()) {
            zzcec.zzj("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadData(str, str2, str3);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcjk
    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (zzaB()) {
            zzcec.zzj("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcjk
    public final synchronized void loadUrl(String str) {
        if (zzaB()) {
            zzcec.zzj("#004 The webview is destroyed. Ignoring action.");
            return;
        }
        try {
            super.loadUrl(str);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzt.zzo().zzw(th, "AdWebViewImpl.loadUrl");
            zzcec.zzk("Could not call loadUrl. ", th);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        zzcjs zzcjsVar = this.zzo;
        if (zzcjsVar != null) {
            zzcjsVar.onAdClicked();
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!zzaB()) {
            this.zzP.zzc();
        }
        if (this.zzX) {
            onResume();
            this.zzX = false;
        }
        boolean z = this.zzB;
        zzcjs zzcjsVar = this.zzo;
        if (zzcjsVar != null && zzcjsVar.zzM()) {
            if (!this.zzC) {
                this.zzo.zza();
                this.zzo.zzb();
                this.zzC = true;
            }
            zzaU();
            z = true;
        }
        zzaY(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        zzcjs zzcjsVar;
        synchronized (this) {
            if (!zzaB()) {
                this.zzP.zzd();
            }
            super.onDetachedFromWindow();
            if (this.zzC && (zzcjsVar = this.zzo) != null && zzcjsVar.zzM() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.zzo.zza();
                this.zzo.zzb();
                this.zzC = false;
            }
        }
        zzaY(false);
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkz)).booleanValue() && getContext() != null) {
                intent.setPackage(getContext().getPackageName());
            }
            com.google.android.gms.ads.internal.zzt.zzp();
            com.google.android.gms.ads.internal.util.zzt.zzS(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            zzcec.zze("Couldn't find an Activity to view url/mimetype: " + str + " / " + str4);
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "AdWebViewImpl.onDownloadStart: ".concat(String.valueOf(str)));
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected final void onDraw(Canvas canvas) {
        if (zzaB()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean zZzaU = zzaU();
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = zzL();
        if (zzmVarZzL == null || !zZzaU) {
            return;
        }
        zzmVarZzL.zzn();
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0080 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x0082 A[Catch: all -> 0x01dd, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:9:0x000f, B:11:0x0015, B:13:0x0019, B:16:0x0023, B:18:0x002b, B:21:0x0030, B:23:0x0038, B:25:0x004a, B:28:0x004f, B:30:0x0056, B:34:0x0060, B:37:0x0065, B:40:0x0076, B:48:0x008c, B:42:0x007d, B:45:0x0082, B:51:0x0099, B:53:0x00a1, B:55:0x00b3, B:58:0x00b8, B:60:0x00d4, B:62:0x00dc, B:61:0x00d8, B:65:0x00e1, B:67:0x00e9, B:70:0x00f4, B:79:0x0118, B:81:0x011f, B:86:0x0127, B:88:0x0139, B:90:0x0147, B:94:0x0154, B:97:0x0159, B:99:0x019f, B:100:0x01a3, B:102:0x01aa, B:107:0x01b7, B:109:0x01bd, B:110:0x01c0, B:112:0x01c4, B:113:0x01cd, B:116:0x01d8), top: B:122:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x0089  */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected final synchronized void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        if (zzaB()) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (!isInEditMode() && !this.zzv && !this.zzr.zzf()) {
            if (this.zzr.zzh()) {
                super.onMeasure(i, i2);
                return;
            }
            if (this.zzr.zzj()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdJ)).booleanValue()) {
                    super.onMeasure(i, i2);
                    return;
                }
                zzcki zzckiVarZzq = zzq();
                float fZze = zzckiVarZzq != null ? zzckiVarZzq.zze() : 0.0f;
                if (fZze == 0.0f) {
                    super.onMeasure(i, i2);
                    return;
                }
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                float f = size2 * fZze;
                int i7 = (int) (size / fZze);
                if (size2 != 0) {
                    i3 = (int) f;
                    if (size == 0) {
                        i6 = size;
                    } else if (i3 != 0) {
                        i7 = (int) (i3 / fZze);
                        i4 = size2;
                        i5 = i3;
                        i6 = i5;
                    }
                    i4 = size2;
                    i5 = i3;
                } else if (i7 != 0) {
                    i5 = (int) (i7 * fZze);
                    i6 = size;
                    i4 = i7;
                } else {
                    size2 = 0;
                    i3 = (int) f;
                    if (size == 0) {
                        i6 = size;
                    } else if (i3 != 0) {
                        i7 = (int) (i3 / fZze);
                        i4 = size2;
                        i5 = i3;
                        i6 = i5;
                    }
                    i4 = size2;
                    i5 = i3;
                }
                setMeasuredDimension(Math.min(i5, i6), Math.min(i7, i4));
                return;
            }
            if (this.zzr.zzg()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdQ)).booleanValue()) {
                    super.onMeasure(i, i2);
                    return;
                }
                zzae("/contentHeight", new zzckd(this));
                zzaQ("(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();");
                float f2 = this.zzi.density;
                int size3 = View.MeasureSpec.getSize(i);
                int i8 = this.zzH;
                setMeasuredDimension(size3, i8 != -1 ? (int) (i8 * f2) : View.MeasureSpec.getSize(i2));
                return;
            }
            if (this.zzr.zzi()) {
                DisplayMetrics displayMetrics = this.zzi;
                setMeasuredDimension(displayMetrics.widthPixels, displayMetrics.heightPixels);
                return;
            }
            int mode = View.MeasureSpec.getMode(i);
            int size4 = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size5 = View.MeasureSpec.getSize(i2);
            int i9 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size4 : Integer.MAX_VALUE;
            int i10 = (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) ? size5 : Integer.MAX_VALUE;
            zzcla zzclaVar = this.zzr;
            boolean z = zzclaVar.zzb > i9 || zzclaVar.zza > i10;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfq)).booleanValue()) {
                zzcla zzclaVar2 = this.zzr;
                float f3 = zzclaVar2.zzb;
                float f4 = this.zzj;
                z &= f3 / f4 <= ((float) i9) / f4 && ((float) zzclaVar2.zza) / f4 <= ((float) i10) / f4;
            }
            if (!z) {
                if (getVisibility() != 8) {
                    setVisibility(0);
                }
                if (!this.zzn) {
                    this.zzW.zzc(10002);
                    this.zzn = true;
                }
                zzcla zzclaVar3 = this.zzr;
                setMeasuredDimension(zzclaVar3.zzb, zzclaVar3.zza);
                return;
            }
            zzcla zzclaVar4 = this.zzr;
            float f5 = zzclaVar4.zzb;
            float f6 = this.zzj;
            zzcec.zzj("Not enough space to show ad. Needs " + ((int) (f5 / f6)) + "x" + ((int) (zzclaVar4.zza / f6)) + " dp, but only has " + ((int) (size4 / f6)) + "x" + ((int) (size5 / f6)) + " dp.");
            if (getVisibility() != 8) {
                setVisibility(4);
            }
            setMeasuredDimension(0, 0);
            if (this.zzm) {
                return;
            }
            this.zzW.zzc(10001);
            this.zzm = true;
            return;
        }
        super.onMeasure(i, i2);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcjk
    public final void onPause() {
        if (zzaB()) {
            return;
        }
        try {
            super.onPause();
        } catch (Exception e) {
            zzcec.zzh("Could not pause webview.", e);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcjk
    public final void onResume() {
        if (zzaB()) {
            return;
        }
        try {
            super.onResume();
        } catch (Exception e) {
            zzcec.zzh("Could not resume webview.", e);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.zzo.zzM() || this.zzo.zzK()) {
            zzavi zzaviVar = this.zzc;
            if (zzaviVar != null) {
                zzaviVar.zzd(motionEvent);
            }
            zzbhj zzbhjVar = this.zze;
            if (zzbhjVar != null) {
                zzbhjVar.zzb(motionEvent);
            }
        } else {
            synchronized (this) {
                zzbja zzbjaVar = this.zzD;
                if (zzbjaVar != null) {
                    zzbjaVar.zzd(motionEvent);
                }
            }
        }
        if (zzaB()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcjk
    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzcjs) {
            this.zzo = (zzcjs) webViewClient;
        }
    }

    @Override // android.webkit.WebView
    public final void stopLoading() {
        if (zzaB()) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception e) {
            zzcec.zzh("Could not stop loading webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final synchronized void zzA(int i) {
        this.zzM = i;
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final void zzB(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzcgl
    public final synchronized void zzC(zzcki zzckiVar) {
        if (this.zzA != null) {
            zzcec.zzg("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.zzA = zzckiVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzcjb
    public final zzfgm zzD() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final Context zzE() {
        return this.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzckv
    public final View zzF() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final WebView zzG() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final WebViewClient zzH() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzckt
    public final zzavi zzI() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized zzbad zzJ() {
        return this.zzF;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized zzbja zzK() {
        return this.zzD;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized com.google.android.gms.ads.internal.overlay.zzm zzL() {
        return this.zzp;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized com.google.android.gms.ads.internal.overlay.zzm zzM() {
        return this.zzN;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final /* synthetic */ zzcky zzN() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzcks
    public final synchronized zzcla zzO() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzckj
    public final zzfgp zzP() {
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final zzfhl zzQ() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized zzfod zzR() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final ListenableFuture zzS() {
        zzbhj zzbhjVar = this.zze;
        return zzbhjVar == null ? zzgen.zzh(null) : zzbhjVar.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized String zzT() {
        return this.zzs;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzU(zzfgm zzfgmVar, zzfgp zzfgpVar) {
        this.zzk = zzfgmVar;
        this.zzl = zzfgpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzV() {
        com.google.android.gms.ads.internal.util.zze.zza("Destroying WebView!");
        zzaW();
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzcke(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzW() {
        zzbb();
        HashMap map = new HashMap(1);
        map.put("version", this.zzf.zza);
        zzd("onhide", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzX(int i) {
        if (i == 0) {
            zzbgs zzbgsVar = this.zzL;
            zzbgm.zza(zzbgsVar.zza(), this.zzJ, "aebb2");
        }
        zzbb();
        this.zzL.zza();
        this.zzL.zza().zzd("close_type", String.valueOf(i));
        HashMap map = new HashMap(2);
        map.put("closetype", String.valueOf(i));
        map.put("version", this.zzf.zza);
        zzd("onhide", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzY() {
        if (this.zzI == null) {
            zzbgs zzbgsVar = this.zzL;
            zzbgm.zza(zzbgsVar.zza(), this.zzJ, "aes2");
            this.zzL.zza();
            zzbgr zzbgrVarZzf = zzbgu.zzf();
            this.zzI = zzbgrVarZzf;
            this.zzL.zzb("native:view_show", zzbgrVarZzf);
        }
        HashMap map = new HashMap(1);
        map.put("version", this.zzf.zza);
        zzd("onshow", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzZ() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbqn
    public final void zza(String str) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final boolean zzaA(final boolean z, final int i) {
        destroy();
        this.zzW.zzb(new zzbbo() { // from class: com.google.android.gms.internal.ads.zzckc
            @Override // com.google.android.gms.internal.ads.zzbbo
            public final void zza(zzbde zzbdeVar) {
                int i2 = zzckf.zza;
                zzbfj zzbfjVarZza = zzbfk.zza();
                boolean zZzc = zzbfjVarZza.zzc();
                boolean z2 = z;
                if (zZzc != z2) {
                    zzbfjVarZza.zza(z2);
                }
                zzbfjVarZza.zzb(i);
                zzbdeVar.zzj((zzbfk) zzbfjVarZza.zzal());
            }
        });
        this.zzW.zzc(10003);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized boolean zzaB() {
        return this.zzu;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized boolean zzaC() {
        return this.zzv;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final boolean zzaD() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized boolean zzaE() {
        return this.zzy;
    }

    @Override // com.google.android.gms.internal.ads.zzckq
    public final void zzaF(com.google.android.gms.ads.internal.overlay.zzc zzcVar, boolean z) {
        this.zzo.zzu(zzcVar, z);
    }

    @Override // com.google.android.gms.internal.ads.zzckq
    public final void zzaG(String str, String str2, int i) {
        this.zzo.zzv(str, str2, 14);
    }

    @Override // com.google.android.gms.internal.ads.zzckq
    public final void zzaH(boolean z, int i, boolean z2) {
        this.zzo.zzw(z, i, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzckq
    public final void zzaI(boolean z, int i, String str, String str2, boolean z2) {
        this.zzo.zzy(z, i, str, str2, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzckq
    public final void zzaJ(boolean z, int i, String str, boolean z2, boolean z3) {
        this.zzo.zzz(z, i, str, z2, z3);
    }

    public final zzcjs zzaL() {
        return this.zzo;
    }

    final synchronized Boolean zzaM() {
        return this.zzx;
    }

    protected final synchronized void zzaP(String str, ValueCallback valueCallback) {
        if (zzaB()) {
            zzcec.zzj("#004 The webview is destroyed. Ignoring action.");
        } else {
            evaluateJavascript(str, null);
        }
    }

    protected final void zzaQ(String str) {
        if (!PlatformVersion.isAtLeastKitKat()) {
            zzaS("javascript:".concat(str));
            return;
        }
        if (zzaM() == null) {
            zzbe();
        }
        if (zzaM().booleanValue()) {
            zzaP(str, null);
        } else {
            zzaS("javascript:".concat(str));
        }
    }

    final /* synthetic */ void zzaR(String str, ValueCallback valueCallback) {
        super.evaluateJavascript(str, valueCallback);
    }

    protected final synchronized void zzaS(String str) {
        if (zzaB()) {
            zzcec.zzj("#004 The webview is destroyed. Ignoring action.");
        } else {
            loadUrl(str);
        }
    }

    final void zzaT(Boolean bool) {
        synchronized (this) {
            this.zzx = bool;
        }
        com.google.android.gms.ads.internal.zzt.zzo().zzx(bool);
    }

    public final boolean zzaU() {
        int i;
        int iZzv;
        if (this.zzo.zzL() || this.zzo.zzM()) {
            com.google.android.gms.ads.internal.client.zzay.zzb();
            DisplayMetrics displayMetrics = this.zzi;
            int iZzv2 = zzcdv.zzv(displayMetrics, displayMetrics.widthPixels);
            com.google.android.gms.ads.internal.client.zzay.zzb();
            DisplayMetrics displayMetrics2 = this.zzi;
            int iZzv3 = zzcdv.zzv(displayMetrics2, displayMetrics2.heightPixels);
            Activity activityZza = this.zzb.zza();
            if (activityZza == null || activityZza.getWindow() == null) {
                i = iZzv2;
                iZzv = iZzv3;
            } else {
                com.google.android.gms.ads.internal.zzt.zzp();
                int[] iArrZzP = com.google.android.gms.ads.internal.util.zzt.zzP(activityZza);
                com.google.android.gms.ads.internal.client.zzay.zzb();
                int iZzv4 = zzcdv.zzv(this.zzi, iArrZzP[0]);
                com.google.android.gms.ads.internal.client.zzay.zzb();
                iZzv = zzcdv.zzv(this.zzi, iArrZzP[1]);
                i = iZzv4;
            }
            int i2 = this.zzR;
            if (i2 != iZzv2 || this.zzQ != iZzv3 || this.zzS != i || this.zzT != iZzv) {
                boolean z = (i2 == iZzv2 && this.zzQ == iZzv3) ? false : true;
                this.zzR = iZzv2;
                this.zzQ = iZzv3;
                this.zzS = i;
                this.zzT = iZzv;
                new zzbvw(this, "").zzj(iZzv2, iZzv3, i, iZzv, this.zzi.density, this.zzV.getDefaultDisplay().getRotation());
                return z;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzaa(boolean z) {
        this.zzo.zzi(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzab() {
        this.zzP.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzac(String str, String str2, String str3) {
        String str4;
        if (zzaB()) {
            zzcec.zzj("#004 The webview is destroyed. Ignoring action.");
            return;
        }
        String str5 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzP);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", str5);
            jSONObject.put("sdk", "Google Mobile Ads");
            jSONObject.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, "12.4.51-000");
            str4 = "<script>Object.defineProperty(window,'MRAID_ENV',{get:function(){return " + jSONObject.toString() + "}});</script>";
        } catch (JSONException e) {
            zzcec.zzk("Unable to build MRAID_ENV", e);
            str4 = null;
        }
        super.loadDataWithBaseURL(str, zzckr.zza(str2, str4), "text/html", Key.STRING_CHARSET_NAME, null);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzad() {
        if (this.zzK == null) {
            this.zzL.zza();
            zzbgr zzbgrVarZzf = zzbgu.zzf();
            this.zzK = zzbgrVarZzf;
            this.zzL.zzb("native:view_load", zzbgrVarZzf);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzae(String str, zzbng zzbngVar) {
        zzcjs zzcjsVar = this.zzo;
        if (zzcjsVar != null) {
            zzcjsVar.zzA(str, zzbngVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzaf() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzag(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.zzp = zzmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzah(zzcla zzclaVar) {
        this.zzr = zzclaVar;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzai(zzbad zzbadVar) {
        this.zzF = zzbadVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzaj(boolean z) {
        this.zzy = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzak() {
        setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzal(Context context) {
        this.zzb.setBaseContext(context);
        this.zzP.zze(this.zzb.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzam(boolean z) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzp;
        if (zzmVar != null) {
            zzmVar.zzy(this.zzo.zzL(), z);
        } else {
            this.zzt = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzan(zzbiy zzbiyVar) {
        this.zzE = zzbiyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzao(boolean z) {
        boolean z2 = this.zzv;
        this.zzv = z;
        zzaV();
        if (z != z2) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzQ)).booleanValue() || !this.zzr.zzi()) {
                new zzbvw(this, "").zzl(true != z ? "default" : "expanded");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzap(zzbja zzbjaVar) {
        this.zzD = zzbjaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzaq(zzfod zzfodVar) {
        this.zzq = zzfodVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzar(int i) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzp;
        if (zzmVar != null) {
            zzmVar.zzA(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzas(boolean z) {
        this.zzX = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzat(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.zzN = zzmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzau(boolean z) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar;
        int i = this.zzG + (true != z ? -1 : 1);
        this.zzG = i;
        if (i > 0 || (zzmVar = this.zzp) == null) {
            return;
        }
        zzmVar.zzE();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0010 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:8:0x000b A[Catch: all -> 0x0012, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0004, B:6:0x0007, B:8:0x000b), top: B:16:0x0004 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:11:0x0010, please report this as an issue */
    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized void zzav(boolean z) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar;
        if (!z) {
            zzmVar = this.zzp;
            if (zzmVar != null) {
                zzmVar.zzB(z);
                return;
            }
            return;
        }
        setBackgroundColor(0);
        zzmVar = this.zzp;
        if (zzmVar != null) {
            zzmVar.zzB(z);
            return;
        }
        return;
        throw th;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzaw(String str, zzbng zzbngVar) {
        zzcjs zzcjsVar = this.zzo;
        if (zzcjsVar != null) {
            zzcjsVar.zzI(str, zzbngVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final void zzax(String str, Predicate predicate) {
        zzcjs zzcjsVar = this.zzo;
        if (zzcjsVar != null) {
            zzcjsVar.zzJ(str, predicate);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized boolean zzay() {
        return this.zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk
    public final synchronized boolean zzaz() {
        return this.zzG > 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbqn
    public final void zzb(String str, String str2) {
        zzaQ(str + "(" + str2 + ");");
    }

    @Override // com.google.android.gms.internal.ads.zzdiu
    public final void zzbo() {
        zzcjs zzcjsVar = this.zzo;
        if (zzcjsVar != null) {
            zzcjsVar.zzbo();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzl
    public final synchronized void zzbp() {
        com.google.android.gms.ads.internal.zzl zzlVar = this.zzg;
        if (zzlVar != null) {
            zzlVar.zzbp();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzl
    public final synchronized void zzbq() {
        com.google.android.gms.ads.internal.zzl zzlVar = this.zzg;
        if (zzlVar != null) {
            zzlVar.zzbq();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final synchronized String zzbr() {
        return this.zzz;
    }

    @Override // com.google.android.gms.internal.ads.zzayq
    public final void zzby(zzayp zzaypVar) {
        synchronized (this) {
            this.zzB = zzaypVar.zzj;
        }
        zzaY(zzaypVar.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzbqa
    public final void zzd(String str, Map map) {
        try {
            zze(str, com.google.android.gms.ads.internal.client.zzay.zzb().zzi(map));
        } catch (JSONException unused) {
            zzcec.zzj("Could not convert parameters to JSON.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbqa
    public final void zze(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String string = jSONObject.toString();
        StringBuilder sb = new StringBuilder("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("',");
        sb.append(string);
        sb.append(");");
        zzcec.zze("Dispatching AFMA event: ".concat(sb.toString()));
        zzaQ(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final synchronized int zzf() {
        return this.zzM;
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final int zzg() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final int zzh() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzckn, com.google.android.gms.internal.ads.zzcgl
    public final Activity zzi() {
        return this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzcgl
    public final com.google.android.gms.ads.internal.zza zzj() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final zzbgr zzk() {
        return this.zzJ;
    }

    @Override // com.google.android.gms.internal.ads.zzbqn
    public final void zzl(String str, JSONObject jSONObject) {
        zzb(str, jSONObject.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzcgl
    public final zzbgs zzm() {
        return this.zzL;
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzcku, com.google.android.gms.internal.ads.zzcgl
    public final zzcei zzn() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final zzcga zzo() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final synchronized zzchw zzp(String str) {
        Map map = this.zzU;
        if (map == null) {
            return null;
        }
        return (zzchw) map.get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzcgl
    public final synchronized zzcki zzq() {
        return this.zzA;
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final synchronized String zzr() {
        zzfgp zzfgpVar = this.zzl;
        if (zzfgpVar == null) {
            return null;
        }
        return zzfgpVar.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdiu
    public final void zzs() {
        zzcjs zzcjsVar = this.zzo;
        if (zzcjsVar != null) {
            zzcjsVar.zzs();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcjk, com.google.android.gms.internal.ads.zzcgl
    public final synchronized void zzt(String str, zzchw zzchwVar) {
        if (this.zzU == null) {
            this.zzU = new HashMap();
        }
        this.zzU.put(str, zzchwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final void zzu() {
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = zzL();
        if (zzmVarZzL != null) {
            zzmVarZzL.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final void zzv(boolean z, long j) {
        HashMap map = new HashMap(2);
        map.put(FirebaseAnalytics.Param.SUCCESS, true != z ? "0" : "1");
        map.put(TypedValues.Transition.S_DURATION, Long.toString(j));
        zzd("onCacheAccessComplete", map);
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final synchronized void zzw() {
        zzbiy zzbiyVar = this.zzE;
        if (zzbiyVar != null) {
            final zzdra zzdraVar = (zzdra) zzbiyVar;
            com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdqy
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        zzdraVar.zzd();
                    } catch (RemoteException e) {
                        zzcec.zzl("#007 Could not call remote method.", e);
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final void zzx(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final void zzy(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzcgl
    public final void zzz(boolean z) {
        this.zzo.zzD(false);
    }
}
