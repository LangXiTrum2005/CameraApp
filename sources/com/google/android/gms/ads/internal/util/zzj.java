package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzazp;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbhs;
import com.google.android.gms.internal.ads.zzcdf;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzcep;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzj implements zzg {
    private boolean zzb;
    private ListenableFuture zzd;
    private SharedPreferences zzf;
    private SharedPreferences.Editor zzg;
    private String zzi;
    private String zzj;
    private final Object zza = new Object();
    private final List zzc = new ArrayList();
    private zzazp zze = null;
    private boolean zzh = true;
    private boolean zzk = true;
    private String zzl = "-1";
    private String zzm = "-1";
    private String zzn = "-1";
    private int zzo = -1;
    private zzcdf zzp = new zzcdf("", 0);
    private long zzq = 0;
    private long zzr = 0;
    private int zzs = -1;
    private int zzt = 0;
    private Set zzu = Collections.emptySet();
    private JSONObject zzv = new JSONObject();
    private boolean zzw = true;
    private boolean zzx = true;
    private String zzy = null;
    private String zzz = "";
    private boolean zzA = false;
    private String zzB = "";
    private int zzC = -1;
    private int zzD = -1;
    private long zzE = 0;

    private final void zzT() {
        ListenableFuture listenableFuture = this.zzd;
        if (listenableFuture == null || listenableFuture.isDone()) {
            return;
        }
        try {
            this.zzd.get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            zzcec.zzk("Interrupted while waiting for preferences loaded.", e);
        } catch (CancellationException e2) {
            e = e2;
            zzcec.zzh("Fail to initialize AdSharedPreferenceManager.", e);
        } catch (ExecutionException e3) {
            e = e3;
            zzcec.zzh("Fail to initialize AdSharedPreferenceManager.", e);
        } catch (TimeoutException e4) {
            e = e4;
            zzcec.zzh("Fail to initialize AdSharedPreferenceManager.", e);
        }
    }

    private final void zzU() {
        zzcep.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.internal.util.zzh
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzg();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzA(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjc)).booleanValue()) {
            zzT();
            synchronized (this.zza) {
                if (this.zzB.equals(str)) {
                    return;
                }
                this.zzB = str;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putString("linked_ad_unit", str);
                    this.zzg.apply();
                }
                zzU();
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzB(boolean z) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjc)).booleanValue()) {
            zzT();
            synchronized (this.zza) {
                if (this.zzA == z) {
                    return;
                }
                this.zzA = z;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putBoolean("linked_device", z);
                    this.zzg.apply();
                }
                zzU();
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzC(String str) {
        zzT();
        synchronized (this.zza) {
            if (TextUtils.equals(this.zzy, str)) {
                return;
            }
            this.zzy = str;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putString("display_cutout", str);
                this.zzg.apply();
            }
            zzU();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzD(long j) {
        zzT();
        synchronized (this.zza) {
            if (this.zzr == j) {
                return;
            }
            this.zzr = j;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putLong("first_ad_req_time_ms", j);
                this.zzg.apply();
            }
            zzU();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzE(int i) {
        zzT();
        synchronized (this.zza) {
            this.zzo = i;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                if (i == -1) {
                    editor.remove("gad_has_consent_for_cookies");
                } else {
                    editor.putInt("gad_has_consent_for_cookies", i);
                }
                this.zzg.apply();
            }
            zzU();
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003a  */
    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzF(String str, String str2) {
        byte b;
        zzT();
        synchronized (this.zza) {
            int iHashCode = str.hashCode();
            if (iHashCode != -2004976699) {
                if (iHashCode != 83641339) {
                    if (iHashCode == 1218895378 && str.equals("IABTCF_TCString")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                } else if (str.equals("IABTCF_gdprApplies")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str.equals("IABTCF_PurposeConsents")) {
                b = 2;
            } else {
                b = -1;
            }
            if (b == 0) {
                this.zzl = str2;
            } else if (b == 1) {
                this.zzm = str2;
            } else if (b != 2) {
                return;
            } else {
                this.zzn = str2;
            }
            if (this.zzg != null) {
                if (str2.equals("-1")) {
                    this.zzg.remove(str);
                } else {
                    this.zzg.putString(str, str2);
                }
                this.zzg.apply();
            }
            zzU();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzG(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziN)).booleanValue()) {
            zzT();
            synchronized (this.zza) {
                if (this.zzz.equals(str)) {
                    return;
                }
                this.zzz = str;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putString("inspector_info", str);
                    this.zzg.apply();
                }
                zzU();
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzH(boolean z) {
        zzT();
        synchronized (this.zza) {
            if (z == this.zzk) {
                return;
            }
            this.zzk = z;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putBoolean("gad_idless", z);
                this.zzg.apply();
            }
            zzU();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzI(boolean z) {
        zzT();
        synchronized (this.zza) {
            long jCurrentTimeMillis = System.currentTimeMillis() + ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjW)).longValue();
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putBoolean("is_topics_ad_personalization_allowed", z);
                this.zzg.putLong("topics_consent_expiry_time_ms", jCurrentTimeMillis);
                this.zzg.apply();
            }
            zzU();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzJ(String str, String str2, boolean z) {
        zzT();
        synchronized (this.zza) {
            JSONArray jSONArrayOptJSONArray = this.zzv.optJSONArray(str);
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
            }
            int length = jSONArrayOptJSONArray.length();
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject == null) {
                    return;
                }
                if (str2.equals(jSONObjectOptJSONObject.optString("template_id"))) {
                    if (!z || !jSONObjectOptJSONObject.optBoolean("uses_media_view", false)) {
                        length = i;
                        break;
                    }
                    return;
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis());
                jSONArrayOptJSONArray.put(length, jSONObject);
                this.zzv.put(str, jSONArrayOptJSONArray);
            } catch (JSONException e) {
                zzcec.zzk("Could not update native advanced settings", e);
            }
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putString("native_advanced_settings", this.zzv.toString());
                this.zzg.apply();
            }
            zzU();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzK(int i) {
        zzT();
        synchronized (this.zza) {
            if (this.zzs == i) {
                return;
            }
            this.zzs = i;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putInt("request_in_session_count", i);
                this.zzg.apply();
            }
            zzU();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzL(int i) {
        zzT();
        synchronized (this.zza) {
            if (this.zzD == i) {
                return;
            }
            this.zzD = i;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putInt("sd_app_measure_npa", i);
                this.zzg.apply();
            }
            zzU();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzM(long j) {
        zzT();
        synchronized (this.zza) {
            if (this.zzE == j) {
                return;
            }
            this.zzE = j;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putLong("sd_app_measure_npa_ts", j);
                this.zzg.apply();
            }
            zzU();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final boolean zzN() {
        boolean z;
        zzT();
        synchronized (this.zza) {
            z = this.zzw;
        }
        return z;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final boolean zzO() {
        boolean z;
        zzT();
        synchronized (this.zza) {
            z = this.zzx;
        }
        return z;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final boolean zzP() {
        boolean z;
        zzT();
        synchronized (this.zza) {
            z = this.zzA;
        }
        return z;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final boolean zzQ() {
        boolean z;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzau)).booleanValue()) {
            return false;
        }
        zzT();
        synchronized (this.zza) {
            z = this.zzk;
        }
        return z;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final boolean zzR() {
        zzT();
        synchronized (this.zza) {
            SharedPreferences sharedPreferences = this.zzf;
            boolean z = false;
            if (sharedPreferences == null) {
                return false;
            }
            if (sharedPreferences.getLong("topics_consent_expiry_time_ms", 0L) < System.currentTimeMillis()) {
                return false;
            }
            if (this.zzf.getBoolean("is_topics_ad_personalization_allowed", false) && !this.zzk) {
                z = true;
            }
            return z;
        }
    }

    final /* synthetic */ void zzS(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("admob", 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        synchronized (this.zza) {
            this.zzf = sharedPreferences;
            this.zzg = editorEdit;
            if (PlatformVersion.isAtLeastM()) {
                NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
            }
            this.zzh = this.zzf.getBoolean("use_https", this.zzh);
            this.zzw = this.zzf.getBoolean("content_url_opted_out", this.zzw);
            this.zzi = this.zzf.getString("content_url_hashes", this.zzi);
            this.zzk = this.zzf.getBoolean("gad_idless", this.zzk);
            this.zzx = this.zzf.getBoolean("content_vertical_opted_out", this.zzx);
            this.zzj = this.zzf.getString("content_vertical_hashes", this.zzj);
            this.zzt = this.zzf.getInt("version_code", this.zzt);
            this.zzp = new zzcdf(this.zzf.getString("app_settings_json", this.zzp.zzc()), this.zzf.getLong("app_settings_last_update_ms", this.zzp.zza()));
            this.zzq = this.zzf.getLong("app_last_background_time_ms", this.zzq);
            this.zzs = this.zzf.getInt("request_in_session_count", this.zzs);
            this.zzr = this.zzf.getLong("first_ad_req_time_ms", this.zzr);
            this.zzu = this.zzf.getStringSet("never_pool_slots", this.zzu);
            this.zzy = this.zzf.getString("display_cutout", this.zzy);
            this.zzC = this.zzf.getInt("app_measurement_npa", this.zzC);
            this.zzD = this.zzf.getInt("sd_app_measure_npa", this.zzD);
            this.zzE = this.zzf.getLong("sd_app_measure_npa_ts", this.zzE);
            this.zzz = this.zzf.getString("inspector_info", this.zzz);
            this.zzA = this.zzf.getBoolean("linked_device", this.zzA);
            this.zzB = this.zzf.getString("linked_ad_unit", this.zzB);
            this.zzl = this.zzf.getString("IABTCF_gdprApplies", this.zzl);
            this.zzn = this.zzf.getString("IABTCF_PurposeConsents", this.zzn);
            this.zzm = this.zzf.getString("IABTCF_TCString", this.zzm);
            this.zzo = this.zzf.getInt("gad_has_consent_for_cookies", this.zzo);
            try {
                this.zzv = new JSONObject(this.zzf.getString("native_advanced_settings", "{}"));
            } catch (JSONException e) {
                zzcec.zzk("Could not convert native advanced settings to json object", e);
            }
            zzU();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final int zza() {
        int i;
        zzT();
        synchronized (this.zza) {
            i = this.zzt;
        }
        return i;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final int zzb() {
        int i;
        zzT();
        synchronized (this.zza) {
            i = this.zzo;
        }
        return i;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final int zzc() {
        int i;
        zzT();
        synchronized (this.zza) {
            i = this.zzs;
        }
        return i;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final long zzd() {
        long j;
        zzT();
        synchronized (this.zza) {
            j = this.zzq;
        }
        return j;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final long zze() {
        long j;
        zzT();
        synchronized (this.zza) {
            j = this.zzr;
        }
        return j;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final long zzf() {
        long j;
        zzT();
        synchronized (this.zza) {
            j = this.zzE;
        }
        return j;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final zzazp zzg() {
        if (!this.zzb) {
            return null;
        }
        if ((zzN() && zzO()) || !((Boolean) zzbhs.zzb.zze()).booleanValue()) {
            return null;
        }
        synchronized (this.zza) {
            if (Looper.getMainLooper() == null) {
                return null;
            }
            if (this.zze == null) {
                this.zze = new zzazp();
            }
            this.zze.zze();
            zzcec.zzi("start fetching content...");
            return this.zze;
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final zzcdf zzh() {
        zzcdf zzcdfVar;
        zzT();
        synchronized (this.zza) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzle)).booleanValue() && this.zzp.zzj()) {
                Iterator it = this.zzc.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
            }
            zzcdfVar = this.zzp;
        }
        return zzcdfVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final zzcdf zzi() {
        zzcdf zzcdfVar;
        synchronized (this.zza) {
            zzcdfVar = this.zzp;
        }
        return zzcdfVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final String zzj() {
        String str;
        zzT();
        synchronized (this.zza) {
            str = this.zzi;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final String zzk() {
        String str;
        zzT();
        synchronized (this.zza) {
            str = this.zzj;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final String zzl() {
        String str;
        zzT();
        synchronized (this.zza) {
            str = this.zzB;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final String zzm() {
        String str;
        zzT();
        synchronized (this.zza) {
            str = this.zzy;
        }
        return str;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003a  */
    @Override // com.google.android.gms.ads.internal.util.zzg
    public final String zzn(String str) {
        byte b;
        zzT();
        synchronized (this.zza) {
            int iHashCode = str.hashCode();
            if (iHashCode != -2004976699) {
                if (iHashCode != 83641339) {
                    if (iHashCode == 1218895378 && str.equals("IABTCF_TCString")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                } else if (str.equals("IABTCF_gdprApplies")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str.equals("IABTCF_PurposeConsents")) {
                b = 2;
            } else {
                b = -1;
            }
            if (b == 0) {
                return this.zzl;
            }
            if (b == 1) {
                return this.zzm;
            }
            if (b != 2) {
                return null;
            }
            return this.zzn;
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final String zzo() {
        String str;
        zzT();
        synchronized (this.zza) {
            str = this.zzz;
        }
        return str;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final JSONObject zzp() {
        JSONObject jSONObject;
        zzT();
        synchronized (this.zza) {
            jSONObject = this.zzv;
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzq(Runnable runnable) {
        this.zzc.add(runnable);
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzr(final Context context) {
        synchronized (this.zza) {
            if (this.zzf != null) {
                return;
            }
            final String str = "admob";
            this.zzd = zzcep.zza.zza(new Runnable(context, str) { // from class: com.google.android.gms.ads.internal.util.zzi
                public final /* synthetic */ Context zzb;
                public final /* synthetic */ String zzc = "admob";

                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzS(this.zzb, this.zzc);
                }
            });
            this.zzb = true;
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzs() {
        zzT();
        synchronized (this.zza) {
            this.zzv = new JSONObject();
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.remove("native_advanced_settings");
                this.zzg.apply();
            }
            zzU();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzt(long j) {
        zzT();
        synchronized (this.zza) {
            if (this.zzq == j) {
                return;
            }
            this.zzq = j;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putLong("app_last_background_time_ms", j);
                this.zzg.apply();
            }
            zzU();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzu(String str) {
        zzT();
        synchronized (this.zza) {
            long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
            if (str != null && !str.equals(this.zzp.zzc())) {
                this.zzp = new zzcdf(str, jCurrentTimeMillis);
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putString("app_settings_json", str);
                    this.zzg.putLong("app_settings_last_update_ms", jCurrentTimeMillis);
                    this.zzg.apply();
                }
                zzU();
                Iterator it = this.zzc.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
                return;
            }
            this.zzp.zzg(jCurrentTimeMillis);
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzv(int i) {
        zzT();
        synchronized (this.zza) {
            if (this.zzt == i) {
                return;
            }
            this.zzt = i;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putInt("version_code", i);
                this.zzg.apply();
            }
            zzU();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzw(String str) {
        zzT();
        synchronized (this.zza) {
            if (str.equals(this.zzi)) {
                return;
            }
            this.zzi = str;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putString("content_url_hashes", str);
                this.zzg.apply();
            }
            zzU();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzx(boolean z) {
        zzT();
        synchronized (this.zza) {
            if (this.zzw == z) {
                return;
            }
            this.zzw = z;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putBoolean("content_url_opted_out", z);
                this.zzg.apply();
            }
            zzU();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzy(String str) {
        zzT();
        synchronized (this.zza) {
            if (str.equals(this.zzj)) {
                return;
            }
            this.zzj = str;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putString("content_vertical_hashes", str);
                this.zzg.apply();
            }
            zzU();
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzg
    public final void zzz(boolean z) {
        zzT();
        synchronized (this.zza) {
            if (this.zzx == z) {
                return;
            }
            this.zzx = z;
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putBoolean("content_vertical_opted_out", z);
                this.zzg.apply();
            }
            zzU();
        }
    }
}
