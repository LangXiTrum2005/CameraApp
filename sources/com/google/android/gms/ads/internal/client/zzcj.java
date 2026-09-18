package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayg;
import com.google.android.gms.internal.ads.zzayi;
import com.google.android.gms.internal.ads.zzbsu;
import com.google.android.gms.internal.ads.zzbsv;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzcj extends zzayg implements zzcl {
    zzcj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.ILiteSdkInfo");
    }

    @Override // com.google.android.gms.ads.internal.client.zzcl
    public final zzbsv getAdapterCreator() throws RemoteException {
        Parcel parcelZzbl = zzbl(2, zza());
        zzbsv zzbsvVarZzf = zzbsu.zzf(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return zzbsvVarZzf;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcl
    public final zzen getLiteSdkVersion() throws RemoteException {
        Parcel parcelZzbl = zzbl(1, zza());
        zzen zzenVar = (zzen) zzayi.zza(parcelZzbl, zzen.CREATOR);
        parcelZzbl.recycle();
        return zzenVar;
    }
}
