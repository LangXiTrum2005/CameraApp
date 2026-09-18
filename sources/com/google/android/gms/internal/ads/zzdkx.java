package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.collection.ArrayMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdkx implements zzdcl, com.google.android.gms.ads.internal.overlay.zzp, zzdbr {
    zzfod zza;
    private final Context zzb;
    private final zzcjk zzc;
    private final zzfgm zzd;
    private final zzcei zze;
    private final zzbbz zzf;

    public zzdkx(Context context, zzcjk zzcjkVar, zzfgm zzfgmVar, zzcei zzceiVar, zzbbz zzbbzVar) {
        this.zzb = context;
        this.zzc = zzcjkVar;
        this.zzd = zzfgmVar;
        this.zze = zzceiVar;
        this.zzf = zzbbzVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbA() {
        if (this.zza == null || this.zzc == null) {
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeZ)).booleanValue()) {
            return;
        }
        this.zzc.zzd("onSdkImpression", new ArrayMap());
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbC() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbD(int i) {
        this.zza = null;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbP() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbt() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzbz() {
    }

    @Override // com.google.android.gms.internal.ads.zzdbr
    public final void zzq() {
        if (this.zza == null || this.zzc == null) {
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeZ)).booleanValue()) {
            this.zzc.zzd("onSdkImpression", new ArrayMap());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcl
    public final void zzr() {
        zzeii zzeiiVar;
        zzeih zzeihVar;
        zzbbz zzbbzVar = this.zzf;
        if ((zzbbzVar == zzbbz.REWARD_BASED_VIDEO_AD || zzbbzVar == zzbbz.INTERSTITIAL || zzbbzVar == zzbbz.APP_OPEN) && this.zzd.zzU && this.zzc != null) {
            if (com.google.android.gms.ads.internal.zzt.zzA().zzj(this.zzb)) {
                zzcei zzceiVar = this.zze;
                String str = zzceiVar.zzb + "." + zzceiVar.zzc;
                zzfhk zzfhkVar = this.zzd.zzW;
                String strZza = zzfhkVar.zza();
                if (zzfhkVar.zzb() == 1) {
                    zzeihVar = zzeih.VIDEO;
                    zzeiiVar = zzeii.DEFINED_BY_JAVASCRIPT;
                } else {
                    zzeiiVar = this.zzd.zzZ == 2 ? zzeii.UNSPECIFIED : zzeii.BEGIN_TO_RENDER;
                    zzeihVar = zzeih.HTML_DISPLAY;
                }
                zzfod zzfodVarZza = com.google.android.gms.ads.internal.zzt.zzA().zza(str, this.zzc.zzG(), "", "javascript", strZza, zzeiiVar, zzeihVar, this.zzd.zzam);
                this.zza = zzfodVarZza;
                if (zzfodVarZza != null) {
                    com.google.android.gms.ads.internal.zzt.zzA().zzh(this.zza, (View) this.zzc);
                    this.zzc.zzaq(this.zza);
                    com.google.android.gms.ads.internal.zzt.zzA().zzi(this.zza);
                    this.zzc.zzd("onSdkLoaded", new ArrayMap());
                }
            }
        }
    }
}
