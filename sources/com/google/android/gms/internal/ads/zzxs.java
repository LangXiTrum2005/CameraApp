package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzxs extends zzdf {
    private boolean zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private final SparseArray zzh;
    private final SparseBooleanArray zzi;

    @Deprecated
    public zzxs() {
        this.zzh = new SparseArray();
        this.zzi = new SparseBooleanArray();
        zzx();
    }

    private final void zzx() {
        this.zza = true;
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
        this.zzf = true;
        this.zzg = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdf
    public final /* synthetic */ zzdf zzf(int i, int i2, boolean z) {
        super.zzf(i, i2, true);
        return this;
    }

    public final zzxs zzp(int i, boolean z) {
        if (this.zzi.get(i) != z) {
            if (z) {
                this.zzi.put(i, true);
            } else {
                this.zzi.delete(i);
            }
        }
        return this;
    }

    public zzxs(Context context) {
        super.zze(context);
        Point pointZzu = zzfy.zzu(context);
        zzf(pointZzu.x, pointZzu.y, true);
        this.zzh = new SparseArray();
        this.zzi = new SparseBooleanArray();
        zzx();
    }

    /* synthetic */ zzxs(zzxu zzxuVar, zzxr zzxrVar) {
        super(zzxuVar);
        this.zza = zzxuVar.zzI;
        this.zzb = zzxuVar.zzK;
        this.zzc = zzxuVar.zzM;
        this.zzd = zzxuVar.zzR;
        this.zze = zzxuVar.zzS;
        this.zzf = zzxuVar.zzT;
        this.zzg = zzxuVar.zzV;
        SparseArray sparseArray = zzxuVar.zzap;
        SparseArray sparseArray2 = new SparseArray();
        for (int i = 0; i < sparseArray.size(); i++) {
            sparseArray2.put(sparseArray.keyAt(i), new HashMap((Map) sparseArray.valueAt(i)));
        }
        this.zzh = sparseArray2;
        this.zzi = zzxuVar.zzaq.clone();
    }
}
