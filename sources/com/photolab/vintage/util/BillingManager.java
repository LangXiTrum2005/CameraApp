package com.photolab.vintage.util;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.android.billingclient.api.AcknowledgePurchaseParams;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.ProductDetailsResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.android.billingclient.api.QueryPurchasesParams;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class BillingManager {
    public static final String PRODUCT_ID_CREDITS_10 = "credits_10";
    public static final String PRODUCT_ID_CREDITS_200 = "credits_200";
    public static final String PRODUCT_ID_CREDITS_50 = "credits_50";
    public static final String PRODUCT_ID_CREDITS_500 = "credits_500";
    public static final String PRODUCT_ID_REMOVE_ADS = "remove_ads";
    public static final String PRODUCT_ID_SUBS_MONTHLY = "subs_monthly";
    public static final String PRODUCT_ID_SUBS_YEARLY = "subs_yearly";
    private static final String TAG = "BillingManager";
    private BillingClient billingClient;
    private final Context context;
    private final BillingUpdatesListener updatesListener;
    private Map<String, ProductDetails> productDetailsMap = new HashMap();
    private boolean isConnected = false;
    private String pendingProductId = null;
    private Activity pendingActivity = null;
    private List<String> additionalProductIds = new ArrayList();
    private final PurchasesUpdatedListener purchasesUpdatedListener = new PurchasesUpdatedListener() { // from class: com.photolab.vintage.util.BillingManager.1
        @Override // com.android.billingclient.api.PurchasesUpdatedListener
        public void onPurchasesUpdated(BillingResult billingResult, List<Purchase> list) {
            if (billingResult.getResponseCode() == 0 && list != null) {
                Iterator<Purchase> it = list.iterator();
                while (it.hasNext()) {
                    BillingManager.this.handlePurchase(it.next());
                }
                if (BillingManager.this.updatesListener != null) {
                    BillingManager.this.updatesListener.onPurchasesUpdated(list);
                    return;
                }
                return;
            }
            if (billingResult.getResponseCode() == 1) {
                Log.i(BillingManager.TAG, "onPurchasesUpdated: User canceled the purchase");
                return;
            }
            Log.e(BillingManager.TAG, "onPurchasesUpdated: " + billingResult.getDebugMessage());
            if (BillingManager.this.updatesListener != null) {
                BillingManager.this.updatesListener.onPurchaseError("Purchase failed: " + billingResult.getDebugMessage());
            }
        }
    };

    public interface BillingUpdatesListener {
        void onBillingClientSetupFinished();

        void onProductDetailsFetched(List<ProductDetails> list);

        void onPurchaseError(String str);

        void onPurchasesUpdated(List<Purchase> list);
    }

    public BillingManager(Context context, BillingUpdatesListener billingUpdatesListener) {
        this.context = context;
        this.updatesListener = billingUpdatesListener;
        initializeBillingClient();
    }

    private void initializeBillingClient() {
        this.billingClient = BillingClient.newBuilder(this.context).setListener(this.purchasesUpdatedListener).enablePendingPurchases().build();
        startConnection();
    }

    private void startConnection() {
        this.billingClient.startConnection(new BillingClientStateListener() { // from class: com.photolab.vintage.util.BillingManager.2
            @Override // com.android.billingclient.api.BillingClientStateListener
            public void onBillingSetupFinished(BillingResult billingResult) {
                if (billingResult.getResponseCode() == 0) {
                    Log.d(BillingManager.TAG, "Billing setup finished successfully");
                    BillingManager.this.isConnected = true;
                    BillingManager.this.queryProductDetails();
                    BillingManager.this.queryPurchases();
                    if (BillingManager.this.updatesListener != null) {
                        BillingManager.this.updatesListener.onBillingClientSetupFinished();
                        return;
                    }
                    return;
                }
                Log.e(BillingManager.TAG, "Billing setup failed: " + billingResult.getDebugMessage());
                BillingManager.this.isConnected = false;
            }

            @Override // com.android.billingclient.api.BillingClientStateListener
            public void onBillingServiceDisconnected() {
                Log.d(BillingManager.TAG, "Billing service disconnected");
                BillingManager.this.isConnected = false;
            }
        });
    }

    public void setAdditionalProductIds(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.additionalProductIds.clear();
        this.additionalProductIds.addAll(list);
        if (this.isConnected) {
            queryProductDetails();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void queryProductDetails() {
        ArrayList<QueryProductDetailsParams.Product> arrayList = new ArrayList();
        arrayList.add(buildProductParam(PRODUCT_ID_REMOVE_ADS, "inapp"));
        ArrayList arrayList2 = new ArrayList();
        for (QueryProductDetailsParams.Product product : arrayList) {
        }
        arrayList2.add(PRODUCT_ID_REMOVE_ADS);
        for (String str : this.additionalProductIds) {
            if (!arrayList2.contains(str)) {
                arrayList.add(buildProductParam(str, "inapp"));
                arrayList2.add(str);
            }
        }
        this.billingClient.queryProductDetailsAsync(QueryProductDetailsParams.newBuilder().setProductList(arrayList).build(), new ProductDetailsResponseListener() { // from class: com.photolab.vintage.util.BillingManager.3
            @Override // com.android.billingclient.api.ProductDetailsResponseListener
            public void onProductDetailsResponse(BillingResult billingResult, List<ProductDetails> list) {
                if (billingResult.getResponseCode() == 0) {
                    if (list.isEmpty()) {
                        Log.w(BillingManager.TAG, "INAPP Query returned 0 products. Check if IDs are active in Play Console.");
                    } else {
                        Log.d(BillingManager.TAG, "INAPP Query found " + list.size() + " products.");
                        for (ProductDetails productDetails : list) {
                            Log.d(BillingManager.TAG, "Found INAPP product: " + productDetails.getProductId());
                            BillingManager.this.productDetailsMap.put(productDetails.getProductId(), productDetails);
                        }
                    }
                    if (BillingManager.this.updatesListener != null) {
                        BillingManager.this.updatesListener.onProductDetailsFetched(list);
                    }
                    BillingManager.this.checkPendingPurchase();
                    return;
                }
                Log.e(BillingManager.TAG, "INAPP Query failed: " + billingResult.getDebugMessage());
            }
        });
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(buildProductParam(PRODUCT_ID_SUBS_MONTHLY, "subs"));
        arrayList3.add(buildProductParam(PRODUCT_ID_SUBS_YEARLY, "subs"));
        this.billingClient.queryProductDetailsAsync(QueryProductDetailsParams.newBuilder().setProductList(arrayList3).build(), new ProductDetailsResponseListener() { // from class: com.photolab.vintage.util.BillingManager.4
            @Override // com.android.billingclient.api.ProductDetailsResponseListener
            public void onProductDetailsResponse(BillingResult billingResult, List<ProductDetails> list) {
                if (billingResult.getResponseCode() == 0) {
                    if (list.isEmpty()) {
                        Log.w(BillingManager.TAG, "SUBS Query returned 0 products. Check if IDs are active in Play Console.");
                    } else {
                        Log.d(BillingManager.TAG, "SUBS Query found " + list.size() + " products.");
                        for (ProductDetails productDetails : list) {
                            Log.d(BillingManager.TAG, "Found SUBS product: " + productDetails.getProductId());
                            BillingManager.this.productDetailsMap.put(productDetails.getProductId(), productDetails);
                        }
                    }
                    if (BillingManager.this.updatesListener != null) {
                        BillingManager.this.updatesListener.onProductDetailsFetched(list);
                    }
                    BillingManager.this.checkPendingPurchase();
                    return;
                }
                Log.e(BillingManager.TAG, "SUBS Query failed: " + billingResult.getDebugMessage());
            }
        });
    }

    private QueryProductDetailsParams.Product buildProductParam(String str, String str2) {
        return QueryProductDetailsParams.Product.newBuilder().setProductId(str).setProductType(str2).build();
    }

    /* JADX INFO: renamed from: launchPurchaseFlow, reason: merged with bridge method [inline-methods] */
    public void m509xc482c11b(Activity activity, String str) {
        ProductDetails productDetails = this.productDetailsMap.get(str);
        if (productDetails != null) {
            this.pendingProductId = null;
            this.pendingActivity = null;
            BillingFlowParams.ProductDetailsParams.Builder productDetails2 = BillingFlowParams.ProductDetailsParams.newBuilder().setProductDetails(productDetails);
            if (productDetails.getProductType().equals("subs")) {
                List<ProductDetails.SubscriptionOfferDetails> subscriptionOfferDetails = productDetails.getSubscriptionOfferDetails();
                if (subscriptionOfferDetails != null && !subscriptionOfferDetails.isEmpty()) {
                    productDetails2.setOfferToken(subscriptionOfferDetails.get(0).getOfferToken());
                } else {
                    Log.e(TAG, "Subscription product " + str + " has no offer details! Check Play Console configuration.");
                    Toast.makeText(activity, "Error: Subscription offer not found.", 0).show();
                    return;
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(productDetails2.build());
            this.billingClient.launchBillingFlow(activity, BillingFlowParams.newBuilder().setProductDetailsParamsList(arrayList).build());
            return;
        }
        this.pendingProductId = str;
        this.pendingActivity = activity;
        Toast.makeText(activity, "Fetching product info, please wait...", 0).show();
        Log.w(TAG, "ProductDetails is null for " + str + ". Requesting query again.");
        if (this.isConnected) {
            queryProductDetails();
        } else {
            startConnection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPendingPurchase() {
        if (this.pendingProductId == null || this.pendingActivity == null) {
            return;
        }
        Log.d(TAG, "Checking pending purchase for: " + this.pendingProductId);
        if (this.productDetailsMap.get(this.pendingProductId) != null) {
            Log.d(TAG, "Pending product found. Launching flow.");
            final Activity activity = this.pendingActivity;
            final String str = this.pendingProductId;
            activity.runOnUiThread(new Runnable() { // from class: com.photolab.vintage.util.BillingManager$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m509xc482c11b(activity, str);
                }
            });
        }
    }

    public void launchPurchaseFlow(Activity activity) {
        m509xc482c11b(activity, PRODUCT_ID_REMOVE_ADS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePurchase(Purchase purchase) {
        int i;
        final int i2;
        int i3;
        if (purchase.getPurchaseState() == 1) {
            Bundle bundle = new Bundle();
            bundle.putString(FirebaseAnalytics.Param.TRANSACTION_ID, purchase.getOrderId());
            bundle.putString(FirebaseAnalytics.Param.CURRENCY, "USD");
            Iterator<String> it = purchase.getProducts().iterator();
            String next = "";
            while (true) {
                i = 0;
                if (!it.hasNext()) {
                    i2 = 0;
                    break;
                }
                next = it.next();
                if (next.startsWith("credits_")) {
                    try {
                        i = Integer.parseInt(next.replace("credits_", ""));
                    } catch (NumberFormatException unused) {
                        Log.e(TAG, "Failed to parse credits from product ID: " + next);
                        if (PRODUCT_ID_CREDITS_10.equals(next)) {
                            i3 = 10;
                        } else if (PRODUCT_ID_CREDITS_50.equals(next)) {
                            i3 = 50;
                        } else if (PRODUCT_ID_CREDITS_200.equals(next)) {
                            i3 = 200;
                        } else if (PRODUCT_ID_CREDITS_500.equals(next)) {
                            i3 = 500;
                        }
                        i = i3;
                    }
                    i2 = i;
                    i = 1;
                    break;
                }
            }
            bundle.putString(FirebaseAnalytics.Param.ITEM_ID, next);
            FirebaseAnalytics.getInstance(this.context).logEvent(FirebaseAnalytics.Event.PURCHASE, bundle);
            if (i != 0) {
                this.billingClient.consumeAsync(ConsumeParams.newBuilder().setPurchaseToken(purchase.getPurchaseToken()).build(), new ConsumeResponseListener() { // from class: com.photolab.vintage.util.BillingManager$$ExternalSyntheticLambda0
                    @Override // com.android.billingclient.api.ConsumeResponseListener
                    public final void onConsumeResponse(BillingResult billingResult, String str) {
                        this.f$0.m510lambda$handlePurchase$1$comphotolabvintageutilBillingManager(i2, billingResult, str);
                    }
                });
            } else if (!purchase.isAcknowledged()) {
                this.billingClient.acknowledgePurchase(AcknowledgePurchaseParams.newBuilder().setPurchaseToken(purchase.getPurchaseToken()).build(), new AcknowledgePurchaseResponseListener() { // from class: com.photolab.vintage.util.BillingManager$$ExternalSyntheticLambda1
                    @Override // com.android.billingclient.api.AcknowledgePurchaseResponseListener
                    public final void onAcknowledgePurchaseResponse(BillingResult billingResult) {
                        this.f$0.m511lambda$handlePurchase$2$comphotolabvintageutilBillingManager(billingResult);
                    }
                });
            } else {
                SharePreferenceUtil.setIsPurchased(this.context, true);
            }
        }
    }

    /* JADX INFO: renamed from: lambda$handlePurchase$1$com-photolab-vintage-util-BillingManager, reason: not valid java name */
    /* synthetic */ void m510lambda$handlePurchase$1$comphotolabvintageutilBillingManager(int i, BillingResult billingResult, String str) {
        if (billingResult.getResponseCode() == 0) {
            Log.d(TAG, "Purchase consumed. Adding credits: " + i);
            SharePreferenceUtil.addCredits(this.context, i);
        }
    }

    /* JADX INFO: renamed from: lambda$handlePurchase$2$com-photolab-vintage-util-BillingManager, reason: not valid java name */
    /* synthetic */ void m511lambda$handlePurchase$2$comphotolabvintageutilBillingManager(BillingResult billingResult) {
        if (billingResult.getResponseCode() == 0) {
            Log.d(TAG, "Purchase acknowledged");
            SharePreferenceUtil.setIsPurchased(this.context, true);
        }
    }

    public void queryPurchases() {
        if (this.isConnected) {
            this.billingClient.queryPurchasesAsync(QueryPurchasesParams.newBuilder().setProductType("inapp").build(), new PurchasesResponseListener() { // from class: com.photolab.vintage.util.BillingManager$$ExternalSyntheticLambda3
                @Override // com.android.billingclient.api.PurchasesResponseListener
                public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
                    this.f$0.m512lambda$queryPurchases$3$comphotolabvintageutilBillingManager(billingResult, list);
                }
            });
            this.billingClient.queryPurchasesAsync(QueryPurchasesParams.newBuilder().setProductType("subs").build(), new PurchasesResponseListener() { // from class: com.photolab.vintage.util.BillingManager$$ExternalSyntheticLambda4
                @Override // com.android.billingclient.api.PurchasesResponseListener
                public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
                    this.f$0.m513lambda$queryPurchases$4$comphotolabvintageutilBillingManager(billingResult, list);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$queryPurchases$3$com-photolab-vintage-util-BillingManager, reason: not valid java name */
    /* synthetic */ void m512lambda$queryPurchases$3$comphotolabvintageutilBillingManager(BillingResult billingResult, List list) {
        if (billingResult.getResponseCode() == 0) {
            processPurchases(list);
        }
    }

    /* JADX INFO: renamed from: lambda$queryPurchases$4$com-photolab-vintage-util-BillingManager, reason: not valid java name */
    /* synthetic */ void m513lambda$queryPurchases$4$comphotolabvintageutilBillingManager(BillingResult billingResult, List list) {
        if (billingResult.getResponseCode() == 0) {
            processPurchases(list);
        }
    }

    private void processPurchases(List<Purchase> list) {
        boolean z = false;
        for (Purchase purchase : list) {
            if (purchase.getPurchaseState() == 1) {
                if (purchase.getProducts().contains(PRODUCT_ID_REMOVE_ADS) || purchase.getProducts().contains(PRODUCT_ID_SUBS_MONTHLY) || purchase.getProducts().contains(PRODUCT_ID_SUBS_YEARLY)) {
                    handlePurchase(purchase);
                    z = true;
                } else if (purchase.getProducts().toString().contains("credits_")) {
                    handlePurchase(purchase);
                }
            }
        }
        if (z) {
            SharePreferenceUtil.setIsPurchased(this.context, true);
        }
        Log.d(TAG, "Query purchases completed. Premium active: " + z);
    }

    public ProductDetails getRemoveAdsProductDetails() {
        return this.productDetailsMap.get(PRODUCT_ID_REMOVE_ADS);
    }

    public void destroy() {
        BillingClient billingClient = this.billingClient;
        if (billingClient != null) {
            billingClient.endConnection();
        }
    }
}
