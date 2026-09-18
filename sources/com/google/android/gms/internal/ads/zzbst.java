package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbst extends zzayg implements zzbsv {
    zzbst(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final zzbsy zzb(String str) throws RemoteException {
        zzbsy zzbswVar;
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzbl = zzbl(1, parcelZza);
        IBinder strongBinder = parcelZzbl.readStrongBinder();
        if (strongBinder == null) {
            zzbswVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            zzbswVar = iInterfaceQueryLocalInterface instanceof zzbsy ? (zzbsy) iInterfaceQueryLocalInterface : new zzbsw(strongBinder);
        }
        parcelZzbl.recycle();
        return zzbswVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final zzbus zzc(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzbl = zzbl(3, parcelZza);
        zzbus zzbusVarZzb = zzbur.zzb(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return zzbusVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final boolean zzd(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzbl = zzbl(4, parcelZza);
        boolean zZzg = zzayi.zzg(parcelZzbl);
        parcelZzbl.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbsv
    public final boolean zze(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzbl = zzbl(2, parcelZza);
        boolean zZzg = zzayi.zzg(parcelZzbl);
        parcelZzbl.recycle();
        return zZzg;
    }
}
