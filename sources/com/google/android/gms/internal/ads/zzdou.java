package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdou {
    private final zzdtk zza;
    private final zzdrz zzb;
    private ViewTreeObserver.OnScrollChangedListener zzc = null;

    public zzdou(zzdtk zzdtkVar, zzdrz zzdrzVar) {
        this.zza = zzdtkVar;
        this.zzb = zzdrzVar;
    }

    private static final int zzf(Context context, String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        com.google.android.gms.ads.internal.client.zzay.zzb();
        return zzcdv.zzx(context, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View zza(final View view, final WindowManager windowManager) throws zzcjw {
        zzcjk zzcjkVarZza = this.zza.zza(com.google.android.gms.ads.internal.client.zzq.zzc(), null, null);
        View view2 = (View) zzcjkVarZza;
        view2.setVisibility(4);
        view2.setContentDescription("policy_validator");
        zzcjkVarZza.zzae("/sendMessageToSdk", new zzbng() { // from class: com.google.android.gms.internal.ads.zzdoo
            @Override // com.google.android.gms.internal.ads.zzbng
            public final void zza(Object obj, Map map) {
                this.zza.zzb((zzcjk) obj, map);
            }
        });
        zzcjkVarZza.zzae("/hideValidatorOverlay", new zzbng() { // from class: com.google.android.gms.internal.ads.zzdop
            @Override // com.google.android.gms.internal.ads.zzbng
            public final void zza(Object obj, Map map) {
                this.zza.zzc(windowManager, view, (zzcjk) obj, map);
            }
        });
        zzcjkVarZza.zzae("/open", new zzbnr(null, null, null, null, null, null));
        this.zzb.zzj(new WeakReference(zzcjkVarZza), "/loadNativeAdPolicyViolations", new zzbng() { // from class: com.google.android.gms.internal.ads.zzdoq
            @Override // com.google.android.gms.internal.ads.zzbng
            public final void zza(Object obj, Map map) {
                this.zza.zze(view, windowManager, (zzcjk) obj, map);
            }
        });
        this.zzb.zzj(new WeakReference(zzcjkVarZza), "/showValidatorOverlay", new zzbng() { // from class: com.google.android.gms.internal.ads.zzdor
            @Override // com.google.android.gms.internal.ads.zzbng
            public final void zza(Object obj, Map map) {
                zzcec.zze("Show native ad policy validator overlay.");
                ((zzcjk) obj).zzF().setVisibility(0);
            }
        });
        return view2;
    }

    final /* synthetic */ void zzb(zzcjk zzcjkVar, Map map) {
        this.zzb.zzg("sendMessageToNativeJs", map);
    }

    final /* synthetic */ void zzc(WindowManager windowManager, View view, zzcjk zzcjkVar, Map map) {
        zzcec.zze("Hide native ad policy validator overlay.");
        zzcjkVar.zzF().setVisibility(8);
        if (zzcjkVar.zzF().getWindowToken() != null) {
            windowManager.removeView(zzcjkVar.zzF());
        }
        zzcjkVar.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (this.zzc == null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnScrollChangedListener(this.zzc);
    }

    final /* synthetic */ void zzd(Map map, boolean z, int i, String str, String str2) {
        HashMap map2 = new HashMap();
        map2.put("messageType", "validatorHtmlLoaded");
        map2.put("id", (String) map.get("id"));
        this.zzb.zzg("sendMessageToNativeJs", map2);
    }

    final /* synthetic */ void zze(final View view, final WindowManager windowManager, final zzcjk zzcjkVar, final Map map) {
        zzcjkVar.zzN().zzB(new zzckw() { // from class: com.google.android.gms.internal.ads.zzdot
            @Override // com.google.android.gms.internal.ads.zzckw
            public final void zza(boolean z, int i, String str, String str2) {
                this.zza.zzd(map, z, i, str, str2);
            }
        });
        if (map == null) {
            return;
        }
        Context context = view.getContext();
        int iZzf = zzf(context, (String) map.get("validator_width"), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhV)).intValue());
        int iZzf2 = zzf(context, (String) map.get("validator_height"), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhW)).intValue());
        int iZzf3 = zzf(context, (String) map.get("validator_x"), 0);
        int iZzf4 = zzf(context, (String) map.get("validator_y"), 0);
        zzcjkVar.zzah(zzcla.zzb(iZzf, iZzf2));
        try {
            zzcjkVar.zzG().getSettings().setUseWideViewPort(((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhX)).booleanValue());
            zzcjkVar.zzG().getSettings().setLoadWithOverviewMode(((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhY)).booleanValue());
        } catch (NullPointerException unused) {
        }
        final WindowManager.LayoutParams layoutParamsZzb = com.google.android.gms.ads.internal.util.zzbz.zzb();
        layoutParamsZzb.x = iZzf3;
        layoutParamsZzb.y = iZzf4;
        windowManager.updateViewLayout(zzcjkVar.zzF(), layoutParamsZzb);
        final String str = (String) map.get("orientation");
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            final int i = (("1".equals(str) || "2".equals(str)) ? rect.bottom : rect.top) - iZzf4;
            this.zzc = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.google.android.gms.internal.ads.zzdos
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    Rect rect2 = new Rect();
                    if (view.getGlobalVisibleRect(rect2)) {
                        zzcjk zzcjkVar2 = zzcjkVar;
                        if (zzcjkVar2.zzF().getWindowToken() == null) {
                            return;
                        }
                        int i2 = i;
                        WindowManager.LayoutParams layoutParams = layoutParamsZzb;
                        String str2 = str;
                        if ("1".equals(str2) || "2".equals(str2)) {
                            layoutParams.y = rect2.bottom - i2;
                        } else {
                            layoutParams.y = rect2.top - i2;
                        }
                        windowManager.updateViewLayout(zzcjkVar2.zzF(), layoutParams);
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnScrollChangedListener(this.zzc);
            }
        }
        String str2 = (String) map.get("overlay_url");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        zzcjkVar.loadUrl(str2);
    }
}
