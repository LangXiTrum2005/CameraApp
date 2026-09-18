package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzbur extends zzayh implements zzbus {
    public zzbur() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzbus zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        return iInterfaceQueryLocalInterface instanceof zzbus ? (zzbus) iInterfaceQueryLocalInterface : new zzbuq(iBinder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [com.google.android.gms.internal.ads.zzbuv] */
    /* JADX WARN: Type inference failed for: r11v4, types: [com.google.android.gms.internal.ads.zzbup] */
    /* JADX WARN: Type inference failed for: r11v5, types: [com.google.android.gms.internal.ads.zzbum] */
    /* JADX WARN: Type inference failed for: r11v6, types: [com.google.android.gms.internal.ads.zzbup] */
    /* JADX WARN: Type inference failed for: r11v8, types: [com.google.android.gms.internal.ads.zzbum] */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.google.android.gms.internal.ads.zzbur] */
    /* JADX WARN: Type inference failed for: r5v16, types: [com.google.android.gms.internal.ads.zzbug] */
    /* JADX WARN: Type inference failed for: r5v5, types: [com.google.android.gms.internal.ads.zzbug] */
    /* JADX WARN: Type inference failed for: r7v14, types: [com.google.android.gms.internal.ads.zzbud] */
    /* JADX WARN: Type inference failed for: r7v5, types: [com.google.android.gms.internal.ads.zzbuj] */
    @Override // com.google.android.gms.internal.ads.zzayh
    protected final boolean zzbO(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        IInterface zzbubVar = null;
        if (i == 1) {
            IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            String string = parcel.readString();
            Bundle bundle = (Bundle) zzayi.zza(parcel, Bundle.CREATOR);
            Bundle bundle2 = (Bundle) zzayi.zza(parcel, Bundle.CREATOR);
            com.google.android.gms.ads.internal.client.zzq zzqVar = (com.google.android.gms.ads.internal.client.zzq) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzq.CREATOR);
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
                zzbubVar = iInterfaceQueryLocalInterface instanceof zzbuv ? (zzbuv) iInterfaceQueryLocalInterface : new zzbut(strongBinder);
            }
            ?? r11 = zzbubVar;
            zzayi.zzc(parcel);
            zzh(iObjectWrapperAsInterface, string, bundle, bundle2, zzqVar, r11);
            parcel2.writeNoException();
        } else if (i == 2) {
            zzbvg zzbvgVarZzf = zzf();
            parcel2.writeNoException();
            zzayi.zze(parcel2, zzbvgVarZzf);
        } else if (i == 3) {
            zzbvg zzbvgVarZzg = zzg();
            parcel2.writeNoException();
            zzayi.zze(parcel2, zzbvgVarZzg);
        } else if (i == 5) {
            com.google.android.gms.ads.internal.client.zzdq zzdqVarZze = zze();
            parcel2.writeNoException();
            zzayi.zzf(parcel2, zzdqVarZze);
        } else if (i == 10) {
            IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzayi.zzc(parcel);
            parcel2.writeNoException();
        } else if (i != 11) {
            switch (i) {
                case 13:
                    String string2 = parcel.readString();
                    String string3 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzl zzlVar = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder2 = parcel.readStrongBinder();
                    if (strongBinder2 != null) {
                        IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                        zzbubVar = iInterfaceQueryLocalInterface2 instanceof zzbug ? (zzbug) iInterfaceQueryLocalInterface2 : new zzbue(strongBinder2);
                    }
                    ?? r5 = zzbubVar;
                    zzbtb zzbtbVarZzb = zzbta.zzb(parcel.readStrongBinder());
                    com.google.android.gms.ads.internal.client.zzq zzqVar2 = (com.google.android.gms.ads.internal.client.zzq) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzq.CREATOR);
                    zzayi.zzc(parcel);
                    zzj(string2, string3, zzlVar, iObjectWrapperAsInterface2, r5, zzbtbVarZzb, zzqVar2);
                    parcel2.writeNoException();
                    break;
                case 14:
                    String string4 = parcel.readString();
                    String string5 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzl zzlVar2 = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder3 = parcel.readStrongBinder();
                    if (strongBinder3 != null) {
                        IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
                        zzbubVar = iInterfaceQueryLocalInterface3 instanceof zzbuj ? (zzbuj) iInterfaceQueryLocalInterface3 : new zzbuh(strongBinder3);
                    }
                    ?? r7 = zzbubVar;
                    zzbtb zzbtbVarZzb2 = zzbta.zzb(parcel.readStrongBinder());
                    zzayi.zzc(parcel);
                    zzl(string4, string5, zzlVar2, iObjectWrapperAsInterface3, r7, zzbtbVarZzb2);
                    parcel2.writeNoException();
                    break;
                case 15:
                    IObjectWrapper iObjectWrapperAsInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    zzayi.zzc(parcel);
                    boolean zZzs = zzs(iObjectWrapperAsInterface4);
                    parcel2.writeNoException();
                    parcel2.writeInt(zZzs ? 1 : 0);
                    break;
                case 16:
                    String string6 = parcel.readString();
                    String string7 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzl zzlVar3 = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder4 = parcel.readStrongBinder();
                    if (strongBinder4 != null) {
                        IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        zzbubVar = iInterfaceQueryLocalInterface4 instanceof zzbup ? (zzbup) iInterfaceQueryLocalInterface4 : new zzbun(strongBinder4);
                    }
                    ?? r12 = zzbubVar;
                    zzbtb zzbtbVarZzb3 = zzbta.zzb(parcel.readStrongBinder());
                    zzayi.zzc(parcel);
                    zzp(string6, string7, zzlVar3, iObjectWrapperAsInterface5, r12, zzbtbVarZzb3);
                    parcel2.writeNoException();
                    break;
                case 17:
                    IObjectWrapper iObjectWrapperAsInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    zzayi.zzc(parcel);
                    boolean zZzt = zzt(iObjectWrapperAsInterface6);
                    parcel2.writeNoException();
                    parcel2.writeInt(zZzt ? 1 : 0);
                    break;
                case 18:
                    String string8 = parcel.readString();
                    String string9 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzl zzlVar4 = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder5 = parcel.readStrongBinder();
                    if (strongBinder5 != null) {
                        IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                        zzbubVar = iInterfaceQueryLocalInterface5 instanceof zzbum ? (zzbum) iInterfaceQueryLocalInterface5 : new zzbuk(strongBinder5);
                    }
                    ?? r13 = zzbubVar;
                    zzbtb zzbtbVarZzb4 = zzbta.zzb(parcel.readStrongBinder());
                    zzayi.zzc(parcel);
                    zzm(string8, string9, zzlVar4, iObjectWrapperAsInterface7, r13, zzbtbVarZzb4);
                    parcel2.writeNoException();
                    break;
                case 19:
                    String string10 = parcel.readString();
                    zzayi.zzc(parcel);
                    zzq(string10);
                    parcel2.writeNoException();
                    break;
                case 20:
                    String string11 = parcel.readString();
                    String string12 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzl zzlVar5 = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder6 = parcel.readStrongBinder();
                    if (strongBinder6 != null) {
                        IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        zzbubVar = iInterfaceQueryLocalInterface6 instanceof zzbup ? (zzbup) iInterfaceQueryLocalInterface6 : new zzbun(strongBinder6);
                    }
                    ?? r14 = zzbubVar;
                    zzbtb zzbtbVarZzb5 = zzbta.zzb(parcel.readStrongBinder());
                    zzayi.zzc(parcel);
                    zzo(string11, string12, zzlVar5, iObjectWrapperAsInterface8, r14, zzbtbVarZzb5);
                    parcel2.writeNoException();
                    break;
                case 21:
                    String string13 = parcel.readString();
                    String string14 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzl zzlVar6 = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder7 = parcel.readStrongBinder();
                    if (strongBinder7 != null) {
                        IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                        zzbubVar = iInterfaceQueryLocalInterface7 instanceof zzbug ? (zzbug) iInterfaceQueryLocalInterface7 : new zzbue(strongBinder7);
                    }
                    ?? r6 = zzbubVar;
                    zzbtb zzbtbVarZzb6 = zzbta.zzb(parcel.readStrongBinder());
                    com.google.android.gms.ads.internal.client.zzq zzqVar3 = (com.google.android.gms.ads.internal.client.zzq) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzq.CREATOR);
                    zzayi.zzc(parcel);
                    zzk(string13, string14, zzlVar6, iObjectWrapperAsInterface9, r6, zzbtbVarZzb6, zzqVar3);
                    parcel2.writeNoException();
                    break;
                case 22:
                    String string15 = parcel.readString();
                    String string16 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzl zzlVar7 = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder8 = parcel.readStrongBinder();
                    if (strongBinder8 != null) {
                        IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                        zzbubVar = iInterfaceQueryLocalInterface8 instanceof zzbum ? (zzbum) iInterfaceQueryLocalInterface8 : new zzbuk(strongBinder8);
                    }
                    ?? r15 = zzbubVar;
                    zzbtb zzbtbVarZzb7 = zzbta.zzb(parcel.readStrongBinder());
                    zzbjb zzbjbVar = (zzbjb) zzayi.zza(parcel, zzbjb.CREATOR);
                    zzayi.zzc(parcel);
                    zzn(string15, string16, zzlVar7, iObjectWrapperAsInterface10, r15, zzbtbVarZzb7, zzbjbVar);
                    parcel2.writeNoException();
                    break;
                case 23:
                    String string17 = parcel.readString();
                    String string18 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzl zzlVar8 = (com.google.android.gms.ads.internal.client.zzl) zzayi.zza(parcel, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder9 = parcel.readStrongBinder();
                    if (strongBinder9 != null) {
                        IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IAppOpenCallback");
                        zzbubVar = iInterfaceQueryLocalInterface9 instanceof zzbud ? (zzbud) iInterfaceQueryLocalInterface9 : new zzbub(strongBinder9);
                    }
                    ?? r8 = zzbubVar;
                    zzbtb zzbtbVarZzb8 = zzbta.zzb(parcel.readStrongBinder());
                    zzayi.zzc(parcel);
                    zzi(string17, string18, zzlVar8, iObjectWrapperAsInterface11, r8, zzbtbVarZzb8);
                    parcel2.writeNoException();
                    break;
                case 24:
                    IObjectWrapper iObjectWrapperAsInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    zzayi.zzc(parcel);
                    boolean zZzr = zzr(iObjectWrapperAsInterface12);
                    parcel2.writeNoException();
                    parcel2.writeInt(zZzr ? 1 : 0);
                    break;
                default:
                    return false;
            }
        } else {
            parcel.createStringArray();
            zzayi.zzc(parcel);
            parcel2.writeNoException();
        }
        return true;
    }
}
