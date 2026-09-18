package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbyp extends zzayh implements zzbyq {
    public zzbyp() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    protected final boolean zzbO(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbza zzbyyVar = null;
        if (i == 1) {
            zzayi.zzc(parcel);
            parcel2.writeNoException();
            zzayi.zze(parcel2, null);
        } else if (i == 2) {
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                if (iInterfaceQueryLocalInterface instanceof zzbyr) {
                }
            }
            zzayi.zzc(parcel);
            parcel2.writeNoException();
        } else if (i == 4) {
            zzbze zzbzeVar = (zzbze) zzayi.zza(parcel, zzbze.CREATOR);
            IBinder strongBinder2 = parcel.readStrongBinder();
            if (strongBinder2 != null) {
                IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                zzbyyVar = iInterfaceQueryLocalInterface2 instanceof zzbza ? (zzbza) iInterfaceQueryLocalInterface2 : new zzbyy(strongBinder2);
            }
            zzayi.zzc(parcel);
            zzg(zzbzeVar, zzbyyVar);
            parcel2.writeNoException();
        } else if (i == 5) {
            zzbze zzbzeVar2 = (zzbze) zzayi.zza(parcel, zzbze.CREATOR);
            IBinder strongBinder3 = parcel.readStrongBinder();
            if (strongBinder3 != null) {
                IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                zzbyyVar = iInterfaceQueryLocalInterface3 instanceof zzbza ? (zzbza) iInterfaceQueryLocalInterface3 : new zzbyy(strongBinder3);
            }
            zzayi.zzc(parcel);
            zzf(zzbzeVar2, zzbyyVar);
            parcel2.writeNoException();
        } else if (i == 6) {
            zzbze zzbzeVar3 = (zzbze) zzayi.zza(parcel, zzbze.CREATOR);
            IBinder strongBinder4 = parcel.readStrongBinder();
            if (strongBinder4 != null) {
                IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                zzbyyVar = iInterfaceQueryLocalInterface4 instanceof zzbza ? (zzbza) iInterfaceQueryLocalInterface4 : new zzbyy(strongBinder4);
            }
            zzayi.zzc(parcel);
            zze(zzbzeVar3, zzbyyVar);
            parcel2.writeNoException();
        } else {
            if (i != 7) {
                return false;
            }
            String string = parcel.readString();
            IBinder strongBinder5 = parcel.readStrongBinder();
            if (strongBinder5 != null) {
                IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                zzbyyVar = iInterfaceQueryLocalInterface5 instanceof zzbza ? (zzbza) iInterfaceQueryLocalInterface5 : new zzbyy(strongBinder5);
            }
            zzayi.zzc(parcel);
            zzh(string, zzbyyVar);
            parcel2.writeNoException();
        }
        return true;
    }
}
