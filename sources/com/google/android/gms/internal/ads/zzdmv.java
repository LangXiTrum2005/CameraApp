package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.collection.ArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdmv extends zzcwh {
    public static final zzgaa zzc = zzgaa.zzq("3010", "3008", "1005", "1009", "2011", "2007");
    private final zzays zzA;
    private final Executor zzd;
    private final zzdna zze;
    private final zzdni zzf;
    private final zzdoa zzg;
    private final zzdnf zzh;
    private final zzdnl zzi;
    private final zzhgx zzj;
    private final zzhgx zzk;
    private final zzhgx zzl;
    private final zzhgx zzm;
    private final zzhgx zzn;
    private zzdow zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private final zzccd zzs;
    private final zzavi zzt;
    private final zzcei zzu;
    private final Context zzv;
    private final zzdmx zzw;
    private final zzeqh zzx;
    private final Map zzy;
    private final List zzz;

    public zzdmv(zzcwg zzcwgVar, Executor executor, zzdna zzdnaVar, zzdni zzdniVar, zzdoa zzdoaVar, zzdnf zzdnfVar, zzdnl zzdnlVar, zzhgx zzhgxVar, zzhgx zzhgxVar2, zzhgx zzhgxVar3, zzhgx zzhgxVar4, zzhgx zzhgxVar5, zzccd zzccdVar, zzavi zzaviVar, zzcei zzceiVar, Context context, zzdmx zzdmxVar, zzeqh zzeqhVar, zzays zzaysVar) {
        super(zzcwgVar);
        this.zzd = executor;
        this.zze = zzdnaVar;
        this.zzf = zzdniVar;
        this.zzg = zzdoaVar;
        this.zzh = zzdnfVar;
        this.zzi = zzdnlVar;
        this.zzj = zzhgxVar;
        this.zzk = zzhgxVar2;
        this.zzl = zzhgxVar3;
        this.zzm = zzhgxVar4;
        this.zzn = zzhgxVar5;
        this.zzs = zzccdVar;
        this.zzt = zzaviVar;
        this.zzu = zzceiVar;
        this.zzv = context;
        this.zzw = zzdmxVar;
        this.zzx = zzeqhVar;
        this.zzy = new HashMap();
        this.zzz = new ArrayList();
        this.zzA = zzaysVar;
    }

    public static boolean zzW(View view) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzke)).booleanValue()) {
            return view.isShown() && view.getGlobalVisibleRect(new Rect(), null);
        }
        com.google.android.gms.ads.internal.zzt.zzp();
        long jZzv = com.google.android.gms.ads.internal.util.zzt.zzv(view);
        if (view.isShown() && view.getGlobalVisibleRect(new Rect(), null)) {
            if (jZzv >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkf)).intValue()) {
                return true;
            }
        }
        return false;
    }

    private final synchronized View zzY(Map map) {
        if (map != null) {
            zzgaa zzgaaVar = zzc;
            int size = zzgaaVar.size();
            int i = 0;
            while (i < size) {
                WeakReference weakReference = (WeakReference) map.get((String) zzgaaVar.get(i));
                i++;
                if (weakReference != null) {
                    return (View) weakReference.get();
                }
            }
        }
        return null;
    }

    private final synchronized ImageView.ScaleType zzZ() {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzhQ)).booleanValue()) {
            return null;
        }
        zzdow zzdowVar = this.zzo;
        if (zzdowVar == null) {
            zzcec.zze("Ad should be associated with an ad view before calling getMediaviewScaleType()");
            return null;
        }
        IObjectWrapper iObjectWrapperZzj = zzdowVar.zzj();
        if (iObjectWrapperZzj != null) {
            return (ImageView.ScaleType) ObjectWrapper.unwrap(iObjectWrapperZzj);
        }
        return zzdoa.zza;
    }

    private final void zzaa(String str, boolean z) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfa)).booleanValue()) {
            zzf("Google", true);
            return;
        }
        ListenableFuture listenableFutureZzw = this.zze.zzw();
        if (listenableFutureZzw == null) {
            return;
        }
        zzgen.zzr(listenableFutureZzw, new zzdmt(this, "Google", true), this.zzd);
    }

    private final synchronized void zzab(View view, Map map, Map map2) {
        this.zzg.zzd(this.zzo);
        this.zzf.zzq(view, map, map2, zzZ());
        this.zzq = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzac(View view, zzfod zzfodVar) {
        zzcjk zzcjkVarZzr = this.zze.zzr();
        if (!this.zzh.zzd() || zzfodVar == null || zzcjkVarZzr == null || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzA().zzh(zzfodVar, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzad, reason: merged with bridge method [inline-methods] */
    public final synchronized void zzy(zzdow zzdowVar) {
        Iterator<String> itKeys;
        View view;
        if (!this.zzp) {
            this.zzo = zzdowVar;
            this.zzg.zze(zzdowVar);
            this.zzf.zzy(zzdowVar.zzf(), zzdowVar.zzm(), zzdowVar.zzn(), zzdowVar, zzdowVar);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcv)).booleanValue()) {
                this.zzt.zzc().zzo(zzdowVar.zzf());
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbK)).booleanValue()) {
                zzfgm zzfgmVar = this.zzb;
                if (zzfgmVar.zzal && (itKeys = zzfgmVar.zzak.keys()) != null) {
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        WeakReference weakReference = (WeakReference) this.zzo.zzl().get(next);
                        this.zzy.put(next, false);
                        if (weakReference != null && (view = (View) weakReference.get()) != null) {
                            zzayr zzayrVar = new zzayr(this.zzv, view);
                            this.zzz.add(zzayrVar);
                            zzayrVar.zzc(new zzdms(this, next));
                        }
                    }
                }
            }
            if (zzdowVar.zzi() != null) {
                zzdowVar.zzi().zzc(this.zzs);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzae, reason: merged with bridge method [inline-methods] */
    public final void zzz(zzdow zzdowVar) {
        this.zzf.zzz(zzdowVar.zzf(), zzdowVar.zzl());
        if (zzdowVar.zzh() != null) {
            zzdowVar.zzh().setClickable(false);
            zzdowVar.zzh().removeAllViews();
        }
        if (zzdowVar.zzi() != null) {
            zzdowVar.zzi().zze(this.zzs);
        }
        this.zzo = null;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0047 A[Catch: all -> 0x00ee, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0007, B:8:0x0019, B:10:0x001f, B:11:0x0029, B:13:0x002f, B:17:0x0047, B:20:0x005b, B:21:0x0063, B:23:0x0069, B:25:0x007d, B:27:0x0083, B:30:0x0088, B:32:0x008e, B:35:0x0093, B:37:0x00a5, B:39:0x00ab, B:42:0x00b0, B:44:0x00c2, B:46:0x00ce, B:48:0x00d8, B:50:0x00e2, B:55:0x00e9), top: B:61:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x0069 A[Catch: all -> 0x00ee, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0007, B:8:0x0019, B:10:0x001f, B:11:0x0029, B:13:0x002f, B:17:0x0047, B:20:0x005b, B:21:0x0063, B:23:0x0069, B:25:0x007d, B:27:0x0083, B:30:0x0088, B:32:0x008e, B:35:0x0093, B:37:0x00a5, B:39:0x00ab, B:42:0x00b0, B:44:0x00c2, B:46:0x00ce, B:48:0x00d8, B:50:0x00e2, B:55:0x00e9), top: B:61:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0088 A[Catch: all -> 0x00ee, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0007, B:8:0x0019, B:10:0x001f, B:11:0x0029, B:13:0x002f, B:17:0x0047, B:20:0x005b, B:21:0x0063, B:23:0x0069, B:25:0x007d, B:27:0x0083, B:30:0x0088, B:32:0x008e, B:35:0x0093, B:37:0x00a5, B:39:0x00ab, B:42:0x00b0, B:44:0x00c2, B:46:0x00ce, B:48:0x00d8, B:50:0x00e2, B:55:0x00e9), top: B:61:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x008e A[Catch: all -> 0x00ee, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0007, B:8:0x0019, B:10:0x001f, B:11:0x0029, B:13:0x002f, B:17:0x0047, B:20:0x005b, B:21:0x0063, B:23:0x0069, B:25:0x007d, B:27:0x0083, B:30:0x0088, B:32:0x008e, B:35:0x0093, B:37:0x00a5, B:39:0x00ab, B:42:0x00b0, B:44:0x00c2, B:46:0x00ce, B:48:0x00d8, B:50:0x00e2, B:55:0x00e9), top: B:61:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0093 A[Catch: all -> 0x00ee, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0007, B:8:0x0019, B:10:0x001f, B:11:0x0029, B:13:0x002f, B:17:0x0047, B:20:0x005b, B:21:0x0063, B:23:0x0069, B:25:0x007d, B:27:0x0083, B:30:0x0088, B:32:0x008e, B:35:0x0093, B:37:0x00a5, B:39:0x00ab, B:42:0x00b0, B:44:0x00c2, B:46:0x00ce, B:48:0x00d8, B:50:0x00e2, B:55:0x00e9), top: B:61:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00a5 A[Catch: all -> 0x00ee, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0007, B:8:0x0019, B:10:0x001f, B:11:0x0029, B:13:0x002f, B:17:0x0047, B:20:0x005b, B:21:0x0063, B:23:0x0069, B:25:0x007d, B:27:0x0083, B:30:0x0088, B:32:0x008e, B:35:0x0093, B:37:0x00a5, B:39:0x00ab, B:42:0x00b0, B:44:0x00c2, B:46:0x00ce, B:48:0x00d8, B:50:0x00e2, B:55:0x00e9), top: B:61:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00ab A[Catch: all -> 0x00ee, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0007, B:8:0x0019, B:10:0x001f, B:11:0x0029, B:13:0x002f, B:17:0x0047, B:20:0x005b, B:21:0x0063, B:23:0x0069, B:25:0x007d, B:27:0x0083, B:30:0x0088, B:32:0x008e, B:35:0x0093, B:37:0x00a5, B:39:0x00ab, B:42:0x00b0, B:44:0x00c2, B:46:0x00ce, B:48:0x00d8, B:50:0x00e2, B:55:0x00e9), top: B:61:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00b0 A[Catch: all -> 0x00ee, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0007, B:8:0x0019, B:10:0x001f, B:11:0x0029, B:13:0x002f, B:17:0x0047, B:20:0x005b, B:21:0x0063, B:23:0x0069, B:25:0x007d, B:27:0x0083, B:30:0x0088, B:32:0x008e, B:35:0x0093, B:37:0x00a5, B:39:0x00ab, B:42:0x00b0, B:44:0x00c2, B:46:0x00ce, B:48:0x00d8, B:50:0x00e2, B:55:0x00e9), top: B:61:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00c2 A[Catch: all -> 0x00ee, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0007, B:8:0x0019, B:10:0x001f, B:11:0x0029, B:13:0x002f, B:17:0x0047, B:20:0x005b, B:21:0x0063, B:23:0x0069, B:25:0x007d, B:27:0x0083, B:30:0x0088, B:32:0x008e, B:35:0x0093, B:37:0x00a5, B:39:0x00ab, B:42:0x00b0, B:44:0x00c2, B:46:0x00ce, B:48:0x00d8, B:50:0x00e2, B:55:0x00e9), top: B:61:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00e9 A[Catch: all -> 0x00ee, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0007, B:8:0x0019, B:10:0x001f, B:11:0x0029, B:13:0x002f, B:17:0x0047, B:20:0x005b, B:21:0x0063, B:23:0x0069, B:25:0x007d, B:27:0x0083, B:30:0x0088, B:32:0x008e, B:35:0x0093, B:37:0x00a5, B:39:0x00ab, B:42:0x00b0, B:44:0x00c2, B:46:0x00ce, B:48:0x00d8, B:50:0x00e2, B:55:0x00e9), top: B:61:0x0001 }] */
    public final synchronized void zzA(View view, Map map, Map map2, boolean z) {
        View viewZzY;
        Rect rect;
        Iterator it;
        View view2;
        if (!this.zzq) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbK)).booleanValue() && this.zzb.zzal) {
                Iterator it2 = this.zzy.keySet().iterator();
                while (it2.hasNext()) {
                    if (!((Boolean) this.zzy.get((String) it2.next())).booleanValue()) {
                    }
                }
                if (z) {
                    viewZzY = zzY(map);
                    if (viewZzY == null) {
                        zzab(view, map, map2);
                        return;
                    }
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdM)).booleanValue()) {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdN)).booleanValue()) {
                            zzab(view, map, map2);
                            return;
                        }
                        rect = new Rect();
                        if (viewZzY.getGlobalVisibleRect(rect, null)) {
                            zzab(view, map, map2);
                        }
                    } else if (zzW(viewZzY)) {
                        zzab(view, map, map2);
                    }
                } else {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdL)).booleanValue()) {
                        it = map.entrySet().iterator();
                        while (it.hasNext()) {
                            view2 = (View) ((WeakReference) ((Map.Entry) it.next()).getValue()).get();
                            if (view2 == null) {
                            }
                        }
                    }
                }
            } else if (z) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdL)).booleanValue() && map != null) {
                    it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        view2 = (View) ((WeakReference) ((Map.Entry) it.next()).getValue()).get();
                        if (view2 == null && zzW(view2)) {
                            zzab(view, map, map2);
                            return;
                        }
                    }
                }
            } else {
                viewZzY = zzY(map);
                if (viewZzY == null) {
                    zzab(view, map, map2);
                    return;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdM)).booleanValue()) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzdN)).booleanValue()) {
                        zzab(view, map, map2);
                        return;
                    }
                    rect = new Rect();
                    if (viewZzY.getGlobalVisibleRect(rect, null) && viewZzY.getHeight() == rect.height() && viewZzY.getWidth() == rect.width()) {
                        zzab(view, map, map2);
                    }
                } else if (zzW(viewZzY)) {
                    zzab(view, map, map2);
                }
            }
        }
    }

    public final synchronized void zzB(com.google.android.gms.ads.internal.client.zzcw zzcwVar) {
        this.zzf.zzj(zzcwVar);
    }

    public final synchronized void zzC(View view, View view2, Map map, Map map2, boolean z) {
        this.zzg.zzc(this.zzo);
        this.zzf.zzk(view, view2, map, map2, z, zzZ());
        if (this.zzr) {
            zzdna zzdnaVar = this.zze;
            if (zzdnaVar.zzs() != null) {
                zzdnaVar.zzs().zzd("onSdkAdUserInteractionClick", new ArrayMap());
            }
        }
    }

    public final synchronized void zzD(final View view, final int i) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkU)).booleanValue()) {
            zzdow zzdowVar = this.zzo;
            if (zzdowVar == null) {
                zzcec.zze("Ad should be associated with an ad view before calling performClickForCustomGesture()");
            } else {
                final boolean z = zzdowVar instanceof zzdnu;
                this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdmp
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzw(view, z, i);
                    }
                });
            }
        }
    }

    public final synchronized void zzE(String str) {
        this.zzf.zzl(str);
    }

    public final synchronized void zzF(Bundle bundle) {
        this.zzf.zzm(bundle);
    }

    public final synchronized void zzG() {
        zzdow zzdowVar = this.zzo;
        if (zzdowVar == null) {
            zzcec.zze("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            final boolean z = zzdowVar instanceof zzdnu;
            this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdmr
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzx(z);
                }
            });
        }
    }

    public final synchronized void zzH() {
        if (this.zzq) {
            return;
        }
        this.zzf.zzr();
    }

    public final void zzI(View view) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfa)).booleanValue()) {
            zzac(view, this.zze.zzu());
            return;
        }
        zzceu zzceuVarZzp = this.zze.zzp();
        if (zzceuVarZzp == null) {
            return;
        }
        zzgen.zzr(zzceuVarZzp, new zzdmu(this, view), this.zzd);
    }

    public final synchronized void zzJ(View view, MotionEvent motionEvent, View view2) {
        this.zzf.zzs(view, motionEvent, view2);
    }

    public final synchronized void zzK(Bundle bundle) {
        this.zzf.zzt(bundle);
    }

    public final synchronized void zzL(View view) {
        this.zzf.zzu(view);
    }

    public final synchronized void zzM() {
        this.zzf.zzv();
    }

    public final synchronized void zzN(com.google.android.gms.ads.internal.client.zzcs zzcsVar) {
        this.zzf.zzw(zzcsVar);
    }

    public final synchronized void zzO(com.google.android.gms.ads.internal.client.zzdg zzdgVar) {
        this.zzx.zza(zzdgVar);
    }

    public final synchronized void zzP(zzblg zzblgVar) {
        this.zzf.zzx(zzblgVar);
    }

    public final synchronized void zzQ(final zzdow zzdowVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbI)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdml
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzy(zzdowVar);
                }
            });
        } else {
            zzy(zzdowVar);
        }
    }

    public final synchronized void zzR(final zzdow zzdowVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbI)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdmm
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzz(zzdowVar);
                }
            });
        } else {
            zzz(zzdowVar);
        }
    }

    public final boolean zzS() {
        return this.zzh.zze();
    }

    public final synchronized boolean zzT() {
        return this.zzf.zzA();
    }

    public final synchronized boolean zzU() {
        return this.zzf.zzB();
    }

    public final boolean zzV() {
        return this.zzh.zzd();
    }

    public final synchronized boolean zzX(Bundle bundle) {
        if (this.zzq) {
            return true;
        }
        boolean zZzC = this.zzf.zzC(bundle);
        this.zzq = zZzC;
        return zZzC;
    }

    public final synchronized int zza() {
        return this.zzf.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcwh
    public final synchronized void zzb() {
        this.zzp = true;
        this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdmq
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzv();
            }
        });
        super.zzb();
    }

    public final zzdmx zzc() {
        return this.zzw;
    }

    public final zzfod zzf(String str, boolean z) {
        String str2;
        zzeii zzeiiVar;
        zzeih zzeihVar;
        String str3;
        if (!this.zzh.zzd() || TextUtils.isEmpty(str)) {
            return null;
        }
        zzdna zzdnaVar = this.zze;
        zzcjk zzcjkVarZzr = zzdnaVar.zzr();
        zzcjk zzcjkVarZzs = zzdnaVar.zzs();
        if (zzcjkVarZzr == null && zzcjkVarZzs == null) {
            zzcec.zzj("Omid display and video webview are null. Skipping initialization.");
            return null;
        }
        boolean z2 = false;
        boolean z3 = zzcjkVarZzr != null;
        boolean z4 = zzcjkVarZzs != null;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeY)).booleanValue()) {
            this.zzh.zza();
            int iZzb = this.zzh.zza().zzb();
            int i = iZzb - 1;
            if (i != 0) {
                if (i != 1) {
                    if (iZzb != 1) {
                        str3 = iZzb != 2 ? "UNKNOWN" : "DISPLAY";
                    } else {
                        str3 = "VIDEO";
                    }
                    zzcec.zzj("Unknown omid media type: " + str3 + ". Not initializing Omid.");
                    return null;
                }
                if (zzcjkVarZzr == null) {
                    zzcec.zzj("Omid media type was display but there was no display webview.");
                    return null;
                }
                z4 = false;
                z2 = true;
            } else {
                if (zzcjkVarZzs == null) {
                    zzcec.zzj("Omid media type was video but there was no video webview.");
                    return null;
                }
                z4 = true;
            }
        } else {
            z2 = z3;
        }
        if (z2) {
            str2 = null;
        } else {
            str2 = "javascript";
            zzcjkVarZzr = zzcjkVarZzs;
        }
        zzcjkVarZzr.zzG();
        if (!com.google.android.gms.ads.internal.zzt.zzA().zzj(this.zzv)) {
            zzcec.zzj("Failed to initialize omid in InternalNativeAd");
            return null;
        }
        zzcei zzceiVar = this.zzu;
        String str4 = zzceiVar.zzb + "." + zzceiVar.zzc;
        if (z4) {
            zzeihVar = zzeih.VIDEO;
            zzeiiVar = zzeii.DEFINED_BY_JAVASCRIPT;
        } else {
            zzdna zzdnaVar2 = this.zze;
            zzeih zzeihVar2 = zzeih.NATIVE_DISPLAY;
            zzeiiVar = zzdnaVar2.zzc() == 3 ? zzeii.UNSPECIFIED : zzeii.ONE_PIXEL;
            zzeihVar = zzeihVar2;
        }
        zzfod zzfodVarZzb = com.google.android.gms.ads.internal.zzt.zzA().zzb(str4, zzcjkVarZzr.zzG(), "", "javascript", str2, str, zzeiiVar, zzeihVar, this.zzb.zzam);
        if (zzfodVarZzb == null) {
            zzcec.zzj("Failed to create omid session in InternalNativeAd");
            return null;
        }
        this.zze.zzW(zzfodVarZzb);
        zzcjkVarZzr.zzaq(zzfodVarZzb);
        if (z4) {
            com.google.android.gms.ads.internal.zzt.zzA().zzh(zzfodVarZzb, zzcjkVarZzs.zzF());
            this.zzr = true;
        }
        if (z) {
            com.google.android.gms.ads.internal.zzt.zzA().zzi(zzfodVarZzb);
            zzcjkVarZzr.zzd("onSdkLoaded", new ArrayMap());
        }
        return zzfodVarZzb;
    }

    public final String zzg() {
        return this.zzh.zzb();
    }

    public final synchronized JSONObject zzi(View view, Map map, Map map2) {
        return this.zzf.zze(view, map, map2, zzZ());
    }

    @Override // com.google.android.gms.internal.ads.zzcwh
    public final void zzj() {
        this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdmn
            @Override // java.lang.Runnable
            public final void run() {
                zzdmv.zzr(this.zza);
            }
        });
        if (this.zze.zzc() != 7) {
            Executor executor = this.zzd;
            final zzdni zzdniVar = this.zzf;
            Objects.requireNonNull(zzdniVar);
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdmo
                @Override // java.lang.Runnable
                public final void run() {
                    zzdniVar.zzp();
                }
            });
        }
        super.zzj();
    }

    public final synchronized JSONObject zzk(View view, Map map, Map map2) {
        return this.zzf.zzf(view, map, map2, zzZ());
    }

    public final void zzt(View view) {
        zzfod zzfodVarZzu = this.zze.zzu();
        if (!this.zzh.zzd() || zzfodVarZzu == null || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzA().zzf(zzfodVarZzu, view);
    }

    public final synchronized void zzu() {
        this.zzf.zzh();
    }

    final /* synthetic */ void zzv() {
        this.zzf.zzi();
        this.zze.zzI();
    }

    final /* synthetic */ void zzw(View view, boolean z, int i) {
        this.zzf.zzo(view, this.zzo.zzf(), this.zzo.zzl(), this.zzo.zzm(), z, zzZ(), i);
    }

    final /* synthetic */ void zzx(boolean z) {
        this.zzf.zzo(null, this.zzo.zzf(), this.zzo.zzl(), this.zzo.zzm(), z, zzZ(), 0);
    }

    public static /* synthetic */ void zzr(zzdmv zzdmvVar) {
        try {
            zzdna zzdnaVar = zzdmvVar.zze;
            int iZzc = zzdnaVar.zzc();
            if (iZzc == 1) {
                if (zzdmvVar.zzi.zzb() != null) {
                    zzdmvVar.zzaa("Google", true);
                    zzdmvVar.zzi.zzb().zze((zzbkd) zzdmvVar.zzj.zzb());
                    return;
                }
                return;
            }
            if (iZzc == 2) {
                if (zzdmvVar.zzi.zza() != null) {
                    zzdmvVar.zzaa("Google", true);
                    zzdmvVar.zzi.zza().zze((zzbkb) zzdmvVar.zzk.zzb());
                    return;
                }
                return;
            }
            if (iZzc == 3) {
                if (zzdmvVar.zzi.zzd(zzdnaVar.zzA()) != null) {
                    if (zzdmvVar.zze.zzs() != null) {
                        zzdmvVar.zzf("Google", true);
                    }
                    zzdmvVar.zzi.zzd(zzdmvVar.zze.zzA()).zze((zzbkg) zzdmvVar.zzn.zzb());
                    return;
                }
                return;
            }
            if (iZzc == 6) {
                if (zzdmvVar.zzi.zzf() != null) {
                    zzdmvVar.zzaa("Google", true);
                    zzdmvVar.zzi.zzf().zze((zzblj) zzdmvVar.zzl.zzb());
                    return;
                }
                return;
            }
            if (iZzc != 7) {
                zzcec.zzg("Wrong native template id!");
                return;
            }
            zzdnl zzdnlVar = zzdmvVar.zzi;
            if (zzdnlVar.zzg() != null) {
                zzdnlVar.zzg().zzg((zzbps) zzdmvVar.zzm.zzb());
            }
        } catch (RemoteException e) {
            zzcec.zzh("RemoteException when notifyAdLoad is called", e);
        }
    }
}
