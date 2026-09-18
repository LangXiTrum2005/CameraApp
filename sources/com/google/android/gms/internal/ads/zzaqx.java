package com.google.android.gms.internal.ads;

import com.google.common.net.HttpHeaders;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaqx {
    public static long zza(String str) {
        try {
            return zzd("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e) {
            if ("0".equals(str) || "-1".equals(str)) {
                zzaqm.zzd("Unable to parse dateStr: %s, falling back to 0", str);
                return 0L;
            }
            zzaqm.zzc(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    public static zzapj zzb(zzapw zzapwVar) {
        boolean z;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map map = zzapwVar.zzc;
        if (map == null) {
            return null;
        }
        String str = (String) map.get(HttpHeaders.DATE);
        long jZza = str != null ? zza(str) : 0L;
        String str2 = (String) map.get(HttpHeaders.CACHE_CONTROL);
        int i = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",", 0);
            z = false;
            j = 0;
            j2 = 0;
            while (i < strArrSplit.length) {
                String strTrim = strArrSplit[i].trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j = Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    z = true;
                }
                i++;
            }
            i = 1;
        } else {
            z = false;
            j = 0;
            j2 = 0;
        }
        String str3 = (String) map.get(HttpHeaders.EXPIRES);
        long jZza2 = str3 != null ? zza(str3) : 0L;
        String str4 = (String) map.get(HttpHeaders.LAST_MODIFIED);
        long jZza3 = str4 != null ? zza(str4) : 0L;
        String str5 = (String) map.get(HttpHeaders.ETAG);
        if (i != 0) {
            j4 = jCurrentTimeMillis + (j2 * 1000);
            if (z) {
                j5 = j4;
            } else {
                Long.signum(j);
                j5 = (j * 1000) + j4;
            }
            j3 = j5;
        } else {
            j3 = 0;
            if (jZza <= 0 || jZza2 < jZza) {
                j4 = 0;
            } else {
                j4 = jCurrentTimeMillis + (jZza2 - jZza);
                j3 = j4;
            }
        }
        zzapj zzapjVar = new zzapj();
        zzapjVar.zza = zzapwVar.zzb;
        zzapjVar.zzb = str5;
        zzapjVar.zzf = j4;
        zzapjVar.zze = j3;
        zzapjVar.zzc = jZza;
        zzapjVar.zzd = jZza3;
        zzapjVar.zzg = map;
        zzapjVar.zzh = zzapwVar.zzd;
        return zzapjVar;
    }

    static String zzc(long j) {
        return zzd("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j));
    }

    private static SimpleDateFormat zzd(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
