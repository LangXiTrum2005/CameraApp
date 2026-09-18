package com.google.android.gms.internal.measurement;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzjr implements zzjv {
    private final ContentResolver zzc;
    private final Uri zzd;
    private final Runnable zze;
    private volatile Map zzi;
    private static final ConcurrentMap zzb = new ConcurrentHashMap();
    public static final String[] zza = {"key", "value"};
    private ContentObserver zzf = null;
    private volatile boolean zzg = true;
    private final Object zzh = new Object();
    private final List zzj = new ArrayList();

    private zzjr(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        Preconditions.checkNotNull(contentResolver);
        Preconditions.checkNotNull(uri);
        this.zzc = contentResolver;
        this.zzd = uri;
        this.zze = runnable;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x002b A[PHI: r1
  0x002b: PHI (r1v3 com.google.android.gms.internal.measurement.zzjr) = (r1v2 com.google.android.gms.internal.measurement.zzjr), (r1v4 com.google.android.gms.internal.measurement.zzjr) binds: [B:6:0x001c, B:8:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    public static zzjr zza(final ContentResolver contentResolver, final Uri uri, final Runnable runnable) {
        zzjr zzjrVar;
        if (Build.VERSION.SDK_INT >= 24) {
            zzjrVar = (zzjr) zzb.computeIfAbsent(uri, new Function() { // from class: com.google.android.gms.internal.measurement.zzjq
                @Override // java.util.function.Function
                public final /* synthetic */ Object apply(Object obj) {
                    return zzjr.zzf(contentResolver, uri, runnable, (Uri) obj);
                }
            });
        } else {
            ConcurrentMap concurrentMap = zzb;
            zzjr zzjrVar2 = (zzjr) concurrentMap.get(uri);
            if (zzjrVar2 == null) {
                zzjrVar2 = new zzjr(contentResolver, uri, runnable);
                zzjrVar = (zzjr) concurrentMap.putIfAbsent(uri, zzjrVar2);
                if (zzjrVar == null) {
                    zzjrVar = zzjrVar2;
                }
            } else {
                zzjrVar = zzjrVar2;
            }
        }
        try {
            if (zzjrVar.zzg) {
                synchronized (zzjrVar) {
                    if (zzjrVar.zzg) {
                        zzjo zzjoVar = new zzjo(zzjrVar, null);
                        zzjrVar.zzc.registerContentObserver(zzjrVar.zzd, false, zzjoVar);
                        zzjrVar.zzf = zzjoVar;
                        zzjrVar.zzg = false;
                    }
                }
            }
            return zzjrVar;
        } catch (SecurityException unused) {
            return null;
        }
    }

    static void zzd() {
        Iterator it = zzb.values().iterator();
        while (it.hasNext()) {
            zzjr zzjrVar = (zzjr) it.next();
            synchronized (zzjrVar) {
                if (zzjrVar.zzg) {
                    zzjrVar.zzg = false;
                } else {
                    ContentObserver contentObserver = zzjrVar.zzf;
                    if (contentObserver != null) {
                        zzjrVar.zzc.unregisterContentObserver(contentObserver);
                        zzjrVar.zzf = null;
                    }
                }
            }
            it.remove();
        }
    }

    static /* synthetic */ zzjr zzf(ContentResolver contentResolver, Uri uri, Runnable runnable, Uri uri2) {
        return new zzjr(contentResolver, uri, runnable);
    }

    public final Map zzb() {
        Map mapEmptyMap;
        Map map = this.zzi;
        if (map == null) {
            synchronized (this.zzh) {
                map = this.zzi;
                if (map == null) {
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        try {
                            mapEmptyMap = (Map) zzjv.CC.zzh(new zzju() { // from class: com.google.android.gms.internal.measurement.zzjp
                                @Override // com.google.android.gms.internal.measurement.zzju
                                public final /* synthetic */ Object zza() {
                                    return this.zza.zzg();
                                }
                            });
                        } catch (SQLiteException | IllegalStateException | SecurityException e) {
                            Log.w("ConfigurationContentLdr", "Unable to query ContentProvider, using default values", e);
                            mapEmptyMap = Collections.emptyMap();
                        }
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        this.zzi = mapEmptyMap;
                        map = mapEmptyMap;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        throw th;
                    }
                }
            }
        }
        return map != null ? map : Collections.emptyMap();
    }

    public final void zzc() {
        synchronized (this.zzh) {
            this.zzi = null;
            this.zze.run();
        }
        synchronized (this) {
            Iterator it = this.zzj.iterator();
            while (it.hasNext()) {
                ((zzjs) it.next()).zza();
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjv
    public final /* bridge */ /* synthetic */ Object zze(String str) {
        return (String) zzb().get(str);
    }

    final /* synthetic */ Map zzg() {
        Map mapEmptyMap;
        Map mapEmptyMap2;
        ContentResolver contentResolver = this.zzc;
        Uri uri = this.zzd;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
        try {
            if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                Log.w("ConfigurationContentLdr", "Unable to acquire ContentProviderClient, using default values");
                return Collections.emptyMap();
            }
            try {
                Cursor cursorQuery = contentProviderClientAcquireUnstableContentProviderClient.query(uri, zza, null, null, null);
                try {
                    if (cursorQuery == null) {
                        Log.w("ConfigurationContentLdr", "ContentProvider query returned null cursor, using default values");
                        mapEmptyMap = Collections.emptyMap();
                        contentProviderClientAcquireUnstableContentProviderClient.release();
                        return mapEmptyMap;
                    }
                    int count = cursorQuery.getCount();
                    if (count == 0) {
                        mapEmptyMap2 = Collections.emptyMap();
                    } else {
                        Map arrayMap = count <= 256 ? new ArrayMap(count) : new HashMap(count, 1.0f);
                        while (cursorQuery.moveToNext()) {
                            arrayMap.put(cursorQuery.getString(0), cursorQuery.getString(1));
                        }
                        if (cursorQuery.isAfterLast()) {
                            cursorQuery.close();
                            contentProviderClientAcquireUnstableContentProviderClient.release();
                            return arrayMap;
                        }
                        Log.w("ConfigurationContentLdr", "Cursor read incomplete (ContentProvider dead?), using default values");
                        mapEmptyMap2 = Collections.emptyMap();
                    }
                    cursorQuery.close();
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                    return mapEmptyMap2;
                } catch (Throwable th) {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (RemoteException e) {
                Log.w("ConfigurationContentLdr", "ContentProvider query failed, using default values", e);
                mapEmptyMap = Collections.emptyMap();
            }
        } catch (Throwable th3) {
            contentProviderClientAcquireUnstableContentProviderClient.release();
            throw th3;
        }
    }
}
