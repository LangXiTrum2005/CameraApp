package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toolbar;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.bumptech.glide.load.Key;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbbp;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzblw;
import com.google.android.gms.internal.ads.zzbly;
import com.google.android.gms.internal.ads.zzbvw;
import com.google.android.gms.internal.ads.zzbwm;
import com.google.android.gms.internal.ads.zzbws;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzcei;
import com.google.android.gms.internal.ads.zzcjk;
import com.google.android.gms.internal.ads.zzcjx;
import com.google.android.gms.internal.ads.zzckw;
import com.google.android.gms.internal.ads.zzcky;
import com.google.android.gms.internal.ads.zzcla;
import com.google.android.gms.internal.ads.zzdbk;
import com.google.android.gms.internal.ads.zzdiu;
import com.google.android.gms.internal.ads.zzeht;
import com.google.android.gms.internal.ads.zzehu;
import com.google.android.gms.internal.ads.zzfod;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
public class zzm extends zzbws implements zzae {
    static final int zza = Color.argb(0, 0, 0, 0);
    protected final Activity zzb;
    AdOverlayInfoParcel zzc;
    zzcjk zzd;
    zzi zze;
    zzs zzf;
    FrameLayout zzh;
    WebChromeClient.CustomViewCallback zzi;
    zzh zzl;
    private Runnable zzq;
    private boolean zzr;
    private boolean zzs;
    private Toolbar zzw;
    boolean zzg = false;
    boolean zzj = false;
    boolean zzk = false;
    boolean zzm = false;
    int zzn = 1;
    private final Object zzo = new Object();
    private final View.OnClickListener zzp = new zzf(this);
    private boolean zzt = false;
    private boolean zzu = false;
    private boolean zzv = true;

    public zzm(Activity activity) {
        this.zzb = activity;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0033 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0035  */
    /* JADX WARN: Code duplicated, block: B:19:0x0048  */
    private final void zzJ(Configuration configuration) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        com.google.android.gms.ads.internal.zzj zzjVar;
        int i;
        com.google.android.gms.ads.internal.zzj zzjVar2;
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = (adOverlayInfoParcel2 == null || (zzjVar2 = adOverlayInfoParcel2.zzo) == null || !zzjVar2.zzb) ? false : true;
        boolean zZzd = com.google.android.gms.ads.internal.zzt.zzq().zzd(this.zzb, configuration);
        if (!this.zzk || z3) {
            if (zZzd) {
                if (((Boolean) zzba.zzc().zza(zzbgc.zzaE)).booleanValue()) {
                    z = false;
                }
            }
            adOverlayInfoParcel = this.zzc;
            if (adOverlayInfoParcel != null && (zzjVar = adOverlayInfoParcel.zzo) != null && zzjVar.zzg) {
                z2 = true;
            }
        } else if (((Boolean) zzba.zzc().zza(zzbgc.zzaF)).booleanValue()) {
            if (zZzd) {
                if (((Boolean) zzba.zzc().zza(zzbgc.zzaE)).booleanValue()) {
                    z = false;
                }
            }
            adOverlayInfoParcel = this.zzc;
            if (adOverlayInfoParcel != null) {
                z2 = true;
            }
        } else {
            z = false;
        }
        Window window = this.zzb.getWindow();
        if (((Boolean) zzba.zzc().zza(zzbgc.zzbe)).booleanValue()) {
            View decorView = window.getDecorView();
            if (z) {
                i = z2 ? 5894 : 5380;
            } else {
                i = 256;
            }
            decorView.setSystemUiVisibility(i);
            return;
        }
        if (!z) {
            window.addFlags(2048);
            window.clearFlags(1024);
            return;
        }
        window.addFlags(1024);
        window.clearFlags(2048);
        if (z2) {
            window.getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        }
    }

