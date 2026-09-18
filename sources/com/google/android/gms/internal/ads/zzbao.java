package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbao extends zzayg implements zzbaq {
    zzbao(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbaq
    public final void zzb() throws RemoteException {
        zzbm(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbaq
    public final void zzc() throws RemoteException {
        zzbm(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbaq
    public final void zzd(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, zzeVar);
        zzbm(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbaq
    public final void zze() throws RemoteException {
        zzbm(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbaq
    public final void zzf() throws RemoteException {
        zzbm(1, zza());
    }
}
