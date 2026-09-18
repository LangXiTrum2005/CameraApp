package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfpw {
    private final HashMap zza = new HashMap();
    private final HashMap zzb = new HashMap();
    private final HashMap zzc = new HashMap();
    private final HashSet zzd = new HashSet();
    private final HashSet zze = new HashSet();
    private final HashSet zzf = new HashSet();
    private final HashMap zzg = new HashMap();
    private final Map zzh = new WeakHashMap();
    private boolean zzi;

    public final View zza(String str) {
        return (View) this.zzc.get(str);
    }

    public final zzfpv zzb(View view) {
        zzfpv zzfpvVar = (zzfpv) this.zzb.get(view);
        if (zzfpvVar != null) {
            this.zzb.remove(view);
        }
        return zzfpvVar;
    }

    public final String zzc(String str) {
        return (String) this.zzg.get(str);
    }

    public final String zzd(View view) {
        if (this.zza.size() == 0) {
            return null;
        }
        String str = (String) this.zza.get(view);
        if (str != null) {
            this.zza.remove(view);
        }
        return str;
    }

    public final HashSet zze() {
        return this.zzf;
    }

    public final HashSet zzf() {
        return this.zze;
    }

    public final void zzg() {
        this.zza.clear();
        this.zzb.clear();
        this.zzc.clear();
        this.zzd.clear();
        this.zze.clear();
        this.zzf.clear();
        this.zzg.clear();
        this.zzi = false;
    }

    public final void zzh() {
        this.zzi = true;
    }

    public final void zzi() {
        Boolean bool;
        String str;
        zzfov zzfovVarZza = zzfov.zza();
        if (zzfovVarZza != null) {
            for (zzfoh zzfohVar : zzfovVarZza.zzb()) {
                View viewZzf = zzfohVar.zzf();
                if (zzfohVar.zzj()) {
                    String strZzh = zzfohVar.zzh();
                    if (viewZzf != null) {
                        if (viewZzf.isAttachedToWindow()) {
                            if (viewZzf.hasWindowFocus()) {
                                this.zzh.remove(viewZzf);
                                bool = false;
                            } else if (this.zzh.containsKey(viewZzf)) {
                                bool = (Boolean) this.zzh.get(viewZzf);
                            } else {
                                this.zzh.put(viewZzf, false);
                                bool = false;
                            }
                            if (!bool.booleanValue()) {
                                HashSet hashSet = new HashSet();
                                View view = viewZzf;
                                while (true) {
                                    if (view == null) {
                                        this.zzd.addAll(hashSet);
                                        str = null;
                                        break;
                                    }
                                    String strZza = zzfpu.zza(view);
                                    if (strZza != null) {
                                        str = strZza;
                                        break;
                                    } else {
                                        hashSet.add(view);
                                        Object parent = view.getParent();
                                        view = parent instanceof View ? (View) parent : null;
                                    }
                                }
                            } else {
                                str = "noWindowFocus";
                            }
                        } else {
                            str = "notAttached";
                        }
                        if (str == null) {
                            this.zze.add(strZzh);
                            this.zza.put(viewZzf, strZzh);
                            for (zzfoy zzfoyVar : zzfohVar.zzi()) {
                                View view2 = (View) zzfoyVar.zzb().get();
                                if (view2 != null) {
                                    zzfpv zzfpvVar = (zzfpv) this.zzb.get(view2);
                                    if (zzfpvVar != null) {
                                        zzfpvVar.zzc(zzfohVar.zzh());
                                    } else {
                                        this.zzb.put(view2, new zzfpv(zzfoyVar, zzfohVar.zzh()));
                                    }
                                }
                            }
                        } else if (str != "noWindowFocus") {
                            this.zzf.add(strZzh);
                            this.zzc.put(strZzh, viewZzf);
                            this.zzg.put(strZzh, str);
                        }
                    } else {
                        this.zzf.add(strZzh);
                        this.zzg.put(strZzh, "noAdView");
                    }
                }
            }
        }
    }

    public final boolean zzj(View view) {
        if (!this.zzh.containsKey(view)) {
            return true;
        }
        this.zzh.put(view, true);
        return false;
    }

    public final int zzk(View view) {
        if (this.zzd.contains(view)) {
            return 1;
        }
        return this.zzi ? 2 : 3;
    }
}
