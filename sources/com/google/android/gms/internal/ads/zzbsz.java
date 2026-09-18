package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbsz extends zzayg implements zzbtb {
    zzbsz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zze() throws RemoteException {
        zzbm(1, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzf() throws RemoteException {
        zzbm(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzg(int i) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzbm(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzh(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, zzeVar);
        zzbm(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzi(int i, String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        parcelZza.writeString(str);
        zzbm(22, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzj(int i) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzk(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, zzeVar);
        zzbm(24, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzl(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzbm(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzm() throws RemoteException {
        zzbm(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzn() throws RemoteException {
        zzbm(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzo() throws RemoteException {
        zzbm(6, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzp() throws RemoteException {
        zzbm(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzq(String str, String str2) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzbm(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzr(zzbkg zzbkgVar, String str) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, zzbkgVar);
        parcelZza.writeString(str);
        zzbm(10, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzs(zzcag zzcagVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzt(zzcak zzcakVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, zzcakVar);
        zzbm(16, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzu() throws RemoteException {
        zzbm(18, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzv() throws RemoteException {
        zzbm(11, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzw() throws RemoteException {
        zzbm(15, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzx() throws RemoteException {
        zzbm(20, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbtb
    public final void zzy() throws RemoteException {
        zzbm(13, zza());
    }
}
