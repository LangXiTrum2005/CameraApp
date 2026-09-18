package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzblk extends UnifiedNativeAd {
    private final zzblj zza;
    private final zzbjn zzc;
    private final NativeAd.AdChoicesInfo zze;
    private final List zzb = new ArrayList();
    private final VideoController zzd = new VideoController();
    private final List zzf = new ArrayList();

    public zzblk(zzblj zzbljVar) {
        zzbjn zzbjnVar;
        zzbjm zzbjkVar;
        IBinder iBinder;
        this.zza = zzbljVar;
        zzbjg zzbjgVar = null;
        try {
            List listZzu = zzbljVar.zzu();
            if (listZzu != null) {
                for (Object obj : listZzu) {
                    if (!(obj instanceof IBinder) || (iBinder = (IBinder) obj) == null) {
                        zzbjkVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                        zzbjkVar = iInterfaceQueryLocalInterface instanceof zzbjm ? (zzbjm) iInterfaceQueryLocalInterface : new zzbjk(iBinder);
                    }
                    if (zzbjkVar != null) {
                        this.zzb.add(new zzbjn(zzbjkVar));
                    }
                }
            }
        } catch (RemoteException e) {
            zzcec.zzh("", e);
        }
        try {
            List listZzv = this.zza.zzv();
            if (listZzv != null) {
                for (Object obj2 : listZzv) {
                    com.google.android.gms.ads.internal.client.zzcw zzcwVarZzb = obj2 instanceof IBinder ? com.google.android.gms.ads.internal.client.zzcv.zzb((IBinder) obj2) : null;
                    if (zzcwVarZzb != null) {
                        this.zzf.add(new com.google.android.gms.ads.internal.client.zzcx(zzcwVarZzb));
                    }
                }
            }
        } catch (RemoteException e2) {
            zzcec.zzh("", e2);
        }
        try {
            zzbjm zzbjmVarZzk = this.zza.zzk();
            zzbjnVar = zzbjmVarZzk != null ? new zzbjn(zzbjmVarZzk) : null;
        } catch (RemoteException e3) {
            zzcec.zzh("", e3);
        }
        this.zzc = zzbjnVar;
        try {
            if (this.zza.zzi() != null) {
                zzbjgVar = new zzbjg(this.zza.zzi());
            }
        } catch (RemoteException e4) {
            zzcec.zzh("", e4);
        }
        this.zze = zzbjgVar;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void performClick(Bundle bundle) {
        try {
            this.zza.zzz(bundle);
        } catch (RemoteException e) {
            zzcec.zzh("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final boolean recordImpression(Bundle bundle) {
        try {
            return this.zza.zzI(bundle);
        } catch (RemoteException e) {
            zzcec.zzh("", e);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zza.zzB(bundle);
        } catch (RemoteException e) {
            zzcec.zzh("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final VideoController zza() {
        try {
            if (this.zza.zzh() != null) {
                this.zzd.zzb(this.zza.zzh());
            }
        } catch (RemoteException e) {
            zzcec.zzh("Exception occurred while getting video controller", e);
        }
        return this.zzd;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final NativeAd.Image zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Double zzc() {
        try {
            double dZze = this.zza.zze();
            if (dZze == -1.0d) {
                return null;
            }
            return Double.valueOf(dZze);
        } catch (RemoteException e) {
            zzcec.zzh("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final Object zzd() {
        try {
            IObjectWrapper iObjectWrapperZzl = this.zza.zzl();
            if (iObjectWrapperZzl != null) {
                return ObjectWrapper.unwrap(iObjectWrapperZzl);
            }
            return null;
        } catch (RemoteException e) {
            zzcec.zzh("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String zze() {
        try {
            return this.zza.zzn();
        } catch (RemoteException e) {
            zzcec.zzh("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String zzf() {
        try {
            return this.zza.zzo();
        } catch (RemoteException e) {
            zzcec.zzh("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String zzg() {
        try {
            return this.zza.zzp();
        } catch (RemoteException e) {
            zzcec.zzh("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String zzh() {
        try {
            return this.zza.zzq();
        } catch (RemoteException e) {
            zzcec.zzh("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String zzi() {
        try {
            return this.zza.zzs();
        } catch (RemoteException e) {
            zzcec.zzh("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final String zzj() {
        try {
            return this.zza.zzt();
        } catch (RemoteException e) {
            zzcec.zzh("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.UnifiedNativeAd
    public final List zzk() {
        return this.zzb;
    }
}
