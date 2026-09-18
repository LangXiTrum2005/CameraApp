package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaze;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.internal.ads.zzbsr;
import com.google.android.gms.internal.ads.zzcdv;
import com.google.android.gms.internal.ads.zzcec;
import java.util.concurrent.atomic.AtomicBoolean;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzea {
    final zzaz zza;
    private final zzbsr zzb;
    private final zzp zzc;
    private final AtomicBoolean zzd;
    private final VideoController zze;
    private zza zzf;
    private AdListener zzg;
    private AdSize[] zzh;
    private AppEventListener zzi;
    private zzbu zzj;
    private VideoOptions zzk;
    private String zzl;

    @NotOnlyInitialized
    private final ViewGroup zzm;
    private int zzn;
    private boolean zzo;
    private OnPaidEventListener zzp;

    public zzea(ViewGroup viewGroup) {
        this(viewGroup, null, false, zzp.zza, null, 0);
    }

    private static zzq zzC(Context context, AdSize[] adSizeArr, int i) {
        for (AdSize adSize : adSizeArr) {
            if (adSize.equals(AdSize.INVALID)) {
                return zzq.zze();
            }
        }
        zzq zzqVar = new zzq(context, adSizeArr);
        zzqVar.zzj = zzD(i);
        return zzqVar;
    }

    private static boolean zzD(int i) {
        return i == 1;
    }

    public final boolean zzA() {
        try {
            zzbu zzbuVar = this.zzj;
            if (zzbuVar != null) {
                return zzbuVar.zzY();
            }
            return false;
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final AdSize[] zzB() {
        return this.zzh;
    }

    public final AdListener zza() {
        return this.zzg;
    }

    public final AdSize zzb() {
        zzq zzqVarZzg;
        try {
            zzbu zzbuVar = this.zzj;
            if (zzbuVar != null && (zzqVarZzg = zzbuVar.zzg()) != null) {
                return com.google.android.gms.ads.zzb.zzc(zzqVarZzg.zze, zzqVarZzg.zzb, zzqVarZzg.zza);
            }
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
        }
        AdSize[] adSizeArr = this.zzh;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    public final OnPaidEventListener zzc() {
        return this.zzp;
    }

    public final ResponseInfo zzd() {
        zzdn zzdnVarZzk = null;
        try {
            zzbu zzbuVar = this.zzj;
            if (zzbuVar != null) {
                zzdnVarZzk = zzbuVar.zzk();
            }
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zza(zzdnVarZzk);
    }

    public final VideoController zzf() {
        return this.zze;
    }

    public final VideoOptions zzg() {
        return this.zzk;
    }

    public final AppEventListener zzh() {
        return this.zzi;
    }

    public final zzdq zzi() {
        zzbu zzbuVar = this.zzj;
        if (zzbuVar != null) {
            try {
                return zzbuVar.zzl();
            } catch (RemoteException e) {
                zzcec.zzl("#007 Could not call remote method.", e);
            }
        }
        return null;
    }

    public final String zzj() {
        zzbu zzbuVar;
        if (this.zzl == null && (zzbuVar = this.zzj) != null) {
            try {
                this.zzl = zzbuVar.zzr();
            } catch (RemoteException e) {
                zzcec.zzl("#007 Could not call remote method.", e);
            }
        }
        return this.zzl;
    }

    public final void zzk() {
        try {
            zzbu zzbuVar = this.zzj;
            if (zzbuVar != null) {
                zzbuVar.zzx();
            }
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
        }
    }

    final /* synthetic */ void zzl(IObjectWrapper iObjectWrapper) {
        this.zzm.addView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00cf A[Catch: RemoteException -> 0x00db, TRY_LEAVE, TryCatch #1 {RemoteException -> 0x00db, blocks: (B:25:0x009e, B:27:0x00a4, B:29:0x00b2, B:31:0x00c4, B:32:0x00cf), top: B:47:0x009e, outer: #0 }] */
    public final void zzm(zzdx zzdxVar) {
        try {
            if (this.zzj == null) {
                if (this.zzh == null || this.zzl == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Context context = this.zzm.getContext();
                zzq zzqVarZzC = zzC(context, this.zzh, this.zzn);
                zzbu zzbuVar = "search_v2".equals(zzqVarZzC.zza) ? (zzbu) new zzal(zzay.zza(), context, zzqVarZzC, this.zzl).zzd(context, false) : (zzbu) new zzaj(zzay.zza(), context, zzqVarZzC, this.zzl, this.zzb).zzd(context, false);
                this.zzj = zzbuVar;
                zzbuVar.zzD(new zzg(this.zza));
                zza zzaVar = this.zzf;
                if (zzaVar != null) {
                    this.zzj.zzC(new zzb(zzaVar));
                }
                AppEventListener appEventListener = this.zzi;
                if (appEventListener != null) {
                    this.zzj.zzG(new zzaze(appEventListener));
                }
                if (this.zzk != null) {
                    this.zzj.zzU(new zzfk(this.zzk));
                }
                this.zzj.zzP(new zzfe(this.zzp));
                this.zzj.zzN(this.zzo);
                zzbu zzbuVar2 = this.zzj;
                if (zzbuVar2 != null) {
                    try {
                        final IObjectWrapper iObjectWrapperZzn = zzbuVar2.zzn();
                        if (iObjectWrapperZzn != null) {
                            if (((Boolean) zzbhy.zzf.zze()).booleanValue()) {
                                if (((Boolean) zzba.zzc().zza(zzbgc.zzkG)).booleanValue()) {
                                    zzcdv.zza.post(new Runnable() { // from class: com.google.android.gms.ads.internal.client.zzdy
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            this.zza.zzl(iObjectWrapperZzn);
                                        }
                                    });
                                } else {
                                    this.zzm.addView((View) ObjectWrapper.unwrap(iObjectWrapperZzn));
                                }
                            } else {
                                this.zzm.addView((View) ObjectWrapper.unwrap(iObjectWrapperZzn));
                            }
                        }
                    } catch (RemoteException e) {
                        zzcec.zzl("#007 Could not call remote method.", e);
                    }
                }
            }
            zzbu zzbuVar3 = this.zzj;
            zzbuVar3.getClass();
            zzbuVar3.zzaa(this.zzc.zza(this.zzm.getContext(), zzdxVar));
        } catch (RemoteException e2) {
            zzcec.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void zzn() {
        try {
            zzbu zzbuVar = this.zzj;
            if (zzbuVar != null) {
                zzbuVar.zzz();
            }
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzo() {
        if (this.zzd.getAndSet(true)) {
            return;
        }
        try {
            zzbu zzbuVar = this.zzj;
            if (zzbuVar != null) {
                zzbuVar.zzA();
            }
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzp() {
        try {
            zzbu zzbuVar = this.zzj;
            if (zzbuVar != null) {
                zzbuVar.zzB();
            }
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzq(zza zzaVar) {
        try {
            this.zzf = zzaVar;
            zzbu zzbuVar = this.zzj;
            if (zzbuVar != null) {
                zzbuVar.zzC(zzaVar != null ? new zzb(zzaVar) : null);
            }
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzr(AdListener adListener) {
        this.zzg = adListener;
        this.zza.zza(adListener);
    }

    public final void zzs(AdSize... adSizeArr) {
        if (this.zzh != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        zzt(adSizeArr);
    }

    public final void zzt(AdSize... adSizeArr) {
        this.zzh = adSizeArr;
        try {
            zzbu zzbuVar = this.zzj;
            if (zzbuVar != null) {
                zzbuVar.zzF(zzC(this.zzm.getContext(), this.zzh, this.zzn));
            }
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
        }
        this.zzm.requestLayout();
    }

    public final void zzu(String str) {
        if (this.zzl != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.zzl = str;
    }

    public final void zzv(AppEventListener appEventListener) {
        try {
            this.zzi = appEventListener;
            zzbu zzbuVar = this.zzj;
            if (zzbuVar != null) {
                zzbuVar.zzG(appEventListener != null ? new zzaze(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzw(boolean z) {
        this.zzo = z;
        try {
            zzbu zzbuVar = this.zzj;
            if (zzbuVar != null) {
                zzbuVar.zzN(z);
            }
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzx(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzp = onPaidEventListener;
            zzbu zzbuVar = this.zzj;
            if (zzbuVar != null) {
                zzbuVar.zzP(new zzfe(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
        }
    }

    public final boolean zzz(zzbu zzbuVar) {
        try {
            IObjectWrapper iObjectWrapperZzn = zzbuVar.zzn();
            if (iObjectWrapperZzn == null || ((View) ObjectWrapper.unwrap(iObjectWrapperZzn)).getParent() != null) {
                return false;
            }
            this.zzm.addView((View) ObjectWrapper.unwrap(iObjectWrapperZzn));
            this.zzj = zzbuVar;
            return true;
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
            return false;
        }
    }

    public zzea(ViewGroup viewGroup, int i) {
        this(viewGroup, null, false, zzp.zza, null, i);
    }

    public final void zzy(VideoOptions videoOptions) {
        this.zzk = videoOptions;
        try {
            zzbu zzbuVar = this.zzj;
            if (zzbuVar != null) {
                zzbuVar.zzU(videoOptions == null ? null : new zzfk(videoOptions));
            }
        } catch (RemoteException e) {
            zzcec.zzl("#007 Could not call remote method.", e);
        }
    }

    public zzea(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzp.zza, null, 0);
    }

    public zzea(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, z, zzp.zza, null, i);
    }

    zzea(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzp zzpVar, zzbu zzbuVar, int i) {
        zzq zzqVarZze;
        this.zzb = new zzbsr();
        this.zze = new VideoController();
        this.zza = new zzdz(this);
        this.zzm = viewGroup;
        this.zzc = zzpVar;
        this.zzj = null;
        this.zzd = new AtomicBoolean(false);
        this.zzn = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzy zzyVar = new zzy(context, attributeSet);
                this.zzh = zzyVar.zzb(z);
                this.zzl = zzyVar.zza();
                if (viewGroup.isInEditMode()) {
                    zzcdv zzcdvVarZzb = zzay.zzb();
                    AdSize adSize = this.zzh[0];
                    int i2 = this.zzn;
                    if (adSize.equals(AdSize.INVALID)) {
                        zzqVarZze = zzq.zze();
                    } else {
                        zzq zzqVar = new zzq(context, adSize);
                        zzqVar.zzj = zzD(i2);
                        zzqVarZze = zzqVar;
                    }
                    zzcdvVarZzb.zzm(viewGroup, zzqVarZze, "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzay.zzb().zzl(viewGroup, new zzq(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }
}
