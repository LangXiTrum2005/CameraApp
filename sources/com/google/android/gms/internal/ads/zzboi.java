package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzboi extends zzayg implements zzbok {
    zzboi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.h5.client.IH5AdsManagerCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzbok
    public final zzboh zze(IObjectWrapper iObjectWrapper, zzbsv zzbsvVar, int i, zzboe zzboeVar) throws RemoteException {
        zzboh zzbofVar;
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, zzbsvVar);
        parcelZza.writeInt(240304000);
        zzayi.zzf(parcelZza, zzboeVar);
        Parcel parcelZzbl = zzbl(1, parcelZza);
        IBinder strongBinder = parcelZzbl.readStrongBinder();
        if (strongBinder == null) {
            zzbofVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.h5.client.IH5AdsManager");
            zzbofVar = iInterfaceQueryLocalInterface instanceof zzboh ? (zzboh) iInterfaceQueryLocalInterface : new zzbof(strongBinder);
        }
        parcelZzbl.recycle();
        return zzbofVar;
    }
}
