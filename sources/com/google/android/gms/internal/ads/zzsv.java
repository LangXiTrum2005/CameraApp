package com.google.android.gms.internal.ads;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzsv {
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final MediaCodecInfo.CodecCapabilities zzd;
    public final boolean zze;
    public final boolean zzf;
    public final boolean zzg;
    private final boolean zzh;

    /* JADX WARN: Code duplicated, block: B:18:0x003f  */
    /* JADX WARN: Code duplicated, block: B:23:0x004e  */
    /* JADX WARN: Code duplicated, block: B:30:0x0060  */
    public static zzsv zzc(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6;
        boolean z7;
        boolean z8;
        if (codecCapabilities != null) {
            int i = zzfy.zza;
            if (!codecCapabilities.isFeatureSupported("adaptive-playback") || (zzfy.zza <= 22 && (("ODROID-XU3".equals(zzfy.zzd) || "Nexus 10".equals(zzfy.zzd)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))))) {
                z6 = false;
            } else {
                z6 = true;
            }
        } else {
            z6 = false;
        }
        if (codecCapabilities != null) {
            int i2 = zzfy.zza;
            if (codecCapabilities.isFeatureSupported("tunneled-playback")) {
                z7 = true;
            } else {
                z7 = false;
            }
        } else {
            z7 = false;
        }
        if (z5) {
            z8 = true;
        } else {
            if (codecCapabilities != null) {
                int i3 = zzfy.zza;
                if (codecCapabilities.isFeatureSupported("secure-playback")) {
                    z8 = true;
                }
            }
            z8 = false;
        }
        return new zzsv(str, str2, str3, codecCapabilities, z, z2, z3, z6, z7, z8);
    }

    private static Point zzi(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        int i3 = zzfy.zza;
        return new Point((((i + widthAlignment) - 1) / widthAlignment) * widthAlignment, (((i2 + heightAlignment) - 1) / heightAlignment) * heightAlignment);
    }

    private final void zzj(String str) {
        zzff.zzb("MediaCodecInfo", "NoSupport [" + str + "] [" + this.zza + ", " + this.zzb + "] [" + zzfy.zze + "]");
    }

    private static boolean zzk(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point pointZzi = zzi(videoCapabilities, i, i2);
        int i3 = pointZzi.x;
        int i4 = pointZzi.y;
        return (d == -1.0d || d < 1.0d) ? videoCapabilities.isSizeSupported(i3, i4) : videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d));
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0079  */
    /* JADX WARN: Code duplicated, block: B:33:0x007f  */
    /* JADX WARN: Code duplicated, block: B:34:0x0082  */
    /* JADX WARN: Code duplicated, block: B:36:0x0087  */
    /* JADX WARN: Code duplicated, block: B:37:0x008a  */
    /* JADX WARN: Code duplicated, block: B:39:0x008f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0092  */
    /* JADX WARN: Code duplicated, block: B:42:0x0097  */
    /* JADX WARN: Code duplicated, block: B:43:0x009a  */
    /* JADX WARN: Code duplicated, block: B:45:0x009f  */
    /* JADX WARN: Code duplicated, block: B:46:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:49:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:51:0x00af  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:55:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:57:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:58:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:65:0x00d9  */
    private final boolean zzl(zzam zzamVar, boolean z) {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrZzh;
        int i;
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        int iIntValue;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        Pair pairZza = zztn.zza(zzamVar);
        if (pairZza != null) {
            int iIntValue2 = ((Integer) pairZza.first).intValue();
            int iIntValue3 = ((Integer) pairZza.second).intValue();
            int i2 = 8;
            if ("video/dolby-vision".equals(zzamVar.zzm)) {
                if ("video/avc".equals(this.zzb)) {
                    iIntValue2 = 8;
                } else if ("video/hevc".equals(this.zzb)) {
                    iIntValue2 = 2;
                }
                iIntValue3 = 0;
            }
            if (this.zzh) {
                codecProfileLevelArrZzh = zzh();
                if (zzfy.zza <= 23 && "video/x-vnd.on2.vp9".equals(this.zzb) && codecProfileLevelArrZzh.length == 0) {
                    codecCapabilities = this.zzd;
                    if (codecCapabilities != null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
                        iIntValue = 0;
                    } else {
                        iIntValue = ((Integer) videoCapabilities.getBitrateRange().getUpper()).intValue();
                    }
                    if (iIntValue >= 180000000) {
                        i2 = 1024;
                    } else if (iIntValue >= 120000000) {
                        i2 = 512;
                    } else if (iIntValue >= 60000000) {
                        i2 = 256;
                    } else if (iIntValue >= 30000000) {
                        i2 = 128;
                    } else if (iIntValue >= 18000000) {
                        i2 = 64;
                    } else if (iIntValue >= 12000000) {
                        i2 = 32;
                    } else if (iIntValue >= 7200000) {
                        i2 = 16;
                    } else if (iIntValue < 3600000) {
                        if (iIntValue >= 1800000) {
                            i2 = 4;
                        } else if (iIntValue >= 800000) {
                            i2 = 2;
                        } else {
                            i2 = 1;
                        }
                    }
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
                    codecProfileLevel.profile = 1;
                    codecProfileLevel.level = i2;
                    codecProfileLevelArrZzh = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
                }
                for (MediaCodecInfo.CodecProfileLevel codecProfileLevel2 : codecProfileLevelArrZzh) {
                    if (codecProfileLevel2.profile == iIntValue2 || ((codecProfileLevel2.level < iIntValue3 && z) || ("video/hevc".equals(this.zzb) && iIntValue2 == 2 && ("sailfish".equals(zzfy.zzb) || "marlin".equals(zzfy.zzb))))) {
                    }
                }
                zzj("codec.profileLevel, " + zzamVar.zzj + ", " + this.zzc);
                return false;
            }
            if (iIntValue2 == 42) {
                iIntValue2 = 42;
                codecProfileLevelArrZzh = zzh();
                if (zzfy.zza <= 23) {
                    codecCapabilities = this.zzd;
                    if (codecCapabilities != null) {
                        iIntValue = 0;
                    } else {
                        iIntValue = 0;
                    }
                    if (iIntValue >= 180000000) {
                        i2 = 1024;
                    } else if (iIntValue >= 120000000) {
                        i2 = 512;
                    } else if (iIntValue >= 60000000) {
                        i2 = 256;
                    } else if (iIntValue >= 30000000) {
                        i2 = 128;
                    } else if (iIntValue >= 18000000) {
                        i2 = 64;
                    } else if (iIntValue >= 12000000) {
                        i2 = 32;
                    } else if (iIntValue >= 7200000) {
                        i2 = 16;
                    } else if (iIntValue < 3600000) {
                        if (iIntValue >= 1800000) {
                            i2 = 4;
                        } else if (iIntValue >= 800000) {
                            i2 = 2;
                        } else {
                            i2 = 1;
                        }
                    }
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel3 = new MediaCodecInfo.CodecProfileLevel();
                    codecProfileLevel3.profile = 1;
                    codecProfileLevel3.level = i2;
                    codecProfileLevelArrZzh = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel3};
                }
                while (i < r4) {
                    if (codecProfileLevel2.profile == iIntValue2) {
                    }
                }
                zzj("codec.profileLevel, " + zzamVar.zzj + ", " + this.zzc);
                return false;
            }
        }
        return true;
    }

    private final boolean zzm(zzam zzamVar) {
        return this.zzb.equals(zzamVar.zzm) || this.zzb.equals(zztn.zzc(zzamVar));
    }

    public final String toString() {
        return this.zza;
    }

    public final Point zza(int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return zzi(videoCapabilities, i, i2);
    }

    public final zzis zzb(zzam zzamVar, zzam zzamVar2) {
        int i = true != zzfy.zzF(zzamVar.zzm, zzamVar2.zzm) ? 8 : 0;
        if (this.zzh) {
            if (zzamVar.zzu != zzamVar2.zzu) {
                i |= 1024;
            }
            if (!this.zze && (zzamVar.zzr != zzamVar2.zzr || zzamVar.zzs != zzamVar2.zzs)) {
                i |= 512;
            }
            if (!zzfy.zzF(zzamVar.zzy, zzamVar2.zzy)) {
                i |= 2048;
            }
            String str = this.zza;
            if (zzfy.zzd.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str) && !zzamVar.zzd(zzamVar2)) {
                i |= 2;
            }
            if (i == 0) {
                return new zzis(this.zza, zzamVar, zzamVar2, true != zzamVar.zzd(zzamVar2) ? 2 : 3, 0);
            }
        } else {
            if (zzamVar.zzz != zzamVar2.zzz) {
                i |= 4096;
            }
            if (zzamVar.zzA != zzamVar2.zzA) {
                i |= 8192;
            }
            if (zzamVar.zzB != zzamVar2.zzB) {
                i |= 16384;
            }
            if (i == 0 && "audio/mp4a-latm".equals(this.zzb)) {
                Pair pairZza = zztn.zza(zzamVar);
                Pair pairZza2 = zztn.zza(zzamVar2);
                if (pairZza != null && pairZza2 != null) {
                    int iIntValue = ((Integer) pairZza.first).intValue();
                    int iIntValue2 = ((Integer) pairZza2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new zzis(this.zza, zzamVar, zzamVar2, 3, 0);
                    }
                }
            }
            if (!zzamVar.zzd(zzamVar2)) {
                i |= 32;
            }
            if ("audio/opus".equals(this.zzb)) {
                i |= 2;
            }
            if (i == 0) {
                return new zzis(this.zza, zzamVar, zzamVar2, 1, 0);
            }
        }
        return new zzis(this.zza, zzamVar, zzamVar2, 0, i);
    }

    public final boolean zzd(zzam zzamVar) {
        return zzm(zzamVar) && zzl(zzamVar, false);
    }

    public final boolean zze(zzam zzamVar) throws zzth {
        int i;
        if (!zzm(zzamVar) || !zzl(zzamVar, true)) {
            return false;
        }
        if (this.zzh) {
            if (zzamVar.zzr <= 0 || zzamVar.zzs <= 0) {
                return true;
            }
            int i2 = zzfy.zza;
            return zzg(zzamVar.zzr, zzamVar.zzs, zzamVar.zzt);
        }
        int i3 = zzfy.zza;
        int i4 = zzamVar.zzA;
        if (i4 != -1) {
            MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
            if (codecCapabilities == null) {
                zzj("sampleRate.caps");
                return false;
            }
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                zzj("sampleRate.aCaps");
                return false;
            }
            if (!audioCapabilities.isSampleRateSupported(i4)) {
                zzj("sampleRate.support, " + i4);
                return false;
            }
        }
        int i5 = zzamVar.zzz;
        if (i5 != -1) {
            MediaCodecInfo.CodecCapabilities codecCapabilities2 = this.zzd;
            if (codecCapabilities2 == null) {
                zzj("channelCount.caps");
            } else {
                MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities2.getAudioCapabilities();
                if (audioCapabilities2 == null) {
                    zzj("channelCount.aCaps");
                } else {
                    String str = this.zza;
                    String str2 = this.zzb;
                    int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                    if (maxInputChannelCount <= 1 && ((zzfy.zza < 26 || maxInputChannelCount <= 0) && !"audio/mpeg".equals(str2) && !"audio/3gpp".equals(str2) && !"audio/amr-wb".equals(str2) && !"audio/mp4a-latm".equals(str2) && !"audio/vorbis".equals(str2) && !"audio/opus".equals(str2) && !"audio/raw".equals(str2) && !"audio/flac".equals(str2) && !"audio/g711-alaw".equals(str2) && !"audio/g711-mlaw".equals(str2) && !"audio/gsm".equals(str2))) {
                        if ("audio/ac3".equals(str2)) {
                            i = 6;
                        } else {
                            i = "audio/eac3".equals(str2) ? 16 : 30;
                        }
                        zzff.zzf("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + maxInputChannelCount + " to " + i + "]");
                        maxInputChannelCount = i;
                    }
                    if (maxInputChannelCount < i5) {
                        zzj("channelCount.support, " + i5);
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final boolean zzf(zzam zzamVar) {
        if (this.zzh) {
            return this.zze;
        }
        Pair pairZza = zztn.zza(zzamVar);
        return pairZza != null && ((Integer) pairZza.first).intValue() == 42;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0058  */
    public final boolean zzg(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null) {
            zzj("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzj("sizeAndRate.vCaps");
            return false;
        }
        if (zzfy.zza >= 29) {
            int iZza = zzsu.zza(videoCapabilities, this.zzb, i, i2, d);
            if (iZza != 2) {
                if (iZza == 1) {
                    zzj("sizeAndRate.cover, " + i + "x" + i2 + "@" + d);
                    return false;
                }
                if (!zzk(videoCapabilities, i, i2, d)) {
                    if (i < i2) {
                    }
                    zzj("sizeAndRate.support, " + i + "x" + i2 + "@" + d);
                    return false;
                }
            }
        } else if (!zzk(videoCapabilities, i, i2, d)) {
            if (i < i2 || (("OMX.MTK.VIDEO.DECODER.HEVC".equals(this.zza) && "mcv5a".equals(zzfy.zzb)) || !zzk(videoCapabilities, i2, i, d))) {
                zzj("sizeAndRate.support, " + i + "x" + i2 + "@" + d);
                return false;
            }
            zzff.zzb("MediaCodecInfo", "AssumedSupport [" + ("sizeAndRate.rotated, " + i + "x" + i2 + "@" + d) + "] [" + this.zza + ", " + this.zzb + "] [" + zzfy.zze + "]");
        }
        return true;
    }

    public final MediaCodecInfo.CodecProfileLevel[] zzh() {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        return (codecCapabilities == null || codecCapabilities.profileLevels == null) ? new MediaCodecInfo.CodecProfileLevel[0] : this.zzd.profileLevels;
    }

    zzsv(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        str.getClass();
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = codecCapabilities;
        this.zzg = z;
        this.zze = z4;
        this.zzf = z6;
        this.zzh = zzcb.zzh(str2);
    }
}
