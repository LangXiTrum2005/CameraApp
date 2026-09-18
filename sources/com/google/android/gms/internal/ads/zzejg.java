package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzejg implements zzeit {
    private final Context zza;
    private final zzctt zzb;

    zzejg(Context context, zzctt zzcttVar) {
        this.zza = context;
        this.zzb = zzcttVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final /* bridge */ /* synthetic */ Object zza(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar) throws zzeml, zzfho {
        zzeks zzeksVar = new zzeks(zzfgmVar, (zzbus) zzeiqVar.zzb, AdFormat.APP_OPEN_AD);
        zzctq zzctqVarZza = this.zzb.zza(new zzcwx(zzfgyVar, zzfgmVar, zzeiqVar.zza), new zzdjr(zzeksVar, null), new zzctr(zzfgmVar.zzab));
        zzeksVar.zzb(zzctqVarZza.zzc());
        ((zzekj) zzeiqVar.zzc).zzc(zzctqVarZza.zzi());
        return zzctqVarZza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final void zzb(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar) throws zzfho {
        try {
            ((zzbus) zzeiqVar.zzb).zzq(zzfgmVar.zzaa);
            ((zzbus) zzeiqVar.zzb).zzi(zzfgmVar.zzV, zzfgmVar.zzw.toString(), zzfgyVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzejf(zzeiqVar, null), (zzbtb) zzeiqVar.zzc);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Remote exception loading an app open RTB ad", e);
            throw new zzfho(e);
        }
    }
}
