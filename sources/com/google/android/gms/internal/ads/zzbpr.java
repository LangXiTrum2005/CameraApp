package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbpr extends zzayh implements zzbps {
    public zzbpr() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    protected final boolean zzbO(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbpv zzbptVar;
        if (i == 3) {
            com.google.android.gms.ads.internal.client.zzdq zzdqVarZzb = zzb();
            parcel2.writeNoException();
            zzayi.zzf(parcel2, zzdqVarZzb);
            return true;
        }
        if (i == 4) {
            zzd();
            parcel2.writeNoException();
            return true;
        }
        if (i == 5) {
            IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                zzbptVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
                zzbptVar = iInterfaceQueryLocalInterface instanceof zzbpv ? (zzbpv) iInterfaceQueryLocalInterface : new zzbpt(strongBinder);
            }
            zzayi.zzc(parcel);
            zzf(iObjectWrapperAsInterface, zzbptVar);
            parcel2.writeNoException();
            return true;
        }
        if (i == 6) {
            IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzayi.zzc(parcel);
            zze(iObjectWrapperAsInterface2);
            parcel2.writeNoException();
            return true;
        }
        if (i != 7) {
            return false;
        }
        zzbjj zzbjjVarZzc = zzc();
        parcel2.writeNoException();
        zzayi.zzf(parcel2, zzbjjVarZzc);
        return true;
    }
}
