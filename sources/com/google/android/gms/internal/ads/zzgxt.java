package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgxs;
import com.google.android.gms.internal.ads.zzgxt;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgxt<MessageType extends zzgxt<MessageType, BuilderType>, BuilderType extends zzgxs<MessageType, BuilderType>> implements zzhbe {
    protected int zza = 0;

    /* JADX WARN: Multi-variable type inference failed */
    protected static void zzav(Iterable iterable, List list) {
        byte[] bArr = zzhae.zzd;
        iterable.getClass();
        if (iterable instanceof zzham) {
            List listZzh = ((zzham) iterable).zzh();
            zzham zzhamVar = (zzham) list;
            int size = list.size();
            for (Object obj : listZzh) {
                if (obj == null) {
                    String str = "Element at index " + (zzhamVar.size() - size) + " is null.";
                    int size2 = zzhamVar.size();
                    while (true) {
                        size2--;
                        if (size2 < size) {
                            throw new NullPointerException(str);
                        }
                        zzhamVar.remove(size2);
                    }
                } else if (obj instanceof zzgyl) {
                    zzhamVar.zzi((zzgyl) obj);
                } else {
                    zzhamVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof zzhbm) {
            list.addAll(iterable);
            return;
        }
        if (list instanceof ArrayList) {
            ((ArrayList) list).ensureCapacity(list.size() + iterable.size());
        }
        int size3 = list.size();
        for (Object obj2 : iterable) {
            if (obj2 == null) {
                String str2 = "Element at index " + (list.size() - size3) + " is null.";
                int size4 = list.size();
                while (true) {
                    size4--;
                    if (size4 < size3) {
                        throw new NullPointerException(str2);
                    }
                    list.remove(size4);
                }
            } else {
                list.add(obj2);
            }
        }
    }

    int zzat(zzhby zzhbyVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final zzgyl zzau() {
        try {
            int iZzaz = zzaz();
            zzgyl zzgylVar = zzgyl.zzb;
            byte[] bArr = new byte[iZzaz];
            zzgza zzgzaVarZzB = zzgza.zzB(bArr, 0, iZzaz);
            zzaW(zzgzaVarZzB);
            zzgzaVarZzB.zzC();
            return new zzgyh(bArr);
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public final void zzaw(OutputStream outputStream) throws IOException {
        int iZzaz = zzaz();
        int i = zzgza.zzf;
        if (iZzaz > 4096) {
            iZzaz = 4096;
        }
        zzgyy zzgyyVar = new zzgyy(outputStream, iZzaz);
        zzaW(zzgyyVar);
        zzgyyVar.zzH();
    }

    public final byte[] zzax() {
        try {
            int iZzaz = zzaz();
            byte[] bArr = new byte[iZzaz];
            zzgza zzgzaVarZzB = zzgza.zzB(bArr, 0, iZzaz);
            zzaW(zzgzaVarZzB);
            zzgzaVarZzB.zzC();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
