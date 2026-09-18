package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcai extends zzayg implements zzcak {
    zzcai(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
    }

    @Override // com.google.android.gms.internal.ads.zzcak
    public final int zze() throws RemoteException {
        Parcel parcelZzbl = zzbl(2, zza());
        int i = parcelZzbl.readInt();
        parcelZzbl.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzcak
    public final String zzf() throws RemoteException {
        Parcel parcelZzbl = zzbl(1, zza());
        String string = parcelZzbl.readString();
        parcelZzbl.recycle();
        return string;
    }
}
