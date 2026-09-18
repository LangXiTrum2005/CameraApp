package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdqu {
    private final Executor zza;
    private final zzctl zzb;
    private final zzdio zzc;

    zzdqu(Executor executor, zzctl zzctlVar, zzdio zzdioVar) {
        this.zza = executor;
        this.zzc = zzdioVar;
        this.zzb = zzctlVar;
    }

    public final void zza(final zzcjk zzcjkVar) {
        if (zzcjkVar == null) {
            return;
        }
        this.zzc.zza(zzcjkVar.zzF());
        this.zzc.zzo(new zzayq() { // from class: com.google.android.gms.internal.ads.zzdqq
            @Override // com.google.android.gms.internal.ads.zzayq
            public final void zzby(zzayp zzaypVar) {
                zzcky zzckyVarZzN = zzcjkVar.zzN();
                Rect rect = zzaypVar.zzd;
                zzckyVarZzN.zzq(rect.left, rect.top, false);
            }
        }, this.zza);
        this.zzc.zzo(new zzayq() { // from class: com.google.android.gms.internal.ads.zzdqr
            @Override // com.google.android.gms.internal.ads.zzayq
            public final void zzby(zzayp zzaypVar) {
                HashMap map = new HashMap();
                map.put("isVisible", true != zzaypVar.zzj ? "0" : "1");
                zzcjkVar.zzd("onAdVisibilityChanged", map);
            }
        }, this.zza);
        this.zzc.zzo(this.zzb, this.zza);
        this.zzb.zzf(zzcjkVar);
        zzcjkVar.zzae("/trackActiveViewUnit", new zzbng() { // from class: com.google.android.gms.internal.ads.zzdqs
            @Override // com.google.android.gms.internal.ads.zzbng
            public final void zza(Object obj, Map map) {
                this.zza.zzb((zzcjk) obj, map);
            }
        });
        zzcjkVar.zzae("/untrackActiveViewUnit", new zzbng() { // from class: com.google.android.gms.internal.ads.zzdqt
            @Override // com.google.android.gms.internal.ads.zzbng
            public final void zza(Object obj, Map map) {
                this.zza.zzc((zzcjk) obj, map);
            }
        });
    }

    final /* synthetic */ void zzb(zzcjk zzcjkVar, Map map) {
        this.zzb.zzb();
    }

    final /* synthetic */ void zzc(zzcjk zzcjkVar, Map map) {
        this.zzb.zza();
    }
}
