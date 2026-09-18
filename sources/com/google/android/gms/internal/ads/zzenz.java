package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzenz implements zzein {
    private final zzeip zza;
    private final zzeit zzb;
    private final zzflm zzc;
    private final zzgey zzd;

    public zzenz(zzflm zzflmVar, zzgey zzgeyVar, zzeip zzeipVar, zzeit zzeitVar) {
        this.zzc = zzflmVar;
        this.zzd = zzgeyVar;
        this.zzb = zzeitVar;
        this.zza = zzeipVar;
    }

    static final String zze(String str, int i) {
        return "Error from: " + str + ", code: " + i;
    }

    @Override // com.google.android.gms.internal.ads.zzein
    public final ListenableFuture zza(final zzfgy zzfgyVar, final zzfgm zzfgmVar) {
        final zzeiq zzeiqVarZza;
        Iterator it = zzfgmVar.zzu.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzeiqVarZza = null;
                break;
            }
            try {
                zzeiqVarZza = this.zza.zza((String) it.next(), zzfgmVar.zzw);
                break;
            } catch (zzfho unused) {
            }
        }
        if (zzeiqVarZza == null) {
            return zzgen.zzg(new zzelp("Unable to instantiate mediation adapter class."));
        }
        zzceu zzceuVar = new zzceu();
        zzeiqVarZza.zzc.zza(new zzeny(this, zzeiqVarZza, zzceuVar));
        if (zzfgmVar.zzN) {
            Bundle bundle = zzfgyVar.zza.zza.zzd.zzm;
            Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        zzflm zzflmVar = this.zzc;
        return zzfkw.zzd(new zzfkq() { // from class: com.google.android.gms.internal.ads.zzenw
            @Override // com.google.android.gms.internal.ads.zzfkq
            public final void zza() throws Exception {
                this.zza.zzd(zzfgyVar, zzfgmVar, zzeiqVarZza);
            }
        }, this.zzd, zzflg.ADAPTER_LOAD_AD_SYN, zzflmVar).zzb(zzflg.ADAPTER_LOAD_AD_ACK).zzd(zzceuVar).zzb(zzflg.ADAPTER_WRAP_ADAPTER).zze(new zzfkp() { // from class: com.google.android.gms.internal.ads.zzenx
            @Override // com.google.android.gms.internal.ads.zzfkp
            public final Object zza(Object obj) {
                return this.zza.zzc(zzfgyVar, zzfgmVar, zzeiqVarZza, (Void) obj);
            }
        }).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzein
    public final boolean zzb(zzfgy zzfgyVar, zzfgm zzfgmVar) {
        return !zzfgmVar.zzu.isEmpty();
    }

    final /* synthetic */ Object zzc(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar, Void r4) throws Exception {
        return this.zzb.zza(zzfgyVar, zzfgmVar, zzeiqVar);
    }

    final /* synthetic */ void zzd(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar) throws Exception {
        this.zzb.zzb(zzfgyVar, zzfgmVar, zzeiqVar);
    }
}
