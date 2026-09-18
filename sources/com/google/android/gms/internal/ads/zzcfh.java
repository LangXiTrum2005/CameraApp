package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcfh implements Runnable {
    final /* synthetic */ MediaPlayer zza;
    final /* synthetic */ zzcfp zzb;

    zzcfh(zzcfp zzcfpVar, MediaPlayer mediaPlayer) {
        this.zza = mediaPlayer;
        this.zzb = zzcfpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcfp.zzl(this.zzb, this.zza);
        zzcfp zzcfpVar = this.zzb;
        if (zzcfpVar.zzq != null) {
            zzcfpVar.zzq.zzf();
        }
    }
}
