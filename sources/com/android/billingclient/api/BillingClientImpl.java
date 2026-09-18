package com.android.billingclient.api;

import android.R;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.BundleCompat;
import androidx.work.WorkRequest;
import com.android.billingclient.BuildConfig;
import com.google.android.gms.internal.play_billing.zzfa;
import com.google.android.gms.internal.play_billing.zzfb;
import com.google.android.gms.internal.play_billing.zzfe;
import com.google.android.gms.internal.play_billing.zzff;
import com.google.android.gms.internal.play_billing.zzfh;
import com.google.android.gms.internal.play_billing.zzfj;
import com.google.android.gms.internal.play_billing.zzfl;
import com.google.android.gms.internal.play_billing.zzfm;
import com.google.android.gms.internal.play_billing.zzfu;
import com.google.android.gms.internal.play_billing.zzfw;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@6.0.1 */
/* JADX INFO: loaded from: classes.dex */
class BillingClientImpl extends BillingClient {
    private volatile int zza;
    private final String zzb;
    private final Handler zzc;
    private volatile zzh zzd;
    private Context zze;
    private zzar zzf;
    private volatile com.google.android.gms.internal.play_billing.zze zzg;
    private volatile zzaf zzh;
    private boolean zzi;
    private boolean zzj;
    private int zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private zzbe zzx;
    private boolean zzy;
    private ExecutorService zzz;

    private BillingClientImpl(Activity activity, zzbe zzbeVar, String str) {
        this(activity.getApplicationContext(), zzbeVar, new zzaj(), str, null, null, null);
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzbe zzbeVar, AlternativeBillingListener alternativeBillingListener, String str, zzar zzarVar) {
        this.zze = context.getApplicationContext();
        zzfl zzflVarZzv = zzfm.zzv();
        zzflVarZzv.zzj(str);
        zzflVarZzv.zzi(this.zze.getPackageName());
        if (zzarVar != null) {
            this.zzf = zzarVar;
        } else {
            this.zzf = new zzaw(this.zze, (zzfm) zzflVarZzv.zzc());
        }
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzd = new zzh(this.zze, purchasesUpdatedListener, alternativeBillingListener, this.zzf);
        this.zzx = zzbeVar;
        this.zzy = alternativeBillingListener != null;
    }

    private int launchBillingFlowCpp(Activity activity, BillingFlowParams billingFlowParams) {
        return launchBillingFlow(activity, billingFlowParams).getResponseCode();
    }

