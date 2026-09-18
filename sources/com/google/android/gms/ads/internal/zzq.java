package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import com.google.android.gms.internal.ads.zzavi;
import com.google.android.gms.internal.ads.zzcec;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzq extends AsyncTask {
    final /* synthetic */ zzs zza;

    /* synthetic */ zzq(zzs zzsVar, zzp zzpVar) {
        this.zza = zzsVar;
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        zzs zzsVar = this.zza;
        String str = (String) obj;
        if (zzsVar.zzf == null || str == null) {
            return;
        }
        zzsVar.zzf.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final String doInBackground(Void... voidArr) {
        try {
            zzs zzsVar = this.zza;
            zzsVar.zzh = (zzavi) zzsVar.zzc.get(1000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e = e;
            zzcec.zzk("", e);
        } catch (ExecutionException e2) {
            e = e2;
            zzcec.zzk("", e);
        } catch (TimeoutException e3) {
            zzcec.zzk("", e3);
        }
        return this.zza.zzp();
    }
}
