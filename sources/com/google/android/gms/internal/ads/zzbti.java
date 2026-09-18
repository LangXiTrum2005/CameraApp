package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbti extends zzayg implements zzbtk {
    zzbti(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final boolean zzA() throws RemoteException {
        Parcel parcelZzbl = zzbl(18, zza());
        boolean zZzg = zzayi.zzg(parcelZzbl);
        parcelZzbl.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final boolean zzB() throws RemoteException {
        Parcel parcelZzbl = zzbl(17, zza());
        boolean zZzg = zzayi.zzg(parcelZzbl);
        parcelZzbl.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final double zze() throws RemoteException {
        Parcel parcelZzbl = zzbl(8, zza());
        double d = parcelZzbl.readDouble();
        parcelZzbl.recycle();
        return d;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final float zzf() throws RemoteException {
        Parcel parcelZzbl = zzbl(23, zza());
        float f = parcelZzbl.readFloat();
        parcelZzbl.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final float zzg() throws RemoteException {
        Parcel parcelZzbl = zzbl(25, zza());
        float f = parcelZzbl.readFloat();
        parcelZzbl.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final float zzh() throws RemoteException {
        Parcel parcelZzbl = zzbl(24, zza());
        float f = parcelZzbl.readFloat();
        parcelZzbl.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final Bundle zzi() throws RemoteException {
        Parcel parcelZzbl = zzbl(16, zza());
        Bundle bundle = (Bundle) zzayi.zza(parcelZzbl, Bundle.CREATOR);
        parcelZzbl.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final com.google.android.gms.ads.internal.client.zzdq zzj() throws RemoteException {
        Parcel parcelZzbl = zzbl(11, zza());
        com.google.android.gms.ads.internal.client.zzdq zzdqVarZzb = com.google.android.gms.ads.internal.client.zzdp.zzb(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return zzdqVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final zzbjf zzk() throws RemoteException {
        Parcel parcelZzbl = zzbl(12, zza());
        zzbjf zzbjfVarZzj = zzbje.zzj(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return zzbjfVarZzj;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final zzbjm zzl() throws RemoteException {
        Parcel parcelZzbl = zzbl(5, zza());
        zzbjm zzbjmVarZzg = zzbjl.zzg(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return zzbjmVarZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final IObjectWrapper zzm() throws RemoteException {
        Parcel parcelZzbl = zzbl(13, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final IObjectWrapper zzn() throws RemoteException {
        Parcel parcelZzbl = zzbl(14, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final IObjectWrapper zzo() throws RemoteException {
        Parcel parcelZzbl = zzbl(15, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final String zzp() throws RemoteException {
        Parcel parcelZzbl = zzbl(7, zza());
        String string = parcelZzbl.readString();
        parcelZzbl.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final String zzq() throws RemoteException {
        Parcel parcelZzbl = zzbl(4, zza());
        String string = parcelZzbl.readString();
        parcelZzbl.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final String zzr() throws RemoteException {
        Parcel parcelZzbl = zzbl(6, zza());
        String string = parcelZzbl.readString();
        parcelZzbl.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final String zzs() throws RemoteException {
        Parcel parcelZzbl = zzbl(2, zza());
        String string = parcelZzbl.readString();
        parcelZzbl.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final String zzt() throws RemoteException {
        Parcel parcelZzbl = zzbl(10, zza());
        String string = parcelZzbl.readString();
        parcelZzbl.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final String zzu() throws RemoteException {
        Parcel parcelZzbl = zzbl(9, zza());
        String string = parcelZzbl.readString();
        parcelZzbl.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final List zzv() throws RemoteException {
        Parcel parcelZzbl = zzbl(3, zza());
        ArrayList arrayListZzb = zzayi.zzb(parcelZzbl);
        parcelZzbl.recycle();
        return arrayListZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzbm(20, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void zzx() throws RemoteException {
        zzbm(19, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void zzy(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, iObjectWrapper2);
        zzayi.zzf(parcelZza, iObjectWrapper3);
        zzbm(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void zzz(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzbm(22, parcelZza);
    }
}
