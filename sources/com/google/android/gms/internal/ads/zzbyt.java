package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbyt extends zzayh implements zzbyu {
    public zzbyt() {
        super("com.google.android.gms.ads.internal.request.IAdsService");
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    protected final boolean zzbO(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbyx zzbyvVar = null;
        if (i == 1) {
            zzbyi zzbyiVar = (zzbyi) zzayi.zza(parcel, zzbyi.CREATOR);
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                zzbyvVar = iInterfaceQueryLocalInterface instanceof zzbyx ? (zzbyx) iInterfaceQueryLocalInterface : new zzbyv(strongBinder);
            }
            zzayi.zzc(parcel);
            zzf(zzbyiVar, zzbyvVar);
        } else if (i == 2) {
            IBinder strongBinder2 = parcel.readStrongBinder();
            if (strongBinder2 != null) {
                IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                if (iInterfaceQueryLocalInterface2 instanceof zzbyx) {
                }
            }
            zzayi.zzc(parcel);
        } else {
            if (i != 3) {
                return false;
            }
            zzbym zzbymVar = (zzbym) zzayi.zza(parcel, zzbym.CREATOR);
            IBinder strongBinder3 = parcel.readStrongBinder();
            if (strongBinder3 != null) {
                IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                zzbyvVar = iInterfaceQueryLocalInterface3 instanceof zzbyx ? (zzbyx) iInterfaceQueryLocalInterface3 : new zzbyv(strongBinder3);
            }
            zzayi.zzc(parcel);
            zze(zzbymVar, zzbyvVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
