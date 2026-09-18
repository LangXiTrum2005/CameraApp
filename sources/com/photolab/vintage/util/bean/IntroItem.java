package com.photolab.vintage.util.bean;

/* JADX INFO: loaded from: classes2.dex */
public class IntroItem {
    private String description;
    private int imageResId;
    private String title;

    public IntroItem(String str, String str2, int i) {
        this.title = str;
        this.description = str2;
        this.imageResId = i;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public int getImageResId() {
        return this.imageResId;
    }
}
