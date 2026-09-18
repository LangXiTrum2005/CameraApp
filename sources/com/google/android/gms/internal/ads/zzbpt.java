package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbpt extends zzayg implements zzbpv {
    zzbpt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbpv
    public final void zze(int i) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzbm(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpv
    public final void zzf() throws RemoteException {
        zzbm(1, zza());
    }
}
