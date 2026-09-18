package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeln implements zzeit {
    private final Context zza;
    private final zzdlk zzb;
    private zzbtk zzc;
    private final zzcei zzd;

    public zzeln(Context context, zzdlk zzdlkVar, zzcei zzceiVar) {
        this.zza = context;
        this.zzb = zzdlkVar;
        this.zzd = zzceiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final /* bridge */ /* synthetic */ Object zza(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar) throws zzeml, zzfho {
        if (!zzfgyVar.zza.zza.zzg.contains(Integer.toString(6))) {
            throw new zzeml(2, "Unified must be used for RTB.");
        }
        zzdna zzdnaVarZzt = zzdna.zzt(this.zzc);
        zzfhh zzfhhVar = zzfgyVar.zza.zza;
        if (!zzfhhVar.zzg.contains(Integer.toString(zzdnaVarZzt.zzc()))) {
            throw new zzeml(1, "No corresponding native ad listener");
        }
        zzdnc zzdncVarZze = this.zzb.zze(new zzcwx(zzfgyVar, zzfgmVar, zzeiqVar.zza), new zzdnm(zzdnaVarZzt), new zzdpd(null, null, this.zzc));
        ((zzekj) zzeiqVar.zzc).zzc(zzdncVarZze.zzi());
        return zzdncVarZze.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeit
    public final void zzb(zzfgy zzfgyVar, zzfgm zzfgmVar, zzeiq zzeiqVar) throws zzfho {
        try {
            ((zzbus) zzeiqVar.zzb).zzq(zzfgmVar.zzaa);
            zzell zzellVar = null;
            if (this.zzd.zzc < ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbH)).intValue()) {
                ((zzbus) zzeiqVar.zzb).zzm(zzfgmVar.zzV, zzfgmVar.zzw.toString(), zzfgyVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzelm(this, zzeiqVar, zzellVar), (zzbtb) zzeiqVar.zzc);
            } else {
                ((zzbus) zzeiqVar.zzb).zzn(zzfgmVar.zzV, zzfgmVar.zzw.toString(), zzfgyVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzelm(this, zzeiqVar, zzellVar), (zzbtb) zzeiqVar.zzc, zzfgyVar.zza.zza.zzi);
            }
        } catch (RemoteException e) {
            throw new zzfho(e);
        }
    }
}
