package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzayg;
import com.google.android.gms.internal.ads.zzayi;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzdl extends zzayg implements zzdn {
    zzdl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IResponseInfo");
    }

    @Override // com.google.android.gms.ads.internal.client.zzdn
    public final Bundle zze() throws RemoteException {
        Parcel parcelZzbl = zzbl(5, zza());
        Bundle bundle = (Bundle) zzayi.zza(parcelZzbl, Bundle.CREATOR);
        parcelZzbl.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdn
    public final zzu zzf() throws RemoteException {
        Parcel parcelZzbl = zzbl(4, zza());
        zzu zzuVar = (zzu) zzayi.zza(parcelZzbl, zzu.CREATOR);
        parcelZzbl.recycle();
        return zzuVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdn
    public final String zzg() throws RemoteException {
        Parcel parcelZzbl = zzbl(1, zza());
        String string = parcelZzbl.readString();
        parcelZzbl.recycle();
        return string;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdn
    public final String zzh() throws RemoteException {
        Parcel parcelZzbl = zzbl(6, zza());
        String string = parcelZzbl.readString();
        parcelZzbl.recycle();
        return string;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdn
    public final String zzi() throws RemoteException {
        Parcel parcelZzbl = zzbl(2, zza());
        String string = parcelZzbl.readString();
        parcelZzbl.recycle();
        return string;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdn
    public final List zzj() throws RemoteException {
        Parcel parcelZzbl = zzbl(3, zza());
        ArrayList arrayListCreateTypedArrayList = parcelZzbl.createTypedArrayList(zzu.CREATOR);
        parcelZzbl.recycle();
        return arrayListCreateTypedArrayList;
    }
}
