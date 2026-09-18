package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzegu {
    private final zzbbp zza;
    private final Context zzb;
    private final zzefy zzc;
    private final zzcei zzd;
    private final String zze;
    private final zzflw zzf;
    private final com.google.android.gms.ads.internal.util.zzg zzg = com.google.android.gms.ads.internal.zzt.zzo().zzi();

    public zzegu(Context context, zzcei zzceiVar, zzbbp zzbbpVar, zzefy zzefyVar, String str, zzflw zzflwVar) {
        this.zzb = context;
        this.zzd = zzceiVar;
        this.zza = zzbbpVar;
        this.zzc = zzefyVar;
        this.zze = str;
        this.zzf = zzflwVar;
    }

    private static final void zzc(SQLiteDatabase sQLiteDatabase, ArrayList arrayList) {
        int size = arrayList.size();
        long jZze = 0;
        for (int i = 0; i < size; i++) {
            zzbdy zzbdyVar = (zzbdy) arrayList.get(i);
            if (zzbdyVar.zzw() == 2 && zzbdyVar.zze() > jZze) {
                jZze = zzbdyVar.zze();
            }
        }
        if (jZze != 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("value", Long.valueOf(jZze));
            sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", null);
        }
    }

    public final void zzb(final boolean z) {
        try {
            this.zzc.zza(new zzfkp() { // from class: com.google.android.gms.internal.ads.zzegq
                @Override // com.google.android.gms.internal.ads.zzfkp
                public final Object zza(Object obj) throws Exception {
                    this.zza.zza(z, (SQLiteDatabase) obj);
                    return null;
                }
            });
        } catch (Exception e) {
            zzcec.zzg("Error in offline signals database startup: ".concat(String.valueOf(e.getMessage())));
        }
    }

    final /* synthetic */ Void zza(boolean z, SQLiteDatabase sQLiteDatabase) throws Exception {
        if (z) {
            this.zzb.deleteDatabase("OfflineUpload.db");
            return null;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziz)).booleanValue()) {
            zzflv zzflvVarZzb = zzflv.zzb("oa_upload");
            zzflvVarZzb.zza("oa_failed_reqs", String.valueOf(zzegn.zza(sQLiteDatabase, 0)));
            zzflvVarZzb.zza("oa_total_reqs", String.valueOf(zzegn.zza(sQLiteDatabase, 1)));
            zzflvVarZzb.zza("oa_upload_time", String.valueOf(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()));
            zzflvVarZzb.zza("oa_last_successful_time", String.valueOf(zzegn.zzb(sQLiteDatabase, 2)));
            zzflvVarZzb.zza("oa_session_id", this.zzg.zzQ() ? "" : this.zze);
            this.zzf.zzb(zzflvVarZzb);
            ArrayList arrayListZzc = zzegn.zzc(sQLiteDatabase);
            zzc(sQLiteDatabase, arrayListZzc);
            int size = arrayListZzc.size();
            for (int i = 0; i < size; i++) {
                zzbdy zzbdyVar = (zzbdy) arrayListZzc.get(i);
                com.google.android.gms.ads.internal.util.zzg zzgVar = this.zzg;
                zzflv zzflvVarZzb2 = zzflv.zzb("oa_signals");
                zzflvVarZzb2.zza("oa_session_id", zzgVar.zzQ() ? "" : this.zze);
                zzbdt zzbdtVarZzf = zzbdyVar.zzf();
                String strValueOf = zzbdtVarZzf.zzf() ? String.valueOf(zzbdtVarZzf.zzh() - 1) : "-1";
                String string = zzgao.zzb(zzbdyVar.zzk(), new zzfws() { // from class: com.google.android.gms.internal.ads.zzegt
                    @Override // com.google.android.gms.internal.ads.zzfws
                    public final Object apply(Object obj) {
                        return ((zzbcn) obj).name();
                    }
                }).toString();
                zzflvVarZzb2.zza("oa_sig_ts", String.valueOf(zzbdyVar.zze()));
                zzflvVarZzb2.zza("oa_sig_status", String.valueOf(zzbdyVar.zzw() - 1));
                zzflvVarZzb2.zza("oa_sig_resp_lat", String.valueOf(zzbdyVar.zzd()));
                zzflvVarZzb2.zza("oa_sig_render_lat", String.valueOf(zzbdyVar.zzc()));
                zzflvVarZzb2.zza("oa_sig_formats", string);
                zzflvVarZzb2.zza("oa_sig_nw_type", strValueOf);
                zzflvVarZzb2.zza("oa_sig_wifi", String.valueOf(zzbdyVar.zzx() - 1));
                zzflvVarZzb2.zza("oa_sig_airplane", String.valueOf(zzbdyVar.zzt() - 1));
                zzflvVarZzb2.zza("oa_sig_data", String.valueOf(zzbdyVar.zzu() - 1));
                zzflvVarZzb2.zza("oa_sig_nw_resp", String.valueOf(zzbdyVar.zza()));
                zzflvVarZzb2.zza("oa_sig_offline", String.valueOf(zzbdyVar.zzv() - 1));
                zzflvVarZzb2.zza("oa_sig_nw_state", String.valueOf(zzbdyVar.zzj().zza()));
                if (zzbdtVarZzf.zze() && zzbdtVarZzf.zzf() && zzbdtVarZzf.zzh() == 2) {
                    zzflvVarZzb2.zza("oa_sig_cell_type", String.valueOf(zzbdtVarZzf.zzg() - 1));
                }
                this.zzf.zzb(zzflvVarZzb2);
            }
        } else {
            ArrayList arrayListZzc2 = zzegn.zzc(sQLiteDatabase);
            Context context = this.zzb;
            zzbdz zzbdzVarZza = zzbed.zza();
            zzbdzVarZza.zzb(context.getPackageName());
            zzbdzVarZza.zzd(Build.MODEL);
            zzbdzVarZza.zze(zzegn.zza(sQLiteDatabase, 0));
            zzbdzVarZza.zza(arrayListZzc2);
            zzbdzVarZza.zzg(zzegn.zza(sQLiteDatabase, 1));
            zzbdzVarZza.zzc(zzegn.zza(sQLiteDatabase, 3));
            zzbdzVarZza.zzh(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis());
            zzbdzVarZza.zzf(zzegn.zzb(sQLiteDatabase, 2));
            final zzbed zzbedVar = (zzbed) zzbdzVarZza.zzal();
            zzc(sQLiteDatabase, arrayListZzc2);
            this.zza.zzb(new zzbbo() { // from class: com.google.android.gms.internal.ads.zzegr
                @Override // com.google.android.gms.internal.ads.zzbbo
                public final void zza(zzbde zzbdeVar) {
                    zzbdeVar.zzi(zzbedVar);
                }
            });
            zzcei zzceiVar = this.zzd;
            zzbeo zzbeoVarZza = zzbep.zza();
            zzbeoVarZza.zza(zzceiVar.zzb);
            zzbeoVarZza.zzc(this.zzd.zzc);
            zzbeoVarZza.zzb(true == this.zzd.zzd ? 0 : 2);
            final zzbep zzbepVar = (zzbep) zzbeoVarZza.zzal();
            this.zza.zzb(new zzbbo() { // from class: com.google.android.gms.internal.ads.zzegs
                @Override // com.google.android.gms.internal.ads.zzbbo
                public final void zza(zzbde zzbdeVar) {
                    zzbcw zzbcwVar = (zzbcw) zzbdeVar.zzb().zzaB();
                    zzbcwVar.zzb(zzbepVar);
                    zzbdeVar.zzg(zzbcwVar);
                }
            });
            this.zza.zzc(10004);
        }
        zzegn.zzf(sQLiteDatabase);
        return null;
    }
}
