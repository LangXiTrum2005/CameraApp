package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfsu extends zzayg implements zzfsw {
    zzfsu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.clearcut.IGassClearcut");
    }

    @Override // com.google.android.gms.internal.ads.zzfsw
    public final void zze(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeString(null);
        zzbm(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzfsw
    public final void zzf() throws RemoteException {
        zzbm(3, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzfsw
    public final void zzg(int i) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzbm(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzfsw
    public final void zzh(int[] iArr) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeIntArray(null);
        zzbm(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzfsw
    public final void zzi(int i) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzbm(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzfsw
    public final void zzj(byte[] bArr) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeByteArray(bArr);
        zzbm(5, parcelZza);
    }
}
