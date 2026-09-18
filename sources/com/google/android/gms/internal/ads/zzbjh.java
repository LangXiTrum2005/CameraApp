package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbjh extends zzayg implements zzbjj {
    zzbjh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final float zze() throws RemoteException {
        Parcel parcelZzbl = zzbl(2, zza());
        float f = parcelZzbl.readFloat();
        parcelZzbl.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final float zzf() throws RemoteException {
        Parcel parcelZzbl = zzbl(6, zza());
        float f = parcelZzbl.readFloat();
        parcelZzbl.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final float zzg() throws RemoteException {
        Parcel parcelZzbl = zzbl(5, zza());
        float f = parcelZzbl.readFloat();
        parcelZzbl.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final com.google.android.gms.ads.internal.client.zzdq zzh() throws RemoteException {
        Parcel parcelZzbl = zzbl(7, zza());
        com.google.android.gms.ads.internal.client.zzdq zzdqVarZzb = com.google.android.gms.ads.internal.client.zzdp.zzb(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return zzdqVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final IObjectWrapper zzi() throws RemoteException {
        Parcel parcelZzbl = zzbl(4, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzbm(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final boolean zzk() throws RemoteException {
        Parcel parcelZzbl = zzbl(10, zza());
        boolean zZzg = zzayi.zzg(parcelZzbl);
        parcelZzbl.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final boolean zzl() throws RemoteException {
        Parcel parcelZzbl = zzbl(8, zza());
        boolean zZzg = zzayi.zzg(parcelZzbl);
        parcelZzbl.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final void zzm(zzbku zzbkuVar) throws RemoteException {
        throw null;
    }
}
