package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbwn extends zzayg implements zzbwp {
    zzbwn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.offline.IOfflineUtilsCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzbwp
    public final zzbwm zze(IObjectWrapper iObjectWrapper, zzbsv zzbsvVar, int i) throws RemoteException {
        zzbwm zzbwkVar;
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, zzbsvVar);
        parcelZza.writeInt(240304000);
        Parcel parcelZzbl = zzbl(1, parcelZza);
        IBinder strongBinder = parcelZzbl.readStrongBinder();
        if (strongBinder == null) {
            zzbwkVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtils");
            zzbwkVar = iInterfaceQueryLocalInterface instanceof zzbwm ? (zzbwm) iInterfaceQueryLocalInterface : new zzbwk(strongBinder);
        }
        parcelZzbl.recycle();
        return zzbwkVar;
    }
}
