package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbuq extends zzayg implements zzbus {
    zzbuq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final com.google.android.gms.ads.internal.client.zzdq zze() throws RemoteException {
        Parcel parcelZzbl = zzbl(5, zza());
        com.google.android.gms.ads.internal.client.zzdq zzdqVarZzb = com.google.android.gms.ads.internal.client.zzdp.zzb(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return zzdqVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final zzbvg zzf() throws RemoteException {
        Parcel parcelZzbl = zzbl(2, zza());
        zzbvg zzbvgVar = (zzbvg) zzayi.zza(parcelZzbl, zzbvg.CREATOR);
        parcelZzbl.recycle();
        return zzbvgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final zzbvg zzg() throws RemoteException {
        Parcel parcelZzbl = zzbl(3, zza());
        zzbvg zzbvgVar = (zzbvg) zzayi.zza(parcelZzbl, zzbvg.CREATOR);
        parcelZzbl.recycle();
        return zzbvgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final void zzh(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, com.google.android.gms.ads.internal.client.zzq zzqVar, zzbuv zzbuvVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        zzayi.zzd(parcelZza, bundle);
        zzayi.zzd(parcelZza, bundle2);
        zzayi.zzd(parcelZza, zzqVar);
        zzayi.zzf(parcelZza, zzbuvVar);
        zzbm(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final void zzi(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbud zzbudVar, zzbtb zzbtbVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzayi.zzd(parcelZza, zzlVar);
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, zzbudVar);
        zzayi.zzf(parcelZza, zzbtbVar);
        zzbm(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final void zzj(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbug zzbugVar, zzbtb zzbtbVar, com.google.android.gms.ads.internal.client.zzq zzqVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzayi.zzd(parcelZza, zzlVar);
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, zzbugVar);
        zzayi.zzf(parcelZza, zzbtbVar);
        zzayi.zzd(parcelZza, zzqVar);
        zzbm(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final void zzk(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbug zzbugVar, zzbtb zzbtbVar, com.google.android.gms.ads.internal.client.zzq zzqVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzayi.zzd(parcelZza, zzlVar);
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, zzbugVar);
        zzayi.zzf(parcelZza, zzbtbVar);
        zzayi.zzd(parcelZza, zzqVar);
        zzbm(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final void zzl(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbuj zzbujVar, zzbtb zzbtbVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzayi.zzd(parcelZza, zzlVar);
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, zzbujVar);
        zzayi.zzf(parcelZza, zzbtbVar);
        zzbm(14, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final void zzm(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbum zzbumVar, zzbtb zzbtbVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzayi.zzd(parcelZza, zzlVar);
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, zzbumVar);
        zzayi.zzf(parcelZza, zzbtbVar);
        zzbm(18, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final void zzn(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbum zzbumVar, zzbtb zzbtbVar, zzbjb zzbjbVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzayi.zzd(parcelZza, zzlVar);
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, zzbumVar);
        zzayi.zzf(parcelZza, zzbtbVar);
        zzayi.zzd(parcelZza, zzbjbVar);
        zzbm(22, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final void zzo(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbup zzbupVar, zzbtb zzbtbVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzayi.zzd(parcelZza, zzlVar);
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, zzbupVar);
        zzayi.zzf(parcelZza, zzbtbVar);
        zzbm(20, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final void zzp(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbup zzbupVar, zzbtb zzbtbVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzayi.zzd(parcelZza, zzlVar);
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, zzbupVar);
        zzayi.zzf(parcelZza, zzbtbVar);
        zzbm(16, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final void zzq(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzbm(19, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        Parcel parcelZzbl = zzbl(24, parcelZza);
        boolean zZzg = zzayi.zzg(parcelZzbl);
        parcelZzbl.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        Parcel parcelZzbl = zzbl(15, parcelZza);
        boolean zZzg = zzayi.zzg(parcelZzbl);
        parcelZzbl.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbus
    public final boolean zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        Parcel parcelZzbl = zzbl(17, parcelZza);
        boolean zZzg = zzayi.zzg(parcelZzbl);
        parcelZzbl.recycle();
        return zZzg;
    }
}