    private static final void zzK(zzfod zzfodVar, View view) {
        if (zzfodVar == null || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzA().zzh(zzfodVar, view);
    }

    public final void zzA(int i) {
        if (this.zzb.getApplicationInfo().targetSdkVersion >= ((Integer) zzba.zzc().zza(zzbgc.zzfY)).intValue()) {
            if (this.zzb.getApplicationInfo().targetSdkVersion <= ((Integer) zzba.zzc().zza(zzbgc.zzfZ)).intValue()) {
                if (Build.VERSION.SDK_INT >= ((Integer) zzba.zzc().zza(zzbgc.zzga)).intValue()) {
                    if (Build.VERSION.SDK_INT <= ((Integer) zzba.zzc().zza(zzbgc.zzgb)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.zzb.setRequestedOrientation(i);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzt.zzo().zzv(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zzB(boolean z) {
        if (z) {
            this.zzl.setBackgroundColor(0);
        } else {
            this.zzl.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    public final void zzC(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        FrameLayout frameLayout = new FrameLayout(this.zzb);
        this.zzh = frameLayout;
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.zzh.addView(view, -1, -1);
        this.zzb.setContentView(this.zzh);
        this.zzs = true;
        this.zzi = customViewCallback;
        this.zzg = true;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0064  */
    protected final void zzD(boolean z) throws zzg {
        boolean z2;
        if (!this.zzs) {
            this.zzb.requestWindowFeature(1);
        }
        Window window = this.zzb.getWindow();
        if (window == null) {
            throw new zzg("Invalid activity, no window available.");
        }
        zzcjk zzcjkVar = this.zzc.zzd;
        zzcky zzckyVarZzN = zzcjkVar != null ? zzcjkVar.zzN() : null;
        boolean z3 = zzckyVarZzN != null && zzckyVarZzN.zzL();
        this.zzm = false;
        if (z3) {
            int i = this.zzc.zzj;
            if (i == 6) {
                z2 = this.zzb.getResources().getConfiguration().orientation == 1;
                this.zzm = z2;
            } else if (i == 7) {
                z2 = this.zzb.getResources().getConfiguration().orientation == 2;
                this.zzm = z2;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        zzcec.zze("Delay onShow to next orientation change: " + z2);
        zzA(this.zzc.zzj);
        window.setFlags(16777216, 16777216);
        zzcec.zze("Hardware acceleration on the AdActivity window enabled.");
        if (this.zzk) {
            this.zzl.setBackgroundColor(zza);
        } else {
            this.zzl.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.zzb.setContentView(this.zzl);
        this.zzs = true;
        if (z) {
            try {
                com.google.android.gms.ads.internal.zzt.zzz();
                Activity activity = this.zzb;
                zzcjk zzcjkVar2 = this.zzc.zzd;
                zzcla zzclaVarZzO = zzcjkVar2 != null ? zzcjkVar2.zzO() : null;
                zzcjk zzcjkVar3 = this.zzc.zzd;
                String strZzT = zzcjkVar3 != null ? zzcjkVar3.zzT() : null;
                AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
                zzcei zzceiVar = adOverlayInfoParcel.zzm;
                zzcjk zzcjkVar4 = adOverlayInfoParcel.zzd;
                zzcjk zzcjkVarZza = zzcjx.zza(activity, zzclaVarZzO, strZzT, true, z3, null, null, zzceiVar, null, null, zzcjkVar4 != null ? zzcjkVar4.zzj() : null, zzbbp.zza(), null, null, null, null);
                this.zzd = zzcjkVarZza;
                zzcky zzckyVarZzN2 = zzcjkVarZza.zzN();
                AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
                zzblw zzblwVar = adOverlayInfoParcel2.zzp;
                zzbly zzblyVar = adOverlayInfoParcel2.zze;
                zzaa zzaaVar = adOverlayInfoParcel2.zzi;
                zzcjk zzcjkVar5 = adOverlayInfoParcel2.zzd;
                zzckyVarZzN2.zzN(null, zzblwVar, null, zzblyVar, zzaaVar, true, null, zzcjkVar5 != null ? zzcjkVar5.zzN().zzd() : null, null, null, null, null, null, null, null, null, null, null, null);
                this.zzd.zzN().zzB(new zzckw() { // from class: com.google.android.gms.ads.internal.overlay.zze
                    @Override // com.google.android.gms.internal.ads.zzckw
                    public final void zza(boolean z4, int i2, String str, String str2) {
                        zzcjk zzcjkVar6 = this.zza.zzd;
                        if (zzcjkVar6 != null) {
                            zzcjkVar6.zzY();
                        }
                    }
                });
                AdOverlayInfoParcel adOverlayInfoParcel3 = this.zzc;
                String str = adOverlayInfoParcel3.zzl;
                if (str != null) {
                    this.zzd.loadUrl(str);
                } else {
                    String str2 = adOverlayInfoParcel3.zzh;
                    if (str2 == null) {
                        throw new zzg("No URL or HTML to display in ad overlay.");
                    }
                    this.zzd.loadDataWithBaseURL(adOverlayInfoParcel3.zzf, str2, "text/html", Key.STRING_CHARSET_NAME, null);
                }
                zzcjk zzcjkVar6 = this.zzc.zzd;
                if (zzcjkVar6 != null) {
                    zzcjkVar6.zzat(this);
                }
            } catch (Exception e) {
                zzcec.zzh("Error obtaining webview.", e);
                throw new zzg("Could not obtain webview for the overlay.", e);
            }
        } else {
            zzcjk zzcjkVar7 = this.zzc.zzd;
            this.zzd = zzcjkVar7;
            zzcjkVar7.zzal(this.zzb);
        }
        if (this.zzc.zzw) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.zzd.zzG(), false);
        }
        this.zzd.zzag(this);
        zzcjk zzcjkVar8 = this.zzc.zzd;
        if (zzcjkVar8 != null) {
            zzK(zzcjkVar8.zzR(), this.zzl);
        }
        if (this.zzc.zzk != 5) {
            ViewParent parent = this.zzd.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this.zzd.zzF());
            }
            if (this.zzk) {
                this.zzd.zzak();
            }
            if (!this.zzc.zzw || Build.VERSION.SDK_INT < 24) {
                this.zzl.addView(this.zzd.zzF(), -1, -1);
            } else {
                Toolbar toolbar = new Toolbar(this.zzb);
                this.zzw = toolbar;
                toolbar.setId(View.generateViewId());
                this.zzd.zzF().setId(View.generateViewId());
                this.zzw.setBackgroundColor(-12303292);
                this.zzw.setVisibility(0);
                this.zzw.setNavigationIcon(com.google.android.gms.ads.internal.zzt.zzo().zze().getDrawable(R.drawable.admob_close_button_white_cross));
                this.zzw.setNavigationOnClickListener(this.zzp);
                this.zzw.setTitleMarginStart(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(10);
                this.zzl.addView(this.zzw, layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(3, this.zzw.getId());
                layoutParams2.addRule(12);
                this.zzl.addView(this.zzd.zzF(), layoutParams2);
            }
        }
        if (!z && !this.zzm) {
            zze();
        }
        if (this.zzc.zzk != 5) {
            zzw(z3);
            if (this.zzd.zzay()) {
                zzy(z3, true);
                return;
            }
            return;
        }
        Activity activity2 = this.zzb;
        zzeht zzehtVarZze = zzehu.zze();
        zzehtVarZze.zza(activity2);
        zzehtVarZze.zzb(this);
        zzehtVarZze.zzc(this.zzc.zzq);
        zzehtVarZze.zzd(this.zzc.zzr);
        try {
            zzf(zzehtVarZze.zze());
        } catch (RemoteException | zzg e2) {
            throw new zzg(e2.getMessage(), e2);
        }
    }

    public final void zzE() {
        synchronized (this.zzo) {
            this.zzr = true;
            if (this.zzq != null) {
                com.google.android.gms.ads.internal.util.zzt.zza.removeCallbacks(this.zzq);
                com.google.android.gms.ads.internal.util.zzt.zza.post(this.zzq);
            }
        }
    }

    protected final void zzF() {
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzp zzpVar;
        if (!this.zzb.isFinishing() || this.zzt) {
            return;
        }
        this.zzt = true;
        zzcjk zzcjkVar = this.zzd;
        if (zzcjkVar != null) {
            zzcjkVar.zzX(this.zzn - 1);
            synchronized (this.zzo) {
                if (!this.zzr && this.zzd.zzaz()) {
                    if (((Boolean) zzba.zzc().zza(zzbgc.zzeI)).booleanValue() && !this.zzu && (adOverlayInfoParcel = this.zzc) != null && (zzpVar = adOverlayInfoParcel.zzc) != null) {
                        zzpVar.zzbz();
                    }
                    this.zzq = new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzd
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zza.zzc();
                        }
                    };
                    com.google.android.gms.ads.internal.util.zzt.zza.postDelayed(this.zzq, ((Long) zzba.zzc().zza(zzbgc.zzaX)).longValue());
                    return;
                }
            }
        }
        zzc();
    }

    public final void zzG(String str) {
        Toolbar toolbar = this.zzw;
        if (toolbar != null) {
            toolbar.setSubtitle(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final boolean zzH() {
        this.zzn = 1;
        if (this.zzd == null) {
            return true;
        }
        if (((Boolean) zzba.zzc().zza(zzbgc.zziN)).booleanValue() && this.zzd.canGoBack()) {
            this.zzd.goBack();
            return false;
        }
        boolean zZzaE = this.zzd.zzaE();
        if (!zZzaE) {
            this.zzd.zzd("onbackblocked", Collections.emptyMap());
        }
        return zZzaE;
    }

    public final void zzb() {
        this.zzn = 3;
        this.zzb.finish();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || adOverlayInfoParcel.zzk != 5) {
            return;
        }
        this.zzb.overridePendingTransition(0, 0);
    }

    final void zzc() {
        zzcjk zzcjkVar;
        zzp zzpVar;
        if (this.zzu) {
            return;
        }
        this.zzu = true;
        zzcjk zzcjkVar2 = this.zzd;
        if (zzcjkVar2 != null) {
            this.zzl.removeView(zzcjkVar2.zzF());
            zzi zziVar = this.zze;
            if (zziVar != null) {
                this.zzd.zzal(zziVar.zzd);
                this.zzd.zzao(false);
                ViewGroup viewGroup = this.zze.zzc;
                View viewZzF = this.zzd.zzF();
                zzi zziVar2 = this.zze;
                viewGroup.addView(viewZzF, zziVar2.zza, zziVar2.zzb);
                this.zze = null;
            } else if (this.zzb.getApplicationContext() != null) {
                this.zzd.zzal(this.zzb.getApplicationContext());
            }
            this.zzd = null;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzpVar = adOverlayInfoParcel.zzc) != null) {
            zzpVar.zzbD(this.zzn);
        }
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
        if (adOverlayInfoParcel2 == null || (zzcjkVar = adOverlayInfoParcel2.zzd) == null) {
            return;
        }
        zzK(zzcjkVar.zzR(), this.zzc.zzd.zzF());
    }

    public final void zzd() {
        this.zzl.zzb = true;
    }

    protected final void zze() {
        this.zzd.zzY();
    }

    public final void zzf(zzehu zzehuVar) throws RemoteException, zzg {
        zzbwm zzbwmVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || (zzbwmVar = adOverlayInfoParcel.zzv) == null) {
            throw new zzg("noioou");
        }
        zzbwmVar.zzg(ObjectWrapper.wrap(zzehuVar));
    }

    public final void zzg() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && this.zzg) {
            zzA(adOverlayInfoParcel.zzj);
        }
        if (this.zzh != null) {
            this.zzb.setContentView(this.zzl);
            this.zzs = true;
            this.zzh.removeAllViews();
            this.zzh = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzi;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzi = null;
        }
        this.zzg = false;
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzh(int i, int i2, Intent intent) {
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzi() {
        this.zzn = 1;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzae
    public final void zzj() {
        this.zzn = 2;
        this.zzb.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzk(IObjectWrapper iObjectWrapper) {
        zzJ((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public void zzl(Bundle bundle) {
        if (!this.zzs) {
            this.zzb.requestWindowFeature(1);
        }
        this.zzj = bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        try {
            AdOverlayInfoParcel adOverlayInfoParcelZza = AdOverlayInfoParcel.zza(this.zzb.getIntent());
            this.zzc = adOverlayInfoParcelZza;
            if (adOverlayInfoParcelZza == null) {
                throw new zzg("Could not get info for ad overlay.");
            }
            if (adOverlayInfoParcelZza.zzw) {
                if (Build.VERSION.SDK_INT >= 28) {
                    this.zzb.setShowWhenLocked(true);
                } else {
                    this.zzb.getWindow().addFlags(524288);
                }
            }
            if (this.zzc.zzm.zzc > 7500000) {
                this.zzn = 4;
            }
            if (this.zzb.getIntent() != null) {
                this.zzv = this.zzb.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
            com.google.android.gms.ads.internal.zzj zzjVar = adOverlayInfoParcel.zzo;
            if (zzjVar != null) {
                boolean z = zzjVar.zza;
                this.zzk = z;
                if (z) {
                    if (adOverlayInfoParcel.zzk != 5 && zzjVar.zzf != -1) {
                        new zzl(this, null).zzb();
                    }
                }
            } else if (adOverlayInfoParcel.zzk == 5) {
                this.zzk = true;
                if (adOverlayInfoParcel.zzk != 5) {
                    new zzl(this, null).zzb();
                }
            } else {
                this.zzk = false;
            }
            if (bundle == null) {
                if (this.zzv) {
                    zzdbk zzdbkVar = this.zzc.zzt;
                    if (zzdbkVar != null) {
                        zzdbkVar.zze();
                    }
                    zzp zzpVar = this.zzc.zzc;
                    if (zzpVar != null) {
                        zzpVar.zzbA();
                    }
                }
                AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
                if (adOverlayInfoParcel2.zzk != 1) {
                    com.google.android.gms.ads.internal.client.zza zzaVar = adOverlayInfoParcel2.zzb;
                    if (zzaVar != null) {
                        zzaVar.onAdClicked();
                    }
                    zzdiu zzdiuVar = this.zzc.zzu;
                    if (zzdiuVar != null) {
                        zzdiuVar.zzs();
                    }
                }
            }
            Activity activity = this.zzb;
            AdOverlayInfoParcel adOverlayInfoParcel3 = this.zzc;
            zzh zzhVar = new zzh(activity, adOverlayInfoParcel3.zzn, adOverlayInfoParcel3.zzm.zza, adOverlayInfoParcel3.zzs);
            this.zzl = zzhVar;
            zzhVar.setId(1000);
            com.google.android.gms.ads.internal.zzt.zzq().zzk(this.zzb);
            AdOverlayInfoParcel adOverlayInfoParcel4 = this.zzc;
            int i = adOverlayInfoParcel4.zzk;
            if (i == 1) {
                zzD(false);
                return;
            }
            if (i == 2) {
                this.zze = new zzi(adOverlayInfoParcel4.zzd);
                zzD(false);
            } else if (i == 3) {
                zzD(true);
            } else {
                if (i != 5) {
                    throw new zzg("Could not determine ad overlay type.");
                }
                zzD(false);
            }
        } catch (zzg e) {
            zzcec.zzj(e.getMessage());
            this.zzn = 4;
            this.zzb.finish();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzm() {
        zzcjk zzcjkVar = this.zzd;
        if (zzcjkVar != null) {
            try {
                this.zzl.removeView(zzcjkVar.zzF());
            } catch (NullPointerException unused) {
            }
        }
        zzF();
    }

    public final void zzn() {
        if (this.zzm) {
            this.zzm = false;
            zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzo() {
        zzp zzpVar;
        zzg();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzpVar = adOverlayInfoParcel.zzc) != null) {
            zzpVar.zzbt();
        }
        if (!((Boolean) zzba.zzc().zza(zzbgc.zzeK)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzF();
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzp(int i, String[] strArr, int[] iArr) {
        if (i == 12345) {
            Activity activity = this.zzb;
            zzeht zzehtVarZze = zzehu.zze();
            zzehtVarZze.zza(activity);
            zzehtVarZze.zzb(this.zzc.zzk == 5 ? this : null);
            try {
                this.zzc.zzv.zzf(strArr, iArr, ObjectWrapper.wrap(zzehtVarZze.zze()));
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzq() {
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzr() {
        zzp zzpVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzpVar = adOverlayInfoParcel.zzc) != null) {
            zzpVar.zzbP();
        }
        zzJ(this.zzb.getResources().getConfiguration());
        if (((Boolean) zzba.zzc().zza(zzbgc.zzeK)).booleanValue()) {
            return;
        }
        zzcjk zzcjkVar = this.zzd;
        if (zzcjkVar == null || zzcjkVar.zzaB()) {
            zzcec.zzj("The webview does not exist. Ignoring action.");
        } else {
            this.zzd.onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzs(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzt() {
        if (((Boolean) zzba.zzc().zza(zzbgc.zzeK)).booleanValue()) {
            zzcjk zzcjkVar = this.zzd;
            if (zzcjkVar == null || zzcjkVar.zzaB()) {
                zzcec.zzj("The webview does not exist. Ignoring action.");
            } else {
                this.zzd.onResume();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzu() {
        if (((Boolean) zzba.zzc().zza(zzbgc.zzeK)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzF();
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzv() {
        zzp zzpVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || (zzpVar = adOverlayInfoParcel.zzc) == null) {
            return;
        }
        zzpVar.zzbC();
    }

    public final void zzw(boolean z) {
        if (this.zzc.zzw) {
            return;
        }
        int iIntValue = ((Integer) zzba.zzc().zza(zzbgc.zzeN)).intValue();
        boolean z2 = ((Boolean) zzba.zzc().zza(zzbgc.zzba)).booleanValue() || z;
        zzr zzrVar = new zzr();
        zzrVar.zzd = 50;
        zzrVar.zza = true != z2 ? 0 : iIntValue;
        zzrVar.zzb = true != z2 ? iIntValue : 0;
        zzrVar.zzc = iIntValue;
        this.zzf = new zzs(this.zzb, zzrVar, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(true != z2 ? 9 : 11);
        zzy(z, this.zzc.zzg);
        this.zzl.addView(this.zzf, layoutParams);
    }

    @Override // com.google.android.gms.internal.ads.zzbwt
    public final void zzx() {
        this.zzs = true;
    }

    public final void zzy(boolean z, boolean z2) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        com.google.android.gms.ads.internal.zzj zzjVar;
        AdOverlayInfoParcel adOverlayInfoParcel2;
        com.google.android.gms.ads.internal.zzj zzjVar2;
        boolean z3 = true;
        boolean z4 = ((Boolean) zzba.zzc().zza(zzbgc.zzaY)).booleanValue() && (adOverlayInfoParcel2 = this.zzc) != null && (zzjVar2 = adOverlayInfoParcel2.zzo) != null && zzjVar2.zzh;
        boolean z5 = ((Boolean) zzba.zzc().zza(zzbgc.zzaZ)).booleanValue() && (adOverlayInfoParcel = this.zzc) != null && (zzjVar = adOverlayInfoParcel.zzo) != null && zzjVar.zzi;
        if (z && z2 && z4 && !z5) {
            new zzbvw(this.zzd, "useCustomClose").zzh("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        zzs zzsVar = this.zzf;
        if (zzsVar != null) {
            if (!z5 && (!z2 || z4)) {
                z3 = false;
            }
            zzsVar.zzb(z3);
        }
    }

    public final void zzz() {
        this.zzl.removeView(this.zzf);
        zzw(true);
    }
}
