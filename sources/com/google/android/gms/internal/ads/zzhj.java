package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.util.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhj extends zzgq implements zzht {
    private final boolean zzb;
    private final int zzc;
    private final int zzd;
    private final String zze;
    private final zzhs zzf;
    private final zzhs zzg;
    private zzhb zzh;
    private HttpURLConnection zzi;
    private InputStream zzj;
    private boolean zzk;
    private int zzl;
    private long zzm;
    private long zzn;

    @Deprecated
    public zzhj() {
        this(null, 8000, 8000, false, null, null, false);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0070  */
    private final HttpURLConnection zzk(URL url, int i, byte[] bArr, long j, long j2, boolean z, boolean z2, Map map) throws IOException {
        StringBuilder sb;
        String string;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.zzc);
        httpURLConnection.setReadTimeout(this.zzd);
        HashMap map2 = new HashMap();
        map2.putAll(this.zzf.zza());
        map2.putAll(this.zzg.zza());
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        if (j != 0) {
            sb = new StringBuilder("bytes=");
            sb.append(j);
            sb.append("-");
            if (j2 != -1) {
                sb.append((j + j2) - 1);
            }
            string = sb.toString();
        } else if (j2 == -1) {
            string = null;
        } else {
            j = 0;
            sb = new StringBuilder("bytes=");
            sb.append(j);
            sb.append("-");
            if (j2 != -1) {
                sb.append((j + j2) - 1);
            }
            string = sb.toString();
        }
        if (string != null) {
            httpURLConnection.setRequestProperty(HttpHeaders.RANGE, string);
        }
        String str = this.zze;
        if (str != null) {
            httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, str);
        }
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, true != z ? "identity" : "gzip");
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(false);
        int i2 = zzhb.zzj;
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return httpURLConnection;
    }

    private final URL zzl(URL url, String str, zzhb zzhbVar) throws zzhp {
        if (str == null) {
            throw new zzhp("Null location redirect", zzhbVar, 2001, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!"https".equals(protocol) && !"http".equals(protocol)) {
                throw new zzhp("Unsupported protocol redirect: ".concat(String.valueOf(protocol)), zzhbVar, 2001, 1);
            }
            if (this.zzb || protocol.equals(url.getProtocol())) {
                return url2;
            }
            throw new zzhp("Disallowed cross-protocol redirect (" + url.getProtocol() + " to " + protocol + ")", zzhbVar, 2001, 1);
        } catch (MalformedURLException e) {
            throw new zzhp(e, zzhbVar, 2001, 1);
        }
    }

    private final void zzm() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                zzff.zzd("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.zzi = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0028  */
    /* JADX WARN: Code duplicated, block: B:13:0x0029 A[Catch: IOException -> 0x0033, TRY_LEAVE, TryCatch #0 {IOException -> 0x0033, blocks: (B:4:0x0004, B:6:0x000d, B:9:0x0018, B:10:0x001e, B:13:0x0029), top: B:18:0x0004 }] */
    @Override // com.google.android.gms.internal.ads.zzu
    public final int zza(byte[] bArr, int i, int i2) throws zzhp {
        int i3;
        if (i2 == 0) {
            return 0;
        }
        try {
            long j = this.zzm;
            if (j != -1) {
                long j2 = j - this.zzn;
                if (j2 != 0) {
                    i2 = (int) Math.min(i2, j2);
                    InputStream inputStream = this.zzj;
                    int i4 = zzfy.zza;
                    i3 = inputStream.read(bArr, i, i2);
                    if (i3 == -1) {
                        this.zzn += (long) i3;
                        zzg(i3);
                        return i3;
                    }
                }
            } else {
                InputStream inputStream2 = this.zzj;
                int i5 = zzfy.zza;
                i3 = inputStream2.read(bArr, i, i2);
                if (i3 == -1) {
                    this.zzn += (long) i3;
                    zzg(i3);
                    return i3;
                }
            }
            return -1;
        } catch (IOException e) {
            zzhb zzhbVar = this.zzh;
            int i6 = zzfy.zza;
            throw zzhp.zza(e, zzhbVar, 2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00bc  */
    @Override // com.google.android.gms.internal.ads.zzgw
    public final long zzb(zzhb zzhbVar) throws zzhp {
        int i;
        HttpURLConnection httpURLConnectionZzk;
        byte[] byteArray;
        long j;
        this.zzh = zzhbVar;
        this.zzn = 0L;
        this.zzm = 0L;
        zzi(zzhbVar);
        try {
            URL url = new URL(zzhbVar.zza.toString());
            int i2 = zzhbVar.zzb;
            byte[] bArr = zzhbVar.zzc;
            long j2 = zzhbVar.zzf;
            long j3 = zzhbVar.zzg;
            boolean zZza = zzhbVar.zza(1);
            try {
                if (this.zzb) {
                    URL urlZzl = url;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3 + 1;
                        if (i3 > 20) {
                            i = 1;
                            throw new zzhp(new NoRouteToHostException("Too many redirects: " + i4), zzhbVar, 2001, 1);
                        }
                        long j4 = j3;
                        long j5 = j2;
                        URL url2 = urlZzl;
                        HttpURLConnection httpURLConnectionZzk2 = zzk(urlZzl, 1, null, j2, j3, zZza, false, zzhbVar.zzd);
                        int responseCode = httpURLConnectionZzk2.getResponseCode();
                        String headerField = httpURLConnectionZzk2.getHeaderField(HttpHeaders.LOCATION);
                        if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && responseCode != 307 && responseCode != 308) {
                            httpURLConnectionZzk = httpURLConnectionZzk2;
                            break;
                        }
                        i = 1;
                        try {
                            httpURLConnectionZzk2.disconnect();
                            urlZzl = zzl(url2, headerField, zzhbVar);
                            i3 = i4;
                            j3 = j4;
                            j2 = j5;
                        } catch (IOException e) {
                            e = e;
                        }
                        e = e;
                        zzm();
                        throw zzhp.zza(e, zzhbVar, i);
                    }
                }
                httpURLConnectionZzk = zzk(url, 1, null, j2, j3, zZza, true, zzhbVar.zzd);
                try {
                    this.zzi = httpURLConnectionZzk;
                    this.zzl = httpURLConnectionZzk.getResponseCode();
                    String responseMessage = httpURLConnectionZzk.getResponseMessage();
                    int i5 = this.zzl;
                    if (i5 < 200 || i5 > 299) {
                        Map<String, List<String>> headerFields = httpURLConnectionZzk.getHeaderFields();
                        if (this.zzl == 416) {
                            if (zzhbVar.zzf == zzhu.zzb(httpURLConnectionZzk.getHeaderField(HttpHeaders.CONTENT_RANGE))) {
                                this.zzk = true;
                                zzj(zzhbVar);
                                long j6 = zzhbVar.zzg;
                                if (j6 != -1) {
                                    return j6;
                                }
                                return 0L;
                            }
                        }
                        InputStream errorStream = httpURLConnectionZzk.getErrorStream();
                        try {
                            if (errorStream != null) {
                                int i6 = zzfy.zza;
                                byte[] bArr2 = new byte[4096];
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                while (true) {
                                    int i7 = errorStream.read(bArr2);
                                    if (i7 == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr2, 0, i7);
                                }
                                byteArray = byteArrayOutputStream.toByteArray();
                            } else {
                                byteArray = zzfy.zzf;
                            }
                        } catch (IOException unused) {
                            byteArray = zzfy.zzf;
                        }
                        zzm();
                        throw new zzhr(this.zzl, responseMessage, this.zzl == 416 ? new zzgx(2008) : null, headerFields, zzhbVar, byteArray);
                    }
                    httpURLConnectionZzk.getContentType();
                    if (this.zzl == 200) {
                        j = zzhbVar.zzf;
                        if (j == 0) {
                            j = 0;
                        }
                    } else {
                        j = 0;
                    }
                    boolean zEqualsIgnoreCase = "gzip".equalsIgnoreCase(httpURLConnectionZzk.getHeaderField(HttpHeaders.CONTENT_ENCODING));
                    if (zEqualsIgnoreCase) {
                        this.zzm = zzhbVar.zzg;
                    } else {
                        long j7 = zzhbVar.zzg;
                        if (j7 != -1) {
                            this.zzm = j7;
                        } else {
                            long jZza = zzhu.zza(httpURLConnectionZzk.getHeaderField(HttpHeaders.CONTENT_LENGTH), httpURLConnectionZzk.getHeaderField(HttpHeaders.CONTENT_RANGE));
                            this.zzm = jZza != -1 ? jZza - j : -1L;
                        }
                    }
                    try {
                        this.zzj = httpURLConnectionZzk.getInputStream();
                        if (zEqualsIgnoreCase) {
                            this.zzj = new GZIPInputStream(this.zzj);
                        }
                        this.zzk = true;
                        zzj(zzhbVar);
                        if (j != 0) {
                            try {
                                byte[] bArr3 = new byte[4096];
                                while (j > 0) {
                                    int iMin = (int) Math.min(j, 4096L);
                                    InputStream inputStream = this.zzj;
                                    int i8 = zzfy.zza;
                                    int i9 = inputStream.read(bArr3, 0, iMin);
                                    if (Thread.currentThread().isInterrupted()) {
                                        throw new zzhp(new InterruptedIOException(), zzhbVar, Constants.MAX_URL_LENGTH, 1);
                                    }
                                    if (i9 == -1) {
                                        throw new zzhp(zzhbVar, 2008, 1);
                                    }
                                    j -= (long) i9;
                                    zzg(i9);
                                }
                            } catch (IOException e2) {
                                zzm();
                                if (e2 instanceof zzhp) {
                                    throw ((zzhp) e2);
                                }
                                throw new zzhp(e2, zzhbVar, Constants.MAX_URL_LENGTH, 1);
                            }
                        }
                        return this.zzm;
                    } catch (IOException e3) {
                        zzm();
                        throw new zzhp(e3, zzhbVar, Constants.MAX_URL_LENGTH, 1);
                    }
                } catch (IOException e4) {
                    e = e4;
                    i = 1;
                }
            } catch (IOException e5) {
                e = e5;
                i = 1;
            }
        } catch (IOException e6) {
            e = e6;
            i = 1;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x002d */
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
            java.io.InputStream r2 = r7.zzj     // Catch: java.lang.Throwable -> L2d
            if (r2 == 0) goto L1e
            java.net.HttpURLConnection r3 = r7.zzi     // Catch: java.lang.Throwable -> L2d
            if (r3 == 0) goto Lc
            int r3 = com.google.android.gms.internal.ads.zzfy.zza     // Catch: java.lang.Throwable -> L2d
        Lc:
            r2.close()     // Catch: java.io.IOException -> L10 java.lang.Throwable -> L2d
            goto L1e
        L10:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzhp r3 = new com.google.android.gms.internal.ads.zzhp     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzhb r4 = r7.zzh     // Catch: java.lang.Throwable -> L2d
            int r5 = com.google.android.gms.internal.ads.zzfy.zza     // Catch: java.lang.Throwable -> L2d
            r5 = 2000(0x7d0, float:2.803E-42)
            r6 = 3
            r3.<init>(r2, r4, r5, r6)     // Catch: java.lang.Throwable -> L2d
            throw r3     // Catch: java.lang.Throwable -> L2d
        L1e:
            r7.zzj = r1
            r7.zzm()
            boolean r1 = r7.zzk
            if (r1 == 0) goto L2c
            r7.zzk = r0
            r7.zzh()
        L2c:
            return
        L2d:
            r2 = move-exception
            r7.zzj = r1
            r7.zzm()
            boolean r1 = r7.zzk
            if (r1 == 0) goto L3c
            r7.zzk = r0
            r7.zzh()
        L3c:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhj.zzd():void");
    }

    @Override // com.google.android.gms.internal.ads.zzgq, com.google.android.gms.internal.ads.zzgw
    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzi;
        return httpURLConnection == null ? zzgad.zzd() : new zzhh(httpURLConnection.getHeaderFields());
    }

    private zzhj(String str, int i, int i2, boolean z, zzhs zzhsVar, zzfxf zzfxfVar, boolean z2) {
        super(true);
        this.zze = str;
        this.zzc = i;
        this.zzd = i2;
        this.zzb = z;
        this.zzf = zzhsVar;
        this.zzg = new zzhs();
    }
}
