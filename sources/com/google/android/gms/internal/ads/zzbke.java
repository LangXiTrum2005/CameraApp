package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbke extends zzayg implements zzbkg {
    zzbke(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final com.google.android.gms.ads.internal.client.zzdq zze() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final zzbjj zzf() throws RemoteException {
        zzbjj zzbjhVar;
        Parcel parcelZzbl = zzbl(16, zza());
        IBinder strongBinder = parcelZzbl.readStrongBinder();
        if (strongBinder == null) {
            zzbjhVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
            zzbjhVar = iInterfaceQueryLocalInterface instanceof zzbjj ? (zzbjj) iInterfaceQueryLocalInterface : new zzbjh(strongBinder);
        }
        parcelZzbl.recycle();
        return zzbjhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final zzbjm zzg(String str) throws RemoteException {
        zzbjm zzbjkVar;
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzbl = zzbl(2, parcelZza);
        IBinder strongBinder = parcelZzbl.readStrongBinder();
        if (strongBinder == null) {
            zzbjkVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            zzbjkVar = iInterfaceQueryLocalInterface instanceof zzbjm ? (zzbjm) iInterfaceQueryLocalInterface : new zzbjk(strongBinder);
        }
        parcelZzbl.recycle();
        return zzbjkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final IObjectWrapper zzh() throws RemoteException {
        Parcel parcelZzbl = zzbl(9, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final String zzi() throws RemoteException {
        Parcel parcelZzbl = zzbl(4, zza());
        String string = parcelZzbl.readString();
        parcelZzbl.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final String zzj(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzbl = zzbl(1, parcelZza);
        String string = parcelZzbl.readString();
        parcelZzbl.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final List zzk() throws RemoteException {
        Parcel parcelZzbl = zzbl(3, zza());
        ArrayList<String> arrayListCreateStringArrayList = parcelZzbl.createStringArrayList();
        parcelZzbl.recycle();
        return arrayListCreateStringArrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final void zzl() throws RemoteException {
        zzbm(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final void zzm() throws RemoteException {
        zzbm(15, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final void zzn(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzbm(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final void zzo() throws RemoteException {
        zzbm(6, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final void zzp(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzbm(14, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final boolean zzq() throws RemoteException {
        Parcel parcelZzbl = zzbl(12, zza());
        boolean zZzg = zzayi.zzg(parcelZzbl);
        parcelZzbl.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        Parcel parcelZzbl = zzbl(17, parcelZza);
        boolean zZzg = zzayi.zzg(parcelZzbl);
        parcelZzbl.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        Parcel parcelZzbl = zzbl(10, parcelZza);
        boolean zZzg = zzayi.zzg(parcelZzbl);
        parcelZzbl.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbkg
    public final boolean zzt() throws RemoteException {
        Parcel parcelZzbl = zzbl(13, zza());
        boolean zZzg = zzayi.zzg(parcelZzbl);
        parcelZzbl.recycle();
        return zZzg;
    }
}
