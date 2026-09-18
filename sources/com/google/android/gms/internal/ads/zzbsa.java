package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbsa implements zzbnu {
    final /* synthetic */ zzbsb zza;
    private final zzbrd zzb;
    private final zzceu zzc;

    public zzbsa(zzbsb zzbsbVar, zzbrd zzbrdVar, zzceu zzceuVar) {
        this.zza = zzbsbVar;
        this.zzb = zzbrdVar;
        this.zzc = zzceuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnu
    public final void zza(String str) {
        try {
            if (str == null) {
                this.zzc.zzd(new zzbrm());
            } else {
                this.zzc.zzd(new zzbrm(str));
            }
        } catch (IllegalStateException unused) {
        } finally {
            this.zzb.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbnu
    public final void zzb(JSONObject jSONObject) {
        try {
            try {
                this.zzc.zzc(this.zza.zza.zza(jSONObject));
            } catch (IllegalStateException unused) {
            } catch (JSONException e) {
                this.zzc.zzd(e);
            }
        } finally {
            this.zzb.zzb();
        }
    }
}
