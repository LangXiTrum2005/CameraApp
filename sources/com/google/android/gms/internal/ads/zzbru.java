package com.google.android.gms.internal.ads;

import com.bumptech.glide.load.Key;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbru {
    private static final Charset zzc = Charset.forName(Key.STRING_CHARSET_NAME);
    public static final zzbrr zza = new zzbrt();
    public static final zzbrp zzb = new zzbrp() { // from class: com.google.android.gms.internal.ads.zzbrs
        @Override // com.google.android.gms.internal.ads.zzbrp
        public final Object zza(JSONObject jSONObject) {
            return zzbru.zza(jSONObject);
        }
    };

    static /* synthetic */ InputStream zza(JSONObject jSONObject) throws JSONException {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(zzc));
    }
}
