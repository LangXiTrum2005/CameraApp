package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcav extends zzayg implements IInterface {
    zzcav(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
    }

    public final void zze(zzcak zzcakVar, String str, String str2) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, zzcakVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbm(2, parcelZza);
    }
}
