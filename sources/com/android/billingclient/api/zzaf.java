package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.google.android.gms.internal.play_billing.zzgd;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.android.billingclient:billing@@6.0.1 */
/* JADX INFO: loaded from: classes.dex */
final class zzaf implements ServiceConnection {
    final /* synthetic */ BillingClientImpl zza;
    private final Object zzb = new Object();
    private boolean zzc = false;
    private BillingClientStateListener zzd;

    /* synthetic */ zzaf(BillingClientImpl billingClientImpl, BillingClientStateListener billingClientStateListener, zzae zzaeVar) {
        this.zza = billingClientImpl;
        this.zzd = billingClientStateListener;
    }

    private final void zzd(BillingResult billingResult) {
        synchronized (this.zzb) {
            BillingClientStateListener billingClientStateListener = this.zzd;
            if (billingClientStateListener != null) {
                billingClientStateListener.onBillingSetupFinished(billingResult);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Billing service connected.");
        this.zza.zzg = com.google.android.gms.internal.play_billing.zzd.zzn(iBinder);
        BillingClientImpl billingClientImpl = this.zza;
        if (billingClientImpl.zzS(new Callable() { // from class: com.android.billingclient.api.zzac
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zza();
                return null;
            }
        }, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new Runnable() { // from class: com.android.billingclient.api.zzad
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzb();
            }
        }, billingClientImpl.zzO()) == null) {
            BillingResult billingResultZzQ = this.zza.zzQ();
            this.zza.zzf.zza(zzaq.zza(25, 6, billingResultZzQ));
            zzd(billingResultZzQ);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Billing service disconnected.");
        this.zza.zzf.zzc(zzgd.zzw());
        this.zza.zzg = null;
        this.zza.zza = 0;
        synchronized (this.zzb) {
            BillingClientStateListener billingClientStateListener = this.zzd;
            if (billingClientStateListener != null) {
                billingClientStateListener.onBillingServiceDisconnected();
            }
        }
    }

    final /* synthetic */ Object zza() throws Exception {
        Bundle bundle;
        int i;
        int iZzq;
        synchronized (this.zzb) {
            if (this.zzc) {
                return null;
            }
            if (TextUtils.isEmpty(null)) {
                bundle = null;
            } else {
                bundle = new Bundle();
                bundle.putString("accountName", null);
            }
            int i2 = 3;
            try {
                String packageName = this.zza.zze.getPackageName();
                iZzq = 3;
                int i3 = 20;
                while (true) {
                    if (i3 < 3) {
                        i3 = 0;
                        break;
                    }
                    if (bundle == null) {
                        try {
                            iZzq = this.zza.zzg.zzq(i3, packageName, "subs");
                        } catch (Exception e) {
                            e = e;
                            i2 = iZzq;
                            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Exception while checking if billing is supported; try to reconnect", e);
                            this.zza.zza = 0;
                            this.zza.zzg = null;
                            i = 42;
                            iZzq = i2;
                        }
                    } else {
                        iZzq = this.zza.zzg.zzc(i3, packageName, "subs", bundle);
                    }
                    if (iZzq == 0) {
                        com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "highestLevelSupportedForSubs: " + i3);
                        break;
                    }
                    i3--;
                }
                boolean z = true;
                this.zza.zzj = i3 >= 5;
                this.zza.zzi = i3 >= 3;
                if (i3 < 3) {
                    com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "In-app billing API does not support subscription on this device.");
                    i = 9;
                } else {
                    i = 1;
                }
                for (int i4 = 20; i4 >= 3; i4--) {
                    iZzq = bundle == null ? this.zza.zzg.zzq(i4, packageName, "inapp") : this.zza.zzg.zzc(i4, packageName, "inapp", bundle);
                    if (iZzq == 0) {
                        this.zza.zzk = i4;
                        com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "mHighestLevelSupportedForInApp: " + this.zza.zzk);
                        break;
                    }
                }
                BillingClientImpl billingClientImpl = this.zza;
                billingClientImpl.zzw = billingClientImpl.zzk >= 20;
                BillingClientImpl billingClientImpl2 = this.zza;
                billingClientImpl2.zzv = billingClientImpl2.zzk >= 19;
                BillingClientImpl billingClientImpl3 = this.zza;
                billingClientImpl3.zzu = billingClientImpl3.zzk >= 18;
                BillingClientImpl billingClientImpl4 = this.zza;
                billingClientImpl4.zzt = billingClientImpl4.zzk >= 17;
                BillingClientImpl billingClientImpl5 = this.zza;
                billingClientImpl5.zzs = billingClientImpl5.zzk >= 16;
                BillingClientImpl billingClientImpl6 = this.zza;
                billingClientImpl6.zzr = billingClientImpl6.zzk >= 15;
                BillingClientImpl billingClientImpl7 = this.zza;
                billingClientImpl7.zzq = billingClientImpl7.zzk >= 14;
                BillingClientImpl billingClientImpl8 = this.zza;
                billingClientImpl8.zzp = billingClientImpl8.zzk >= 12;
                BillingClientImpl billingClientImpl9 = this.zza;
                billingClientImpl9.zzo = billingClientImpl9.zzk >= 10;
                BillingClientImpl billingClientImpl10 = this.zza;
                billingClientImpl10.zzn = billingClientImpl10.zzk >= 9;
                BillingClientImpl billingClientImpl11 = this.zza;
                billingClientImpl11.zzm = billingClientImpl11.zzk >= 8;
                BillingClientImpl billingClientImpl12 = this.zza;
                if (billingClientImpl12.zzk < 6) {
                    z = false;
                }
                billingClientImpl12.zzl = z;
                if (this.zza.zzk < 3) {
                    com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "In-app billing API version 3 is not supported on this device.");
                    i = 36;
                }
                if (iZzq == 0) {
                    this.zza.zza = 2;
                } else {
                    this.zza.zza = 0;
                    this.zza.zzg = null;
                }
            } catch (Exception e2) {
                e = e2;
            }
            if (iZzq == 0) {
                this.zza.zzf.zzb(zzaq.zzb(6));
                zzd(zzat.zzl);
            } else {
                this.zza.zzf.zza(zzaq.zza(i, 6, zzat.zza));
                zzd(zzat.zza);
            }
            return null;
        }
    }

    final /* synthetic */ void zzb() {
        this.zza.zza = 0;
        this.zza.zzg = null;
        this.zza.zzf.zza(zzaq.zza(24, 6, zzat.zzn));
        zzd(zzat.zzn);
    }

    final void zzc() {
        synchronized (this.zzb) {
            this.zzd = null;
            this.zzc = true;
        }
    }
}
