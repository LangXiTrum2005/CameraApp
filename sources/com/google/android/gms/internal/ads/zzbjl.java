package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbjl extends zzayh implements zzbjm {
    public zzbjl() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public static zzbjm zzg(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        return iInterfaceQueryLocalInterface instanceof zzbjm ? (zzbjm) iInterfaceQueryLocalInterface : new zzbjk(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    protected final boolean zzbO(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            IObjectWrapper iObjectWrapperZzf = zzf();
            parcel2.writeNoException();
            zzayi.zzf(parcel2, iObjectWrapperZzf);
        } else if (i == 2) {
            Uri uriZze = zze();
            parcel2.writeNoException();
            zzayi.zze(parcel2, uriZze);
        } else if (i == 3) {
            double dZzb = zzb();
            parcel2.writeNoException();
            parcel2.writeDouble(dZzb);
        } else if (i == 4) {
            int iZzd = zzd();
            parcel2.writeNoException();
            parcel2.writeInt(iZzd);
        } else {
            if (i != 5) {
                return false;
            }
            int iZzc = zzc();
            parcel2.writeNoException();
            parcel2.writeInt(iZzc);
        }
        return true;
    }
}
