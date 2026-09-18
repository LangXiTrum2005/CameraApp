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
public final class zzblh extends zzayg implements zzblj {
    zzblh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final void zzA() throws RemoteException {
        zzbm(28, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final void zzB(Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, bundle);
        zzbm(17, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final void zzC() throws RemoteException {
        zzbm(27, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final void zzD(com.google.android.gms.ads.internal.client.zzcs zzcsVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, zzcsVar);
        zzbm(26, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final void zzE(com.google.android.gms.ads.internal.client.zzdg zzdgVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, zzdgVar);
        zzbm(32, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final void zzF(zzblg zzblgVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, zzblgVar);
        zzbm(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final boolean zzG() throws RemoteException {
        Parcel parcelZzbl = zzbl(30, zza());
        boolean zZzg = zzayi.zzg(parcelZzbl);
        parcelZzbl.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final boolean zzH() throws RemoteException {
        Parcel parcelZzbl = zzbl(24, zza());
        boolean zZzg = zzayi.zzg(parcelZzbl);
        parcelZzbl.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final boolean zzI(Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, bundle);
        Parcel parcelZzbl = zzbl(16, parcelZza);
        boolean zZzg = zzayi.zzg(parcelZzbl);
        parcelZzbl.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final double zze() throws RemoteException {
        Parcel parcelZzbl = zzbl(8, zza());
        double d = parcelZzbl.readDouble();
        parcelZzbl.recycle();
        return d;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final Bundle zzf() throws RemoteException {
        Parcel parcelZzbl = zzbl(20, zza());
        Bundle bundle = (Bundle) zzayi.zza(parcelZzbl, Bundle.CREATOR);
        parcelZzbl.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final com.google.android.gms.ads.internal.client.zzdn zzg() throws RemoteException {
        Parcel parcelZzbl = zzbl(31, zza());
        com.google.android.gms.ads.internal.client.zzdn zzdnVarZzb = com.google.android.gms.ads.internal.client.zzdm.zzb(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return zzdnVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final com.google.android.gms.ads.internal.client.zzdq zzh() throws RemoteException {
        Parcel parcelZzbl = zzbl(11, zza());
        com.google.android.gms.ads.internal.client.zzdq zzdqVarZzb = com.google.android.gms.ads.internal.client.zzdp.zzb(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return zzdqVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final zzbjf zzi() throws RemoteException {
        zzbjf zzbjdVar;
        Parcel parcelZzbl = zzbl(14, zza());
        IBinder strongBinder = parcelZzbl.readStrongBinder();
        if (strongBinder == null) {
            zzbjdVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
            zzbjdVar = iInterfaceQueryLocalInterface instanceof zzbjf ? (zzbjf) iInterfaceQueryLocalInterface : new zzbjd(strongBinder);
        }
        parcelZzbl.recycle();
        return zzbjdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final zzbjj zzj() throws RemoteException {
        zzbjj zzbjhVar;
        Parcel parcelZzbl = zzbl(29, zza());
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

    @Override // com.google.android.gms.internal.ads.zzblj
    public final zzbjm zzk() throws RemoteException {
        zzbjm zzbjkVar;
        Parcel parcelZzbl = zzbl(5, zza());
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

    @Override // com.google.android.gms.internal.ads.zzblj
    public final IObjectWrapper zzl() throws RemoteException {
        Parcel parcelZzbl = zzbl(19, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final IObjectWrapper zzm() throws RemoteException {
        Parcel parcelZzbl = zzbl(18, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final String zzn() throws RemoteException {
        Parcel parcelZzbl = zzbl(7, zza());
        String string = parcelZzbl.readString();
        parcelZzbl.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final String zzo() throws RemoteException {
        Parcel parcelZzbl = zzbl(4, zza());
        String string = parcelZzbl.readString();
        parcelZzbl.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final String zzp() throws RemoteException {
        Parcel parcelZzbl = zzbl(6, zza());
        String string = parcelZzbl.readString();
        parcelZzbl.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final String zzq() throws RemoteException {
        Parcel parcelZzbl = zzbl(2, zza());
        String string = parcelZzbl.readString();
        parcelZzbl.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final String zzr() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final String zzs() throws RemoteException {
        Parcel parcelZzbl = zzbl(10, zza());
        String string = parcelZzbl.readString();
        parcelZzbl.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final String zzt() throws RemoteException {
        Parcel parcelZzbl = zzbl(9, zza());
        String string = parcelZzbl.readString();
        parcelZzbl.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final List zzu() throws RemoteException {
        Parcel parcelZzbl = zzbl(3, zza());
        ArrayList arrayListZzb = zzayi.zzb(parcelZzbl);
        parcelZzbl.recycle();
        return arrayListZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final List zzv() throws RemoteException {
        Parcel parcelZzbl = zzbl(23, zza());
        ArrayList arrayListZzb = zzayi.zzb(parcelZzbl);
        parcelZzbl.recycle();
        return arrayListZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final void zzw() throws RemoteException {
        zzbm(22, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final void zzx() throws RemoteException {
        zzbm(13, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final void zzy(com.google.android.gms.ads.internal.client.zzcw zzcwVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, zzcwVar);
        zzbm(25, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzblj
    public final void zzz(Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, bundle);
        zzbm(15, parcelZza);
    }
}
