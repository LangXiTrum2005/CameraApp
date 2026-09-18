package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgzk {
    private static final zzgzk zzb = new zzgzk(true);
    final zzhcl zza = new zzhcb(16);
    private boolean zzc;
    private boolean zzd;

    private zzgzk() {
    }

    public static zzgzk zza() {
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    private static final void zzd(zzgzj zzgzjVar, Object obj) {
        boolean z;
        zzhdf zzhdfVarZzb = zzgzjVar.zzb();
        byte[] bArr = zzhae.zzd;
        obj.getClass();
        zzhdf zzhdfVar = zzhdf.DOUBLE;
        zzhdg zzhdgVar = zzhdg.INT;
        switch (zzhdfVarZzb.zza().ordinal()) {
            case 0:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgzjVar.zza()), zzgzjVar.zzb().zza(), obj.getClass().getName()));
            case 1:
                z = obj instanceof Long;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgzjVar.zza()), zzgzjVar.zzb().zza(), obj.getClass().getName()));
            case 2:
                z = obj instanceof Float;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgzjVar.zza()), zzgzjVar.zzb().zza(), obj.getClass().getName()));
            case 3:
                z = obj instanceof Double;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgzjVar.zza()), zzgzjVar.zzb().zza(), obj.getClass().getName()));
            case 4:
                z = obj instanceof Boolean;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgzjVar.zza()), zzgzjVar.zzb().zza(), obj.getClass().getName()));
            case 5:
                z = obj instanceof String;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgzjVar.zza()), zzgzjVar.zzb().zza(), obj.getClass().getName()));
            case 6:
                if ((obj instanceof zzgyl) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgzjVar.zza()), zzgzjVar.zzb().zza(), obj.getClass().getName()));
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzgzw)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgzjVar.zza()), zzgzjVar.zzb().zza(), obj.getClass().getName()));
            case 8:
                if ((obj instanceof zzhbe) || (obj instanceof zzhaj)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgzjVar.zza()), zzgzjVar.zzb().zza(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzgzjVar.zza()), zzgzjVar.zzb().zza(), obj.getClass().getName()));
        }
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzgzk zzgzkVar = new zzgzk();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry entryZzg = this.zza.zzg(i);
            zzgzkVar.zzc((zzgzj) entryZzg.getKey(), entryZzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzgzkVar.zzc((zzgzj) entry.getKey(), entry.getValue());
        }
        zzgzkVar.zzd = this.zzd;
        return zzgzkVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzgzk) {
            return this.zza.equals(((zzgzk) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (this.zzc) {
            return;
        }
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry entryZzg = this.zza.zzg(i);
            if (entryZzg.getValue() instanceof zzgzu) {
                ((zzgzu) entryZzg.getValue()).zzaS();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzc(zzgzj zzgzjVar, Object obj) {
        if (!zzgzjVar.zzc()) {
            zzd(zzgzjVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzd(zzgzjVar, arrayList.get(i));
            }
            obj = arrayList;
        }
        if (obj instanceof zzhaj) {
            this.zzd = true;
        }
        this.zza.put(zzgzjVar, obj);
    }

    private zzgzk(boolean z) {
        zzb();
        zzb();
    }
}
