package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbjr extends zzayg implements zzbjt {
    zzbjr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzbjt
    public final IBinder zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, int i) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, iObjectWrapper2);
        zzayi.zzf(parcelZza, iObjectWrapper3);
        parcelZza.writeInt(240304000);
        Parcel parcelZzbl = zzbl(1, parcelZza);
        IBinder strongBinder = parcelZzbl.readStrongBinder();
        parcelZzbl.recycle();
        return strongBinder;
    }
}
