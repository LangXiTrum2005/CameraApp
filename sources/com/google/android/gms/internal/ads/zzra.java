package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.media.AudioTrack$StreamEventCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzra extends AudioTrack$StreamEventCallback {
    final /* synthetic */ zzrd zza;
    final /* synthetic */ zzrb zzb;

    zzra(zzrb zzrbVar, zzrd zzrdVar) {
        this.zza = zzrdVar;
        this.zzb = zzrbVar;
    }

    public final void onDataRequest(AudioTrack audioTrack, int i) {
        if (audioTrack.equals(this.zzb.zza.zzt)) {
            zzrd zzrdVar = this.zzb.zza;
            if (zzrdVar.zzp == null || !zzrdVar.zzO) {
                return;
            }
            zzrdVar.zzp.zzb();
        }
    }

    public final void onTearDown(AudioTrack audioTrack) {
        if (audioTrack.equals(this.zzb.zza.zzt)) {
            zzrd zzrdVar = this.zzb.zza;
            if (zzrdVar.zzp == null || !zzrdVar.zzO) {
                return;
            }
            zzrdVar.zzp.zzb();
        }
    }
}
