package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzayg;
import com.google.android.gms.internal.ads.zzayi;
import com.google.android.gms.internal.ads.zzbsv;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbv extends zzayg implements IInterface {
    zzbv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }

    public final IBinder zze(IObjectWrapper iObjectWrapper, zzq zzqVar, String str, zzbsv zzbsvVar, int i, int i2) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzd(parcelZza, zzqVar);
        parcelZza.writeString(str);
        zzayi.zzf(parcelZza, zzbsvVar);
        parcelZza.writeInt(240304000);
        parcelZza.writeInt(i2);
        Parcel parcelZzbl = zzbl(2, parcelZza);
        IBinder strongBinder = parcelZzbl.readStrongBinder();
        parcelZzbl.recycle();
        return strongBinder;
    }
}
