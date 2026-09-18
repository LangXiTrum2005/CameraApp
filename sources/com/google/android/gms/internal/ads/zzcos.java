package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcos implements zzfer {
    private final zzcnc zza;
    private Context zzb;
    private String zzc;
    private com.google.android.gms.ads.internal.client.zzq zzd;

    /* synthetic */ zzcos(zzcnc zzcncVar, zzcor zzcorVar) {
        this.zza = zzcncVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfer
    public final /* synthetic */ zzfer zza(com.google.android.gms.ads.internal.client.zzq zzqVar) {
        zzqVar.getClass();
        this.zzd = zzqVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfer
    public final /* synthetic */ zzfer zzb(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfer
    public final /* synthetic */ zzfer zzc(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfer
    public final zzfes zzd() {
        zzhhl.zzc(this.zzb, Context.class);
        zzhhl.zzc(this.zzc, String.class);
        zzhhl.zzc(this.zzd, com.google.android.gms.ads.internal.client.zzq.class);
        return new zzcou(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
