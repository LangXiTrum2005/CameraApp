package com.google.android.gms.internal.ads;

import android.media.AudioFormat;
import android.media.AudioTrack;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzpc {
    public static int zza(int i, int i2, zzk zzkVar) {
        for (int i3 = 10; i3 > 0; i3--) {
            int iZzg = zzfy.zzg(i3);
            if (iZzg != 0 && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i).setSampleRate(i2).setChannelMask(iZzg).build(), zzkVar.zza().zza)) {
                return i3;
            }
        }
        return 0;
    }

    public static zzgaa<Integer> zzb(zzk zzkVar) {
        zzfzx zzfzxVar = new zzfzx();
        zzgce it = zzpd.zzc.keySet().iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            int iIntValue = num.intValue();
            if (zzfy.zza >= zzfy.zzf(iIntValue) && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(iIntValue).setSampleRate(48000).build(), zzkVar.zza().zza)) {
                zzfzxVar.zzf(num);
            }
        }
        zzfzxVar.zzf((Object) 2);
        return zzfzxVar.zzi();
    }
}
