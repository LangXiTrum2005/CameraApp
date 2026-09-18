package com.google.android.gms.internal.ads;

import com.google.common.net.HttpHeaders;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzare extends zzaqa {
    private final Object zza;
    private final zzaqf zzb;

    public zzare(int i, String str, zzaqf zzaqfVar, zzaqe zzaqeVar) {
        super(i, str, zzaqeVar);
        this.zza = new Object();
        this.zzb = zzaqfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    protected final zzaqg zzh(zzapw zzapwVar) {
        String str;
        String str2;
        try {
            byte[] bArr = zzapwVar.zzb;
            Map map = zzapwVar.zzc;
            String str3 = "ISO-8859-1";
            if (map != null && (str2 = (String) map.get(HttpHeaders.CONTENT_TYPE)) != null) {
                String[] strArrSplit = str2.split(";", 0);
                for (int i = 1; i < strArrSplit.length; i++) {
                    String[] strArrSplit2 = strArrSplit[i].trim().split("=", 0);
                    if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                        str3 = strArrSplit2[1];
                        break;
                    }
                }
            }
            str = new String(bArr, str3);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzapwVar.zzb);
        }
        return zzaqg.zzb(str, zzaqx.zzb(zzapwVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzaqa
    /* JADX INFO: renamed from: zzz, reason: merged with bridge method [inline-methods] */
    public void zzo(String str) {
        zzaqf zzaqfVar;
        synchronized (this.zza) {
            zzaqfVar = this.zzb;
        }
        zzaqfVar.zza(str);
    }
}
