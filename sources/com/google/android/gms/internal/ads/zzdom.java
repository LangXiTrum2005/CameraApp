package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.view.View;
import com.bumptech.glide.load.Key;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdom {
    private final zzdtk zza;
    private final zzdrz zzb;
    private final zzctl zzc;
    private final zzdni zzd;

    public zzdom(zzdtk zzdtkVar, zzdrz zzdrzVar, zzctl zzctlVar, zzdni zzdniVar) {
        this.zza = zzdtkVar;
        this.zzb = zzdrzVar;
        this.zzc = zzctlVar;
        this.zzd = zzdniVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View zza() throws zzcjw {
        zzcjk zzcjkVarZza = this.zza.zza(com.google.android.gms.ads.internal.client.zzq.zzc(), null, null);
        View view = (View) zzcjkVarZza;
        view.setVisibility(8);
        zzcjkVarZza.zzae("/sendMessageToSdk", new zzbng() { // from class: com.google.android.gms.internal.ads.zzdoh
            @Override // com.google.android.gms.internal.ads.zzbng
            public final void zza(Object obj, Map map) {
                this.zza.zzb((zzcjk) obj, map);
            }
        });
        zzcjkVarZza.zzae("/adMuted", new zzbng() { // from class: com.google.android.gms.internal.ads.zzdoi
            @Override // com.google.android.gms.internal.ads.zzbng
            public final void zza(Object obj, Map map) {
                this.zza.zzc((zzcjk) obj, map);
            }
        });
        this.zzb.zzj(new WeakReference(zzcjkVarZza), "/loadHtml", new zzbng() { // from class: com.google.android.gms.internal.ads.zzdoj
            @Override // com.google.android.gms.internal.ads.zzbng
            public final void zza(Object obj, final Map map) {
                zzcjk zzcjkVar = (zzcjk) obj;
                zzcky zzckyVarZzN = zzcjkVar.zzN();
                final zzdom zzdomVar = this.zza;
                zzckyVarZzN.zzB(new zzckw() { // from class: com.google.android.gms.internal.ads.zzdog
                    @Override // com.google.android.gms.internal.ads.zzckw
                    public final void zza(boolean z, int i, String str, String str2) {
                        zzdomVar.zzd(map, z, i, str, str2);
                    }
                });
                String str = (String) map.get("overlayHtml");
                String str2 = (String) map.get("baseUrl");
                if (TextUtils.isEmpty(str2)) {
                    zzcjkVar.loadData(str, "text/html", Key.STRING_CHARSET_NAME);
                } else {
                    zzcjkVar.loadDataWithBaseURL(str2, str, "text/html", Key.STRING_CHARSET_NAME, null);
                }
            }
        });
        this.zzb.zzj(new WeakReference(zzcjkVarZza), "/showOverlay", new zzbng() { // from class: com.google.android.gms.internal.ads.zzdok
            @Override // com.google.android.gms.internal.ads.zzbng
            public final void zza(Object obj, Map map) {
                this.zza.zze((zzcjk) obj, map);
            }
        });
        this.zzb.zzj(new WeakReference(zzcjkVarZza), "/hideOverlay", new zzbng() { // from class: com.google.android.gms.internal.ads.zzdol
            @Override // com.google.android.gms.internal.ads.zzbng
            public final void zza(Object obj, Map map) {
                this.zza.zzf((zzcjk) obj, map);
            }
        });
        return view;
    }

    final /* synthetic */ void zzb(zzcjk zzcjkVar, Map map) {
        this.zzb.zzg("sendMessageToNativeJs", map);
    }

    final /* synthetic */ void zzc(zzcjk zzcjkVar, Map map) {
        this.zzd.zzg();
    }

    final /* synthetic */ void zzd(Map map, boolean z, int i, String str, String str2) {
        HashMap map2 = new HashMap();
        map2.put("messageType", "htmlLoaded");
        map2.put("id", (String) map.get("id"));
        this.zzb.zzg("sendMessageToNativeJs", map2);
    }

    final /* synthetic */ void zze(zzcjk zzcjkVar, Map map) {
        zzcec.zzi("Showing native ads overlay.");
        zzcjkVar.zzF().setVisibility(0);
        this.zzc.zze(true);
    }

    final /* synthetic */ void zzf(zzcjk zzcjkVar, Map map) {
        zzcec.zzi("Hiding native ads overlay.");
        zzcjkVar.zzF().setVisibility(8);
        this.zzc.zze(false);
    }
}
