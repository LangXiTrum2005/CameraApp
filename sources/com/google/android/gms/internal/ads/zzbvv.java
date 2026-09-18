package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbvv extends zzbvw implements zzbng {
    DisplayMetrics zza;
    int zzb;
    int zzc;
    int zzd;
    int zze;
    int zzf;
    int zzg;
    private final zzcjk zzh;
    private final Context zzi;
    private final WindowManager zzj;
    private final zzbfm zzk;
    private float zzl;
    private int zzm;

    public zzbvv(zzcjk zzcjkVar, Context context, zzbfm zzbfmVar) {
        super(zzcjkVar, "");
        this.zzb = -1;
        this.zzc = -1;
        this.zzd = -1;
        this.zze = -1;
        this.zzf = -1;
        this.zzg = -1;
        this.zzh = zzcjkVar;
        this.zzi = context;
        this.zzk = zzbfmVar;
        this.zzj = (WindowManager) context.getSystemService("window");
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObjectPut;
        this.zza = new DisplayMetrics();
        Display defaultDisplay = this.zzj.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zza);
        this.zzl = this.zza.density;
        this.zzm = defaultDisplay.getRotation();
        com.google.android.gms.ads.internal.client.zzay.zzb();
        DisplayMetrics displayMetrics = this.zza;
        this.zzb = zzcdv.zzv(displayMetrics, displayMetrics.widthPixels);
        com.google.android.gms.ads.internal.client.zzay.zzb();
        DisplayMetrics displayMetrics2 = this.zza;
        this.zzc = zzcdv.zzv(displayMetrics2, displayMetrics2.heightPixels);
        Activity activityZzi = this.zzh.zzi();
        if (activityZzi == null || activityZzi.getWindow() == null) {
            this.zzd = this.zzb;
            this.zze = this.zzc;
        } else {
            com.google.android.gms.ads.internal.zzt.zzp();
            int[] iArrZzP = com.google.android.gms.ads.internal.util.zzt.zzP(activityZzi);
            com.google.android.gms.ads.internal.client.zzay.zzb();
            this.zzd = zzcdv.zzv(this.zza, iArrZzP[0]);
            com.google.android.gms.ads.internal.client.zzay.zzb();
            this.zze = zzcdv.zzv(this.zza, iArrZzP[1]);
        }
        if (this.zzh.zzO().zzi()) {
            this.zzf = this.zzb;
            this.zzg = this.zzc;
        } else {
            this.zzh.measure(0, 0);
        }
        zzj(this.zzb, this.zzc, this.zzd, this.zze, this.zzl, this.zzm);
        zzbvu zzbvuVar = new zzbvu();
        zzbfm zzbfmVar = this.zzk;
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        zzbvuVar.zze(zzbfmVar.zza(intent));
        zzbfm zzbfmVar2 = this.zzk;
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse("sms:"));
        zzbvuVar.zzc(zzbfmVar2.zza(intent2));
        zzbvuVar.zza(this.zzk.zzb());
        zzbvuVar.zzd(this.zzk.zzc());
        zzbvuVar.zzb(true);
        boolean z = zzbvuVar.zza;
        boolean z2 = zzbvuVar.zzb;
        boolean z3 = zzbvuVar.zzc;
        boolean z4 = zzbvuVar.zzd;
        boolean z5 = zzbvuVar.zze;
        zzcjk zzcjkVar = this.zzh;
        try {
            jSONObjectPut = new JSONObject().put("sms", z).put("tel", z2).put("calendar", z3).put("storePicture", z4).put("inlineVideo", z5);
        } catch (JSONException e) {
            zzcec.zzh("Error occurred while obtaining the MRAID capabilities.", e);
            jSONObjectPut = null;
        }
        zzcjkVar.zze("onDeviceFeaturesReceived", jSONObjectPut);
        int[] iArr = new int[2];
        this.zzh.getLocationOnScreen(iArr);
        zzb(com.google.android.gms.ads.internal.client.zzay.zzb().zzb(this.zzi, iArr[0]), com.google.android.gms.ads.internal.client.zzay.zzb().zzb(this.zzi, iArr[1]));
        if (com.google.android.gms.ads.internal.util.zze.zzm(2)) {
            zzcec.zzi("Dispatching Ready Event.");
        }
        zzi(this.zzh.zzn().zza);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x006b A[PHI: r3
  0x006b: PHI (r3v1 int) = (r3v0 int), (r3v4 int) binds: [B:11:0x0042, B:17:0x0058] A[DONT_GENERATE, DONT_INLINE]] */
    public final void zzb(int i, int i2) {
        int i3;
        Context context = this.zzi;
        int i4 = 0;
        if (context instanceof Activity) {
            com.google.android.gms.ads.internal.zzt.zzp();
            i3 = com.google.android.gms.ads.internal.util.zzt.zzQ((Activity) context)[0];
        } else {
            i3 = 0;
        }
        if (this.zzh.zzO() == null || !this.zzh.zzO().zzi()) {
            zzcjk zzcjkVar = this.zzh;
            int width = zzcjkVar.getWidth();
            int height = zzcjkVar.getHeight();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzR)).booleanValue()) {
                if (width == 0) {
                    width = this.zzh.zzO() != null ? this.zzh.zzO().zzb : 0;
                }
                if (height != 0) {
                    i4 = height;
                } else if (this.zzh.zzO() != null) {
                    i4 = this.zzh.zzO().zza;
                }
            } else {
                i4 = height;
            }
            this.zzf = com.google.android.gms.ads.internal.client.zzay.zzb().zzb(this.zzi, width);
            this.zzg = com.google.android.gms.ads.internal.client.zzay.zzb().zzb(this.zzi, i4);
        }
        zzg(i, i2 - i3, this.zzf, this.zzg);
        this.zzh.zzN().zzC(i, i2);
    }
}
