package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzpu;
import com.google.firebase.messaging.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzad extends zzos {
    private String zza;
    private Set zzb;
    private Map zzc;
    private Long zzd;
    private Long zze;

    zzad(zzpg zzpgVar) {
        super(zzpgVar);
    }

    private final zzy zzc(Integer num) {
        if (this.zzc.containsKey(num)) {
            return (zzy) this.zzc.get(num);
        }
        zzy zzyVar = new zzy(this, this.zza, null);
        this.zzc.put(num, zzyVar);
        return zzyVar;
    }

    private final boolean zzd(int i, int i2) {
        zzy zzyVar = (zzy) this.zzc.get(Integer.valueOf(i));
        if (zzyVar == null) {
            return false;
        }
        return zzyVar.zzc().get(i2);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0253  */
    /* JADX WARN: Code duplicated, block: B:101:0x025b  */
    /* JADX WARN: Code duplicated, block: B:103:0x0266  */
    /* JADX WARN: Code duplicated, block: B:107:0x0292 A[Catch: all -> 0x02ca, SQLiteException -> 0x02cd, LOOP:11: B:107:0x0292->B:515:?, LOOP_START, TryCatch #22 {all -> 0x02ca, blocks: (B:105:0x028c, B:107:0x0292, B:109:0x02a3, B:110:0x02ab, B:114:0x02c3, B:125:0x02d5), top: B:461:0x0282 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x02a3 A[Catch: all -> 0x02ca, SQLiteException -> 0x02cd, TryCatch #22 {all -> 0x02ca, blocks: (B:105:0x028c, B:107:0x0292, B:109:0x02a3, B:110:0x02ab, B:114:0x02c3, B:125:0x02d5), top: B:461:0x0282 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x02bf A[PHI: r0 r5
  0x02bf: PHI (r0v55 java.util.Map) = (r0v40 java.util.Map), (r0v57 java.util.Map), (r0v34 java.util.Map) binds: [B:126:0x02ec, B:115:0x02c7, B:112:0x02bd] A[DONT_GENERATE, DONT_INLINE]
  0x02bf: PHI (r5v14 android.database.Cursor) = (r5v9 android.database.Cursor), (r5v15 android.database.Cursor), (r5v15 android.database.Cursor) binds: [B:126:0x02ec, B:115:0x02c7, B:112:0x02bd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:114:0x02c3 A[Catch: all -> 0x02ca, SQLiteException -> 0x02cd, TRY_ENTER, TRY_LEAVE, TryCatch #22 {all -> 0x02ca, blocks: (B:105:0x028c, B:107:0x0292, B:109:0x02a3, B:110:0x02ab, B:114:0x02c3, B:125:0x02d5), top: B:461:0x0282 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x0304  */
    /* JADX WARN: Code duplicated, block: B:134:0x0312  */
    /* JADX WARN: Code duplicated, block: B:136:0x0329  */
    /* JADX WARN: Code duplicated, block: B:160:0x03fa  */
    /* JADX WARN: Code duplicated, block: B:162:0x03fe  */
    /* JADX WARN: Code duplicated, block: B:166:0x040b  */
    /* JADX WARN: Code duplicated, block: B:168:0x042c  */
    /* JADX WARN: Code duplicated, block: B:174:0x0441  */
    /* JADX WARN: Code duplicated, block: B:178:0x045b  */
    /* JADX WARN: Code duplicated, block: B:179:0x0464  */
    /* JADX WARN: Code duplicated, block: B:183:0x0470  */
    /* JADX WARN: Code duplicated, block: B:189:0x0485  */
    /* JADX WARN: Code duplicated, block: B:196:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:199:0x04c6  */
    /* JADX WARN: Code duplicated, block: B:201:0x04d0  */
    /* JADX WARN: Code duplicated, block: B:203:0x04f2  */
    /* JADX WARN: Code duplicated, block: B:204:0x04f6  */
    /* JADX WARN: Code duplicated, block: B:209:0x050e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:234:0x05b6  */
    /* JADX WARN: Code duplicated, block: B:237:0x05cb  */
    /* JADX WARN: Code duplicated, block: B:243:0x0602  */
    /* JADX WARN: Code duplicated, block: B:251:0x0643  */
    /* JADX WARN: Code duplicated, block: B:258:0x066b  */
    /* JADX WARN: Code duplicated, block: B:260:0x0676  */
    /* JADX WARN: Code duplicated, block: B:267:0x069a  */
    /* JADX WARN: Code duplicated, block: B:269:0x069f A[LOOP:8: B:252:0x0645->B:269:0x069f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:272:0x06a6  */
    /* JADX WARN: Code duplicated, block: B:275:0x06b0 A[PHI: r0 r5 r23 r27 r28
  0x06b0: PHI (r0v78 java.util.Map) = (r0v80 java.util.Map), (r0v86 java.util.Map) binds: [B:293:0x06e8, B:274:0x06ae] A[DONT_GENERATE, DONT_INLINE]
  0x06b0: PHI (r5v26 android.database.Cursor) = (r5v27 android.database.Cursor), (r5v28 android.database.Cursor) binds: [B:293:0x06e8, B:274:0x06ae] A[DONT_GENERATE, DONT_INLINE]
  0x06b0: PHI (r23v9 com.google.android.gms.measurement.internal.zzbc) = (r23v10 com.google.android.gms.measurement.internal.zzbc), (r23v14 com.google.android.gms.measurement.internal.zzbc) binds: [B:293:0x06e8, B:274:0x06ae] A[DONT_GENERATE, DONT_INLINE]
  0x06b0: PHI (r27v7 java.lang.String) = (r27v8 java.lang.String), (r27v11 java.lang.String) binds: [B:293:0x06e8, B:274:0x06ae] A[DONT_GENERATE, DONT_INLINE]
  0x06b0: PHI (r28v8 java.lang.String) = (r28v9 java.lang.String), (r28v11 java.lang.String) binds: [B:293:0x06e8, B:274:0x06ae] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:299:0x06f5  */
    /* JADX WARN: Code duplicated, block: B:303:0x0709  */
    /* JADX WARN: Code duplicated, block: B:309:0x073a  */
    /* JADX WARN: Code duplicated, block: B:311:0x0767 A[LOOP:10: B:307:0x0734->B:311:0x0767, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:315:0x077d  */
    /* JADX WARN: Code duplicated, block: B:319:0x0791  */
    /* JADX WARN: Code duplicated, block: B:322:0x079b  */
    /* JADX WARN: Code duplicated, block: B:325:0x07aa  */
    /* JADX WARN: Code duplicated, block: B:327:0x07bd  */
    /* JADX WARN: Code duplicated, block: B:333:0x07fa A[Catch: SQLiteException -> 0x0865, all -> 0x0894, LOOP:4: B:333:0x07fa->B:350:0x0854, LOOP_START, PHI: r3
  0x07fa: PHI (r3v45 java.util.Iterator) = (r3v38 java.util.Iterator), (r3v47 java.util.Iterator) binds: [B:332:0x07f8, B:350:0x0854] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #16 {SQLiteException -> 0x0865, blocks: (B:331:0x07f4, B:333:0x07fa, B:334:0x07ff, B:336:0x0810, B:338:0x0820, B:340:0x082b, B:342:0x0832), top: B:452:0x07f4 }] */
    /* JADX WARN: Code duplicated, block: B:338:0x0820 A[Catch: SQLiteException -> 0x0865, all -> 0x0894, TryCatch #16 {SQLiteException -> 0x0865, blocks: (B:331:0x07f4, B:333:0x07fa, B:334:0x07ff, B:336:0x0810, B:338:0x0820, B:340:0x082b, B:342:0x0832), top: B:452:0x07f4 }] */
    /* JADX WARN: Code duplicated, block: B:339:0x0829  */
    /* JADX WARN: Code duplicated, block: B:348:0x084f  */
    /* JADX WARN: Code duplicated, block: B:350:0x0854 A[LOOP:4: B:333:0x07fa->B:350:0x0854, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:351:0x0857  */
    /* JADX WARN: Code duplicated, block: B:354:0x085f A[PHI: r0 r13 r31
  0x085f: PHI (r0v126 java.util.Map) = (r0v128 java.util.Map), (r0v133 java.util.Map) binds: [B:367:0x088d, B:353:0x085d] A[DONT_GENERATE, DONT_INLINE]
  0x085f: PHI (r13v22 android.database.Cursor) = (r13v23 android.database.Cursor), (r13v24 android.database.Cursor) binds: [B:367:0x088d, B:353:0x085d] A[DONT_GENERATE, DONT_INLINE]
  0x085f: PHI (r31v6 java.util.Iterator) = (r31v7 java.util.Iterator), (r31v10 java.util.Iterator) binds: [B:367:0x088d, B:353:0x085d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:375:0x089c  */
    /* JADX WARN: Code duplicated, block: B:379:0x08b0  */
    /* JADX WARN: Code duplicated, block: B:382:0x08d1  */
    /* JADX WARN: Code duplicated, block: B:385:0x08e2  */
    /* JADX WARN: Code duplicated, block: B:387:0x08f9  */
    /* JADX WARN: Code duplicated, block: B:389:0x0907  */
    /* JADX WARN: Code duplicated, block: B:390:0x0912  */
    /* JADX WARN: Code duplicated, block: B:392:0x0940  */
    /* JADX WARN: Code duplicated, block: B:395:0x094a  */
    /* JADX WARN: Code duplicated, block: B:404:0x0993  */
    /* JADX WARN: Code duplicated, block: B:405:0x099c  */
    /* JADX WARN: Code duplicated, block: B:409:0x09ad A[PHI: r16 r32
  0x09ad: PHI (r16v13 java.lang.String) = (r16v14 java.lang.String), (r1v17 java.lang.String) binds: [B:408:0x09ab, B:406:0x099d] A[DONT_GENERATE, DONT_INLINE]
  0x09ad: PHI (r32v6 java.util.Map) = (r32v7 java.util.Map), (r32v9 java.util.Map) binds: [B:408:0x09ab, B:406:0x099d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:415:0x09da  */
    /* JADX WARN: Code duplicated, block: B:420:0x0a36 A[Catch: SQLiteException -> 0x0a4a, TRY_LEAVE, TryCatch #26 {SQLiteException -> 0x0a4a, blocks: (B:418:0x0a2c, B:420:0x0a36), top: B:465:0x0a2c }] */
    /* JADX WARN: Code duplicated, block: B:429:0x0a66  */
    /* JADX WARN: Code duplicated, block: B:485:0x0a61 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:490:0x084d A[EDGE_INSN: B:490:0x084d->B:347:0x084d BREAK  A[LOOP:4: B:333:0x07fa->B:350:0x0854], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:491:0x08c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:493:0x09b2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:494:0x09a7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:495:0x097f A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:499:0x05d9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:500:0x05f2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:502:0x05c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:503:0x05c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:505:0x0698 A[EDGE_INSN: B:505:0x0698->B:266:0x0698 BREAK  A[LOOP:8: B:252:0x0645->B:269:0x069f], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:506:0x0729 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:508:0x071b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:512:0x0779 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:513:0x0772 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:517:0x056c A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:524:0x044d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:526:0x043b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:529:0x0491 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:532:0x047f A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:544:0x03e5 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:558:0x020d A[EDGE_INSN: B:558:0x020d->B:79:0x020d BREAK  A[LOOP:20: B:68:0x01c1->B:82:0x0215], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x0176  */
    /* JADX WARN: Code duplicated, block: B:63:0x01ac A[Catch: SQLiteException -> 0x0220, all -> 0x0a6c, TRY_LEAVE, TryCatch #6 {SQLiteException -> 0x0220, blocks: (B:61:0x01a6, B:63:0x01ac, B:67:0x01bc, B:68:0x01c1, B:69:0x01cb, B:70:0x01db, B:72:0x01ea), top: B:441:0x01a6 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:67:0x01bc A[Catch: SQLiteException -> 0x0220, all -> 0x0a6c, TRY_ENTER, TryCatch #6 {SQLiteException -> 0x0220, blocks: (B:61:0x01a6, B:63:0x01ac, B:67:0x01bc, B:68:0x01c1, B:69:0x01cb, B:70:0x01db, B:72:0x01ea), top: B:441:0x01a6 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x020f  */
    /* JADX WARN: Code duplicated, block: B:82:0x0215 A[LOOP:20: B:68:0x01c1->B:82:0x0215, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:96:0x0249  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v189, types: [android.content.ContentValues] */
    /* JADX WARN: Type inference failed for: r4v26, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v43 */
    /* JADX WARN: Type inference failed for: r5v45, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v49, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r5v5, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v50 */
    /* JADX WARN: Type inference failed for: r5v51, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v52 */
    /* JADX WARN: Type inference failed for: r5v53 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.database.Cursor] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    final List zzb(String str, List list, List list2, Long l, Long l2, boolean z) throws Throwable {
        int i;
        int i2;
        boolean z2;
        ?? r5;
        Map map;
        Cursor cursor;
        String str2;
        Cursor cursorQuery;
        Map map2;
        String str3;
        Map map3;
        String str4;
        String str5;
        String str6;
        com.google.android.gms.internal.measurement.zzii zziiVar;
        BitSet bitSet;
        BitSet bitSet2;
        ArrayMap arrayMap;
        List<com.google.android.gms.internal.measurement.zzff> list3;
        int i3;
        String str7;
        Iterator it;
        com.google.android.gms.internal.measurement.zzik zzikVar;
        Long lValueOf;
        String str8;
        Map arrayMap2;
        ?? Zze;
        Cursor cursorRawQuery;
        ArrayMap arrayMap3;
        Iterator it2;
        Integer num;
        com.google.android.gms.internal.measurement.zzii zziiVar2;
        List list4;
        Map map4;
        Iterator it3;
        String str9;
        Integer numValueOf;
        List arrayList;
        String str10;
        zzz zzzVar;
        ArrayMap arrayMap4;
        Iterator it4;
        com.google.android.gms.internal.measurement.zzhs zzhsVar;
        com.google.android.gms.internal.measurement.zzhs zzhsVarZza;
        zzpg zzpgVar;
        zzbc zzbcVarZzaf;
        long j;
        String strZzd;
        Map mapEmptyMap;
        zzbc zzbcVar;
        int iIntValue;
        Iterator it5;
        boolean z3;
        Map map5;
        zzaa zzaaVar;
        boolean zZzd;
        zzav zzavVarZzj;
        String str11;
        ArrayMap arrayMap5;
        String str12;
        String str13;
        Cursor cursorQuery2;
        Integer numValueOf2;
        List list5;
        List arrayList2;
        String str14;
        ArrayMap arrayMap6;
        Iterator it6;
        String strZzc;
        Map mapEmptyMap2;
        String str15;
        String str16;
        Iterator it7;
        boolean zZzd2;
        com.google.android.gms.internal.measurement.zzfn zzfnVar;
        zzic zzicVar;
        Integer numValueOf3;
        zzac zzacVar;
        Integer numValueOf4;
        zzav zzavVarZzj2;
        String str17;
        ArrayMap arrayMap7;
        Cursor cursor2;
        Cursor cursorQuery3;
        Integer numValueOf5;
        List list6;
        List arrayList3;
        String str18;
        ArrayList arrayList4;
        zzav zzavVarZzj3;
        String str19;
        ContentValues contentValues;
        ArrayMap arrayMap8;
        int i4;
        Cursor cursorQuery4;
        List arrayList5;
        String str20 = "current_results";
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.zza = str;
        this.zzb = new HashSet();
        this.zzc = new ArrayMap();
        this.zzd = l;
        this.zze = l2;
        Iterator it8 = list.iterator();
        while (true) {
            i = 0;
            i2 = 1;
            if (!it8.hasNext()) {
                z2 = false;
                break;
            }
            if ("_s".equals(((com.google.android.gms.internal.measurement.zzhs) it8.next()).zzd())) {
                z2 = true;
                break;
            }
        }
        zzpu.zza();
        zzic zzicVar2 = this.zzu;
        boolean zZzp = zzicVar2.zzc().zzp(this.zza, zzfy.zzaF);
        zzpu.zza();
        boolean zZzp2 = zzicVar2.zzc().zzp(this.zza, zzfy.zzaE);
        if (z2) {
            zzav zzavVarZzj4 = this.zzg.zzj();
            String str21 = this.zza;
            zzavVarZzj4.zzaw();
            zzavVarZzj4.zzg();
            Preconditions.checkNotEmpty(str21);
            ?? contentValues2 = new ContentValues();
            ?? r6 = 0;
            contentValues2.put("current_session_count", r6);
            try {
                r6 = "events";
                zzavVarZzj4.zze().update("events", contentValues2, "app_id = ?", new String[]{str21});
                r5 = "events";
            } catch (SQLiteException e) {
                zzavVarZzj4.zzu.zzaV().zzb().zzc("Error resetting session-scoped event counts. appId", zzgu.zzl(str21), e);
                r5 = r6;
            }
        }
        Map mapEmptyMap3 = Collections.emptyMap();
        String str22 = "Failed to merge filter. appId";
        String str23 = "Database error querying filters. appId";
        String str24 = Constants.ScionAnalytics.MessageType.DATA_MESSAGE;
        String str25 = "audience_id";
        if (zZzp2 && zZzp) {
            zzav zzavVarZzj5 = this.zzg.zzj();
            String str26 = this.zza;
            Preconditions.checkNotEmpty(str26);
            ArrayMap arrayMap9 = new ArrayMap();
            try {
                try {
                    cursorQuery4 = zzavVarZzj5.zze().query("event_filters", new String[]{"audience_id", Constants.ScionAnalytics.MessageType.DATA_MESSAGE}, "app_id=?", new String[]{str26}, null, null, null);
                    try {
                        if (cursorQuery4.moveToFirst()) {
                            while (true) {
                                try {
                                    com.google.android.gms.internal.measurement.zzff zzffVar = (com.google.android.gms.internal.measurement.zzff) ((com.google.android.gms.internal.measurement.zzfe) zzpk.zzw(com.google.android.gms.internal.measurement.zzff.zzn(), cursorQuery4.getBlob(i2))).zzbc();
                                    if (zzffVar.zzg()) {
                                        Integer numValueOf6 = Integer.valueOf(cursorQuery4.getInt(i));
                                        List list7 = (List) arrayMap9.get(numValueOf6);
                                        if (list7 == null) {
                                            arrayList5 = new ArrayList();
                                            arrayMap9.put(numValueOf6, arrayList5);
                                        } else {
                                            arrayList5 = list7;
                                        }
                                        arrayList5.add(zzffVar);
                                    }
                                } catch (IOException e2) {
                                    zzavVarZzj5.zzu.zzaV().zzb().zzc("Failed to merge filter. appId", zzgu.zzl(str26), e2);
                                }
                                if (!cursorQuery4.moveToNext()) {
                                    break;
                                }
                                i = 0;
                                i2 = 1;
                            }
                            if (cursorQuery4 != null) {
                                cursorQuery4.close();
                            }
                            map = arrayMap9;
                        } else {
                            mapEmptyMap3 = Collections.emptyMap();
                            if (cursorQuery4 != null) {
                                cursorQuery4.close();
                            }
                            map = mapEmptyMap3;
                        }
                    } catch (SQLiteException e3) {
                        e = e3;
                        zzavVarZzj5.zzu.zzaV().zzb().zzc("Database error querying filters. appId", zzgu.zzl(str26), e);
                        mapEmptyMap3 = Collections.emptyMap();
                        if (cursorQuery4 != null) {
                        }
                        map = mapEmptyMap3;
                        zzav zzavVarZzj6 = this.zzg.zzj();
                        String str27 = this.zza;
                        zzavVarZzj6.zzaw();
                        zzavVarZzj6.zzg();
                        Preconditions.checkNotEmpty(str27);
                        cursorQuery = zzavVarZzj6.zze().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str27}, null, null, null);
                        try {
                            if (cursorQuery.moveToFirst()) {
                                arrayMap8 = new ArrayMap();
                                while (true) {
                                    i4 = cursorQuery.getInt(0);
                                    try {
                                        arrayMap8.put(Integer.valueOf(i4), (com.google.android.gms.internal.measurement.zzii) ((com.google.android.gms.internal.measurement.zzih) zzpk.zzw(com.google.android.gms.internal.measurement.zzii.zzi(), cursorQuery.getBlob(1))).zzbc());
                                        str2 = str25;
                                    } catch (IOException e4) {
                                        str2 = str25;
                                        try {
                                            zzavVarZzj6.zzu.zzaV().zzb().zzd("Failed to merge filter results. appId, audienceId, error", zzgu.zzl(str27), Integer.valueOf(i4), e4);
                                        } catch (SQLiteException e5) {
                                            e = e5;
                                            str24 = str24;
                                            zzavVarZzj6.zzu.zzaV().zzb().zzc("Database error querying filter results. appId", zzgu.zzl(str27), e);
                                            Map mapEmptyMap4 = Collections.emptyMap();
                                            if (cursorQuery != null) {
                                                cursorQuery.close();
                                            }
                                            map2 = mapEmptyMap4;
                                            if (map2.isEmpty()) {
                                                str6 = "Database error querying filters. appId";
                                                str4 = "Failed to merge filter. appId";
                                                str5 = str2;
                                            } else {
                                                HashSet<Integer> hashSet = new HashSet(map2.keySet());
                                                if (z2) {
                                                    String str28 = this.zza;
                                                    zzav zzavVarZzj7 = this.zzg.zzj();
                                                    str8 = this.zza;
                                                    zzavVarZzj7.zzaw();
                                                    zzavVarZzj7.zzg();
                                                    Preconditions.checkNotEmpty(str8);
                                                    arrayMap2 = new ArrayMap();
                                                    Zze = zzavVarZzj7.zze();
                                                    try {
                                                        try {
                                                            cursorRawQuery = Zze.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str8, str8});
                                                            try {
                                                                if (cursorRawQuery.moveToFirst()) {
                                                                    do {
                                                                        numValueOf = Integer.valueOf(cursorRawQuery.getInt(0));
                                                                        arrayList = (List) arrayMap2.get(numValueOf);
                                                                        if (arrayList == null) {
                                                                            arrayList = new ArrayList();
                                                                            arrayMap2.put(numValueOf, arrayList);
                                                                        }
                                                                        arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                                                                    } while (cursorRawQuery.moveToNext());
                                                                    if (cursorRawQuery != null) {
                                                                        cursorRawQuery.close();
                                                                    }
                                                                } else {
                                                                    arrayMap2 = Collections.emptyMap();
                                                                    if (cursorRawQuery != null) {
                                                                        cursorRawQuery.close();
                                                                    }
                                                                }
                                                            } catch (SQLiteException e6) {
                                                                e = e6;
                                                                zzavVarZzj7.zzu.zzaV().zzb().zzc("Database error querying scoped filters. appId", zzgu.zzl(str8), e);
                                                                arrayMap2 = Collections.emptyMap();
                                                                if (cursorRawQuery != null) {
                                                                }
                                                                Preconditions.checkNotEmpty(str28);
                                                                Preconditions.checkNotNull(map2);
                                                                arrayMap3 = new ArrayMap();
                                                                if (!map2.isEmpty()) {
                                                                    it2 = map2.keySet().iterator();
                                                                    while (it2.hasNext()) {
                                                                        num = (Integer) it2.next();
                                                                        num.intValue();
                                                                        zziiVar2 = (com.google.android.gms.internal.measurement.zzii) map2.get(num);
                                                                        list4 = (List) arrayMap2.get(num);
                                                                        if (list4 != null) {
                                                                        }
                                                                        map4 = arrayMap2;
                                                                        it3 = it2;
                                                                        str9 = str23;
                                                                        arrayMap3.put(num, zziiVar2);
                                                                        arrayMap2 = map4;
                                                                        it2 = it3;
                                                                        str23 = str9;
                                                                    }
                                                                }
                                                                str3 = str23;
                                                                map3 = arrayMap3;
                                                                for (Integer num2 : hashSet) {
                                                                    num2.intValue();
                                                                    zziiVar = (com.google.android.gms.internal.measurement.zzii) map3.get(num2);
                                                                    bitSet = new BitSet();
                                                                    bitSet2 = new BitSet();
                                                                    arrayMap = new ArrayMap();
                                                                    if (zziiVar != null) {
                                                                        for (com.google.android.gms.internal.measurement.zzhq zzhqVar : zziiVar.zze()) {
                                                                            if (zzhqVar.zza()) {
                                                                                Integer numValueOf7 = Integer.valueOf(zzhqVar.zzb());
                                                                                if (zzhqVar.zzc()) {
                                                                                    lValueOf = Long.valueOf(zzhqVar.zzd());
                                                                                } else {
                                                                                    lValueOf = null;
                                                                                }
                                                                                arrayMap.put(numValueOf7, lValueOf);
                                                                            }
                                                                        }
                                                                    }
                                                                    ArrayMap arrayMap10 = new ArrayMap();
                                                                    if (zziiVar != null) {
                                                                        it = zziiVar.zzg().iterator();
                                                                        while (it.hasNext()) {
                                                                            zzikVar = (com.google.android.gms.internal.measurement.zzik) it.next();
                                                                            if (!zzikVar.zza()) {
                                                                            }
                                                                        }
                                                                    }
                                                                    Map map6 = map3;
                                                                    if (zziiVar != null) {
                                                                        i3 = 0;
                                                                        while (i3 < zziiVar.zzb() * 64) {
                                                                            if (zzpk.zzn(zziiVar.zza(), i3)) {
                                                                                str7 = str22;
                                                                                this.zzu.zzaV().zzk().zzc("Filter already evaluated. audience ID, filter ID", num2, Integer.valueOf(i3));
                                                                                bitSet2.set(i3);
                                                                                if (zzpk.zzn(zziiVar.zzc(), i3)) {
                                                                                    bitSet.set(i3);
                                                                                }
                                                                                i3++;
                                                                                str22 = str7;
                                                                            } else {
                                                                                str7 = str22;
                                                                            }
                                                                            arrayMap.remove(Integer.valueOf(i3));
                                                                            i3++;
                                                                            str22 = str7;
                                                                        }
                                                                    }
                                                                    String str29 = str22;
                                                                    com.google.android.gms.internal.measurement.zzii zziiVar3 = (com.google.android.gms.internal.measurement.zzii) map2.get(num2);
                                                                    if (!zZzp2) {
                                                                    }
                                                                    this.zzc.put(num2, new zzy(this, this.zza, zziiVar3, bitSet, bitSet2, arrayMap, arrayMap10, null));
                                                                    map2 = map2;
                                                                    str22 = str29;
                                                                    zZzp = zZzp;
                                                                    map = map;
                                                                    map3 = map6;
                                                                    str2 = str2;
                                                                }
                                                                str4 = str22;
                                                                str5 = str2;
                                                                str6 = str3;
                                                                str10 = "Skipping failed audience ID";
                                                                if (!list.isEmpty()) {
                                                                    zzzVar = new zzz(this, null);
                                                                    arrayMap4 = new ArrayMap();
                                                                    it4 = list.iterator();
                                                                    while (it4.hasNext()) {
                                                                        zzhsVar = (com.google.android.gms.internal.measurement.zzhs) it4.next();
                                                                        zzhsVarZza = zzzVar.zza(this.zza, zzhsVar);
                                                                        if (zzhsVarZza != null) {
                                                                            zzpgVar = this.zzg;
                                                                            zzbcVarZzaf = zzpgVar.zzj().zzaf(this.zza, zzhsVar, zzhsVarZza.zzd());
                                                                            zzpgVar.zzj().zzh(zzbcVarZzaf);
                                                                            if (!z) {
                                                                                zzz zzzVar2 = zzzVar;
                                                                                j = zzbcVarZzaf.zzc;
                                                                                strZzd = zzhsVarZza.zzd();
                                                                                mapEmptyMap = (Map) arrayMap4.get(strZzd);
                                                                                if (mapEmptyMap == null) {
                                                                                    zzavVarZzj = zzpgVar.zzj();
                                                                                    str11 = this.zza;
                                                                                    zzavVarZzj.zzaw();
                                                                                    zzavVarZzj.zzg();
                                                                                    Preconditions.checkNotEmpty(str11);
                                                                                    Preconditions.checkNotEmpty(strZzd);
                                                                                    arrayMap5 = new ArrayMap();
                                                                                    str12 = str5;
                                                                                    str13 = str24;
                                                                                    try {
                                                                                        try {
                                                                                            str24 = str13;
                                                                                            try {
                                                                                                cursorQuery2 = zzavVarZzj.zze().query("event_filters", new String[]{str12, str13}, "app_id=? AND event_name=?", new String[]{str11, strZzd}, null, null, null);
                                                                                                try {
                                                                                                    try {
                                                                                                        if (cursorQuery2.moveToFirst()) {
                                                                                                            str5 = str12;
                                                                                                            while (true) {
                                                                                                                try {
                                                                                                                    try {
                                                                                                                        com.google.android.gms.internal.measurement.zzff zzffVar2 = (com.google.android.gms.internal.measurement.zzff) ((com.google.android.gms.internal.measurement.zzfe) zzpk.zzw(com.google.android.gms.internal.measurement.zzff.zzn(), cursorQuery2.getBlob(1))).zzbc();
                                                                                                                        numValueOf2 = Integer.valueOf(cursorQuery2.getInt(0));
                                                                                                                        list5 = (List) arrayMap5.get(numValueOf2);
                                                                                                                        if (list5 == null) {
                                                                                                                            zzbcVar = zzbcVarZzaf;
                                                                                                                            try {
                                                                                                                                arrayList2 = new ArrayList();
                                                                                                                                arrayMap5.put(numValueOf2, arrayList2);
                                                                                                                            } catch (SQLiteException e7) {
                                                                                                                                e = e7;
                                                                                                                                zzavVarZzj.zzu.zzaV().zzb().zzc(str6, zzgu.zzl(str11), e);
                                                                                                                                mapEmptyMap = Collections.emptyMap();
                                                                                                                                if (cursorQuery2 != null) {
                                                                                                                                    cursorQuery2.close();
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            zzbcVar = zzbcVarZzaf;
                                                                                                                            arrayList2 = list5;
                                                                                                                        }
                                                                                                                        arrayList2.add(zzffVar2);
                                                                                                                    } catch (IOException e8) {
                                                                                                                        zzbcVar = zzbcVarZzaf;
                                                                                                                        zzavVarZzj.zzu.zzaV().zzb().zzc(str4, zzgu.zzl(str11), e8);
                                                                                                                    }
                                                                                                                    if (!cursorQuery2.moveToNext()) {
                                                                                                                        break;
                                                                                                                    }
                                                                                                                    zzbcVarZzaf = zzbcVar;
                                                                                                                } catch (SQLiteException e9) {
                                                                                                                    e = e9;
                                                                                                                    zzbcVar = zzbcVarZzaf;
                                                                                                                }
                                                                                                            }
                                                                                                            if (cursorQuery2 != null) {
                                                                                                                cursorQuery2.close();
                                                                                                            }
                                                                                                            mapEmptyMap = arrayMap5;
                                                                                                        } else {
                                                                                                            zzbcVar = zzbcVarZzaf;
                                                                                                            str5 = str12;
                                                                                                            mapEmptyMap = Collections.emptyMap();
                                                                                                            if (cursorQuery2 != null) {
                                                                                                                cursorQuery2.close();
                                                                                                            }
                                                                                                        }
                                                                                                    } catch (SQLiteException e10) {
                                                                                                        e = e10;
                                                                                                        zzbcVar = zzbcVarZzaf;
                                                                                                        str5 = str12;
                                                                                                    }
                                                                                                    arrayMap4.put(strZzd, mapEmptyMap);
                                                                                                } catch (Throwable th) {
                                                                                                    th = th;
                                                                                                    if (cursorQuery2 != null) {
                                                                                                        cursorQuery2.close();
                                                                                                    }
                                                                                                    throw th;
                                                                                                }
                                                                                            } catch (SQLiteException e11) {
                                                                                                e = e11;
                                                                                                zzbcVar = zzbcVarZzaf;
                                                                                                str5 = str12;
                                                                                                cursorQuery2 = null;
                                                                                                zzavVarZzj.zzu.zzaV().zzb().zzc(str6, zzgu.zzl(str11), e);
                                                                                                mapEmptyMap = Collections.emptyMap();
                                                                                                if (cursorQuery2 != null) {
                                                                                                    cursorQuery2.close();
                                                                                                }
                                                                                                arrayMap4.put(strZzd, mapEmptyMap);
                                                                                                for (Integer num3 : mapEmptyMap.keySet()) {
                                                                                                    iIntValue = num3.intValue();
                                                                                                    if (this.zzb.contains(num3)) {
                                                                                                        this.zzu.zzaV().zzk().zzb("Skipping failed audience ID", num3);
                                                                                                    } else {
                                                                                                        it5 = ((List) mapEmptyMap.get(num3)).iterator();
                                                                                                        z3 = true;
                                                                                                        while (true) {
                                                                                                            if (!it5.hasNext()) {
                                                                                                                map5 = mapEmptyMap;
                                                                                                                break;
                                                                                                            }
                                                                                                            com.google.android.gms.internal.measurement.zzff zzffVar3 = (com.google.android.gms.internal.measurement.zzff) it5.next();
                                                                                                            zzaaVar = new zzaa(this, this.zza, iIntValue, zzffVar3);
                                                                                                            map5 = mapEmptyMap;
                                                                                                            zZzd = zzaaVar.zzd(this.zzd, this.zze, zzhsVarZza, j, zzbcVar, zzd(iIntValue, zzffVar3.zzb()));
                                                                                                            if (!zZzd) {
                                                                                                                this.zzb.add(num3);
                                                                                                                z3 = zZzd;
                                                                                                                break;
                                                                                                            }
                                                                                                            zzc(num3).zza(zzaaVar);
                                                                                                            z3 = zZzd;
                                                                                                            mapEmptyMap = map5;
                                                                                                        }
                                                                                                        if (!z3) {
                                                                                                            this.zzb.add(num3);
                                                                                                        }
                                                                                                        mapEmptyMap = map5;
                                                                                                    }
                                                                                                }
                                                                                                zzzVar = zzzVar2;
                                                                                                it4 = it4;
                                                                                                str20 = str20;
                                                                                            }
                                                                                        } catch (SQLiteException e12) {
                                                                                            e = e12;
                                                                                            str24 = str13;
                                                                                        }
                                                                                    } catch (Throwable th2) {
                                                                                        th = th2;
                                                                                        cursorQuery2 = null;
                                                                                    }
                                                                                } else {
                                                                                    zzbcVar = zzbcVarZzaf;
                                                                                }
                                                                                while (r5.hasNext()) {
                                                                                    iIntValue = num3.intValue();
                                                                                    if (this.zzb.contains(num3)) {
                                                                                        this.zzu.zzaV().zzk().zzb("Skipping failed audience ID", num3);
                                                                                    } else {
                                                                                        it5 = ((List) mapEmptyMap.get(num3)).iterator();
                                                                                        z3 = true;
                                                                                        while (true) {
                                                                                            if (!it5.hasNext()) {
                                                                                                map5 = mapEmptyMap;
                                                                                                break;
                                                                                            }
                                                                                            com.google.android.gms.internal.measurement.zzff zzffVar4 = (com.google.android.gms.internal.measurement.zzff) it5.next();
                                                                                            zzaaVar = new zzaa(this, this.zza, iIntValue, zzffVar4);
                                                                                            map5 = mapEmptyMap;
                                                                                            zZzd = zzaaVar.zzd(this.zzd, this.zze, zzhsVarZza, j, zzbcVar, zzd(iIntValue, zzffVar4.zzb()));
                                                                                            if (!zZzd) {
                                                                                                this.zzb.add(num3);
                                                                                                z3 = zZzd;
                                                                                                break;
                                                                                            }
                                                                                            zzc(num3).zza(zzaaVar);
                                                                                            z3 = zZzd;
                                                                                            mapEmptyMap = map5;
                                                                                        }
                                                                                        if (!z3) {
                                                                                            this.zzb.add(num3);
                                                                                        }
                                                                                        mapEmptyMap = map5;
                                                                                    }
                                                                                }
                                                                                zzzVar = zzzVar2;
                                                                                it4 = it4;
                                                                                str20 = str20;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                str14 = str20;
                                                                if (!z) {
                                                                    return new ArrayList();
                                                                }
                                                                if (!list2.isEmpty()) {
                                                                    arrayMap6 = new ArrayMap();
                                                                    it6 = list2.iterator();
                                                                    while (it6.hasNext()) {
                                                                        com.google.android.gms.internal.measurement.zziu zziuVar = (com.google.android.gms.internal.measurement.zziu) it6.next();
                                                                        strZzc = zziuVar.zzc();
                                                                        mapEmptyMap2 = (Map) arrayMap6.get(strZzc);
                                                                        if (mapEmptyMap2 == null) {
                                                                            zzavVarZzj2 = this.zzg.zzj();
                                                                            str17 = this.zza;
                                                                            zzavVarZzj2.zzaw();
                                                                            zzavVarZzj2.zzg();
                                                                            Preconditions.checkNotEmpty(str17);
                                                                            Preconditions.checkNotEmpty(strZzc);
                                                                            arrayMap7 = new ArrayMap();
                                                                            str15 = str5;
                                                                            str16 = str24;
                                                                            try {
                                                                                cursorQuery3 = zzavVarZzj2.zze().query("property_filters", new String[]{str15, str16}, "app_id=? AND property_name=?", new String[]{str17, strZzc}, null, null, null);
                                                                                try {
                                                                                    try {
                                                                                        if (cursorQuery3.moveToFirst()) {
                                                                                            while (true) {
                                                                                                try {
                                                                                                    com.google.android.gms.internal.measurement.zzfn zzfnVar2 = (com.google.android.gms.internal.measurement.zzfn) ((com.google.android.gms.internal.measurement.zzfm) zzpk.zzw(com.google.android.gms.internal.measurement.zzfn.zzi(), cursorQuery3.getBlob(1))).zzbc();
                                                                                                    numValueOf5 = Integer.valueOf(cursorQuery3.getInt(0));
                                                                                                    list6 = (List) arrayMap7.get(numValueOf5);
                                                                                                    if (list6 == null) {
                                                                                                        arrayList3 = new ArrayList();
                                                                                                        arrayMap7.put(numValueOf5, arrayList3);
                                                                                                    } else {
                                                                                                        arrayList3 = list6;
                                                                                                    }
                                                                                                    arrayList3.add(zzfnVar2);
                                                                                                } catch (IOException e13) {
                                                                                                    zzavVarZzj2.zzu.zzaV().zzb().zzc("Failed to merge filter", zzgu.zzl(str17), e13);
                                                                                                }
                                                                                                try {
                                                                                                    if (!cursorQuery3.moveToNext()) {
                                                                                                        break;
                                                                                                    }
                                                                                                    it6 = it6;
                                                                                                } catch (SQLiteException e14) {
                                                                                                    e = e14;
                                                                                                    zzavVarZzj2.zzu.zzaV().zzb().zzc(str6, zzgu.zzl(str17), e);
                                                                                                    mapEmptyMap2 = Collections.emptyMap();
                                                                                                    if (cursorQuery3 != null) {
                                                                                                        cursorQuery3.close();
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            if (cursorQuery3 != null) {
                                                                                                cursorQuery3.close();
                                                                                            }
                                                                                            mapEmptyMap2 = arrayMap7;
                                                                                        } else {
                                                                                            it6 = it6;
                                                                                            mapEmptyMap2 = Collections.emptyMap();
                                                                                            if (cursorQuery3 != null) {
                                                                                                cursorQuery3.close();
                                                                                            }
                                                                                        }
                                                                                    } catch (Throwable th3) {
                                                                                        th = th3;
                                                                                        cursor2 = cursorQuery3;
                                                                                        if (cursor2 != null) {
                                                                                            cursor2.close();
                                                                                        }
                                                                                        throw th;
                                                                                    }
                                                                                } catch (SQLiteException e15) {
                                                                                    e = e15;
                                                                                    it6 = it6;
                                                                                }
                                                                            } catch (SQLiteException e16) {
                                                                                e = e16;
                                                                                it6 = it6;
                                                                                cursorQuery3 = null;
                                                                            } catch (Throwable th4) {
                                                                                th = th4;
                                                                                cursor2 = null;
                                                                            }
                                                                            arrayMap6.put(strZzc, mapEmptyMap2);
                                                                        } else {
                                                                            it6 = it6;
                                                                            str15 = str5;
                                                                            str16 = str24;
                                                                        }
                                                                        for (Integer num4 : mapEmptyMap2.keySet()) {
                                                                            int iIntValue2 = num4.intValue();
                                                                            if (this.zzb.contains(num4)) {
                                                                                this.zzu.zzaV().zzk().zzb(str10, num4);
                                                                                break;
                                                                            }
                                                                            it7 = ((List) mapEmptyMap2.get(num4)).iterator();
                                                                            zZzd2 = true;
                                                                            while (true) {
                                                                                if (it7.hasNext()) {
                                                                                    zzfnVar = (com.google.android.gms.internal.measurement.zzfn) it7.next();
                                                                                    zzicVar = this.zzu;
                                                                                    if (Log.isLoggable(zzicVar.zzaV().zzn(), 2)) {
                                                                                        zzgs zzgsVarZzk = zzicVar.zzaV().zzk();
                                                                                        if (zzfnVar.zza()) {
                                                                                            numValueOf4 = Integer.valueOf(zzfnVar.zzb());
                                                                                        } else {
                                                                                            numValueOf4 = null;
                                                                                        }
                                                                                        zzgsVarZzk.zzd("Evaluating filter. audience, filter, property", num4, numValueOf4, zzicVar.zzl().zzc(zzfnVar.zzc()));
                                                                                        zzicVar.zzaV().zzk().zzb("Filter definition", this.zzg.zzp().zzk(zzfnVar));
                                                                                    } else {
                                                                                        mapEmptyMap2 = mapEmptyMap2;
                                                                                    }
                                                                                    if (zzfnVar.zza()) {
                                                                                    }
                                                                                    zzgs zzgsVarZze = zzicVar.zzaV().zze();
                                                                                    Object objZzl = zzgu.zzl(this.zza);
                                                                                    if (zzfnVar.zza()) {
                                                                                        numValueOf3 = Integer.valueOf(zzfnVar.zzb());
                                                                                    } else {
                                                                                        numValueOf3 = null;
                                                                                    }
                                                                                    zzgsVarZze.zzc("Invalid property filter ID. appId, id", objZzl, String.valueOf(numValueOf3));
                                                                                    this.zzb.add(num4);
                                                                                    mapEmptyMap2 = mapEmptyMap2;
                                                                                    str10 = str10;
                                                                                } else {
                                                                                    mapEmptyMap2 = mapEmptyMap2;
                                                                                    str10 = str10;
                                                                                }
                                                                                if (!zZzd2) {
                                                                                    this.zzb.add(num4);
                                                                                }
                                                                                mapEmptyMap2 = mapEmptyMap2;
                                                                                str10 = str10;
                                                                                zzc(num4).zza(zzacVar);
                                                                                mapEmptyMap2 = mapEmptyMap2;
                                                                                str10 = str10;
                                                                            }
                                                                        }
                                                                        it6 = it6;
                                                                        str24 = str16;
                                                                        str5 = str15;
                                                                    }
                                                                }
                                                                str18 = str5;
                                                                arrayList4 = new ArrayList();
                                                                Set<Integer> setKeySet = this.zzc.keySet();
                                                                setKeySet.removeAll(this.zzb);
                                                                for (Integer num5 : setKeySet) {
                                                                    int iIntValue3 = num5.intValue();
                                                                    zzy zzyVar = (zzy) this.zzc.get(num5);
                                                                    Preconditions.checkNotNull(zzyVar);
                                                                    com.google.android.gms.internal.measurement.zzhg zzhgVarZzb = zzyVar.zzb(iIntValue3);
                                                                    arrayList4.add(zzhgVarZzb);
                                                                    zzavVarZzj3 = this.zzg.zzj();
                                                                    str19 = this.zza;
                                                                    com.google.android.gms.internal.measurement.zzii zziiVarZzc = zzhgVarZzb.zzc();
                                                                    zzavVarZzj3.zzaw();
                                                                    zzavVarZzj3.zzg();
                                                                    Preconditions.checkNotEmpty(str19);
                                                                    Preconditions.checkNotNull(zziiVarZzc);
                                                                    byte[] bArrZzcc = zziiVarZzc.zzcc();
                                                                    contentValues = new ContentValues();
                                                                    contentValues.put("app_id", str19);
                                                                    contentValues.put(str18, num5);
                                                                    String str30 = str14;
                                                                    contentValues.put(str30, bArrZzcc);
                                                                    try {
                                                                        try {
                                                                            if (zzavVarZzj3.zze().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                                                                zzavVarZzj3.zzu.zzaV().zzb().zzb("Failed to insert filter results (got -1). appId", zzgu.zzl(str19));
                                                                            }
                                                                        } catch (SQLiteException e17) {
                                                                            e = e17;
                                                                            zzavVarZzj3.zzu.zzaV().zzb().zzc("Error storing filter results. appId", zzgu.zzl(str19), e);
                                                                        }
                                                                    } catch (SQLiteException e18) {
                                                                        e = e18;
                                                                    }
                                                                    str14 = str30;
                                                                }
                                                                return arrayList4;
                                                            }
                                                        } catch (SQLiteException e19) {
                                                            e = e19;
                                                            cursorRawQuery = null;
                                                        } catch (Throwable th5) {
                                                            th = th5;
                                                            Zze = 0;
                                                            if (Zze != 0) {
                                                                Zze.close();
                                                            }
                                                            throw th;
                                                        }
                                                        Preconditions.checkNotEmpty(str28);
                                                        Preconditions.checkNotNull(map2);
                                                        arrayMap3 = new ArrayMap();
                                                        if (!map2.isEmpty()) {
                                                            it2 = map2.keySet().iterator();
                                                            while (it2.hasNext()) {
                                                                num = (Integer) it2.next();
                                                                num.intValue();
                                                                zziiVar2 = (com.google.android.gms.internal.measurement.zzii) map2.get(num);
                                                                list4 = (List) arrayMap2.get(num);
                                                                if (list4 != null) {
                                                                }
                                                                map4 = arrayMap2;
                                                                it3 = it2;
                                                                str9 = str23;
                                                                arrayMap3.put(num, zziiVar2);
                                                                arrayMap2 = map4;
                                                                it2 = it3;
                                                                str23 = str9;
                                                            }
                                                        }
                                                        str3 = str23;
                                                        map3 = arrayMap3;
                                                    } catch (Throwable th6) {
                                                        th = th6;
                                                        if (Zze != 0) {
                                                            Zze.close();
                                                        }
                                                        throw th;
                                                    }
                                                } else {
                                                    str3 = "Database error querying filters. appId";
                                                    map3 = map2;
                                                }
                                                while (r16.hasNext()) {
                                                    num2.intValue();
                                                    zziiVar = (com.google.android.gms.internal.measurement.zzii) map3.get(num2);
                                                    bitSet = new BitSet();
                                                    bitSet2 = new BitSet();
                                                    arrayMap = new ArrayMap();
                                                    if (zziiVar != null) {
                                                        while (r2.hasNext()) {
                                                            if (zzhqVar.zza()) {
                                                                Integer numValueOf8 = Integer.valueOf(zzhqVar.zzb());
                                                                if (zzhqVar.zzc()) {
                                                                    lValueOf = Long.valueOf(zzhqVar.zzd());
                                                                } else {
                                                                    lValueOf = null;
                                                                }
                                                                arrayMap.put(numValueOf8, lValueOf);
                                                            }
                                                        }
                                                    }
                                                    ArrayMap arrayMap11 = new ArrayMap();
                                                    if (zziiVar != null) {
                                                        it = zziiVar.zzg().iterator();
                                                        while (it.hasNext()) {
                                                            zzikVar = (com.google.android.gms.internal.measurement.zzik) it.next();
                                                            if (!zzikVar.zza()) {
                                                            }
                                                        }
                                                    }
                                                    Map map7 = map3;
                                                    if (zziiVar != null) {
                                                        i3 = 0;
                                                        while (i3 < zziiVar.zzb() * 64) {
                                                            if (zzpk.zzn(zziiVar.zza(), i3)) {
                                                                str7 = str22;
                                                                this.zzu.zzaV().zzk().zzc("Filter already evaluated. audience ID, filter ID", num2, Integer.valueOf(i3));
                                                                bitSet2.set(i3);
                                                                if (zzpk.zzn(zziiVar.zzc(), i3)) {
                                                                    bitSet.set(i3);
                                                                }
                                                                i3++;
                                                                str22 = str7;
                                                            } else {
                                                                str7 = str22;
                                                            }
                                                            arrayMap.remove(Integer.valueOf(i3));
                                                            i3++;
                                                            str22 = str7;
                                                        }
                                                    }
                                                    String str210 = str22;
                                                    com.google.android.gms.internal.measurement.zzii zziiVar4 = (com.google.android.gms.internal.measurement.zzii) map2.get(num2);
                                                    if (!zZzp2) {
                                                    }
                                                    this.zzc.put(num2, new zzy(this, this.zza, zziiVar4, bitSet, bitSet2, arrayMap, arrayMap11, null));
                                                    map2 = map2;
                                                    str22 = str210;
                                                    zZzp = zZzp;
                                                    map = map;
                                                    map3 = map7;
                                                    str2 = str2;
                                                }
                                                str4 = str22;
                                                str5 = str2;
                                                str6 = str3;
                                            }
                                            str10 = "Skipping failed audience ID";
                                            if (!list.isEmpty()) {
                                                zzzVar = new zzz(this, null);
                                                arrayMap4 = new ArrayMap();
                                                it4 = list.iterator();
                                                while (it4.hasNext()) {
                                                    zzhsVar = (com.google.android.gms.internal.measurement.zzhs) it4.next();
                                                    zzhsVarZza = zzzVar.zza(this.zza, zzhsVar);
                                                    if (zzhsVarZza != null) {
                                                        zzpgVar = this.zzg;
                                                        zzbcVarZzaf = zzpgVar.zzj().zzaf(this.zza, zzhsVar, zzhsVarZza.zzd());
                                                        zzpgVar.zzj().zzh(zzbcVarZzaf);
                                                        if (!z) {
                                                            zzz zzzVar3 = zzzVar;
                                                            j = zzbcVarZzaf.zzc;
                                                            strZzd = zzhsVarZza.zzd();
                                                            mapEmptyMap = (Map) arrayMap4.get(strZzd);
                                                            if (mapEmptyMap == null) {
                                                                zzavVarZzj = zzpgVar.zzj();
                                                                str11 = this.zza;
                                                                zzavVarZzj.zzaw();
                                                                zzavVarZzj.zzg();
                                                                Preconditions.checkNotEmpty(str11);
                                                                Preconditions.checkNotEmpty(strZzd);
                                                                arrayMap5 = new ArrayMap();
                                                                str12 = str5;
                                                                str13 = str24;
                                                                str24 = str13;
                                                                cursorQuery2 = zzavVarZzj.zze().query("event_filters", new String[]{str12, str13}, "app_id=? AND event_name=?", new String[]{str11, strZzd}, null, null, null);
                                                                if (cursorQuery2.moveToFirst()) {
                                                                    str5 = str12;
                                                                    while (true) {
                                                                        com.google.android.gms.internal.measurement.zzff zzffVar5 = (com.google.android.gms.internal.measurement.zzff) ((com.google.android.gms.internal.measurement.zzfe) zzpk.zzw(com.google.android.gms.internal.measurement.zzff.zzn(), cursorQuery2.getBlob(1))).zzbc();
                                                                        numValueOf2 = Integer.valueOf(cursorQuery2.getInt(0));
                                                                        list5 = (List) arrayMap5.get(numValueOf2);
                                                                        if (list5 == null) {
                                                                            zzbcVar = zzbcVarZzaf;
                                                                            arrayList2 = new ArrayList();
                                                                            arrayMap5.put(numValueOf2, arrayList2);
                                                                        } else {
                                                                            zzbcVar = zzbcVarZzaf;
                                                                            arrayList2 = list5;
                                                                        }
                                                                        arrayList2.add(zzffVar5);
                                                                        if (!cursorQuery2.moveToNext()) {
                                                                            break;
                                                                            break;
                                                                        }
                                                                        zzbcVarZzaf = zzbcVar;
                                                                    }
                                                                    if (cursorQuery2 != null) {
                                                                        cursorQuery2.close();
                                                                    }
                                                                    mapEmptyMap = arrayMap5;
                                                                } else {
                                                                    zzbcVar = zzbcVarZzaf;
                                                                    str5 = str12;
                                                                    mapEmptyMap = Collections.emptyMap();
                                                                    if (cursorQuery2 != null) {
                                                                        cursorQuery2.close();
                                                                    }
                                                                }
                                                                arrayMap4.put(strZzd, mapEmptyMap);
                                                            } else {
                                                                zzbcVar = zzbcVarZzaf;
                                                            }
                                                            while (r5.hasNext()) {
                                                                iIntValue = num3.intValue();
                                                                if (this.zzb.contains(num3)) {
                                                                    this.zzu.zzaV().zzk().zzb("Skipping failed audience ID", num3);
                                                                } else {
                                                                    it5 = ((List) mapEmptyMap.get(num3)).iterator();
                                                                    z3 = true;
                                                                    while (true) {
                                                                        if (!it5.hasNext()) {
                                                                            map5 = mapEmptyMap;
                                                                            break;
                                                                        }
                                                                        com.google.android.gms.internal.measurement.zzff zzffVar6 = (com.google.android.gms.internal.measurement.zzff) it5.next();
                                                                        zzaaVar = new zzaa(this, this.zza, iIntValue, zzffVar6);
                                                                        map5 = mapEmptyMap;
                                                                        zZzd = zzaaVar.zzd(this.zzd, this.zze, zzhsVarZza, j, zzbcVar, zzd(iIntValue, zzffVar6.zzb()));
                                                                        if (!zZzd) {
                                                                            this.zzb.add(num3);
                                                                            z3 = zZzd;
                                                                            break;
                                                                        }
                                                                        zzc(num3).zza(zzaaVar);
                                                                        z3 = zZzd;
                                                                        mapEmptyMap = map5;
                                                                    }
                                                                    if (!z3) {
                                                                        this.zzb.add(num3);
                                                                    }
                                                                    mapEmptyMap = map5;
                                                                }
                                                            }
                                                            zzzVar = zzzVar3;
                                                            it4 = it4;
                                                            str20 = str20;
                                                        }
                                                    }
                                                }
                                            }
                                            str14 = str20;
                                            if (!z) {
                                                return new ArrayList();
                                            }
                                            if (!list2.isEmpty()) {
                                                arrayMap6 = new ArrayMap();
                                                it6 = list2.iterator();
                                                while (it6.hasNext()) {
                                                    com.google.android.gms.internal.measurement.zziu zziuVar2 = (com.google.android.gms.internal.measurement.zziu) it6.next();
                                                    strZzc = zziuVar2.zzc();
                                                    mapEmptyMap2 = (Map) arrayMap6.get(strZzc);
                                                    if (mapEmptyMap2 == null) {
                                                        zzavVarZzj2 = this.zzg.zzj();
                                                        str17 = this.zza;
                                                        zzavVarZzj2.zzaw();
                                                        zzavVarZzj2.zzg();
                                                        Preconditions.checkNotEmpty(str17);
                                                        Preconditions.checkNotEmpty(strZzc);
                                                        arrayMap7 = new ArrayMap();
                                                        str15 = str5;
                                                        str16 = str24;
                                                        cursorQuery3 = zzavVarZzj2.zze().query("property_filters", new String[]{str15, str16}, "app_id=? AND property_name=?", new String[]{str17, strZzc}, null, null, null);
                                                        if (cursorQuery3.moveToFirst()) {
                                                            while (true) {
                                                                com.google.android.gms.internal.measurement.zzfn zzfnVar3 = (com.google.android.gms.internal.measurement.zzfn) ((com.google.android.gms.internal.measurement.zzfm) zzpk.zzw(com.google.android.gms.internal.measurement.zzfn.zzi(), cursorQuery3.getBlob(1))).zzbc();
                                                                numValueOf5 = Integer.valueOf(cursorQuery3.getInt(0));
                                                                list6 = (List) arrayMap7.get(numValueOf5);
                                                                if (list6 == null) {
                                                                    arrayList3 = new ArrayList();
                                                                    arrayMap7.put(numValueOf5, arrayList3);
                                                                } else {
                                                                    arrayList3 = list6;
                                                                }
                                                                arrayList3.add(zzfnVar3);
                                                                if (!cursorQuery3.moveToNext()) {
                                                                    break;
                                                                    break;
                                                                }
                                                                it6 = it6;
                                                            }
                                                            if (cursorQuery3 != null) {
                                                                cursorQuery3.close();
                                                            }
                                                            mapEmptyMap2 = arrayMap7;
                                                        } else {
                                                            it6 = it6;
                                                            mapEmptyMap2 = Collections.emptyMap();
                                                            if (cursorQuery3 != null) {
                                                                cursorQuery3.close();
                                                            }
                                                        }
                                                        arrayMap6.put(strZzc, mapEmptyMap2);
                                                    } else {
                                                        it6 = it6;
                                                        str15 = str5;
                                                        str16 = str24;
                                                    }
                                                    while (r3.hasNext()) {
                                                        int iIntValue4 = num4.intValue();
                                                        if (this.zzb.contains(num4)) {
                                                            this.zzu.zzaV().zzk().zzb(str10, num4);
                                                            break;
                                                            break;
                                                        }
                                                        it7 = ((List) mapEmptyMap2.get(num4)).iterator();
                                                        zZzd2 = true;
                                                        while (true) {
                                                            if (it7.hasNext()) {
                                                                zzfnVar = (com.google.android.gms.internal.measurement.zzfn) it7.next();
                                                                zzicVar = this.zzu;
                                                                if (Log.isLoggable(zzicVar.zzaV().zzn(), 2)) {
                                                                    zzgs zzgsVarZzk2 = zzicVar.zzaV().zzk();
                                                                    if (zzfnVar.zza()) {
                                                                        numValueOf4 = Integer.valueOf(zzfnVar.zzb());
                                                                    } else {
                                                                        numValueOf4 = null;
                                                                    }
                                                                    zzgsVarZzk2.zzd("Evaluating filter. audience, filter, property", num4, numValueOf4, zzicVar.zzl().zzc(zzfnVar.zzc()));
                                                                    zzicVar.zzaV().zzk().zzb("Filter definition", this.zzg.zzp().zzk(zzfnVar));
                                                                } else {
                                                                    mapEmptyMap2 = mapEmptyMap2;
                                                                }
                                                                if (zzfnVar.zza()) {
                                                                }
                                                                zzgs zzgsVarZze2 = zzicVar.zzaV().zze();
                                                                Object objZzl2 = zzgu.zzl(this.zza);
                                                                if (zzfnVar.zza()) {
                                                                    numValueOf3 = Integer.valueOf(zzfnVar.zzb());
                                                                } else {
                                                                    numValueOf3 = null;
                                                                }
                                                                zzgsVarZze2.zzc("Invalid property filter ID. appId, id", objZzl2, String.valueOf(numValueOf3));
                                                                this.zzb.add(num4);
                                                                mapEmptyMap2 = mapEmptyMap2;
                                                                str10 = str10;
                                                            } else {
                                                                mapEmptyMap2 = mapEmptyMap2;
                                                                str10 = str10;
                                                            }
                                                            if (!zZzd2) {
                                                                this.zzb.add(num4);
                                                            }
                                                            mapEmptyMap2 = mapEmptyMap2;
                                                            str10 = str10;
                                                            zzc(num4).zza(zzacVar);
                                                            mapEmptyMap2 = mapEmptyMap2;
                                                            str10 = str10;
                                                        }
                                                    }
                                                    it6 = it6;
                                                    str24 = str16;
                                                    str5 = str15;
                                                }
                                            }
                                            str18 = str5;
                                            arrayList4 = new ArrayList();
                                            Set<Integer> setKeySet2 = this.zzc.keySet();
                                            setKeySet2.removeAll(this.zzb);
                                            while (r2.hasNext()) {
                                                int iIntValue5 = num5.intValue();
                                                zzy zzyVar2 = (zzy) this.zzc.get(num5);
                                                Preconditions.checkNotNull(zzyVar2);
                                                com.google.android.gms.internal.measurement.zzhg zzhgVarZzb2 = zzyVar2.zzb(iIntValue5);
                                                arrayList4.add(zzhgVarZzb2);
                                                zzavVarZzj3 = this.zzg.zzj();
                                                str19 = this.zza;
                                                com.google.android.gms.internal.measurement.zzii zziiVarZzc2 = zzhgVarZzb2.zzc();
                                                zzavVarZzj3.zzaw();
                                                zzavVarZzj3.zzg();
                                                Preconditions.checkNotEmpty(str19);
                                                Preconditions.checkNotNull(zziiVarZzc2);
                                                byte[] bArrZzcc2 = zziiVarZzc2.zzcc();
                                                contentValues = new ContentValues();
                                                contentValues.put("app_id", str19);
                                                contentValues.put(str18, num5);
                                                String str31 = str14;
                                                contentValues.put(str31, bArrZzcc2);
                                                if (zzavVarZzj3.zze().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                                    zzavVarZzj3.zzu.zzaV().zzb().zzb("Failed to insert filter results (got -1). appId", zzgu.zzl(str19));
                                                }
                                                str14 = str31;
                                            }
                                            return arrayList4;
                                        }
                                    }
                                    try {
                                        if (!cursorQuery.moveToNext()) {
                                            break;
                                        }
                                        arrayMap8 = arrayMap8;
                                        str25 = str2;
                                        str24 = str24;
                                    } catch (SQLiteException e20) {
                                        e = e20;
                                        zzavVarZzj6.zzu.zzaV().zzb().zzc("Database error querying filter results. appId", zzgu.zzl(str27), e);
                                        Map mapEmptyMap5 = Collections.emptyMap();
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        map2 = mapEmptyMap5;
                                    }
                                }
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                map2 = arrayMap8;
                            } else {
                                Map mapEmptyMap6 = Collections.emptyMap();
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                map2 = mapEmptyMap6;
                                str2 = "audience_id";
                                str24 = Constants.ScionAnalytics.MessageType.DATA_MESSAGE;
                            }
                            if (map2.isEmpty()) {
                                str6 = "Database error querying filters. appId";
                                str4 = "Failed to merge filter. appId";
                                str5 = str2;
                            } else {
                                HashSet<Integer> hashSet2 = new HashSet(map2.keySet());
                                if (z2) {
                                    String str211 = this.zza;
                                    zzav zzavVarZzj8 = this.zzg.zzj();
                                    str8 = this.zza;
                                    zzavVarZzj8.zzaw();
                                    zzavVarZzj8.zzg();
                                    Preconditions.checkNotEmpty(str8);
                                    arrayMap2 = new ArrayMap();
                                    Zze = zzavVarZzj8.zze();
                                    cursorRawQuery = Zze.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str8, str8});
                                    if (cursorRawQuery.moveToFirst()) {
                                        do {
                                            numValueOf = Integer.valueOf(cursorRawQuery.getInt(0));
                                            arrayList = (List) arrayMap2.get(numValueOf);
                                            if (arrayList == null) {
                                                arrayList = new ArrayList();
                                                arrayMap2.put(numValueOf, arrayList);
                                            }
                                            arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                                        } while (cursorRawQuery.moveToNext());
                                        if (cursorRawQuery != null) {
                                            cursorRawQuery.close();
                                        }
                                    } else {
                                        arrayMap2 = Collections.emptyMap();
                                        if (cursorRawQuery != null) {
                                            cursorRawQuery.close();
                                        }
                                    }
                                    Preconditions.checkNotEmpty(str211);
                                    Preconditions.checkNotNull(map2);
                                    arrayMap3 = new ArrayMap();
                                    if (!map2.isEmpty()) {
                                        it2 = map2.keySet().iterator();
                                        while (it2.hasNext()) {
                                            num = (Integer) it2.next();
                                            num.intValue();
                                            zziiVar2 = (com.google.android.gms.internal.measurement.zzii) map2.get(num);
                                            list4 = (List) arrayMap2.get(num);
                                            if (list4 != null) {
                                            }
                                            map4 = arrayMap2;
                                            it3 = it2;
                                            str9 = str23;
                                            arrayMap3.put(num, zziiVar2);
                                            arrayMap2 = map4;
                                            it2 = it3;
                                            str23 = str9;
                                        }
                                    }
                                    str3 = str23;
                                    map3 = arrayMap3;
                                } else {
                                    str3 = "Database error querying filters. appId";
                                    map3 = map2;
                                }
                                while (r16.hasNext()) {
                                    num2.intValue();
                                    zziiVar = (com.google.android.gms.internal.measurement.zzii) map3.get(num2);
                                    bitSet = new BitSet();
                                    bitSet2 = new BitSet();
                                    arrayMap = new ArrayMap();
                                    if (zziiVar != null) {
                                        while (r2.hasNext()) {
                                            if (zzhqVar.zza()) {
                                                Integer numValueOf9 = Integer.valueOf(zzhqVar.zzb());
                                                if (zzhqVar.zzc()) {
                                                    lValueOf = Long.valueOf(zzhqVar.zzd());
                                                } else {
                                                    lValueOf = null;
                                                }
                                                arrayMap.put(numValueOf9, lValueOf);
                                            }
                                        }
                                    }
                                    ArrayMap arrayMap12 = new ArrayMap();
                                    if (zziiVar != null) {
                                        it = zziiVar.zzg().iterator();
                                        while (it.hasNext()) {
                                            zzikVar = (com.google.android.gms.internal.measurement.zzik) it.next();
                                            if (!zzikVar.zza()) {
                                            }
                                        }
                                    }
                                    Map map8 = map3;
                                    if (zziiVar != null) {
                                        i3 = 0;
                                        while (i3 < zziiVar.zzb() * 64) {
                                            if (zzpk.zzn(zziiVar.zza(), i3)) {
                                                str7 = str22;
                                                this.zzu.zzaV().zzk().zzc("Filter already evaluated. audience ID, filter ID", num2, Integer.valueOf(i3));
                                                bitSet2.set(i3);
                                                if (zzpk.zzn(zziiVar.zzc(), i3)) {
                                                    bitSet.set(i3);
                                                }
                                                i3++;
                                                str22 = str7;
                                            } else {
                                                str7 = str22;
                                            }
                                            arrayMap.remove(Integer.valueOf(i3));
                                            i3++;
                                            str22 = str7;
                                        }
                                    }
                                    String str212 = str22;
                                    com.google.android.gms.internal.measurement.zzii zziiVar5 = (com.google.android.gms.internal.measurement.zzii) map2.get(num2);
                                    if (!zZzp2) {
                                    }
                                    this.zzc.put(num2, new zzy(this, this.zza, zziiVar5, bitSet, bitSet2, arrayMap, arrayMap12, null));
                                    map2 = map2;
                                    str22 = str212;
                                    zZzp = zZzp;
                                    map = map;
                                    map3 = map8;
                                    str2 = str2;
                                }
                                str4 = str22;
                                str5 = str2;
                                str6 = str3;
                            }
                            str10 = "Skipping failed audience ID";
                            if (!list.isEmpty()) {
                                zzzVar = new zzz(this, null);
                                arrayMap4 = new ArrayMap();
                                it4 = list.iterator();
                                while (it4.hasNext()) {
                                    zzhsVar = (com.google.android.gms.internal.measurement.zzhs) it4.next();
                                    zzhsVarZza = zzzVar.zza(this.zza, zzhsVar);
                                    if (zzhsVarZza != null) {
                                        zzpgVar = this.zzg;
                                        zzbcVarZzaf = zzpgVar.zzj().zzaf(this.zza, zzhsVar, zzhsVarZza.zzd());
                                        zzpgVar.zzj().zzh(zzbcVarZzaf);
                                        if (!z) {
                                            zzz zzzVar4 = zzzVar;
                                            j = zzbcVarZzaf.zzc;
                                            strZzd = zzhsVarZza.zzd();
                                            mapEmptyMap = (Map) arrayMap4.get(strZzd);
                                            if (mapEmptyMap == null) {
                                                zzavVarZzj = zzpgVar.zzj();
                                                str11 = this.zza;
                                                zzavVarZzj.zzaw();
                                                zzavVarZzj.zzg();
                                                Preconditions.checkNotEmpty(str11);
                                                Preconditions.checkNotEmpty(strZzd);
                                                arrayMap5 = new ArrayMap();
                                                str12 = str5;
                                                str13 = str24;
                                                str24 = str13;
                                                cursorQuery2 = zzavVarZzj.zze().query("event_filters", new String[]{str12, str13}, "app_id=? AND event_name=?", new String[]{str11, strZzd}, null, null, null);
                                                if (cursorQuery2.moveToFirst()) {
                                                    str5 = str12;
                                                    while (true) {
                                                        com.google.android.gms.internal.measurement.zzff zzffVar7 = (com.google.android.gms.internal.measurement.zzff) ((com.google.android.gms.internal.measurement.zzfe) zzpk.zzw(com.google.android.gms.internal.measurement.zzff.zzn(), cursorQuery2.getBlob(1))).zzbc();
                                                        numValueOf2 = Integer.valueOf(cursorQuery2.getInt(0));
                                                        list5 = (List) arrayMap5.get(numValueOf2);
                                                        if (list5 == null) {
                                                            zzbcVar = zzbcVarZzaf;
                                                            arrayList2 = new ArrayList();
                                                            arrayMap5.put(numValueOf2, arrayList2);
                                                        } else {
                                                            zzbcVar = zzbcVarZzaf;
                                                            arrayList2 = list5;
                                                        }
                                                        arrayList2.add(zzffVar7);
                                                        if (!cursorQuery2.moveToNext()) {
                                                            break;
                                                            break;
                                                        }
                                                        zzbcVarZzaf = zzbcVar;
                                                    }
                                                    if (cursorQuery2 != null) {
                                                        cursorQuery2.close();
                                                    }
                                                    mapEmptyMap = arrayMap5;
                                                } else {
                                                    zzbcVar = zzbcVarZzaf;
                                                    str5 = str12;
                                                    mapEmptyMap = Collections.emptyMap();
                                                    if (cursorQuery2 != null) {
                                                        cursorQuery2.close();
                                                    }
                                                }
                                                arrayMap4.put(strZzd, mapEmptyMap);
                                            } else {
                                                zzbcVar = zzbcVarZzaf;
                                            }
                                            while (r5.hasNext()) {
                                                iIntValue = num3.intValue();
                                                if (this.zzb.contains(num3)) {
                                                    this.zzu.zzaV().zzk().zzb("Skipping failed audience ID", num3);
                                                } else {
                                                    it5 = ((List) mapEmptyMap.get(num3)).iterator();
                                                    z3 = true;
                                                    while (true) {
                                                        if (!it5.hasNext()) {
                                                            map5 = mapEmptyMap;
                                                            break;
                                                        }
                                                        com.google.android.gms.internal.measurement.zzff zzffVar8 = (com.google.android.gms.internal.measurement.zzff) it5.next();
                                                        zzaaVar = new zzaa(this, this.zza, iIntValue, zzffVar8);
                                                        map5 = mapEmptyMap;
                                                        zZzd = zzaaVar.zzd(this.zzd, this.zze, zzhsVarZza, j, zzbcVar, zzd(iIntValue, zzffVar8.zzb()));
                                                        if (!zZzd) {
                                                            this.zzb.add(num3);
                                                            z3 = zZzd;
                                                            break;
                                                        }
                                                        zzc(num3).zza(zzaaVar);
                                                        z3 = zZzd;
                                                        mapEmptyMap = map5;
                                                    }
                                                    if (!z3) {
                                                        this.zzb.add(num3);
                                                    }
                                                    mapEmptyMap = map5;
                                                }
                                            }
                                            zzzVar = zzzVar4;
                                            it4 = it4;
                                            str20 = str20;
                                        }
                                    }
                                }
                            }
                            str14 = str20;
                            if (!z) {
                                return new ArrayList();
                            }
                            if (!list2.isEmpty()) {
                                arrayMap6 = new ArrayMap();
                                it6 = list2.iterator();
                                while (it6.hasNext()) {
                                    com.google.android.gms.internal.measurement.zziu zziuVar3 = (com.google.android.gms.internal.measurement.zziu) it6.next();
                                    strZzc = zziuVar3.zzc();
                                    mapEmptyMap2 = (Map) arrayMap6.get(strZzc);
                                    if (mapEmptyMap2 == null) {
                                        zzavVarZzj2 = this.zzg.zzj();
                                        str17 = this.zza;
                                        zzavVarZzj2.zzaw();
                                        zzavVarZzj2.zzg();
                                        Preconditions.checkNotEmpty(str17);
                                        Preconditions.checkNotEmpty(strZzc);
                                        arrayMap7 = new ArrayMap();
                                        str15 = str5;
                                        str16 = str24;
                                        cursorQuery3 = zzavVarZzj2.zze().query("property_filters", new String[]{str15, str16}, "app_id=? AND property_name=?", new String[]{str17, strZzc}, null, null, null);
                                        if (cursorQuery3.moveToFirst()) {
                                            while (true) {
                                                com.google.android.gms.internal.measurement.zzfn zzfnVar4 = (com.google.android.gms.internal.measurement.zzfn) ((com.google.android.gms.internal.measurement.zzfm) zzpk.zzw(com.google.android.gms.internal.measurement.zzfn.zzi(), cursorQuery3.getBlob(1))).zzbc();
                                                numValueOf5 = Integer.valueOf(cursorQuery3.getInt(0));
                                                list6 = (List) arrayMap7.get(numValueOf5);
                                                if (list6 == null) {
                                                    arrayList3 = new ArrayList();
                                                    arrayMap7.put(numValueOf5, arrayList3);
                                                } else {
                                                    arrayList3 = list6;
                                                }
                                                arrayList3.add(zzfnVar4);
                                                if (!cursorQuery3.moveToNext()) {
                                                    break;
                                                    break;
                                                }
                                                it6 = it6;
                                            }
                                            if (cursorQuery3 != null) {
                                                cursorQuery3.close();
                                            }
                                            mapEmptyMap2 = arrayMap7;
                                        } else {
                                            it6 = it6;
                                            mapEmptyMap2 = Collections.emptyMap();
                                            if (cursorQuery3 != null) {
                                                cursorQuery3.close();
                                            }
                                        }
                                        arrayMap6.put(strZzc, mapEmptyMap2);
                                    } else {
                                        it6 = it6;
                                        str15 = str5;
                                        str16 = str24;
                                    }
                                    while (r3.hasNext()) {
                                        int iIntValue6 = num4.intValue();
                                        if (this.zzb.contains(num4)) {
                                            this.zzu.zzaV().zzk().zzb(str10, num4);
                                            break;
                                            break;
                                        }
                                        it7 = ((List) mapEmptyMap2.get(num4)).iterator();
                                        zZzd2 = true;
                                        while (true) {
                                            if (it7.hasNext()) {
                                                zzfnVar = (com.google.android.gms.internal.measurement.zzfn) it7.next();
                                                zzicVar = this.zzu;
                                                if (Log.isLoggable(zzicVar.zzaV().zzn(), 2)) {
                                                    zzgs zzgsVarZzk3 = zzicVar.zzaV().zzk();
                                                    if (zzfnVar.zza()) {
                                                        numValueOf4 = Integer.valueOf(zzfnVar.zzb());
                                                    } else {
                                                        numValueOf4 = null;
                                                    }
                                                    zzgsVarZzk3.zzd("Evaluating filter. audience, filter, property", num4, numValueOf4, zzicVar.zzl().zzc(zzfnVar.zzc()));
                                                    zzicVar.zzaV().zzk().zzb("Filter definition", this.zzg.zzp().zzk(zzfnVar));
                                                } else {
                                                    mapEmptyMap2 = mapEmptyMap2;
                                                }
                                                if (zzfnVar.zza()) {
                                                }
                                                zzgs zzgsVarZze3 = zzicVar.zzaV().zze();
                                                Object objZzl3 = zzgu.zzl(this.zza);
                                                if (zzfnVar.zza()) {
                                                    numValueOf3 = Integer.valueOf(zzfnVar.zzb());
                                                } else {
                                                    numValueOf3 = null;
                                                }
                                                zzgsVarZze3.zzc("Invalid property filter ID. appId, id", objZzl3, String.valueOf(numValueOf3));
                                                this.zzb.add(num4);
                                                mapEmptyMap2 = mapEmptyMap2;
                                                str10 = str10;
                                            } else {
                                                mapEmptyMap2 = mapEmptyMap2;
                                                str10 = str10;
                                            }
                                            if (!zZzd2) {
                                                this.zzb.add(num4);
                                            }
                                            mapEmptyMap2 = mapEmptyMap2;
                                            str10 = str10;
                                            zzc(num4).zza(zzacVar);
                                            mapEmptyMap2 = mapEmptyMap2;
                                            str10 = str10;
                                        }
                                    }
                                    it6 = it6;
                                    str24 = str16;
                                    str5 = str15;
                                }
                            }
                            str18 = str5;
                            arrayList4 = new ArrayList();
                            Set<Integer> setKeySet3 = this.zzc.keySet();
                            setKeySet3.removeAll(this.zzb);
                            while (r2.hasNext()) {
                                int iIntValue7 = num5.intValue();
                                zzy zzyVar3 = (zzy) this.zzc.get(num5);
                                Preconditions.checkNotNull(zzyVar3);
                                com.google.android.gms.internal.measurement.zzhg zzhgVarZzb3 = zzyVar3.zzb(iIntValue7);
                                arrayList4.add(zzhgVarZzb3);
                                zzavVarZzj3 = this.zzg.zzj();
                                str19 = this.zza;
                                com.google.android.gms.internal.measurement.zzii zziiVarZzc3 = zzhgVarZzb3.zzc();
                                zzavVarZzj3.zzaw();
                                zzavVarZzj3.zzg();
                                Preconditions.checkNotEmpty(str19);
                                Preconditions.checkNotNull(zziiVarZzc3);
                                byte[] bArrZzcc3 = zziiVarZzc3.zzcc();
                                contentValues = new ContentValues();
                                contentValues.put("app_id", str19);
                                contentValues.put(str18, num5);
                                String str32 = str14;
                                contentValues.put(str32, bArrZzcc3);
                                if (zzavVarZzj3.zze().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                    zzavVarZzj3.zzu.zzaV().zzb().zzb("Failed to insert filter results (got -1). appId", zzgu.zzl(str19));
                                }
                                str14 = str32;
                            }
                            return arrayList4;
                        } catch (Throwable th7) {
                            th = th7;
                            cursor = cursorQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                } catch (SQLiteException e21) {
                    e = e21;
                    cursorQuery4 = null;
                } catch (Throwable th8) {
                    th = th8;
                    r5 = 0;
                    if (r5 != 0) {
                        r5.close();
                    }
                    throw th;
                }
            } catch (Throwable th9) {
                th = th9;
                if (r5 != 0) {
                    r5.close();
                }
                throw th;
            }
        } else {
            map = mapEmptyMap3;
        }
        zzav zzavVarZzj9 = this.zzg.zzj();
        String str213 = this.zza;
        zzavVarZzj9.zzaw();
        zzavVarZzj9.zzg();
        Preconditions.checkNotEmpty(str213);
        try {
            cursorQuery = zzavVarZzj9.zze().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str213}, null, null, null);
            try {
                if (cursorQuery.moveToFirst()) {
                    Map mapEmptyMap7 = Collections.emptyMap();
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    map2 = mapEmptyMap7;
                    str2 = "audience_id";
                    str24 = Constants.ScionAnalytics.MessageType.DATA_MESSAGE;
                } else {
                    arrayMap8 = new ArrayMap();
                    while (true) {
                        i4 = cursorQuery.getInt(0);
                        arrayMap8.put(Integer.valueOf(i4), (com.google.android.gms.internal.measurement.zzii) ((com.google.android.gms.internal.measurement.zzih) zzpk.zzw(com.google.android.gms.internal.measurement.zzii.zzi(), cursorQuery.getBlob(1))).zzbc());
                        str2 = str25;
                        if (!cursorQuery.moveToNext()) {
                            break;
                            break;
                        }
                        arrayMap8 = arrayMap8;
                        str25 = str2;
                        str24 = str24;
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    map2 = arrayMap8;
                }
            } catch (SQLiteException e22) {
                e = e22;
                str2 = "audience_id";
            }
        } catch (SQLiteException e23) {
            e = e23;
            str2 = "audience_id";
            str24 = Constants.ScionAnalytics.MessageType.DATA_MESSAGE;
            cursorQuery = null;
        } catch (Throwable th10) {
            th = th10;
            cursor = null;
        }
        if (map2.isEmpty()) {
            str6 = "Database error querying filters. appId";
            str4 = "Failed to merge filter. appId";
            str5 = str2;
        } else {
            HashSet<Integer> hashSet3 = new HashSet(map2.keySet());
            if (z2) {
                String str214 = this.zza;
                zzav zzavVarZzj10 = this.zzg.zzj();
                str8 = this.zza;
                zzavVarZzj10.zzaw();
                zzavVarZzj10.zzg();
                Preconditions.checkNotEmpty(str8);
                arrayMap2 = new ArrayMap();
                Zze = zzavVarZzj10.zze();
                cursorRawQuery = Zze.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str8, str8});
                if (cursorRawQuery.moveToFirst()) {
                    do {
                        numValueOf = Integer.valueOf(cursorRawQuery.getInt(0));
                        arrayList = (List) arrayMap2.get(numValueOf);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            arrayMap2.put(numValueOf, arrayList);
                        }
                        arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                    } while (cursorRawQuery.moveToNext());
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } else {
                    arrayMap2 = Collections.emptyMap();
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                }
                Preconditions.checkNotEmpty(str214);
                Preconditions.checkNotNull(map2);
                arrayMap3 = new ArrayMap();
                if (!map2.isEmpty()) {
                    it2 = map2.keySet().iterator();
                    while (it2.hasNext()) {
                        num = (Integer) it2.next();
                        num.intValue();
                        zziiVar2 = (com.google.android.gms.internal.measurement.zzii) map2.get(num);
                        list4 = (List) arrayMap2.get(num);
                        if (list4 != null || list4.isEmpty()) {
                            map4 = arrayMap2;
                            it3 = it2;
                            str9 = str23;
                            arrayMap3.put(num, zziiVar2);
                            arrayMap2 = map4;
                            it2 = it3;
                            str23 = str9;
                        } else {
                            zzpg zzpgVar2 = this.zzg;
                            map4 = arrayMap2;
                            it3 = it2;
                            List listZzq = zzpgVar2.zzp().zzq(zziiVar2.zzc(), list4);
                            if (listZzq.isEmpty()) {
                                arrayMap2 = map4;
                                it2 = it3;
                            } else {
                                com.google.android.gms.internal.measurement.zzih zzihVar = (com.google.android.gms.internal.measurement.zzih) zziiVar2.zzcl();
                                zzihVar.zzd();
                                zzihVar.zzc(listZzq);
                                List listZzq2 = zzpgVar2.zzp().zzq(zziiVar2.zza(), list4);
                                zzihVar.zzb();
                                zzihVar.zza(listZzq2);
                                ArrayList arrayList6 = new ArrayList();
                                Iterator it9 = zziiVar2.zze().iterator();
                                while (it9.hasNext()) {
                                    Iterator it10 = it9;
                                    com.google.android.gms.internal.measurement.zzhq zzhqVar2 = (com.google.android.gms.internal.measurement.zzhq) it9.next();
                                    String str33 = str23;
                                    if (!list4.contains(Integer.valueOf(zzhqVar2.zzb()))) {
                                        arrayList6.add(zzhqVar2);
                                    }
                                    it9 = it10;
                                    str23 = str33;
                                }
                                str9 = str23;
                                zzihVar.zzf();
                                zzihVar.zze(arrayList6);
                                ArrayList arrayList7 = new ArrayList();
                                for (com.google.android.gms.internal.measurement.zzik zzikVar2 : zziiVar2.zzg()) {
                                    if (!list4.contains(Integer.valueOf(zzikVar2.zzb()))) {
                                        arrayList7.add(zzikVar2);
                                    }
                                }
                                zzihVar.zzh();
                                zzihVar.zzg(arrayList7);
                                arrayMap3.put(num, (com.google.android.gms.internal.measurement.zzii) zzihVar.zzbc());
                                arrayMap2 = map4;
                                it2 = it3;
                                str23 = str9;
                            }
                        }
                    }
                }
                str3 = str23;
                map3 = arrayMap3;
            } else {
                str3 = "Database error querying filters. appId";
                map3 = map2;
            }
            while (r16.hasNext()) {
                num2.intValue();
                zziiVar = (com.google.android.gms.internal.measurement.zzii) map3.get(num2);
                bitSet = new BitSet();
                bitSet2 = new BitSet();
                arrayMap = new ArrayMap();
                if (zziiVar != null && zziiVar.zzf() != 0) {
                    while (r2.hasNext()) {
                        if (zzhqVar.zza()) {
                            Integer numValueOf10 = Integer.valueOf(zzhqVar.zzb());
                            if (zzhqVar.zzc()) {
                                lValueOf = Long.valueOf(zzhqVar.zzd());
                            } else {
                                lValueOf = null;
                            }
                            arrayMap.put(numValueOf10, lValueOf);
                        }
                    }
                }
                ArrayMap arrayMap13 = new ArrayMap();
                if (zziiVar != null && zziiVar.zzh() != 0) {
                    it = zziiVar.zzg().iterator();
                    while (it.hasNext()) {
                        zzikVar = (com.google.android.gms.internal.measurement.zzik) it.next();
                        if (!zzikVar.zza() && zzikVar.zzd() > 0) {
                            arrayMap13.put(Integer.valueOf(zzikVar.zzb()), Long.valueOf(zzikVar.zze(zzikVar.zzd() - 1)));
                            map3 = map3;
                            it = it;
                        }
                    }
                }
                Map map9 = map3;
                if (zziiVar != null) {
                    i3 = 0;
                    while (i3 < zziiVar.zzb() * 64) {
                        if (zzpk.zzn(zziiVar.zza(), i3)) {
                            str7 = str22;
                            this.zzu.zzaV().zzk().zzc("Filter already evaluated. audience ID, filter ID", num2, Integer.valueOf(i3));
                            bitSet2.set(i3);
                            if (zzpk.zzn(zziiVar.zzc(), i3)) {
                                bitSet.set(i3);
                            }
                            i3++;
                            str22 = str7;
                        } else {
                            str7 = str22;
                        }
                        arrayMap.remove(Integer.valueOf(i3));
                        i3++;
                        str22 = str7;
                    }
                }
                String str215 = str22;
                com.google.android.gms.internal.measurement.zzii zziiVar6 = (com.google.android.gms.internal.measurement.zzii) map2.get(num2);
                if (!zZzp2 && zZzp && (list3 = (List) map.get(num2)) != null && this.zze != null && this.zzd != null) {
                    for (com.google.android.gms.internal.measurement.zzff zzffVar9 : list3) {
                        int iZzb = zzffVar9.zzb();
                        long jLongValue = this.zze.longValue() / 1000;
                        if (zzffVar9.zzj()) {
                            jLongValue = this.zzd.longValue() / 1000;
                        }
                        Integer numValueOf11 = Integer.valueOf(iZzb);
                        if (arrayMap.containsKey(numValueOf11)) {
                            arrayMap.put(numValueOf11, Long.valueOf(jLongValue));
                        }
                        if (arrayMap13.containsKey(numValueOf11)) {
                            arrayMap13.put(numValueOf11, Long.valueOf(jLongValue));
                        }
                    }
                }
                this.zzc.put(num2, new zzy(this, this.zza, zziiVar6, bitSet, bitSet2, arrayMap, arrayMap13, null));
                map2 = map2;
                str22 = str215;
                zZzp = zZzp;
                map = map;
                map3 = map9;
                str2 = str2;
            }
            str4 = str22;
            str5 = str2;
            str6 = str3;
        }
        str10 = "Skipping failed audience ID";
        if (!list.isEmpty()) {
            zzzVar = new zzz(this, null);
            arrayMap4 = new ArrayMap();
            it4 = list.iterator();
            while (it4.hasNext()) {
                zzhsVar = (com.google.android.gms.internal.measurement.zzhs) it4.next();
                zzhsVarZza = zzzVar.zza(this.zza, zzhsVar);
                if (zzhsVarZza != null) {
                    zzpgVar = this.zzg;
                    zzbcVarZzaf = zzpgVar.zzj().zzaf(this.zza, zzhsVar, zzhsVarZza.zzd());
                    zzpgVar.zzj().zzh(zzbcVarZzaf);
                    if (!z) {
                        zzz zzzVar5 = zzzVar;
                        j = zzbcVarZzaf.zzc;
                        strZzd = zzhsVarZza.zzd();
                        mapEmptyMap = (Map) arrayMap4.get(strZzd);
                        if (mapEmptyMap == null) {
                            zzavVarZzj = zzpgVar.zzj();
                            str11 = this.zza;
                            zzavVarZzj.zzaw();
                            zzavVarZzj.zzg();
                            Preconditions.checkNotEmpty(str11);
                            Preconditions.checkNotEmpty(strZzd);
                            arrayMap5 = new ArrayMap();
                            str12 = str5;
                            str13 = str24;
                            str24 = str13;
                            cursorQuery2 = zzavVarZzj.zze().query("event_filters", new String[]{str12, str13}, "app_id=? AND event_name=?", new String[]{str11, strZzd}, null, null, null);
                            if (cursorQuery2.moveToFirst()) {
                                str5 = str12;
                                while (true) {
                                    com.google.android.gms.internal.measurement.zzff zzffVar10 = (com.google.android.gms.internal.measurement.zzff) ((com.google.android.gms.internal.measurement.zzfe) zzpk.zzw(com.google.android.gms.internal.measurement.zzff.zzn(), cursorQuery2.getBlob(1))).zzbc();
                                    numValueOf2 = Integer.valueOf(cursorQuery2.getInt(0));
                                    list5 = (List) arrayMap5.get(numValueOf2);
                                    if (list5 == null) {
                                        zzbcVar = zzbcVarZzaf;
                                        arrayList2 = new ArrayList();
                                        arrayMap5.put(numValueOf2, arrayList2);
                                    } else {
                                        zzbcVar = zzbcVarZzaf;
                                        arrayList2 = list5;
                                    }
                                    arrayList2.add(zzffVar10);
                                    if (!cursorQuery2.moveToNext()) {
                                        break;
                                        break;
                                    }
                                    zzbcVarZzaf = zzbcVar;
                                }
                                if (cursorQuery2 != null) {
                                    cursorQuery2.close();
                                }
                                mapEmptyMap = arrayMap5;
                            } else {
                                zzbcVar = zzbcVarZzaf;
                                str5 = str12;
                                mapEmptyMap = Collections.emptyMap();
                                if (cursorQuery2 != null) {
                                    cursorQuery2.close();
                                }
                            }
                            arrayMap4.put(strZzd, mapEmptyMap);
                        } else {
                            zzbcVar = zzbcVarZzaf;
                        }
                        while (r5.hasNext()) {
                            iIntValue = num3.intValue();
                            if (this.zzb.contains(num3)) {
                                this.zzu.zzaV().zzk().zzb("Skipping failed audience ID", num3);
                            } else {
                                it5 = ((List) mapEmptyMap.get(num3)).iterator();
                                z3 = true;
                                while (true) {
                                    if (!it5.hasNext()) {
                                        map5 = mapEmptyMap;
                                        break;
                                    }
                                    com.google.android.gms.internal.measurement.zzff zzffVar11 = (com.google.android.gms.internal.measurement.zzff) it5.next();
                                    zzaaVar = new zzaa(this, this.zza, iIntValue, zzffVar11);
                                    map5 = mapEmptyMap;
                                    zZzd = zzaaVar.zzd(this.zzd, this.zze, zzhsVarZza, j, zzbcVar, zzd(iIntValue, zzffVar11.zzb()));
                                    if (!zZzd) {
                                        this.zzb.add(num3);
                                        z3 = zZzd;
                                        break;
                                    }
                                    zzc(num3).zza(zzaaVar);
                                    z3 = zZzd;
                                    mapEmptyMap = map5;
                                }
                                if (!z3) {
                                    this.zzb.add(num3);
                                }
                                mapEmptyMap = map5;
                            }
                        }
                        zzzVar = zzzVar5;
                        it4 = it4;
                        str20 = str20;
                    }
                }
            }
        }
        str14 = str20;
        if (!z) {
            return new ArrayList();
        }
        if (!list2.isEmpty()) {
            arrayMap6 = new ArrayMap();
            it6 = list2.iterator();
            while (it6.hasNext()) {
                com.google.android.gms.internal.measurement.zziu zziuVar4 = (com.google.android.gms.internal.measurement.zziu) it6.next();
                strZzc = zziuVar4.zzc();
                mapEmptyMap2 = (Map) arrayMap6.get(strZzc);
                if (mapEmptyMap2 == null) {
                    zzavVarZzj2 = this.zzg.zzj();
                    str17 = this.zza;
                    zzavVarZzj2.zzaw();
                    zzavVarZzj2.zzg();
                    Preconditions.checkNotEmpty(str17);
                    Preconditions.checkNotEmpty(strZzc);
                    arrayMap7 = new ArrayMap();
                    str15 = str5;
                    str16 = str24;
                    cursorQuery3 = zzavVarZzj2.zze().query("property_filters", new String[]{str15, str16}, "app_id=? AND property_name=?", new String[]{str17, strZzc}, null, null, null);
                    if (cursorQuery3.moveToFirst()) {
                        while (true) {
                            com.google.android.gms.internal.measurement.zzfn zzfnVar5 = (com.google.android.gms.internal.measurement.zzfn) ((com.google.android.gms.internal.measurement.zzfm) zzpk.zzw(com.google.android.gms.internal.measurement.zzfn.zzi(), cursorQuery3.getBlob(1))).zzbc();
                            numValueOf5 = Integer.valueOf(cursorQuery3.getInt(0));
                            list6 = (List) arrayMap7.get(numValueOf5);
                            if (list6 == null) {
                                arrayList3 = new ArrayList();
                                arrayMap7.put(numValueOf5, arrayList3);
                            } else {
                                arrayList3 = list6;
                            }
                            arrayList3.add(zzfnVar5);
                            if (!cursorQuery3.moveToNext()) {
                                break;
                                break;
                            }
                            it6 = it6;
                        }
                        if (cursorQuery3 != null) {
                            cursorQuery3.close();
                        }
                        mapEmptyMap2 = arrayMap7;
                    } else {
                        it6 = it6;
                        mapEmptyMap2 = Collections.emptyMap();
                        if (cursorQuery3 != null) {
                            cursorQuery3.close();
                        }
                    }
                    arrayMap6.put(strZzc, mapEmptyMap2);
                } else {
                    it6 = it6;
                    str15 = str5;
                    str16 = str24;
                }
                while (r3.hasNext()) {
                    int iIntValue8 = num4.intValue();
                    if (this.zzb.contains(num4)) {
                        this.zzu.zzaV().zzk().zzb(str10, num4);
                        break;
                        break;
                    }
                    it7 = ((List) mapEmptyMap2.get(num4)).iterator();
                    zZzd2 = true;
                    while (true) {
                        if (it7.hasNext()) {
                            zzfnVar = (com.google.android.gms.internal.measurement.zzfn) it7.next();
                            zzicVar = this.zzu;
                            if (Log.isLoggable(zzicVar.zzaV().zzn(), 2)) {
                                zzgs zzgsVarZzk4 = zzicVar.zzaV().zzk();
                                if (zzfnVar.zza()) {
                                    numValueOf4 = Integer.valueOf(zzfnVar.zzb());
                                } else {
                                    numValueOf4 = null;
                                }
                                zzgsVarZzk4.zzd("Evaluating filter. audience, filter, property", num4, numValueOf4, zzicVar.zzl().zzc(zzfnVar.zzc()));
                                zzicVar.zzaV().zzk().zzb("Filter definition", this.zzg.zzp().zzk(zzfnVar));
                            } else {
                                mapEmptyMap2 = mapEmptyMap2;
                            }
                            if (zzfnVar.zza() || zzfnVar.zzb() > 256) {
                                zzgs zzgsVarZze4 = zzicVar.zzaV().zze();
                                Object objZzl4 = zzgu.zzl(this.zza);
                                if (zzfnVar.zza()) {
                                    numValueOf3 = Integer.valueOf(zzfnVar.zzb());
                                } else {
                                    numValueOf3 = null;
                                }
                                zzgsVarZze4.zzc("Invalid property filter ID. appId, id", objZzl4, String.valueOf(numValueOf3));
                                this.zzb.add(num4);
                                mapEmptyMap2 = mapEmptyMap2;
                                str10 = str10;
                            } else {
                                zzacVar = new zzac(this, this.zza, iIntValue8, zzfnVar);
                                zZzd2 = zzacVar.zzd(this.zzd, this.zze, zziuVar4, zzd(iIntValue8, zzfnVar.zzb()));
                                if (zZzd2) {
                                    zzc(num4).zza(zzacVar);
                                    mapEmptyMap2 = mapEmptyMap2;
                                    str10 = str10;
                                } else {
                                    this.zzb.add(num4);
                                }
                            }
                        } else {
                            mapEmptyMap2 = mapEmptyMap2;
                            str10 = str10;
                        }
                        if (!zZzd2) {
                            this.zzb.add(num4);
                        }
                        mapEmptyMap2 = mapEmptyMap2;
                        str10 = str10;
                    }
                }
                it6 = it6;
                str24 = str16;
                str5 = str15;
            }
        }
        str18 = str5;
        arrayList4 = new ArrayList();
        Set<Integer> setKeySet4 = this.zzc.keySet();
        setKeySet4.removeAll(this.zzb);
        while (r2.hasNext()) {
            int iIntValue9 = num5.intValue();
            zzy zzyVar4 = (zzy) this.zzc.get(num5);
            Preconditions.checkNotNull(zzyVar4);
            com.google.android.gms.internal.measurement.zzhg zzhgVarZzb4 = zzyVar4.zzb(iIntValue9);
            arrayList4.add(zzhgVarZzb4);
            zzavVarZzj3 = this.zzg.zzj();
            str19 = this.zza;
            com.google.android.gms.internal.measurement.zzii zziiVarZzc4 = zzhgVarZzb4.zzc();
            zzavVarZzj3.zzaw();
            zzavVarZzj3.zzg();
            Preconditions.checkNotEmpty(str19);
            Preconditions.checkNotNull(zziiVarZzc4);
            byte[] bArrZzcc4 = zziiVarZzc4.zzcc();
            contentValues = new ContentValues();
            contentValues.put("app_id", str19);
            contentValues.put(str18, num5);
            String str34 = str14;
            contentValues.put(str34, bArrZzcc4);
            if (zzavVarZzj3.zze().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                zzavVarZzj3.zzu.zzaV().zzb().zzb("Failed to insert filter results (got -1). appId", zzgu.zzl(str19));
            }
            str14 = str34;
        }
        return arrayList4;
    }

    @Override // com.google.android.gms.measurement.internal.zzos
    protected final boolean zzbb() {
        return false;
    }
}
