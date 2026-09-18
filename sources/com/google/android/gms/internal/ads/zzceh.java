package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzceh implements zzcdu {
    private final String zza;

    public zzceh() {
        this.zza = null;
    }

    public zzceh(String str) {
        this.zza = str;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00d4 A[PHI: r5
  0x00d4: PHI (r5v1 boolean) = (r5v0 boolean), (r5v0 boolean), (r5v3 boolean) binds: [B:38:0x00d2, B:34:0x00b2, B:19:0x0085] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.ads.zzcdu
    public final boolean zza(String str) {
        boolean z = false;
        try {
            try {
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.setThreadStatsTag(263);
                }
                zzcec.zze("Pinging URL: " + str);
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                try {
                    com.google.android.gms.ads.internal.client.zzay.zzb();
                    String str2 = this.zza;
                    httpURLConnection.setConnectTimeout(60000);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setReadTimeout(60000);
                    if (str2 != null) {
                        httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, str2);
                    }
                    httpURLConnection.setUseCaches(false);
                    zzceb zzcebVar = new zzceb(null);
                    zzcebVar.zzc(httpURLConnection, null);
                    int responseCode = httpURLConnection.getResponseCode();
                    zzcebVar.zze(httpURLConnection, responseCode);
                    if (responseCode < 200 || responseCode >= 300) {
                        zzcec.zzj("Received non-success response code " + responseCode + " from pinging URL: " + str);
                    } else {
                        z = true;
                    }
                    httpURLConnection.disconnect();
                    if (ClientLibraryUtils.isPackageSide()) {
                        TrafficStats.clearThreadStatsTag();
                    }
                    return z;
                } catch (Throwable th) {
                    httpURLConnection.disconnect();
                    throw th;
                }
            } catch (IOException e) {
                e = e;
                zzcec.zzj("Error while pinging URL: " + str + ". " + e.getMessage());
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.clearThreadStatsTag();
                }
            } catch (IndexOutOfBoundsException e2) {
                zzcec.zzj("Error while parsing ping URL: " + str + ". " + e2.getMessage());
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.clearThreadStatsTag();
                }
            } catch (RuntimeException e3) {
                e = e3;
                zzcec.zzj("Error while pinging URL: " + str + ". " + e.getMessage());
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.clearThreadStatsTag();
                }
            }
        } catch (Throwable th2) {
            if (ClientLibraryUtils.isPackageSide()) {
                TrafficStats.clearThreadStatsTag();
            }
            throw th2;
        }
    }
}
