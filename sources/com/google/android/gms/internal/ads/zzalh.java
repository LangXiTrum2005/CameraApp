package com.google.android.gms.internal.ads;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.work.WorkRequest;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzalh implements zzakr {
    private static final Pattern zza = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    private final boolean zzb;
    private final zzalg zzc;
    private final zzfp zzd;
    private Map zze;
    private float zzf;
    private float zzg;

    public zzalh() {
        this(null);
    }

    private static float zzb(int i) {
        if (i == 0) {
            return 0.05f;
        }
        if (i != 1) {
            return i != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    private static int zzc(long j, List list, List list2) {
        int i;
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                i = 0;
                break;
            }
            if (((Long) list.get(size)).longValue() == j) {
                return size;
            }
            if (((Long) list.get(size)).longValue() < j) {
                i = size + 1;
                break;
            }
        }
        list.add(i, Long.valueOf(j));
        list2.add(i, i == 0 ? new ArrayList() : new ArrayList((Collection) list2.get(i - 1)));
        return i;
    }

    private static long zzd(String str) {
        Matcher matcher = zza.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        String strGroup = matcher.group(1);
        int i = zzfy.zza;
        long j = Long.parseLong(strGroup) * 3600000000L;
        long j2 = Long.parseLong(matcher.group(2)) * 60000000;
        return j + j2 + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * WorkRequest.MIN_BACKOFF_MILLIS);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x0053  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void zze(zzfp zzfpVar, Charset charset) {
        while (true) {
            String strZzy = zzfpVar.zzy(charset);
            if (strZzy == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(strZzy)) {
                while (true) {
                    String strZzy2 = zzfpVar.zzy(charset);
                    if (strZzy2 == null || (zzfpVar.zzb() != 0 && zzfpVar.zza(charset) == '[')) {
                        break;
                    }
                    String[] strArrSplit = strZzy2.split(":");
                    if (strArrSplit.length == 2) {
                        byte b = 0;
                        String strZza = zzfwk.zza(strArrSplit[0].trim());
                        switch (strZza.hashCode()) {
                            case 1879649548:
                                if (!strZza.equals("playresx")) {
                                    b = -1;
                                }
                                break;
                            case 1879649549:
                                if (!strZza.equals("playresy")) {
                                    b = -1;
                                } else {
                                    b = 1;
                                }
                                break;
                            default:
                                b = -1;
                                break;
                        }
                        if (b == 0) {
                            this.zzf = Float.parseFloat(strArrSplit[1].trim());
                        } else if (b == 1) {
                            try {
                                this.zzg = Float.parseFloat(strArrSplit[1].trim());
                            } catch (NumberFormatException unused) {
                            }
                        }
                    }
                }
            } else if ("[V4+ Styles]".equalsIgnoreCase(strZzy)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                zzali zzaliVarZza = null;
                while (true) {
                    String strZzy3 = zzfpVar.zzy(charset);
                    if (strZzy3 != null && (zzfpVar.zzb() == 0 || zzfpVar.zza(charset) != '[')) {
                        if (strZzy3.startsWith("Format:")) {
                            zzaliVarZza = zzali.zza(strZzy3);
                        } else if (strZzy3.startsWith("Style:")) {
                            if (zzaliVarZza == null) {
                                zzff.zzf("SsaParser", "Skipping 'Style:' line before 'Format:' line: ".concat(strZzy3));
                            } else {
                                zzalk zzalkVarZzb = zzalk.zzb(strZzy3, zzaliVarZza);
                                if (zzalkVarZzb != null) {
                                    linkedHashMap.put(zzalkVarZzb.zza, zzalkVarZzb);
                                }
                            }
                        }
                    }
                }
                this.zze = linkedHashMap;
            } else if ("[V4 Styles]".equalsIgnoreCase(strZzy)) {
                zzff.zze("SsaParser", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(strZzy)) {
                return;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:119:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:132:0x02db A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x019c  */
    /* JADX WARN: Code duplicated, block: B:68:0x01ac  */
    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zza(byte[] bArr, int i, int i2, zzakq zzakqVar, zzep zzepVar) {
        int i3;
        zzfp zzfpVar;
        int i4;
        Layout.Alignment alignment;
        int i5;
        int i6;
        int i7;
        Integer num;
        int i8;
        zzalh zzalhVar = this;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        zzalhVar.zzd.zzI(bArr, i + i2);
        zzalhVar.zzd.zzK(i);
        Charset charsetZzB = zzalhVar.zzd.zzB();
        if (charsetZzB == null) {
            charsetZzB = zzfwq.zzc;
        }
        if (!zzalhVar.zzb) {
            zzalhVar.zze(zzalhVar.zzd, charsetZzB);
        }
        zzfp zzfpVar2 = zzalhVar.zzd;
        zzalg zzalgVarZza = zzalhVar.zzb ? zzalhVar.zzc : null;
        while (true) {
            String strZzy = zzfpVar2.zzy(charsetZzB);
            if (strZzy == null) {
                int i9 = 0;
                while (i9 < arrayList.size()) {
                    List list = (List) arrayList.get(i9);
                    if (!list.isEmpty()) {
                        if (i9 != arrayList.size() - 1) {
                            throw new IllegalStateException();
                        }
                        zzepVar.zza(new zzakj(list, ((Long) arrayList2.get(i9)).longValue(), ((Long) arrayList2.get(i9 + 1)).longValue() - ((Long) arrayList2.get(i9)).longValue()));
                        i3 = 1;
                    } else if (i9 != 0) {
                        i3 = 1;
                    } else {
                        i9 = 0;
                        if (i9 != arrayList.size() - 1) {
                            throw new IllegalStateException();
                        }
                        zzepVar.zza(new zzakj(list, ((Long) arrayList2.get(i9)).longValue(), ((Long) arrayList2.get(i9 + 1)).longValue() - ((Long) arrayList2.get(i9)).longValue()));
                        i3 = 1;
                    }
                    i9 += i3;
                }
                return;
            }
            if (strZzy.startsWith("Format:")) {
                zzalgVarZza = zzalg.zza(strZzy);
            } else {
                if (strZzy.startsWith("Dialogue:")) {
                    if (zzalgVarZza == null) {
                        zzff.zzf("SsaParser", "Skipping dialogue line before complete format: ".concat(strZzy));
                    } else {
                        zzek.zzd(strZzy.startsWith("Dialogue:"));
                        String[] strArrSplit = strZzy.substring(9).split(",", zzalgVarZza.zze);
                        if (strArrSplit.length != zzalgVarZza.zze) {
                            zzff.zzf("SsaParser", "Skipping dialogue line with fewer columns than format: ".concat(strZzy));
                        } else {
                            long jZzd = zzd(strArrSplit[zzalgVarZza.zza]);
                            if (jZzd == -9223372036854775807L) {
                                zzff.zzf("SsaParser", "Skipping invalid timing: ".concat(strZzy));
                            } else {
                                long jZzd2 = zzd(strArrSplit[zzalgVarZza.zzb]);
                                if (jZzd2 == -9223372036854775807L) {
                                    zzff.zzf("SsaParser", "Skipping invalid timing: ".concat(strZzy));
                                } else {
                                    Map map = zzalhVar.zze;
                                    zzalk zzalkVar = (map == null || (i8 = zzalgVarZza.zzc) == -1) ? null : (zzalk) map.get(strArrSplit[i8].trim());
                                    String str = strArrSplit[zzalgVarZza.zzd];
                                    zzalj zzaljVarZza = zzalj.zza(str);
                                    String strReplace = zzalj.zzb(str).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " ");
                                    float f = zzalhVar.zzf;
                                    float f2 = zzalhVar.zzg;
                                    SpannableString spannableString = new SpannableString(strReplace);
                                    zzea zzeaVar = new zzea();
                                    zzeaVar.zzl(spannableString);
                                    if (zzalkVar != null) {
                                        Integer num2 = zzalkVar.zzc;
                                        zzfpVar = zzfpVar2;
                                        if (num2 != null) {
                                            spannableString.setSpan(new ForegroundColorSpan(num2.intValue()), 0, spannableString.length(), 33);
                                        }
                                        if (zzalkVar.zzj == 3 && (num = zzalkVar.zzd) != null) {
                                            spannableString.setSpan(new BackgroundColorSpan(num.intValue()), 0, spannableString.length(), 33);
                                        }
                                        float f3 = zzalkVar.zze;
                                        if (f3 != -3.4028235E38f && f2 != -3.4028235E38f) {
                                            zzeaVar.zzn(f3 / f2, 1);
                                        }
                                        if (!zzalkVar.zzf) {
                                            i6 = 33;
                                            i7 = 0;
                                            if (zzalkVar.zzg) {
                                                i4 = 2;
                                                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
                                            }
                                            if (zzalkVar.zzh) {
                                                spannableString.setSpan(new UnderlineSpan(), i7, spannableString.length(), i6);
                                            }
                                            if (zzalkVar.zzi) {
                                                spannableString.setSpan(new StrikethroughSpan(), i7, spannableString.length(), i6);
                                            }
                                        } else if (zzalkVar.zzg) {
                                            i6 = 33;
                                            i7 = 0;
                                            spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
                                        } else {
                                            i6 = 33;
                                            i7 = 0;
                                            spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
                                        }
                                        i4 = 2;
                                        if (zzalkVar.zzh) {
                                            spannableString.setSpan(new UnderlineSpan(), i7, spannableString.length(), i6);
                                        }
                                        if (zzalkVar.zzi) {
                                            spannableString.setSpan(new StrikethroughSpan(), i7, spannableString.length(), i6);
                                        }
                                    } else {
                                        zzfpVar = zzfpVar2;
                                        zzalgVarZza = zzalgVarZza;
                                        jZzd2 = jZzd2;
                                        i4 = 2;
                                    }
                                    int i10 = zzaljVarZza.zza;
                                    if (i10 == -1) {
                                        i10 = zzalkVar != null ? zzalkVar.zzb : -1;
                                    }
                                    switch (i10) {
                                        case 0:
                                        default:
                                            zzff.zzf("SsaParser", "Unknown alignment: " + i10);
                                        case -1:
                                            alignment = null;
                                            break;
                                        case 1:
                                        case 4:
                                        case 7:
                                            alignment = Layout.Alignment.ALIGN_NORMAL;
                                            break;
                                        case 2:
                                        case 5:
                                        case 8:
                                            alignment = Layout.Alignment.ALIGN_CENTER;
                                            break;
                                        case 3:
                                        case 6:
                                        case 9:
                                            alignment = Layout.Alignment.ALIGN_OPPOSITE;
                                            break;
                                    }
                                    zzeaVar.zzm(alignment);
                                    int i11 = Integer.MIN_VALUE;
                                    switch (i10) {
                                        case 0:
                                        default:
                                            zzff.zzf("SsaParser", "Unknown alignment: " + i10);
                                        case -1:
                                            i5 = Integer.MIN_VALUE;
                                            break;
                                        case 1:
                                        case 4:
                                        case 7:
                                            i5 = 0;
                                            break;
                                        case 2:
                                        case 5:
                                        case 8:
                                            i5 = 1;
                                            break;
                                        case 3:
                                        case 6:
                                        case 9:
                                            i5 = i4;
                                            break;
                                    }
                                    zzeaVar.zzi(i5);
                                    switch (i10) {
                                        case -1:
                                            break;
                                        case 0:
                                        default:
                                            zzff.zzf("SsaParser", "Unknown alignment: " + i10);
                                            break;
                                        case 1:
                                        case 2:
                                        case 3:
                                            i11 = i4;
                                            break;
                                        case 4:
                                        case 5:
                                        case 6:
                                            i11 = 1;
                                            break;
                                        case 7:
                                        case 8:
                                        case 9:
                                            i11 = 0;
                                            break;
                                    }
                                    zzeaVar.zzf(i11);
                                    PointF pointF = zzaljVarZza.zzb;
                                    if (pointF == null || f2 == -3.4028235E38f || f == -3.4028235E38f) {
                                        zzeaVar.zzh(zzb(zzeaVar.zzb()));
                                        zzeaVar.zze(zzb(zzeaVar.zza()), 0);
                                    } else {
                                        zzeaVar.zzh(pointF.x / f);
                                        zzeaVar.zze(zzaljVarZza.zzb.y / f2, 0);
                                    }
                                    zzec zzecVarZzp = zzeaVar.zzp();
                                    int iZzc = zzc(jZzd2, arrayList2, arrayList);
                                    for (int iZzc2 = zzc(jZzd, arrayList2, arrayList); iZzc2 < iZzc; iZzc2++) {
                                        ((List) arrayList.get(iZzc2)).add(zzecVarZzp);
                                    }
                                }
                            }
                        }
                    }
                    zzfpVar = zzfpVar2;
                    zzalgVarZza = zzalgVarZza;
                } else {
                    zzfpVar = zzfpVar2;
                    zzalgVarZza = zzalgVarZza;
                }
                zzalhVar = this;
                charsetZzB = charsetZzB;
                zzfpVar2 = zzfpVar;
                zzalgVarZza = zzalgVarZza;
            }
        }
    }

    public zzalh(List list) {
        this.zzf = -3.4028235E38f;
        this.zzg = -3.4028235E38f;
        this.zzd = new zzfp();
        if (list == null || list.isEmpty()) {
            this.zzb = false;
            this.zzc = null;
            return;
        }
        this.zzb = true;
        String strZzz = zzfy.zzz((byte[]) list.get(0));
        zzek.zzd(strZzz.startsWith("Format:"));
        zzalg zzalgVarZza = zzalg.zza(strZzz);
        zzalgVarZza.getClass();
        this.zzc = zzalgVarZza;
        zze(new zzfp((byte[]) list.get(1)), zzfwq.zzc);
    }
}
