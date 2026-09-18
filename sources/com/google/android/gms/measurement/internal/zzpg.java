package com.google.android.gms.measurement.internal;

import android.app.BroadcastOptions;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.collection.ArrayMap;
import androidx.work.WorkRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzpr;
import com.google.android.gms.internal.measurement.zzqp;
import com.google.android.gms.internal.measurement.zzrb;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.core.ServerValues;
import com.google.firebase.messaging.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;
import kotlin.time.DurationKt;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzpg implements zzjg {
    private static volatile zzpg zzb;
    private List zzA;
    private long zzB;
    private final Map zzC;
    private final Map zzD;
    private final Map zzE;
    private zzlu zzG;
    private String zzH;
    private zzay zzI;
    private long zzJ;
    long zza;
    private final zzht zzc;
    private final zzgz zzd;
    private zzav zze;
    private zzhb zzf;
    private zzok zzg;
    private zzad zzh;
    private final zzpk zzi;
    private zzlp zzj;
    private zznn zzk;
    private final zzou zzl;
    private zzhk zzm;
    private final zzic zzn;
    private boolean zzp;
    private List zzq;
    private int zzs;
    private int zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private FileLock zzx;
    private FileChannel zzy;
    private List zzz;
    private final AtomicBoolean zzo = new AtomicBoolean(false);
    private final Deque zzr = new LinkedList();
    private final Map zzF = new HashMap();
    private final zzpo zzK = new zzpb(this);

    zzpg(zzph zzphVar, zzic zzicVar) {
        Preconditions.checkNotNull(zzphVar);
        this.zzn = zzic.zzy(zzphVar.zza, null, null);
        this.zzB = -1L;
        this.zzl = new zzou(this);
        zzpk zzpkVar = new zzpk(this);
        zzpkVar.zzax();
        this.zzi = zzpkVar;
        zzgz zzgzVar = new zzgz(this);
        zzgzVar.zzax();
        this.zzd = zzgzVar;
        zzht zzhtVar = new zzht(this);
        zzhtVar.zzax();
        this.zzc = zzhtVar;
        this.zzC = new HashMap();
        this.zzD = new HashMap();
        this.zzE = new HashMap();
        zzaW().zzj(new zzov(this, zzphVar));
    }

    public static zzpg zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzpg.class) {
                if (zzb == null) {
                    zzb = new zzpg((zzph) Preconditions.checkNotNull(new zzph(context)), null);
                }
            }
        }
        return zzb;
    }

    static final void zzaA(com.google.android.gms.internal.measurement.zzhr zzhrVar, int i, String str) {
        List listZza = zzhrVar.zza();
        for (int i2 = 0; i2 < listZza.size(); i2++) {
            if ("_err".equals(((com.google.android.gms.internal.measurement.zzhw) listZza.get(i2)).zzb())) {
                return;
            }
        }
        com.google.android.gms.internal.measurement.zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
        zzhvVarZzn.zzb("_err");
        long j = i;
        Long.valueOf(j).getClass();
        zzhvVarZzn.zzf(j);
        com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn.zzbc();
        com.google.android.gms.internal.measurement.zzhv zzhvVarZzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
        zzhvVarZzn2.zzb("_ev");
        zzhvVarZzn2.zzd(str);
        com.google.android.gms.internal.measurement.zzhw zzhwVar2 = (com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn2.zzbc();
        zzhrVar.zzf(zzhwVar);
        zzhrVar.zzf(zzhwVar2);
    }

    static final void zzaB(com.google.android.gms.internal.measurement.zzhr zzhrVar, String str) {
        List listZza = zzhrVar.zza();
        for (int i = 0; i < listZza.size(); i++) {
            if (str.equals(((com.google.android.gms.internal.measurement.zzhw) listZza.get(i)).zzb())) {
                zzhrVar.zzj(i);
                return;
            }
        }
    }

    private final int zzaC(String str, zzan zzanVar) throws Throwable {
        zzjk zzjkVar;
        zzji zzjiVarZzA;
        zzht zzhtVar = this.zzc;
        if (zzhtVar.zzx(str) == null) {
            zzanVar.zzc(zzjk.AD_PERSONALIZATION, zzam.FAILSAFE);
            return 1;
        }
        zzh zzhVarZzu = zzj().zzu(str);
        if (zzhVarZzu != null && zze.zzc(zzhVarZzu.zzaH()).zza() == zzji.POLICY && (zzjiVarZzA = zzhtVar.zzA(str, (zzjkVar = zzjk.AD_PERSONALIZATION))) != zzji.UNINITIALIZED) {
            zzanVar.zzc(zzjkVar, zzam.REMOTE_ENFORCED_DEFAULT);
            return zzjiVarZzA == zzji.GRANTED ? 0 : 1;
        }
        zzjk zzjkVar2 = zzjk.AD_PERSONALIZATION;
        zzanVar.zzc(zzjkVar2, zzam.REMOTE_DEFAULT);
        return zzhtVar.zzv(str, zzjkVar2) ? 0 : 1;
    }

    private final Map zzaD(com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        HashMap map = new HashMap();
        zzp();
        for (Map.Entry entry : zzpk.zzH(zzhsVar, "gad_").entrySet()) {
            map.put((String) entry.getKey(), String.valueOf(entry.getValue()));
        }
        return map;
    }

    private final zzay zzaE() {
        if (this.zzI == null) {
            this.zzI = new zzoy(this, this.zzn);
        }
        return this.zzI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaF, reason: merged with bridge method [inline-methods] */
    public final void zzav() {
        zzaW().zzg();
        if (this.zzr.isEmpty() || zzaE().zzc()) {
            return;
        }
        long jMax = Math.max(0L, ((long) ((Integer) zzfy.zzaB.zzb(null)).intValue()) - (zzaZ().elapsedRealtime() - this.zzJ));
        zzaV().zzk().zzb("Scheduling notify next app runnable, delay in ms", Long.valueOf(jMax));
        zzaE().zzb(jMax);
    }

    /* JADX WARN: Code duplicated, block: B:110:0x03a3 A[Catch: all -> 0x0e14, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x03bb A[Catch: all -> 0x0e14, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x03da A[Catch: all -> 0x0e14, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x03f0 A[Catch: all -> 0x0e14, TRY_ENTER, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x0400  */
    /* JADX WARN: Code duplicated, block: B:122:0x0402 A[Catch: all -> 0x0e14, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0412  */
    /* JADX WARN: Code duplicated, block: B:128:0x0419  */
    /* JADX WARN: Code duplicated, block: B:129:0x041b A[Catch: all -> 0x0e14, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:136:0x044f  */
    /* JADX WARN: Code duplicated, block: B:137:0x0450 A[Catch: all -> 0x0e14, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x0461  */
    /* JADX WARN: Code duplicated, block: B:142:0x0468 A[Catch: all -> 0x0e14, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x0472 A[Catch: all -> 0x0e14, LOOP:11: B:140:0x0462->B:144:0x0472, LOOP_END, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x0491  */
    /* JADX WARN: Code duplicated, block: B:149:0x049c A[Catch: all -> 0x0e14, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:151:0x04ab  */
    /* JADX WARN: Code duplicated, block: B:156:0x04cc A[Catch: all -> 0x0e14, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:159:0x04e3  */
    /* JADX WARN: Code duplicated, block: B:160:0x04e5 A[PHI: r7
  0x04e5: PHI (r7v48 com.google.android.gms.internal.measurement.zzic) = (r7v45 com.google.android.gms.internal.measurement.zzic), (r7v51 com.google.android.gms.internal.measurement.zzic) binds: [B:164:0x0505, B:159:0x04e3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:161:0x04e8 A[Catch: all -> 0x0e14, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:163:0x04f6 A[Catch: all -> 0x0e14, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:165:0x0507  */
    /* JADX WARN: Code duplicated, block: B:170:0x0528 A[Catch: all -> 0x0e14, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:173:0x0537 A[Catch: all -> 0x0e14, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:175:0x0546 A[Catch: all -> 0x0e14, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:186:0x057b A[Catch: all -> 0x0e14, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:189:0x0596 A[Catch: all -> 0x0e14, LOOP:10: B:184:0x0575->B:189:0x0596, LOOP_END, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:193:0x05a1 A[Catch: all -> 0x0e14, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:196:0x05b3 A[Catch: all -> 0x0e14, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:209:0x0638 A[Catch: all -> 0x0e14, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:211:0x0648 A[Catch: all -> 0x0e14, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:216:0x068a A[Catch: all -> 0x0e14, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:222:0x06b4 A[Catch: all -> 0x0e14, LOOP:9: B:220:0x06ae->B:222:0x06b4, LOOP_END, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:223:0x06be  */
    /* JADX WARN: Code duplicated, block: B:233:0x0714 A[Catch: all -> 0x0e14, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:235:0x071d A[Catch: all -> 0x0e14, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:237:0x0723 A[Catch: all -> 0x0e14, TryCatch #1 {all -> 0x0e14, blocks: (B:3:0x0011, B:5:0x0029, B:8:0x0031, B:9:0x0045, B:12:0x005d, B:15:0x0083, B:17:0x00b8, B:20:0x00c9, B:22:0x00d3, B:225:0x06de, B:24:0x0102, B:27:0x0114, B:29:0x011a, B:42:0x0155, B:44:0x0163, B:47:0x0183, B:49:0x0189, B:51:0x0199, B:53:0x01a7, B:55:0x01b7, B:56:0x01c4, B:57:0x01c7, B:60:0x01dd, B:70:0x020e, B:73:0x0218, B:75:0x0226, B:79:0x026b, B:76:0x0242, B:78:0x0252, B:83:0x0278, B:85:0x02a4, B:86:0x02ce, B:88:0x0305, B:90:0x030c, B:93:0x0318, B:95:0x0352, B:96:0x036d, B:98:0x0373, B:100:0x0381, B:104:0x0395, B:101:0x038a, B:107:0x039c, B:110:0x03a3, B:111:0x03bb, B:115:0x03da, B:116:0x03e6, B:119:0x03f0, B:125:0x0413, B:122:0x0402, B:147:0x0492, B:149:0x049c, B:152:0x04ad, B:154:0x04c0, B:156:0x04cc, B:191:0x059b, B:193:0x05a1, B:194:0x05ad, B:196:0x05b3, B:198:0x05c3, B:200:0x05cd, B:201:0x05e2, B:203:0x05e8, B:204:0x0603, B:206:0x0609, B:207:0x0627, B:208:0x0632, B:212:0x065b, B:209:0x0638, B:211:0x0648, B:213:0x0668, B:214:0x0684, B:216:0x068a, B:218:0x069d, B:219:0x06aa, B:220:0x06ae, B:222:0x06b4, B:224:0x06c6, B:161:0x04e8, B:163:0x04f6, B:166:0x0509, B:168:0x051c, B:170:0x0528, B:173:0x0537, B:175:0x0546, B:177:0x0552, B:179:0x055e, B:181:0x0568, B:184:0x0575, B:186:0x057b, B:188:0x058b, B:189:0x0596, B:129:0x041b, B:131:0x0427, B:133:0x0433, B:145:0x0478, B:137:0x0450, B:140:0x0462, B:142:0x0468, B:144:0x0472, B:31:0x0120, B:33:0x012b, B:35:0x0137, B:37:0x013d, B:41:0x0148, B:228:0x06f5, B:230:0x0703, B:232:0x070c, B:243:0x073d, B:233:0x0714, B:235:0x071d, B:237:0x0723, B:240:0x072f, B:242:0x0737, B:244:0x0740, B:245:0x074c, B:248:0x0754, B:250:0x0766, B:251:0x0771, B:253:0x0779, B:257:0x079e, B:259:0x07b8, B:261:0x07cd, B:263:0x07e7, B:265:0x07fc, B:266:0x080a, B:268:0x0810, B:270:0x0820, B:271:0x0827, B:273:0x0833, B:274:0x083a, B:275:0x083d, B:277:0x087f, B:279:0x0885, B:285:0x08ac, B:287:0x08b4, B:288:0x08bd, B:290:0x08c3, B:291:0x08c9, B:293:0x08de, B:295:0x08ee, B:297:0x08fe, B:299:0x0906, B:300:0x0909, B:308:0x097b, B:310:0x0994, B:312:0x09aa, B:314:0x09af, B:316:0x09b3, B:318:0x09b7, B:320:0x09c1, B:321:0x09c7, B:323:0x09cb, B:325:0x09d1, B:326:0x09df, B:327:0x09e8, B:332:0x0a0b, B:336:0x0a12, B:280:0x0893, B:282:0x0899, B:284:0x089f, B:264:0x07f9, B:260:0x07ca, B:254:0x077e, B:256:0x0784), top: B:473:0x0011, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:238:0x072c  */
    /* JADX WARN: Code duplicated, block: B:40:0x0146  */
    /* JADX WARN: Code duplicated, block: B:431:0x0d03  */
    /* JADX WARN: Code duplicated, block: B:438:0x0d29 A[Catch: all -> 0x0e12, TryCatch #0 {all -> 0x0e12, blocks: (B:432:0x0d05, B:434:0x0d1a, B:437:0x0d21, B:442:0x0d52, B:444:0x0d64, B:445:0x0d7a, B:448:0x0d82, B:449:0x0d87, B:450:0x0d97, B:452:0x0db1, B:453:0x0dcc, B:454:0x0dd4, B:459:0x0df3, B:458:0x0de0, B:438:0x0d29, B:440:0x0d35, B:441:0x0d3b, B:462:0x0e00), top: B:472:0x0027, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:440:0x0d35 A[Catch: all -> 0x0e12, TryCatch #0 {all -> 0x0e12, blocks: (B:432:0x0d05, B:434:0x0d1a, B:437:0x0d21, B:442:0x0d52, B:444:0x0d64, B:445:0x0d7a, B:448:0x0d82, B:449:0x0d87, B:450:0x0d97, B:452:0x0db1, B:453:0x0dcc, B:454:0x0dd4, B:459:0x0df3, B:458:0x0de0, B:438:0x0d29, B:440:0x0d35, B:441:0x0d3b, B:462:0x0e00), top: B:472:0x0027, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:441:0x0d3b A[Catch: all -> 0x0e12, TryCatch #0 {all -> 0x0e12, blocks: (B:432:0x0d05, B:434:0x0d1a, B:437:0x0d21, B:442:0x0d52, B:444:0x0d64, B:445:0x0d7a, B:448:0x0d82, B:449:0x0d87, B:450:0x0d97, B:452:0x0db1, B:453:0x0dcc, B:454:0x0dd4, B:459:0x0df3, B:458:0x0de0, B:438:0x0d29, B:440:0x0d35, B:441:0x0d3b, B:462:0x0e00), top: B:472:0x0027, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:443:0x0d62  */
    /* JADX WARN: Code duplicated, block: B:447:0x0d80 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:448:0x0d82 A[Catch: all -> 0x0e12, TryCatch #0 {all -> 0x0e12, blocks: (B:432:0x0d05, B:434:0x0d1a, B:437:0x0d21, B:442:0x0d52, B:444:0x0d64, B:445:0x0d7a, B:448:0x0d82, B:449:0x0d87, B:450:0x0d97, B:452:0x0db1, B:453:0x0dcc, B:454:0x0dd4, B:459:0x0df3, B:458:0x0de0, B:438:0x0d29, B:440:0x0d35, B:441:0x0d3b, B:462:0x0e00), top: B:472:0x0027, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:452:0x0db1 A[Catch: all -> 0x0e12, TryCatch #0 {all -> 0x0e12, blocks: (B:432:0x0d05, B:434:0x0d1a, B:437:0x0d21, B:442:0x0d52, B:444:0x0d64, B:445:0x0d7a, B:448:0x0d82, B:449:0x0d87, B:450:0x0d97, B:452:0x0db1, B:453:0x0dcc, B:454:0x0dd4, B:459:0x0df3, B:458:0x0de0, B:438:0x0d29, B:440:0x0d35, B:441:0x0d3b, B:462:0x0e00), top: B:472:0x0027, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:500:0x0413 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:504:0x065b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:508:0x069d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:510:0x0684 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:514:0x058b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:516:0x0478 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:520:0x073d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:531:0x0d87 A[SYNTHETIC] */
    private final boolean zzaG(String str, long j) throws Throwable {
        boolean z;
        boolean z2;
        int i;
        com.google.android.gms.internal.measurement.zzic zzicVar;
        zzpc zzpcVar;
        com.google.android.gms.internal.measurement.zzic zzicVar2;
        boolean z3;
        long j2;
        int iZzm;
        long j3;
        zzpc zzpcVar2;
        com.google.android.gms.internal.measurement.zzic zzicVar3;
        int i2;
        zzav zzavVarZzj;
        List list;
        StringBuilder sb;
        int iDelete;
        zzav zzavVarZzj2;
        com.google.android.gms.internal.measurement.zzgl zzglVarZzb;
        com.google.android.gms.internal.measurement.zzhw zzhwVarZzF;
        Long lValueOf;
        String str2;
        String str3;
        String str4;
        boolean z4;
        boolean z5;
        boolean z6;
        int i3;
        String str5;
        int i4;
        com.google.android.gms.internal.measurement.zzhw zzhwVarZzc;
        com.google.android.gms.internal.measurement.zzhr zzhrVar;
        boolean z7;
        String str6;
        int i5;
        String str7;
        int i6;
        boolean z8;
        Bundle bundleZzE;
        int i7;
        zzpk zzpkVarZzp;
        ArrayList arrayList;
        Iterator it;
        com.google.android.gms.internal.measurement.zzhv zzhvVarZzn;
        Object obj;
        com.google.android.gms.internal.measurement.zzhw zzhwVarZzc2;
        String str8;
        boolean z9;
        String str9;
        int i8;
        com.google.android.gms.internal.measurement.zzhr zzhrVar2;
        ArrayList arrayList2;
        int i9;
        int i10;
        int i11;
        String strZzd;
        int iCharCount;
        int iCodePointAt;
        boolean z10;
        boolean z11;
        String str10;
        zzpg zzpgVar = this;
        String str11 = "_f";
        String str12 = "_ai";
        String str13 = FirebaseAnalytics.Event.PURCHASE;
        String str14 = FirebaseAnalytics.Param.ITEMS;
        zzj().zzb();
        try {
            zzpc zzpcVar3 = new zzpc(zzpgVar, null);
            zzj().zzat(str, j, zzpgVar.zzB, zzpcVar3);
            List list2 = zzpcVar3.zzc;
            try {
                if (list2 == null || list2.isEmpty()) {
                    zzj().zzc();
                    z = false;
                } else {
                    com.google.android.gms.internal.measurement.zzic zzicVar4 = (com.google.android.gms.internal.measurement.zzic) zzpcVar3.zza.zzcl();
                    zzicVar4.zzi();
                    com.google.android.gms.internal.measurement.zzhr zzhrVar3 = null;
                    com.google.android.gms.internal.measurement.zzhr zzhrVar4 = null;
                    int i12 = -1;
                    int i13 = 0;
                    int i14 = 0;
                    boolean z12 = false;
                    boolean z13 = false;
                    int i15 = -1;
                    while (true) {
                        z2 = z13;
                        i = i14;
                        String str15 = "_et";
                        String str16 = str14;
                        zzicVar = zzicVar4;
                        int i16 = i12;
                        if (i13 >= zzpcVar3.zzc.size()) {
                            break;
                        }
                        com.google.android.gms.internal.measurement.zzhr zzhrVar5 = (com.google.android.gms.internal.measurement.zzhr) ((com.google.android.gms.internal.measurement.zzhs) zzpcVar3.zzc.get(i13)).zzcl();
                        int i17 = i13;
                        if (zzh().zzj(zzpcVar3.zza.zzA(), zzhrVar5.zzk())) {
                            zzaV().zze().zzc("Dropping blocked raw event. appId", zzgu.zzl(zzpcVar3.zza.zzA()), zzpgVar.zzn.zzl().zza(zzhrVar5.zzk()));
                            if (!zzh().zzn(zzpcVar3.zza.zzA()) && !zzh().zzo(zzpcVar3.zza.zzA()) && !"_err".equals(zzhrVar5.zzk())) {
                                zzt().zzN(zzpgVar.zzK, zzpcVar3.zza.zzA(), 11, "_ev", zzhrVar5.zzk(), 0);
                            }
                            str6 = str11;
                            str3 = str12;
                            str13 = str13;
                            i14 = i;
                            str7 = str16;
                            zzicVar4 = zzicVar;
                            i12 = i16;
                            i6 = i17;
                            z8 = z2;
                        } else {
                            String strZzk = zzhrVar5.zzk();
                            String str17 = str11;
                            com.google.android.gms.internal.measurement.zzhr zzhrVar6 = zzhrVar3;
                            if (strZzk.equals(str13) || strZzk.equals("_iap") || strZzk.equals("ecommerce_purchase")) {
                                com.google.android.gms.internal.measurement.zzhv zzhvVarZzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzhvVarZzn2.zzb("_ct");
                                if (z12) {
                                    str2 = "returning";
                                } else {
                                    String strZzA = zzpcVar3.zza.zzA();
                                    if (zzpgVar.zzaP(strZzA, str13) && zzpgVar.zzaP(strZzA, "_iap") && zzpgVar.zzaP(strZzA, "ecommerce_purchase")) {
                                        str2 = "new";
                                    } else {
                                        str2 = "returning";
                                    }
                                }
                                zzhvVarZzn2.zzd(str2);
                                zzhrVar5.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn2.zzbc());
                                z12 = true;
                            }
                            if (zzhrVar5.zzk().equals(zzjm.zza(str12))) {
                                zzhrVar5.zzl(str12);
                                zzaV().zzk().zza("Renaming ad_impression to _ai");
                                if (Log.isLoggable(zzaV().zzn(), 5)) {
                                    for (int i18 = 0; i18 < zzhrVar5.zzb(); i18++) {
                                        if (FirebaseAnalytics.Param.AD_PLATFORM.equals(zzhrVar5.zzc(i18).zzb()) && !zzhrVar5.zzc(i18).zzd().isEmpty() && "admob".equalsIgnoreCase(zzhrVar5.zzc(i18).zzd())) {
                                            zzaV().zzh().zza("AdMob ad impression logged from app. Potentially duplicative.");
                                        }
                                    }
                                }
                            }
                            boolean zZzk = zzh().zzk(zzpcVar3.zza.zzA(), zzhrVar5.zzk());
                            if (zZzk) {
                                str3 = str12;
                            } else {
                                zzp();
                                String strZzk2 = zzhrVar5.zzk();
                                Preconditions.checkNotEmpty(strZzk2);
                                str3 = str12;
                                if (strZzk2.hashCode() != 95027 || !strZzk2.equals("_ui")) {
                                    z6 = z2;
                                    str4 = "_et";
                                    z4 = z12;
                                    z5 = false;
                                }
                                if (z5) {
                                    arrayList2 = new ArrayList(zzhrVar5.zza());
                                    i10 = -1;
                                    i11 = -1;
                                    for (i9 = 0; i9 < arrayList2.size(); i9++) {
                                        if ("value".equals(((com.google.android.gms.internal.measurement.zzhw) arrayList2.get(i9)).zzb())) {
                                            i10 = i9;
                                        } else if (FirebaseAnalytics.Param.CURRENCY.equals(((com.google.android.gms.internal.measurement.zzhw) arrayList2.get(i9)).zzb())) {
                                            i11 = i9;
                                        }
                                    }
                                    if (i10 != -1) {
                                        if (!((com.google.android.gms.internal.measurement.zzhw) arrayList2.get(i10)).zze() || ((com.google.android.gms.internal.measurement.zzhw) arrayList2.get(i10)).zzi()) {
                                            if (i11 == -1) {
                                                strZzd = ((com.google.android.gms.internal.measurement.zzhw) arrayList2.get(i11)).zzd();
                                                if (strZzd.length() == 3) {
                                                    iCharCount = 0;
                                                    while (iCharCount < strZzd.length()) {
                                                        iCodePointAt = strZzd.codePointAt(iCharCount);
                                                        if (Character.isLetter(iCodePointAt)) {
                                                            iCharCount += Character.charCount(iCodePointAt);
                                                        }
                                                    }
                                                }
                                            }
                                            zzaV().zzh().zza("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                            zzhrVar5.zzj(i10);
                                            zzaB(zzhrVar5, "_c");
                                            zzaA(zzhrVar5, 19, FirebaseAnalytics.Param.CURRENCY);
                                            break;
                                        }
                                        zzaV().zzh().zza("Value must be specified with a numeric type.");
                                        zzhrVar5.zzj(i10);
                                        zzaB(zzhrVar5, "_c");
                                        zzaA(zzhrVar5, 18, "value");
                                    }
                                }
                                if ("_e".equals(zzhrVar5.zzk())) {
                                    zzp();
                                    if (zzpk.zzF((com.google.android.gms.internal.measurement.zzhs) zzhrVar5.zzbc(), "_fr") == null) {
                                        if (zzhrVar4 != null && Math.abs(zzhrVar4.zzn() - zzhrVar5.zzn()) <= 1000) {
                                            zzhrVar2 = (com.google.android.gms.internal.measurement.zzhr) zzhrVar4.clone();
                                            if (zzpgVar.zzaI(zzhrVar5, zzhrVar2)) {
                                                zzicVar4 = zzicVar;
                                                zzicVar4.zzf(i15, zzhrVar2);
                                                i3 = i16;
                                                str5 = str17;
                                                zzhrVar3 = null;
                                                zzhrVar4 = null;
                                            }
                                        }
                                        zzicVar4 = zzicVar;
                                        zzhrVar3 = zzhrVar5;
                                        i3 = i;
                                        str5 = str17;
                                    } else {
                                        zzicVar4 = zzicVar;
                                        i3 = i16;
                                        str5 = str17;
                                        zzhrVar3 = zzhrVar6;
                                    }
                                } else {
                                    zzicVar4 = zzicVar;
                                    if ("_vs".equals(zzhrVar5.zzk())) {
                                        zzp();
                                        if (zzpk.zzF((com.google.android.gms.internal.measurement.zzhs) zzhrVar5.zzbc(), str4) == null) {
                                            if (zzhrVar6 != null && Math.abs(zzhrVar6.zzn() - zzhrVar5.zzn()) <= 1000) {
                                                zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzhrVar6.clone();
                                                if (zzpgVar.zzaI(zzhrVar, zzhrVar5)) {
                                                    i3 = i16;
                                                    zzicVar4.zzf(i3, zzhrVar);
                                                    str5 = str17;
                                                    zzhrVar3 = null;
                                                    zzhrVar4 = null;
                                                }
                                            }
                                            i3 = i16;
                                            zzhrVar4 = zzhrVar5;
                                            i15 = i;
                                        } else {
                                            i3 = i16;
                                        }
                                    } else {
                                        i3 = i16;
                                        if (zzd().zzp(null, zzfy.zzbj)) {
                                            str5 = str17;
                                            if ((str5.equals(zzhrVar5.zzk()) || "_v".equals(zzhrVar5.zzk())) && (str5.equals(zzhrVar5.zzk()) || "_v".equals(zzhrVar5.zzk()))) {
                                                for (i4 = 0; i4 < zzhrVar5.zzb(); i4++) {
                                                    zzhwVarZzc = zzhrVar5.zzc(i4);
                                                    if ("_elt".equals(zzhwVarZzc.zzb())) {
                                                        zzhrVar5.zzr(zzhwVarZzc.zzf());
                                                        zzhrVar5.zzj(i4);
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        zzhrVar3 = zzhrVar6;
                                    }
                                    str5 = str17;
                                    zzhrVar3 = zzhrVar6;
                                }
                                if (zzhrVar5.zzb() != 0) {
                                    zzp();
                                    bundleZzE = zzpk.zzE(zzhrVar5.zza());
                                    i7 = 0;
                                    while (i7 < zzhrVar5.zzb()) {
                                        zzhwVarZzc2 = zzhrVar5.zzc(i7);
                                        str8 = str16;
                                        if (zzhwVarZzc2.zzb().equals(str8) || zzhwVarZzc2.zzk().isEmpty()) {
                                            z9 = z6;
                                            str9 = str5;
                                            i8 = i3;
                                            if (!zzhwVarZzc2.zzb().equals(str8)) {
                                                zzpgVar.zzU(zzhrVar5.zzk(), (com.google.android.gms.internal.measurement.zzhv) zzhwVarZzc2.zzcl(), bundleZzE, zzpcVar3.zza.zzA());
                                            }
                                        } else {
                                            String strZzA2 = zzpcVar3.zza.zzA();
                                            List listZzk = zzhwVarZzc2.zzk();
                                            Bundle[] bundleArr = new Bundle[listZzk.size()];
                                            z9 = z6;
                                            str9 = str5;
                                            int i19 = 0;
                                            while (i19 < listZzk.size()) {
                                                com.google.android.gms.internal.measurement.zzhw zzhwVar = (com.google.android.gms.internal.measurement.zzhw) listZzk.get(i19);
                                                zzp();
                                                int i20 = i3;
                                                Bundle bundleZzE2 = zzpk.zzE(zzhwVar.zzk());
                                                Iterator it2 = zzhwVar.zzk().iterator();
                                                while (it2.hasNext()) {
                                                    zzpgVar.zzU(zzhrVar5.zzk(), (com.google.android.gms.internal.measurement.zzhv) ((com.google.android.gms.internal.measurement.zzhw) it2.next()).zzcl(), bundleZzE2, strZzA2);
                                                    it2 = it2;
                                                    listZzk = listZzk;
                                                }
                                                bundleArr[i19] = bundleZzE2;
                                                i19++;
                                                i3 = i20;
                                                listZzk = listZzk;
                                            }
                                            i8 = i3;
                                            bundleZzE.putParcelableArray(str8, bundleArr);
                                        }
                                        i7++;
                                        z6 = z9;
                                        str16 = str8;
                                        i3 = i8;
                                        str5 = str9;
                                    }
                                    z7 = z6;
                                    str6 = str5;
                                    i5 = i3;
                                    str7 = str16;
                                    zzhrVar5.zzi();
                                    zzpkVarZzp = zzp();
                                    arrayList = new ArrayList();
                                    for (String str18 : bundleZzE.keySet()) {
                                        zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                                        zzhvVarZzn.zzb(str18);
                                        obj = bundleZzE.get(str18);
                                        if (obj != null) {
                                            zzpkVarZzp.zzd(zzhvVarZzn, obj);
                                            arrayList.add((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn.zzbc());
                                        }
                                    }
                                    it = arrayList.iterator();
                                    while (it.hasNext()) {
                                        zzhrVar5.zzf((com.google.android.gms.internal.measurement.zzhw) it.next());
                                    }
                                } else {
                                    z7 = z6;
                                    str6 = str5;
                                    i5 = i3;
                                    str7 = str16;
                                }
                                i6 = i17;
                                zzpcVar3.zzc.set(i6, (com.google.android.gms.internal.measurement.zzhs) zzhrVar5.zzbc());
                                zzicVar4.zzg(zzhrVar5);
                                i14 = i + 1;
                                z8 = z7;
                                i12 = i5;
                                z12 = z4;
                            }
                            int i21 = 0;
                            boolean z14 = false;
                            boolean z15 = false;
                            while (true) {
                                z4 = z12;
                                if (i21 >= zzhrVar5.zzb()) {
                                    break;
                                }
                                if ("_c".equals(zzhrVar5.zzc(i21).zzb())) {
                                    com.google.android.gms.internal.measurement.zzhv zzhvVar = (com.google.android.gms.internal.measurement.zzhv) zzhrVar5.zzc(i21).zzcl();
                                    str10 = str15;
                                    zzhvVar.zzf(1L);
                                    zzhrVar5.zzd(i21, (com.google.android.gms.internal.measurement.zzhw) zzhvVar.zzbc());
                                    z14 = true;
                                } else {
                                    str10 = str15;
                                    if ("_r".equals(zzhrVar5.zzc(i21).zzb())) {
                                        com.google.android.gms.internal.measurement.zzhv zzhvVar2 = (com.google.android.gms.internal.measurement.zzhv) zzhrVar5.zzc(i21).zzcl();
                                        zzhvVar2.zzf(1L);
                                        zzhrVar5.zzd(i21, (com.google.android.gms.internal.measurement.zzhw) zzhvVar2.zzbc());
                                        z15 = true;
                                    }
                                }
                                i21++;
                                z12 = z4;
                                str15 = str10;
                            }
                            str4 = str15;
                            if (!z14 && zZzk) {
                                zzaV().zzk().zzb("Marking event as conversion", zzpgVar.zzn.zzl().zza(zzhrVar5.zzk()));
                                com.google.android.gms.internal.measurement.zzhv zzhvVarZzn3 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzhvVarZzn3.zzb("_c");
                                zzhvVarZzn3.zzf(1L);
                                zzhrVar5.zzg(zzhvVarZzn3);
                            }
                            if (!z15) {
                                zzaV().zzk().zzb("Marking event as real-time", zzpgVar.zzn.zzl().zza(zzhrVar5.zzk()));
                                com.google.android.gms.internal.measurement.zzhv zzhvVarZzn4 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzhvVarZzn4.zzb("_r");
                                zzhvVarZzn4.zzf(1L);
                                zzhrVar5.zzg(zzhvVarZzn4);
                            }
                            if (zzj().zzw(zzC(), zzpcVar3.zza.zzA(), false, false, false, false, true, false, false).zze > zzd().zzm(zzpcVar3.zza.zzA(), zzfy.zzo)) {
                                zzaB(zzhrVar5, "_r");
                                z10 = z2;
                            } else {
                                z10 = true;
                            }
                            if (zzpp.zzh(zzhrVar5.zzk()) && zZzk) {
                                z5 = zZzk;
                                z11 = z10;
                                if (zzj().zzw(zzC(), zzpcVar3.zza.zzA(), false, false, true, false, false, false, false).zzc > zzd().zzm(zzpcVar3.zza.zzA(), zzfy.zzn)) {
                                    zzaV().zze().zzb("Too many conversions. Not logging as conversion. appId", zzgu.zzl(zzpcVar3.zza.zzA()));
                                    boolean z16 = false;
                                    int i22 = -1;
                                    com.google.android.gms.internal.measurement.zzhv zzhvVar3 = null;
                                    for (int i23 = 0; i23 < zzhrVar5.zzb(); i23++) {
                                        com.google.android.gms.internal.measurement.zzhw zzhwVarZzc3 = zzhrVar5.zzc(i23);
                                        if ("_c".equals(zzhwVarZzc3.zzb())) {
                                            zzhvVar3 = (com.google.android.gms.internal.measurement.zzhv) zzhwVarZzc3.zzcl();
                                            i22 = i23;
                                        } else if ("_err".equals(zzhwVarZzc3.zzb())) {
                                            z16 = true;
                                        }
                                    }
                                    if (z16) {
                                        if (zzhvVar3 != null) {
                                            zzhrVar5.zzj(i22);
                                        } else {
                                            zzhvVar3 = null;
                                            if (zzhvVar3 != null) {
                                                com.google.android.gms.internal.measurement.zzhv zzhvVar4 = (com.google.android.gms.internal.measurement.zzhv) zzhvVar3.clone();
                                                zzhvVar4.zzb("_err");
                                                zzhvVar4.zzf(10L);
                                                zzhrVar5.zzd(i22, (com.google.android.gms.internal.measurement.zzhw) zzhvVar4.zzbc());
                                            } else {
                                                zzaV().zzb().zzb("Did not find conversion parameter. appId", zzgu.zzl(zzpcVar3.zza.zzA()));
                                            }
                                        }
                                    } else if (zzhvVar3 != null) {
                                        com.google.android.gms.internal.measurement.zzhv zzhvVar5 = (com.google.android.gms.internal.measurement.zzhv) zzhvVar3.clone();
                                        zzhvVar5.zzb("_err");
                                        zzhvVar5.zzf(10L);
                                        zzhrVar5.zzd(i22, (com.google.android.gms.internal.measurement.zzhw) zzhvVar5.zzbc());
                                    } else {
                                        zzaV().zzb().zzb("Did not find conversion parameter. appId", zzgu.zzl(zzpcVar3.zza.zzA()));
                                    }
                                }
                            } else {
                                z5 = zZzk;
                                z11 = z10;
                            }
                            z6 = z11;
                            if (z5) {
                                arrayList2 = new ArrayList(zzhrVar5.zza());
                                i10 = -1;
                                i11 = -1;
                                while (i9 < arrayList2.size()) {
                                    if ("value".equals(((com.google.android.gms.internal.measurement.zzhw) arrayList2.get(i9)).zzb())) {
                                        i10 = i9;
                                    } else if (FirebaseAnalytics.Param.CURRENCY.equals(((com.google.android.gms.internal.measurement.zzhw) arrayList2.get(i9)).zzb())) {
                                        i11 = i9;
                                    }
                                }
                                if (i10 != -1) {
                                    if (((com.google.android.gms.internal.measurement.zzhw) arrayList2.get(i10)).zze()) {
                                    }
                                    if (i11 == -1) {
                                        strZzd = ((com.google.android.gms.internal.measurement.zzhw) arrayList2.get(i11)).zzd();
                                        if (strZzd.length() == 3) {
                                            iCharCount = 0;
                                            while (iCharCount < strZzd.length()) {
                                                iCodePointAt = strZzd.codePointAt(iCharCount);
                                                if (Character.isLetter(iCodePointAt)) {
                                                    iCharCount += Character.charCount(iCodePointAt);
                                                }
                                            }
                                        }
                                    }
                                    zzaV().zzh().zza("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                    zzhrVar5.zzj(i10);
                                    zzaB(zzhrVar5, "_c");
                                    zzaA(zzhrVar5, 19, FirebaseAnalytics.Param.CURRENCY);
                                    break;
                                }
                            }
                            if ("_e".equals(zzhrVar5.zzk())) {
                                zzp();
                                if (zzpk.zzF((com.google.android.gms.internal.measurement.zzhs) zzhrVar5.zzbc(), "_fr") == null) {
                                    if (zzhrVar4 != null) {
                                        zzhrVar2 = (com.google.android.gms.internal.measurement.zzhr) zzhrVar4.clone();
                                        if (zzpgVar.zzaI(zzhrVar5, zzhrVar2)) {
                                            zzicVar4 = zzicVar;
                                            zzicVar4.zzf(i15, zzhrVar2);
                                            i3 = i16;
                                            str5 = str17;
                                            zzhrVar3 = null;
                                            zzhrVar4 = null;
                                        }
                                    }
                                    zzicVar4 = zzicVar;
                                    zzhrVar3 = zzhrVar5;
                                    i3 = i;
                                    str5 = str17;
                                } else {
                                    zzicVar4 = zzicVar;
                                    i3 = i16;
                                    str5 = str17;
                                    zzhrVar3 = zzhrVar6;
                                }
                            } else {
                                zzicVar4 = zzicVar;
                                if ("_vs".equals(zzhrVar5.zzk())) {
                                    zzp();
                                    if (zzpk.zzF((com.google.android.gms.internal.measurement.zzhs) zzhrVar5.zzbc(), str4) == null) {
                                        if (zzhrVar6 != null) {
                                            zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzhrVar6.clone();
                                            if (zzpgVar.zzaI(zzhrVar, zzhrVar5)) {
                                                i3 = i16;
                                                zzicVar4.zzf(i3, zzhrVar);
                                                str5 = str17;
                                                zzhrVar3 = null;
                                                zzhrVar4 = null;
                                            }
                                        }
                                        i3 = i16;
                                        zzhrVar4 = zzhrVar5;
                                        i15 = i;
                                    } else {
                                        i3 = i16;
                                    }
                                } else {
                                    i3 = i16;
                                    if (zzd().zzp(null, zzfy.zzbj)) {
                                        str5 = str17;
                                        if (str5.equals(zzhrVar5.zzk())) {
                                            while (i4 < zzhrVar5.zzb()) {
                                                zzhwVarZzc = zzhrVar5.zzc(i4);
                                                if ("_elt".equals(zzhwVarZzc.zzb())) {
                                                    zzhrVar5.zzr(zzhwVarZzc.zzf());
                                                    zzhrVar5.zzj(i4);
                                                    break;
                                                }
                                            }
                                        } else {
                                            while (i4 < zzhrVar5.zzb()) {
                                                zzhwVarZzc = zzhrVar5.zzc(i4);
                                                if ("_elt".equals(zzhwVarZzc.zzb())) {
                                                    zzhrVar5.zzr(zzhwVarZzc.zzf());
                                                    zzhrVar5.zzj(i4);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    zzhrVar3 = zzhrVar6;
                                }
                                str5 = str17;
                                zzhrVar3 = zzhrVar6;
                            }
                            if (zzhrVar5.zzb() != 0) {
                                zzp();
                                bundleZzE = zzpk.zzE(zzhrVar5.zza());
                                i7 = 0;
                                while (i7 < zzhrVar5.zzb()) {
                                    zzhwVarZzc2 = zzhrVar5.zzc(i7);
                                    str8 = str16;
                                    if (zzhwVarZzc2.zzb().equals(str8)) {
                                        z9 = z6;
                                        str9 = str5;
                                        i8 = i3;
                                        if (!zzhwVarZzc2.zzb().equals(str8)) {
                                            zzpgVar.zzU(zzhrVar5.zzk(), (com.google.android.gms.internal.measurement.zzhv) zzhwVarZzc2.zzcl(), bundleZzE, zzpcVar3.zza.zzA());
                                        }
                                    } else {
                                        z9 = z6;
                                        str9 = str5;
                                        i8 = i3;
                                        if (!zzhwVarZzc2.zzb().equals(str8)) {
                                            zzpgVar.zzU(zzhrVar5.zzk(), (com.google.android.gms.internal.measurement.zzhv) zzhwVarZzc2.zzcl(), bundleZzE, zzpcVar3.zza.zzA());
                                        }
                                    }
                                    i7++;
                                    z6 = z9;
                                    str16 = str8;
                                    i3 = i8;
                                    str5 = str9;
                                }
                                z7 = z6;
                                str6 = str5;
                                i5 = i3;
                                str7 = str16;
                                zzhrVar5.zzi();
                                zzpkVarZzp = zzp();
                                arrayList = new ArrayList();
                                while (r5.hasNext()) {
                                    zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                                    zzhvVarZzn.zzb(str18);
                                    obj = bundleZzE.get(str18);
                                    if (obj != null) {
                                        zzpkVarZzp.zzd(zzhvVarZzn, obj);
                                        arrayList.add((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn.zzbc());
                                    }
                                }
                                it = arrayList.iterator();
                                while (it.hasNext()) {
                                    zzhrVar5.zzf((com.google.android.gms.internal.measurement.zzhw) it.next());
                                }
                            } else {
                                z7 = z6;
                                str6 = str5;
                                i5 = i3;
                                str7 = str16;
                            }
                            i6 = i17;
                            zzpcVar3.zzc.set(i6, (com.google.android.gms.internal.measurement.zzhs) zzhrVar5.zzbc());
                            zzicVar4.zzg(zzhrVar5);
                            i14 = i + 1;
                            z8 = z7;
                            i12 = i5;
                            z12 = z4;
                        }
                        i13 = i6 + 1;
                        str14 = str7;
                        str12 = str3;
                        str13 = str13;
                        z13 = z8;
                        str11 = str6;
                        Throwable th = th;
                        zzj().zzd();
                        throw th;
                    }
                    com.google.android.gms.internal.measurement.zzic zzicVar5 = zzicVar;
                    long j4 = 0;
                    long jLongValue = 0;
                    int i24 = i;
                    int i25 = 0;
                    while (i25 < i24) {
                        com.google.android.gms.internal.measurement.zzhs zzhsVarZzd = zzicVar5.zzd(i25);
                        if ("_e".equals(zzhsVarZzd.zzd())) {
                            zzp();
                            if (zzpk.zzF(zzhsVarZzd, "_fr") != null) {
                                zzicVar5.zzj(i25);
                                i24--;
                                i25--;
                            } else {
                                zzp();
                                zzhwVarZzF = zzpk.zzF(zzhsVarZzd, "_et");
                                if (zzhwVarZzF == null) {
                                    if (zzhwVarZzF.zze()) {
                                        lValueOf = Long.valueOf(zzhwVarZzF.zzf());
                                    } else {
                                        lValueOf = null;
                                    }
                                    if (lValueOf == null && lValueOf.longValue() > 0) {
                                        jLongValue += lValueOf.longValue();
                                    }
                                }
                            }
                        } else {
                            zzp();
                            zzhwVarZzF = zzpk.zzF(zzhsVarZzd, "_et");
                            if (zzhwVarZzF == null) {
                                if (zzhwVarZzF.zze()) {
                                    lValueOf = Long.valueOf(zzhwVarZzF.zzf());
                                } else {
                                    lValueOf = null;
                                }
                                if (lValueOf == null) {
                                }
                            }
                        }
                        i25++;
                    }
                    zzpgVar.zzaH(zzicVar5, jLongValue, false);
                    Iterator it3 = zzicVar5.zzb().iterator();
                    while (it3.hasNext()) {
                        if ("_s".equals(((com.google.android.gms.internal.measurement.zzhs) it3.next()).zzd())) {
                            zzj().zzk(zzicVar5.zzK(), "_se");
                            break;
                        }
                    }
                    if (zzpk.zzx(zzicVar5, "_sid") >= 0) {
                        zzpgVar.zzaH(zzicVar5, jLongValue, true);
                    } else {
                        int iZzx = zzpk.zzx(zzicVar5, "_se");
                        if (iZzx >= 0) {
                            zzicVar5.zzr(iZzx);
                            zzaV().zzb().zzb("Session engagement user property is in the bundle without session ID. appId", zzgu.zzl(zzpcVar3.zza.zzA()));
                        }
                    }
                    String strZzA3 = zzpcVar3.zza.zzA();
                    zzaW().zzg();
                    zzu();
                    zzh zzhVarZzu = zzj().zzu(strZzA3);
                    if (zzhVarZzu == null) {
                        zzaV().zzb().zzb("Cannot fix consent fields without appInfo. appId", zzgu.zzl(strZzA3));
                    } else {
                        zzpgVar.zzI(zzhVarZzu, zzicVar5);
                    }
                    String strZzA4 = zzpcVar3.zza.zzA();
                    zzaW().zzg();
                    zzu();
                    zzh zzhVarZzu2 = zzj().zzu(strZzA4);
                    if (zzhVarZzu2 == null) {
                        zzaV().zze().zzb("Cannot populate ad_campaign_info without appInfo. appId", zzgu.zzl(strZzA4));
                    } else {
                        zzpgVar.zzJ(zzhVarZzu2, zzicVar5);
                    }
                    zzicVar5.zzv(Long.MAX_VALUE);
                    zzicVar5.zzx(Long.MIN_VALUE);
                    for (int i26 = 0; i26 < zzicVar5.zzc(); i26++) {
                        com.google.android.gms.internal.measurement.zzhs zzhsVarZzd2 = zzicVar5.zzd(i26);
                        if (zzhsVarZzd2.zzf() < zzicVar5.zzu()) {
                            zzicVar5.zzv(zzhsVarZzd2.zzf());
                        }
                        if (zzhsVarZzd2.zzf() > zzicVar5.zzw()) {
                            zzicVar5.zzx(zzhsVarZzd2.zzf());
                        }
                    }
                    zzicVar5.zzak();
                    zzjl zzjlVar = zzjl.zza;
                    zzjl zzjlVarZzs = zzpgVar.zzB(zzpcVar3.zza.zzA()).zzs(zzjl.zzf(zzpcVar3.zza.zzaf(), 100));
                    zzjl zzjlVarZzad = zzj().zzad(zzpcVar3.zza.zzA());
                    zzj().zzac(zzpcVar3.zza.zzA(), zzjlVarZzs);
                    zzjk zzjkVar = zzjk.ANALYTICS_STORAGE;
                    if (!zzjlVarZzs.zzo(zzjkVar) && zzjlVarZzad.zzo(zzjkVar)) {
                        zzj().zzi(zzpcVar3.zza.zzA());
                    } else if (zzjlVarZzs.zzo(zzjkVar) && !zzjlVarZzad.zzo(zzjkVar)) {
                        zzj().zzj(zzpcVar3.zza.zzA());
                    }
                    zzjk zzjkVar2 = zzjk.AD_STORAGE;
                    if (!zzjlVarZzs.zzo(zzjkVar2)) {
                        zzicVar5.zzR();
                        zzicVar5.zzU();
                        zzicVar5.zzan();
                    }
                    if (!zzjlVarZzs.zzo(zzjkVar)) {
                        zzicVar5.zzX();
                        zzicVar5.zzav();
                    }
                    zzqp.zza();
                    if (zzd().zzp(zzpcVar3.zza.zzA(), zzfy.zzaP) && zzt().zzX(zzpcVar3.zza.zzA()) && zzpgVar.zzB(zzpcVar3.zza.zzA()).zzo(zzjkVar2) && zzpcVar3.zza.zzak()) {
                        zzpgVar.zzT(zzicVar5, zzpcVar3);
                    }
                    zzicVar5.zzag();
                    zzicVar5.zzaf(zzm().zzb(zzicVar5.zzK(), zzicVar5.zzb(), zzicVar5.zzk(), Long.valueOf(zzicVar5.zzu()), Long.valueOf(zzicVar5.zzw()), !zzjlVarZzs.zzo(zzjkVar)));
                    if (zzd().zzD(zzpcVar3.zza.zzA())) {
                        try {
                            HashMap map = new HashMap();
                            ArrayList arrayList3 = new ArrayList();
                            SecureRandom secureRandomZzf = zzt().zzf();
                            int i27 = 0;
                            while (i27 < zzicVar5.zzc()) {
                                com.google.android.gms.internal.measurement.zzhr zzhrVar7 = (com.google.android.gms.internal.measurement.zzhr) zzicVar5.zzd(i27).zzcl();
                                if (zzhrVar7.zzk().equals("_ep")) {
                                    zzp();
                                    String str19 = (String) zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar7.zzbc(), "_en");
                                    zzbc zzbcVarZzf = (zzbc) map.get(str19);
                                    if (zzbcVarZzf == null && (zzbcVarZzf = zzj().zzf(zzpcVar3.zza.zzA(), (String) Preconditions.checkNotNull(str19))) != null) {
                                        map.put(str19, zzbcVarZzf);
                                    }
                                    if (zzbcVarZzf != null && zzbcVarZzf.zzi == null) {
                                        Long l = zzbcVarZzf.zzj;
                                        if (l != null && l.longValue() > 1) {
                                            zzp();
                                            zzpk.zzC(zzhrVar7, "_sr", l);
                                        }
                                        Boolean bool = zzbcVarZzf.zzk;
                                        if (bool != null && bool.booleanValue()) {
                                            zzp();
                                            zzpk.zzC(zzhrVar7, "_efs", 1L);
                                        }
                                        arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar7.zzbc());
                                    }
                                    zzicVar5.zzf(i27, zzhrVar7);
                                    zzpcVar2 = zzpcVar3;
                                    zzicVar3 = zzicVar5;
                                    secureRandomZzf = secureRandomZzf;
                                } else {
                                    zzht zzhtVarZzh = zzh();
                                    String strZzA5 = zzpcVar3.zza.zzA();
                                    String strZza = zzhtVarZzh.zza(strZzA5, "measurement.account.time_zone_offset_minutes");
                                    if (TextUtils.isEmpty(strZza)) {
                                        j2 = j4;
                                    } else {
                                        try {
                                            j2 = Long.parseLong(strZza);
                                        } catch (NumberFormatException e) {
                                            zzhtVarZzh.zzu.zzaV().zze().zzc("Unable to parse timezone offset. appId", zzgu.zzl(strZzA5), e);
                                            j2 = j4;
                                        }
                                    }
                                    long jZzaj = zzt().zzaj(zzhrVar7.zzn(), j2);
                                    com.google.android.gms.internal.measurement.zzhs zzhsVar = (com.google.android.gms.internal.measurement.zzhs) zzhrVar7.zzbc();
                                    Long l2 = 1L;
                                    if (!TextUtils.isEmpty("_dbg")) {
                                        Iterator it4 = zzhsVar.zza().iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                com.google.android.gms.internal.measurement.zzhw zzhwVar2 = (com.google.android.gms.internal.measurement.zzhw) it4.next();
                                                Iterator it5 = it4;
                                                if ("_dbg".equals(zzhwVar2.zzb())) {
                                                    if (l2.equals(Long.valueOf(zzhwVar2.zzf()))) {
                                                        iZzm = 1;
                                                        break;
                                                    }
                                                } else {
                                                    it4 = it5;
                                                }
                                            }
                                            iZzm = zzh().zzm(zzpcVar3.zza.zzA(), zzhrVar7.zzk());
                                            break;
                                        }
                                    }
                                    iZzm = zzh().zzm(zzpcVar3.zza.zzA(), zzhrVar7.zzk());
                                    break;
                                    if (iZzm <= 0) {
                                        zzaV().zze().zzc("Sample rate must be positive. event, rate", zzhrVar7.zzk(), Integer.valueOf(iZzm));
                                        arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar7.zzbc());
                                        zzicVar5.zzf(i27, zzhrVar7);
                                        zzpcVar2 = zzpcVar3;
                                        zzicVar3 = zzicVar5;
                                        secureRandomZzf = secureRandomZzf;
                                    } else {
                                        zzbc zzbcVarZzc = (zzbc) map.get(zzhrVar7.zzk());
                                        if (zzbcVarZzc == null) {
                                            j3 = j2;
                                            zzbcVarZzc = zzj().zzf(zzpcVar3.zza.zzA(), zzhrVar7.zzk());
                                            if (zzbcVarZzc == null) {
                                                zzaV().zze().zzc("Event being bundled has no eventAggregate. appId, eventName", zzpcVar3.zza.zzA(), zzhrVar7.zzk());
                                                zzbcVarZzc = new zzbc(zzpcVar3.zza.zzA(), zzhrVar7.zzk(), 1L, 1L, 1L, zzhrVar7.zzn(), 0L, null, null, null, null);
                                            }
                                        } else {
                                            j3 = j2;
                                        }
                                        zzp();
                                        Long l3 = (Long) zzpk.zzI((com.google.android.gms.internal.measurement.zzhs) zzhrVar7.zzbc(), "_eid");
                                        boolean z17 = l3 != null;
                                        Boolean boolValueOf = Boolean.valueOf(z17);
                                        zzpcVar2 = zzpcVar3;
                                        if (iZzm == 1) {
                                            arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar7.zzbc());
                                            boolValueOf.getClass();
                                            if (z17 && (zzbcVarZzc.zzi != null || zzbcVarZzc.zzj != null || zzbcVarZzc.zzk != null)) {
                                                map.put(zzhrVar7.zzk(), zzbcVarZzc.zzc(null, null, null));
                                            }
                                            zzicVar5.zzf(i27, zzhrVar7);
                                            zzicVar3 = zzicVar5;
                                            secureRandomZzf = secureRandomZzf;
                                        } else {
                                            if (secureRandomZzf.nextInt(iZzm) == 0) {
                                                zzp();
                                                com.google.android.gms.internal.measurement.zzic zzicVar6 = zzicVar5;
                                                Long lValueOf2 = Long.valueOf(iZzm);
                                                zzpk.zzC(zzhrVar7, "_sr", lValueOf2);
                                                arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar7.zzbc());
                                                boolValueOf.getClass();
                                                if (z17) {
                                                    zzbcVarZzc = zzbcVarZzc.zzc(null, lValueOf2, null);
                                                }
                                                map.put(zzhrVar7.zzk(), zzbcVarZzc.zzb(zzhrVar7.zzn(), jZzaj));
                                                secureRandomZzf = secureRandomZzf;
                                                zzicVar3 = zzicVar6;
                                            } else {
                                                com.google.android.gms.internal.measurement.zzic zzicVar7 = zzicVar5;
                                                Long l4 = zzbcVarZzc.zzh;
                                                if ((l4 != null ? l4.longValue() : zzt().zzaj(zzhrVar7.zzp(), j3)) != jZzaj) {
                                                    zzp();
                                                    zzpk.zzC(zzhrVar7, "_efs", 1L);
                                                    zzp();
                                                    Long lValueOf3 = Long.valueOf(iZzm);
                                                    zzpk.zzC(zzhrVar7, "_sr", lValueOf3);
                                                    arrayList3.add((com.google.android.gms.internal.measurement.zzhs) zzhrVar7.zzbc());
                                                    boolValueOf.getClass();
                                                    if (z17) {
                                                        zzbcVarZzc = zzbcVarZzc.zzc(null, lValueOf3, true);
                                                    }
                                                    map.put(zzhrVar7.zzk(), zzbcVarZzc.zzb(zzhrVar7.zzn(), jZzaj));
                                                } else {
                                                    boolValueOf.getClass();
                                                    if (z17 != 0) {
                                                        map.put(zzhrVar7.zzk(), zzbcVarZzc.zzc(l3, null, null));
                                                    }
                                                }
                                                zzicVar3 = zzicVar7;
                                            }
                                            zzicVar3.zzf(i27, zzhrVar7);
                                        }
                                    }
                                }
                                i27++;
                                secureRandomZzf = secureRandomZzf;
                                zzicVar5 = zzicVar3;
                                zzpcVar3 = zzpcVar2;
                                j4 = 0;
                                zzpgVar = this;
                            }
                            zzpcVar = zzpcVar3;
                            zzicVar2 = zzicVar5;
                            z3 = true;
                            if (arrayList3.size() < zzicVar2.zzc()) {
                                zzicVar2.zzi();
                                zzicVar2.zzh(arrayList3);
                            }
                            Iterator it6 = map.entrySet().iterator();
                            while (it6.hasNext()) {
                                zzj().zzh((zzbc) ((Map.Entry) it6.next()).getValue());
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } else {
                        zzpcVar = zzpcVar3;
                        zzicVar2 = zzicVar5;
                        z3 = true;
                    }
                    zzpc zzpcVar4 = zzpcVar;
                    String strZzA6 = zzpcVar4.zza.zzA();
                    zzh zzhVarZzu3 = zzj().zzu(strZzA6);
                    try {
                        if (zzhVarZzu3 == null) {
                            zzaV().zzb().zzb("Bundling raw events w/o app info. appId", zzgu.zzl(zzpcVar4.zza.zzA()));
                        } else {
                            if (zzicVar2.zzc() > 0) {
                                long jZzp = zzhVarZzu3.zzp();
                                if (jZzp != 0) {
                                    zzicVar2.zzA(jZzp);
                                } else {
                                    zzicVar2.zzB();
                                }
                                long jZzn = zzhVarZzu3.zzn();
                                if (jZzn != 0) {
                                    jZzp = jZzn;
                                }
                                if (jZzp != 0) {
                                    zzicVar2.zzy(jZzp);
                                } else {
                                    zzicVar2.zzz();
                                }
                                zzhVarZzu3.zzM(zzicVar2.zzc());
                                zzicVar2.zzaJ((int) zzhVarZzu3.zzaF());
                                zzicVar2.zzZ((int) zzhVarZzu3.zzG());
                                zzhVarZzu3.zzo(zzicVar2.zzu());
                                zzhVarZzu3.zzq(zzicVar2.zzw());
                                String strZzaa = zzhVarZzu3.zzaa();
                                if (strZzaa != null) {
                                    zzicVar2.zzaa(strZzaa);
                                } else {
                                    zzicVar2.zzab();
                                }
                                i2 = 0;
                                zzj().zzv(zzhVarZzu3, false, false);
                            }
                            if (zzicVar2.zzc() > 0) {
                                this.zzn.zzaU();
                                zzglVarZzb = zzh().zzb(zzpcVar4.zza.zzA());
                                if (zzglVarZzb == null && zzglVarZzb.zza()) {
                                    zzicVar2.zzal(zzglVarZzb.zzb());
                                } else if (zzpcVar4.zza.zzP().isEmpty()) {
                                    zzicVar2.zzal(-1L);
                                } else {
                                    zzaV().zze().zzb("Did not find measurement config or missing version info. appId", zzgu.zzl(zzpcVar4.zza.zzA()));
                                }
                                zzj().zzz((com.google.android.gms.internal.measurement.zzid) zzicVar2.zzbc(), z2);
                            }
                            zzavVarZzj = zzj();
                            list = zzpcVar4.zzb;
                            Preconditions.checkNotNull(list);
                            zzavVarZzj.zzg();
                            zzavVarZzj.zzaw();
                            sb = new StringBuilder("rowid in (");
                            while (i2 < list.size()) {
                                if (i2 != 0) {
                                    sb.append(",");
                                }
                                sb.append(((Long) list.get(i2)).longValue());
                                i2++;
                            }
                            sb.append(")");
                            iDelete = zzavVarZzj.zze().delete("raw_events", sb.toString(), null);
                            if (iDelete != list.size()) {
                                zzavVarZzj.zzu.zzaV().zzb().zzc("Deleted fewer rows from raw events table than expected", Integer.valueOf(iDelete), Integer.valueOf(list.size()));
                            }
                            zzavVarZzj2 = zzj();
                            zzavVarZzj2.zze().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{strZzA6, strZzA6});
                            zzj().zzc();
                            z = z3;
                        }
                        zzavVarZzj2.zze().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{strZzA6, strZzA6});
                    } catch (SQLiteException e2) {
                        zzavVarZzj2.zzu.zzaV().zzb().zzc("Failed to remove unused event metadata. appId", zzgu.zzl(strZzA6), e2);
                    }
                    i2 = 0;
                    if (zzicVar2.zzc() > 0) {
                        this.zzn.zzaU();
                        zzglVarZzb = zzh().zzb(zzpcVar4.zza.zzA());
                        if (zzglVarZzb == null) {
                            if (zzpcVar4.zza.zzP().isEmpty()) {
                                zzicVar2.zzal(-1L);
                            } else {
                                zzaV().zze().zzb("Did not find measurement config or missing version info. appId", zzgu.zzl(zzpcVar4.zza.zzA()));
                            }
                        } else if (zzpcVar4.zza.zzP().isEmpty()) {
                            zzicVar2.zzal(-1L);
                        } else {
                            zzaV().zze().zzb("Did not find measurement config or missing version info. appId", zzgu.zzl(zzpcVar4.zza.zzA()));
                        }
                        zzj().zzz((com.google.android.gms.internal.measurement.zzid) zzicVar2.zzbc(), z2);
                    }
                    zzavVarZzj = zzj();
                    list = zzpcVar4.zzb;
                    Preconditions.checkNotNull(list);
                    zzavVarZzj.zzg();
                    zzavVarZzj.zzaw();
                    sb = new StringBuilder("rowid in (");
                    while (i2 < list.size()) {
                        if (i2 != 0) {
                            sb.append(",");
                        }
                        sb.append(((Long) list.get(i2)).longValue());
                        i2++;
                    }
                    sb.append(")");
                    iDelete = zzavVarZzj.zze().delete("raw_events", sb.toString(), null);
                    if (iDelete != list.size()) {
                        zzavVarZzj.zzu.zzaV().zzb().zzc("Deleted fewer rows from raw events table than expected", Integer.valueOf(iDelete), Integer.valueOf(list.size()));
                    }
                    zzavVarZzj2 = zzj();
                    zzj().zzc();
                    z = z3;
                }
                zzj().zzd();
                return z;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private final void zzaH(com.google.android.gms.internal.measurement.zzic zzicVar, long j, boolean z) throws Throwable {
        Object obj;
        String str = true != z ? "_lte" : "_se";
        zzpn zzpnVarZzm = zzj().zzm(zzicVar.zzK(), str);
        zzpn zzpnVar = (zzpnVarZzm == null || (obj = zzpnVarZzm.zze) == null) ? new zzpn(zzicVar.zzK(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, zzaZ().currentTimeMillis(), Long.valueOf(j)) : new zzpn(zzicVar.zzK(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, zzaZ().currentTimeMillis(), Long.valueOf(((Long) obj).longValue() + j));
        com.google.android.gms.internal.measurement.zzit zzitVarZzm = com.google.android.gms.internal.measurement.zziu.zzm();
        zzitVarZzm.zzb(str);
        zzitVarZzm.zza(zzaZ().currentTimeMillis());
        Object obj2 = zzpnVar.zze;
        zzitVarZzm.zze(((Long) obj2).longValue());
        com.google.android.gms.internal.measurement.zziu zziuVar = (com.google.android.gms.internal.measurement.zziu) zzitVarZzm.zzbc();
        int iZzx = zzpk.zzx(zzicVar, str);
        if (iZzx >= 0) {
            zzicVar.zzn(iZzx, zziuVar);
        } else {
            zzicVar.zzo(zziuVar);
        }
        if (j > 0) {
            zzj().zzl(zzpnVar);
            zzaV().zzk().zzc("Updated engagement user property. scope, value", true != z ? "lifetime" : "session-scoped", obj2);
        }
    }

    private final boolean zzaI(com.google.android.gms.internal.measurement.zzhr zzhrVar, com.google.android.gms.internal.measurement.zzhr zzhrVar2) {
        Preconditions.checkArgument("_e".equals(zzhrVar.zzk()));
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzhwVarZzF = zzpk.zzF((com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc(), "_sc");
        String strZzd = zzhwVarZzF == null ? null : zzhwVarZzF.zzd();
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzhwVarZzF2 = zzpk.zzF((com.google.android.gms.internal.measurement.zzhs) zzhrVar2.zzbc(), "_pc");
        String strZzd2 = zzhwVarZzF2 != null ? zzhwVarZzF2.zzd() : null;
        if (strZzd2 == null || !strZzd2.equals(strZzd)) {
            return false;
        }
        Preconditions.checkArgument("_e".equals(zzhrVar.zzk()));
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzhwVarZzF3 = zzpk.zzF((com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc(), "_et");
        if (zzhwVarZzF3 == null || !zzhwVarZzF3.zze() || zzhwVarZzF3.zzf() <= 0) {
            return true;
        }
        long jZzf = zzhwVarZzF3.zzf();
        zzp();
        com.google.android.gms.internal.measurement.zzhw zzhwVarZzF4 = zzpk.zzF((com.google.android.gms.internal.measurement.zzhs) zzhrVar2.zzbc(), "_et");
        if (zzhwVarZzF4 != null && zzhwVarZzF4.zzf() > 0) {
            jZzf += zzhwVarZzF4.zzf();
        }
        zzp();
        zzpk.zzC(zzhrVar2, "_et", Long.valueOf(jZzf));
        zzp();
        zzpk.zzC(zzhrVar, "_fr", 1L);
        return true;
    }

    private final boolean zzaJ() {
        zzaW().zzg();
        zzu();
        return zzj().zzP() || !TextUtils.isEmpty(zzj().zzF());
    }

    private static String zzaK(Map map, String str) {
        if (map == null) {
            return null;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (str.equalsIgnoreCase((String) entry.getKey())) {
                if (((List) entry.getValue()).isEmpty()) {
                    return null;
                }
                return (String) ((List) entry.getValue()).get(0);
            }
        }
        return null;
    }

    private final void zzaL() {
        long jMax;
        long jMax2;
        zzaW().zzg();
        zzu();
        if (this.zza > 0) {
            long jAbs = 3600000 - Math.abs(zzaZ().elapsedRealtime() - this.zza);
            if (jAbs > 0) {
                zzaV().zzk().zzb("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(jAbs));
                zzk().zzb();
                zzl().zzd();
                return;
            }
            this.zza = 0L;
        }
        if (!this.zzn.zzH() || !zzaJ()) {
            zzaV().zzk().zza("Nothing to upload or uploading impossible");
            zzk().zzb();
            zzl().zzd();
            return;
        }
        long jCurrentTimeMillis = zzaZ().currentTimeMillis();
        zzd();
        long jMax3 = Math.max(0L, ((Long) zzfy.zzO.zzb(null)).longValue());
        boolean z = true;
        if (!zzj().zzR() && !zzj().zzG()) {
            z = false;
        }
        if (z) {
            String strZzA = zzd().zzA();
            if (TextUtils.isEmpty(strZzA) || ".none.".equals(strZzA)) {
                zzd();
                jMax = Math.max(0L, ((Long) zzfy.zzI.zzb(null)).longValue());
            } else {
                zzd();
                jMax = Math.max(0L, ((Long) zzfy.zzJ.zzb(null)).longValue());
            }
        } else {
            zzd();
            jMax = Math.max(0L, ((Long) zzfy.zzH.zzb(null)).longValue());
        }
        long jZza = this.zzk.zzd.zza();
        long jZza2 = this.zzk.zze.zza();
        boolean z2 = z;
        long jMax4 = Math.max(zzj().zzM(), zzj().zzO());
        if (jMax4 != 0) {
            long jAbs2 = jCurrentTimeMillis - Math.abs(jMax4 - jCurrentTimeMillis);
            long jAbs3 = jCurrentTimeMillis - Math.abs(jZza - jCurrentTimeMillis);
            long jAbs4 = jCurrentTimeMillis - Math.abs(jZza2 - jCurrentTimeMillis);
            jMax2 = jAbs2 + jMax3;
            long jMax5 = Math.max(jAbs3, jAbs4);
            if (z2 && jMax5 > 0) {
                jMax2 = Math.min(jAbs2, jMax5) + jMax;
            }
            if (!zzp().zzs(jMax5, jMax)) {
                jMax2 = jMax5 + jMax;
            }
            if (jAbs4 != 0 && jAbs4 >= jAbs2) {
                int i = 0;
                while (true) {
                    zzd();
                    if (i >= Math.min(20, Math.max(0, ((Integer) zzfy.zzQ.zzb(null)).intValue()))) {
                        jMax2 = 0;
                        break;
                    }
                    zzd();
                    jMax2 += Math.max(0L, ((Long) zzfy.zzP.zzb(null)).longValue()) * (1 << i);
                    if (jMax2 > jAbs4) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        } else {
            jMax2 = 0;
            break;
        }
        if (jMax2 == 0) {
            zzaV().zzk().zza("Next upload time is 0");
            zzk().zzb();
            zzl().zzd();
            return;
        }
        if (!zzi().zzb()) {
            zzaV().zzk().zza("No network");
            zzk().zza();
            zzl().zzd();
            return;
        }
        long jZza3 = this.zzk.zzc.zza();
        zzd();
        long jMax6 = Math.max(0L, ((Long) zzfy.zzF.zzb(null)).longValue());
        if (!zzp().zzs(jZza3, jMax6)) {
            jMax2 = Math.max(jMax2, jZza3 + jMax6);
        }
        zzk().zzb();
        long jCurrentTimeMillis2 = jMax2 - zzaZ().currentTimeMillis();
        if (jCurrentTimeMillis2 <= 0) {
            zzd();
            jCurrentTimeMillis2 = Math.max(0L, ((Long) zzfy.zzK.zzb(null)).longValue());
            this.zzk.zzd.zzb(zzaZ().currentTimeMillis());
        }
        zzaV().zzk().zzb("Upload scheduled in approximately ms", Long.valueOf(jCurrentTimeMillis2));
        zzl().zzc(jCurrentTimeMillis2);
    }

    private final void zzaM() {
        zzaW().zzg();
        if (this.zzu || this.zzv || this.zzw) {
            zzaV().zzk().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv), Boolean.valueOf(this.zzw));
            return;
        }
        zzaV().zzk().zza("Stopping uploading service(s)");
        List list = this.zzq;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        ((List) Preconditions.checkNotNull(this.zzq)).clear();
    }

    private final Boolean zzaN(zzh zzhVar) {
        try {
            if (zzhVar.zzt() != -2147483648L) {
                if (zzhVar.zzt() == Wrappers.packageManager(this.zzn.zzaY()).getPackageInfo(zzhVar.zzc(), 0).versionCode) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzn.zzaY()).getPackageInfo(zzhVar.zzc(), 0).versionName;
                String strZzr = zzhVar.zzr();
                if (strZzr != null && strZzr.equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final zzr zzaO(String str) throws Throwable {
        zzh zzhVarZzu = zzj().zzu(str);
        if (zzhVarZzu == null || TextUtils.isEmpty(zzhVarZzu.zzr())) {
            zzaV().zzj().zzb("No app data available; dropping", str);
            return null;
        }
        Boolean boolZzaN = zzaN(zzhVarZzu);
        if (boolZzaN == null || boolZzaN.booleanValue()) {
            return new zzr(str, zzhVarZzu.zzf(), zzhVarZzu.zzr(), zzhVarZzu.zzt(), zzhVarZzu.zzv(), zzhVarZzu.zzx(), zzhVarZzu.zzz(), (String) null, zzhVarZzu.zzD(), false, zzhVarZzu.zzl(), 0L, 0, zzhVarZzu.zzac(), false, zzhVarZzu.zzae(), zzhVarZzu.zzB(), zzhVarZzu.zzag(), zzB(str).zzl(), "", (String) null, zzhVarZzu.zzai(), zzhVarZzu.zzak(), zzB(str).zzb(), zzx(str).zze(), zzhVarZzu.zzao(), zzhVarZzu.zzaw(), zzhVarZzu.zzay(), zzhVarZzu.zzaH(), 0L, zzhVarZzu.zzaL());
        }
        zzaV().zzb().zzb("App version does not match; dropping. appId", zzgu.zzl(str));
        return null;
    }

    private final boolean zzaP(String str, String str2) {
        zzbc zzbcVarZzf = zzj().zzf(str, str2);
        return zzbcVarZzf == null || zzbcVarZzf.zzc < 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzaQ(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT < 34) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
        }
    }

    private static final boolean zzaR(zzr zzrVar) {
        return !TextUtils.isEmpty(zzrVar.zzb);
    }

    private static final zzos zzaS(zzos zzosVar) {
        if (zzosVar == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (zzosVar.zzav()) {
            return zzosVar;
        }
        String strValueOf = String.valueOf(zzosVar.getClass());
        String.valueOf(strValueOf);
        throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(strValueOf)));
    }

    private static final Boolean zzaT(zzr zzrVar) {
        Boolean bool = zzrVar.zzp;
        String str = zzrVar.zzC;
        if (!TextUtils.isEmpty(str)) {
            zzji zzjiVarZza = zze.zzc(str).zza();
            zzji zzjiVar = zzji.UNINITIALIZED;
            int iOrdinal = zzjiVarZza.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                return null;
            }
            if (iOrdinal == 2) {
                return true;
            }
            if (iOrdinal == 3) {
                return false;
            }
        }
        return bool;
    }

    final void zzA(String str, zzjl zzjlVar) {
        zzaW().zzg();
        zzu();
        this.zzC.put(str, zzjlVar);
        zzj().zzZ(str, zzjlVar);
    }

    final zzjl zzB(String str) throws Throwable {
        zzjl zzjlVar = zzjl.zza;
        zzaW().zzg();
        zzu();
        zzjl zzjlVarZzX = (zzjl) this.zzC.get(str);
        if (zzjlVarZzX == null) {
            zzjlVarZzX = zzj().zzX(str);
            if (zzjlVarZzX == null) {
                zzjlVarZzX = zzjl.zza;
            }
            zzA(str, zzjlVarZzX);
        }
        return zzjlVarZzX;
    }

    final long zzC() {
        long jCurrentTimeMillis = zzaZ().currentTimeMillis();
        zznn zznnVar = this.zzk;
        zznnVar.zzaw();
        zznnVar.zzg();
        zzhe zzheVar = zznnVar.zzf;
        long jZza = zzheVar.zza();
        if (jZza == 0) {
            jZza = ((long) zznnVar.zzu.zzk().zzf().nextInt(86400000)) + 1;
            zzheVar.zzb(jZza);
        }
        return ((((jCurrentTimeMillis + jZza) / 1000) / 60) / 60) / 24;
    }

    final void zzD(zzbg zzbgVar, String str) throws Throwable {
        zzh zzhVarZzu = zzj().zzu(str);
        if (zzhVarZzu == null || TextUtils.isEmpty(zzhVarZzu.zzr())) {
            zzaV().zzj().zzb("No app data available; dropping event", str);
            return;
        }
        Boolean boolZzaN = zzaN(zzhVarZzu);
        if (boolZzaN == null) {
            if (!"_ui".equals(zzbgVar.zza)) {
                zzaV().zze().zzb("Could not find package. appId", zzgu.zzl(str));
            }
        } else if (!boolZzaN.booleanValue()) {
            zzaV().zzb().zzb("App version does not match; dropping event. appId", zzgu.zzl(str));
            return;
        }
        zzE(zzbgVar, new zzr(str, zzhVarZzu.zzf(), zzhVarZzu.zzr(), zzhVarZzu.zzt(), zzhVarZzu.zzv(), zzhVarZzu.zzx(), zzhVarZzu.zzz(), (String) null, zzhVarZzu.zzD(), false, zzhVarZzu.zzl(), 0L, 0, zzhVarZzu.zzac(), false, zzhVarZzu.zzae(), zzhVarZzu.zzB(), zzhVarZzu.zzag(), zzB(str).zzl(), "", (String) null, zzhVarZzu.zzai(), zzhVarZzu.zzak(), zzB(str).zzb(), zzx(str).zze(), zzhVarZzu.zzao(), zzhVarZzu.zzaw(), zzhVarZzu.zzay(), zzhVarZzu.zzaH(), 0L, zzhVarZzu.zzaL()));
    }

    final void zzE(zzbg zzbgVar, zzr zzrVar) throws Throwable {
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzgv zzgvVarZza = zzgv.zza(zzbgVar);
        zzt().zzI(zzgvVarZza.zzd, zzj().zzU(str));
        zzt().zzG(zzgvVarZza, zzd().zzd(str));
        zzbg zzbgVarZzb = zzgvVarZza.zzb();
        if (!zzd().zzp(null, zzfy.zzbf) && Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzbgVarZzb.zza)) {
            zzbe zzbeVar = zzbgVarZzb.zzb;
            if ("referrer API v2".equals(zzbeVar.zzd("_cis"))) {
                String strZzd = zzbeVar.zzd("gclid");
                if (!TextUtils.isEmpty(strZzd)) {
                    zzac(new zzpl("_lgclid", zzbgVarZzb.zzd, strZzd, DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzrVar);
                }
            }
        }
        zzF(zzbgVarZzb, zzrVar);
    }

    final void zzF(zzbg zzbgVar, zzr zzrVar) {
        zzbg zzbgVar2;
        List<zzah> listZzt;
        List<zzah> listZzt2;
        List<zzah> listZzt3;
        String str;
        Preconditions.checkNotNull(zzrVar);
        String str2 = zzrVar.zza;
        Preconditions.checkNotEmpty(str2);
        zzaW().zzg();
        zzu();
        long j = zzbgVar.zzd;
        zzgv zzgvVarZza = zzgv.zza(zzbgVar);
        zzaW().zzg();
        zzpp.zzav((this.zzG == null || (str = this.zzH) == null || !str.equals(str2)) ? null : this.zzG, zzgvVarZza.zzd, false);
        zzbg zzbgVarZzb = zzgvVarZza.zzb();
        zzp();
        if (zzpk.zzD(zzbgVarZzb, zzrVar)) {
            if (!zzrVar.zzh) {
                zzao(zzrVar);
                return;
            }
            List list = zzrVar.zzr;
            if (list != null) {
                String str3 = zzbgVarZzb.zza;
                if (!list.contains(str3)) {
                    zzaV().zzj().zzd("Dropping non-safelisted event. appId, event name, origin", str2, zzbgVarZzb.zza, zzbgVarZzb.zzc);
                    return;
                } else {
                    Bundle bundleZzf = zzbgVarZzb.zzb.zzf();
                    bundleZzf.putLong("ga_safelisted", 1L);
                    zzbgVar2 = new zzbg(str3, new zzbe(bundleZzf), zzbgVarZzb.zzc, zzbgVarZzb.zzd);
                }
            } else {
                zzbgVar2 = zzbgVarZzb;
            }
            zzj().zzb();
            try {
                String str4 = zzbgVar2.zza;
                if ("_s".equals(str4) && !zzj().zzQ(str2, "_s") && zzbgVar2.zzb.zzb("_sid").longValue() != 0) {
                    if (zzj().zzQ(str2, "_f") || zzj().zzQ(str2, "_v")) {
                        zzj().zzW(str2, null, "_sid", zzG(str2, zzbgVar2));
                    } else {
                        zzj().zzW(str2, Long.valueOf(zzaZ().currentTimeMillis() - 15000), "_sid", zzG(str2, zzbgVar2));
                    }
                }
                zzav zzavVarZzj = zzj();
                Preconditions.checkNotEmpty(str2);
                zzavVarZzj.zzg();
                zzavVarZzj.zzaw();
                if (j < 0) {
                    zzavVarZzj.zzu.zzaV().zze().zzc("Invalid time querying timed out conditional properties", zzgu.zzl(str2), Long.valueOf(j));
                    listZzt = Collections.emptyList();
                } else {
                    listZzt = zzavVarZzj.zzt("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j)});
                }
                for (zzah zzahVar : listZzt) {
                    if (zzahVar != null) {
                        zzaV().zzk().zzd("User property timed out", zzahVar.zza, this.zzn.zzl().zzc(zzahVar.zzc.zzb), zzahVar.zzc.zza());
                        zzbg zzbgVar3 = zzahVar.zzg;
                        if (zzbgVar3 != null) {
                            zzH(new zzbg(zzbgVar3, j), zzrVar);
                        }
                        zzj().zzr(str2, zzahVar.zzc.zzb);
                    }
                }
                zzav zzavVarZzj2 = zzj();
                Preconditions.checkNotEmpty(str2);
                zzavVarZzj2.zzg();
                zzavVarZzj2.zzaw();
                if (j < 0) {
                    zzavVarZzj2.zzu.zzaV().zze().zzc("Invalid time querying expired conditional properties", zzgu.zzl(str2), Long.valueOf(j));
                    listZzt2 = Collections.emptyList();
                } else {
                    listZzt2 = zzavVarZzj2.zzt("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(listZzt2.size());
                for (zzah zzahVar2 : listZzt2) {
                    if (zzahVar2 != null) {
                        zzaV().zzk().zzd("User property expired", zzahVar2.zza, this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzc.zza());
                        zzj().zzk(str2, zzahVar2.zzc.zzb);
                        zzbg zzbgVar4 = zzahVar2.zzk;
                        if (zzbgVar4 != null) {
                            arrayList.add(zzbgVar4);
                        }
                        zzj().zzr(str2, zzahVar2.zzc.zzb);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    zzH(new zzbg((zzbg) it.next(), j), zzrVar);
                }
                zzav zzavVarZzj3 = zzj();
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str4);
                zzavVarZzj3.zzg();
                zzavVarZzj3.zzaw();
                if (j < 0) {
                    zzic zzicVar = zzavVarZzj3.zzu;
                    zzicVar.zzaV().zze().zzd("Invalid time querying triggered conditional properties", zzgu.zzl(str2), zzicVar.zzl().zza(str4), Long.valueOf(j));
                    listZzt3 = Collections.emptyList();
                } else {
                    listZzt3 = zzavVarZzj3.zzt("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str4, String.valueOf(j)});
                }
                ArrayList arrayList2 = new ArrayList(listZzt3.size());
                for (zzah zzahVar3 : listZzt3) {
                    if (zzahVar3 != null) {
                        zzpl zzplVar = zzahVar3.zzc;
                        zzpn zzpnVar = new zzpn((String) Preconditions.checkNotNull(zzahVar3.zza), zzahVar3.zzb, zzplVar.zzb, j, Preconditions.checkNotNull(zzplVar.zza()));
                        if (zzj().zzl(zzpnVar)) {
                            zzaV().zzk().zzd("User property triggered", zzahVar3.zza, this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                        } else {
                            zzaV().zzb().zzd("Too many active user properties, ignoring", zzgu.zzl(zzahVar3.zza), this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                        }
                        zzbg zzbgVar5 = zzahVar3.zzi;
                        if (zzbgVar5 != null) {
                            arrayList2.add(zzbgVar5);
                        }
                        zzahVar3.zzc = new zzpl(zzpnVar);
                        zzahVar3.zze = true;
                        zzj().zzp(zzahVar3);
                    }
                }
                zzH(zzbgVar2, zzrVar);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    zzH(new zzbg((zzbg) it2.next(), j), zzrVar);
                }
                zzj().zzc();
            } finally {
                zzj().zzd();
            }
        }
    }

    final Bundle zzG(String str, zzbg zzbgVar) throws Throwable {
        Bundle bundle = new Bundle();
        bundle.putLong("_sid", zzbgVar.zzb.zzb("_sid").longValue());
        zzpn zzpnVarZzm = zzj().zzm(str, "_sno");
        if (zzpnVarZzm != null) {
            Object obj = zzpnVarZzm.zze;
            if (obj instanceof Long) {
                bundle.putLong("_sno", ((Long) obj).longValue());
            }
        }
        return bundle;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0387 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x038e A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:108:0x03b2 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x03ca A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x03d1 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:114:0x0405  */
    /* JADX WARN: Code duplicated, block: B:116:0x040c A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x0429  */
    /* JADX WARN: Code duplicated, block: B:120:0x042f A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x044f A[Catch: all -> 0x0bb2, TRY_LEAVE, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x046e A[Catch: all -> 0x0bb2, TRY_ENTER, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x0485  */
    /* JADX WARN: Code duplicated, block: B:129:0x048f A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x04a1 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:136:0x04b5 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x0531 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:159:0x0572 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:161:0x0587 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:166:0x05e1 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:169:0x0625 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:172:0x0630 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:175:0x063b A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:178:0x0646 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:181:0x0652 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:184:0x0663 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:187:0x0692 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:230:0x0735  */
    /* JADX WARN: Code duplicated, block: B:233:0x073f A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:236:0x0765 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:237:0x076a A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:239:0x0770 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:258:0x07f5  */
    /* JADX WARN: Code duplicated, block: B:260:0x07f8 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:263:0x0808 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:266:0x082b A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:289:0x08bb  */
    /* JADX WARN: Code duplicated, block: B:292:0x08fb A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:294:0x0905 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:297:0x0912 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:299:0x092f A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:301:0x0971  */
    /* JADX WARN: Code duplicated, block: B:304:0x097a A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:309:0x099b A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:313:0x09b7 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:315:0x09f3 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:326:0x0a75 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:331:0x0aaf A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:338:0x0b1f A[Catch: SQLiteException -> 0x0b38, all -> 0x0bb2, TRY_LEAVE, TryCatch #0 {SQLiteException -> 0x0b38, blocks: (B:336:0x0b0e, B:338:0x0b1f), top: B:359:0x0b0e, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:340:0x0b33  */
    /* JADX WARN: Code duplicated, block: B:371:0x04cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:388:0x0a12 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:391:0x0a85 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:392:0x0a82 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:393:? A[LOOP:3: B:324:0x0a6f->B:393:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:395:0x033e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:397:0x0328 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x01a3 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x01b8 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:68:0x0202 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0214 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0222 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x026a A[Catch: all -> 0x0bb2, TRY_LEAVE, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x02d5 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x031e  */
    /* JADX WARN: Code duplicated, block: B:94:0x0321 A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x032e A[Catch: all -> 0x0bb2, TryCatch #2 {all -> 0x0bb2, blocks: (B:37:0x0157, B:40:0x0166, B:42:0x016e, B:47:0x0178, B:91:0x030d, B:100:0x0344, B:102:0x0387, B:104:0x038e, B:105:0x03a5, B:108:0x03b2, B:110:0x03ca, B:112:0x03d1, B:113:0x03e8, B:116:0x040c, B:120:0x042f, B:121:0x0446, B:122:0x044f, B:125:0x046e, B:127:0x0487, B:129:0x048f, B:131:0x049b, B:133:0x04a1, B:134:0x04a8, B:136:0x04b5, B:138:0x04bd, B:140:0x04c5, B:142:0x04cf, B:143:0x04db, B:144:0x04e8, B:146:0x050d, B:156:0x0531, B:157:0x0546, B:159:0x0572, B:162:0x0589, B:165:0x05c5, B:167:0x05ed, B:169:0x0625, B:170:0x0628, B:172:0x0630, B:173:0x0633, B:175:0x063b, B:176:0x063e, B:178:0x0646, B:179:0x0649, B:181:0x0652, B:182:0x0656, B:184:0x0663, B:185:0x0666, B:187:0x0692, B:189:0x069c, B:193:0x06b3, B:198:0x06c0, B:231:0x0737, B:233:0x073f, B:234:0x0742, B:236:0x0765, B:239:0x0770, B:242:0x0778, B:243:0x0792, B:245:0x0798, B:247:0x07ac, B:249:0x07b8, B:251:0x07c5, B:255:0x07df, B:256:0x07ef, B:260:0x07f8, B:261:0x07fb, B:263:0x0808, B:264:0x080d, B:266:0x082b, B:268:0x082f, B:270:0x083f, B:272:0x084a, B:273:0x0855, B:275:0x085f, B:277:0x086b, B:279:0x0875, B:281:0x087b, B:283:0x088b, B:285:0x089f, B:287:0x08a5, B:288:0x08ae, B:290:0x08bf, B:292:0x08fb, B:294:0x0905, B:295:0x0908, B:297:0x0912, B:299:0x092f, B:300:0x093a, B:302:0x0972, B:304:0x097a, B:306:0x0984, B:307:0x0991, B:309:0x099b, B:310:0x09a8, B:311:0x09b1, B:313:0x09b7, B:315:0x09f3, B:317:0x09fd, B:319:0x0a0f, B:321:0x0a15, B:322:0x0a59, B:323:0x0a64, B:324:0x0a6f, B:326:0x0a75, B:335:0x0ac3, B:336:0x0b0e, B:338:0x0b1f, B:352:0x0b81, B:341:0x0b35, B:343:0x0b39, B:329:0x0a85, B:331:0x0aaf, B:347:0x0b52, B:348:0x0b69, B:351:0x0b6c, B:237:0x076a, B:201:0x06cb, B:205:0x06d7, B:209:0x06e5, B:213:0x06f3, B:217:0x0701, B:221:0x070f, B:225:0x071b, B:229:0x0728, B:166:0x05e1, B:153:0x0519, B:94:0x0321, B:95:0x0328, B:97:0x032e, B:99:0x033e, B:54:0x0195, B:56:0x01a3, B:58:0x01b8, B:64:0x01d8, B:69:0x020e, B:71:0x0214, B:73:0x0222, B:75:0x0237, B:78:0x023e, B:87:0x02cb, B:89:0x02d5, B:80:0x026a, B:81:0x028b, B:86:0x02b2, B:85:0x029f, B:67:0x01e4, B:68:0x0202), top: B:362:0x0157, inners: #0, #1, #6, #8 }] */
    final void zzH(zzbg zzbgVar, zzr zzrVar) throws Throwable {
        zzbe zzbeVar;
        String str;
        String strZzd;
        long jLongValue;
        String upperCase;
        String strConcat;
        zzpn zzpnVarZzm;
        zzav zzavVarZzj;
        zzpn zzpnVar;
        zzpn zzpnVar2;
        double dDoubleValue;
        String str2;
        boolean zZzh;
        boolean zEquals;
        zzbe zzbeVar2;
        zzbd zzbdVar;
        long length;
        Object objZza;
        zzbg zzbgVar2;
        zzar zzarVarZzx;
        long jZzH;
        Bundle bundleZzf;
        zzav zzavVarZzj2;
        String str3;
        long jDelete;
        zzbb zzbbVar;
        zzic zzicVar;
        String str4;
        String str5;
        zzbc zzbcVarZzf;
        zzbc zzbcVarZza;
        String str6;
        com.google.android.gms.internal.measurement.zzic zzicVarZzaE;
        String str7;
        String str8;
        String str9;
        long j;
        String str10;
        long j2;
        com.google.android.gms.internal.measurement.zzjr zzjrVarZza;
        Map mapZzb;
        ArrayList arrayList;
        String str11;
        zzjl zzjlVarZzs;
        zzjk zzjkVar;
        String str12;
        zzic zzicVar2;
        zzh zzhVarZzu;
        int i;
        List listZzn;
        int i2;
        zzav zzavVarZzj3;
        zzav zzavVarZzj4;
        zzbd zzbdVar2;
        boolean zZzk;
        int i3;
        String str13;
        ContentValues contentValues;
        String next;
        zzh zzhVarZzu2;
        Object obj;
        zzpn zzpnVarZzm2;
        Object obj2;
        long jMax;
        long jIntValue;
        String str14 = "app_id";
        String str15 = "_fx";
        Preconditions.checkNotNull(zzrVar);
        String str16 = zzrVar.zza;
        Preconditions.checkNotEmpty(str16);
        long jNanoTime = System.nanoTime();
        zzaW().zzg();
        zzu();
        zzp();
        if (zzpk.zzD(zzbgVar, zzrVar)) {
            if (!zzrVar.zzh) {
                zzao(zzrVar);
                return;
            }
            zzht zzhtVarZzh = zzh();
            String str17 = zzbgVar.zza;
            if (zzhtVarZzh.zzj(str16, str17)) {
                zzaV().zze().zzc("Dropping blocked event. appId", zzgu.zzl(str16), this.zzn.zzl().zza(str17));
                if (!zzh().zzn(str16) && !zzh().zzo(str16)) {
                    if ("_err".equals(str17)) {
                        return;
                    }
                    zzt().zzN(this.zzK, str16, 11, "_ev", str17, 0);
                    return;
                }
                zzh zzhVarZzu3 = zzj().zzu(str16);
                if (zzhVarZzu3 != null) {
                    long jAbs = Math.abs(zzaZ().currentTimeMillis() - Math.max(zzhVarZzu3.zzJ(), zzhVarZzu3.zzH()));
                    zzd();
                    if (jAbs > ((Long) zzfy.zzN.zzb(null)).longValue()) {
                        zzaV().zzj().zza("Fetching config for blocked app");
                        zzW(zzhVarZzu3);
                        return;
                    }
                    return;
                }
                return;
            }
            zzgv zzgvVarZza = zzgv.zza(zzbgVar);
            zzt().zzG(zzgvVarZza, zzd().zzd(str16));
            int iZzn = zzd().zzn(str16, zzfy.zzag, 10, 35);
            Bundle bundle = zzgvVarZza.zzd;
            for (String str18 : new TreeSet(bundle.keySet())) {
                if (FirebaseAnalytics.Param.ITEMS.equals(str18)) {
                    zzt().zzH(bundle.getParcelableArray(str18), iZzn);
                }
            }
            zzbg zzbgVarZzb = zzgvVarZza.zzb();
            if (Log.isLoggable(zzaV().zzn(), 2)) {
                zzaV().zzk().zzb("Logging event", this.zzn.zzl().zzd(zzbgVarZzb));
            }
            zzj().zzb();
            try {
                zzao(zzrVar);
                String str19 = zzbgVarZzb.zza;
                boolean z = "ecommerce_purchase".equals(str19) || FirebaseAnalytics.Event.PURCHASE.equals(str19) || FirebaseAnalytics.Event.REFUND.equals(str19);
                if ("_iap".equals(str19)) {
                    zzbeVar = zzbgVarZzb.zzb;
                    str = "_err";
                    strZzd = zzbeVar.zzd(FirebaseAnalytics.Param.CURRENCY);
                    if (z) {
                        dDoubleValue = zzbeVar.zzc("value").doubleValue() * 1000000.0d;
                        if (dDoubleValue == 0.0d) {
                            dDoubleValue = zzbeVar.zzb("value").longValue() * 1000000.0d;
                        }
                        if (dDoubleValue <= 9.223372036854776E18d || dDoubleValue < -9.223372036854776E18d) {
                            zzaV().zze().zzc("Data lost. Currency value is too big. appId", zzgu.zzl(str16), Double.valueOf(dDoubleValue));
                            zzj().zzc();
                        } else {
                            jLongValue = Math.round(dDoubleValue);
                            if (FirebaseAnalytics.Event.REFUND.equals(str19)) {
                                jLongValue = -jLongValue;
                            }
                        }
                    } else {
                        str14 = "app_id";
                        str15 = "_fx";
                        jLongValue = zzbeVar.zzb("value").longValue();
                    }
                    if (!TextUtils.isEmpty(strZzd)) {
                        upperCase = strZzd.toUpperCase(Locale.US);
                        if (upperCase.matches("[A-Z]{3}")) {
                            String.valueOf(upperCase);
                            strConcat = "_ltv_".concat(String.valueOf(upperCase));
                            zzpnVarZzm = zzj().zzm(str16, strConcat);
                            if (zzpnVarZzm == null && (zzpnVarZzm.zze instanceof Long)) {
                                zzbgVarZzb = zzbgVarZzb;
                                zzpnVar = new zzpn(str16, zzbgVarZzb.zzc, strConcat, zzaZ().currentTimeMillis(), Long.valueOf(((Long) zzpnVarZzm.zze).longValue() + jLongValue));
                            } else {
                                zzbgVarZzb = zzbgVarZzb;
                                zzavVarZzj = zzj();
                                int iZzm = zzd().zzm(str16, zzfy.zzT) - 1;
                                Preconditions.checkNotEmpty(str16);
                                zzavVarZzj.zzg();
                                zzavVarZzj.zzaw();
                                try {
                                    zzavVarZzj.zze().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '!_ltv!_%' escape '!'order by set_timestamp desc limit ?,10);", new String[]{str16, str16, String.valueOf(iZzm)});
                                } catch (SQLiteException e) {
                                    zzavVarZzj.zzu.zzaV().zzb().zzc("Error pruning currencies. appId", zzgu.zzl(str16), e);
                                }
                                zzpnVar = new zzpn(str16, zzbgVarZzb.zzc, strConcat, zzaZ().currentTimeMillis(), Long.valueOf(jLongValue));
                            }
                            zzpnVar2 = zzpnVar;
                            if (!zzj().zzl(zzpnVar2)) {
                                zzaV().zzb().zzd("Too many unique user properties are set. Ignoring user property. appId", zzgu.zzl(str16), this.zzn.zzl().zzc(zzpnVar2.zzc), zzpnVar2.zze);
                                zzt().zzN(this.zzK, str16, 9, null, null, 0);
                            }
                            str2 = zzbgVarZzb.zza;
                            zZzh = zzpp.zzh(str2);
                            zEquals = str.equals(str2);
                            zzt();
                            zzbeVar2 = zzbgVarZzb.zzb;
                            if (zzbeVar2 == null) {
                                length = 0;
                            } else {
                                zzbdVar = new zzbd(zzbeVar2);
                                length = 0;
                                while (zzbdVar.hasNext()) {
                                    String next2 = zzbdVar.next();
                                    String str20 = next2;
                                    objZza = zzbeVar2.zza(next2);
                                    if (objZza instanceof Parcelable[]) {
                                        length += (long) ((Parcelable[]) objZza).length;
                                    }
                                }
                            }
                            zzbgVar2 = zzbgVarZzb;
                            zzarVarZzx = zzj().zzx(zzC(), str16, length + 1, true, zZzh, false, zEquals, false, false, false);
                            long j3 = zzarVarZzx.zzb;
                            zzd();
                            jZzH = j3 - zzal.zzH();
                            if (jZzH > 0) {
                                if (jZzH % 1000 == 1) {
                                    zzaV().zzb().zzc("Data loss. Too many events logged. appId, count", zzgu.zzl(str16), Long.valueOf(zzarVarZzx.zzb));
                                }
                                zzj().zzc();
                            } else if (zZzh) {
                                long j4 = zzarVarZzx.zza;
                                zzd();
                                jIntValue = j4 - ((long) ((Integer) zzfy.zzm.zzb(null)).intValue());
                                if (jIntValue > 0) {
                                    if (jIntValue % 1000 == 1) {
                                        zzaV().zzb().zzc("Data loss. Too many public events logged. appId, count", zzgu.zzl(str16), Long.valueOf(zzarVarZzx.zza));
                                    }
                                    zzt().zzN(this.zzK, str16, 16, "_ev", zzbgVar2.zza, 0);
                                    zzj().zzc();
                                } else {
                                    if (zEquals) {
                                        bundleZzf = zzbeVar2.zzf();
                                        zzpp zzppVarZzt = zzt();
                                        String str21 = zzbgVar2.zzc;
                                        zzppVarZzt.zzM(bundleZzf, "_o", str21);
                                        if (zzt().zzaa(str16, zzrVar.zzB)) {
                                            zzt().zzM(bundleZzf, "_dbg", 1L);
                                            zzt().zzM(bundleZzf, "_r", 1L);
                                        }
                                        if ("_s".equals(str2)) {
                                            obj2 = zzpnVarZzm2.zze;
                                            if (obj2 instanceof Long) {
                                                zzt().zzM(bundleZzf, "_sno", obj2);
                                            }
                                        }
                                        if (zzd().zzp(null, zzfy.zzaX)) {
                                            obj = bundleZzf.get("value");
                                            if (obj instanceof String) {
                                                double d = Double.parseDouble((String) obj);
                                                bundleZzf.remove("value");
                                                bundleZzf.putDouble("value", d);
                                            }
                                        }
                                        zzavVarZzj2 = zzj();
                                        Preconditions.checkNotEmpty(str16);
                                        zzavVarZzj2.zzg();
                                        zzavVarZzj2.zzaw();
                                        str3 = r6;
                                        jDelete = zzavVarZzj2.zze().delete(str3, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str16, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzavVarZzj2.zzu.zzc().zzm(str16, zzfy.zzp))))});
                                        if (jDelete > 0) {
                                            zzaV().zze().zzc("Data lost. Too many events stored on disk, deleted. appId", zzgu.zzl(str16), Long.valueOf(jDelete));
                                        }
                                        zzicVar = this.zzn;
                                        str4 = str3;
                                        zzbbVar = new zzbb(zzicVar, zzbgVar2.zzc, str16, zzbgVar2.zza, zzbgVar2.zzd, 0L, bundleZzf);
                                        zzav zzavVarZzj5 = zzj();
                                        str5 = zzbbVar.zzb;
                                        zzbcVarZzf = zzavVarZzj5.zzf(str16, str5);
                                        if (zzbcVarZzf != null) {
                                            if (zzj().zzS(str16) >= zzd().zzh(str16)) {
                                            }
                                            zzbcVarZza = new zzbc(str16, str5, 0L, 0L, 0L, zzbbVar.zzd, 0L, null, null, null, null);
                                        } else {
                                            zzbbVar = zzbbVar.zza(zzicVar, zzbcVarZzf.zzf);
                                            zzbcVarZza = zzbcVarZzf.zza(zzbbVar.zzd);
                                        }
                                        zzj().zzh(zzbcVarZza);
                                        zzaW().zzg();
                                        zzu();
                                        Preconditions.checkNotNull(zzbbVar);
                                        Preconditions.checkNotNull(zzrVar);
                                        String str22 = zzbbVar.zza;
                                        Preconditions.checkNotEmpty(str22);
                                        str6 = zzrVar.zza;
                                        Preconditions.checkArgument(str22.equals(str6));
                                        zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                                        boolean z2 = true;
                                        zzicVarZzaE.zza(1);
                                        zzicVarZzaE.zzC("android");
                                        if (!TextUtils.isEmpty(str6)) {
                                            zzicVarZzaE.zzL(str6);
                                        }
                                        str7 = zzrVar.zzd;
                                        if (!TextUtils.isEmpty(str7)) {
                                            zzicVarZzaE.zzJ(str7);
                                        }
                                        str8 = zzrVar.zzc;
                                        if (!TextUtils.isEmpty(str8)) {
                                            zzicVarZzaE.zzM(str8);
                                        }
                                        str9 = zzrVar.zzu;
                                        if (!TextUtils.isEmpty(str9)) {
                                            zzicVarZzaE.zzau(str9);
                                        }
                                        j = zzrVar.zzj;
                                        if (j != -2147483648L) {
                                            zzicVarZzaE.zzaj((int) j);
                                        }
                                        zzicVarZzaE.zzN(zzrVar.zze);
                                        str10 = zzrVar.zzb;
                                        if (!TextUtils.isEmpty(str10)) {
                                            zzicVarZzaE.zzad(str10);
                                        }
                                        zzjl zzjlVarZzs2 = zzB((String) Preconditions.checkNotNull(str6)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                        zzicVarZzaE.zzat(zzjlVarZzs2.zzk());
                                        zzqp.zza();
                                        if (!zzd().zzp(str6, zzfy.zzaP)) {
                                        }
                                        j2 = zzrVar.zzf;
                                        if (j2 != 0) {
                                            zzicVarZzaE.zzY(j2);
                                        }
                                        zzicVarZzaE.zzar(zzrVar.zzq);
                                        zzpk zzpkVarZzp = zzp();
                                        zzjrVarZza = com.google.android.gms.internal.measurement.zzjr.zza(zzpkVarZzp.zzg.zzn.zzaY().getContentResolver(), com.google.android.gms.internal.measurement.zzkb.zza("com.google.android.gms.measurement"), zzfu.zza);
                                        if (zzjrVarZza == null) {
                                            mapZzb = Collections.emptyMap();
                                        } else {
                                            mapZzb = zzjrVarZza.zzb();
                                        }
                                        if (mapZzb != null) {
                                            arrayList = null;
                                        } else {
                                            arrayList = null;
                                        }
                                        if (arrayList != null) {
                                            zzicVarZzaE.zzaq(arrayList);
                                        }
                                        if (zzd().zzp(null, zzfy.zzba)) {
                                            zzicVarZzaE.zzaP("");
                                        }
                                        str11 = zzrVar.zza;
                                        zzjlVarZzs = zzB((String) Preconditions.checkNotNull(str11)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                        zzjkVar = zzjk.AD_STORAGE;
                                        if (zzjlVarZzs.zzo(zzjkVar)) {
                                            zzjlVarZzs = zzjlVarZzs;
                                            zzjkVar = zzjkVar;
                                            str12 = "_r";
                                        } else {
                                            zzjlVarZzs = zzjlVarZzs;
                                            zzjkVar = zzjkVar;
                                            str12 = "_r";
                                        }
                                        zzicVar2 = this.zzn;
                                        zzicVar2.zzu().zzw();
                                        zzicVarZzaE.zzF(Build.MODEL);
                                        zzicVar2.zzu().zzw();
                                        zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                                        zzicVarZzaE.zzI((int) zzicVar2.zzu().zzb());
                                        zzicVarZzaE.zzH(zzicVar2.zzu().zzc());
                                        zzicVarZzaE.zzay(zzrVar.zzw);
                                        if (zzicVar2.zzB()) {
                                            zzicVarZzaE.zzK();
                                            if (!TextUtils.isEmpty(null)) {
                                                zzicVarZzaE.zzam(null);
                                            }
                                        }
                                        zzhVarZzu = zzj().zzu(str11);
                                        if (zzhVarZzu == null) {
                                            zzhVarZzu = new zzh(zzicVar2, str11);
                                            zzhVarZzu.zze(zzK(zzjlVarZzs));
                                            zzhVarZzu.zzm(zzrVar.zzk);
                                            zzhVarZzu.zzg(zzrVar.zzb);
                                            if (zzjlVarZzs.zzo(zzjkVar)) {
                                                zzhVarZzu.zzk(this.zzk.zzf(str11, zzrVar.zzn));
                                            }
                                            zzhVarZzu.zzF(0L);
                                            zzhVarZzu.zzo(0L);
                                            zzhVarZzu.zzq(0L);
                                            zzhVarZzu.zzs(zzrVar.zzc);
                                            zzhVarZzu.zzu(zzrVar.zzj);
                                            zzhVarZzu.zzw(zzrVar.zzd);
                                            zzhVarZzu.zzy(zzrVar.zze);
                                            zzhVarZzu.zzA(zzrVar.zzf);
                                            zzhVarZzu.zzE(zzrVar.zzh);
                                            zzhVarZzu.zzC(zzrVar.zzq);
                                            i = 0;
                                            zzj().zzv(zzhVarZzu, false, false);
                                        } else {
                                            i = 0;
                                        }
                                        if (zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                                            zzicVarZzaE.zzW((String) Preconditions.checkNotNull(zzhVarZzu.zzd()));
                                        }
                                        if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                            zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                                        }
                                        listZzn = zzj().zzn(str11);
                                        for (i2 = i; i2 < listZzn.size(); i2++) {
                                            com.google.android.gms.internal.measurement.zzit zzitVarZzm = com.google.android.gms.internal.measurement.zziu.zzm();
                                            zzitVarZzm.zzb(((zzpn) listZzn.get(i2)).zzc);
                                            zzitVarZzm.zza(((zzpn) listZzn.get(i2)).zzd);
                                            zzp().zzc(zzitVarZzm, ((zzpn) listZzn.get(i2)).zze);
                                            zzicVarZzaE.zzp(zzitVarZzm);
                                            if (!"_sid".equals(((zzpn) listZzn.get(i2)).zzc)) {
                                            }
                                        }
                                        zzavVarZzj3 = zzj();
                                        com.google.android.gms.internal.measurement.zzid zzidVar = (com.google.android.gms.internal.measurement.zzid) zzicVarZzaE.zzbc();
                                        zzavVarZzj3.zzg();
                                        zzavVarZzj3.zzaw();
                                        Preconditions.checkNotNull(zzidVar);
                                        Preconditions.checkNotEmpty(zzidVar.zzA());
                                        byte[] bArrZzcc = zzidVar.zzcc();
                                        long jZzt = zzavVarZzj3.zzg.zzp().zzt(bArrZzcc);
                                        ContentValues contentValues2 = new ContentValues();
                                        String str23 = str14;
                                        contentValues2.put(str23, zzidVar.zzA());
                                        contentValues2.put("metadata_fingerprint", Long.valueOf(jZzt));
                                        contentValues2.put("metadata", bArrZzcc);
                                        zzavVarZzj3.zze().insertWithOnConflict("raw_events_metadata", null, contentValues2, 4);
                                        zzavVarZzj4 = zzj();
                                        zzbdVar2 = new zzbd(zzbbVar.zzf);
                                        while (true) {
                                            if (zzbdVar2.hasNext()) {
                                                zzht zzhtVarZzh2 = zzh();
                                                String str24 = zzbbVar.zza;
                                                zZzk = zzhtVarZzh2.zzk(str24, zzbbVar.zzb);
                                                zzar zzarVarZzw = zzj().zzw(zzC(), str24, false, false, false, false, false, false, false);
                                                if (zZzk) {
                                                }
                                                i3 = 0;
                                                break;
                                            }
                                            next = zzbdVar2.next();
                                            String str25 = next;
                                            if (str12.equals(next)) {
                                            }
                                            i3 = 1;
                                            break;
                                        }
                                        zzavVarZzj4.zzg();
                                        zzavVarZzj4.zzaw();
                                        Preconditions.checkNotNull(zzbbVar);
                                        str13 = zzbbVar.zza;
                                        Preconditions.checkNotEmpty(str13);
                                        byte[] bArrZzcc2 = zzavVarZzj4.zzg.zzp().zzh(zzbbVar).zzcc();
                                        contentValues = new ContentValues();
                                        contentValues.put(str23, str13);
                                        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbbVar.zzb);
                                        contentValues.put(ServerValues.NAME_OP_TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                                        contentValues.put("metadata_fingerprint", Long.valueOf(jZzt));
                                        contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzcc2);
                                        contentValues.put("realtime", Integer.valueOf(i3));
                                        if (zzavVarZzj4.zze().insert(str4, null, contentValues) == -1) {
                                            zzavVarZzj4.zzu.zzaV().zzb().zzb("Failed to insert raw event (got -1). appId", zzgu.zzl(str13));
                                        } else {
                                            this.zza = 0L;
                                        }
                                        zzj().zzc();
                                        zzj().zzd();
                                        zzaL();
                                        zzaV().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                        return;
                                    }
                                    jMax = zzarVarZzx.zzd - ((long) Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzd().zzm(zzrVar.zza, zzfy.zzl))));
                                    if (jMax > 0) {
                                        bundleZzf = zzbeVar2.zzf();
                                        zzpp zzppVarZzt2 = zzt();
                                        String str26 = zzbgVar2.zzc;
                                        zzppVarZzt2.zzM(bundleZzf, "_o", str26);
                                        if (zzt().zzaa(str16, zzrVar.zzB)) {
                                            zzt().zzM(bundleZzf, "_dbg", 1L);
                                            zzt().zzM(bundleZzf, "_r", 1L);
                                        }
                                        if ("_s".equals(str2) && (zzpnVarZzm2 = zzj().zzm(zzrVar.zza, "_sno")) != null) {
                                            obj2 = zzpnVarZzm2.zze;
                                            if (obj2 instanceof Long) {
                                                zzt().zzM(bundleZzf, "_sno", obj2);
                                            }
                                        }
                                        if (zzd().zzp(null, zzfy.zzaX) && Objects.equals(str26, "am") && Objects.equals(str2, "_ai")) {
                                            obj = bundleZzf.get("value");
                                            if (obj instanceof String) {
                                                try {
                                                    double d2 = Double.parseDouble((String) obj);
                                                    bundleZzf.remove("value");
                                                    bundleZzf.putDouble("value", d2);
                                                } catch (NumberFormatException unused) {
                                                }
                                            }
                                        }
                                        zzavVarZzj2 = zzj();
                                        Preconditions.checkNotEmpty(str16);
                                        zzavVarZzj2.zzg();
                                        zzavVarZzj2.zzaw();
                                        try {
                                            str3 = r6;
                                            try {
                                                jDelete = zzavVarZzj2.zze().delete(str3, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str16, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzavVarZzj2.zzu.zzc().zzm(str16, zzfy.zzp))))});
                                            } catch (SQLiteException e2) {
                                                e = e2;
                                                zzavVarZzj2.zzu.zzaV().zzb().zzc("Error deleting over the limit events. appId", zzgu.zzl(str16), e);
                                                jDelete = 0;
                                            }
                                        } catch (SQLiteException e3) {
                                            e = e3;
                                            str3 = r6;
                                        }
                                        if (jDelete > 0) {
                                            zzaV().zze().zzc("Data lost. Too many events stored on disk, deleted. appId", zzgu.zzl(str16), Long.valueOf(jDelete));
                                        }
                                        zzicVar = this.zzn;
                                        str4 = str3;
                                        zzbbVar = new zzbb(zzicVar, zzbgVar2.zzc, str16, zzbgVar2.zza, zzbgVar2.zzd, 0L, bundleZzf);
                                        zzav zzavVarZzj6 = zzj();
                                        str5 = zzbbVar.zzb;
                                        zzbcVarZzf = zzavVarZzj6.zzf(str16, str5);
                                        if (zzbcVarZzf != null) {
                                            zzbbVar = zzbbVar.zza(zzicVar, zzbcVarZzf.zzf);
                                            zzbcVarZza = zzbcVarZzf.zza(zzbbVar.zzd);
                                        } else if (zzj().zzS(str16) >= zzd().zzh(str16) || !zZzh) {
                                            zzbcVarZza = new zzbc(str16, str5, 0L, 0L, 0L, zzbbVar.zzd, 0L, null, null, null, null);
                                        } else {
                                            zzaV().zzb().zzd("Too many event names used, ignoring event. appId, name, supported count", zzgu.zzl(str16), zzicVar.zzl().zza(str5), Integer.valueOf(zzd().zzh(str16)));
                                            zzt().zzN(this.zzK, str16, 8, null, null, 0);
                                        }
                                        zzj().zzh(zzbcVarZza);
                                        zzaW().zzg();
                                        zzu();
                                        Preconditions.checkNotNull(zzbbVar);
                                        Preconditions.checkNotNull(zzrVar);
                                        String str27 = zzbbVar.zza;
                                        Preconditions.checkNotEmpty(str27);
                                        str6 = zzrVar.zza;
                                        Preconditions.checkArgument(str27.equals(str6));
                                        zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                                        boolean z3 = true;
                                        zzicVarZzaE.zza(1);
                                        zzicVarZzaE.zzC("android");
                                        if (!TextUtils.isEmpty(str6)) {
                                            zzicVarZzaE.zzL(str6);
                                        }
                                        str7 = zzrVar.zzd;
                                        if (!TextUtils.isEmpty(str7)) {
                                            zzicVarZzaE.zzJ(str7);
                                        }
                                        str8 = zzrVar.zzc;
                                        if (!TextUtils.isEmpty(str8)) {
                                            zzicVarZzaE.zzM(str8);
                                        }
                                        str9 = zzrVar.zzu;
                                        if (!TextUtils.isEmpty(str9)) {
                                            zzicVarZzaE.zzau(str9);
                                        }
                                        j = zzrVar.zzj;
                                        if (j != -2147483648L) {
                                            zzicVarZzaE.zzaj((int) j);
                                        }
                                        zzicVarZzaE.zzN(zzrVar.zze);
                                        str10 = zzrVar.zzb;
                                        if (!TextUtils.isEmpty(str10)) {
                                            zzicVarZzaE.zzad(str10);
                                        }
                                        zzjl zzjlVarZzs3 = zzB((String) Preconditions.checkNotNull(str6)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                        zzicVarZzaE.zzat(zzjlVarZzs3.zzk());
                                        zzqp.zza();
                                        if (!zzd().zzp(str6, zzfy.zzaP) && zzt().zzX(str6)) {
                                            zzicVarZzaE.zzaH(zzrVar.zzz);
                                            long j5 = zzrVar.zzA;
                                            if (!zzjlVarZzs3.zzo(zzjk.AD_STORAGE) && j5 != 0) {
                                                j5 = (j5 & (-2)) | 32;
                                            }
                                            zzicVarZzaE.zzaz(j5 == 1);
                                            if (j5 != 0) {
                                                com.google.android.gms.internal.measurement.zzhd zzhdVarZzh = com.google.android.gms.internal.measurement.zzhe.zzh();
                                                if ((j5 & 1) == 0) {
                                                    z3 = false;
                                                }
                                                zzhdVarZzh.zza(z3);
                                                zzhdVarZzh.zzb((j5 & 2) != 0);
                                                zzhdVarZzh.zzc((j5 & 4) != 0);
                                                zzhdVarZzh.zzd((j5 & 8) != 0);
                                                zzhdVarZzh.zze((j5 & 16) != 0);
                                                zzhdVarZzh.zzf((j5 & 32) != 0);
                                                zzhdVarZzh.zzg((64 & j5) != 0);
                                                zzicVarZzaE.zzaI((com.google.android.gms.internal.measurement.zzhe) zzhdVarZzh.zzbc());
                                            }
                                        }
                                        j2 = zzrVar.zzf;
                                        if (j2 != 0) {
                                            zzicVarZzaE.zzY(j2);
                                        }
                                        zzicVarZzaE.zzar(zzrVar.zzq);
                                        zzpk zzpkVarZzp2 = zzp();
                                        zzjrVarZza = com.google.android.gms.internal.measurement.zzjr.zza(zzpkVarZzp2.zzg.zzn.zzaY().getContentResolver(), com.google.android.gms.internal.measurement.zzkb.zza("com.google.android.gms.measurement"), zzfu.zza);
                                        if (zzjrVarZza == null) {
                                            mapZzb = Collections.emptyMap();
                                        } else {
                                            mapZzb = zzjrVarZza.zzb();
                                        }
                                        if (mapZzb != null || mapZzb.isEmpty()) {
                                            arrayList = null;
                                        } else {
                                            arrayList = new ArrayList();
                                            int iIntValue = ((Integer) zzfy.zzaf.zzb(null)).intValue();
                                            for (Map.Entry entry : mapZzb.entrySet()) {
                                                if (((String) entry.getKey()).startsWith("measurement.id.")) {
                                                    try {
                                                        int i4 = Integer.parseInt((String) entry.getValue());
                                                        if (i4 != 0) {
                                                            arrayList.add(Integer.valueOf(i4));
                                                            if (arrayList.size() >= iIntValue) {
                                                                zzpkVarZzp2.zzu.zzaV().zze().zzb("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                                                                break;
                                                            }
                                                            continue;
                                                        } else {
                                                            continue;
                                                        }
                                                    } catch (NumberFormatException e4) {
                                                        zzpkVarZzp2.zzu.zzaV().zze().zzb("Experiment ID NumberFormatException", e4);
                                                    }
                                                }
                                            }
                                            if (arrayList.isEmpty()) {
                                                arrayList = null;
                                            }
                                        }
                                        if (arrayList != null) {
                                            zzicVarZzaE.zzaq(arrayList);
                                        }
                                        if (zzd().zzp(null, zzfy.zzba)) {
                                            zzicVarZzaE.zzaP("");
                                        }
                                        str11 = zzrVar.zza;
                                        zzjlVarZzs = zzB((String) Preconditions.checkNotNull(str11)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                        zzjkVar = zzjk.AD_STORAGE;
                                        if (zzjlVarZzs.zzo(zzjkVar) || !zzrVar.zzn) {
                                            zzjlVarZzs = zzjlVarZzs;
                                            zzjkVar = zzjkVar;
                                            str12 = "_r";
                                        } else {
                                            Pair pairZzc = this.zzk.zzc(str11, zzjlVarZzs);
                                            if (TextUtils.isEmpty((CharSequence) pairZzc.first)) {
                                                zzjlVarZzs = zzjlVarZzs;
                                                zzjkVar = zzjkVar;
                                                str12 = "_r";
                                            } else {
                                                zzicVarZzaE.zzQ((String) pairZzc.first);
                                                if (pairZzc.second != null) {
                                                    zzicVarZzaE.zzT(((Boolean) pairZzc.second).booleanValue());
                                                }
                                                String str28 = str15;
                                                if (zzbbVar.zzb.equals(str28) || ((String) pairZzc.first).equals("00000000-0000-0000-0000-000000000000") || (zzhVarZzu2 = zzj().zzu(str11)) == null || !zzhVarZzu2.zzaq()) {
                                                    zzjlVarZzs = zzjlVarZzs;
                                                    zzjkVar = zzjkVar;
                                                    str12 = "_r";
                                                } else {
                                                    zzR(str11, false, null, null);
                                                    Bundle bundle2 = new Bundle();
                                                    Long lZzas = zzhVarZzu2.zzas();
                                                    if (lZzas != null) {
                                                        bundle2.putLong("_pfo", Math.max(0L, lZzas.longValue()));
                                                    }
                                                    Long lZzau = zzhVarZzu2.zzau();
                                                    if (lZzau != null) {
                                                        bundle2.putLong("_uwa", lZzau.longValue());
                                                    }
                                                    str12 = "_r";
                                                    bundle2.putLong(str12, 1L);
                                                    this.zzK.zza(str11, str28, bundle2);
                                                }
                                            }
                                        }
                                        zzicVar2 = this.zzn;
                                        zzicVar2.zzu().zzw();
                                        zzicVarZzaE.zzF(Build.MODEL);
                                        zzicVar2.zzu().zzw();
                                        zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                                        zzicVarZzaE.zzI((int) zzicVar2.zzu().zzb());
                                        zzicVarZzaE.zzH(zzicVar2.zzu().zzc());
                                        zzicVarZzaE.zzay(zzrVar.zzw);
                                        if (zzicVar2.zzB()) {
                                            zzicVarZzaE.zzK();
                                            if (!TextUtils.isEmpty(null)) {
                                                zzicVarZzaE.zzam(null);
                                            }
                                        }
                                        zzhVarZzu = zzj().zzu(str11);
                                        if (zzhVarZzu == null) {
                                            zzhVarZzu = new zzh(zzicVar2, str11);
                                            zzhVarZzu.zze(zzK(zzjlVarZzs));
                                            zzhVarZzu.zzm(zzrVar.zzk);
                                            zzhVarZzu.zzg(zzrVar.zzb);
                                            if (zzjlVarZzs.zzo(zzjkVar)) {
                                                zzhVarZzu.zzk(this.zzk.zzf(str11, zzrVar.zzn));
                                            }
                                            zzhVarZzu.zzF(0L);
                                            zzhVarZzu.zzo(0L);
                                            zzhVarZzu.zzq(0L);
                                            zzhVarZzu.zzs(zzrVar.zzc);
                                            zzhVarZzu.zzu(zzrVar.zzj);
                                            zzhVarZzu.zzw(zzrVar.zzd);
                                            zzhVarZzu.zzy(zzrVar.zze);
                                            zzhVarZzu.zzA(zzrVar.zzf);
                                            zzhVarZzu.zzE(zzrVar.zzh);
                                            zzhVarZzu.zzC(zzrVar.zzq);
                                            i = 0;
                                            zzj().zzv(zzhVarZzu, false, false);
                                        } else {
                                            i = 0;
                                        }
                                        if (zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE) && !TextUtils.isEmpty(zzhVarZzu.zzd())) {
                                            zzicVarZzaE.zzW((String) Preconditions.checkNotNull(zzhVarZzu.zzd()));
                                        }
                                        if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                            zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                                        }
                                        listZzn = zzj().zzn(str11);
                                        while (i2 < listZzn.size()) {
                                            com.google.android.gms.internal.measurement.zzit zzitVarZzm2 = com.google.android.gms.internal.measurement.zziu.zzm();
                                            zzitVarZzm2.zzb(((zzpn) listZzn.get(i2)).zzc);
                                            zzitVarZzm2.zza(((zzpn) listZzn.get(i2)).zzd);
                                            zzp().zzc(zzitVarZzm2, ((zzpn) listZzn.get(i2)).zze);
                                            zzicVarZzaE.zzp(zzitVarZzm2);
                                            if (!"_sid".equals(((zzpn) listZzn.get(i2)).zzc) && zzhVarZzu.zzam() != 0 && zzp().zzu(zzrVar.zzu) != zzhVarZzu.zzam()) {
                                                zzicVarZzaE.zzav();
                                            }
                                        }
                                        try {
                                            zzavVarZzj3 = zzj();
                                            com.google.android.gms.internal.measurement.zzid zzidVar2 = (com.google.android.gms.internal.measurement.zzid) zzicVarZzaE.zzbc();
                                            zzavVarZzj3.zzg();
                                            zzavVarZzj3.zzaw();
                                            Preconditions.checkNotNull(zzidVar2);
                                            Preconditions.checkNotEmpty(zzidVar2.zzA());
                                            byte[] bArrZzcc3 = zzidVar2.zzcc();
                                            long jZzt2 = zzavVarZzj3.zzg.zzp().zzt(bArrZzcc3);
                                            ContentValues contentValues3 = new ContentValues();
                                            String str29 = str14;
                                            contentValues3.put(str29, zzidVar2.zzA());
                                            contentValues3.put("metadata_fingerprint", Long.valueOf(jZzt2));
                                            contentValues3.put("metadata", bArrZzcc3);
                                            try {
                                                zzavVarZzj3.zze().insertWithOnConflict("raw_events_metadata", null, contentValues3, 4);
                                                zzavVarZzj4 = zzj();
                                                zzbdVar2 = new zzbd(zzbbVar.zzf);
                                                while (true) {
                                                    if (zzbdVar2.hasNext()) {
                                                        zzht zzhtVarZzh3 = zzh();
                                                        String str210 = zzbbVar.zza;
                                                        zZzk = zzhtVarZzh3.zzk(str210, zzbbVar.zzb);
                                                        zzar zzarVarZzw2 = zzj().zzw(zzC(), str210, false, false, false, false, false, false, false);
                                                        if (zZzk || zzarVarZzw2.zze >= zzd().zzm(str210, zzfy.zzo)) {
                                                            i3 = 0;
                                                            break;
                                                        }
                                                    } else {
                                                        next = zzbdVar2.next();
                                                        String str211 = next;
                                                        if (str12.equals(next)) {
                                                        }
                                                    }
                                                    i3 = 1;
                                                    break;
                                                }
                                                zzavVarZzj4.zzg();
                                                zzavVarZzj4.zzaw();
                                                Preconditions.checkNotNull(zzbbVar);
                                                str13 = zzbbVar.zza;
                                                Preconditions.checkNotEmpty(str13);
                                                byte[] bArrZzcc4 = zzavVarZzj4.zzg.zzp().zzh(zzbbVar).zzcc();
                                                contentValues = new ContentValues();
                                                contentValues.put(str29, str13);
                                                contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbbVar.zzb);
                                                contentValues.put(ServerValues.NAME_OP_TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                                                contentValues.put("metadata_fingerprint", Long.valueOf(jZzt2));
                                                contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzcc4);
                                                contentValues.put("realtime", Integer.valueOf(i3));
                                                try {
                                                    if (zzavVarZzj4.zze().insert(str4, null, contentValues) == -1) {
                                                        zzavVarZzj4.zzu.zzaV().zzb().zzb("Failed to insert raw event (got -1). appId", zzgu.zzl(str13));
                                                    } else {
                                                        this.zza = 0L;
                                                    }
                                                } catch (SQLiteException e5) {
                                                    zzavVarZzj4.zzu.zzaV().zzb().zzc("Error storing raw event. appId", zzgu.zzl(zzbbVar.zza), e5);
                                                }
                                            } catch (SQLiteException e6) {
                                                zzavVarZzj3.zzu.zzaV().zzb().zzc("Error storing raw event metadata. appId", zzgu.zzl(zzidVar2.zzA()), e6);
                                                throw e6;
                                            }
                                        } catch (IOException e7) {
                                            zzaV().zzb().zzc("Data loss. Failed to insert raw event metadata. appId", zzgu.zzl(zzicVarZzaE.zzK()), e7);
                                        }
                                        zzj().zzc();
                                        zzj().zzd();
                                        zzaL();
                                        zzaV().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                        return;
                                    }
                                    if (jMax == 1) {
                                        zzaV().zzb().zzc("Too many error events logged. appId, count", zzgu.zzl(str16), Long.valueOf(zzarVarZzx.zzd));
                                    }
                                    zzj().zzc();
                                }
                            } else {
                                if (zEquals) {
                                    bundleZzf = zzbeVar2.zzf();
                                    zzpp zzppVarZzt3 = zzt();
                                    String str212 = zzbgVar2.zzc;
                                    zzppVarZzt3.zzM(bundleZzf, "_o", str212);
                                    if (zzt().zzaa(str16, zzrVar.zzB)) {
                                        zzt().zzM(bundleZzf, "_dbg", 1L);
                                        zzt().zzM(bundleZzf, "_r", 1L);
                                    }
                                    if ("_s".equals(str2)) {
                                        obj2 = zzpnVarZzm2.zze;
                                        if (obj2 instanceof Long) {
                                            zzt().zzM(bundleZzf, "_sno", obj2);
                                        }
                                    }
                                    if (zzd().zzp(null, zzfy.zzaX)) {
                                        obj = bundleZzf.get("value");
                                        if (obj instanceof String) {
                                            double d3 = Double.parseDouble((String) obj);
                                            bundleZzf.remove("value");
                                            bundleZzf.putDouble("value", d3);
                                        }
                                    }
                                    zzavVarZzj2 = zzj();
                                    Preconditions.checkNotEmpty(str16);
                                    zzavVarZzj2.zzg();
                                    zzavVarZzj2.zzaw();
                                    str3 = r6;
                                    jDelete = zzavVarZzj2.zze().delete(str3, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str16, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzavVarZzj2.zzu.zzc().zzm(str16, zzfy.zzp))))});
                                    if (jDelete > 0) {
                                        zzaV().zze().zzc("Data lost. Too many events stored on disk, deleted. appId", zzgu.zzl(str16), Long.valueOf(jDelete));
                                    }
                                    zzicVar = this.zzn;
                                    str4 = str3;
                                    zzbbVar = new zzbb(zzicVar, zzbgVar2.zzc, str16, zzbgVar2.zza, zzbgVar2.zzd, 0L, bundleZzf);
                                    zzav zzavVarZzj7 = zzj();
                                    str5 = zzbbVar.zzb;
                                    zzbcVarZzf = zzavVarZzj7.zzf(str16, str5);
                                    if (zzbcVarZzf != null) {
                                        if (zzj().zzS(str16) >= zzd().zzh(str16)) {
                                        }
                                        zzbcVarZza = new zzbc(str16, str5, 0L, 0L, 0L, zzbbVar.zzd, 0L, null, null, null, null);
                                    } else {
                                        zzbbVar = zzbbVar.zza(zzicVar, zzbcVarZzf.zzf);
                                        zzbcVarZza = zzbcVarZzf.zza(zzbbVar.zzd);
                                    }
                                    zzj().zzh(zzbcVarZza);
                                    zzaW().zzg();
                                    zzu();
                                    Preconditions.checkNotNull(zzbbVar);
                                    Preconditions.checkNotNull(zzrVar);
                                    String str213 = zzbbVar.zza;
                                    Preconditions.checkNotEmpty(str213);
                                    str6 = zzrVar.zza;
                                    Preconditions.checkArgument(str213.equals(str6));
                                    zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                                    boolean z4 = true;
                                    zzicVarZzaE.zza(1);
                                    zzicVarZzaE.zzC("android");
                                    if (!TextUtils.isEmpty(str6)) {
                                        zzicVarZzaE.zzL(str6);
                                    }
                                    str7 = zzrVar.zzd;
                                    if (!TextUtils.isEmpty(str7)) {
                                        zzicVarZzaE.zzJ(str7);
                                    }
                                    str8 = zzrVar.zzc;
                                    if (!TextUtils.isEmpty(str8)) {
                                        zzicVarZzaE.zzM(str8);
                                    }
                                    str9 = zzrVar.zzu;
                                    if (!TextUtils.isEmpty(str9)) {
                                        zzicVarZzaE.zzau(str9);
                                    }
                                    j = zzrVar.zzj;
                                    if (j != -2147483648L) {
                                        zzicVarZzaE.zzaj((int) j);
                                    }
                                    zzicVarZzaE.zzN(zzrVar.zze);
                                    str10 = zzrVar.zzb;
                                    if (!TextUtils.isEmpty(str10)) {
                                        zzicVarZzaE.zzad(str10);
                                    }
                                    zzjl zzjlVarZzs4 = zzB((String) Preconditions.checkNotNull(str6)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                    zzicVarZzaE.zzat(zzjlVarZzs4.zzk());
                                    zzqp.zza();
                                    if (!zzd().zzp(str6, zzfy.zzaP)) {
                                    }
                                    j2 = zzrVar.zzf;
                                    if (j2 != 0) {
                                        zzicVarZzaE.zzY(j2);
                                    }
                                    zzicVarZzaE.zzar(zzrVar.zzq);
                                    zzpk zzpkVarZzp3 = zzp();
                                    zzjrVarZza = com.google.android.gms.internal.measurement.zzjr.zza(zzpkVarZzp3.zzg.zzn.zzaY().getContentResolver(), com.google.android.gms.internal.measurement.zzkb.zza("com.google.android.gms.measurement"), zzfu.zza);
                                    if (zzjrVarZza == null) {
                                        mapZzb = Collections.emptyMap();
                                    } else {
                                        mapZzb = zzjrVarZza.zzb();
                                    }
                                    if (mapZzb != null) {
                                        arrayList = null;
                                    } else {
                                        arrayList = null;
                                    }
                                    if (arrayList != null) {
                                        zzicVarZzaE.zzaq(arrayList);
                                    }
                                    if (zzd().zzp(null, zzfy.zzba)) {
                                        zzicVarZzaE.zzaP("");
                                    }
                                    str11 = zzrVar.zza;
                                    zzjlVarZzs = zzB((String) Preconditions.checkNotNull(str11)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                    zzjkVar = zzjk.AD_STORAGE;
                                    if (zzjlVarZzs.zzo(zzjkVar)) {
                                        zzjlVarZzs = zzjlVarZzs;
                                        zzjkVar = zzjkVar;
                                        str12 = "_r";
                                    } else {
                                        zzjlVarZzs = zzjlVarZzs;
                                        zzjkVar = zzjkVar;
                                        str12 = "_r";
                                    }
                                    zzicVar2 = this.zzn;
                                    zzicVar2.zzu().zzw();
                                    zzicVarZzaE.zzF(Build.MODEL);
                                    zzicVar2.zzu().zzw();
                                    zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                                    zzicVarZzaE.zzI((int) zzicVar2.zzu().zzb());
                                    zzicVarZzaE.zzH(zzicVar2.zzu().zzc());
                                    zzicVarZzaE.zzay(zzrVar.zzw);
                                    if (zzicVar2.zzB()) {
                                        zzicVarZzaE.zzK();
                                        if (!TextUtils.isEmpty(null)) {
                                            zzicVarZzaE.zzam(null);
                                        }
                                    }
                                    zzhVarZzu = zzj().zzu(str11);
                                    if (zzhVarZzu == null) {
                                        zzhVarZzu = new zzh(zzicVar2, str11);
                                        zzhVarZzu.zze(zzK(zzjlVarZzs));
                                        zzhVarZzu.zzm(zzrVar.zzk);
                                        zzhVarZzu.zzg(zzrVar.zzb);
                                        if (zzjlVarZzs.zzo(zzjkVar)) {
                                            zzhVarZzu.zzk(this.zzk.zzf(str11, zzrVar.zzn));
                                        }
                                        zzhVarZzu.zzF(0L);
                                        zzhVarZzu.zzo(0L);
                                        zzhVarZzu.zzq(0L);
                                        zzhVarZzu.zzs(zzrVar.zzc);
                                        zzhVarZzu.zzu(zzrVar.zzj);
                                        zzhVarZzu.zzw(zzrVar.zzd);
                                        zzhVarZzu.zzy(zzrVar.zze);
                                        zzhVarZzu.zzA(zzrVar.zzf);
                                        zzhVarZzu.zzE(zzrVar.zzh);
                                        zzhVarZzu.zzC(zzrVar.zzq);
                                        i = 0;
                                        zzj().zzv(zzhVarZzu, false, false);
                                    } else {
                                        i = 0;
                                    }
                                    if (zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                                        zzicVarZzaE.zzW((String) Preconditions.checkNotNull(zzhVarZzu.zzd()));
                                    }
                                    if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                        zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                                    }
                                    listZzn = zzj().zzn(str11);
                                    while (i2 < listZzn.size()) {
                                        com.google.android.gms.internal.measurement.zzit zzitVarZzm3 = com.google.android.gms.internal.measurement.zziu.zzm();
                                        zzitVarZzm3.zzb(((zzpn) listZzn.get(i2)).zzc);
                                        zzitVarZzm3.zza(((zzpn) listZzn.get(i2)).zzd);
                                        zzp().zzc(zzitVarZzm3, ((zzpn) listZzn.get(i2)).zze);
                                        zzicVarZzaE.zzp(zzitVarZzm3);
                                        if (!"_sid".equals(((zzpn) listZzn.get(i2)).zzc)) {
                                        }
                                    }
                                    zzavVarZzj3 = zzj();
                                    com.google.android.gms.internal.measurement.zzid zzidVar3 = (com.google.android.gms.internal.measurement.zzid) zzicVarZzaE.zzbc();
                                    zzavVarZzj3.zzg();
                                    zzavVarZzj3.zzaw();
                                    Preconditions.checkNotNull(zzidVar3);
                                    Preconditions.checkNotEmpty(zzidVar3.zzA());
                                    byte[] bArrZzcc5 = zzidVar3.zzcc();
                                    long jZzt3 = zzavVarZzj3.zzg.zzp().zzt(bArrZzcc5);
                                    ContentValues contentValues4 = new ContentValues();
                                    String str214 = str14;
                                    contentValues4.put(str214, zzidVar3.zzA());
                                    contentValues4.put("metadata_fingerprint", Long.valueOf(jZzt3));
                                    contentValues4.put("metadata", bArrZzcc5);
                                    zzavVarZzj3.zze().insertWithOnConflict("raw_events_metadata", null, contentValues4, 4);
                                    zzavVarZzj4 = zzj();
                                    zzbdVar2 = new zzbd(zzbbVar.zzf);
                                    while (true) {
                                        if (zzbdVar2.hasNext()) {
                                            zzht zzhtVarZzh4 = zzh();
                                            String str215 = zzbbVar.zza;
                                            zZzk = zzhtVarZzh4.zzk(str215, zzbbVar.zzb);
                                            zzar zzarVarZzw3 = zzj().zzw(zzC(), str215, false, false, false, false, false, false, false);
                                            if (zZzk) {
                                            }
                                            i3 = 0;
                                            break;
                                        }
                                        next = zzbdVar2.next();
                                        String str216 = next;
                                        if (str12.equals(next)) {
                                        }
                                        i3 = 1;
                                        break;
                                    }
                                    zzavVarZzj4.zzg();
                                    zzavVarZzj4.zzaw();
                                    Preconditions.checkNotNull(zzbbVar);
                                    str13 = zzbbVar.zza;
                                    Preconditions.checkNotEmpty(str13);
                                    byte[] bArrZzcc6 = zzavVarZzj4.zzg.zzp().zzh(zzbbVar).zzcc();
                                    contentValues = new ContentValues();
                                    contentValues.put(str214, str13);
                                    contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbbVar.zzb);
                                    contentValues.put(ServerValues.NAME_OP_TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                                    contentValues.put("metadata_fingerprint", Long.valueOf(jZzt3));
                                    contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzcc6);
                                    contentValues.put("realtime", Integer.valueOf(i3));
                                    if (zzavVarZzj4.zze().insert(str4, null, contentValues) == -1) {
                                        zzavVarZzj4.zzu.zzaV().zzb().zzb("Failed to insert raw event (got -1). appId", zzgu.zzl(str13));
                                    } else {
                                        this.zza = 0L;
                                    }
                                    zzj().zzc();
                                    zzj().zzd();
                                    zzaL();
                                    zzaV().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                    return;
                                }
                                jMax = zzarVarZzx.zzd - ((long) Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzd().zzm(zzrVar.zza, zzfy.zzl))));
                                if (jMax > 0) {
                                    bundleZzf = zzbeVar2.zzf();
                                    zzpp zzppVarZzt4 = zzt();
                                    String str217 = zzbgVar2.zzc;
                                    zzppVarZzt4.zzM(bundleZzf, "_o", str217);
                                    if (zzt().zzaa(str16, zzrVar.zzB)) {
                                        zzt().zzM(bundleZzf, "_dbg", 1L);
                                        zzt().zzM(bundleZzf, "_r", 1L);
                                    }
                                    if ("_s".equals(str2)) {
                                        obj2 = zzpnVarZzm2.zze;
                                        if (obj2 instanceof Long) {
                                            zzt().zzM(bundleZzf, "_sno", obj2);
                                        }
                                    }
                                    if (zzd().zzp(null, zzfy.zzaX)) {
                                        obj = bundleZzf.get("value");
                                        if (obj instanceof String) {
                                            double d4 = Double.parseDouble((String) obj);
                                            bundleZzf.remove("value");
                                            bundleZzf.putDouble("value", d4);
                                        }
                                    }
                                    zzavVarZzj2 = zzj();
                                    Preconditions.checkNotEmpty(str16);
                                    zzavVarZzj2.zzg();
                                    zzavVarZzj2.zzaw();
                                    str3 = r6;
                                    jDelete = zzavVarZzj2.zze().delete(str3, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str16, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzavVarZzj2.zzu.zzc().zzm(str16, zzfy.zzp))))});
                                    if (jDelete > 0) {
                                        zzaV().zze().zzc("Data lost. Too many events stored on disk, deleted. appId", zzgu.zzl(str16), Long.valueOf(jDelete));
                                    }
                                    zzicVar = this.zzn;
                                    str4 = str3;
                                    zzbbVar = new zzbb(zzicVar, zzbgVar2.zzc, str16, zzbgVar2.zza, zzbgVar2.zzd, 0L, bundleZzf);
                                    zzav zzavVarZzj8 = zzj();
                                    str5 = zzbbVar.zzb;
                                    zzbcVarZzf = zzavVarZzj8.zzf(str16, str5);
                                    if (zzbcVarZzf != null) {
                                        if (zzj().zzS(str16) >= zzd().zzh(str16)) {
                                        }
                                        zzbcVarZza = new zzbc(str16, str5, 0L, 0L, 0L, zzbbVar.zzd, 0L, null, null, null, null);
                                    } else {
                                        zzbbVar = zzbbVar.zza(zzicVar, zzbcVarZzf.zzf);
                                        zzbcVarZza = zzbcVarZzf.zza(zzbbVar.zzd);
                                    }
                                    zzj().zzh(zzbcVarZza);
                                    zzaW().zzg();
                                    zzu();
                                    Preconditions.checkNotNull(zzbbVar);
                                    Preconditions.checkNotNull(zzrVar);
                                    String str218 = zzbbVar.zza;
                                    Preconditions.checkNotEmpty(str218);
                                    str6 = zzrVar.zza;
                                    Preconditions.checkArgument(str218.equals(str6));
                                    zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                                    boolean z5 = true;
                                    zzicVarZzaE.zza(1);
                                    zzicVarZzaE.zzC("android");
                                    if (!TextUtils.isEmpty(str6)) {
                                        zzicVarZzaE.zzL(str6);
                                    }
                                    str7 = zzrVar.zzd;
                                    if (!TextUtils.isEmpty(str7)) {
                                        zzicVarZzaE.zzJ(str7);
                                    }
                                    str8 = zzrVar.zzc;
                                    if (!TextUtils.isEmpty(str8)) {
                                        zzicVarZzaE.zzM(str8);
                                    }
                                    str9 = zzrVar.zzu;
                                    if (!TextUtils.isEmpty(str9)) {
                                        zzicVarZzaE.zzau(str9);
                                    }
                                    j = zzrVar.zzj;
                                    if (j != -2147483648L) {
                                        zzicVarZzaE.zzaj((int) j);
                                    }
                                    zzicVarZzaE.zzN(zzrVar.zze);
                                    str10 = zzrVar.zzb;
                                    if (!TextUtils.isEmpty(str10)) {
                                        zzicVarZzaE.zzad(str10);
                                    }
                                    zzjl zzjlVarZzs5 = zzB((String) Preconditions.checkNotNull(str6)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                    zzicVarZzaE.zzat(zzjlVarZzs5.zzk());
                                    zzqp.zza();
                                    if (!zzd().zzp(str6, zzfy.zzaP)) {
                                    }
                                    j2 = zzrVar.zzf;
                                    if (j2 != 0) {
                                        zzicVarZzaE.zzY(j2);
                                    }
                                    zzicVarZzaE.zzar(zzrVar.zzq);
                                    zzpk zzpkVarZzp4 = zzp();
                                    zzjrVarZza = com.google.android.gms.internal.measurement.zzjr.zza(zzpkVarZzp4.zzg.zzn.zzaY().getContentResolver(), com.google.android.gms.internal.measurement.zzkb.zza("com.google.android.gms.measurement"), zzfu.zza);
                                    if (zzjrVarZza == null) {
                                        mapZzb = Collections.emptyMap();
                                    } else {
                                        mapZzb = zzjrVarZza.zzb();
                                    }
                                    if (mapZzb != null) {
                                        arrayList = null;
                                    } else {
                                        arrayList = null;
                                    }
                                    if (arrayList != null) {
                                        zzicVarZzaE.zzaq(arrayList);
                                    }
                                    if (zzd().zzp(null, zzfy.zzba)) {
                                        zzicVarZzaE.zzaP("");
                                    }
                                    str11 = zzrVar.zza;
                                    zzjlVarZzs = zzB((String) Preconditions.checkNotNull(str11)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                    zzjkVar = zzjk.AD_STORAGE;
                                    if (zzjlVarZzs.zzo(zzjkVar)) {
                                        zzjlVarZzs = zzjlVarZzs;
                                        zzjkVar = zzjkVar;
                                        str12 = "_r";
                                    } else {
                                        zzjlVarZzs = zzjlVarZzs;
                                        zzjkVar = zzjkVar;
                                        str12 = "_r";
                                    }
                                    zzicVar2 = this.zzn;
                                    zzicVar2.zzu().zzw();
                                    zzicVarZzaE.zzF(Build.MODEL);
                                    zzicVar2.zzu().zzw();
                                    zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                                    zzicVarZzaE.zzI((int) zzicVar2.zzu().zzb());
                                    zzicVarZzaE.zzH(zzicVar2.zzu().zzc());
                                    zzicVarZzaE.zzay(zzrVar.zzw);
                                    if (zzicVar2.zzB()) {
                                        zzicVarZzaE.zzK();
                                        if (!TextUtils.isEmpty(null)) {
                                            zzicVarZzaE.zzam(null);
                                        }
                                    }
                                    zzhVarZzu = zzj().zzu(str11);
                                    if (zzhVarZzu == null) {
                                        zzhVarZzu = new zzh(zzicVar2, str11);
                                        zzhVarZzu.zze(zzK(zzjlVarZzs));
                                        zzhVarZzu.zzm(zzrVar.zzk);
                                        zzhVarZzu.zzg(zzrVar.zzb);
                                        if (zzjlVarZzs.zzo(zzjkVar)) {
                                            zzhVarZzu.zzk(this.zzk.zzf(str11, zzrVar.zzn));
                                        }
                                        zzhVarZzu.zzF(0L);
                                        zzhVarZzu.zzo(0L);
                                        zzhVarZzu.zzq(0L);
                                        zzhVarZzu.zzs(zzrVar.zzc);
                                        zzhVarZzu.zzu(zzrVar.zzj);
                                        zzhVarZzu.zzw(zzrVar.zzd);
                                        zzhVarZzu.zzy(zzrVar.zze);
                                        zzhVarZzu.zzA(zzrVar.zzf);
                                        zzhVarZzu.zzE(zzrVar.zzh);
                                        zzhVarZzu.zzC(zzrVar.zzq);
                                        i = 0;
                                        zzj().zzv(zzhVarZzu, false, false);
                                    } else {
                                        i = 0;
                                    }
                                    if (zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                                        zzicVarZzaE.zzW((String) Preconditions.checkNotNull(zzhVarZzu.zzd()));
                                    }
                                    if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                        zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                                    }
                                    listZzn = zzj().zzn(str11);
                                    while (i2 < listZzn.size()) {
                                        com.google.android.gms.internal.measurement.zzit zzitVarZzm4 = com.google.android.gms.internal.measurement.zziu.zzm();
                                        zzitVarZzm4.zzb(((zzpn) listZzn.get(i2)).zzc);
                                        zzitVarZzm4.zza(((zzpn) listZzn.get(i2)).zzd);
                                        zzp().zzc(zzitVarZzm4, ((zzpn) listZzn.get(i2)).zze);
                                        zzicVarZzaE.zzp(zzitVarZzm4);
                                        if (!"_sid".equals(((zzpn) listZzn.get(i2)).zzc)) {
                                        }
                                    }
                                    zzavVarZzj3 = zzj();
                                    com.google.android.gms.internal.measurement.zzid zzidVar4 = (com.google.android.gms.internal.measurement.zzid) zzicVarZzaE.zzbc();
                                    zzavVarZzj3.zzg();
                                    zzavVarZzj3.zzaw();
                                    Preconditions.checkNotNull(zzidVar4);
                                    Preconditions.checkNotEmpty(zzidVar4.zzA());
                                    byte[] bArrZzcc7 = zzidVar4.zzcc();
                                    long jZzt4 = zzavVarZzj3.zzg.zzp().zzt(bArrZzcc7);
                                    ContentValues contentValues5 = new ContentValues();
                                    String str219 = str14;
                                    contentValues5.put(str219, zzidVar4.zzA());
                                    contentValues5.put("metadata_fingerprint", Long.valueOf(jZzt4));
                                    contentValues5.put("metadata", bArrZzcc7);
                                    zzavVarZzj3.zze().insertWithOnConflict("raw_events_metadata", null, contentValues5, 4);
                                    zzavVarZzj4 = zzj();
                                    zzbdVar2 = new zzbd(zzbbVar.zzf);
                                    while (true) {
                                        if (zzbdVar2.hasNext()) {
                                            zzht zzhtVarZzh5 = zzh();
                                            String str2110 = zzbbVar.zza;
                                            zZzk = zzhtVarZzh5.zzk(str2110, zzbbVar.zzb);
                                            zzar zzarVarZzw4 = zzj().zzw(zzC(), str2110, false, false, false, false, false, false, false);
                                            if (zZzk) {
                                            }
                                            i3 = 0;
                                            break;
                                        }
                                        next = zzbdVar2.next();
                                        String str2111 = next;
                                        if (str12.equals(next)) {
                                        }
                                        i3 = 1;
                                        break;
                                    }
                                    zzavVarZzj4.zzg();
                                    zzavVarZzj4.zzaw();
                                    Preconditions.checkNotNull(zzbbVar);
                                    str13 = zzbbVar.zza;
                                    Preconditions.checkNotEmpty(str13);
                                    byte[] bArrZzcc8 = zzavVarZzj4.zzg.zzp().zzh(zzbbVar).zzcc();
                                    contentValues = new ContentValues();
                                    contentValues.put(str219, str13);
                                    contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbbVar.zzb);
                                    contentValues.put(ServerValues.NAME_OP_TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                                    contentValues.put("metadata_fingerprint", Long.valueOf(jZzt4));
                                    contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzcc8);
                                    contentValues.put("realtime", Integer.valueOf(i3));
                                    if (zzavVarZzj4.zze().insert(str4, null, contentValues) == -1) {
                                        zzavVarZzj4.zzu.zzaV().zzb().zzb("Failed to insert raw event (got -1). appId", zzgu.zzl(str13));
                                    } else {
                                        this.zza = 0L;
                                    }
                                    zzj().zzc();
                                    zzj().zzd();
                                    zzaL();
                                    zzaV().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                    return;
                                }
                                if (jMax == 1) {
                                    zzaV().zzb().zzc("Too many error events logged. appId, count", zzgu.zzl(str16), Long.valueOf(zzarVarZzx.zzd));
                                }
                                zzj().zzc();
                            }
                        }
                    }
                    str = str;
                    str2 = zzbgVarZzb.zza;
                    zZzh = zzpp.zzh(str2);
                    zEquals = str.equals(str2);
                    zzt();
                    zzbeVar2 = zzbgVarZzb.zzb;
                    if (zzbeVar2 == null) {
                        length = 0;
                    } else {
                        zzbdVar = new zzbd(zzbeVar2);
                        length = 0;
                        while (zzbdVar.hasNext()) {
                            String next3 = zzbdVar.next();
                            String str220 = next3;
                            objZza = zzbeVar2.zza(next3);
                            if (objZza instanceof Parcelable[]) {
                                length += (long) ((Parcelable[]) objZza).length;
                            }
                        }
                    }
                    zzbgVar2 = zzbgVarZzb;
                    zzarVarZzx = zzj().zzx(zzC(), str16, length + 1, true, zZzh, false, zEquals, false, false, false);
                    long j6 = zzarVarZzx.zzb;
                    zzd();
                    jZzH = j6 - zzal.zzH();
                    if (jZzH > 0) {
                        if (jZzH % 1000 == 1) {
                            zzaV().zzb().zzc("Data loss. Too many events logged. appId, count", zzgu.zzl(str16), Long.valueOf(zzarVarZzx.zzb));
                        }
                        zzj().zzc();
                    } else if (zZzh) {
                        long j7 = zzarVarZzx.zza;
                        zzd();
                        jIntValue = j7 - ((long) ((Integer) zzfy.zzm.zzb(null)).intValue());
                        if (jIntValue > 0) {
                            if (jIntValue % 1000 == 1) {
                                zzaV().zzb().zzc("Data loss. Too many public events logged. appId, count", zzgu.zzl(str16), Long.valueOf(zzarVarZzx.zza));
                            }
                            zzt().zzN(this.zzK, str16, 16, "_ev", zzbgVar2.zza, 0);
                            zzj().zzc();
                        } else {
                            if (zEquals) {
                                bundleZzf = zzbeVar2.zzf();
                                zzpp zzppVarZzt5 = zzt();
                                String str2112 = zzbgVar2.zzc;
                                zzppVarZzt5.zzM(bundleZzf, "_o", str2112);
                                if (zzt().zzaa(str16, zzrVar.zzB)) {
                                    zzt().zzM(bundleZzf, "_dbg", 1L);
                                    zzt().zzM(bundleZzf, "_r", 1L);
                                }
                                if ("_s".equals(str2)) {
                                    obj2 = zzpnVarZzm2.zze;
                                    if (obj2 instanceof Long) {
                                        zzt().zzM(bundleZzf, "_sno", obj2);
                                    }
                                }
                                if (zzd().zzp(null, zzfy.zzaX)) {
                                    obj = bundleZzf.get("value");
                                    if (obj instanceof String) {
                                        double d5 = Double.parseDouble((String) obj);
                                        bundleZzf.remove("value");
                                        bundleZzf.putDouble("value", d5);
                                    }
                                }
                                zzavVarZzj2 = zzj();
                                Preconditions.checkNotEmpty(str16);
                                zzavVarZzj2.zzg();
                                zzavVarZzj2.zzaw();
                                str3 = r6;
                                jDelete = zzavVarZzj2.zze().delete(str3, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str16, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzavVarZzj2.zzu.zzc().zzm(str16, zzfy.zzp))))});
                                if (jDelete > 0) {
                                    zzaV().zze().zzc("Data lost. Too many events stored on disk, deleted. appId", zzgu.zzl(str16), Long.valueOf(jDelete));
                                }
                                zzicVar = this.zzn;
                                str4 = str3;
                                zzbbVar = new zzbb(zzicVar, zzbgVar2.zzc, str16, zzbgVar2.zza, zzbgVar2.zzd, 0L, bundleZzf);
                                zzav zzavVarZzj9 = zzj();
                                str5 = zzbbVar.zzb;
                                zzbcVarZzf = zzavVarZzj9.zzf(str16, str5);
                                if (zzbcVarZzf != null) {
                                    if (zzj().zzS(str16) >= zzd().zzh(str16)) {
                                    }
                                    zzbcVarZza = new zzbc(str16, str5, 0L, 0L, 0L, zzbbVar.zzd, 0L, null, null, null, null);
                                } else {
                                    zzbbVar = zzbbVar.zza(zzicVar, zzbcVarZzf.zzf);
                                    zzbcVarZza = zzbcVarZzf.zza(zzbbVar.zzd);
                                }
                                zzj().zzh(zzbcVarZza);
                                zzaW().zzg();
                                zzu();
                                Preconditions.checkNotNull(zzbbVar);
                                Preconditions.checkNotNull(zzrVar);
                                String str2113 = zzbbVar.zza;
                                Preconditions.checkNotEmpty(str2113);
                                str6 = zzrVar.zza;
                                Preconditions.checkArgument(str2113.equals(str6));
                                zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                                boolean z6 = true;
                                zzicVarZzaE.zza(1);
                                zzicVarZzaE.zzC("android");
                                if (!TextUtils.isEmpty(str6)) {
                                    zzicVarZzaE.zzL(str6);
                                }
                                str7 = zzrVar.zzd;
                                if (!TextUtils.isEmpty(str7)) {
                                    zzicVarZzaE.zzJ(str7);
                                }
                                str8 = zzrVar.zzc;
                                if (!TextUtils.isEmpty(str8)) {
                                    zzicVarZzaE.zzM(str8);
                                }
                                str9 = zzrVar.zzu;
                                if (!TextUtils.isEmpty(str9)) {
                                    zzicVarZzaE.zzau(str9);
                                }
                                j = zzrVar.zzj;
                                if (j != -2147483648L) {
                                    zzicVarZzaE.zzaj((int) j);
                                }
                                zzicVarZzaE.zzN(zzrVar.zze);
                                str10 = zzrVar.zzb;
                                if (!TextUtils.isEmpty(str10)) {
                                    zzicVarZzaE.zzad(str10);
                                }
                                zzjl zzjlVarZzs6 = zzB((String) Preconditions.checkNotNull(str6)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                zzicVarZzaE.zzat(zzjlVarZzs6.zzk());
                                zzqp.zza();
                                if (!zzd().zzp(str6, zzfy.zzaP)) {
                                }
                                j2 = zzrVar.zzf;
                                if (j2 != 0) {
                                    zzicVarZzaE.zzY(j2);
                                }
                                zzicVarZzaE.zzar(zzrVar.zzq);
                                zzpk zzpkVarZzp5 = zzp();
                                zzjrVarZza = com.google.android.gms.internal.measurement.zzjr.zza(zzpkVarZzp5.zzg.zzn.zzaY().getContentResolver(), com.google.android.gms.internal.measurement.zzkb.zza("com.google.android.gms.measurement"), zzfu.zza);
                                if (zzjrVarZza == null) {
                                    mapZzb = Collections.emptyMap();
                                } else {
                                    mapZzb = zzjrVarZza.zzb();
                                }
                                if (mapZzb != null) {
                                    arrayList = null;
                                } else {
                                    arrayList = null;
                                }
                                if (arrayList != null) {
                                    zzicVarZzaE.zzaq(arrayList);
                                }
                                if (zzd().zzp(null, zzfy.zzba)) {
                                    zzicVarZzaE.zzaP("");
                                }
                                str11 = zzrVar.zza;
                                zzjlVarZzs = zzB((String) Preconditions.checkNotNull(str11)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                zzjkVar = zzjk.AD_STORAGE;
                                if (zzjlVarZzs.zzo(zzjkVar)) {
                                    zzjlVarZzs = zzjlVarZzs;
                                    zzjkVar = zzjkVar;
                                    str12 = "_r";
                                } else {
                                    zzjlVarZzs = zzjlVarZzs;
                                    zzjkVar = zzjkVar;
                                    str12 = "_r";
                                }
                                zzicVar2 = this.zzn;
                                zzicVar2.zzu().zzw();
                                zzicVarZzaE.zzF(Build.MODEL);
                                zzicVar2.zzu().zzw();
                                zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                                zzicVarZzaE.zzI((int) zzicVar2.zzu().zzb());
                                zzicVarZzaE.zzH(zzicVar2.zzu().zzc());
                                zzicVarZzaE.zzay(zzrVar.zzw);
                                if (zzicVar2.zzB()) {
                                    zzicVarZzaE.zzK();
                                    if (!TextUtils.isEmpty(null)) {
                                        zzicVarZzaE.zzam(null);
                                    }
                                }
                                zzhVarZzu = zzj().zzu(str11);
                                if (zzhVarZzu == null) {
                                    zzhVarZzu = new zzh(zzicVar2, str11);
                                    zzhVarZzu.zze(zzK(zzjlVarZzs));
                                    zzhVarZzu.zzm(zzrVar.zzk);
                                    zzhVarZzu.zzg(zzrVar.zzb);
                                    if (zzjlVarZzs.zzo(zzjkVar)) {
                                        zzhVarZzu.zzk(this.zzk.zzf(str11, zzrVar.zzn));
                                    }
                                    zzhVarZzu.zzF(0L);
                                    zzhVarZzu.zzo(0L);
                                    zzhVarZzu.zzq(0L);
                                    zzhVarZzu.zzs(zzrVar.zzc);
                                    zzhVarZzu.zzu(zzrVar.zzj);
                                    zzhVarZzu.zzw(zzrVar.zzd);
                                    zzhVarZzu.zzy(zzrVar.zze);
                                    zzhVarZzu.zzA(zzrVar.zzf);
                                    zzhVarZzu.zzE(zzrVar.zzh);
                                    zzhVarZzu.zzC(zzrVar.zzq);
                                    i = 0;
                                    zzj().zzv(zzhVarZzu, false, false);
                                } else {
                                    i = 0;
                                }
                                if (zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                                    zzicVarZzaE.zzW((String) Preconditions.checkNotNull(zzhVarZzu.zzd()));
                                }
                                if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                    zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                                }
                                listZzn = zzj().zzn(str11);
                                while (i2 < listZzn.size()) {
                                    com.google.android.gms.internal.measurement.zzit zzitVarZzm5 = com.google.android.gms.internal.measurement.zziu.zzm();
                                    zzitVarZzm5.zzb(((zzpn) listZzn.get(i2)).zzc);
                                    zzitVarZzm5.zza(((zzpn) listZzn.get(i2)).zzd);
                                    zzp().zzc(zzitVarZzm5, ((zzpn) listZzn.get(i2)).zze);
                                    zzicVarZzaE.zzp(zzitVarZzm5);
                                    if (!"_sid".equals(((zzpn) listZzn.get(i2)).zzc)) {
                                    }
                                }
                                zzavVarZzj3 = zzj();
                                com.google.android.gms.internal.measurement.zzid zzidVar5 = (com.google.android.gms.internal.measurement.zzid) zzicVarZzaE.zzbc();
                                zzavVarZzj3.zzg();
                                zzavVarZzj3.zzaw();
                                Preconditions.checkNotNull(zzidVar5);
                                Preconditions.checkNotEmpty(zzidVar5.zzA());
                                byte[] bArrZzcc9 = zzidVar5.zzcc();
                                long jZzt5 = zzavVarZzj3.zzg.zzp().zzt(bArrZzcc9);
                                ContentValues contentValues6 = new ContentValues();
                                String str2114 = str14;
                                contentValues6.put(str2114, zzidVar5.zzA());
                                contentValues6.put("metadata_fingerprint", Long.valueOf(jZzt5));
                                contentValues6.put("metadata", bArrZzcc9);
                                zzavVarZzj3.zze().insertWithOnConflict("raw_events_metadata", null, contentValues6, 4);
                                zzavVarZzj4 = zzj();
                                zzbdVar2 = new zzbd(zzbbVar.zzf);
                                while (true) {
                                    if (zzbdVar2.hasNext()) {
                                        zzht zzhtVarZzh6 = zzh();
                                        String str2115 = zzbbVar.zza;
                                        zZzk = zzhtVarZzh6.zzk(str2115, zzbbVar.zzb);
                                        zzar zzarVarZzw5 = zzj().zzw(zzC(), str2115, false, false, false, false, false, false, false);
                                        if (zZzk) {
                                        }
                                        i3 = 0;
                                        break;
                                    }
                                    next = zzbdVar2.next();
                                    String str2116 = next;
                                    if (str12.equals(next)) {
                                    }
                                    i3 = 1;
                                    break;
                                }
                                zzavVarZzj4.zzg();
                                zzavVarZzj4.zzaw();
                                Preconditions.checkNotNull(zzbbVar);
                                str13 = zzbbVar.zza;
                                Preconditions.checkNotEmpty(str13);
                                byte[] bArrZzcc10 = zzavVarZzj4.zzg.zzp().zzh(zzbbVar).zzcc();
                                contentValues = new ContentValues();
                                contentValues.put(str2114, str13);
                                contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbbVar.zzb);
                                contentValues.put(ServerValues.NAME_OP_TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                                contentValues.put("metadata_fingerprint", Long.valueOf(jZzt5));
                                contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzcc10);
                                contentValues.put("realtime", Integer.valueOf(i3));
                                if (zzavVarZzj4.zze().insert(str4, null, contentValues) == -1) {
                                    zzavVarZzj4.zzu.zzaV().zzb().zzb("Failed to insert raw event (got -1). appId", zzgu.zzl(str13));
                                } else {
                                    this.zza = 0L;
                                }
                                zzj().zzc();
                                zzj().zzd();
                                zzaL();
                                zzaV().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                return;
                            }
                            jMax = zzarVarZzx.zzd - ((long) Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzd().zzm(zzrVar.zza, zzfy.zzl))));
                            if (jMax > 0) {
                                bundleZzf = zzbeVar2.zzf();
                                zzpp zzppVarZzt6 = zzt();
                                String str2117 = zzbgVar2.zzc;
                                zzppVarZzt6.zzM(bundleZzf, "_o", str2117);
                                if (zzt().zzaa(str16, zzrVar.zzB)) {
                                    zzt().zzM(bundleZzf, "_dbg", 1L);
                                    zzt().zzM(bundleZzf, "_r", 1L);
                                }
                                if ("_s".equals(str2)) {
                                    obj2 = zzpnVarZzm2.zze;
                                    if (obj2 instanceof Long) {
                                        zzt().zzM(bundleZzf, "_sno", obj2);
                                    }
                                }
                                if (zzd().zzp(null, zzfy.zzaX)) {
                                    obj = bundleZzf.get("value");
                                    if (obj instanceof String) {
                                        double d6 = Double.parseDouble((String) obj);
                                        bundleZzf.remove("value");
                                        bundleZzf.putDouble("value", d6);
                                    }
                                }
                                zzavVarZzj2 = zzj();
                                Preconditions.checkNotEmpty(str16);
                                zzavVarZzj2.zzg();
                                zzavVarZzj2.zzaw();
                                str3 = r6;
                                jDelete = zzavVarZzj2.zze().delete(str3, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str16, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzavVarZzj2.zzu.zzc().zzm(str16, zzfy.zzp))))});
                                if (jDelete > 0) {
                                    zzaV().zze().zzc("Data lost. Too many events stored on disk, deleted. appId", zzgu.zzl(str16), Long.valueOf(jDelete));
                                }
                                zzicVar = this.zzn;
                                str4 = str3;
                                zzbbVar = new zzbb(zzicVar, zzbgVar2.zzc, str16, zzbgVar2.zza, zzbgVar2.zzd, 0L, bundleZzf);
                                zzav zzavVarZzj10 = zzj();
                                str5 = zzbbVar.zzb;
                                zzbcVarZzf = zzavVarZzj10.zzf(str16, str5);
                                if (zzbcVarZzf != null) {
                                    if (zzj().zzS(str16) >= zzd().zzh(str16)) {
                                    }
                                    zzbcVarZza = new zzbc(str16, str5, 0L, 0L, 0L, zzbbVar.zzd, 0L, null, null, null, null);
                                } else {
                                    zzbbVar = zzbbVar.zza(zzicVar, zzbcVarZzf.zzf);
                                    zzbcVarZza = zzbcVarZzf.zza(zzbbVar.zzd);
                                }
                                zzj().zzh(zzbcVarZza);
                                zzaW().zzg();
                                zzu();
                                Preconditions.checkNotNull(zzbbVar);
                                Preconditions.checkNotNull(zzrVar);
                                String str2118 = zzbbVar.zza;
                                Preconditions.checkNotEmpty(str2118);
                                str6 = zzrVar.zza;
                                Preconditions.checkArgument(str2118.equals(str6));
                                zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                                boolean z7 = true;
                                zzicVarZzaE.zza(1);
                                zzicVarZzaE.zzC("android");
                                if (!TextUtils.isEmpty(str6)) {
                                    zzicVarZzaE.zzL(str6);
                                }
                                str7 = zzrVar.zzd;
                                if (!TextUtils.isEmpty(str7)) {
                                    zzicVarZzaE.zzJ(str7);
                                }
                                str8 = zzrVar.zzc;
                                if (!TextUtils.isEmpty(str8)) {
                                    zzicVarZzaE.zzM(str8);
                                }
                                str9 = zzrVar.zzu;
                                if (!TextUtils.isEmpty(str9)) {
                                    zzicVarZzaE.zzau(str9);
                                }
                                j = zzrVar.zzj;
                                if (j != -2147483648L) {
                                    zzicVarZzaE.zzaj((int) j);
                                }
                                zzicVarZzaE.zzN(zzrVar.zze);
                                str10 = zzrVar.zzb;
                                if (!TextUtils.isEmpty(str10)) {
                                    zzicVarZzaE.zzad(str10);
                                }
                                zzjl zzjlVarZzs7 = zzB((String) Preconditions.checkNotNull(str6)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                zzicVarZzaE.zzat(zzjlVarZzs7.zzk());
                                zzqp.zza();
                                if (!zzd().zzp(str6, zzfy.zzaP)) {
                                }
                                j2 = zzrVar.zzf;
                                if (j2 != 0) {
                                    zzicVarZzaE.zzY(j2);
                                }
                                zzicVarZzaE.zzar(zzrVar.zzq);
                                zzpk zzpkVarZzp6 = zzp();
                                zzjrVarZza = com.google.android.gms.internal.measurement.zzjr.zza(zzpkVarZzp6.zzg.zzn.zzaY().getContentResolver(), com.google.android.gms.internal.measurement.zzkb.zza("com.google.android.gms.measurement"), zzfu.zza);
                                if (zzjrVarZza == null) {
                                    mapZzb = Collections.emptyMap();
                                } else {
                                    mapZzb = zzjrVarZza.zzb();
                                }
                                if (mapZzb != null) {
                                    arrayList = null;
                                } else {
                                    arrayList = null;
                                }
                                if (arrayList != null) {
                                    zzicVarZzaE.zzaq(arrayList);
                                }
                                if (zzd().zzp(null, zzfy.zzba)) {
                                    zzicVarZzaE.zzaP("");
                                }
                                str11 = zzrVar.zza;
                                zzjlVarZzs = zzB((String) Preconditions.checkNotNull(str11)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                zzjkVar = zzjk.AD_STORAGE;
                                if (zzjlVarZzs.zzo(zzjkVar)) {
                                    zzjlVarZzs = zzjlVarZzs;
                                    zzjkVar = zzjkVar;
                                    str12 = "_r";
                                } else {
                                    zzjlVarZzs = zzjlVarZzs;
                                    zzjkVar = zzjkVar;
                                    str12 = "_r";
                                }
                                zzicVar2 = this.zzn;
                                zzicVar2.zzu().zzw();
                                zzicVarZzaE.zzF(Build.MODEL);
                                zzicVar2.zzu().zzw();
                                zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                                zzicVarZzaE.zzI((int) zzicVar2.zzu().zzb());
                                zzicVarZzaE.zzH(zzicVar2.zzu().zzc());
                                zzicVarZzaE.zzay(zzrVar.zzw);
                                if (zzicVar2.zzB()) {
                                    zzicVarZzaE.zzK();
                                    if (!TextUtils.isEmpty(null)) {
                                        zzicVarZzaE.zzam(null);
                                    }
                                }
                                zzhVarZzu = zzj().zzu(str11);
                                if (zzhVarZzu == null) {
                                    zzhVarZzu = new zzh(zzicVar2, str11);
                                    zzhVarZzu.zze(zzK(zzjlVarZzs));
                                    zzhVarZzu.zzm(zzrVar.zzk);
                                    zzhVarZzu.zzg(zzrVar.zzb);
                                    if (zzjlVarZzs.zzo(zzjkVar)) {
                                        zzhVarZzu.zzk(this.zzk.zzf(str11, zzrVar.zzn));
                                    }
                                    zzhVarZzu.zzF(0L);
                                    zzhVarZzu.zzo(0L);
                                    zzhVarZzu.zzq(0L);
                                    zzhVarZzu.zzs(zzrVar.zzc);
                                    zzhVarZzu.zzu(zzrVar.zzj);
                                    zzhVarZzu.zzw(zzrVar.zzd);
                                    zzhVarZzu.zzy(zzrVar.zze);
                                    zzhVarZzu.zzA(zzrVar.zzf);
                                    zzhVarZzu.zzE(zzrVar.zzh);
                                    zzhVarZzu.zzC(zzrVar.zzq);
                                    i = 0;
                                    zzj().zzv(zzhVarZzu, false, false);
                                } else {
                                    i = 0;
                                }
                                if (zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                                    zzicVarZzaE.zzW((String) Preconditions.checkNotNull(zzhVarZzu.zzd()));
                                }
                                if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                    zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                                }
                                listZzn = zzj().zzn(str11);
                                while (i2 < listZzn.size()) {
                                    com.google.android.gms.internal.measurement.zzit zzitVarZzm6 = com.google.android.gms.internal.measurement.zziu.zzm();
                                    zzitVarZzm6.zzb(((zzpn) listZzn.get(i2)).zzc);
                                    zzitVarZzm6.zza(((zzpn) listZzn.get(i2)).zzd);
                                    zzp().zzc(zzitVarZzm6, ((zzpn) listZzn.get(i2)).zze);
                                    zzicVarZzaE.zzp(zzitVarZzm6);
                                    if (!"_sid".equals(((zzpn) listZzn.get(i2)).zzc)) {
                                    }
                                }
                                zzavVarZzj3 = zzj();
                                com.google.android.gms.internal.measurement.zzid zzidVar6 = (com.google.android.gms.internal.measurement.zzid) zzicVarZzaE.zzbc();
                                zzavVarZzj3.zzg();
                                zzavVarZzj3.zzaw();
                                Preconditions.checkNotNull(zzidVar6);
                                Preconditions.checkNotEmpty(zzidVar6.zzA());
                                byte[] bArrZzcc11 = zzidVar6.zzcc();
                                long jZzt6 = zzavVarZzj3.zzg.zzp().zzt(bArrZzcc11);
                                ContentValues contentValues7 = new ContentValues();
                                String str2119 = str14;
                                contentValues7.put(str2119, zzidVar6.zzA());
                                contentValues7.put("metadata_fingerprint", Long.valueOf(jZzt6));
                                contentValues7.put("metadata", bArrZzcc11);
                                zzavVarZzj3.zze().insertWithOnConflict("raw_events_metadata", null, contentValues7, 4);
                                zzavVarZzj4 = zzj();
                                zzbdVar2 = new zzbd(zzbbVar.zzf);
                                while (true) {
                                    if (zzbdVar2.hasNext()) {
                                        zzht zzhtVarZzh7 = zzh();
                                        String str21110 = zzbbVar.zza;
                                        zZzk = zzhtVarZzh7.zzk(str21110, zzbbVar.zzb);
                                        zzar zzarVarZzw6 = zzj().zzw(zzC(), str21110, false, false, false, false, false, false, false);
                                        if (zZzk) {
                                        }
                                        i3 = 0;
                                        break;
                                    }
                                    next = zzbdVar2.next();
                                    String str21111 = next;
                                    if (str12.equals(next)) {
                                    }
                                    i3 = 1;
                                    break;
                                }
                                zzavVarZzj4.zzg();
                                zzavVarZzj4.zzaw();
                                Preconditions.checkNotNull(zzbbVar);
                                str13 = zzbbVar.zza;
                                Preconditions.checkNotEmpty(str13);
                                byte[] bArrZzcc12 = zzavVarZzj4.zzg.zzp().zzh(zzbbVar).zzcc();
                                contentValues = new ContentValues();
                                contentValues.put(str2119, str13);
                                contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbbVar.zzb);
                                contentValues.put(ServerValues.NAME_OP_TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                                contentValues.put("metadata_fingerprint", Long.valueOf(jZzt6));
                                contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzcc12);
                                contentValues.put("realtime", Integer.valueOf(i3));
                                if (zzavVarZzj4.zze().insert(str4, null, contentValues) == -1) {
                                    zzavVarZzj4.zzu.zzaV().zzb().zzb("Failed to insert raw event (got -1). appId", zzgu.zzl(str13));
                                } else {
                                    this.zza = 0L;
                                }
                                zzj().zzc();
                                zzj().zzd();
                                zzaL();
                                zzaV().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                return;
                            }
                            if (jMax == 1) {
                                zzaV().zzb().zzc("Too many error events logged. appId, count", zzgu.zzl(str16), Long.valueOf(zzarVarZzx.zzd));
                            }
                            zzj().zzc();
                        }
                    } else {
                        if (zEquals) {
                            bundleZzf = zzbeVar2.zzf();
                            zzpp zzppVarZzt7 = zzt();
                            String str21112 = zzbgVar2.zzc;
                            zzppVarZzt7.zzM(bundleZzf, "_o", str21112);
                            if (zzt().zzaa(str16, zzrVar.zzB)) {
                                zzt().zzM(bundleZzf, "_dbg", 1L);
                                zzt().zzM(bundleZzf, "_r", 1L);
                            }
                            if ("_s".equals(str2)) {
                                obj2 = zzpnVarZzm2.zze;
                                if (obj2 instanceof Long) {
                                    zzt().zzM(bundleZzf, "_sno", obj2);
                                }
                            }
                            if (zzd().zzp(null, zzfy.zzaX)) {
                                obj = bundleZzf.get("value");
                                if (obj instanceof String) {
                                    double d7 = Double.parseDouble((String) obj);
                                    bundleZzf.remove("value");
                                    bundleZzf.putDouble("value", d7);
                                }
                            }
                            zzavVarZzj2 = zzj();
                            Preconditions.checkNotEmpty(str16);
                            zzavVarZzj2.zzg();
                            zzavVarZzj2.zzaw();
                            str3 = r6;
                            jDelete = zzavVarZzj2.zze().delete(str3, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str16, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzavVarZzj2.zzu.zzc().zzm(str16, zzfy.zzp))))});
                            if (jDelete > 0) {
                                zzaV().zze().zzc("Data lost. Too many events stored on disk, deleted. appId", zzgu.zzl(str16), Long.valueOf(jDelete));
                            }
                            zzicVar = this.zzn;
                            str4 = str3;
                            zzbbVar = new zzbb(zzicVar, zzbgVar2.zzc, str16, zzbgVar2.zza, zzbgVar2.zzd, 0L, bundleZzf);
                            zzav zzavVarZzj11 = zzj();
                            str5 = zzbbVar.zzb;
                            zzbcVarZzf = zzavVarZzj11.zzf(str16, str5);
                            if (zzbcVarZzf != null) {
                                if (zzj().zzS(str16) >= zzd().zzh(str16)) {
                                }
                                zzbcVarZza = new zzbc(str16, str5, 0L, 0L, 0L, zzbbVar.zzd, 0L, null, null, null, null);
                            } else {
                                zzbbVar = zzbbVar.zza(zzicVar, zzbcVarZzf.zzf);
                                zzbcVarZza = zzbcVarZzf.zza(zzbbVar.zzd);
                            }
                            zzj().zzh(zzbcVarZza);
                            zzaW().zzg();
                            zzu();
                            Preconditions.checkNotNull(zzbbVar);
                            Preconditions.checkNotNull(zzrVar);
                            String str21113 = zzbbVar.zza;
                            Preconditions.checkNotEmpty(str21113);
                            str6 = zzrVar.zza;
                            Preconditions.checkArgument(str21113.equals(str6));
                            zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                            boolean z8 = true;
                            zzicVarZzaE.zza(1);
                            zzicVarZzaE.zzC("android");
                            if (!TextUtils.isEmpty(str6)) {
                                zzicVarZzaE.zzL(str6);
                            }
                            str7 = zzrVar.zzd;
                            if (!TextUtils.isEmpty(str7)) {
                                zzicVarZzaE.zzJ(str7);
                            }
                            str8 = zzrVar.zzc;
                            if (!TextUtils.isEmpty(str8)) {
                                zzicVarZzaE.zzM(str8);
                            }
                            str9 = zzrVar.zzu;
                            if (!TextUtils.isEmpty(str9)) {
                                zzicVarZzaE.zzau(str9);
                            }
                            j = zzrVar.zzj;
                            if (j != -2147483648L) {
                                zzicVarZzaE.zzaj((int) j);
                            }
                            zzicVarZzaE.zzN(zzrVar.zze);
                            str10 = zzrVar.zzb;
                            if (!TextUtils.isEmpty(str10)) {
                                zzicVarZzaE.zzad(str10);
                            }
                            zzjl zzjlVarZzs8 = zzB((String) Preconditions.checkNotNull(str6)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                            zzicVarZzaE.zzat(zzjlVarZzs8.zzk());
                            zzqp.zza();
                            if (!zzd().zzp(str6, zzfy.zzaP)) {
                            }
                            j2 = zzrVar.zzf;
                            if (j2 != 0) {
                                zzicVarZzaE.zzY(j2);
                            }
                            zzicVarZzaE.zzar(zzrVar.zzq);
                            zzpk zzpkVarZzp7 = zzp();
                            zzjrVarZza = com.google.android.gms.internal.measurement.zzjr.zza(zzpkVarZzp7.zzg.zzn.zzaY().getContentResolver(), com.google.android.gms.internal.measurement.zzkb.zza("com.google.android.gms.measurement"), zzfu.zza);
                            if (zzjrVarZza == null) {
                                mapZzb = Collections.emptyMap();
                            } else {
                                mapZzb = zzjrVarZza.zzb();
                            }
                            if (mapZzb != null) {
                                arrayList = null;
                            } else {
                                arrayList = null;
                            }
                            if (arrayList != null) {
                                zzicVarZzaE.zzaq(arrayList);
                            }
                            if (zzd().zzp(null, zzfy.zzba)) {
                                zzicVarZzaE.zzaP("");
                            }
                            str11 = zzrVar.zza;
                            zzjlVarZzs = zzB((String) Preconditions.checkNotNull(str11)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                            zzjkVar = zzjk.AD_STORAGE;
                            if (zzjlVarZzs.zzo(zzjkVar)) {
                                zzjlVarZzs = zzjlVarZzs;
                                zzjkVar = zzjkVar;
                                str12 = "_r";
                            } else {
                                zzjlVarZzs = zzjlVarZzs;
                                zzjkVar = zzjkVar;
                                str12 = "_r";
                            }
                            zzicVar2 = this.zzn;
                            zzicVar2.zzu().zzw();
                            zzicVarZzaE.zzF(Build.MODEL);
                            zzicVar2.zzu().zzw();
                            zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                            zzicVarZzaE.zzI((int) zzicVar2.zzu().zzb());
                            zzicVarZzaE.zzH(zzicVar2.zzu().zzc());
                            zzicVarZzaE.zzay(zzrVar.zzw);
                            if (zzicVar2.zzB()) {
                                zzicVarZzaE.zzK();
                                if (!TextUtils.isEmpty(null)) {
                                    zzicVarZzaE.zzam(null);
                                }
                            }
                            zzhVarZzu = zzj().zzu(str11);
                            if (zzhVarZzu == null) {
                                zzhVarZzu = new zzh(zzicVar2, str11);
                                zzhVarZzu.zze(zzK(zzjlVarZzs));
                                zzhVarZzu.zzm(zzrVar.zzk);
                                zzhVarZzu.zzg(zzrVar.zzb);
                                if (zzjlVarZzs.zzo(zzjkVar)) {
                                    zzhVarZzu.zzk(this.zzk.zzf(str11, zzrVar.zzn));
                                }
                                zzhVarZzu.zzF(0L);
                                zzhVarZzu.zzo(0L);
                                zzhVarZzu.zzq(0L);
                                zzhVarZzu.zzs(zzrVar.zzc);
                                zzhVarZzu.zzu(zzrVar.zzj);
                                zzhVarZzu.zzw(zzrVar.zzd);
                                zzhVarZzu.zzy(zzrVar.zze);
                                zzhVarZzu.zzA(zzrVar.zzf);
                                zzhVarZzu.zzE(zzrVar.zzh);
                                zzhVarZzu.zzC(zzrVar.zzq);
                                i = 0;
                                zzj().zzv(zzhVarZzu, false, false);
                            } else {
                                i = 0;
                            }
                            if (zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                                zzicVarZzaE.zzW((String) Preconditions.checkNotNull(zzhVarZzu.zzd()));
                            }
                            if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                            }
                            listZzn = zzj().zzn(str11);
                            while (i2 < listZzn.size()) {
                                com.google.android.gms.internal.measurement.zzit zzitVarZzm7 = com.google.android.gms.internal.measurement.zziu.zzm();
                                zzitVarZzm7.zzb(((zzpn) listZzn.get(i2)).zzc);
                                zzitVarZzm7.zza(((zzpn) listZzn.get(i2)).zzd);
                                zzp().zzc(zzitVarZzm7, ((zzpn) listZzn.get(i2)).zze);
                                zzicVarZzaE.zzp(zzitVarZzm7);
                                if (!"_sid".equals(((zzpn) listZzn.get(i2)).zzc)) {
                                }
                            }
                            zzavVarZzj3 = zzj();
                            com.google.android.gms.internal.measurement.zzid zzidVar7 = (com.google.android.gms.internal.measurement.zzid) zzicVarZzaE.zzbc();
                            zzavVarZzj3.zzg();
                            zzavVarZzj3.zzaw();
                            Preconditions.checkNotNull(zzidVar7);
                            Preconditions.checkNotEmpty(zzidVar7.zzA());
                            byte[] bArrZzcc13 = zzidVar7.zzcc();
                            long jZzt7 = zzavVarZzj3.zzg.zzp().zzt(bArrZzcc13);
                            ContentValues contentValues8 = new ContentValues();
                            String str21114 = str14;
                            contentValues8.put(str21114, zzidVar7.zzA());
                            contentValues8.put("metadata_fingerprint", Long.valueOf(jZzt7));
                            contentValues8.put("metadata", bArrZzcc13);
                            zzavVarZzj3.zze().insertWithOnConflict("raw_events_metadata", null, contentValues8, 4);
                            zzavVarZzj4 = zzj();
                            zzbdVar2 = new zzbd(zzbbVar.zzf);
                            while (true) {
                                if (zzbdVar2.hasNext()) {
                                    zzht zzhtVarZzh8 = zzh();
                                    String str21115 = zzbbVar.zza;
                                    zZzk = zzhtVarZzh8.zzk(str21115, zzbbVar.zzb);
                                    zzar zzarVarZzw7 = zzj().zzw(zzC(), str21115, false, false, false, false, false, false, false);
                                    if (zZzk) {
                                    }
                                    i3 = 0;
                                    break;
                                }
                                next = zzbdVar2.next();
                                String str21116 = next;
                                if (str12.equals(next)) {
                                }
                                i3 = 1;
                                break;
                            }
                            zzavVarZzj4.zzg();
                            zzavVarZzj4.zzaw();
                            Preconditions.checkNotNull(zzbbVar);
                            str13 = zzbbVar.zza;
                            Preconditions.checkNotEmpty(str13);
                            byte[] bArrZzcc14 = zzavVarZzj4.zzg.zzp().zzh(zzbbVar).zzcc();
                            contentValues = new ContentValues();
                            contentValues.put(str21114, str13);
                            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbbVar.zzb);
                            contentValues.put(ServerValues.NAME_OP_TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                            contentValues.put("metadata_fingerprint", Long.valueOf(jZzt7));
                            contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzcc14);
                            contentValues.put("realtime", Integer.valueOf(i3));
                            if (zzavVarZzj4.zze().insert(str4, null, contentValues) == -1) {
                                zzavVarZzj4.zzu.zzaV().zzb().zzb("Failed to insert raw event (got -1). appId", zzgu.zzl(str13));
                            } else {
                                this.zza = 0L;
                            }
                            zzj().zzc();
                            zzj().zzd();
                            zzaL();
                            zzaV().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                            return;
                        }
                        jMax = zzarVarZzx.zzd - ((long) Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzd().zzm(zzrVar.zza, zzfy.zzl))));
                        if (jMax > 0) {
                            bundleZzf = zzbeVar2.zzf();
                            zzpp zzppVarZzt8 = zzt();
                            String str21117 = zzbgVar2.zzc;
                            zzppVarZzt8.zzM(bundleZzf, "_o", str21117);
                            if (zzt().zzaa(str16, zzrVar.zzB)) {
                                zzt().zzM(bundleZzf, "_dbg", 1L);
                                zzt().zzM(bundleZzf, "_r", 1L);
                            }
                            if ("_s".equals(str2)) {
                                obj2 = zzpnVarZzm2.zze;
                                if (obj2 instanceof Long) {
                                    zzt().zzM(bundleZzf, "_sno", obj2);
                                }
                            }
                            if (zzd().zzp(null, zzfy.zzaX)) {
                                obj = bundleZzf.get("value");
                                if (obj instanceof String) {
                                    double d8 = Double.parseDouble((String) obj);
                                    bundleZzf.remove("value");
                                    bundleZzf.putDouble("value", d8);
                                }
                            }
                            zzavVarZzj2 = zzj();
                            Preconditions.checkNotEmpty(str16);
                            zzavVarZzj2.zzg();
                            zzavVarZzj2.zzaw();
                            str3 = r6;
                            jDelete = zzavVarZzj2.zze().delete(str3, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str16, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzavVarZzj2.zzu.zzc().zzm(str16, zzfy.zzp))))});
                            if (jDelete > 0) {
                                zzaV().zze().zzc("Data lost. Too many events stored on disk, deleted. appId", zzgu.zzl(str16), Long.valueOf(jDelete));
                            }
                            zzicVar = this.zzn;
                            str4 = str3;
                            zzbbVar = new zzbb(zzicVar, zzbgVar2.zzc, str16, zzbgVar2.zza, zzbgVar2.zzd, 0L, bundleZzf);
                            zzav zzavVarZzj12 = zzj();
                            str5 = zzbbVar.zzb;
                            zzbcVarZzf = zzavVarZzj12.zzf(str16, str5);
                            if (zzbcVarZzf != null) {
                                if (zzj().zzS(str16) >= zzd().zzh(str16)) {
                                }
                                zzbcVarZza = new zzbc(str16, str5, 0L, 0L, 0L, zzbbVar.zzd, 0L, null, null, null, null);
                            } else {
                                zzbbVar = zzbbVar.zza(zzicVar, zzbcVarZzf.zzf);
                                zzbcVarZza = zzbcVarZzf.zza(zzbbVar.zzd);
                            }
                            zzj().zzh(zzbcVarZza);
                            zzaW().zzg();
                            zzu();
                            Preconditions.checkNotNull(zzbbVar);
                            Preconditions.checkNotNull(zzrVar);
                            String str21118 = zzbbVar.zza;
                            Preconditions.checkNotEmpty(str21118);
                            str6 = zzrVar.zza;
                            Preconditions.checkArgument(str21118.equals(str6));
                            zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                            boolean z9 = true;
                            zzicVarZzaE.zza(1);
                            zzicVarZzaE.zzC("android");
                            if (!TextUtils.isEmpty(str6)) {
                                zzicVarZzaE.zzL(str6);
                            }
                            str7 = zzrVar.zzd;
                            if (!TextUtils.isEmpty(str7)) {
                                zzicVarZzaE.zzJ(str7);
                            }
                            str8 = zzrVar.zzc;
                            if (!TextUtils.isEmpty(str8)) {
                                zzicVarZzaE.zzM(str8);
                            }
                            str9 = zzrVar.zzu;
                            if (!TextUtils.isEmpty(str9)) {
                                zzicVarZzaE.zzau(str9);
                            }
                            j = zzrVar.zzj;
                            if (j != -2147483648L) {
                                zzicVarZzaE.zzaj((int) j);
                            }
                            zzicVarZzaE.zzN(zzrVar.zze);
                            str10 = zzrVar.zzb;
                            if (!TextUtils.isEmpty(str10)) {
                                zzicVarZzaE.zzad(str10);
                            }
                            zzjl zzjlVarZzs9 = zzB((String) Preconditions.checkNotNull(str6)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                            zzicVarZzaE.zzat(zzjlVarZzs9.zzk());
                            zzqp.zza();
                            if (!zzd().zzp(str6, zzfy.zzaP)) {
                            }
                            j2 = zzrVar.zzf;
                            if (j2 != 0) {
                                zzicVarZzaE.zzY(j2);
                            }
                            zzicVarZzaE.zzar(zzrVar.zzq);
                            zzpk zzpkVarZzp8 = zzp();
                            zzjrVarZza = com.google.android.gms.internal.measurement.zzjr.zza(zzpkVarZzp8.zzg.zzn.zzaY().getContentResolver(), com.google.android.gms.internal.measurement.zzkb.zza("com.google.android.gms.measurement"), zzfu.zza);
                            if (zzjrVarZza == null) {
                                mapZzb = Collections.emptyMap();
                            } else {
                                mapZzb = zzjrVarZza.zzb();
                            }
                            if (mapZzb != null) {
                                arrayList = null;
                            } else {
                                arrayList = null;
                            }
                            if (arrayList != null) {
                                zzicVarZzaE.zzaq(arrayList);
                            }
                            if (zzd().zzp(null, zzfy.zzba)) {
                                zzicVarZzaE.zzaP("");
                            }
                            str11 = zzrVar.zza;
                            zzjlVarZzs = zzB((String) Preconditions.checkNotNull(str11)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                            zzjkVar = zzjk.AD_STORAGE;
                            if (zzjlVarZzs.zzo(zzjkVar)) {
                                zzjlVarZzs = zzjlVarZzs;
                                zzjkVar = zzjkVar;
                                str12 = "_r";
                            } else {
                                zzjlVarZzs = zzjlVarZzs;
                                zzjkVar = zzjkVar;
                                str12 = "_r";
                            }
                            zzicVar2 = this.zzn;
                            zzicVar2.zzu().zzw();
                            zzicVarZzaE.zzF(Build.MODEL);
                            zzicVar2.zzu().zzw();
                            zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                            zzicVarZzaE.zzI((int) zzicVar2.zzu().zzb());
                            zzicVarZzaE.zzH(zzicVar2.zzu().zzc());
                            zzicVarZzaE.zzay(zzrVar.zzw);
                            if (zzicVar2.zzB()) {
                                zzicVarZzaE.zzK();
                                if (!TextUtils.isEmpty(null)) {
                                    zzicVarZzaE.zzam(null);
                                }
                            }
                            zzhVarZzu = zzj().zzu(str11);
                            if (zzhVarZzu == null) {
                                zzhVarZzu = new zzh(zzicVar2, str11);
                                zzhVarZzu.zze(zzK(zzjlVarZzs));
                                zzhVarZzu.zzm(zzrVar.zzk);
                                zzhVarZzu.zzg(zzrVar.zzb);
                                if (zzjlVarZzs.zzo(zzjkVar)) {
                                    zzhVarZzu.zzk(this.zzk.zzf(str11, zzrVar.zzn));
                                }
                                zzhVarZzu.zzF(0L);
                                zzhVarZzu.zzo(0L);
                                zzhVarZzu.zzq(0L);
                                zzhVarZzu.zzs(zzrVar.zzc);
                                zzhVarZzu.zzu(zzrVar.zzj);
                                zzhVarZzu.zzw(zzrVar.zzd);
                                zzhVarZzu.zzy(zzrVar.zze);
                                zzhVarZzu.zzA(zzrVar.zzf);
                                zzhVarZzu.zzE(zzrVar.zzh);
                                zzhVarZzu.zzC(zzrVar.zzq);
                                i = 0;
                                zzj().zzv(zzhVarZzu, false, false);
                            } else {
                                i = 0;
                            }
                            if (zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                                zzicVarZzaE.zzW((String) Preconditions.checkNotNull(zzhVarZzu.zzd()));
                            }
                            if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                            }
                            listZzn = zzj().zzn(str11);
                            while (i2 < listZzn.size()) {
                                com.google.android.gms.internal.measurement.zzit zzitVarZzm8 = com.google.android.gms.internal.measurement.zziu.zzm();
                                zzitVarZzm8.zzb(((zzpn) listZzn.get(i2)).zzc);
                                zzitVarZzm8.zza(((zzpn) listZzn.get(i2)).zzd);
                                zzp().zzc(zzitVarZzm8, ((zzpn) listZzn.get(i2)).zze);
                                zzicVarZzaE.zzp(zzitVarZzm8);
                                if (!"_sid".equals(((zzpn) listZzn.get(i2)).zzc)) {
                                }
                            }
                            zzavVarZzj3 = zzj();
                            com.google.android.gms.internal.measurement.zzid zzidVar8 = (com.google.android.gms.internal.measurement.zzid) zzicVarZzaE.zzbc();
                            zzavVarZzj3.zzg();
                            zzavVarZzj3.zzaw();
                            Preconditions.checkNotNull(zzidVar8);
                            Preconditions.checkNotEmpty(zzidVar8.zzA());
                            byte[] bArrZzcc15 = zzidVar8.zzcc();
                            long jZzt8 = zzavVarZzj3.zzg.zzp().zzt(bArrZzcc15);
                            ContentValues contentValues9 = new ContentValues();
                            String str21119 = str14;
                            contentValues9.put(str21119, zzidVar8.zzA());
                            contentValues9.put("metadata_fingerprint", Long.valueOf(jZzt8));
                            contentValues9.put("metadata", bArrZzcc15);
                            zzavVarZzj3.zze().insertWithOnConflict("raw_events_metadata", null, contentValues9, 4);
                            zzavVarZzj4 = zzj();
                            zzbdVar2 = new zzbd(zzbbVar.zzf);
                            while (true) {
                                if (zzbdVar2.hasNext()) {
                                    zzht zzhtVarZzh9 = zzh();
                                    String str211110 = zzbbVar.zza;
                                    zZzk = zzhtVarZzh9.zzk(str211110, zzbbVar.zzb);
                                    zzar zzarVarZzw8 = zzj().zzw(zzC(), str211110, false, false, false, false, false, false, false);
                                    if (zZzk) {
                                    }
                                    i3 = 0;
                                    break;
                                }
                                next = zzbdVar2.next();
                                String str211111 = next;
                                if (str12.equals(next)) {
                                }
                                i3 = 1;
                                break;
                            }
                            zzavVarZzj4.zzg();
                            zzavVarZzj4.zzaw();
                            Preconditions.checkNotNull(zzbbVar);
                            str13 = zzbbVar.zza;
                            Preconditions.checkNotEmpty(str13);
                            byte[] bArrZzcc16 = zzavVarZzj4.zzg.zzp().zzh(zzbbVar).zzcc();
                            contentValues = new ContentValues();
                            contentValues.put(str21119, str13);
                            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbbVar.zzb);
                            contentValues.put(ServerValues.NAME_OP_TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                            contentValues.put("metadata_fingerprint", Long.valueOf(jZzt8));
                            contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzcc16);
                            contentValues.put("realtime", Integer.valueOf(i3));
                            if (zzavVarZzj4.zze().insert(str4, null, contentValues) == -1) {
                                zzavVarZzj4.zzu.zzaV().zzb().zzb("Failed to insert raw event (got -1). appId", zzgu.zzl(str13));
                            } else {
                                this.zza = 0L;
                            }
                            zzj().zzc();
                            zzj().zzd();
                            zzaL();
                            zzaV().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                            return;
                        }
                        if (jMax == 1) {
                            zzaV().zzb().zzc("Too many error events logged. appId, count", zzgu.zzl(str16), Long.valueOf(zzarVarZzx.zzd));
                        }
                        zzj().zzc();
                    }
                } else {
                    if (z) {
                        z = true;
                        zzbeVar = zzbgVarZzb.zzb;
                        str = "_err";
                        strZzd = zzbeVar.zzd(FirebaseAnalytics.Param.CURRENCY);
                        if (z) {
                            dDoubleValue = zzbeVar.zzc("value").doubleValue() * 1000000.0d;
                            if (dDoubleValue == 0.0d) {
                                dDoubleValue = zzbeVar.zzb("value").longValue() * 1000000.0d;
                            }
                            if (dDoubleValue <= 9.223372036854776E18d) {
                            }
                            zzaV().zze().zzc("Data lost. Currency value is too big. appId", zzgu.zzl(str16), Double.valueOf(dDoubleValue));
                            zzj().zzc();
                        } else {
                            str14 = "app_id";
                            str15 = "_fx";
                            jLongValue = zzbeVar.zzb("value").longValue();
                        }
                        if (!TextUtils.isEmpty(strZzd)) {
                            upperCase = strZzd.toUpperCase(Locale.US);
                            if (upperCase.matches("[A-Z]{3}")) {
                                String.valueOf(upperCase);
                                strConcat = "_ltv_".concat(String.valueOf(upperCase));
                                zzpnVarZzm = zzj().zzm(str16, strConcat);
                                if (zzpnVarZzm == null) {
                                    zzbgVarZzb = zzbgVarZzb;
                                    zzavVarZzj = zzj();
                                    int iZzm2 = zzd().zzm(str16, zzfy.zzT) - 1;
                                    Preconditions.checkNotEmpty(str16);
                                    zzavVarZzj.zzg();
                                    zzavVarZzj.zzaw();
                                    zzavVarZzj.zze().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '!_ltv!_%' escape '!'order by set_timestamp desc limit ?,10);", new String[]{str16, str16, String.valueOf(iZzm2)});
                                    zzpnVar = new zzpn(str16, zzbgVarZzb.zzc, strConcat, zzaZ().currentTimeMillis(), Long.valueOf(jLongValue));
                                    zzpnVar2 = zzpnVar;
                                    if (!zzj().zzl(zzpnVar2)) {
                                        zzaV().zzb().zzd("Too many unique user properties are set. Ignoring user property. appId", zzgu.zzl(str16), this.zzn.zzl().zzc(zzpnVar2.zzc), zzpnVar2.zze);
                                        zzt().zzN(this.zzK, str16, 9, null, null, 0);
                                    }
                                    str2 = zzbgVarZzb.zza;
                                    zZzh = zzpp.zzh(str2);
                                    zEquals = str.equals(str2);
                                    zzt();
                                    zzbeVar2 = zzbgVarZzb.zzb;
                                    if (zzbeVar2 == null) {
                                        length = 0;
                                    } else {
                                        zzbdVar = new zzbd(zzbeVar2);
                                        length = 0;
                                        while (zzbdVar.hasNext()) {
                                            String next4 = zzbdVar.next();
                                            String str221 = next4;
                                            objZza = zzbeVar2.zza(next4);
                                            if (objZza instanceof Parcelable[]) {
                                                length += (long) ((Parcelable[]) objZza).length;
                                            }
                                        }
                                    }
                                    zzbgVar2 = zzbgVarZzb;
                                    zzarVarZzx = zzj().zzx(zzC(), str16, length + 1, true, zZzh, false, zEquals, false, false, false);
                                    long j8 = zzarVarZzx.zzb;
                                    zzd();
                                    jZzH = j8 - zzal.zzH();
                                    if (jZzH > 0) {
                                        if (jZzH % 1000 == 1) {
                                            zzaV().zzb().zzc("Data loss. Too many events logged. appId, count", zzgu.zzl(str16), Long.valueOf(zzarVarZzx.zzb));
                                        }
                                        zzj().zzc();
                                    } else if (zZzh) {
                                        long j9 = zzarVarZzx.zza;
                                        zzd();
                                        jIntValue = j9 - ((long) ((Integer) zzfy.zzm.zzb(null)).intValue());
                                        if (jIntValue > 0) {
                                            if (jIntValue % 1000 == 1) {
                                                zzaV().zzb().zzc("Data loss. Too many public events logged. appId, count", zzgu.zzl(str16), Long.valueOf(zzarVarZzx.zza));
                                            }
                                            zzt().zzN(this.zzK, str16, 16, "_ev", zzbgVar2.zza, 0);
                                            zzj().zzc();
                                        } else {
                                            if (zEquals) {
                                                bundleZzf = zzbeVar2.zzf();
                                                zzpp zzppVarZzt9 = zzt();
                                                String str211112 = zzbgVar2.zzc;
                                                zzppVarZzt9.zzM(bundleZzf, "_o", str211112);
                                                if (zzt().zzaa(str16, zzrVar.zzB)) {
                                                    zzt().zzM(bundleZzf, "_dbg", 1L);
                                                    zzt().zzM(bundleZzf, "_r", 1L);
                                                }
                                                if ("_s".equals(str2)) {
                                                    obj2 = zzpnVarZzm2.zze;
                                                    if (obj2 instanceof Long) {
                                                        zzt().zzM(bundleZzf, "_sno", obj2);
                                                    }
                                                }
                                                if (zzd().zzp(null, zzfy.zzaX)) {
                                                    obj = bundleZzf.get("value");
                                                    if (obj instanceof String) {
                                                        double d9 = Double.parseDouble((String) obj);
                                                        bundleZzf.remove("value");
                                                        bundleZzf.putDouble("value", d9);
                                                    }
                                                }
                                                zzavVarZzj2 = zzj();
                                                Preconditions.checkNotEmpty(str16);
                                                zzavVarZzj2.zzg();
                                                zzavVarZzj2.zzaw();
                                                str3 = r6;
                                                jDelete = zzavVarZzj2.zze().delete(str3, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str16, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzavVarZzj2.zzu.zzc().zzm(str16, zzfy.zzp))))});
                                                if (jDelete > 0) {
                                                    zzaV().zze().zzc("Data lost. Too many events stored on disk, deleted. appId", zzgu.zzl(str16), Long.valueOf(jDelete));
                                                }
                                                zzicVar = this.zzn;
                                                str4 = str3;
                                                zzbbVar = new zzbb(zzicVar, zzbgVar2.zzc, str16, zzbgVar2.zza, zzbgVar2.zzd, 0L, bundleZzf);
                                                zzav zzavVarZzj13 = zzj();
                                                str5 = zzbbVar.zzb;
                                                zzbcVarZzf = zzavVarZzj13.zzf(str16, str5);
                                                if (zzbcVarZzf != null) {
                                                    if (zzj().zzS(str16) >= zzd().zzh(str16)) {
                                                    }
                                                    zzbcVarZza = new zzbc(str16, str5, 0L, 0L, 0L, zzbbVar.zzd, 0L, null, null, null, null);
                                                } else {
                                                    zzbbVar = zzbbVar.zza(zzicVar, zzbcVarZzf.zzf);
                                                    zzbcVarZza = zzbcVarZzf.zza(zzbbVar.zzd);
                                                }
                                                zzj().zzh(zzbcVarZza);
                                                zzaW().zzg();
                                                zzu();
                                                Preconditions.checkNotNull(zzbbVar);
                                                Preconditions.checkNotNull(zzrVar);
                                                String str211113 = zzbbVar.zza;
                                                Preconditions.checkNotEmpty(str211113);
                                                str6 = zzrVar.zza;
                                                Preconditions.checkArgument(str211113.equals(str6));
                                                zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                                                boolean z10 = true;
                                                zzicVarZzaE.zza(1);
                                                zzicVarZzaE.zzC("android");
                                                if (!TextUtils.isEmpty(str6)) {
                                                    zzicVarZzaE.zzL(str6);
                                                }
                                                str7 = zzrVar.zzd;
                                                if (!TextUtils.isEmpty(str7)) {
                                                    zzicVarZzaE.zzJ(str7);
                                                }
                                                str8 = zzrVar.zzc;
                                                if (!TextUtils.isEmpty(str8)) {
                                                    zzicVarZzaE.zzM(str8);
                                                }
                                                str9 = zzrVar.zzu;
                                                if (!TextUtils.isEmpty(str9)) {
                                                    zzicVarZzaE.zzau(str9);
                                                }
                                                j = zzrVar.zzj;
                                                if (j != -2147483648L) {
                                                    zzicVarZzaE.zzaj((int) j);
                                                }
                                                zzicVarZzaE.zzN(zzrVar.zze);
                                                str10 = zzrVar.zzb;
                                                if (!TextUtils.isEmpty(str10)) {
                                                    zzicVarZzaE.zzad(str10);
                                                }
                                                zzjl zzjlVarZzs10 = zzB((String) Preconditions.checkNotNull(str6)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                                zzicVarZzaE.zzat(zzjlVarZzs10.zzk());
                                                zzqp.zza();
                                                if (!zzd().zzp(str6, zzfy.zzaP)) {
                                                }
                                                j2 = zzrVar.zzf;
                                                if (j2 != 0) {
                                                    zzicVarZzaE.zzY(j2);
                                                }
                                                zzicVarZzaE.zzar(zzrVar.zzq);
                                                zzpk zzpkVarZzp9 = zzp();
                                                zzjrVarZza = com.google.android.gms.internal.measurement.zzjr.zza(zzpkVarZzp9.zzg.zzn.zzaY().getContentResolver(), com.google.android.gms.internal.measurement.zzkb.zza("com.google.android.gms.measurement"), zzfu.zza);
                                                if (zzjrVarZza == null) {
                                                    mapZzb = Collections.emptyMap();
                                                } else {
                                                    mapZzb = zzjrVarZza.zzb();
                                                }
                                                if (mapZzb != null) {
                                                    arrayList = null;
                                                } else {
                                                    arrayList = null;
                                                }
                                                if (arrayList != null) {
                                                    zzicVarZzaE.zzaq(arrayList);
                                                }
                                                if (zzd().zzp(null, zzfy.zzba)) {
                                                    zzicVarZzaE.zzaP("");
                                                }
                                                str11 = zzrVar.zza;
                                                zzjlVarZzs = zzB((String) Preconditions.checkNotNull(str11)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                                zzjkVar = zzjk.AD_STORAGE;
                                                if (zzjlVarZzs.zzo(zzjkVar)) {
                                                    zzjlVarZzs = zzjlVarZzs;
                                                    zzjkVar = zzjkVar;
                                                    str12 = "_r";
                                                } else {
                                                    zzjlVarZzs = zzjlVarZzs;
                                                    zzjkVar = zzjkVar;
                                                    str12 = "_r";
                                                }
                                                zzicVar2 = this.zzn;
                                                zzicVar2.zzu().zzw();
                                                zzicVarZzaE.zzF(Build.MODEL);
                                                zzicVar2.zzu().zzw();
                                                zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                                                zzicVarZzaE.zzI((int) zzicVar2.zzu().zzb());
                                                zzicVarZzaE.zzH(zzicVar2.zzu().zzc());
                                                zzicVarZzaE.zzay(zzrVar.zzw);
                                                if (zzicVar2.zzB()) {
                                                    zzicVarZzaE.zzK();
                                                    if (!TextUtils.isEmpty(null)) {
                                                        zzicVarZzaE.zzam(null);
                                                    }
                                                }
                                                zzhVarZzu = zzj().zzu(str11);
                                                if (zzhVarZzu == null) {
                                                    zzhVarZzu = new zzh(zzicVar2, str11);
                                                    zzhVarZzu.zze(zzK(zzjlVarZzs));
                                                    zzhVarZzu.zzm(zzrVar.zzk);
                                                    zzhVarZzu.zzg(zzrVar.zzb);
                                                    if (zzjlVarZzs.zzo(zzjkVar)) {
                                                        zzhVarZzu.zzk(this.zzk.zzf(str11, zzrVar.zzn));
                                                    }
                                                    zzhVarZzu.zzF(0L);
                                                    zzhVarZzu.zzo(0L);
                                                    zzhVarZzu.zzq(0L);
                                                    zzhVarZzu.zzs(zzrVar.zzc);
                                                    zzhVarZzu.zzu(zzrVar.zzj);
                                                    zzhVarZzu.zzw(zzrVar.zzd);
                                                    zzhVarZzu.zzy(zzrVar.zze);
                                                    zzhVarZzu.zzA(zzrVar.zzf);
                                                    zzhVarZzu.zzE(zzrVar.zzh);
                                                    zzhVarZzu.zzC(zzrVar.zzq);
                                                    i = 0;
                                                    zzj().zzv(zzhVarZzu, false, false);
                                                } else {
                                                    i = 0;
                                                }
                                                if (zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                                                    zzicVarZzaE.zzW((String) Preconditions.checkNotNull(zzhVarZzu.zzd()));
                                                }
                                                if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                                    zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                                                }
                                                listZzn = zzj().zzn(str11);
                                                while (i2 < listZzn.size()) {
                                                    com.google.android.gms.internal.measurement.zzit zzitVarZzm9 = com.google.android.gms.internal.measurement.zziu.zzm();
                                                    zzitVarZzm9.zzb(((zzpn) listZzn.get(i2)).zzc);
                                                    zzitVarZzm9.zza(((zzpn) listZzn.get(i2)).zzd);
                                                    zzp().zzc(zzitVarZzm9, ((zzpn) listZzn.get(i2)).zze);
                                                    zzicVarZzaE.zzp(zzitVarZzm9);
                                                    if (!"_sid".equals(((zzpn) listZzn.get(i2)).zzc)) {
                                                    }
                                                }
                                                zzavVarZzj3 = zzj();
                                                com.google.android.gms.internal.measurement.zzid zzidVar9 = (com.google.android.gms.internal.measurement.zzid) zzicVarZzaE.zzbc();
                                                zzavVarZzj3.zzg();
                                                zzavVarZzj3.zzaw();
                                                Preconditions.checkNotNull(zzidVar9);
                                                Preconditions.checkNotEmpty(zzidVar9.zzA());
                                                byte[] bArrZzcc17 = zzidVar9.zzcc();
                                                long jZzt9 = zzavVarZzj3.zzg.zzp().zzt(bArrZzcc17);
                                                ContentValues contentValues10 = new ContentValues();
                                                String str211114 = str14;
                                                contentValues10.put(str211114, zzidVar9.zzA());
                                                contentValues10.put("metadata_fingerprint", Long.valueOf(jZzt9));
                                                contentValues10.put("metadata", bArrZzcc17);
                                                zzavVarZzj3.zze().insertWithOnConflict("raw_events_metadata", null, contentValues10, 4);
                                                zzavVarZzj4 = zzj();
                                                zzbdVar2 = new zzbd(zzbbVar.zzf);
                                                while (true) {
                                                    if (zzbdVar2.hasNext()) {
                                                        zzht zzhtVarZzh10 = zzh();
                                                        String str211115 = zzbbVar.zza;
                                                        zZzk = zzhtVarZzh10.zzk(str211115, zzbbVar.zzb);
                                                        zzar zzarVarZzw9 = zzj().zzw(zzC(), str211115, false, false, false, false, false, false, false);
                                                        if (zZzk) {
                                                        }
                                                        i3 = 0;
                                                        break;
                                                    }
                                                    next = zzbdVar2.next();
                                                    String str211116 = next;
                                                    if (str12.equals(next)) {
                                                    }
                                                    i3 = 1;
                                                    break;
                                                }
                                                zzavVarZzj4.zzg();
                                                zzavVarZzj4.zzaw();
                                                Preconditions.checkNotNull(zzbbVar);
                                                str13 = zzbbVar.zza;
                                                Preconditions.checkNotEmpty(str13);
                                                byte[] bArrZzcc18 = zzavVarZzj4.zzg.zzp().zzh(zzbbVar).zzcc();
                                                contentValues = new ContentValues();
                                                contentValues.put(str211114, str13);
                                                contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbbVar.zzb);
                                                contentValues.put(ServerValues.NAME_OP_TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                                                contentValues.put("metadata_fingerprint", Long.valueOf(jZzt9));
                                                contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzcc18);
                                                contentValues.put("realtime", Integer.valueOf(i3));
                                                if (zzavVarZzj4.zze().insert(str4, null, contentValues) == -1) {
                                                    zzavVarZzj4.zzu.zzaV().zzb().zzb("Failed to insert raw event (got -1). appId", zzgu.zzl(str13));
                                                } else {
                                                    this.zza = 0L;
                                                }
                                                zzj().zzc();
                                                zzj().zzd();
                                                zzaL();
                                                zzaV().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                                return;
                                            }
                                            jMax = zzarVarZzx.zzd - ((long) Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzd().zzm(zzrVar.zza, zzfy.zzl))));
                                            if (jMax > 0) {
                                                bundleZzf = zzbeVar2.zzf();
                                                zzpp zzppVarZzt10 = zzt();
                                                String str211117 = zzbgVar2.zzc;
                                                zzppVarZzt10.zzM(bundleZzf, "_o", str211117);
                                                if (zzt().zzaa(str16, zzrVar.zzB)) {
                                                    zzt().zzM(bundleZzf, "_dbg", 1L);
                                                    zzt().zzM(bundleZzf, "_r", 1L);
                                                }
                                                if ("_s".equals(str2)) {
                                                    obj2 = zzpnVarZzm2.zze;
                                                    if (obj2 instanceof Long) {
                                                        zzt().zzM(bundleZzf, "_sno", obj2);
                                                    }
                                                }
                                                if (zzd().zzp(null, zzfy.zzaX)) {
                                                    obj = bundleZzf.get("value");
                                                    if (obj instanceof String) {
                                                        double d10 = Double.parseDouble((String) obj);
                                                        bundleZzf.remove("value");
                                                        bundleZzf.putDouble("value", d10);
                                                    }
                                                }
                                                zzavVarZzj2 = zzj();
                                                Preconditions.checkNotEmpty(str16);
                                                zzavVarZzj2.zzg();
                                                zzavVarZzj2.zzaw();
                                                str3 = r6;
                                                jDelete = zzavVarZzj2.zze().delete(str3, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str16, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzavVarZzj2.zzu.zzc().zzm(str16, zzfy.zzp))))});
                                                if (jDelete > 0) {
                                                    zzaV().zze().zzc("Data lost. Too many events stored on disk, deleted. appId", zzgu.zzl(str16), Long.valueOf(jDelete));
                                                }
                                                zzicVar = this.zzn;
                                                str4 = str3;
                                                zzbbVar = new zzbb(zzicVar, zzbgVar2.zzc, str16, zzbgVar2.zza, zzbgVar2.zzd, 0L, bundleZzf);
                                                zzav zzavVarZzj14 = zzj();
                                                str5 = zzbbVar.zzb;
                                                zzbcVarZzf = zzavVarZzj14.zzf(str16, str5);
                                                if (zzbcVarZzf != null) {
                                                    if (zzj().zzS(str16) >= zzd().zzh(str16)) {
                                                    }
                                                    zzbcVarZza = new zzbc(str16, str5, 0L, 0L, 0L, zzbbVar.zzd, 0L, null, null, null, null);
                                                } else {
                                                    zzbbVar = zzbbVar.zza(zzicVar, zzbcVarZzf.zzf);
                                                    zzbcVarZza = zzbcVarZzf.zza(zzbbVar.zzd);
                                                }
                                                zzj().zzh(zzbcVarZza);
                                                zzaW().zzg();
                                                zzu();
                                                Preconditions.checkNotNull(zzbbVar);
                                                Preconditions.checkNotNull(zzrVar);
                                                String str211118 = zzbbVar.zza;
                                                Preconditions.checkNotEmpty(str211118);
                                                str6 = zzrVar.zza;
                                                Preconditions.checkArgument(str211118.equals(str6));
                                                zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                                                boolean z11 = true;
                                                zzicVarZzaE.zza(1);
                                                zzicVarZzaE.zzC("android");
                                                if (!TextUtils.isEmpty(str6)) {
                                                    zzicVarZzaE.zzL(str6);
                                                }
                                                str7 = zzrVar.zzd;
                                                if (!TextUtils.isEmpty(str7)) {
                                                    zzicVarZzaE.zzJ(str7);
                                                }
                                                str8 = zzrVar.zzc;
                                                if (!TextUtils.isEmpty(str8)) {
                                                    zzicVarZzaE.zzM(str8);
                                                }
                                                str9 = zzrVar.zzu;
                                                if (!TextUtils.isEmpty(str9)) {
                                                    zzicVarZzaE.zzau(str9);
                                                }
                                                j = zzrVar.zzj;
                                                if (j != -2147483648L) {
                                                    zzicVarZzaE.zzaj((int) j);
                                                }
                                                zzicVarZzaE.zzN(zzrVar.zze);
                                                str10 = zzrVar.zzb;
                                                if (!TextUtils.isEmpty(str10)) {
                                                    zzicVarZzaE.zzad(str10);
                                                }
                                                zzjl zzjlVarZzs11 = zzB((String) Preconditions.checkNotNull(str6)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                                zzicVarZzaE.zzat(zzjlVarZzs11.zzk());
                                                zzqp.zza();
                                                if (!zzd().zzp(str6, zzfy.zzaP)) {
                                                }
                                                j2 = zzrVar.zzf;
                                                if (j2 != 0) {
                                                    zzicVarZzaE.zzY(j2);
                                                }
                                                zzicVarZzaE.zzar(zzrVar.zzq);
                                                zzpk zzpkVarZzp10 = zzp();
                                                zzjrVarZza = com.google.android.gms.internal.measurement.zzjr.zza(zzpkVarZzp10.zzg.zzn.zzaY().getContentResolver(), com.google.android.gms.internal.measurement.zzkb.zza("com.google.android.gms.measurement"), zzfu.zza);
                                                if (zzjrVarZza == null) {
                                                    mapZzb = Collections.emptyMap();
                                                } else {
                                                    mapZzb = zzjrVarZza.zzb();
                                                }
                                                if (mapZzb != null) {
                                                    arrayList = null;
                                                } else {
                                                    arrayList = null;
                                                }
                                                if (arrayList != null) {
                                                    zzicVarZzaE.zzaq(arrayList);
                                                }
                                                if (zzd().zzp(null, zzfy.zzba)) {
                                                    zzicVarZzaE.zzaP("");
                                                }
                                                str11 = zzrVar.zza;
                                                zzjlVarZzs = zzB((String) Preconditions.checkNotNull(str11)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                                zzjkVar = zzjk.AD_STORAGE;
                                                if (zzjlVarZzs.zzo(zzjkVar)) {
                                                    zzjlVarZzs = zzjlVarZzs;
                                                    zzjkVar = zzjkVar;
                                                    str12 = "_r";
                                                } else {
                                                    zzjlVarZzs = zzjlVarZzs;
                                                    zzjkVar = zzjkVar;
                                                    str12 = "_r";
                                                }
                                                zzicVar2 = this.zzn;
                                                zzicVar2.zzu().zzw();
                                                zzicVarZzaE.zzF(Build.MODEL);
                                                zzicVar2.zzu().zzw();
                                                zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                                                zzicVarZzaE.zzI((int) zzicVar2.zzu().zzb());
                                                zzicVarZzaE.zzH(zzicVar2.zzu().zzc());
                                                zzicVarZzaE.zzay(zzrVar.zzw);
                                                if (zzicVar2.zzB()) {
                                                    zzicVarZzaE.zzK();
                                                    if (!TextUtils.isEmpty(null)) {
                                                        zzicVarZzaE.zzam(null);
                                                    }
                                                }
                                                zzhVarZzu = zzj().zzu(str11);
                                                if (zzhVarZzu == null) {
                                                    zzhVarZzu = new zzh(zzicVar2, str11);
                                                    zzhVarZzu.zze(zzK(zzjlVarZzs));
                                                    zzhVarZzu.zzm(zzrVar.zzk);
                                                    zzhVarZzu.zzg(zzrVar.zzb);
                                                    if (zzjlVarZzs.zzo(zzjkVar)) {
                                                        zzhVarZzu.zzk(this.zzk.zzf(str11, zzrVar.zzn));
                                                    }
                                                    zzhVarZzu.zzF(0L);
                                                    zzhVarZzu.zzo(0L);
                                                    zzhVarZzu.zzq(0L);
                                                    zzhVarZzu.zzs(zzrVar.zzc);
                                                    zzhVarZzu.zzu(zzrVar.zzj);
                                                    zzhVarZzu.zzw(zzrVar.zzd);
                                                    zzhVarZzu.zzy(zzrVar.zze);
                                                    zzhVarZzu.zzA(zzrVar.zzf);
                                                    zzhVarZzu.zzE(zzrVar.zzh);
                                                    zzhVarZzu.zzC(zzrVar.zzq);
                                                    i = 0;
                                                    zzj().zzv(zzhVarZzu, false, false);
                                                } else {
                                                    i = 0;
                                                }
                                                if (zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                                                    zzicVarZzaE.zzW((String) Preconditions.checkNotNull(zzhVarZzu.zzd()));
                                                }
                                                if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                                    zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                                                }
                                                listZzn = zzj().zzn(str11);
                                                while (i2 < listZzn.size()) {
                                                    com.google.android.gms.internal.measurement.zzit zzitVarZzm10 = com.google.android.gms.internal.measurement.zziu.zzm();
                                                    zzitVarZzm10.zzb(((zzpn) listZzn.get(i2)).zzc);
                                                    zzitVarZzm10.zza(((zzpn) listZzn.get(i2)).zzd);
                                                    zzp().zzc(zzitVarZzm10, ((zzpn) listZzn.get(i2)).zze);
                                                    zzicVarZzaE.zzp(zzitVarZzm10);
                                                    if (!"_sid".equals(((zzpn) listZzn.get(i2)).zzc)) {
                                                    }
                                                }
                                                zzavVarZzj3 = zzj();
                                                com.google.android.gms.internal.measurement.zzid zzidVar10 = (com.google.android.gms.internal.measurement.zzid) zzicVarZzaE.zzbc();
                                                zzavVarZzj3.zzg();
                                                zzavVarZzj3.zzaw();
                                                Preconditions.checkNotNull(zzidVar10);
                                                Preconditions.checkNotEmpty(zzidVar10.zzA());
                                                byte[] bArrZzcc19 = zzidVar10.zzcc();
                                                long jZzt10 = zzavVarZzj3.zzg.zzp().zzt(bArrZzcc19);
                                                ContentValues contentValues11 = new ContentValues();
                                                String str211119 = str14;
                                                contentValues11.put(str211119, zzidVar10.zzA());
                                                contentValues11.put("metadata_fingerprint", Long.valueOf(jZzt10));
                                                contentValues11.put("metadata", bArrZzcc19);
                                                zzavVarZzj3.zze().insertWithOnConflict("raw_events_metadata", null, contentValues11, 4);
                                                zzavVarZzj4 = zzj();
                                                zzbdVar2 = new zzbd(zzbbVar.zzf);
                                                while (true) {
                                                    if (zzbdVar2.hasNext()) {
                                                        zzht zzhtVarZzh11 = zzh();
                                                        String str2111110 = zzbbVar.zza;
                                                        zZzk = zzhtVarZzh11.zzk(str2111110, zzbbVar.zzb);
                                                        zzar zzarVarZzw10 = zzj().zzw(zzC(), str2111110, false, false, false, false, false, false, false);
                                                        if (zZzk) {
                                                        }
                                                        i3 = 0;
                                                        break;
                                                    }
                                                    next = zzbdVar2.next();
                                                    String str2111111 = next;
                                                    if (str12.equals(next)) {
                                                    }
                                                    i3 = 1;
                                                    break;
                                                }
                                                zzavVarZzj4.zzg();
                                                zzavVarZzj4.zzaw();
                                                Preconditions.checkNotNull(zzbbVar);
                                                str13 = zzbbVar.zza;
                                                Preconditions.checkNotEmpty(str13);
                                                byte[] bArrZzcc110 = zzavVarZzj4.zzg.zzp().zzh(zzbbVar).zzcc();
                                                contentValues = new ContentValues();
                                                contentValues.put(str211119, str13);
                                                contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbbVar.zzb);
                                                contentValues.put(ServerValues.NAME_OP_TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                                                contentValues.put("metadata_fingerprint", Long.valueOf(jZzt10));
                                                contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzcc110);
                                                contentValues.put("realtime", Integer.valueOf(i3));
                                                if (zzavVarZzj4.zze().insert(str4, null, contentValues) == -1) {
                                                    zzavVarZzj4.zzu.zzaV().zzb().zzb("Failed to insert raw event (got -1). appId", zzgu.zzl(str13));
                                                } else {
                                                    this.zza = 0L;
                                                }
                                                zzj().zzc();
                                                zzj().zzd();
                                                zzaL();
                                                zzaV().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                                return;
                                            }
                                            if (jMax == 1) {
                                                zzaV().zzb().zzc("Too many error events logged. appId, count", zzgu.zzl(str16), Long.valueOf(zzarVarZzx.zzd));
                                            }
                                            zzj().zzc();
                                        }
                                    } else {
                                        if (zEquals) {
                                            bundleZzf = zzbeVar2.zzf();
                                            zzpp zzppVarZzt11 = zzt();
                                            String str2111112 = zzbgVar2.zzc;
                                            zzppVarZzt11.zzM(bundleZzf, "_o", str2111112);
                                            if (zzt().zzaa(str16, zzrVar.zzB)) {
                                                zzt().zzM(bundleZzf, "_dbg", 1L);
                                                zzt().zzM(bundleZzf, "_r", 1L);
                                            }
                                            if ("_s".equals(str2)) {
                                                obj2 = zzpnVarZzm2.zze;
                                                if (obj2 instanceof Long) {
                                                    zzt().zzM(bundleZzf, "_sno", obj2);
                                                }
                                            }
                                            if (zzd().zzp(null, zzfy.zzaX)) {
                                                obj = bundleZzf.get("value");
                                                if (obj instanceof String) {
                                                    double d11 = Double.parseDouble((String) obj);
                                                    bundleZzf.remove("value");
                                                    bundleZzf.putDouble("value", d11);
                                                }
                                            }
                                            zzavVarZzj2 = zzj();
                                            Preconditions.checkNotEmpty(str16);
                                            zzavVarZzj2.zzg();
                                            zzavVarZzj2.zzaw();
                                            str3 = r6;
                                            jDelete = zzavVarZzj2.zze().delete(str3, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str16, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzavVarZzj2.zzu.zzc().zzm(str16, zzfy.zzp))))});
                                            if (jDelete > 0) {
                                                zzaV().zze().zzc("Data lost. Too many events stored on disk, deleted. appId", zzgu.zzl(str16), Long.valueOf(jDelete));
                                            }
                                            zzicVar = this.zzn;
                                            str4 = str3;
                                            zzbbVar = new zzbb(zzicVar, zzbgVar2.zzc, str16, zzbgVar2.zza, zzbgVar2.zzd, 0L, bundleZzf);
                                            zzav zzavVarZzj15 = zzj();
                                            str5 = zzbbVar.zzb;
                                            zzbcVarZzf = zzavVarZzj15.zzf(str16, str5);
                                            if (zzbcVarZzf != null) {
                                                if (zzj().zzS(str16) >= zzd().zzh(str16)) {
                                                }
                                                zzbcVarZza = new zzbc(str16, str5, 0L, 0L, 0L, zzbbVar.zzd, 0L, null, null, null, null);
                                            } else {
                                                zzbbVar = zzbbVar.zza(zzicVar, zzbcVarZzf.zzf);
                                                zzbcVarZza = zzbcVarZzf.zza(zzbbVar.zzd);
                                            }
                                            zzj().zzh(zzbcVarZza);
                                            zzaW().zzg();
                                            zzu();
                                            Preconditions.checkNotNull(zzbbVar);
                                            Preconditions.checkNotNull(zzrVar);
                                            String str2111113 = zzbbVar.zza;
                                            Preconditions.checkNotEmpty(str2111113);
                                            str6 = zzrVar.zza;
                                            Preconditions.checkArgument(str2111113.equals(str6));
                                            zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                                            boolean z12 = true;
                                            zzicVarZzaE.zza(1);
                                            zzicVarZzaE.zzC("android");
                                            if (!TextUtils.isEmpty(str6)) {
                                                zzicVarZzaE.zzL(str6);
                                            }
                                            str7 = zzrVar.zzd;
                                            if (!TextUtils.isEmpty(str7)) {
                                                zzicVarZzaE.zzJ(str7);
                                            }
                                            str8 = zzrVar.zzc;
                                            if (!TextUtils.isEmpty(str8)) {
                                                zzicVarZzaE.zzM(str8);
                                            }
                                            str9 = zzrVar.zzu;
                                            if (!TextUtils.isEmpty(str9)) {
                                                zzicVarZzaE.zzau(str9);
                                            }
                                            j = zzrVar.zzj;
                                            if (j != -2147483648L) {
                                                zzicVarZzaE.zzaj((int) j);
                                            }
                                            zzicVarZzaE.zzN(zzrVar.zze);
                                            str10 = zzrVar.zzb;
                                            if (!TextUtils.isEmpty(str10)) {
                                                zzicVarZzaE.zzad(str10);
                                            }
                                            zzjl zzjlVarZzs12 = zzB((String) Preconditions.checkNotNull(str6)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                            zzicVarZzaE.zzat(zzjlVarZzs12.zzk());
                                            zzqp.zza();
                                            if (!zzd().zzp(str6, zzfy.zzaP)) {
                                            }
                                            j2 = zzrVar.zzf;
                                            if (j2 != 0) {
                                                zzicVarZzaE.zzY(j2);
                                            }
                                            zzicVarZzaE.zzar(zzrVar.zzq);
                                            zzpk zzpkVarZzp11 = zzp();
                                            zzjrVarZza = com.google.android.gms.internal.measurement.zzjr.zza(zzpkVarZzp11.zzg.zzn.zzaY().getContentResolver(), com.google.android.gms.internal.measurement.zzkb.zza("com.google.android.gms.measurement"), zzfu.zza);
                                            if (zzjrVarZza == null) {
                                                mapZzb = Collections.emptyMap();
                                            } else {
                                                mapZzb = zzjrVarZza.zzb();
                                            }
                                            if (mapZzb != null) {
                                                arrayList = null;
                                            } else {
                                                arrayList = null;
                                            }
                                            if (arrayList != null) {
                                                zzicVarZzaE.zzaq(arrayList);
                                            }
                                            if (zzd().zzp(null, zzfy.zzba)) {
                                                zzicVarZzaE.zzaP("");
                                            }
                                            str11 = zzrVar.zza;
                                            zzjlVarZzs = zzB((String) Preconditions.checkNotNull(str11)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                            zzjkVar = zzjk.AD_STORAGE;
                                            if (zzjlVarZzs.zzo(zzjkVar)) {
                                                zzjlVarZzs = zzjlVarZzs;
                                                zzjkVar = zzjkVar;
                                                str12 = "_r";
                                            } else {
                                                zzjlVarZzs = zzjlVarZzs;
                                                zzjkVar = zzjkVar;
                                                str12 = "_r";
                                            }
                                            zzicVar2 = this.zzn;
                                            zzicVar2.zzu().zzw();
                                            zzicVarZzaE.zzF(Build.MODEL);
                                            zzicVar2.zzu().zzw();
                                            zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                                            zzicVarZzaE.zzI((int) zzicVar2.zzu().zzb());
                                            zzicVarZzaE.zzH(zzicVar2.zzu().zzc());
                                            zzicVarZzaE.zzay(zzrVar.zzw);
                                            if (zzicVar2.zzB()) {
                                                zzicVarZzaE.zzK();
                                                if (!TextUtils.isEmpty(null)) {
                                                    zzicVarZzaE.zzam(null);
                                                }
                                            }
                                            zzhVarZzu = zzj().zzu(str11);
                                            if (zzhVarZzu == null) {
                                                zzhVarZzu = new zzh(zzicVar2, str11);
                                                zzhVarZzu.zze(zzK(zzjlVarZzs));
                                                zzhVarZzu.zzm(zzrVar.zzk);
                                                zzhVarZzu.zzg(zzrVar.zzb);
                                                if (zzjlVarZzs.zzo(zzjkVar)) {
                                                    zzhVarZzu.zzk(this.zzk.zzf(str11, zzrVar.zzn));
                                                }
                                                zzhVarZzu.zzF(0L);
                                                zzhVarZzu.zzo(0L);
                                                zzhVarZzu.zzq(0L);
                                                zzhVarZzu.zzs(zzrVar.zzc);
                                                zzhVarZzu.zzu(zzrVar.zzj);
                                                zzhVarZzu.zzw(zzrVar.zzd);
                                                zzhVarZzu.zzy(zzrVar.zze);
                                                zzhVarZzu.zzA(zzrVar.zzf);
                                                zzhVarZzu.zzE(zzrVar.zzh);
                                                zzhVarZzu.zzC(zzrVar.zzq);
                                                i = 0;
                                                zzj().zzv(zzhVarZzu, false, false);
                                            } else {
                                                i = 0;
                                            }
                                            if (zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                                                zzicVarZzaE.zzW((String) Preconditions.checkNotNull(zzhVarZzu.zzd()));
                                            }
                                            if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                                zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                                            }
                                            listZzn = zzj().zzn(str11);
                                            while (i2 < listZzn.size()) {
                                                com.google.android.gms.internal.measurement.zzit zzitVarZzm11 = com.google.android.gms.internal.measurement.zziu.zzm();
                                                zzitVarZzm11.zzb(((zzpn) listZzn.get(i2)).zzc);
                                                zzitVarZzm11.zza(((zzpn) listZzn.get(i2)).zzd);
                                                zzp().zzc(zzitVarZzm11, ((zzpn) listZzn.get(i2)).zze);
                                                zzicVarZzaE.zzp(zzitVarZzm11);
                                                if (!"_sid".equals(((zzpn) listZzn.get(i2)).zzc)) {
                                                }
                                            }
                                            zzavVarZzj3 = zzj();
                                            com.google.android.gms.internal.measurement.zzid zzidVar11 = (com.google.android.gms.internal.measurement.zzid) zzicVarZzaE.zzbc();
                                            zzavVarZzj3.zzg();
                                            zzavVarZzj3.zzaw();
                                            Preconditions.checkNotNull(zzidVar11);
                                            Preconditions.checkNotEmpty(zzidVar11.zzA());
                                            byte[] bArrZzcc111 = zzidVar11.zzcc();
                                            long jZzt11 = zzavVarZzj3.zzg.zzp().zzt(bArrZzcc111);
                                            ContentValues contentValues12 = new ContentValues();
                                            String str2111114 = str14;
                                            contentValues12.put(str2111114, zzidVar11.zzA());
                                            contentValues12.put("metadata_fingerprint", Long.valueOf(jZzt11));
                                            contentValues12.put("metadata", bArrZzcc111);
                                            zzavVarZzj3.zze().insertWithOnConflict("raw_events_metadata", null, contentValues12, 4);
                                            zzavVarZzj4 = zzj();
                                            zzbdVar2 = new zzbd(zzbbVar.zzf);
                                            while (true) {
                                                if (zzbdVar2.hasNext()) {
                                                    zzht zzhtVarZzh12 = zzh();
                                                    String str2111115 = zzbbVar.zza;
                                                    zZzk = zzhtVarZzh12.zzk(str2111115, zzbbVar.zzb);
                                                    zzar zzarVarZzw11 = zzj().zzw(zzC(), str2111115, false, false, false, false, false, false, false);
                                                    if (zZzk) {
                                                    }
                                                    i3 = 0;
                                                    break;
                                                }
                                                next = zzbdVar2.next();
                                                String str2111116 = next;
                                                if (str12.equals(next)) {
                                                }
                                                i3 = 1;
                                                break;
                                            }
                                            zzavVarZzj4.zzg();
                                            zzavVarZzj4.zzaw();
                                            Preconditions.checkNotNull(zzbbVar);
                                            str13 = zzbbVar.zza;
                                            Preconditions.checkNotEmpty(str13);
                                            byte[] bArrZzcc112 = zzavVarZzj4.zzg.zzp().zzh(zzbbVar).zzcc();
                                            contentValues = new ContentValues();
                                            contentValues.put(str2111114, str13);
                                            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbbVar.zzb);
                                            contentValues.put(ServerValues.NAME_OP_TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                                            contentValues.put("metadata_fingerprint", Long.valueOf(jZzt11));
                                            contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzcc112);
                                            contentValues.put("realtime", Integer.valueOf(i3));
                                            if (zzavVarZzj4.zze().insert(str4, null, contentValues) == -1) {
                                                zzavVarZzj4.zzu.zzaV().zzb().zzb("Failed to insert raw event (got -1). appId", zzgu.zzl(str13));
                                            } else {
                                                this.zza = 0L;
                                            }
                                            zzj().zzc();
                                            zzj().zzd();
                                            zzaL();
                                            zzaV().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                            return;
                                        }
                                        jMax = zzarVarZzx.zzd - ((long) Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzd().zzm(zzrVar.zza, zzfy.zzl))));
                                        if (jMax > 0) {
                                            bundleZzf = zzbeVar2.zzf();
                                            zzpp zzppVarZzt12 = zzt();
                                            String str2111117 = zzbgVar2.zzc;
                                            zzppVarZzt12.zzM(bundleZzf, "_o", str2111117);
                                            if (zzt().zzaa(str16, zzrVar.zzB)) {
                                                zzt().zzM(bundleZzf, "_dbg", 1L);
                                                zzt().zzM(bundleZzf, "_r", 1L);
                                            }
                                            if ("_s".equals(str2)) {
                                                obj2 = zzpnVarZzm2.zze;
                                                if (obj2 instanceof Long) {
                                                    zzt().zzM(bundleZzf, "_sno", obj2);
                                                }
                                            }
                                            if (zzd().zzp(null, zzfy.zzaX)) {
                                                obj = bundleZzf.get("value");
                                                if (obj instanceof String) {
                                                    double d12 = Double.parseDouble((String) obj);
                                                    bundleZzf.remove("value");
                                                    bundleZzf.putDouble("value", d12);
                                                }
                                            }
                                            zzavVarZzj2 = zzj();
                                            Preconditions.checkNotEmpty(str16);
                                            zzavVarZzj2.zzg();
                                            zzavVarZzj2.zzaw();
                                            str3 = r6;
                                            jDelete = zzavVarZzj2.zze().delete(str3, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str16, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzavVarZzj2.zzu.zzc().zzm(str16, zzfy.zzp))))});
                                            if (jDelete > 0) {
                                                zzaV().zze().zzc("Data lost. Too many events stored on disk, deleted. appId", zzgu.zzl(str16), Long.valueOf(jDelete));
                                            }
                                            zzicVar = this.zzn;
                                            str4 = str3;
                                            zzbbVar = new zzbb(zzicVar, zzbgVar2.zzc, str16, zzbgVar2.zza, zzbgVar2.zzd, 0L, bundleZzf);
                                            zzav zzavVarZzj16 = zzj();
                                            str5 = zzbbVar.zzb;
                                            zzbcVarZzf = zzavVarZzj16.zzf(str16, str5);
                                            if (zzbcVarZzf != null) {
                                                if (zzj().zzS(str16) >= zzd().zzh(str16)) {
                                                }
                                                zzbcVarZza = new zzbc(str16, str5, 0L, 0L, 0L, zzbbVar.zzd, 0L, null, null, null, null);
                                            } else {
                                                zzbbVar = zzbbVar.zza(zzicVar, zzbcVarZzf.zzf);
                                                zzbcVarZza = zzbcVarZzf.zza(zzbbVar.zzd);
                                            }
                                            zzj().zzh(zzbcVarZza);
                                            zzaW().zzg();
                                            zzu();
                                            Preconditions.checkNotNull(zzbbVar);
                                            Preconditions.checkNotNull(zzrVar);
                                            String str2111118 = zzbbVar.zza;
                                            Preconditions.checkNotEmpty(str2111118);
                                            str6 = zzrVar.zza;
                                            Preconditions.checkArgument(str2111118.equals(str6));
                                            zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                                            boolean z13 = true;
                                            zzicVarZzaE.zza(1);
                                            zzicVarZzaE.zzC("android");
                                            if (!TextUtils.isEmpty(str6)) {
                                                zzicVarZzaE.zzL(str6);
                                            }
                                            str7 = zzrVar.zzd;
                                            if (!TextUtils.isEmpty(str7)) {
                                                zzicVarZzaE.zzJ(str7);
                                            }
                                            str8 = zzrVar.zzc;
                                            if (!TextUtils.isEmpty(str8)) {
                                                zzicVarZzaE.zzM(str8);
                                            }
                                            str9 = zzrVar.zzu;
                                            if (!TextUtils.isEmpty(str9)) {
                                                zzicVarZzaE.zzau(str9);
                                            }
                                            j = zzrVar.zzj;
                                            if (j != -2147483648L) {
                                                zzicVarZzaE.zzaj((int) j);
                                            }
                                            zzicVarZzaE.zzN(zzrVar.zze);
                                            str10 = zzrVar.zzb;
                                            if (!TextUtils.isEmpty(str10)) {
                                                zzicVarZzaE.zzad(str10);
                                            }
                                            zzjl zzjlVarZzs13 = zzB((String) Preconditions.checkNotNull(str6)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                            zzicVarZzaE.zzat(zzjlVarZzs13.zzk());
                                            zzqp.zza();
                                            if (!zzd().zzp(str6, zzfy.zzaP)) {
                                            }
                                            j2 = zzrVar.zzf;
                                            if (j2 != 0) {
                                                zzicVarZzaE.zzY(j2);
                                            }
                                            zzicVarZzaE.zzar(zzrVar.zzq);
                                            zzpk zzpkVarZzp12 = zzp();
                                            zzjrVarZza = com.google.android.gms.internal.measurement.zzjr.zza(zzpkVarZzp12.zzg.zzn.zzaY().getContentResolver(), com.google.android.gms.internal.measurement.zzkb.zza("com.google.android.gms.measurement"), zzfu.zza);
                                            if (zzjrVarZza == null) {
                                                mapZzb = Collections.emptyMap();
                                            } else {
                                                mapZzb = zzjrVarZza.zzb();
                                            }
                                            if (mapZzb != null) {
                                                arrayList = null;
                                            } else {
                                                arrayList = null;
                                            }
                                            if (arrayList != null) {
                                                zzicVarZzaE.zzaq(arrayList);
                                            }
                                            if (zzd().zzp(null, zzfy.zzba)) {
                                                zzicVarZzaE.zzaP("");
                                            }
                                            str11 = zzrVar.zza;
                                            zzjlVarZzs = zzB((String) Preconditions.checkNotNull(str11)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                            zzjkVar = zzjk.AD_STORAGE;
                                            if (zzjlVarZzs.zzo(zzjkVar)) {
                                                zzjlVarZzs = zzjlVarZzs;
                                                zzjkVar = zzjkVar;
                                                str12 = "_r";
                                            } else {
                                                zzjlVarZzs = zzjlVarZzs;
                                                zzjkVar = zzjkVar;
                                                str12 = "_r";
                                            }
                                            zzicVar2 = this.zzn;
                                            zzicVar2.zzu().zzw();
                                            zzicVarZzaE.zzF(Build.MODEL);
                                            zzicVar2.zzu().zzw();
                                            zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                                            zzicVarZzaE.zzI((int) zzicVar2.zzu().zzb());
                                            zzicVarZzaE.zzH(zzicVar2.zzu().zzc());
                                            zzicVarZzaE.zzay(zzrVar.zzw);
                                            if (zzicVar2.zzB()) {
                                                zzicVarZzaE.zzK();
                                                if (!TextUtils.isEmpty(null)) {
                                                    zzicVarZzaE.zzam(null);
                                                }
                                            }
                                            zzhVarZzu = zzj().zzu(str11);
                                            if (zzhVarZzu == null) {
                                                zzhVarZzu = new zzh(zzicVar2, str11);
                                                zzhVarZzu.zze(zzK(zzjlVarZzs));
                                                zzhVarZzu.zzm(zzrVar.zzk);
                                                zzhVarZzu.zzg(zzrVar.zzb);
                                                if (zzjlVarZzs.zzo(zzjkVar)) {
                                                    zzhVarZzu.zzk(this.zzk.zzf(str11, zzrVar.zzn));
                                                }
                                                zzhVarZzu.zzF(0L);
                                                zzhVarZzu.zzo(0L);
                                                zzhVarZzu.zzq(0L);
                                                zzhVarZzu.zzs(zzrVar.zzc);
                                                zzhVarZzu.zzu(zzrVar.zzj);
                                                zzhVarZzu.zzw(zzrVar.zzd);
                                                zzhVarZzu.zzy(zzrVar.zze);
                                                zzhVarZzu.zzA(zzrVar.zzf);
                                                zzhVarZzu.zzE(zzrVar.zzh);
                                                zzhVarZzu.zzC(zzrVar.zzq);
                                                i = 0;
                                                zzj().zzv(zzhVarZzu, false, false);
                                            } else {
                                                i = 0;
                                            }
                                            if (zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                                                zzicVarZzaE.zzW((String) Preconditions.checkNotNull(zzhVarZzu.zzd()));
                                            }
                                            if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                                zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                                            }
                                            listZzn = zzj().zzn(str11);
                                            while (i2 < listZzn.size()) {
                                                com.google.android.gms.internal.measurement.zzit zzitVarZzm12 = com.google.android.gms.internal.measurement.zziu.zzm();
                                                zzitVarZzm12.zzb(((zzpn) listZzn.get(i2)).zzc);
                                                zzitVarZzm12.zza(((zzpn) listZzn.get(i2)).zzd);
                                                zzp().zzc(zzitVarZzm12, ((zzpn) listZzn.get(i2)).zze);
                                                zzicVarZzaE.zzp(zzitVarZzm12);
                                                if (!"_sid".equals(((zzpn) listZzn.get(i2)).zzc)) {
                                                }
                                            }
                                            zzavVarZzj3 = zzj();
                                            com.google.android.gms.internal.measurement.zzid zzidVar12 = (com.google.android.gms.internal.measurement.zzid) zzicVarZzaE.zzbc();
                                            zzavVarZzj3.zzg();
                                            zzavVarZzj3.zzaw();
                                            Preconditions.checkNotNull(zzidVar12);
                                            Preconditions.checkNotEmpty(zzidVar12.zzA());
                                            byte[] bArrZzcc113 = zzidVar12.zzcc();
                                            long jZzt12 = zzavVarZzj3.zzg.zzp().zzt(bArrZzcc113);
                                            ContentValues contentValues13 = new ContentValues();
                                            String str2111119 = str14;
                                            contentValues13.put(str2111119, zzidVar12.zzA());
                                            contentValues13.put("metadata_fingerprint", Long.valueOf(jZzt12));
                                            contentValues13.put("metadata", bArrZzcc113);
                                            zzavVarZzj3.zze().insertWithOnConflict("raw_events_metadata", null, contentValues13, 4);
                                            zzavVarZzj4 = zzj();
                                            zzbdVar2 = new zzbd(zzbbVar.zzf);
                                            while (true) {
                                                if (zzbdVar2.hasNext()) {
                                                    zzht zzhtVarZzh13 = zzh();
                                                    String str21111110 = zzbbVar.zza;
                                                    zZzk = zzhtVarZzh13.zzk(str21111110, zzbbVar.zzb);
                                                    zzar zzarVarZzw12 = zzj().zzw(zzC(), str21111110, false, false, false, false, false, false, false);
                                                    if (zZzk) {
                                                    }
                                                    i3 = 0;
                                                    break;
                                                }
                                                next = zzbdVar2.next();
                                                String str21111111 = next;
                                                if (str12.equals(next)) {
                                                }
                                                i3 = 1;
                                                break;
                                            }
                                            zzavVarZzj4.zzg();
                                            zzavVarZzj4.zzaw();
                                            Preconditions.checkNotNull(zzbbVar);
                                            str13 = zzbbVar.zza;
                                            Preconditions.checkNotEmpty(str13);
                                            byte[] bArrZzcc114 = zzavVarZzj4.zzg.zzp().zzh(zzbbVar).zzcc();
                                            contentValues = new ContentValues();
                                            contentValues.put(str2111119, str13);
                                            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbbVar.zzb);
                                            contentValues.put(ServerValues.NAME_OP_TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                                            contentValues.put("metadata_fingerprint", Long.valueOf(jZzt12));
                                            contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzcc114);
                                            contentValues.put("realtime", Integer.valueOf(i3));
                                            if (zzavVarZzj4.zze().insert(str4, null, contentValues) == -1) {
                                                zzavVarZzj4.zzu.zzaV().zzb().zzb("Failed to insert raw event (got -1). appId", zzgu.zzl(str13));
                                            } else {
                                                this.zza = 0L;
                                            }
                                            zzj().zzc();
                                            zzj().zzd();
                                            zzaL();
                                            zzaV().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                            return;
                                        }
                                        if (jMax == 1) {
                                            zzaV().zzb().zzc("Too many error events logged. appId, count", zzgu.zzl(str16), Long.valueOf(zzarVarZzx.zzd));
                                        }
                                        zzj().zzc();
                                    }
                                } else {
                                    zzbgVarZzb = zzbgVarZzb;
                                    zzavVarZzj = zzj();
                                    int iZzm3 = zzd().zzm(str16, zzfy.zzT) - 1;
                                    Preconditions.checkNotEmpty(str16);
                                    zzavVarZzj.zzg();
                                    zzavVarZzj.zzaw();
                                    zzavVarZzj.zze().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '!_ltv!_%' escape '!'order by set_timestamp desc limit ?,10);", new String[]{str16, str16, String.valueOf(iZzm3)});
                                    zzpnVar = new zzpn(str16, zzbgVarZzb.zzc, strConcat, zzaZ().currentTimeMillis(), Long.valueOf(jLongValue));
                                    zzpnVar2 = zzpnVar;
                                    if (!zzj().zzl(zzpnVar2)) {
                                        zzaV().zzb().zzd("Too many unique user properties are set. Ignoring user property. appId", zzgu.zzl(str16), this.zzn.zzl().zzc(zzpnVar2.zzc), zzpnVar2.zze);
                                        zzt().zzN(this.zzK, str16, 9, null, null, 0);
                                    }
                                    str2 = zzbgVarZzb.zza;
                                    zZzh = zzpp.zzh(str2);
                                    zEquals = str.equals(str2);
                                    zzt();
                                    zzbeVar2 = zzbgVarZzb.zzb;
                                    if (zzbeVar2 == null) {
                                        length = 0;
                                    } else {
                                        zzbdVar = new zzbd(zzbeVar2);
                                        length = 0;
                                        while (zzbdVar.hasNext()) {
                                            String next5 = zzbdVar.next();
                                            String str222 = next5;
                                            objZza = zzbeVar2.zza(next5);
                                            if (objZza instanceof Parcelable[]) {
                                                length += (long) ((Parcelable[]) objZza).length;
                                            }
                                        }
                                    }
                                    zzbgVar2 = zzbgVarZzb;
                                    zzarVarZzx = zzj().zzx(zzC(), str16, length + 1, true, zZzh, false, zEquals, false, false, false);
                                    long j10 = zzarVarZzx.zzb;
                                    zzd();
                                    jZzH = j10 - zzal.zzH();
                                    if (jZzH > 0) {
                                        if (jZzH % 1000 == 1) {
                                            zzaV().zzb().zzc("Data loss. Too many events logged. appId, count", zzgu.zzl(str16), Long.valueOf(zzarVarZzx.zzb));
                                        }
                                        zzj().zzc();
                                    } else if (zZzh) {
                                        long j11 = zzarVarZzx.zza;
                                        zzd();
                                        jIntValue = j11 - ((long) ((Integer) zzfy.zzm.zzb(null)).intValue());
                                        if (jIntValue > 0) {
                                            if (jIntValue % 1000 == 1) {
                                                zzaV().zzb().zzc("Data loss. Too many public events logged. appId, count", zzgu.zzl(str16), Long.valueOf(zzarVarZzx.zza));
                                            }
                                            zzt().zzN(this.zzK, str16, 16, "_ev", zzbgVar2.zza, 0);
                                            zzj().zzc();
                                        } else {
                                            if (zEquals) {
                                                bundleZzf = zzbeVar2.zzf();
                                                zzpp zzppVarZzt13 = zzt();
                                                String str21111112 = zzbgVar2.zzc;
                                                zzppVarZzt13.zzM(bundleZzf, "_o", str21111112);
                                                if (zzt().zzaa(str16, zzrVar.zzB)) {
                                                    zzt().zzM(bundleZzf, "_dbg", 1L);
                                                    zzt().zzM(bundleZzf, "_r", 1L);
                                                }
                                                if ("_s".equals(str2)) {
                                                    obj2 = zzpnVarZzm2.zze;
                                                    if (obj2 instanceof Long) {
                                                        zzt().zzM(bundleZzf, "_sno", obj2);
                                                    }
                                                }
                                                if (zzd().zzp(null, zzfy.zzaX)) {
                                                    obj = bundleZzf.get("value");
                                                    if (obj instanceof String) {
                                                        double d13 = Double.parseDouble((String) obj);
                                                        bundleZzf.remove("value");
                                                        bundleZzf.putDouble("value", d13);
                                                    }
                                                }
                                                zzavVarZzj2 = zzj();
                                                Preconditions.checkNotEmpty(str16);
                                                zzavVarZzj2.zzg();
                                                zzavVarZzj2.zzaw();
                                                str3 = r6;
                                                jDelete = zzavVarZzj2.zze().delete(str3, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str16, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzavVarZzj2.zzu.zzc().zzm(str16, zzfy.zzp))))});
                                                if (jDelete > 0) {
                                                    zzaV().zze().zzc("Data lost. Too many events stored on disk, deleted. appId", zzgu.zzl(str16), Long.valueOf(jDelete));
                                                }
                                                zzicVar = this.zzn;
                                                str4 = str3;
                                                zzbbVar = new zzbb(zzicVar, zzbgVar2.zzc, str16, zzbgVar2.zza, zzbgVar2.zzd, 0L, bundleZzf);
                                                zzav zzavVarZzj17 = zzj();
                                                str5 = zzbbVar.zzb;
                                                zzbcVarZzf = zzavVarZzj17.zzf(str16, str5);
                                                if (zzbcVarZzf != null) {
                                                    if (zzj().zzS(str16) >= zzd().zzh(str16)) {
                                                    }
                                                    zzbcVarZza = new zzbc(str16, str5, 0L, 0L, 0L, zzbbVar.zzd, 0L, null, null, null, null);
                                                } else {
                                                    zzbbVar = zzbbVar.zza(zzicVar, zzbcVarZzf.zzf);
                                                    zzbcVarZza = zzbcVarZzf.zza(zzbbVar.zzd);
                                                }
                                                zzj().zzh(zzbcVarZza);
                                                zzaW().zzg();
                                                zzu();
                                                Preconditions.checkNotNull(zzbbVar);
                                                Preconditions.checkNotNull(zzrVar);
                                                String str21111113 = zzbbVar.zza;
                                                Preconditions.checkNotEmpty(str21111113);
                                                str6 = zzrVar.zza;
                                                Preconditions.checkArgument(str21111113.equals(str6));
                                                zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                                                boolean z14 = true;
                                                zzicVarZzaE.zza(1);
                                                zzicVarZzaE.zzC("android");
                                                if (!TextUtils.isEmpty(str6)) {
                                                    zzicVarZzaE.zzL(str6);
                                                }
                                                str7 = zzrVar.zzd;
                                                if (!TextUtils.isEmpty(str7)) {
                                                    zzicVarZzaE.zzJ(str7);
                                                }
                                                str8 = zzrVar.zzc;
                                                if (!TextUtils.isEmpty(str8)) {
                                                    zzicVarZzaE.zzM(str8);
                                                }
                                                str9 = zzrVar.zzu;
                                                if (!TextUtils.isEmpty(str9)) {
                                                    zzicVarZzaE.zzau(str9);
                                                }
                                                j = zzrVar.zzj;
                                                if (j != -2147483648L) {
                                                    zzicVarZzaE.zzaj((int) j);
                                                }
                                                zzicVarZzaE.zzN(zzrVar.zze);
                                                str10 = zzrVar.zzb;
                                                if (!TextUtils.isEmpty(str10)) {
                                                    zzicVarZzaE.zzad(str10);
                                                }
                                                zzjl zzjlVarZzs14 = zzB((String) Preconditions.checkNotNull(str6)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                                zzicVarZzaE.zzat(zzjlVarZzs14.zzk());
                                                zzqp.zza();
                                                if (!zzd().zzp(str6, zzfy.zzaP)) {
                                                }
                                                j2 = zzrVar.zzf;
                                                if (j2 != 0) {
                                                    zzicVarZzaE.zzY(j2);
                                                }
                                                zzicVarZzaE.zzar(zzrVar.zzq);
                                                zzpk zzpkVarZzp13 = zzp();
                                                zzjrVarZza = com.google.android.gms.internal.measurement.zzjr.zza(zzpkVarZzp13.zzg.zzn.zzaY().getContentResolver(), com.google.android.gms.internal.measurement.zzkb.zza("com.google.android.gms.measurement"), zzfu.zza);
                                                if (zzjrVarZza == null) {
                                                    mapZzb = Collections.emptyMap();
                                                } else {
                                                    mapZzb = zzjrVarZza.zzb();
                                                }
                                                if (mapZzb != null) {
                                                    arrayList = null;
                                                } else {
                                                    arrayList = null;
                                                }
                                                if (arrayList != null) {
                                                    zzicVarZzaE.zzaq(arrayList);
                                                }
                                                if (zzd().zzp(null, zzfy.zzba)) {
                                                    zzicVarZzaE.zzaP("");
                                                }
                                                str11 = zzrVar.zza;
                                                zzjlVarZzs = zzB((String) Preconditions.checkNotNull(str11)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                                zzjkVar = zzjk.AD_STORAGE;
                                                if (zzjlVarZzs.zzo(zzjkVar)) {
                                                    zzjlVarZzs = zzjlVarZzs;
                                                    zzjkVar = zzjkVar;
                                                    str12 = "_r";
                                                } else {
                                                    zzjlVarZzs = zzjlVarZzs;
                                                    zzjkVar = zzjkVar;
                                                    str12 = "_r";
                                                }
                                                zzicVar2 = this.zzn;
                                                zzicVar2.zzu().zzw();
                                                zzicVarZzaE.zzF(Build.MODEL);
                                                zzicVar2.zzu().zzw();
                                                zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                                                zzicVarZzaE.zzI((int) zzicVar2.zzu().zzb());
                                                zzicVarZzaE.zzH(zzicVar2.zzu().zzc());
                                                zzicVarZzaE.zzay(zzrVar.zzw);
                                                if (zzicVar2.zzB()) {
                                                    zzicVarZzaE.zzK();
                                                    if (!TextUtils.isEmpty(null)) {
                                                        zzicVarZzaE.zzam(null);
                                                    }
                                                }
                                                zzhVarZzu = zzj().zzu(str11);
                                                if (zzhVarZzu == null) {
                                                    zzhVarZzu = new zzh(zzicVar2, str11);
                                                    zzhVarZzu.zze(zzK(zzjlVarZzs));
                                                    zzhVarZzu.zzm(zzrVar.zzk);
                                                    zzhVarZzu.zzg(zzrVar.zzb);
                                                    if (zzjlVarZzs.zzo(zzjkVar)) {
                                                        zzhVarZzu.zzk(this.zzk.zzf(str11, zzrVar.zzn));
                                                    }
                                                    zzhVarZzu.zzF(0L);
                                                    zzhVarZzu.zzo(0L);
                                                    zzhVarZzu.zzq(0L);
                                                    zzhVarZzu.zzs(zzrVar.zzc);
                                                    zzhVarZzu.zzu(zzrVar.zzj);
                                                    zzhVarZzu.zzw(zzrVar.zzd);
                                                    zzhVarZzu.zzy(zzrVar.zze);
                                                    zzhVarZzu.zzA(zzrVar.zzf);
                                                    zzhVarZzu.zzE(zzrVar.zzh);
                                                    zzhVarZzu.zzC(zzrVar.zzq);
                                                    i = 0;
                                                    zzj().zzv(zzhVarZzu, false, false);
                                                } else {
                                                    i = 0;
                                                }
                                                if (zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                                                    zzicVarZzaE.zzW((String) Preconditions.checkNotNull(zzhVarZzu.zzd()));
                                                }
                                                if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                                    zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                                                }
                                                listZzn = zzj().zzn(str11);
                                                while (i2 < listZzn.size()) {
                                                    com.google.android.gms.internal.measurement.zzit zzitVarZzm13 = com.google.android.gms.internal.measurement.zziu.zzm();
                                                    zzitVarZzm13.zzb(((zzpn) listZzn.get(i2)).zzc);
                                                    zzitVarZzm13.zza(((zzpn) listZzn.get(i2)).zzd);
                                                    zzp().zzc(zzitVarZzm13, ((zzpn) listZzn.get(i2)).zze);
                                                    zzicVarZzaE.zzp(zzitVarZzm13);
                                                    if (!"_sid".equals(((zzpn) listZzn.get(i2)).zzc)) {
                                                    }
                                                }
                                                zzavVarZzj3 = zzj();
                                                com.google.android.gms.internal.measurement.zzid zzidVar13 = (com.google.android.gms.internal.measurement.zzid) zzicVarZzaE.zzbc();
                                                zzavVarZzj3.zzg();
                                                zzavVarZzj3.zzaw();
                                                Preconditions.checkNotNull(zzidVar13);
                                                Preconditions.checkNotEmpty(zzidVar13.zzA());
                                                byte[] bArrZzcc115 = zzidVar13.zzcc();
                                                long jZzt13 = zzavVarZzj3.zzg.zzp().zzt(bArrZzcc115);
                                                ContentValues contentValues14 = new ContentValues();
                                                String str21111114 = str14;
                                                contentValues14.put(str21111114, zzidVar13.zzA());
                                                contentValues14.put("metadata_fingerprint", Long.valueOf(jZzt13));
                                                contentValues14.put("metadata", bArrZzcc115);
                                                zzavVarZzj3.zze().insertWithOnConflict("raw_events_metadata", null, contentValues14, 4);
                                                zzavVarZzj4 = zzj();
                                                zzbdVar2 = new zzbd(zzbbVar.zzf);
                                                while (true) {
                                                    if (zzbdVar2.hasNext()) {
                                                        zzht zzhtVarZzh14 = zzh();
                                                        String str21111115 = zzbbVar.zza;
                                                        zZzk = zzhtVarZzh14.zzk(str21111115, zzbbVar.zzb);
                                                        zzar zzarVarZzw13 = zzj().zzw(zzC(), str21111115, false, false, false, false, false, false, false);
                                                        if (zZzk) {
                                                        }
                                                        i3 = 0;
                                                        break;
                                                    }
                                                    next = zzbdVar2.next();
                                                    String str21111116 = next;
                                                    if (str12.equals(next)) {
                                                    }
                                                    i3 = 1;
                                                    break;
                                                }
                                                zzavVarZzj4.zzg();
                                                zzavVarZzj4.zzaw();
                                                Preconditions.checkNotNull(zzbbVar);
                                                str13 = zzbbVar.zza;
                                                Preconditions.checkNotEmpty(str13);
                                                byte[] bArrZzcc116 = zzavVarZzj4.zzg.zzp().zzh(zzbbVar).zzcc();
                                                contentValues = new ContentValues();
                                                contentValues.put(str21111114, str13);
                                                contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbbVar.zzb);
                                                contentValues.put(ServerValues.NAME_OP_TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                                                contentValues.put("metadata_fingerprint", Long.valueOf(jZzt13));
                                                contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzcc116);
                                                contentValues.put("realtime", Integer.valueOf(i3));
                                                if (zzavVarZzj4.zze().insert(str4, null, contentValues) == -1) {
                                                    zzavVarZzj4.zzu.zzaV().zzb().zzb("Failed to insert raw event (got -1). appId", zzgu.zzl(str13));
                                                } else {
                                                    this.zza = 0L;
                                                }
                                                zzj().zzc();
                                                zzj().zzd();
                                                zzaL();
                                                zzaV().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                                return;
                                            }
                                            jMax = zzarVarZzx.zzd - ((long) Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzd().zzm(zzrVar.zza, zzfy.zzl))));
                                            if (jMax > 0) {
                                                bundleZzf = zzbeVar2.zzf();
                                                zzpp zzppVarZzt14 = zzt();
                                                String str21111117 = zzbgVar2.zzc;
                                                zzppVarZzt14.zzM(bundleZzf, "_o", str21111117);
                                                if (zzt().zzaa(str16, zzrVar.zzB)) {
                                                    zzt().zzM(bundleZzf, "_dbg", 1L);
                                                    zzt().zzM(bundleZzf, "_r", 1L);
                                                }
                                                if ("_s".equals(str2)) {
                                                    obj2 = zzpnVarZzm2.zze;
                                                    if (obj2 instanceof Long) {
                                                        zzt().zzM(bundleZzf, "_sno", obj2);
                                                    }
                                                }
                                                if (zzd().zzp(null, zzfy.zzaX)) {
                                                    obj = bundleZzf.get("value");
                                                    if (obj instanceof String) {
                                                        double d14 = Double.parseDouble((String) obj);
                                                        bundleZzf.remove("value");
                                                        bundleZzf.putDouble("value", d14);
                                                    }
                                                }
                                                zzavVarZzj2 = zzj();
                                                Preconditions.checkNotEmpty(str16);
                                                zzavVarZzj2.zzg();
                                                zzavVarZzj2.zzaw();
                                                str3 = r6;
                                                jDelete = zzavVarZzj2.zze().delete(str3, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str16, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzavVarZzj2.zzu.zzc().zzm(str16, zzfy.zzp))))});
                                                if (jDelete > 0) {
                                                    zzaV().zze().zzc("Data lost. Too many events stored on disk, deleted. appId", zzgu.zzl(str16), Long.valueOf(jDelete));
                                                }
                                                zzicVar = this.zzn;
                                                str4 = str3;
                                                zzbbVar = new zzbb(zzicVar, zzbgVar2.zzc, str16, zzbgVar2.zza, zzbgVar2.zzd, 0L, bundleZzf);
                                                zzav zzavVarZzj18 = zzj();
                                                str5 = zzbbVar.zzb;
                                                zzbcVarZzf = zzavVarZzj18.zzf(str16, str5);
                                                if (zzbcVarZzf != null) {
                                                    if (zzj().zzS(str16) >= zzd().zzh(str16)) {
                                                    }
                                                    zzbcVarZza = new zzbc(str16, str5, 0L, 0L, 0L, zzbbVar.zzd, 0L, null, null, null, null);
                                                } else {
                                                    zzbbVar = zzbbVar.zza(zzicVar, zzbcVarZzf.zzf);
                                                    zzbcVarZza = zzbcVarZzf.zza(zzbbVar.zzd);
                                                }
                                                zzj().zzh(zzbcVarZza);
                                                zzaW().zzg();
                                                zzu();
                                                Preconditions.checkNotNull(zzbbVar);
                                                Preconditions.checkNotNull(zzrVar);
                                                String str21111118 = zzbbVar.zza;
                                                Preconditions.checkNotEmpty(str21111118);
                                                str6 = zzrVar.zza;
                                                Preconditions.checkArgument(str21111118.equals(str6));
                                                zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                                                boolean z15 = true;
                                                zzicVarZzaE.zza(1);
                                                zzicVarZzaE.zzC("android");
                                                if (!TextUtils.isEmpty(str6)) {
                                                    zzicVarZzaE.zzL(str6);
                                                }
                                                str7 = zzrVar.zzd;
                                                if (!TextUtils.isEmpty(str7)) {
                                                    zzicVarZzaE.zzJ(str7);
                                                }
                                                str8 = zzrVar.zzc;
                                                if (!TextUtils.isEmpty(str8)) {
                                                    zzicVarZzaE.zzM(str8);
                                                }
                                                str9 = zzrVar.zzu;
                                                if (!TextUtils.isEmpty(str9)) {
                                                    zzicVarZzaE.zzau(str9);
                                                }
                                                j = zzrVar.zzj;
                                                if (j != -2147483648L) {
                                                    zzicVarZzaE.zzaj((int) j);
                                                }
                                                zzicVarZzaE.zzN(zzrVar.zze);
                                                str10 = zzrVar.zzb;
                                                if (!TextUtils.isEmpty(str10)) {
                                                    zzicVarZzaE.zzad(str10);
                                                }
                                                zzjl zzjlVarZzs15 = zzB((String) Preconditions.checkNotNull(str6)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                                zzicVarZzaE.zzat(zzjlVarZzs15.zzk());
                                                zzqp.zza();
                                                if (!zzd().zzp(str6, zzfy.zzaP)) {
                                                }
                                                j2 = zzrVar.zzf;
                                                if (j2 != 0) {
                                                    zzicVarZzaE.zzY(j2);
                                                }
                                                zzicVarZzaE.zzar(zzrVar.zzq);
                                                zzpk zzpkVarZzp14 = zzp();
                                                zzjrVarZza = com.google.android.gms.internal.measurement.zzjr.zza(zzpkVarZzp14.zzg.zzn.zzaY().getContentResolver(), com.google.android.gms.internal.measurement.zzkb.zza("com.google.android.gms.measurement"), zzfu.zza);
                                                if (zzjrVarZza == null) {
                                                    mapZzb = Collections.emptyMap();
                                                } else {
                                                    mapZzb = zzjrVarZza.zzb();
                                                }
                                                if (mapZzb != null) {
                                                    arrayList = null;
                                                } else {
                                                    arrayList = null;
                                                }
                                                if (arrayList != null) {
                                                    zzicVarZzaE.zzaq(arrayList);
                                                }
                                                if (zzd().zzp(null, zzfy.zzba)) {
                                                    zzicVarZzaE.zzaP("");
                                                }
                                                str11 = zzrVar.zza;
                                                zzjlVarZzs = zzB((String) Preconditions.checkNotNull(str11)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                                zzjkVar = zzjk.AD_STORAGE;
                                                if (zzjlVarZzs.zzo(zzjkVar)) {
                                                    zzjlVarZzs = zzjlVarZzs;
                                                    zzjkVar = zzjkVar;
                                                    str12 = "_r";
                                                } else {
                                                    zzjlVarZzs = zzjlVarZzs;
                                                    zzjkVar = zzjkVar;
                                                    str12 = "_r";
                                                }
                                                zzicVar2 = this.zzn;
                                                zzicVar2.zzu().zzw();
                                                zzicVarZzaE.zzF(Build.MODEL);
                                                zzicVar2.zzu().zzw();
                                                zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                                                zzicVarZzaE.zzI((int) zzicVar2.zzu().zzb());
                                                zzicVarZzaE.zzH(zzicVar2.zzu().zzc());
                                                zzicVarZzaE.zzay(zzrVar.zzw);
                                                if (zzicVar2.zzB()) {
                                                    zzicVarZzaE.zzK();
                                                    if (!TextUtils.isEmpty(null)) {
                                                        zzicVarZzaE.zzam(null);
                                                    }
                                                }
                                                zzhVarZzu = zzj().zzu(str11);
                                                if (zzhVarZzu == null) {
                                                    zzhVarZzu = new zzh(zzicVar2, str11);
                                                    zzhVarZzu.zze(zzK(zzjlVarZzs));
                                                    zzhVarZzu.zzm(zzrVar.zzk);
                                                    zzhVarZzu.zzg(zzrVar.zzb);
                                                    if (zzjlVarZzs.zzo(zzjkVar)) {
                                                        zzhVarZzu.zzk(this.zzk.zzf(str11, zzrVar.zzn));
                                                    }
                                                    zzhVarZzu.zzF(0L);
                                                    zzhVarZzu.zzo(0L);
                                                    zzhVarZzu.zzq(0L);
                                                    zzhVarZzu.zzs(zzrVar.zzc);
                                                    zzhVarZzu.zzu(zzrVar.zzj);
                                                    zzhVarZzu.zzw(zzrVar.zzd);
                                                    zzhVarZzu.zzy(zzrVar.zze);
                                                    zzhVarZzu.zzA(zzrVar.zzf);
                                                    zzhVarZzu.zzE(zzrVar.zzh);
                                                    zzhVarZzu.zzC(zzrVar.zzq);
                                                    i = 0;
                                                    zzj().zzv(zzhVarZzu, false, false);
                                                } else {
                                                    i = 0;
                                                }
                                                if (zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                                                    zzicVarZzaE.zzW((String) Preconditions.checkNotNull(zzhVarZzu.zzd()));
                                                }
                                                if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                                    zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                                                }
                                                listZzn = zzj().zzn(str11);
                                                while (i2 < listZzn.size()) {
                                                    com.google.android.gms.internal.measurement.zzit zzitVarZzm14 = com.google.android.gms.internal.measurement.zziu.zzm();
                                                    zzitVarZzm14.zzb(((zzpn) listZzn.get(i2)).zzc);
                                                    zzitVarZzm14.zza(((zzpn) listZzn.get(i2)).zzd);
                                                    zzp().zzc(zzitVarZzm14, ((zzpn) listZzn.get(i2)).zze);
                                                    zzicVarZzaE.zzp(zzitVarZzm14);
                                                    if (!"_sid".equals(((zzpn) listZzn.get(i2)).zzc)) {
                                                    }
                                                }
                                                zzavVarZzj3 = zzj();
                                                com.google.android.gms.internal.measurement.zzid zzidVar14 = (com.google.android.gms.internal.measurement.zzid) zzicVarZzaE.zzbc();
                                                zzavVarZzj3.zzg();
                                                zzavVarZzj3.zzaw();
                                                Preconditions.checkNotNull(zzidVar14);
                                                Preconditions.checkNotEmpty(zzidVar14.zzA());
                                                byte[] bArrZzcc117 = zzidVar14.zzcc();
                                                long jZzt14 = zzavVarZzj3.zzg.zzp().zzt(bArrZzcc117);
                                                ContentValues contentValues15 = new ContentValues();
                                                String str21111119 = str14;
                                                contentValues15.put(str21111119, zzidVar14.zzA());
                                                contentValues15.put("metadata_fingerprint", Long.valueOf(jZzt14));
                                                contentValues15.put("metadata", bArrZzcc117);
                                                zzavVarZzj3.zze().insertWithOnConflict("raw_events_metadata", null, contentValues15, 4);
                                                zzavVarZzj4 = zzj();
                                                zzbdVar2 = new zzbd(zzbbVar.zzf);
                                                while (true) {
                                                    if (zzbdVar2.hasNext()) {
                                                        zzht zzhtVarZzh15 = zzh();
                                                        String str211111110 = zzbbVar.zza;
                                                        zZzk = zzhtVarZzh15.zzk(str211111110, zzbbVar.zzb);
                                                        zzar zzarVarZzw14 = zzj().zzw(zzC(), str211111110, false, false, false, false, false, false, false);
                                                        if (zZzk) {
                                                        }
                                                        i3 = 0;
                                                        break;
                                                    }
                                                    next = zzbdVar2.next();
                                                    String str211111111 = next;
                                                    if (str12.equals(next)) {
                                                    }
                                                    i3 = 1;
                                                    break;
                                                }
                                                zzavVarZzj4.zzg();
                                                zzavVarZzj4.zzaw();
                                                Preconditions.checkNotNull(zzbbVar);
                                                str13 = zzbbVar.zza;
                                                Preconditions.checkNotEmpty(str13);
                                                byte[] bArrZzcc118 = zzavVarZzj4.zzg.zzp().zzh(zzbbVar).zzcc();
                                                contentValues = new ContentValues();
                                                contentValues.put(str21111119, str13);
                                                contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbbVar.zzb);
                                                contentValues.put(ServerValues.NAME_OP_TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                                                contentValues.put("metadata_fingerprint", Long.valueOf(jZzt14));
                                                contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzcc118);
                                                contentValues.put("realtime", Integer.valueOf(i3));
                                                if (zzavVarZzj4.zze().insert(str4, null, contentValues) == -1) {
                                                    zzavVarZzj4.zzu.zzaV().zzb().zzb("Failed to insert raw event (got -1). appId", zzgu.zzl(str13));
                                                } else {
                                                    this.zza = 0L;
                                                }
                                                zzj().zzc();
                                                zzj().zzd();
                                                zzaL();
                                                zzaV().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                                return;
                                            }
                                            if (jMax == 1) {
                                                zzaV().zzb().zzc("Too many error events logged. appId, count", zzgu.zzl(str16), Long.valueOf(zzarVarZzx.zzd));
                                            }
                                            zzj().zzc();
                                        }
                                    } else {
                                        if (zEquals) {
                                            bundleZzf = zzbeVar2.zzf();
                                            zzpp zzppVarZzt15 = zzt();
                                            String str211111112 = zzbgVar2.zzc;
                                            zzppVarZzt15.zzM(bundleZzf, "_o", str211111112);
                                            if (zzt().zzaa(str16, zzrVar.zzB)) {
                                                zzt().zzM(bundleZzf, "_dbg", 1L);
                                                zzt().zzM(bundleZzf, "_r", 1L);
                                            }
                                            if ("_s".equals(str2)) {
                                                obj2 = zzpnVarZzm2.zze;
                                                if (obj2 instanceof Long) {
                                                    zzt().zzM(bundleZzf, "_sno", obj2);
                                                }
                                            }
                                            if (zzd().zzp(null, zzfy.zzaX)) {
                                                obj = bundleZzf.get("value");
                                                if (obj instanceof String) {
                                                    double d15 = Double.parseDouble((String) obj);
                                                    bundleZzf.remove("value");
                                                    bundleZzf.putDouble("value", d15);
                                                }
                                            }
                                            zzavVarZzj2 = zzj();
                                            Preconditions.checkNotEmpty(str16);
                                            zzavVarZzj2.zzg();
                                            zzavVarZzj2.zzaw();
                                            str3 = r6;
                                            jDelete = zzavVarZzj2.zze().delete(str3, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str16, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzavVarZzj2.zzu.zzc().zzm(str16, zzfy.zzp))))});
                                            if (jDelete > 0) {
                                                zzaV().zze().zzc("Data lost. Too many events stored on disk, deleted. appId", zzgu.zzl(str16), Long.valueOf(jDelete));
                                            }
                                            zzicVar = this.zzn;
                                            str4 = str3;
                                            zzbbVar = new zzbb(zzicVar, zzbgVar2.zzc, str16, zzbgVar2.zza, zzbgVar2.zzd, 0L, bundleZzf);
                                            zzav zzavVarZzj19 = zzj();
                                            str5 = zzbbVar.zzb;
                                            zzbcVarZzf = zzavVarZzj19.zzf(str16, str5);
                                            if (zzbcVarZzf != null) {
                                                if (zzj().zzS(str16) >= zzd().zzh(str16)) {
                                                }
                                                zzbcVarZza = new zzbc(str16, str5, 0L, 0L, 0L, zzbbVar.zzd, 0L, null, null, null, null);
                                            } else {
                                                zzbbVar = zzbbVar.zza(zzicVar, zzbcVarZzf.zzf);
                                                zzbcVarZza = zzbcVarZzf.zza(zzbbVar.zzd);
                                            }
                                            zzj().zzh(zzbcVarZza);
                                            zzaW().zzg();
                                            zzu();
                                            Preconditions.checkNotNull(zzbbVar);
                                            Preconditions.checkNotNull(zzrVar);
                                            String str211111113 = zzbbVar.zza;
                                            Preconditions.checkNotEmpty(str211111113);
                                            str6 = zzrVar.zza;
                                            Preconditions.checkArgument(str211111113.equals(str6));
                                            zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                                            boolean z16 = true;
                                            zzicVarZzaE.zza(1);
                                            zzicVarZzaE.zzC("android");
                                            if (!TextUtils.isEmpty(str6)) {
                                                zzicVarZzaE.zzL(str6);
                                            }
                                            str7 = zzrVar.zzd;
                                            if (!TextUtils.isEmpty(str7)) {
                                                zzicVarZzaE.zzJ(str7);
                                            }
                                            str8 = zzrVar.zzc;
                                            if (!TextUtils.isEmpty(str8)) {
                                                zzicVarZzaE.zzM(str8);
                                            }
                                            str9 = zzrVar.zzu;
                                            if (!TextUtils.isEmpty(str9)) {
                                                zzicVarZzaE.zzau(str9);
                                            }
                                            j = zzrVar.zzj;
                                            if (j != -2147483648L) {
                                                zzicVarZzaE.zzaj((int) j);
                                            }
                                            zzicVarZzaE.zzN(zzrVar.zze);
                                            str10 = zzrVar.zzb;
                                            if (!TextUtils.isEmpty(str10)) {
                                                zzicVarZzaE.zzad(str10);
                                            }
                                            zzjl zzjlVarZzs16 = zzB((String) Preconditions.checkNotNull(str6)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                            zzicVarZzaE.zzat(zzjlVarZzs16.zzk());
                                            zzqp.zza();
                                            if (!zzd().zzp(str6, zzfy.zzaP)) {
                                            }
                                            j2 = zzrVar.zzf;
                                            if (j2 != 0) {
                                                zzicVarZzaE.zzY(j2);
                                            }
                                            zzicVarZzaE.zzar(zzrVar.zzq);
                                            zzpk zzpkVarZzp15 = zzp();
                                            zzjrVarZza = com.google.android.gms.internal.measurement.zzjr.zza(zzpkVarZzp15.zzg.zzn.zzaY().getContentResolver(), com.google.android.gms.internal.measurement.zzkb.zza("com.google.android.gms.measurement"), zzfu.zza);
                                            if (zzjrVarZza == null) {
                                                mapZzb = Collections.emptyMap();
                                            } else {
                                                mapZzb = zzjrVarZza.zzb();
                                            }
                                            if (mapZzb != null) {
                                                arrayList = null;
                                            } else {
                                                arrayList = null;
                                            }
                                            if (arrayList != null) {
                                                zzicVarZzaE.zzaq(arrayList);
                                            }
                                            if (zzd().zzp(null, zzfy.zzba)) {
                                                zzicVarZzaE.zzaP("");
                                            }
                                            str11 = zzrVar.zza;
                                            zzjlVarZzs = zzB((String) Preconditions.checkNotNull(str11)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                            zzjkVar = zzjk.AD_STORAGE;
                                            if (zzjlVarZzs.zzo(zzjkVar)) {
                                                zzjlVarZzs = zzjlVarZzs;
                                                zzjkVar = zzjkVar;
                                                str12 = "_r";
                                            } else {
                                                zzjlVarZzs = zzjlVarZzs;
                                                zzjkVar = zzjkVar;
                                                str12 = "_r";
                                            }
                                            zzicVar2 = this.zzn;
                                            zzicVar2.zzu().zzw();
                                            zzicVarZzaE.zzF(Build.MODEL);
                                            zzicVar2.zzu().zzw();
                                            zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                                            zzicVarZzaE.zzI((int) zzicVar2.zzu().zzb());
                                            zzicVarZzaE.zzH(zzicVar2.zzu().zzc());
                                            zzicVarZzaE.zzay(zzrVar.zzw);
                                            if (zzicVar2.zzB()) {
                                                zzicVarZzaE.zzK();
                                                if (!TextUtils.isEmpty(null)) {
                                                    zzicVarZzaE.zzam(null);
                                                }
                                            }
                                            zzhVarZzu = zzj().zzu(str11);
                                            if (zzhVarZzu == null) {
                                                zzhVarZzu = new zzh(zzicVar2, str11);
                                                zzhVarZzu.zze(zzK(zzjlVarZzs));
                                                zzhVarZzu.zzm(zzrVar.zzk);
                                                zzhVarZzu.zzg(zzrVar.zzb);
                                                if (zzjlVarZzs.zzo(zzjkVar)) {
                                                    zzhVarZzu.zzk(this.zzk.zzf(str11, zzrVar.zzn));
                                                }
                                                zzhVarZzu.zzF(0L);
                                                zzhVarZzu.zzo(0L);
                                                zzhVarZzu.zzq(0L);
                                                zzhVarZzu.zzs(zzrVar.zzc);
                                                zzhVarZzu.zzu(zzrVar.zzj);
                                                zzhVarZzu.zzw(zzrVar.zzd);
                                                zzhVarZzu.zzy(zzrVar.zze);
                                                zzhVarZzu.zzA(zzrVar.zzf);
                                                zzhVarZzu.zzE(zzrVar.zzh);
                                                zzhVarZzu.zzC(zzrVar.zzq);
                                                i = 0;
                                                zzj().zzv(zzhVarZzu, false, false);
                                            } else {
                                                i = 0;
                                            }
                                            if (zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                                                zzicVarZzaE.zzW((String) Preconditions.checkNotNull(zzhVarZzu.zzd()));
                                            }
                                            if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                                zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                                            }
                                            listZzn = zzj().zzn(str11);
                                            while (i2 < listZzn.size()) {
                                                com.google.android.gms.internal.measurement.zzit zzitVarZzm15 = com.google.android.gms.internal.measurement.zziu.zzm();
                                                zzitVarZzm15.zzb(((zzpn) listZzn.get(i2)).zzc);
                                                zzitVarZzm15.zza(((zzpn) listZzn.get(i2)).zzd);
                                                zzp().zzc(zzitVarZzm15, ((zzpn) listZzn.get(i2)).zze);
                                                zzicVarZzaE.zzp(zzitVarZzm15);
                                                if (!"_sid".equals(((zzpn) listZzn.get(i2)).zzc)) {
                                                }
                                            }
                                            zzavVarZzj3 = zzj();
                                            com.google.android.gms.internal.measurement.zzid zzidVar15 = (com.google.android.gms.internal.measurement.zzid) zzicVarZzaE.zzbc();
                                            zzavVarZzj3.zzg();
                                            zzavVarZzj3.zzaw();
                                            Preconditions.checkNotNull(zzidVar15);
                                            Preconditions.checkNotEmpty(zzidVar15.zzA());
                                            byte[] bArrZzcc119 = zzidVar15.zzcc();
                                            long jZzt15 = zzavVarZzj3.zzg.zzp().zzt(bArrZzcc119);
                                            ContentValues contentValues16 = new ContentValues();
                                            String str211111114 = str14;
                                            contentValues16.put(str211111114, zzidVar15.zzA());
                                            contentValues16.put("metadata_fingerprint", Long.valueOf(jZzt15));
                                            contentValues16.put("metadata", bArrZzcc119);
                                            zzavVarZzj3.zze().insertWithOnConflict("raw_events_metadata", null, contentValues16, 4);
                                            zzavVarZzj4 = zzj();
                                            zzbdVar2 = new zzbd(zzbbVar.zzf);
                                            while (true) {
                                                if (zzbdVar2.hasNext()) {
                                                    zzht zzhtVarZzh16 = zzh();
                                                    String str211111115 = zzbbVar.zza;
                                                    zZzk = zzhtVarZzh16.zzk(str211111115, zzbbVar.zzb);
                                                    zzar zzarVarZzw15 = zzj().zzw(zzC(), str211111115, false, false, false, false, false, false, false);
                                                    if (zZzk) {
                                                    }
                                                    i3 = 0;
                                                    break;
                                                }
                                                next = zzbdVar2.next();
                                                String str211111116 = next;
                                                if (str12.equals(next)) {
                                                }
                                                i3 = 1;
                                                break;
                                            }
                                            zzavVarZzj4.zzg();
                                            zzavVarZzj4.zzaw();
                                            Preconditions.checkNotNull(zzbbVar);
                                            str13 = zzbbVar.zza;
                                            Preconditions.checkNotEmpty(str13);
                                            byte[] bArrZzcc1110 = zzavVarZzj4.zzg.zzp().zzh(zzbbVar).zzcc();
                                            contentValues = new ContentValues();
                                            contentValues.put(str211111114, str13);
                                            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbbVar.zzb);
                                            contentValues.put(ServerValues.NAME_OP_TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                                            contentValues.put("metadata_fingerprint", Long.valueOf(jZzt15));
                                            contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzcc1110);
                                            contentValues.put("realtime", Integer.valueOf(i3));
                                            if (zzavVarZzj4.zze().insert(str4, null, contentValues) == -1) {
                                                zzavVarZzj4.zzu.zzaV().zzb().zzb("Failed to insert raw event (got -1). appId", zzgu.zzl(str13));
                                            } else {
                                                this.zza = 0L;
                                            }
                                            zzj().zzc();
                                            zzj().zzd();
                                            zzaL();
                                            zzaV().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                            return;
                                        }
                                        jMax = zzarVarZzx.zzd - ((long) Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzd().zzm(zzrVar.zza, zzfy.zzl))));
                                        if (jMax > 0) {
                                            bundleZzf = zzbeVar2.zzf();
                                            zzpp zzppVarZzt16 = zzt();
                                            String str211111117 = zzbgVar2.zzc;
                                            zzppVarZzt16.zzM(bundleZzf, "_o", str211111117);
                                            if (zzt().zzaa(str16, zzrVar.zzB)) {
                                                zzt().zzM(bundleZzf, "_dbg", 1L);
                                                zzt().zzM(bundleZzf, "_r", 1L);
                                            }
                                            if ("_s".equals(str2)) {
                                                obj2 = zzpnVarZzm2.zze;
                                                if (obj2 instanceof Long) {
                                                    zzt().zzM(bundleZzf, "_sno", obj2);
                                                }
                                            }
                                            if (zzd().zzp(null, zzfy.zzaX)) {
                                                obj = bundleZzf.get("value");
                                                if (obj instanceof String) {
                                                    double d16 = Double.parseDouble((String) obj);
                                                    bundleZzf.remove("value");
                                                    bundleZzf.putDouble("value", d16);
                                                }
                                            }
                                            zzavVarZzj2 = zzj();
                                            Preconditions.checkNotEmpty(str16);
                                            zzavVarZzj2.zzg();
                                            zzavVarZzj2.zzaw();
                                            str3 = r6;
                                            jDelete = zzavVarZzj2.zze().delete(str3, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str16, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzavVarZzj2.zzu.zzc().zzm(str16, zzfy.zzp))))});
                                            if (jDelete > 0) {
                                                zzaV().zze().zzc("Data lost. Too many events stored on disk, deleted. appId", zzgu.zzl(str16), Long.valueOf(jDelete));
                                            }
                                            zzicVar = this.zzn;
                                            str4 = str3;
                                            zzbbVar = new zzbb(zzicVar, zzbgVar2.zzc, str16, zzbgVar2.zza, zzbgVar2.zzd, 0L, bundleZzf);
                                            zzav zzavVarZzj110 = zzj();
                                            str5 = zzbbVar.zzb;
                                            zzbcVarZzf = zzavVarZzj110.zzf(str16, str5);
                                            if (zzbcVarZzf != null) {
                                                if (zzj().zzS(str16) >= zzd().zzh(str16)) {
                                                }
                                                zzbcVarZza = new zzbc(str16, str5, 0L, 0L, 0L, zzbbVar.zzd, 0L, null, null, null, null);
                                            } else {
                                                zzbbVar = zzbbVar.zza(zzicVar, zzbcVarZzf.zzf);
                                                zzbcVarZza = zzbcVarZzf.zza(zzbbVar.zzd);
                                            }
                                            zzj().zzh(zzbcVarZza);
                                            zzaW().zzg();
                                            zzu();
                                            Preconditions.checkNotNull(zzbbVar);
                                            Preconditions.checkNotNull(zzrVar);
                                            String str211111118 = zzbbVar.zza;
                                            Preconditions.checkNotEmpty(str211111118);
                                            str6 = zzrVar.zza;
                                            Preconditions.checkArgument(str211111118.equals(str6));
                                            zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                                            boolean z17 = true;
                                            zzicVarZzaE.zza(1);
                                            zzicVarZzaE.zzC("android");
                                            if (!TextUtils.isEmpty(str6)) {
                                                zzicVarZzaE.zzL(str6);
                                            }
                                            str7 = zzrVar.zzd;
                                            if (!TextUtils.isEmpty(str7)) {
                                                zzicVarZzaE.zzJ(str7);
                                            }
                                            str8 = zzrVar.zzc;
                                            if (!TextUtils.isEmpty(str8)) {
                                                zzicVarZzaE.zzM(str8);
                                            }
                                            str9 = zzrVar.zzu;
                                            if (!TextUtils.isEmpty(str9)) {
                                                zzicVarZzaE.zzau(str9);
                                            }
                                            j = zzrVar.zzj;
                                            if (j != -2147483648L) {
                                                zzicVarZzaE.zzaj((int) j);
                                            }
                                            zzicVarZzaE.zzN(zzrVar.zze);
                                            str10 = zzrVar.zzb;
                                            if (!TextUtils.isEmpty(str10)) {
                                                zzicVarZzaE.zzad(str10);
                                            }
                                            zzjl zzjlVarZzs17 = zzB((String) Preconditions.checkNotNull(str6)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                            zzicVarZzaE.zzat(zzjlVarZzs17.zzk());
                                            zzqp.zza();
                                            if (!zzd().zzp(str6, zzfy.zzaP)) {
                                            }
                                            j2 = zzrVar.zzf;
                                            if (j2 != 0) {
                                                zzicVarZzaE.zzY(j2);
                                            }
                                            zzicVarZzaE.zzar(zzrVar.zzq);
                                            zzpk zzpkVarZzp16 = zzp();
                                            zzjrVarZza = com.google.android.gms.internal.measurement.zzjr.zza(zzpkVarZzp16.zzg.zzn.zzaY().getContentResolver(), com.google.android.gms.internal.measurement.zzkb.zza("com.google.android.gms.measurement"), zzfu.zza);
                                            if (zzjrVarZza == null) {
                                                mapZzb = Collections.emptyMap();
                                            } else {
                                                mapZzb = zzjrVarZza.zzb();
                                            }
                                            if (mapZzb != null) {
                                                arrayList = null;
                                            } else {
                                                arrayList = null;
                                            }
                                            if (arrayList != null) {
                                                zzicVarZzaE.zzaq(arrayList);
                                            }
                                            if (zzd().zzp(null, zzfy.zzba)) {
                                                zzicVarZzaE.zzaP("");
                                            }
                                            str11 = zzrVar.zza;
                                            zzjlVarZzs = zzB((String) Preconditions.checkNotNull(str11)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                            zzjkVar = zzjk.AD_STORAGE;
                                            if (zzjlVarZzs.zzo(zzjkVar)) {
                                                zzjlVarZzs = zzjlVarZzs;
                                                zzjkVar = zzjkVar;
                                                str12 = "_r";
                                            } else {
                                                zzjlVarZzs = zzjlVarZzs;
                                                zzjkVar = zzjkVar;
                                                str12 = "_r";
                                            }
                                            zzicVar2 = this.zzn;
                                            zzicVar2.zzu().zzw();
                                            zzicVarZzaE.zzF(Build.MODEL);
                                            zzicVar2.zzu().zzw();
                                            zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                                            zzicVarZzaE.zzI((int) zzicVar2.zzu().zzb());
                                            zzicVarZzaE.zzH(zzicVar2.zzu().zzc());
                                            zzicVarZzaE.zzay(zzrVar.zzw);
                                            if (zzicVar2.zzB()) {
                                                zzicVarZzaE.zzK();
                                                if (!TextUtils.isEmpty(null)) {
                                                    zzicVarZzaE.zzam(null);
                                                }
                                            }
                                            zzhVarZzu = zzj().zzu(str11);
                                            if (zzhVarZzu == null) {
                                                zzhVarZzu = new zzh(zzicVar2, str11);
                                                zzhVarZzu.zze(zzK(zzjlVarZzs));
                                                zzhVarZzu.zzm(zzrVar.zzk);
                                                zzhVarZzu.zzg(zzrVar.zzb);
                                                if (zzjlVarZzs.zzo(zzjkVar)) {
                                                    zzhVarZzu.zzk(this.zzk.zzf(str11, zzrVar.zzn));
                                                }
                                                zzhVarZzu.zzF(0L);
                                                zzhVarZzu.zzo(0L);
                                                zzhVarZzu.zzq(0L);
                                                zzhVarZzu.zzs(zzrVar.zzc);
                                                zzhVarZzu.zzu(zzrVar.zzj);
                                                zzhVarZzu.zzw(zzrVar.zzd);
                                                zzhVarZzu.zzy(zzrVar.zze);
                                                zzhVarZzu.zzA(zzrVar.zzf);
                                                zzhVarZzu.zzE(zzrVar.zzh);
                                                zzhVarZzu.zzC(zzrVar.zzq);
                                                i = 0;
                                                zzj().zzv(zzhVarZzu, false, false);
                                            } else {
                                                i = 0;
                                            }
                                            if (zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                                                zzicVarZzaE.zzW((String) Preconditions.checkNotNull(zzhVarZzu.zzd()));
                                            }
                                            if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                                zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                                            }
                                            listZzn = zzj().zzn(str11);
                                            while (i2 < listZzn.size()) {
                                                com.google.android.gms.internal.measurement.zzit zzitVarZzm16 = com.google.android.gms.internal.measurement.zziu.zzm();
                                                zzitVarZzm16.zzb(((zzpn) listZzn.get(i2)).zzc);
                                                zzitVarZzm16.zza(((zzpn) listZzn.get(i2)).zzd);
                                                zzp().zzc(zzitVarZzm16, ((zzpn) listZzn.get(i2)).zze);
                                                zzicVarZzaE.zzp(zzitVarZzm16);
                                                if (!"_sid".equals(((zzpn) listZzn.get(i2)).zzc)) {
                                                }
                                            }
                                            zzavVarZzj3 = zzj();
                                            com.google.android.gms.internal.measurement.zzid zzidVar16 = (com.google.android.gms.internal.measurement.zzid) zzicVarZzaE.zzbc();
                                            zzavVarZzj3.zzg();
                                            zzavVarZzj3.zzaw();
                                            Preconditions.checkNotNull(zzidVar16);
                                            Preconditions.checkNotEmpty(zzidVar16.zzA());
                                            byte[] bArrZzcc1111 = zzidVar16.zzcc();
                                            long jZzt16 = zzavVarZzj3.zzg.zzp().zzt(bArrZzcc1111);
                                            ContentValues contentValues17 = new ContentValues();
                                            String str211111119 = str14;
                                            contentValues17.put(str211111119, zzidVar16.zzA());
                                            contentValues17.put("metadata_fingerprint", Long.valueOf(jZzt16));
                                            contentValues17.put("metadata", bArrZzcc1111);
                                            zzavVarZzj3.zze().insertWithOnConflict("raw_events_metadata", null, contentValues17, 4);
                                            zzavVarZzj4 = zzj();
                                            zzbdVar2 = new zzbd(zzbbVar.zzf);
                                            while (true) {
                                                if (zzbdVar2.hasNext()) {
                                                    zzht zzhtVarZzh17 = zzh();
                                                    String str2111111110 = zzbbVar.zza;
                                                    zZzk = zzhtVarZzh17.zzk(str2111111110, zzbbVar.zzb);
                                                    zzar zzarVarZzw16 = zzj().zzw(zzC(), str2111111110, false, false, false, false, false, false, false);
                                                    if (zZzk) {
                                                    }
                                                    i3 = 0;
                                                    break;
                                                }
                                                next = zzbdVar2.next();
                                                String str2111111111 = next;
                                                if (str12.equals(next)) {
                                                }
                                                i3 = 1;
                                                break;
                                            }
                                            zzavVarZzj4.zzg();
                                            zzavVarZzj4.zzaw();
                                            Preconditions.checkNotNull(zzbbVar);
                                            str13 = zzbbVar.zza;
                                            Preconditions.checkNotEmpty(str13);
                                            byte[] bArrZzcc1112 = zzavVarZzj4.zzg.zzp().zzh(zzbbVar).zzcc();
                                            contentValues = new ContentValues();
                                            contentValues.put(str211111119, str13);
                                            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbbVar.zzb);
                                            contentValues.put(ServerValues.NAME_OP_TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                                            contentValues.put("metadata_fingerprint", Long.valueOf(jZzt16));
                                            contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzcc1112);
                                            contentValues.put("realtime", Integer.valueOf(i3));
                                            if (zzavVarZzj4.zze().insert(str4, null, contentValues) == -1) {
                                                zzavVarZzj4.zzu.zzaV().zzb().zzb("Failed to insert raw event (got -1). appId", zzgu.zzl(str13));
                                            } else {
                                                this.zza = 0L;
                                            }
                                            zzj().zzc();
                                            zzj().zzd();
                                            zzaL();
                                            zzaV().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                            return;
                                        }
                                        if (jMax == 1) {
                                            zzaV().zzb().zzc("Too many error events logged. appId, count", zzgu.zzl(str16), Long.valueOf(zzarVarZzx.zzd));
                                        }
                                        zzj().zzc();
                                    }
                                }
                            }
                        }
                        str = str;
                    } else {
                        str14 = "app_id";
                        str15 = "_fx";
                        str = "_err";
                    }
                    str2 = zzbgVarZzb.zza;
                    zZzh = zzpp.zzh(str2);
                    zEquals = str.equals(str2);
                    zzt();
                    zzbeVar2 = zzbgVarZzb.zzb;
                    if (zzbeVar2 == null) {
                        length = 0;
                    } else {
                        zzbdVar = new zzbd(zzbeVar2);
                        length = 0;
                        while (zzbdVar.hasNext()) {
                            String next6 = zzbdVar.next();
                            String str223 = next6;
                            objZza = zzbeVar2.zza(next6);
                            if (objZza instanceof Parcelable[]) {
                                length += (long) ((Parcelable[]) objZza).length;
                            }
                        }
                    }
                    zzbgVar2 = zzbgVarZzb;
                    zzarVarZzx = zzj().zzx(zzC(), str16, length + 1, true, zZzh, false, zEquals, false, false, false);
                    long j12 = zzarVarZzx.zzb;
                    zzd();
                    jZzH = j12 - zzal.zzH();
                    if (jZzH > 0) {
                        if (jZzH % 1000 == 1) {
                            zzaV().zzb().zzc("Data loss. Too many events logged. appId, count", zzgu.zzl(str16), Long.valueOf(zzarVarZzx.zzb));
                        }
                        zzj().zzc();
                    } else if (zZzh) {
                        long j13 = zzarVarZzx.zza;
                        zzd();
                        jIntValue = j13 - ((long) ((Integer) zzfy.zzm.zzb(null)).intValue());
                        if (jIntValue > 0) {
                            if (jIntValue % 1000 == 1) {
                                zzaV().zzb().zzc("Data loss. Too many public events logged. appId, count", zzgu.zzl(str16), Long.valueOf(zzarVarZzx.zza));
                            }
                            zzt().zzN(this.zzK, str16, 16, "_ev", zzbgVar2.zza, 0);
                            zzj().zzc();
                        } else {
                            if (zEquals) {
                                bundleZzf = zzbeVar2.zzf();
                                zzpp zzppVarZzt17 = zzt();
                                String str2111111112 = zzbgVar2.zzc;
                                zzppVarZzt17.zzM(bundleZzf, "_o", str2111111112);
                                if (zzt().zzaa(str16, zzrVar.zzB)) {
                                    zzt().zzM(bundleZzf, "_dbg", 1L);
                                    zzt().zzM(bundleZzf, "_r", 1L);
                                }
                                if ("_s".equals(str2)) {
                                    obj2 = zzpnVarZzm2.zze;
                                    if (obj2 instanceof Long) {
                                        zzt().zzM(bundleZzf, "_sno", obj2);
                                    }
                                }
                                if (zzd().zzp(null, zzfy.zzaX)) {
                                    obj = bundleZzf.get("value");
                                    if (obj instanceof String) {
                                        double d17 = Double.parseDouble((String) obj);
                                        bundleZzf.remove("value");
                                        bundleZzf.putDouble("value", d17);
                                    }
                                }
                                zzavVarZzj2 = zzj();
                                Preconditions.checkNotEmpty(str16);
                                zzavVarZzj2.zzg();
                                zzavVarZzj2.zzaw();
                                str3 = r6;
                                jDelete = zzavVarZzj2.zze().delete(str3, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str16, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzavVarZzj2.zzu.zzc().zzm(str16, zzfy.zzp))))});
                                if (jDelete > 0) {
                                    zzaV().zze().zzc("Data lost. Too many events stored on disk, deleted. appId", zzgu.zzl(str16), Long.valueOf(jDelete));
                                }
                                zzicVar = this.zzn;
                                str4 = str3;
                                zzbbVar = new zzbb(zzicVar, zzbgVar2.zzc, str16, zzbgVar2.zza, zzbgVar2.zzd, 0L, bundleZzf);
                                zzav zzavVarZzj111 = zzj();
                                str5 = zzbbVar.zzb;
                                zzbcVarZzf = zzavVarZzj111.zzf(str16, str5);
                                if (zzbcVarZzf != null) {
                                    if (zzj().zzS(str16) >= zzd().zzh(str16)) {
                                    }
                                    zzbcVarZza = new zzbc(str16, str5, 0L, 0L, 0L, zzbbVar.zzd, 0L, null, null, null, null);
                                } else {
                                    zzbbVar = zzbbVar.zza(zzicVar, zzbcVarZzf.zzf);
                                    zzbcVarZza = zzbcVarZzf.zza(zzbbVar.zzd);
                                }
                                zzj().zzh(zzbcVarZza);
                                zzaW().zzg();
                                zzu();
                                Preconditions.checkNotNull(zzbbVar);
                                Preconditions.checkNotNull(zzrVar);
                                String str2111111113 = zzbbVar.zza;
                                Preconditions.checkNotEmpty(str2111111113);
                                str6 = zzrVar.zza;
                                Preconditions.checkArgument(str2111111113.equals(str6));
                                zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                                boolean z18 = true;
                                zzicVarZzaE.zza(1);
                                zzicVarZzaE.zzC("android");
                                if (!TextUtils.isEmpty(str6)) {
                                    zzicVarZzaE.zzL(str6);
                                }
                                str7 = zzrVar.zzd;
                                if (!TextUtils.isEmpty(str7)) {
                                    zzicVarZzaE.zzJ(str7);
                                }
                                str8 = zzrVar.zzc;
                                if (!TextUtils.isEmpty(str8)) {
                                    zzicVarZzaE.zzM(str8);
                                }
                                str9 = zzrVar.zzu;
                                if (!TextUtils.isEmpty(str9)) {
                                    zzicVarZzaE.zzau(str9);
                                }
                                j = zzrVar.zzj;
                                if (j != -2147483648L) {
                                    zzicVarZzaE.zzaj((int) j);
                                }
                                zzicVarZzaE.zzN(zzrVar.zze);
                                str10 = zzrVar.zzb;
                                if (!TextUtils.isEmpty(str10)) {
                                    zzicVarZzaE.zzad(str10);
                                }
                                zzjl zzjlVarZzs18 = zzB((String) Preconditions.checkNotNull(str6)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                zzicVarZzaE.zzat(zzjlVarZzs18.zzk());
                                zzqp.zza();
                                if (!zzd().zzp(str6, zzfy.zzaP)) {
                                }
                                j2 = zzrVar.zzf;
                                if (j2 != 0) {
                                    zzicVarZzaE.zzY(j2);
                                }
                                zzicVarZzaE.zzar(zzrVar.zzq);
                                zzpk zzpkVarZzp17 = zzp();
                                zzjrVarZza = com.google.android.gms.internal.measurement.zzjr.zza(zzpkVarZzp17.zzg.zzn.zzaY().getContentResolver(), com.google.android.gms.internal.measurement.zzkb.zza("com.google.android.gms.measurement"), zzfu.zza);
                                if (zzjrVarZza == null) {
                                    mapZzb = Collections.emptyMap();
                                } else {
                                    mapZzb = zzjrVarZza.zzb();
                                }
                                if (mapZzb != null) {
                                    arrayList = null;
                                } else {
                                    arrayList = null;
                                }
                                if (arrayList != null) {
                                    zzicVarZzaE.zzaq(arrayList);
                                }
                                if (zzd().zzp(null, zzfy.zzba)) {
                                    zzicVarZzaE.zzaP("");
                                }
                                str11 = zzrVar.zza;
                                zzjlVarZzs = zzB((String) Preconditions.checkNotNull(str11)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                zzjkVar = zzjk.AD_STORAGE;
                                if (zzjlVarZzs.zzo(zzjkVar)) {
                                    zzjlVarZzs = zzjlVarZzs;
                                    zzjkVar = zzjkVar;
                                    str12 = "_r";
                                } else {
                                    zzjlVarZzs = zzjlVarZzs;
                                    zzjkVar = zzjkVar;
                                    str12 = "_r";
                                }
                                zzicVar2 = this.zzn;
                                zzicVar2.zzu().zzw();
                                zzicVarZzaE.zzF(Build.MODEL);
                                zzicVar2.zzu().zzw();
                                zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                                zzicVarZzaE.zzI((int) zzicVar2.zzu().zzb());
                                zzicVarZzaE.zzH(zzicVar2.zzu().zzc());
                                zzicVarZzaE.zzay(zzrVar.zzw);
                                if (zzicVar2.zzB()) {
                                    zzicVarZzaE.zzK();
                                    if (!TextUtils.isEmpty(null)) {
                                        zzicVarZzaE.zzam(null);
                                    }
                                }
                                zzhVarZzu = zzj().zzu(str11);
                                if (zzhVarZzu == null) {
                                    zzhVarZzu = new zzh(zzicVar2, str11);
                                    zzhVarZzu.zze(zzK(zzjlVarZzs));
                                    zzhVarZzu.zzm(zzrVar.zzk);
                                    zzhVarZzu.zzg(zzrVar.zzb);
                                    if (zzjlVarZzs.zzo(zzjkVar)) {
                                        zzhVarZzu.zzk(this.zzk.zzf(str11, zzrVar.zzn));
                                    }
                                    zzhVarZzu.zzF(0L);
                                    zzhVarZzu.zzo(0L);
                                    zzhVarZzu.zzq(0L);
                                    zzhVarZzu.zzs(zzrVar.zzc);
                                    zzhVarZzu.zzu(zzrVar.zzj);
                                    zzhVarZzu.zzw(zzrVar.zzd);
                                    zzhVarZzu.zzy(zzrVar.zze);
                                    zzhVarZzu.zzA(zzrVar.zzf);
                                    zzhVarZzu.zzE(zzrVar.zzh);
                                    zzhVarZzu.zzC(zzrVar.zzq);
                                    i = 0;
                                    zzj().zzv(zzhVarZzu, false, false);
                                } else {
                                    i = 0;
                                }
                                if (zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                                    zzicVarZzaE.zzW((String) Preconditions.checkNotNull(zzhVarZzu.zzd()));
                                }
                                if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                    zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                                }
                                listZzn = zzj().zzn(str11);
                                while (i2 < listZzn.size()) {
                                    com.google.android.gms.internal.measurement.zzit zzitVarZzm17 = com.google.android.gms.internal.measurement.zziu.zzm();
                                    zzitVarZzm17.zzb(((zzpn) listZzn.get(i2)).zzc);
                                    zzitVarZzm17.zza(((zzpn) listZzn.get(i2)).zzd);
                                    zzp().zzc(zzitVarZzm17, ((zzpn) listZzn.get(i2)).zze);
                                    zzicVarZzaE.zzp(zzitVarZzm17);
                                    if (!"_sid".equals(((zzpn) listZzn.get(i2)).zzc)) {
                                    }
                                }
                                zzavVarZzj3 = zzj();
                                com.google.android.gms.internal.measurement.zzid zzidVar17 = (com.google.android.gms.internal.measurement.zzid) zzicVarZzaE.zzbc();
                                zzavVarZzj3.zzg();
                                zzavVarZzj3.zzaw();
                                Preconditions.checkNotNull(zzidVar17);
                                Preconditions.checkNotEmpty(zzidVar17.zzA());
                                byte[] bArrZzcc1113 = zzidVar17.zzcc();
                                long jZzt17 = zzavVarZzj3.zzg.zzp().zzt(bArrZzcc1113);
                                ContentValues contentValues18 = new ContentValues();
                                String str2111111114 = str14;
                                contentValues18.put(str2111111114, zzidVar17.zzA());
                                contentValues18.put("metadata_fingerprint", Long.valueOf(jZzt17));
                                contentValues18.put("metadata", bArrZzcc1113);
                                zzavVarZzj3.zze().insertWithOnConflict("raw_events_metadata", null, contentValues18, 4);
                                zzavVarZzj4 = zzj();
                                zzbdVar2 = new zzbd(zzbbVar.zzf);
                                while (true) {
                                    if (zzbdVar2.hasNext()) {
                                        zzht zzhtVarZzh18 = zzh();
                                        String str2111111115 = zzbbVar.zza;
                                        zZzk = zzhtVarZzh18.zzk(str2111111115, zzbbVar.zzb);
                                        zzar zzarVarZzw17 = zzj().zzw(zzC(), str2111111115, false, false, false, false, false, false, false);
                                        if (zZzk) {
                                        }
                                        i3 = 0;
                                        break;
                                    }
                                    next = zzbdVar2.next();
                                    String str2111111116 = next;
                                    if (str12.equals(next)) {
                                    }
                                    i3 = 1;
                                    break;
                                }
                                zzavVarZzj4.zzg();
                                zzavVarZzj4.zzaw();
                                Preconditions.checkNotNull(zzbbVar);
                                str13 = zzbbVar.zza;
                                Preconditions.checkNotEmpty(str13);
                                byte[] bArrZzcc1114 = zzavVarZzj4.zzg.zzp().zzh(zzbbVar).zzcc();
                                contentValues = new ContentValues();
                                contentValues.put(str2111111114, str13);
                                contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbbVar.zzb);
                                contentValues.put(ServerValues.NAME_OP_TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                                contentValues.put("metadata_fingerprint", Long.valueOf(jZzt17));
                                contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzcc1114);
                                contentValues.put("realtime", Integer.valueOf(i3));
                                if (zzavVarZzj4.zze().insert(str4, null, contentValues) == -1) {
                                    zzavVarZzj4.zzu.zzaV().zzb().zzb("Failed to insert raw event (got -1). appId", zzgu.zzl(str13));
                                } else {
                                    this.zza = 0L;
                                }
                                zzj().zzc();
                                zzj().zzd();
                                zzaL();
                                zzaV().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                return;
                            }
                            jMax = zzarVarZzx.zzd - ((long) Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzd().zzm(zzrVar.zza, zzfy.zzl))));
                            if (jMax > 0) {
                                bundleZzf = zzbeVar2.zzf();
                                zzpp zzppVarZzt18 = zzt();
                                String str2111111117 = zzbgVar2.zzc;
                                zzppVarZzt18.zzM(bundleZzf, "_o", str2111111117);
                                if (zzt().zzaa(str16, zzrVar.zzB)) {
                                    zzt().zzM(bundleZzf, "_dbg", 1L);
                                    zzt().zzM(bundleZzf, "_r", 1L);
                                }
                                if ("_s".equals(str2)) {
                                    obj2 = zzpnVarZzm2.zze;
                                    if (obj2 instanceof Long) {
                                        zzt().zzM(bundleZzf, "_sno", obj2);
                                    }
                                }
                                if (zzd().zzp(null, zzfy.zzaX)) {
                                    obj = bundleZzf.get("value");
                                    if (obj instanceof String) {
                                        double d18 = Double.parseDouble((String) obj);
                                        bundleZzf.remove("value");
                                        bundleZzf.putDouble("value", d18);
                                    }
                                }
                                zzavVarZzj2 = zzj();
                                Preconditions.checkNotEmpty(str16);
                                zzavVarZzj2.zzg();
                                zzavVarZzj2.zzaw();
                                str3 = r6;
                                jDelete = zzavVarZzj2.zze().delete(str3, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str16, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzavVarZzj2.zzu.zzc().zzm(str16, zzfy.zzp))))});
                                if (jDelete > 0) {
                                    zzaV().zze().zzc("Data lost. Too many events stored on disk, deleted. appId", zzgu.zzl(str16), Long.valueOf(jDelete));
                                }
                                zzicVar = this.zzn;
                                str4 = str3;
                                zzbbVar = new zzbb(zzicVar, zzbgVar2.zzc, str16, zzbgVar2.zza, zzbgVar2.zzd, 0L, bundleZzf);
                                zzav zzavVarZzj112 = zzj();
                                str5 = zzbbVar.zzb;
                                zzbcVarZzf = zzavVarZzj112.zzf(str16, str5);
                                if (zzbcVarZzf != null) {
                                    if (zzj().zzS(str16) >= zzd().zzh(str16)) {
                                    }
                                    zzbcVarZza = new zzbc(str16, str5, 0L, 0L, 0L, zzbbVar.zzd, 0L, null, null, null, null);
                                } else {
                                    zzbbVar = zzbbVar.zza(zzicVar, zzbcVarZzf.zzf);
                                    zzbcVarZza = zzbcVarZzf.zza(zzbbVar.zzd);
                                }
                                zzj().zzh(zzbcVarZza);
                                zzaW().zzg();
                                zzu();
                                Preconditions.checkNotNull(zzbbVar);
                                Preconditions.checkNotNull(zzrVar);
                                String str2111111118 = zzbbVar.zza;
                                Preconditions.checkNotEmpty(str2111111118);
                                str6 = zzrVar.zza;
                                Preconditions.checkArgument(str2111111118.equals(str6));
                                zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                                boolean z19 = true;
                                zzicVarZzaE.zza(1);
                                zzicVarZzaE.zzC("android");
                                if (!TextUtils.isEmpty(str6)) {
                                    zzicVarZzaE.zzL(str6);
                                }
                                str7 = zzrVar.zzd;
                                if (!TextUtils.isEmpty(str7)) {
                                    zzicVarZzaE.zzJ(str7);
                                }
                                str8 = zzrVar.zzc;
                                if (!TextUtils.isEmpty(str8)) {
                                    zzicVarZzaE.zzM(str8);
                                }
                                str9 = zzrVar.zzu;
                                if (!TextUtils.isEmpty(str9)) {
                                    zzicVarZzaE.zzau(str9);
                                }
                                j = zzrVar.zzj;
                                if (j != -2147483648L) {
                                    zzicVarZzaE.zzaj((int) j);
                                }
                                zzicVarZzaE.zzN(zzrVar.zze);
                                str10 = zzrVar.zzb;
                                if (!TextUtils.isEmpty(str10)) {
                                    zzicVarZzaE.zzad(str10);
                                }
                                zzjl zzjlVarZzs19 = zzB((String) Preconditions.checkNotNull(str6)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                zzicVarZzaE.zzat(zzjlVarZzs19.zzk());
                                zzqp.zza();
                                if (!zzd().zzp(str6, zzfy.zzaP)) {
                                }
                                j2 = zzrVar.zzf;
                                if (j2 != 0) {
                                    zzicVarZzaE.zzY(j2);
                                }
                                zzicVarZzaE.zzar(zzrVar.zzq);
                                zzpk zzpkVarZzp18 = zzp();
                                zzjrVarZza = com.google.android.gms.internal.measurement.zzjr.zza(zzpkVarZzp18.zzg.zzn.zzaY().getContentResolver(), com.google.android.gms.internal.measurement.zzkb.zza("com.google.android.gms.measurement"), zzfu.zza);
                                if (zzjrVarZza == null) {
                                    mapZzb = Collections.emptyMap();
                                } else {
                                    mapZzb = zzjrVarZza.zzb();
                                }
                                if (mapZzb != null) {
                                    arrayList = null;
                                } else {
                                    arrayList = null;
                                }
                                if (arrayList != null) {
                                    zzicVarZzaE.zzaq(arrayList);
                                }
                                if (zzd().zzp(null, zzfy.zzba)) {
                                    zzicVarZzaE.zzaP("");
                                }
                                str11 = zzrVar.zza;
                                zzjlVarZzs = zzB((String) Preconditions.checkNotNull(str11)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                                zzjkVar = zzjk.AD_STORAGE;
                                if (zzjlVarZzs.zzo(zzjkVar)) {
                                    zzjlVarZzs = zzjlVarZzs;
                                    zzjkVar = zzjkVar;
                                    str12 = "_r";
                                } else {
                                    zzjlVarZzs = zzjlVarZzs;
                                    zzjkVar = zzjkVar;
                                    str12 = "_r";
                                }
                                zzicVar2 = this.zzn;
                                zzicVar2.zzu().zzw();
                                zzicVarZzaE.zzF(Build.MODEL);
                                zzicVar2.zzu().zzw();
                                zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                                zzicVarZzaE.zzI((int) zzicVar2.zzu().zzb());
                                zzicVarZzaE.zzH(zzicVar2.zzu().zzc());
                                zzicVarZzaE.zzay(zzrVar.zzw);
                                if (zzicVar2.zzB()) {
                                    zzicVarZzaE.zzK();
                                    if (!TextUtils.isEmpty(null)) {
                                        zzicVarZzaE.zzam(null);
                                    }
                                }
                                zzhVarZzu = zzj().zzu(str11);
                                if (zzhVarZzu == null) {
                                    zzhVarZzu = new zzh(zzicVar2, str11);
                                    zzhVarZzu.zze(zzK(zzjlVarZzs));
                                    zzhVarZzu.zzm(zzrVar.zzk);
                                    zzhVarZzu.zzg(zzrVar.zzb);
                                    if (zzjlVarZzs.zzo(zzjkVar)) {
                                        zzhVarZzu.zzk(this.zzk.zzf(str11, zzrVar.zzn));
                                    }
                                    zzhVarZzu.zzF(0L);
                                    zzhVarZzu.zzo(0L);
                                    zzhVarZzu.zzq(0L);
                                    zzhVarZzu.zzs(zzrVar.zzc);
                                    zzhVarZzu.zzu(zzrVar.zzj);
                                    zzhVarZzu.zzw(zzrVar.zzd);
                                    zzhVarZzu.zzy(zzrVar.zze);
                                    zzhVarZzu.zzA(zzrVar.zzf);
                                    zzhVarZzu.zzE(zzrVar.zzh);
                                    zzhVarZzu.zzC(zzrVar.zzq);
                                    i = 0;
                                    zzj().zzv(zzhVarZzu, false, false);
                                } else {
                                    i = 0;
                                }
                                if (zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                                    zzicVarZzaE.zzW((String) Preconditions.checkNotNull(zzhVarZzu.zzd()));
                                }
                                if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                    zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                                }
                                listZzn = zzj().zzn(str11);
                                while (i2 < listZzn.size()) {
                                    com.google.android.gms.internal.measurement.zzit zzitVarZzm18 = com.google.android.gms.internal.measurement.zziu.zzm();
                                    zzitVarZzm18.zzb(((zzpn) listZzn.get(i2)).zzc);
                                    zzitVarZzm18.zza(((zzpn) listZzn.get(i2)).zzd);
                                    zzp().zzc(zzitVarZzm18, ((zzpn) listZzn.get(i2)).zze);
                                    zzicVarZzaE.zzp(zzitVarZzm18);
                                    if (!"_sid".equals(((zzpn) listZzn.get(i2)).zzc)) {
                                    }
                                }
                                zzavVarZzj3 = zzj();
                                com.google.android.gms.internal.measurement.zzid zzidVar18 = (com.google.android.gms.internal.measurement.zzid) zzicVarZzaE.zzbc();
                                zzavVarZzj3.zzg();
                                zzavVarZzj3.zzaw();
                                Preconditions.checkNotNull(zzidVar18);
                                Preconditions.checkNotEmpty(zzidVar18.zzA());
                                byte[] bArrZzcc1115 = zzidVar18.zzcc();
                                long jZzt18 = zzavVarZzj3.zzg.zzp().zzt(bArrZzcc1115);
                                ContentValues contentValues19 = new ContentValues();
                                String str2111111119 = str14;
                                contentValues19.put(str2111111119, zzidVar18.zzA());
                                contentValues19.put("metadata_fingerprint", Long.valueOf(jZzt18));
                                contentValues19.put("metadata", bArrZzcc1115);
                                zzavVarZzj3.zze().insertWithOnConflict("raw_events_metadata", null, contentValues19, 4);
                                zzavVarZzj4 = zzj();
                                zzbdVar2 = new zzbd(zzbbVar.zzf);
                                while (true) {
                                    if (zzbdVar2.hasNext()) {
                                        zzht zzhtVarZzh19 = zzh();
                                        String str21111111110 = zzbbVar.zza;
                                        zZzk = zzhtVarZzh19.zzk(str21111111110, zzbbVar.zzb);
                                        zzar zzarVarZzw18 = zzj().zzw(zzC(), str21111111110, false, false, false, false, false, false, false);
                                        if (zZzk) {
                                        }
                                        i3 = 0;
                                        break;
                                    }
                                    next = zzbdVar2.next();
                                    String str21111111111 = next;
                                    if (str12.equals(next)) {
                                    }
                                    i3 = 1;
                                    break;
                                }
                                zzavVarZzj4.zzg();
                                zzavVarZzj4.zzaw();
                                Preconditions.checkNotNull(zzbbVar);
                                str13 = zzbbVar.zza;
                                Preconditions.checkNotEmpty(str13);
                                byte[] bArrZzcc1116 = zzavVarZzj4.zzg.zzp().zzh(zzbbVar).zzcc();
                                contentValues = new ContentValues();
                                contentValues.put(str2111111119, str13);
                                contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbbVar.zzb);
                                contentValues.put(ServerValues.NAME_OP_TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                                contentValues.put("metadata_fingerprint", Long.valueOf(jZzt18));
                                contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzcc1116);
                                contentValues.put("realtime", Integer.valueOf(i3));
                                if (zzavVarZzj4.zze().insert(str4, null, contentValues) == -1) {
                                    zzavVarZzj4.zzu.zzaV().zzb().zzb("Failed to insert raw event (got -1). appId", zzgu.zzl(str13));
                                } else {
                                    this.zza = 0L;
                                }
                                zzj().zzc();
                                zzj().zzd();
                                zzaL();
                                zzaV().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                                return;
                            }
                            if (jMax == 1) {
                                zzaV().zzb().zzc("Too many error events logged. appId, count", zzgu.zzl(str16), Long.valueOf(zzarVarZzx.zzd));
                            }
                            zzj().zzc();
                        }
                    } else {
                        if (zEquals) {
                            bundleZzf = zzbeVar2.zzf();
                            zzpp zzppVarZzt19 = zzt();
                            String str21111111112 = zzbgVar2.zzc;
                            zzppVarZzt19.zzM(bundleZzf, "_o", str21111111112);
                            if (zzt().zzaa(str16, zzrVar.zzB)) {
                                zzt().zzM(bundleZzf, "_dbg", 1L);
                                zzt().zzM(bundleZzf, "_r", 1L);
                            }
                            if ("_s".equals(str2)) {
                                obj2 = zzpnVarZzm2.zze;
                                if (obj2 instanceof Long) {
                                    zzt().zzM(bundleZzf, "_sno", obj2);
                                }
                            }
                            if (zzd().zzp(null, zzfy.zzaX)) {
                                obj = bundleZzf.get("value");
                                if (obj instanceof String) {
                                    double d19 = Double.parseDouble((String) obj);
                                    bundleZzf.remove("value");
                                    bundleZzf.putDouble("value", d19);
                                }
                            }
                            zzavVarZzj2 = zzj();
                            Preconditions.checkNotEmpty(str16);
                            zzavVarZzj2.zzg();
                            zzavVarZzj2.zzaw();
                            str3 = r6;
                            jDelete = zzavVarZzj2.zze().delete(str3, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str16, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzavVarZzj2.zzu.zzc().zzm(str16, zzfy.zzp))))});
                            if (jDelete > 0) {
                                zzaV().zze().zzc("Data lost. Too many events stored on disk, deleted. appId", zzgu.zzl(str16), Long.valueOf(jDelete));
                            }
                            zzicVar = this.zzn;
                            str4 = str3;
                            zzbbVar = new zzbb(zzicVar, zzbgVar2.zzc, str16, zzbgVar2.zza, zzbgVar2.zzd, 0L, bundleZzf);
                            zzav zzavVarZzj113 = zzj();
                            str5 = zzbbVar.zzb;
                            zzbcVarZzf = zzavVarZzj113.zzf(str16, str5);
                            if (zzbcVarZzf != null) {
                                if (zzj().zzS(str16) >= zzd().zzh(str16)) {
                                }
                                zzbcVarZza = new zzbc(str16, str5, 0L, 0L, 0L, zzbbVar.zzd, 0L, null, null, null, null);
                            } else {
                                zzbbVar = zzbbVar.zza(zzicVar, zzbcVarZzf.zzf);
                                zzbcVarZza = zzbcVarZzf.zza(zzbbVar.zzd);
                            }
                            zzj().zzh(zzbcVarZza);
                            zzaW().zzg();
                            zzu();
                            Preconditions.checkNotNull(zzbbVar);
                            Preconditions.checkNotNull(zzrVar);
                            String str21111111113 = zzbbVar.zza;
                            Preconditions.checkNotEmpty(str21111111113);
                            str6 = zzrVar.zza;
                            Preconditions.checkArgument(str21111111113.equals(str6));
                            zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                            boolean z110 = true;
                            zzicVarZzaE.zza(1);
                            zzicVarZzaE.zzC("android");
                            if (!TextUtils.isEmpty(str6)) {
                                zzicVarZzaE.zzL(str6);
                            }
                            str7 = zzrVar.zzd;
                            if (!TextUtils.isEmpty(str7)) {
                                zzicVarZzaE.zzJ(str7);
                            }
                            str8 = zzrVar.zzc;
                            if (!TextUtils.isEmpty(str8)) {
                                zzicVarZzaE.zzM(str8);
                            }
                            str9 = zzrVar.zzu;
                            if (!TextUtils.isEmpty(str9)) {
                                zzicVarZzaE.zzau(str9);
                            }
                            j = zzrVar.zzj;
                            if (j != -2147483648L) {
                                zzicVarZzaE.zzaj((int) j);
                            }
                            zzicVarZzaE.zzN(zzrVar.zze);
                            str10 = zzrVar.zzb;
                            if (!TextUtils.isEmpty(str10)) {
                                zzicVarZzaE.zzad(str10);
                            }
                            zzjl zzjlVarZzs110 = zzB((String) Preconditions.checkNotNull(str6)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                            zzicVarZzaE.zzat(zzjlVarZzs110.zzk());
                            zzqp.zza();
                            if (!zzd().zzp(str6, zzfy.zzaP)) {
                            }
                            j2 = zzrVar.zzf;
                            if (j2 != 0) {
                                zzicVarZzaE.zzY(j2);
                            }
                            zzicVarZzaE.zzar(zzrVar.zzq);
                            zzpk zzpkVarZzp19 = zzp();
                            zzjrVarZza = com.google.android.gms.internal.measurement.zzjr.zza(zzpkVarZzp19.zzg.zzn.zzaY().getContentResolver(), com.google.android.gms.internal.measurement.zzkb.zza("com.google.android.gms.measurement"), zzfu.zza);
                            if (zzjrVarZza == null) {
                                mapZzb = Collections.emptyMap();
                            } else {
                                mapZzb = zzjrVarZza.zzb();
                            }
                            if (mapZzb != null) {
                                arrayList = null;
                            } else {
                                arrayList = null;
                            }
                            if (arrayList != null) {
                                zzicVarZzaE.zzaq(arrayList);
                            }
                            if (zzd().zzp(null, zzfy.zzba)) {
                                zzicVarZzaE.zzaP("");
                            }
                            str11 = zzrVar.zza;
                            zzjlVarZzs = zzB((String) Preconditions.checkNotNull(str11)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                            zzjkVar = zzjk.AD_STORAGE;
                            if (zzjlVarZzs.zzo(zzjkVar)) {
                                zzjlVarZzs = zzjlVarZzs;
                                zzjkVar = zzjkVar;
                                str12 = "_r";
                            } else {
                                zzjlVarZzs = zzjlVarZzs;
                                zzjkVar = zzjkVar;
                                str12 = "_r";
                            }
                            zzicVar2 = this.zzn;
                            zzicVar2.zzu().zzw();
                            zzicVarZzaE.zzF(Build.MODEL);
                            zzicVar2.zzu().zzw();
                            zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                            zzicVarZzaE.zzI((int) zzicVar2.zzu().zzb());
                            zzicVarZzaE.zzH(zzicVar2.zzu().zzc());
                            zzicVarZzaE.zzay(zzrVar.zzw);
                            if (zzicVar2.zzB()) {
                                zzicVarZzaE.zzK();
                                if (!TextUtils.isEmpty(null)) {
                                    zzicVarZzaE.zzam(null);
                                }
                            }
                            zzhVarZzu = zzj().zzu(str11);
                            if (zzhVarZzu == null) {
                                zzhVarZzu = new zzh(zzicVar2, str11);
                                zzhVarZzu.zze(zzK(zzjlVarZzs));
                                zzhVarZzu.zzm(zzrVar.zzk);
                                zzhVarZzu.zzg(zzrVar.zzb);
                                if (zzjlVarZzs.zzo(zzjkVar)) {
                                    zzhVarZzu.zzk(this.zzk.zzf(str11, zzrVar.zzn));
                                }
                                zzhVarZzu.zzF(0L);
                                zzhVarZzu.zzo(0L);
                                zzhVarZzu.zzq(0L);
                                zzhVarZzu.zzs(zzrVar.zzc);
                                zzhVarZzu.zzu(zzrVar.zzj);
                                zzhVarZzu.zzw(zzrVar.zzd);
                                zzhVarZzu.zzy(zzrVar.zze);
                                zzhVarZzu.zzA(zzrVar.zzf);
                                zzhVarZzu.zzE(zzrVar.zzh);
                                zzhVarZzu.zzC(zzrVar.zzq);
                                i = 0;
                                zzj().zzv(zzhVarZzu, false, false);
                            } else {
                                i = 0;
                            }
                            if (zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                                zzicVarZzaE.zzW((String) Preconditions.checkNotNull(zzhVarZzu.zzd()));
                            }
                            if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                            }
                            listZzn = zzj().zzn(str11);
                            while (i2 < listZzn.size()) {
                                com.google.android.gms.internal.measurement.zzit zzitVarZzm19 = com.google.android.gms.internal.measurement.zziu.zzm();
                                zzitVarZzm19.zzb(((zzpn) listZzn.get(i2)).zzc);
                                zzitVarZzm19.zza(((zzpn) listZzn.get(i2)).zzd);
                                zzp().zzc(zzitVarZzm19, ((zzpn) listZzn.get(i2)).zze);
                                zzicVarZzaE.zzp(zzitVarZzm19);
                                if (!"_sid".equals(((zzpn) listZzn.get(i2)).zzc)) {
                                }
                            }
                            zzavVarZzj3 = zzj();
                            com.google.android.gms.internal.measurement.zzid zzidVar19 = (com.google.android.gms.internal.measurement.zzid) zzicVarZzaE.zzbc();
                            zzavVarZzj3.zzg();
                            zzavVarZzj3.zzaw();
                            Preconditions.checkNotNull(zzidVar19);
                            Preconditions.checkNotEmpty(zzidVar19.zzA());
                            byte[] bArrZzcc1117 = zzidVar19.zzcc();
                            long jZzt19 = zzavVarZzj3.zzg.zzp().zzt(bArrZzcc1117);
                            ContentValues contentValues110 = new ContentValues();
                            String str21111111114 = str14;
                            contentValues110.put(str21111111114, zzidVar19.zzA());
                            contentValues110.put("metadata_fingerprint", Long.valueOf(jZzt19));
                            contentValues110.put("metadata", bArrZzcc1117);
                            zzavVarZzj3.zze().insertWithOnConflict("raw_events_metadata", null, contentValues110, 4);
                            zzavVarZzj4 = zzj();
                            zzbdVar2 = new zzbd(zzbbVar.zzf);
                            while (true) {
                                if (zzbdVar2.hasNext()) {
                                    zzht zzhtVarZzh110 = zzh();
                                    String str21111111115 = zzbbVar.zza;
                                    zZzk = zzhtVarZzh110.zzk(str21111111115, zzbbVar.zzb);
                                    zzar zzarVarZzw19 = zzj().zzw(zzC(), str21111111115, false, false, false, false, false, false, false);
                                    if (zZzk) {
                                    }
                                    i3 = 0;
                                    break;
                                }
                                next = zzbdVar2.next();
                                String str21111111116 = next;
                                if (str12.equals(next)) {
                                }
                                i3 = 1;
                                break;
                            }
                            zzavVarZzj4.zzg();
                            zzavVarZzj4.zzaw();
                            Preconditions.checkNotNull(zzbbVar);
                            str13 = zzbbVar.zza;
                            Preconditions.checkNotEmpty(str13);
                            byte[] bArrZzcc1118 = zzavVarZzj4.zzg.zzp().zzh(zzbbVar).zzcc();
                            contentValues = new ContentValues();
                            contentValues.put(str21111111114, str13);
                            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbbVar.zzb);
                            contentValues.put(ServerValues.NAME_OP_TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                            contentValues.put("metadata_fingerprint", Long.valueOf(jZzt19));
                            contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzcc1118);
                            contentValues.put("realtime", Integer.valueOf(i3));
                            if (zzavVarZzj4.zze().insert(str4, null, contentValues) == -1) {
                                zzavVarZzj4.zzu.zzaV().zzb().zzb("Failed to insert raw event (got -1). appId", zzgu.zzl(str13));
                            } else {
                                this.zza = 0L;
                            }
                            zzj().zzc();
                            zzj().zzd();
                            zzaL();
                            zzaV().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                            return;
                        }
                        jMax = zzarVarZzx.zzd - ((long) Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzd().zzm(zzrVar.zza, zzfy.zzl))));
                        if (jMax > 0) {
                            bundleZzf = zzbeVar2.zzf();
                            zzpp zzppVarZzt110 = zzt();
                            String str21111111117 = zzbgVar2.zzc;
                            zzppVarZzt110.zzM(bundleZzf, "_o", str21111111117);
                            if (zzt().zzaa(str16, zzrVar.zzB)) {
                                zzt().zzM(bundleZzf, "_dbg", 1L);
                                zzt().zzM(bundleZzf, "_r", 1L);
                            }
                            if ("_s".equals(str2)) {
                                obj2 = zzpnVarZzm2.zze;
                                if (obj2 instanceof Long) {
                                    zzt().zzM(bundleZzf, "_sno", obj2);
                                }
                            }
                            if (zzd().zzp(null, zzfy.zzaX)) {
                                obj = bundleZzf.get("value");
                                if (obj instanceof String) {
                                    double d110 = Double.parseDouble((String) obj);
                                    bundleZzf.remove("value");
                                    bundleZzf.putDouble("value", d110);
                                }
                            }
                            zzavVarZzj2 = zzj();
                            Preconditions.checkNotEmpty(str16);
                            zzavVarZzj2.zzg();
                            zzavVarZzj2.zzaw();
                            str3 = r6;
                            jDelete = zzavVarZzj2.zze().delete(str3, "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str16, String.valueOf(Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzavVarZzj2.zzu.zzc().zzm(str16, zzfy.zzp))))});
                            if (jDelete > 0) {
                                zzaV().zze().zzc("Data lost. Too many events stored on disk, deleted. appId", zzgu.zzl(str16), Long.valueOf(jDelete));
                            }
                            zzicVar = this.zzn;
                            str4 = str3;
                            zzbbVar = new zzbb(zzicVar, zzbgVar2.zzc, str16, zzbgVar2.zza, zzbgVar2.zzd, 0L, bundleZzf);
                            zzav zzavVarZzj114 = zzj();
                            str5 = zzbbVar.zzb;
                            zzbcVarZzf = zzavVarZzj114.zzf(str16, str5);
                            if (zzbcVarZzf != null) {
                                if (zzj().zzS(str16) >= zzd().zzh(str16)) {
                                }
                                zzbcVarZza = new zzbc(str16, str5, 0L, 0L, 0L, zzbbVar.zzd, 0L, null, null, null, null);
                            } else {
                                zzbbVar = zzbbVar.zza(zzicVar, zzbcVarZzf.zzf);
                                zzbcVarZza = zzbcVarZzf.zza(zzbbVar.zzd);
                            }
                            zzj().zzh(zzbcVarZza);
                            zzaW().zzg();
                            zzu();
                            Preconditions.checkNotNull(zzbbVar);
                            Preconditions.checkNotNull(zzrVar);
                            String str21111111118 = zzbbVar.zza;
                            Preconditions.checkNotEmpty(str21111111118);
                            str6 = zzrVar.zza;
                            Preconditions.checkArgument(str21111111118.equals(str6));
                            zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                            boolean z111 = true;
                            zzicVarZzaE.zza(1);
                            zzicVarZzaE.zzC("android");
                            if (!TextUtils.isEmpty(str6)) {
                                zzicVarZzaE.zzL(str6);
                            }
                            str7 = zzrVar.zzd;
                            if (!TextUtils.isEmpty(str7)) {
                                zzicVarZzaE.zzJ(str7);
                            }
                            str8 = zzrVar.zzc;
                            if (!TextUtils.isEmpty(str8)) {
                                zzicVarZzaE.zzM(str8);
                            }
                            str9 = zzrVar.zzu;
                            if (!TextUtils.isEmpty(str9)) {
                                zzicVarZzaE.zzau(str9);
                            }
                            j = zzrVar.zzj;
                            if (j != -2147483648L) {
                                zzicVarZzaE.zzaj((int) j);
                            }
                            zzicVarZzaE.zzN(zzrVar.zze);
                            str10 = zzrVar.zzb;
                            if (!TextUtils.isEmpty(str10)) {
                                zzicVarZzaE.zzad(str10);
                            }
                            zzjl zzjlVarZzs111 = zzB((String) Preconditions.checkNotNull(str6)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                            zzicVarZzaE.zzat(zzjlVarZzs111.zzk());
                            zzqp.zza();
                            if (!zzd().zzp(str6, zzfy.zzaP)) {
                            }
                            j2 = zzrVar.zzf;
                            if (j2 != 0) {
                                zzicVarZzaE.zzY(j2);
                            }
                            zzicVarZzaE.zzar(zzrVar.zzq);
                            zzpk zzpkVarZzp110 = zzp();
                            zzjrVarZza = com.google.android.gms.internal.measurement.zzjr.zza(zzpkVarZzp110.zzg.zzn.zzaY().getContentResolver(), com.google.android.gms.internal.measurement.zzkb.zza("com.google.android.gms.measurement"), zzfu.zza);
                            if (zzjrVarZza == null) {
                                mapZzb = Collections.emptyMap();
                            } else {
                                mapZzb = zzjrVarZza.zzb();
                            }
                            if (mapZzb != null) {
                                arrayList = null;
                            } else {
                                arrayList = null;
                            }
                            if (arrayList != null) {
                                zzicVarZzaE.zzaq(arrayList);
                            }
                            if (zzd().zzp(null, zzfy.zzba)) {
                                zzicVarZzaE.zzaP("");
                            }
                            str11 = zzrVar.zza;
                            zzjlVarZzs = zzB((String) Preconditions.checkNotNull(str11)).zzs(zzjl.zzf(zzrVar.zzs, 100));
                            zzjkVar = zzjk.AD_STORAGE;
                            if (zzjlVarZzs.zzo(zzjkVar)) {
                                zzjlVarZzs = zzjlVarZzs;
                                zzjkVar = zzjkVar;
                                str12 = "_r";
                            } else {
                                zzjlVarZzs = zzjlVarZzs;
                                zzjkVar = zzjkVar;
                                str12 = "_r";
                            }
                            zzicVar2 = this.zzn;
                            zzicVar2.zzu().zzw();
                            zzicVarZzaE.zzF(Build.MODEL);
                            zzicVar2.zzu().zzw();
                            zzicVarZzaE.zzE(Build.VERSION.RELEASE);
                            zzicVarZzaE.zzI((int) zzicVar2.zzu().zzb());
                            zzicVarZzaE.zzH(zzicVar2.zzu().zzc());
                            zzicVarZzaE.zzay(zzrVar.zzw);
                            if (zzicVar2.zzB()) {
                                zzicVarZzaE.zzK();
                                if (!TextUtils.isEmpty(null)) {
                                    zzicVarZzaE.zzam(null);
                                }
                            }
                            zzhVarZzu = zzj().zzu(str11);
                            if (zzhVarZzu == null) {
                                zzhVarZzu = new zzh(zzicVar2, str11);
                                zzhVarZzu.zze(zzK(zzjlVarZzs));
                                zzhVarZzu.zzm(zzrVar.zzk);
                                zzhVarZzu.zzg(zzrVar.zzb);
                                if (zzjlVarZzs.zzo(zzjkVar)) {
                                    zzhVarZzu.zzk(this.zzk.zzf(str11, zzrVar.zzn));
                                }
                                zzhVarZzu.zzF(0L);
                                zzhVarZzu.zzo(0L);
                                zzhVarZzu.zzq(0L);
                                zzhVarZzu.zzs(zzrVar.zzc);
                                zzhVarZzu.zzu(zzrVar.zzj);
                                zzhVarZzu.zzw(zzrVar.zzd);
                                zzhVarZzu.zzy(zzrVar.zze);
                                zzhVarZzu.zzA(zzrVar.zzf);
                                zzhVarZzu.zzE(zzrVar.zzh);
                                zzhVarZzu.zzC(zzrVar.zzq);
                                i = 0;
                                zzj().zzv(zzhVarZzu, false, false);
                            } else {
                                i = 0;
                            }
                            if (zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                                zzicVarZzaE.zzW((String) Preconditions.checkNotNull(zzhVarZzu.zzd()));
                            }
                            if (!TextUtils.isEmpty(zzhVarZzu.zzl())) {
                                zzicVarZzaE.zzah((String) Preconditions.checkNotNull(zzhVarZzu.zzl()));
                            }
                            listZzn = zzj().zzn(str11);
                            while (i2 < listZzn.size()) {
                                com.google.android.gms.internal.measurement.zzit zzitVarZzm110 = com.google.android.gms.internal.measurement.zziu.zzm();
                                zzitVarZzm110.zzb(((zzpn) listZzn.get(i2)).zzc);
                                zzitVarZzm110.zza(((zzpn) listZzn.get(i2)).zzd);
                                zzp().zzc(zzitVarZzm110, ((zzpn) listZzn.get(i2)).zze);
                                zzicVarZzaE.zzp(zzitVarZzm110);
                                if (!"_sid".equals(((zzpn) listZzn.get(i2)).zzc)) {
                                }
                            }
                            zzavVarZzj3 = zzj();
                            com.google.android.gms.internal.measurement.zzid zzidVar110 = (com.google.android.gms.internal.measurement.zzid) zzicVarZzaE.zzbc();
                            zzavVarZzj3.zzg();
                            zzavVarZzj3.zzaw();
                            Preconditions.checkNotNull(zzidVar110);
                            Preconditions.checkNotEmpty(zzidVar110.zzA());
                            byte[] bArrZzcc1119 = zzidVar110.zzcc();
                            long jZzt110 = zzavVarZzj3.zzg.zzp().zzt(bArrZzcc1119);
                            ContentValues contentValues111 = new ContentValues();
                            String str21111111119 = str14;
                            contentValues111.put(str21111111119, zzidVar110.zzA());
                            contentValues111.put("metadata_fingerprint", Long.valueOf(jZzt110));
                            contentValues111.put("metadata", bArrZzcc1119);
                            zzavVarZzj3.zze().insertWithOnConflict("raw_events_metadata", null, contentValues111, 4);
                            zzavVarZzj4 = zzj();
                            zzbdVar2 = new zzbd(zzbbVar.zzf);
                            while (true) {
                                if (zzbdVar2.hasNext()) {
                                    zzht zzhtVarZzh111 = zzh();
                                    String str211111111110 = zzbbVar.zza;
                                    zZzk = zzhtVarZzh111.zzk(str211111111110, zzbbVar.zzb);
                                    zzar zzarVarZzw110 = zzj().zzw(zzC(), str211111111110, false, false, false, false, false, false, false);
                                    if (zZzk) {
                                    }
                                    i3 = 0;
                                    break;
                                }
                                next = zzbdVar2.next();
                                String str211111111111 = next;
                                if (str12.equals(next)) {
                                }
                                i3 = 1;
                                break;
                            }
                            zzavVarZzj4.zzg();
                            zzavVarZzj4.zzaw();
                            Preconditions.checkNotNull(zzbbVar);
                            str13 = zzbbVar.zza;
                            Preconditions.checkNotEmpty(str13);
                            byte[] bArrZzcc11110 = zzavVarZzj4.zzg.zzp().zzh(zzbbVar).zzcc();
                            contentValues = new ContentValues();
                            contentValues.put(str21111111119, str13);
                            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzbbVar.zzb);
                            contentValues.put(ServerValues.NAME_OP_TIMESTAMP, Long.valueOf(zzbbVar.zzd));
                            contentValues.put("metadata_fingerprint", Long.valueOf(jZzt110));
                            contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, bArrZzcc11110);
                            contentValues.put("realtime", Integer.valueOf(i3));
                            if (zzavVarZzj4.zze().insert(str4, null, contentValues) == -1) {
                                zzavVarZzj4.zzu.zzaV().zzb().zzb("Failed to insert raw event (got -1). appId", zzgu.zzl(str13));
                            } else {
                                this.zza = 0L;
                            }
                            zzj().zzc();
                            zzj().zzd();
                            zzaL();
                            zzaV().zzk().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                            return;
                        }
                        if (jMax == 1) {
                            zzaV().zzb().zzc("Too many error events logged. appId, count", zzgu.zzl(str16), Long.valueOf(zzarVarZzx.zzd));
                        }
                        zzj().zzc();
                    }
                }
                zzj().zzd();
            } catch (Throwable th) {
                zzj().zzd();
                throw th;
            }
        }
    }

    final void zzI(zzh zzhVar, com.google.android.gms.internal.measurement.zzic zzicVar) throws Throwable {
        com.google.android.gms.internal.measurement.zziu zziuVar;
        zzaW().zzg();
        zzu();
        zzan zzanVarZzd = zzan.zzd(zzicVar.zzaA());
        String strZzc = zzhVar.zzc();
        zzaW().zzg();
        zzu();
        zzjl zzjlVarZzB = zzB(strZzc);
        zzji zzjiVar = zzji.UNINITIALIZED;
        int iOrdinal = zzjlVarZzB.zzp().ordinal();
        if (iOrdinal == 1) {
            zzanVarZzd.zzc(zzjk.AD_STORAGE, zzam.REMOTE_ENFORCED_DEFAULT);
        } else if (iOrdinal == 2 || iOrdinal == 3) {
            zzanVarZzd.zzb(zzjk.AD_STORAGE, zzjlVarZzB.zzb());
        } else {
            zzanVarZzd.zzc(zzjk.AD_STORAGE, zzam.FAILSAFE);
        }
        int iOrdinal2 = zzjlVarZzB.zzq().ordinal();
        if (iOrdinal2 == 1) {
            zzanVarZzd.zzc(zzjk.ANALYTICS_STORAGE, zzam.REMOTE_ENFORCED_DEFAULT);
        } else if (iOrdinal2 == 2 || iOrdinal2 == 3) {
            zzanVarZzd.zzb(zzjk.ANALYTICS_STORAGE, zzjlVarZzB.zzb());
        } else {
            zzanVarZzd.zzc(zzjk.ANALYTICS_STORAGE, zzam.FAILSAFE);
        }
        String strZzc2 = zzhVar.zzc();
        zzaW().zzg();
        zzu();
        zzaz zzazVarZzz = zzz(strZzc2, zzx(strZzc2), zzB(strZzc2), zzanVarZzd);
        zzicVar.zzaD(((Boolean) Preconditions.checkNotNull(zzazVarZzz.zzj())).booleanValue());
        if (!TextUtils.isEmpty(zzazVarZzz.zzk())) {
            zzicVar.zzaF(zzazVarZzz.zzk());
        }
        zzaW().zzg();
        zzu();
        Iterator it = zzicVar.zzk().iterator();
        do {
            if (!it.hasNext()) {
                zziuVar = null;
                break;
            }
            zziuVar = (com.google.android.gms.internal.measurement.zziu) it.next();
        } while (!"_npa".equals(zziuVar.zzc()));
        if (zziuVar != null) {
            zzjk zzjkVar = zzjk.AD_PERSONALIZATION;
            if (zzanVarZzd.zza(zzjkVar) == zzam.UNSET) {
                zzpn zzpnVarZzm = zzj().zzm(zzhVar.zzc(), "_npa");
                if (zzpnVarZzm != null) {
                    String str = zzpnVarZzm.zzb;
                    if ("tcf".equals(str)) {
                        zzanVarZzd.zzc(zzjkVar, zzam.TCF);
                    } else if ("app".equals(str)) {
                        zzanVarZzd.zzc(zzjkVar, zzam.API);
                    } else {
                        zzanVarZzd.zzc(zzjkVar, zzam.MANIFEST);
                    }
                } else {
                    Boolean boolZzae = zzhVar.zzae();
                    if (boolZzae == null || ((boolZzae.booleanValue() && zziuVar.zzg() != 1) || !(boolZzae.booleanValue() || zziuVar.zzg() == 0))) {
                        zzanVarZzd.zzc(zzjkVar, zzam.API);
                    } else {
                        zzanVarZzd.zzc(zzjkVar, zzam.MANIFEST);
                    }
                }
            }
        } else {
            int iZzaC = zzaC(zzhVar.zzc(), zzanVarZzd);
            com.google.android.gms.internal.measurement.zzit zzitVarZzm = com.google.android.gms.internal.measurement.zziu.zzm();
            zzitVarZzm.zzb("_npa");
            zzitVarZzm.zza(zzaZ().currentTimeMillis());
            zzitVarZzm.zze(iZzaC);
            zzicVar.zzo((com.google.android.gms.internal.measurement.zziu) zzitVarZzm.zzbc());
            zzaV().zzk().zzc("Setting user property", "non_personalized_ads(_npa)", Integer.valueOf(iZzaC));
        }
        zzicVar.zzaB(zzanVarZzd.toString());
        boolean zZzy = this.zzc.zzy(zzhVar.zzc());
        List listZzb = zzicVar.zzb();
        int i = 0;
        for (int i2 = 0; i2 < listZzb.size(); i2++) {
            if ("_tcf".equals(((com.google.android.gms.internal.measurement.zzhs) listZzb.get(i2)).zzd())) {
                com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) ((com.google.android.gms.internal.measurement.zzhs) listZzb.get(i2)).zzcl();
                List listZza = zzhrVar.zza();
                for (int i3 = 0; i3 < listZza.size(); i3++) {
                    if ("_tcfd".equals(((com.google.android.gms.internal.measurement.zzhw) listZza.get(i3)).zzb())) {
                        String strZzd = ((com.google.android.gms.internal.measurement.zzhw) listZza.get(i3)).zzd();
                        if (zZzy && strZzd.length() > 4) {
                            char[] charArray = strZzd.toCharArray();
                            for (int i4 = 1; i4 < 64; i4++) {
                                if (charArray[4] == "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i4)) {
                                    i = i4;
                                    break;
                                }
                            }
                            charArray[4] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i | 1);
                            strZzd = String.valueOf(charArray);
                        }
                        com.google.android.gms.internal.measurement.zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                        zzhvVarZzn.zzb("_tcfd");
                        zzhvVarZzn.zzd(strZzd);
                        zzhrVar.zze(i3, zzhvVarZzn);
                        break;
                    }
                }
                zzicVar.zzf(i2, zzhrVar);
                return;
            }
        }
    }

    final void zzJ(zzh zzhVar, com.google.android.gms.internal.measurement.zzic zzicVar) {
        zzaW().zzg();
        zzu();
        com.google.android.gms.internal.measurement.zzgx zzgxVarZzr = com.google.android.gms.internal.measurement.zzha.zzr();
        byte[] bArrZzaJ = zzhVar.zzaJ();
        if (bArrZzaJ != null) {
            try {
                zzgxVarZzr = (com.google.android.gms.internal.measurement.zzgx) zzpk.zzw(zzgxVarZzr, bArrZzaJ);
            } catch (com.google.android.gms.internal.measurement.zzmr unused) {
                zzaV().zze().zzb("Failed to parse locally stored ad campaign info. appId", zzgu.zzl(zzhVar.zzc()));
            }
        }
        for (com.google.android.gms.internal.measurement.zzhs zzhsVar : zzicVar.zzb()) {
            if (zzhsVar.zzd().equals(Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN)) {
                String str = (String) zzpk.zzJ(zzhsVar, "gclid", "");
                String str2 = (String) zzpk.zzJ(zzhsVar, "gbraid", "");
                String str3 = (String) zzpk.zzJ(zzhsVar, "gad_source", "");
                String[] strArrSplit = ((String) zzfy.zzbg.zzb(null)).split(",");
                zzp();
                if (!zzpk.zzG(zzhsVar, strArrSplit).isEmpty()) {
                    long jLongValue = ((Long) zzpk.zzJ(zzhsVar, "click_timestamp", 0L)).longValue();
                    if (jLongValue <= 0) {
                        jLongValue = zzhsVar.zzf();
                    }
                    if ("referrer API v2".equals(zzpk.zzI(zzhsVar, "_cis"))) {
                        if (jLongValue > zzgxVarZzr.zzo()) {
                            if (str.isEmpty()) {
                                zzgxVarZzr.zzj();
                            } else {
                                zzgxVarZzr.zzi(str);
                            }
                            if (str2.isEmpty()) {
                                zzgxVarZzr.zzl();
                            } else {
                                zzgxVarZzr.zzk(str2);
                            }
                            if (str3.isEmpty()) {
                                zzgxVarZzr.zzn();
                            } else {
                                zzgxVarZzr.zzm(str3);
                            }
                            zzgxVarZzr.zzp(jLongValue);
                            zzgxVarZzr.zzs();
                            zzgxVarZzr.zzt(zzaD(zzhsVar));
                        }
                    } else if (jLongValue > zzgxVarZzr.zzg()) {
                        if (str.isEmpty()) {
                            zzgxVarZzr.zzb();
                        } else {
                            zzgxVarZzr.zza(str);
                        }
                        if (str2.isEmpty()) {
                            zzgxVarZzr.zzd();
                        } else {
                            zzgxVarZzr.zzc(str2);
                        }
                        if (str3.isEmpty()) {
                            zzgxVarZzr.zzf();
                        } else {
                            zzgxVarZzr.zze(str3);
                        }
                        zzgxVarZzr.zzh(jLongValue);
                        zzgxVarZzr.zzq();
                        zzgxVarZzr.zzr(zzaD(zzhsVar));
                    }
                }
            }
        }
        if (!((com.google.android.gms.internal.measurement.zzha) zzgxVarZzr.zzbc()).equals(com.google.android.gms.internal.measurement.zzha.zzs())) {
            zzicVar.zzaM((com.google.android.gms.internal.measurement.zzha) zzgxVarZzr.zzbc());
        }
        zzhVar.zzaI(((com.google.android.gms.internal.measurement.zzha) zzgxVarZzr.zzbc()).zzcc());
        if (zzhVar.zza()) {
            zzj().zzv(zzhVar, false, false);
        }
        if (zzd().zzp(null, zzfy.zzbf)) {
            zzj().zzk(zzhVar.zzc(), "_lgclid");
        }
    }

    final String zzK(zzjl zzjlVar) {
        if (!zzjlVar.zzo(zzjk.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        zzt().zzf().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    final void zzL(List list) {
        Preconditions.checkArgument(!list.isEmpty());
        if (this.zzz != null) {
            zzaV().zzb().zza("Set uploading progress before finishing the previous upload");
        } else {
            this.zzz = new ArrayList(list);
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0108 A[Catch: all -> 0x01b9, PHI: r5 r7
  0x0108: PHI (r5v10 long) = (r5v6 long), (r5v11 long), (r5v6 long) binds: [B:43:0x0125, B:37:0x0110, B:33:0x0106] A[DONT_GENERATE, DONT_INLINE]
  0x0108: PHI (r7v12 android.database.Cursor) = (r7v21 android.database.Cursor), (r7v22 android.database.Cursor), (r7v23 android.database.Cursor) binds: [B:43:0x0125, B:37:0x0110, B:33:0x0106] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x01b9, blocks: (B:3:0x000e, B:5:0x001d, B:6:0x002c, B:8:0x0032, B:9:0x0041, B:11:0x0049, B:12:0x004e, B:14:0x0059, B:15:0x0068, B:17:0x0072, B:18:0x0084, B:20:0x00a3, B:22:0x00a9, B:23:0x00ac, B:25:0x00c5, B:26:0x00dc, B:28:0x00ec, B:30:0x00f2, B:34:0x0108, B:45:0x0128, B:47:0x012d, B:48:0x0130, B:49:0x0131, B:50:0x0136, B:56:0x0173, B:70:0x0198, B:72:0x019e, B:74:0x01a8, B:80:0x01b5, B:81:0x01b8, B:31:0x00f6, B:36:0x010c, B:42:0x0116), top: B:92:0x000e, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0173 A[Catch: all -> 0x01b9, PHI: r1 r7
  0x0173: PHI (r1v20 ??) = (r1v40 ??), (r1v41 ??), (r1v42 ??) binds: [B:59:0x017b, B:55:0x0171, B:68:0x0195] A[DONT_GENERATE, DONT_INLINE]
  0x0173: PHI (r7v2 java.lang.Object) = (r7v32 java.lang.Object), (r7v16 java.lang.Object), (r7v33 java.lang.Object) binds: [B:59:0x017b, B:55:0x0171, B:68:0x0195] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x01b9, blocks: (B:3:0x000e, B:5:0x001d, B:6:0x002c, B:8:0x0032, B:9:0x0041, B:11:0x0049, B:12:0x004e, B:14:0x0059, B:15:0x0068, B:17:0x0072, B:18:0x0084, B:20:0x00a3, B:22:0x00a9, B:23:0x00ac, B:25:0x00c5, B:26:0x00dc, B:28:0x00ec, B:30:0x00f2, B:34:0x0108, B:45:0x0128, B:47:0x012d, B:48:0x0130, B:49:0x0131, B:50:0x0136, B:56:0x0173, B:70:0x0198, B:72:0x019e, B:74:0x01a8, B:80:0x01b5, B:81:0x01b8, B:31:0x00f6, B:36:0x010c, B:42:0x0116), top: B:92:0x000e, inners: #2 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.google.android.gms.measurement.internal.zzpg] */
    /* JADX WARN: Type inference failed for: r1v12, types: [long] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v19, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v20, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24, types: [com.google.android.gms.measurement.internal.zzav] */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.google.android.gms.measurement.internal.zzav, com.google.android.gms.measurement.internal.zzje, com.google.android.gms.measurement.internal.zzos] */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.google.android.gms.measurement.internal.zzje] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.CharSequence, java.lang.String] */
    final void zzM() {
        Throwable th;
        SQLiteException e;
        String string;
        ?? r1;
        boolean zIsEmpty;
        zzh zzhVarZzu;
        Cursor cursor;
        Cursor cursor2;
        zzaW().zzg();
        zzu();
        this.zzw = true;
        try {
            zzic zzicVar = this.zzn;
            zzicVar.zzaU();
            Boolean boolZzJ = zzicVar.zzt().zzJ();
            if (boolZzJ == null) {
                zzaV().zze().zza("Upload data called on the client side before use of service was decided");
            } else if (boolZzJ.booleanValue()) {
                zzaV().zzb().zza("Upload called in the client side when service should be used");
            } else if (this.zza > 0) {
                zzaL();
            } else {
                zzaW().zzg();
                if (this.zzz != null) {
                    zzaV().zzk().zza("Uploading requested multiple times");
                } else if (zzi().zzb()) {
                    ?? CurrentTimeMillis = zzaZ().currentTimeMillis();
                    ?? r7 = 0;
                    cursorRawQuery = null;
                    cursorRawQuery = null;
                    cursorRawQuery = null;
                    ?? r8 = 0;
                    Object obj = null;
                    cursorRawQuery = null;
                    Cursor cursorRawQuery = null;
                    int iZzm = zzd().zzm(null, zzfy.zzai);
                    zzd();
                    long jZzF = CurrentTimeMillis - zzal.zzF();
                    for (int i = 0; i < iZzm && zzaG(null, jZzF); i++) {
                    }
                    zzqp.zza();
                    zzaW().zzg();
                    zzav();
                    long jZza = this.zzk.zzd.zza();
                    if (jZza != 0) {
                        zzaV().zzj().zzb("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(CurrentTimeMillis - jZza)));
                    }
                    ?? ZzF = zzj().zzF();
                    long j = -1;
                    if (TextUtils.isEmpty(ZzF)) {
                        try {
                            this.zzB = -1L;
                            ZzF = zzj();
                            zzd();
                            long jZzF2 = CurrentTimeMillis - zzal.zzF();
                            ZzF.zzg();
                            ZzF.zzaw();
                            try {
                                CurrentTimeMillis = ZzF.zze().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(jZzF2)});
                                try {
                                    if (CurrentTimeMillis.moveToFirst()) {
                                        string = CurrentTimeMillis.getString(0);
                                        if (CurrentTimeMillis != 0) {
                                            r8 = string;
                                            r1 = CurrentTimeMillis;
                                            obj = string;
                                            r1 = CurrentTimeMillis;
                                            r1.close();
                                            r8 = obj;
                                        }
                                    } else {
                                        ZzF.zzu.zzaV().zzk().zza("No expired configs for apps with pending events");
                                        if (CurrentTimeMillis != 0) {
                                            r8 = string;
                                            r1 = CurrentTimeMillis;
                                            obj = string;
                                            r1 = CurrentTimeMillis;
                                            r1.close();
                                            r8 = obj;
                                        }
                                    }
                                } catch (SQLiteException e2) {
                                    e = e2;
                                    ZzF.zzu.zzaV().zzb().zzb("Error selecting expired configs", e);
                                    r8 = cursorRawQuery;
                                    r1 = CurrentTimeMillis;
                                    obj = cursorRawQuery;
                                    if (CurrentTimeMillis != 0) {
                                        r8 = string;
                                        r1 = CurrentTimeMillis;
                                        obj = string;
                                        r1 = CurrentTimeMillis;
                                        r1.close();
                                        r8 = obj;
                                    }
                                }
                            } catch (SQLiteException e3) {
                                e = e3;
                                CurrentTimeMillis = 0;
                                ZzF.zzu.zzaV().zzb().zzb("Error selecting expired configs", e);
                                r8 = cursorRawQuery;
                                r1 = CurrentTimeMillis;
                                obj = cursorRawQuery;
                                if (CurrentTimeMillis != 0) {
                                    r8 = string;
                                    r1 = CurrentTimeMillis;
                                    obj = string;
                                    r1 = CurrentTimeMillis;
                                    r1.close();
                                    r8 = obj;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (r7 != 0) {
                                    r7.close();
                                }
                                throw th;
                            }
                            r8 = string;
                            r1 = CurrentTimeMillis;
                            obj = string;
                            r1 = CurrentTimeMillis;
                            zIsEmpty = TextUtils.isEmpty(r8);
                            CurrentTimeMillis = zIsEmpty;
                            if (!zIsEmpty && (zzhVarZzu = zzj().zzu(r8)) != null) {
                                CurrentTimeMillis = zzhVarZzu;
                                zzW(zzhVarZzu);
                                CurrentTimeMillis = zzhVarZzu;
                            }
                            CurrentTimeMillis = zzhVarZzu;
                        } catch (Throwable th3) {
                            th = th3;
                            r7 = CurrentTimeMillis;
                        }
                    } else {
                        if (this.zzB == -1) {
                            zzav zzavVarZzj = zzj();
                            try {
                                try {
                                    cursorRawQuery = zzavVarZzj.zze().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                                    boolean zMoveToFirst = cursorRawQuery.moveToFirst();
                                    cursor2 = cursorRawQuery;
                                    cursor = cursorRawQuery;
                                    if (zMoveToFirst) {
                                        j = cursorRawQuery.getLong(0);
                                        if (cursorRawQuery != null) {
                                            cursor2 = cursorRawQuery;
                                            cursor = cursorRawQuery;
                                            cursor2.close();
                                            cursor = cursor2;
                                        }
                                    } else if (cursorRawQuery != null) {
                                        cursor2 = cursorRawQuery;
                                        cursor = cursorRawQuery;
                                        cursor2.close();
                                        cursor = cursor2;
                                    }
                                } catch (SQLiteException e4) {
                                    zzavVarZzj.zzu.zzaV().zzb().zzb("Error querying raw events", e4);
                                    cursor2 = cursorRawQuery;
                                    cursor = cursorRawQuery;
                                    if (cursorRawQuery != null) {
                                    }
                                    cursor2 = cursorRawQuery;
                                    cursor = cursorRawQuery;
                                    this.zzB = j;
                                    cursorRawQuery = cursor;
                                    zzN(ZzF, CurrentTimeMillis);
                                }
                                cursor2 = cursorRawQuery;
                                cursor = cursorRawQuery;
                                this.zzB = j;
                                cursorRawQuery = cursor;
                            } catch (Throwable th4) {
                                if (cursorRawQuery != null) {
                                    cursorRawQuery.close();
                                }
                                throw th4;
                            }
                        }
                        zzN(ZzF, CurrentTimeMillis);
                    }
                    e = e2;
                    ZzF.zzu.zzaV().zzb().zzb("Error selecting expired configs", e);
                    r8 = cursorRawQuery;
                    r1 = CurrentTimeMillis;
                    obj = cursorRawQuery;
                    if (CurrentTimeMillis != 0) {
                        r8 = string;
                        r1 = CurrentTimeMillis;
                        obj = string;
                        r1 = CurrentTimeMillis;
                        r1.close();
                        r8 = obj;
                    }
                    r8 = string;
                    r1 = CurrentTimeMillis;
                    obj = string;
                    r1 = CurrentTimeMillis;
                    zIsEmpty = TextUtils.isEmpty(r8);
                    CurrentTimeMillis = zIsEmpty;
                    if (!zIsEmpty) {
                        CurrentTimeMillis = zzhVarZzu;
                        zzW(zzhVarZzu);
                        CurrentTimeMillis = zzhVarZzu;
                    }
                    CurrentTimeMillis = zzhVarZzu;
                } else {
                    zzaV().zzk().zza("Network not connected, ignoring upload request");
                    zzaL();
                }
            }
            this.zzw = false;
            zzaM();
        } catch (Throwable th5) {
            this.zzw = false;
            zzaM();
            throw th5;
        }
    }

    /* JADX WARN: Code duplicated, block: B:134:0x03a0 A[LOOP:2: B:134:0x03a0->B:148:0x0418, LOOP_START, PHI: r4 r6
  0x03a0: PHI (r4v53 java.lang.String) = (r4v5 java.lang.String), (r4v56 java.lang.String) binds: [B:133:0x039e, B:148:0x0418] A[DONT_GENERATE, DONT_INLINE]
  0x03a0: PHI (r6v37 java.util.ArrayList) = (r6v33 java.util.ArrayList), (r6v39 java.util.ArrayList) binds: [B:133:0x039e, B:148:0x0418] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:148:0x0418 A[LOOP:2: B:134:0x03a0->B:148:0x0418, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:151:0x041f  */
    /* JADX WARN: Code duplicated, block: B:153:0x0425  */
    /* JADX WARN: Code duplicated, block: B:164:0x0450  */
    /* JADX WARN: Code duplicated, block: B:168:0x045e  */
    /* JADX WARN: Code duplicated, block: B:176:0x0498  */
    /* JADX WARN: Code duplicated, block: B:179:0x04a6  */
    /* JADX WARN: Code duplicated, block: B:181:0x04bc  */
    /* JADX WARN: Code duplicated, block: B:183:0x04bf  */
    /* JADX WARN: Code duplicated, block: B:185:0x04c2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:186:0x04c4  */
    /* JADX WARN: Code duplicated, block: B:187:0x04c6  */
    /* JADX WARN: Code duplicated, block: B:188:0x04c8  */
    /* JADX WARN: Code duplicated, block: B:189:0x04ca  */
    /* JADX WARN: Code duplicated, block: B:190:0x04cc  */
    /* JADX WARN: Code duplicated, block: B:193:0x04d9  */
    /* JADX WARN: Code duplicated, block: B:195:0x04dc  */
    /* JADX WARN: Code duplicated, block: B:196:0x04de  */
    /* JADX WARN: Code duplicated, block: B:203:0x050b  */
    /* JADX WARN: Code duplicated, block: B:205:0x050f A[PHI: r11
  0x050f: PHI (r11v20 java.util.List) = (r11v0 java.util.List), (r11v30 java.util.List) binds: [B:96:0x0218, B:129:0x0348] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:209:0x0518  */
    /* JADX WARN: Code duplicated, block: B:212:0x0526  */
    /* JADX WARN: Code duplicated, block: B:215:0x0530  */
    /* JADX WARN: Code duplicated, block: B:220:0x054c  */
    /* JADX WARN: Code duplicated, block: B:223:0x0553  */
    /* JADX WARN: Code duplicated, block: B:235:0x05a2  */
    /* JADX WARN: Code duplicated, block: B:238:0x05cb  */
    /* JADX WARN: Code duplicated, block: B:240:0x0607  */
    /* JADX WARN: Code duplicated, block: B:242:0x060c  */
    /* JADX WARN: Code duplicated, block: B:244:0x0614  */
    /* JADX WARN: Code duplicated, block: B:247:0x061c  */
    /* JADX WARN: Code duplicated, block: B:249:0x0621  */
    /* JADX WARN: Code duplicated, block: B:252:0x062e  */
    /* JADX WARN: Code duplicated, block: B:255:0x0639  */
    /* JADX WARN: Code duplicated, block: B:256:0x0645  */
    /* JADX WARN: Code duplicated, block: B:260:0x0664  */
    /* JADX WARN: Code duplicated, block: B:265:0x0696  */
    /* JADX WARN: Code duplicated, block: B:267:0x06a1  */
    /* JADX WARN: Code duplicated, block: B:270:0x06b4  */
    /* JADX WARN: Code duplicated, block: B:272:0x06c5  */
    /* JADX WARN: Code duplicated, block: B:276:0x06d6  */
    /* JADX WARN: Code duplicated, block: B:278:0x06de  */
    /* JADX WARN: Code duplicated, block: B:282:0x06ed  */
    /* JADX WARN: Code duplicated, block: B:284:0x06f9  */
    /* JADX WARN: Code duplicated, block: B:287:0x0714  */
    /* JADX WARN: Code duplicated, block: B:292:0x0732  */
    /* JADX WARN: Code duplicated, block: B:294:0x0746  */
    /* JADX WARN: Code duplicated, block: B:296:0x0759  */
    /* JADX WARN: Code duplicated, block: B:297:0x075b  */
    /* JADX WARN: Code duplicated, block: B:300:0x0764 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:301:0x0766  */
    /* JADX WARN: Code duplicated, block: B:302:0x0768  */
    /* JADX WARN: Code duplicated, block: B:303:0x076d  */
    /* JADX WARN: Code duplicated, block: B:307:0x0782  */
    /* JADX WARN: Code duplicated, block: B:313:0x07b2  */
    /* JADX WARN: Code duplicated, block: B:316:0x07c3  */
    /* JADX WARN: Code duplicated, block: B:320:0x07d9 A[LOOP:10: B:318:0x07d3->B:320:0x07d9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:323:0x0804  */
    /* JADX WARN: Code duplicated, block: B:324:0x0807  */
    /* JADX WARN: Code duplicated, block: B:327:0x081c  */
    /* JADX WARN: Code duplicated, block: B:330:0x084e A[LOOP:11: B:328:0x0848->B:330:0x084e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:333:0x0880  */
    /* JADX WARN: Code duplicated, block: B:335:0x08cb  */
    /* JADX WARN: Code duplicated, block: B:336:0x08ce  */
    /* JADX WARN: Code duplicated, block: B:338:0x08d9  */
    /* JADX WARN: Code duplicated, block: B:340:0x08e6  */
    /* JADX WARN: Code duplicated, block: B:341:0x08e9  */
    /* JADX WARN: Code duplicated, block: B:344:0x08fa  */
    /* JADX WARN: Code duplicated, block: B:346:0x08fd  */
    /* JADX WARN: Code duplicated, block: B:349:0x090a A[LOOP:12: B:347:0x0904->B:349:0x090a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:352:0x0949  */
    /* JADX WARN: Code duplicated, block: B:354:0x096d  */
    /* JADX WARN: Code duplicated, block: B:357:0x097a  */
    /* JADX WARN: Code duplicated, block: B:359:0x0989  */
    /* JADX WARN: Code duplicated, block: B:360:0x0992  */
    /* JADX WARN: Code duplicated, block: B:366:0x09ca  */
    /* JADX WARN: Code duplicated, block: B:406:0x03db A[EDGE_INSN: B:406:0x03db->B:143:0x03db BREAK  A[LOOP:2: B:134:0x03a0->B:148:0x0418], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:409:0x04ec A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:411:0x04df A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:413:0x0549 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:414:0x0544 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:415:? A[LOOP:5: B:213:0x052a->B:415:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:422:0x071a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:424:0x068a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:425:0x067c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:429:0x0797 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:430:0x078e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:431:? A[LOOP:9: B:305:0x077c->B:431:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:451:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:452:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:453:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:454:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:95:0x020d  */
    /* JADX WARN: Code duplicated, block: B:97:0x021a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r31v0, types: [com.google.android.gms.measurement.internal.zzpg] */
    final void zzN(String str, long j) throws Throwable {
        ?? r13;
        Cursor cursorQuery;
        List listEmptyList;
        List<Pair> listSubList;
        zzal zzalVarZzd;
        zzfx zzfxVar;
        String str2;
        zzjl zzjlVarZzB;
        zzjk zzjkVar;
        com.google.android.gms.internal.measurement.zzhz zzhzVarZzh;
        int size;
        ArrayList arrayList;
        boolean z;
        boolean zZzo;
        boolean zZzo2;
        boolean zZzp;
        zzou zzouVar;
        zzot zzotVarZza;
        int i;
        com.google.android.gms.internal.measurement.zzib zzibVar;
        ArrayList arrayList2;
        boolean z2;
        boolean z3;
        String str3;
        String strZzi;
        Iterator it;
        String string;
        com.google.android.gms.internal.measurement.zzhz zzhzVarZzi;
        String strZzc;
        ArrayList arrayList3;
        Iterator it2;
        String strZzh;
        com.google.android.gms.internal.measurement.zzib zzibVar2;
        com.google.android.gms.internal.measurement.zzhz zzhzVar;
        int i2;
        com.google.android.gms.internal.measurement.zzhz zzhzVarZzh2;
        String strZzc2;
        zzot zzotVar;
        zzls zzlsVar;
        zzls zzlsVar2;
        com.google.android.gms.internal.measurement.zzic zzicVar;
        String strZzP;
        boolean z4;
        ArrayList arrayList4;
        Iterator it3;
        boolean z5;
        boolean z6;
        Long lValueOf;
        Long lValueOf2;
        boolean z7;
        boolean z8;
        boolean z9;
        List list;
        String str4;
        com.google.android.gms.internal.measurement.zzhs zzhsVar;
        com.google.android.gms.internal.measurement.zzhw zzhwVarZzF;
        com.google.android.gms.internal.measurement.zzhw zzhwVarZzF2;
        com.google.android.gms.internal.measurement.zzis zzisVarZzd;
        Iterator it4;
        String strZzG;
        int i3;
        com.google.android.gms.internal.measurement.zzid zzidVar;
        com.google.android.gms.internal.measurement.zzid zzidVar2;
        ArrayList arrayList5;
        zzav zzavVarZzj;
        ArrayList arrayList6;
        Cursor cursor;
        Cursor cursorQuery2;
        List listEmptyList2;
        boolean z10;
        com.google.android.gms.internal.measurement.zzic zzicVar2;
        com.google.android.gms.internal.measurement.zzgf zzgfVarZzx;
        ArrayList arrayList7;
        int i4;
        int i5;
        int i6;
        int iZzd;
        SQLiteDatabase sQLiteDatabaseZze;
        long jCurrentTimeMillis;
        long jZzg;
        long jZzg2;
        int iZzm = zzd().zzm(str, zzfy.zzg);
        int i7 = 0;
        int iMax = Math.max(0, zzd().zzm(str, zzfy.zzh));
        zzav zzavVarZzj2 = zzj();
        zzavVarZzj2.zzg();
        zzavVarZzj2.zzaw();
        int i8 = 1;
        Preconditions.checkArgument(iZzm > 0);
        ?? r10 = iMax > 0 ? 1 : 0;
        Preconditions.checkArgument(r10);
        Preconditions.checkNotEmpty(str);
        try {
            try {
                cursorQuery = zzavVarZzj2.zze().query("queue", new String[]{"rowid", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(iZzm));
                try {
                    if (cursorQuery.moveToFirst()) {
                        listSubList = new ArrayList();
                        int length = 0;
                        while (true) {
                            long j2 = cursorQuery.getLong(i7);
                            try {
                                byte[] blob = cursorQuery.getBlob(i8);
                                zzpk zzpkVarZzp = zzavVarZzj2.zzg.zzp();
                                try {
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(blob);
                                    GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int i9 = gZIPInputStream.read(bArr);
                                        if (i9 <= 0) {
                                            break;
                                        } else {
                                            byteArrayOutputStream.write(bArr, 0, i9);
                                        }
                                    }
                                    gZIPInputStream.close();
                                    byteArrayInputStream.close();
                                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                                    if (!listSubList.isEmpty() && byteArray.length + length > iMax) {
                                        break;
                                    }
                                    try {
                                        com.google.android.gms.internal.measurement.zzic zzicVar3 = (com.google.android.gms.internal.measurement.zzic) zzpk.zzw(com.google.android.gms.internal.measurement.zzid.zzaE(), byteArray);
                                        if (!listSubList.isEmpty()) {
                                            com.google.android.gms.internal.measurement.zzid zzidVar3 = (com.google.android.gms.internal.measurement.zzid) ((Pair) listSubList.get(0)).first;
                                            com.google.android.gms.internal.measurement.zzid zzidVar4 = (com.google.android.gms.internal.measurement.zzid) zzicVar3.zzbc();
                                            if (!zzidVar3.zzaf().equals(zzidVar4.zzaf()) || !zzidVar3.zzam().equals(zzidVar4.zzam()) || zzidVar3.zzao() != zzidVar4.zzao() || !zzidVar3.zzaq().equals(zzidVar4.zzaq())) {
                                                break;
                                            }
                                            Iterator it5 = zzidVar3.zzf().iterator();
                                            while (true) {
                                                if (!it5.hasNext()) {
                                                    jZzg = -1;
                                                    break;
                                                }
                                                com.google.android.gms.internal.measurement.zziu zziuVar = (com.google.android.gms.internal.measurement.zziu) it5.next();
                                                if ("_npa".equals(zziuVar.zzc())) {
                                                    jZzg = zziuVar.zzg();
                                                    break;
                                                }
                                            }
                                            Iterator it6 = zzidVar4.zzf().iterator();
                                            while (true) {
                                                if (!it6.hasNext()) {
                                                    jZzg2 = -1;
                                                    break;
                                                }
                                                com.google.android.gms.internal.measurement.zziu zziuVar2 = (com.google.android.gms.internal.measurement.zziu) it6.next();
                                                if ("_npa".equals(zziuVar2.zzc())) {
                                                    jZzg2 = zziuVar2.zzg();
                                                    break;
                                                }
                                            }
                                            if (jZzg != jZzg2) {
                                                break;
                                            }
                                        }
                                        if (!cursorQuery.isNull(2)) {
                                            zzicVar3.zzao(cursorQuery.getInt(2));
                                        }
                                        length += byteArray.length;
                                        listSubList.add(Pair.create((com.google.android.gms.internal.measurement.zzid) zzicVar3.zzbc(), Long.valueOf(j2)));
                                    } catch (IOException e) {
                                        zzavVarZzj2.zzu.zzaV().zzb().zzc("Failed to merge queued bundle. appId", zzgu.zzl(str), e);
                                    }
                                    if (!cursorQuery.moveToNext() || length > iMax) {
                                        break;
                                    }
                                    i7 = 0;
                                    i8 = 1;
                                } catch (IOException e2) {
                                    zzpkVarZzp.zzu.zzaV().zzb().zzb("Failed to ungzip content", e2);
                                    throw e2;
                                }
                            } catch (IOException e3) {
                                zzavVarZzj2.zzu.zzaV().zzb().zzc("Failed to unzip queued bundle. appId", zzgu.zzl(str), e3);
                            }
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    } else {
                        listEmptyList = Collections.emptyList();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        listSubList = listEmptyList;
                    }
                } catch (SQLiteException e4) {
                    e = e4;
                    zzavVarZzj2.zzu.zzaV().zzb().zzc("Error querying bundles. appId", zzgu.zzl(str), e);
                    listEmptyList = Collections.emptyList();
                    if (cursorQuery != null) {
                    }
                    listSubList = listEmptyList;
                    if (listSubList.isEmpty()) {
                        return;
                    }
                    com.google.android.gms.internal.measurement.zzpo.zza();
                    zzalVarZzd = zzd();
                    zzfxVar = zzfy.zzbh;
                    str2 = "_f";
                    if (zzalVarZzd.zzp(null, zzfxVar)) {
                        com.google.android.gms.internal.measurement.zzpo.zza();
                        if (zzd().zzp(null, zzfxVar)) {
                            if (zzB(str).zzo(zzjk.ANALYTICS_STORAGE)) {
                            }
                            arrayList5 = new ArrayList(listSubList.size());
                            zzavVarZzj = zzj();
                            Preconditions.checkNotEmpty(str);
                            zzavVarZzj.zzg();
                            zzavVarZzj.zzaw();
                            arrayList6 = new ArrayList();
                            try {
                                try {
                                    sQLiteDatabaseZze = zzavVarZzj.zze();
                                    jCurrentTimeMillis = zzavVarZzj.zzu.zzaZ().currentTimeMillis();
                                    cursorQuery2 = sQLiteDatabaseZze.query("no_data_mode_events", new String[]{Constants.ScionAnalytics.MessageType.DATA_MESSAGE}, "app_id=? AND timestamp_millis <= CAST(? AS INTEGER)", new String[]{str, String.valueOf(jCurrentTimeMillis)}, null, null, "rowid", null);
                                    try {
                                        try {
                                            if (cursorQuery2.moveToFirst()) {
                                                while (true) {
                                                    try {
                                                        arrayList6.add((com.google.android.gms.internal.measurement.zzhs) ((com.google.android.gms.internal.measurement.zzhr) zzpk.zzw(com.google.android.gms.internal.measurement.zzhs.zzk(), cursorQuery2.getBlob(0))).zzbc());
                                                    } catch (com.google.android.gms.internal.measurement.zzmr e5) {
                                                        zzavVarZzj.zzu.zzaV().zzh().zzc("Failed to parse stored NO_DATA mode event, appId", zzgu.zzl(str), e5);
                                                    }
                                                    try {
                                                        if (!cursorQuery2.moveToNext()) {
                                                            break;
                                                        }
                                                        arrayList6 = arrayList6;
                                                        str2 = str2;
                                                    } catch (SQLiteException e6) {
                                                        e = e6;
                                                        zzavVarZzj.zzu.zzaV().zzb().zzc("Error flushing NO_DATA mode events. appId", zzgu.zzl(str), e);
                                                        listEmptyList2 = Collections.emptyList();
                                                        if (cursorQuery2 != null) {
                                                            cursorQuery2.close();
                                                        }
                                                    }
                                                }
                                                cursorQuery2.close();
                                                try {
                                                    int iDelete = sQLiteDatabaseZze.delete("no_data_mode_events", "app_id=? AND timestamp_millis <= CAST(? AS INTEGER)", new String[]{str, String.valueOf(jCurrentTimeMillis)});
                                                    zzgs zzgsVarZzk = zzavVarZzj.zzu.zzaV().zzk();
                                                    StringBuilder sb = new StringBuilder(String.valueOf(iDelete).length() + 34);
                                                    sb.append("Pruned ");
                                                    sb.append(iDelete);
                                                    sb.append(" NO_DATA mode events. appId");
                                                    zzgsVarZzk.zzb(sb.toString(), str);
                                                } catch (SQLiteException e7) {
                                                    e = e7;
                                                    cursorQuery2 = null;
                                                    zzavVarZzj.zzu.zzaV().zzb().zzc("Error flushing NO_DATA mode events. appId", zzgu.zzl(str), e);
                                                    listEmptyList2 = Collections.emptyList();
                                                    if (cursorQuery2 != null) {
                                                        cursorQuery2.close();
                                                    }
                                                }
                                            } else {
                                                str2 = "_f";
                                                arrayList6 = arrayList6;
                                                if (cursorQuery2 != null) {
                                                    cursorQuery2.close();
                                                }
                                            }
                                            listEmptyList2 = arrayList6;
                                        } catch (SQLiteException e8) {
                                            e = e8;
                                            str2 = str2;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor = cursorQuery2;
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    cursor = null;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    throw th;
                                }
                            } catch (SQLiteException e9) {
                                e = e9;
                                str2 = "_f";
                            }
                            z10 = true;
                            for (Pair pair : listSubList) {
                                zzicVar2 = (com.google.android.gms.internal.measurement.zzic) ((com.google.android.gms.internal.measurement.zzid) pair.first).zzcl();
                                if (z10) {
                                    List listZzb = zzicVar2.zzb();
                                    zzicVar2.zzi();
                                    zzicVar2.zzh(listEmptyList2);
                                    zzicVar2.zzh(listZzb);
                                    z10 = false;
                                }
                                com.google.android.gms.internal.measurement.zzhh zzhhVarZzb = com.google.android.gms.internal.measurement.zzho.zzb();
                                zzgfVarZzx = zzh().zzx(str);
                                arrayList7 = new ArrayList();
                                if (zzgfVarZzx == null) {
                                    for (com.google.android.gms.internal.measurement.zzfu zzfuVar : zzgfVarZzx.zza()) {
                                        com.google.android.gms.internal.measurement.zzhk zzhkVarZza = com.google.android.gms.internal.measurement.zzhl.zza();
                                        int iZzb = zzfuVar.zzb();
                                        zzji zzjiVar = zzji.UNINITIALIZED;
                                        i4 = iZzb - 1;
                                        i5 = 3;
                                        if (i4 != 1) {
                                            i6 = 2;
                                        } else if (i4 != 2) {
                                            i6 = 3;
                                        } else if (i4 != 3) {
                                            i6 = 4;
                                        } else if (i4 != 4) {
                                            i6 = 1;
                                        } else {
                                            i6 = 5;
                                        }
                                        zzhkVarZza.zza(i6);
                                        iZzd = zzfuVar.zzd() - 1;
                                        if (iZzd != 1) {
                                            i5 = 2;
                                        } else if (iZzd != 2) {
                                            i5 = 1;
                                        }
                                        zzhkVarZza.zzb(i5);
                                        arrayList7.add((com.google.android.gms.internal.measurement.zzhl) zzhkVarZza.zzbc());
                                    }
                                }
                                zzhhVarZzb.zza(arrayList7);
                                zzicVar2.zzaQ(zzhhVarZzb);
                                arrayList5.add(Pair.create((com.google.android.gms.internal.measurement.zzid) zzicVar2.zzbc(), (Long) pair.second));
                            }
                            listSubList = arrayList5;
                        } else {
                            str2 = "_f";
                        }
                        if (listSubList.isEmpty()) {
                            return;
                        }
                    } else {
                        str2 = "_f";
                    }
                    zzjlVarZzB = zzB(str);
                    zzjkVar = zzjk.AD_STORAGE;
                    if (zzjlVarZzB.zzo(zzjkVar)) {
                        it4 = listSubList.iterator();
                        while (true) {
                            if (it4.hasNext()) {
                                strZzG = null;
                                break;
                            }
                            zzidVar2 = (com.google.android.gms.internal.measurement.zzid) ((Pair) it4.next()).first;
                            if (!zzidVar2.zzG().isEmpty()) {
                                strZzG = zzidVar2.zzG();
                                break;
                            }
                        }
                        if (strZzG != null) {
                            for (i3 = 0; i3 < listSubList.size(); i3++) {
                                zzidVar = (com.google.android.gms.internal.measurement.zzid) ((Pair) listSubList.get(i3)).first;
                                if (!zzidVar.zzG().isEmpty()) {
                                    listSubList = listSubList.subList(0, i3);
                                    break;
                                }
                            }
                        }
                    }
                    zzhzVarZzh = com.google.android.gms.internal.measurement.zzib.zzh();
                    size = listSubList.size();
                    arrayList = new ArrayList(listSubList.size());
                    if (zzd().zzC(str)) {
                        z = false;
                    } else {
                        z = false;
                    }
                    zZzo = zzB(str).zzo(zzjkVar);
                    zZzo2 = zzB(str).zzo(zzjk.ANALYTICS_STORAGE);
                    zzrb.zza();
                    zZzp = zzd().zzp(str, zzfy.zzaM);
                    zzouVar = this.zzl;
                    zzotVarZza = zzouVar.zza(str);
                    i = 0;
                    while (i < size) {
                        zzicVar = (com.google.android.gms.internal.measurement.zzic) ((com.google.android.gms.internal.measurement.zzid) ((Pair) listSubList.get(i)).first).zzcl();
                        arrayList.add((Long) ((Pair) listSubList.get(i)).second);
                        zzd().zzi();
                        zzicVar.zzO(133005L);
                        zzicVar.zzs(j);
                        int i10 = size;
                        this.zzn.zzaU();
                        zzicVar.zzae(false);
                        if (!z) {
                            zzicVar.zzan();
                        }
                        if (!zZzo) {
                            zzicVar.zzR();
                            zzicVar.zzU();
                        }
                        if (!zZzo2) {
                            zzicVar.zzX();
                        }
                        zzS(str, zzicVar);
                        if (!zZzp) {
                            zzicVar.zzav();
                        }
                        if (!zZzo2) {
                            zzicVar.zzag();
                        }
                        strZzP = zzicVar.zzP();
                        if (TextUtils.isEmpty(strZzP)) {
                            z4 = zZzo;
                        } else {
                            z4 = zZzo;
                            if (strZzP.equals("00000000-0000-0000-0000-000000000000")) {
                                z5 = z;
                                z6 = zZzo2;
                                z9 = zZzp;
                                list = listSubList;
                                str4 = str2;
                            }
                            if (zzicVar.zzc() != 0) {
                                if (zzd().zzp(str, zzfy.zzaC)) {
                                    zzicVar.zzas(zzp().zzt(((com.google.android.gms.internal.measurement.zzid) zzicVar.zzbc()).zzcc()));
                                }
                                zzisVarZzd = zzotVarZza.zzd();
                                if (zzisVarZzd != null) {
                                    zzicVar.zzaN(zzisVarZzd);
                                }
                                zzhzVarZzh.zze(zzicVar);
                            }
                            i++;
                            str2 = str4;
                            size = i10;
                            zZzo = z4;
                            z = z5;
                            zZzo2 = z6;
                            listSubList = list;
                            zZzp = z9;
                        }
                        arrayList4 = new ArrayList(zzicVar.zzb());
                        it3 = arrayList4.iterator();
                        z5 = z;
                        z6 = zZzo2;
                        lValueOf = null;
                        lValueOf2 = null;
                        z7 = false;
                        z8 = false;
                        while (it3.hasNext()) {
                            zZzp = zZzp;
                            zzhsVar = (com.google.android.gms.internal.measurement.zzhs) it3.next();
                            listSubList = listSubList;
                            if ("_fx".equals(zzhsVar.zzd())) {
                                it3.remove();
                                listSubList = listSubList;
                                zZzp = zZzp;
                                z7 = true;
                                z8 = true;
                            } else {
                                str2 = str2;
                                if (str2.equals(zzhsVar.zzd())) {
                                    zzp();
                                    zzhwVarZzF = zzpk.zzF(zzhsVar, "_pfo");
                                    if (zzhwVarZzF != null) {
                                        lValueOf = Long.valueOf(zzhwVarZzF.zzf());
                                    }
                                    zzp();
                                    zzhwVarZzF2 = zzpk.zzF(zzhsVar, "_uwa");
                                    if (zzhwVarZzF2 != null) {
                                        lValueOf2 = Long.valueOf(zzhwVarZzF2.zzf());
                                    }
                                    z8 = true;
                                }
                            }
                        }
                        z9 = zZzp;
                        list = listSubList;
                        str4 = str2;
                        if (z7) {
                            zzicVar.zzi();
                            zzicVar.zzh(arrayList4);
                        }
                        if (z8) {
                            zzR(zzicVar.zzK(), true, lValueOf, lValueOf2);
                        }
                        if (zzicVar.zzc() != 0) {
                            if (zzd().zzp(str, zzfy.zzaC)) {
                                zzicVar.zzas(zzp().zzt(((com.google.android.gms.internal.measurement.zzid) zzicVar.zzbc()).zzcc()));
                            }
                            zzisVarZzd = zzotVarZza.zzd();
                            if (zzisVarZzd != null) {
                                zzicVar.zzaN(zzisVarZzd);
                            }
                            zzhzVarZzh.zze(zzicVar);
                        }
                        i++;
                        str2 = str4;
                        size = i10;
                        zZzo = z4;
                        z = z5;
                        zZzo2 = z6;
                        listSubList = list;
                        zZzp = z9;
                    }
                    if (zzhzVarZzh.zzb() == 0) {
                        zzL(arrayList);
                        zzV(false, 204, null, null, str, Collections.emptyList());
                        return;
                    }
                    zzibVar = (com.google.android.gms.internal.measurement.zzib) zzhzVarZzh.zzbc();
                    arrayList2 = new ArrayList();
                    if (zzotVarZza.zzc() == zzls.SGTM_CLIENT) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (zzotVarZza.zzc() != zzls.SGTM) {
                        if (z2) {
                            z3 = true;
                        } else {
                            str3 = null;
                        }
                        if (zzi().zzb()) {
                            if (Log.isLoggable(zzaV().zzn(), 2)) {
                                strZzi = zzp().zzi(zzibVar);
                            } else {
                                strZzi = str3;
                            }
                            zzp();
                            byte[] bArrZzcc = zzibVar.zzcc();
                            zzL(arrayList);
                            this.zzk.zze.zzb(j);
                            zzaV().zzk().zzd("Uploading data. app, uncompressed size, data", str, Integer.valueOf(bArrZzcc.length), strZzi);
                            this.zzv = true;
                            zzi().zzc(str, zzotVarZza, zzibVar, new zzow(this, str, arrayList2));
                            return;
                        }
                        return;
                    }
                    z3 = z2;
                    it = ((com.google.android.gms.internal.measurement.zzib) zzhzVarZzh.zzbc()).zza().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((com.google.android.gms.internal.measurement.zzid) it.next()).zzY()) {
                                string = UUID.randomUUID().toString();
                                break;
                            }
                        } else {
                            string = null;
                            break;
                        }
                    }
                    com.google.android.gms.internal.measurement.zzib zzibVar3 = (com.google.android.gms.internal.measurement.zzib) zzhzVarZzh.zzbc();
                    zzaW().zzg();
                    zzu();
                    zzhzVarZzi = com.google.android.gms.internal.measurement.zzib.zzi(zzibVar3);
                    if (!TextUtils.isEmpty(string)) {
                        zzhzVarZzi.zzi(string);
                    }
                    strZzc = zzh().zzc(str);
                    if (!TextUtils.isEmpty(strZzc)) {
                        zzhzVarZzi.zzj(strZzc);
                    }
                    arrayList3 = new ArrayList();
                    it2 = zzibVar3.zza().iterator();
                    while (it2.hasNext()) {
                        com.google.android.gms.internal.measurement.zzic zzicVarZzaF = com.google.android.gms.internal.measurement.zzid.zzaF((com.google.android.gms.internal.measurement.zzid) it2.next());
                        zzicVarZzaF.zzan();
                        arrayList3.add((com.google.android.gms.internal.measurement.zzid) zzicVarZzaF.zzbc());
                    }
                    zzhzVarZzi.zzg();
                    zzhzVarZzi.zzf(arrayList3);
                    zzgs zzgsVarZzk2 = zzaV().zzk();
                    if (TextUtils.isEmpty(string)) {
                        strZzh = "null";
                    } else {
                        strZzh = zzhzVarZzi.zzh();
                    }
                    zzgsVarZzk2.zzb("[sgtm] Processed MeasurementBatch for sGTM with sgtmJoinId: ", strZzh);
                    zzibVar2 = (com.google.android.gms.internal.measurement.zzib) zzhzVarZzi.zzbc();
                    if (TextUtils.isEmpty(string)) {
                        str3 = null;
                    } else {
                        com.google.android.gms.internal.measurement.zzib zzibVar4 = (com.google.android.gms.internal.measurement.zzib) zzhzVarZzh.zzbc();
                        zzaW().zzg();
                        zzu();
                        zzhzVarZzh2 = com.google.android.gms.internal.measurement.zzib.zzh();
                        zzaV().zzk().zzb("[sgtm] Processing Google Signal, sgtmJoinId:", string);
                        zzhzVarZzh2.zzi(string);
                        for (com.google.android.gms.internal.measurement.zzid zzidVar5 : zzibVar4.zza()) {
                            com.google.android.gms.internal.measurement.zzic zzicVarZzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                            zzicVarZzaE.zzam(zzidVar5.zzZ());
                            zzicVarZzaE.zzaJ(zzidVar5.zzav());
                            zzhzVarZzh2.zze(zzicVarZzaE);
                        }
                        com.google.android.gms.internal.measurement.zzib zzibVar5 = (com.google.android.gms.internal.measurement.zzib) zzhzVarZzh2.zzbc();
                        strZzc2 = zzouVar.zzg.zzh().zzc(str);
                        if (TextUtils.isEmpty(strZzc2)) {
                            str3 = null;
                            String str5 = (String) zzfy.zzr.zzb(null);
                            if (z3) {
                                zzlsVar = zzls.GOOGLE_SIGNAL_PENDING;
                            } else {
                                zzlsVar = zzls.GOOGLE_SIGNAL;
                            }
                            zzotVar = new zzot(str5, Collections.emptyMap(), zzlsVar, null);
                        } else {
                            Uri uri = Uri.parse((String) zzfy.zzr.zzb(null));
                            Uri.Builder builderBuildUpon = uri.buildUpon();
                            String authority = uri.getAuthority();
                            StringBuilder sb2 = new StringBuilder(String.valueOf(strZzc2).length() + 1 + String.valueOf(authority).length());
                            sb2.append(strZzc2);
                            sb2.append(".");
                            sb2.append(authority);
                            builderBuildUpon.authority(sb2.toString());
                            String string2 = builderBuildUpon.build().toString();
                            if (z3) {
                                zzlsVar2 = zzls.GOOGLE_SIGNAL_PENDING;
                            } else {
                                zzlsVar2 = zzls.GOOGLE_SIGNAL;
                            }
                            str3 = null;
                            zzotVar = new zzot(string2, Collections.emptyMap(), zzlsVar2, null);
                        }
                        arrayList2.add(Pair.create(zzibVar5, zzotVar));
                    }
                    if (z3) {
                        zzibVar = zzibVar2;
                        if (zzi().zzb()) {
                            if (Log.isLoggable(zzaV().zzn(), 2)) {
                                strZzi = zzp().zzi(zzibVar);
                            } else {
                                strZzi = str3;
                            }
                            zzp();
                            byte[] bArrZzcc2 = zzibVar.zzcc();
                            zzL(arrayList);
                            this.zzk.zze.zzb(j);
                            zzaV().zzk().zzd("Uploading data. app, uncompressed size, data", str, Integer.valueOf(bArrZzcc2.length), strZzi);
                            this.zzv = true;
                            zzi().zzc(str, zzotVarZza, zzibVar, new zzow(this, str, arrayList2));
                            return;
                        }
                        return;
                    }
                    zzhzVar = (com.google.android.gms.internal.measurement.zzhz) zzibVar2.zzcl();
                    for (i2 = 0; i2 < zzibVar2.zzb(); i2++) {
                        com.google.android.gms.internal.measurement.zzic zzicVar4 = (com.google.android.gms.internal.measurement.zzic) zzibVar2.zzc(i2).zzcl();
                        zzicVar4.zzt();
                        zzicVar4.zzaO(j);
                        zzhzVar.zzd(i2, zzicVar4);
                    }
                    arrayList2.add(Pair.create((com.google.android.gms.internal.measurement.zzib) zzhzVar.zzbc(), zzotVarZza));
                    zzL(arrayList);
                    zzV(false, 204, null, null, str, arrayList2);
                    if (zzO(str, zzotVarZza.zza())) {
                        zzaV().zzk().zzb("[sgtm] Sending sgtm batches available notification to app", str);
                        Intent intent = new Intent();
                        intent.setAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
                        intent.setPackage(str);
                        zzaQ(this.zzn.zzaY(), intent);
                    }
                }
            } catch (SQLiteException e10) {
                e = e10;
                cursorQuery = null;
            } catch (Throwable th3) {
                th = th3;
                r13 = 0;
                if (r13 != 0) {
                    r13.close();
                }
                throw th;
            }
            if (listSubList.isEmpty()) {
                return;
            }
            com.google.android.gms.internal.measurement.zzpo.zza();
            zzalVarZzd = zzd();
            zzfxVar = zzfy.zzbh;
            str2 = "_f";
            if (zzalVarZzd.zzp(null, zzfxVar)) {
                com.google.android.gms.internal.measurement.zzpo.zza();
                if (zzd().zzp(null, zzfxVar)) {
                    str2 = "_f";
                } else if (zzB(str).zzo(zzjk.ANALYTICS_STORAGE) && zzh().zzB(str)) {
                    List listAsList = Arrays.asList(((String) zzfy.zzbi.zzb(null)).split(","));
                    for (Pair pair2 : listSubList) {
                        try {
                            zzj().zzH(((Long) pair2.second).longValue());
                            for (com.google.android.gms.internal.measurement.zzhs zzhsVar2 : ((com.google.android.gms.internal.measurement.zzid) pair2.first).zzc()) {
                                if (listAsList.contains(zzhsVar2.zzd())) {
                                    if (zzhsVar2.zzd().equals("_f") || zzhsVar2.zzd().equals("_v")) {
                                        com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzhsVar2.zzcl();
                                        zzp();
                                        zzpk.zzC(zzhrVar, "_dac", 1L);
                                        zzhsVar2 = (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc();
                                    }
                                    zzav zzavVarZzj3 = zzj();
                                    zzavVarZzj3.zzg();
                                    zzavVarZzj3.zzaw();
                                    Preconditions.checkNotNull(zzhsVar2);
                                    Preconditions.checkNotEmpty(str);
                                    zzic zzicVar5 = zzavVarZzj3.zzu;
                                    zzicVar5.zzaV().zzk().zzb("Caching events in NO_DATA mode", zzhsVar2);
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("app_id", str);
                                    contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzhsVar2.zzd());
                                    contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, zzhsVar2.zzcc());
                                    contentValues.put("timestamp_millis", Long.valueOf(zzhsVar2.zzf()));
                                    try {
                                        if (zzavVarZzj3.zze().insert("no_data_mode_events", null, contentValues) == -1) {
                                            try {
                                                zzicVar5.zzaV().zzb().zzb("Failed to insert NO_DATA mode event (got -1). appId", zzgu.zzl(str));
                                            } catch (SQLiteException e11) {
                                                e = e11;
                                                try {
                                                    zzavVarZzj3.zzu.zzaV().zzb().zzc("Error storing NO_DATA mode event. appId", zzgu.zzl(str), e);
                                                } catch (SQLiteException unused) {
                                                    zzaV().zzh().zzb("Failed handling NO_DATA mode bundles. appId", str);
                                                }
                                            }
                                        }
                                    } catch (SQLiteException e12) {
                                        e = e12;
                                    }
                                }
                            }
                        } catch (SQLiteException unused2) {
                        }
                    }
                    listSubList = Collections.emptyList();
                    str2 = "_f";
                } else {
                    arrayList5 = new ArrayList(listSubList.size());
                    zzavVarZzj = zzj();
                    Preconditions.checkNotEmpty(str);
                    zzavVarZzj.zzg();
                    zzavVarZzj.zzaw();
                    arrayList6 = new ArrayList();
                    sQLiteDatabaseZze = zzavVarZzj.zze();
                    jCurrentTimeMillis = zzavVarZzj.zzu.zzaZ().currentTimeMillis();
                    cursorQuery2 = sQLiteDatabaseZze.query("no_data_mode_events", new String[]{Constants.ScionAnalytics.MessageType.DATA_MESSAGE}, "app_id=? AND timestamp_millis <= CAST(? AS INTEGER)", new String[]{str, String.valueOf(jCurrentTimeMillis)}, null, null, "rowid", null);
                    if (cursorQuery2.moveToFirst()) {
                        while (true) {
                            arrayList6.add((com.google.android.gms.internal.measurement.zzhs) ((com.google.android.gms.internal.measurement.zzhr) zzpk.zzw(com.google.android.gms.internal.measurement.zzhs.zzk(), cursorQuery2.getBlob(0))).zzbc());
                            if (!cursorQuery2.moveToNext()) {
                                break;
                                break;
                            } else {
                                arrayList6 = arrayList6;
                                str2 = str2;
                            }
                        }
                        cursorQuery2.close();
                        int iDelete2 = sQLiteDatabaseZze.delete("no_data_mode_events", "app_id=? AND timestamp_millis <= CAST(? AS INTEGER)", new String[]{str, String.valueOf(jCurrentTimeMillis)});
                        zzgs zzgsVarZzk3 = zzavVarZzj.zzu.zzaV().zzk();
                        StringBuilder sb3 = new StringBuilder(String.valueOf(iDelete2).length() + 34);
                        sb3.append("Pruned ");
                        sb3.append(iDelete2);
                        sb3.append(" NO_DATA mode events. appId");
                        zzgsVarZzk3.zzb(sb3.toString(), str);
                    } else {
                        str2 = "_f";
                        arrayList6 = arrayList6;
                        if (cursorQuery2 != null) {
                            cursorQuery2.close();
                        }
                    }
                    listEmptyList2 = arrayList6;
                    z10 = true;
                    while (r0.hasNext()) {
                        zzicVar2 = (com.google.android.gms.internal.measurement.zzic) ((com.google.android.gms.internal.measurement.zzid) pair.first).zzcl();
                        if (z10 && !listEmptyList2.isEmpty()) {
                            List listZzb2 = zzicVar2.zzb();
                            zzicVar2.zzi();
                            zzicVar2.zzh(listEmptyList2);
                            zzicVar2.zzh(listZzb2);
                            z10 = false;
                        }
                        com.google.android.gms.internal.measurement.zzhh zzhhVarZzb2 = com.google.android.gms.internal.measurement.zzho.zzb();
                        zzgfVarZzx = zzh().zzx(str);
                        arrayList7 = new ArrayList();
                        if (zzgfVarZzx == null) {
                            while (r7.hasNext()) {
                                com.google.android.gms.internal.measurement.zzhk zzhkVarZza2 = com.google.android.gms.internal.measurement.zzhl.zza();
                                int iZzb2 = zzfuVar.zzb();
                                zzji zzjiVar2 = zzji.UNINITIALIZED;
                                i4 = iZzb2 - 1;
                                i5 = 3;
                                if (i4 != 1) {
                                    i6 = 2;
                                } else if (i4 != 2) {
                                    i6 = 3;
                                } else if (i4 != 3) {
                                    i6 = 4;
                                } else if (i4 != 4) {
                                    i6 = 1;
                                } else {
                                    i6 = 5;
                                }
                                zzhkVarZza2.zza(i6);
                                iZzd = zzfuVar.zzd() - 1;
                                if (iZzd != 1) {
                                    i5 = 2;
                                } else if (iZzd != 2) {
                                    i5 = 1;
                                }
                                zzhkVarZza2.zzb(i5);
                                arrayList7.add((com.google.android.gms.internal.measurement.zzhl) zzhkVarZza2.zzbc());
                            }
                        }
                        zzhhVarZzb2.zza(arrayList7);
                        zzicVar2.zzaQ(zzhhVarZzb2);
                        arrayList5.add(Pair.create((com.google.android.gms.internal.measurement.zzid) zzicVar2.zzbc(), (Long) pair.second));
                    }
                    listSubList = arrayList5;
                }
                if (listSubList.isEmpty()) {
                    return;
                }
            } else {
                str2 = "_f";
            }
            zzjlVarZzB = zzB(str);
            zzjkVar = zzjk.AD_STORAGE;
            if (zzjlVarZzB.zzo(zzjkVar)) {
                it4 = listSubList.iterator();
                while (true) {
                    if (it4.hasNext()) {
                        strZzG = null;
                        break;
                    }
                    zzidVar2 = (com.google.android.gms.internal.measurement.zzid) ((Pair) it4.next()).first;
                    if (!zzidVar2.zzG().isEmpty()) {
                        strZzG = zzidVar2.zzG();
                        break;
                    }
                }
                if (strZzG != null) {
                    while (i3 < listSubList.size()) {
                        zzidVar = (com.google.android.gms.internal.measurement.zzid) ((Pair) listSubList.get(i3)).first;
                        if (!zzidVar.zzG().isEmpty() && !zzidVar.zzG().equals(strZzG)) {
                            listSubList = listSubList.subList(0, i3);
                            break;
                        }
                    }
                }
            }
            zzhzVarZzh = com.google.android.gms.internal.measurement.zzib.zzh();
            size = listSubList.size();
            arrayList = new ArrayList(listSubList.size());
            if (zzd().zzC(str) || !zzB(str).zzo(zzjkVar)) {
                z = false;
            } else {
                z = true;
            }
            zZzo = zzB(str).zzo(zzjkVar);
            zZzo2 = zzB(str).zzo(zzjk.ANALYTICS_STORAGE);
            zzrb.zza();
            zZzp = zzd().zzp(str, zzfy.zzaM);
            zzouVar = this.zzl;
            zzotVarZza = zzouVar.zza(str);
            i = 0;
            while (i < size) {
                zzicVar = (com.google.android.gms.internal.measurement.zzic) ((com.google.android.gms.internal.measurement.zzid) ((Pair) listSubList.get(i)).first).zzcl();
                arrayList.add((Long) ((Pair) listSubList.get(i)).second);
                zzd().zzi();
                zzicVar.zzO(133005L);
                zzicVar.zzs(j);
                int i11 = size;
                this.zzn.zzaU();
                zzicVar.zzae(false);
                if (!z) {
                    zzicVar.zzan();
                }
                if (!zZzo) {
                    zzicVar.zzR();
                    zzicVar.zzU();
                }
                if (!zZzo2) {
                    zzicVar.zzX();
                }
                zzS(str, zzicVar);
                if (!zZzp) {
                    zzicVar.zzav();
                }
                if (!zZzo2) {
                    zzicVar.zzag();
                }
                strZzP = zzicVar.zzP();
                if (TextUtils.isEmpty(strZzP)) {
                    z4 = zZzo;
                    if (strZzP.equals("00000000-0000-0000-0000-000000000000")) {
                        z5 = z;
                        z6 = zZzo2;
                        z9 = zZzp;
                        list = listSubList;
                        str4 = str2;
                    }
                    if (zzicVar.zzc() != 0) {
                        if (zzd().zzp(str, zzfy.zzaC)) {
                            zzicVar.zzas(zzp().zzt(((com.google.android.gms.internal.measurement.zzid) zzicVar.zzbc()).zzcc()));
                        }
                        zzisVarZzd = zzotVarZza.zzd();
                        if (zzisVarZzd != null) {
                            zzicVar.zzaN(zzisVarZzd);
                        }
                        zzhzVarZzh.zze(zzicVar);
                    }
                    i++;
                    str2 = str4;
                    size = i11;
                    zZzo = z4;
                    z = z5;
                    zZzo2 = z6;
                    listSubList = list;
                    zZzp = z9;
                } else {
                    z4 = zZzo;
                }
                arrayList4 = new ArrayList(zzicVar.zzb());
                it3 = arrayList4.iterator();
                z5 = z;
                z6 = zZzo2;
                lValueOf = null;
                lValueOf2 = null;
                z7 = false;
                z8 = false;
                while (it3.hasNext()) {
                    zZzp = zZzp;
                    zzhsVar = (com.google.android.gms.internal.measurement.zzhs) it3.next();
                    listSubList = listSubList;
                    if ("_fx".equals(zzhsVar.zzd())) {
                        it3.remove();
                        listSubList = listSubList;
                        zZzp = zZzp;
                        z7 = true;
                        z8 = true;
                    } else {
                        str2 = str2;
                        if (str2.equals(zzhsVar.zzd())) {
                            zzp();
                            zzhwVarZzF = zzpk.zzF(zzhsVar, "_pfo");
                            if (zzhwVarZzF != null) {
                                lValueOf = Long.valueOf(zzhwVarZzF.zzf());
                            }
                            zzp();
                            zzhwVarZzF2 = zzpk.zzF(zzhsVar, "_uwa");
                            if (zzhwVarZzF2 != null) {
                                lValueOf2 = Long.valueOf(zzhwVarZzF2.zzf());
                            }
                            z8 = true;
                        }
                    }
                }
                z9 = zZzp;
                list = listSubList;
                str4 = str2;
                if (z7) {
                    zzicVar.zzi();
                    zzicVar.zzh(arrayList4);
                }
                if (z8) {
                    zzR(zzicVar.zzK(), true, lValueOf, lValueOf2);
                }
                if (zzicVar.zzc() != 0) {
                    if (zzd().zzp(str, zzfy.zzaC)) {
                        zzicVar.zzas(zzp().zzt(((com.google.android.gms.internal.measurement.zzid) zzicVar.zzbc()).zzcc()));
                    }
                    zzisVarZzd = zzotVarZza.zzd();
                    if (zzisVarZzd != null) {
                        zzicVar.zzaN(zzisVarZzd);
                    }
                    zzhzVarZzh.zze(zzicVar);
                }
                i++;
                str2 = str4;
                size = i11;
                zZzo = z4;
                z = z5;
                zZzo2 = z6;
                listSubList = list;
                zZzp = z9;
            }
            if (zzhzVarZzh.zzb() == 0) {
                zzL(arrayList);
                zzV(false, 204, null, null, str, Collections.emptyList());
                return;
            }
            zzibVar = (com.google.android.gms.internal.measurement.zzib) zzhzVarZzh.zzbc();
            arrayList2 = new ArrayList();
            if (zzotVarZza.zzc() == zzls.SGTM_CLIENT) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (zzotVarZza.zzc() != zzls.SGTM) {
                if (z2) {
                    z3 = true;
                } else {
                    str3 = null;
                }
                if (zzi().zzb()) {
                    if (Log.isLoggable(zzaV().zzn(), 2)) {
                        strZzi = zzp().zzi(zzibVar);
                    } else {
                        strZzi = str3;
                    }
                    zzp();
                    byte[] bArrZzcc3 = zzibVar.zzcc();
                    zzL(arrayList);
                    this.zzk.zze.zzb(j);
                    zzaV().zzk().zzd("Uploading data. app, uncompressed size, data", str, Integer.valueOf(bArrZzcc3.length), strZzi);
                    this.zzv = true;
                    zzi().zzc(str, zzotVarZza, zzibVar, new zzow(this, str, arrayList2));
                    return;
                }
                return;
            }
            z3 = z2;
            it = ((com.google.android.gms.internal.measurement.zzib) zzhzVarZzh.zzbc()).zza().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((com.google.android.gms.internal.measurement.zzid) it.next()).zzY()) {
                        string = UUID.randomUUID().toString();
                        break;
                    }
                } else {
                    string = null;
                    break;
                }
            }
            com.google.android.gms.internal.measurement.zzib zzibVar6 = (com.google.android.gms.internal.measurement.zzib) zzhzVarZzh.zzbc();
            zzaW().zzg();
            zzu();
            zzhzVarZzi = com.google.android.gms.internal.measurement.zzib.zzi(zzibVar6);
            if (!TextUtils.isEmpty(string)) {
                zzhzVarZzi.zzi(string);
            }
            strZzc = zzh().zzc(str);
            if (!TextUtils.isEmpty(strZzc)) {
                zzhzVarZzi.zzj(strZzc);
            }
            arrayList3 = new ArrayList();
            it2 = zzibVar6.zza().iterator();
            while (it2.hasNext()) {
                com.google.android.gms.internal.measurement.zzic zzicVarZzaF2 = com.google.android.gms.internal.measurement.zzid.zzaF((com.google.android.gms.internal.measurement.zzid) it2.next());
                zzicVarZzaF2.zzan();
                arrayList3.add((com.google.android.gms.internal.measurement.zzid) zzicVarZzaF2.zzbc());
            }
            zzhzVarZzi.zzg();
            zzhzVarZzi.zzf(arrayList3);
            zzgs zzgsVarZzk4 = zzaV().zzk();
            if (TextUtils.isEmpty(string)) {
                strZzh = "null";
            } else {
                strZzh = zzhzVarZzi.zzh();
            }
            zzgsVarZzk4.zzb("[sgtm] Processed MeasurementBatch for sGTM with sgtmJoinId: ", strZzh);
            zzibVar2 = (com.google.android.gms.internal.measurement.zzib) zzhzVarZzi.zzbc();
            if (TextUtils.isEmpty(string)) {
                com.google.android.gms.internal.measurement.zzib zzibVar7 = (com.google.android.gms.internal.measurement.zzib) zzhzVarZzh.zzbc();
                zzaW().zzg();
                zzu();
                zzhzVarZzh2 = com.google.android.gms.internal.measurement.zzib.zzh();
                zzaV().zzk().zzb("[sgtm] Processing Google Signal, sgtmJoinId:", string);
                zzhzVarZzh2.zzi(string);
                while (r0.hasNext()) {
                    com.google.android.gms.internal.measurement.zzic zzicVarZzaE2 = com.google.android.gms.internal.measurement.zzid.zzaE();
                    zzicVarZzaE2.zzam(zzidVar5.zzZ());
                    zzicVarZzaE2.zzaJ(zzidVar5.zzav());
                    zzhzVarZzh2.zze(zzicVarZzaE2);
                }
                com.google.android.gms.internal.measurement.zzib zzibVar8 = (com.google.android.gms.internal.measurement.zzib) zzhzVarZzh2.zzbc();
                strZzc2 = zzouVar.zzg.zzh().zzc(str);
                if (TextUtils.isEmpty(strZzc2)) {
                    Uri uri2 = Uri.parse((String) zzfy.zzr.zzb(null));
                    Uri.Builder builderBuildUpon2 = uri2.buildUpon();
                    String authority2 = uri2.getAuthority();
                    StringBuilder sb4 = new StringBuilder(String.valueOf(strZzc2).length() + 1 + String.valueOf(authority2).length());
                    sb4.append(strZzc2);
                    sb4.append(".");
                    sb4.append(authority2);
                    builderBuildUpon2.authority(sb4.toString());
                    String string3 = builderBuildUpon2.build().toString();
                    if (z3) {
                        zzlsVar2 = zzls.GOOGLE_SIGNAL_PENDING;
                    } else {
                        zzlsVar2 = zzls.GOOGLE_SIGNAL;
                    }
                    str3 = null;
                    zzotVar = new zzot(string3, Collections.emptyMap(), zzlsVar2, null);
                } else {
                    str3 = null;
                    String str6 = (String) zzfy.zzr.zzb(null);
                    if (z3) {
                        zzlsVar = zzls.GOOGLE_SIGNAL_PENDING;
                    } else {
                        zzlsVar = zzls.GOOGLE_SIGNAL;
                    }
                    zzotVar = new zzot(str6, Collections.emptyMap(), zzlsVar, null);
                }
                arrayList2.add(Pair.create(zzibVar8, zzotVar));
            } else {
                str3 = null;
            }
            if (z3) {
                zzibVar = zzibVar2;
                if (zzi().zzb()) {
                    if (Log.isLoggable(zzaV().zzn(), 2)) {
                        strZzi = zzp().zzi(zzibVar);
                    } else {
                        strZzi = str3;
                    }
                    zzp();
                    byte[] bArrZzcc4 = zzibVar.zzcc();
                    zzL(arrayList);
                    this.zzk.zze.zzb(j);
                    zzaV().zzk().zzd("Uploading data. app, uncompressed size, data", str, Integer.valueOf(bArrZzcc4.length), strZzi);
                    this.zzv = true;
                    zzi().zzc(str, zzotVarZza, zzibVar, new zzow(this, str, arrayList2));
                    return;
                }
                return;
            }
            zzhzVar = (com.google.android.gms.internal.measurement.zzhz) zzibVar2.zzcl();
            while (i2 < zzibVar2.zzb()) {
                com.google.android.gms.internal.measurement.zzic zzicVar6 = (com.google.android.gms.internal.measurement.zzic) zzibVar2.zzc(i2).zzcl();
                zzicVar6.zzt();
                zzicVar6.zzaO(j);
                zzhzVar.zzd(i2, zzicVar6);
            }
            arrayList2.add(Pair.create((com.google.android.gms.internal.measurement.zzib) zzhzVar.zzbc(), zzotVarZza));
            zzL(arrayList);
            zzV(false, 204, null, null, str, arrayList2);
            if (zzO(str, zzotVarZza.zza())) {
                zzaV().zzk().zzb("[sgtm] Sending sgtm batches available notification to app", str);
                Intent intent2 = new Intent();
                intent2.setAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
                intent2.setPackage(str);
                zzaQ(this.zzn.zzaY(), intent2);
            }
        } catch (Throwable th4) {
            th = th4;
            r13 = r10;
            if (r13 != 0) {
                r13.close();
            }
            throw th;
        }
    }

    final boolean zzO(String str, String str2) throws Throwable {
        zzh zzhVarZzu = zzj().zzu(str);
        if (zzhVarZzu != null && zzt().zzaa(str, zzhVarZzu.zzay())) {
            this.zzF.remove(str2);
            return true;
        }
        zzpe zzpeVar = (zzpe) this.zzF.get(str2);
        if (zzpeVar == null) {
            return true;
        }
        return zzpeVar.zzb();
    }

    final void zzP(String str) {
        com.google.android.gms.internal.measurement.zzib zzibVarZzd;
        zzaW().zzg();
        zzu();
        this.zzw = true;
        try {
            zzic zzicVar = this.zzn;
            zzicVar.zzaU();
            Boolean boolZzJ = zzicVar.zzt().zzJ();
            if (boolZzJ == null) {
                zzaV().zze().zza("Upload data called on the client side before use of service was decided");
            } else if (boolZzJ.booleanValue()) {
                zzaV().zzb().zza("Upload called in the client side when service should be used");
            } else if (this.zza > 0) {
                zzaL();
            } else if (!zzi().zzb()) {
                zzaV().zzk().zza("Network not connected, ignoring upload request");
                zzaL();
            } else if (zzj().zzD(str)) {
                zzav zzavVarZzj = zzj();
                Preconditions.checkNotEmpty(str);
                zzavVarZzj.zzg();
                zzavVarZzj.zzaw();
                List listZzC = zzavVarZzj.zzC(str, zzoo.zza(zzls.GOOGLE_SIGNAL), 1);
                zzpj zzpjVar = listZzC.isEmpty() ? null : (zzpj) listZzC.get(0);
                if (zzpjVar != null && (zzibVarZzd = zzpjVar.zzd()) != null) {
                    zzaV().zzk().zzd("[sgtm] Uploading data from upload queue. appId, type, url", str, zzpjVar.zzf(), zzpjVar.zze());
                    byte[] bArrZzcc = zzibVarZzd.zzcc();
                    if (Log.isLoggable(zzaV().zzn(), 2)) {
                        zzaV().zzk().zzd("[sgtm] Uploading data from upload queue. appId, uncompressed size, data", str, Integer.valueOf(bArrZzcc.length), zzp().zzi(zzibVarZzd));
                    }
                    zzot zzotVarZza = zzpjVar.zza();
                    this.zzv = true;
                    zzi().zzc(str, zzotVarZza, zzibVarZzd, new zzox(this, str, zzpjVar));
                }
            } else {
                zzaV().zzk().zzb("[sgtm] Upload queue has no batches for appId", str);
            }
        } finally {
            this.zzw = false;
            zzaM();
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001e A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:4:0x000d, B:19:0x005a, B:22:0x0080, B:13:0x001e, B:15:0x0048, B:17:0x0052, B:18:0x0056), top: B:27:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0056 A[Catch: all -> 0x0010, TryCatch #0 {all -> 0x0010, blocks: (B:4:0x000d, B:19:0x005a, B:22:0x0080, B:13:0x001e, B:15:0x0048, B:17:0x0052, B:18:0x0056), top: B:27:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:19:0x005a A[Catch: all -> 0x0010, PHI: r5
  0x005a: PHI (r5v7 int) = (r5v1 int), (r5v0 int) binds: [B:12:0x001c, B:10:0x0019] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0010, blocks: (B:4:0x000d, B:19:0x005a, B:22:0x0080, B:13:0x001e, B:15:0x0048, B:17:0x0052, B:18:0x0056), top: B:27:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:21:0x007f  */
    final void zzQ(String str, int i, Throwable th, byte[] bArr, zzpj zzpjVar) {
        String strSubstring;
        Object obj;
        zzaW().zzg();
        zzu();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } finally {
                this.zzv = false;
                zzaM();
            }
        }
        if (i == 200) {
            if (th == null) {
                zzj().zzE(Long.valueOf(zzpjVar.zzc()));
                zzaV().zzk().zzc("Successfully uploaded batch from upload queue. appId, status", str, Integer.valueOf(i));
                if (zzi().zzb() || !zzj().zzD(str)) {
                    zzaL();
                } else {
                    zzP(str);
                }
            } else {
                String str2 = new String(bArr, StandardCharsets.UTF_8);
                strSubstring = str2.substring(0, Math.min(32, str2.length()));
                zzgs zzgsVarZzh = zzaV().zzh();
                Integer numValueOf = Integer.valueOf(i);
                obj = th;
                if (th == null) {
                    obj = strSubstring;
                }
                zzgsVarZzh.zzd("Network upload failed. Will retry later. appId, status, error", str, numValueOf, obj);
                zzj().zzK(Long.valueOf(zzpjVar.zzc()));
                zzaL();
            }
        } else if (i == 204) {
            i = 204;
            if (th == null) {
                zzj().zzE(Long.valueOf(zzpjVar.zzc()));
                zzaV().zzk().zzc("Successfully uploaded batch from upload queue. appId, status", str, Integer.valueOf(i));
                if (zzi().zzb()) {
                    zzaL();
                } else {
                    zzaL();
                }
            } else {
                String str3 = new String(bArr, StandardCharsets.UTF_8);
                strSubstring = str3.substring(0, Math.min(32, str3.length()));
                zzgs zzgsVarZzh2 = zzaV().zzh();
                Integer numValueOf2 = Integer.valueOf(i);
                obj = th;
                if (th == null) {
                    obj = strSubstring;
                }
                zzgsVarZzh2.zzd("Network upload failed. Will retry later. appId, status, error", str, numValueOf2, obj);
                zzj().zzK(Long.valueOf(zzpjVar.zzc()));
                zzaL();
            }
        } else {
            String str4 = new String(bArr, StandardCharsets.UTF_8);
            strSubstring = str4.substring(0, Math.min(32, str4.length()));
            zzgs zzgsVarZzh3 = zzaV().zzh();
            Integer numValueOf3 = Integer.valueOf(i);
            obj = th;
            if (th == null) {
                obj = strSubstring;
            }
            zzgsVarZzh3.zzd("Network upload failed. Will retry later. appId, status, error", str, numValueOf3, obj);
            zzj().zzK(Long.valueOf(zzpjVar.zzc()));
            zzaL();
        }
    }

    final void zzR(String str, boolean z, Long l, Long l2) throws Throwable {
        zzh zzhVarZzu = zzj().zzu(str);
        if (zzhVarZzu != null) {
            zzhVarZzu.zzar(z);
            zzhVarZzu.zzat(l);
            zzhVarZzu.zzav(l2);
            if (zzhVarZzu.zza()) {
                zzj().zzv(zzhVarZzu, false, false);
            }
        }
    }

    final void zzS(String str, com.google.android.gms.internal.measurement.zzic zzicVar) {
        int iZzx;
        int iIndexOf;
        Set setZzl = zzh().zzl(str);
        if (setZzl != null) {
            zzicVar.zzaw(setZzl);
        }
        if (zzh().zzp(str)) {
            zzicVar.zzG();
        }
        if (zzh().zzq(str)) {
            String strZzD = zzicVar.zzD();
            if (!TextUtils.isEmpty(strZzD) && (iIndexOf = strZzD.indexOf(".")) != -1) {
                zzicVar.zzE(strZzD.substring(0, iIndexOf));
            }
        }
        if (zzh().zzr(str) && (iZzx = zzpk.zzx(zzicVar, "_id")) != -1) {
            zzicVar.zzr(iZzx);
        }
        if (zzh().zzs(str)) {
            zzicVar.zzan();
        }
        if (zzh().zzt(str)) {
            zzicVar.zzX();
            if (zzB(str).zzo(zzjk.ANALYTICS_STORAGE)) {
                Map map = this.zzE;
                zzpd zzpdVar = (zzpd) map.get(str);
                if (zzpdVar == null || zzpdVar.zzb + zzd().zzl(str, zzfy.zzak) < zzaZ().elapsedRealtime()) {
                    zzpdVar = new zzpd(this, (byte[]) null);
                    map.put(str, zzpdVar);
                }
                zzicVar.zzax(zzpdVar.zza);
            }
        }
        if (zzh().zzu(str)) {
            zzicVar.zzav();
        }
    }

    final void zzT(com.google.android.gms.internal.measurement.zzic zzicVar, zzpc zzpcVar) {
        for (int i = 0; i < zzicVar.zzc(); i++) {
            com.google.android.gms.internal.measurement.zzhr zzhrVar = (com.google.android.gms.internal.measurement.zzhr) zzicVar.zzd(i).zzcl();
            Iterator it = zzhrVar.zza().iterator();
            while (it.hasNext()) {
                if ("_c".equals(((com.google.android.gms.internal.measurement.zzhw) it.next()).zzb())) {
                    if (zzpcVar.zza.zzar() >= zzd().zzm(zzpcVar.zza.zzA(), zzfy.zzal)) {
                        int iZzm = zzd().zzm(zzpcVar.zza.zzA(), zzfy.zzay);
                        String strZzaw = null;
                        if (iZzm <= 0) {
                            if (zzd().zzp(zzpcVar.zza.zzA(), zzfy.zzaR)) {
                                strZzaw = zzt().zzaw();
                                com.google.android.gms.internal.measurement.zzhv zzhvVarZzn = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzhvVarZzn.zzb("_tu");
                                zzhvVarZzn.zzd(strZzaw);
                                zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn.zzbc());
                            }
                            com.google.android.gms.internal.measurement.zzhv zzhvVarZzn2 = com.google.android.gms.internal.measurement.zzhw.zzn();
                            zzhvVarZzn2.zzb("_tr");
                            zzhvVarZzn2.zzf(1L);
                            zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn2.zzbc());
                            zzoh zzohVarZzf = zzp().zzf(zzpcVar.zza.zzA(), zzicVar, zzhrVar, strZzaw);
                            if (zzohVarZzf != null) {
                                zzaV().zzk().zzc("Generated trigger URI. appId, uri", zzpcVar.zza.zzA(), zzohVarZzf.zza);
                                zzj().zzY(zzpcVar.zza.zzA(), zzohVarZzf);
                                Deque deque = this.zzr;
                                if (!deque.contains(zzpcVar.zza.zzA())) {
                                    deque.add(zzpcVar.zza.zzA());
                                }
                            }
                        } else if (zzj().zzw(zzC(), zzpcVar.zza.zzA(), false, false, false, false, false, false, true).zzg > iZzm) {
                            com.google.android.gms.internal.measurement.zzhv zzhvVarZzn3 = com.google.android.gms.internal.measurement.zzhw.zzn();
                            zzhvVarZzn3.zzb("_tnr");
                            zzhvVarZzn3.zzf(1L);
                            zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn3.zzbc());
                        } else {
                            if (zzd().zzp(zzpcVar.zza.zzA(), zzfy.zzaR)) {
                                strZzaw = zzt().zzaw();
                                com.google.android.gms.internal.measurement.zzhv zzhvVarZzn4 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzhvVarZzn4.zzb("_tu");
                                zzhvVarZzn4.zzd(strZzaw);
                                zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn4.zzbc());
                            }
                            com.google.android.gms.internal.measurement.zzhv zzhvVarZzn5 = com.google.android.gms.internal.measurement.zzhw.zzn();
                            zzhvVarZzn5.zzb("_tr");
                            zzhvVarZzn5.zzf(1L);
                            zzhrVar.zzf((com.google.android.gms.internal.measurement.zzhw) zzhvVarZzn5.zzbc());
                            zzoh zzohVarZzf2 = zzp().zzf(zzpcVar.zza.zzA(), zzicVar, zzhrVar, strZzaw);
                            if (zzohVarZzf2 != null) {
                                zzaV().zzk().zzc("Generated trigger URI. appId, uri", zzpcVar.zza.zzA(), zzohVarZzf2.zza);
                                zzj().zzY(zzpcVar.zza.zzA(), zzohVarZzf2);
                                Deque deque2 = this.zzr;
                                if (!deque2.contains(zzpcVar.zza.zzA())) {
                                    deque2.add(zzpcVar.zza.zzA());
                                }
                            }
                        }
                    }
                    zzicVar.zze(i, (com.google.android.gms.internal.measurement.zzhs) zzhrVar.zzbc());
                    break;
                }
            }
        }
    }

    final void zzU(String str, com.google.android.gms.internal.measurement.zzhv zzhvVar, Bundle bundle, String str2) {
        List listListOf = CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"});
        long jZzf = (zzpp.zzZ(zzhvVar.zza()) || zzpp.zzZ(str)) ? zzd().zzf(str2, true) : zzd().zze(str2, true);
        long jCodePointCount = zzhvVar.zzc().codePointCount(0, zzhvVar.zzc().length());
        zzpp zzppVarZzt = zzt();
        String strZza = zzhvVar.zza();
        zzd();
        String strZzC = zzppVarZzt.zzC(strZza, 40, true);
        if (jCodePointCount <= jZzf || listListOf.contains(zzhvVar.zza())) {
            return;
        }
        if ("_ev".equals(zzhvVar.zza())) {
            bundle.putString("_ev", zzt().zzC(zzhvVar.zzc(), zzd().zzf(str2, true), true));
            return;
        }
        zzaV().zzh().zzc("Param value is too long; discarded. Name, value length", strZzC, Long.valueOf(jCodePointCount));
        if (bundle.getLong("_err") == 0) {
            bundle.putLong("_err", 4L);
            if (bundle.getString("_ev") == null) {
                bundle.putString("_ev", strZzC);
                bundle.putLong("_el", jCodePointCount);
            }
        }
        bundle.remove(zzhvVar.zza());
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0176 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:102:0x0159 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:20:0x008b A[Catch: all -> 0x0290, PHI: r0
  0x008b: PHI (r0v2 int) = (r0v0 int), (r0v37 int) binds: [B:7:0x0026, B:13:0x0031] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {all -> 0x0290, blocks: (B:4:0x0015, B:6:0x001a, B:14:0x0033, B:19:0x007f, B:18:0x0070, B:20:0x008b, B:22:0x00a2, B:23:0x00b1, B:25:0x00bf, B:27:0x00df, B:66:0x0216, B:68:0x0229, B:70:0x0233, B:78:0x0253, B:72:0x0239, B:74:0x0243, B:76:0x0249, B:77:0x024d, B:80:0x0257, B:81:0x025e, B:26:0x00d2, B:83:0x0260), top: B:89:0x0015, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x00bf A[Catch: SQLiteException -> 0x025f, all -> 0x0290, TryCatch #2 {SQLiteException -> 0x025f, blocks: (B:22:0x00a2, B:23:0x00b1, B:25:0x00bf, B:27:0x00df, B:66:0x0216, B:68:0x0229, B:70:0x0233, B:78:0x0253, B:72:0x0239, B:74:0x0243, B:76:0x0249, B:77:0x024d, B:80:0x0257, B:81:0x025e, B:26:0x00d2), top: B:91:0x00a2, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x00d2 A[Catch: SQLiteException -> 0x025f, all -> 0x0290, TryCatch #2 {SQLiteException -> 0x025f, blocks: (B:22:0x00a2, B:23:0x00b1, B:25:0x00bf, B:27:0x00df, B:66:0x0216, B:68:0x0229, B:70:0x0233, B:78:0x0253, B:72:0x0239, B:74:0x0243, B:76:0x0249, B:77:0x024d, B:80:0x0257, B:81:0x025e, B:26:0x00d2), top: B:91:0x00a2, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x00f7 A[Catch: all -> 0x0256, TryCatch #1 {all -> 0x0256, blocks: (B:28:0x00e6, B:29:0x00ef, B:31:0x00f7, B:33:0x0111, B:37:0x013c, B:39:0x0146, B:41:0x0154, B:42:0x0159, B:44:0x015f, B:46:0x0176, B:47:0x0198, B:49:0x01b1, B:51:0x01d4, B:52:0x01e5, B:53:0x01e9, B:55:0x01ef, B:56:0x01f6, B:59:0x0203, B:61:0x0207, B:64:0x020e, B:65:0x020f), top: B:90:0x00e6, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0138  */
    /* JADX WARN: Code duplicated, block: B:44:0x015f A[Catch: all -> 0x0256, TryCatch #1 {all -> 0x0256, blocks: (B:28:0x00e6, B:29:0x00ef, B:31:0x00f7, B:33:0x0111, B:37:0x013c, B:39:0x0146, B:41:0x0154, B:42:0x0159, B:44:0x015f, B:46:0x0176, B:47:0x0198, B:49:0x01b1, B:51:0x01d4, B:52:0x01e5, B:53:0x01e9, B:55:0x01ef, B:56:0x01f6, B:59:0x0203, B:61:0x0207, B:64:0x020e, B:65:0x020f), top: B:90:0x00e6, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x01b1 A[Catch: all -> 0x0256, TryCatch #1 {all -> 0x0256, blocks: (B:28:0x00e6, B:29:0x00ef, B:31:0x00f7, B:33:0x0111, B:37:0x013c, B:39:0x0146, B:41:0x0154, B:42:0x0159, B:44:0x015f, B:46:0x0176, B:47:0x0198, B:49:0x01b1, B:51:0x01d4, B:52:0x01e5, B:53:0x01e9, B:55:0x01ef, B:56:0x01f6, B:59:0x0203, B:61:0x0207, B:64:0x020e, B:65:0x020f), top: B:90:0x00e6, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x01d4 A[Catch: all -> 0x0256, TryCatch #1 {all -> 0x0256, blocks: (B:28:0x00e6, B:29:0x00ef, B:31:0x00f7, B:33:0x0111, B:37:0x013c, B:39:0x0146, B:41:0x0154, B:42:0x0159, B:44:0x015f, B:46:0x0176, B:47:0x0198, B:49:0x01b1, B:51:0x01d4, B:52:0x01e5, B:53:0x01e9, B:55:0x01ef, B:56:0x01f6, B:59:0x0203, B:61:0x0207, B:64:0x020e, B:65:0x020f), top: B:90:0x00e6, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x01ef A[Catch: all -> 0x0256, TRY_LEAVE, TryCatch #1 {all -> 0x0256, blocks: (B:28:0x00e6, B:29:0x00ef, B:31:0x00f7, B:33:0x0111, B:37:0x013c, B:39:0x0146, B:41:0x0154, B:42:0x0159, B:44:0x015f, B:46:0x0176, B:47:0x0198, B:49:0x01b1, B:51:0x01d4, B:52:0x01e5, B:53:0x01e9, B:55:0x01ef, B:56:0x01f6, B:59:0x0203, B:61:0x0207, B:64:0x020e, B:65:0x020f), top: B:90:0x00e6, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0229 A[Catch: SQLiteException -> 0x025f, all -> 0x0290, TryCatch #2 {SQLiteException -> 0x025f, blocks: (B:22:0x00a2, B:23:0x00b1, B:25:0x00bf, B:27:0x00df, B:66:0x0216, B:68:0x0229, B:70:0x0233, B:78:0x0253, B:72:0x0239, B:74:0x0243, B:76:0x0249, B:77:0x024d, B:80:0x0257, B:81:0x025e, B:26:0x00d2), top: B:91:0x00a2, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0239 A[Catch: SQLiteException -> 0x025f, all -> 0x0290, TryCatch #2 {SQLiteException -> 0x025f, blocks: (B:22:0x00a2, B:23:0x00b1, B:25:0x00bf, B:27:0x00df, B:66:0x0216, B:68:0x0229, B:70:0x0233, B:78:0x0253, B:72:0x0239, B:74:0x0243, B:76:0x0249, B:77:0x024d, B:80:0x0257, B:81:0x025e, B:26:0x00d2), top: B:91:0x00a2, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0243 A[Catch: SQLiteException -> 0x025f, all -> 0x0290, TryCatch #2 {SQLiteException -> 0x025f, blocks: (B:22:0x00a2, B:23:0x00b1, B:25:0x00bf, B:27:0x00df, B:66:0x0216, B:68:0x0229, B:70:0x0233, B:78:0x0253, B:72:0x0239, B:74:0x0243, B:76:0x0249, B:77:0x024d, B:80:0x0257, B:81:0x025e, B:26:0x00d2), top: B:91:0x00a2, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x024d A[Catch: SQLiteException -> 0x025f, all -> 0x0290, TryCatch #2 {SQLiteException -> 0x025f, blocks: (B:22:0x00a2, B:23:0x00b1, B:25:0x00bf, B:27:0x00df, B:66:0x0216, B:68:0x0229, B:70:0x0233, B:78:0x0253, B:72:0x0239, B:74:0x0243, B:76:0x0249, B:77:0x024d, B:80:0x0257, B:81:0x025e, B:26:0x00d2), top: B:91:0x00a2, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x0111 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:0x00ef A[SYNTHETIC] */
    final void zzV(boolean z, int i, Throwable th, byte[] bArr, String str, List list) {
        byte[] bArr2;
        Integer numValueOf;
        HashMap map;
        Iterator it;
        Iterator it2;
        List listZzC;
        long jZzg;
        com.google.android.gms.internal.measurement.zzib zzibVar;
        zzot zzotVar;
        com.google.android.gms.internal.measurement.zzib zzibVar2;
        zzot zzotVar2;
        long jZzA;
        int i2 = i;
        zzaW().zzg();
        zzu();
        if (bArr == null) {
            try {
                bArr2 = new byte[0];
            } catch (Throwable th2) {
                this.zzv = false;
                zzaM();
                throw th2;
            }
        } else {
            bArr2 = bArr;
        }
        List<Long> list2 = (List) Preconditions.checkNotNull(this.zzz);
        this.zzz = null;
        if (z) {
            if (i2 == 200) {
                if (th != null) {
                    zzgs zzgsVarZzk = zzaV().zzk();
                    numValueOf = Integer.valueOf(i2);
                    zzgsVarZzk.zzc("Network upload successful with code, uploadAttempted", numValueOf, Boolean.valueOf(z));
                    if (z) {
                        this.zzk.zzd.zzb(zzaZ().currentTimeMillis());
                    }
                    this.zzk.zze.zzb(0L);
                    zzaL();
                    if (z) {
                        zzaV().zzk().zzc("Successful upload. Got network response. code, size", numValueOf, Integer.valueOf(bArr2.length));
                    } else {
                        zzaV().zzk().zza("Purged empty bundles");
                    }
                    zzj().zzb();
                    map = new HashMap();
                    it = list.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        zzibVar2 = (com.google.android.gms.internal.measurement.zzib) pair.first;
                        zzotVar2 = (zzot) pair.second;
                        if (zzotVar2.zzc() != zzls.SGTM_CLIENT) {
                            jZzA = zzj().zzA(str, zzibVar2, zzotVar2.zza(), zzotVar2.zzb(), zzotVar2.zzc(), null);
                            if (zzotVar2.zzc() == zzls.GOOGLE_SIGNAL_PENDING) {
                                map.put(zzibVar2.zze(), Long.valueOf(jZzA));
                            }
                        }
                    }
                    it2 = list.iterator();
                    while (it2.hasNext()) {
                        Pair pair2 = (Pair) it2.next();
                        zzibVar = (com.google.android.gms.internal.measurement.zzib) pair2.first;
                        zzotVar = (zzot) pair2.second;
                        if (zzotVar.zzc() == zzls.SGTM_CLIENT) {
                            zzj().zzA(str, zzibVar, zzotVar.zza(), zzotVar.zzb(), zzotVar.zzc(), (Long) map.get(zzibVar.zze()));
                        }
                    }
                    listZzC = zzj().zzC(str, zzoo.zza(zzls.SGTM_CLIENT), 1);
                    if (!listZzC.isEmpty()) {
                        jZzg = ((zzpj) listZzC.get(0)).zzg();
                        if (zzaZ().currentTimeMillis() > ((Long) zzfy.zzE.zzb(null)).longValue() + jZzg) {
                            zzaV().zze().zzc("[sgtm] client batches are queued too long. appId, creationTime", str, Long.valueOf(jZzg));
                        }
                    }
                    for (Long l : list2) {
                        zzj().zzH(l.longValue());
                    }
                    zzj().zzc();
                    zzj().zzd();
                    this.zzA = null;
                    if (!zzi().zzb()) {
                        if (zzi().zzb()) {
                            this.zzB = -1L;
                            zzaL();
                        } else {
                            this.zzB = -1L;
                            zzaL();
                        }
                    } else if (zzi().zzb()) {
                        this.zzB = -1L;
                        zzaL();
                    } else {
                        this.zzB = -1L;
                        zzaL();
                    }
                    this.zza = 0L;
                }
            } else if (i2 == 204) {
                i2 = 204;
                if (th != null) {
                    zzgs zzgsVarZzk2 = zzaV().zzk();
                    numValueOf = Integer.valueOf(i2);
                    zzgsVarZzk2.zzc("Network upload successful with code, uploadAttempted", numValueOf, Boolean.valueOf(z));
                    if (z) {
                        this.zzk.zzd.zzb(zzaZ().currentTimeMillis());
                    }
                    this.zzk.zze.zzb(0L);
                    zzaL();
                    if (z) {
                        zzaV().zzk().zzc("Successful upload. Got network response. code, size", numValueOf, Integer.valueOf(bArr2.length));
                    } else {
                        zzaV().zzk().zza("Purged empty bundles");
                    }
                    zzj().zzb();
                    map = new HashMap();
                    it = list.iterator();
                    while (it.hasNext()) {
                        Pair pair3 = (Pair) it.next();
                        zzibVar2 = (com.google.android.gms.internal.measurement.zzib) pair3.first;
                        zzotVar2 = (zzot) pair3.second;
                        if (zzotVar2.zzc() != zzls.SGTM_CLIENT) {
                            jZzA = zzj().zzA(str, zzibVar2, zzotVar2.zza(), zzotVar2.zzb(), zzotVar2.zzc(), null);
                            if (zzotVar2.zzc() == zzls.GOOGLE_SIGNAL_PENDING) {
                                map.put(zzibVar2.zze(), Long.valueOf(jZzA));
                            }
                        }
                    }
                    it2 = list.iterator();
                    while (it2.hasNext()) {
                        Pair pair4 = (Pair) it2.next();
                        zzibVar = (com.google.android.gms.internal.measurement.zzib) pair4.first;
                        zzotVar = (zzot) pair4.second;
                        if (zzotVar.zzc() == zzls.SGTM_CLIENT) {
                            zzj().zzA(str, zzibVar, zzotVar.zza(), zzotVar.zzb(), zzotVar.zzc(), (Long) map.get(zzibVar.zze()));
                        }
                    }
                    listZzC = zzj().zzC(str, zzoo.zza(zzls.SGTM_CLIENT), 1);
                    if (!listZzC.isEmpty()) {
                        jZzg = ((zzpj) listZzC.get(0)).zzg();
                        if (zzaZ().currentTimeMillis() > ((Long) zzfy.zzE.zzb(null)).longValue() + jZzg) {
                            zzaV().zze().zzc("[sgtm] client batches are queued too long. appId, creationTime", str, Long.valueOf(jZzg));
                        }
                    }
                    while (r2.hasNext()) {
                        zzj().zzH(l.longValue());
                    }
                    zzj().zzc();
                    zzj().zzd();
                    this.zzA = null;
                    if (!zzi().zzb()) {
                        if (zzi().zzb()) {
                            this.zzB = -1L;
                            zzaL();
                        } else {
                            this.zzB = -1L;
                            zzaL();
                        }
                    } else if (zzi().zzb()) {
                        this.zzB = -1L;
                        zzaL();
                    } else {
                        this.zzB = -1L;
                        zzaL();
                    }
                    this.zza = 0L;
                }
            }
            String str2 = new String(bArr2, StandardCharsets.UTF_8);
            zzaV().zzh().zzd("Network upload failed. Will retry later. code, error", Integer.valueOf(i2), th, str2.substring(0, Math.min(32, str2.length())));
            this.zzk.zze.zzb(zzaZ().currentTimeMillis());
            if (i2 == 503 || i2 == 429) {
                this.zzk.zzc.zzb(zzaZ().currentTimeMillis());
            }
            zzj().zzJ(list2);
            zzaL();
        } else {
            zzgs zzgsVarZzk3 = zzaV().zzk();
            numValueOf = Integer.valueOf(i2);
            zzgsVarZzk3.zzc("Network upload successful with code, uploadAttempted", numValueOf, Boolean.valueOf(z));
            if (z) {
                try {
                    this.zzk.zzd.zzb(zzaZ().currentTimeMillis());
                } catch (SQLiteException e) {
                    zzaV().zzb().zzb("Database error while trying to delete uploaded bundles", e);
                    this.zza = zzaZ().elapsedRealtime();
                    zzaV().zzk().zzb("Disable upload, time", Long.valueOf(this.zza));
                }
            }
            this.zzk.zze.zzb(0L);
            zzaL();
            if (z) {
                zzaV().zzk().zzc("Successful upload. Got network response. code, size", numValueOf, Integer.valueOf(bArr2.length));
            } else {
                zzaV().zzk().zza("Purged empty bundles");
            }
            zzj().zzb();
            try {
                map = new HashMap();
                it = list.iterator();
                while (it.hasNext()) {
                    Pair pair5 = (Pair) it.next();
                    zzibVar2 = (com.google.android.gms.internal.measurement.zzib) pair5.first;
                    zzotVar2 = (zzot) pair5.second;
                    if (zzotVar2.zzc() != zzls.SGTM_CLIENT) {
                        jZzA = zzj().zzA(str, zzibVar2, zzotVar2.zza(), zzotVar2.zzb(), zzotVar2.zzc(), null);
                        if (zzotVar2.zzc() == zzls.GOOGLE_SIGNAL_PENDING && jZzA != -1 && !zzibVar2.zze().isEmpty()) {
                            map.put(zzibVar2.zze(), Long.valueOf(jZzA));
                        }
                    }
                }
                it2 = list.iterator();
                while (it2.hasNext()) {
                    Pair pair6 = (Pair) it2.next();
                    zzibVar = (com.google.android.gms.internal.measurement.zzib) pair6.first;
                    zzotVar = (zzot) pair6.second;
                    if (zzotVar.zzc() == zzls.SGTM_CLIENT) {
                        zzj().zzA(str, zzibVar, zzotVar.zza(), zzotVar.zzb(), zzotVar.zzc(), (Long) map.get(zzibVar.zze()));
                    }
                }
                listZzC = zzj().zzC(str, zzoo.zza(zzls.SGTM_CLIENT), 1);
                if (!listZzC.isEmpty()) {
                    jZzg = ((zzpj) listZzC.get(0)).zzg();
                    if (zzaZ().currentTimeMillis() > ((Long) zzfy.zzE.zzb(null)).longValue() + jZzg) {
                        zzaV().zze().zzc("[sgtm] client batches are queued too long. appId, creationTime", str, Long.valueOf(jZzg));
                    }
                }
                while (r2.hasNext()) {
                    try {
                        zzj().zzH(l.longValue());
                    } catch (SQLiteException e2) {
                        List list3 = this.zzA;
                        if (list3 == null || !list3.contains(l)) {
                            throw e2;
                        }
                    }
                }
                zzj().zzc();
                zzj().zzd();
                this.zzA = null;
                if (!zzi().zzb() && zzj().zzD(str)) {
                    zzP(str);
                } else if (zzi().zzb() || !zzaJ()) {
                    this.zzB = -1L;
                    zzaL();
                } else {
                    zzM();
                }
                this.zza = 0L;
            } catch (Throwable th3) {
                zzj().zzd();
                throw th3;
            }
        }
        this.zzv = false;
        zzaM();
    }

    final void zzW(zzh zzhVar) {
        zzaW().zzg();
        if (TextUtils.isEmpty(zzhVar.zzf())) {
            zzX((String) Preconditions.checkNotNull(zzhVar.zzc()), 204, null, null, null);
            return;
        }
        String str = (String) Preconditions.checkNotNull(zzhVar.zzc());
        zzaV().zzk().zzb("Fetching remote configuration", str);
        com.google.android.gms.internal.measurement.zzgl zzglVarZzb = zzh().zzb(str);
        String strZzd = zzh().zzd(str);
        ArrayMap arrayMap = null;
        if (zzglVarZzb != null) {
            if (!TextUtils.isEmpty(strZzd)) {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put(HttpHeaders.IF_MODIFIED_SINCE, strZzd);
                arrayMap = arrayMap2;
            }
            String strZze = zzh().zze(str);
            if (!TextUtils.isEmpty(strZze)) {
                if (arrayMap == null) {
                    arrayMap = new ArrayMap();
                }
                arrayMap.put(HttpHeaders.IF_NONE_MATCH, strZze);
            }
        }
        this.zzu = true;
        zzi().zzd(zzhVar, arrayMap, new zzgw() { // from class: com.google.android.gms.measurement.internal.zzpf
            @Override // com.google.android.gms.measurement.internal.zzgw
            public final /* synthetic */ void zza(String str2, int i, Throwable th, byte[] bArr, Map map) {
                this.zza.zzX(str2, i, th, bArr, map);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0042  */
    /* JADX WARN: Code duplicated, block: B:14:0x0044 A[PHI: r8
  0x0044: PHI (r8v12 int) = (r8v2 int), (r8v0 int) binds: [B:12:0x0040, B:10:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    final void zzX(String str, int i, Throwable th, byte[] bArr, Map map) {
        boolean z;
        zzaW().zzg();
        zzu();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzu = false;
                zzaM();
                throw th2;
            }
        }
        zzgs zzgsVarZzk = zzaV().zzk();
        Integer numValueOf = Integer.valueOf(bArr.length);
        zzgsVarZzk.zzb("onConfigFetched. Response size", numValueOf);
        zzj().zzb();
        try {
            zzh zzhVarZzu = zzj().zzu(str);
            if (i == 200 || i == 204) {
                if (th == null) {
                    z = true;
                } else {
                    z = false;
                }
            } else if (i == 304) {
                i = 304;
                if (th == null) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            if (zzhVarZzu == null) {
                zzaV().zze().zzb("App does not exist in onConfigFetched. appId", zzgu.zzl(str));
            } else if (z || i == 404) {
                String strZzaK = zzaK(map, HttpHeaders.LAST_MODIFIED);
                String strZzaK2 = zzaK(map, HttpHeaders.ETAG);
                if (i != 404 && i != 304) {
                    zzh().zzi(str, bArr, strZzaK, strZzaK2);
                } else if (zzh().zzb(str) == null) {
                    zzh().zzi(str, null, null, null);
                }
                zzhVarZzu.zzI(zzaZ().currentTimeMillis());
                zzj().zzv(zzhVarZzu, false, false);
                if (i == 404) {
                    zzaV().zzh().zzb("Config not found. Using empty config. appId", str);
                } else {
                    zzaV().zzk().zzc("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), numValueOf);
                }
                if (zzi().zzb() && zzaJ()) {
                    zzM();
                } else if (zzi().zzb() && zzj().zzD(zzhVarZzu.zzc())) {
                    zzP(zzhVarZzu.zzc());
                } else {
                    zzaL();
                }
            } else {
                zzhVarZzu.zzK(zzaZ().currentTimeMillis());
                zzj().zzv(zzhVarZzu, false, false);
                zzaV().zzk().zzc("Fetching config failed. code, error", Integer.valueOf(i), th);
                zzh().zzf(str);
                this.zzk.zze.zzb(zzaZ().currentTimeMillis());
                if (i == 503 || i == 429) {
                    this.zzk.zzc.zzb(zzaZ().currentTimeMillis());
                }
                zzaL();
            }
            zzj().zzc();
            zzj().zzd();
            this.zzu = false;
            zzaM();
        } catch (Throwable th3) {
            zzj().zzd();
            throw th3;
        }
    }

    final void zzY(Runnable runnable) {
        zzaW().zzg();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }

    final void zzZ() {
        zzaW().zzg();
        zzu();
        if (this.zzp) {
            return;
        }
        this.zzp = true;
        if (zzaa()) {
            FileChannel fileChannel = this.zzy;
            zzaW().zzg();
            int i = 0;
            if (fileChannel == null || !fileChannel.isOpen()) {
                zzaV().zzb().zza("Bad channel to read from");
            } else {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
                try {
                    fileChannel.position(0L);
                    int i2 = fileChannel.read(byteBufferAllocate);
                    if (i2 == 4) {
                        byteBufferAllocate.flip();
                        i = byteBufferAllocate.getInt();
                    } else if (i2 != -1) {
                        zzaV().zze().zzb("Unexpected data length. Bytes read", Integer.valueOf(i2));
                    }
                } catch (IOException e) {
                    zzaV().zzb().zzb("Failed to read from channel", e);
                }
            }
            int iZzm = this.zzn.zzv().zzm();
            zzaW().zzg();
            if (i > iZzm) {
                zzaV().zzb().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(iZzm));
                return;
            }
            if (i < iZzm) {
                FileChannel fileChannel2 = this.zzy;
                zzaW().zzg();
                if (fileChannel2 == null || !fileChannel2.isOpen()) {
                    zzaV().zzb().zza("Bad channel to read from");
                } else {
                    ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
                    byteBufferAllocate2.putInt(iZzm);
                    byteBufferAllocate2.flip();
                    try {
                        fileChannel2.truncate(0L);
                        fileChannel2.write(byteBufferAllocate2);
                        fileChannel2.force(true);
                        if (fileChannel2.size() != 4) {
                            zzaV().zzb().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                        }
                        zzaV().zzk().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(iZzm));
                        return;
                    } catch (IOException e2) {
                        zzaV().zzb().zzb("Failed to write to channel", e2);
                    }
                }
                zzaV().zzb().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(iZzm));
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzae zzaU() {
        return this.zzn.zzaU();
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzgu zzaV() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzaV();
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzhz zzaW() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzaW();
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final Context zzaY() {
        return this.zzn.zzaY();
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final Clock zzaZ() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzaZ();
    }

    final boolean zzaa() {
        zzaW().zzg();
        FileLock fileLock = this.zzx;
        if (fileLock != null && fileLock.isValid()) {
            zzaV().zzk().zza("Storage concurrent access okay");
            return true;
        }
        this.zze.zzu.zzc();
        File filesDir = this.zzn.zzaY().getFilesDir();
        com.google.android.gms.internal.measurement.zzbv.zza();
        int i = com.google.android.gms.internal.measurement.zzca.zzb;
        try {
            FileChannel channel = new RandomAccessFile(new File(new File(filesDir, "google_app_measurement.db").getPath()), "rw").getChannel();
            this.zzy = channel;
            FileLock fileLockTryLock = channel.tryLock();
            this.zzx = fileLockTryLock;
            if (fileLockTryLock != null) {
                zzaV().zzk().zza("Storage concurrent access okay");
                return true;
            }
            zzaV().zzb().zza("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            zzaV().zzb().zzb("Failed to acquire storage lock", e);
            return false;
        } catch (IOException e2) {
            zzaV().zzb().zzb("Failed to access storage lock file", e2);
            return false;
        } catch (OverlappingFileLockException e3) {
            zzaV().zze().zzb("Storage lock already acquired", e3);
            return false;
        }
    }

    final void zzab(zzr zzrVar) throws Throwable {
        if (this.zzz != null) {
            ArrayList arrayList = new ArrayList();
            this.zzA = arrayList;
            arrayList.addAll(this.zzz);
        }
        zzav zzavVarZzj = zzj();
        String str = (String) Preconditions.checkNotNull(zzrVar.zza);
        Preconditions.checkNotEmpty(str);
        zzavVarZzj.zzg();
        zzavVarZzj.zzaw();
        try {
            SQLiteDatabase sQLiteDatabaseZze = zzavVarZzj.zze();
            String[] strArr = {str};
            int iDelete = sQLiteDatabaseZze.delete("apps", "app_id=?", strArr) + sQLiteDatabaseZze.delete("events", "app_id=?", strArr) + sQLiteDatabaseZze.delete("events_snapshot", "app_id=?", strArr) + sQLiteDatabaseZze.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseZze.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseZze.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseZze.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseZze.delete("queue", "app_id=?", strArr) + sQLiteDatabaseZze.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseZze.delete("main_event_params", "app_id=?", strArr) + sQLiteDatabaseZze.delete("default_event_params", "app_id=?", strArr) + sQLiteDatabaseZze.delete("trigger_uris", "app_id=?", strArr) + sQLiteDatabaseZze.delete("upload_queue", "app_id=?", strArr);
            com.google.android.gms.internal.measurement.zzpo.zza();
            zzic zzicVar = zzavVarZzj.zzu;
            if (zzicVar.zzc().zzp(null, zzfy.zzbh)) {
                iDelete += sQLiteDatabaseZze.delete("no_data_mode_events", "app_id=?", strArr);
            }
            if (iDelete > 0) {
                zzicVar.zzaV().zzk().zzc("Reset analytics data. app, records", str, Integer.valueOf(iDelete));
            }
        } catch (SQLiteException e) {
            zzavVarZzj.zzu.zzaV().zzb().zzc("Error resetting analytics data. appId, error", zzgu.zzl(str), e);
        }
        if (zzrVar.zzh) {
            zzah(zzrVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00d4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:42:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:43:0x0108  */
    final void zzac(zzpl zzplVar, zzr zzrVar) throws Throwable {
        zzpn zzpnVarZzm;
        zzbc zzbcVarZzf;
        long jLongValue;
        zzaW().zzg();
        zzu();
        if (zzaR(zzrVar)) {
            if (!zzrVar.zzh) {
                zzao(zzrVar);
                return;
            }
            zzpp zzppVarZzt = zzt();
            String str = zzplVar.zzb;
            int iZzp = zzppVarZzt.zzp(str);
            if (iZzp != 0) {
                zzpp zzppVarZzt2 = zzt();
                zzd();
                zzt().zzN(this.zzK, zzrVar.zza, iZzp, "_ev", zzppVarZzt2.zzC(str, 24, true), str != null ? str.length() : 0);
                return;
            }
            int iZzK = zzt().zzK(str, zzplVar.zza());
            if (iZzK != 0) {
                zzpp zzppVarZzt3 = zzt();
                zzd();
                String strZzC = zzppVarZzt3.zzC(str, 24, true);
                Object objZza = zzplVar.zza();
                zzt().zzN(this.zzK, zzrVar.zza, iZzK, "_ev", strZzC, (objZza == null || !((objZza instanceof String) || (objZza instanceof CharSequence))) ? 0 : objZza.toString().length());
                return;
            }
            Object objZzL = zzt().zzL(str, zzplVar.zza());
            if (objZzL != null) {
                String str2 = "_sid";
                if ("_sid".equals(str)) {
                    long j = zzplVar.zzc;
                    String str3 = zzplVar.zzf;
                    String str4 = (String) Preconditions.checkNotNull(zzrVar.zza);
                    zzpn zzpnVarZzm2 = zzj().zzm(str4, "_sno");
                    if (zzpnVarZzm2 != null) {
                        Object obj = zzpnVarZzm2.zze;
                        if (obj instanceof Long) {
                            jLongValue = ((Long) obj).longValue();
                        } else {
                            if (zzpnVarZzm2 != null) {
                                zzaV().zze().zzb("Retrieved last session number from database does not contain a valid (long) value", zzpnVarZzm2.zze);
                            }
                            zzbcVarZzf = zzj().zzf(str4, "_s");
                            if (zzbcVarZzf != null) {
                                zzgs zzgsVarZzk = zzaV().zzk();
                                long j2 = zzbcVarZzf.zzc;
                                zzgsVarZzk.zzb("Backfill the session number. Last used session number", Long.valueOf(j2));
                                jLongValue = j2;
                            } else {
                                jLongValue = 0;
                            }
                        }
                    } else {
                        if (zzpnVarZzm2 != null) {
                            zzaV().zze().zzb("Retrieved last session number from database does not contain a valid (long) value", zzpnVarZzm2.zze);
                        }
                        zzbcVarZzf = zzj().zzf(str4, "_s");
                        if (zzbcVarZzf != null) {
                            zzgs zzgsVarZzk2 = zzaV().zzk();
                            long j3 = zzbcVarZzf.zzc;
                            zzgsVarZzk2.zzb("Backfill the session number. Last used session number", Long.valueOf(j3));
                            jLongValue = j3;
                        } else {
                            jLongValue = 0;
                        }
                    }
                    zzac(new zzpl("_sno", j, Long.valueOf(jLongValue + 1), str3), zzrVar);
                } else {
                    str2 = "_sid";
                }
                String str5 = zzrVar.zza;
                zzpn zzpnVar = new zzpn((String) Preconditions.checkNotNull(str5), (String) Preconditions.checkNotNull(zzplVar.zzf), str, zzplVar.zzc, objZzL);
                zzgs zzgsVarZzk3 = zzaV().zzk();
                zzic zzicVar = this.zzn;
                String str6 = zzpnVar.zzc;
                zzgsVarZzk3.zzc("Setting user property", zzicVar.zzl().zzc(str6), objZzL);
                zzj().zzb();
                try {
                    if ("_id".equals(str6) && (zzpnVarZzm = zzj().zzm(str5, "_id")) != null && !zzpnVar.zze.equals(zzpnVarZzm.zze)) {
                        zzj().zzk(str5, "_lair");
                    }
                    zzao(zzrVar);
                    boolean zZzl = zzj().zzl(zzpnVar);
                    if (str2.equals(str)) {
                        long jZzu = zzp().zzu(zzrVar.zzu);
                        zzh zzhVarZzu = zzj().zzu(str5);
                        if (zzhVarZzu != null) {
                            zzhVarZzu.zzan(jZzu);
                            if (zzhVarZzu.zza()) {
                                zzj().zzv(zzhVarZzu, false, false);
                            }
                        }
                    }
                    zzj().zzc();
                    if (!zZzl) {
                        zzaV().zzb().zzc("Too many unique user properties are set. Ignoring user property", zzicVar.zzl().zzc(str6), zzpnVar.zze);
                        zzt().zzN(this.zzK, str5, 9, null, null, 0);
                    }
                } finally {
                    zzj().zzd();
                }
            }
        }
    }

    final void zzad(String str, zzr zzrVar) throws Throwable {
        zzaW().zzg();
        zzu();
        if (zzaR(zzrVar)) {
            if (!zzrVar.zzh) {
                zzao(zzrVar);
                return;
            }
            Boolean boolZzaT = zzaT(zzrVar);
            if ("_npa".equals(str) && boolZzaT != null) {
                zzaV().zzj().zza("Falling back to manifest metadata value for ad personalization");
                zzac(new zzpl("_npa", zzaZ().currentTimeMillis(), Long.valueOf(true != boolZzaT.booleanValue() ? 0L : 1L), DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzrVar);
                return;
            }
            zzgs zzgsVarZzj = zzaV().zzj();
            zzic zzicVar = this.zzn;
            zzgsVarZzj.zzb("Removing user property", zzicVar.zzl().zzc(str));
            zzj().zzb();
            try {
                zzao(zzrVar);
                if ("_id".equals(str)) {
                    zzj().zzk((String) Preconditions.checkNotNull(zzrVar.zza), "_lair");
                }
                zzj().zzk((String) Preconditions.checkNotNull(zzrVar.zza), str);
                zzj().zzc();
                zzaV().zzj().zzb("User property removed", zzicVar.zzl().zzc(str));
            } finally {
                zzj().zzd();
            }
        }
    }

    final void zzae() {
        this.zzs++;
    }

    final void zzaf() {
        this.zzt++;
    }

    final zzic zzag() {
        return this.zzn;
    }

    final void zzah(zzr zzrVar) throws Throwable {
        boolean z;
        zzbc zzbcVarZzf;
        boolean z2;
        String str;
        long j;
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        long j2;
        boolean z3;
        zzaW().zzg();
        zzu();
        Preconditions.checkNotNull(zzrVar);
        String str2 = zzrVar.zza;
        Preconditions.checkNotEmpty(str2);
        if (zzaR(zzrVar)) {
            zzh zzhVarZzu = zzj().zzu(str2);
            if (zzhVarZzu != null && TextUtils.isEmpty(zzhVarZzu.zzf()) && !TextUtils.isEmpty(zzrVar.zzb)) {
                zzhVarZzu.zzI(0L);
                zzj().zzv(zzhVarZzu, false, false);
                zzh().zzh(str2);
            }
            if (!zzrVar.zzh) {
                zzao(zzrVar);
                return;
            }
            long jCurrentTimeMillis = zzrVar.zzl;
            if (jCurrentTimeMillis == 0) {
                jCurrentTimeMillis = zzaZ().currentTimeMillis();
            }
            int i = zzrVar.zzm;
            if (i != 0 && i != 1) {
                zzaV().zze().zzc("Incorrect app type, assuming installed app. appId, appType", zzgu.zzl(str2), Integer.valueOf(i));
                i = 0;
            }
            zzj().zzb();
            try {
                zzpn zzpnVarZzm = zzj().zzm(str2, "_npa");
                Boolean boolZzaT = zzaT(zzrVar);
                if (zzpnVarZzm != null && !DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(zzpnVarZzm.zzb)) {
                    z = true;
                } else if (boolZzaT != null) {
                    z = true;
                    zzpl zzplVar = new zzpl("_npa", jCurrentTimeMillis, Long.valueOf(true != boolZzaT.booleanValue() ? 0L : 1L), DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
                    if (zzpnVarZzm == null || !zzpnVarZzm.zze.equals(zzplVar.zzd)) {
                        zzac(zzplVar, zzrVar);
                    }
                } else {
                    z = true;
                    if (zzpnVarZzm != null) {
                        zzad("_npa", zzrVar);
                    }
                }
                if (zzd().zzp(null, zzfy.zzbb)) {
                    zzan(zzrVar, zzrVar.zzD);
                } else {
                    zzan(zzrVar, jCurrentTimeMillis);
                }
                zzao(zzrVar);
                if (i == 0) {
                    zzbcVarZzf = zzj().zzf(str2, "_f");
                    z2 = false;
                } else {
                    zzbcVarZzf = zzj().zzf(str2, "_v");
                    z2 = z;
                }
                if (zzbcVarZzf == null) {
                    long j3 = ((jCurrentTimeMillis / 3600000) + 1) * 3600000;
                    if (z2) {
                        long j4 = jCurrentTimeMillis;
                        zzac(new zzpl("_fvt", j4, Long.valueOf(j3), DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzrVar);
                        zzaW().zzg();
                        zzu();
                        Bundle bundle = new Bundle();
                        bundle.putLong("_c", 1L);
                        bundle.putLong("_r", 1L);
                        bundle.putLong("_et", 1L);
                        if (zzrVar.zzo) {
                            bundle.putLong("_dac", 1L);
                        }
                        if (zzd().zzp(null, zzfy.zzbj)) {
                            bundle.putLong("_elt", zzaZ().currentTimeMillis());
                        }
                        zzE(new zzbg("_v", new zzbe(bundle), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, j4), zzrVar);
                    } else {
                        zzac(new zzpl("_fot", jCurrentTimeMillis, Long.valueOf(j3), DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzrVar);
                        zzaW().zzg();
                        zzhk zzhkVar = (zzhk) Preconditions.checkNotNull(this.zzm);
                        if (str2 == null || str2.isEmpty()) {
                            str = "_elt";
                            j = jCurrentTimeMillis;
                            zzhkVar.zza.zzaV().zzf().zza("Install Referrer Reporter was called with invalid app package name");
                        } else {
                            zzic zzicVar = zzhkVar.zza;
                            zzicVar.zzaW().zzg();
                            if (zzhkVar.zza()) {
                                str = "_elt";
                                zzhj zzhjVar = new zzhj(zzhkVar, str2);
                                zzicVar.zzaW().zzg();
                                j = jCurrentTimeMillis;
                                Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
                                intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
                                PackageManager packageManager = zzicVar.zzaY().getPackageManager();
                                if (packageManager == null) {
                                    zzicVar.zzaV().zzf().zza("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
                                } else {
                                    List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
                                    if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                                        zzicVar.zzaV().zzi().zza("Play Service for fetching Install Referrer is unavailable on device");
                                    } else {
                                        ResolveInfo resolveInfo = listQueryIntentServices.get(0);
                                        if (resolveInfo.serviceInfo != null) {
                                            String str3 = resolveInfo.serviceInfo.packageName;
                                            if (resolveInfo.serviceInfo.name != null && "com.android.vending".equals(str3) && zzhkVar.zza()) {
                                                try {
                                                    zzicVar.zzaV().zzk().zzb("Install Referrer Service is", ConnectionTracker.getInstance().bindService(zzicVar.zzaY(), new Intent(intent), zzhjVar, 1) ? "available" : "not available");
                                                } catch (RuntimeException e) {
                                                    zzhkVar.zza.zzaV().zzb().zzb("Exception occurred while binding to Install Referrer Service", e.getMessage());
                                                }
                                            } else {
                                                zzicVar.zzaV().zze().zza("Play Store version 8.3.73 or higher required for Install Referrer");
                                            }
                                        }
                                    }
                                }
                            } else {
                                zzicVar.zzaV().zzi().zza("Install Referrer Reporter is not available");
                                str = "_elt";
                                j = jCurrentTimeMillis;
                            }
                        }
                        zzaW().zzg();
                        zzu();
                        Bundle bundle2 = new Bundle();
                        bundle2.putLong("_c", 1L);
                        bundle2.putLong("_r", 1L);
                        bundle2.putLong("_uwa", 0L);
                        bundle2.putLong("_pfo", 0L);
                        bundle2.putLong("_sys", 0L);
                        bundle2.putLong("_sysu", 0L);
                        bundle2.putLong("_et", 1L);
                        if (zzrVar.zzo) {
                            bundle2.putLong("_dac", 1L);
                        }
                        String str4 = (String) Preconditions.checkNotNull(zzrVar.zza);
                        zzav zzavVarZzj = zzj();
                        Preconditions.checkNotEmpty(str4);
                        zzavVarZzj.zzg();
                        zzavVarZzj.zzaw();
                        long jZzN = zzavVarZzj.zzN(str4, "first_open_count");
                        zzic zzicVar2 = this.zzn;
                        if (zzicVar2.zzaY().getPackageManager() == null) {
                            zzaV().zzb().zzb("PackageManager is null, first open report might be inaccurate. appId", zzgu.zzl(str4));
                        } else {
                            try {
                                packageInfo = Wrappers.packageManager(zzicVar2.zzaY()).getPackageInfo(str4, 0);
                            } catch (PackageManager.NameNotFoundException e2) {
                                zzaV().zzb().zzc("Package info is null, first open report might be inaccurate. appId", zzgu.zzl(str4), e2);
                                packageInfo = null;
                            }
                            if (packageInfo != null && packageInfo.firstInstallTime != 0) {
                                if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                    if (!zzd().zzp(null, zzfy.zzaI)) {
                                        bundle2.putLong("_uwa", 1L);
                                    } else if (jZzN == 0) {
                                        bundle2.putLong("_uwa", 1L);
                                        jZzN = 0;
                                    }
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                                zzac(new zzpl("_fi", j, Long.valueOf(true != z3 ? 0L : 1L), DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzrVar);
                            }
                            try {
                                applicationInfo = Wrappers.packageManager(this.zzn.zzaY()).getApplicationInfo(str4, 0);
                            } catch (PackageManager.NameNotFoundException e3) {
                                zzaV().zzb().zzc("Application info is null, first open report might be inaccurate. appId", zzgu.zzl(str4), e3);
                                applicationInfo = null;
                            }
                            if (applicationInfo != null) {
                                if ((applicationInfo.flags & 1) != 0) {
                                    j2 = 1;
                                    bundle2.putLong("_sys", 1L);
                                } else {
                                    j2 = 1;
                                }
                                if ((applicationInfo.flags & 128) != 0) {
                                    bundle2.putLong("_sysu", j2);
                                }
                            }
                        }
                        if (jZzN >= 0) {
                            bundle2.putLong("_pfo", jZzN);
                        }
                        if (zzd().zzp(null, zzfy.zzbj)) {
                            bundle2.putLong(str, zzaZ().currentTimeMillis());
                        }
                        zzE(new zzbg("_f", new zzbe(bundle2), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, j), zzrVar);
                    }
                } else {
                    long j5 = jCurrentTimeMillis;
                    if (zzrVar.zzi) {
                        zzE(new zzbg("_cd", new zzbe(new Bundle()), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, j5), zzrVar);
                    }
                }
                zzj().zzc();
                zzj().zzd();
            } catch (Throwable th) {
                zzj().zzd();
                throw th;
            }
        }
    }

    final void zzai(zzr zzrVar) throws Throwable {
        zzaW().zzg();
        zzu();
        Preconditions.checkNotNull(zzrVar);
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        int i = 0;
        if (zzd().zzp(null, zzfy.zzaz)) {
            long jCurrentTimeMillis = zzaZ().currentTimeMillis();
            int iZzm = zzd().zzm(null, zzfy.zzai);
            zzd();
            long jZzF = jCurrentTimeMillis - zzal.zzF();
            while (i < iZzm && zzaG(null, jZzF)) {
                i++;
            }
        } else {
            zzd();
            long jZzH = zzal.zzH();
            while (i < jZzH && zzaG(str, 0L)) {
                i++;
            }
        }
        if (zzd().zzp(null, zzfy.zzaA)) {
            zzaW().zzg();
            zzav();
        }
        if (this.zzl.zzc(str, com.google.android.gms.internal.measurement.zzin.zzb(zzrVar.zzE))) {
            zzaV().zzk().zzb("[sgtm] Going background, trigger client side upload. appId", str);
            zzN(str, zzaZ().currentTimeMillis());
        }
    }

    final void zzaj(zzah zzahVar) throws Throwable {
        zzr zzrVarZzaO = zzaO((String) Preconditions.checkNotNull(zzahVar.zza));
        if (zzrVarZzaO != null) {
            zzak(zzahVar, zzrVarZzaO);
        }
    }

    final void zzak(zzah zzahVar, zzr zzrVar) throws Throwable {
        Preconditions.checkNotNull(zzahVar);
        Preconditions.checkNotEmpty(zzahVar.zza);
        Preconditions.checkNotNull(zzahVar.zzb);
        Preconditions.checkNotNull(zzahVar.zzc);
        Preconditions.checkNotEmpty(zzahVar.zzc.zzb);
        zzaW().zzg();
        zzu();
        if (zzaR(zzrVar)) {
            if (!zzrVar.zzh) {
                zzao(zzrVar);
                return;
            }
            zzah zzahVar2 = new zzah(zzahVar);
            boolean z = false;
            zzahVar2.zze = false;
            zzj().zzb();
            try {
                zzah zzahVarZzq = zzj().zzq((String) Preconditions.checkNotNull(zzahVar2.zza), zzahVar2.zzc.zzb);
                if (zzahVarZzq != null && !zzahVarZzq.zzb.equals(zzahVar2.zzb)) {
                    zzaV().zze().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzb, zzahVarZzq.zzb);
                }
                if (zzahVarZzq != null && zzahVarZzq.zze) {
                    zzahVar2.zzb = zzahVarZzq.zzb;
                    zzahVar2.zzd = zzahVarZzq.zzd;
                    zzahVar2.zzh = zzahVarZzq.zzh;
                    zzahVar2.zzf = zzahVarZzq.zzf;
                    zzahVar2.zzi = zzahVarZzq.zzi;
                    zzahVar2.zze = true;
                    zzpl zzplVar = zzahVar2.zzc;
                    zzahVar2.zzc = new zzpl(zzplVar.zzb, zzahVarZzq.zzc.zzc, zzplVar.zza(), zzahVarZzq.zzc.zzf);
                } else if (TextUtils.isEmpty(zzahVar2.zzf)) {
                    zzpl zzplVar2 = zzahVar2.zzc;
                    zzahVar2.zzc = new zzpl(zzplVar2.zzb, zzahVar2.zzd, zzplVar2.zza(), zzahVar2.zzc.zzf);
                    zzahVar2.zze = true;
                    z = true;
                }
                if (zzahVar2.zze) {
                    zzpl zzplVar3 = zzahVar2.zzc;
                    zzpn zzpnVar = new zzpn((String) Preconditions.checkNotNull(zzahVar2.zza), zzahVar2.zzb, zzplVar3.zzb, zzplVar3.zzc, Preconditions.checkNotNull(zzplVar3.zza()));
                    if (zzj().zzl(zzpnVar)) {
                        zzaV().zzj().zzd("User property updated immediately", zzahVar2.zza, this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                    } else {
                        zzaV().zzb().zzd("(2)Too many active user properties, ignoring", zzgu.zzl(zzahVar2.zza), this.zzn.zzl().zzc(zzpnVar.zzc), zzpnVar.zze);
                    }
                    if (z && zzahVar2.zzi != null) {
                        zzH(new zzbg(zzahVar2.zzi, zzahVar2.zzd), zzrVar);
                    }
                }
                if (zzj().zzp(zzahVar2)) {
                    zzaV().zzj().zzd("Conditional property added", zzahVar2.zza, this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzc.zza());
                } else {
                    zzaV().zzb().zzd("Too many conditional properties, ignoring", zzgu.zzl(zzahVar2.zza), this.zzn.zzl().zzc(zzahVar2.zzc.zzb), zzahVar2.zzc.zza());
                }
                zzj().zzc();
            } finally {
                zzj().zzd();
            }
        }
    }

    final void zzal(zzah zzahVar) throws Throwable {
        zzr zzrVarZzaO = zzaO((String) Preconditions.checkNotNull(zzahVar.zza));
        if (zzrVarZzaO != null) {
            zzam(zzahVar, zzrVarZzaO);
        }
    }

    final void zzam(zzah zzahVar, zzr zzrVar) throws Throwable {
        Preconditions.checkNotNull(zzahVar);
        Preconditions.checkNotEmpty(zzahVar.zza);
        Preconditions.checkNotNull(zzahVar.zzc);
        Preconditions.checkNotEmpty(zzahVar.zzc.zzb);
        zzaW().zzg();
        zzu();
        if (zzaR(zzrVar)) {
            if (!zzrVar.zzh) {
                zzao(zzrVar);
                return;
            }
            zzj().zzb();
            try {
                zzao(zzrVar);
                String str = (String) Preconditions.checkNotNull(zzahVar.zza);
                zzah zzahVarZzq = zzj().zzq(str, zzahVar.zzc.zzb);
                if (zzahVarZzq != null) {
                    zzaV().zzj().zzc("Removing conditional user property", zzahVar.zza, this.zzn.zzl().zzc(zzahVar.zzc.zzb));
                    zzj().zzr(str, zzahVar.zzc.zzb);
                    if (zzahVarZzq.zze) {
                        zzj().zzk(str, zzahVar.zzc.zzb);
                    }
                    zzbg zzbgVar = zzahVar.zzk;
                    if (zzbgVar != null) {
                        zzbe zzbeVar = zzbgVar.zzb;
                        zzH((zzbg) Preconditions.checkNotNull(zzt().zzac(str, ((zzbg) Preconditions.checkNotNull(zzbgVar)).zza, zzbeVar != null ? zzbeVar.zzf() : null, zzahVarZzq.zzb, zzbgVar.zzd, true, true)), zzrVar);
                    }
                } else {
                    zzaV().zze().zzc("Conditional user property doesn't exist", zzgu.zzl(zzahVar.zza), this.zzn.zzl().zzc(zzahVar.zzc.zzb));
                }
                zzj().zzc();
            } finally {
                zzj().zzd();
            }
        }
    }

    final void zzan(zzr zzrVar, long j) throws Throwable {
        zzh zzhVarZzu = zzj().zzu((String) Preconditions.checkNotNull(zzrVar.zza));
        if (zzhVarZzu != null && zzt().zzB(zzrVar.zzb, zzhVarZzu.zzf())) {
            zzaV().zze().zzb("New GMP App Id passed in. Removing cached database data. appId", zzgu.zzl(zzhVarZzu.zzc()));
            zzav zzavVarZzj = zzj();
            String strZzc = zzhVarZzu.zzc();
            zzavVarZzj.zzaw();
            zzavVarZzj.zzg();
            Preconditions.checkNotEmpty(strZzc);
            try {
                SQLiteDatabase sQLiteDatabaseZze = zzavVarZzj.zze();
                String[] strArr = {strZzc};
                int iDelete = sQLiteDatabaseZze.delete("events", "app_id=?", strArr) + sQLiteDatabaseZze.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseZze.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseZze.delete("apps", "app_id=?", strArr) + sQLiteDatabaseZze.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseZze.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseZze.delete("event_filters", "app_id=?", strArr) + sQLiteDatabaseZze.delete("property_filters", "app_id=?", strArr) + sQLiteDatabaseZze.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseZze.delete("consent_settings", "app_id=?", strArr) + sQLiteDatabaseZze.delete("default_event_params", "app_id=?", strArr) + sQLiteDatabaseZze.delete("trigger_uris", "app_id=?", strArr);
                com.google.android.gms.internal.measurement.zzpo.zza();
                zzic zzicVar = zzavVarZzj.zzu;
                if (zzicVar.zzc().zzp(null, zzfy.zzbh)) {
                    iDelete += sQLiteDatabaseZze.delete("no_data_mode_events", "app_id=?", strArr);
                }
                if (iDelete > 0) {
                    zzicVar.zzaV().zzk().zzc("Deleted application data. app, records", strZzc, Integer.valueOf(iDelete));
                }
            } catch (SQLiteException e) {
                zzavVarZzj.zzu.zzaV().zzb().zzc("Error deleting application data. appId, error", zzgu.zzl(strZzc), e);
            }
            zzhVarZzu = null;
        }
        if (zzhVarZzu != null) {
            boolean z = (zzhVarZzu.zzt() == -2147483648L || zzhVarZzu.zzt() == zzrVar.zzj) ? false : true;
            String strZzr = zzhVarZzu.zzr();
            if (z || ((zzhVarZzu.zzt() != -2147483648L || strZzr == null || strZzr.equals(zzrVar.zzc)) ? false : true)) {
                Bundle bundle = new Bundle();
                bundle.putString("_pv", strZzr);
                zzbg zzbgVar = new zzbg("_au", new zzbe(bundle), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, j);
                if (zzd().zzp(null, zzfy.zzbc)) {
                    zzE(zzbgVar, zzrVar);
                } else {
                    zzF(zzbgVar, zzrVar);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0134  */
    /* JADX WARN: Code duplicated, block: B:53:0x013f  */
    /* JADX WARN: Code duplicated, block: B:56:0x014a  */
    /* JADX WARN: Code duplicated, block: B:59:0x0156  */
    /* JADX WARN: Code duplicated, block: B:62:0x016b  */
    /* JADX WARN: Code duplicated, block: B:65:0x0191  */
    /* JADX WARN: Code duplicated, block: B:66:0x0197  */
    /* JADX WARN: Code duplicated, block: B:68:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:71:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:74:0x01dc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x01df  */
    final zzh zzao(zzr zzrVar) throws Throwable {
        boolean z;
        String str;
        long j;
        String str2;
        String str3;
        String str4;
        zzaW().zzg();
        zzu();
        Preconditions.checkNotNull(zzrVar);
        String str5 = zzrVar.zza;
        Preconditions.checkNotEmpty(str5);
        String str6 = zzrVar.zzt;
        if (!str6.isEmpty()) {
            this.zzE.put(str5, new zzpd(this, str6, null));
        }
        zzh zzhVarZzu = zzj().zzu(str5);
        zzjl zzjlVarZzs = zzB(str5).zzs(zzjl.zzf(zzrVar.zzs, 100));
        zzjk zzjkVar = zzjk.AD_STORAGE;
        String strZzf = zzjlVarZzs.zzo(zzjkVar) ? this.zzk.zzf(str5, zzrVar.zzn) : "";
        boolean z2 = true;
        if (zzhVarZzu == null) {
            zzh zzhVar = new zzh(this.zzn, str5);
            if (zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                zzhVar.zze(zzK(zzjlVarZzs));
            }
            if (zzjlVarZzs.zzo(zzjkVar)) {
                zzhVar.zzk(strZzf);
            }
            zzhVarZzu = zzhVar;
        } else {
            if (zzjlVarZzs.zzo(zzjkVar) && strZzf != null && !strZzf.equals(zzhVarZzu.zzj())) {
                boolean zIsEmpty = TextUtils.isEmpty(zzhVarZzu.zzj());
                zzhVarZzu.zzk(strZzf);
                if (zzrVar.zzn && !"00000000-0000-0000-0000-000000000000".equals(this.zzk.zzc(str5, zzjlVarZzs).first) && !zIsEmpty) {
                    if (zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                        zzhVarZzu.zze(zzK(zzjlVarZzs));
                        z = false;
                    } else {
                        z = true;
                    }
                    if (zzj().zzm(str5, "_id") != null && zzj().zzm(str5, "_lair") == null) {
                        zzj().zzl(new zzpn(str5, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lair", zzaZ().currentTimeMillis(), 1L));
                    }
                } else if (TextUtils.isEmpty(zzhVarZzu.zzd()) && zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                    zzhVarZzu.zze(zzK(zzjlVarZzs));
                }
                zzhVarZzu.zzg(zzrVar.zzb);
                str = zzrVar.zzk;
                if (!TextUtils.isEmpty(str)) {
                    zzhVarZzu.zzm(str);
                }
                j = zzrVar.zze;
                if (j != 0) {
                    zzhVarZzu.zzy(j);
                }
                str2 = zzrVar.zzc;
                if (!TextUtils.isEmpty(str2)) {
                    zzhVarZzu.zzs(str2);
                }
                zzhVarZzu.zzu(zzrVar.zzj);
                str3 = zzrVar.zzd;
                if (str3 != null) {
                    zzhVarZzu.zzw(str3);
                }
                zzhVarZzu.zzA(zzrVar.zzf);
                zzhVarZzu.zzE(zzrVar.zzh);
                str4 = zzrVar.zzg;
                if (!TextUtils.isEmpty(str4)) {
                    zzhVarZzu.zzab(str4);
                }
                zzhVarZzu.zzad(zzrVar.zzn);
                zzhVarZzu.zzaf(zzrVar.zzp);
                zzhVarZzu.zzC(zzrVar.zzq);
                zzhVarZzu.zzi(zzrVar.zzu);
                zzpr.zza();
                if (zzd().zzp(null, zzfy.zzaL)) {
                    zzhVarZzu.zzah(zzrVar.zzr);
                } else {
                    zzpr.zza();
                    if (zzd().zzp(null, zzfy.zzaK)) {
                        zzhVarZzu.zzah(null);
                    }
                }
                zzhVarZzu.zzaj(zzrVar.zzv);
                zzhVarZzu.zzaz(zzrVar.zzB);
                zzqp.zza();
                if (zzd().zzp(null, zzfy.zzaP)) {
                    zzhVarZzu.zzap(zzrVar.zzz);
                }
                zzhVarZzu.zzal(zzrVar.zzw);
                zzhVarZzu.zzaG(zzrVar.zzC);
                zzhVarZzu.zzaK(zzrVar.zzE);
                if (!zzhVarZzu.zza()) {
                    if (z) {
                    }
                    return zzhVarZzu;
                }
                z2 = z;
                zzj().zzv(zzhVarZzu, z2, false);
                return zzhVarZzu;
            }
            if (TextUtils.isEmpty(zzhVarZzu.zzd()) && zzjlVarZzs.zzo(zzjk.ANALYTICS_STORAGE)) {
                zzhVarZzu.zze(zzK(zzjlVarZzs));
            }
        }
        z = false;
        zzhVarZzu.zzg(zzrVar.zzb);
        str = zzrVar.zzk;
        if (!TextUtils.isEmpty(str)) {
            zzhVarZzu.zzm(str);
        }
        j = zzrVar.zze;
        if (j != 0) {
            zzhVarZzu.zzy(j);
        }
        str2 = zzrVar.zzc;
        if (!TextUtils.isEmpty(str2)) {
            zzhVarZzu.zzs(str2);
        }
        zzhVarZzu.zzu(zzrVar.zzj);
        str3 = zzrVar.zzd;
        if (str3 != null) {
            zzhVarZzu.zzw(str3);
        }
        zzhVarZzu.zzA(zzrVar.zzf);
        zzhVarZzu.zzE(zzrVar.zzh);
        str4 = zzrVar.zzg;
        if (!TextUtils.isEmpty(str4)) {
            zzhVarZzu.zzab(str4);
        }
        zzhVarZzu.zzad(zzrVar.zzn);
        zzhVarZzu.zzaf(zzrVar.zzp);
        zzhVarZzu.zzC(zzrVar.zzq);
        zzhVarZzu.zzi(zzrVar.zzu);
        zzpr.zza();
        if (zzd().zzp(null, zzfy.zzaL)) {
            zzhVarZzu.zzah(zzrVar.zzr);
        } else {
            zzpr.zza();
            if (zzd().zzp(null, zzfy.zzaK)) {
                zzhVarZzu.zzah(null);
            }
        }
        zzhVarZzu.zzaj(zzrVar.zzv);
        zzhVarZzu.zzaz(zzrVar.zzB);
        zzqp.zza();
        if (zzd().zzp(null, zzfy.zzaP)) {
            zzhVarZzu.zzap(zzrVar.zzz);
        }
        zzhVarZzu.zzal(zzrVar.zzw);
        zzhVarZzu.zzaG(zzrVar.zzC);
        zzhVarZzu.zzaK(zzrVar.zzE);
        if (!zzhVarZzu.zza()) {
            if (z) {
            }
            return zzhVarZzu;
        }
        z2 = z;
        zzj().zzv(zzhVarZzu, z2, false);
        return zzhVarZzu;
    }

    final String zzap(zzr zzrVar) {
        try {
            return (String) zzaW().zzh(new zzoz(this, zzrVar)).get(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzaV().zzb().zzc("Failed to get app instance id. appId", zzgu.zzl(zzrVar.zza), e);
            return null;
        }
    }

    final List zzaq(zzr zzrVar, Bundle bundle) {
        zzaW().zzg();
        zzqp.zza();
        zzal zzalVarZzd = zzd();
        String str = zzrVar.zza;
        if (!zzalVarZzd.zzp(str, zzfy.zzaP) || str == null) {
            return new ArrayList();
        }
        if (bundle != null) {
            int[] intArray = bundle.getIntArray("uriSources");
            long[] longArray = bundle.getLongArray("uriTimestamps");
            if (intArray != null) {
                if (longArray == null || longArray.length != intArray.length) {
                    zzaV().zzb().zza("Uri sources and timestamps do not match");
                } else {
                    for (int i = 0; i < intArray.length; i++) {
                        zzav zzavVarZzj = zzj();
                        int i2 = intArray[i];
                        long j = longArray[i];
                        Preconditions.checkNotEmpty(str);
                        zzavVarZzj.zzg();
                        zzavVarZzj.zzaw();
                        try {
                            int iDelete = zzavVarZzj.zze().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{str, String.valueOf(i2), String.valueOf(j)});
                            zzgs zzgsVarZzk = zzavVarZzj.zzu.zzaV().zzk();
                            StringBuilder sb = new StringBuilder(String.valueOf(iDelete).length() + 46);
                            sb.append("Pruned ");
                            sb.append(iDelete);
                            sb.append(" trigger URIs. appId, source, timestamp");
                            zzgsVarZzk.zzd(sb.toString(), str, Integer.valueOf(i2), Long.valueOf(j));
                        } catch (SQLiteException e) {
                            zzavVarZzj.zzu.zzaV().zzb().zzc("Error pruning trigger URIs. appId", zzgu.zzl(str), e);
                        }
                    }
                }
            }
        }
        zzav zzavVarZzj2 = zzj();
        String str2 = zzrVar.zza;
        Preconditions.checkNotEmpty(str2);
        zzavVarZzj2.zzg();
        zzavVarZzj2.zzaw();
        List arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = zzavVarZzj2.zze().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str2}, null, null, "rowid", null);
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(0);
                        if (string == null) {
                            string = "";
                        }
                        arrayList.add(new zzoh(string, cursorQuery.getLong(1), cursorQuery.getInt(2)));
                    } while (cursorQuery.moveToNext());
                }
            } catch (SQLiteException e2) {
                zzavVarZzj2.zzu.zzaV().zzb().zzc("Error querying trigger uris. appId", zzgu.zzl(str2), e2);
                arrayList = Collections.emptyList();
            }
            return arrayList;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    final void zzar(String str, zzaf zzafVar) {
        zzaW().zzg();
        zzu();
        zzav zzavVarZzj = zzj();
        long j = zzafVar.zza;
        zzpj zzpjVarZzB = zzavVarZzj.zzB(j);
        if (zzpjVarZzB == null) {
            zzaV().zze().zzc("[sgtm] Queued batch doesn't exist. appId, rowId", str, Long.valueOf(j));
            return;
        }
        String strZze = zzpjVarZzB.zze();
        if (zzafVar.zzb != zzlr.SUCCESS.zza()) {
            if (zzafVar.zzb == zzlr.BACKOFF.zza()) {
                Map map = this.zzF;
                zzpe zzpeVar = (zzpe) map.get(strZze);
                if (zzpeVar == null) {
                    zzpeVar = new zzpe(this);
                    map.put(strZze, zzpeVar);
                } else {
                    zzpeVar.zza();
                }
                zzaV().zzk().zzd("[sgtm] Putting sGTM server in backoff mode. appId, destination, nextRetryInSeconds", str, strZze, Long.valueOf((zzpeVar.zzc() - zzaZ().currentTimeMillis()) / 1000));
            }
            zzav zzavVarZzj2 = zzj();
            Long lValueOf = Long.valueOf(zzafVar.zza);
            zzavVarZzj2.zzK(lValueOf);
            zzaV().zzk().zzc("[sgtm] increased batch retry count after failed client upload. appId, rowId", str, lValueOf);
            return;
        }
        Map map2 = this.zzF;
        if (map2.containsKey(strZze)) {
            map2.remove(strZze);
        }
        zzav zzavVarZzj3 = zzj();
        Long lValueOf2 = Long.valueOf(j);
        zzavVarZzj3.zzE(lValueOf2);
        zzaV().zzk().zzc("[sgtm] queued batch deleted after successful client upload. appId, rowId", str, lValueOf2);
        long j2 = zzafVar.zzc;
        if (j2 > 0) {
            zzav zzavVarZzj4 = zzj();
            zzavVarZzj4.zzg();
            zzavVarZzj4.zzaw();
            Long lValueOf3 = Long.valueOf(j2);
            Preconditions.checkNotNull(lValueOf3);
            ContentValues contentValues = new ContentValues();
            contentValues.put("upload_type", Integer.valueOf(zzls.GOOGLE_SIGNAL.zza()));
            zzic zzicVar = zzavVarZzj4.zzu;
            contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzicVar.zzaZ().currentTimeMillis()));
            try {
                if (zzavVarZzj4.zze().update("upload_queue", contentValues, "rowid=? AND app_id=? AND upload_type=?", new String[]{String.valueOf(j2), str, String.valueOf(zzls.GOOGLE_SIGNAL_PENDING.zza())}) != 1) {
                    zzicVar.zzaV().zze().zzc("Google Signal pending batch not updated. appId, rowId", str, lValueOf3);
                }
                zzaV().zzk().zzc("[sgtm] queued Google Signal batch updated. appId, signalRowId", str, Long.valueOf(zzafVar.zzc));
                zzP(str);
            } catch (SQLiteException e) {
                zzavVarZzj4.zzu.zzaV().zzb().zzd("Failed to update google Signal pending batch. appid, rowId", str, Long.valueOf(j2), e);
                throw e;
            }
        }
    }

    final void zzas(boolean z) {
        zzaL();
    }

    public final void zzat(String str, zzlu zzluVar) {
        zzaW().zzg();
        String str2 = this.zzH;
        if (str2 == null || str2.equals(str) || zzluVar != null) {
            this.zzH = str;
            this.zzG = zzluVar;
        }
    }

    final /* synthetic */ void zzau(zzph zzphVar) {
        zzaW().zzg();
        this.zzm = new zzhk(this);
        zzav zzavVar = new zzav(this);
        zzavVar.zzax();
        this.zze = zzavVar;
        zzd().zza((zzak) Preconditions.checkNotNull(this.zzc));
        zznn zznnVar = new zznn(this);
        zznnVar.zzax();
        this.zzk = zznnVar;
        zzad zzadVar = new zzad(this);
        zzadVar.zzax();
        this.zzh = zzadVar;
        zzlp zzlpVar = new zzlp(this);
        zzlpVar.zzax();
        this.zzj = zzlpVar;
        zzok zzokVar = new zzok(this);
        zzokVar.zzax();
        this.zzg = zzokVar;
        this.zzf = new zzhb(this);
        if (this.zzs != this.zzt) {
            zzaV().zzb().zzc("Not all upload components initialized", Integer.valueOf(this.zzs), Integer.valueOf(this.zzt));
        }
        this.zzo.set(true);
        zzaV().zzk().zza("UploadController is now fully initialized");
    }

    final /* synthetic */ zzic zzax() {
        return this.zzn;
    }

    final /* synthetic */ Deque zzay() {
        return this.zzr;
    }

    final /* synthetic */ void zzaz(long j) {
        this.zzJ = j;
    }

    protected final void zzc() {
        zzaW().zzg();
        zzj().zzI();
        zzav zzavVarZzj = zzj();
        zzavVarZzj.zzg();
        zzavVarZzj.zzaw();
        if (zzavVarZzj.zzag()) {
            zzfx zzfxVar = zzfy.zzav;
            if (((Long) zzfxVar.zzb(null)).longValue() != 0) {
                SQLiteDatabase sQLiteDatabaseZze = zzavVarZzj.zze();
                zzic zzicVar = zzavVarZzj.zzu;
                int iDelete = sQLiteDatabaseZze.delete("trigger_uris", "abs(timestamp_millis - ?) > cast(? as integer)", new String[]{String.valueOf(zzicVar.zzaZ().currentTimeMillis()), String.valueOf(zzfxVar.zzb(null))});
                if (iDelete > 0) {
                    zzicVar.zzaV().zzk().zzb("Deleted stale trigger uris. rowsDeleted", Integer.valueOf(iDelete));
                }
            }
        }
        if (this.zzk.zzd.zza() == 0) {
            this.zzk.zzd.zzb(zzaZ().currentTimeMillis());
        }
        zzaL();
    }

    public final zzal zzd() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzc();
    }

    public final zzou zzf() {
        return this.zzl;
    }

    public final zzht zzh() {
        zzht zzhtVar = this.zzc;
        zzaS(zzhtVar);
        return zzhtVar;
    }

    public final zzgz zzi() {
        zzgz zzgzVar = this.zzd;
        zzaS(zzgzVar);
        return zzgzVar;
    }

    public final zzav zzj() {
        zzav zzavVar = this.zze;
        zzaS(zzavVar);
        return zzavVar;
    }

    public final zzhb zzk() {
        zzhb zzhbVar = this.zzf;
        if (zzhbVar != null) {
            return zzhbVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzok zzl() {
        zzok zzokVar = this.zzg;
        zzaS(zzokVar);
        return zzokVar;
    }

    public final zzad zzm() {
        zzad zzadVar = this.zzh;
        zzaS(zzadVar);
        return zzadVar;
    }

    public final zzlp zzn() {
        zzlp zzlpVar = this.zzj;
        zzaS(zzlpVar);
        return zzlpVar;
    }

    public final zzpk zzp() {
        zzpk zzpkVar = this.zzi;
        zzaS(zzpkVar);
        return zzpkVar;
    }

    public final zznn zzq() {
        return this.zzk;
    }

    public final zzgn zzs() {
        return this.zzn.zzl();
    }

    public final zzpp zzt() {
        return ((zzic) Preconditions.checkNotNull(this.zzn)).zzk();
    }

    final void zzu() {
        if (!this.zzo.get()) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    final void zzv(zzr zzrVar) {
        zzaW().zzg();
        zzu();
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzjl zzjlVarZzf = zzjl.zzf(zzrVar.zzs, zzrVar.zzx);
        zzB(str);
        zzaV().zzk().zzc("Setting storage consent for package", str, zzjlVarZzf);
        zzA(str, zzjlVarZzf);
    }

    final void zzw(zzr zzrVar) {
        zzaW().zzg();
        zzu();
        String str = zzrVar.zza;
        Preconditions.checkNotEmpty(str);
        zzaz zzazVarZzg = zzaz.zzg(zzrVar.zzy);
        zzaV().zzk().zzc("Setting DMA consent for package", str, zzazVarZzg);
        zzaW().zzg();
        zzu();
        zzji zzjiVarZzc = zzaz.zzh(zzy(str), 100).zzc();
        this.zzD.put(str, zzazVarZzg);
        zzj().zzab(str, zzazVarZzg);
        zzji zzjiVarZzc2 = zzaz.zzh(zzy(str), 100).zzc();
        zzaW().zzg();
        zzu();
        zzji zzjiVar = zzji.DENIED;
        boolean z = zzjiVarZzc == zzjiVar && zzjiVarZzc2 == zzji.GRANTED;
        boolean z2 = zzjiVarZzc == zzji.GRANTED && zzjiVarZzc2 == zzjiVar;
        if (z || z2) {
            zzaV().zzk().zzb("Generated _dcu event for", str);
            Bundle bundle = new Bundle();
            if (zzj().zzw(zzC(), str, false, false, false, false, false, false, false).zzf < zzd().zzm(str, zzfy.zzam)) {
                bundle.putLong("_r", 1L);
                zzaV().zzk().zzc("_dcu realtime event count", str, Long.valueOf(zzj().zzw(zzC(), str, false, false, false, false, false, true, false).zzf));
            }
            this.zzK.zza(str, "_dcu", bundle);
        }
    }

    final zzaz zzx(String str) {
        zzaW().zzg();
        zzu();
        Map map = this.zzD;
        zzaz zzazVar = (zzaz) map.get(str);
        if (zzazVar != null) {
            return zzazVar;
        }
        zzaz zzazVarZzaa = zzj().zzaa(str);
        map.put(str, zzazVarZzaa);
        return zzazVarZzaa;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    final Bundle zzy(String str) throws Throwable {
        zzaW().zzg();
        zzu();
        if (zzh().zzx(str) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        zzjl zzjlVarZzB = zzB(str);
        bundle.putAll(zzjlVarZzB.zzn());
        bundle.putAll(zzz(str, zzx(str), zzjlVarZzB, new zzan()).zzf());
        zzpn zzpnVarZzm = zzj().zzm(str, "_npa");
        bundle.putString("ad_personalization", 1 != (zzpnVarZzm != null ? zzpnVarZzm.zze.equals(1L) : zzaC(str, new zzan())) ? "granted" : "denied");
        return bundle;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x005b  */
    /* JADX WARN: Code duplicated, block: B:23:0x006b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0079  */
    /* JADX WARN: Code duplicated, block: B:30:0x0084  */
    /* JADX WARN: Code duplicated, block: B:31:0x0086  */
    final zzaz zzz(String str, zzaz zzazVar, zzjl zzjlVar, zzan zzanVar) {
        zzji zzjiVar;
        zzht zzhtVar;
        zzjk zzjkVar;
        zzjk zzjkVarZzw;
        int iZzb = 90;
        if (zzh().zzx(str) == null) {
            if (zzazVar.zzc() == zzji.DENIED) {
                iZzb = zzazVar.zzb();
                zzanVar.zzb(zzjk.AD_USER_DATA, iZzb);
            } else {
                zzanVar.zzc(zzjk.AD_USER_DATA, zzam.FAILSAFE);
            }
            return new zzaz((Boolean) false, iZzb, (Boolean) true, "-");
        }
        zzji zzjiVarZzc = zzazVar.zzc();
        zzji zzjiVar2 = zzji.GRANTED;
        if (zzjiVarZzc == zzjiVar2 || zzjiVarZzc == (zzjiVar = zzji.DENIED)) {
            iZzb = zzazVar.zzb();
            zzanVar.zzb(zzjk.AD_USER_DATA, iZzb);
        } else if (zzjiVarZzc == zzji.POLICY) {
            zzht zzhtVar2 = this.zzc;
            zzjk zzjkVar2 = zzjk.AD_USER_DATA;
            zzji zzjiVarZzA = zzhtVar2.zzA(str, zzjkVar2);
            if (zzjiVarZzA != zzji.UNINITIALIZED) {
                zzanVar.zzc(zzjkVar2, zzam.REMOTE_ENFORCED_DEFAULT);
                zzjiVarZzc = zzjiVarZzA;
            } else {
                zzhtVar = this.zzc;
                zzjkVar = zzjk.AD_USER_DATA;
                zzjkVarZzw = zzhtVar.zzw(str, zzjkVar);
                zzji zzjiVarZzp = zzjlVar.zzp();
                boolean z = zzjiVarZzp != zzjiVar2 || zzjiVarZzp == zzjiVar;
                if (zzjkVarZzw == zzjk.AD_STORAGE || !z) {
                    zzanVar.zzc(zzjkVar, zzam.REMOTE_DEFAULT);
                    if (true != zzhtVar.zzv(str, zzjkVar)) {
                        zzjiVarZzc = zzjiVar;
                    } else {
                        zzjiVarZzc = zzjiVar2;
                    }
                } else {
                    zzanVar.zzc(zzjkVar, zzam.REMOTE_DELEGATION);
                    zzjiVarZzc = zzjiVarZzp;
                }
            }
        } else {
            zzhtVar = this.zzc;
            zzjkVar = zzjk.AD_USER_DATA;
            zzjkVarZzw = zzhtVar.zzw(str, zzjkVar);
            zzji zzjiVarZzp2 = zzjlVar.zzp();
            if (zzjiVarZzp2 != zzjiVar2) {
            }
            if (zzjkVarZzw == zzjk.AD_STORAGE) {
                zzanVar.zzc(zzjkVar, zzam.REMOTE_DEFAULT);
                if (true != zzhtVar.zzv(str, zzjkVar)) {
                    zzjiVarZzc = zzjiVar;
                } else {
                    zzjiVarZzc = zzjiVar2;
                }
            } else {
                zzanVar.zzc(zzjkVar, zzam.REMOTE_DEFAULT);
                if (true != zzhtVar.zzv(str, zzjkVar)) {
                    zzjiVarZzc = zzjiVar;
                } else {
                    zzjiVarZzc = zzjiVar2;
                }
            }
        }
        boolean zZzy = this.zzc.zzy(str);
        SortedSet sortedSetZzz = zzh().zzz(str);
        if (zzjiVarZzc == zzji.DENIED || sortedSetZzz.isEmpty()) {
            return new zzaz((Boolean) false, iZzb, Boolean.valueOf(zZzy), "-");
        }
        return new zzaz((Boolean) true, iZzb, Boolean.valueOf(zZzy), zZzy ? TextUtils.join("", sortedSetZzz) : "");
    }
}
