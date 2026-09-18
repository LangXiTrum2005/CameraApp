package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzesd implements zzexq {
    private final zzgey zza;
    private final zzdua zzb;
    private final zzdyi zzc;
    private final zzesf zzd;

    public zzesd(zzgey zzgeyVar, zzdua zzduaVar, zzdyi zzdyiVar, zzesf zzesfVar) {
        this.zza = zzgeyVar;
        this.zzb = zzduaVar;
        this.zzc = zzdyiVar;
        this.zzd = zzesfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlc)).booleanValue() && this.zzd.zza() != null) {
            zzese zzeseVarZza = this.zzd.zza();
            zzeseVarZza.getClass();
            return zzgen.zzh(zzeseVarZza);
        }
        if (!zzfxt.zzd((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbr))) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlc)).booleanValue() || (!this.zzd.zzd() && this.zzc.zzt())) {
                this.zzd.zzc(true);
                return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzesc
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.zza.zzc();
                    }
                });
            }
        }
        return zzgen.zzh(new zzese(new Bundle()));
    }

    final /* synthetic */ zzese zzc() throws Exception {
        List<String> listAsList = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbr)).split(";"));
        Bundle bundle = new Bundle();
        for (String str : listAsList) {
            try {
                zzfif zzfifVarZzc = this.zzb.zzc(str, new JSONObject());
                zzfifVarZzc.zzC();
                boolean zZzt = this.zzc.zzt();
                Bundle bundle2 = new Bundle();
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlc)).booleanValue() || zZzt) {
                    try {
                        zzbvg zzbvgVarZzf = zzfifVarZzc.zzf();
                        if (zzbvgVarZzf != null) {
                            bundle2.putString("sdk_version", zzbvgVarZzf.toString());
                        }
                    } catch (zzfho unused) {
                    }
                }
                try {
                    zzbvg zzbvgVarZze = zzfifVarZzc.zze();
                    if (zzbvgVarZze != null) {
                        bundle2.putString("adapter_version", zzbvgVarZze.toString());
                    }
                } catch (zzfho unused2) {
                }
                bundle.putBundle(str, bundle2);
            } catch (zzfho unused3) {
            }
        }
        zzese zzeseVar = new zzese(bundle);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlc)).booleanValue()) {
            this.zzd.zzb(zzeseVar);
        }
        return zzeseVar;
    }
}
