package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzayi;
import com.google.android.gms.internal.ads.zzbjq;
import com.google.android.gms.internal.ads.zzbjw;
import com.google.android.gms.internal.ads.zzbod;
import com.google.android.gms.internal.ads.zzboe;
import com.google.android.gms.internal.ads.zzboh;
import com.google.android.gms.internal.ads.zzbsu;
import com.google.android.gms.internal.ads.zzbsv;
import com.google.android.gms.internal.ads.zzbwm;
import com.google.android.gms.internal.ads.zzbwt;
import com.google.android.gms.internal.ads.zzbzx;
import com.google.android.gms.internal.ads.zzcan;
import com.google.android.gms.internal.ads.zzcct;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzcd extends zzayh implements zzce {
    public zzcd() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    protected final boolean zzbO(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzq zzqVar = (zzq) zzayi.zza(parcel, zzq.CREATOR);
                String string = parcel.readString();
                zzbsv zzbsvVarZzf = zzbsu.zzf(parcel.readStrongBinder());
                int i3 = parcel.readInt();
                zzayi.zzc(parcel);
                zzbu zzbuVarZzd = zzd(iObjectWrapperAsInterface, zzqVar, string, zzbsvVarZzf, i3);
                parcel2.writeNoException();
                zzayi.zzf(parcel2, zzbuVarZzd);
                return true;
            case 2:
                IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzq zzqVar2 = (zzq) zzayi.zza(parcel, zzq.CREATOR);
                String string2 = parcel.readString();
                zzbsv zzbsvVarZzf2 = zzbsu.zzf(parcel.readStrongBinder());
                int i4 = parcel.readInt();
                zzayi.zzc(parcel);
                zzbu zzbuVarZze = zze(iObjectWrapperAsInterface2, zzqVar2, string2, zzbsvVarZzf2, i4);
                parcel2.writeNoException();
                zzayi.zzf(parcel2, zzbuVarZze);
                return true;
            case 3:
                IObjectWrapper iObjectWrapperAsInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String string3 = parcel.readString();
                zzbsv zzbsvVarZzf3 = zzbsu.zzf(parcel.readStrongBinder());
                int i5 = parcel.readInt();
                zzayi.zzc(parcel);
                zzbq zzbqVarZzb = zzb(iObjectWrapperAsInterface3, string3, zzbsvVarZzf3, i5);
                parcel2.writeNoException();
                zzayi.zzf(parcel2, zzbqVarZzb);
                return true;
            case 4:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                parcel2.writeNoException();
                zzayi.zzf(parcel2, null);
                return true;
            case 5:
                IObjectWrapper iObjectWrapperAsInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                zzbjq zzbjqVarZzi = zzi(iObjectWrapperAsInterface4, iObjectWrapperAsInterface5);
                parcel2.writeNoException();
                zzayi.zzf(parcel2, zzbjqVarZzi);
                return true;
            case 6:
                IObjectWrapper iObjectWrapperAsInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbsv zzbsvVarZzf4 = zzbsu.zzf(parcel.readStrongBinder());
                int i6 = parcel.readInt();
                zzayi.zzc(parcel);
                zzbzx zzbzxVarZzn = zzn(iObjectWrapperAsInterface6, zzbsvVarZzf4, i6);
                parcel2.writeNoException();
                zzayi.zzf(parcel2, zzbzxVarZzn);
                return true;
            case 7:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                parcel2.writeNoException();
                zzayi.zzf(parcel2, null);
                return true;
            case 8:
                IObjectWrapper iObjectWrapperAsInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                zzbwt zzbwtVarZzm = zzm(iObjectWrapperAsInterface7);
                parcel2.writeNoException();
                zzayi.zzf(parcel2, zzbwtVarZzm);
                return true;
            case 9:
                IObjectWrapper iObjectWrapperAsInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                int i7 = parcel.readInt();
                zzayi.zzc(parcel);
                zzco zzcoVarZzg = zzg(iObjectWrapperAsInterface8, i7);
                parcel2.writeNoException();
                zzayi.zzf(parcel2, zzcoVarZzg);
                return true;
            case 10:
                IObjectWrapper iObjectWrapperAsInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzq zzqVar3 = (zzq) zzayi.zza(parcel, zzq.CREATOR);
                String string4 = parcel.readString();
                int i8 = parcel.readInt();
                zzayi.zzc(parcel);
                zzbu zzbuVarZzf = zzf(iObjectWrapperAsInterface9, zzqVar3, string4, i8);
                parcel2.writeNoException();
                zzayi.zzf(parcel2, zzbuVarZzf);
                return true;
            case 11:
                IObjectWrapper iObjectWrapperAsInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                zzbjw zzbjwVarZzj = zzj(iObjectWrapperAsInterface10, iObjectWrapperAsInterface11, iObjectWrapperAsInterface12);
                parcel2.writeNoException();
                zzayi.zzf(parcel2, zzbjwVarZzj);
                return true;
            case 12:
                IObjectWrapper iObjectWrapperAsInterface13 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String string5 = parcel.readString();
                zzbsv zzbsvVarZzf5 = zzbsu.zzf(parcel.readStrongBinder());
                int i9 = parcel.readInt();
                zzayi.zzc(parcel);
                zzcan zzcanVarZzo = zzo(iObjectWrapperAsInterface13, string5, zzbsvVarZzf5, i9);
                parcel2.writeNoException();
                zzayi.zzf(parcel2, zzcanVarZzo);
                return true;
            case 13:
                IObjectWrapper iObjectWrapperAsInterface14 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzq zzqVar4 = (zzq) zzayi.zza(parcel, zzq.CREATOR);
                String string6 = parcel.readString();
                zzbsv zzbsvVarZzf6 = zzbsu.zzf(parcel.readStrongBinder());
                int i10 = parcel.readInt();
                zzayi.zzc(parcel);
                zzbu zzbuVarZzc = zzc(iObjectWrapperAsInterface14, zzqVar4, string6, zzbsvVarZzf6, i10);
                parcel2.writeNoException();
                zzayi.zzf(parcel2, zzbuVarZzc);
                return true;
            case 14:
                IObjectWrapper iObjectWrapperAsInterface15 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbsv zzbsvVarZzf7 = zzbsu.zzf(parcel.readStrongBinder());
                int i11 = parcel.readInt();
                zzayi.zzc(parcel);
                zzcct zzcctVarZzp = zzp(iObjectWrapperAsInterface15, zzbsvVarZzf7, i11);
                parcel2.writeNoException();
                zzayi.zzf(parcel2, zzcctVarZzp);
                return true;
            case 15:
                IObjectWrapper iObjectWrapperAsInterface16 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbsv zzbsvVarZzf8 = zzbsu.zzf(parcel.readStrongBinder());
                int i12 = parcel.readInt();
                zzayi.zzc(parcel);
                zzbwm zzbwmVarZzl = zzl(iObjectWrapperAsInterface16, zzbsvVarZzf8, i12);
                parcel2.writeNoException();
                zzayi.zzf(parcel2, zzbwmVarZzl);
                return true;
            case 16:
                IObjectWrapper iObjectWrapperAsInterface17 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbsv zzbsvVarZzf9 = zzbsu.zzf(parcel.readStrongBinder());
                int i13 = parcel.readInt();
                zzboe zzboeVarZzc = zzbod.zzc(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                zzboh zzbohVarZzk = zzk(iObjectWrapperAsInterface17, zzbsvVarZzf9, i13, zzboeVarZzc);
                parcel2.writeNoException();
                zzayi.zzf(parcel2, zzbohVarZzk);
                return true;
            case 17:
                IObjectWrapper iObjectWrapperAsInterface18 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbsv zzbsvVarZzf10 = zzbsu.zzf(parcel.readStrongBinder());
                int i14 = parcel.readInt();
                zzayi.zzc(parcel);
                zzdj zzdjVarZzh = zzh(iObjectWrapperAsInterface18, zzbsvVarZzf10, i14);
                parcel2.writeNoException();
                zzayi.zzf(parcel2, zzdjVarZzh);
                return true;
            default:
                return false;
        }
    }
}
