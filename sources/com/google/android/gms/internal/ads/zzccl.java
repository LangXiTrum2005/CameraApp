package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzccl implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ zzccm zza;
    private final String zzb;

    public zzccl(zzccm zzccmVar, String str) {
        this.zza = zzccmVar;
        this.zzb = str;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zza) {
            for (zzcck zzcckVar : this.zza.zzb) {
                zzcckVar.zza.zzb(zzcckVar.zzb, sharedPreferences, this.zzb, str);
            }
        }
    }
}
