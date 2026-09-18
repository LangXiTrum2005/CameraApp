package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzckd implements zzbng {
    final /* synthetic */ zzckf zza;

    zzckd(zzckf zzckfVar) {
        this.zza = zzckfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbng
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        if (map != null) {
            String str = (String) map.get("height");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int i = Integer.parseInt(str);
                synchronized (this.zza) {
                    zzckf zzckfVar = this.zza;
                    if (zzckfVar.zzH != i) {
                        zzckfVar.zzH = i;
                        this.zza.requestLayout();
                    }
                }
            } catch (Exception e) {
                zzcec.zzk("Exception occurred while getting webview content height", e);
            }
        }
    }
}
