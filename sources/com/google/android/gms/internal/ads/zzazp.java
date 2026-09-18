package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.common.util.PlatformVersion;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public final class zzazp extends Thread {
    private boolean zza;
    private boolean zzb;
    private final Object zzc;
    private final zzazg zzd;
    private final int zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final String zzm;
    private final boolean zzn;
    private final boolean zzo;
    private final boolean zzp;

    public zzazp() {
        zzazg zzazgVar = new zzazg();
        this.zza = false;
        this.zzb = false;
        this.zzd = zzazgVar;
        this.zzc = new Object();
        this.zzf = ((Long) zzbhs.zzd.zze()).intValue();
        this.zzg = ((Long) zzbhs.zza.zze()).intValue();
        this.zzh = ((Long) zzbhs.zze.zze()).intValue();
        this.zzi = ((Long) zzbhs.zzc.zze()).intValue();
        this.zzj = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzS)).intValue();
        this.zzk = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzT)).intValue();
        this.zzl = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzU)).intValue();
        this.zze = ((Long) zzbhs.zzf.zze()).intValue();
        this.zzm = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzW);
        this.zzn = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzX)).booleanValue();
        this.zzo = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzY)).booleanValue();
        this.zzp = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzZ)).booleanValue();
        setName("ContentFetchTask");
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x00ee */
    /* JADX WARN: Code duplicated, block: B:63:0x00e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x00dc A[EXC_TOP_SPLITTER, LOOP:1: B:65:0x00dc->B:70:0x00dc, LOOP_START, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazp.run():void");
    }

    public final zzazf zza() {
        return this.zzd.zza(this.zzp);
    }

    final zzazo zzb(View view, zzazf zzazfVar) {
        if (view != null) {
            boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
            if ((view instanceof TextView) && !(view instanceof EditText)) {
                CharSequence text = ((TextView) view).getText();
                if (!TextUtils.isEmpty(text)) {
                    zzazfVar.zzk(text.toString(), globalVisibleRect, view.getX(), view.getY(), view.getWidth(), view.getHeight());
                    return new zzazo(this, 1, 0);
                }
            } else if ((view instanceof WebView) && !(view instanceof zzcjk)) {
                WebView webView = (WebView) view;
                if (PlatformVersion.isAtLeastKitKat()) {
                    zzazfVar.zzh();
                    webView.post(new zzazn(this, zzazfVar, webView, globalVisibleRect));
                    return new zzazo(this, 0, 1);
                }
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int i = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                    zzazo zzazoVarZzb = zzb(viewGroup.getChildAt(i3), zzazfVar);
                    i += zzazoVarZzb.zza;
                    i2 += zzazoVarZzb.zzb;
                }
                return new zzazo(this, i, i2);
            }
        }
        return new zzazo(this, 0, 0);
    }

    final void zzc(View view) {
        try {
            zzazf zzazfVar = new zzazf(this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzo);
            Context contextZzb = com.google.android.gms.ads.internal.zzt.zzb().zzb();
            if (contextZzb != null && !TextUtils.isEmpty(this.zzm)) {
                String str = (String) view.getTag(contextZzb.getResources().getIdentifier((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzV), "id", contextZzb.getPackageName()));
                if (str != null && str.equals(this.zzm)) {
                    return;
                }
            }
            zzazo zzazoVarZzb = zzb(view, zzazfVar);
            zzazfVar.zzm();
            if (zzazoVarZzb.zza == 0 && zzazoVarZzb.zzb == 0) {
                return;
            }
            int i = zzazoVarZzb.zzb;
            if (i != 0) {
                if (i == 0) {
                }
                this.zzd.zzb(zzazfVar);
            } else if (zzazfVar.zzc() == 0) {
                return;
            }
            if (this.zzd.zzd(zzazfVar)) {
                return;
            }
            this.zzd.zzb(zzazfVar);
        } catch (Exception e) {
            zzcec.zzh("Exception in fetchContentOnUIThread", e);
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "ContentFetchTask.fetchContent");
        }
    }

    final void zzd(zzazf zzazfVar, WebView webView, String str, boolean z) {
        zzazfVar.zzg();
        try {
            if (!TextUtils.isEmpty(str)) {
                String strOptString = new JSONObject(str).optString("text");
                if (this.zzn || TextUtils.isEmpty(webView.getTitle())) {
                    zzazfVar.zzl(strOptString, z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                } else {
                    zzazfVar.zzl(webView.getTitle() + "\n" + strOptString, z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                }
            }
            if (zzazfVar.zzo()) {
                this.zzd.zzc(zzazfVar);
            }
        } catch (JSONException unused) {
            zzcec.zze("Json string may be malformed.");
        } catch (Throwable th) {
            zzcec.zzf("Failed to get webview content.", th);
            com.google.android.gms.ads.internal.zzt.zzo().zzw(th, "ContentFetchTask.processWebViewContent");
        }
    }

    public final void zze() {
        synchronized (this.zzc) {
            if (this.zza) {
                zzcec.zze("Content hash thread already started, quitting...");
            } else {
                this.zza = true;
                start();
            }
        }
    }

    public final void zzf() {
        synchronized (this.zzc) {
            this.zzb = true;
            zzcec.zze("ContentFetchThread: paused, pause = true");
        }
    }

    public final void zzg() {
        synchronized (this.zzc) {
            this.zzb = false;
            this.zzc.notifyAll();
            zzcec.zze("ContentFetchThread: wakeup");
        }
    }

    public final boolean zzh() {
        return this.zzb;
    }
}
