package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzetf implements zzexq {
    private final zzgey zza;
    private final Context zzb;

    public zzetf(zzgey zzgeyVar, Context context) {
        this.zza = zzgeyVar;
        this.zzb = context;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 13;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzete
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    final /* synthetic */ zzetg zzc() throws Exception {
        int iZzj;
        int streamMaxVolume;
        AudioManager audioManager = (AudioManager) this.zzb.getSystemService("audio");
        int mode = audioManager.getMode();
        boolean zIsMusicActive = audioManager.isMusicActive();
        boolean zIsSpeakerphoneOn = audioManager.isSpeakerphoneOn();
        int streamVolume = audioManager.getStreamVolume(3);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkv)).booleanValue()) {
            iZzj = com.google.android.gms.ads.internal.zzt.zzq().zzj(audioManager);
            streamMaxVolume = audioManager.getStreamMaxVolume(3);
        } else {
            iZzj = -1;
            streamMaxVolume = -1;
        }
        return new zzetg(mode, zIsMusicActive, zIsSpeakerphoneOn, streamVolume, iZzj, streamMaxVolume, audioManager.getRingerMode(), audioManager.getStreamVolume(2), com.google.android.gms.ads.internal.zzt.zzr().zza(), com.google.android.gms.ads.internal.zzt.zzr().zze());
    }
}
