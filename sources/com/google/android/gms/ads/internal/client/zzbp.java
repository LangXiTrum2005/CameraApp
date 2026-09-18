package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzayi;
import com.google.android.gms.internal.ads.zzbjb;
import com.google.android.gms.internal.ads.zzbkj;
import com.google.android.gms.internal.ads.zzbkk;
import com.google.android.gms.internal.ads.zzbkm;
import com.google.android.gms.internal.ads.zzbkn;
import com.google.android.gms.internal.ads.zzbkp;
import com.google.android.gms.internal.ads.zzbkq;
import com.google.android.gms.internal.ads.zzbks;
import com.google.android.gms.internal.ads.zzbkt;
import com.google.android.gms.internal.ads.zzbkw;
import com.google.android.gms.internal.ads.zzbkx;
import com.google.android.gms.internal.ads.zzbkz;
import com.google.android.gms.internal.ads.zzbla;
import com.google.android.gms.internal.ads.zzbpp;
import com.google.android.gms.internal.ads.zzbpx;
import com.google.android.gms.internal.ads.zzbpy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzbp extends zzayh implements zzbq {
    public zzbp() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    protected final boolean zzbO(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbh zzbfVar = null;
        zzcf zzcfVar = null;
        switch (i) {
            case 1:
                zzbn zzbnVarZze = zze();
                parcel2.writeNoException();
                zzayi.zzf(parcel2, zzbnVarZze);
                return true;
            case 2:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    zzbfVar = iInterfaceQueryLocalInterface instanceof zzbh ? (zzbh) iInterfaceQueryLocalInterface : new zzbf(strongBinder);
                }
                zzayi.zzc(parcel);
                zzl(zzbfVar);
                parcel2.writeNoException();
                return true;
            case 3:
                zzbkk zzbkkVarZzb = zzbkj.zzb(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                zzf(zzbkkVarZzb);
                parcel2.writeNoException();
                return true;
            case 4:
                zzbkn zzbknVarZzb = zzbkm.zzb(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                zzg(zzbknVarZzb);
                parcel2.writeNoException();
                return true;
            case 5:
                String string = parcel.readString();
                zzbkt zzbktVarZzb = zzbks.zzb(parcel.readStrongBinder());
                zzbkq zzbkqVarZzb = zzbkp.zzb(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                zzh(string, zzbktVarZzb, zzbkqVarZzb);
                parcel2.writeNoException();
                return true;
            case 6:
                zzbjb zzbjbVar = (zzbjb) zzayi.zza(parcel, zzbjb.CREATOR);
                zzayi.zzc(parcel);
                zzo(zzbjbVar);
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    zzcfVar = iInterfaceQueryLocalInterface2 instanceof zzcf ? (zzcf) iInterfaceQueryLocalInterface2 : new zzcf(strongBinder2);
                }
                zzayi.zzc(parcel);
                zzq(zzcfVar);
                parcel2.writeNoException();
                return true;
            case 8:
                zzbkx zzbkxVarZzb = zzbkw.zzb(parcel.readStrongBinder());
                zzq zzqVar = (zzq) zzayi.zza(parcel, zzq.CREATOR);
                zzayi.zzc(parcel);
                zzj(zzbkxVarZzb, zzqVar);
                parcel2.writeNoException();
                return true;
            case 9:
                PublisherAdViewOptions publisherAdViewOptions = (PublisherAdViewOptions) zzayi.zza(parcel, PublisherAdViewOptions.CREATOR);
                zzayi.zzc(parcel);
                zzp(publisherAdViewOptions);
                parcel2.writeNoException();
                return true;
            case 10:
                zzbla zzblaVarZzb = zzbkz.zzb(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                zzk(zzblaVarZzb);
                parcel2.writeNoException();
                return true;
            case 11:
            case 12:
            default:
                return false;
            case 13:
                zzbpp zzbppVar = (zzbpp) zzayi.zza(parcel, zzbpp.CREATOR);
                zzayi.zzc(parcel);
                zzn(zzbppVar);
                parcel2.writeNoException();
                return true;
            case 14:
                zzbpy zzbpyVarZzb = zzbpx.zzb(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                zzi(zzbpyVarZzb);
                parcel2.writeNoException();
                return true;
            case 15:
                AdManagerAdViewOptions adManagerAdViewOptions = (AdManagerAdViewOptions) zzayi.zza(parcel, AdManagerAdViewOptions.CREATOR);
                zzayi.zzc(parcel);
                zzm(adManagerAdViewOptions);
                parcel2.writeNoException();
                return true;
        }
    }
}
