package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeas implements zzhhd {
    private final zzhhu zza;

    public zzeas(zzhhu zzhhuVar) {
        this.zza = zzhhuVar;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0051  */
    /* JADX WARN: Code duplicated, block: B:18:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x0036  */
    @Override // com.google.android.gms.internal.ads.zzhhu
    public final /* bridge */ /* synthetic */ Object zzb() {
        String strValueOf;
        zzfhh zzfhhVarZza = ((zzdao) this.zza).zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhm)).booleanValue()) {
            String str = zzfhhVarZza.zzd.zzx;
            if (!TextUtils.isEmpty(str)) {
                try {
                    strValueOf = new JSONObject(str).getString("request_id");
                    if (TextUtils.isEmpty(strValueOf)) {
                        if (zzfhhVarZza.zzd.zzs != null) {
                            try {
                                strValueOf = new JSONObject(zzfhhVarZza.zzd.zzs.zza).getString("request_id");
                                if (TextUtils.isEmpty(strValueOf)) {
                                    strValueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzay.zze().nextInt() & Integer.MAX_VALUE);
                                }
                            } catch (JSONException unused) {
                            }
                        } else {
                            strValueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzay.zze().nextInt() & Integer.MAX_VALUE);
                        }
                    }
                } catch (JSONException unused2) {
                }
            } else if (zzfhhVarZza.zzd.zzs != null) {
                strValueOf = new JSONObject(zzfhhVarZza.zzd.zzs.zza).getString("request_id");
                if (TextUtils.isEmpty(strValueOf)) {
                    strValueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzay.zze().nextInt() & Integer.MAX_VALUE);
                }
            } else {
                strValueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzay.zze().nextInt() & Integer.MAX_VALUE);
            }
        } else {
            strValueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzay.zze().nextInt() & Integer.MAX_VALUE);
        }
        zzhhl.zzb(strValueOf);
        return strValueOf;
    }
}
