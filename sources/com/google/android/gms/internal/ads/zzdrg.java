package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdrg implements zzbja {
    final /* synthetic */ String zza = NativeCustomFormatAd.ASSET_NAME_VIDEO;
    final /* synthetic */ zzdrh zzb;

    zzdrg(zzdrh zzdrhVar, String str) {
        this.zzb = zzdrhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbja
    public final JSONObject zza() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbja
    public final JSONObject zzb() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbja
    public final void zzc() {
        zzdrh zzdrhVar = this.zzb;
        if (zzdrhVar.zzd != null) {
            zzdrhVar.zzd.zzE(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbja
    public final void zzd(MotionEvent motionEvent) {
    }
}
