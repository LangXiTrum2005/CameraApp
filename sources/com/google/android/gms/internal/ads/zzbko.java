package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbko extends zzayg implements zzbkq {
    zzbko(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbkq
    public final void zze(zzbkg zzbkgVar, String str) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, zzbkgVar);
        parcelZza.writeString(str);
        zzbm(1, parcelZza);
    }
}
