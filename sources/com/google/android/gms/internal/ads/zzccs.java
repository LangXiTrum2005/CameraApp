package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzccs extends zzayh implements zzcct {
    public zzccs() {
        super("com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    public static zzcct zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGenerator");
        return iInterfaceQueryLocalInterface instanceof zzcct ? (zzcct) iInterfaceQueryLocalInterface : new zzccr(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    protected final boolean zzbO(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzccq zzccoVar = null;
        switch (i) {
            case 1:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzccx zzccxVar = (zzccx) zzayi.zza(parcel, zzccx.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalCallback");
                    zzccoVar = iInterfaceQueryLocalInterface instanceof zzccq ? (zzccq) iInterfaceQueryLocalInterface : new zzcco(strongBinder);
                }
                zzayi.zzc(parcel);
                zzf(iObjectWrapperAsInterface, zzccxVar, zzccoVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                zzk(iObjectWrapperAsInterface2);
                parcel2.writeNoException();
                return true;
            case 3:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                parcel2.writeNoException();
                zzayi.zzf(parcel2, null);
                return true;
            case 4:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                parcel2.writeNoException();
                zzayi.zzf(parcel2, null);
                return true;
            case 5:
                ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper iObjectWrapperAsInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbxi zzbxiVarZzb = zzbxh.zzb(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                zzm(arrayListCreateTypedArrayList, iObjectWrapperAsInterface3, zzbxiVarZzb);
                parcel2.writeNoException();
                return true;
            case 6:
                ArrayList arrayListCreateTypedArrayList2 = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper iObjectWrapperAsInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbxi zzbxiVarZzb2 = zzbxh.zzb(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                zzl(arrayListCreateTypedArrayList2, iObjectWrapperAsInterface4, zzbxiVarZzb2);
                parcel2.writeNoException();
                return true;
            case 7:
                zzbxr zzbxrVar = (zzbxr) zzayi.zza(parcel, zzbxr.CREATOR);
                zzayi.zzc(parcel);
                zzg(zzbxrVar);
                parcel2.writeNoException();
                return true;
            case 8:
                IObjectWrapper iObjectWrapperAsInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                zzj(iObjectWrapperAsInterface5);
                parcel2.writeNoException();
                return true;
            case 9:
                ArrayList arrayListCreateTypedArrayList3 = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper iObjectWrapperAsInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbxi zzbxiVarZzb3 = zzbxh.zzb(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                zzi(arrayListCreateTypedArrayList3, iObjectWrapperAsInterface6, zzbxiVarZzb3);
                parcel2.writeNoException();
                return true;
            case 10:
                ArrayList arrayListCreateTypedArrayList4 = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper iObjectWrapperAsInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbxi zzbxiVarZzb4 = zzbxh.zzb(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                zzh(arrayListCreateTypedArrayList4, iObjectWrapperAsInterface7, zzbxiVarZzb4);
                parcel2.writeNoException();
                return true;
            case 11:
                IObjectWrapper iObjectWrapperAsInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String string = parcel.readString();
                IObjectWrapper iObjectWrapperAsInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                IObjectWrapper iObjectWrapperZze = zze(iObjectWrapperAsInterface8, iObjectWrapperAsInterface9, string, iObjectWrapperAsInterface10);
                parcel2.writeNoException();
                zzayi.zzf(parcel2, iObjectWrapperZze);
                return true;
            default:
                return false;
        }
    }
}
