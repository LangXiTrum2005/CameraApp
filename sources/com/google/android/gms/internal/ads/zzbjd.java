package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbjd extends zzayg implements zzbjf {
    zzbjd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final String zzg() throws RemoteException {
        Parcel parcelZzbl = zzbl(2, zza());
        String string = parcelZzbl.readString();
        parcelZzbl.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbjf
    public final List zzh() throws RemoteException {
        Parcel parcelZzbl = zzbl(3, zza());
        ArrayList arrayListZzb = zzayi.zzb(parcelZzbl);
        parcelZzbl.recycle();
        return arrayListZzb;
    }
}
