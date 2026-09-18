package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzccr extends zzayg implements zzcct {
    zzccr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final IObjectWrapper zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, iObjectWrapper2);
        parcelZza.writeString(str);
        zzayi.zzf(parcelZza, iObjectWrapper3);
        Parcel parcelZzbl = zzbl(11, parcelZza);
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzf(IObjectWrapper iObjectWrapper, zzccx zzccxVar, zzccq zzccqVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzd(parcelZza, zzccxVar);
        zzayi.zzf(parcelZza, zzccqVar);
        zzbm(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzg(zzbxr zzbxrVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, zzbxrVar);
        zzbm(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbxi zzbxiVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, zzbxiVar);
        zzbm(10, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzi(List list, IObjectWrapper iObjectWrapper, zzbxi zzbxiVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, zzbxiVar);
        zzbm(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzbm(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzbm(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbxi zzbxiVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, zzbxiVar);
        zzbm(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzcct
    public final void zzm(List list, IObjectWrapper iObjectWrapper, zzbxi zzbxiVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, zzbxiVar);
        zzbm(5, parcelZza);
    }
}
