package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfsd extends zzayg implements IInterface {
    zzfsd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzfsb zze(zzfrz zzfrzVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, zzfrzVar);
        Parcel parcelZzbl = zzbl(1, parcelZza);
        zzfsb zzfsbVar = (zzfsb) zzayi.zza(parcelZzbl, zzfsb.CREATOR);
        parcelZzbl.recycle();
        return zzfsbVar;
    }

    public final zzfsk zzf(zzfsi zzfsiVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, zzfsiVar);
        Parcel parcelZzbl = zzbl(3, parcelZza);
        zzfsk zzfskVar = (zzfsk) zzayi.zza(parcelZzbl, zzfsk.CREATOR);
        parcelZzbl.recycle();
        return zzfskVar;
    }

    public final void zzg(zzfrw zzfrwVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, zzfrwVar);
        zzbm(2, parcelZza);
    }
}
