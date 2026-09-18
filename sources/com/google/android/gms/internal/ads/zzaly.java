package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaly {
    private static final Pattern zza = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private static final Pattern zzb = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    private final zzfp zzc = new zzfp();
    private final StringBuilder zzd = new StringBuilder();

    static String zza(zzfp zzfpVar, StringBuilder sb) {
        zzc(zzfpVar);
        if (zzfpVar.zzb() == 0) {
            return null;
        }
        String strZzd = zzd(zzfpVar, sb);
        if (!"".equals(strZzd)) {
            return strZzd;
        }
        char cZzm = (char) zzfpVar.zzm();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cZzm);
        return sb2.toString();
    }

    static void zzc(zzfp zzfpVar) {
        while (true) {
            for (boolean z = true; zzfpVar.zzb() > 0 && z; z = false) {
                char c = (char) zzfpVar.zzM()[zzfpVar.zzd()];
                if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
                    zzfpVar.zzL(1);
                } else {
                    int iZzd = zzfpVar.zzd();
                    int iZze = zzfpVar.zze();
                    byte[] bArrZzM = zzfpVar.zzM();
                    if (iZzd + 2 <= iZze) {
                        int i = iZzd + 1;
                        if (bArrZzM[iZzd] == 47) {
                            int i2 = iZzd + 2;
                            if (bArrZzM[i] == 42) {
                                while (true) {
                                    int i3 = i2 + 1;
                                    if (i3 >= iZze) {
                                        break;
                                    }
                                    if (((char) bArrZzM[i2]) == '*' && ((char) bArrZzM[i3]) == '/') {
                                        iZze = i2 + 2;
                                        i2 = iZze;
                                    } else {
                                        i2 = i3;
                                    }
                                }
                                zzfpVar.zzL(iZze - zzfpVar.zzd());
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return;
        }
    }

    private static String zzd(zzfp zzfpVar, StringBuilder sb) {
        char c;
        sb.setLength(0);
        int iZzd = zzfpVar.zzd();
        int iZze = zzfpVar.zze();
        loop0: while (true) {
            boolean z = false;
            while (true) {
                if (iZzd < iZze && !z) {
                    c = (char) zzfpVar.zzM()[iZzd];
                    if ((c >= 'A' && c <= 'Z') || ((c >= 'a' && c <= 'z') || ((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.' || c == '_'))) {
                        break;
                    }
                    z = true;
                } else {
                    break loop0;
                }
            }
            sb.append(c);
            iZzd++;
        }
        zzfpVar.zzL(iZzd - zzfpVar.zzd());
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:102:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:104:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:105:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:107:0x0207  */
    /* JADX WARN: Code duplicated, block: B:108:0x020c  */
    /* JADX WARN: Code duplicated, block: B:110:0x0214  */
    /* JADX WARN: Code duplicated, block: B:116:0x0227  */
    /* JADX WARN: Code duplicated, block: B:118:0x022d  */
    /* JADX WARN: Code duplicated, block: B:120:0x0235  */
    /* JADX WARN: Code duplicated, block: B:122:0x023d  */
    /* JADX WARN: Code duplicated, block: B:123:0x0242  */
    /* JADX WARN: Code duplicated, block: B:125:0x024a  */
    /* JADX WARN: Code duplicated, block: B:126:0x024f  */
    /* JADX WARN: Code duplicated, block: B:128:0x0257  */
    /* JADX WARN: Code duplicated, block: B:130:0x025f  */
    /* JADX WARN: Code duplicated, block: B:131:0x0264  */
    /* JADX WARN: Code duplicated, block: B:133:0x026c  */
    /* JADX WARN: Code duplicated, block: B:135:0x0274  */
    /* JADX WARN: Code duplicated, block: B:136:0x0279  */
    /* JADX WARN: Code duplicated, block: B:138:0x0281  */
    /* JADX WARN: Code duplicated, block: B:140:0x0291  */
    /* JADX WARN: Code duplicated, block: B:141:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:143:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:145:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:151:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:153:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:154:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:156:0x02de  */
    /* JADX WARN: Code duplicated, block: B:157:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:159:0x02e3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:160:0x02e5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:161:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:164:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:165:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:177:0x02ec A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:188:0x0307 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:191:0x0307 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:194:0x0307 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:196:0x0307 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:198:0x0307 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:8:0x0044  */
    /* JADX WARN: Code duplicated, block: B:96:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:97:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:99:0x01e0  */
    /* JADX WARN: Instruction removed from duplicated block: B:140:0x0291, please report this as an issue */
    public final List zzb(zzfp zzfpVar) {
        String strTrim;
        String string;
        Matcher matcher;
        String strGroup;
        int iHashCode;
        byte b;
        boolean z;
        int i = 0;
        this.zzd.setLength(0);
        int iZzd = zzfpVar.zzd();
        while (!TextUtils.isEmpty(zzfpVar.zzy(zzfwq.zzc))) {
        }
        this.zzc.zzI(zzfpVar.zzM(), zzfpVar.zzd());
        this.zzc.zzK(iZzd);
        ArrayList arrayList = new ArrayList();
        while (true) {
            zzfp zzfpVar2 = this.zzc;
            StringBuilder sb = this.zzd;
            zzc(zzfpVar2);
            if (zzfpVar2.zzb() >= 5 && "::cue".equals(zzfpVar2.zzA(5, zzfwq.zzc))) {
                int iZzd2 = zzfpVar2.zzd();
                String strZza = zza(zzfpVar2, sb);
                if (strZza == null) {
                    strTrim = null;
                } else if ("{".equals(strZza)) {
                    zzfpVar2.zzK(iZzd2);
                    strTrim = "";
                } else {
                    if ("(".equals(strZza)) {
                        int iZzd3 = zzfpVar2.zzd();
                        int iZze = zzfpVar2.zze();
                        int i2 = i;
                        while (iZzd3 < iZze && i2 == 0) {
                            int i3 = iZzd3 + 1;
                            i2 = ((char) zzfpVar2.zzM()[iZzd3]) == ')' ? 1 : i;
                            iZzd3 = i3;
                        }
                        strTrim = zzfpVar2.zzA((iZzd3 - 1) - zzfpVar2.zzd(), zzfwq.zzc).trim();
                    } else {
                        strTrim = null;
                    }
                    if (!")".equals(zza(zzfpVar2, sb))) {
                        strTrim = null;
                    }
                }
            } else {
                strTrim = null;
            }
            if (strTrim == null || !"{".equals(zza(this.zzc, this.zzd))) {
                break;
            }
            zzalz zzalzVar = new zzalz();
            if (!"".equals(strTrim)) {
                int iIndexOf = strTrim.indexOf(91);
                if (iIndexOf != -1) {
                    Matcher matcher2 = zza.matcher(strTrim.substring(iIndexOf));
                    if (matcher2.matches()) {
                        String strGroup2 = matcher2.group(1);
                        strGroup2.getClass();
                        zzalzVar.zzv(strGroup2);
                    }
                    strTrim = strTrim.substring(i, iIndexOf);
                }
                int i4 = zzfy.zza;
                String[] strArrSplit = strTrim.split("\\.", -1);
                String str = strArrSplit[i];
                int iIndexOf2 = str.indexOf(35);
                if (iIndexOf2 != -1) {
                    zzalzVar.zzu(str.substring(i, iIndexOf2));
                    zzalzVar.zzt(str.substring(iIndexOf2 + 1));
                } else {
                    zzalzVar.zzu(str);
                }
                int length = strArrSplit.length;
                if (length > 1) {
                    zzalzVar.zzs((String[]) Arrays.copyOfRange(strArrSplit, 1, length));
                }
            }
            int i5 = i;
            String strZza2 = null;
            while (i5 == 0) {
                zzfp zzfpVar3 = this.zzc;
                StringBuilder sb2 = this.zzd;
                int iZzd4 = zzfpVar3.zzd();
                strZza2 = zza(zzfpVar3, sb2);
                i5 = (strZza2 == null || "}".equals(strZza2)) ? 1 : i;
                if (i5 == 0) {
                    this.zzc.zzK(iZzd4);
                    zzfp zzfpVar4 = this.zzc;
                    StringBuilder sb3 = this.zzd;
                    zzc(zzfpVar4);
                    String strZzd = zzd(zzfpVar4, sb3);
                    if (!"".equals(strZzd) && ":".equals(zza(zzfpVar4, sb3))) {
                        zzc(zzfpVar4);
                        StringBuilder sb4 = new StringBuilder();
                        int i6 = i;
                        while (true) {
                            if (i6 != 0) {
                                string = sb4.toString();
                                break;
                            }
                            int iZzd5 = zzfpVar4.zzd();
                            String strZza3 = zza(zzfpVar4, sb3);
                            if (strZza3 == null) {
                                string = null;
                                break;
                            }
                            if ("}".equals(strZza3) || ";".equals(strZza3)) {
                                zzfpVar4.zzK(iZzd5);
                                i6 = 1;
                            } else {
                                sb4.append(strZza3);
                            }
                        }
                        if (string != null && !"".equals(string)) {
                            int iZzd6 = zzfpVar4.zzd();
                            String strZza4 = zza(zzfpVar4, sb3);
                            if (";".equals(strZza4)) {
                                if (TypedValues.Custom.S_COLOR.equals(strZzd)) {
                                    zzalzVar.zzk(zzen.zza(string));
                                } else if ("background-color".equals(strZzd)) {
                                    zzalzVar.zzh(zzen.zza(string));
                                } else if ("ruby-position".equals(strZzd)) {
                                    if ("over".equals(string)) {
                                        zzalzVar.zzp(1);
                                    } else if ("under".equals(string)) {
                                        zzalzVar.zzp(2);
                                    }
                                } else if ("text-combine-upright".equals(strZzd)) {
                                    if ("all".equals(string)) {
                                        z = true;
                                    } else {
                                        z = true;
                                    }
                                    zzalzVar.zzj(z);
                                } else if ("text-decoration".equals(strZzd)) {
                                    if ("underline".equals(string)) {
                                        zzalzVar.zzq(true);
                                    }
                                } else if ("font-family".equals(strZzd)) {
                                    zzalzVar.zzl(string);
                                } else if ("font-weight".equals(strZzd)) {
                                    if ("bold".equals(string)) {
                                        zzalzVar.zzi(true);
                                    }
                                } else if ("font-style".equals(strZzd)) {
                                    if ("italic".equals(string)) {
                                        zzalzVar.zzo(true);
                                    }
                                } else if ("font-size".equals(strZzd)) {
                                    matcher = zzb.matcher(zzfwk.zza(string));
                                    if (matcher.matches()) {
                                        strGroup = matcher.group(2);
                                        strGroup.getClass();
                                        iHashCode = strGroup.hashCode();
                                        if (iHashCode != 37) {
                                            if (iHashCode != 3240) {
                                                if (iHashCode != 3592) {
                                                    b = -1;
                                                } else {
                                                    b = 0;
                                                }
                                            } else if (strGroup.equals("em")) {
                                                b = 1;
                                            } else {
                                                b = -1;
                                            }
                                        } else if (strGroup.equals("%")) {
                                            b = 2;
                                        } else {
                                            b = -1;
                                        }
                                        if (b != 0) {
                                            zzalzVar.zzn(1);
                                        } else if (b != 1) {
                                            zzalzVar.zzn(2);
                                        } else {
                                            if (b == 2) {
                                                throw new IllegalStateException();
                                            }
                                            zzalzVar.zzn(3);
                                        }
                                        String strGroup3 = matcher.group(1);
                                        strGroup3.getClass();
                                        zzalzVar.zzm(Float.parseFloat(strGroup3));
                                    } else {
                                        zzff.zzf("WebvttCssParser", "Invalid font-size: '" + string + "'.");
                                    }
                                } else {
                                    continue;
                                }
                            } else if ("}".equals(strZza4)) {
                                zzfpVar4.zzK(iZzd6);
                                if (TypedValues.Custom.S_COLOR.equals(strZzd)) {
                                    zzalzVar.zzk(zzen.zza(string));
                                } else if ("background-color".equals(strZzd)) {
                                    zzalzVar.zzh(zzen.zza(string));
                                } else if ("ruby-position".equals(strZzd)) {
                                    if ("over".equals(string)) {
                                        zzalzVar.zzp(1);
                                    } else if ("under".equals(string)) {
                                        zzalzVar.zzp(2);
                                    }
                                } else if ("text-combine-upright".equals(strZzd)) {
                                    if ("all".equals(string) || string.startsWith("digits")) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    zzalzVar.zzj(z);
                                } else if ("text-decoration".equals(strZzd)) {
                                    if ("underline".equals(string)) {
                                        zzalzVar.zzq(true);
                                    }
                                } else if ("font-family".equals(strZzd)) {
                                    zzalzVar.zzl(string);
                                } else if ("font-weight".equals(strZzd)) {
                                    if ("bold".equals(string)) {
                                        zzalzVar.zzi(true);
                                    }
                                } else if ("font-style".equals(strZzd)) {
                                    if ("italic".equals(string)) {
                                        zzalzVar.zzo(true);
                                    }
                                } else if ("font-size".equals(strZzd)) {
                                    matcher = zzb.matcher(zzfwk.zza(string));
                                    if (matcher.matches()) {
                                        zzff.zzf("WebvttCssParser", "Invalid font-size: '" + string + "'.");
                                    } else {
                                        strGroup = matcher.group(2);
                                        strGroup.getClass();
                                        iHashCode = strGroup.hashCode();
                                        if (iHashCode != 37) {
                                            if (iHashCode != 3240) {
                                                if (iHashCode != 3592 && strGroup.equals("px")) {
                                                    b = 0;
                                                } else {
                                                    b = -1;
                                                }
                                            } else if (strGroup.equals("em")) {
                                                b = 1;
                                            } else {
                                                b = -1;
                                            }
                                        } else if (strGroup.equals("%")) {
                                            b = 2;
                                        } else {
                                            b = -1;
                                        }
                                        if (b != 0) {
                                            zzalzVar.zzn(1);
                                        } else if (b != 1) {
                                            zzalzVar.zzn(2);
                                        } else {
                                            if (b == 2) {
                                                throw new IllegalStateException();
                                            }
                                            zzalzVar.zzn(3);
                                        }
                                        String strGroup4 = matcher.group(1);
                                        strGroup4.getClass();
                                        zzalzVar.zzm(Float.parseFloat(strGroup4));
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                i = 0;
            }
            if ("}".equals(strZza2)) {
                arrayList.add(zzalzVar);
            }
            i = 0;
        }
        return arrayList;
    }
}
