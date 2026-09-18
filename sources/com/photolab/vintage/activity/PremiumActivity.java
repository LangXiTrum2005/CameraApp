package com.photolab.vintage.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.billingclient.api.ProductDetails;
import com.android.billingclient.api.Purchase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.photolab.vintage.R;
import com.photolab.vintage.util.BillingManager;
import com.photolab.vintage.util.SharePreferenceUtil;
import com.photolab.vintage.util.adapter.CreditPackageAdapter;
import com.photolab.vintage.util.bean.CreditPackageConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PremiumActivity extends Activity implements BillingManager.BillingUpdatesListener {
    private static String TAG = "PremiumActivity";
    private BillingManager billingManager;
    private View btnMainAction;
    private View cardMonthly;
    private View cardYearly;
    private CreditPackageAdapter creditAdapter;
    private View indicatorCredits;
    private View indicatorSubscription;
    private ImageView ivClose;
    private View layoutCredits;
    private View layoutSubscription;
    private RecyclerView rvCreditPackages;
    private LinearLayout tabCredits;
    private LinearLayout tabSubscription;
    private TextView tvBtnText;
    private TextView tvCreditBalance;
    private TextView tvPriceMonthly;
    private TextView tvPriceYearly;
    private TextView tvRestore;
    private TextView tvTabCredits;
    private TextView tvTabSubscription;
    private List<CreditPackageConfig> creditPackages = new ArrayList();
    private String selectedProductId = BillingManager.PRODUCT_ID_SUBS_YEARLY;
    private boolean isSubscriptionTab = true;
    private Map<String, String> priceCache = new HashMap();

    @Override // com.photolab.vintage.util.BillingManager.BillingUpdatesListener
    public void onBillingClientSetupFinished() {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_premium);
        initViews();
        setupBilling();
        setupRemoteConfig();
        selectTab(true);
    }

    private void setupRemoteConfig() {
        final FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        firebaseRemoteConfig.setConfigSettingsAsync(new FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(3600L).build());
        firebaseRemoteConfig.fetchAndActivate().addOnCompleteListener(this, new OnCompleteListener() { // from class: com.photolab.vintage.activity.PremiumActivity$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.m508xcf8965a5(firebaseRemoteConfig, task);
            }
        });
        parseCreditPackages(firebaseRemoteConfig);
    }

    /* JADX INFO: renamed from: lambda$setupRemoteConfig$0$com-photolab-vintage-activity-PremiumActivity, reason: not valid java name */
    /* synthetic */ void m508xcf8965a5(FirebaseRemoteConfig firebaseRemoteConfig, Task task) {
        if (task.isSuccessful()) {
            boolean zBooleanValue = ((Boolean) task.getResult()).booleanValue();
            Log.d(TAG, "Config params updated: " + zBooleanValue);
        } else {
            Log.d(TAG, "Fetch failed");
        }
        parseCreditPackages(firebaseRemoteConfig);
    }

    private void parseCreditPackages(FirebaseRemoteConfig firebaseRemoteConfig) {
        String string = firebaseRemoteConfig.getString("credit_packages");
        Log.d(TAG, "data_remote:; " + string);
        if (string.isEmpty()) {
            this.creditPackages.clear();
            this.creditPackages.add(new CreditPackageConfig(BillingManager.PRODUCT_ID_CREDITS_50, "50 Credits", 50, "$4.99", false, "cube"));
            this.creditPackages.add(new CreditPackageConfig(BillingManager.PRODUCT_ID_CREDITS_200, "200 Credits", 200, "$14.99", true, "star"));
            this.creditPackages.add(new CreditPackageConfig(BillingManager.PRODUCT_ID_CREDITS_500, "500 Credits", 500, "$29.99", false, "diamond"));
        } else {
            try {
                ArrayList arrayList = (ArrayList) new Gson().fromJson(string, new TypeToken<ArrayList<CreditPackageConfig>>() { // from class: com.photolab.vintage.activity.PremiumActivity.1
                }.getType());
                if (arrayList != null && !arrayList.isEmpty()) {
                    this.creditPackages.clear();
                    this.creditPackages.addAll(arrayList);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!this.priceCache.isEmpty()) {
            for (CreditPackageConfig creditPackageConfig : this.creditPackages) {
                if (this.priceCache.containsKey(creditPackageConfig.getId())) {
                    creditPackageConfig.setPrice(this.priceCache.get(creditPackageConfig.getId()));
                }
            }
        }
        if (this.creditAdapter != null) {
            runOnUiThread(new Runnable() { // from class: com.photolab.vintage.activity.PremiumActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m507x8024bd7a();
                }
            });
        }
        if (this.billingManager == null || this.creditPackages.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<CreditPackageConfig> it = this.creditPackages.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().getId());
        }
        Log.d(TAG, "Registering credit packages with BillingManager: " + arrayList2);
        this.billingManager.setAdditionalProductIds(arrayList2);
    }

    /* JADX INFO: renamed from: lambda$parseCreditPackages$1$com-photolab-vintage-activity-PremiumActivity, reason: not valid java name */
    /* synthetic */ void m507x8024bd7a() {
        this.creditAdapter.updateData(this.creditPackages);
    }

    private void initViews() {
        this.ivClose = (ImageView) findViewById(R.id.ivClose);
        this.tvCreditBalance = (TextView) findViewById(R.id.tvCreditBalance);
        updateCreditBalance();
        this.ivClose.setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.activity.PremiumActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PremiumActivity.this.finish();
            }
        });
        this.tabSubscription = (LinearLayout) findViewById(R.id.tabSubscription);
        this.tabCredits = (LinearLayout) findViewById(R.id.tabCredits);
        this.tvTabSubscription = (TextView) findViewById(R.id.tvTabSubscription);
        this.tvTabCredits = (TextView) findViewById(R.id.tvTabCredits);
        this.indicatorSubscription = findViewById(R.id.indicatorSubscription);
        this.indicatorCredits = findViewById(R.id.indicatorCredits);
        this.layoutSubscription = findViewById(R.id.layoutSubscription);
        this.layoutCredits = findViewById(R.id.layoutCredits);
        this.tabSubscription.setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.activity.PremiumActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PremiumActivity.this.selectTab(true);
            }
        });
        this.tabCredits.setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.activity.PremiumActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PremiumActivity.this.selectTab(false);
            }
        });
        this.cardMonthly = findViewById(R.id.cardMonthly);
        this.cardYearly = findViewById(R.id.cardYearly);
        this.tvPriceMonthly = (TextView) findViewById(R.id.tvPriceMonthly);
        this.tvPriceYearly = (TextView) findViewById(R.id.tvPriceYearly);
        this.cardMonthly.setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.activity.PremiumActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PremiumActivity.this.selectSubscription(BillingManager.PRODUCT_ID_SUBS_MONTHLY);
            }
        });
        this.cardYearly.setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.activity.PremiumActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PremiumActivity.this.selectSubscription(BillingManager.PRODUCT_ID_SUBS_YEARLY);
            }
        });
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvCreditPackages);
        this.rvCreditPackages = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.creditPackages.add(new CreditPackageConfig(BillingManager.PRODUCT_ID_CREDITS_50, "50 Credits", 50, "$4.99", false, "cube"));
        this.creditPackages.add(new CreditPackageConfig(BillingManager.PRODUCT_ID_CREDITS_200, "200 Credits", 200, "$14.99", true, "star"));
        this.creditPackages.add(new CreditPackageConfig(BillingManager.PRODUCT_ID_CREDITS_500, "500 Credits", 500, "$29.99", false, "diamond"));
        CreditPackageAdapter creditPackageAdapter = new CreditPackageAdapter(this, this.creditPackages, new CreditPackageAdapter.OnPackageSelectedListener() { // from class: com.photolab.vintage.activity.PremiumActivity.7
            @Override // com.photolab.vintage.util.adapter.CreditPackageAdapter.OnPackageSelectedListener
            public void onPackageSelected(CreditPackageConfig creditPackageConfig) {
                PremiumActivity.this.selectedProductId = creditPackageConfig.getId();
                PremiumActivity.this.tvBtnText.setText("Purchase " + creditPackageConfig.getTitle());
            }
        });
        this.creditAdapter = creditPackageAdapter;
        this.rvCreditPackages.setAdapter(creditPackageAdapter);
        this.btnMainAction = findViewById(R.id.btnMainAction);
        this.tvBtnText = (TextView) findViewById(R.id.tvBtnText);
        this.tvRestore = (TextView) findViewById(R.id.tvRestore);
        this.btnMainAction.setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.activity.PremiumActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PremiumActivity.this.billingManager != null) {
                    BillingManager billingManager = PremiumActivity.this.billingManager;
                    PremiumActivity premiumActivity = PremiumActivity.this;
                    billingManager.m509xc482c11b(premiumActivity, premiumActivity.selectedProductId);
                }
            }
        });
        this.tvRestore.setOnClickListener(new View.OnClickListener() { // from class: com.photolab.vintage.activity.PremiumActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PremiumActivity.this.billingManager != null) {
                    Toast.makeText(PremiumActivity.this, "Restoring purchases...", 0).show();
                    PremiumActivity.this.billingManager.queryPurchases();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCreditBalance() {
        if (this.tvCreditBalance != null) {
            this.tvCreditBalance.setText(String.valueOf(SharePreferenceUtil.getCredits(this)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectTab(boolean z) {
        this.isSubscriptionTab = z;
        if (z) {
            this.tvTabSubscription.setTextColor(-16121);
            this.indicatorSubscription.setBackgroundColor(-16121);
            this.tvTabCredits.setTextColor(1728053247);
            this.indicatorCredits.setBackgroundColor(0);
            this.layoutSubscription.setVisibility(0);
            this.layoutCredits.setVisibility(8);
            selectSubscription(BillingManager.PRODUCT_ID_SUBS_YEARLY);
            this.tvBtnText.setText("Subscribe Now");
            return;
        }
        this.tvTabSubscription.setTextColor(1728053247);
        this.indicatorSubscription.setBackgroundColor(0);
        this.tvTabCredits.setTextColor(-16121);
        this.indicatorCredits.setBackgroundColor(-16121);
        this.layoutSubscription.setVisibility(8);
        this.layoutCredits.setVisibility(0);
        if (!this.creditPackages.isEmpty()) {
            CreditPackageConfig creditPackageConfig = this.creditPackages.get(0);
            this.selectedProductId = creditPackageConfig.getId();
            this.creditAdapter.setSelectedPosition(0);
            this.tvBtnText.setText("Purchase " + creditPackageConfig.getTitle());
            return;
        }
        this.tvBtnText.setText("Purchase Credits");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectSubscription(String str) {
        this.selectedProductId = str;
        if (BillingManager.PRODUCT_ID_SUBS_MONTHLY.equals(str)) {
            this.cardMonthly.setBackgroundResource(R.drawable.bg_card_premium_selected);
            this.cardYearly.setBackgroundResource(R.drawable.bg_card_premium_normal);
        } else {
            this.cardMonthly.setBackgroundResource(R.drawable.bg_card_premium_normal);
            this.cardYearly.setBackgroundResource(R.drawable.bg_card_premium_selected);
        }
    }

    private void setupBilling() {
        this.billingManager = new BillingManager(this, this);
    }

    @Override // com.photolab.vintage.util.BillingManager.BillingUpdatesListener
    public void onPurchasesUpdated(List<Purchase> list) {
        runOnUiThread(new Runnable() { // from class: com.photolab.vintage.activity.PremiumActivity.10
            @Override // java.lang.Runnable
            public void run() {
                PremiumActivity.this.updateCreditBalance();
                Toast.makeText(PremiumActivity.this, "Purchase Successful!", 1).show();
            }
        });
    }

    @Override // com.photolab.vintage.util.BillingManager.BillingUpdatesListener
    public void onProductDetailsFetched(final List<ProductDetails> list) {
        runOnUiThread(new Runnable() { // from class: com.photolab.vintage.activity.PremiumActivity.11
            @Override // java.lang.Runnable
            public void run() {
                ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails;
                List list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    return;
                }
                boolean z = false;
                for (ProductDetails productDetails : list) {
                    String productId = productDetails.getProductId();
                    String formattedPrice = "";
                    if (productDetails.getProductType().equals("subs")) {
                        List<ProductDetails.SubscriptionOfferDetails> subscriptionOfferDetails = productDetails.getSubscriptionOfferDetails();
                        if (subscriptionOfferDetails != null && !subscriptionOfferDetails.isEmpty()) {
                            formattedPrice = subscriptionOfferDetails.get(0).getPricingPhases().getPricingPhaseList().get(0).getFormattedPrice();
                        }
                    } else if (productDetails.getProductType().equals("inapp") && (oneTimePurchaseOfferDetails = productDetails.getOneTimePurchaseOfferDetails()) != null) {
                        formattedPrice = oneTimePurchaseOfferDetails.getFormattedPrice();
                    }
                    if (!formattedPrice.isEmpty()) {
                        if (productId.equals(BillingManager.PRODUCT_ID_SUBS_MONTHLY)) {
                            PremiumActivity.this.tvPriceMonthly.setText(formattedPrice);
                        } else if (productId.equals(BillingManager.PRODUCT_ID_SUBS_YEARLY)) {
                            PremiumActivity.this.tvPriceYearly.setText(formattedPrice);
                        }
                        PremiumActivity.this.priceCache.put(productId, formattedPrice);
                        for (CreditPackageConfig creditPackageConfig : PremiumActivity.this.creditPackages) {
                            if (creditPackageConfig.getId().equals(productId)) {
                                creditPackageConfig.setPrice(formattedPrice);
                                z = true;
                                break;
                            }
                        }
                    }
                }
                if (!z || PremiumActivity.this.creditAdapter == null) {
                    return;
                }
                PremiumActivity.this.creditAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override // com.photolab.vintage.util.BillingManager.BillingUpdatesListener
    public void onPurchaseError(final String str) {
        runOnUiThread(new Runnable() { // from class: com.photolab.vintage.activity.PremiumActivity.12
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(PremiumActivity.this, str, 0).show();
            }
        });
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        BillingManager billingManager = this.billingManager;
        if (billingManager != null) {
            billingManager.destroy();
        }
    }
}
