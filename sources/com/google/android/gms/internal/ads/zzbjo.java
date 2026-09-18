package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbjo extends zzayg implements zzbjq {
    zzbjo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzbjq
    public final IObjectWrapper zzb(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzbl = zzbl(2, parcelZza);
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbjq
    public final void zzbE(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzbm(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbjq
    public final void zzbF(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzbm(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbjq
    public final void zzbG(zzbjj zzbjjVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, zzbjjVar);
        zzbm(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbjq
    public final void zzbH(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzbm(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbjq
    public final void zzbI(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzbm(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbjq
    public final void zzc() throws RemoteException {
        zzbm(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbjq
    public final void zzd(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzbm(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbjq
    public final void zze(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        parcelZza.writeInt(i);
        zzbm(5, parcelZza);
    }
}
