package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhdd extends IllegalArgumentException {
    zzhdd(int i, int i2) {
        super("Unpaired surrogate at index " + i + " of " + i2);
    }
}
