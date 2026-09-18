package com.google.android.gms.internal.ads;

import androidx.core.view.PointerIconCompat;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhdi implements zzgzy {
    static final zzgzy zza = new zzhdi();

    private zzhdi() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzy
    public final boolean zza(int i) {
        if (i != 0 && i != 1 && i != 2 && i != 1999) {
            switch (i) {
                case 1000:
                case PointerIconCompat.TYPE_CONTEXT_MENU /* 1001 */:
                case PointerIconCompat.TYPE_HAND /* 1002 */:
                case PointerIconCompat.TYPE_HELP /* 1003 */:
                case PointerIconCompat.TYPE_WAIT /* 1004 */:
                case 1005:
                case PointerIconCompat.TYPE_CELL /* 1006 */:
                case PointerIconCompat.TYPE_CROSSHAIR /* 1007 */:
                case PointerIconCompat.TYPE_TEXT /* 1008 */:
                case PointerIconCompat.TYPE_VERTICAL_TEXT /* 1009 */:
                case PointerIconCompat.TYPE_ALIAS /* 1010 */:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}
