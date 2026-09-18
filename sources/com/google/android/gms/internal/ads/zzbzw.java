package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbzw extends zzayh implements zzbzx {
    public zzbzw() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    protected final boolean zzbO(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzcab zzcabVar = (zzcab) zzayi.zza(parcel, zzcab.CREATOR);
            zzayi.zzc(parcel);
            zzg(zzcabVar);
            parcel2.writeNoException();
        } else if (i != 2) {
            zzcaa zzbzyVar = null;
            zzbzv zzbzvVar = null;
            if (i == 3) {
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
                    zzbzyVar = iInterfaceQueryLocalInterface instanceof zzcaa ? (zzcaa) iInterfaceQueryLocalInterface : new zzbzy(strongBinder);
                }
                zzayi.zzc(parcel);
                zzo(zzbzyVar);
                parcel2.writeNoException();
            } else if (i != 34) {
                switch (i) {
                    case 5:
                        boolean zZzs = zzs();
                        parcel2.writeNoException();
                        int i3 = zzayi.zza;
                        parcel2.writeInt(zZzs ? 1 : 0);
                        break;
                    case 6:
                        zzh();
                        parcel2.writeNoException();
                        break;
                    case 7:
                        zzj();
                        parcel2.writeNoException();
                        break;
                    case 8:
                        zze();
                        parcel2.writeNoException();
                        break;
                    case 9:
                        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                        zzayi.zzc(parcel);
                        zzi(iObjectWrapperAsInterface);
                        parcel2.writeNoException();
                        break;
                    case 10:
                        IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                        zzayi.zzc(parcel);
                        zzk(iObjectWrapperAsInterface2);
                        parcel2.writeNoException();
                        break;
                    case 11:
                        IObjectWrapper iObjectWrapperAsInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                        zzayi.zzc(parcel);
                        zzf(iObjectWrapperAsInterface3);
                        parcel2.writeNoException();
                        break;
                    case 12:
                        String strZzd = zzd();
                        parcel2.writeNoException();
                        parcel2.writeString(strZzd);
                        break;
                    case 13:
                        String string = parcel.readString();
                        zzayi.zzc(parcel);
                        zzp(string);
                        parcel2.writeNoException();
                        break;
                    case 14:
                        com.google.android.gms.ads.internal.client.zzby zzbyVarZzb = com.google.android.gms.ads.internal.client.zzbx.zzb(parcel.readStrongBinder());
                        zzayi.zzc(parcel);
                        zzl(zzbyVarZzb);
                        parcel2.writeNoException();
                        break;
                    case 15:
                        Bundle bundleZzb = zzb();
                        parcel2.writeNoException();
                        zzayi.zze(parcel2, bundleZzb);
                        break;
                    case 16:
                        IBinder strongBinder2 = parcel.readStrongBinder();
                        if (strongBinder2 != null) {
                            IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
                            zzbzvVar = iInterfaceQueryLocalInterface2 instanceof zzbzv ? (zzbzv) iInterfaceQueryLocalInterface2 : new zzbzv(strongBinder2);
                        }
                        zzayi.zzc(parcel);
                        zzu(zzbzvVar);
                        parcel2.writeNoException();
                        break;
                    case 17:
                        parcel.readString();
                        zzayi.zzc(parcel);
                        parcel2.writeNoException();
                        break;
                    case 18:
                        IObjectWrapper iObjectWrapperAsInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                        zzayi.zzc(parcel);
                        zzr(iObjectWrapperAsInterface4);
                        parcel2.writeNoException();
                        break;
                    case 19:
                        String string2 = parcel.readString();
                        zzayi.zzc(parcel);
                        zzm(string2);
                        parcel2.writeNoException();
                        break;
                    case 20:
                        boolean zZzt = zzt();
                        parcel2.writeNoException();
                        int i4 = zzayi.zza;
                        parcel2.writeInt(zZzt ? 1 : 0);
                        break;
                    case 21:
                        com.google.android.gms.ads.internal.client.zzdn zzdnVarZzc = zzc();
                        parcel2.writeNoException();
                        zzayi.zzf(parcel2, zzdnVarZzc);
                        break;
                    default:
                        return false;
                }
            } else {
                boolean zZzg = zzayi.zzg(parcel);
                zzayi.zzc(parcel);
                zzn(zZzg);
                parcel2.writeNoException();
            }
        } else {
            zzq();
            parcel2.writeNoException();
        }
        return true;
    }
}
