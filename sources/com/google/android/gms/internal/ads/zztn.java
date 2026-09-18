package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zztn {
    public static final /* synthetic */ int zza = 0;
    private static final Pattern zzb = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap zzc = new HashMap();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:137:0x024b  */
    /* JADX WARN: Code duplicated, block: B:15:0x0064  */
    /* JADX WARN: Code duplicated, block: B:173:0x02bf A[Catch: NumberFormatException -> 0x02d0, TRY_LEAVE, TryCatch #3 {NumberFormatException -> 0x02d0, blocks: (B:144:0x0269, B:146:0x027b, B:157:0x0297, B:173:0x02bf), top: B:481:0x0269 }] */
    /* JADX WARN: Code duplicated, block: B:244:0x0425  */
    /* JADX WARN: Code duplicated, block: B:326:0x0556  */
    /* JADX WARN: Code duplicated, block: B:410:0x06d0  */
    /* JADX WARN: Code duplicated, block: B:411:0x06e3  */
    /* JADX WARN: Code duplicated, block: B:445:0x0781  */
    /* JADX WARN: Code duplicated, block: B:446:0x0794  */
    /* JADX WARN: Code duplicated, block: B:447:0x0797  */
    /* JADX WARN: Code duplicated, block: B:448:0x079a  */
    /* JADX WARN: Code duplicated, block: B:449:0x079d  */
    /* JADX WARN: Code duplicated, block: B:450:0x07a0  */
    /* JADX WARN: Code duplicated, block: B:451:0x07a3  */
    /* JADX WARN: Code duplicated, block: B:452:0x07a5  */
    /* JADX WARN: Code duplicated, block: B:453:0x07a8  */
    /* JADX WARN: Code duplicated, block: B:454:0x07ac  */
    /* JADX WARN: Code duplicated, block: B:455:0x07af  */
    /* JADX WARN: Code duplicated, block: B:456:0x07b1  */
    /* JADX WARN: Code duplicated, block: B:457:0x07b4  */
    /* JADX WARN: Code duplicated, block: B:458:0x07b7  */
    /* JADX WARN: Code duplicated, block: B:459:0x07b9  */
    /* JADX WARN: Code duplicated, block: B:460:0x07bb  */
    /* JADX WARN: Code duplicated, block: B:461:0x07be  */
    /* JADX WARN: Code duplicated, block: B:462:0x07c0  */
    /* JADX WARN: Code duplicated, block: B:463:0x07c3  */
    /* JADX WARN: Code duplicated, block: B:464:0x07c5  */
    /* JADX WARN: Code duplicated, block: B:465:0x07c7  */
    /* JADX WARN: Code duplicated, block: B:466:0x07ca  */
    /* JADX WARN: Code duplicated, block: B:467:0x07cc  */
    /* JADX WARN: Code duplicated, block: B:470:0x07d0  */
    /* JADX WARN: Code duplicated, block: B:471:0x07e3  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:66:0x0121  */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r2v137 int, still in use, count: 1, list:
  (r2v137 int) from 0x012b: SWITCH (r2v137 int)
 case 1567: goto B:80:0x015f
 case 1568: goto B:77:0x014f
 case 1569: goto B:74:0x013f
 case 1570: goto B:71:0x012f
 default: goto B:66:0x0121 A[RegionRef:SW:69]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:226)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:215)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:355)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Instruction removed from duplicated block: B:410:0x06d0, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:445:0x0781, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:470:0x07d0, please report this as an issue */
    public static Pair zza(zzam zzamVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        byte b;
        Integer num;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Integer num2;
        Integer num3;
        String str = zzamVar.zzj;
        if (str != null) {
            String[] strArrSplit = str.split("\\.");
            int i14 = 8;
            int i15 = 2;
            if (!"video/dolby-vision".equals(zzamVar.zzm)) {
                switch (strArrSplit[0]) {
                    case "avc1":
                    case "avc2":
                        String str2 = zzamVar.zzj;
                        int length = strArrSplit.length;
                        if (length < 2) {
                            zzff.zzf("MediaCodecUtil", "Ignoring malformed AVC codec string: ".concat(String.valueOf(str2)));
                            break;
                        } else {
                            try {
                                if (strArrSplit[1].length() != 6) {
                                    i = 16;
                                    if (length < 3) {
                                        zzff.zzf("MediaCodecUtil", "Ignoring malformed AVC codec string: " + str2);
                                    } else {
                                        i2 = Integer.parseInt(strArrSplit[1]);
                                        i3 = Integer.parseInt(strArrSplit[2]);
                                    }
                                } else {
                                    i = 16;
                                    i2 = Integer.parseInt(strArrSplit[1].substring(0, 2), 16);
                                    i3 = Integer.parseInt(strArrSplit[1].substring(4), 16);
                                }
                                if (i2 != 66) {
                                    if (i2 != 77) {
                                        if (i2 == 88) {
                                            i15 = 4;
                                        } else if (i2 == 100) {
                                            i4 = -1;
                                            i15 = 8;
                                        } else if (i2 == 110) {
                                            i15 = i;
                                        } else if (i2 == 122) {
                                            i15 = 32;
                                        } else if (i2 != 244) {
                                            i4 = -1;
                                            i15 = -1;
                                        } else {
                                            i15 = 64;
                                        }
                                    }
                                    if (i15 == i4) {
                                        zzff.zzf("MediaCodecUtil", "Unknown AVC profile: " + i2);
                                    } else {
                                        switch (i3) {
                                            case 10:
                                                i5 = 1;
                                                break;
                                            case 11:
                                                i5 = 4;
                                                break;
                                            case 12:
                                                i5 = 8;
                                                break;
                                            case 13:
                                                i5 = i;
                                                break;
                                            default:
                                                switch (i3) {
                                                    case 20:
                                                        i5 = 32;
                                                        break;
                                                    case 21:
                                                        i5 = 64;
                                                        break;
                                                    case 22:
                                                        i5 = 128;
                                                        break;
                                                    default:
                                                        switch (i3) {
                                                            case 30:
                                                                i5 = 256;
                                                                break;
                                                            case 31:
                                                                i5 = 512;
                                                                break;
                                                            case 32:
                                                                i5 = 1024;
                                                                break;
                                                            default:
                                                                switch (i3) {
                                                                    case 40:
                                                                        i5 = 2048;
                                                                        break;
                                                                    case 41:
                                                                        i5 = 4096;
                                                                        break;
                                                                    case 42:
                                                                        i5 = 8192;
                                                                        break;
                                                                    default:
                                                                        switch (i3) {
                                                                            case 50:
                                                                                i5 = 16384;
                                                                                break;
                                                                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                                                                i5 = 32768;
                                                                                break;
                                                                            case 52:
                                                                                i5 = 65536;
                                                                                break;
                                                                            default:
                                                                                i5 = -1;
                                                                                break;
                                                                        }
                                                                        break;
                                                                }
                                                                break;
                                                        }
                                                        break;
                                                }
                                                break;
                                        }
                                        if (i5 == -1) {
                                            return new Pair(Integer.valueOf(i15), Integer.valueOf(i5));
                                        }
                                        zzff.zzf("MediaCodecUtil", "Unknown AVC level: " + i3);
                                    }
                                } else {
                                    i15 = 1;
                                }
                                i4 = -1;
                                if (i15 == i4) {
                                    zzff.zzf("MediaCodecUtil", "Unknown AVC profile: " + i2);
                                } else {
                                    switch (i3) {
                                        case 10:
                                            i5 = 1;
                                            break;
                                        case 11:
                                            i5 = 4;
                                            break;
                                        case 12:
                                            i5 = 8;
                                            break;
                                        case 13:
                                            i5 = i;
                                            break;
                                        default:
                                            switch (i3) {
                                                case 20:
                                                    i5 = 32;
                                                    break;
                                                case 21:
                                                    i5 = 64;
                                                    break;
                                                case 22:
                                                    i5 = 128;
                                                    break;
                                                default:
                                                    switch (i3) {
                                                        case 30:
                                                            i5 = 256;
                                                            break;
                                                        case 31:
                                                            i5 = 512;
                                                            break;
                                                        case 32:
                                                            i5 = 1024;
                                                            break;
                                                        default:
                                                            switch (i3) {
                                                                case 40:
                                                                    i5 = 2048;
                                                                    break;
                                                                case 41:
                                                                    i5 = 4096;
                                                                    break;
                                                                case 42:
                                                                    i5 = 8192;
                                                                    break;
                                                                default:
                                                                    switch (i3) {
                                                                        case 50:
                                                                            i5 = 16384;
                                                                            break;
                                                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                                                            i5 = 32768;
                                                                            break;
                                                                        case 52:
                                                                            i5 = 65536;
                                                                            break;
                                                                        default:
                                                                            i5 = -1;
                                                                            break;
                                                                    }
                                                                    break;
                                                            }
                                                            break;
                                                    }
                                                    break;
                                            }
                                            break;
                                    }
                                    if (i5 == -1) {
                                        return new Pair(Integer.valueOf(i15), Integer.valueOf(i5));
                                    }
                                    zzff.zzf("MediaCodecUtil", "Unknown AVC level: " + i3);
                                }
                            } catch (NumberFormatException unused) {
                                zzff.zzf("MediaCodecUtil", "Ignoring malformed AVC codec string: ".concat(String.valueOf(str2)));
                            }
                            break;
                        }
                        break;
                    case "vp09":
                        String str3 = zzamVar.zzj;
                        if (strArrSplit.length < 3) {
                            zzff.zzf("MediaCodecUtil", "Ignoring malformed VP9 codec string: ".concat(String.valueOf(str3)));
                            break;
                        } else {
                            try {
                                int i16 = Integer.parseInt(strArrSplit[1]);
                                int i17 = Integer.parseInt(strArrSplit[2]);
                                if (i16 == 0) {
                                    i6 = 1;
                                } else if (i16 == 1) {
                                    i6 = 2;
                                } else if (i16 != 2) {
                                    i6 = i16 != 3 ? -1 : 8;
                                } else {
                                    i6 = 4;
                                }
                                if (i6 == -1) {
                                    zzff.zzf("MediaCodecUtil", "Unknown VP9 profile: " + i16);
                                } else {
                                    if (i17 == 10) {
                                        i14 = 1;
                                    } else if (i17 == 11) {
                                        i14 = 2;
                                    } else if (i17 != 20) {
                                        if (i17 != 21) {
                                            if (i17 == 30) {
                                                i7 = -1;
                                                i14 = 16;
                                            } else if (i17 == 31) {
                                                i14 = 32;
                                            } else if (i17 == 40) {
                                                i14 = 64;
                                            } else if (i17 == 41) {
                                                i14 = 128;
                                            } else if (i17 == 50) {
                                                i14 = 256;
                                            } else if (i17 != 51) {
                                                switch (i17) {
                                                    case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                                                        i14 = 2048;
                                                        break;
                                                    case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                                        i14 = 4096;
                                                        break;
                                                    case 62:
                                                        i14 = 8192;
                                                        break;
                                                    default:
                                                        i7 = -1;
                                                        i14 = -1;
                                                        break;
                                                }
                                            } else {
                                                i14 = 512;
                                            }
                                        }
                                        if (i14 == i7) {
                                            return new Pair(Integer.valueOf(i6), Integer.valueOf(i14));
                                        }
                                        zzff.zzf("MediaCodecUtil", "Unknown VP9 level: " + i17);
                                    } else {
                                        i14 = 4;
                                    }
                                    i7 = -1;
                                    if (i14 == i7) {
                                        return new Pair(Integer.valueOf(i6), Integer.valueOf(i14));
                                    }
                                    zzff.zzf("MediaCodecUtil", "Unknown VP9 level: " + i17);
                                }
                            } catch (NumberFormatException unused2) {
                                zzff.zzf("MediaCodecUtil", "Ignoring malformed VP9 codec string: ".concat(String.valueOf(str3)));
                            }
                            break;
                        }
                        break;
                    case "hev1":
                    case "hvc1":
                        String str4 = zzamVar.zzj;
                        zzt zztVar = zzamVar.zzy;
                        if (strArrSplit.length >= 4) {
                            Matcher matcher = zzb.matcher(strArrSplit[1]);
                            if (!matcher.matches()) {
                                zzff.zzf("MediaCodecUtil", "Ignoring malformed HEVC codec string: ".concat(String.valueOf(str4)));
                            } else {
                                String strGroup = matcher.group(1);
                                if ("1".equals(strGroup)) {
                                    i8 = 1;
                                } else if (!"2".equals(strGroup)) {
                                    zzff.zzf("MediaCodecUtil", "Unknown HEVC profile string: ".concat(String.valueOf(strGroup)));
                                } else {
                                    i8 = (zztVar == null || zztVar.zzf != 6) ? 2 : 4096;
                                }
                                String str5 = strArrSplit[3];
                                if (str5 != null) {
                                    switch (str5.hashCode()) {
                                        case 70821:
                                            if (!str5.equals("H30")) {
                                                b = -1;
                                            } else {
                                                b = Ascii.CR;
                                            }
                                            break;
                                        case 70914:
                                            if (!str5.equals("H60")) {
                                                b = -1;
                                            } else {
                                                b = Ascii.SO;
                                            }
                                            break;
                                        case 70917:
                                            if (!str5.equals("H63")) {
                                                b = -1;
                                            } else {
                                                b = Ascii.SI;
                                            }
                                            break;
                                        case 71007:
                                            if (!str5.equals("H90")) {
                                                b = -1;
                                            } else {
                                                b = Ascii.DLE;
                                            }
                                            break;
                                        case 71010:
                                            if (!str5.equals("H93")) {
                                                b = -1;
                                            } else {
                                                b = 17;
                                            }
                                            break;
                                        case 74665:
                                            if (!str5.equals("L30")) {
                                                b = -1;
                                            } else {
                                                b = 0;
                                            }
                                            break;
                                        case 74758:
                                            if (!str5.equals("L60")) {
                                                b = -1;
                                            } else {
                                                b = 1;
                                            }
                                            break;
                                        case 74761:
                                            if (!str5.equals("L63")) {
                                                b = -1;
                                            } else {
                                                b = 2;
                                            }
                                            break;
                                        case 74851:
                                            if (!str5.equals("L90")) {
                                                b = -1;
                                            } else {
                                                b = 3;
                                            }
                                            break;
                                        case 74854:
                                            if (!str5.equals("L93")) {
                                                b = -1;
                                            } else {
                                                b = 4;
                                            }
                                            break;
                                        case 2193639:
                                            if (!str5.equals("H120")) {
                                                b = -1;
                                            } else {
                                                b = Ascii.DC2;
                                            }
                                            break;
                                        case 2193642:
                                            if (!str5.equals("H123")) {
                                                b = -1;
                                            } else {
                                                b = 19;
                                            }
                                            break;
                                        case 2193732:
                                            if (!str5.equals("H150")) {
                                                b = -1;
                                            } else {
                                                b = 20;
                                            }
                                            break;
                                        case 2193735:
                                            if (!str5.equals("H153")) {
                                                b = -1;
                                            } else {
                                                b = Ascii.NAK;
                                            }
                                            break;
                                        case 2193738:
                                            if (!str5.equals("H156")) {
                                                b = -1;
                                            } else {
                                                b = Ascii.SYN;
                                            }
                                            break;
                                        case 2193825:
                                            if (!str5.equals("H180")) {
                                                b = -1;
                                            } else {
                                                b = Ascii.ETB;
                                            }
                                            break;
                                        case 2193828:
                                            if (!str5.equals("H183")) {
                                                b = -1;
                                            } else {
                                                b = Ascii.CAN;
                                            }
                                            break;
                                        case 2193831:
                                            if (!str5.equals("H186")) {
                                                b = -1;
                                            } else {
                                                b = Ascii.EM;
                                            }
                                            break;
                                        case 2312803:
                                            if (!str5.equals("L120")) {
                                                b = -1;
                                            } else {
                                                b = 5;
                                            }
                                            break;
                                        case 2312806:
                                            if (!str5.equals("L123")) {
                                                b = -1;
                                            } else {
                                                b = 6;
                                            }
                                            break;
                                        case 2312896:
                                            if (!str5.equals("L150")) {
                                                b = -1;
                                            } else {
                                                b = 7;
                                            }
                                            break;
                                        case 2312899:
                                            if (!str5.equals("L153")) {
                                                b = -1;
                                            } else {
                                                b = 8;
                                            }
                                            break;
                                        case 2312902:
                                            if (!str5.equals("L156")) {
                                                b = -1;
                                            } else {
                                                b = 9;
                                            }
                                            break;
                                        case 2312989:
                                            if (!str5.equals("L180")) {
                                                b = -1;
                                            } else {
                                                b = 10;
                                            }
                                            break;
                                        case 2312992:
                                            if (!str5.equals("L183")) {
                                                b = -1;
                                            } else {
                                                b = Ascii.VT;
                                            }
                                            break;
                                        case 2312995:
                                            if (!str5.equals("L186")) {
                                                b = -1;
                                            } else {
                                                b = Ascii.FF;
                                            }
                                            break;
                                        default:
                                            b = -1;
                                            break;
                                    }
                                    switch (b) {
                                        case 0:
                                            num = 1;
                                            break;
                                        case 1:
                                            num = 4;
                                            break;
                                        case 2:
                                            num = 16;
                                            break;
                                        case 3:
                                            num = 64;
                                            break;
                                        case 4:
                                            num = 256;
                                            break;
                                        case 5:
                                            num = 1024;
                                            break;
                                        case 6:
                                            num = 4096;
                                            break;
                                        case 7:
                                            num = 16384;
                                            break;
                                        case 8:
                                            num = 65536;
                                            break;
                                        case 9:
                                            num = 262144;
                                            break;
                                        case 10:
                                            num = 1048576;
                                            break;
                                        case 11:
                                            num = 4194304;
                                            break;
                                        case 12:
                                            num = 16777216;
                                            break;
                                        case 13:
                                            num = 2;
                                            break;
                                        case 14:
                                            num = 8;
                                            break;
                                        case 15:
                                            num = 32;
                                            break;
                                        case 16:
                                            num = 128;
                                            break;
                                        case 17:
                                            num = 512;
                                            break;
                                        case 18:
                                            num = 2048;
                                            break;
                                        case 19:
                                            num = 8192;
                                            break;
                                        case 20:
                                            num = 32768;
                                            break;
                                        case 21:
                                            num = 131072;
                                            break;
                                        case 22:
                                            num = 524288;
                                            break;
                                        case 23:
                                            num = 2097152;
                                            break;
                                        case 24:
                                            num = 8388608;
                                            break;
                                        case 25:
                                            num = 33554432;
                                            break;
                                        default:
                                            num = null;
                                            break;
                                    }
                                } else {
                                    num = null;
                                }
                                if (num != null) {
                                    return new Pair(Integer.valueOf(i8), num);
                                }
                                zzff.zzf("MediaCodecUtil", "Unknown HEVC level string: ".concat(String.valueOf(str5)));
                            }
                            break;
                        } else {
                            zzff.zzf("MediaCodecUtil", "Ignoring malformed HEVC codec string: ".concat(String.valueOf(str4)));
                            break;
                        }
                        break;
                    case "av01":
                        String str6 = zzamVar.zzj;
                        zzt zztVar2 = zzamVar.zzy;
                        if (strArrSplit.length < 4) {
                            zzff.zzf("MediaCodecUtil", "Ignoring malformed AV1 codec string: ".concat(String.valueOf(str6)));
                            break;
                        } else {
                            try {
                                int i18 = Integer.parseInt(strArrSplit[1]);
                                int i19 = Integer.parseInt(strArrSplit[2].substring(0, 2));
                                int i20 = Integer.parseInt(strArrSplit[3]);
                                if (i18 != 0) {
                                    zzff.zzf("MediaCodecUtil", "Unknown AV1 profile: " + i18);
                                } else {
                                    if (i20 == 8) {
                                        i9 = 1;
                                    } else if (i20 != 10) {
                                        zzff.zzf("MediaCodecUtil", "Unknown AV1 bit depth: " + i20);
                                    } else {
                                        i9 = (zztVar2 == null || !(zztVar2.zzg != null || (i11 = zztVar2.zzf) == 7 || i11 == 6)) ? 2 : 4096;
                                    }
                                    switch (i19) {
                                        case 0:
                                            i15 = 1;
                                            i10 = -1;
                                            break;
                                        case 1:
                                            i10 = -1;
                                            break;
                                        case 2:
                                            i15 = 4;
                                            i10 = -1;
                                            break;
                                        case 3:
                                            i15 = 8;
                                            i10 = -1;
                                            break;
                                        case 4:
                                            i10 = -1;
                                            i15 = 16;
                                            break;
                                        case 5:
                                            i15 = 32;
                                            i10 = -1;
                                            break;
                                        case 6:
                                            i10 = -1;
                                            i15 = 64;
                                            break;
                                        case 7:
                                            i15 = 128;
                                            i10 = -1;
                                            break;
                                        case 8:
                                            i10 = -1;
                                            i15 = 256;
                                            break;
                                        case 9:
                                            i15 = 512;
                                            i10 = -1;
                                            break;
                                        case 10:
                                            i10 = -1;
                                            i15 = 1024;
                                            break;
                                        case 11:
                                            i10 = -1;
                                            i15 = 2048;
                                            break;
                                        case 12:
                                            i10 = -1;
                                            i15 = 4096;
                                            break;
                                        case 13:
                                            i15 = 8192;
                                            i10 = -1;
                                            break;
                                        case 14:
                                            i15 = 16384;
                                            i10 = -1;
                                            break;
                                        case 15:
                                            i15 = 32768;
                                            i10 = -1;
                                            break;
                                        case 16:
                                            i15 = 65536;
                                            i10 = -1;
                                            break;
                                        case 17:
                                            i15 = 131072;
                                            i10 = -1;
                                            break;
                                        case 18:
                                            i15 = 262144;
                                            i10 = -1;
                                            break;
                                        case 19:
                                            i15 = 524288;
                                            i10 = -1;
                                            break;
                                        case 20:
                                            i15 = 1048576;
                                            i10 = -1;
                                            break;
                                        case 21:
                                            i15 = 2097152;
                                            i10 = -1;
                                            break;
                                        case 22:
                                            i15 = 4194304;
                                            i10 = -1;
                                            break;
                                        case 23:
                                            i15 = 8388608;
                                            i10 = -1;
                                            break;
                                        default:
                                            i10 = -1;
                                            i15 = -1;
                                            break;
                                    }
                                    if (i15 != i10) {
                                        return new Pair(Integer.valueOf(i9), Integer.valueOf(i15));
                                    }
                                    zzff.zzf("MediaCodecUtil", "Unknown AV1 level: " + i19);
                                }
                            } catch (NumberFormatException unused3) {
                                zzff.zzf("MediaCodecUtil", "Ignoring malformed AV1 codec string: ".concat(String.valueOf(str6)));
                            }
                            break;
                        }
                        break;
                    case "mp4a":
                        String str7 = zzamVar.zzj;
                        if (strArrSplit.length != 3) {
                            zzff.zzf("MediaCodecUtil", "Ignoring malformed MP4A codec string: ".concat(String.valueOf(str7)));
                            break;
                        } else {
                            try {
                                if ("audio/mp4a-latm".equals(zzcb.zzd(Integer.parseInt(strArrSplit[1], 16)))) {
                                    int i21 = Integer.parseInt(strArrSplit[2]);
                                    if (i21 == 17) {
                                        i12 = 17;
                                    } else if (i21 == 20) {
                                        i12 = 20;
                                    } else if (i21 == 23) {
                                        i12 = 23;
                                    } else if (i21 == 29) {
                                        i12 = 29;
                                    } else if (i21 == 39) {
                                        i12 = 39;
                                    } else if (i21 != 42) {
                                        switch (i21) {
                                            case 1:
                                                i12 = 1;
                                                break;
                                            case 2:
                                                i12 = 2;
                                                break;
                                            case 3:
                                                i12 = 3;
                                                break;
                                            case 4:
                                                i12 = 4;
                                                break;
                                            case 5:
                                                i13 = -1;
                                                i12 = 5;
                                                break;
                                            case 6:
                                                i13 = -1;
                                                i12 = 6;
                                                break;
                                            default:
                                                i13 = -1;
                                                i12 = -1;
                                                break;
                                        }
                                        if (i12 != i13) {
                                            return new Pair(Integer.valueOf(i12), 0);
                                        }
                                    } else {
                                        i12 = 42;
                                    }
                                    i13 = -1;
                                    if (i12 != i13) {
                                        return new Pair(Integer.valueOf(i12), 0);
                                    }
                                }
                            } catch (NumberFormatException unused4) {
                                zzff.zzf("MediaCodecUtil", "Ignoring malformed MP4A codec string: ".concat(String.valueOf(str7)));
                            }
                            break;
                        }
                        break;
                }
            } else {
                String str8 = zzamVar.zzj;
                if (strArrSplit.length < 3) {
                    zzff.zzf("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: ".concat(String.valueOf(str8)));
                } else {
                    Matcher matcher2 = zzb.matcher(strArrSplit[1]);
                    if (matcher2.matches()) {
                        String strGroup2 = matcher2.group(1);
                        if (strGroup2 != null) {
                            switch (strGroup2) {
                                case "00":
                                    num2 = 1;
                                    break;
                                case "01":
                                    num2 = 2;
                                    break;
                                case "02":
                                    num2 = 4;
                                    break;
                                case "03":
                                    num2 = 8;
                                    break;
                                case "04":
                                    num2 = 16;
                                    break;
                                case "05":
                                    num2 = 32;
                                    break;
                                case "06":
                                    num2 = 64;
                                    break;
                                case "07":
                                    num2 = 128;
                                    break;
                                case "08":
                                    num2 = 256;
                                    break;
                                case "09":
                                    num2 = 512;
                                    break;
                                default:
                                    num2 = null;
                                    break;
                            }
                        } else {
                            num2 = null;
                        }
                        if (num2 == null) {
                            zzff.zzf("MediaCodecUtil", "Unknown Dolby Vision profile string: ".concat(String.valueOf(strGroup2)));
                        } else {
                            String str9 = strArrSplit[2];
                            if (str9 != null) {
                                switch (str9) {
                                    case "01":
                                        num3 = 1;
                                        break;
                                    case "02":
                                        num3 = 2;
                                        break;
                                    case "03":
                                        num3 = 4;
                                        break;
                                    case "04":
                                        num3 = 8;
                                        break;
                                    case "05":
                                        num3 = 16;
                                        break;
                                    case "06":
                                        num3 = 32;
                                        break;
                                    case "07":
                                        num3 = 64;
                                        break;
                                    case "08":
                                        num3 = 128;
                                        break;
                                    case "09":
                                        num3 = 256;
                                        break;
                                    default:
                                        switch (str9) {
                                            case 1567:
                                                if (!str9.equals("10")) {
                                                    num3 = null;
                                                } else {
                                                    num3 = 512;
                                                }
                                                break;
                                            case 1568:
                                                if (!str9.equals("11")) {
                                                    num3 = null;
                                                } else {
                                                    num3 = 1024;
                                                }
                                                break;
                                            case 1569:
                                                if (!str9.equals("12")) {
                                                    num3 = null;
                                                } else {
                                                    num3 = 2048;
                                                }
                                                break;
                                            case 1570:
                                                if (!str9.equals("13")) {
                                                    num3 = null;
                                                } else {
                                                    num3 = 4096;
                                                }
                                                break;
                                            default:
                                                num3 = null;
                                                break;
                                        }
                                }
                            } else {
                                num3 = null;
                            }
                            if (num3 != null) {
                                return new Pair(num2, num3);
                            }
                            zzff.zzf("MediaCodecUtil", "Unknown Dolby Vision level string: ".concat(String.valueOf(str9)));
                        }
                    } else {
                        zzff.zzf("MediaCodecUtil", "Ignoring malformed Dolby Vision codec string: ".concat(String.valueOf(str8)));
                    }
                }
            }
        }
        return null;
    }

    public static zzsv zzb() throws zzth {
        List listZze = zze("audio/raw", false, false);
        if (listZze.isEmpty()) {
            return null;
        }
        return (zzsv) listZze.get(0);
    }

    public static String zzc(zzam zzamVar) {
        Pair pairZza;
        if ("audio/eac3-joc".equals(zzamVar.zzm)) {
            return "audio/eac3";
        }
        if (!"video/dolby-vision".equals(zzamVar.zzm) || (pairZza = zza(zzamVar)) == null) {
            return null;
        }
        int iIntValue = ((Integer) pairZza.first).intValue();
        if (iIntValue == 16 || iIntValue == 256) {
            return "video/hevc";
        }
        if (iIntValue == 512) {
            return "video/avc";
        }
        return null;
    }

    public static List zzd(zztb zztbVar, zzam zzamVar, boolean z, boolean z2) throws zzth {
        String strZzc = zzc(zzamVar);
        return strZzc == null ? zzgaa.zzl() : zze(strZzc, z, z2);
    }

    public static synchronized List zze(String str, boolean z, boolean z2) throws zzth {
        zztf zztfVar = new zztf(str, z, z2);
        HashMap map = zzc;
        List list = (List) map.get(zztfVar);
        if (list != null) {
            return list;
        }
        int i = zzfy.zza;
        ArrayList arrayListZzh = zzh(zztfVar, new zztl(z, z2));
        if (z && arrayListZzh.isEmpty() && zzfy.zza <= 23) {
            arrayListZzh = zzh(zztfVar, new zztk(null));
            if (!arrayListZzh.isEmpty()) {
                zzff.zzf("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((zzsv) arrayListZzh.get(0)).zza);
            }
        }
        if ("audio/raw".equals(str)) {
            if (zzfy.zza < 26 && zzfy.zzb.equals("R9") && arrayListZzh.size() == 1 && ((zzsv) arrayListZzh.get(0)).zza.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                arrayListZzh.add(zzsv.zzc("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
            }
            zzi(arrayListZzh, new zztm() { // from class: com.google.android.gms.internal.ads.zztd
                @Override // com.google.android.gms.internal.ads.zztm
                public final int zza(Object obj) {
                    int i2 = zztn.zza;
                    String str2 = ((zzsv) obj).zza;
                    if (str2.startsWith("OMX.google") || str2.startsWith("c2.android")) {
                        return 1;
                    }
                    return (zzfy.zza >= 26 || !str2.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
                }
            });
        }
        if (zzfy.zza < 32 && arrayListZzh.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((zzsv) arrayListZzh.get(0)).zza)) {
            arrayListZzh.add((zzsv) arrayListZzh.remove(0));
        }
        zzgaa zzgaaVarZzj = zzgaa.zzj(arrayListZzh);
        map.put(zztfVar, zzgaaVarZzj);
        return zzgaaVarZzj;
    }

    @RequiresNonNull({"#2.sampleMimeType"})
    public static List zzf(zztb zztbVar, zzam zzamVar, boolean z, boolean z2) throws zzth {
        List listZze = zze(zzamVar.zzm, z, z2);
        List listZzd = zzd(zztbVar, zzamVar, z, z2);
        zzfzx zzfzxVar = new zzfzx();
        zzfzxVar.zzh(listZze);
        zzfzxVar.zzh(listZzd);
        return zzfzxVar.zzi();
    }

    public static List zzg(List list, final zzam zzamVar) {
        ArrayList arrayList = new ArrayList(list);
        zzi(arrayList, new zztm() { // from class: com.google.android.gms.internal.ads.zzte
            @Override // com.google.android.gms.internal.ads.zztm
            public final int zza(Object obj) {
                int i = zztn.zza;
                return ((zzsv) obj).zzd(zzamVar) ? 1 : 0;
            }
        });
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0192 A[Catch: Exception -> 0x0225, TryCatch #2 {Exception -> 0x0225, blocks: (B:80:0x0145, B:86:0x015c, B:92:0x0171, B:94:0x0177, B:99:0x0188, B:101:0x0192, B:111:0x01be, B:102:0x0197, B:104:0x01a7, B:106:0x01af, B:95:0x017d), top: B:155:0x0145 }] */
    /* JADX WARN: Code duplicated, block: B:102:0x0197 A[Catch: Exception -> 0x0225, TryCatch #2 {Exception -> 0x0225, blocks: (B:80:0x0145, B:86:0x015c, B:92:0x0171, B:94:0x0177, B:99:0x0188, B:101:0x0192, B:111:0x01be, B:102:0x0197, B:104:0x01a7, B:106:0x01af, B:95:0x017d), top: B:155:0x0145 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x01a7 A[Catch: Exception -> 0x0225, TryCatch #2 {Exception -> 0x0225, blocks: (B:80:0x0145, B:86:0x015c, B:92:0x0171, B:94:0x0177, B:99:0x0188, B:101:0x0192, B:111:0x01be, B:102:0x0197, B:104:0x01a7, B:106:0x01af, B:95:0x017d), top: B:155:0x0145 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:111:0x01be A[Catch: Exception -> 0x0225, TRY_LEAVE, TryCatch #2 {Exception -> 0x0225, blocks: (B:80:0x0145, B:86:0x015c, B:92:0x0171, B:94:0x0177, B:99:0x0188, B:101:0x0192, B:111:0x01be, B:102:0x0197, B:104:0x01a7, B:106:0x01af, B:95:0x017d), top: B:155:0x0145 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x01c2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:116:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:125:0x01fa A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:141:0x0234 A[Catch: Exception -> 0x0282, TRY_ENTER, TryCatch #5 {Exception -> 0x0282, blocks: (B:3:0x0008, B:5:0x001d, B:7:0x0027, B:10:0x0034, B:14:0x0042, B:16:0x0048, B:18:0x004e, B:20:0x0056, B:22:0x005e, B:24:0x0068, B:26:0x0072, B:28:0x007c, B:30:0x0086, B:32:0x0090, B:34:0x009a, B:36:0x00a4, B:38:0x00ae, B:40:0x00b8, B:42:0x00be, B:44:0x00c6, B:46:0x00ce, B:48:0x00d7, B:138:0x022c, B:141:0x0234, B:143:0x023a, B:144:0x0254, B:145:0x0275, B:51:0x00e0, B:52:0x00e3, B:54:0x00eb, B:57:0x00f6, B:59:0x00fe, B:62:0x0109, B:64:0x0111, B:67:0x011c, B:69:0x0124, B:72:0x012f, B:74:0x0137), top: B:161:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x01c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:165:0x0254 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:0x0276 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x0142 A[EDGE_INSN: B:78:0x0142->B:79:0x0143 BREAK  A[LOOP:1: B:47:0x00d5->B:51:0x00e0]] */
    /* JADX WARN: Code duplicated, block: B:88:0x016a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:89:0x016c  */
    /* JADX WARN: Code duplicated, block: B:90:0x016d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:91:0x016f  */
    /* JADX WARN: Code duplicated, block: B:94:0x0177 A[Catch: Exception -> 0x0225, TryCatch #2 {Exception -> 0x0225, blocks: (B:80:0x0145, B:86:0x015c, B:92:0x0171, B:94:0x0177, B:99:0x0188, B:101:0x0192, B:111:0x01be, B:102:0x0197, B:104:0x01a7, B:106:0x01af, B:95:0x017d), top: B:155:0x0145 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x017d A[Catch: Exception -> 0x0225, TryCatch #2 {Exception -> 0x0225, blocks: (B:80:0x0145, B:86:0x015c, B:92:0x0171, B:94:0x0177, B:99:0x0188, B:101:0x0192, B:111:0x01be, B:102:0x0197, B:104:0x01a7, B:106:0x01af, B:95:0x017d), top: B:155:0x0145 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x0183  */
    /* JADX WARN: Code duplicated, block: B:98:0x0186  */
    /* JADX WARN: Code duplicated, block: B:9:0x002d  */
    private static ArrayList zzh(zztf zztfVar, zzti zztiVar) throws zzth {
        String str;
        String str2;
        int i;
        int i2;
        String str3;
        boolean zZzd;
        boolean zZzc;
        boolean zIsHardwareAccelerated;
        boolean zZzj;
        String strZza;
        boolean zIsVendor;
        zztf zztfVar2 = zztfVar;
        try {
            ArrayList arrayList = new ArrayList();
            String str4 = zztfVar2.zza;
            boolean zZze = zztiVar.zze();
            int i3 = 0;
            for (int iZza = zztiVar.zza(); i3 < iZza; iZza = i2) {
                MediaCodecInfo mediaCodecInfoZzb = zztiVar.zzb(i3);
                if (zzfy.zza < 29 || !mediaCodecInfoZzb.isAlias()) {
                    String name = mediaCodecInfoZzb.getName();
                    if (mediaCodecInfoZzb.isEncoder() || ((!zZze && name.endsWith(".secure")) || ((zzfy.zza < 24 && (("OMX.SEC.aac.dec".equals(name) || "OMX.Exynos.AAC.Decoder".equals(name)) && "samsung".equals(zzfy.zzc) && (zzfy.zzb.startsWith("zeroflte") || zzfy.zzb.startsWith("zerolte") || zzfy.zzb.startsWith("zenlte") || "SC-05G".equals(zzfy.zzb) || "marinelteatt".equals(zzfy.zzb) || "404SC".equals(zzfy.zzb) || "SC-04G".equals(zzfy.zzb) || "SCV31".equals(zzfy.zzb)))) || (zzfy.zza <= 23 && "audio/eac3-joc".equals(str4) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(name))))) {
                        i = i3;
                        i2 = iZza;
                        str3 = str4;
                    } else {
                        String[] supportedTypes = mediaCodecInfoZzb.getSupportedTypes();
                        int length = supportedTypes.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= length) {
                                if (!str4.equals("video/dolby-vision")) {
                                    if (!str4.equals("audio/alac") || !"OMX.lge.alac.decoder".equals(name)) {
                                        if (!str4.equals("audio/flac") || !"OMX.lge.flac.decoder".equals(name)) {
                                            if (!str4.equals("audio/ac3") || !"OMX.lge.ac3.decoder".equals(name)) {
                                                str = null;
                                                break;
                                            }
                                            str = "audio/lg-ac3";
                                            break;
                                        }
                                        str = "audio/x-lg-flac";
                                        break;
                                    }
                                    str = "audio/x-lg-alac";
                                    break;
                                }
                                if (!"OMX.MS.HEVCDV.Decoder".equals(name)) {
                                    if (!"OMX.RTK.video.decoder".equals(name) && !"OMX.realtek.video.decoder.tunneled".equals(name)) {
                                        str = null;
                                        break;
                                    }
                                    str = "video/dv_hevc";
                                    break;
                                }
                                str = "video/hevcdv";
                                break;
                            }
                            str = supportedTypes[i4];
                            if (str.equalsIgnoreCase(str4)) {
                                break;
                            }
                            i4++;
                        }
                        if (str != null) {
                            try {
                                MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfoZzb.getCapabilitiesForType(str);
                                boolean zZzd2 = zztiVar.zzd("tunneled-playback", str, capabilitiesForType);
                                boolean zZzc2 = zztiVar.zzc("tunneled-playback", str, capabilitiesForType);
                                if (zztfVar2.zzc) {
                                    if (zZzd2) {
                                        zZzd = zztiVar.zzd("secure-playback", str, capabilitiesForType);
                                        zZzc = zztiVar.zzc("secure-playback", str, capabilitiesForType);
                                        if (zztfVar2.zzb) {
                                            if (zZzd) {
                                                zZzd = true;
                                                if (zzfy.zza >= 29) {
                                                    zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                                } else if (zzj(mediaCodecInfoZzb, str4)) {
                                                    zIsHardwareAccelerated = false;
                                                } else {
                                                    zIsHardwareAccelerated = true;
                                                }
                                                zZzj = zzj(mediaCodecInfoZzb, str4);
                                                if (zzfy.zza >= 29) {
                                                    zIsVendor = mediaCodecInfoZzb.isVendor();
                                                } else {
                                                    strZza = zzfwk.zza(mediaCodecInfoZzb.getName());
                                                    if (strZza.startsWith("omx.google.")) {
                                                        zIsVendor = false;
                                                    } else {
                                                        zIsVendor = false;
                                                    }
                                                }
                                                if (zZze) {
                                                    if (!zZze) {
                                                        if (!zztfVar2.zzb) {
                                                            i = i3;
                                                            i2 = iZza;
                                                            str3 = str4;
                                                            arrayList.add(zzsv.zzc(name, str4, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                        }
                                                    }
                                                    i = i3;
                                                    i2 = iZza;
                                                    str3 = str4;
                                                    if (zZze) {
                                                        continue;
                                                    }
                                                } else {
                                                    if (!zZze) {
                                                        if (!zztfVar2.zzb) {
                                                            i = i3;
                                                            i2 = iZza;
                                                            str3 = str4;
                                                            arrayList.add(zzsv.zzc(name, str4, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                        }
                                                    }
                                                    i = i3;
                                                    i2 = iZza;
                                                    str3 = str4;
                                                    if (zZze) {
                                                        continue;
                                                    }
                                                }
                                            }
                                        } else if (!zZzc) {
                                            if (zzfy.zza >= 29) {
                                                zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                            } else if (zzj(mediaCodecInfoZzb, str4)) {
                                                zIsHardwareAccelerated = true;
                                            } else {
                                                zIsHardwareAccelerated = false;
                                            }
                                            zZzj = zzj(mediaCodecInfoZzb, str4);
                                            if (zzfy.zza >= 29) {
                                                zIsVendor = mediaCodecInfoZzb.isVendor();
                                            } else {
                                                strZza = zzfwk.zza(mediaCodecInfoZzb.getName());
                                                if (strZza.startsWith("omx.google.")) {
                                                    zIsVendor = false;
                                                } else {
                                                    zIsVendor = false;
                                                }
                                            }
                                            if (zZze) {
                                                if (!zZze) {
                                                    if (!zztfVar2.zzb) {
                                                        i = i3;
                                                        i2 = iZza;
                                                        str3 = str4;
                                                        arrayList.add(zzsv.zzc(name, str4, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                    }
                                                }
                                                i = i3;
                                                i2 = iZza;
                                                str3 = str4;
                                                if (zZze) {
                                                    continue;
                                                }
                                            } else {
                                                if (!zZze) {
                                                    if (!zztfVar2.zzb) {
                                                        i = i3;
                                                        i2 = iZza;
                                                        str3 = str4;
                                                        arrayList.add(zzsv.zzc(name, str4, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                    }
                                                }
                                                i = i3;
                                                i2 = iZza;
                                                str3 = str4;
                                                if (zZze) {
                                                    continue;
                                                }
                                            }
                                        }
                                    }
                                } else if (!zZzc2) {
                                    zZzd = zztiVar.zzd("secure-playback", str, capabilitiesForType);
                                    zZzc = zztiVar.zzc("secure-playback", str, capabilitiesForType);
                                    if (zztfVar2.zzb) {
                                        if (!zZzc) {
                                            if (zzfy.zza >= 29) {
                                                zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                            } else if (zzj(mediaCodecInfoZzb, str4)) {
                                                zIsHardwareAccelerated = true;
                                            } else {
                                                zIsHardwareAccelerated = false;
                                            }
                                            zZzj = zzj(mediaCodecInfoZzb, str4);
                                            if (zzfy.zza >= 29) {
                                                zIsVendor = mediaCodecInfoZzb.isVendor();
                                            } else {
                                                strZza = zzfwk.zza(mediaCodecInfoZzb.getName());
                                                if (strZza.startsWith("omx.google.") || strZza.startsWith("c2.android.") || strZza.startsWith("c2.google.")) {
                                                    zIsVendor = false;
                                                } else {
                                                    zIsVendor = true;
                                                }
                                            }
                                            if (zZze || zztfVar2.zzb != zZzd) {
                                                if (!zZze) {
                                                    try {
                                                        if (!zztfVar2.zzb) {
                                                            i = i3;
                                                            i2 = iZza;
                                                            str3 = str4;
                                                            try {
                                                                arrayList.add(zzsv.zzc(name, str4, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                            } catch (Exception e) {
                                                                e = e;
                                                                str2 = name;
                                                                if (zzfy.zza <= 23) {
                                                                }
                                                                zzff.zzc("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                                                throw e;
                                                            }
                                                        }
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        i = i3;
                                                        i2 = iZza;
                                                        str3 = str4;
                                                        str2 = name;
                                                        if (zzfy.zza <= 23) {
                                                        }
                                                        zzff.zzc("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                                        throw e;
                                                    }
                                                }
                                                i = i3;
                                                i2 = iZza;
                                                str3 = str4;
                                                if (zZze && zZzd) {
                                                    StringBuilder sb = new StringBuilder();
                                                    try {
                                                        sb.append(name);
                                                        sb.append(".secure");
                                                        str2 = name;
                                                        try {
                                                            arrayList.add(zzsv.zzc(sb.toString(), str3, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, true));
                                                            break;
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                            if (zzfy.zza <= 23 || arrayList.isEmpty()) {
                                                                zzff.zzc("MediaCodecUtil", "Failed to query codec " + str2 + " (" + str + ")");
                                                                throw e;
                                                            }
                                                            zzff.zzc("MediaCodecUtil", "Skipping codec " + str2 + " (failed to query capabilities)");
                                                            i3 = i + 1;
                                                            zztfVar2 = zztfVar;
                                                            str4 = str3;
                                                        }
                                                    } catch (Exception e4) {
                                                        e = e4;
                                                        str2 = name;
                                                    }
                                                }
                                            } else {
                                                i = i3;
                                                i2 = iZza;
                                                str3 = str4;
                                                arrayList.add(zzsv.zzc(name, str4, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                            }
                                        }
                                    } else if (zZzd) {
                                        zZzd = true;
                                        if (zzfy.zza >= 29) {
                                            zIsHardwareAccelerated = mediaCodecInfoZzb.isHardwareAccelerated();
                                        } else if (zzj(mediaCodecInfoZzb, str4)) {
                                            zIsHardwareAccelerated = true;
                                        } else {
                                            zIsHardwareAccelerated = false;
                                        }
                                        zZzj = zzj(mediaCodecInfoZzb, str4);
                                        if (zzfy.zza >= 29) {
                                            zIsVendor = mediaCodecInfoZzb.isVendor();
                                        } else {
                                            strZza = zzfwk.zza(mediaCodecInfoZzb.getName());
                                            if (strZza.startsWith("omx.google.")) {
                                                zIsVendor = false;
                                            } else {
                                                zIsVendor = false;
                                            }
                                        }
                                        if (zZze) {
                                            if (!zZze) {
                                                if (!zztfVar2.zzb) {
                                                    i = i3;
                                                    i2 = iZza;
                                                    str3 = str4;
                                                    arrayList.add(zzsv.zzc(name, str4, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                }
                                            }
                                            i = i3;
                                            i2 = iZza;
                                            str3 = str4;
                                            if (zZze) {
                                                continue;
                                            }
                                        } else {
                                            if (!zZze) {
                                                if (!zztfVar2.zzb) {
                                                    i = i3;
                                                    i2 = iZza;
                                                    str3 = str4;
                                                    arrayList.add(zzsv.zzc(name, str4, str, capabilitiesForType, zIsHardwareAccelerated, zZzj, zIsVendor, false, false));
                                                }
                                            }
                                            i = i3;
                                            i2 = iZza;
                                            str3 = str4;
                                            if (zZze) {
                                                continue;
                                            }
                                        }
                                    }
                                }
                                i = i3;
                                i2 = iZza;
                                str3 = str4;
                            } catch (Exception e5) {
                                e = e5;
                                str2 = name;
                                i = i3;
                                i2 = iZza;
                                str3 = str4;
                            }
                        } else {
                            i = i3;
                            i2 = iZza;
                            str3 = str4;
                        }
                    }
                } else {
                    i = i3;
                    i2 = iZza;
                    str3 = str4;
                }
                i3 = i + 1;
                zztfVar2 = zztfVar;
                str4 = str3;
            }
            return arrayList;
        } catch (Exception e6) {
            throw new zzth(e6, null);
        }
    }

    private static void zzi(List list, final zztm zztmVar) {
        Collections.sort(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zztc
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int i = zztn.zza;
                zztm zztmVar2 = zztmVar;
                return zztmVar2.zza(obj2) - zztmVar2.zza(obj);
            }
        });
    }

    private static boolean zzj(MediaCodecInfo mediaCodecInfo, String str) {
        if (zzfy.zza >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        if (zzcb.zzg(str)) {
            return true;
        }
        String strZza = zzfwk.zza(mediaCodecInfo.getName());
        if (strZza.startsWith("arc.")) {
            return false;
        }
        if (strZza.startsWith("omx.google.") || strZza.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((strZza.startsWith("omx.sec.") && strZza.contains(".sw.")) || strZza.equals("omx.qcom.video.decoder.hevcswvdec") || strZza.startsWith("c2.android.") || strZza.startsWith("c2.google.")) {
            return true;
        }
        return (strZza.startsWith("omx.") || strZza.startsWith("c2.")) ? false : true;
    }
}
