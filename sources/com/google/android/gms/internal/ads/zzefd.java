package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzefd implements zzfkp {
    private static final Pattern zza = Pattern.compile("([^;]+=[^;]+)(;\\s|$)", 2);
    private final String zzb;
    private final zzfmo zzc;
    private final zzfmz zzd;

    public zzefd(String str, zzfmz zzfmzVar, zzfmo zzfmoVar) {
        this.zzb = str;
        this.zzd = zzfmzVar;
        this.zzc = zzfmoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfkp
    public final /* bridge */ /* synthetic */ Object zza(Object obj) throws Exception {
        zzead zzeadVar;
        String strConcat;
        zzefc zzefcVar = (zzefc) obj;
        int iOptInt = zzefcVar.zza.optInt("http_timeout_millis", 60000);
        zzbzh zzbzhVar = zzefcVar.zzb;
        String strJoin = "";
        if (zzbzhVar.zza() != -2) {
            if (zzbzhVar.zza() == 1) {
                if (zzbzhVar.zzf() != null) {
                    strJoin = TextUtils.join(", ", zzbzhVar.zzf());
                    zzcec.zzg(strJoin);
                }
                zzeadVar = new zzead(2, "Error building request URL: ".concat(String.valueOf(strJoin)));
            } else {
                zzeadVar = new zzead(1);
            }
            zzfmz zzfmzVar = this.zzd;
            zzfmo zzfmoVar = this.zzc;
            zzfmoVar.zzg(zzeadVar);
            zzfmoVar.zzf(false);
            zzfmzVar.zza(zzfmoVar);
            throw zzeadVar;
        }
        HashMap map = new HashMap();
        if (zzefcVar.zzb.zzh() && !TextUtils.isEmpty(this.zzb)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaO)).booleanValue()) {
                String str = this.zzb;
                if (TextUtils.isEmpty(str)) {
                    strConcat = "";
                } else {
                    Matcher matcher = zza.matcher(str);
                    strConcat = "";
                    while (matcher.find()) {
                        String strGroup = matcher.group(1);
                        if (strGroup != null && (strGroup.toLowerCase(Locale.ROOT).startsWith("id=") || strGroup.toLowerCase(Locale.ROOT).startsWith("ide="))) {
                            if (!TextUtils.isEmpty(strConcat)) {
                                strConcat = strConcat.concat("; ");
                            }
                            strConcat = strConcat.concat(strGroup);
                        }
                    }
                }
                if (!TextUtils.isEmpty(strConcat)) {
                    map.put(HttpHeaders.COOKIE, strConcat);
                }
            } else {
                map.put(HttpHeaders.COOKIE, this.zzb);
            }
        }
        if (zzefcVar.zzb.zzi()) {
            zzefe.zza(map, zzefcVar.zza);
        }
        if (zzefcVar.zzb != null && !TextUtils.isEmpty(zzefcVar.zzb.zzd())) {
            strJoin = zzefcVar.zzb.zzd();
        }
        zzfmz zzfmzVar2 = this.zzd;
        zzfmo zzfmoVar2 = this.zzc;
        zzfmoVar2.zzf(true);
        zzfmzVar2.zza(zzfmoVar2);
        return new zzeey(zzefcVar.zzb.zze(), iOptInt, map, strJoin.getBytes(zzfwq.zzc), "", zzefcVar.zzb.zzi());
    }
}