    private void startConnection(long j) {
        zzaj zzajVar = new zzaj(j);
        if (isReady()) {
            com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Service connection is valid. No need to re-initialize.");
            this.zzf.zzb(zzaq.zzb(6));
            zzajVar.onBillingSetupFinished(zzat.zzl);
            return;
        }
        int i = 1;
        if (this.zza == 1) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Client is already in the process of connecting to billing service.");
            this.zzf.zza(zzaq.zza(37, 6, zzat.zzd));
            zzajVar.onBillingSetupFinished(zzat.zzd);
            return;
        }
        if (this.zza == 3) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            this.zzf.zza(zzaq.zza(38, 6, zzat.zzm));
            zzajVar.onBillingSetupFinished(zzat.zzm);
            return;
        }
        this.zza = 1;
        this.zzd.zze();
        com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Starting in-app billing setup.");
        this.zzh = new zzaf(this, zzajVar, null);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List<ResolveInfo> listQueryIntentServices = this.zze.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            i = 41;
        } else {
            ResolveInfo resolveInfo = listQueryIntentServices.get(0);
            if (resolveInfo.serviceInfo != null) {
                String str = resolveInfo.serviceInfo.packageName;
                String str2 = resolveInfo.serviceInfo.name;
                if (!"com.android.vending".equals(str) || str2 == null) {
                    com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "The device doesn't have valid Play Store.");
                    i = 40;
                } else {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    intent2.putExtra("playBillingLibraryVersion", this.zzb);
                    if (this.zze.bindService(intent2, this.zzh, 1)) {
                        com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Service was bonded successfully.");
                        return;
                    } else {
                        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Connection to Billing service is blocked.");
                        i = 39;
                    }
                }
            }
        }
        this.zza = 0;
        com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Billing service unavailable on device.");
        this.zzf.zza(zzaq.zza(i, 6, zzat.zzc));
        zzajVar.onBillingSetupFinished(zzat.zzc);
    }

    static /* synthetic */ zzbj zzN(BillingClientImpl billingClientImpl, String str, int i) {
        Bundle bundleZzi;
        com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Querying owned items, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        int i2 = 0;
        Bundle bundleZzc = com.google.android.gms.internal.play_billing.zzb.zzc(billingClientImpl.zzn, billingClientImpl.zzv, true, false, billingClientImpl.zzb);
        List list = null;
        String string = null;
        while (true) {
            try {
                if (billingClientImpl.zzn) {
                    bundleZzi = billingClientImpl.zzg.zzj(z != billingClientImpl.zzv ? 9 : 19, billingClientImpl.zze.getPackageName(), str, string, bundleZzc);
                } else {
                    bundleZzi = billingClientImpl.zzg.zzi(3, billingClientImpl.zze.getPackageName(), str, string);
                }
                zzbk zzbkVarZza = zzbl.zza(bundleZzi, "BillingClient", "getPurchase()");
                BillingResult billingResultZza = zzbkVarZza.zza();
                if (billingResultZza != zzat.zzl) {
                    billingClientImpl.zzf.zza(zzaq.zza(zzbkVarZza.zzb(), 9, billingResultZza));
                    return new zzbj(billingResultZza, list);
                }
                ArrayList<String> stringArrayList = bundleZzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = bundleZzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = bundleZzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                int i3 = i2;
                int i4 = i3;
                while (i3 < stringArrayList2.size()) {
                    String str2 = stringArrayList2.get(i3);
                    String str3 = stringArrayList3.get(i3);
                    com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i3))));
                    try {
                        Purchase purchase = new Purchase(str2, str3);
                        if (TextUtils.isEmpty(purchase.getPurchaseToken())) {
                            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "BUG: empty/null token!");
                            i4 = 1;
                        }
                        arrayList.add(purchase);
                        i3++;
                    } catch (JSONException e) {
                        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Got an exception trying to decode the purchase!", e);
                        billingClientImpl.zzf.zza(zzaq.zza(51, 9, zzat.zzj));
                        return new zzbj(zzat.zzj, null);
                    }
                }
                if (i4 != 0) {
                    billingClientImpl.zzf.zza(zzaq.zza(26, 9, zzat.zzj));
                }
                string = bundleZzi.getString("INAPP_CONTINUATION_TOKEN");
                com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
                if (TextUtils.isEmpty(string)) {
                    return new zzbj(zzat.zzl, arrayList);
                }
                list = null;
                z = true;
                i2 = 0;
            } catch (Exception e2) {
                billingClientImpl.zzf.zza(zzaq.zza(52, 9, zzat.zzm));
                com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Got exception trying to get purchasesm try to reconnect", e2);
                return new zzbj(zzat.zzm, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler zzO() {
        return Looper.myLooper() == null ? this.zzc : new Handler(Looper.myLooper());
    }

    private final BillingResult zzP(final BillingResult billingResult) {
        if (Thread.interrupted()) {
            return billingResult;
        }
        this.zzc.post(new Runnable() { // from class: com.android.billingclient.api.zzx
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzH(billingResult);
            }
        });
        return billingResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BillingResult zzQ() {
        return (this.zza == 0 || this.zza == 3) ? zzat.zzm : zzat.zzj;
    }

    private static String zzR() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return BuildConfig.VERSION_NAME;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Future zzS(Callable callable, long j, final Runnable runnable, Handler handler) {
        if (this.zzz == null) {
            this.zzz = Executors.newFixedThreadPool(com.google.android.gms.internal.play_billing.zzb.zza, new zzab(this));
        }
        try {
            final Future futureSubmit = this.zzz.submit(callable);
            handler.postDelayed(new Runnable() { // from class: com.android.billingclient.api.zzw
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = futureSubmit;
                    Runnable runnable2 = runnable;
                    if (future.isDone() || future.isCancelled()) {
                        return;
                    }
                    future.cancel(true);
                    com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Async task is taking too long, cancel it!");
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }, (long) (j * 0.95d));
            return futureSubmit;
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Async task throws exception!", e);
            return null;
        }
    }

    private final void zzT(String str, final PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        if (!isReady()) {
            this.zzf.zza(zzaq.zza(2, 11, zzat.zzm));
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzat.zzm, null);
        } else if (zzS(new zzz(this, str, purchaseHistoryResponseListener), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new Runnable() { // from class: com.android.billingclient.api.zzo
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzK(purchaseHistoryResponseListener);
            }
        }, zzO()) == null) {
            BillingResult billingResultZzQ = zzQ();
            this.zzf.zza(zzaq.zza(25, 11, billingResultZzQ));
            purchaseHistoryResponseListener.onPurchaseHistoryResponse(billingResultZzQ, null);
        }
    }

    private final void zzU(String str, final PurchasesResponseListener purchasesResponseListener) {
        if (!isReady()) {
            this.zzf.zza(zzaq.zza(2, 9, zzat.zzm));
            purchasesResponseListener.onQueryPurchasesResponse(zzat.zzm, com.google.android.gms.internal.play_billing.zzu.zzk());
        } else if (TextUtils.isEmpty(str)) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Please provide a valid product type.");
            this.zzf.zza(zzaq.zza(50, 9, zzat.zzg));
            purchasesResponseListener.onQueryPurchasesResponse(zzat.zzg, com.google.android.gms.internal.play_billing.zzu.zzk());
        } else if (zzS(new zzy(this, str, purchasesResponseListener), WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new Runnable() { // from class: com.android.billingclient.api.zzu
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzL(purchasesResponseListener);
            }
        }, zzO()) == null) {
            BillingResult billingResultZzQ = zzQ();
            this.zzf.zza(zzaq.zza(25, 9, billingResultZzQ));
            purchasesResponseListener.onQueryPurchasesResponse(billingResultZzQ, com.google.android.gms.internal.play_billing.zzu.zzk());
        }
    }

    private final void zzV(BillingResult billingResult, int i, int i2) {
        if (billingResult.getResponseCode() == 0) {
            zzar zzarVar = this.zzf;
            zzfe zzfeVarZzv = zzff.zzv();
            zzfeVarZzv.zzj(5);
            zzfu zzfuVarZzv = zzfw.zzv();
            zzfuVarZzv.zzi(i2);
            zzfeVarZzv.zzi((zzfw) zzfuVarZzv.zzc());
            zzarVar.zzb((zzff) zzfeVarZzv.zzc());
            return;
        }
        zzar zzarVar2 = this.zzf;
        zzfa zzfaVarZzv = zzfb.zzv();
        zzfh zzfhVarZzv = zzfj.zzv();
        zzfhVarZzv.zzj(billingResult.getResponseCode());
        zzfhVarZzv.zzi(billingResult.getDebugMessage());
        zzfhVarZzv.zzk(i);
        zzfaVarZzv.zzi(zzfhVarZzv);
        zzfaVarZzv.zzk(5);
        zzfu zzfuVarZzv2 = zzfw.zzv();
        zzfuVarZzv2.zzi(i2);
        zzfaVarZzv.zzj((zzfw) zzfuVarZzv2.zzc());
        zzarVar2.zza((zzfb) zzfaVarZzv.zzc());
    }

    static /* synthetic */ zzai zzf(BillingClientImpl billingClientImpl, String str) {
        com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Querying purchase history, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        int i = 0;
        Bundle bundleZzc = com.google.android.gms.internal.play_billing.zzb.zzc(billingClientImpl.zzn, billingClientImpl.zzv, true, false, billingClientImpl.zzb);
        String string = null;
        while (billingClientImpl.zzl) {
            try {
                Bundle bundleZzh = billingClientImpl.zzg.zzh(6, billingClientImpl.zze.getPackageName(), str, string, bundleZzc);
                zzbk zzbkVarZza = zzbl.zza(bundleZzh, "BillingClient", "getPurchaseHistory()");
                BillingResult billingResultZza = zzbkVarZza.zza();
                if (billingResultZza != zzat.zzl) {
                    billingClientImpl.zzf.zza(zzaq.zza(zzbkVarZza.zzb(), 11, billingResultZza));
                    return new zzai(billingResultZza, null);
                }
                ArrayList<String> stringArrayList = bundleZzh.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = bundleZzh.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = bundleZzh.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                int i2 = i;
                int i3 = i2;
                while (i2 < stringArrayList2.size()) {
                    String str2 = stringArrayList2.get(i2);
                    String str3 = stringArrayList3.get(i2);
                    com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Purchase record found for sku : ".concat(String.valueOf(stringArrayList.get(i2))));
                    try {
                        PurchaseHistoryRecord purchaseHistoryRecord = new PurchaseHistoryRecord(str2, str3);
                        if (TextUtils.isEmpty(purchaseHistoryRecord.getPurchaseToken())) {
                            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "BUG: empty/null token!");
                            i3 = 1;
                        }
                        arrayList.add(purchaseHistoryRecord);
                        i2++;
                    } catch (JSONException e) {
                        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Got an exception trying to decode the purchase!", e);
                        billingClientImpl.zzf.zza(zzaq.zza(51, 11, zzat.zzj));
                        return new zzai(zzat.zzj, null);
                    }
                }
                if (i3 != 0) {
                    billingClientImpl.zzf.zza(zzaq.zza(26, 11, zzat.zzj));
                }
                string = bundleZzh.getString("INAPP_CONTINUATION_TOKEN");
                com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
                if (TextUtils.isEmpty(string)) {
                    return new zzai(zzat.zzl, arrayList);
                }
                i = 0;
            } catch (RemoteException e2) {
                com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Got exception trying to get purchase history, try to reconnect", e2);
                billingClientImpl.zzf.zza(zzaq.zza(59, 11, zzat.zzm));
                return new zzai(zzat.zzm, null);
            }
        }
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "getPurchaseHistory is not supported on current device");
        return new zzai(zzat.zzq, null);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void acknowledgePurchase(final AcknowledgePurchaseParams acknowledgePurchaseParams, final AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        if (!isReady()) {
            this.zzf.zza(zzaq.zza(2, 3, zzat.zzm));
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzat.zzm);
            return;
        }
        if (TextUtils.isEmpty(acknowledgePurchaseParams.getPurchaseToken())) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Please provide a valid purchase token.");
            this.zzf.zza(zzaq.zza(26, 3, zzat.zzi));
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzat.zzi);
        } else if (!this.zzn) {
            this.zzf.zza(zzaq.zza(27, 3, zzat.zzb));
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzat.zzb);
        } else if (zzS(new Callable() { // from class: com.android.billingclient.api.zzp
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzj(acknowledgePurchaseParams, acknowledgePurchaseResponseListener);
                return null;
            }
        }, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new Runnable() { // from class: com.android.billingclient.api.zzq
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzG(acknowledgePurchaseResponseListener);
            }
        }, zzO()) == null) {
            BillingResult billingResultZzQ = zzQ();
            this.zzf.zza(zzaq.zza(25, 3, billingResultZzQ));
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResultZzQ);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void consumeAsync(final ConsumeParams consumeParams, final ConsumeResponseListener consumeResponseListener) {
        if (!isReady()) {
            this.zzf.zza(zzaq.zza(2, 4, zzat.zzm));
            consumeResponseListener.onConsumeResponse(zzat.zzm, consumeParams.getPurchaseToken());
        } else if (zzS(new Callable() { // from class: com.android.billingclient.api.zzm
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzk(consumeParams, consumeResponseListener);
                return null;
            }
        }, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new Runnable() { // from class: com.android.billingclient.api.zzn
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzI(consumeResponseListener, consumeParams);
            }
        }, zzO()) == null) {
            BillingResult billingResultZzQ = zzQ();
            this.zzf.zza(zzaq.zza(25, 4, billingResultZzQ));
            consumeResponseListener.onConsumeResponse(billingResultZzQ, consumeParams.getPurchaseToken());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void endConnection() {
        this.zzf.zzb(zzaq.zzb(12));
        try {
            this.zzd.zzd();
            if (this.zzh != null) {
                this.zzh.zzc();
            }
            if (this.zzh != null && this.zzg != null) {
                com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Unbinding from service.");
                this.zze.unbindService(this.zzh);
                this.zzh = null;
            }
            this.zzg = null;
            ExecutorService executorService = this.zzz;
            if (executorService != null) {
                executorService.shutdownNow();
                this.zzz = null;
            }
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "There was an exception while ending connection!", e);
        } finally {
            this.zza = 3;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final int getConnectionState() {
        return this.zza;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:49:0x00b9  */
    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult isFeatureSupported(String str) {
        if (!isReady()) {
            BillingResult billingResult = zzat.zzm;
            if (billingResult.getResponseCode() != 0) {
                this.zzf.zza(zzaq.zza(2, 5, billingResult));
            } else {
                this.zzf.zzb(zzaq.zzb(5));
            }
            return zzat.zzm;
        }
        int i = zzat.zzD;
        switch (str) {
            case "subscriptions":
                BillingResult billingResult2 = this.zzi ? zzat.zzl : zzat.zzo;
                zzV(billingResult2, 9, 2);
                return billingResult2;
            case "subscriptionsUpdate":
                BillingResult billingResult3 = this.zzj ? zzat.zzl : zzat.zzp;
                zzV(billingResult3, 10, 3);
                return billingResult3;
            case "priceChangeConfirmation":
                BillingResult billingResult4 = this.zzm ? zzat.zzl : zzat.zzr;
                zzV(billingResult4, 35, 4);
                return billingResult4;
            case "bbb":
                BillingResult billingResult5 = this.zzp ? zzat.zzl : zzat.zzw;
                zzV(billingResult5, 30, 5);
                return billingResult5;
            case "aaa":
                BillingResult billingResult6 = this.zzr ? zzat.zzl : zzat.zzs;
                zzV(billingResult6, 31, 6);
                return billingResult6;
            case "ddd":
                BillingResult billingResult7 = this.zzq ? zzat.zzl : zzat.zzu;
                zzV(billingResult7, 21, 7);
                return billingResult7;
            case "ccc":
                BillingResult billingResult8 = this.zzs ? zzat.zzl : zzat.zzt;
                zzV(billingResult8, 19, 8);
                return billingResult8;
            case "eee":
                BillingResult billingResult9 = this.zzs ? zzat.zzl : zzat.zzt;
                zzV(billingResult9, 61, 9);
                return billingResult9;
            case "fff":
                BillingResult billingResult10 = this.zzt ? zzat.zzl : zzat.zzv;
                zzV(billingResult10, 20, 10);
                return billingResult10;
            case "ggg":
                BillingResult billingResult11 = this.zzu ? zzat.zzl : zzat.zzz;
                zzV(billingResult11, 32, 11);
                return billingResult11;
            case "hhh":
                BillingResult billingResult12 = this.zzu ? zzat.zzl : zzat.zzA;
                zzV(billingResult12, 33, 12);
                return billingResult12;
            case "iii":
                BillingResult billingResult13 = this.zzw ? zzat.zzl : zzat.zzC;
                zzV(billingResult13, 60, 13);
                return billingResult13;
            default:
                com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Unsupported feature: ".concat(String.valueOf(str)));
                zzV(zzat.zzy, 34, 1);
                return zzat.zzy;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final boolean isReady() {
        return (this.zza != 2 || this.zzg == null || this.zzh == null) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:148:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:151:0x03e1  */
    /* JADX WARN: Code duplicated, block: B:152:0x03e9  */
    /* JADX WARN: Code duplicated, block: B:154:0x03f7  */
    /* JADX WARN: Code duplicated, block: B:167:0x0428  */
    /* JADX WARN: Code duplicated, block: B:169:0x042c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:171:0x0431  */
    /* JADX WARN: Code duplicated, block: B:173:0x0435  */
    /* JADX WARN: Code duplicated, block: B:174:0x0438  */
    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult launchBillingFlow(Activity activity, final BillingFlowParams billingFlowParams) {
        final String productId;
        final String productType;
        String str;
        Future futureZzS;
        boolean z;
        String str2;
        SkuDetails skuDetails;
        BillingFlowParams.ProductDetailsParams productDetailsParams;
        String str3;
        String str4;
        String str5;
        boolean z2;
        Intent intent;
        String str6;
        int i;
        final int i2;
        final BillingClientImpl billingClientImpl = this;
        if (!isReady()) {
            billingClientImpl.zzf.zza(zzaq.zza(2, 2, zzat.zzm));
            BillingResult billingResult = zzat.zzm;
            billingClientImpl.zzP(billingResult);
            return billingResult;
        }
        ArrayList<SkuDetails> arrayListZzg = billingFlowParams.zzg();
        List listZzh = billingFlowParams.zzh();
        SkuDetails skuDetails2 = (SkuDetails) com.google.android.gms.internal.play_billing.zzz.zza(arrayListZzg, null);
        BillingFlowParams.ProductDetailsParams productDetailsParams2 = (BillingFlowParams.ProductDetailsParams) com.google.android.gms.internal.play_billing.zzz.zza(listZzh, null);
        if (skuDetails2 != null) {
            productId = skuDetails2.getSku();
            productType = skuDetails2.getType();
        } else {
            productId = productDetailsParams2.zza().getProductId();
            productType = productDetailsParams2.zza().getProductType();
        }
        if (productType.equals("subs") && !billingClientImpl.zzi) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Current client doesn't support subscriptions.");
            billingClientImpl.zzf.zza(zzaq.zza(9, 2, zzat.zzo));
            BillingResult billingResult2 = zzat.zzo;
            billingClientImpl.zzP(billingResult2);
            return billingResult2;
        }
        if (billingFlowParams.zzq() && !billingClientImpl.zzl) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Current client doesn't support extra params for buy intent.");
            billingClientImpl.zzf.zza(zzaq.zza(18, 2, zzat.zzh));
            BillingResult billingResult3 = zzat.zzh;
            billingClientImpl.zzP(billingResult3);
            return billingResult3;
        }
        if (arrayListZzg.size() > 1 && !billingClientImpl.zzs) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Current client doesn't support multi-item purchases.");
            billingClientImpl.zzf.zza(zzaq.zza(19, 2, zzat.zzt));
            BillingResult billingResult4 = zzat.zzt;
            billingClientImpl.zzP(billingResult4);
            return billingResult4;
        }
        if (!listZzh.isEmpty() && !billingClientImpl.zzt) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Current client doesn't support purchases with ProductDetails.");
            billingClientImpl.zzf.zza(zzaq.zza(20, 2, zzat.zzv));
            BillingResult billingResult5 = zzat.zzv;
            billingClientImpl.zzP(billingResult5);
            return billingResult5;
        }
        if (billingClientImpl.zzl) {
            boolean z3 = billingClientImpl.zzn;
            boolean z4 = billingClientImpl.zzy;
            String str7 = billingClientImpl.zzb;
            final Bundle bundle = new Bundle();
            bundle.putString("playBillingLibraryVersion", str7);
            if (billingFlowParams.zzb() != 0) {
                bundle.putInt("prorationMode", billingFlowParams.zzb());
            } else if (billingFlowParams.zza() != 0) {
                bundle.putInt("prorationMode", billingFlowParams.zza());
            }
            if (!TextUtils.isEmpty(billingFlowParams.zzc())) {
                bundle.putString(BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, billingFlowParams.zzc());
            }
            if (!TextUtils.isEmpty(billingFlowParams.zzd())) {
                bundle.putString("obfuscatedProfileId", billingFlowParams.zzd());
            }
            if (billingFlowParams.zzp()) {
                bundle.putBoolean("isOfferPersonalizedByDeveloper", true);
            }
            if (!TextUtils.isEmpty(null)) {
                bundle.putStringArrayList("skusToReplace", new ArrayList<>(Arrays.asList(null)));
            }
            if (!TextUtils.isEmpty(billingFlowParams.zze())) {
                bundle.putString("oldSkuPurchaseToken", billingFlowParams.zze());
            }
            String str8 = null;
            if (!TextUtils.isEmpty(null)) {
                bundle.putString("oldSkuPurchaseId", null);
            }
            if (!TextUtils.isEmpty(billingFlowParams.zzf())) {
                bundle.putString("originalExternalTransactionId", billingFlowParams.zzf());
                str8 = null;
            }
            if (!TextUtils.isEmpty(str8)) {
                bundle.putString("paymentsPurchaseParams", str8);
            }
            if (z3) {
                z = true;
                bundle.putBoolean("enablePendingPurchases", true);
            } else {
                z = true;
            }
            if (z4) {
                bundle.putBoolean("enableAlternativeBilling", z);
            }
            final String str9 = productType;
            if (arrayListZzg.isEmpty()) {
                str2 = "proxyPackageVersion";
                skuDetails = skuDetails2;
                productDetailsParams = productDetailsParams2;
                str3 = productId;
                str4 = "BillingClient";
                ArrayList<String> arrayList = new ArrayList<>(listZzh.size() - 1);
                ArrayList<String> arrayList2 = new ArrayList<>(listZzh.size() - 1);
                ArrayList<String> arrayList3 = new ArrayList<>();
                ArrayList<String> arrayList4 = new ArrayList<>();
                ArrayList<String> arrayList5 = new ArrayList<>();
                for (int i3 = 0; i3 < listZzh.size(); i3++) {
                    BillingFlowParams.ProductDetailsParams productDetailsParams3 = (BillingFlowParams.ProductDetailsParams) listZzh.get(i3);
                    ProductDetails productDetailsZza = productDetailsParams3.zza();
                    if (!productDetailsZza.zzb().isEmpty()) {
                        arrayList3.add(productDetailsZza.zzb());
                    }
                    arrayList4.add(productDetailsParams3.zzb());
                    if (!TextUtils.isEmpty(productDetailsZza.zzc())) {
                        arrayList5.add(productDetailsZza.zzc());
                    }
                    if (i3 > 0) {
                        arrayList.add(((BillingFlowParams.ProductDetailsParams) listZzh.get(i3)).zza().getProductId());
                        arrayList2.add(((BillingFlowParams.ProductDetailsParams) listZzh.get(i3)).zza().getProductType());
                    }
                }
                bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList4);
                if (!arrayList3.isEmpty()) {
                    bundle.putStringArrayList("skuDetailsTokens", arrayList3);
                }
                if (!arrayList5.isEmpty()) {
                    bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5);
                }
                if (!arrayList.isEmpty()) {
                    bundle.putStringArrayList("additionalSkus", arrayList);
                    bundle.putStringArrayList("additionalSkuTypes", arrayList2);
                }
            } else {
                ArrayList<String> arrayList6 = new ArrayList<>();
                ArrayList<String> arrayList7 = new ArrayList<>();
                str3 = productId;
                ArrayList<String> arrayList8 = new ArrayList<>();
                str2 = "proxyPackageVersion";
                ArrayList<Integer> arrayList9 = new ArrayList<>();
                str4 = "BillingClient";
                ArrayList<String> arrayList10 = new ArrayList<>();
                boolean z5 = false;
                boolean z6 = false;
                boolean z7 = false;
                boolean z8 = false;
                for (SkuDetails skuDetails3 : arrayListZzg) {
                    if (!skuDetails3.zzf().isEmpty()) {
                        arrayList6.add(skuDetails3.zzf());
                    }
                    String strZzc = skuDetails3.zzc();
                    SkuDetails skuDetails4 = skuDetails2;
                    String strZzb = skuDetails3.zzb();
                    int iZza = skuDetails3.zza();
                    String strZze = skuDetails3.zze();
                    arrayList7.add(strZzc);
                    z5 |= !TextUtils.isEmpty(strZzc);
                    arrayList8.add(strZzb);
                    z6 |= !TextUtils.isEmpty(strZzb);
                    arrayList9.add(Integer.valueOf(iZza));
                    z7 |= iZza != 0;
                    z8 |= !TextUtils.isEmpty(strZze);
                    arrayList10.add(strZze);
                    productDetailsParams2 = productDetailsParams2;
                    skuDetails2 = skuDetails4;
                }
                skuDetails = skuDetails2;
                productDetailsParams = productDetailsParams2;
                if (!arrayList6.isEmpty()) {
                    bundle.putStringArrayList("skuDetailsTokens", arrayList6);
                }
                if (z5) {
                    bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList7);
                }
                if (z6) {
                    bundle.putStringArrayList("SKU_OFFER_ID_LIST", arrayList8);
                }
                if (z7) {
                    bundle.putIntegerArrayList("SKU_OFFER_TYPE_LIST", arrayList9);
                }
                if (z8) {
                    bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList10);
                }
                if (arrayListZzg.size() > 1) {
                    ArrayList<String> arrayList11 = new ArrayList<>(arrayListZzg.size() - 1);
                    ArrayList<String> arrayList12 = new ArrayList<>(arrayListZzg.size() - 1);
                    for (int i4 = 1; i4 < arrayListZzg.size(); i4++) {
                        arrayList11.add(((SkuDetails) arrayListZzg.get(i4)).getSku());
                        arrayList12.add(((SkuDetails) arrayListZzg.get(i4)).getType());
                    }
                    bundle.putStringArrayList("additionalSkus", arrayList11);
                    bundle.putStringArrayList("additionalSkuTypes", arrayList12);
                }
            }
            billingClientImpl = this;
            if (bundle.containsKey("SKU_OFFER_ID_TOKEN_LIST") && !billingClientImpl.zzq) {
                billingClientImpl.zzf.zza(zzaq.zza(21, 2, zzat.zzu));
                BillingResult billingResult6 = zzat.zzu;
                billingClientImpl.zzP(billingResult6);
                return billingResult6;
            }
            if (skuDetails == null || TextUtils.isEmpty(skuDetails.zzd())) {
                if (productDetailsParams == null || TextUtils.isEmpty(productDetailsParams.zza().zza())) {
                    str5 = null;
                    z2 = false;
                } else {
                    bundle.putString("skuPackageName", productDetailsParams.zza().zza());
                }
                if (!TextUtils.isEmpty(str5)) {
                    bundle.putString("accountName", str5);
                }
                intent = activity.getIntent();
                if (intent == null) {
                    str = str4;
                    com.google.android.gms.internal.play_billing.zzb.zzj(str, "Activity's intent is null.");
                } else {
                    str = str4;
                    if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                        String stringExtra = intent.getStringExtra("PROXY_PACKAGE");
                        bundle.putString("proxyPackage", stringExtra);
                        try {
                            str6 = str2;
                            try {
                                bundle.putString(str6, billingClientImpl.zze.getPackageManager().getPackageInfo(stringExtra, 0).versionName);
                            } catch (PackageManager.NameNotFoundException unused) {
                                bundle.putString(str6, "package not found");
                            }
                        } catch (PackageManager.NameNotFoundException unused2) {
                            str6 = str2;
                        }
                    }
                }
                if (!billingClientImpl.zzt && !listZzh.isEmpty()) {
                    i = 17;
                } else if (billingClientImpl.zzr || !z2) {
                    if (billingClientImpl.zzn) {
                        i2 = 9;
                    } else {
                        i = 6;
                    }
                    final String str10 = str3;
                    futureZzS = zzS(new Callable() { // from class: com.android.billingclient.api.zzs
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return this.zza.zzc(i2, str10, str9, billingFlowParams, bundle);
                        }
                    }, 5000L, null, billingClientImpl.zzc);
                } else {
                    i = 15;
                }
                i2 = i;
                final String str11 = str3;
                futureZzS = zzS(new Callable() { // from class: com.android.billingclient.api.zzs
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.zza.zzc(i2, str11, str9, billingFlowParams, bundle);
                    }
                }, 5000L, null, billingClientImpl.zzc);
            } else {
                bundle.putString("skuPackageName", skuDetails.zzd());
            }
            str5 = null;
            z2 = true;
            if (!TextUtils.isEmpty(str5)) {
                bundle.putString("accountName", str5);
            }
            intent = activity.getIntent();
            if (intent == null) {
                str = str4;
                com.google.android.gms.internal.play_billing.zzb.zzj(str, "Activity's intent is null.");
            } else {
                str = str4;
                if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                    String stringExtra2 = intent.getStringExtra("PROXY_PACKAGE");
                    bundle.putString("proxyPackage", stringExtra2);
                    str6 = str2;
                    bundle.putString(str6, billingClientImpl.zze.getPackageManager().getPackageInfo(stringExtra2, 0).versionName);
                }
            }
            if (!billingClientImpl.zzt) {
                if (billingClientImpl.zzr) {
                    if (billingClientImpl.zzn) {
                        i2 = 9;
                    } else {
                        i = 6;
                        i2 = i;
                    }
                } else if (billingClientImpl.zzn) {
                    i2 = 9;
                } else {
                    i = 6;
                    i2 = i;
                }
            } else if (billingClientImpl.zzr) {
                if (billingClientImpl.zzn) {
                    i2 = 9;
                } else {
                    i = 6;
                    i2 = i;
                }
            } else if (billingClientImpl.zzn) {
                i2 = 9;
            } else {
                i = 6;
                i2 = i;
            }
            final String str12 = str3;
            futureZzS = zzS(new Callable() { // from class: com.android.billingclient.api.zzs
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzc(i2, str12, str9, billingFlowParams, bundle);
                }
            }, 5000L, null, billingClientImpl.zzc);
        } else {
            str = "BillingClient";
            futureZzS = zzS(new Callable() { // from class: com.android.billingclient.api.zzt
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzd(productId, productType);
                }
            }, 5000L, null, billingClientImpl.zzc);
        }
        try {
            Bundle bundle2 = (Bundle) futureZzS.get(5000L, TimeUnit.MILLISECONDS);
            int iZzb = com.google.android.gms.internal.play_billing.zzb.zzb(bundle2, str);
            String strZzf = com.google.android.gms.internal.play_billing.zzb.zzf(bundle2, str);
            if (iZzb == 0) {
                Intent intent2 = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
                intent2.putExtra("BUY_INTENT", (PendingIntent) bundle2.getParcelable("BUY_INTENT"));
                activity.startActivity(intent2);
                return zzat.zzl;
            }
            com.google.android.gms.internal.play_billing.zzb.zzj(str, "Unable to buy item, Error response code: " + iZzb);
            BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
            builderNewBuilder.setResponseCode(iZzb);
            builderNewBuilder.setDebugMessage(strZzf);
            BillingResult billingResultBuild = builderNewBuilder.build();
            billingClientImpl.zzf.zza(zzaq.zza(3, 2, billingResultBuild));
            billingClientImpl.zzP(billingResultBuild);
            return billingResultBuild;
        } catch (CancellationException e) {
            e = e;
            com.google.android.gms.internal.play_billing.zzb.zzk(str, "Time out while launching billing flow. Try to reconnect", e);
            billingClientImpl.zzf.zza(zzaq.zza(4, 2, zzat.zzn));
            BillingResult billingResult7 = zzat.zzn;
            billingClientImpl.zzP(billingResult7);
            return billingResult7;
        } catch (TimeoutException e2) {
            e = e2;
            com.google.android.gms.internal.play_billing.zzb.zzk(str, "Time out while launching billing flow. Try to reconnect", e);
            billingClientImpl.zzf.zza(zzaq.zza(4, 2, zzat.zzn));
            BillingResult billingResult8 = zzat.zzn;
            billingClientImpl.zzP(billingResult8);
            return billingResult8;
        } catch (Exception e3) {
            com.google.android.gms.internal.play_billing.zzb.zzk(str, "Exception while launching billing flow. Try to reconnect", e3);
            billingClientImpl.zzf.zza(zzaq.zza(5, 2, zzat.zzm));
            BillingResult billingResult9 = zzat.zzm;
            billingClientImpl.zzP(billingResult9);
            return billingResult9;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryProductDetailsAsync(final QueryProductDetailsParams queryProductDetailsParams, final ProductDetailsResponseListener productDetailsResponseListener) {
        if (!isReady()) {
            this.zzf.zza(zzaq.zza(2, 7, zzat.zzm));
            productDetailsResponseListener.onProductDetailsResponse(zzat.zzm, new ArrayList());
        } else if (!this.zzt) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Querying product details is not supported.");
            this.zzf.zza(zzaq.zza(20, 7, zzat.zzv));
            productDetailsResponseListener.onProductDetailsResponse(zzat.zzv, new ArrayList());
        } else if (zzS(new Callable() { // from class: com.android.billingclient.api.zzk
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzl(queryProductDetailsParams, productDetailsResponseListener);
                return null;
            }
        }, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new Runnable() { // from class: com.android.billingclient.api.zzl
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzJ(productDetailsResponseListener);
            }
        }, zzO()) == null) {
            BillingResult billingResultZzQ = zzQ();
            this.zzf.zza(zzaq.zza(25, 7, billingResultZzQ));
            productDetailsResponseListener.onProductDetailsResponse(billingResultZzQ, new ArrayList());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchaseHistoryAsync(QueryPurchaseHistoryParams queryPurchaseHistoryParams, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        zzT(queryPurchaseHistoryParams.zza(), purchaseHistoryResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchasesAsync(QueryPurchasesParams queryPurchasesParams, PurchasesResponseListener purchasesResponseListener) {
        zzU(queryPurchasesParams.zza(), purchasesResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void querySkuDetailsAsync(SkuDetailsParams skuDetailsParams, final SkuDetailsResponseListener skuDetailsResponseListener) {
        if (!isReady()) {
            this.zzf.zza(zzaq.zza(2, 8, zzat.zzm));
            skuDetailsResponseListener.onSkuDetailsResponse(zzat.zzm, null);
            return;
        }
        final String skuType = skuDetailsParams.getSkuType();
        final List<String> skusList = skuDetailsParams.getSkusList();
        if (TextUtils.isEmpty(skuType)) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Please fix the input params. SKU type can't be empty.");
            this.zzf.zza(zzaq.zza(49, 8, zzat.zzf));
            skuDetailsResponseListener.onSkuDetailsResponse(zzat.zzf, null);
        } else if (skusList == null) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Please fix the input params. The list of SKUs can't be empty.");
            this.zzf.zza(zzaq.zza(48, 8, zzat.zze));
            skuDetailsResponseListener.onSkuDetailsResponse(zzat.zze, null);
        } else {
            final String str = null;
            if (zzS(new Callable(skuType, skusList, str, skuDetailsResponseListener) { // from class: com.android.billingclient.api.zzj
                public final /* synthetic */ String zzb;
                public final /* synthetic */ List zzc;
                public final /* synthetic */ SkuDetailsResponseListener zzd;

                {
                    this.zzd = skuDetailsResponseListener;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() throws Exception {
                    this.zza.zzm(this.zzb, this.zzc, null, this.zzd);
                    return null;
                }
            }, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, new Runnable() { // from class: com.android.billingclient.api.zzr
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzM(skuDetailsResponseListener);
                }
            }, zzO()) == null) {
                BillingResult billingResultZzQ = zzQ();
                this.zzf.zza(zzaq.zza(25, 8, billingResultZzQ));
                skuDetailsResponseListener.onSkuDetailsResponse(billingResultZzQ, null);
            }
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult showInAppMessages(final Activity activity, InAppMessageParams inAppMessageParams, InAppMessageResponseListener inAppMessageResponseListener) {
        if (!isReady()) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Service disconnected.");
            return zzat.zzm;
        }
        if (!this.zzp) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Current client doesn't support showing in-app messages.");
            return zzat.zzw;
        }
        View viewFindViewById = activity.findViewById(R.id.content);
        IBinder windowToken = viewFindViewById.getWindowToken();
        Rect rect = new Rect();
        viewFindViewById.getGlobalVisibleRect(rect);
        final Bundle bundle = new Bundle();
        BundleCompat.putBinder(bundle, "KEY_WINDOW_TOKEN", windowToken);
        bundle.putInt("KEY_DIMEN_LEFT", rect.left);
        bundle.putInt("KEY_DIMEN_TOP", rect.top);
        bundle.putInt("KEY_DIMEN_RIGHT", rect.right);
        bundle.putInt("KEY_DIMEN_BOTTOM", rect.bottom);
        bundle.putString("playBillingLibraryVersion", this.zzb);
        bundle.putIntegerArrayList("KEY_CATEGORY_IDS", inAppMessageParams.zza());
        final zzaa zzaaVar = new zzaa(this, this.zzc, inAppMessageResponseListener);
        zzS(new Callable() { // from class: com.android.billingclient.api.zzv
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zza.zzn(bundle, activity, zzaaVar);
                return null;
            }
        }, 5000L, null, this.zzc);
        return zzat.zzl;
    }

    final /* synthetic */ void zzG(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        this.zzf.zza(zzaq.zza(24, 3, zzat.zzn));
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzat.zzn);
    }

    final /* synthetic */ void zzH(BillingResult billingResult) {
        if (this.zzd.zzc() != null) {
            this.zzd.zzc().onPurchasesUpdated(billingResult, null);
        } else {
            this.zzd.zzb();
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "No valid listener is set in BroadcastManager");
        }
    }

    final /* synthetic */ void zzI(ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) {
        this.zzf.zza(zzaq.zza(24, 4, zzat.zzn));
        consumeResponseListener.onConsumeResponse(zzat.zzn, consumeParams.getPurchaseToken());
    }

    final /* synthetic */ void zzJ(ProductDetailsResponseListener productDetailsResponseListener) {
        this.zzf.zza(zzaq.zza(24, 7, zzat.zzn));
        productDetailsResponseListener.onProductDetailsResponse(zzat.zzn, new ArrayList());
    }

    final /* synthetic */ void zzK(PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        this.zzf.zza(zzaq.zza(24, 11, zzat.zzn));
        purchaseHistoryResponseListener.onPurchaseHistoryResponse(zzat.zzn, null);
    }

    final /* synthetic */ void zzL(PurchasesResponseListener purchasesResponseListener) {
        this.zzf.zza(zzaq.zza(24, 9, zzat.zzn));
        purchasesResponseListener.onQueryPurchasesResponse(zzat.zzn, com.google.android.gms.internal.play_billing.zzu.zzk());
    }

    final /* synthetic */ void zzM(SkuDetailsResponseListener skuDetailsResponseListener) {
        this.zzf.zza(zzaq.zza(24, 8, zzat.zzn));
        skuDetailsResponseListener.onSkuDetailsResponse(zzat.zzn, null);
    }

    final /* synthetic */ Bundle zzc(int i, String str, String str2, BillingFlowParams billingFlowParams, Bundle bundle) throws Exception {
        return this.zzg.zzg(i, this.zze.getPackageName(), str, str2, null, bundle);
    }

    final /* synthetic */ Bundle zzd(String str, String str2) throws Exception {
        return this.zzg.zzf(3, this.zze.getPackageName(), str, str2, null);
    }

    final /* synthetic */ Object zzj(AcknowledgePurchaseParams acknowledgePurchaseParams, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) throws Exception {
        try {
            com.google.android.gms.internal.play_billing.zze zzeVar = this.zzg;
            String packageName = this.zze.getPackageName();
            String purchaseToken = acknowledgePurchaseParams.getPurchaseToken();
            String str = this.zzb;
            Bundle bundle = new Bundle();
            bundle.putString("playBillingLibraryVersion", str);
            Bundle bundleZzd = zzeVar.zzd(9, packageName, purchaseToken, bundle);
            int iZzb = com.google.android.gms.internal.play_billing.zzb.zzb(bundleZzd, "BillingClient");
            String strZzf = com.google.android.gms.internal.play_billing.zzb.zzf(bundleZzd, "BillingClient");
            BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
            builderNewBuilder.setResponseCode(iZzb);
            builderNewBuilder.setDebugMessage(strZzf);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(builderNewBuilder.build());
            return null;
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Error acknowledge purchase!", e);
            this.zzf.zza(zzaq.zza(28, 3, zzat.zzm));
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzat.zzm);
            return null;
        }
    }

    final /* synthetic */ Object zzk(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) throws Exception {
        int iZza;
        String strZzf;
        String purchaseToken = consumeParams.getPurchaseToken();
        try {
            com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Consuming purchase with token: " + purchaseToken);
            if (this.zzn) {
                com.google.android.gms.internal.play_billing.zze zzeVar = this.zzg;
                String packageName = this.zze.getPackageName();
                boolean z = this.zzn;
                String str = this.zzb;
                Bundle bundle = new Bundle();
                if (z) {
                    bundle.putString("playBillingLibraryVersion", str);
                }
                Bundle bundleZze = zzeVar.zze(9, packageName, purchaseToken, bundle);
                iZza = bundleZze.getInt("RESPONSE_CODE");
                strZzf = com.google.android.gms.internal.play_billing.zzb.zzf(bundleZze, "BillingClient");
            } else {
                iZza = this.zzg.zza(3, this.zze.getPackageName(), purchaseToken);
                strZzf = "";
            }
            BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
            builderNewBuilder.setResponseCode(iZza);
            builderNewBuilder.setDebugMessage(strZzf);
            BillingResult billingResultBuild = builderNewBuilder.build();
            if (iZza == 0) {
                com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Successfully consumed purchase.");
                consumeResponseListener.onConsumeResponse(billingResultBuild, purchaseToken);
                return null;
            }
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Error consuming purchase with token. Response code: " + iZza);
            this.zzf.zza(zzaq.zza(23, 4, billingResultBuild));
            consumeResponseListener.onConsumeResponse(billingResultBuild, purchaseToken);
            return null;
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Error consuming purchase!", e);
            this.zzf.zza(zzaq.zza(29, 4, zzat.zzm));
            consumeResponseListener.onConsumeResponse(zzat.zzm, purchaseToken);
            return null;
        }
    }

    final /* synthetic */ Object zzl(QueryProductDetailsParams queryProductDetailsParams, ProductDetailsResponseListener productDetailsResponseListener) throws Exception {
        String strZzf;
        int iZzb;
        int i;
        int i2;
        ArrayList arrayList = new ArrayList();
        String strZzb = queryProductDetailsParams.zzb();
        com.google.android.gms.internal.play_billing.zzu zzuVarZza = queryProductDetailsParams.zza();
        int size = zzuVarZza.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                strZzf = "";
                iZzb = 0;
                break;
            }
            int i4 = i3 + 20;
            ArrayList arrayList2 = new ArrayList(zzuVarZza.subList(i3, i4 > size ? size : i4));
            ArrayList<String> arrayList3 = new ArrayList<>();
            int size2 = arrayList2.size();
            for (int i5 = 0; i5 < size2; i5++) {
                arrayList3.add(((QueryProductDetailsParams.Product) arrayList2.get(i5)).zza());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList3);
            bundle.putString("playBillingLibraryVersion", this.zzb);
            try {
                com.google.android.gms.internal.play_billing.zze zzeVar = this.zzg;
                int i6 = true != this.zzw ? 17 : 20;
                String packageName = this.zze.getPackageName();
                String str = this.zzb;
                if (TextUtils.isEmpty(null)) {
                    this.zze.getPackageName();
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("playBillingLibraryVersion", str);
                bundle2.putBoolean("enablePendingPurchases", true);
                bundle2.putString("SKU_DETAILS_RESPONSE_FORMAT", "PRODUCT_DETAILS");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ArrayList<String> arrayList5 = new ArrayList<>();
                int size3 = arrayList2.size();
                com.google.android.gms.internal.play_billing.zzu zzuVar = zzuVarZza;
                int i7 = 0;
                boolean z = false;
                boolean z2 = false;
                while (i7 < size3) {
                    QueryProductDetailsParams.Product product = (QueryProductDetailsParams.Product) arrayList2.get(i7);
                    ArrayList arrayList6 = arrayList2;
                    arrayList4.add(null);
                    z |= !TextUtils.isEmpty(null);
                    String strZzb2 = product.zzb();
                    int i8 = size3;
                    if (strZzb2.equals("first_party")) {
                        com.google.android.gms.internal.play_billing.zzm.zzc(null, "Serialized DocId is required for constructing ExtraParams to query ProductDetails for all first party products.");
                        arrayList5.add(null);
                        z2 = true;
                    }
                    i7++;
                    size3 = i8;
                    arrayList2 = arrayList6;
                }
                if (z) {
                    bundle2.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList4);
                }
                if (!arrayList5.isEmpty()) {
                    bundle2.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5);
                }
                if (z2 && !TextUtils.isEmpty(null)) {
                    bundle2.putString("accountName", null);
                }
                i2 = 7;
                try {
                    Bundle bundleZzl = zzeVar.zzl(i6, packageName, strZzb, bundle, bundle2);
                    strZzf = "Item is unavailable for purchase.";
                    if (bundleZzl == null) {
                        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "queryProductDetailsAsync got empty product details response.");
                        zzar zzarVar = this.zzf;
                        BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
                        builderNewBuilder.setResponseCode(4);
                        builderNewBuilder.setDebugMessage("Item is unavailable for purchase.");
                        zzarVar.zza(zzaq.zza(44, 7, builderNewBuilder.build()));
                    } else {
                        if (!bundleZzl.containsKey("DETAILS_LIST")) {
                            iZzb = com.google.android.gms.internal.play_billing.zzb.zzb(bundleZzl, "BillingClient");
                            strZzf = com.google.android.gms.internal.play_billing.zzb.zzf(bundleZzl, "BillingClient");
                            if (iZzb == 0) {
                                com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.");
                                zzar zzarVar2 = this.zzf;
                                BillingResult.Builder builderNewBuilder2 = BillingResult.newBuilder();
                                builderNewBuilder2.setResponseCode(6);
                                builderNewBuilder2.setDebugMessage(strZzf);
                                zzarVar2.zza(zzaq.zza(45, 7, builderNewBuilder2.build()));
                                iZzb = 6;
                                break;
                            }
                            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "getSkuDetails() failed for queryProductDetailsAsync. Response code: " + iZzb);
                            this.zzf.zza(zzaq.zza(23, 7, zzat.zza(iZzb, strZzf)));
                            break;
                        }
                        ArrayList<String> stringArrayList = bundleZzl.getStringArrayList("DETAILS_LIST");
                        if (stringArrayList == null) {
                            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "queryProductDetailsAsync got null response list");
                            this.zzf.zza(zzaq.zza(46, 7, zzat.zzB));
                        } else {
                            for (int i9 = 0; i9 < stringArrayList.size(); i9++) {
                                try {
                                    ProductDetails productDetails = new ProductDetails(stringArrayList.get(i9));
                                    com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Got product details: ".concat(productDetails.toString()));
                                    arrayList.add(productDetails);
                                } catch (JSONException e) {
                                    com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Got a JSON exception trying to decode ProductDetails. \n Exception: ", e);
                                    zzar zzarVar3 = this.zzf;
                                    BillingResult.Builder builderNewBuilder3 = BillingResult.newBuilder();
                                    i = 6;
                                    builderNewBuilder3.setResponseCode(6);
                                    strZzf = "Error trying to decode SkuDetails.";
                                    builderNewBuilder3.setDebugMessage("Error trying to decode SkuDetails.");
                                    zzarVar3.zza(zzaq.zza(47, 7, builderNewBuilder3.build()));
                                    iZzb = i;
                                    BillingResult.Builder builderNewBuilder4 = BillingResult.newBuilder();
                                    builderNewBuilder4.setResponseCode(iZzb);
                                    builderNewBuilder4.setDebugMessage(strZzf);
                                    productDetailsResponseListener.onProductDetailsResponse(builderNewBuilder4.build(), arrayList);
                                    return null;
                                }
                            }
                            i3 = i4;
                            zzuVarZza = zzuVar;
                        }
                    }
                    iZzb = 4;
                    break;
                } catch (Exception e2) {
                    e = e2;
                    i = 6;
                    com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "queryProductDetailsAsync got a remote exception (try to reconnect).", e);
                    this.zzf.zza(zzaq.zza(43, i2, zzat.zzj));
                    strZzf = "An internal error occurred.";
                    iZzb = i;
                    BillingResult.Builder builderNewBuilder5 = BillingResult.newBuilder();
                    builderNewBuilder5.setResponseCode(iZzb);
                    builderNewBuilder5.setDebugMessage(strZzf);
                    productDetailsResponseListener.onProductDetailsResponse(builderNewBuilder5.build(), arrayList);
                    return null;
                }
            } catch (Exception e3) {
                e = e3;
                i = 6;
                i2 = 7;
            }
        }
        BillingResult.Builder builderNewBuilder6 = BillingResult.newBuilder();
        builderNewBuilder6.setResponseCode(iZzb);
        builderNewBuilder6.setDebugMessage(strZzf);
        productDetailsResponseListener.onProductDetailsResponse(builderNewBuilder6.build(), arrayList);
        return null;
    }

    final /* synthetic */ Object zzm(String str, List list, String str2, SkuDetailsResponseListener skuDetailsResponseListener) throws Exception {
        String strZzf;
        int i;
        Bundle bundleZzk;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                strZzf = "";
                i = 0;
                break;
            }
            int i3 = i2 + 20;
            ArrayList<String> arrayList2 = new ArrayList<>(list.subList(i2, i3 > size ? size : i3));
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList2);
            bundle.putString("playBillingLibraryVersion", this.zzb);
            try {
                if (this.zzo) {
                    com.google.android.gms.internal.play_billing.zze zzeVar = this.zzg;
                    String packageName = this.zze.getPackageName();
                    int i4 = this.zzk;
                    String str3 = this.zzb;
                    Bundle bundle2 = new Bundle();
                    if (i4 >= 9) {
                        bundle2.putString("playBillingLibraryVersion", str3);
                    }
                    if (i4 >= 9) {
                        bundle2.putBoolean("enablePendingPurchases", true);
                    }
                    bundleZzk = zzeVar.zzl(10, packageName, str, bundle, bundle2);
                } else {
                    bundleZzk = this.zzg.zzk(3, this.zze.getPackageName(), str, bundle);
                }
                strZzf = "Item is unavailable for purchase.";
                if (bundleZzk != null) {
                    if (bundleZzk.containsKey("DETAILS_LIST")) {
                        ArrayList<String> stringArrayList = bundleZzk.getStringArrayList("DETAILS_LIST");
                        if (stringArrayList == null) {
                            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "querySkuDetailsAsync got null response list");
                            this.zzf.zza(zzaq.zza(46, 8, zzat.zzB));
                        } else {
                            for (int i5 = 0; i5 < stringArrayList.size(); i5++) {
                                try {
                                    SkuDetails skuDetails = new SkuDetails(stringArrayList.get(i5));
                                    com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Got sku details: ".concat(skuDetails.toString()));
                                    arrayList.add(skuDetails);
                                } catch (JSONException e) {
                                    com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Got a JSON exception trying to decode SkuDetails.", e);
                                    strZzf = "Error trying to decode SkuDetails.";
                                    this.zzf.zza(zzaq.zza(47, 8, zzat.zza(6, "Error trying to decode SkuDetails.")));
                                    arrayList = null;
                                }
                            }
                            i2 = i3;
                        }
                    } else {
                        int iZzb = com.google.android.gms.internal.play_billing.zzb.zzb(bundleZzk, "BillingClient");
                        strZzf = com.google.android.gms.internal.play_billing.zzb.zzf(bundleZzk, "BillingClient");
                        if (iZzb != 0) {
                            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "getSkuDetails() failed. Response code: " + iZzb);
                            this.zzf.zza(zzaq.zza(23, 8, zzat.zza(iZzb, strZzf)));
                            i = iZzb;
                            break;
                        }
                        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a detail list.");
                        this.zzf.zza(zzaq.zza(45, 8, zzat.zza(6, strZzf)));
                    }
                    i = 6;
                    break;
                }
                com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "querySkuDetailsAsync got null sku details list");
                this.zzf.zza(zzaq.zza(44, 8, zzat.zzB));
                arrayList = null;
                i = 4;
                break;
            } catch (Exception e2) {
                com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "querySkuDetailsAsync got a remote exception (try to reconnect).", e2);
                this.zzf.zza(zzaq.zza(43, 8, zzat.zzm));
                strZzf = "Service connection is disconnected.";
                i = -1;
                arrayList = null;
            }
        }
        BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
        builderNewBuilder.setResponseCode(i);
        builderNewBuilder.setDebugMessage(strZzf);
        skuDetailsResponseListener.onSkuDetailsResponse(builderNewBuilder.build(), arrayList);
        return null;
    }

    final /* synthetic */ Object zzn(Bundle bundle, Activity activity, ResultReceiver resultReceiver) throws Exception {
        this.zzg.zzm(12, this.zze.getPackageName(), bundle, new zzah(new WeakReference(activity), resultReceiver, null));
        return null;
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchaseHistoryAsync(String str, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        zzT(str, purchaseHistoryResponseListener);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchasesAsync(String str, PurchasesResponseListener purchasesResponseListener) {
        zzU(str, purchasesResponseListener);
    }

    private BillingClientImpl(Context context, zzbe zzbeVar, PurchasesUpdatedListener purchasesUpdatedListener, String str, String str2, AlternativeBillingListener alternativeBillingListener, zzar zzarVar) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = str;
        initialize(context, purchasesUpdatedListener, zzbeVar, alternativeBillingListener, str, null);
    }

    private BillingClientImpl(String str) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = str;
    }

    BillingClientImpl(String str, zzbe zzbeVar, Context context, zzaz zzazVar, zzar zzarVar) {
        this.zza = 0;
        this.zzc = new Handler(Looper.getMainLooper());
        this.zzk = 0;
        this.zzb = zzR();
        this.zze = context.getApplicationContext();
        zzfl zzflVarZzv = zzfm.zzv();
        zzflVarZzv.zzj(zzR());
        zzflVarZzv.zzi(this.zze.getPackageName());
        this.zzf = new zzaw(this.zze, (zzfm) zzflVarZzv.zzc());
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.zzd = new zzh(this.zze, null, this.zzf);
        this.zzx = zzbeVar;
    }

    BillingClientImpl(String str, zzbe zzbeVar, Context context, PurchasesUpdatedListener purchasesUpdatedListener, AlternativeBillingListener alternativeBillingListener, zzar zzarVar) {
        this(context, zzbeVar, purchasesUpdatedListener, zzR(), null, alternativeBillingListener, null);
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void startConnection(BillingClientStateListener billingClientStateListener) {
        if (isReady()) {
            com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Service connection is valid. No need to re-initialize.");
            this.zzf.zzb(zzaq.zzb(6));
            billingClientStateListener.onBillingSetupFinished(zzat.zzl);
            return;
        }
        int i = 1;
        if (this.zza == 1) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Client is already in the process of connecting to billing service.");
            this.zzf.zza(zzaq.zza(37, 6, zzat.zzd));
            billingClientStateListener.onBillingSetupFinished(zzat.zzd);
            return;
        }
        if (this.zza == 3) {
            com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            this.zzf.zza(zzaq.zza(38, 6, zzat.zzm));
            billingClientStateListener.onBillingSetupFinished(zzat.zzm);
            return;
        }
        this.zza = 1;
        this.zzd.zze();
        com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Starting in-app billing setup.");
        this.zzh = new zzaf(this, billingClientStateListener, null);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List<ResolveInfo> listQueryIntentServices = this.zze.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            i = 41;
        } else {
            ResolveInfo resolveInfo = listQueryIntentServices.get(0);
            if (resolveInfo.serviceInfo != null) {
                String str = resolveInfo.serviceInfo.packageName;
                String str2 = resolveInfo.serviceInfo.name;
                if (!"com.android.vending".equals(str) || str2 == null) {
                    com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "The device doesn't have valid Play Store.");
                    i = 40;
                } else {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    intent2.putExtra("playBillingLibraryVersion", this.zzb);
                    if (this.zze.bindService(intent2, this.zzh, 1)) {
                        com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Service was bonded successfully.");
                        return;
                    } else {
                        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "Connection to Billing service is blocked.");
                        i = 39;
                    }
                }
            }
        }
        this.zza = 0;
        com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "Billing service unavailable on device.");
        this.zzf.zza(zzaq.zza(i, 6, zzat.zzc));
        billingClientStateListener.onBillingSetupFinished(zzat.zzc);
    }
}
