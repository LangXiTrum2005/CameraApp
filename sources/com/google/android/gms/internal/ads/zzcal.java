package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcal extends zzayg implements zzcan {
    zzcal(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final Bundle zzb() throws RemoteException {
        Parcel parcelZzbl = zzbl(9, zza());
        Bundle bundle = (Bundle) zzayi.zza(parcelZzbl, Bundle.CREATOR);
        parcelZzbl.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final com.google.android.gms.ads.internal.client.zzdn zzc() throws RemoteException {
        Parcel parcelZzbl = zzbl(12, zza());
        com.google.android.gms.ads.internal.client.zzdn zzdnVarZzb = com.google.android.gms.ads.internal.client.zzdm.zzb(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return zzdnVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final zzcak zzd() throws RemoteException {
        zzcak zzcaiVar;
        Parcel parcelZzbl = zzbl(11, zza());
        IBinder strongBinder = parcelZzbl.readStrongBinder();
        if (strongBinder == null) {
            zzcaiVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
            zzcaiVar = iInterfaceQueryLocalInterface instanceof zzcak ? (zzcak) iInterfaceQueryLocalInterface : new zzcai(strongBinder);
        }
        parcelZzbl.recycle();
        return zzcaiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final String zze() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzf(com.google.android.gms.ads.internal.client.zzl zzlVar, zzcau zzcauVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, zzlVar);
        zzayi.zzf(parcelZza, zzcauVar);
        zzbm(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzg(com.google.android.gms.ads.internal.client.zzl zzlVar, zzcau zzcauVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, zzlVar);
        zzayi.zzf(parcelZza, zzcauVar);
        zzbm(14, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzh(boolean z) throws RemoteException {
        Parcel parcelZza = zza();
        int i = zzayi.zza;
        parcelZza.writeInt(z ? 1 : 0);
        zzbm(15, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzi(com.google.android.gms.ads.internal.client.zzdd zzddVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, zzddVar);
        zzbm(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzj(com.google.android.gms.ads.internal.client.zzdg zzdgVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, zzdgVar);
        zzbm(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzk(zzcaq zzcaqVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, zzcaqVar);
        zzbm(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzl(zzcbb zzcbbVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, zzcbbVar);
        zzbm(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzbm(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzn(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final boolean zzo() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcan
    public final void zzp(zzcav zzcavVar) throws RemoteException {
        throw null;
    }
}
