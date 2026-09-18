package com.google.android.gms.ads.internal.overlay;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzcdv;
import com.google.android.gms.internal.ads.zzcec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzs extends FrameLayout implements View.OnClickListener {
    private final ImageButton zza;
    private final zzae zzb;

    public zzs(Context context, zzr zzrVar, zzae zzaeVar) {
        super(context);
        this.zzb = zzaeVar;
        setOnClickListener(this);
        ImageButton imageButton = new ImageButton(context);
        this.zza = imageButton;
        zzc();
        imageButton.setBackgroundColor(0);
        imageButton.setOnClickListener(this);
        zzay.zzb();
        int iZzx = zzcdv.zzx(context, zzrVar.zza);
        zzay.zzb();
        int iZzx2 = zzcdv.zzx(context, 0);
        zzay.zzb();
        int iZzx3 = zzcdv.zzx(context, zzrVar.zzb);
        zzay.zzb();
        imageButton.setPadding(iZzx, iZzx2, iZzx3, zzcdv.zzx(context, zzrVar.zzc));
        imageButton.setContentDescription("Interstitial close button");
        zzay.zzb();
        int iZzx4 = zzcdv.zzx(context, zzrVar.zzd + zzrVar.zza + zzrVar.zzb);
        zzay.zzb();
        addView(imageButton, new FrameLayout.LayoutParams(iZzx4, zzcdv.zzx(context, zzrVar.zzd + zzrVar.zzc), 17));
        long jLongValue = ((Long) zzba.zzc().zza(zzbgc.zzbc)).longValue();
        if (jLongValue <= 0) {
            return;
        }
        zzq zzqVar = ((Boolean) zzba.zzc().zza(zzbgc.zzbd)).booleanValue() ? new zzq(this) : null;
        imageButton.setAlpha(0.0f);
        imageButton.animate().alpha(1.0f).setDuration(jLongValue).setListener(zzqVar);
    }

    private final void zzc() {
        String str = (String) zzba.zzc().zza(zzbgc.zzbb);
        if (!PlatformVersion.isAtLeastLollipop() || TextUtils.isEmpty(str) || "default".equals(str)) {
            this.zza.setImageResource(R.drawable.btn_dialog);
            return;
        }
        Resources resourcesZze = com.google.android.gms.ads.internal.zzt.zzo().zze();
        if (resourcesZze == null) {
            this.zza.setImageResource(R.drawable.btn_dialog);
            return;
        }
        Drawable drawable = null;
        try {
            if ("white".equals(str)) {
                drawable = resourcesZze.getDrawable(com.google.android.gms.ads.impl.R.drawable.admob_close_button_white_circle_black_cross);
            } else if ("black".equals(str)) {
                drawable = resourcesZze.getDrawable(com.google.android.gms.ads.impl.R.drawable.admob_close_button_black_circle_white_cross);
            }
        } catch (Resources.NotFoundException unused) {
            zzcec.zze("Close button resource not found, falling back to default.");
        }
        if (drawable == null) {
            this.zza.setImageResource(R.drawable.btn_dialog);
        } else {
            this.zza.setImageDrawable(drawable);
            this.zza.setScaleType(ImageView.ScaleType.CENTER);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        zzae zzaeVar = this.zzb;
        if (zzaeVar != null) {
            zzaeVar.zzj();
        }
    }

    public final void zzb(boolean z) {
        if (!z) {
            this.zza.setVisibility(0);
            return;
        }
        this.zza.setVisibility(8);
        if (((Long) zzba.zzc().zza(zzbgc.zzbc)).longValue() > 0) {
            this.zza.animate().cancel();
            this.zza.clearAnimation();
        }
    }
}
