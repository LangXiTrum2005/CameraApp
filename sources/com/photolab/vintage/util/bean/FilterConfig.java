package com.photolab.vintage.util.bean;

/* JADX INFO: loaded from: classes2.dex */
public class FilterConfig {
    public static final int ADJUST = 5;
    public static final int DUST = 2;
    public static final int FILTER = 0;
    public static final int GRADIENT = 3;
    public static final int LIGHT = 1;
    public static final int MASK = 4;
    private String assetUrl;
    private int color;
    private String config;
    private int intensive;
    private boolean isPremium;
    private boolean lastItem;
    private String name;
    private int type;

    public FilterConfig() {
    }

    public FilterConfig(int i, String str, String str2, String str3, int i2, int i3) {
        this(i, str, str2, str3, i2, i3, false);
    }

    public FilterConfig(int i, String str, String str2, String str3, int i2, int i3, boolean z) {
        this.type = i;
        this.config = str2;
        this.name = str3;
        this.color = i2;
        this.assetUrl = str;
        this.intensive = i3;
        this.isPremium = z;
    }

    public FilterConfig(int i, String str, String str2, String str3, int i2, boolean z, int i3, boolean z2) {
        this.type = i;
        this.config = str2;
        this.name = str3;
        this.color = i2;
        this.lastItem = z;
        this.assetUrl = str;
        this.intensive = i3;
        this.isPremium = z2;
    }

    public FilterConfig(int i, String str, String str2, String str3, int i2, boolean z, int i3) {
        this(i, str, str2, str3, i2, z, i3, false);
    }

    public boolean isPremium() {
        return this.isPremium;
    }

    public void setPremium(boolean z) {
        this.isPremium = z;
    }

    public int getIntensive() {
        return this.intensive;
    }

    public void setIntensive(int i) {
        this.intensive = i;
    }

    public String getAssetUrl() {
        return this.assetUrl;
    }

    public void setAssetUrl(String str) {
        this.assetUrl = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getColor() {
        return this.color;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public boolean isLastItem() {
        return this.lastItem;
    }

    public void setLastItem(boolean z) {
        this.lastItem = z;
    }

    public String getConfig() {
        return this.config;
    }

    public void setConfig(String str) {
        this.config = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }
}
