package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzckm {
    private final zzckn zza;
    private final zzckl zzb;

    public zzckm(zzckn zzcknVar, zzckl zzcklVar) {
        this.zzb = zzcklVar;
        this.zza = zzcknVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.ads.zzckn, com.google.android.gms.internal.ads.zzckt] */
    @JavascriptInterface
    public String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.ads.internal.util.zze.zza("Click string is empty, not proceeding.");
            return "";
        }
        ?? r0 = this.zza;
        zzavi zzaviVarZzI = r0.zzI();
        if (zzaviVarZzI == null) {
            com.google.android.gms.ads.internal.util.zze.zza("Signal utils is empty, ignoring.");
            return "";
        }
        zzave zzaveVarZzc = zzaviVarZzI.zzc();
        if (r0.getContext() == null) {
            com.google.android.gms.ads.internal.util.zze.zza("Context is null, ignoring.");
            return "";
        }
        zzckn zzcknVar = this.zza;
        return zzaveVarZzc.zzf(zzcknVar.getContext(), str, (View) zzcknVar, zzcknVar.zzi());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.ads.zzckn, com.google.android.gms.internal.ads.zzckt] */
    @JavascriptInterface
    public String getViewSignals() {
        ?? r0 = this.zza;
        zzavi zzaviVarZzI = r0.zzI();
        if (zzaviVarZzI == null) {
            com.google.android.gms.ads.internal.util.zze.zza("Signal utils is empty, ignoring.");
            return "";
        }
        zzave zzaveVarZzc = zzaviVarZzI.zzc();
        if (r0.getContext() == null) {
            com.google.android.gms.ads.internal.util.zze.zza("Context is null, ignoring.");
            return "";
        }
        zzckn zzcknVar = this.zza;
        return zzaveVarZzc.zzh(zzcknVar.getContext(), (View) zzcknVar, zzcknVar.zzi());
    }

    @JavascriptInterface
    public void notify(final String str) {
        if (TextUtils.isEmpty(str)) {
            zzcec.zzj("URL is empty, ignoring message");
        } else {
            com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzckk
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zza(str);
                }
            });
        }
    }

    final /* synthetic */ void zza(String str) {
        Uri uri = Uri.parse(str);
        zzcjs zzcjsVarZzaL = ((zzckf) this.zzb.zza).zzaL();
        if (zzcjsVarZzaL == null) {
            zzcec.zzg("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
        } else {
            zzcjsVarZzaL.zzj(uri);
        }
    }
}
