package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.util.Constants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcja extends zzgq implements zzht {
    private static final Pattern zzb = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final zzhs zzf;
    private zzhb zzg;
    private HttpURLConnection zzh;
    private final Queue zzi;
    private InputStream zzj;
    private boolean zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;
    private final long zzr;
    private final long zzs;

    zzcja(String str, zzhy zzhyVar, int i, int i2, long j, long j2) {
        super(true);
        zzek.zzc(str);
        this.zze = str;
        this.zzf = new zzhs();
        this.zzc = i;
        this.zzd = i2;
        this.zzi = new ArrayDeque();
        this.zzr = j;
        this.zzs = j2;
        if (zzhyVar != null) {
            zzf(zzhyVar);
        }
    }

    private final void zzl() {
        while (!this.zzi.isEmpty()) {
            try {
                ((HttpURLConnection) this.zzi.remove()).disconnect();
            } catch (Exception e) {
                zzcec.zzh("Unexpected error while disconnecting", e);
            }
        }
        this.zzh = null;
    }

    @Override // com.google.android.gms.internal.ads.zzu
    public final int zza(byte[] bArr, int i, int i2) throws zzhp {
        if (i2 == 0) {
            return 0;
        }
        try {
            long j = this.zzm;
            long j2 = this.zzn;
            if (j - j2 == 0) {
                return -1;
            }
            long j3 = this.zzo + j2;
            long j4 = i2;
            long j5 = this.zzs;
            long j6 = j3 + j4 + j5;
            long j7 = this.zzq;
            long j8 = j7 + 1;
            if (j6 > j8) {
                long j9 = this.zzp;
                if (j7 < j9) {
                    long jMin = Math.min(j9, Math.max(((this.zzr + j8) - j5) - 1, (-1) + j8 + j4));
                    zzk(j8, jMin, 2);
                    this.zzq = jMin;
                    j7 = jMin;
                }
            }
            int i3 = this.zzj.read(bArr, i, (int) Math.min(j4, ((j7 + 1) - this.zzo) - this.zzn));
            if (i3 == -1) {
                throw new EOFException();
            }
            this.zzn += (long) i3;
            zzg(i3);
            return i3;
        } catch (IOException e) {
            throw new zzhp(e, this.zzg, Constants.MAX_URL_LENGTH, 2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final long zzb(zzhb zzhbVar) throws zzhp {
        this.zzg = zzhbVar;
        this.zzn = 0L;
        long j = zzhbVar.zzf;
        long j2 = zzhbVar.zzg;
        long jMin = j2 == -1 ? this.zzr : Math.min(this.zzr, j2);
        this.zzo = j;
        HttpURLConnection httpURLConnectionZzk = zzk(j, (jMin + j) - 1, 1);
        this.zzh = httpURLConnectionZzk;
        String headerField = httpURLConnectionZzk.getHeaderField(HttpHeaders.CONTENT_RANGE);
        if (!TextUtils.isEmpty(headerField)) {
            Matcher matcher = zzb.matcher(headerField);
            if (matcher.find()) {
                try {
                    Long.parseLong(matcher.group(1));
                    long j3 = Long.parseLong(matcher.group(2));
                    long j4 = Long.parseLong(matcher.group(3));
                    long j5 = zzhbVar.zzg;
                    if (j5 != -1) {
                        this.zzm = j5;
                        this.zzp = Math.max(j3, (this.zzo + j5) - 1);
                    } else {
                        this.zzm = j4 - this.zzo;
                        this.zzp = j4 - 1;
                    }
                    this.zzq = j3;
                    this.zzk = true;
                    zzj(zzhbVar);
                    return this.zzm;
                } catch (NumberFormatException unused) {
                    zzcec.zzg("Unexpected Content-Range [" + headerField + "]");
                }
            }
        }
        throw new zzciy(headerField, zzhbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0025 */
    @Override // com.google.android.gms.internal.ads.zzgw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzd() throws com.google.android.gms.internal.ads.zzhp {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r7.zzj     // Catch: java.lang.Throwable -> L25
            if (r2 == 0) goto L16
            r2.close()     // Catch: java.io.IOException -> La java.lang.Throwable -> L25
            goto L16
        La:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzhp r3 = new com.google.android.gms.internal.ads.zzhp     // Catch: java.lang.Throwable -> L25
            com.google.android.gms.internal.ads.zzhb r4 = r7.zzg     // Catch: java.lang.Throwable -> L25
            r5 = 2000(0x7d0, float:2.803E-42)
            r6 = 3
            r3.<init>(r2, r4, r5, r6)     // Catch: java.lang.Throwable -> L25
            throw r3     // Catch: java.lang.Throwable -> L25
        L16:
            r7.zzj = r1
            r7.zzl()
            boolean r1 = r7.zzk
            if (r1 == 0) goto L24
            r7.zzk = r0
            r7.zzh()
        L24:
            return
        L25:
            r2 = move-exception
            r7.zzj = r1
            r7.zzl()
            boolean r1 = r7.zzk
            if (r1 == 0) goto L34
            r7.zzk = r0
            r7.zzh()
        L34:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcja.zzd():void");
    }

    @Override // com.google.android.gms.internal.ads.zzgq, com.google.android.gms.internal.ads.zzgw
    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    final HttpURLConnection zzk(long j, long j2, int i) throws zzhp {
        String string = this.zzg.zza.toString();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(string).openConnection();
            httpURLConnection.setConnectTimeout(this.zzc);
            httpURLConnection.setReadTimeout(this.zzd);
            for (Map.Entry entry : this.zzf.zza().entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            httpURLConnection.setRequestProperty(HttpHeaders.RANGE, "bytes=" + j + "-" + j2);
            httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, this.zze);
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "identity");
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            this.zzi.add(httpURLConnection);
            String string2 = this.zzg.zza.toString();
            try {
                int responseCode = httpURLConnection.getResponseCode();
                this.zzl = responseCode;
                if (responseCode < 200 || responseCode > 299) {
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    zzl();
                    throw new zzciz(this.zzl, headerFields, this.zzg, i);
                }
                try {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (this.zzj != null) {
                        inputStream = new SequenceInputStream(this.zzj, inputStream);
                    }
                    this.zzj = inputStream;
                    return httpURLConnection;
                } catch (IOException e) {
                    zzl();
                    throw new zzhp(e, this.zzg, Constants.MAX_URL_LENGTH, i);
                }
            } catch (IOException e2) {
                zzl();
                throw new zzhp("Unable to connect to ".concat(String.valueOf(string2)), e2, this.zzg, Constants.MAX_URL_LENGTH, i);
            }
        } catch (IOException e3) {
            throw new zzhp("Unable to connect to ".concat(String.valueOf(string)), e3, this.zzg, Constants.MAX_URL_LENGTH, i);
        }
    }
}
