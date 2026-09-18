package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzemy implements zzeit {
    private final Context zza;
    private final zzdst zzb;

    public zzemy(Context context, zzdst zzdstVar) {
        this.zza = context;
        this.zzb = zzdstVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final /* bridge */ /* synthetic */ Object zza(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar) throws zzeml, zzfho {
        zzeks zzeksVar = new zzeks(zzfgmVar, (zzbus) zzeiqVar.zzb, AdFormat.REWARDED);
        zzdsp zzdspVarZze = this.zzb.zze(new zzcwx(zzfgyVar, zzfgmVar, zzeiqVar.zza), new zzdsq(zzeksVar));
        zzeksVar.zzb(zzdspVarZze.zzc());
        ((zzekj) zzeiqVar.zzc).zzc(zzdspVarZze.zzn());
        return zzdspVarZze.zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final void zzb(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar) throws zzfho {
        try {
            ((zzbus) zzeiqVar.zzb).zzq(zzfgmVar.zzaa);
            if (zzfgyVar.zza.zza.zzo.zza == 3) {
                ((zzbus) zzeiqVar.zzb).zzo(zzfgmVar.zzV, zzfgmVar.zzw.toString(), zzfgyVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzemx(this, zzeiqVar, null), (zzbtb) zzeiqVar.zzc);
            } else {
                ((zzbus) zzeiqVar.zzb).zzp(zzfgmVar.zzV, zzfgmVar.zzw.toString(), zzfgyVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzemx(this, zzeiqVar, null), (zzbtb) zzeiqVar.zzc);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Remote exception loading a rewarded RTB ad", e);
        }
    }
}
