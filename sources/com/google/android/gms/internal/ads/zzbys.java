package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbys extends zzayg implements zzbyu {
    zzbys(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdsService");
    }

    @Override // com.google.android.gms.internal.ads.zzbyu
    public final void zze(zzbym zzbymVar, zzbyx zzbyxVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, zzbymVar);
        zzayi.zzf(parcelZza, zzbyxVar);
        zzbm(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyu
    public final void zzf(zzbyi zzbyiVar, zzbyx zzbyxVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, zzbyiVar);
        zzayi.zzf(parcelZza, zzbyxVar);
        zzbm(1, parcelZza);
    }
}
