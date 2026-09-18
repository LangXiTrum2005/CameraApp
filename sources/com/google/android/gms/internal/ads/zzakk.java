package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzakk implements zzakp {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:31:0x005e  */
    @Override // com.google.android.gms.internal.ads.zzakp
    public final int zza(zzam zzamVar) {
        String str = zzamVar.zzm;
        if (str != null) {
            switch (str) {
                case "text/x-ssa":
                case "text/vtt":
                    return 1;
                case "application/x-mp4-vtt":
                    return 2;
                case "application/x-subrip":
                    return 1;
                case "application/x-quicktime-tx3g":
                case "application/pgs":
                case "application/dvbsubs":
                    return 2;
                case "application/ttml+xml":
                    return 1;
            }
        }
        throw new IllegalArgumentException("Unsupported MIME type: ".concat(String.valueOf(str)));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    @Override // com.google.android.gms.internal.ads.zzakp
    public final zzakr zzb(zzam zzamVar) {
        String str = zzamVar.zzm;
        if (str != null) {
            switch (str) {
                case "text/x-ssa":
                    return new zzalh(zzamVar.zzo);
                case "text/vtt":
                    return new zzami();
                case "application/x-mp4-vtt":
                    return new zzalx();
                case "application/x-subrip":
                    return new zzall();
                case "application/x-quicktime-tx3g":
                    return new zzalw(zzamVar.zzo);
                case "application/pgs":
                    return new zzalf();
                case "application/dvbsubs":
                    return new zzald(zzamVar.zzo);
                case "application/ttml+xml":
                    return new zzalr();
            }
        }
        throw new IllegalArgumentException("Unsupported MIME type: ".concat(String.valueOf(str)));
    }

    @Override // com.google.android.gms.internal.ads.zzakp
    public final boolean zzc(zzam zzamVar) {
        String str = zzamVar.zzm;
        return Objects.equals(str, "text/x-ssa") || Objects.equals(str, "text/vtt") || Objects.equals(str, "application/x-mp4-vtt") || Objects.equals(str, "application/x-subrip") || Objects.equals(str, "application/x-quicktime-tx3g") || Objects.equals(str, "application/pgs") || Objects.equals(str, "application/dvbsubs") || Objects.equals(str, "application/ttml+xml");
    }
}
