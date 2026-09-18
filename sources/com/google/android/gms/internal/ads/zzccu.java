package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzccu extends zzayg implements zzccw {
    zzccu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGeneratorCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzccw
    public final zzcct zze(IObjectWrapper iObjectWrapper, zzbsv zzbsvVar, int i) throws RemoteException {
        zzcct zzccrVar;
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, zzbsvVar);
        parcelZza.writeInt(240304000);
        Parcel parcelZzbl = zzbl(2, parcelZza);
        IBinder strongBinder = parcelZzbl.readStrongBinder();
        if (strongBinder == null) {
            zzccrVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGenerator");
            zzccrVar = iInterfaceQueryLocalInterface instanceof zzcct ? (zzcct) iInterfaceQueryLocalInterface : new zzccr(strongBinder);
        }
        parcelZzbl.recycle();
        return zzccrVar;
    }
}
