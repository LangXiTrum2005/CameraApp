package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.LocaleList;
import android.os.StatFs;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzexx implements zzexq {
    private final zzgey zza;
    private final Context zzb;

    public zzexx(zzgey zzgeyVar, Context context) {
        this.zza = zzgeyVar;
        this.zzb = context;
    }

    private static ResolveInfo zzd(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 38;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final ListenableFuture zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzexw
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0067  */
    /* JADX WARN: Code duplicated, block: B:40:0x013a  */
    /* JADX WARN: Code duplicated, block: B:42:0x0145  */
    /* JADX WARN: Code duplicated, block: B:43:0x0147  */
    /* JADX WARN: Code duplicated, block: B:46:0x015a  */
    /* JADX WARN: Code duplicated, block: B:53:0x0179  */
    /* JADX WARN: Code duplicated, block: B:54:0x017b  */
    /* JADX WARN: Code duplicated, block: B:56:0x017f  */
    /* JADX WARN: Code duplicated, block: B:57:0x0181  */
    /* JADX WARN: Code duplicated, block: B:59:0x0184  */
    /* JADX WARN: Code duplicated, block: B:60:0x0186  */
    final /* synthetic */ zzexv zzc() throws Exception {
        ActivityInfo activityInfo;
        String str;
        String str2;
        String str3;
        boolean zEquals;
        boolean z;
        String string;
        boolean z2;
        boolean z3;
        Bundle bundle;
        PackageManager packageManager = this.zzb.getPackageManager();
        Locale locale = Locale.getDefault();
        ResolveInfo resolveInfoZzd = zzd(packageManager, "geo:0,0?q=donuts");
        ResolveInfo resolveInfoZzd2 = zzd(packageManager, "http://www.google.com");
        String country = locale.getCountry();
        com.google.android.gms.ads.internal.zzt.zzp();
        com.google.android.gms.ads.internal.client.zzay.zzb();
        boolean zZzr = zzcdv.zzr();
        Context context = this.zzb;
        boolean zIsLatchsky = DeviceProperties.isLatchsky(context);
        boolean zIsSidewinder = DeviceProperties.isSidewinder(context);
        String language = locale.getLanguage();
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList localeList = LocaleList.getDefault();
            for (int i = 0; i < localeList.size(); i++) {
                arrayList.add(localeList.get(i).getLanguage());
            }
        }
        Context context2 = this.zzb;
        ResolveInfo resolveInfoZzd3 = zzd(packageManager, "market://details?id=com.google.android.gms.ads");
        if (resolveInfoZzd3 == null || (activityInfo = resolveInfoZzd3.activityInfo) == null) {
            str = null;
        } else {
            try {
                PackageInfo packageInfo = Wrappers.packageManager(context2).getPackageInfo(activityInfo.packageName, 0);
                if (packageInfo != null) {
                    str = packageInfo.versionCode + "." + activityInfo.packageName;
                } else {
                    str = null;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        try {
            PackageInfo packageInfo2 = Wrappers.packageManager(this.zzb).getPackageInfo("com.android.vending", 128);
            str2 = packageInfo2 != null ? packageInfo2.versionCode + "." + packageInfo2.packageName : null;
        } catch (Exception unused2) {
        }
        Context context3 = this.zzb;
        String str4 = Build.FINGERPRINT;
        if (packageManager != null) {
            str3 = str2;
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
            ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            if (listQueryIntentActivities != null && resolveInfoResolveActivity != null) {
                int i2 = 0;
                while (true) {
                    if (i2 < listQueryIntentActivities.size()) {
                        List<ResolveInfo> list = listQueryIntentActivities;
                        if (resolveInfoResolveActivity.activityInfo.name.equals(listQueryIntentActivities.get(i2).activityInfo.name)) {
                            zEquals = resolveInfoResolveActivity.activityInfo.packageName.equals(zzhhv.zza(context3));
                            break;
                        }
                        i2++;
                        listQueryIntentActivities = list;
                    }
                }
            }
            com.google.android.gms.ads.internal.zzt.zzp();
            long availableBytes = new StatFs(Environment.getDataDirectory().getAbsolutePath()).getAvailableBytes() / 1024;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkM)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.zzp();
                if (com.google.android.gms.ads.internal.util.zzt.zzA(this.zzb)) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkO)).booleanValue()) {
                Context context4 = this.zzb;
                try {
                    bundle = Wrappers.packageManager(context4).getApplicationInfo(context4.getPackageName(), 128).metaData;
                    if (bundle == null && bundle.containsKey("com.google.unity.ads.UNITY_VERSION")) {
                        string = bundle.getString("com.google.unity.ads.UNITY_VERSION");
                    } else {
                        string = null;
                    }
                } catch (PackageManager.NameNotFoundException unused3) {
                }
            } else {
                string = "";
            }
            if (resolveInfoZzd2 != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (resolveInfoZzd != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            return new zzexv(z3, z2, country, zZzr, zIsLatchsky, zIsSidewinder, language, arrayList, str, str3, str4, zEquals, Build.MODEL, availableBytes, z, string, Build.VERSION.SDK_INT);
        }
        str3 = str2;
        zEquals = false;
        com.google.android.gms.ads.internal.zzt.zzp();
        long availableBytes2 = new StatFs(Environment.getDataDirectory().getAbsolutePath()).getAvailableBytes() / 1024;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkM)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzp();
            if (com.google.android.gms.ads.internal.util.zzt.zzA(this.zzb)) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkO)).booleanValue()) {
            Context context5 = this.zzb;
            bundle = Wrappers.packageManager(context5).getApplicationInfo(context5.getPackageName(), 128).metaData;
            if (bundle == null) {
                string = null;
            } else {
                string = null;
            }
        } else {
            string = "";
        }
        if (resolveInfoZzd2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (resolveInfoZzd != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        return new zzexv(z3, z2, country, zZzr, zIsLatchsky, zIsSidewinder, language, arrayList, str, str3, str4, zEquals, Build.MODEL, availableBytes2, z, string, Build.VERSION.SDK_INT);
    }
}
