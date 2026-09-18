package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzatw implements Runnable {
    private zzatw() {
    }

    /* synthetic */ zzatw(zzatv zzatvVar) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        CountDownLatch countDownLatch;
        try {
            zzatx.zzd = MessageDigest.getInstance("MD5");
            countDownLatch = zzatx.zzb;
        } catch (NoSuchAlgorithmException unused) {
            countDownLatch = zzatx.zzb;
        } catch (Throwable th) {
            zzatx.zzb.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }
}
