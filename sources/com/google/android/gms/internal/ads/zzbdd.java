package com.google.android.gms.internal.ads;

import androidx.core.view.PointerIconCompat;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbdd {
    private static final zzgzx zza = new zzbdb();

    public static int zza(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i != 1000) {
            return 0;
        }
        return PointerIconCompat.TYPE_CONTEXT_MENU;
    }
}
