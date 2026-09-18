package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbsw extends zzayg implements zzbsy {
    zzbsw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzA(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzbtb zzbtbVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzd(parcelZza, zzlVar);
        parcelZza.writeString(str);
        zzayi.zzf(parcelZza, zzbtbVar);
        zzbm(28, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzB(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, String str2) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzC(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzbtb zzbtbVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzd(parcelZza, zzlVar);
        parcelZza.writeString(str);
        zzayi.zzf(parcelZza, zzbtbVar);
        zzbm(32, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzD(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzbm(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzE() throws RemoteException {
        zzbm(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzF() throws RemoteException {
        zzbm(9, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzG(boolean z) throws RemoteException {
        Parcel parcelZza = zza();
        int i = zzayi.zza;
        parcelZza.writeInt(z ? 1 : 0);
        zzbm(25, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzH(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzbm(39, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzI() throws RemoteException {
        zzbm(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzJ(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzbm(37, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzK(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzbm(30, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzL() throws RemoteException {
        zzbm(12, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final boolean zzM() throws RemoteException {
        Parcel parcelZzbl = zzbl(22, zza());
        boolean zZzg = zzayi.zzg(parcelZzbl);
        parcelZzbl.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final boolean zzN() throws RemoteException {
        Parcel parcelZzbl = zzbl(13, zza());
        boolean zZzg = zzayi.zzg(parcelZzbl);
        parcelZzbl.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final zzbtg zzO() throws RemoteException {
        zzbtg zzbtgVar;
        Parcel parcelZzbl = zzbl(15, zza());
        IBinder strongBinder = parcelZzbl.readStrongBinder();
        if (strongBinder == null) {
            zzbtgVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            zzbtgVar = iInterfaceQueryLocalInterface instanceof zzbtg ? (zzbtg) iInterfaceQueryLocalInterface : new zzbtg(strongBinder);
        }
        parcelZzbl.recycle();
        return zzbtgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final zzbth zzP() throws RemoteException {
        zzbth zzbthVar;
        Parcel parcelZzbl = zzbl(16, zza());
        IBinder strongBinder = parcelZzbl.readStrongBinder();
        if (strongBinder == null) {
            zzbthVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            zzbthVar = iInterfaceQueryLocalInterface instanceof zzbth ? (zzbth) iInterfaceQueryLocalInterface : new zzbth(strongBinder);
        }
        parcelZzbl.recycle();
        return zzbthVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final Bundle zze() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final Bundle zzf() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final Bundle zzg() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final com.google.android.gms.ads.internal.client.zzdq zzh() throws RemoteException {
        Parcel parcelZzbl = zzbl(26, zza());
        com.google.android.gms.ads.internal.client.zzdq zzdqVarZzb = com.google.android.gms.ads.internal.client.zzdp.zzb(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return zzdqVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final zzbkg zzi() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final zzbte zzj() throws RemoteException {
        zzbte zzbtcVar;
        Parcel parcelZzbl = zzbl(36, zza());
        IBinder strongBinder = parcelZzbl.readStrongBinder();
        if (strongBinder == null) {
            zzbtcVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
            zzbtcVar = iInterfaceQueryLocalInterface instanceof zzbte ? (zzbte) iInterfaceQueryLocalInterface : new zzbtc(strongBinder);
        }
        parcelZzbl.recycle();
        return zzbtcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final zzbtk zzk() throws RemoteException {
        zzbtk zzbtiVar;
        Parcel parcelZzbl = zzbl(27, zza());
        IBinder strongBinder = parcelZzbl.readStrongBinder();
        if (strongBinder == null) {
            zzbtiVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
            zzbtiVar = iInterfaceQueryLocalInterface instanceof zzbtk ? (zzbtk) iInterfaceQueryLocalInterface : new zzbti(strongBinder);
        }
        parcelZzbl.recycle();
        return zzbtiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final zzbvg zzl() throws RemoteException {
        Parcel parcelZzbl = zzbl(33, zza());
        zzbvg zzbvgVar = (zzbvg) zzayi.zza(parcelZzbl, zzbvg.CREATOR);
        parcelZzbl.recycle();
        return zzbvgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final zzbvg zzm() throws RemoteException {
        Parcel parcelZzbl = zzbl(34, zza());
        zzbvg zzbvgVar = (zzbvg) zzayi.zza(parcelZzbl, zzbvg.CREATOR);
        parcelZzbl.recycle();
        return zzbvgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final IObjectWrapper zzn() throws RemoteException {
        Parcel parcelZzbl = zzbl(2, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzo() throws RemoteException {
        zzbm(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzp(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzcaf zzcafVar, String str2) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzd(parcelZza, zzlVar);
        parcelZza.writeString(null);
        zzayi.zzf(parcelZza, zzcafVar);
        parcelZza.writeString(str2);
        zzbm(10, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzq(IObjectWrapper iObjectWrapper, zzbph zzbphVar, List list) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, zzbphVar);
        parcelZza.writeTypedList(list);
        zzbm(31, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzr(IObjectWrapper iObjectWrapper, zzcaf zzcafVar, List list) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, zzcafVar);
        parcelZza.writeStringList(list);
        zzbm(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzs(com.google.android.gms.ads.internal.client.zzl zzlVar, String str) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzd(parcelZza, zzlVar);
        parcelZza.writeString(str);
        zzbm(11, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzt(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzbtb zzbtbVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzd(parcelZza, zzlVar);
        parcelZza.writeString(str);
        zzayi.zzf(parcelZza, zzbtbVar);
        zzbm(38, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzu(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzbtb zzbtbVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzv(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, String str2, zzbtb zzbtbVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzd(parcelZza, zzqVar);
        zzayi.zzd(parcelZza, zzlVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzayi.zzf(parcelZza, zzbtbVar);
        zzbm(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzw(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, String str2, zzbtb zzbtbVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzd(parcelZza, zzqVar);
        zzayi.zzd(parcelZza, zzlVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzayi.zzf(parcelZza, zzbtbVar);
        zzbm(35, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzx(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzbtb zzbtbVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzy(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, String str2, zzbtb zzbtbVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzd(parcelZza, zzlVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzayi.zzf(parcelZza, zzbtbVar);
        zzbm(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zzz(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, String str2, zzbtb zzbtbVar, zzbjb zzbjbVar, List list) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzd(parcelZza, zzlVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzayi.zzf(parcelZza, zzbtbVar);
        zzayi.zzd(parcelZza, zzbjbVar);
        parcelZza.writeStringList(list);
        zzbm(14, parcelZza);
    }
}
