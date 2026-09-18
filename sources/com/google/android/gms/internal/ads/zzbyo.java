package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbyo extends zzayg implements zzbyq {
    zzbyo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzbyq
    public final void zze(zzbze zzbzeVar, zzbza zzbzaVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, zzbzeVar);
        zzayi.zzf(parcelZza, zzbzaVar);
        zzbm(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyq
    public final void zzf(zzbze zzbzeVar, zzbza zzbzaVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, zzbzeVar);
        zzayi.zzf(parcelZza, zzbzaVar);
        zzbm(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyq
    public final void zzg(zzbze zzbzeVar, zzbza zzbzaVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, zzbzeVar);
        zzayi.zzf(parcelZza, zzbzaVar);
        zzbm(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyq
    public final void zzh(String str, zzbza zzbzaVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzayi.zzf(parcelZza, zzbzaVar);
        zzbm(7, parcelZza);
    }
}
