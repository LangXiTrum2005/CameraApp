package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.common.net.HttpHeaders;
import com.google.firebase.messaging.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzchz extends zzchw {
    public static final /* synthetic */ int zzd = 0;
    private static final Set zze = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzf = new DecimalFormat("#,###");
    private File zzg;
    private boolean zzh;

    public zzchz(zzcgl zzcglVar) {
        super(zzcglVar);
        File cacheDir = this.zza.getCacheDir();
        if (cacheDir == null) {
            zzcec.zzj("Context.getCacheDir() returned null");
            return;
        }
        File file = new File(cacheDir, "admobVideoStreams");
        this.zzg = file;
        if (!file.isDirectory() && !this.zzg.mkdirs()) {
            zzcec.zzj("Could not create preload cache directory at ".concat(String.valueOf(this.zzg.getAbsolutePath())));
            this.zzg = null;
        } else {
            if (this.zzg.setReadable(true, false) && this.zzg.setExecutable(true, false)) {
                return;
            }
            zzcec.zzj("Could not set cache file permissions at ".concat(String.valueOf(this.zzg.getAbsolutePath())));
            this.zzg = null;
        }
    }

    private final File zza(File file) {
        return new File(this.zzg, String.valueOf(file.getName()).concat(".done"));
    }

    @Override // com.google.android.gms.internal.ads.zzchw
    public final void zzf() {
        this.zzh = true;
    }

    /* JADX WARN: Code duplicated, block: B:162:0x03c5  */
    /* JADX WARN: Code duplicated, block: B:166:0x03d5  */
    /* JADX WARN: Code duplicated, block: B:167:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:170:0x0408  */
    /* JADX WARN: Instruction removed from duplicated block: B:166:0x03d5, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:167:0x03ec, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzchw
    public final boolean zzt(final String str) {
        int i;
        String str2;
        String str3;
        FileOutputStream fileOutputStream;
        String str4;
        String str5;
        int responseCode;
        String str6;
        boolean zDelete;
        FileOutputStream fileOutputStream2 = null;
        if (this.zzg == null) {
            zzg(str, null, "noCacheDir", null);
            return false;
        }
        do {
            File file = this.zzg;
            if (file == null) {
                i = 0;
            } else {
                i = 0;
                for (File file2 : file.listFiles()) {
                    if (!file2.getName().endsWith(".done")) {
                        i++;
                    }
                }
            }
            if (i <= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzu)).intValue()) {
                File file3 = new File(this.zzg, zzcdv.zze(str));
                File fileZza = zza(file3);
                if (file3.isFile() && fileZza.isFile()) {
                    int length = (int) file3.length();
                    zzcec.zze("Stream cache hit at ".concat(String.valueOf(str)));
                    zzh(str, file3.getAbsolutePath(), length);
                    return true;
                }
                String strValueOf = String.valueOf(this.zzg.getAbsolutePath());
                String strValueOf2 = String.valueOf(str);
                Set set = zze;
                String strConcat = strValueOf.concat(strValueOf2);
                synchronized (set) {
                    if (set.contains(strConcat)) {
                        zzcec.zzj("Stream cache already in progress at " + str);
                        zzg(str, file3.getAbsolutePath(), "inProgress", null);
                        return false;
                    }
                    set.add(strConcat);
                    String str7 = Constants.IPC_BUNDLE_KEY_SEND_ERROR;
                    try {
                        HttpURLConnection httpURLConnectionZzn = zzfto.zza().zzn(new zzftn() { // from class: com.google.android.gms.internal.ads.zzchy
                            @Override // com.google.android.gms.internal.ads.zzftn
                            public final URLConnection zza() throws IOException {
                                int i2 = zzchz.zzd;
                                com.google.android.gms.ads.internal.zzt.zzw();
                                int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzz)).intValue();
                                URL url = new URL(str);
                                int i3 = 0;
                                while (true) {
                                    i3++;
                                    if (i3 > 20) {
                                        throw new IOException("Too many redirects (20)");
                                    }
                                    URLConnection uRLConnectionOpenConnection = url.openConnection();
                                    uRLConnectionOpenConnection.setConnectTimeout(iIntValue);
                                    uRLConnectionOpenConnection.setReadTimeout(iIntValue);
                                    if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                                        throw new IOException("Invalid protocol.");
                                    }
                                    HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                                    zzceb zzcebVar = new zzceb(null);
                                    zzcebVar.zzc(httpURLConnection, null);
                                    httpURLConnection.setInstanceFollowRedirects(false);
                                    int responseCode2 = httpURLConnection.getResponseCode();
                                    zzcebVar.zze(httpURLConnection, responseCode2);
                                    if (responseCode2 / 100 != 3) {
                                        return httpURLConnection;
                                    }
                                    String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                                    if (headerField == null) {
                                        throw new IOException("Missing Location header in redirect");
                                    }
                                    URL url2 = new URL(url, headerField);
                                    String protocol = url2.getProtocol();
                                    if (protocol == null) {
                                        throw new IOException("Protocol is null");
                                    }
                                    if (!protocol.equals("http") && !protocol.equals("https")) {
                                        throw new IOException("Unsupported scheme: ".concat(protocol));
                                    }
                                    zzcec.zze("Redirecting to ".concat(headerField));
                                    httpURLConnection.disconnect();
                                    url = url2;
                                }
                            }
                        }, 265, -1);
                        if (!(httpURLConnectionZzn instanceof HttpURLConnection) || (responseCode = httpURLConnectionZzn.getResponseCode()) < 400) {
                            int contentLength = httpURLConnectionZzn.getContentLength();
                            if (contentLength < 0) {
                                zzcec.zzj("Stream cache aborted, missing content-length header at " + str);
                                zzg(str, file3.getAbsolutePath(), "contentLengthMissing", null);
                                set.remove(strConcat);
                                return false;
                            }
                            String str8 = zzf.format(contentLength);
                            int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzv)).intValue();
                            if (contentLength > iIntValue) {
                                zzcec.zzj("Content length " + str8 + " exceeds limit at " + str);
                                StringBuilder sb = new StringBuilder();
                                sb.append("File too big for full file cache. Size: ");
                                sb.append(str8);
                                zzg(str, file3.getAbsolutePath(), "sizeExceeded", sb.toString());
                                set.remove(strConcat);
                                return false;
                            }
                            zzcec.zze("Caching " + str8 + " bytes from " + str);
                            ReadableByteChannel readableByteChannelNewChannel = Channels.newChannel(httpURLConnectionZzn.getInputStream());
                            FileOutputStream fileOutputStream3 = new FileOutputStream(file3);
                            try {
                                FileChannel channel = fileOutputStream3.getChannel();
                                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1048576);
                                Clock clockZzB = com.google.android.gms.ads.internal.zzt.zzB();
                                long jCurrentTimeMillis = clockZzB.currentTimeMillis();
                                com.google.android.gms.ads.internal.util.zzcb zzcbVar = new com.google.android.gms.ads.internal.util.zzcb(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzy)).longValue());
                                zzbfu zzbfuVar = zzbgc.zzx;
                                zzbga zzbgaVarZzc = com.google.android.gms.ads.internal.client.zzba.zzc();
                                long jLongValue = ((Long) zzbgaVarZzc.zza(zzbfuVar)).longValue();
                                int i2 = 0;
                                while (true) {
                                    int i3 = readableByteChannelNewChannel.read(byteBufferAllocate);
                                    if (i3 >= 0) {
                                        i2 += i3;
                                        try {
                                            try {
                                                if (i2 > iIntValue) {
                                                    String str9 = "File too big for full file cache. Size: " + Integer.toString(i2);
                                                    throw new IOException("stream cache file size limit exceeded");
                                                }
                                                try {
                                                    byteBufferAllocate.flip();
                                                    while (channel.write(byteBufferAllocate) > 0) {
                                                    }
                                                    byteBufferAllocate.clear();
                                                    if (clockZzB.currentTimeMillis() - jCurrentTimeMillis > 1000 * jLongValue) {
                                                        String str10 = "Timeout exceeded. Limit: " + Long.toString(jLongValue) + " sec";
                                                        throw new IOException("stream cache time limit exceeded");
                                                    }
                                                    ByteBuffer byteBuffer = byteBufferAllocate;
                                                    if (this.zzh) {
                                                        throw new IOException("abort requested");
                                                    }
                                                    if (zzcbVar.zzb()) {
                                                        str4 = str7;
                                                        try {
                                                            str5 = strConcat;
                                                            fileOutputStream = fileOutputStream3;
                                                            try {
                                                                try {
                                                                    zzcdv.zza.post(new zzchq(this, str, file3.getAbsolutePath(), i2, contentLength, false));
                                                                } catch (RuntimeException e) {
                                                                    e = e;
                                                                }
                                                            } catch (IOException e2) {
                                                                e = e2;
                                                            }
                                                        } catch (IOException e3) {
                                                            e = e3;
                                                            fileOutputStream = fileOutputStream3;
                                                            str5 = strConcat;
                                                            str2 = str5;
                                                            str7 = str4;
                                                            fileOutputStream2 = fileOutputStream;
                                                            str3 = 0;
                                                            if (e instanceof RuntimeException) {
                                                                com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "VideoStreamFullFileCache.preload");
                                                            }
                                                            fileOutputStream2.close();
                                                            if (this.zzh) {
                                                                zzcec.zzi("Preload aborted for URL \"" + str + "\"");
                                                            } else {
                                                                zzcec.zzk("Preload failed for URL \"" + str + "\"", e);
                                                            }
                                                            if (file3.exists()) {
                                                                zzcec.zzj("Could not delete partial cache file at ".concat(String.valueOf(file3.getAbsolutePath())));
                                                            }
                                                            zzg(str, file3.getAbsolutePath(), str7, str3);
                                                            zze.remove(str2);
                                                            return false;
                                                        } catch (RuntimeException e4) {
                                                            e = e4;
                                                            fileOutputStream = fileOutputStream3;
                                                            str5 = strConcat;
                                                            str2 = str5;
                                                            str7 = str4;
                                                            fileOutputStream2 = fileOutputStream;
                                                            str3 = 0;
                                                            if (e instanceof RuntimeException) {
                                                                com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "VideoStreamFullFileCache.preload");
                                                            }
                                                            fileOutputStream2.close();
                                                            if (this.zzh) {
                                                                zzcec.zzi("Preload aborted for URL \"" + str + "\"");
                                                            } else {
                                                                zzcec.zzk("Preload failed for URL \"" + str + "\"", e);
                                                            }
                                                            if (file3.exists()) {
                                                                zzcec.zzj("Could not delete partial cache file at ".concat(String.valueOf(file3.getAbsolutePath())));
                                                            }
                                                            zzg(str, file3.getAbsolutePath(), str7, str3);
                                                            zze.remove(str2);
                                                            return false;
                                                        }
                                                    } else {
                                                        fileOutputStream = fileOutputStream3;
                                                        str5 = strConcat;
                                                        str4 = str7;
                                                    }
                                                    byteBufferAllocate = byteBuffer;
                                                    readableByteChannelNewChannel = readableByteChannelNewChannel;
                                                    str7 = str4;
                                                    zzcbVar = zzcbVar;
                                                    strConcat = str5;
                                                    channel = channel;
                                                    fileOutputStream3 = fileOutputStream;
                                                    iIntValue = iIntValue;
                                                    contentLength = contentLength;
                                                } catch (IOException | RuntimeException e5) {
                                                    e = e5;
                                                    fileOutputStream = fileOutputStream3;
                                                    str5 = strConcat;
                                                    str4 = str7;
                                                }
                                                str2 = str5;
                                                str7 = str4;
                                                fileOutputStream2 = fileOutputStream;
                                                str3 = 0;
                                            } catch (IOException | RuntimeException e6) {
                                                e = e6;
                                                str2 = str5;
                                            }
                                        } catch (IOException | RuntimeException e7) {
                                            e = e7;
                                            str3 = zzbgaVarZzc;
                                            str2 = str5;
                                            fileOutputStream2 = fileOutputStream;
                                        }
                                    } else {
                                        fileOutputStream = fileOutputStream3;
                                        str5 = strConcat;
                                        str4 = str7;
                                        fileOutputStream.close();
                                        if (com.google.android.gms.ads.internal.util.zze.zzm(3)) {
                                            zzcec.zze("Preloaded " + zzf.format(i2) + " bytes from " + str);
                                        }
                                        file3.setReadable(true, false);
                                        if (fileZza.isFile()) {
                                            fileZza.setLastModified(System.currentTimeMillis());
                                        } else {
                                            try {
                                                fileZza.createNewFile();
                                            } catch (IOException unused) {
                                            }
                                        }
                                        zzh(str, file3.getAbsolutePath(), i2);
                                        str2 = str5;
                                        try {
                                            zze.remove(str2);
                                            return true;
                                        } catch (IOException e8) {
                                            e = e8;
                                        } catch (RuntimeException e9) {
                                            e = e9;
                                        }
                                    }
                                }
                            } catch (IOException | RuntimeException e10) {
                                e = e10;
                                fileOutputStream = fileOutputStream3;
                                str2 = strConcat;
                                str4 = str7;
                            }
                        } else {
                            str7 = "badUrl";
                            try {
                                String str11 = "HTTP request failed. Code: " + Integer.toString(responseCode);
                                try {
                                    throw new IOException("HTTP status code " + responseCode + " at " + str);
                                } catch (IOException | RuntimeException e11) {
                                    e = e11;
                                    str6 = str11;
                                    str2 = strConcat;
                                    str3 = str6;
                                    if (e instanceof RuntimeException) {
                                        com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "VideoStreamFullFileCache.preload");
                                    }
                                    fileOutputStream2.close();
                                    if (this.zzh) {
                                        zzcec.zzi("Preload aborted for URL \"" + str + "\"");
                                    } else {
                                        zzcec.zzk("Preload failed for URL \"" + str + "\"", e);
                                    }
                                    if (file3.exists()) {
                                        zzcec.zzj("Could not delete partial cache file at ".concat(String.valueOf(file3.getAbsolutePath())));
                                    }
                                    zzg(str, file3.getAbsolutePath(), str7, str3);
                                    zze.remove(str2);
                                    return false;
                                }
                            } catch (IOException | RuntimeException e12) {
                                e = e12;
                                str6 = null;
                            }
                        }
                    } catch (IOException | RuntimeException e13) {
                        e = e13;
                        str2 = strConcat;
                        str7 = Constants.IPC_BUNDLE_KEY_SEND_ERROR;
                        str3 = 0;
                        fileOutputStream2 = null;
                    }
                    if (e instanceof RuntimeException) {
                        com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "VideoStreamFullFileCache.preload");
                    }
                    try {
                        fileOutputStream2.close();
                    } catch (IOException | NullPointerException unused2) {
                    }
                    if (this.zzh) {
                        zzcec.zzi("Preload aborted for URL \"" + str + "\"");
                    } else {
                        zzcec.zzk("Preload failed for URL \"" + str + "\"", e);
                    }
                    if (file3.exists() && !file3.delete()) {
                        zzcec.zzj("Could not delete partial cache file at ".concat(String.valueOf(file3.getAbsolutePath())));
                    }
                    zzg(str, file3.getAbsolutePath(), str7, str3);
                    zze.remove(str2);
                    return false;
                }
            }
            File file4 = this.zzg;
            if (file4 == null) {
                break;
            }
            long j = Long.MAX_VALUE;
            File file5 = null;
            for (File file6 : file4.listFiles()) {
                if (!file6.getName().endsWith(".done")) {
                    long jLastModified = file6.lastModified();
                    if (jLastModified < j) {
                        file5 = file6;
                        j = jLastModified;
                    }
                }
            }
            if (file5 != null) {
                zDelete = file5.delete();
                File fileZza2 = zza(file5);
                if (fileZza2.isFile()) {
                    zDelete &= fileZza2.delete();
                }
            } else {
                zDelete = false;
            }
        } while (zDelete);
        zzcec.zzj("Unable to expire stream cache");
        zzg(str, null, "expireFailed", null);
        return false;
    }
}
