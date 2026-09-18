package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbws;
import com.google.android.gms.internal.ads.zzbwv;
import com.google.android.gms.internal.ads.zzbww;
import com.google.android.gms.internal.ads.zzbxw;
import com.google.android.gms.internal.ads.zzcee;
import com.google.android.gms.internal.ads.zzcef;
import com.google.android.gms.internal.ads.zzceg;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzaa extends zzax {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzaw zzb;

    zzaa(zzaw zzawVar, Activity activity) {
        this.zza = activity;
        this.zzb = zzawVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    protected final /* bridge */ /* synthetic */ Object zza() {
        zzaw.zzt(this.zza, "ad_overlay");
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object zzb(zzce zzceVar) throws RemoteException {
        return zzceVar.zzm(ObjectWrapper.wrap(this.zza));
    }

    @Override // com.google.android.gms.ads.internal.client.zzax
    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        zzbgc.zza(this.zza);
        if (!((Boolean) zzba.zzc().zza(zzbgc.zzki)).booleanValue()) {
            zzaw zzawVar = this.zzb;
            return zzawVar.zzf.zza(this.zza);
        }
        try {
            return zzbws.zzI(((zzbww) zzceg.zzb(this.zza, "com.google.android.gms.ads.ChimeraAdOverlayCreatorImpl", new zzcee() { // from class: com.google.android.gms.ads.internal.client.zzz
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.internal.ads.zzcee
                public final Object zza(Object obj) {
                    return zzbwv.zzb(obj);
                }
            })).zze(ObjectWrapper.wrap(this.zza)));
        } catch (RemoteException | zzcef | NullPointerException e) {
            this.zzb.zzh = zzbxw.zza(this.zza.getApplicationContext());
            this.zzb.zzh.zzg(e, "ClientApiBroker.createAdOverlay");
            return null;
        }
    }
}
