package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.ViewGroup;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdnz implements zzbja {
    final /* synthetic */ zzdow zza;
    final /* synthetic */ ViewGroup zzb;

    zzdnz(zzdow zzdowVar, ViewGroup viewGroup) {
        this.zza = zzdowVar;
        this.zzb = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzbja
    public final JSONObject zza() {
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzbja
    public final JSONObject zzb() {
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzbja
    public final void zzc() {
        zzgaa zzgaaVar = zzdnw.zza;
        Map mapZzm = this.zza.zzm();
        if (mapZzm == null) {
            return;
        }
        int size = zzgaaVar.size();
        int i = 0;
        while (i < size) {
            Object obj = mapZzm.get((String) zzgaaVar.get(i));
            i++;
            if (obj != null) {
                this.zza.onClick(this.zzb);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbja
    public final void zzd(MotionEvent motionEvent) {
        this.zza.onTouch(null, motionEvent);
    }
}
