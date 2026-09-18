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
public abstract class zzbli extends zzayh implements zzblj {
    public zzbli() {
        super("com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    protected final boolean zzbO(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzblg zzbleVar;
        switch (i) {
            case 2:
                String strZzq = zzq();
                parcel2.writeNoException();
                parcel2.writeString(strZzq);
                return true;
            case 3:
                List listZzu = zzu();
                parcel2.writeNoException();
                parcel2.writeList(listZzu);
                return true;
            case 4:
                String strZzo = zzo();
                parcel2.writeNoException();
                parcel2.writeString(strZzo);
                return true;
            case 5:
                zzbjm zzbjmVarZzk = zzk();
                parcel2.writeNoException();
                zzayi.zzf(parcel2, zzbjmVarZzk);
                return true;
            case 6:
                String strZzp = zzp();
                parcel2.writeNoException();
                parcel2.writeString(strZzp);
                return true;
            case 7:
                String strZzn = zzn();
                parcel2.writeNoException();
                parcel2.writeString(strZzn);
                return true;
            case 8:
                double dZze = zze();
                parcel2.writeNoException();
                parcel2.writeDouble(dZze);
                return true;
            case 9:
                String strZzt = zzt();
                parcel2.writeNoException();
                parcel2.writeString(strZzt);
                return true;
            case 10:
                String strZzs = zzs();
                parcel2.writeNoException();
                parcel2.writeString(strZzs);
                return true;
            case 11:
                com.google.android.gms.ads.internal.client.zzdq zzdqVarZzh = zzh();
                parcel2.writeNoException();
                zzayi.zzf(parcel2, zzdqVarZzh);
                return true;
            case 12:
                String strZzr = zzr();
                parcel2.writeNoException();
                parcel2.writeString(strZzr);
                return true;
            case 13:
                zzx();
                parcel2.writeNoException();
                return true;
            case 14:
                zzbjf zzbjfVarZzi = zzi();
                parcel2.writeNoException();
                zzayi.zzf(parcel2, zzbjfVarZzi);
                return true;
            case 15:
                Bundle bundle = (Bundle) zzayi.zza(parcel, Bundle.CREATOR);
                zzayi.zzc(parcel);
                zzz(bundle);
                parcel2.writeNoException();
                return true;
            case 16:
                Bundle bundle2 = (Bundle) zzayi.zza(parcel, Bundle.CREATOR);
                zzayi.zzc(parcel);
                boolean zZzI = zzI(bundle2);
                parcel2.writeNoException();
                parcel2.writeInt(zZzI ? 1 : 0);
                return true;
            case 17:
                Bundle bundle3 = (Bundle) zzayi.zza(parcel, Bundle.CREATOR);
                zzayi.zzc(parcel);
                zzB(bundle3);
                parcel2.writeNoException();
                return true;
            case 18:
                IObjectWrapper iObjectWrapperZzm = zzm();
                parcel2.writeNoException();
                zzayi.zzf(parcel2, iObjectWrapperZzm);
                return true;
            case 19:
                IObjectWrapper iObjectWrapperZzl = zzl();
                parcel2.writeNoException();
                zzayi.zzf(parcel2, iObjectWrapperZzl);
                return true;
            case 20:
                Bundle bundleZzf = zzf();
                parcel2.writeNoException();
                zzayi.zze(parcel2, bundleZzf);
                return true;
            case 21:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzbleVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
                    zzbleVar = iInterfaceQueryLocalInterface instanceof zzblg ? (zzblg) iInterfaceQueryLocalInterface : new zzble(strongBinder);
                }
                zzayi.zzc(parcel);
                zzF(zzbleVar);
                parcel2.writeNoException();
                return true;
            case 22:
                zzw();
                parcel2.writeNoException();
                return true;
            case 23:
                List listZzv = zzv();
                parcel2.writeNoException();
                parcel2.writeList(listZzv);
                return true;
            case 24:
                boolean zZzH = zzH();
                parcel2.writeNoException();
                int i3 = zzayi.zza;
                parcel2.writeInt(zZzH ? 1 : 0);
                return true;
            case 25:
                com.google.android.gms.ads.internal.client.zzcw zzcwVarZzb = com.google.android.gms.ads.internal.client.zzcv.zzb(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                zzy(zzcwVarZzb);
                parcel2.writeNoException();
                return true;
            case 26:
                com.google.android.gms.ads.internal.client.zzcs zzcsVarZzb = com.google.android.gms.ads.internal.client.zzcr.zzb(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                zzD(zzcsVarZzb);
                parcel2.writeNoException();
                return true;
            case 27:
                zzC();
                parcel2.writeNoException();
                return true;
            case 28:
                zzA();
                parcel2.writeNoException();
                return true;
            case 29:
                zzbjj zzbjjVarZzj = zzj();
                parcel2.writeNoException();
                zzayi.zzf(parcel2, zzbjjVarZzj);
                return true;
            case 30:
                boolean zZzG = zzG();
                parcel2.writeNoException();
                int i4 = zzayi.zza;
                parcel2.writeInt(zZzG ? 1 : 0);
                return true;
            case 31:
                com.google.android.gms.ads.internal.client.zzdn zzdnVarZzg = zzg();
                parcel2.writeNoException();
                zzayi.zzf(parcel2, zzdnVarZzg);
                return true;
            case 32:
                com.google.android.gms.ads.internal.client.zzdg zzdgVarZzb = com.google.android.gms.ads.internal.client.zzdf.zzb(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                zzE(zzdgVarZzb);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
