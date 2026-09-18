package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.core.location.LocationRequestCompat;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcb {
    public static final /* synthetic */ int zza = 0;
    private static final ArrayList zzb = new ArrayList();
    private static final Pattern zzc = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:41:0x008e  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int zza(String str, String str2) {
        byte b;
        zzca zzcaVarZzc;
        switch (str.hashCode()) {
            case -2123537834:
                if (!str.equals("audio/eac3-joc")) {
                    b = -1;
                } else {
                    b = 4;
                }
                break;
            case -1365340241:
                if (!str.equals("audio/vnd.dts.hd;profile=lbr")) {
                    b = -1;
                } else {
                    b = 8;
                }
                break;
            case -1095064472:
                if (!str.equals("audio/vnd.dts")) {
                    b = -1;
                } else {
                    b = 6;
                }
                break;
            case -53558318:
                if (!str.equals("audio/mp4a-latm")) {
                    b = -1;
                } else {
                    b = 1;
                }
                break;
            case 187078296:
                if (!str.equals("audio/ac3")) {
                    b = -1;
                } else {
                    b = 2;
                }
                break;
            case 187078297:
                if (!str.equals("audio/ac4")) {
                    b = -1;
                } else {
                    b = 5;
                }
                break;
            case 550520934:
                if (!str.equals("audio/vnd.dts.uhd;profile=p2")) {
                    b = -1;
                } else {
                    b = 9;
                }
                break;
            case 1504578661:
                if (!str.equals("audio/eac3")) {
                    b = -1;
                } else {
                    b = 3;
                }
                break;
            case 1504831518:
                if (!str.equals("audio/mpeg")) {
                    b = -1;
                } else {
                    b = 0;
                }
                break;
            case 1504891608:
                if (!str.equals("audio/opus")) {
                    b = -1;
                } else {
                    b = Ascii.VT;
                }
                break;
            case 1505942594:
                if (!str.equals("audio/vnd.dts.hd")) {
                    b = -1;
                } else {
                    b = 7;
                }
                break;
            case 1556697186:
                if (!str.equals("audio/true-hd")) {
                    b = -1;
                } else {
                    b = 10;
                }
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                return 9;
            case 1:
                if (str2 == null || (zzcaVarZzc = zzc(str2)) == null) {
                    return 0;
                }
                return zzcaVarZzc.zza();
            case 2:
                return 5;
            case 3:
                return 6;
            case 4:
                return 18;
            case 5:
                return 17;
            case 6:
                return 7;
            case 7:
            case 8:
                return 8;
            case 9:
                return 30;
            case 10:
                return 14;
            case 11:
                return 20;
            default:
                return 0;
        }
    }

    public static int zzb(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (zzg(str)) {
            return 1;
        }
        if (zzh(str)) {
            return 2;
        }
        if ("text".equals(zzi(str)) || "application/x-media3-cues".equals(str) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
            return 3;
        }
        if ("image".equals(zzi(str)) || "application/x-image-uri".equals(str)) {
            return 4;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
            return 5;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 6;
        }
        int size = zzb.size();
        for (int i = 0; i < size; i++) {
            zzbz zzbzVar = (zzbz) zzb.get(i);
            String str2 = zzbzVar.zza;
            if (str.equals(null)) {
                int i2 = zzbzVar.zzb;
                return 0;
            }
        }
        return -1;
    }

    static zzca zzc(String str) {
        Matcher matcher = zzc.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String strGroup = matcher.group(1);
        strGroup.getClass();
        String strGroup2 = matcher.group(2);
        try {
            return new zzca(Integer.parseInt(strGroup, 16), strGroup2 != null ? Integer.parseInt(strGroup2) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static String zzd(int i) {
        if (i == 32) {
            return "video/mp4v-es";
        }
        if (i == 33) {
            return "video/avc";
        }
        if (i == 35) {
            return "video/hevc";
        }
        if (i == 64) {
            return "audio/mp4a-latm";
        }
        if (i == 163) {
            return "video/wvc1";
        }
        if (i == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i == 221) {
            return "audio/vorbis";
        }
        if (i == 165) {
            return "audio/ac3";
        }
        if (i == 166) {
            return "audio/eac3";
        }
        switch (i) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return "video/mpeg2";
            case LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY /* 102 */:
            case 103:
            case LocationRequestCompat.QUALITY_LOW_POWER /* 104 */:
                return "audio/mp4a-latm";
            case 105:
            case 107:
                return "audio/mpeg";
            case 106:
                return "video/mpeg";
            default:
                switch (i) {
                    case 169:
                    case 172:
                        return "audio/vnd.dts";
                    case 170:
                    case 171:
                        return "audio/vnd.dts.hd";
                    case 173:
                        return "audio/opus";
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:26:0x0051  */
    public static String zze(String str) {
        byte b;
        if (str == null) {
            return null;
        }
        String strZza = zzfwk.zza(str);
        switch (strZza) {
            case "audio/x-flac":
                b = 0;
                break;
            case "application/x-mpegurl":
                b = 3;
                break;
            case "audio/x-wav":
                b = 2;
                break;
            case "audio/mpeg-l1":
                b = 4;
                break;
            case "audio/mpeg-l2":
                b = 5;
                break;
            case "audio/mp3":
                b = 1;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            return "audio/flac";
        }
        if (b == 1) {
            return "audio/mpeg";
        }
        if (b == 2) {
            return "audio/wav";
        }
        if (b == 3) {
            return "application/x-mpegURL";
        }
        if (b != 4) {
            return b != 5 ? strZza : "audio/mpeg-L2";
        }
        return "audio/mpeg-L1";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:41:0x0081  */
    public static boolean zzf(String str, String str2) {
        zzca zzcaVarZzc;
        int iZza;
        if (str == null) {
            return false;
        }
        switch (str) {
            case "audio/mpeg":
            case "audio/mpeg-L1":
            case "audio/mpeg-L2":
            case "audio/raw":
            case "audio/g711-alaw":
            case "audio/g711-mlaw":
            case "audio/flac":
            case "audio/ac3":
            case "audio/eac3":
            case "audio/eac3-joc":
                return true;
            case "audio/mp4a-latm":
                return (str2 == null || (zzcaVarZzc = zzc(str2)) == null || (iZza = zzcaVarZzc.zza()) == 0 || iZza == 16) ? false : true;
            default:
                return false;
        }
    }

    public static boolean zzg(String str) {
        return "audio".equals(zzi(str));
    }

    public static boolean zzh(String str) {
        return "video".equals(zzi(str));
    }

    private static String zzi(String str) {
        int iIndexOf;
        if (str == null || (iIndexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, iIndexOf);
    }
}
