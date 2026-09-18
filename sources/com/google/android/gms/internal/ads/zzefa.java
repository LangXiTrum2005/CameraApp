package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.util.IOUtils;
import com.google.common.net.HttpHeaders;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzefa implements zzfkp {
    protected final Context zza;
    protected final String zzb;
    protected final zzbzq zzc;

    public zzefa(Context context, String str, zzbzq zzbzqVar, int i) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzbzqVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v6, types: [boolean] */
    @Override // com.google.android.gms.internal.ads.zzfkp
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzeez zza(zzeey zzeeyVar) throws zzead {
        int i;
        HttpURLConnection httpURLConnection;
        zzeez zzeezVar;
        zzefa zzefaVar = this;
        String str = zzeeyVar.zza;
        int i2 = zzeeyVar.zzb;
        Map map = zzeeyVar.zzc;
        byte[] bArr = zzeeyVar.zzd;
        String str2 = zzeeyVar.zze;
        long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
        byte b = 1;
        b = 1;
        try {
            zzeez zzeezVar2 = new zzeez();
            zzcec.zzi("SDK version: " + zzefaVar.zzb);
            zzcec.zze("AdRequestServiceImpl: Sending request: " + str);
            URL url = new URL(str);
            HashMap map2 = new HashMap();
            int i3 = 0;
            while (true) {
                httpURLConnection = (HttpURLConnection) url.openConnection();
                try {
                    com.google.android.gms.ads.internal.util.zzt zztVarZzp = com.google.android.gms.ads.internal.zzt.zzp();
                    Context context = zzefaVar.zza;
                    String str3 = zzefaVar.zzb;
                    zzeez zzeezVar3 = zzeezVar2;
                    i = b == true ? 1 : 0;
                    try {
                        try {
                            zztVarZzp.zzf(context, str3, false, httpURLConnection, false, i2);
                            for (Map.Entry entry : map.entrySet()) {
                                httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                            }
                            if (!TextUtils.isEmpty(str2)) {
                                httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, str2);
                            }
                            int length = bArr.length;
                            Closeable closeable = null;
                            if (length > 0) {
                                httpURLConnection.setDoOutput(i);
                                httpURLConnection.setFixedLengthStreamingMode(length);
                                try {
                                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                                    try {
                                        bufferedOutputStream.write(bArr);
                                        IOUtils.closeQuietly(bufferedOutputStream);
                                    } catch (Throwable th) {
                                        th = th;
                                        closeable = bufferedOutputStream;
                                        IOUtils.closeQuietly(closeable);
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                            zzceb zzcebVar = new zzceb(null);
                            zzcebVar.zzc(httpURLConnection, bArr);
                            int responseCode = httpURLConnection.getResponseCode();
                            for (Map.Entry<String, List<String>> entry2 : httpURLConnection.getHeaderFields().entrySet()) {
                                String key = entry2.getKey();
                                List<String> value = entry2.getValue();
                                if (map2.containsKey(key)) {
                                    ((List) map2.get(key)).addAll(value);
                                } else {
                                    map2.put(key, new ArrayList(value));
                                }
                            }
                            zzcebVar.zze(httpURLConnection, responseCode);
                            zzeezVar = zzeezVar3;
                            try {
                                zzeezVar.zza = responseCode;
                                zzeezVar.zzb = map2;
                                zzeezVar.zzc = "";
                                if (responseCode >= 200 && responseCode < 300) {
                                    try {
                                        InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                                        try {
                                            com.google.android.gms.ads.internal.zzt.zzp();
                                            String strZzM = com.google.android.gms.ads.internal.util.zzt.zzM(inputStreamReader);
                                            IOUtils.closeQuietly(inputStreamReader);
                                            zzcebVar.zzg(strZzM);
                                            zzeezVar.zzc = strZzM;
                                            if (TextUtils.isEmpty(strZzM)) {
                                                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzft)).booleanValue()) {
                                                    throw new zzead(3);
                                                }
                                            }
                                            zzeezVar.zzd = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime;
                                            break;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            closeable = inputStreamReader;
                                            IOUtils.closeQuietly(closeable);
                                            throw th;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                    }
                                } else {
                                    if (responseCode < 300 || responseCode >= 400) {
                                        zzcec.zzj("Received error HTTP response code: " + responseCode);
                                        throw new zzead(i == true ? 1 : 0, "Received error HTTP response code: " + responseCode);
                                    }
                                    String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                                    if (TextUtils.isEmpty(headerField)) {
                                        zzcec.zzj("No location header to follow redirect.");
                                        throw new zzead(i == true ? 1 : 0, "No location header to follow redirect");
                                    }
                                    URL url2 = new URL(headerField);
                                    i3 += i == true ? 1 : 0;
                                    if (i3 > ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeT)).intValue()) {
                                        zzcec.zzj("Too many redirects.");
                                        throw new zzead(i == true ? 1 : 0, "Too many redirects");
                                    }
                                    try {
                                        httpURLConnection.disconnect();
                                        b = i == true ? 1 : 0;
                                        url = url2;
                                        zzeezVar2 = zzeezVar;
                                        zzefaVar = this;
                                    } catch (IOException e) {
                                        e = e;
                                        String strConcat = "Error while connecting to ad server: ".concat(String.valueOf(e.getMessage()));
                                        zzcec.zzj(strConcat);
                                        throw new zzead(i, strConcat, e);
                                    }
                                }
                            } catch (zzead e2) {
                                e = e2;
                                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzih)).booleanValue()) {
                                    throw e;
                                }
                                zzeezVar.zzd = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            httpURLConnection.disconnect();
                            throw th;
                        }
                    } catch (zzead e3) {
                        e = e3;
                        zzeezVar = zzeezVar3;
                    }
                } catch (zzead e4) {
                    e = e4;
                    zzeezVar = zzeezVar2;
                    byte b2 = b == true ? 1 : 0;
                } catch (Throwable th6) {
                    th = th6;
                    byte b3 = b == true ? 1 : 0;
                }
            }
            httpURLConnection.disconnect();
            return zzeezVar;
        } catch (IOException e5) {
            e = e5;
            i = b;
        }
    }
}
