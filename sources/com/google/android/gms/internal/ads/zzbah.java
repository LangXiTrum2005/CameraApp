package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbah extends zzayg implements zzbaj {
    zzbah(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbaj
    public final com.google.android.gms.ads.internal.client.zzbu zze() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbaj
    public final com.google.android.gms.ads.internal.client.zzdn zzf() throws RemoteException {
        Parcel parcelZzbl = zzbl(5, zza());
        com.google.android.gms.ads.internal.client.zzdn zzdnVarZzb = com.google.android.gms.ads.internal.client.zzdm.zzb(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return zzdnVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbaj
    public final void zzg(boolean z) throws RemoteException {
        Parcel parcelZza = zza();
        int i = zzayi.zza;
        parcelZza.writeInt(z ? 1 : 0);
        zzbm(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbaj
    public final void zzh(com.google.android.gms.ads.internal.client.zzdg zzdgVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, zzdgVar);
        zzbm(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbaj
    public final void zzi(IObjectWrapper iObjectWrapper, zzbaq zzbaqVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, zzbaqVar);
        zzbm(4, parcelZza);
    }
}
