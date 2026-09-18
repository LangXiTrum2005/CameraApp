package com.photolab.vintage.util.bean;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class CreditPackageConfig {

    @SerializedName("credits")
    private int credits;

    @SerializedName("iconType")
    private String iconType;

    @SerializedName("id")
    private String id;

    @SerializedName("isBestValue")
    private boolean isBestValue;

    @SerializedName(FirebaseAnalytics.Param.PRICE)
    private String price;

    @SerializedName("title")
    private String title;

    public CreditPackageConfig(String str, String str2, int i, String str3, boolean z, String str4) {
        this.id = str;
        this.title = str2;
        this.credits = i;
        this.price = str3;
        this.isBestValue = z;
        this.iconType = str4;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public int getCredits() {
        return this.credits;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public boolean isBestValue() {
        return this.isBestValue;
    }

    public String getIconType() {
        return this.iconType;
    }
}
