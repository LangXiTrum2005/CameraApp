package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbsx extends zzayh implements zzbsy {
    public zzbsx() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzayh
    protected final boolean zzbO(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbtb zzbszVar = null;
        switch (i) {
            case 1:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzq zzqVar = (com.google.android.gms.ads.internal.client.zzq) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzq.CREATOR);
                com.google.android.gms.ads.internal.client.zzl zzlVar = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                String string = parcel.readString();
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbszVar = iInterfaceQueryLocalInterface instanceof zzbtb ? (zzbtb) iInterfaceQueryLocalInterface : new zzbsz(strongBinder);
                }
                zzbtb zzbtbVar = zzbszVar;
                zzayi.zzc(parcel);
                zzu(iObjectWrapperAsInterface, zzqVar, zzlVar, string, zzbtbVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IObjectWrapper iObjectWrapperZzn = zzn();
                parcel2.writeNoException();
                zzayi.zzf(parcel2, iObjectWrapperZzn);
                return true;
            case 3:
                IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzl zzlVar2 = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                String string2 = parcel.readString();
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbszVar = iInterfaceQueryLocalInterface2 instanceof zzbtb ? (zzbtb) iInterfaceQueryLocalInterface2 : new zzbsz(strongBinder2);
                }
                zzayi.zzc(parcel);
                zzx(iObjectWrapperAsInterface2, zzlVar2, string2, zzbszVar);
                parcel2.writeNoException();
                return true;
            case 4:
                zzI();
                parcel2.writeNoException();
                return true;
            case 5:
                zzo();
                parcel2.writeNoException();
                return true;
            case 6:
                IObjectWrapper iObjectWrapperAsInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzq zzqVar2 = (com.google.android.gms.ads.internal.client.zzq) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzq.CREATOR);
                com.google.android.gms.ads.internal.client.zzl zzlVar3 = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbszVar = iInterfaceQueryLocalInterface3 instanceof zzbtb ? (zzbtb) iInterfaceQueryLocalInterface3 : new zzbsz(strongBinder3);
                }
                zzbtb zzbtbVar2 = zzbszVar;
                zzayi.zzc(parcel);
                zzv(iObjectWrapperAsInterface3, zzqVar2, zzlVar3, string3, string4, zzbtbVar2);
                parcel2.writeNoException();
                return true;
            case 7:
                IObjectWrapper iObjectWrapperAsInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzl zzlVar4 = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbszVar = iInterfaceQueryLocalInterface4 instanceof zzbtb ? (zzbtb) iInterfaceQueryLocalInterface4 : new zzbsz(strongBinder4);
                }
                zzbtb zzbtbVar3 = zzbszVar;
                zzayi.zzc(parcel);
                zzy(iObjectWrapperAsInterface4, zzlVar4, string5, string6, zzbtbVar3);
                parcel2.writeNoException();
                return true;
            case 8:
                zzE();
                parcel2.writeNoException();
                return true;
            case 9:
                zzF();
                parcel2.writeNoException();
                return true;
            case 10:
                IObjectWrapper iObjectWrapperAsInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzl zzlVar5 = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                String string7 = parcel.readString();
                zzcaf zzcafVarZzb = zzcae.zzb(parcel.readStrongBinder());
                String string8 = parcel.readString();
                zzayi.zzc(parcel);
                zzp(iObjectWrapperAsInterface5, zzlVar5, string7, zzcafVarZzb, string8);
                parcel2.writeNoException();
                return true;
            case 11:
                com.google.android.gms.ads.internal.client.zzl zzlVar6 = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                String string9 = parcel.readString();
                zzayi.zzc(parcel);
                zzs(zzlVar6, string9);
                parcel2.writeNoException();
                return true;
            case 12:
                zzL();
                parcel2.writeNoException();
                return true;
            case 13:
                boolean zZzN = zzN();
                parcel2.writeNoException();
                int i3 = zzayi.zza;
                parcel2.writeInt(zZzN ? 1 : 0);
                return true;
            case 14:
                IObjectWrapper iObjectWrapperAsInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzl zzlVar7 = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                String string10 = parcel.readString();
                String string11 = parcel.readString();
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbszVar = iInterfaceQueryLocalInterface5 instanceof zzbtb ? (zzbtb) iInterfaceQueryLocalInterface5 : new zzbsz(strongBinder5);
                }
                zzbtb zzbtbVar4 = zzbszVar;
                zzbjb zzbjbVar = (zzbjb) zzayi.zza(parcel, zzbjb.CREATOR);
                ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
                zzayi.zzc(parcel);
                zzz(iObjectWrapperAsInterface6, zzlVar7, string10, string11, zzbtbVar4, zzbjbVar, arrayListCreateStringArrayList);
                parcel2.writeNoException();
                return true;
            case 15:
                parcel2.writeNoException();
                zzayi.zzf(parcel2, null);
                return true;
            case 16:
                parcel2.writeNoException();
                zzayi.zzf(parcel2, null);
                return true;
            case 17:
                Bundle bundleZze = zze();
                parcel2.writeNoException();
                zzayi.zze(parcel2, bundleZze);
                return true;
            case 18:
                Bundle bundleZzf = zzf();
                parcel2.writeNoException();
                zzayi.zze(parcel2, bundleZzf);
                return true;
            case 19:
                Bundle bundleZzg = zzg();
                parcel2.writeNoException();
                zzayi.zze(parcel2, bundleZzg);
                return true;
            case 20:
                com.google.android.gms.ads.internal.client.zzl zzlVar8 = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                String string12 = parcel.readString();
                String string13 = parcel.readString();
                zzayi.zzc(parcel);
                zzB(zzlVar8, string12, string13);
                parcel2.writeNoException();
                return true;
            case 21:
                IObjectWrapper iObjectWrapperAsInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                zzD(iObjectWrapperAsInterface7);
                parcel2.writeNoException();
                return true;
            case 22:
                parcel2.writeNoException();
                int i4 = zzayi.zza;
                parcel2.writeInt(0);
                return true;
            case 23:
                IObjectWrapper iObjectWrapperAsInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzcaf zzcafVarZzb2 = zzcae.zzb(parcel.readStrongBinder());
                ArrayList<String> arrayListCreateStringArrayList2 = parcel.createStringArrayList();
                zzayi.zzc(parcel);
                zzr(iObjectWrapperAsInterface8, zzcafVarZzb2, arrayListCreateStringArrayList2);
                parcel2.writeNoException();
                return true;
            case 24:
                zzbkg zzbkgVarZzi = zzi();
                parcel2.writeNoException();
                zzayi.zzf(parcel2, zzbkgVarZzi);
                return true;
            case 25:
                boolean zZzg = zzayi.zzg(parcel);
                zzayi.zzc(parcel);
                zzG(zZzg);
                parcel2.writeNoException();
                return true;
            case 26:
                com.google.android.gms.ads.internal.client.zzdq zzdqVarZzh = zzh();
                parcel2.writeNoException();
                zzayi.zzf(parcel2, zzdqVarZzh);
                return true;
            case 27:
                zzbtk zzbtkVarZzk = zzk();
                parcel2.writeNoException();
                zzayi.zzf(parcel2, zzbtkVarZzk);
                return true;
            case 28:
                IObjectWrapper iObjectWrapperAsInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzl zzlVar9 = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                String string14 = parcel.readString();
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbszVar = iInterfaceQueryLocalInterface6 instanceof zzbtb ? (zzbtb) iInterfaceQueryLocalInterface6 : new zzbsz(strongBinder6);
                }
                zzayi.zzc(parcel);
                zzA(iObjectWrapperAsInterface9, zzlVar9, string14, zzbszVar);
                parcel2.writeNoException();
                return true;
            case 29:
            default:
                return false;
            case 30:
                IObjectWrapper iObjectWrapperAsInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                zzK(iObjectWrapperAsInterface10);
                parcel2.writeNoException();
                return true;
            case 31:
                IObjectWrapper iObjectWrapperAsInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbph zzbphVarZzb = zzbpg.zzb(parcel.readStrongBinder());
                ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(zzbpn.CREATOR);
                zzayi.zzc(parcel);
                zzq(iObjectWrapperAsInterface11, zzbphVarZzb, arrayListCreateTypedArrayList);
                parcel2.writeNoException();
                return true;
            case 32:
                IObjectWrapper iObjectWrapperAsInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzl zzlVar10 = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                String string15 = parcel.readString();
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbszVar = iInterfaceQueryLocalInterface7 instanceof zzbtb ? (zzbtb) iInterfaceQueryLocalInterface7 : new zzbsz(strongBinder7);
                }
                zzayi.zzc(parcel);
                zzC(iObjectWrapperAsInterface12, zzlVar10, string15, zzbszVar);
                parcel2.writeNoException();
                return true;
            case 33:
                zzbvg zzbvgVarZzl = zzl();
                parcel2.writeNoException();
                zzayi.zze(parcel2, zzbvgVarZzl);
                return true;
            case 34:
                zzbvg zzbvgVarZzm = zzm();
                parcel2.writeNoException();
                zzayi.zze(parcel2, zzbvgVarZzm);
                return true;
            case 35:
                IObjectWrapper iObjectWrapperAsInterface13 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzq zzqVar3 = (com.google.android.gms.ads.internal.client.zzq) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzq.CREATOR);
                com.google.android.gms.ads.internal.client.zzl zzlVar11 = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                String string16 = parcel.readString();
                String string17 = parcel.readString();
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbszVar = iInterfaceQueryLocalInterface8 instanceof zzbtb ? (zzbtb) iInterfaceQueryLocalInterface8 : new zzbsz(strongBinder8);
                }
                zzbtb zzbtbVar5 = zzbszVar;
                zzayi.zzc(parcel);
                zzw(iObjectWrapperAsInterface13, zzqVar3, zzlVar11, string16, string17, zzbtbVar5);
                parcel2.writeNoException();
                return true;
            case 36:
                zzbte zzbteVarZzj = zzj();
                parcel2.writeNoException();
                zzayi.zzf(parcel2, zzbteVarZzj);
                return true;
            case 37:
                IObjectWrapper iObjectWrapperAsInterface14 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                zzJ(iObjectWrapperAsInterface14);
                parcel2.writeNoException();
                return true;
            case 38:
                IObjectWrapper iObjectWrapperAsInterface15 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzl zzlVar12 = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                String string18 = parcel.readString();
                IBinder strongBinder9 = parcel.readStrongBinder();
                if (strongBinder9 != null) {
                    IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbszVar = iInterfaceQueryLocalInterface9 instanceof zzbtb ? (zzbtb) iInterfaceQueryLocalInterface9 : new zzbsz(strongBinder9);
                }
                zzayi.zzc(parcel);
                zzt(iObjectWrapperAsInterface15, zzlVar12, string18, zzbszVar);
                parcel2.writeNoException();
                return true;
            case 39:
                IObjectWrapper iObjectWrapperAsInterface16 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzayi.zzc(parcel);
                zzH(iObjectWrapperAsInterface16);
                parcel2.writeNoException();
                return true;
        }
    }
}
