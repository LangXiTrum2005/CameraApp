package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeky implements zzeit {
    private final Context zza;
    private final zzdko zzb;

    public zzeky(Context context, zzdko zzdkoVar) {
        this.zza = context;
        this.zzb = zzdkoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final /* bridge */ /* synthetic */ Object zza(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar) throws zzeml, zzfho {
        zzeks zzeksVar = new zzeks(zzfgmVar, (zzbus) zzeiqVar.zzb, AdFormat.INTERSTITIAL);
        zzdjo zzdjoVarZze = this.zzb.zze(new zzcwx(zzfgyVar, zzfgmVar, zzeiqVar.zza), new zzdjr(zzeksVar, null));
        zzeksVar.zzb(zzdjoVarZze.zzc());
        ((zzekj) zzeiqVar.zzc).zzc(zzdjoVarZze.zzi());
        return zzdjoVarZze.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final void zzb(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar) throws zzfho {
        try {
            ((zzbus) zzeiqVar.zzb).zzq(zzfgmVar.zzaa);
            ((zzbus) zzeiqVar.zzb).zzl(zzfgmVar.zzV, zzfgmVar.zzw.toString(), zzfgyVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzekx(this, zzeiqVar, null), (zzbtb) zzeiqVar.zzc);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Remote exception loading a interstitial RTB ad", e);
            throw new zzfho(e);
        }
    }
}
