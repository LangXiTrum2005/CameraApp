package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbtg extends zzayg implements IInterface {
    zzbtg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
    }

    public final double zze() throws RemoteException {
        Parcel parcelZzbl = zzbl(7, zza());
        double d = parcelZzbl.readDouble();
        parcelZzbl.recycle();
        return d;
    }

    public final Bundle zzf() throws RemoteException {
        Parcel parcelZzbl = zzbl(15, zza());
        Bundle bundle = (Bundle) zzayi.zza(parcelZzbl, Bundle.CREATOR);
        parcelZzbl.recycle();
        return bundle;
    }

    public final com.google.android.gms.ads.internal.client.zzdq zzg() throws RemoteException {
        Parcel parcelZzbl = zzbl(17, zza());
        com.google.android.gms.ads.internal.client.zzdq zzdqVarZzb = com.google.android.gms.ads.internal.client.zzdp.zzb(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return zzdqVarZzb;
    }

    public final zzbjf zzh() throws RemoteException {
        Parcel parcelZzbl = zzbl(19, zza());
        zzbjf zzbjfVarZzj = zzbje.zzj(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return zzbjfVarZzj;
    }

    public final zzbjm zzi() throws RemoteException {
        Parcel parcelZzbl = zzbl(5, zza());
        zzbjm zzbjmVarZzg = zzbjl.zzg(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return zzbjmVarZzg;
    }

    public final IObjectWrapper zzj() throws RemoteException {
        Parcel parcelZzbl = zzbl(18, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return iObjectWrapperAsInterface;
    }

    public final IObjectWrapper zzk() throws RemoteException {
        Parcel parcelZzbl = zzbl(20, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return iObjectWrapperAsInterface;
    }

    public final IObjectWrapper zzl() throws RemoteException {
        Parcel parcelZzbl = zzbl(21, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return iObjectWrapperAsInterface;
    }

    public final String zzm() throws RemoteException {
        Parcel parcelZzbl = zzbl(4, zza());
        String string = parcelZzbl.readString();
        parcelZzbl.recycle();
        return string;
    }

    public final String zzn() throws RemoteException {
        Parcel parcelZzbl = zzbl(6, zza());
        String string = parcelZzbl.readString();
        parcelZzbl.recycle();
        return string;
    }

    public final String zzo() throws RemoteException {
        Parcel parcelZzbl = zzbl(2, zza());
        String string = parcelZzbl.readString();
        parcelZzbl.recycle();
        return string;
    }

    public final String zzp() throws RemoteException {
        Parcel parcelZzbl = zzbl(9, zza());
        String string = parcelZzbl.readString();
        parcelZzbl.recycle();
        return string;
    }

    public final String zzq() throws RemoteException {
        Parcel parcelZzbl = zzbl(8, zza());
        String string = parcelZzbl.readString();
        parcelZzbl.recycle();
        return string;
    }

    public final List zzr() throws RemoteException {
        Parcel parcelZzbl = zzbl(3, zza());
        ArrayList arrayListZzb = zzayi.zzb(parcelZzbl);
        parcelZzbl.recycle();
        return arrayListZzb;
    }

    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzbm(11, parcelZza);
    }

    public final void zzt() throws RemoteException {
        zzbm(10, zza());
    }

    public final void zzu(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzbm(12, parcelZza);
    }

    public final void zzv(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, iObjectWrapper2);
        zzayi.zzf(parcelZza, iObjectWrapper3);
        zzbm(22, parcelZza);
    }

    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzbm(16, parcelZza);
    }

    public final boolean zzx() throws RemoteException {
        Parcel parcelZzbl = zzbl(14, zza());
        boolean zZzg = zzayi.zzg(parcelZzbl);
        parcelZzbl.recycle();
        return zZzg;
    }

    public final boolean zzy() throws RemoteException {
        Parcel parcelZzbl = zzbl(13, zza());
        boolean zZzg = zzayi.zzg(parcelZzbl);
        parcelZzbl.recycle();
        return zZzg;
    }
}
