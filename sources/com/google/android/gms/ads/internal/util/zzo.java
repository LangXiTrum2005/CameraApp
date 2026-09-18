package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.internal.ads.zzbhb;
import com.google.android.gms.internal.ads.zzbhd;
import com.google.android.gms.internal.ads.zzhhv;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzo implements zzbhb {
    final /* synthetic */ zzbhd zza;
    final /* synthetic */ Context zzb;
    final /* synthetic */ Uri zzc;

    zzo(zzt zztVar, zzbhd zzbhdVar, Context context, Uri uri) {
        this.zza = zzbhdVar;
        this.zzb = context;
        this.zzc = uri;
    }

    @Override // com.google.android.gms.internal.ads.zzbhb
    public final void zza() {
        CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder(this.zza.zza()).build();
        customTabsIntentBuild.intent.setPackage(zzhhv.zza(this.zzb));
        customTabsIntentBuild.launchUrl(this.zzb, this.zzc);
        this.zza.zzf((Activity) this.zzb);
    }
}
