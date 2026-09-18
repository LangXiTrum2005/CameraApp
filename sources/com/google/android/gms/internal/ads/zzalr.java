package com.google.android.gms.internal.ads;

import android.text.Layout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.base.Ascii;
import com.google.firebase.messaging.Constants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzalr implements zzakr {
    private final XmlPullParserFactory zzi;
    private static final Pattern zzc = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern zzd = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern zze = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    static final Pattern zza = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    static final Pattern zzb = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final Pattern zzf = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
    private static final Pattern zzg = Pattern.compile("^(\\d+) (\\d+)$");
    private static final zzalp zzh = new zzalp(30.0f, 1, 1);

    /* JADX WARN: Code duplicated, block: B:50:0x00f2  */
    private static long zzc(String str, zzalp zzalpVar) throws zzakn {
        double d;
        double d2;
        Matcher matcher = zzc.matcher(str);
        byte b = 2;
        if (matcher.matches()) {
            String strGroup = matcher.group(1);
            strGroup.getClass();
            long j = Long.parseLong(strGroup) * 3600;
            String strGroup2 = matcher.group(2);
            strGroup2.getClass();
            long j2 = Long.parseLong(strGroup2) * 60;
            String strGroup3 = matcher.group(3);
            strGroup3.getClass();
            double d3 = j + j2;
            double d4 = Long.parseLong(strGroup3);
            String strGroup4 = matcher.group(4);
            double d5 = 0.0d;
            double d6 = strGroup4 != null ? Double.parseDouble(strGroup4) : 0.0d;
            double d7 = d3 + d4;
            String strGroup5 = matcher.group(5);
            double d8 = strGroup5 != null ? Long.parseLong(strGroup5) / zzalpVar.zza : 0.0d;
            double d9 = d7 + d6;
            String strGroup6 = matcher.group(6);
            if (strGroup6 != null) {
                d5 = (Long.parseLong(strGroup6) / ((double) zzalpVar.zzb)) / ((double) zzalpVar.zza);
            }
            return (long) ((d9 + d8 + d5) * 1000000.0d);
        }
        Matcher matcher2 = zzd.matcher(str);
        if (!matcher2.matches()) {
            throw new zzakn("Malformed time expression: ".concat(String.valueOf(str)));
        }
        String strGroup7 = matcher2.group(1);
        strGroup7.getClass();
        double d10 = Double.parseDouble(strGroup7);
        String strGroup8 = matcher2.group(2);
        strGroup8.getClass();
        int iHashCode = strGroup8.hashCode();
        if (iHashCode != 102) {
            if (iHashCode != 104) {
                if (iHashCode != 109) {
                    if (iHashCode != 3494) {
                        if (iHashCode != 115) {
                            if (iHashCode == 116 && strGroup8.equals("t")) {
                                b = 5;
                            } else {
                                b = -1;
                            }
                        } else if (!strGroup8.equals("s")) {
                            b = -1;
                        }
                    } else if (strGroup8.equals("ms")) {
                        b = 3;
                    } else {
                        b = -1;
                    }
                } else if (strGroup8.equals("m")) {
                    b = 1;
                } else {
                    b = -1;
                }
            } else if (strGroup8.equals("h")) {
                b = 0;
            } else {
                b = -1;
            }
        } else if (strGroup8.equals("f")) {
            b = 4;
        } else {
            b = -1;
        }
        if (b != 0) {
            if (b != 1) {
                if (b == 3) {
                    d2 = 1000.0d;
                } else if (b == 4) {
                    d2 = zzalpVar.zza;
                } else if (b == 5) {
                    d2 = zzalpVar.zzc;
                }
                d10 /= d2;
            } else {
                d = 60.0d;
            }
            return (long) (d10 * 1000000.0d);
        }
        d = 3600.0d;
        d10 *= d;
        return (long) (d10 * 1000000.0d);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x0042  */
    private static Layout.Alignment zzd(String str) {
        byte b;
        switch (zzfwk.zza(str)) {
            case "center":
                b = 4;
                break;
            case "end":
                b = 3;
                break;
            case "left":
                b = 0;
                break;
            case "right":
                b = 2;
                break;
            case "start":
                b = 1;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0 || b == 1) {
            return Layout.Alignment.ALIGN_NORMAL;
        }
        if (b == 2 || b == 3) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        if (b != 4) {
            return null;
        }
        return Layout.Alignment.ALIGN_CENTER;
    }

    private static zzalu zze(zzalu zzaluVar) {
        return zzaluVar == null ? new zzalu() : zzaluVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static zzalu zzf(XmlPullParser xmlPullParser, zzalu zzaluVar) {
        byte b;
        Matcher matcher;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeValue = xmlPullParser.getAttributeValue(i);
            String attributeName = xmlPullParser.getAttributeName(i);
            byte b2 = -1;
            switch (attributeName.hashCode()) {
                case -1550943582:
                    b = attributeName.equals("fontStyle") ? (byte) 6 : (byte) -1;
                    break;
                case -1224696685:
                    b = attributeName.equals("fontFamily") ? (byte) 3 : (byte) -1;
                    break;
                case -1065511464:
                    b = attributeName.equals("textAlign") ? (byte) 7 : (byte) -1;
                    break;
                case -879295043:
                    b = attributeName.equals("textDecoration") ? Ascii.FF : (byte) -1;
                    break;
                case -734428249:
                    b = attributeName.equals("fontWeight") ? (byte) 5 : (byte) -1;
                    break;
                case 3355:
                    b = attributeName.equals("id") ? (byte) 0 : (byte) -1;
                    break;
                case 3511770:
                    b = attributeName.equals("ruby") ? (byte) 10 : (byte) -1;
                    break;
                case 94842723:
                    b = attributeName.equals(TypedValues.Custom.S_COLOR) ? (byte) 2 : (byte) -1;
                    break;
                case 109403361:
                    b = attributeName.equals("shear") ? Ascii.SO : (byte) -1;
                    break;
                case 110138194:
                    b = attributeName.equals("textCombine") ? (byte) 9 : (byte) -1;
                    break;
                case 365601008:
                    b = attributeName.equals("fontSize") ? (byte) 4 : (byte) -1;
                    break;
                case 921125321:
                    b = attributeName.equals("textEmphasis") ? Ascii.CR : (byte) -1;
                    break;
                case 1115953443:
                    b = attributeName.equals("rubyPosition") ? Ascii.VT : (byte) -1;
                    break;
                case 1287124693:
                    b = attributeName.equals("backgroundColor") ? (byte) 1 : (byte) -1;
                    break;
                case 1754920356:
                    b = attributeName.equals("multiRowAlign") ? (byte) 8 : (byte) -1;
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    if ("style".equals(xmlPullParser.getName())) {
                        zzaluVar = zze(zzaluVar);
                        zzaluVar.zzs(attributeValue);
                    }
                    break;
                case 1:
                    zzaluVar = zze(zzaluVar);
                    try {
                        zzaluVar.zzm(zzen.zzb(attributeValue));
                    } catch (IllegalArgumentException unused) {
                        zzff.zzf("TtmlParser", "Failed parsing background value: ".concat(String.valueOf(attributeValue)));
                    }
                    break;
                case 2:
                    zzaluVar = zze(zzaluVar);
                    try {
                        zzaluVar.zzo(zzen.zzb(attributeValue));
                    } catch (IllegalArgumentException unused2) {
                        zzff.zzf("TtmlParser", "Failed parsing color value: ".concat(String.valueOf(attributeValue)));
                    }
                    break;
                case 3:
                    zzaluVar = zze(zzaluVar);
                    zzaluVar.zzp(attributeValue);
                    break;
                case 4:
                    try {
                        zzaluVar = zze(zzaluVar);
                        int i2 = zzfy.zza;
                        String[] strArrSplit = attributeValue.split("\\s+", -1);
                        int length = strArrSplit.length;
                        if (length == 1) {
                            matcher = zze.matcher(attributeValue);
                        } else {
                            if (length != 2) {
                                throw new zzakn("Invalid number of entries for fontSize: " + length + ".");
                            }
                            matcher = zze.matcher(strArrSplit[1]);
                            zzff.zzf("TtmlParser", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
                        }
                        if (!matcher.matches()) {
                            throw new zzakn("Invalid expression for fontSize: '" + attributeValue + "'.");
                        }
                        String strGroup = matcher.group(3);
                        strGroup.getClass();
                        int iHashCode = strGroup.hashCode();
                        if (iHashCode != 37) {
                            if (iHashCode != 3240) {
                                if (iHashCode == 3592 && strGroup.equals("px")) {
                                    b2 = 0;
                                }
                            } else if (strGroup.equals("em")) {
                                b2 = 1;
                            }
                        } else if (strGroup.equals("%")) {
                            b2 = 2;
                        }
                        if (b2 == 0) {
                            zzaluVar.zzr(1);
                        } else if (b2 == 1) {
                            zzaluVar.zzr(2);
                        } else {
                            if (b2 != 2) {
                                throw new zzakn("Invalid unit for fontSize: '" + strGroup + "'.");
                            }
                            zzaluVar.zzr(3);
                        }
                        String strGroup2 = matcher.group(1);
                        strGroup2.getClass();
                        zzaluVar.zzq(Float.parseFloat(strGroup2));
                    } catch (zzakn unused3) {
                        zzff.zzf("TtmlParser", "Failed parsing fontSize value: ".concat(String.valueOf(attributeValue)));
                    }
                    break;
                case 5:
                    zzaluVar = zze(zzaluVar);
                    zzaluVar.zzn("bold".equalsIgnoreCase(attributeValue));
                    break;
                case 6:
                    zzaluVar = zze(zzaluVar);
                    zzaluVar.zzt("italic".equalsIgnoreCase(attributeValue));
                    break;
                case 7:
                    zzaluVar = zze(zzaluVar);
                    zzaluVar.zzz(zzd(attributeValue));
                    break;
                case 8:
                    zzaluVar = zze(zzaluVar);
                    zzaluVar.zzv(zzd(attributeValue));
                    break;
                case 9:
                    String strZza = zzfwk.zza(attributeValue);
                    int iHashCode2 = strZza.hashCode();
                    if (iHashCode2 != 96673) {
                        if (iHashCode2 == 3387192 && strZza.equals("none")) {
                            b2 = 0;
                        }
                    } else if (strZza.equals("all")) {
                        b2 = 1;
                    }
                    if (b2 == 0) {
                        zzaluVar = zze(zzaluVar);
                        zzaluVar.zzA(false);
                    } else if (b2 == 1) {
                        zzaluVar = zze(zzaluVar);
                        zzaluVar.zzA(true);
                    }
                    break;
                case 10:
                    String strZza2 = zzfwk.zza(attributeValue);
                    switch (strZza2.hashCode()) {
                        case -618561360:
                            if (strZza2.equals("baseContainer")) {
                                b2 = 2;
                            }
                            break;
                        case -410956671:
                            if (strZza2.equals("container")) {
                                b2 = 0;
                            }
                            break;
                        case -250518009:
                            if (strZza2.equals("delimiter")) {
                                b2 = 5;
                            }
                            break;
                        case -136074796:
                            if (strZza2.equals("textContainer")) {
                                b2 = 4;
                            }
                            break;
                        case 3016401:
                            if (strZza2.equals("base")) {
                                b2 = 1;
                            }
                            break;
                        case 3556653:
                            if (strZza2.equals("text")) {
                                b2 = 3;
                            }
                            break;
                    }
                    if (b2 == 0) {
                        zzaluVar = zze(zzaluVar);
                        zzaluVar.zzx(1);
                    } else if (b2 == 1 || b2 == 2) {
                        zzaluVar = zze(zzaluVar);
                        zzaluVar.zzx(2);
                    } else if (b2 == 3 || b2 == 4) {
                        zzaluVar = zze(zzaluVar);
                        zzaluVar.zzx(3);
                    } else if (b2 == 5) {
                        zzaluVar = zze(zzaluVar);
                        zzaluVar.zzx(4);
                    }
                    break;
                case 11:
                    String strZza3 = zzfwk.zza(attributeValue);
                    int iHashCode3 = strZza3.hashCode();
                    if (iHashCode3 != -1392885889) {
                        if (iHashCode3 == 92734940 && strZza3.equals("after")) {
                            b2 = 1;
                        }
                    } else if (strZza3.equals("before")) {
                        b2 = 0;
                    }
                    if (b2 == 0) {
                        zzaluVar = zze(zzaluVar);
                        zzaluVar.zzw(1);
                    } else if (b2 == 1) {
                        zzaluVar = zze(zzaluVar);
                        zzaluVar.zzw(2);
                    }
                    break;
                case 12:
                    String strZza4 = zzfwk.zza(attributeValue);
                    switch (strZza4.hashCode()) {
                        case -1461280213:
                            if (strZza4.equals("nounderline")) {
                                b2 = 3;
                            }
                            break;
                        case -1026963764:
                            if (strZza4.equals("underline")) {
                                b2 = 2;
                            }
                            break;
                        case 913457136:
                            if (strZza4.equals("nolinethrough")) {
                                b2 = 1;
                            }
                            break;
                        case 1679736913:
                            if (strZza4.equals("linethrough")) {
                                b2 = 0;
                            }
                            break;
                    }
                    if (b2 == 0) {
                        zzaluVar = zze(zzaluVar);
                        zzaluVar.zzu(true);
                    } else if (b2 == 1) {
                        zzaluVar = zze(zzaluVar);
                        zzaluVar.zzu(false);
                    } else if (b2 == 2) {
                        zzaluVar = zze(zzaluVar);
                        zzaluVar.zzC(true);
                    } else if (b2 == 3) {
                        zzaluVar = zze(zzaluVar);
                        zzaluVar.zzC(false);
                    }
                    break;
                case 13:
                    zzaluVar = zze(zzaluVar);
                    zzaluVar.zzB(zzaln.zza(attributeValue));
                    break;
                case 14:
                    zzaluVar = zze(zzaluVar);
                    Matcher matcher2 = zza.matcher(attributeValue);
                    float fMin = Float.MAX_VALUE;
                    if (matcher2.matches()) {
                        try {
                            String strGroup3 = matcher2.group(1);
                            strGroup3.getClass();
                            fMin = Math.min(100.0f, Math.max(-100.0f, Float.parseFloat(strGroup3)));
                        } catch (NumberFormatException e) {
                            zzff.zzg("TtmlParser", "Failed to parse shear: ".concat(String.valueOf(attributeValue)), e);
                        }
                    } else {
                        zzff.zzf("TtmlParser", "Invalid value for shear: ".concat(String.valueOf(attributeValue)));
                    }
                    zzaluVar.zzy(fMin);
                    break;
            }
        }
        return zzaluVar;
    }

    private static String[] zzg(String str) {
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return new String[0];
        }
        int i = zzfy.zza;
        return strTrim.split("\\s+", -1);
    }

    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zza(byte[] bArr, int i, int i2, zzakq zzakqVar, zzep zzepVar) {
        zzakl.zza(zzb(bArr, i, i2), zzakqVar, zzepVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:111:0x0269 A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x026f A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, LOOP:1: B:113:0x026f->B:254:0x04e9, LOOP_START, PHI: r2 r5 r11
  0x026f: PHI (r2v42 java.lang.String) = (r2v16 java.lang.String), (r2v80 java.lang.String) binds: [B:112:0x026d, B:254:0x04e9] A[DONT_GENERATE, DONT_INLINE]
  0x026f: PHI (r5v7 java.util.HashMap) = (r5v1 java.util.HashMap), (r5v24 java.util.HashMap) binds: [B:112:0x026d, B:254:0x04e9] A[DONT_GENERATE, DONT_INLINE]
  0x026f: PHI (r11v11 com.google.android.gms.internal.ads.zzalp) = (r11v5 com.google.android.gms.internal.ads.zzalp), (r11v28 com.google.android.gms.internal.ads.zzalp) binds: [B:112:0x026d, B:254:0x04e9] A[DONT_GENERATE, DONT_INLINE], TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x0278 A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x0287 A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x0291 A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, LOOP:2: B:118:0x028f->B:119:0x0291, LOOP_END, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:120:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:123:0x02ab A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x02af A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TRY_LEAVE, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x02b9 A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TRY_ENTER, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:129:0x02bf A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, LOOP:3: B:129:0x02bf->B:432:?, LOOP_START, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x02ca A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:137:0x02e3 A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:141:0x02f0 A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x02f8 A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TRY_LEAVE, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x030e  */
    /* JADX WARN: Code duplicated, block: B:154:0x0339 A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x0341 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:157:0x0343 A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TRY_LEAVE, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:159:0x034d  */
    /* JADX WARN: Code duplicated, block: B:168:0x037a A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TRY_LEAVE, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:170:0x0388  */
    /* JADX WARN: Code duplicated, block: B:178:0x03b4 A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:180:0x03ba A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:181:0x03bc A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TRY_LEAVE, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:183:0x03c7  */
    /* JADX WARN: Code duplicated, block: B:192:0x03f5 A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TRY_LEAVE, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:195:0x0402  */
    /* JADX WARN: Code duplicated, block: B:198:0x0408  */
    /* JADX WARN: Code duplicated, block: B:201:0x0412  */
    /* JADX WARN: Code duplicated, block: B:203:0x041a  */
    /* JADX WARN: Code duplicated, block: B:204:0x041c  */
    /* JADX WARN: Code duplicated, block: B:206:0x041f  */
    /* JADX WARN: Code duplicated, block: B:209:0x0423  */
    /* JADX WARN: Code duplicated, block: B:210:0x042a  */
    /* JADX WARN: Code duplicated, block: B:211:0x0434  */
    /* JADX WARN: Code duplicated, block: B:215:0x0443 A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TRY_LEAVE, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:218:0x044f  */
    /* JADX WARN: Code duplicated, block: B:220:0x0454  */
    /* JADX WARN: Code duplicated, block: B:223:0x045a  */
    /* JADX WARN: Code duplicated, block: B:226:0x0464  */
    /* JADX WARN: Code duplicated, block: B:228:0x046c  */
    /* JADX WARN: Code duplicated, block: B:229:0x046e  */
    /* JADX WARN: Code duplicated, block: B:231:0x0476  */
    /* JADX WARN: Code duplicated, block: B:232:0x0478  */
    /* JADX WARN: Code duplicated, block: B:234:0x047b  */
    /* JADX WARN: Code duplicated, block: B:240:0x0485  */
    /* JADX WARN: Code duplicated, block: B:241:0x0488  */
    /* JADX WARN: Code duplicated, block: B:244:0x04a3 A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:245:0x04ae A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:247:0x04c0 A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:248:0x04cb A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:250:0x04d8 A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:254:0x04e9 A[LOOP:1: B:113:0x026f->B:254:0x04e9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:255:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:263:0x0523  */
    /* JADX WARN: Code duplicated, block: B:265:0x052b  */
    /* JADX WARN: Code duplicated, block: B:266:0x052d  */
    /* JADX WARN: Code duplicated, block: B:268:0x0533  */
    /* JADX WARN: Code duplicated, block: B:269:0x0535  */
    /* JADX WARN: Code duplicated, block: B:271:0x053d  */
    /* JADX WARN: Code duplicated, block: B:272:0x053f  */
    /* JADX WARN: Code duplicated, block: B:274:0x0547  */
    /* JADX WARN: Code duplicated, block: B:275:0x0549  */
    /* JADX WARN: Code duplicated, block: B:277:0x0551  */
    /* JADX WARN: Code duplicated, block: B:278:0x0553  */
    /* JADX WARN: Code duplicated, block: B:280:0x0559  */
    /* JADX WARN: Code duplicated, block: B:281:0x055b  */
    /* JADX WARN: Code duplicated, block: B:283:0x055e  */
    /* JADX WARN: Code duplicated, block: B:285:0x0561  */
    /* JADX WARN: Code duplicated, block: B:287:0x0564  */
    /* JADX WARN: Code duplicated, block: B:289:0x0567  */
    /* JADX WARN: Code duplicated, block: B:291:0x056a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:292:0x056c  */
    /* JADX WARN: Code duplicated, block: B:295:0x0576  */
    /* JADX WARN: Code duplicated, block: B:299:0x057f A[Catch: zzakn -> 0x0596, IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TryCatch #1 {zzakn -> 0x0596, blocks: (B:296:0x0577, B:299:0x057f, B:302:0x0589), top: B:396:0x0577 }] */
    /* JADX WARN: Code duplicated, block: B:301:0x0586  */
    /* JADX WARN: Code duplicated, block: B:302:0x0589 A[Catch: zzakn -> 0x0596, IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TRY_LEAVE, TryCatch #1 {zzakn -> 0x0596, blocks: (B:296:0x0577, B:299:0x057f, B:302:0x0589), top: B:396:0x0577 }] */
    /* JADX WARN: Code duplicated, block: B:304:0x0591  */
    /* JADX WARN: Code duplicated, block: B:308:0x059b  */
    /* JADX WARN: Code duplicated, block: B:310:0x05a3 A[Catch: zzakn -> 0x05e3, IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TryCatch #9 {zzakn -> 0x05e3, blocks: (B:312:0x05b2, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:339:0x05f5), top: B:412:0x05b2 }] */
    /* JADX WARN: Code duplicated, block: B:311:0x05ab A[Catch: zzakn -> 0x05e3, IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TryCatch #9 {zzakn -> 0x05e3, blocks: (B:312:0x05b2, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:339:0x05f5), top: B:412:0x05b2 }] */
    /* JADX WARN: Code duplicated, block: B:319:0x05c7 A[Catch: zzakn -> 0x05e3, IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TryCatch #9 {zzakn -> 0x05e3, blocks: (B:312:0x05b2, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:339:0x05f5), top: B:412:0x05b2 }] */
    /* JADX WARN: Code duplicated, block: B:321:0x05cd  */
    /* JADX WARN: Code duplicated, block: B:323:0x05d1 A[Catch: zzakn -> 0x05e3, IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TryCatch #9 {zzakn -> 0x05e3, blocks: (B:312:0x05b2, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:339:0x05f5), top: B:412:0x05b2 }] */
    /* JADX WARN: Code duplicated, block: B:324:0x05d4  */
    /* JADX WARN: Code duplicated, block: B:327:0x05da A[Catch: zzakn -> 0x05e3, IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TryCatch #9 {zzakn -> 0x05e3, blocks: (B:312:0x05b2, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:339:0x05f5), top: B:412:0x05b2 }] */
    /* JADX WARN: Code duplicated, block: B:328:0x05dd  */
    /* JADX WARN: Code duplicated, block: B:329:0x05e1 A[PHI: r29 r36
  0x05e1: PHI (r29v3 long) = (r29v1 long), (r29v5 long) binds: [B:320:0x05cb, B:327:0x05da] A[DONT_GENERATE, DONT_INLINE]
  0x05e1: PHI (r36v4 long) = (r36v1 long), (r36v6 long) binds: [B:320:0x05cb, B:327:0x05da] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:332:0x05e5  */
    /* JADX WARN: Code duplicated, block: B:335:0x05ea  */
    /* JADX WARN: Code duplicated, block: B:337:0x05ee A[Catch: zzakn -> 0x05e3, IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TryCatch #9 {zzakn -> 0x05e3, blocks: (B:312:0x05b2, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:339:0x05f5), top: B:412:0x05b2 }] */
    /* JADX WARN: Code duplicated, block: B:338:0x05f3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:339:0x05f5 A[Catch: zzakn -> 0x05e3, IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TRY_LEAVE, TryCatch #9 {zzakn -> 0x05e3, blocks: (B:312:0x05b2, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:339:0x05f5), top: B:412:0x05b2 }] */
    /* JADX WARN: Code duplicated, block: B:342:0x05fb  */
    /* JADX WARN: Code duplicated, block: B:343:0x05fe  */
    /* JADX WARN: Code duplicated, block: B:344:0x0601  */
    /* JADX WARN: Code duplicated, block: B:349:0x0616 A[Catch: zzakn -> 0x0623, IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TRY_LEAVE, TryCatch #8 {zzakn -> 0x0623, blocks: (B:347:0x0611, B:349:0x0616), top: B:410:0x0611 }] */
    /* JADX WARN: Code duplicated, block: B:398:0x0512 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:402:0x056e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:429:0x04e3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x017f  */
    /* JADX WARN: Code duplicated, block: B:64:0x0181 A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x018d A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TRY_LEAVE, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0197  */
    /* JADX WARN: Code duplicated, block: B:81:0x01dc A[Catch: IOException -> 0x06b9, XmlPullParserException -> 0x06c3, TRY_ENTER, TryCatch #17 {IOException -> 0x06b9, XmlPullParserException -> 0x06c3, blocks: (B:3:0x0006, B:6:0x0060, B:8:0x006b, B:11:0x0075, B:14:0x007f, B:16:0x0087, B:18:0x008e, B:21:0x0098, B:25:0x00aa, B:27:0x00c9, B:29:0x00d7, B:31:0x00de, B:33:0x00ea, B:35:0x00f5, B:61:0x0177, B:78:0x01ce, B:81:0x01dc, B:83:0x01e2, B:85:0x01ea, B:87:0x01f2, B:89:0x01fa, B:91:0x0202, B:93:0x020a, B:95:0x0210, B:97:0x0218, B:99:0x0220, B:101:0x0226, B:103:0x022c, B:105:0x0234, B:107:0x023c, B:110:0x0245, B:384:0x06a1, B:111:0x0269, B:113:0x026f, B:115:0x0278, B:117:0x0287, B:119:0x0291, B:121:0x02a5, B:123:0x02ab, B:251:0x04dd, B:124:0x02af, B:127:0x02b9, B:129:0x02bf, B:131:0x02ca, B:133:0x02d0, B:134:0x02d7, B:137:0x02e3, B:250:0x04d8, B:141:0x02f0, B:143:0x02f8, B:147:0x0311, B:149:0x0318, B:151:0x0326, B:166:0x0372, B:168:0x037a, B:171:0x0389, B:173:0x0390, B:175:0x039e, B:190:0x03ed, B:192:0x03f5, B:213:0x043b, B:215:0x0443, B:242:0x048c, B:177:0x03a9, B:178:0x03b4, B:181:0x03bc, B:184:0x03c8, B:186:0x03cf, B:188:0x03db, B:243:0x0498, B:244:0x04a3, B:245:0x04ae, B:153:0x032f, B:154:0x0339, B:157:0x0343, B:160:0x034e, B:162:0x0355, B:164:0x0361, B:246:0x04b5, B:247:0x04c0, B:248:0x04cb, B:256:0x04f5, B:259:0x0512, B:312:0x05b2, B:293:0x056e, B:296:0x0577, B:358:0x0630, B:299:0x057f, B:302:0x0589, B:309:0x059e, B:310:0x05a3, B:311:0x05ab, B:319:0x05c7, B:323:0x05d1, B:327:0x05da, B:337:0x05ee, B:345:0x0603, B:347:0x0611, B:349:0x0616, B:339:0x05f5, B:64:0x0181, B:66:0x018d, B:69:0x0198, B:71:0x019f, B:73:0x01ab, B:75:0x01b5, B:39:0x010c, B:41:0x0118, B:44:0x0123, B:46:0x012a, B:48:0x0136, B:54:0x014c, B:56:0x0153, B:60:0x016d, B:364:0x0650, B:367:0x065f, B:369:0x0669, B:371:0x0676, B:373:0x067e, B:377:0x0692, B:381:0x069a), top: B:426:0x0006, inners: #3, #5, #6, #10, #14 }] */
    public final zzakm zzb(byte[] bArr, int i, int i2) {
        String str;
        HashMap map;
        ArrayDeque arrayDeque;
        zzalv zzalvVar;
        int i3;
        String str2;
        HashMap map2;
        zzalp zzalpVar;
        zzalp zzalpVar2;
        int i4;
        zzakn zzaknVar;
        int attributeCount;
        String[] strArr;
        String strSubstring;
        String str3;
        long jZzc;
        long jZzc2;
        long jZzc3;
        int i5;
        zzalo zzaloVar;
        long j;
        zzalo zzaloVarZzb;
        long j2;
        long j3;
        String attributeName;
        String attributeValue;
        byte b;
        String[] strArrZzg;
        String strZza;
        String strZza2;
        String str4;
        Pattern pattern;
        Matcher matcher;
        Pattern pattern2;
        Matcher matcher2;
        float f;
        float f2;
        String strZza3;
        Matcher matcher3;
        Matcher matcher4;
        float f3;
        float f4;
        String strZza4;
        float f5;
        int i6;
        String strZza5;
        int i7;
        zzals zzalsVar;
        String strZza6;
        int iHashCode;
        byte b2;
        String strZza7;
        int iHashCode2;
        byte b3;
        String strZza8;
        String strZza9;
        zzalu zzaluVarZzf;
        String strZzE;
        String[] strArrZzg2;
        int length;
        int i8;
        float f6;
        zzalp zzalpVar3;
        boolean z;
        String strZza10;
        Matcher matcher5;
        String str5 = "";
        String str6 = "http://www.w3.org/ns/ttml#parameter";
        try {
            XmlPullParser xmlPullParserNewPullParser = this.zzi.newPullParser();
            HashMap map3 = new HashMap();
            HashMap map4 = new HashMap();
            HashMap map5 = new HashMap();
            map4.put("", new zzals("", -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE));
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, i, i2), null);
            ArrayDeque arrayDeque2 = new ArrayDeque();
            int eventType = xmlPullParserNewPullParser.getEventType();
            zzalp zzalpVar4 = zzh;
            zzalv zzalvVar2 = null;
            zzalq zzalqVar = null;
            int i9 = 0;
            int i10 = 15;
            while (eventType != 1) {
                zzalo zzaloVar2 = (zzalo) arrayDeque2.peek();
                if (i9 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    str = str5;
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            String attributeValue2 = xmlPullParserNewPullParser.getAttributeValue(str6, "frameRate");
                            int i11 = attributeValue2 != null ? Integer.parseInt(attributeValue2) : 30;
                            String attributeValue3 = xmlPullParserNewPullParser.getAttributeValue(str6, "frameRateMultiplier");
                            if (attributeValue3 != null) {
                                int i12 = zzfy.zza;
                                String[] strArrSplit = attributeValue3.split(" ", -1);
                                zzek.zze(strArrSplit.length == 2, "frameRateMultiplier doesn't have 2 parts");
                                f6 = Integer.parseInt(strArrSplit[0]) / Integer.parseInt(strArrSplit[1]);
                            } else {
                                f6 = 1.0f;
                            }
                            zzalp zzalpVar5 = zzh;
                            int i13 = zzalpVar5.zzb;
                            String attributeValue4 = xmlPullParserNewPullParser.getAttributeValue(str6, "subFrameRate");
                            int i14 = attributeValue4 != null ? Integer.parseInt(attributeValue4) : i13;
                            int i15 = zzalpVar5.zzc;
                            String attributeValue5 = xmlPullParserNewPullParser.getAttributeValue(str6, "tickRate");
                            zzalp zzalpVar6 = new zzalp(i11 * f6, i14, attributeValue5 != null ? Integer.parseInt(attributeValue5) : i15);
                            String attributeValue6 = xmlPullParserNewPullParser.getAttributeValue(str6, "cellResolution");
                            if (attributeValue6 == null) {
                                str6 = str6;
                                zzalpVar3 = zzalpVar6;
                                i10 = 15;
                            } else {
                                Matcher matcher6 = zzg.matcher(attributeValue6);
                                if (matcher6.matches()) {
                                    try {
                                        String strGroup = matcher6.group(1);
                                        strGroup.getClass();
                                        int i16 = Integer.parseInt(strGroup);
                                        String strGroup2 = matcher6.group(2);
                                        strGroup2.getClass();
                                        int i17 = Integer.parseInt(strGroup2);
                                        if (i16 == 0) {
                                            i10 = i17;
                                            z = false;
                                        } else if (i17 != 0) {
                                            i10 = i17;
                                            z = true;
                                        } else {
                                            z = false;
                                            i10 = 0;
                                        }
                                        try {
                                            StringBuilder sb = new StringBuilder();
                                            zzalpVar3 = zzalpVar6;
                                            try {
                                                sb.append("Invalid cell resolution ");
                                                sb.append(i16);
                                                sb.append(" ");
                                                sb.append(i10);
                                                zzek.zze(z, sb.toString());
                                            } catch (NumberFormatException unused) {
                                                zzff.zzf("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue6));
                                                i10 = 15;
                                            }
                                        } catch (NumberFormatException unused2) {
                                            zzalpVar3 = zzalpVar6;
                                            zzff.zzf("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue6));
                                            i10 = 15;
                                            strZza10 = zzfz.zza(xmlPullParserNewPullParser, "extent");
                                            if (strZza10 == null) {
                                                zzalqVar = null;
                                                zzalpVar4 = zzalpVar3;
                                                str2 = "metadata";
                                                if (name.equals("tt")) {
                                                    if ("head".equals(name)) {
                                                        while (true) {
                                                            xmlPullParserNewPullParser.next();
                                                            if (zzfz.zzc(xmlPullParserNewPullParser, "style")) {
                                                                strZza9 = zzfz.zza(xmlPullParserNewPullParser, "style");
                                                                zzaluVarZzf = zzf(xmlPullParserNewPullParser, new zzalu());
                                                                if (strZza9 != null) {
                                                                    strArrZzg2 = zzg(strZza9);
                                                                    i8 = 0;
                                                                    for (length = strArrZzg2.length; i8 < length; length = length) {
                                                                        zzaluVarZzf.zzl((zzalu) map3.get(strArrZzg2[i8]));
                                                                        i8++;
                                                                    }
                                                                }
                                                                strZzE = zzaluVarZzf.zzE();
                                                                if (strZzE != null) {
                                                                    map3.put(strZzE, zzaluVarZzf);
                                                                }
                                                            } else {
                                                                zzalpVar4 = zzalpVar4;
                                                                if (zzfz.zzc(xmlPullParserNewPullParser, "region")) {
                                                                    strZza = zzfz.zza(xmlPullParserNewPullParser, "id");
                                                                    if (strZza == null) {
                                                                        str4 = str2;
                                                                        map2 = map3;
                                                                    } else {
                                                                        strZza2 = zzfz.zza(xmlPullParserNewPullParser, "origin");
                                                                        if (strZza2 != null) {
                                                                            pattern = zzb;
                                                                            matcher = pattern.matcher(strZza2);
                                                                            pattern2 = zzf;
                                                                            str4 = str2;
                                                                            matcher2 = pattern2.matcher(strZza2);
                                                                            if (matcher.matches()) {
                                                                                map2 = map3;
                                                                                String strGroup3 = matcher.group(1);
                                                                                strGroup3.getClass();
                                                                                float f7 = Float.parseFloat(strGroup3) / 100.0f;
                                                                                String strGroup4 = matcher.group(2);
                                                                                strGroup4.getClass();
                                                                                f2 = Float.parseFloat(strGroup4) / 100.0f;
                                                                                f = f7;
                                                                                strZza3 = zzfz.zza(xmlPullParserNewPullParser, "extent");
                                                                                if (strZza3 != null) {
                                                                                    matcher3 = pattern.matcher(strZza3);
                                                                                    matcher4 = pattern2.matcher(strZza3);
                                                                                    if (matcher3.matches()) {
                                                                                        String strGroup5 = matcher3.group(1);
                                                                                        strGroup5.getClass();
                                                                                        float f8 = Float.parseFloat(strGroup5) / 100.0f;
                                                                                        String strGroup6 = matcher3.group(2);
                                                                                        strGroup6.getClass();
                                                                                        f3 = Float.parseFloat(strGroup6) / 100.0f;
                                                                                        f4 = f8;
                                                                                        strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                                        if (strZza4 != null) {
                                                                                            strZza7 = zzfwk.zza(strZza4);
                                                                                            iHashCode2 = strZza7.hashCode();
                                                                                            if (iHashCode2 != -1364013995) {
                                                                                                if (iHashCode2 != 92734940) {
                                                                                                    b3 = -1;
                                                                                                } else {
                                                                                                    b3 = 1;
                                                                                                }
                                                                                            } else if (strZza7.equals("center")) {
                                                                                                b3 = 0;
                                                                                            } else {
                                                                                                b3 = -1;
                                                                                            }
                                                                                            if (b3 != 0) {
                                                                                                f5 = f2 + (f3 / 2.0f);
                                                                                                i6 = 1;
                                                                                            } else if (b3 != 1) {
                                                                                                f5 = f2;
                                                                                                i6 = 0;
                                                                                            } else {
                                                                                                f5 = f2 + f3;
                                                                                                i6 = 2;
                                                                                            }
                                                                                        } else {
                                                                                            f5 = f2;
                                                                                            i6 = 0;
                                                                                        }
                                                                                        float f9 = 1.0f / i10;
                                                                                        strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                        if (strZza5 != null) {
                                                                                            strZza6 = zzfwk.zza(strZza5);
                                                                                            iHashCode = strZza6.hashCode();
                                                                                            if (iHashCode != 3694) {
                                                                                                if (iHashCode != 3553396) {
                                                                                                    if (iHashCode != 3553576) {
                                                                                                        b2 = -1;
                                                                                                    } else {
                                                                                                        b2 = 2;
                                                                                                    }
                                                                                                } else if (strZza6.equals("tblr")) {
                                                                                                    b2 = 1;
                                                                                                } else {
                                                                                                    b2 = -1;
                                                                                                }
                                                                                            } else if (strZza6.equals("tb")) {
                                                                                                b2 = 0;
                                                                                            } else {
                                                                                                b2 = -1;
                                                                                            }
                                                                                            if (b2 != 0) {
                                                                                                i7 = 2;
                                                                                            } else {
                                                                                                i7 = 2;
                                                                                            }
                                                                                        } else {
                                                                                            i7 = Integer.MIN_VALUE;
                                                                                        }
                                                                                        zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f9, i7);
                                                                                    } else if (matcher4.matches()) {
                                                                                        zzff.zzf("TtmlParser", "Ignoring region with unsupported extent: ".concat(strZza2));
                                                                                    } else if (zzalqVar == null) {
                                                                                        zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                                                    } else {
                                                                                        String strGroup7 = matcher4.group(1);
                                                                                        strGroup7.getClass();
                                                                                        int i18 = Integer.parseInt(strGroup7);
                                                                                        String strGroup8 = matcher4.group(2);
                                                                                        strGroup8.getClass();
                                                                                        int i19 = Integer.parseInt(strGroup8);
                                                                                        float f10 = i18 / zzalqVar.zza;
                                                                                        f3 = i19 / zzalqVar.zzb;
                                                                                        f4 = f10;
                                                                                        strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                                        if (strZza4 != null) {
                                                                                            strZza7 = zzfwk.zza(strZza4);
                                                                                            iHashCode2 = strZza7.hashCode();
                                                                                            if (iHashCode2 != -1364013995) {
                                                                                                if (iHashCode2 != 92734940) {
                                                                                                    b3 = -1;
                                                                                                } else {
                                                                                                    b3 = 1;
                                                                                                }
                                                                                            } else if (strZza7.equals("center")) {
                                                                                                b3 = 0;
                                                                                            } else {
                                                                                                b3 = -1;
                                                                                            }
                                                                                            if (b3 != 0) {
                                                                                                f5 = f2 + (f3 / 2.0f);
                                                                                                i6 = 1;
                                                                                            } else if (b3 != 1) {
                                                                                                f5 = f2;
                                                                                                i6 = 0;
                                                                                            } else {
                                                                                                f5 = f2 + f3;
                                                                                                i6 = 2;
                                                                                            }
                                                                                        } else {
                                                                                            f5 = f2;
                                                                                            i6 = 0;
                                                                                        }
                                                                                        float f11 = 1.0f / i10;
                                                                                        strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                        if (strZza5 != null) {
                                                                                            strZza6 = zzfwk.zza(strZza5);
                                                                                            iHashCode = strZza6.hashCode();
                                                                                            if (iHashCode != 3694) {
                                                                                                if (iHashCode != 3553396) {
                                                                                                    if (iHashCode != 3553576) {
                                                                                                        b2 = -1;
                                                                                                    } else {
                                                                                                        b2 = 2;
                                                                                                    }
                                                                                                } else if (strZza6.equals("tblr")) {
                                                                                                    b2 = 1;
                                                                                                } else {
                                                                                                    b2 = -1;
                                                                                                }
                                                                                            } else if (strZza6.equals("tb")) {
                                                                                                b2 = 0;
                                                                                            } else {
                                                                                                b2 = -1;
                                                                                            }
                                                                                            if (b2 != 0) {
                                                                                                i7 = 2;
                                                                                            } else {
                                                                                                i7 = 2;
                                                                                            }
                                                                                        } else {
                                                                                            i7 = Integer.MIN_VALUE;
                                                                                        }
                                                                                        zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f11, i7);
                                                                                    }
                                                                                    if (zzalsVar != null) {
                                                                                        map4.put(zzalsVar.zza, zzalsVar);
                                                                                    }
                                                                                } else {
                                                                                    zzff.zzf("TtmlParser", "Ignoring region without an extent");
                                                                                }
                                                                            } else {
                                                                                map2 = map3;
                                                                                if (!matcher2.matches()) {
                                                                                    zzff.zzf("TtmlParser", "Ignoring region with unsupported origin: ".concat(strZza2));
                                                                                } else if (zzalqVar == null) {
                                                                                    zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                                                } else {
                                                                                    String strGroup9 = matcher2.group(1);
                                                                                    strGroup9.getClass();
                                                                                    int i20 = Integer.parseInt(strGroup9);
                                                                                    String strGroup10 = matcher2.group(2);
                                                                                    strGroup10.getClass();
                                                                                    float f12 = Integer.parseInt(strGroup10);
                                                                                    f = i20 / zzalqVar.zza;
                                                                                    f2 = f12 / zzalqVar.zzb;
                                                                                    strZza3 = zzfz.zza(xmlPullParserNewPullParser, "extent");
                                                                                    if (strZza3 != null) {
                                                                                        matcher3 = pattern.matcher(strZza3);
                                                                                        matcher4 = pattern2.matcher(strZza3);
                                                                                        if (matcher3.matches()) {
                                                                                            String strGroup11 = matcher3.group(1);
                                                                                            strGroup11.getClass();
                                                                                            float f13 = Float.parseFloat(strGroup11) / 100.0f;
                                                                                            String strGroup12 = matcher3.group(2);
                                                                                            strGroup12.getClass();
                                                                                            f3 = Float.parseFloat(strGroup12) / 100.0f;
                                                                                            f4 = f13;
                                                                                            strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                                            if (strZza4 != null) {
                                                                                                strZza7 = zzfwk.zza(strZza4);
                                                                                                iHashCode2 = strZza7.hashCode();
                                                                                                if (iHashCode2 != -1364013995) {
                                                                                                    if (iHashCode2 != 92734940) {
                                                                                                        b3 = -1;
                                                                                                    } else {
                                                                                                        b3 = 1;
                                                                                                    }
                                                                                                } else if (strZza7.equals("center")) {
                                                                                                    b3 = 0;
                                                                                                } else {
                                                                                                    b3 = -1;
                                                                                                }
                                                                                                if (b3 != 0) {
                                                                                                    f5 = f2 + (f3 / 2.0f);
                                                                                                    i6 = 1;
                                                                                                } else if (b3 != 1) {
                                                                                                    f5 = f2;
                                                                                                    i6 = 0;
                                                                                                } else {
                                                                                                    f5 = f2 + f3;
                                                                                                    i6 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                f5 = f2;
                                                                                                i6 = 0;
                                                                                            }
                                                                                            float f14 = 1.0f / i10;
                                                                                            strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                            if (strZza5 != null) {
                                                                                                strZza6 = zzfwk.zza(strZza5);
                                                                                                iHashCode = strZza6.hashCode();
                                                                                                if (iHashCode != 3694) {
                                                                                                    if (iHashCode != 3553396) {
                                                                                                        if (iHashCode != 3553576) {
                                                                                                            b2 = -1;
                                                                                                        } else {
                                                                                                            b2 = 2;
                                                                                                        }
                                                                                                    } else if (strZza6.equals("tblr")) {
                                                                                                        b2 = 1;
                                                                                                    } else {
                                                                                                        b2 = -1;
                                                                                                    }
                                                                                                } else if (strZza6.equals("tb")) {
                                                                                                    b2 = 0;
                                                                                                } else {
                                                                                                    b2 = -1;
                                                                                                }
                                                                                                if (b2 != 0) {
                                                                                                    i7 = 2;
                                                                                                } else {
                                                                                                    i7 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                i7 = Integer.MIN_VALUE;
                                                                                            }
                                                                                            zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f14, i7);
                                                                                        } else if (matcher4.matches()) {
                                                                                            zzff.zzf("TtmlParser", "Ignoring region with unsupported extent: ".concat(strZza2));
                                                                                        } else if (zzalqVar == null) {
                                                                                            zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                                                        } else {
                                                                                            String strGroup13 = matcher4.group(1);
                                                                                            strGroup13.getClass();
                                                                                            int i110 = Integer.parseInt(strGroup13);
                                                                                            String strGroup14 = matcher4.group(2);
                                                                                            strGroup14.getClass();
                                                                                            int i111 = Integer.parseInt(strGroup14);
                                                                                            float f15 = i110 / zzalqVar.zza;
                                                                                            f3 = i111 / zzalqVar.zzb;
                                                                                            f4 = f15;
                                                                                            strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                                            if (strZza4 != null) {
                                                                                                strZza7 = zzfwk.zza(strZza4);
                                                                                                iHashCode2 = strZza7.hashCode();
                                                                                                if (iHashCode2 != -1364013995) {
                                                                                                    if (iHashCode2 != 92734940) {
                                                                                                        b3 = -1;
                                                                                                    } else {
                                                                                                        b3 = 1;
                                                                                                    }
                                                                                                } else if (strZza7.equals("center")) {
                                                                                                    b3 = 0;
                                                                                                } else {
                                                                                                    b3 = -1;
                                                                                                }
                                                                                                if (b3 != 0) {
                                                                                                    f5 = f2 + (f3 / 2.0f);
                                                                                                    i6 = 1;
                                                                                                } else if (b3 != 1) {
                                                                                                    f5 = f2;
                                                                                                    i6 = 0;
                                                                                                } else {
                                                                                                    f5 = f2 + f3;
                                                                                                    i6 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                f5 = f2;
                                                                                                i6 = 0;
                                                                                            }
                                                                                            float f16 = 1.0f / i10;
                                                                                            strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                            if (strZza5 != null) {
                                                                                                strZza6 = zzfwk.zza(strZza5);
                                                                                                iHashCode = strZza6.hashCode();
                                                                                                if (iHashCode != 3694) {
                                                                                                    if (iHashCode != 3553396) {
                                                                                                        if (iHashCode != 3553576) {
                                                                                                            b2 = -1;
                                                                                                        } else {
                                                                                                            b2 = 2;
                                                                                                        }
                                                                                                    } else if (strZza6.equals("tblr")) {
                                                                                                        b2 = 1;
                                                                                                    } else {
                                                                                                        b2 = -1;
                                                                                                    }
                                                                                                } else if (strZza6.equals("tb")) {
                                                                                                    b2 = 0;
                                                                                                } else {
                                                                                                    b2 = -1;
                                                                                                }
                                                                                                if (b2 != 0) {
                                                                                                    i7 = 2;
                                                                                                } else {
                                                                                                    i7 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                i7 = Integer.MIN_VALUE;
                                                                                            }
                                                                                            zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f16, i7);
                                                                                        }
                                                                                        if (zzalsVar != null) {
                                                                                            map4.put(zzalsVar.zza, zzalsVar);
                                                                                        }
                                                                                    } else {
                                                                                        zzff.zzf("TtmlParser", "Ignoring region without an extent");
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else {
                                                                            str4 = str2;
                                                                            map2 = map3;
                                                                            zzff.zzf("TtmlParser", "Ignoring region without an origin");
                                                                        }
                                                                    }
                                                                    zzalsVar = null;
                                                                    if (zzalsVar != null) {
                                                                        map4.put(zzalsVar.zza, zzalsVar);
                                                                    }
                                                                } else if (zzfz.zzc(xmlPullParserNewPullParser, str2)) {
                                                                    do {
                                                                        xmlPullParserNewPullParser.next();
                                                                        if (zzfz.zzc(xmlPullParserNewPullParser, "image")) {
                                                                            map5.put(strZza8, xmlPullParserNewPullParser.nextText());
                                                                        }
                                                                    } while (!zzfz.zzb(xmlPullParserNewPullParser, str2));
                                                                }
                                                                if (zzfz.zzb(xmlPullParserNewPullParser, "head")) {
                                                                    zzalpVar2 = zzalpVar4;
                                                                    arrayDeque = arrayDeque2;
                                                                } else {
                                                                    zzalpVar4 = zzalpVar4;
                                                                    str2 = str4;
                                                                    map3 = map2;
                                                                }
                                                            }
                                                            str4 = str2;
                                                            map2 = map3;
                                                            if (zzfz.zzb(xmlPullParserNewPullParser, "head")) {
                                                                zzalpVar2 = zzalpVar4;
                                                                arrayDeque = arrayDeque2;
                                                            } else {
                                                                zzalpVar4 = zzalpVar4;
                                                                str2 = str4;
                                                                map3 = map2;
                                                            }
                                                        }
                                                    } else {
                                                        map2 = map3;
                                                        zzalpVar = zzalpVar4;
                                                        attributeCount = xmlPullParserNewPullParser.getAttributeCount();
                                                        zzalu zzaluVarZzf2 = zzf(xmlPullParserNewPullParser, null);
                                                        strArr = null;
                                                        strSubstring = null;
                                                        str3 = str;
                                                        jZzc = -9223372036854775807L;
                                                        jZzc2 = -9223372036854775807L;
                                                        jZzc3 = -9223372036854775807L;
                                                        i5 = 0;
                                                        while (i5 < attributeCount) {
                                                            attributeName = xmlPullParserNewPullParser.getAttributeName(i5);
                                                            attributeValue = xmlPullParserNewPullParser.getAttributeValue(i5);
                                                            switch (attributeName) {
                                                                case "region":
                                                                    b = 4;
                                                                    break;
                                                                case "dur":
                                                                    b = 2;
                                                                    break;
                                                                case "end":
                                                                    b = 1;
                                                                    break;
                                                                case "begin":
                                                                    b = 0;
                                                                    break;
                                                                case "style":
                                                                    b = 3;
                                                                    break;
                                                                case "backgroundImage":
                                                                    b = 5;
                                                                    break;
                                                                default:
                                                                    b = -1;
                                                                    break;
                                                            }
                                                            if (b == 0) {
                                                                zzalpVar2 = zzalpVar;
                                                                i4 = 1;
                                                                jZzc2 = zzc(attributeValue, zzalpVar2);
                                                            } else if (b == 1) {
                                                                i4 = 1;
                                                                zzalpVar2 = zzalpVar;
                                                                jZzc = zzc(attributeValue, zzalpVar2);
                                                            } else if (b != 2) {
                                                                if (b == 3) {
                                                                    i4 = 1;
                                                                    strArrZzg = zzg(attributeValue);
                                                                    if (strArrZzg.length > 0) {
                                                                        strArr = strArrZzg;
                                                                    }
                                                                } else if (b == 4) {
                                                                    i4 = 1;
                                                                    if (map4.containsKey(attributeValue)) {
                                                                        str3 = attributeValue;
                                                                    }
                                                                } else if (b != 5) {
                                                                    i4 = 1;
                                                                } else if (attributeValue.startsWith("#")) {
                                                                    i4 = 1;
                                                                    strSubstring = attributeValue.substring(1);
                                                                } else {
                                                                    i4 = 1;
                                                                }
                                                                zzalpVar2 = zzalpVar;
                                                            } else {
                                                                zzalpVar2 = zzalpVar;
                                                                i4 = 1;
                                                                jZzc3 = zzc(attributeValue, zzalpVar2);
                                                            }
                                                            i5++;
                                                            zzalpVar = zzalpVar2;
                                                            i4 = 0;
                                                        }
                                                        zzalpVar2 = zzalpVar;
                                                        i4 = 1;
                                                        if (zzaloVar2 != null) {
                                                            j3 = zzaloVar2.zzd;
                                                            if (j3 == -9223372036854775807L) {
                                                                zzaloVar = zzaloVar2;
                                                            } else {
                                                                if (jZzc2 != -9223372036854775807L) {
                                                                    jZzc2 += j3;
                                                                } else {
                                                                    jZzc2 = -9223372036854775807L;
                                                                }
                                                                if (jZzc != -9223372036854775807L) {
                                                                    jZzc += j3;
                                                                    zzaloVar = zzaloVar2;
                                                                } else {
                                                                    zzaloVar = zzaloVar2;
                                                                    jZzc = -9223372036854775807L;
                                                                }
                                                            }
                                                        } else {
                                                            zzaloVar = null;
                                                        }
                                                        if (jZzc != -9223372036854775807L) {
                                                            j = jZzc;
                                                        } else if (jZzc3 != -9223372036854775807L) {
                                                            j = jZzc2 + jZzc3;
                                                        } else if (zzaloVar != null) {
                                                            j2 = zzaloVar.zze;
                                                            if (j2 != -9223372036854775807L) {
                                                                j = j2;
                                                            } else {
                                                                j = -9223372036854775807L;
                                                            }
                                                        } else {
                                                            j = -9223372036854775807L;
                                                        }
                                                        zzaloVarZzb = zzalo.zzb(xmlPullParserNewPullParser.getName(), jZzc2, j, zzaluVarZzf2, strArr, str3, strSubstring, zzaloVar);
                                                        arrayDeque = arrayDeque2;
                                                        arrayDeque.push(zzaloVarZzb);
                                                        if (zzaloVar2 != null) {
                                                            zzaloVar2.zzf(zzaloVarZzb);
                                                        }
                                                    }
                                                    zzalpVar4 = zzalpVar2;
                                                    i9 = i9;
                                                    map = map2;
                                                } else {
                                                    if ("head".equals(name)) {
                                                        while (true) {
                                                            xmlPullParserNewPullParser.next();
                                                            if (zzfz.zzc(xmlPullParserNewPullParser, "style")) {
                                                                strZza9 = zzfz.zza(xmlPullParserNewPullParser, "style");
                                                                zzaluVarZzf = zzf(xmlPullParserNewPullParser, new zzalu());
                                                                if (strZza9 != null) {
                                                                    strArrZzg2 = zzg(strZza9);
                                                                    i8 = 0;
                                                                    while (i8 < length) {
                                                                        zzaluVarZzf.zzl((zzalu) map3.get(strArrZzg2[i8]));
                                                                        i8++;
                                                                    }
                                                                }
                                                                strZzE = zzaluVarZzf.zzE();
                                                                if (strZzE != null) {
                                                                    map3.put(strZzE, zzaluVarZzf);
                                                                }
                                                            } else {
                                                                zzalpVar4 = zzalpVar4;
                                                                if (zzfz.zzc(xmlPullParserNewPullParser, "region")) {
                                                                    strZza = zzfz.zza(xmlPullParserNewPullParser, "id");
                                                                    if (strZza == null) {
                                                                        str4 = str2;
                                                                        map2 = map3;
                                                                    } else {
                                                                        strZza2 = zzfz.zza(xmlPullParserNewPullParser, "origin");
                                                                        if (strZza2 != null) {
                                                                            pattern = zzb;
                                                                            matcher = pattern.matcher(strZza2);
                                                                            pattern2 = zzf;
                                                                            str4 = str2;
                                                                            matcher2 = pattern2.matcher(strZza2);
                                                                            if (matcher.matches()) {
                                                                                map2 = map3;
                                                                                try {
                                                                                    String strGroup15 = matcher.group(1);
                                                                                    strGroup15.getClass();
                                                                                    float f17 = Float.parseFloat(strGroup15) / 100.0f;
                                                                                    String strGroup16 = matcher.group(2);
                                                                                    strGroup16.getClass();
                                                                                    f2 = Float.parseFloat(strGroup16) / 100.0f;
                                                                                    f = f17;
                                                                                    strZza3 = zzfz.zza(xmlPullParserNewPullParser, "extent");
                                                                                    if (strZza3 != null) {
                                                                                        matcher3 = pattern.matcher(strZza3);
                                                                                        matcher4 = pattern2.matcher(strZza3);
                                                                                        if (matcher3.matches()) {
                                                                                            try {
                                                                                                String strGroup17 = matcher3.group(1);
                                                                                                strGroup17.getClass();
                                                                                                float f18 = Float.parseFloat(strGroup17) / 100.0f;
                                                                                                String strGroup18 = matcher3.group(2);
                                                                                                strGroup18.getClass();
                                                                                                f3 = Float.parseFloat(strGroup18) / 100.0f;
                                                                                                f4 = f18;
                                                                                                strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                                                if (strZza4 != null) {
                                                                                                    strZza7 = zzfwk.zza(strZza4);
                                                                                                    iHashCode2 = strZza7.hashCode();
                                                                                                    if (iHashCode2 != -1364013995) {
                                                                                                        if (iHashCode2 != 92734940) {
                                                                                                            b3 = -1;
                                                                                                        } else {
                                                                                                            b3 = 1;
                                                                                                        }
                                                                                                    } else if (strZza7.equals("center")) {
                                                                                                        b3 = 0;
                                                                                                    } else {
                                                                                                        b3 = -1;
                                                                                                    }
                                                                                                    if (b3 != 0) {
                                                                                                        f5 = f2 + (f3 / 2.0f);
                                                                                                        i6 = 1;
                                                                                                    } else if (b3 != 1) {
                                                                                                        f5 = f2;
                                                                                                        i6 = 0;
                                                                                                    } else {
                                                                                                        f5 = f2 + f3;
                                                                                                        i6 = 2;
                                                                                                    }
                                                                                                } else {
                                                                                                    f5 = f2;
                                                                                                    i6 = 0;
                                                                                                }
                                                                                                float f19 = 1.0f / i10;
                                                                                                strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                                if (strZza5 != null) {
                                                                                                    strZza6 = zzfwk.zza(strZza5);
                                                                                                    iHashCode = strZza6.hashCode();
                                                                                                    if (iHashCode != 3694) {
                                                                                                        if (iHashCode != 3553396) {
                                                                                                            if (iHashCode != 3553576) {
                                                                                                                b2 = -1;
                                                                                                            } else {
                                                                                                                b2 = 2;
                                                                                                            }
                                                                                                        } else if (strZza6.equals("tblr")) {
                                                                                                            b2 = 1;
                                                                                                        } else {
                                                                                                            b2 = -1;
                                                                                                        }
                                                                                                    } else if (strZza6.equals("tb")) {
                                                                                                        b2 = 0;
                                                                                                    } else {
                                                                                                        b2 = -1;
                                                                                                    }
                                                                                                    if (b2 != 0) {
                                                                                                        i7 = 2;
                                                                                                    } else {
                                                                                                        i7 = 2;
                                                                                                    }
                                                                                                } else {
                                                                                                    i7 = Integer.MIN_VALUE;
                                                                                                }
                                                                                                zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f19, i7);
                                                                                            } catch (NumberFormatException unused3) {
                                                                                                zzff.zzf("TtmlParser", "Ignoring region with malformed extent: ".concat(strZza2));
                                                                                                zzalsVar = null;
                                                                                            }
                                                                                        } else if (matcher4.matches()) {
                                                                                            zzff.zzf("TtmlParser", "Ignoring region with unsupported extent: ".concat(strZza2));
                                                                                        } else if (zzalqVar == null) {
                                                                                            zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                                                        } else {
                                                                                            try {
                                                                                                String strGroup19 = matcher4.group(1);
                                                                                                strGroup19.getClass();
                                                                                                int i112 = Integer.parseInt(strGroup19);
                                                                                                String strGroup110 = matcher4.group(2);
                                                                                                strGroup110.getClass();
                                                                                                int i113 = Integer.parseInt(strGroup110);
                                                                                                float f110 = i112 / zzalqVar.zza;
                                                                                                f3 = i113 / zzalqVar.zzb;
                                                                                                f4 = f110;
                                                                                                strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                                                if (strZza4 != null) {
                                                                                                    strZza7 = zzfwk.zza(strZza4);
                                                                                                    iHashCode2 = strZza7.hashCode();
                                                                                                    if (iHashCode2 != -1364013995) {
                                                                                                        if (iHashCode2 != 92734940) {
                                                                                                            b3 = -1;
                                                                                                        } else {
                                                                                                            b3 = 1;
                                                                                                        }
                                                                                                    } else if (strZza7.equals("center")) {
                                                                                                        b3 = 0;
                                                                                                    } else {
                                                                                                        b3 = -1;
                                                                                                    }
                                                                                                    if (b3 != 0) {
                                                                                                        f5 = f2 + (f3 / 2.0f);
                                                                                                        i6 = 1;
                                                                                                    } else if (b3 != 1) {
                                                                                                        f5 = f2;
                                                                                                        i6 = 0;
                                                                                                    } else {
                                                                                                        f5 = f2 + f3;
                                                                                                        i6 = 2;
                                                                                                    }
                                                                                                } else {
                                                                                                    f5 = f2;
                                                                                                    i6 = 0;
                                                                                                }
                                                                                                float f111 = 1.0f / i10;
                                                                                                strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                                if (strZza5 != null) {
                                                                                                    strZza6 = zzfwk.zza(strZza5);
                                                                                                    iHashCode = strZza6.hashCode();
                                                                                                    if (iHashCode != 3694) {
                                                                                                        if (iHashCode != 3553396) {
                                                                                                            if (iHashCode != 3553576) {
                                                                                                                b2 = -1;
                                                                                                            } else {
                                                                                                                b2 = 2;
                                                                                                            }
                                                                                                        } else if (strZza6.equals("tblr")) {
                                                                                                            b2 = 1;
                                                                                                        } else {
                                                                                                            b2 = -1;
                                                                                                        }
                                                                                                    } else if (strZza6.equals("tb")) {
                                                                                                        b2 = 0;
                                                                                                    } else {
                                                                                                        b2 = -1;
                                                                                                    }
                                                                                                    if (b2 != 0) {
                                                                                                        i7 = 2;
                                                                                                    } else {
                                                                                                        i7 = 2;
                                                                                                    }
                                                                                                } else {
                                                                                                    i7 = Integer.MIN_VALUE;
                                                                                                }
                                                                                                zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f111, i7);
                                                                                            } catch (NumberFormatException unused4) {
                                                                                                zzff.zzf("TtmlParser", "Ignoring region with malformed extent: ".concat(strZza2));
                                                                                                zzalsVar = null;
                                                                                            }
                                                                                        }
                                                                                        if (zzalsVar != null) {
                                                                                            map4.put(zzalsVar.zza, zzalsVar);
                                                                                        }
                                                                                    } else {
                                                                                        zzff.zzf("TtmlParser", "Ignoring region without an extent");
                                                                                    }
                                                                                } catch (NumberFormatException unused5) {
                                                                                    zzff.zzf("TtmlParser", "Ignoring region with malformed origin: ".concat(strZza2));
                                                                                }
                                                                            } else {
                                                                                map2 = map3;
                                                                                if (!matcher2.matches()) {
                                                                                    zzff.zzf("TtmlParser", "Ignoring region with unsupported origin: ".concat(strZza2));
                                                                                } else if (zzalqVar == null) {
                                                                                    zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                                                } else {
                                                                                    try {
                                                                                        String strGroup20 = matcher2.group(1);
                                                                                        strGroup20.getClass();
                                                                                        int i21 = Integer.parseInt(strGroup20);
                                                                                        String strGroup111 = matcher2.group(2);
                                                                                        strGroup111.getClass();
                                                                                        float f112 = Integer.parseInt(strGroup111);
                                                                                        f = i21 / zzalqVar.zza;
                                                                                        f2 = f112 / zzalqVar.zzb;
                                                                                        strZza3 = zzfz.zza(xmlPullParserNewPullParser, "extent");
                                                                                        if (strZza3 != null) {
                                                                                            matcher3 = pattern.matcher(strZza3);
                                                                                            matcher4 = pattern2.matcher(strZza3);
                                                                                            if (matcher3.matches()) {
                                                                                                String strGroup112 = matcher3.group(1);
                                                                                                strGroup112.getClass();
                                                                                                float f113 = Float.parseFloat(strGroup112) / 100.0f;
                                                                                                String strGroup113 = matcher3.group(2);
                                                                                                strGroup113.getClass();
                                                                                                f3 = Float.parseFloat(strGroup113) / 100.0f;
                                                                                                f4 = f113;
                                                                                                strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                                                if (strZza4 != null) {
                                                                                                    strZza7 = zzfwk.zza(strZza4);
                                                                                                    iHashCode2 = strZza7.hashCode();
                                                                                                    if (iHashCode2 != -1364013995) {
                                                                                                        if (iHashCode2 != 92734940) {
                                                                                                            b3 = -1;
                                                                                                        } else {
                                                                                                            b3 = 1;
                                                                                                        }
                                                                                                    } else if (strZza7.equals("center")) {
                                                                                                        b3 = 0;
                                                                                                    } else {
                                                                                                        b3 = -1;
                                                                                                    }
                                                                                                    if (b3 != 0) {
                                                                                                        f5 = f2 + (f3 / 2.0f);
                                                                                                        i6 = 1;
                                                                                                    } else if (b3 != 1) {
                                                                                                        f5 = f2;
                                                                                                        i6 = 0;
                                                                                                    } else {
                                                                                                        f5 = f2 + f3;
                                                                                                        i6 = 2;
                                                                                                    }
                                                                                                } else {
                                                                                                    f5 = f2;
                                                                                                    i6 = 0;
                                                                                                }
                                                                                                float f114 = 1.0f / i10;
                                                                                                strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                                if (strZza5 != null) {
                                                                                                    strZza6 = zzfwk.zza(strZza5);
                                                                                                    iHashCode = strZza6.hashCode();
                                                                                                    if (iHashCode != 3694) {
                                                                                                        if (iHashCode != 3553396) {
                                                                                                            if (iHashCode != 3553576) {
                                                                                                                b2 = -1;
                                                                                                            } else {
                                                                                                                b2 = 2;
                                                                                                            }
                                                                                                        } else if (strZza6.equals("tblr")) {
                                                                                                            b2 = 1;
                                                                                                        } else {
                                                                                                            b2 = -1;
                                                                                                        }
                                                                                                    } else if (strZza6.equals("tb")) {
                                                                                                        b2 = 0;
                                                                                                    } else {
                                                                                                        b2 = -1;
                                                                                                    }
                                                                                                    if (b2 != 0) {
                                                                                                        i7 = 2;
                                                                                                    } else {
                                                                                                        i7 = 2;
                                                                                                    }
                                                                                                } else {
                                                                                                    i7 = Integer.MIN_VALUE;
                                                                                                }
                                                                                                zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f114, i7);
                                                                                            } else if (matcher4.matches()) {
                                                                                                zzff.zzf("TtmlParser", "Ignoring region with unsupported extent: ".concat(strZza2));
                                                                                            } else if (zzalqVar == null) {
                                                                                                zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                                                            } else {
                                                                                                String strGroup114 = matcher4.group(1);
                                                                                                strGroup114.getClass();
                                                                                                int i114 = Integer.parseInt(strGroup114);
                                                                                                String strGroup115 = matcher4.group(2);
                                                                                                strGroup115.getClass();
                                                                                                int i115 = Integer.parseInt(strGroup115);
                                                                                                float f115 = i114 / zzalqVar.zza;
                                                                                                f3 = i115 / zzalqVar.zzb;
                                                                                                f4 = f115;
                                                                                                strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                                                if (strZza4 != null) {
                                                                                                    strZza7 = zzfwk.zza(strZza4);
                                                                                                    iHashCode2 = strZza7.hashCode();
                                                                                                    if (iHashCode2 != -1364013995) {
                                                                                                        if (iHashCode2 != 92734940) {
                                                                                                            b3 = -1;
                                                                                                        } else {
                                                                                                            b3 = 1;
                                                                                                        }
                                                                                                    } else if (strZza7.equals("center")) {
                                                                                                        b3 = 0;
                                                                                                    } else {
                                                                                                        b3 = -1;
                                                                                                    }
                                                                                                    if (b3 != 0) {
                                                                                                        f5 = f2 + (f3 / 2.0f);
                                                                                                        i6 = 1;
                                                                                                    } else if (b3 != 1) {
                                                                                                        f5 = f2;
                                                                                                        i6 = 0;
                                                                                                    } else {
                                                                                                        f5 = f2 + f3;
                                                                                                        i6 = 2;
                                                                                                    }
                                                                                                } else {
                                                                                                    f5 = f2;
                                                                                                    i6 = 0;
                                                                                                }
                                                                                                float f116 = 1.0f / i10;
                                                                                                strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                                if (strZza5 != null) {
                                                                                                    strZza6 = zzfwk.zza(strZza5);
                                                                                                    iHashCode = strZza6.hashCode();
                                                                                                    if (iHashCode != 3694) {
                                                                                                        if (iHashCode != 3553396) {
                                                                                                            if (iHashCode != 3553576) {
                                                                                                                b2 = -1;
                                                                                                            } else {
                                                                                                                b2 = 2;
                                                                                                            }
                                                                                                        } else if (strZza6.equals("tblr")) {
                                                                                                            b2 = 1;
                                                                                                        } else {
                                                                                                            b2 = -1;
                                                                                                        }
                                                                                                    } else if (strZza6.equals("tb")) {
                                                                                                        b2 = 0;
                                                                                                    } else {
                                                                                                        b2 = -1;
                                                                                                    }
                                                                                                    if (b2 != 0) {
                                                                                                        i7 = 2;
                                                                                                    } else {
                                                                                                        i7 = 2;
                                                                                                    }
                                                                                                } else {
                                                                                                    i7 = Integer.MIN_VALUE;
                                                                                                }
                                                                                                zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f116, i7);
                                                                                            }
                                                                                            if (zzalsVar != null) {
                                                                                                map4.put(zzalsVar.zza, zzalsVar);
                                                                                            }
                                                                                        } else {
                                                                                            zzff.zzf("TtmlParser", "Ignoring region without an extent");
                                                                                        }
                                                                                    } catch (NumberFormatException unused6) {
                                                                                        zzff.zzf("TtmlParser", "Ignoring region with malformed origin: ".concat(strZza2));
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else {
                                                                            str4 = str2;
                                                                            map2 = map3;
                                                                            zzff.zzf("TtmlParser", "Ignoring region without an origin");
                                                                        }
                                                                    }
                                                                    zzalsVar = null;
                                                                    if (zzalsVar != null) {
                                                                        map4.put(zzalsVar.zza, zzalsVar);
                                                                    }
                                                                } else if (zzfz.zzc(xmlPullParserNewPullParser, str2)) {
                                                                    do {
                                                                        xmlPullParserNewPullParser.next();
                                                                        if (zzfz.zzc(xmlPullParserNewPullParser, "image")) {
                                                                            map5.put(strZza8, xmlPullParserNewPullParser.nextText());
                                                                        }
                                                                    } while (!zzfz.zzb(xmlPullParserNewPullParser, str2));
                                                                }
                                                                if (zzfz.zzb(xmlPullParserNewPullParser, "head")) {
                                                                    zzalpVar2 = zzalpVar4;
                                                                    arrayDeque = arrayDeque2;
                                                                } else {
                                                                    zzalpVar4 = zzalpVar4;
                                                                    str2 = str4;
                                                                    map3 = map2;
                                                                }
                                                            }
                                                            str4 = str2;
                                                            map2 = map3;
                                                            if (zzfz.zzb(xmlPullParserNewPullParser, "head")) {
                                                                zzalpVar2 = zzalpVar4;
                                                                arrayDeque = arrayDeque2;
                                                            } else {
                                                                zzalpVar4 = zzalpVar4;
                                                                str2 = str4;
                                                                map3 = map2;
                                                            }
                                                        }
                                                    } else {
                                                        map2 = map3;
                                                        zzalpVar = zzalpVar4;
                                                        try {
                                                            attributeCount = xmlPullParserNewPullParser.getAttributeCount();
                                                            zzalu zzaluVarZzf3 = zzf(xmlPullParserNewPullParser, null);
                                                            strArr = null;
                                                            strSubstring = null;
                                                            str3 = str;
                                                            jZzc = -9223372036854775807L;
                                                            jZzc2 = -9223372036854775807L;
                                                            jZzc3 = -9223372036854775807L;
                                                            i5 = 0;
                                                            while (i5 < attributeCount) {
                                                                try {
                                                                    attributeName = xmlPullParserNewPullParser.getAttributeName(i5);
                                                                    attributeValue = xmlPullParserNewPullParser.getAttributeValue(i5);
                                                                    switch (attributeName) {
                                                                        case -934795532:
                                                                            if (!attributeName.equals("region")) {
                                                                                b = 4;
                                                                            } else {
                                                                                b = -1;
                                                                            }
                                                                            break;
                                                                        case 99841:
                                                                            if (!attributeName.equals("dur")) {
                                                                                b = 2;
                                                                            } else {
                                                                                b = -1;
                                                                            }
                                                                            break;
                                                                        case 100571:
                                                                            if (!attributeName.equals("end")) {
                                                                                b = 1;
                                                                            } else {
                                                                                b = -1;
                                                                            }
                                                                            break;
                                                                        case 93616297:
                                                                            if (!attributeName.equals("begin")) {
                                                                                b = 0;
                                                                            } else {
                                                                                b = -1;
                                                                            }
                                                                            break;
                                                                        case 109780401:
                                                                            if (!attributeName.equals("style")) {
                                                                                b = 3;
                                                                            } else {
                                                                                b = -1;
                                                                            }
                                                                            break;
                                                                        case 1292595405:
                                                                            if (!attributeName.equals("backgroundImage")) {
                                                                                b = 5;
                                                                            } else {
                                                                                b = -1;
                                                                            }
                                                                            break;
                                                                        default:
                                                                            b = -1;
                                                                            break;
                                                                    }
                                                                    if (b == 0) {
                                                                        zzalpVar2 = zzalpVar;
                                                                        i4 = 1;
                                                                        jZzc2 = zzc(attributeValue, zzalpVar2);
                                                                    } else if (b == 1) {
                                                                        i4 = 1;
                                                                        zzalpVar2 = zzalpVar;
                                                                        jZzc = zzc(attributeValue, zzalpVar2);
                                                                    } else if (b != 2) {
                                                                        if (b == 3) {
                                                                            i4 = 1;
                                                                            strArrZzg = zzg(attributeValue);
                                                                            if (strArrZzg.length > 0) {
                                                                                strArr = strArrZzg;
                                                                            }
                                                                        } else if (b == 4) {
                                                                            i4 = 1;
                                                                            if (map4.containsKey(attributeValue)) {
                                                                                str3 = attributeValue;
                                                                            }
                                                                        } else if (b != 5) {
                                                                            i4 = 1;
                                                                        } else {
                                                                            try {
                                                                                if (attributeValue.startsWith("#")) {
                                                                                    i4 = 1;
                                                                                    try {
                                                                                        strSubstring = attributeValue.substring(1);
                                                                                    } catch (zzakn e) {
                                                                                        e = e;
                                                                                        zzaknVar = e;
                                                                                        zzalpVar2 = zzalpVar;
                                                                                        arrayDeque = arrayDeque2;
                                                                                        zzff.zzg("TtmlParser", "Suppressing parser error", zzaknVar);
                                                                                        zzalpVar4 = zzalpVar2;
                                                                                        i9 = i4;
                                                                                        map = map2;
                                                                                        xmlPullParserNewPullParser.next();
                                                                                        eventType = xmlPullParserNewPullParser.getEventType();
                                                                                        map3 = map;
                                                                                        arrayDeque2 = arrayDeque;
                                                                                        str5 = str;
                                                                                        str6 = str6;
                                                                                    }
                                                                                } else {
                                                                                    i4 = 1;
                                                                                }
                                                                            } catch (zzakn e2) {
                                                                                e = e2;
                                                                                i4 = 1;
                                                                            }
                                                                        }
                                                                        zzalpVar2 = zzalpVar;
                                                                    } else {
                                                                        zzalpVar2 = zzalpVar;
                                                                        i4 = 1;
                                                                        jZzc3 = zzc(attributeValue, zzalpVar2);
                                                                    }
                                                                    try {
                                                                        i5++;
                                                                        zzalpVar = zzalpVar2;
                                                                        i4 = 0;
                                                                    } catch (zzakn e3) {
                                                                        e = e3;
                                                                        zzaknVar = e;
                                                                        arrayDeque = arrayDeque2;
                                                                        zzff.zzg("TtmlParser", "Suppressing parser error", zzaknVar);
                                                                        zzalpVar4 = zzalpVar2;
                                                                        i9 = i4;
                                                                        map = map2;
                                                                        xmlPullParserNewPullParser.next();
                                                                        eventType = xmlPullParserNewPullParser.getEventType();
                                                                        map3 = map;
                                                                        arrayDeque2 = arrayDeque;
                                                                        str5 = str;
                                                                        str6 = str6;
                                                                    }
                                                                } catch (zzakn e4) {
                                                                    e = e4;
                                                                    zzalpVar2 = zzalpVar;
                                                                    i4 = 1;
                                                                }
                                                            }
                                                            zzalpVar2 = zzalpVar;
                                                            i4 = 1;
                                                            if (zzaloVar2 != null) {
                                                                j3 = zzaloVar2.zzd;
                                                                if (j3 == -9223372036854775807L) {
                                                                    zzaloVar = zzaloVar2;
                                                                } else {
                                                                    if (jZzc2 != -9223372036854775807L) {
                                                                        jZzc2 += j3;
                                                                    } else {
                                                                        jZzc2 = -9223372036854775807L;
                                                                    }
                                                                    if (jZzc != -9223372036854775807L) {
                                                                        jZzc += j3;
                                                                        zzaloVar = zzaloVar2;
                                                                    } else {
                                                                        zzaloVar = zzaloVar2;
                                                                        jZzc = -9223372036854775807L;
                                                                    }
                                                                }
                                                            } else {
                                                                zzaloVar = null;
                                                            }
                                                            if (jZzc != -9223372036854775807L) {
                                                                j = jZzc;
                                                            } else if (jZzc3 != -9223372036854775807L) {
                                                                j = jZzc2 + jZzc3;
                                                            } else if (zzaloVar != null) {
                                                                j2 = zzaloVar.zze;
                                                                if (j2 != -9223372036854775807L) {
                                                                    j = j2;
                                                                } else {
                                                                    j = -9223372036854775807L;
                                                                }
                                                            } else {
                                                                j = -9223372036854775807L;
                                                            }
                                                            try {
                                                                zzaloVarZzb = zzalo.zzb(xmlPullParserNewPullParser.getName(), jZzc2, j, zzaluVarZzf3, strArr, str3, strSubstring, zzaloVar);
                                                                arrayDeque = arrayDeque2;
                                                                try {
                                                                    arrayDeque.push(zzaloVarZzb);
                                                                    if (zzaloVar2 != null) {
                                                                        zzaloVar2.zzf(zzaloVarZzb);
                                                                    }
                                                                } catch (zzakn e5) {
                                                                    e = e5;
                                                                    zzaknVar = e;
                                                                    zzff.zzg("TtmlParser", "Suppressing parser error", zzaknVar);
                                                                    zzalpVar4 = zzalpVar2;
                                                                    i9 = i4;
                                                                }
                                                            } catch (zzakn e6) {
                                                                e = e6;
                                                                arrayDeque = arrayDeque2;
                                                            }
                                                        } catch (zzakn e7) {
                                                            e = e7;
                                                            zzalpVar2 = zzalpVar;
                                                            arrayDeque = arrayDeque2;
                                                            i4 = 1;
                                                        }
                                                    }
                                                    zzalpVar4 = zzalpVar2;
                                                    i9 = i9;
                                                    map = map2;
                                                }
                                            } else {
                                                matcher5 = zzf.matcher(strZza10);
                                                if (matcher5.matches()) {
                                                    try {
                                                        String strGroup21 = matcher5.group(1);
                                                        strGroup21.getClass();
                                                        int i22 = Integer.parseInt(strGroup21);
                                                        String strGroup22 = matcher5.group(2);
                                                        strGroup22.getClass();
                                                        zzalqVar = new zzalq(i22, Integer.parseInt(strGroup22));
                                                    } catch (NumberFormatException unused7) {
                                                        zzff.zzf("TtmlParser", "Ignoring malformed tts extent: ".concat(strZza10));
                                                        zzalqVar = null;
                                                    }
                                                    zzalpVar4 = zzalpVar3;
                                                    str2 = "metadata";
                                                    if (name.equals("tt")) {
                                                        if ("head".equals(name)) {
                                                            while (true) {
                                                                xmlPullParserNewPullParser.next();
                                                                if (zzfz.zzc(xmlPullParserNewPullParser, "style")) {
                                                                    strZza9 = zzfz.zza(xmlPullParserNewPullParser, "style");
                                                                    zzaluVarZzf = zzf(xmlPullParserNewPullParser, new zzalu());
                                                                    if (strZza9 != null) {
                                                                        strArrZzg2 = zzg(strZza9);
                                                                        i8 = 0;
                                                                        while (i8 < length) {
                                                                            zzaluVarZzf.zzl((zzalu) map3.get(strArrZzg2[i8]));
                                                                            i8++;
                                                                        }
                                                                    }
                                                                    strZzE = zzaluVarZzf.zzE();
                                                                    if (strZzE != null) {
                                                                        map3.put(strZzE, zzaluVarZzf);
                                                                    }
                                                                } else {
                                                                    zzalpVar4 = zzalpVar4;
                                                                    if (zzfz.zzc(xmlPullParserNewPullParser, "region")) {
                                                                        strZza = zzfz.zza(xmlPullParserNewPullParser, "id");
                                                                        if (strZza == null) {
                                                                            str4 = str2;
                                                                            map2 = map3;
                                                                        } else {
                                                                            strZza2 = zzfz.zza(xmlPullParserNewPullParser, "origin");
                                                                            if (strZza2 != null) {
                                                                                pattern = zzb;
                                                                                matcher = pattern.matcher(strZza2);
                                                                                pattern2 = zzf;
                                                                                str4 = str2;
                                                                                matcher2 = pattern2.matcher(strZza2);
                                                                                if (matcher.matches()) {
                                                                                    map2 = map3;
                                                                                    String strGroup116 = matcher.group(1);
                                                                                    strGroup116.getClass();
                                                                                    float f117 = Float.parseFloat(strGroup116) / 100.0f;
                                                                                    String strGroup117 = matcher.group(2);
                                                                                    strGroup117.getClass();
                                                                                    f2 = Float.parseFloat(strGroup117) / 100.0f;
                                                                                    f = f117;
                                                                                    strZza3 = zzfz.zza(xmlPullParserNewPullParser, "extent");
                                                                                    if (strZza3 != null) {
                                                                                        matcher3 = pattern.matcher(strZza3);
                                                                                        matcher4 = pattern2.matcher(strZza3);
                                                                                        if (matcher3.matches()) {
                                                                                            String strGroup118 = matcher3.group(1);
                                                                                            strGroup118.getClass();
                                                                                            float f118 = Float.parseFloat(strGroup118) / 100.0f;
                                                                                            String strGroup119 = matcher3.group(2);
                                                                                            strGroup119.getClass();
                                                                                            f3 = Float.parseFloat(strGroup119) / 100.0f;
                                                                                            f4 = f118;
                                                                                            strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                                            if (strZza4 != null) {
                                                                                                strZza7 = zzfwk.zza(strZza4);
                                                                                                iHashCode2 = strZza7.hashCode();
                                                                                                if (iHashCode2 != -1364013995) {
                                                                                                    if (iHashCode2 != 92734940) {
                                                                                                        b3 = -1;
                                                                                                    } else {
                                                                                                        b3 = 1;
                                                                                                    }
                                                                                                } else if (strZza7.equals("center")) {
                                                                                                    b3 = 0;
                                                                                                } else {
                                                                                                    b3 = -1;
                                                                                                }
                                                                                                if (b3 != 0) {
                                                                                                    f5 = f2 + (f3 / 2.0f);
                                                                                                    i6 = 1;
                                                                                                } else if (b3 != 1) {
                                                                                                    f5 = f2;
                                                                                                    i6 = 0;
                                                                                                } else {
                                                                                                    f5 = f2 + f3;
                                                                                                    i6 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                f5 = f2;
                                                                                                i6 = 0;
                                                                                            }
                                                                                            float f119 = 1.0f / i10;
                                                                                            strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                            if (strZza5 != null) {
                                                                                                strZza6 = zzfwk.zza(strZza5);
                                                                                                iHashCode = strZza6.hashCode();
                                                                                                if (iHashCode != 3694) {
                                                                                                    if (iHashCode != 3553396) {
                                                                                                        if (iHashCode != 3553576) {
                                                                                                            b2 = -1;
                                                                                                        } else {
                                                                                                            b2 = 2;
                                                                                                        }
                                                                                                    } else if (strZza6.equals("tblr")) {
                                                                                                        b2 = 1;
                                                                                                    } else {
                                                                                                        b2 = -1;
                                                                                                    }
                                                                                                } else if (strZza6.equals("tb")) {
                                                                                                    b2 = 0;
                                                                                                } else {
                                                                                                    b2 = -1;
                                                                                                }
                                                                                                if (b2 != 0) {
                                                                                                    i7 = 2;
                                                                                                } else {
                                                                                                    i7 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                i7 = Integer.MIN_VALUE;
                                                                                            }
                                                                                            zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f119, i7);
                                                                                        } else if (matcher4.matches()) {
                                                                                            zzff.zzf("TtmlParser", "Ignoring region with unsupported extent: ".concat(strZza2));
                                                                                        } else if (zzalqVar == null) {
                                                                                            zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                                                        } else {
                                                                                            String strGroup1110 = matcher4.group(1);
                                                                                            strGroup1110.getClass();
                                                                                            int i116 = Integer.parseInt(strGroup1110);
                                                                                            String strGroup1111 = matcher4.group(2);
                                                                                            strGroup1111.getClass();
                                                                                            int i117 = Integer.parseInt(strGroup1111);
                                                                                            float f1110 = i116 / zzalqVar.zza;
                                                                                            f3 = i117 / zzalqVar.zzb;
                                                                                            f4 = f1110;
                                                                                            strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                                            if (strZza4 != null) {
                                                                                                strZza7 = zzfwk.zza(strZza4);
                                                                                                iHashCode2 = strZza7.hashCode();
                                                                                                if (iHashCode2 != -1364013995) {
                                                                                                    if (iHashCode2 != 92734940) {
                                                                                                        b3 = -1;
                                                                                                    } else {
                                                                                                        b3 = 1;
                                                                                                    }
                                                                                                } else if (strZza7.equals("center")) {
                                                                                                    b3 = 0;
                                                                                                } else {
                                                                                                    b3 = -1;
                                                                                                }
                                                                                                if (b3 != 0) {
                                                                                                    f5 = f2 + (f3 / 2.0f);
                                                                                                    i6 = 1;
                                                                                                } else if (b3 != 1) {
                                                                                                    f5 = f2;
                                                                                                    i6 = 0;
                                                                                                } else {
                                                                                                    f5 = f2 + f3;
                                                                                                    i6 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                f5 = f2;
                                                                                                i6 = 0;
                                                                                            }
                                                                                            float f1111 = 1.0f / i10;
                                                                                            strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                            if (strZza5 != null) {
                                                                                                strZza6 = zzfwk.zza(strZza5);
                                                                                                iHashCode = strZza6.hashCode();
                                                                                                if (iHashCode != 3694) {
                                                                                                    if (iHashCode != 3553396) {
                                                                                                        if (iHashCode != 3553576) {
                                                                                                            b2 = -1;
                                                                                                        } else {
                                                                                                            b2 = 2;
                                                                                                        }
                                                                                                    } else if (strZza6.equals("tblr")) {
                                                                                                        b2 = 1;
                                                                                                    } else {
                                                                                                        b2 = -1;
                                                                                                    }
                                                                                                } else if (strZza6.equals("tb")) {
                                                                                                    b2 = 0;
                                                                                                } else {
                                                                                                    b2 = -1;
                                                                                                }
                                                                                                if (b2 != 0) {
                                                                                                    i7 = 2;
                                                                                                } else {
                                                                                                    i7 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                i7 = Integer.MIN_VALUE;
                                                                                            }
                                                                                            zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f1111, i7);
                                                                                        }
                                                                                        if (zzalsVar != null) {
                                                                                            map4.put(zzalsVar.zza, zzalsVar);
                                                                                        }
                                                                                    } else {
                                                                                        zzff.zzf("TtmlParser", "Ignoring region without an extent");
                                                                                    }
                                                                                } else {
                                                                                    map2 = map3;
                                                                                    if (!matcher2.matches()) {
                                                                                        zzff.zzf("TtmlParser", "Ignoring region with unsupported origin: ".concat(strZza2));
                                                                                    } else if (zzalqVar == null) {
                                                                                        zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                                                    } else {
                                                                                        String strGroup23 = matcher2.group(1);
                                                                                        strGroup23.getClass();
                                                                                        int i23 = Integer.parseInt(strGroup23);
                                                                                        String strGroup1112 = matcher2.group(2);
                                                                                        strGroup1112.getClass();
                                                                                        float f1112 = Integer.parseInt(strGroup1112);
                                                                                        f = i23 / zzalqVar.zza;
                                                                                        f2 = f1112 / zzalqVar.zzb;
                                                                                        strZza3 = zzfz.zza(xmlPullParserNewPullParser, "extent");
                                                                                        if (strZza3 != null) {
                                                                                            matcher3 = pattern.matcher(strZza3);
                                                                                            matcher4 = pattern2.matcher(strZza3);
                                                                                            if (matcher3.matches()) {
                                                                                                String strGroup1113 = matcher3.group(1);
                                                                                                strGroup1113.getClass();
                                                                                                float f1113 = Float.parseFloat(strGroup1113) / 100.0f;
                                                                                                String strGroup1114 = matcher3.group(2);
                                                                                                strGroup1114.getClass();
                                                                                                f3 = Float.parseFloat(strGroup1114) / 100.0f;
                                                                                                f4 = f1113;
                                                                                                strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                                                if (strZza4 != null) {
                                                                                                    strZza7 = zzfwk.zza(strZza4);
                                                                                                    iHashCode2 = strZza7.hashCode();
                                                                                                    if (iHashCode2 != -1364013995) {
                                                                                                        if (iHashCode2 != 92734940) {
                                                                                                            b3 = -1;
                                                                                                        } else {
                                                                                                            b3 = 1;
                                                                                                        }
                                                                                                    } else if (strZza7.equals("center")) {
                                                                                                        b3 = 0;
                                                                                                    } else {
                                                                                                        b3 = -1;
                                                                                                    }
                                                                                                    if (b3 != 0) {
                                                                                                        f5 = f2 + (f3 / 2.0f);
                                                                                                        i6 = 1;
                                                                                                    } else if (b3 != 1) {
                                                                                                        f5 = f2;
                                                                                                        i6 = 0;
                                                                                                    } else {
                                                                                                        f5 = f2 + f3;
                                                                                                        i6 = 2;
                                                                                                    }
                                                                                                } else {
                                                                                                    f5 = f2;
                                                                                                    i6 = 0;
                                                                                                }
                                                                                                float f1114 = 1.0f / i10;
                                                                                                strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                                if (strZza5 != null) {
                                                                                                    strZza6 = zzfwk.zza(strZza5);
                                                                                                    iHashCode = strZza6.hashCode();
                                                                                                    if (iHashCode != 3694) {
                                                                                                        if (iHashCode != 3553396) {
                                                                                                            if (iHashCode != 3553576) {
                                                                                                                b2 = -1;
                                                                                                            } else {
                                                                                                                b2 = 2;
                                                                                                            }
                                                                                                        } else if (strZza6.equals("tblr")) {
                                                                                                            b2 = 1;
                                                                                                        } else {
                                                                                                            b2 = -1;
                                                                                                        }
                                                                                                    } else if (strZza6.equals("tb")) {
                                                                                                        b2 = 0;
                                                                                                    } else {
                                                                                                        b2 = -1;
                                                                                                    }
                                                                                                    if (b2 != 0) {
                                                                                                        i7 = 2;
                                                                                                    } else {
                                                                                                        i7 = 2;
                                                                                                    }
                                                                                                } else {
                                                                                                    i7 = Integer.MIN_VALUE;
                                                                                                }
                                                                                                zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f1114, i7);
                                                                                            } else if (matcher4.matches()) {
                                                                                                zzff.zzf("TtmlParser", "Ignoring region with unsupported extent: ".concat(strZza2));
                                                                                            } else if (zzalqVar == null) {
                                                                                                zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                                                            } else {
                                                                                                String strGroup1115 = matcher4.group(1);
                                                                                                strGroup1115.getClass();
                                                                                                int i118 = Integer.parseInt(strGroup1115);
                                                                                                String strGroup1116 = matcher4.group(2);
                                                                                                strGroup1116.getClass();
                                                                                                int i119 = Integer.parseInt(strGroup1116);
                                                                                                float f1115 = i118 / zzalqVar.zza;
                                                                                                f3 = i119 / zzalqVar.zzb;
                                                                                                f4 = f1115;
                                                                                                strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                                                if (strZza4 != null) {
                                                                                                    strZza7 = zzfwk.zza(strZza4);
                                                                                                    iHashCode2 = strZza7.hashCode();
                                                                                                    if (iHashCode2 != -1364013995) {
                                                                                                        if (iHashCode2 != 92734940) {
                                                                                                            b3 = -1;
                                                                                                        } else {
                                                                                                            b3 = 1;
                                                                                                        }
                                                                                                    } else if (strZza7.equals("center")) {
                                                                                                        b3 = 0;
                                                                                                    } else {
                                                                                                        b3 = -1;
                                                                                                    }
                                                                                                    if (b3 != 0) {
                                                                                                        f5 = f2 + (f3 / 2.0f);
                                                                                                        i6 = 1;
                                                                                                    } else if (b3 != 1) {
                                                                                                        f5 = f2;
                                                                                                        i6 = 0;
                                                                                                    } else {
                                                                                                        f5 = f2 + f3;
                                                                                                        i6 = 2;
                                                                                                    }
                                                                                                } else {
                                                                                                    f5 = f2;
                                                                                                    i6 = 0;
                                                                                                }
                                                                                                float f1116 = 1.0f / i10;
                                                                                                strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                                if (strZza5 != null) {
                                                                                                    strZza6 = zzfwk.zza(strZza5);
                                                                                                    iHashCode = strZza6.hashCode();
                                                                                                    if (iHashCode != 3694) {
                                                                                                        if (iHashCode != 3553396) {
                                                                                                            if (iHashCode != 3553576) {
                                                                                                                b2 = -1;
                                                                                                            } else {
                                                                                                                b2 = 2;
                                                                                                            }
                                                                                                        } else if (strZza6.equals("tblr")) {
                                                                                                            b2 = 1;
                                                                                                        } else {
                                                                                                            b2 = -1;
                                                                                                        }
                                                                                                    } else if (strZza6.equals("tb")) {
                                                                                                        b2 = 0;
                                                                                                    } else {
                                                                                                        b2 = -1;
                                                                                                    }
                                                                                                    if (b2 != 0) {
                                                                                                        i7 = 2;
                                                                                                    } else {
                                                                                                        i7 = 2;
                                                                                                    }
                                                                                                } else {
                                                                                                    i7 = Integer.MIN_VALUE;
                                                                                                }
                                                                                                zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f1116, i7);
                                                                                            }
                                                                                            if (zzalsVar != null) {
                                                                                                map4.put(zzalsVar.zza, zzalsVar);
                                                                                            }
                                                                                        } else {
                                                                                            zzff.zzf("TtmlParser", "Ignoring region without an extent");
                                                                                        }
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                str4 = str2;
                                                                                map2 = map3;
                                                                                zzff.zzf("TtmlParser", "Ignoring region without an origin");
                                                                            }
                                                                        }
                                                                        zzalsVar = null;
                                                                        if (zzalsVar != null) {
                                                                            map4.put(zzalsVar.zza, zzalsVar);
                                                                        }
                                                                    } else if (zzfz.zzc(xmlPullParserNewPullParser, str2)) {
                                                                        do {
                                                                            xmlPullParserNewPullParser.next();
                                                                            if (zzfz.zzc(xmlPullParserNewPullParser, "image")) {
                                                                                map5.put(strZza8, xmlPullParserNewPullParser.nextText());
                                                                            }
                                                                        } while (!zzfz.zzb(xmlPullParserNewPullParser, str2));
                                                                    }
                                                                    if (zzfz.zzb(xmlPullParserNewPullParser, "head")) {
                                                                        zzalpVar2 = zzalpVar4;
                                                                        arrayDeque = arrayDeque2;
                                                                    } else {
                                                                        zzalpVar4 = zzalpVar4;
                                                                        str2 = str4;
                                                                        map3 = map2;
                                                                    }
                                                                }
                                                                str4 = str2;
                                                                map2 = map3;
                                                                if (zzfz.zzb(xmlPullParserNewPullParser, "head")) {
                                                                    zzalpVar2 = zzalpVar4;
                                                                    arrayDeque = arrayDeque2;
                                                                } else {
                                                                    zzalpVar4 = zzalpVar4;
                                                                    str2 = str4;
                                                                    map3 = map2;
                                                                }
                                                            }
                                                        } else {
                                                            map2 = map3;
                                                            zzalpVar = zzalpVar4;
                                                            attributeCount = xmlPullParserNewPullParser.getAttributeCount();
                                                            zzalu zzaluVarZzf4 = zzf(xmlPullParserNewPullParser, null);
                                                            strArr = null;
                                                            strSubstring = null;
                                                            str3 = str;
                                                            jZzc = -9223372036854775807L;
                                                            jZzc2 = -9223372036854775807L;
                                                            jZzc3 = -9223372036854775807L;
                                                            i5 = 0;
                                                            while (i5 < attributeCount) {
                                                                attributeName = xmlPullParserNewPullParser.getAttributeName(i5);
                                                                attributeValue = xmlPullParserNewPullParser.getAttributeValue(i5);
                                                                switch (attributeName) {
                                                                    case -934795532:
                                                                        if (!attributeName.equals("region")) {
                                                                            b = 4;
                                                                        } else {
                                                                            b = -1;
                                                                        }
                                                                        break;
                                                                    case 99841:
                                                                        if (!attributeName.equals("dur")) {
                                                                            b = 2;
                                                                        } else {
                                                                            b = -1;
                                                                        }
                                                                        break;
                                                                    case 100571:
                                                                        if (!attributeName.equals("end")) {
                                                                            b = 1;
                                                                        } else {
                                                                            b = -1;
                                                                        }
                                                                        break;
                                                                    case 93616297:
                                                                        if (!attributeName.equals("begin")) {
                                                                            b = 0;
                                                                        } else {
                                                                            b = -1;
                                                                        }
                                                                        break;
                                                                    case 109780401:
                                                                        if (!attributeName.equals("style")) {
                                                                            b = 3;
                                                                        } else {
                                                                            b = -1;
                                                                        }
                                                                        break;
                                                                    case 1292595405:
                                                                        if (!attributeName.equals("backgroundImage")) {
                                                                            b = 5;
                                                                        } else {
                                                                            b = -1;
                                                                        }
                                                                        break;
                                                                    default:
                                                                        b = -1;
                                                                        break;
                                                                }
                                                                if (b == 0) {
                                                                    zzalpVar2 = zzalpVar;
                                                                    i4 = 1;
                                                                    jZzc2 = zzc(attributeValue, zzalpVar2);
                                                                } else if (b == 1) {
                                                                    i4 = 1;
                                                                    zzalpVar2 = zzalpVar;
                                                                    jZzc = zzc(attributeValue, zzalpVar2);
                                                                } else if (b != 2) {
                                                                    if (b == 3) {
                                                                        i4 = 1;
                                                                        strArrZzg = zzg(attributeValue);
                                                                        if (strArrZzg.length > 0) {
                                                                            strArr = strArrZzg;
                                                                        }
                                                                    } else if (b == 4) {
                                                                        i4 = 1;
                                                                        if (map4.containsKey(attributeValue)) {
                                                                            str3 = attributeValue;
                                                                        }
                                                                    } else if (b != 5) {
                                                                        i4 = 1;
                                                                    } else if (attributeValue.startsWith("#")) {
                                                                        i4 = 1;
                                                                        strSubstring = attributeValue.substring(1);
                                                                    } else {
                                                                        i4 = 1;
                                                                    }
                                                                    zzalpVar2 = zzalpVar;
                                                                } else {
                                                                    zzalpVar2 = zzalpVar;
                                                                    i4 = 1;
                                                                    jZzc3 = zzc(attributeValue, zzalpVar2);
                                                                }
                                                                i5++;
                                                                zzalpVar = zzalpVar2;
                                                                i4 = 0;
                                                            }
                                                            zzalpVar2 = zzalpVar;
                                                            i4 = 1;
                                                            if (zzaloVar2 != null) {
                                                                j3 = zzaloVar2.zzd;
                                                                if (j3 == -9223372036854775807L) {
                                                                    zzaloVar = zzaloVar2;
                                                                } else {
                                                                    if (jZzc2 != -9223372036854775807L) {
                                                                        jZzc2 += j3;
                                                                    } else {
                                                                        jZzc2 = -9223372036854775807L;
                                                                    }
                                                                    if (jZzc != -9223372036854775807L) {
                                                                        jZzc += j3;
                                                                        zzaloVar = zzaloVar2;
                                                                    } else {
                                                                        zzaloVar = zzaloVar2;
                                                                        jZzc = -9223372036854775807L;
                                                                    }
                                                                }
                                                            } else {
                                                                zzaloVar = null;
                                                            }
                                                            if (jZzc != -9223372036854775807L) {
                                                                j = jZzc;
                                                            } else if (jZzc3 != -9223372036854775807L) {
                                                                j = jZzc2 + jZzc3;
                                                            } else if (zzaloVar != null) {
                                                                j2 = zzaloVar.zze;
                                                                if (j2 != -9223372036854775807L) {
                                                                    j = j2;
                                                                } else {
                                                                    j = -9223372036854775807L;
                                                                }
                                                            } else {
                                                                j = -9223372036854775807L;
                                                            }
                                                            zzaloVarZzb = zzalo.zzb(xmlPullParserNewPullParser.getName(), jZzc2, j, zzaluVarZzf4, strArr, str3, strSubstring, zzaloVar);
                                                            arrayDeque = arrayDeque2;
                                                            arrayDeque.push(zzaloVarZzb);
                                                            if (zzaloVar2 != null) {
                                                                zzaloVar2.zzf(zzaloVarZzb);
                                                            }
                                                        }
                                                        zzalpVar4 = zzalpVar2;
                                                        i9 = i9;
                                                        map = map2;
                                                    } else {
                                                        if ("head".equals(name)) {
                                                            while (true) {
                                                                xmlPullParserNewPullParser.next();
                                                                if (zzfz.zzc(xmlPullParserNewPullParser, "style")) {
                                                                    strZza9 = zzfz.zza(xmlPullParserNewPullParser, "style");
                                                                    zzaluVarZzf = zzf(xmlPullParserNewPullParser, new zzalu());
                                                                    if (strZza9 != null) {
                                                                        strArrZzg2 = zzg(strZza9);
                                                                        i8 = 0;
                                                                        while (i8 < length) {
                                                                            zzaluVarZzf.zzl((zzalu) map3.get(strArrZzg2[i8]));
                                                                            i8++;
                                                                        }
                                                                    }
                                                                    strZzE = zzaluVarZzf.zzE();
                                                                    if (strZzE != null) {
                                                                        map3.put(strZzE, zzaluVarZzf);
                                                                    }
                                                                } else {
                                                                    zzalpVar4 = zzalpVar4;
                                                                    if (zzfz.zzc(xmlPullParserNewPullParser, "region")) {
                                                                        strZza = zzfz.zza(xmlPullParserNewPullParser, "id");
                                                                        if (strZza == null) {
                                                                            str4 = str2;
                                                                            map2 = map3;
                                                                        } else {
                                                                            strZza2 = zzfz.zza(xmlPullParserNewPullParser, "origin");
                                                                            if (strZza2 != null) {
                                                                                pattern = zzb;
                                                                                matcher = pattern.matcher(strZza2);
                                                                                pattern2 = zzf;
                                                                                str4 = str2;
                                                                                matcher2 = pattern2.matcher(strZza2);
                                                                                if (matcher.matches()) {
                                                                                    map2 = map3;
                                                                                    String strGroup1117 = matcher.group(1);
                                                                                    strGroup1117.getClass();
                                                                                    float f1117 = Float.parseFloat(strGroup1117) / 100.0f;
                                                                                    String strGroup1118 = matcher.group(2);
                                                                                    strGroup1118.getClass();
                                                                                    f2 = Float.parseFloat(strGroup1118) / 100.0f;
                                                                                    f = f1117;
                                                                                    strZza3 = zzfz.zza(xmlPullParserNewPullParser, "extent");
                                                                                    if (strZza3 != null) {
                                                                                        matcher3 = pattern.matcher(strZza3);
                                                                                        matcher4 = pattern2.matcher(strZza3);
                                                                                        if (matcher3.matches()) {
                                                                                            String strGroup1119 = matcher3.group(1);
                                                                                            strGroup1119.getClass();
                                                                                            float f1118 = Float.parseFloat(strGroup1119) / 100.0f;
                                                                                            String strGroup11110 = matcher3.group(2);
                                                                                            strGroup11110.getClass();
                                                                                            f3 = Float.parseFloat(strGroup11110) / 100.0f;
                                                                                            f4 = f1118;
                                                                                            strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                                            if (strZza4 != null) {
                                                                                                strZza7 = zzfwk.zza(strZza4);
                                                                                                iHashCode2 = strZza7.hashCode();
                                                                                                if (iHashCode2 != -1364013995) {
                                                                                                    if (iHashCode2 != 92734940) {
                                                                                                        b3 = -1;
                                                                                                    } else {
                                                                                                        b3 = 1;
                                                                                                    }
                                                                                                } else if (strZza7.equals("center")) {
                                                                                                    b3 = 0;
                                                                                                } else {
                                                                                                    b3 = -1;
                                                                                                }
                                                                                                if (b3 != 0) {
                                                                                                    f5 = f2 + (f3 / 2.0f);
                                                                                                    i6 = 1;
                                                                                                } else if (b3 != 1) {
                                                                                                    f5 = f2;
                                                                                                    i6 = 0;
                                                                                                } else {
                                                                                                    f5 = f2 + f3;
                                                                                                    i6 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                f5 = f2;
                                                                                                i6 = 0;
                                                                                            }
                                                                                            float f1119 = 1.0f / i10;
                                                                                            strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                            if (strZza5 != null) {
                                                                                                strZza6 = zzfwk.zza(strZza5);
                                                                                                iHashCode = strZza6.hashCode();
                                                                                                if (iHashCode != 3694) {
                                                                                                    if (iHashCode != 3553396) {
                                                                                                        if (iHashCode != 3553576) {
                                                                                                            b2 = -1;
                                                                                                        } else {
                                                                                                            b2 = 2;
                                                                                                        }
                                                                                                    } else if (strZza6.equals("tblr")) {
                                                                                                        b2 = 1;
                                                                                                    } else {
                                                                                                        b2 = -1;
                                                                                                    }
                                                                                                } else if (strZza6.equals("tb")) {
                                                                                                    b2 = 0;
                                                                                                } else {
                                                                                                    b2 = -1;
                                                                                                }
                                                                                                if (b2 != 0) {
                                                                                                    i7 = 2;
                                                                                                } else {
                                                                                                    i7 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                i7 = Integer.MIN_VALUE;
                                                                                            }
                                                                                            zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f1119, i7);
                                                                                        } else if (matcher4.matches()) {
                                                                                            zzff.zzf("TtmlParser", "Ignoring region with unsupported extent: ".concat(strZza2));
                                                                                        } else if (zzalqVar == null) {
                                                                                            zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                                                        } else {
                                                                                            String strGroup11111 = matcher4.group(1);
                                                                                            strGroup11111.getClass();
                                                                                            int i1110 = Integer.parseInt(strGroup11111);
                                                                                            String strGroup11112 = matcher4.group(2);
                                                                                            strGroup11112.getClass();
                                                                                            int i1111 = Integer.parseInt(strGroup11112);
                                                                                            float f11110 = i1110 / zzalqVar.zza;
                                                                                            f3 = i1111 / zzalqVar.zzb;
                                                                                            f4 = f11110;
                                                                                            strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                                            if (strZza4 != null) {
                                                                                                strZza7 = zzfwk.zza(strZza4);
                                                                                                iHashCode2 = strZza7.hashCode();
                                                                                                if (iHashCode2 != -1364013995) {
                                                                                                    if (iHashCode2 != 92734940) {
                                                                                                        b3 = -1;
                                                                                                    } else {
                                                                                                        b3 = 1;
                                                                                                    }
                                                                                                } else if (strZza7.equals("center")) {
                                                                                                    b3 = 0;
                                                                                                } else {
                                                                                                    b3 = -1;
                                                                                                }
                                                                                                if (b3 != 0) {
                                                                                                    f5 = f2 + (f3 / 2.0f);
                                                                                                    i6 = 1;
                                                                                                } else if (b3 != 1) {
                                                                                                    f5 = f2;
                                                                                                    i6 = 0;
                                                                                                } else {
                                                                                                    f5 = f2 + f3;
                                                                                                    i6 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                f5 = f2;
                                                                                                i6 = 0;
                                                                                            }
                                                                                            float f11111 = 1.0f / i10;
                                                                                            strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                            if (strZza5 != null) {
                                                                                                strZza6 = zzfwk.zza(strZza5);
                                                                                                iHashCode = strZza6.hashCode();
                                                                                                if (iHashCode != 3694) {
                                                                                                    if (iHashCode != 3553396) {
                                                                                                        if (iHashCode != 3553576) {
                                                                                                            b2 = -1;
                                                                                                        } else {
                                                                                                            b2 = 2;
                                                                                                        }
                                                                                                    } else if (strZza6.equals("tblr")) {
                                                                                                        b2 = 1;
                                                                                                    } else {
                                                                                                        b2 = -1;
                                                                                                    }
                                                                                                } else if (strZza6.equals("tb")) {
                                                                                                    b2 = 0;
                                                                                                } else {
                                                                                                    b2 = -1;
                                                                                                }
                                                                                                if (b2 != 0) {
                                                                                                    i7 = 2;
                                                                                                } else {
                                                                                                    i7 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                i7 = Integer.MIN_VALUE;
                                                                                            }
                                                                                            zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f11111, i7);
                                                                                        }
                                                                                        if (zzalsVar != null) {
                                                                                            map4.put(zzalsVar.zza, zzalsVar);
                                                                                        }
                                                                                    } else {
                                                                                        zzff.zzf("TtmlParser", "Ignoring region without an extent");
                                                                                    }
                                                                                } else {
                                                                                    map2 = map3;
                                                                                    if (!matcher2.matches()) {
                                                                                        zzff.zzf("TtmlParser", "Ignoring region with unsupported origin: ".concat(strZza2));
                                                                                    } else if (zzalqVar == null) {
                                                                                        zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                                                    } else {
                                                                                        String strGroup24 = matcher2.group(1);
                                                                                        strGroup24.getClass();
                                                                                        int i24 = Integer.parseInt(strGroup24);
                                                                                        String strGroup11113 = matcher2.group(2);
                                                                                        strGroup11113.getClass();
                                                                                        float f11112 = Integer.parseInt(strGroup11113);
                                                                                        f = i24 / zzalqVar.zza;
                                                                                        f2 = f11112 / zzalqVar.zzb;
                                                                                        strZza3 = zzfz.zza(xmlPullParserNewPullParser, "extent");
                                                                                        if (strZza3 != null) {
                                                                                            matcher3 = pattern.matcher(strZza3);
                                                                                            matcher4 = pattern2.matcher(strZza3);
                                                                                            if (matcher3.matches()) {
                                                                                                String strGroup11114 = matcher3.group(1);
                                                                                                strGroup11114.getClass();
                                                                                                float f11113 = Float.parseFloat(strGroup11114) / 100.0f;
                                                                                                String strGroup11115 = matcher3.group(2);
                                                                                                strGroup11115.getClass();
                                                                                                f3 = Float.parseFloat(strGroup11115) / 100.0f;
                                                                                                f4 = f11113;
                                                                                                strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                                                if (strZza4 != null) {
                                                                                                    strZza7 = zzfwk.zza(strZza4);
                                                                                                    iHashCode2 = strZza7.hashCode();
                                                                                                    if (iHashCode2 != -1364013995) {
                                                                                                        if (iHashCode2 != 92734940) {
                                                                                                            b3 = -1;
                                                                                                        } else {
                                                                                                            b3 = 1;
                                                                                                        }
                                                                                                    } else if (strZza7.equals("center")) {
                                                                                                        b3 = 0;
                                                                                                    } else {
                                                                                                        b3 = -1;
                                                                                                    }
                                                                                                    if (b3 != 0) {
                                                                                                        f5 = f2 + (f3 / 2.0f);
                                                                                                        i6 = 1;
                                                                                                    } else if (b3 != 1) {
                                                                                                        f5 = f2;
                                                                                                        i6 = 0;
                                                                                                    } else {
                                                                                                        f5 = f2 + f3;
                                                                                                        i6 = 2;
                                                                                                    }
                                                                                                } else {
                                                                                                    f5 = f2;
                                                                                                    i6 = 0;
                                                                                                }
                                                                                                float f11114 = 1.0f / i10;
                                                                                                strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                                if (strZza5 != null) {
                                                                                                    strZza6 = zzfwk.zza(strZza5);
                                                                                                    iHashCode = strZza6.hashCode();
                                                                                                    if (iHashCode != 3694) {
                                                                                                        if (iHashCode != 3553396) {
                                                                                                            if (iHashCode != 3553576) {
                                                                                                                b2 = -1;
                                                                                                            } else {
                                                                                                                b2 = 2;
                                                                                                            }
                                                                                                        } else if (strZza6.equals("tblr")) {
                                                                                                            b2 = 1;
                                                                                                        } else {
                                                                                                            b2 = -1;
                                                                                                        }
                                                                                                    } else if (strZza6.equals("tb")) {
                                                                                                        b2 = 0;
                                                                                                    } else {
                                                                                                        b2 = -1;
                                                                                                    }
                                                                                                    if (b2 != 0) {
                                                                                                        i7 = 2;
                                                                                                    } else {
                                                                                                        i7 = 2;
                                                                                                    }
                                                                                                } else {
                                                                                                    i7 = Integer.MIN_VALUE;
                                                                                                }
                                                                                                zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f11114, i7);
                                                                                            } else if (matcher4.matches()) {
                                                                                                zzff.zzf("TtmlParser", "Ignoring region with unsupported extent: ".concat(strZza2));
                                                                                            } else if (zzalqVar == null) {
                                                                                                zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                                                            } else {
                                                                                                String strGroup11116 = matcher4.group(1);
                                                                                                strGroup11116.getClass();
                                                                                                int i1112 = Integer.parseInt(strGroup11116);
                                                                                                String strGroup11117 = matcher4.group(2);
                                                                                                strGroup11117.getClass();
                                                                                                int i1113 = Integer.parseInt(strGroup11117);
                                                                                                float f11115 = i1112 / zzalqVar.zza;
                                                                                                f3 = i1113 / zzalqVar.zzb;
                                                                                                f4 = f11115;
                                                                                                strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                                                if (strZza4 != null) {
                                                                                                    strZza7 = zzfwk.zza(strZza4);
                                                                                                    iHashCode2 = strZza7.hashCode();
                                                                                                    if (iHashCode2 != -1364013995) {
                                                                                                        if (iHashCode2 != 92734940) {
                                                                                                            b3 = -1;
                                                                                                        } else {
                                                                                                            b3 = 1;
                                                                                                        }
                                                                                                    } else if (strZza7.equals("center")) {
                                                                                                        b3 = 0;
                                                                                                    } else {
                                                                                                        b3 = -1;
                                                                                                    }
                                                                                                    if (b3 != 0) {
                                                                                                        f5 = f2 + (f3 / 2.0f);
                                                                                                        i6 = 1;
                                                                                                    } else if (b3 != 1) {
                                                                                                        f5 = f2;
                                                                                                        i6 = 0;
                                                                                                    } else {
                                                                                                        f5 = f2 + f3;
                                                                                                        i6 = 2;
                                                                                                    }
                                                                                                } else {
                                                                                                    f5 = f2;
                                                                                                    i6 = 0;
                                                                                                }
                                                                                                float f11116 = 1.0f / i10;
                                                                                                strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                                if (strZza5 != null) {
                                                                                                    strZza6 = zzfwk.zza(strZza5);
                                                                                                    iHashCode = strZza6.hashCode();
                                                                                                    if (iHashCode != 3694) {
                                                                                                        if (iHashCode != 3553396) {
                                                                                                            if (iHashCode != 3553576) {
                                                                                                                b2 = -1;
                                                                                                            } else {
                                                                                                                b2 = 2;
                                                                                                            }
                                                                                                        } else if (strZza6.equals("tblr")) {
                                                                                                            b2 = 1;
                                                                                                        } else {
                                                                                                            b2 = -1;
                                                                                                        }
                                                                                                    } else if (strZza6.equals("tb")) {
                                                                                                        b2 = 0;
                                                                                                    } else {
                                                                                                        b2 = -1;
                                                                                                    }
                                                                                                    if (b2 != 0) {
                                                                                                        i7 = 2;
                                                                                                    } else {
                                                                                                        i7 = 2;
                                                                                                    }
                                                                                                } else {
                                                                                                    i7 = Integer.MIN_VALUE;
                                                                                                }
                                                                                                zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f11116, i7);
                                                                                            }
                                                                                            if (zzalsVar != null) {
                                                                                                map4.put(zzalsVar.zza, zzalsVar);
                                                                                            }
                                                                                        } else {
                                                                                            zzff.zzf("TtmlParser", "Ignoring region without an extent");
                                                                                        }
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                str4 = str2;
                                                                                map2 = map3;
                                                                                zzff.zzf("TtmlParser", "Ignoring region without an origin");
                                                                            }
                                                                        }
                                                                        zzalsVar = null;
                                                                        if (zzalsVar != null) {
                                                                            map4.put(zzalsVar.zza, zzalsVar);
                                                                        }
                                                                    } else if (zzfz.zzc(xmlPullParserNewPullParser, str2)) {
                                                                        do {
                                                                            xmlPullParserNewPullParser.next();
                                                                            if (zzfz.zzc(xmlPullParserNewPullParser, "image")) {
                                                                                map5.put(strZza8, xmlPullParserNewPullParser.nextText());
                                                                            }
                                                                        } while (!zzfz.zzb(xmlPullParserNewPullParser, str2));
                                                                    }
                                                                    if (zzfz.zzb(xmlPullParserNewPullParser, "head")) {
                                                                        zzalpVar2 = zzalpVar4;
                                                                        arrayDeque = arrayDeque2;
                                                                    } else {
                                                                        zzalpVar4 = zzalpVar4;
                                                                        str2 = str4;
                                                                        map3 = map2;
                                                                    }
                                                                }
                                                                str4 = str2;
                                                                map2 = map3;
                                                                if (zzfz.zzb(xmlPullParserNewPullParser, "head")) {
                                                                    zzalpVar2 = zzalpVar4;
                                                                    arrayDeque = arrayDeque2;
                                                                } else {
                                                                    zzalpVar4 = zzalpVar4;
                                                                    str2 = str4;
                                                                    map3 = map2;
                                                                }
                                                            }
                                                        } else {
                                                            map2 = map3;
                                                            zzalpVar = zzalpVar4;
                                                            attributeCount = xmlPullParserNewPullParser.getAttributeCount();
                                                            zzalu zzaluVarZzf5 = zzf(xmlPullParserNewPullParser, null);
                                                            strArr = null;
                                                            strSubstring = null;
                                                            str3 = str;
                                                            jZzc = -9223372036854775807L;
                                                            jZzc2 = -9223372036854775807L;
                                                            jZzc3 = -9223372036854775807L;
                                                            i5 = 0;
                                                            while (i5 < attributeCount) {
                                                                attributeName = xmlPullParserNewPullParser.getAttributeName(i5);
                                                                attributeValue = xmlPullParserNewPullParser.getAttributeValue(i5);
                                                                switch (attributeName) {
                                                                    case -934795532:
                                                                        if (!attributeName.equals("region")) {
                                                                            b = 4;
                                                                        } else {
                                                                            b = -1;
                                                                        }
                                                                        break;
                                                                    case 99841:
                                                                        if (!attributeName.equals("dur")) {
                                                                            b = 2;
                                                                        } else {
                                                                            b = -1;
                                                                        }
                                                                        break;
                                                                    case 100571:
                                                                        if (!attributeName.equals("end")) {
                                                                            b = 1;
                                                                        } else {
                                                                            b = -1;
                                                                        }
                                                                        break;
                                                                    case 93616297:
                                                                        if (!attributeName.equals("begin")) {
                                                                            b = 0;
                                                                        } else {
                                                                            b = -1;
                                                                        }
                                                                        break;
                                                                    case 109780401:
                                                                        if (!attributeName.equals("style")) {
                                                                            b = 3;
                                                                        } else {
                                                                            b = -1;
                                                                        }
                                                                        break;
                                                                    case 1292595405:
                                                                        if (!attributeName.equals("backgroundImage")) {
                                                                            b = 5;
                                                                        } else {
                                                                            b = -1;
                                                                        }
                                                                        break;
                                                                    default:
                                                                        b = -1;
                                                                        break;
                                                                }
                                                                if (b == 0) {
                                                                    zzalpVar2 = zzalpVar;
                                                                    i4 = 1;
                                                                    jZzc2 = zzc(attributeValue, zzalpVar2);
                                                                } else if (b == 1) {
                                                                    i4 = 1;
                                                                    zzalpVar2 = zzalpVar;
                                                                    jZzc = zzc(attributeValue, zzalpVar2);
                                                                } else if (b != 2) {
                                                                    if (b == 3) {
                                                                        i4 = 1;
                                                                        strArrZzg = zzg(attributeValue);
                                                                        if (strArrZzg.length > 0) {
                                                                            strArr = strArrZzg;
                                                                        }
                                                                    } else if (b == 4) {
                                                                        i4 = 1;
                                                                        if (map4.containsKey(attributeValue)) {
                                                                            str3 = attributeValue;
                                                                        }
                                                                    } else if (b != 5) {
                                                                        i4 = 1;
                                                                    } else if (attributeValue.startsWith("#")) {
                                                                        i4 = 1;
                                                                        strSubstring = attributeValue.substring(1);
                                                                    } else {
                                                                        i4 = 1;
                                                                    }
                                                                    zzalpVar2 = zzalpVar;
                                                                } else {
                                                                    zzalpVar2 = zzalpVar;
                                                                    i4 = 1;
                                                                    jZzc3 = zzc(attributeValue, zzalpVar2);
                                                                }
                                                                i5++;
                                                                zzalpVar = zzalpVar2;
                                                                i4 = 0;
                                                            }
                                                            zzalpVar2 = zzalpVar;
                                                            i4 = 1;
                                                            if (zzaloVar2 != null) {
                                                                j3 = zzaloVar2.zzd;
                                                                if (j3 == -9223372036854775807L) {
                                                                    zzaloVar = zzaloVar2;
                                                                } else {
                                                                    if (jZzc2 != -9223372036854775807L) {
                                                                        jZzc2 += j3;
                                                                    } else {
                                                                        jZzc2 = -9223372036854775807L;
                                                                    }
                                                                    if (jZzc != -9223372036854775807L) {
                                                                        jZzc += j3;
                                                                        zzaloVar = zzaloVar2;
                                                                    } else {
                                                                        zzaloVar = zzaloVar2;
                                                                        jZzc = -9223372036854775807L;
                                                                    }
                                                                }
                                                            } else {
                                                                zzaloVar = null;
                                                            }
                                                            if (jZzc != -9223372036854775807L) {
                                                                j = jZzc;
                                                            } else if (jZzc3 != -9223372036854775807L) {
                                                                j = jZzc2 + jZzc3;
                                                            } else if (zzaloVar != null) {
                                                                j2 = zzaloVar.zze;
                                                                if (j2 != -9223372036854775807L) {
                                                                    j = j2;
                                                                } else {
                                                                    j = -9223372036854775807L;
                                                                }
                                                            } else {
                                                                j = -9223372036854775807L;
                                                            }
                                                            zzaloVarZzb = zzalo.zzb(xmlPullParserNewPullParser.getName(), jZzc2, j, zzaluVarZzf5, strArr, str3, strSubstring, zzaloVar);
                                                            arrayDeque = arrayDeque2;
                                                            arrayDeque.push(zzaloVarZzb);
                                                            if (zzaloVar2 != null) {
                                                                zzaloVar2.zzf(zzaloVarZzb);
                                                            }
                                                        }
                                                        zzalpVar4 = zzalpVar2;
                                                        i9 = i9;
                                                        map = map2;
                                                    }
                                                } else {
                                                    zzff.zzf("TtmlParser", "Ignoring non-pixel tts extent: ".concat(strZza10));
                                                }
                                                zzalqVar = null;
                                                zzalpVar4 = zzalpVar3;
                                                str2 = "metadata";
                                                if (name.equals("tt")) {
                                                    if ("head".equals(name)) {
                                                        while (true) {
                                                            xmlPullParserNewPullParser.next();
                                                            if (zzfz.zzc(xmlPullParserNewPullParser, "style")) {
                                                                strZza9 = zzfz.zza(xmlPullParserNewPullParser, "style");
                                                                zzaluVarZzf = zzf(xmlPullParserNewPullParser, new zzalu());
                                                                if (strZza9 != null) {
                                                                    strArrZzg2 = zzg(strZza9);
                                                                    i8 = 0;
                                                                    while (i8 < length) {
                                                                        zzaluVarZzf.zzl((zzalu) map3.get(strArrZzg2[i8]));
                                                                        i8++;
                                                                    }
                                                                }
                                                                strZzE = zzaluVarZzf.zzE();
                                                                if (strZzE != null) {
                                                                    map3.put(strZzE, zzaluVarZzf);
                                                                }
                                                            } else {
                                                                zzalpVar4 = zzalpVar4;
                                                                if (zzfz.zzc(xmlPullParserNewPullParser, "region")) {
                                                                    strZza = zzfz.zza(xmlPullParserNewPullParser, "id");
                                                                    if (strZza == null) {
                                                                        str4 = str2;
                                                                        map2 = map3;
                                                                    } else {
                                                                        strZza2 = zzfz.zza(xmlPullParserNewPullParser, "origin");
                                                                        if (strZza2 != null) {
                                                                            pattern = zzb;
                                                                            matcher = pattern.matcher(strZza2);
                                                                            pattern2 = zzf;
                                                                            str4 = str2;
                                                                            matcher2 = pattern2.matcher(strZza2);
                                                                            if (matcher.matches()) {
                                                                                map2 = map3;
                                                                                String strGroup11118 = matcher.group(1);
                                                                                strGroup11118.getClass();
                                                                                float f11117 = Float.parseFloat(strGroup11118) / 100.0f;
                                                                                String strGroup11119 = matcher.group(2);
                                                                                strGroup11119.getClass();
                                                                                f2 = Float.parseFloat(strGroup11119) / 100.0f;
                                                                                f = f11117;
                                                                                strZza3 = zzfz.zza(xmlPullParserNewPullParser, "extent");
                                                                                if (strZza3 != null) {
                                                                                    matcher3 = pattern.matcher(strZza3);
                                                                                    matcher4 = pattern2.matcher(strZza3);
                                                                                    if (matcher3.matches()) {
                                                                                        String strGroup111110 = matcher3.group(1);
                                                                                        strGroup111110.getClass();
                                                                                        float f11118 = Float.parseFloat(strGroup111110) / 100.0f;
                                                                                        String strGroup111111 = matcher3.group(2);
                                                                                        strGroup111111.getClass();
                                                                                        f3 = Float.parseFloat(strGroup111111) / 100.0f;
                                                                                        f4 = f11118;
                                                                                        strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                                        if (strZza4 != null) {
                                                                                            strZza7 = zzfwk.zza(strZza4);
                                                                                            iHashCode2 = strZza7.hashCode();
                                                                                            if (iHashCode2 != -1364013995) {
                                                                                                if (iHashCode2 != 92734940) {
                                                                                                    b3 = -1;
                                                                                                } else {
                                                                                                    b3 = 1;
                                                                                                }
                                                                                            } else if (strZza7.equals("center")) {
                                                                                                b3 = 0;
                                                                                            } else {
                                                                                                b3 = -1;
                                                                                            }
                                                                                            if (b3 != 0) {
                                                                                                f5 = f2 + (f3 / 2.0f);
                                                                                                i6 = 1;
                                                                                            } else if (b3 != 1) {
                                                                                                f5 = f2;
                                                                                                i6 = 0;
                                                                                            } else {
                                                                                                f5 = f2 + f3;
                                                                                                i6 = 2;
                                                                                            }
                                                                                        } else {
                                                                                            f5 = f2;
                                                                                            i6 = 0;
                                                                                        }
                                                                                        float f11119 = 1.0f / i10;
                                                                                        strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                        if (strZza5 != null) {
                                                                                            strZza6 = zzfwk.zza(strZza5);
                                                                                            iHashCode = strZza6.hashCode();
                                                                                            if (iHashCode != 3694) {
                                                                                                if (iHashCode != 3553396) {
                                                                                                    if (iHashCode != 3553576) {
                                                                                                        b2 = -1;
                                                                                                    } else {
                                                                                                        b2 = 2;
                                                                                                    }
                                                                                                } else if (strZza6.equals("tblr")) {
                                                                                                    b2 = 1;
                                                                                                } else {
                                                                                                    b2 = -1;
                                                                                                }
                                                                                            } else if (strZza6.equals("tb")) {
                                                                                                b2 = 0;
                                                                                            } else {
                                                                                                b2 = -1;
                                                                                            }
                                                                                            if (b2 != 0) {
                                                                                                i7 = 2;
                                                                                            } else {
                                                                                                i7 = 2;
                                                                                            }
                                                                                        } else {
                                                                                            i7 = Integer.MIN_VALUE;
                                                                                        }
                                                                                        zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f11119, i7);
                                                                                    } else if (matcher4.matches()) {
                                                                                        zzff.zzf("TtmlParser", "Ignoring region with unsupported extent: ".concat(strZza2));
                                                                                    } else if (zzalqVar == null) {
                                                                                        zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                                                    } else {
                                                                                        String strGroup111112 = matcher4.group(1);
                                                                                        strGroup111112.getClass();
                                                                                        int i1114 = Integer.parseInt(strGroup111112);
                                                                                        String strGroup111113 = matcher4.group(2);
                                                                                        strGroup111113.getClass();
                                                                                        int i1115 = Integer.parseInt(strGroup111113);
                                                                                        float f111110 = i1114 / zzalqVar.zza;
                                                                                        f3 = i1115 / zzalqVar.zzb;
                                                                                        f4 = f111110;
                                                                                        strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                                        if (strZza4 != null) {
                                                                                            strZza7 = zzfwk.zza(strZza4);
                                                                                            iHashCode2 = strZza7.hashCode();
                                                                                            if (iHashCode2 != -1364013995) {
                                                                                                if (iHashCode2 != 92734940) {
                                                                                                    b3 = -1;
                                                                                                } else {
                                                                                                    b3 = 1;
                                                                                                }
                                                                                            } else if (strZza7.equals("center")) {
                                                                                                b3 = 0;
                                                                                            } else {
                                                                                                b3 = -1;
                                                                                            }
                                                                                            if (b3 != 0) {
                                                                                                f5 = f2 + (f3 / 2.0f);
                                                                                                i6 = 1;
                                                                                            } else if (b3 != 1) {
                                                                                                f5 = f2;
                                                                                                i6 = 0;
                                                                                            } else {
                                                                                                f5 = f2 + f3;
                                                                                                i6 = 2;
                                                                                            }
                                                                                        } else {
                                                                                            f5 = f2;
                                                                                            i6 = 0;
                                                                                        }
                                                                                        float f111111 = 1.0f / i10;
                                                                                        strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                        if (strZza5 != null) {
                                                                                            strZza6 = zzfwk.zza(strZza5);
                                                                                            iHashCode = strZza6.hashCode();
                                                                                            if (iHashCode != 3694) {
                                                                                                if (iHashCode != 3553396) {
                                                                                                    if (iHashCode != 3553576) {
                                                                                                        b2 = -1;
                                                                                                    } else {
                                                                                                        b2 = 2;
                                                                                                    }
                                                                                                } else if (strZza6.equals("tblr")) {
                                                                                                    b2 = 1;
                                                                                                } else {
                                                                                                    b2 = -1;
                                                                                                }
                                                                                            } else if (strZza6.equals("tb")) {
                                                                                                b2 = 0;
                                                                                            } else {
                                                                                                b2 = -1;
                                                                                            }
                                                                                            if (b2 != 0) {
                                                                                                i7 = 2;
                                                                                            } else {
                                                                                                i7 = 2;
                                                                                            }
                                                                                        } else {
                                                                                            i7 = Integer.MIN_VALUE;
                                                                                        }
                                                                                        zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f111111, i7);
                                                                                    }
                                                                                    if (zzalsVar != null) {
                                                                                        map4.put(zzalsVar.zza, zzalsVar);
                                                                                    }
                                                                                } else {
                                                                                    zzff.zzf("TtmlParser", "Ignoring region without an extent");
                                                                                }
                                                                            } else {
                                                                                map2 = map3;
                                                                                if (!matcher2.matches()) {
                                                                                    zzff.zzf("TtmlParser", "Ignoring region with unsupported origin: ".concat(strZza2));
                                                                                } else if (zzalqVar == null) {
                                                                                    zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                                                } else {
                                                                                    String strGroup25 = matcher2.group(1);
                                                                                    strGroup25.getClass();
                                                                                    int i25 = Integer.parseInt(strGroup25);
                                                                                    String strGroup111114 = matcher2.group(2);
                                                                                    strGroup111114.getClass();
                                                                                    float f111112 = Integer.parseInt(strGroup111114);
                                                                                    f = i25 / zzalqVar.zza;
                                                                                    f2 = f111112 / zzalqVar.zzb;
                                                                                    strZza3 = zzfz.zza(xmlPullParserNewPullParser, "extent");
                                                                                    if (strZza3 != null) {
                                                                                        matcher3 = pattern.matcher(strZza3);
                                                                                        matcher4 = pattern2.matcher(strZza3);
                                                                                        if (matcher3.matches()) {
                                                                                            String strGroup111115 = matcher3.group(1);
                                                                                            strGroup111115.getClass();
                                                                                            float f111113 = Float.parseFloat(strGroup111115) / 100.0f;
                                                                                            String strGroup111116 = matcher3.group(2);
                                                                                            strGroup111116.getClass();
                                                                                            f3 = Float.parseFloat(strGroup111116) / 100.0f;
                                                                                            f4 = f111113;
                                                                                            strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                                            if (strZza4 != null) {
                                                                                                strZza7 = zzfwk.zza(strZza4);
                                                                                                iHashCode2 = strZza7.hashCode();
                                                                                                if (iHashCode2 != -1364013995) {
                                                                                                    if (iHashCode2 != 92734940) {
                                                                                                        b3 = -1;
                                                                                                    } else {
                                                                                                        b3 = 1;
                                                                                                    }
                                                                                                } else if (strZza7.equals("center")) {
                                                                                                    b3 = 0;
                                                                                                } else {
                                                                                                    b3 = -1;
                                                                                                }
                                                                                                if (b3 != 0) {
                                                                                                    f5 = f2 + (f3 / 2.0f);
                                                                                                    i6 = 1;
                                                                                                } else if (b3 != 1) {
                                                                                                    f5 = f2;
                                                                                                    i6 = 0;
                                                                                                } else {
                                                                                                    f5 = f2 + f3;
                                                                                                    i6 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                f5 = f2;
                                                                                                i6 = 0;
                                                                                            }
                                                                                            float f111114 = 1.0f / i10;
                                                                                            strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                            if (strZza5 != null) {
                                                                                                strZza6 = zzfwk.zza(strZza5);
                                                                                                iHashCode = strZza6.hashCode();
                                                                                                if (iHashCode != 3694) {
                                                                                                    if (iHashCode != 3553396) {
                                                                                                        if (iHashCode != 3553576) {
                                                                                                            b2 = -1;
                                                                                                        } else {
                                                                                                            b2 = 2;
                                                                                                        }
                                                                                                    } else if (strZza6.equals("tblr")) {
                                                                                                        b2 = 1;
                                                                                                    } else {
                                                                                                        b2 = -1;
                                                                                                    }
                                                                                                } else if (strZza6.equals("tb")) {
                                                                                                    b2 = 0;
                                                                                                } else {
                                                                                                    b2 = -1;
                                                                                                }
                                                                                                if (b2 != 0) {
                                                                                                    i7 = 2;
                                                                                                } else {
                                                                                                    i7 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                i7 = Integer.MIN_VALUE;
                                                                                            }
                                                                                            zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f111114, i7);
                                                                                        } else if (matcher4.matches()) {
                                                                                            zzff.zzf("TtmlParser", "Ignoring region with unsupported extent: ".concat(strZza2));
                                                                                        } else if (zzalqVar == null) {
                                                                                            zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                                                        } else {
                                                                                            String strGroup111117 = matcher4.group(1);
                                                                                            strGroup111117.getClass();
                                                                                            int i1116 = Integer.parseInt(strGroup111117);
                                                                                            String strGroup111118 = matcher4.group(2);
                                                                                            strGroup111118.getClass();
                                                                                            int i1117 = Integer.parseInt(strGroup111118);
                                                                                            float f111115 = i1116 / zzalqVar.zza;
                                                                                            f3 = i1117 / zzalqVar.zzb;
                                                                                            f4 = f111115;
                                                                                            strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                                            if (strZza4 != null) {
                                                                                                strZza7 = zzfwk.zza(strZza4);
                                                                                                iHashCode2 = strZza7.hashCode();
                                                                                                if (iHashCode2 != -1364013995) {
                                                                                                    if (iHashCode2 != 92734940) {
                                                                                                        b3 = -1;
                                                                                                    } else {
                                                                                                        b3 = 1;
                                                                                                    }
                                                                                                } else if (strZza7.equals("center")) {
                                                                                                    b3 = 0;
                                                                                                } else {
                                                                                                    b3 = -1;
                                                                                                }
                                                                                                if (b3 != 0) {
                                                                                                    f5 = f2 + (f3 / 2.0f);
                                                                                                    i6 = 1;
                                                                                                } else if (b3 != 1) {
                                                                                                    f5 = f2;
                                                                                                    i6 = 0;
                                                                                                } else {
                                                                                                    f5 = f2 + f3;
                                                                                                    i6 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                f5 = f2;
                                                                                                i6 = 0;
                                                                                            }
                                                                                            float f111116 = 1.0f / i10;
                                                                                            strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                            if (strZza5 != null) {
                                                                                                strZza6 = zzfwk.zza(strZza5);
                                                                                                iHashCode = strZza6.hashCode();
                                                                                                if (iHashCode != 3694) {
                                                                                                    if (iHashCode != 3553396) {
                                                                                                        if (iHashCode != 3553576) {
                                                                                                            b2 = -1;
                                                                                                        } else {
                                                                                                            b2 = 2;
                                                                                                        }
                                                                                                    } else if (strZza6.equals("tblr")) {
                                                                                                        b2 = 1;
                                                                                                    } else {
                                                                                                        b2 = -1;
                                                                                                    }
                                                                                                } else if (strZza6.equals("tb")) {
                                                                                                    b2 = 0;
                                                                                                } else {
                                                                                                    b2 = -1;
                                                                                                }
                                                                                                if (b2 != 0) {
                                                                                                    i7 = 2;
                                                                                                } else {
                                                                                                    i7 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                i7 = Integer.MIN_VALUE;
                                                                                            }
                                                                                            zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f111116, i7);
                                                                                        }
                                                                                        if (zzalsVar != null) {
                                                                                            map4.put(zzalsVar.zza, zzalsVar);
                                                                                        }
                                                                                    } else {
                                                                                        zzff.zzf("TtmlParser", "Ignoring region without an extent");
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else {
                                                                            str4 = str2;
                                                                            map2 = map3;
                                                                            zzff.zzf("TtmlParser", "Ignoring region without an origin");
                                                                        }
                                                                    }
                                                                    zzalsVar = null;
                                                                    if (zzalsVar != null) {
                                                                        map4.put(zzalsVar.zza, zzalsVar);
                                                                    }
                                                                } else if (zzfz.zzc(xmlPullParserNewPullParser, str2)) {
                                                                    do {
                                                                        xmlPullParserNewPullParser.next();
                                                                        if (zzfz.zzc(xmlPullParserNewPullParser, "image")) {
                                                                            map5.put(strZza8, xmlPullParserNewPullParser.nextText());
                                                                        }
                                                                    } while (!zzfz.zzb(xmlPullParserNewPullParser, str2));
                                                                }
                                                                if (zzfz.zzb(xmlPullParserNewPullParser, "head")) {
                                                                    zzalpVar2 = zzalpVar4;
                                                                    arrayDeque = arrayDeque2;
                                                                } else {
                                                                    zzalpVar4 = zzalpVar4;
                                                                    str2 = str4;
                                                                    map3 = map2;
                                                                }
                                                            }
                                                            str4 = str2;
                                                            map2 = map3;
                                                            if (zzfz.zzb(xmlPullParserNewPullParser, "head")) {
                                                                zzalpVar2 = zzalpVar4;
                                                                arrayDeque = arrayDeque2;
                                                            } else {
                                                                zzalpVar4 = zzalpVar4;
                                                                str2 = str4;
                                                                map3 = map2;
                                                            }
                                                        }
                                                    } else {
                                                        map2 = map3;
                                                        zzalpVar = zzalpVar4;
                                                        attributeCount = xmlPullParserNewPullParser.getAttributeCount();
                                                        zzalu zzaluVarZzf6 = zzf(xmlPullParserNewPullParser, null);
                                                        strArr = null;
                                                        strSubstring = null;
                                                        str3 = str;
                                                        jZzc = -9223372036854775807L;
                                                        jZzc2 = -9223372036854775807L;
                                                        jZzc3 = -9223372036854775807L;
                                                        i5 = 0;
                                                        while (i5 < attributeCount) {
                                                            attributeName = xmlPullParserNewPullParser.getAttributeName(i5);
                                                            attributeValue = xmlPullParserNewPullParser.getAttributeValue(i5);
                                                            switch (attributeName) {
                                                                case -934795532:
                                                                    if (!attributeName.equals("region")) {
                                                                        b = 4;
                                                                    } else {
                                                                        b = -1;
                                                                    }
                                                                    break;
                                                                case 99841:
                                                                    if (!attributeName.equals("dur")) {
                                                                        b = 2;
                                                                    } else {
                                                                        b = -1;
                                                                    }
                                                                    break;
                                                                case 100571:
                                                                    if (!attributeName.equals("end")) {
                                                                        b = 1;
                                                                    } else {
                                                                        b = -1;
                                                                    }
                                                                    break;
                                                                case 93616297:
                                                                    if (!attributeName.equals("begin")) {
                                                                        b = 0;
                                                                    } else {
                                                                        b = -1;
                                                                    }
                                                                    break;
                                                                case 109780401:
                                                                    if (!attributeName.equals("style")) {
                                                                        b = 3;
                                                                    } else {
                                                                        b = -1;
                                                                    }
                                                                    break;
                                                                case 1292595405:
                                                                    if (!attributeName.equals("backgroundImage")) {
                                                                        b = 5;
                                                                    } else {
                                                                        b = -1;
                                                                    }
                                                                    break;
                                                                default:
                                                                    b = -1;
                                                                    break;
                                                            }
                                                            if (b == 0) {
                                                                zzalpVar2 = zzalpVar;
                                                                i4 = 1;
                                                                jZzc2 = zzc(attributeValue, zzalpVar2);
                                                            } else if (b == 1) {
                                                                i4 = 1;
                                                                zzalpVar2 = zzalpVar;
                                                                jZzc = zzc(attributeValue, zzalpVar2);
                                                            } else if (b != 2) {
                                                                if (b == 3) {
                                                                    i4 = 1;
                                                                    strArrZzg = zzg(attributeValue);
                                                                    if (strArrZzg.length > 0) {
                                                                        strArr = strArrZzg;
                                                                    }
                                                                } else if (b == 4) {
                                                                    i4 = 1;
                                                                    if (map4.containsKey(attributeValue)) {
                                                                        str3 = attributeValue;
                                                                    }
                                                                } else if (b != 5) {
                                                                    i4 = 1;
                                                                } else if (attributeValue.startsWith("#")) {
                                                                    i4 = 1;
                                                                    strSubstring = attributeValue.substring(1);
                                                                } else {
                                                                    i4 = 1;
                                                                }
                                                                zzalpVar2 = zzalpVar;
                                                            } else {
                                                                zzalpVar2 = zzalpVar;
                                                                i4 = 1;
                                                                jZzc3 = zzc(attributeValue, zzalpVar2);
                                                            }
                                                            i5++;
                                                            zzalpVar = zzalpVar2;
                                                            i4 = 0;
                                                        }
                                                        zzalpVar2 = zzalpVar;
                                                        i4 = 1;
                                                        if (zzaloVar2 != null) {
                                                            j3 = zzaloVar2.zzd;
                                                            if (j3 == -9223372036854775807L) {
                                                                zzaloVar = zzaloVar2;
                                                            } else {
                                                                if (jZzc2 != -9223372036854775807L) {
                                                                    jZzc2 += j3;
                                                                } else {
                                                                    jZzc2 = -9223372036854775807L;
                                                                }
                                                                if (jZzc != -9223372036854775807L) {
                                                                    jZzc += j3;
                                                                    zzaloVar = zzaloVar2;
                                                                } else {
                                                                    zzaloVar = zzaloVar2;
                                                                    jZzc = -9223372036854775807L;
                                                                }
                                                            }
                                                        } else {
                                                            zzaloVar = null;
                                                        }
                                                        if (jZzc != -9223372036854775807L) {
                                                            j = jZzc;
                                                        } else if (jZzc3 != -9223372036854775807L) {
                                                            j = jZzc2 + jZzc3;
                                                        } else if (zzaloVar != null) {
                                                            j2 = zzaloVar.zze;
                                                            if (j2 != -9223372036854775807L) {
                                                                j = j2;
                                                            } else {
                                                                j = -9223372036854775807L;
                                                            }
                                                        } else {
                                                            j = -9223372036854775807L;
                                                        }
                                                        zzaloVarZzb = zzalo.zzb(xmlPullParserNewPullParser.getName(), jZzc2, j, zzaluVarZzf6, strArr, str3, strSubstring, zzaloVar);
                                                        arrayDeque = arrayDeque2;
                                                        arrayDeque.push(zzaloVarZzb);
                                                        if (zzaloVar2 != null) {
                                                            zzaloVar2.zzf(zzaloVarZzb);
                                                        }
                                                    }
                                                    zzalpVar4 = zzalpVar2;
                                                    i9 = i9;
                                                    map = map2;
                                                } else {
                                                    if ("head".equals(name)) {
                                                        while (true) {
                                                            xmlPullParserNewPullParser.next();
                                                            if (zzfz.zzc(xmlPullParserNewPullParser, "style")) {
                                                                strZza9 = zzfz.zza(xmlPullParserNewPullParser, "style");
                                                                zzaluVarZzf = zzf(xmlPullParserNewPullParser, new zzalu());
                                                                if (strZza9 != null) {
                                                                    strArrZzg2 = zzg(strZza9);
                                                                    i8 = 0;
                                                                    while (i8 < length) {
                                                                        zzaluVarZzf.zzl((zzalu) map3.get(strArrZzg2[i8]));
                                                                        i8++;
                                                                    }
                                                                }
                                                                strZzE = zzaluVarZzf.zzE();
                                                                if (strZzE != null) {
                                                                    map3.put(strZzE, zzaluVarZzf);
                                                                }
                                                            } else {
                                                                zzalpVar4 = zzalpVar4;
                                                                if (zzfz.zzc(xmlPullParserNewPullParser, "region")) {
                                                                    strZza = zzfz.zza(xmlPullParserNewPullParser, "id");
                                                                    if (strZza == null) {
                                                                        str4 = str2;
                                                                        map2 = map3;
                                                                    } else {
                                                                        strZza2 = zzfz.zza(xmlPullParserNewPullParser, "origin");
                                                                        if (strZza2 != null) {
                                                                            pattern = zzb;
                                                                            matcher = pattern.matcher(strZza2);
                                                                            pattern2 = zzf;
                                                                            str4 = str2;
                                                                            matcher2 = pattern2.matcher(strZza2);
                                                                            if (matcher.matches()) {
                                                                                map2 = map3;
                                                                                String strGroup111119 = matcher.group(1);
                                                                                strGroup111119.getClass();
                                                                                float f111117 = Float.parseFloat(strGroup111119) / 100.0f;
                                                                                String strGroup111120 = matcher.group(2);
                                                                                strGroup111120.getClass();
                                                                                f2 = Float.parseFloat(strGroup111120) / 100.0f;
                                                                                f = f111117;
                                                                                strZza3 = zzfz.zza(xmlPullParserNewPullParser, "extent");
                                                                                if (strZza3 != null) {
                                                                                    matcher3 = pattern.matcher(strZza3);
                                                                                    matcher4 = pattern2.matcher(strZza3);
                                                                                    if (matcher3.matches()) {
                                                                                        String strGroup1111110 = matcher3.group(1);
                                                                                        strGroup1111110.getClass();
                                                                                        float f111118 = Float.parseFloat(strGroup1111110) / 100.0f;
                                                                                        String strGroup1111111 = matcher3.group(2);
                                                                                        strGroup1111111.getClass();
                                                                                        f3 = Float.parseFloat(strGroup1111111) / 100.0f;
                                                                                        f4 = f111118;
                                                                                        strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                                        if (strZza4 != null) {
                                                                                            strZza7 = zzfwk.zza(strZza4);
                                                                                            iHashCode2 = strZza7.hashCode();
                                                                                            if (iHashCode2 != -1364013995) {
                                                                                                if (iHashCode2 != 92734940) {
                                                                                                    b3 = -1;
                                                                                                } else {
                                                                                                    b3 = 1;
                                                                                                }
                                                                                            } else if (strZza7.equals("center")) {
                                                                                                b3 = 0;
                                                                                            } else {
                                                                                                b3 = -1;
                                                                                            }
                                                                                            if (b3 != 0) {
                                                                                                f5 = f2 + (f3 / 2.0f);
                                                                                                i6 = 1;
                                                                                            } else if (b3 != 1) {
                                                                                                f5 = f2;
                                                                                                i6 = 0;
                                                                                            } else {
                                                                                                f5 = f2 + f3;
                                                                                                i6 = 2;
                                                                                            }
                                                                                        } else {
                                                                                            f5 = f2;
                                                                                            i6 = 0;
                                                                                        }
                                                                                        float f111119 = 1.0f / i10;
                                                                                        strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                        if (strZza5 != null) {
                                                                                            strZza6 = zzfwk.zza(strZza5);
                                                                                            iHashCode = strZza6.hashCode();
                                                                                            if (iHashCode != 3694) {
                                                                                                if (iHashCode != 3553396) {
                                                                                                    if (iHashCode != 3553576) {
                                                                                                        b2 = -1;
                                                                                                    } else {
                                                                                                        b2 = 2;
                                                                                                    }
                                                                                                } else if (strZza6.equals("tblr")) {
                                                                                                    b2 = 1;
                                                                                                } else {
                                                                                                    b2 = -1;
                                                                                                }
                                                                                            } else if (strZza6.equals("tb")) {
                                                                                                b2 = 0;
                                                                                            } else {
                                                                                                b2 = -1;
                                                                                            }
                                                                                            if (b2 != 0) {
                                                                                                i7 = 2;
                                                                                            } else {
                                                                                                i7 = 2;
                                                                                            }
                                                                                        } else {
                                                                                            i7 = Integer.MIN_VALUE;
                                                                                        }
                                                                                        zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f111119, i7);
                                                                                    } else if (matcher4.matches()) {
                                                                                        zzff.zzf("TtmlParser", "Ignoring region with unsupported extent: ".concat(strZza2));
                                                                                    } else if (zzalqVar == null) {
                                                                                        zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                                                    } else {
                                                                                        String strGroup1111112 = matcher4.group(1);
                                                                                        strGroup1111112.getClass();
                                                                                        int i1118 = Integer.parseInt(strGroup1111112);
                                                                                        String strGroup1111113 = matcher4.group(2);
                                                                                        strGroup1111113.getClass();
                                                                                        int i1119 = Integer.parseInt(strGroup1111113);
                                                                                        float f1111110 = i1118 / zzalqVar.zza;
                                                                                        f3 = i1119 / zzalqVar.zzb;
                                                                                        f4 = f1111110;
                                                                                        strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                                        if (strZza4 != null) {
                                                                                            strZza7 = zzfwk.zza(strZza4);
                                                                                            iHashCode2 = strZza7.hashCode();
                                                                                            if (iHashCode2 != -1364013995) {
                                                                                                if (iHashCode2 != 92734940) {
                                                                                                    b3 = -1;
                                                                                                } else {
                                                                                                    b3 = 1;
                                                                                                }
                                                                                            } else if (strZza7.equals("center")) {
                                                                                                b3 = 0;
                                                                                            } else {
                                                                                                b3 = -1;
                                                                                            }
                                                                                            if (b3 != 0) {
                                                                                                f5 = f2 + (f3 / 2.0f);
                                                                                                i6 = 1;
                                                                                            } else if (b3 != 1) {
                                                                                                f5 = f2;
                                                                                                i6 = 0;
                                                                                            } else {
                                                                                                f5 = f2 + f3;
                                                                                                i6 = 2;
                                                                                            }
                                                                                        } else {
                                                                                            f5 = f2;
                                                                                            i6 = 0;
                                                                                        }
                                                                                        float f1111111 = 1.0f / i10;
                                                                                        strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                        if (strZza5 != null) {
                                                                                            strZza6 = zzfwk.zza(strZza5);
                                                                                            iHashCode = strZza6.hashCode();
                                                                                            if (iHashCode != 3694) {
                                                                                                if (iHashCode != 3553396) {
                                                                                                    if (iHashCode != 3553576) {
                                                                                                        b2 = -1;
                                                                                                    } else {
                                                                                                        b2 = 2;
                                                                                                    }
                                                                                                } else if (strZza6.equals("tblr")) {
                                                                                                    b2 = 1;
                                                                                                } else {
                                                                                                    b2 = -1;
                                                                                                }
                                                                                            } else if (strZza6.equals("tb")) {
                                                                                                b2 = 0;
                                                                                            } else {
                                                                                                b2 = -1;
                                                                                            }
                                                                                            if (b2 != 0) {
                                                                                                i7 = 2;
                                                                                            } else {
                                                                                                i7 = 2;
                                                                                            }
                                                                                        } else {
                                                                                            i7 = Integer.MIN_VALUE;
                                                                                        }
                                                                                        zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f1111111, i7);
                                                                                    }
                                                                                    if (zzalsVar != null) {
                                                                                        map4.put(zzalsVar.zza, zzalsVar);
                                                                                    }
                                                                                } else {
                                                                                    zzff.zzf("TtmlParser", "Ignoring region without an extent");
                                                                                }
                                                                            } else {
                                                                                map2 = map3;
                                                                                if (!matcher2.matches()) {
                                                                                    zzff.zzf("TtmlParser", "Ignoring region with unsupported origin: ".concat(strZza2));
                                                                                } else if (zzalqVar == null) {
                                                                                    zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                                                } else {
                                                                                    String strGroup26 = matcher2.group(1);
                                                                                    strGroup26.getClass();
                                                                                    int i26 = Integer.parseInt(strGroup26);
                                                                                    String strGroup1111114 = matcher2.group(2);
                                                                                    strGroup1111114.getClass();
                                                                                    float f1111112 = Integer.parseInt(strGroup1111114);
                                                                                    f = i26 / zzalqVar.zza;
                                                                                    f2 = f1111112 / zzalqVar.zzb;
                                                                                    strZza3 = zzfz.zza(xmlPullParserNewPullParser, "extent");
                                                                                    if (strZza3 != null) {
                                                                                        matcher3 = pattern.matcher(strZza3);
                                                                                        matcher4 = pattern2.matcher(strZza3);
                                                                                        if (matcher3.matches()) {
                                                                                            String strGroup1111115 = matcher3.group(1);
                                                                                            strGroup1111115.getClass();
                                                                                            float f1111113 = Float.parseFloat(strGroup1111115) / 100.0f;
                                                                                            String strGroup1111116 = matcher3.group(2);
                                                                                            strGroup1111116.getClass();
                                                                                            f3 = Float.parseFloat(strGroup1111116) / 100.0f;
                                                                                            f4 = f1111113;
                                                                                            strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                                            if (strZza4 != null) {
                                                                                                strZza7 = zzfwk.zza(strZza4);
                                                                                                iHashCode2 = strZza7.hashCode();
                                                                                                if (iHashCode2 != -1364013995) {
                                                                                                    if (iHashCode2 != 92734940) {
                                                                                                        b3 = -1;
                                                                                                    } else {
                                                                                                        b3 = 1;
                                                                                                    }
                                                                                                } else if (strZza7.equals("center")) {
                                                                                                    b3 = 0;
                                                                                                } else {
                                                                                                    b3 = -1;
                                                                                                }
                                                                                                if (b3 != 0) {
                                                                                                    f5 = f2 + (f3 / 2.0f);
                                                                                                    i6 = 1;
                                                                                                } else if (b3 != 1) {
                                                                                                    f5 = f2;
                                                                                                    i6 = 0;
                                                                                                } else {
                                                                                                    f5 = f2 + f3;
                                                                                                    i6 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                f5 = f2;
                                                                                                i6 = 0;
                                                                                            }
                                                                                            float f1111114 = 1.0f / i10;
                                                                                            strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                            if (strZza5 != null) {
                                                                                                strZza6 = zzfwk.zza(strZza5);
                                                                                                iHashCode = strZza6.hashCode();
                                                                                                if (iHashCode != 3694) {
                                                                                                    if (iHashCode != 3553396) {
                                                                                                        if (iHashCode != 3553576) {
                                                                                                            b2 = -1;
                                                                                                        } else {
                                                                                                            b2 = 2;
                                                                                                        }
                                                                                                    } else if (strZza6.equals("tblr")) {
                                                                                                        b2 = 1;
                                                                                                    } else {
                                                                                                        b2 = -1;
                                                                                                    }
                                                                                                } else if (strZza6.equals("tb")) {
                                                                                                    b2 = 0;
                                                                                                } else {
                                                                                                    b2 = -1;
                                                                                                }
                                                                                                if (b2 != 0) {
                                                                                                    i7 = 2;
                                                                                                } else {
                                                                                                    i7 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                i7 = Integer.MIN_VALUE;
                                                                                            }
                                                                                            zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f1111114, i7);
                                                                                        } else if (matcher4.matches()) {
                                                                                            zzff.zzf("TtmlParser", "Ignoring region with unsupported extent: ".concat(strZza2));
                                                                                        } else if (zzalqVar == null) {
                                                                                            zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                                                        } else {
                                                                                            String strGroup1111117 = matcher4.group(1);
                                                                                            strGroup1111117.getClass();
                                                                                            int i11110 = Integer.parseInt(strGroup1111117);
                                                                                            String strGroup1111118 = matcher4.group(2);
                                                                                            strGroup1111118.getClass();
                                                                                            int i11111 = Integer.parseInt(strGroup1111118);
                                                                                            float f1111115 = i11110 / zzalqVar.zza;
                                                                                            f3 = i11111 / zzalqVar.zzb;
                                                                                            f4 = f1111115;
                                                                                            strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                                            if (strZza4 != null) {
                                                                                                strZza7 = zzfwk.zza(strZza4);
                                                                                                iHashCode2 = strZza7.hashCode();
                                                                                                if (iHashCode2 != -1364013995) {
                                                                                                    if (iHashCode2 != 92734940) {
                                                                                                        b3 = -1;
                                                                                                    } else {
                                                                                                        b3 = 1;
                                                                                                    }
                                                                                                } else if (strZza7.equals("center")) {
                                                                                                    b3 = 0;
                                                                                                } else {
                                                                                                    b3 = -1;
                                                                                                }
                                                                                                if (b3 != 0) {
                                                                                                    f5 = f2 + (f3 / 2.0f);
                                                                                                    i6 = 1;
                                                                                                } else if (b3 != 1) {
                                                                                                    f5 = f2;
                                                                                                    i6 = 0;
                                                                                                } else {
                                                                                                    f5 = f2 + f3;
                                                                                                    i6 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                f5 = f2;
                                                                                                i6 = 0;
                                                                                            }
                                                                                            float f1111116 = 1.0f / i10;
                                                                                            strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                                            if (strZza5 != null) {
                                                                                                strZza6 = zzfwk.zza(strZza5);
                                                                                                iHashCode = strZza6.hashCode();
                                                                                                if (iHashCode != 3694) {
                                                                                                    if (iHashCode != 3553396) {
                                                                                                        if (iHashCode != 3553576) {
                                                                                                            b2 = -1;
                                                                                                        } else {
                                                                                                            b2 = 2;
                                                                                                        }
                                                                                                    } else if (strZza6.equals("tblr")) {
                                                                                                        b2 = 1;
                                                                                                    } else {
                                                                                                        b2 = -1;
                                                                                                    }
                                                                                                } else if (strZza6.equals("tb")) {
                                                                                                    b2 = 0;
                                                                                                } else {
                                                                                                    b2 = -1;
                                                                                                }
                                                                                                if (b2 != 0) {
                                                                                                    i7 = 2;
                                                                                                } else {
                                                                                                    i7 = 2;
                                                                                                }
                                                                                            } else {
                                                                                                i7 = Integer.MIN_VALUE;
                                                                                            }
                                                                                            zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f1111116, i7);
                                                                                        }
                                                                                        if (zzalsVar != null) {
                                                                                            map4.put(zzalsVar.zza, zzalsVar);
                                                                                        }
                                                                                    } else {
                                                                                        zzff.zzf("TtmlParser", "Ignoring region without an extent");
                                                                                    }
                                                                                }
                                                                            }
                                                                        } else {
                                                                            str4 = str2;
                                                                            map2 = map3;
                                                                            zzff.zzf("TtmlParser", "Ignoring region without an origin");
                                                                        }
                                                                    }
                                                                    zzalsVar = null;
                                                                    if (zzalsVar != null) {
                                                                        map4.put(zzalsVar.zza, zzalsVar);
                                                                    }
                                                                } else if (zzfz.zzc(xmlPullParserNewPullParser, str2)) {
                                                                    do {
                                                                        xmlPullParserNewPullParser.next();
                                                                        if (zzfz.zzc(xmlPullParserNewPullParser, "image")) {
                                                                            map5.put(strZza8, xmlPullParserNewPullParser.nextText());
                                                                        }
                                                                    } while (!zzfz.zzb(xmlPullParserNewPullParser, str2));
                                                                }
                                                                if (zzfz.zzb(xmlPullParserNewPullParser, "head")) {
                                                                    zzalpVar2 = zzalpVar4;
                                                                    arrayDeque = arrayDeque2;
                                                                } else {
                                                                    zzalpVar4 = zzalpVar4;
                                                                    str2 = str4;
                                                                    map3 = map2;
                                                                }
                                                            }
                                                            str4 = str2;
                                                            map2 = map3;
                                                            if (zzfz.zzb(xmlPullParserNewPullParser, "head")) {
                                                                zzalpVar2 = zzalpVar4;
                                                                arrayDeque = arrayDeque2;
                                                            } else {
                                                                zzalpVar4 = zzalpVar4;
                                                                str2 = str4;
                                                                map3 = map2;
                                                            }
                                                        }
                                                    } else {
                                                        map2 = map3;
                                                        zzalpVar = zzalpVar4;
                                                        attributeCount = xmlPullParserNewPullParser.getAttributeCount();
                                                        zzalu zzaluVarZzf7 = zzf(xmlPullParserNewPullParser, null);
                                                        strArr = null;
                                                        strSubstring = null;
                                                        str3 = str;
                                                        jZzc = -9223372036854775807L;
                                                        jZzc2 = -9223372036854775807L;
                                                        jZzc3 = -9223372036854775807L;
                                                        i5 = 0;
                                                        while (i5 < attributeCount) {
                                                            attributeName = xmlPullParserNewPullParser.getAttributeName(i5);
                                                            attributeValue = xmlPullParserNewPullParser.getAttributeValue(i5);
                                                            switch (attributeName) {
                                                                case -934795532:
                                                                    if (!attributeName.equals("region")) {
                                                                        b = 4;
                                                                    } else {
                                                                        b = -1;
                                                                    }
                                                                    break;
                                                                case 99841:
                                                                    if (!attributeName.equals("dur")) {
                                                                        b = 2;
                                                                    } else {
                                                                        b = -1;
                                                                    }
                                                                    break;
                                                                case 100571:
                                                                    if (!attributeName.equals("end")) {
                                                                        b = 1;
                                                                    } else {
                                                                        b = -1;
                                                                    }
                                                                    break;
                                                                case 93616297:
                                                                    if (!attributeName.equals("begin")) {
                                                                        b = 0;
                                                                    } else {
                                                                        b = -1;
                                                                    }
                                                                    break;
                                                                case 109780401:
                                                                    if (!attributeName.equals("style")) {
                                                                        b = 3;
                                                                    } else {
                                                                        b = -1;
                                                                    }
                                                                    break;
                                                                case 1292595405:
                                                                    if (!attributeName.equals("backgroundImage")) {
                                                                        b = 5;
                                                                    } else {
                                                                        b = -1;
                                                                    }
                                                                    break;
                                                                default:
                                                                    b = -1;
                                                                    break;
                                                            }
                                                            if (b == 0) {
                                                                zzalpVar2 = zzalpVar;
                                                                i4 = 1;
                                                                jZzc2 = zzc(attributeValue, zzalpVar2);
                                                            } else if (b == 1) {
                                                                i4 = 1;
                                                                zzalpVar2 = zzalpVar;
                                                                jZzc = zzc(attributeValue, zzalpVar2);
                                                            } else if (b != 2) {
                                                                if (b == 3) {
                                                                    i4 = 1;
                                                                    strArrZzg = zzg(attributeValue);
                                                                    if (strArrZzg.length > 0) {
                                                                        strArr = strArrZzg;
                                                                    }
                                                                } else if (b == 4) {
                                                                    i4 = 1;
                                                                    if (map4.containsKey(attributeValue)) {
                                                                        str3 = attributeValue;
                                                                    }
                                                                } else if (b != 5) {
                                                                    i4 = 1;
                                                                } else if (attributeValue.startsWith("#")) {
                                                                    i4 = 1;
                                                                    strSubstring = attributeValue.substring(1);
                                                                } else {
                                                                    i4 = 1;
                                                                }
                                                                zzalpVar2 = zzalpVar;
                                                            } else {
                                                                zzalpVar2 = zzalpVar;
                                                                i4 = 1;
                                                                jZzc3 = zzc(attributeValue, zzalpVar2);
                                                            }
                                                            i5++;
                                                            zzalpVar = zzalpVar2;
                                                            i4 = 0;
                                                        }
                                                        zzalpVar2 = zzalpVar;
                                                        i4 = 1;
                                                        if (zzaloVar2 != null) {
                                                            j3 = zzaloVar2.zzd;
                                                            if (j3 == -9223372036854775807L) {
                                                                zzaloVar = zzaloVar2;
                                                            } else {
                                                                if (jZzc2 != -9223372036854775807L) {
                                                                    jZzc2 += j3;
                                                                } else {
                                                                    jZzc2 = -9223372036854775807L;
                                                                }
                                                                if (jZzc != -9223372036854775807L) {
                                                                    jZzc += j3;
                                                                    zzaloVar = zzaloVar2;
                                                                } else {
                                                                    zzaloVar = zzaloVar2;
                                                                    jZzc = -9223372036854775807L;
                                                                }
                                                            }
                                                        } else {
                                                            zzaloVar = null;
                                                        }
                                                        if (jZzc != -9223372036854775807L) {
                                                            j = jZzc;
                                                        } else if (jZzc3 != -9223372036854775807L) {
                                                            j = jZzc2 + jZzc3;
                                                        } else if (zzaloVar != null) {
                                                            j2 = zzaloVar.zze;
                                                            if (j2 != -9223372036854775807L) {
                                                                j = j2;
                                                            } else {
                                                                j = -9223372036854775807L;
                                                            }
                                                        } else {
                                                            j = -9223372036854775807L;
                                                        }
                                                        zzaloVarZzb = zzalo.zzb(xmlPullParserNewPullParser.getName(), jZzc2, j, zzaluVarZzf7, strArr, str3, strSubstring, zzaloVar);
                                                        arrayDeque = arrayDeque2;
                                                        arrayDeque.push(zzaloVarZzb);
                                                        if (zzaloVar2 != null) {
                                                            zzaloVar2.zzf(zzaloVarZzb);
                                                        }
                                                    }
                                                    zzalpVar4 = zzalpVar2;
                                                    i9 = i9;
                                                    map = map2;
                                                }
                                            }
                                            xmlPullParserNewPullParser.next();
                                            eventType = xmlPullParserNewPullParser.getEventType();
                                            map3 = map;
                                            arrayDeque2 = arrayDeque;
                                            str5 = str;
                                            str6 = str6;
                                        }
                                    } catch (NumberFormatException unused8) {
                                        str6 = str6;
                                    }
                                } else {
                                    zzff.zzf("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue6));
                                    str6 = str6;
                                    zzalpVar3 = zzalpVar6;
                                    i10 = 15;
                                }
                            }
                            strZza10 = zzfz.zza(xmlPullParserNewPullParser, "extent");
                            if (strZza10 == null) {
                                zzalqVar = null;
                                zzalpVar4 = zzalpVar3;
                            } else {
                                matcher5 = zzf.matcher(strZza10);
                                if (matcher5.matches()) {
                                    zzff.zzf("TtmlParser", "Ignoring non-pixel tts extent: ".concat(strZza10));
                                } else {
                                    String strGroup27 = matcher5.group(1);
                                    strGroup27.getClass();
                                    int i27 = Integer.parseInt(strGroup27);
                                    String strGroup28 = matcher5.group(2);
                                    strGroup28.getClass();
                                    zzalqVar = new zzalq(i27, Integer.parseInt(strGroup28));
                                    zzalpVar4 = zzalpVar3;
                                }
                                zzalqVar = null;
                                zzalpVar4 = zzalpVar3;
                            }
                        } else {
                            str6 = str6;
                            arrayDeque2 = arrayDeque2;
                            zzalvVar2 = zzalvVar2;
                            i9 = i9;
                            zzalqVar = zzalqVar;
                            i10 = i10;
                        }
                        str2 = "metadata";
                        if (name.equals("tt") || name.equals("head") || name.equals("body") || name.equals("div") || name.equals("p") || name.equals("span") || name.equals("br") || name.equals("style") || name.equals("styling") || name.equals("layout") || name.equals("region") || name.equals("metadata") || name.equals("image") || name.equals(Constants.ScionAnalytics.MessageType.DATA_MESSAGE) || name.equals("information")) {
                            if ("head".equals(name)) {
                                while (true) {
                                    xmlPullParserNewPullParser.next();
                                    if (zzfz.zzc(xmlPullParserNewPullParser, "style")) {
                                        strZza9 = zzfz.zza(xmlPullParserNewPullParser, "style");
                                        zzaluVarZzf = zzf(xmlPullParserNewPullParser, new zzalu());
                                        if (strZza9 != null) {
                                            strArrZzg2 = zzg(strZza9);
                                            i8 = 0;
                                            while (i8 < length) {
                                                zzaluVarZzf.zzl((zzalu) map3.get(strArrZzg2[i8]));
                                                i8++;
                                            }
                                        }
                                        strZzE = zzaluVarZzf.zzE();
                                        if (strZzE != null) {
                                            map3.put(strZzE, zzaluVarZzf);
                                        }
                                    } else {
                                        zzalpVar4 = zzalpVar4;
                                        if (zzfz.zzc(xmlPullParserNewPullParser, "region")) {
                                            strZza = zzfz.zza(xmlPullParserNewPullParser, "id");
                                            if (strZza == null) {
                                                str4 = str2;
                                                map2 = map3;
                                            } else {
                                                strZza2 = zzfz.zza(xmlPullParserNewPullParser, "origin");
                                                if (strZza2 != null) {
                                                    pattern = zzb;
                                                    matcher = pattern.matcher(strZza2);
                                                    pattern2 = zzf;
                                                    str4 = str2;
                                                    matcher2 = pattern2.matcher(strZza2);
                                                    if (matcher.matches()) {
                                                        map2 = map3;
                                                        String strGroup1111119 = matcher.group(1);
                                                        strGroup1111119.getClass();
                                                        float f1111117 = Float.parseFloat(strGroup1111119) / 100.0f;
                                                        String strGroup111121 = matcher.group(2);
                                                        strGroup111121.getClass();
                                                        f2 = Float.parseFloat(strGroup111121) / 100.0f;
                                                        f = f1111117;
                                                        strZza3 = zzfz.zza(xmlPullParserNewPullParser, "extent");
                                                        if (strZza3 != null) {
                                                            matcher3 = pattern.matcher(strZza3);
                                                            matcher4 = pattern2.matcher(strZza3);
                                                            if (matcher3.matches()) {
                                                                String strGroup11111110 = matcher3.group(1);
                                                                strGroup11111110.getClass();
                                                                float f1111118 = Float.parseFloat(strGroup11111110) / 100.0f;
                                                                String strGroup11111111 = matcher3.group(2);
                                                                strGroup11111111.getClass();
                                                                f3 = Float.parseFloat(strGroup11111111) / 100.0f;
                                                                f4 = f1111118;
                                                                strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                if (strZza4 != null) {
                                                                    strZza7 = zzfwk.zza(strZza4);
                                                                    iHashCode2 = strZza7.hashCode();
                                                                    if (iHashCode2 != -1364013995) {
                                                                        if (iHashCode2 != 92734940 && strZza7.equals("after")) {
                                                                            b3 = 1;
                                                                        } else {
                                                                            b3 = -1;
                                                                        }
                                                                    } else if (strZza7.equals("center")) {
                                                                        b3 = 0;
                                                                    } else {
                                                                        b3 = -1;
                                                                    }
                                                                    if (b3 != 0) {
                                                                        f5 = f2 + (f3 / 2.0f);
                                                                        i6 = 1;
                                                                    } else if (b3 != 1) {
                                                                        f5 = f2;
                                                                        i6 = 0;
                                                                    } else {
                                                                        f5 = f2 + f3;
                                                                        i6 = 2;
                                                                    }
                                                                } else {
                                                                    f5 = f2;
                                                                    i6 = 0;
                                                                }
                                                                float f1111119 = 1.0f / i10;
                                                                strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                if (strZza5 != null) {
                                                                    strZza6 = zzfwk.zza(strZza5);
                                                                    iHashCode = strZza6.hashCode();
                                                                    if (iHashCode != 3694) {
                                                                        if (iHashCode != 3553396) {
                                                                            if (iHashCode != 3553576 && strZza6.equals("tbrl")) {
                                                                                b2 = 2;
                                                                            } else {
                                                                                b2 = -1;
                                                                            }
                                                                        } else if (strZza6.equals("tblr")) {
                                                                            b2 = 1;
                                                                        } else {
                                                                            b2 = -1;
                                                                        }
                                                                    } else if (strZza6.equals("tb")) {
                                                                        b2 = 0;
                                                                    } else {
                                                                        b2 = -1;
                                                                    }
                                                                    if (b2 != 0 || b2 == 1) {
                                                                        i7 = 2;
                                                                    } else if (b2 != 2) {
                                                                        i7 = Integer.MIN_VALUE;
                                                                    } else {
                                                                        i7 = 1;
                                                                    }
                                                                } else {
                                                                    i7 = Integer.MIN_VALUE;
                                                                }
                                                                zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f1111119, i7);
                                                            } else if (matcher4.matches()) {
                                                                zzff.zzf("TtmlParser", "Ignoring region with unsupported extent: ".concat(strZza2));
                                                            } else if (zzalqVar == null) {
                                                                zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                            } else {
                                                                String strGroup11111112 = matcher4.group(1);
                                                                strGroup11111112.getClass();
                                                                int i11112 = Integer.parseInt(strGroup11111112);
                                                                String strGroup11111113 = matcher4.group(2);
                                                                strGroup11111113.getClass();
                                                                int i11113 = Integer.parseInt(strGroup11111113);
                                                                float f11111110 = i11112 / zzalqVar.zza;
                                                                f3 = i11113 / zzalqVar.zzb;
                                                                f4 = f11111110;
                                                                strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                if (strZza4 != null) {
                                                                    strZza7 = zzfwk.zza(strZza4);
                                                                    iHashCode2 = strZza7.hashCode();
                                                                    if (iHashCode2 != -1364013995) {
                                                                        if (iHashCode2 != 92734940) {
                                                                            b3 = -1;
                                                                        } else {
                                                                            b3 = 1;
                                                                        }
                                                                    } else if (strZza7.equals("center")) {
                                                                        b3 = 0;
                                                                    } else {
                                                                        b3 = -1;
                                                                    }
                                                                    if (b3 != 0) {
                                                                        f5 = f2 + (f3 / 2.0f);
                                                                        i6 = 1;
                                                                    } else if (b3 != 1) {
                                                                        f5 = f2;
                                                                        i6 = 0;
                                                                    } else {
                                                                        f5 = f2 + f3;
                                                                        i6 = 2;
                                                                    }
                                                                } else {
                                                                    f5 = f2;
                                                                    i6 = 0;
                                                                }
                                                                float f11111111 = 1.0f / i10;
                                                                strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                if (strZza5 != null) {
                                                                    strZza6 = zzfwk.zza(strZza5);
                                                                    iHashCode = strZza6.hashCode();
                                                                    if (iHashCode != 3694) {
                                                                        if (iHashCode != 3553396) {
                                                                            if (iHashCode != 3553576) {
                                                                                b2 = -1;
                                                                            } else {
                                                                                b2 = 2;
                                                                            }
                                                                        } else if (strZza6.equals("tblr")) {
                                                                            b2 = 1;
                                                                        } else {
                                                                            b2 = -1;
                                                                        }
                                                                    } else if (strZza6.equals("tb")) {
                                                                        b2 = 0;
                                                                    } else {
                                                                        b2 = -1;
                                                                    }
                                                                    if (b2 != 0) {
                                                                        i7 = 2;
                                                                    } else {
                                                                        i7 = 2;
                                                                    }
                                                                } else {
                                                                    i7 = Integer.MIN_VALUE;
                                                                }
                                                                zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f11111111, i7);
                                                            }
                                                            if (zzalsVar != null) {
                                                                map4.put(zzalsVar.zza, zzalsVar);
                                                            }
                                                        } else {
                                                            zzff.zzf("TtmlParser", "Ignoring region without an extent");
                                                        }
                                                    } else {
                                                        map2 = map3;
                                                        if (!matcher2.matches()) {
                                                            zzff.zzf("TtmlParser", "Ignoring region with unsupported origin: ".concat(strZza2));
                                                        } else if (zzalqVar == null) {
                                                            zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                        } else {
                                                            String strGroup29 = matcher2.group(1);
                                                            strGroup29.getClass();
                                                            int i28 = Integer.parseInt(strGroup29);
                                                            String strGroup11111114 = matcher2.group(2);
                                                            strGroup11111114.getClass();
                                                            float f11111112 = Integer.parseInt(strGroup11111114);
                                                            f = i28 / zzalqVar.zza;
                                                            f2 = f11111112 / zzalqVar.zzb;
                                                            strZza3 = zzfz.zza(xmlPullParserNewPullParser, "extent");
                                                            if (strZza3 != null) {
                                                                matcher3 = pattern.matcher(strZza3);
                                                                matcher4 = pattern2.matcher(strZza3);
                                                                if (matcher3.matches()) {
                                                                    String strGroup11111115 = matcher3.group(1);
                                                                    strGroup11111115.getClass();
                                                                    float f11111113 = Float.parseFloat(strGroup11111115) / 100.0f;
                                                                    String strGroup11111116 = matcher3.group(2);
                                                                    strGroup11111116.getClass();
                                                                    f3 = Float.parseFloat(strGroup11111116) / 100.0f;
                                                                    f4 = f11111113;
                                                                    strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                    if (strZza4 != null) {
                                                                        strZza7 = zzfwk.zza(strZza4);
                                                                        iHashCode2 = strZza7.hashCode();
                                                                        if (iHashCode2 != -1364013995) {
                                                                            if (iHashCode2 != 92734940) {
                                                                                b3 = -1;
                                                                            } else {
                                                                                b3 = 1;
                                                                            }
                                                                        } else if (strZza7.equals("center")) {
                                                                            b3 = 0;
                                                                        } else {
                                                                            b3 = -1;
                                                                        }
                                                                        if (b3 != 0) {
                                                                            f5 = f2 + (f3 / 2.0f);
                                                                            i6 = 1;
                                                                        } else if (b3 != 1) {
                                                                            f5 = f2;
                                                                            i6 = 0;
                                                                        } else {
                                                                            f5 = f2 + f3;
                                                                            i6 = 2;
                                                                        }
                                                                    } else {
                                                                        f5 = f2;
                                                                        i6 = 0;
                                                                    }
                                                                    float f11111114 = 1.0f / i10;
                                                                    strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                    if (strZza5 != null) {
                                                                        strZza6 = zzfwk.zza(strZza5);
                                                                        iHashCode = strZza6.hashCode();
                                                                        if (iHashCode != 3694) {
                                                                            if (iHashCode != 3553396) {
                                                                                if (iHashCode != 3553576) {
                                                                                    b2 = -1;
                                                                                } else {
                                                                                    b2 = 2;
                                                                                }
                                                                            } else if (strZza6.equals("tblr")) {
                                                                                b2 = 1;
                                                                            } else {
                                                                                b2 = -1;
                                                                            }
                                                                        } else if (strZza6.equals("tb")) {
                                                                            b2 = 0;
                                                                        } else {
                                                                            b2 = -1;
                                                                        }
                                                                        if (b2 != 0) {
                                                                            i7 = 2;
                                                                        } else {
                                                                            i7 = 2;
                                                                        }
                                                                    } else {
                                                                        i7 = Integer.MIN_VALUE;
                                                                    }
                                                                    zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f11111114, i7);
                                                                } else if (matcher4.matches()) {
                                                                    zzff.zzf("TtmlParser", "Ignoring region with unsupported extent: ".concat(strZza2));
                                                                } else if (zzalqVar == null) {
                                                                    zzff.zzf("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZza2));
                                                                } else {
                                                                    String strGroup11111117 = matcher4.group(1);
                                                                    strGroup11111117.getClass();
                                                                    int i11114 = Integer.parseInt(strGroup11111117);
                                                                    String strGroup11111118 = matcher4.group(2);
                                                                    strGroup11111118.getClass();
                                                                    int i11115 = Integer.parseInt(strGroup11111118);
                                                                    float f11111115 = i11114 / zzalqVar.zza;
                                                                    f3 = i11115 / zzalqVar.zzb;
                                                                    f4 = f11111115;
                                                                    strZza4 = zzfz.zza(xmlPullParserNewPullParser, "displayAlign");
                                                                    if (strZza4 != null) {
                                                                        strZza7 = zzfwk.zza(strZza4);
                                                                        iHashCode2 = strZza7.hashCode();
                                                                        if (iHashCode2 != -1364013995) {
                                                                            if (iHashCode2 != 92734940) {
                                                                                b3 = -1;
                                                                            } else {
                                                                                b3 = 1;
                                                                            }
                                                                        } else if (strZza7.equals("center")) {
                                                                            b3 = 0;
                                                                        } else {
                                                                            b3 = -1;
                                                                        }
                                                                        if (b3 != 0) {
                                                                            f5 = f2 + (f3 / 2.0f);
                                                                            i6 = 1;
                                                                        } else if (b3 != 1) {
                                                                            f5 = f2;
                                                                            i6 = 0;
                                                                        } else {
                                                                            f5 = f2 + f3;
                                                                            i6 = 2;
                                                                        }
                                                                    } else {
                                                                        f5 = f2;
                                                                        i6 = 0;
                                                                    }
                                                                    float f11111116 = 1.0f / i10;
                                                                    strZza5 = zzfz.zza(xmlPullParserNewPullParser, "writingMode");
                                                                    if (strZza5 != null) {
                                                                        strZza6 = zzfwk.zza(strZza5);
                                                                        iHashCode = strZza6.hashCode();
                                                                        if (iHashCode != 3694) {
                                                                            if (iHashCode != 3553396) {
                                                                                if (iHashCode != 3553576) {
                                                                                    b2 = -1;
                                                                                } else {
                                                                                    b2 = 2;
                                                                                }
                                                                            } else if (strZza6.equals("tblr")) {
                                                                                b2 = 1;
                                                                            } else {
                                                                                b2 = -1;
                                                                            }
                                                                        } else if (strZza6.equals("tb")) {
                                                                            b2 = 0;
                                                                        } else {
                                                                            b2 = -1;
                                                                        }
                                                                        if (b2 != 0) {
                                                                            i7 = 2;
                                                                        } else {
                                                                            i7 = 2;
                                                                        }
                                                                    } else {
                                                                        i7 = Integer.MIN_VALUE;
                                                                    }
                                                                    zzalsVar = new zzals(strZza, f, f5, 0, i6, f4, f3, 1, f11111116, i7);
                                                                }
                                                                if (zzalsVar != null) {
                                                                    map4.put(zzalsVar.zza, zzalsVar);
                                                                }
                                                            } else {
                                                                zzff.zzf("TtmlParser", "Ignoring region without an extent");
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    str4 = str2;
                                                    map2 = map3;
                                                    zzff.zzf("TtmlParser", "Ignoring region without an origin");
                                                }
                                            }
                                            zzalsVar = null;
                                            if (zzalsVar != null) {
                                                map4.put(zzalsVar.zza, zzalsVar);
                                            }
                                        } else if (zzfz.zzc(xmlPullParserNewPullParser, str2)) {
                                            do {
                                                xmlPullParserNewPullParser.next();
                                                if (zzfz.zzc(xmlPullParserNewPullParser, "image") && (strZza8 = zzfz.zza(xmlPullParserNewPullParser, "id")) != null) {
                                                    map5.put(strZza8, xmlPullParserNewPullParser.nextText());
                                                }
                                            } while (!zzfz.zzb(xmlPullParserNewPullParser, str2));
                                        }
                                        if (zzfz.zzb(xmlPullParserNewPullParser, "head")) {
                                            zzalpVar2 = zzalpVar4;
                                            arrayDeque = arrayDeque2;
                                        } else {
                                            zzalpVar4 = zzalpVar4;
                                            str2 = str4;
                                            map3 = map2;
                                        }
                                    }
                                    str4 = str2;
                                    map2 = map3;
                                    if (zzfz.zzb(xmlPullParserNewPullParser, "head")) {
                                        zzalpVar2 = zzalpVar4;
                                        arrayDeque = arrayDeque2;
                                    } else {
                                        zzalpVar4 = zzalpVar4;
                                        str2 = str4;
                                        map3 = map2;
                                    }
                                }
                            } else {
                                map2 = map3;
                                zzalpVar = zzalpVar4;
                                attributeCount = xmlPullParserNewPullParser.getAttributeCount();
                                zzalu zzaluVarZzf8 = zzf(xmlPullParserNewPullParser, null);
                                strArr = null;
                                strSubstring = null;
                                str3 = str;
                                jZzc = -9223372036854775807L;
                                jZzc2 = -9223372036854775807L;
                                jZzc3 = -9223372036854775807L;
                                i5 = 0;
                                while (i5 < attributeCount) {
                                    attributeName = xmlPullParserNewPullParser.getAttributeName(i5);
                                    attributeValue = xmlPullParserNewPullParser.getAttributeValue(i5);
                                    switch (attributeName) {
                                        case -934795532:
                                            if (!attributeName.equals("region")) {
                                                b = 4;
                                            } else {
                                                b = -1;
                                            }
                                            break;
                                        case 99841:
                                            if (!attributeName.equals("dur")) {
                                                b = 2;
                                            } else {
                                                b = -1;
                                            }
                                            break;
                                        case 100571:
                                            if (!attributeName.equals("end")) {
                                                b = 1;
                                            } else {
                                                b = -1;
                                            }
                                            break;
                                        case 93616297:
                                            if (!attributeName.equals("begin")) {
                                                b = 0;
                                            } else {
                                                b = -1;
                                            }
                                            break;
                                        case 109780401:
                                            if (!attributeName.equals("style")) {
                                                b = 3;
                                            } else {
                                                b = -1;
                                            }
                                            break;
                                        case 1292595405:
                                            if (!attributeName.equals("backgroundImage")) {
                                                b = 5;
                                            } else {
                                                b = -1;
                                            }
                                            break;
                                        default:
                                            b = -1;
                                            break;
                                    }
                                    if (b == 0) {
                                        zzalpVar2 = zzalpVar;
                                        i4 = 1;
                                        jZzc2 = zzc(attributeValue, zzalpVar2);
                                    } else if (b == 1) {
                                        i4 = 1;
                                        zzalpVar2 = zzalpVar;
                                        jZzc = zzc(attributeValue, zzalpVar2);
                                    } else if (b != 2) {
                                        if (b == 3) {
                                            i4 = 1;
                                            strArrZzg = zzg(attributeValue);
                                            if (strArrZzg.length > 0) {
                                                strArr = strArrZzg;
                                            }
                                        } else if (b == 4) {
                                            i4 = 1;
                                            if (map4.containsKey(attributeValue)) {
                                                str3 = attributeValue;
                                            }
                                        } else if (b != 5) {
                                            i4 = 1;
                                        } else if (attributeValue.startsWith("#")) {
                                            i4 = 1;
                                            strSubstring = attributeValue.substring(1);
                                        } else {
                                            i4 = 1;
                                        }
                                        zzalpVar2 = zzalpVar;
                                    } else {
                                        zzalpVar2 = zzalpVar;
                                        i4 = 1;
                                        jZzc3 = zzc(attributeValue, zzalpVar2);
                                    }
                                    i5++;
                                    zzalpVar = zzalpVar2;
                                    i4 = 0;
                                }
                                zzalpVar2 = zzalpVar;
                                i4 = 1;
                                if (zzaloVar2 != null) {
                                    j3 = zzaloVar2.zzd;
                                    if (j3 == -9223372036854775807L) {
                                        zzaloVar = zzaloVar2;
                                    } else {
                                        if (jZzc2 != -9223372036854775807L) {
                                            jZzc2 += j3;
                                        } else {
                                            jZzc2 = -9223372036854775807L;
                                        }
                                        if (jZzc != -9223372036854775807L) {
                                            jZzc += j3;
                                            zzaloVar = zzaloVar2;
                                        } else {
                                            zzaloVar = zzaloVar2;
                                            jZzc = -9223372036854775807L;
                                        }
                                    }
                                } else {
                                    zzaloVar = null;
                                }
                                if (jZzc != -9223372036854775807L) {
                                    j = jZzc;
                                } else if (jZzc3 != -9223372036854775807L) {
                                    j = jZzc2 + jZzc3;
                                } else if (zzaloVar != null) {
                                    j2 = zzaloVar.zze;
                                    if (j2 != -9223372036854775807L) {
                                        j = j2;
                                    } else {
                                        j = -9223372036854775807L;
                                    }
                                } else {
                                    j = -9223372036854775807L;
                                }
                                zzaloVarZzb = zzalo.zzb(xmlPullParserNewPullParser.getName(), jZzc2, j, zzaluVarZzf8, strArr, str3, strSubstring, zzaloVar);
                                arrayDeque = arrayDeque2;
                                arrayDeque.push(zzaloVarZzb);
                                if (zzaloVar2 != null) {
                                    zzaloVar2.zzf(zzaloVarZzb);
                                }
                            }
                            zzalpVar4 = zzalpVar2;
                            i9 = i9;
                            map = map2;
                        } else {
                            zzff.zze("TtmlParser", "Ignoring unsupported tag: " + xmlPullParserNewPullParser.getName());
                            map = map3;
                            zzalqVar = zzalqVar;
                            i10 = i10;
                            zzalvVar2 = zzalvVar2;
                            arrayDeque = arrayDeque2;
                            i9 = 1;
                        }
                    } else {
                        str6 = str6;
                        HashMap map6 = map3;
                        arrayDeque = arrayDeque2;
                        zzalvVar = zzalvVar2;
                        i3 = i9;
                        if (eventType == 4) {
                            zzaloVar2.getClass();
                            zzaloVar2.zzf(zzalo.zzc(xmlPullParserNewPullParser.getText()));
                        } else {
                            if (eventType == 3) {
                                if (xmlPullParserNewPullParser.getName().equals("tt")) {
                                    zzalo zzaloVar3 = (zzalo) arrayDeque.peek();
                                    zzaloVar3.getClass();
                                    map = map6;
                                    zzalvVar2 = new zzalv(zzaloVar3, map, map4, map5);
                                } else {
                                    map = map6;
                                    zzalvVar2 = zzalvVar;
                                }
                                arrayDeque.pop();
                            }
                            i9 = i3;
                        }
                        map = map6;
                        zzalvVar2 = zzalvVar;
                        i9 = i3;
                    }
                } else {
                    str = str5;
                    str6 = str6;
                    map = map3;
                    arrayDeque = arrayDeque2;
                    zzalvVar = zzalvVar2;
                    i3 = i9;
                    if (eventType == 2) {
                        i9 = i3 + 1;
                    } else {
                        if (eventType == 3) {
                            i9 = i3 - 1;
                        }
                        zzalvVar2 = zzalvVar;
                        i9 = i3;
                    }
                    zzalvVar2 = zzalvVar;
                }
                xmlPullParserNewPullParser.next();
                eventType = xmlPullParserNewPullParser.getEventType();
                map3 = map;
                arrayDeque2 = arrayDeque;
                str5 = str;
                str6 = str6;
            }
            zzalv zzalvVar3 = zzalvVar2;
            zzalvVar3.getClass();
            return zzalvVar3;
        } catch (IOException e8) {
            throw new IllegalStateException("Unexpected error when reading input.", e8);
        } catch (XmlPullParserException e9) {
            throw new IllegalStateException("Unable to decode source", e9);
        }
    }

    public zzalr() {
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.zzi = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }
}
