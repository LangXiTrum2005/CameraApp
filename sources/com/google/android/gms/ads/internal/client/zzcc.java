package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzayg;
import com.google.android.gms.internal.ads.zzayi;
import com.google.android.gms.internal.ads.zzbjp;
import com.google.android.gms.internal.ads.zzbjq;
import com.google.android.gms.internal.ads.zzbjv;
import com.google.android.gms.internal.ads.zzbjw;
import com.google.android.gms.internal.ads.zzboe;
import com.google.android.gms.internal.ads.zzbog;
import com.google.android.gms.internal.ads.zzboh;
import com.google.android.gms.internal.ads.zzbsv;
import com.google.android.gms.internal.ads.zzbwl;
import com.google.android.gms.internal.ads.zzbwm;
import com.google.android.gms.internal.ads.zzbws;
import com.google.android.gms.internal.ads.zzbwt;
import com.google.android.gms.internal.ads.zzbzx;
import com.google.android.gms.internal.ads.zzcam;
import com.google.android.gms.internal.ads.zzcan;
import com.google.android.gms.internal.ads.zzccs;
import com.google.android.gms.internal.ads.zzcct;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzcc extends zzayg implements zzce {
    zzcc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbq zzb(IObjectWrapper iObjectWrapper, String str, zzbsv zzbsvVar, int i) throws RemoteException {
        zzbq zzboVar;
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        zzayi.zzf(parcelZza, zzbsvVar);
        parcelZza.writeInt(240304000);
        Parcel parcelZzbl = zzbl(3, parcelZza);
        IBinder strongBinder = parcelZzbl.readStrongBinder();
        if (strongBinder == null) {
            zzboVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            zzboVar = iInterfaceQueryLocalInterface instanceof zzbq ? (zzbq) iInterfaceQueryLocalInterface : new zzbo(strongBinder);
        }
        parcelZzbl.recycle();
        return zzboVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zzc(IObjectWrapper iObjectWrapper, zzq zzqVar, String str, zzbsv zzbsvVar, int i) throws RemoteException {
        zzbu zzbsVar;
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzd(parcelZza, zzqVar);
        parcelZza.writeString(str);
        zzayi.zzf(parcelZza, zzbsvVar);
        parcelZza.writeInt(240304000);
        Parcel parcelZzbl = zzbl(13, parcelZza);
        IBinder strongBinder = parcelZzbl.readStrongBinder();
        if (strongBinder == null) {
            zzbsVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbsVar = iInterfaceQueryLocalInterface instanceof zzbu ? (zzbu) iInterfaceQueryLocalInterface : new zzbs(strongBinder);
        }
        parcelZzbl.recycle();
        return zzbsVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zzd(IObjectWrapper iObjectWrapper, zzq zzqVar, String str, zzbsv zzbsvVar, int i) throws RemoteException {
        zzbu zzbsVar;
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzd(parcelZza, zzqVar);
        parcelZza.writeString(str);
        zzayi.zzf(parcelZza, zzbsvVar);
        parcelZza.writeInt(240304000);
        Parcel parcelZzbl = zzbl(1, parcelZza);
        IBinder strongBinder = parcelZzbl.readStrongBinder();
        if (strongBinder == null) {
            zzbsVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbsVar = iInterfaceQueryLocalInterface instanceof zzbu ? (zzbu) iInterfaceQueryLocalInterface : new zzbs(strongBinder);
        }
        parcelZzbl.recycle();
        return zzbsVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zze(IObjectWrapper iObjectWrapper, zzq zzqVar, String str, zzbsv zzbsvVar, int i) throws RemoteException {
        zzbu zzbsVar;
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzd(parcelZza, zzqVar);
        parcelZza.writeString(str);
        zzayi.zzf(parcelZza, zzbsvVar);
        parcelZza.writeInt(240304000);
        Parcel parcelZzbl = zzbl(2, parcelZza);
        IBinder strongBinder = parcelZzbl.readStrongBinder();
        if (strongBinder == null) {
            zzbsVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbsVar = iInterfaceQueryLocalInterface instanceof zzbu ? (zzbu) iInterfaceQueryLocalInterface : new zzbs(strongBinder);
        }
        parcelZzbl.recycle();
        return zzbsVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zzf(IObjectWrapper iObjectWrapper, zzq zzqVar, String str, int i) throws RemoteException {
        zzbu zzbsVar;
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzd(parcelZza, zzqVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(240304000);
        Parcel parcelZzbl = zzbl(10, parcelZza);
        IBinder strongBinder = parcelZzbl.readStrongBinder();
        if (strongBinder == null) {
            zzbsVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbsVar = iInterfaceQueryLocalInterface instanceof zzbu ? (zzbu) iInterfaceQueryLocalInterface : new zzbs(strongBinder);
        }
        parcelZzbl.recycle();
        return zzbsVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzco zzg(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzco zzcmVar;
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        parcelZza.writeInt(240304000);
        Parcel parcelZzbl = zzbl(9, parcelZza);
        IBinder strongBinder = parcelZzbl.readStrongBinder();
        if (strongBinder == null) {
            zzcmVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            zzcmVar = iInterfaceQueryLocalInterface instanceof zzco ? (zzco) iInterfaceQueryLocalInterface : new zzcm(strongBinder);
        }
        parcelZzbl.recycle();
        return zzcmVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzdj zzh(IObjectWrapper iObjectWrapper, zzbsv zzbsvVar, int i) throws RemoteException {
        zzdj zzdhVar;
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, zzbsvVar);
        parcelZza.writeInt(240304000);
        Parcel parcelZzbl = zzbl(17, parcelZza);
        IBinder strongBinder = parcelZzbl.readStrongBinder();
        if (strongBinder == null) {
            zzdhVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOutOfContextTester");
            zzdhVar = iInterfaceQueryLocalInterface instanceof zzdj ? (zzdj) iInterfaceQueryLocalInterface : new zzdh(strongBinder);
        }
        parcelZzbl.recycle();
        return zzdhVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbjq zzi(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, iObjectWrapper2);
        Parcel parcelZzbl = zzbl(5, parcelZza);
        zzbjq zzbjqVarZzbJ = zzbjp.zzbJ(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return zzbjqVarZzbJ;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbjw zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, iObjectWrapper2);
        zzayi.zzf(parcelZza, iObjectWrapper3);
        Parcel parcelZzbl = zzbl(11, parcelZza);
        zzbjw zzbjwVarZze = zzbjv.zze(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return zzbjwVarZze;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzboh zzk(IObjectWrapper iObjectWrapper, zzbsv zzbsvVar, int i, zzboe zzboeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, zzbsvVar);
        parcelZza.writeInt(240304000);
        zzayi.zzf(parcelZza, zzboeVar);
        Parcel parcelZzbl = zzbl(16, parcelZza);
        zzboh zzbohVarZzb = zzbog.zzb(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return zzbohVarZzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbwm zzl(IObjectWrapper iObjectWrapper, zzbsv zzbsvVar, int i) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, zzbsvVar);
        parcelZza.writeInt(240304000);
        Parcel parcelZzbl = zzbl(15, parcelZza);
        zzbwm zzbwmVarZzb = zzbwl.zzb(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return zzbwmVarZzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbwt zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        Parcel parcelZzbl = zzbl(8, parcelZza);
        zzbwt zzbwtVarZzI = zzbws.zzI(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return zzbwtVarZzI;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbzx zzn(IObjectWrapper iObjectWrapper, zzbsv zzbsvVar, int i) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzcan zzo(IObjectWrapper iObjectWrapper, String str, zzbsv zzbsvVar, int i) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        zzayi.zzf(parcelZza, zzbsvVar);
        parcelZza.writeInt(240304000);
        Parcel parcelZzbl = zzbl(12, parcelZza);
        zzcan zzcanVarZzq = zzcam.zzq(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return zzcanVarZzq;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzcct zzp(IObjectWrapper iObjectWrapper, zzbsv zzbsvVar, int i) throws RemoteException {
        Parcel parcelZza = zza();
        zzayi.zzf(parcelZza, iObjectWrapper);
        zzayi.zzf(parcelZza, zzbsvVar);
        parcelZza.writeInt(240304000);
        Parcel parcelZzbl = zzbl(14, parcelZza);
        zzcct zzcctVarZzb = zzccs.zzb(parcelZzbl.readStrongBinder());
        parcelZzbl.recycle();
        return zzcctVarZzb;
    }
}
