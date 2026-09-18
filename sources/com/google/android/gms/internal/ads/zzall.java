package com.google.android.gms.internal.ads;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzall implements zzakr {
    private static final Pattern zza = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");
    private static final Pattern zzb = Pattern.compile("\\{\\\\.*?\\}");
    private final StringBuilder zzc = new StringBuilder();
    private final ArrayList zzd = new ArrayList();
    private final zzfp zze = new zzfp();

    public static float zzb(int i) {
        if (i == 0) {
            return 0.08f;
        }
        if (i == 1) {
            return 0.5f;
        }
        if (i == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }

    private static long zzc(Matcher matcher, int i) {
        String strGroup = matcher.group(i + 1);
        long j = strGroup != null ? Long.parseLong(strGroup) * 3600000 : 0L;
        String strGroup2 = matcher.group(i + 2);
        strGroup2.getClass();
        long j2 = j + (Long.parseLong(strGroup2) * 60000);
        String strGroup3 = matcher.group(i + 3);
        strGroup3.getClass();
        long j3 = j2 + (Long.parseLong(strGroup3) * 1000);
        String strGroup4 = matcher.group(i + 4);
        if (strGroup4 != null) {
            j3 += Long.parseLong(strGroup4);
        }
        return j3 * 1000;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:59:0x013d  */
    /* JADX WARN: Code duplicated, block: B:94:0x0197  */
    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zza(byte[] bArr, int i, int i2, zzakq zzakqVar, zzep zzepVar) {
        String str;
        byte b;
        byte b2;
        int i3;
        zzec zzecVarZzp;
        zzall zzallVar = this;
        zzallVar.zze.zzI(bArr, i + i2);
        zzallVar.zze.zzK(i);
        Charset charsetZzB = zzallVar.zze.zzB();
        if (charsetZzB == null) {
            charsetZzB = zzfwq.zzc;
        }
        while (true) {
            String strZzy = zzallVar.zze.zzy(charsetZzB);
            if (strZzy == null) {
                return;
            }
            if (strZzy.length() != 0) {
                try {
                    Integer.parseInt(strZzy);
                    String strZzy2 = zzallVar.zze.zzy(charsetZzB);
                    if (strZzy2 == null) {
                        zzff.zzf("SubripParser", "Unexpected end");
                        return;
                    }
                    Matcher matcher = zza.matcher(strZzy2);
                    if (matcher.matches()) {
                        long jZzc = zzc(matcher, 1);
                        long jZzc2 = zzc(matcher, 6);
                        int i4 = 0;
                        zzallVar.zzc.setLength(0);
                        zzallVar.zzd.clear();
                        String strZzy3 = zzallVar.zze.zzy(charsetZzB);
                        while (!TextUtils.isEmpty(strZzy3)) {
                            if (zzallVar.zzc.length() > 0) {
                                zzallVar.zzc.append("<br>");
                            }
                            StringBuilder sb = zzallVar.zzc;
                            ArrayList arrayList = zzallVar.zzd;
                            String strTrim = strZzy3.trim();
                            StringBuilder sb2 = new StringBuilder(strTrim);
                            Matcher matcher2 = zzb.matcher(strTrim);
                            int i5 = i4;
                            while (matcher2.find()) {
                                String strGroup = matcher2.group();
                                arrayList.add(strGroup);
                                int iStart = matcher2.start() - i5;
                                int length = strGroup.length();
                                sb2.replace(iStart, iStart + length, "");
                                i5 += length;
                            }
                            sb.append(sb2.toString());
                            strZzy3 = zzallVar.zze.zzy(charsetZzB);
                            i4 = 0;
                        }
                        Spanned spannedFromHtml = Html.fromHtml(zzallVar.zzc.toString());
                        int i6 = 0;
                        while (true) {
                            if (i6 < zzallVar.zzd.size()) {
                                str = (String) zzallVar.zzd.get(i6);
                                if (!str.matches("\\{\\\\an[1-9]\\}")) {
                                    i6++;
                                }
                            } else {
                                str = null;
                            }
                        }
                        zzea zzeaVar = new zzea();
                        zzeaVar.zzl(spannedFromHtml);
                        if (str == null) {
                            zzecVarZzp = zzeaVar.zzp();
                        } else {
                            switch (str) {
                                case "{\an1}":
                                    b = 0;
                                    break;
                                case "{\an3}":
                                    b = 3;
                                    break;
                                case "{\an4}":
                                    b = 1;
                                    break;
                                case "{\an6}":
                                    b = 4;
                                    break;
                                case "{\an7}":
                                    b = 2;
                                    break;
                                case "{\an9}":
                                    b = 5;
                                    break;
                                default:
                                    b = -1;
                                    break;
                            }
                            if (b == 0 || b == 1 || b == 2) {
                                zzeaVar.zzi(0);
                            } else if (b == 3 || b == 4 || b == 5) {
                                zzeaVar.zzi(2);
                            } else {
                                zzeaVar.zzi(1);
                            }
                            switch (str) {
                                case "{\an1}":
                                    b2 = 0;
                                    break;
                                case "{\an2}":
                                    b2 = 1;
                                    break;
                                case "{\an3}":
                                    b2 = 2;
                                    break;
                                case "{\an7}":
                                    b2 = 3;
                                    break;
                                case "{\an8}":
                                    b2 = 4;
                                    break;
                                case "{\an9}":
                                    b2 = 5;
                                    break;
                                default:
                                    b2 = -1;
                                    break;
                            }
                            if (b2 == 0 || b2 == 1) {
                                i3 = 2;
                            } else {
                                if (b2 == 2) {
                                    i3 = 2;
                                } else if (b2 == 3 || b2 == 4 || b2 == 5) {
                                    zzeaVar.zzf(0);
                                } else {
                                    zzeaVar.zzf(1);
                                }
                                zzeaVar.zzh(zzb(zzeaVar.zzb()));
                                zzeaVar.zze(zzb(zzeaVar.zza()), 0);
                                zzecVarZzp = zzeaVar.zzp();
                            }
                            zzeaVar.zzf(i3);
                            zzeaVar.zzh(zzb(zzeaVar.zzb()));
                            zzeaVar.zze(zzb(zzeaVar.zza()), 0);
                            zzecVarZzp = zzeaVar.zzp();
                        }
                        zzepVar.zza(new zzakj(zzgaa.zzm(zzecVarZzp), jZzc, jZzc2 - jZzc));
                    } else {
                        zzff.zzf("SubripParser", "Skipping invalid timing: ".concat(strZzy2));
                    }
                } catch (NumberFormatException unused) {
                    zzff.zzf("SubripParser", "Skipping invalid index: ".concat(strZzy));
                }
            }
            zzallVar = this;
        }
    }
}
