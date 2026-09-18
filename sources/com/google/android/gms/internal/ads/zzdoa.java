package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdoa {
    static final ImageView.ScaleType zza = ImageView.ScaleType.CENTER_INSIDE;
    private final com.google.android.gms.ads.internal.util.zzg zzb;
    private final zzfhh zzc;
    private final zzdnf zzd;
    private final zzdna zze;
    private final zzdom zzf;
    private final zzdou zzg;
    private final Executor zzh;
    private final Executor zzi;
    private final zzbjb zzj;
    private final zzdmx zzk;

    public zzdoa(com.google.android.gms.ads.internal.util.zzg zzgVar, zzfhh zzfhhVar, zzdnf zzdnfVar, zzdna zzdnaVar, zzdom zzdomVar, zzdou zzdouVar, Executor executor, Executor executor2, zzdmx zzdmxVar) {
        this.zzb = zzgVar;
        this.zzc = zzfhhVar;
        this.zzj = zzfhhVar.zzi;
        this.zzd = zzdnfVar;
        this.zze = zzdnaVar;
        this.zzf = zzdomVar;
        this.zzg = zzdouVar;
        this.zzh = executor;
        this.zzi = executor2;
        this.zzk = zzdmxVar;
    }

    private final boolean zzi(ViewGroup viewGroup, boolean z) {
        View viewZzf = z ? this.zze.zzf() : this.zze.zzg();
        if (viewZzf == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (viewZzf.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewZzf.getParent()).removeView(viewZzf);
        }
        viewGroup.addView(viewZzf, ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdJ)).booleanValue() ? new FrameLayout.LayoutParams(-1, -1, 17) : new FrameLayout.LayoutParams(-2, -2, 17));
        return true;
    }

    final /* synthetic */ void zza(ViewGroup viewGroup) {
        zzdna zzdnaVar = this.zze;
        if (zzdnaVar.zzf() != null) {
            boolean z = viewGroup != null;
            if (zzdnaVar.zzc() == 2 || zzdnaVar.zzc() == 1) {
                this.zzb.zzJ(this.zzc.zzf, String.valueOf(zzdnaVar.zzc()), z);
            } else if (zzdnaVar.zzc() == 6) {
                this.zzb.zzJ(this.zzc.zzf, "2", z);
                this.zzb.zzJ(this.zzc.zzf, "1", z);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:82:0x0197  */
    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ void zzb(zzdow zzdowVar) {
        ViewGroup viewGroup;
        View viewZze;
        final ViewGroup viewGroup2;
        zzbjj zzbjjVarZza;
        Drawable drawable;
        if (!this.zzd.zzf() && !this.zzd.zze()) {
            viewGroup = null;
            break;
        }
        String[] strArr = {NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, "3011"};
        int i = 0;
        while (true) {
            if (i >= 2) {
                viewGroup = null;
                break;
            }
            View viewZzg = zzdowVar.zzg(strArr[i]);
            if (viewZzg != null && (viewZzg instanceof ViewGroup)) {
                viewGroup = (ViewGroup) viewZzg;
                break;
            }
            i++;
        }
        Context context = zzdowVar.zzf().getContext();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        zzdna zzdnaVar = this.zze;
        if (zzdnaVar.zze() != null) {
            zzbjb zzbjbVar = this.zzj;
            viewZze = zzdnaVar.zze();
            if (zzbjbVar != null && viewGroup == null) {
                zzh(layoutParams, zzbjbVar.zze);
                viewZze.setLayoutParams(layoutParams);
                viewGroup = null;
            }
        } else if (zzdnaVar.zzl() instanceof zzbiw) {
            zzbiw zzbiwVar = (zzbiw) zzdnaVar.zzl();
            if (viewGroup == null) {
                zzh(layoutParams, zzbiwVar.zzc());
                viewGroup = null;
            }
            View zzbixVar = new zzbix(context, zzbiwVar, layoutParams);
            zzbixVar.setContentDescription((CharSequence) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdH));
            viewZze = zzbixVar;
        } else {
            viewZze = null;
        }
        if (viewZze != null) {
            if (viewZze.getParent() instanceof ViewGroup) {
                ((ViewGroup) viewZze.getParent()).removeView(viewZze);
            }
            if (viewGroup != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(viewZze);
            } else {
                com.google.android.gms.ads.formats.zza zzaVar = new com.google.android.gms.ads.formats.zza(zzdowVar.zzf().getContext());
                zzaVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                zzaVar.addView(viewZze);
                FrameLayout frameLayoutZzh = zzdowVar.zzh();
                if (frameLayoutZzh != null) {
                    frameLayoutZzh.addView(zzaVar);
                }
            }
            zzdowVar.zzq(zzdowVar.zzk(), viewZze, true);
        }
        zzgaa zzgaaVar = zzdnw.zza;
        int size = zzgaaVar.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                viewGroup2 = null;
                break;
            }
            View viewZzg2 = zzdowVar.zzg((String) zzgaaVar.get(i2));
            i2++;
            if (viewZzg2 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) viewZzg2;
                break;
            }
        }
        this.zzi.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdnx
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(viewGroup2);
            }
        });
        if (viewGroup2 == null) {
            return;
        }
        if (zzi(viewGroup2, true)) {
            zzdna zzdnaVar2 = this.zze;
            if (zzdnaVar2.zzs() != null) {
                zzdnaVar2.zzs().zzap(new zzdnz(zzdowVar, viewGroup2));
                return;
            }
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjK)).booleanValue() && zzi(viewGroup2, false)) {
            zzdna zzdnaVar3 = this.zze;
            if (zzdnaVar3.zzq() != null) {
                zzdnaVar3.zzq().zzap(new zzdnz(zzdowVar, viewGroup2));
                return;
            }
            return;
        }
        viewGroup2.removeAllViews();
        View viewZzf = zzdowVar.zzf();
        Context context2 = viewZzf != null ? viewZzf.getContext() : null;
        if (context2 == null || (zzbjjVarZza = this.zzk.zza()) == null) {
            return;
        }
        try {
            IObjectWrapper iObjectWrapperZzi = zzbjjVarZza.zzi();
            if (iObjectWrapperZzi == null || (drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapperZzi)) == null) {
                return;
            }
            ImageView imageView = new ImageView(context2);
            imageView.setImageDrawable(drawable);
            IObjectWrapper iObjectWrapperZzj = zzdowVar.zzj();
            if (iObjectWrapperZzj == null) {
                imageView.setScaleType(zza);
            } else if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgi)).booleanValue()) {
                imageView.setScaleType((ImageView.ScaleType) ObjectWrapper.unwrap(iObjectWrapperZzj));
            } else {
                imageView.setScaleType(zza);
            }
            imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            viewGroup2.addView(imageView);
        } catch (RemoteException unused) {
            zzcec.zzj("Could not get main image drawable");
        }
    }

    public final void zzc(zzdow zzdowVar) {
        if (zzdowVar == null || this.zzf == null || zzdowVar.zzh() == null || !this.zzd.zzg()) {
            return;
        }
        try {
            zzdowVar.zzh().addView(this.zzf.zza());
        } catch (zzcjw e) {
            com.google.android.gms.ads.internal.util.zze.zzb("web view can not be obtained", e);
        }
    }

    public final void zzd(zzdow zzdowVar) {
        if (zzdowVar == null) {
            return;
        }
        Context context = zzdowVar.zzf().getContext();
        if (com.google.android.gms.ads.internal.util.zzbz.zzh(context, this.zzd.zza)) {
            if (!(context instanceof Activity)) {
                zzcec.zze("Activity context is needed for policy validator.");
                return;
            }
            if (this.zzg == null || zzdowVar.zzh() == null) {
                return;
            }
            try {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                windowManager.addView(this.zzg.zza(zzdowVar.zzh(), windowManager), com.google.android.gms.ads.internal.util.zzbz.zzb());
            } catch (zzcjw e) {
                com.google.android.gms.ads.internal.util.zze.zzb("web view can not be obtained", e);
            }
        }
    }

    public final void zze(final zzdow zzdowVar) {
        this.zzh.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdny
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzb(zzdowVar);
            }
        });
    }

    public final boolean zzf(ViewGroup viewGroup) {
        return zzi(viewGroup, false);
    }

    public final boolean zzg(ViewGroup viewGroup) {
        return zzi(viewGroup, true);
    }

    private static void zzh(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }
}
