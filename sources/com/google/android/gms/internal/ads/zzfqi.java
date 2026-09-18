package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfqi extends zzfqe {
    public zzfqi(zzfpx zzfpxVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzfpxVar, hashSet, jSONObject, j);
    }

    private final void zzc(String str) {
        zzfov zzfovVarZza = zzfov.zza();
        if (zzfovVarZza != null) {
            for (zzfoh zzfohVar : zzfovVarZza.zzc()) {
                if (this.zza.contains(zzfohVar.zzh())) {
                    zzfohVar.zzg().zzd(str, this.zzc);
                }
            }
        }
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfqf, android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        zzc(str);
        super.onPostExecute(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfqf
    /* JADX INFO: renamed from: zza */
    public final void onPostExecute(String str) {
        zzc(str);
        super.onPostExecute(str);
    }
}
