package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzsu {
    public static int zza(MediaCodecInfo.VideoCapabilities videoCapabilities, String str, int i, int i2, double d) {
        List supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints();
        if (supportedPerformancePoints == null || supportedPerformancePoints.isEmpty()) {
            return 0;
        }
        int iZzb = zzb(supportedPerformancePoints, zzf$$ExternalSyntheticApiModelOutline0.m(i, i2, (int) d));
        if (iZzb == 1 && str.equals("video/avc")) {
            zzf$$ExternalSyntheticApiModelOutline0.m$1();
            if (zzb(supportedPerformancePoints, zzf$$ExternalSyntheticApiModelOutline0.m(1280, 720, 60)) != 2) {
                return 0;
            }
        }
        return iZzb;
    }

    private static int zzb(List list, MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint) {
        for (int i = 0; i < list.size(); i++) {
            if (zzf$$ExternalSyntheticApiModelOutline0.m(list.get(i)).covers(performancePoint)) {
                return 2;
            }
        }
        return 1;
    }
}
