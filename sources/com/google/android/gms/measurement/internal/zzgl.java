package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgl extends zzg {
    private static final String[] zza = {"app_version", "ALTER TABLE messages ADD COLUMN app_version TEXT;", "app_version_int", "ALTER TABLE messages ADD COLUMN app_version_int INTEGER;"};
    private final zzgj zzb;
    private boolean zzc;

    zzgl(zzic zzicVar) {
        super(zzicVar);
        Context contextZzaY = this.zzu.zzaY();
        this.zzu.zzc();
        this.zzb = new zzgj(this, contextZzaY, "google_app_measurement_local.db");
    }

    /* JADX WARN: Code duplicated, block: B:68:0x0129 A[PHI: r8 r10
  0x0129: PHI (r8v5 int) = (r8v3 int), (r8v3 int), (r8v6 int) binds: [B:59:0x0117, B:74:0x0147, B:67:0x0127] A[DONT_GENERATE, DONT_INLINE]
  0x0129: PHI (r10v8 android.database.sqlite.SQLiteDatabase) = 
  (r10v6 android.database.sqlite.SQLiteDatabase)
  (r10v7 android.database.sqlite.SQLiteDatabase)
  (r10v9 android.database.sqlite.SQLiteDatabase)
 binds: [B:59:0x0117, B:74:0x0147, B:67:0x0127] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:80:0x0154  */
    /* JADX WARN: Code duplicated, block: B:82:0x0159  */
    private final boolean zzs(int i, byte[] bArr) throws Throwable {
        SQLiteDatabase sQLiteDatabaseZzp;
        Cursor cursorRawQuery;
        zzg();
        boolean z = false;
        z = false;
        if (!this.zzc) {
            zzic zzicVar = this.zzu;
            zzal zzalVarZzc = zzicVar.zzc();
            zzfx zzfxVar = zzfy.zzbb;
            Cursor cursor = null;
            cursor = null;
            zzr zzrVarZzh = zzalVarZzc.zzp(null, zzfxVar) ? this.zzu.zzv().zzh(null) : null;
            ContentValues contentValues = new ContentValues();
            contentValues.put("type", Integer.valueOf(i));
            contentValues.put("entry", bArr);
            if (zzicVar.zzc().zzp(null, zzfxVar) && zzrVarZzh != null) {
                contentValues.put("app_version", zzrVarZzh.zzc);
                contentValues.put("app_version_int", Long.valueOf(zzrVarZzh.zzj));
            }
            zzicVar.zzc();
            int i2 = 0;
            int i3 = 5;
            for (int i4 = 5; i2 < i4; i4 = 5) {
                try {
                    sQLiteDatabaseZzp = zzp();
                    if (sQLiteDatabaseZzp == null) {
                        this.zzc = true;
                    } else {
                        try {
                            sQLiteDatabaseZzp.beginTransaction();
                            cursorRawQuery = sQLiteDatabaseZzp.rawQuery("select count(1) from messages", null);
                            long j = 0;
                            if (cursorRawQuery != null) {
                                try {
                                    if (cursorRawQuery.moveToFirst()) {
                                        j = cursorRawQuery.getLong(z ? 1 : 0);
                                    }
                                } catch (SQLiteDatabaseLockedException unused) {
                                    SystemClock.sleep(i3);
                                    i3 += 20;
                                    if (cursorRawQuery != null) {
                                        cursorRawQuery.close();
                                    }
                                    if (sQLiteDatabaseZzp != null) {
                                        sQLiteDatabaseZzp.close();
                                    }
                                    i2++;
                                    z = false;
                                } catch (SQLiteFullException e) {
                                    e = e;
                                    this.zzu.zzaV().zzb().zzb("Error writing entry; local database full", e);
                                    this.zzc = true;
                                    if (cursorRawQuery != null) {
                                        cursorRawQuery.close();
                                    }
                                    if (sQLiteDatabaseZzp != null) {
                                        sQLiteDatabaseZzp.close();
                                    }
                                    i2++;
                                    z = false;
                                } catch (SQLiteException e2) {
                                    e = e2;
                                    if (sQLiteDatabaseZzp != null) {
                                        try {
                                            if (sQLiteDatabaseZzp.inTransaction()) {
                                                sQLiteDatabaseZzp.endTransaction();
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            cursor = cursorRawQuery;
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            if (sQLiteDatabaseZzp != null) {
                                                sQLiteDatabaseZzp.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    this.zzu.zzaV().zzb().zzb("Error writing entry to local database", e);
                                    this.zzc = true;
                                    if (cursorRawQuery != null) {
                                        cursorRawQuery.close();
                                    }
                                    if (sQLiteDatabaseZzp != null) {
                                        sQLiteDatabaseZzp.close();
                                    }
                                    i2++;
                                    z = false;
                                }
                            }
                            if (j >= 100000) {
                                zzicVar.zzaV().zzb().zza("Data loss, local db full");
                                long j2 = 100001 - j;
                                long jDelete = sQLiteDatabaseZzp.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", new String[]{Long.toString(j2)});
                                if (jDelete != j2) {
                                    zzicVar.zzaV().zzb().zzd("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j2), Long.valueOf(jDelete), Long.valueOf(j2 - jDelete));
                                }
                            }
                            sQLiteDatabaseZzp.insertOrThrow("messages", null, contentValues);
                            sQLiteDatabaseZzp.setTransactionSuccessful();
                            sQLiteDatabaseZzp.endTransaction();
                            if (cursorRawQuery != null) {
                                cursorRawQuery.close();
                            }
                            sQLiteDatabaseZzp.close();
                            return true;
                        } catch (SQLiteDatabaseLockedException unused2) {
                            cursorRawQuery = null;
                        } catch (SQLiteFullException e3) {
                            e = e3;
                            cursorRawQuery = null;
                        } catch (SQLiteException e4) {
                            e = e4;
                            cursorRawQuery = null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabaseZzp != null) {
                                sQLiteDatabaseZzp.close();
                            }
                            throw th;
                        }
                    }
                } catch (SQLiteDatabaseLockedException unused3) {
                    sQLiteDatabaseZzp = null;
                    cursorRawQuery = null;
                } catch (SQLiteFullException e5) {
                    e = e5;
                    sQLiteDatabaseZzp = null;
                    cursorRawQuery = null;
                } catch (SQLiteException e6) {
                    e = e6;
                    sQLiteDatabaseZzp = null;
                    cursorRawQuery = null;
                } catch (Throwable th3) {
                    th = th3;
                    sQLiteDatabaseZzp = null;
                }
            }
            this.zzu.zzaV().zzk().zza("Failed to write entry to local database");
            return false;
        }
        return z;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zze() {
        return false;
    }

    public final void zzh() {
        int iDelete;
        zzg();
        try {
            SQLiteDatabase sQLiteDatabaseZzp = zzp();
            if (sQLiteDatabaseZzp == null || (iDelete = sQLiteDatabaseZzp.delete("messages", null, null)) <= 0) {
                return;
            }
            this.zzu.zzaV().zzk().zzb("Reset local analytics data. records", Integer.valueOf(iDelete));
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzb("Error resetting local analytics data. error", e);
        }
    }

    public final boolean zzi(zzbg zzbgVar) {
        Parcel parcelObtain = Parcel.obtain();
        zzbh.zza(zzbgVar, parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return zzs(0, bArrMarshall);
        }
        this.zzu.zzaV().zzc().zza("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zzj(zzpl zzplVar) {
        Parcel parcelObtain = Parcel.obtain();
        zzpm.zza(zzplVar, parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return zzs(1, bArrMarshall);
        }
        this.zzu.zzaV().zzc().zza("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zzk(zzah zzahVar) {
        zzic zzicVar = this.zzu;
        byte[] bArrZzae = zzicVar.zzk().zzae(zzahVar);
        if (bArrZzae.length <= 131072) {
            return zzs(2, bArrZzae);
        }
        zzicVar.zzaV().zzc().zza("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zzl(zzbe zzbeVar) {
        zzic zzicVar = this.zzu;
        byte[] bArrZzae = zzicVar.zzk().zzae(zzbeVar);
        if (bArrZzae == null) {
            zzicVar.zzaV().zzc().zza("Null default event parameters; not writing to database");
            return false;
        }
        if (bArrZzae.length <= 131072) {
            return zzs(4, bArrZzae);
        }
        zzicVar.zzaV().zzc().zza("Default event parameters too long for local database. Sending directly to service");
        return false;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 8711. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final java.util.List zzm(int r29) {
        /*
            Method dump skipped, instruction units count: 871
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgl.zzm(int):java.util.List");
    }

    public final boolean zzn() {
        return zzs(3, new byte[0]);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x006b A[PHI: r4
  0x006b: PHI (r4v3 int) = (r4v1 int), (r4v1 int), (r4v4 int) binds: [B:34:0x007e, B:28:0x0062, B:31:0x0069] A[DONT_GENERATE, DONT_INLINE]] */
    public final boolean zzo() {
        zzg();
        if (!this.zzc && zzq()) {
            int i = 5;
            for (int i2 = 0; i2 < 5; i2++) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    try {
                        try {
                            SQLiteDatabase sQLiteDatabaseZzp = zzp();
                            if (sQLiteDatabaseZzp != null) {
                                sQLiteDatabaseZzp.beginTransaction();
                                sQLiteDatabaseZzp.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                                sQLiteDatabaseZzp.setTransactionSuccessful();
                                sQLiteDatabaseZzp.endTransaction();
                                sQLiteDatabaseZzp.close();
                                return true;
                            }
                            this.zzc = true;
                        } catch (SQLiteFullException e) {
                            this.zzu.zzaV().zzb().zzb("Error deleting app launch break from local database", e);
                            this.zzc = true;
                            if (0 != 0) {
                                sQLiteDatabase.close();
                            }
                        }
                    } catch (SQLiteException e2) {
                        if (0 != 0) {
                            try {
                                if (sQLiteDatabase.inTransaction()) {
                                    sQLiteDatabase.endTransaction();
                                }
                            } catch (Throwable th) {
                                if (0 != 0) {
                                    sQLiteDatabase.close();
                                }
                                throw th;
                            }
                        }
                        this.zzu.zzaV().zzb().zzb("Error deleting app launch break from local database", e2);
                        this.zzc = true;
                        if (0 != 0) {
                            sQLiteDatabase.close();
                        }
                    }
                } catch (SQLiteDatabaseLockedException unused) {
                    SystemClock.sleep(i);
                    i += 20;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                }
            }
            this.zzu.zzaV().zze().zza("Error deleting app launch break from local database in reasonable time");
        }
        return false;
    }

    final SQLiteDatabase zzp() throws SQLiteException {
        if (this.zzc) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zzb.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzc = true;
        return null;
    }

    final boolean zzq() {
        zzic zzicVar = this.zzu;
        Context contextZzaY = zzicVar.zzaY();
        zzicVar.zzc();
        return contextZzaY.getDatabasePath("google_app_measurement_local.db").exists();
    }
}
