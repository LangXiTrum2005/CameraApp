package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzri implements zzpy {
    final /* synthetic */ zzrj zza;

    /* synthetic */ zzri(zzrj zzrjVar, zzrh zzrhVar) {
        this.zza = zzrjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzpy
    public final void zza(Exception exc) {
        zzff.zzd("MediaCodecAudioRenderer", "Audio sink error", exc);
        this.zza.zzc.zzb(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzpy
    public final void zzb() {
        zzrj zzrjVar = this.zza;
        if (zzrjVar.zzm != null) {
            zzrjVar.zzm.zzb();
        }
    }
}
