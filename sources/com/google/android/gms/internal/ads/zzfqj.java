package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfqj extends zzfqe {
    public zzfqj(zzfpx zzfpxVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzfpxVar, hashSet, jSONObject, j);
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        if (zzfpo.zzg(this.zzb, this.zzd.zza())) {
            return null;
        }
        this.zzd.zze(this.zzb);
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfqf, android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        onPostExecute((String) obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfqf
    /* JADX INFO: renamed from: zza */
    public final void onPostExecute(String str) {
        zzfov zzfovVarZza;
        if (!TextUtils.isEmpty(str) && (zzfovVarZza = zzfov.zza()) != null) {
            for (zzfoh zzfohVar : zzfovVarZza.zzc()) {
                if (this.zza.contains(zzfohVar.zzh())) {
                    zzfohVar.zzg().zzf(str, this.zzc);
                }
            }
        }
        super.onPostExecute(str);
    }
}
