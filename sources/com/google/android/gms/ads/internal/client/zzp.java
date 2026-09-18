package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.ads.zzcdv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.0.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzp {
    public static final zzp zza = new zzp();

    protected zzp() {
    }

    public final zzl zza(Context context, zzdx zzdxVar) {
        String strZzq;
        String strZzj = zzdxVar.zzj();
        Set setZzo = zzdxVar.zzo();
        List listUnmodifiableList = !setZzo.isEmpty() ? Collections.unmodifiableList(new ArrayList(setZzo)) : null;
        boolean zZzq = zzdxVar.zzq(context);
        Bundle bundleZze = zzdxVar.zze(AdMobAdapter.class);
        String strZzk = zzdxVar.zzk();
        SearchAdRequest searchAdRequestZzh = zzdxVar.zzh();
        zzfh zzfhVar = searchAdRequestZzh != null ? new zzfh(searchAdRequestZzh) : null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzay.zzb();
            strZzq = zzcdv.zzq(Thread.currentThread().getStackTrace(), packageName);
        } else {
            strZzq = null;
        }
        boolean zZzp = zzdxVar.zzp();
        RequestConfiguration requestConfigurationZzc = zzej.zzf().zzc();
        return new zzl(8, -1L, bundleZze, -1, listUnmodifiableList, zZzq, Math.max(zzdxVar.zzb(), requestConfigurationZzc.getTagForChildDirectedTreatment()), false, strZzk, zzfhVar, null, strZzj, zzdxVar.zzf(), zzdxVar.zzd(), Collections.unmodifiableList(new ArrayList(zzdxVar.zzn())), zzdxVar.zzl(), strZzq, zZzp, null, requestConfigurationZzc.getTagForUnderAgeOfConsent(), (String) Collections.max(Arrays.asList(null, requestConfigurationZzc.getMaxAdContentRating()), new Comparator() { // from class: com.google.android.gms.ads.internal.client.zzo
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return RequestConfiguration.zza.indexOf((String) obj) - RequestConfiguration.zza.indexOf((String) obj2);
            }
        }), zzdxVar.zzm(), zzdxVar.zza(), zzdxVar.zzi(), requestConfigurationZzc.getPublisherPrivacyPersonalizationState().getValue());
    }
}
