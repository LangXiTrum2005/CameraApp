package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public final class zzdpb implements zzdni {
    private final zzbtk zza;
    private final zzdbp zzb;
    private final zzdav zzc;
    private final zzdis zzd;
    private final Context zze;
    private final zzfgm zzf;
    private final zzcei zzg;
    private final zzfhh zzh;
    private boolean zzi = false;
    private boolean zzj = false;
    private boolean zzk = true;
    private final zzbtg zzl;
    private final zzbth zzm;

    public zzdpb(zzbtg zzbtgVar, zzbth zzbthVar, zzbtk zzbtkVar, zzdbp zzdbpVar, zzdav zzdavVar, zzdis zzdisVar, Context context, zzfgm zzfgmVar, zzcei zzceiVar, zzfhh zzfhhVar) {
        this.zzl = zzbtgVar;
        this.zzm = zzbthVar;
        this.zza = zzbtkVar;
        this.zzb = zzdbpVar;
        this.zzc = zzdavVar;
        this.zzd = zzdisVar;
        this.zze = context;
        this.zzf = zzfgmVar;
        this.zzg = zzceiVar;
        this.zzh = zzfhhVar;
    }

    private final void zzb(View view) {
        try {
            zzbtk zzbtkVar = this.zza;
            if (zzbtkVar != null && !zzbtkVar.zzA()) {
                this.zza.zzw(ObjectWrapper.wrap(view));
                this.zzc.onAdClicked();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkm)).booleanValue()) {
                    this.zzd.zzs();
                    return;
                }
                return;
            }
            zzbtg zzbtgVar = this.zzl;
            if (zzbtgVar != null && !zzbtgVar.zzx()) {
                this.zzl.zzs(ObjectWrapper.wrap(view));
                this.zzc.onAdClicked();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkm)).booleanValue()) {
                    this.zzd.zzs();
                    return;
                }
                return;
            }
            zzbth zzbthVar = this.zzm;
            if (zzbthVar == null || zzbthVar.zzv()) {
                return;
            }
            this.zzm.zzq(ObjectWrapper.wrap(view));
            this.zzc.onAdClicked();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkm)).booleanValue()) {
                this.zzd.zzs();
            }
        } catch (RemoteException e) {
            zzcec.zzk("Failed to call handleClick", e);
        }
    }

    private static final HashMap zzc(Map map) {
        HashMap map2 = new HashMap();
        if (map != null) {
            synchronized (map) {
                for (Map.Entry entry : map.entrySet()) {
                    View view = (View) ((WeakReference) entry.getValue()).get();
                    if (view != null) {
                        map2.put((String) entry.getKey(), view);
                    }
                }
            }
        }
        return map2;
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final boolean zzA() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final boolean zzB() {
        return this.zzf.zzM;
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final boolean zzC(Bundle bundle) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final JSONObject zze(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final JSONObject zzf(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzg() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzh() {
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzi() {
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzj(com.google.android.gms.ads.internal.client.zzcw zzcwVar) {
        zzcec.zzj("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzk(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType) {
        if (this.zzj && this.zzf.zzM) {
            return;
        }
        zzb(view);
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzl(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzm(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzo(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType, int i) {
        if (!this.zzj) {
            zzcec.zzj("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (this.zzf.zzM) {
            zzb(view2);
        } else {
            zzcec.zzj("Custom click reporting for 3p ads failed. Ad unit id not in allow list.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzp() {
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzq(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        try {
            if (!this.zzi) {
                this.zzi = com.google.android.gms.ads.internal.zzt.zzs().zzn(this.zze, this.zzg.zza, this.zzf.zzD.toString(), this.zzh.zzf);
            }
            if (this.zzk) {
                zzbtk zzbtkVar = this.zza;
                if (zzbtkVar != null && !zzbtkVar.zzB()) {
                    this.zza.zzx();
                    this.zzb.zza();
                    return;
                }
                zzbtg zzbtgVar = this.zzl;
                if (zzbtgVar != null && !zzbtgVar.zzy()) {
                    this.zzl.zzt();
                    this.zzb.zza();
                    return;
                }
                zzbth zzbthVar = this.zzm;
                if (zzbthVar == null || zzbthVar.zzw()) {
                    return;
                }
                this.zzm.zzr();
                this.zzb.zza();
            }
        } catch (RemoteException e) {
            zzcec.zzk("Failed to call recordImpression", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzr() {
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzs(View view, MotionEvent motionEvent, View view2) {
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzt(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzu(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzv() {
        this.zzj = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzw(com.google.android.gms.ads.internal.client.zzcs zzcsVar) {
        zzcec.zzj("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzx(zzblg zzblgVar) {
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00cc A[Catch: JSONException -> 0x0044, RemoteException -> 0x0122, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0044, blocks: (B:47:0x00b1, B:48:0x00c6, B:50:0x00cc), top: B:72:0x00b1 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x005f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x0044 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x00c6 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzy(View view, Map map, Map map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        Object obj;
        ClassLoader classLoader;
        Iterator it;
        IObjectWrapper iObjectWrapperZzn;
        try {
            IObjectWrapper iObjectWrapperWrap = ObjectWrapper.wrap(view);
            JSONObject jSONObject = this.zzf.zzak;
            boolean z = true;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbx)).booleanValue() && jSONObject.length() != 0) {
                Map map3 = map == null ? new HashMap() : map;
                Map map4 = map2 == null ? new HashMap() : map2;
                HashMap map5 = new HashMap();
                map5.putAll(map3);
                map5.putAll(map4);
                Iterator<String> itKeys = jSONObject.keys();
                loop0: while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(next);
                    if (jSONArrayOptJSONArray != null) {
                        WeakReference weakReference = (WeakReference) map5.get(next);
                        if (weakReference != null && (obj = weakReference.get()) != null) {
                            Class<?> cls = obj.getClass();
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzby)).booleanValue() && next.equals("3010")) {
                                zzbtk zzbtkVar = this.zza;
                                Object objUnwrap = null;
                                if (zzbtkVar != null) {
                                    try {
                                        iObjectWrapperZzn = zzbtkVar.zzn();
                                    } catch (RemoteException | IllegalArgumentException unused) {
                                    }
                                } else {
                                    zzbtg zzbtgVar = this.zzl;
                                    if (zzbtgVar != null) {
                                        iObjectWrapperZzn = zzbtgVar.zzk();
                                    } else {
                                        zzbth zzbthVar = this.zzm;
                                        iObjectWrapperZzn = zzbthVar != null ? zzbthVar.zzj() : null;
                                    }
                                }
                                if (iObjectWrapperZzn != null) {
                                    objUnwrap = ObjectWrapper.unwrap(iObjectWrapperZzn);
                                }
                                if (objUnwrap != null) {
                                    cls = objUnwrap.getClass();
                                    ArrayList arrayList = new ArrayList();
                                    com.google.android.gms.ads.internal.util.zzbw.zzc(jSONArrayOptJSONArray, arrayList);
                                    com.google.android.gms.ads.internal.zzt.zzp();
                                    classLoader = this.zze.getClassLoader();
                                    it = arrayList.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            if (Class.forName((String) it.next(), false, classLoader).isAssignableFrom(cls)) {
                                            }
                                        }
                                    }
                                }
                            } else {
                                try {
                                    ArrayList arrayList2 = new ArrayList();
                                    com.google.android.gms.ads.internal.util.zzbw.zzc(jSONArrayOptJSONArray, arrayList2);
                                    com.google.android.gms.ads.internal.zzt.zzp();
                                    classLoader = this.zze.getClassLoader();
                                    it = arrayList2.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            if (Class.forName((String) it.next(), false, classLoader).isAssignableFrom(cls)) {
                                            }
                                        }
                                    }
                                } catch (JSONException unused2) {
                                    continue;
                                }
                            }
                        }
                        z = false;
                        break;
                    }
                }
            }
            this.zzk = z;
            HashMap mapZzc = zzc(map);
            HashMap mapZzc2 = zzc(map2);
            zzbtk zzbtkVar2 = this.zza;
            if (zzbtkVar2 != null) {
                zzbtkVar2.zzy(iObjectWrapperWrap, ObjectWrapper.wrap(mapZzc), ObjectWrapper.wrap(mapZzc2));
                return;
            }
            zzbtg zzbtgVar2 = this.zzl;
            if (zzbtgVar2 != null) {
                zzbtgVar2.zzv(iObjectWrapperWrap, ObjectWrapper.wrap(mapZzc), ObjectWrapper.wrap(mapZzc2));
                this.zzl.zzu(iObjectWrapperWrap);
                return;
            }
            zzbth zzbthVar2 = this.zzm;
            if (zzbthVar2 != null) {
                zzbthVar2.zzt(iObjectWrapperWrap, ObjectWrapper.wrap(mapZzc), ObjectWrapper.wrap(mapZzc2));
                this.zzm.zzs(iObjectWrapperWrap);
            }
        } catch (RemoteException e) {
            zzcec.zzk("Failed to call trackView", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdni
    public final void zzz(View view, Map map) {
        try {
            IObjectWrapper iObjectWrapperWrap = ObjectWrapper.wrap(view);
            zzbtk zzbtkVar = this.zza;
            if (zzbtkVar != null) {
                zzbtkVar.zzz(iObjectWrapperWrap);
                return;
            }
            zzbtg zzbtgVar = this.zzl;
            if (zzbtgVar != null) {
                zzbtgVar.zzw(iObjectWrapperWrap);
                return;
            }
            zzbth zzbthVar = this.zzm;
            if (zzbthVar != null) {
                zzbthVar.zzu(iObjectWrapperWrap);
            }
        } catch (RemoteException e) {
            zzcec.zzk("Failed to call untrackView", e);
        }
    }
}
