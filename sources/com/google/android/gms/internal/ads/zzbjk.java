package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbjk extends zzayg implements zzbjm {
    zzbjk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    @Override // com.google.android.gms.internal.ads.zzbjm
    public final double zzb() throws RemoteException {
        Parcel parcelZzbl = zzbl(3, zza());
        double d = parcelZzbl.readDouble();
        parcelZzbl.recycle();
        return d;
    }

    @Override // com.google.android.gms.internal.ads.zzbjm
    public final int zzc() throws RemoteException {
        Parcel parcelZzbl = zzbl(5, zza());
        int i = parcelZzbl.readInt();
        parcelZzbl.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzbjm
    public final int zzd() throws RemoteException {
        Parcel parcelZzbl = zzbl(4, zza());
        int i = parcelZzbl.readInt();
        parcelZzbl.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzbjm
    public final Uri zze() throws RemoteException {
        Parcel parcelZzbl = zzbl(2, zza());
        Uri uri = (Uri) zzayi.zza(parcelZzbl, Uri.CREATOR);
        parcelZzbl.recycle();
        return uri;
    }

    @Override // com.google.android.gms.internal.ads.zzbjm
    public final IObjectWrapper zzf() throws RemoteException {
        Parcel parcelZzbl = zzbl(1, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return iObjectWrapperAsInterface;
    }
}
