package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.bumptech.glide.load.Key;
import com.google.android.gms.common.util.Predicate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public final class zzbqm implements zzbqe, zzbqc {
    private final zzcjk zza;

    /* JADX WARN: Multi-variable type inference failed */
    public zzbqm(Context context, zzcei zzceiVar, zzavi zzaviVar, com.google.android.gms.ads.internal.zza zzaVar) throws zzcjw {
        com.google.android.gms.ads.internal.zzt.zzz();
        zzcjk zzcjkVarZza = zzcjx.zza(context, zzcla.zza(), "", false, false, null, null, zzceiVar, null, null, null, zzbbp.zza(), null, null, null, null);
        this.zza = zzcjkVarZza;
        ((View) zzcjkVarZza).setWillNotDraw(true);
    }

    private static final void zzs(Runnable runnable) {
        com.google.android.gms.ads.internal.client.zzay.zzb();
        if (zzcdv.zzu()) {
            com.google.android.gms.ads.internal.util.zze.zza("runOnUiThread > the UI thread is the main thread, the runnable will be run now");
            runnable.run();
        } else {
            com.google.android.gms.ads.internal.util.zze.zza("runOnUiThread > the UI thread is not the main thread, the runnable will be added to the message queue");
            if (com.google.android.gms.ads.internal.util.zzt.zza.post(runnable)) {
                return;
            }
            zzcec.zzj("runOnUiThread > the runnable could not be placed to the message queue");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbqn
    public final void zza(final String str) {
        com.google.android.gms.ads.internal.util.zze.zza("invokeJavascript on adWebView from js");
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbqi
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzm(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbqn
    public final /* synthetic */ void zzb(String str, String str2) {
        zzbqb.zzc(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbqe
    public final void zzc() {
        this.zza.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzbqa
    public final /* synthetic */ void zzd(String str, Map map) {
        zzbqb.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzbqa
    public final /* synthetic */ void zze(String str, JSONObject jSONObject) {
        zzbqb.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbqe
    public final void zzf(final String str) {
        com.google.android.gms.ads.internal.util.zze.zza("loadHtml on adWebView from html");
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbqj
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzn(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbqe
    public final void zzg(final String str) {
        com.google.android.gms.ads.internal.util.zze.zza("loadHtmlWrapper on adWebView from path: ".concat(String.valueOf(str)));
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbqg
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzo(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbqe
    public final void zzh(String str) {
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascript on adWebView from path: ".concat(String.valueOf(str)));
        final String str2 = String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", str);
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbqk
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzp(str2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbqe
    public final boolean zzi() {
        return this.zza.zzaB();
    }

    @Override // com.google.android.gms.internal.ads.zzbqe
    public final zzbrl zzj() {
        return new zzbrl(this);
    }

    @Override // com.google.android.gms.internal.ads.zzbqe
    public final void zzk(final zzbqs zzbqsVar) {
        zzcky zzckyVarZzN = this.zza.zzN();
        Objects.requireNonNull(zzbqsVar);
        zzckyVarZzN.zzH(new zzckx() { // from class: com.google.android.gms.internal.ads.zzbqh
            @Override // com.google.android.gms.internal.ads.zzckx
            public final void zza() {
                long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
                zzbqs zzbqsVar2 = zzbqsVar;
                final long j = zzbqsVar2.zzc;
                final ArrayList arrayList = zzbqsVar2.zzb;
                arrayList.add(Long.valueOf(jCurrentTimeMillis - j));
                com.google.android.gms.ads.internal.util.zze.zza("LoadNewJavascriptEngine(onEngLoaded) latency is " + String.valueOf(arrayList.get(0)) + " ms.");
                zzftt zzfttVar = com.google.android.gms.ads.internal.util.zzt.zza;
                final zzbrj zzbrjVar = zzbqsVar2.zza;
                final zzbri zzbriVar = zzbqsVar2.zzd;
                final zzbqe zzbqeVar = zzbqsVar2.zze;
                zzfttVar.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbqo
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzbrjVar.zzi(zzbriVar, zzbqeVar, arrayList, j);
                    }
                }, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzc)).intValue());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbqn
    public final /* synthetic */ void zzl(String str, JSONObject jSONObject) {
        zzbqb.zzd(this, str, jSONObject);
    }

    final /* synthetic */ void zzm(String str) {
        this.zza.zza(str);
    }

    final /* synthetic */ void zzn(String str) {
        this.zza.loadData(str, "text/html", Key.STRING_CHARSET_NAME);
    }

    final /* synthetic */ void zzo(String str) {
        this.zza.loadUrl(str);
    }

    final /* synthetic */ void zzp(String str) {
        this.zza.loadData(str, "text/html", Key.STRING_CHARSET_NAME);
    }

    @Override // com.google.android.gms.internal.ads.zzbrk
    public final void zzq(String str, zzbng zzbngVar) {
        this.zza.zzae(str, new zzbql(this, zzbngVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbrk
    public final void zzr(String str, final zzbng zzbngVar) {
        this.zza.zzax(str, new Predicate() { // from class: com.google.android.gms.internal.ads.zzbqf
            @Override // com.google.android.gms.common.util.Predicate
            public final boolean apply(Object obj) {
                zzbng zzbngVar2 = (zzbng) obj;
                if (zzbngVar2 instanceof zzbql) {
                    return ((zzbql) zzbngVar2).zzb.equals(zzbngVar);
                }
                return false;
            }
        });
    }
}
