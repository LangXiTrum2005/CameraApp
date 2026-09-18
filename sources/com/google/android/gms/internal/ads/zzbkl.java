package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbkl extends zzayg implements zzbkn {
    zzbkl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbkn
    public final void zze(zzbkd zzbkdVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, zzbkdVar);
        zzbm(1, parcelZza);
    }
}
