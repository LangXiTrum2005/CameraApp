package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzzx implements zzdm {
    private static final zzfxu zza = zzfxx.zza(new zzfxu() { // from class: com.google.android.gms.internal.ads.zzzv
        @Override // com.google.android.gms.internal.ads.zzfxu
        public final Object zza() {
            try {
                Class<?> cls = Class.forName("androidx.media3.effect.DefaultVideoFrameProcessor$Factory$Builder");
                Object objInvoke = cls.getMethod("build", null).invoke(cls.getConstructor(null).newInstance(null), null);
                objInvoke.getClass();
                return (zzdm) objInvoke;
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
    });

    private zzzx() {
    }

    /* synthetic */ zzzx(zzzw zzzwVar) {
    }
}
