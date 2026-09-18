package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfqd implements zzfpd {
    private static final zzfqd zza = new zzfqd();
    private static final Handler zzb = new Handler(Looper.getMainLooper());
    private static Handler zzc = null;
    private static final Runnable zzd = new zzfpz();
    private static final Runnable zze = new zzfqa();
    private int zzg;
    private long zzm;
    private final List zzf = new ArrayList();
    private boolean zzh = false;
    private final List zzi = new ArrayList();
    private final zzfpw zzk = new zzfpw();
    private final zzfpf zzj = new zzfpf();
    private final zzfpx zzl = new zzfpx(new zzfqg());

    zzfqd() {
    }

    public static zzfqd zzd() {
        return zza;
    }

    static /* bridge */ /* synthetic */ void zzg(zzfqd zzfqdVar) {
        zzfqdVar.zzg = 0;
        zzfqdVar.zzi.clear();
        zzfqdVar.zzh = false;
        for (zzfoh zzfohVar : zzfov.zza().zzb()) {
        }
        zzfqdVar.zzm = System.nanoTime();
        zzfqdVar.zzk.zzi();
        long jNanoTime = System.nanoTime();
        zzfpe zzfpeVarZza = zzfqdVar.zzj.zza();
        if (zzfqdVar.zzk.zze().size() > 0) {
            for (String str : zzfqdVar.zzk.zze()) {
                JSONObject jSONObjectZza = zzfpeVarZza.zza(null);
                View viewZza = zzfqdVar.zzk.zza(str);
                zzfpe zzfpeVarZzb = zzfqdVar.zzj.zzb();
                String strZzc = zzfqdVar.zzk.zzc(str);
                if (strZzc != null) {
                    JSONObject jSONObjectZza2 = zzfpeVarZzb.zza(viewZza);
                    zzfpo.zzb(jSONObjectZza2, str);
                    try {
                        jSONObjectZza2.put("notVisibleReason", strZzc);
                    } catch (JSONException e) {
                        zzfpp.zza("Error with setting not visible reason", e);
                    }
                    zzfpo.zzc(jSONObjectZza, jSONObjectZza2);
                }
                zzfpo.zzf(jSONObjectZza);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                zzfqdVar.zzl.zzc(jSONObjectZza, hashSet, jNanoTime);
            }
        }
        if (zzfqdVar.zzk.zzf().size() > 0) {
            JSONObject jSONObjectZza3 = zzfpeVarZza.zza(null);
            zzfqdVar.zzk(null, zzfpeVarZza, jSONObjectZza3, 1, false);
            zzfpo.zzf(jSONObjectZza3);
            zzfqdVar.zzl.zzd(jSONObjectZza3, zzfqdVar.zzk.zzf(), jNanoTime);
            boolean z = zzfqdVar.zzh;
        } else {
            zzfqdVar.zzl.zzb();
        }
        zzfqdVar.zzk.zzg();
        long jNanoTime2 = System.nanoTime() - zzfqdVar.zzm;
        if (zzfqdVar.zzf.size() > 0) {
            for (zzfqc zzfqcVar : zzfqdVar.zzf) {
                int i = zzfqdVar.zzg;
                TimeUnit.NANOSECONDS.toMillis(jNanoTime2);
                zzfqcVar.zzb();
                if (zzfqcVar instanceof zzfqb) {
                    int i2 = zzfqdVar.zzg;
                    ((zzfqb) zzfqcVar).zza();
                }
            }
        }
    }

    private final void zzk(View view, zzfpe zzfpeVar, JSONObject jSONObject, int i, boolean z) {
        zzfpeVar.zzb(view, jSONObject, this, i == 1, z);
    }

    private static final void zzl() {
        Handler handler = zzc;
        if (handler != null) {
            handler.removeCallbacks(zze);
            zzc = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfpd
    public final void zza(View view, zzfpe zzfpeVar, JSONObject jSONObject, boolean z) {
        int iZzk;
        boolean z2;
        if (zzfpu.zza(view) != null || (iZzk = this.zzk.zzk(view)) == 3) {
            return;
        }
        JSONObject jSONObjectZza = zzfpeVar.zza(view);
        zzfpo.zzc(jSONObject, jSONObjectZza);
        String strZzd = this.zzk.zzd(view);
        if (strZzd != null) {
            zzfpo.zzb(jSONObjectZza, strZzd);
            try {
                jSONObjectZza.put("hasWindowFocus", Boolean.valueOf(this.zzk.zzj(view)));
            } catch (JSONException e) {
                zzfpp.zza("Error with setting has window focus", e);
            }
            this.zzk.zzh();
        } else {
            zzfpv zzfpvVarZzb = this.zzk.zzb(view);
            if (zzfpvVarZzb != null) {
                zzfoy zzfoyVarZza = zzfpvVarZzb.zza();
                JSONArray jSONArray = new JSONArray();
                ArrayList arrayListZzb = zzfpvVarZzb.zzb();
                int size = arrayListZzb.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put((String) arrayListZzb.get(i));
                }
                try {
                    jSONObjectZza.put("isFriendlyObstructionFor", jSONArray);
                    jSONObjectZza.put("friendlyObstructionClass", zzfoyVarZza.zzd());
                    jSONObjectZza.put("friendlyObstructionPurpose", zzfoyVarZza.zza());
                    jSONObjectZza.put("friendlyObstructionReason", zzfoyVarZza.zzc());
                } catch (JSONException e2) {
                    zzfpp.zza("Error with setting friendly obstruction", e2);
                }
                z2 = true;
            } else {
                z2 = false;
            }
            zzk(view, zzfpeVar, jSONObjectZza, iZzk, z || z2);
        }
        this.zzg++;
    }

    public final void zzh() {
        zzl();
    }

    public final void zzi() {
        if (zzc == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            zzc = handler;
            handler.post(zzd);
            zzc.postDelayed(zze, 200L);
        }
    }

    public final void zzj() {
        zzl();
        this.zzf.clear();
        zzb.post(new zzfpy(this));
    }
}
