package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfue extends zzfuc {
    private static zzfue zzc;

    private zzfue(Context context) {
        super(context, "paidv1_id", "paidv1_creation_time", "PaidV1LifecycleImpl");
    }

    public static final zzfue zzj(Context context) {
        zzfue zzfueVar;
        synchronized (zzfue.class) {
            if (zzc == null) {
                zzc = new zzfue(context);
            }
            zzfueVar = zzc;
        }
        return zzfueVar;
    }

    public final zzfub zzh(long j, boolean z) throws IOException {
        zzfub zzfubVarZzb;
        synchronized (zzfue.class) {
            zzfubVarZzb = zzb(null, null, j, z);
        }
        return zzfubVarZzb;
    }

    public final zzfub zzi(String str, String str2, long j, boolean z) throws IOException {
        zzfub zzfubVarZzb;
        synchronized (zzfue.class) {
            zzfubVarZzb = zzb(str, str2, j, z);
        }
        return zzfubVarZzb;
    }

    public final void zzk() throws IOException {
        synchronized (zzfue.class) {
            zzf(false);
        }
    }

    public final void zzl() throws IOException {
        synchronized (zzfue.class) {
            zzf(true);
        }
    }
}
