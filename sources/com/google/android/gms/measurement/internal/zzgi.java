package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzqp;
import com.google.android.gms.internal.measurement.zzrn;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgi extends zzg {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private final long zzg;
    private final long zzh;
    private List zzi;
    private String zzj;
    private int zzk;
    private String zzl;
    private String zzm;
    private long zzn;
    private String zzo;

    zzgi(zzic zzicVar, long j, long j2) {
        super(zzicVar);
        this.zzn = 0L;
        this.zzo = null;
        this.zzg = j;
        this.zzh = j2;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zze() {
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:30:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:32:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:34:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:38:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:40:0x00da  */
    /* JADX WARN: Code duplicated, block: B:41:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:42:0x0107  */
    /* JADX WARN: Code duplicated, block: B:43:0x0117  */
    /* JADX WARN: Code duplicated, block: B:44:0x0127  */
    /* JADX WARN: Code duplicated, block: B:45:0x0137  */
    /* JADX WARN: Code duplicated, block: B:46:0x0147  */
    /* JADX WARN: Code duplicated, block: B:47:0x0157  */
    /* JADX WARN: Code duplicated, block: B:51:0x0181  */
    /* JADX WARN: Code duplicated, block: B:52:0x0182  */
    /* JADX WARN: Code duplicated, block: B:55:0x0187 A[Catch: IllegalStateException -> 0x0199, TRY_LEAVE, TryCatch #2 {IllegalStateException -> 0x0199, blocks: (B:49:0x016d, B:53:0x0183, B:55:0x0187), top: B:81:0x016d }] */
    /* JADX WARN: Code duplicated, block: B:62:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:64:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:65:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:68:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:71:0x01f3 A[EDGE_INSN: B:71:0x01f3->B:72:0x01f5 BREAK  A[LOOP:0: B:66:0x01da->B:87:?]] */
    /* JADX WARN: Code duplicated, block: B:73:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:75:0x0202  */
    /* JADX WARN: Code duplicated, block: B:85:0x01f3 A[SYNTHETIC] */
    @Override // com.google.android.gms.measurement.internal.zzg
    @EnsuresNonNull({RemoteConfigConstants.RequestFieldKey.APP_ID, "appStore", "appName", "gmpAppId", "gaAppId"})
    protected final void zzf() {
        String str;
        String string;
        int iZzC;
        zzic zzicVar;
        zzic zzicVar2;
        List listZzs;
        Iterator it;
        String strZza;
        zzic zzicVar3 = this.zzu;
        zzicVar3.zzaV().zzk().zzc("sdkVersion bundled with app, dynamiteVersion", Long.valueOf(this.zzh), Long.valueOf(this.zzg));
        String packageName = zzicVar3.zzaY().getPackageName();
        PackageManager packageManager = zzicVar3.zzaY().getPackageManager();
        String str2 = "";
        int i = Integer.MIN_VALUE;
        String str3 = "Unknown";
        String installerPackageName = EnvironmentCompat.MEDIA_UNKNOWN;
        try {
            if (packageManager != null) {
                try {
                    installerPackageName = packageManager.getInstallerPackageName(packageName);
                } catch (IllegalArgumentException unused) {
                    this.zzu.zzaV().zzb().zzb("Error retrieving app installer package name. appId", zzgu.zzl(packageName));
                }
                if (installerPackageName == null) {
                    installerPackageName = "manual_install";
                } else if ("com.android.vending".equals(installerPackageName)) {
                    installerPackageName = "";
                }
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(this.zzu.zzaY().getPackageName(), 0);
                    if (packageInfo != null) {
                        CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                        string = !TextUtils.isEmpty(applicationLabel) ? applicationLabel.toString() : "Unknown";
                        try {
                            str3 = packageInfo.versionName;
                            i = packageInfo.versionCode;
                        } catch (PackageManager.NameNotFoundException unused2) {
                            str = str3;
                            str3 = string;
                            this.zzu.zzaV().zzb().zzc("Error retrieving package info. appId, appName", zzgu.zzl(packageName), str3);
                            string = str3;
                            str3 = str;
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused3) {
                    str = "Unknown";
                }
                this.zza = packageName;
                this.zzd = installerPackageName;
                this.zzb = str3;
                this.zzc = i;
                this.zze = string;
                this.zzf = 0L;
                zzic zzicVar4 = this.zzu;
                iZzC = zzicVar4.zzC();
                if (iZzC != 0) {
                    this.zzu.zzaV().zzk().zza("App measurement collection enabled");
                } else if (iZzC != 1) {
                    this.zzu.zzaV().zzi().zza("App measurement deactivated via the manifest");
                } else if (iZzC != 3) {
                    this.zzu.zzaV().zzi().zza("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                } else if (iZzC != 4) {
                    this.zzu.zzaV().zzi().zza("App measurement disabled via the manifest");
                } else if (iZzC != 6) {
                    this.zzu.zzaV().zzh().zza("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                } else if (iZzC != 7) {
                    this.zzu.zzaV().zzi().zza("App measurement disabled via the global data collection setting");
                } else if (iZzC != 8) {
                    zzic zzicVar5 = this.zzu;
                    zzicVar5.zzaV().zzi().zza("App measurement disabled");
                    zzicVar5.zzaV().zzc().zza("Invalid scion state in identity");
                } else {
                    this.zzu.zzaV().zzi().zza("App measurement disabled due to denied storage consent");
                }
                this.zzl = "";
                zzicVar = this.zzu;
                zzicVar.zzaU();
                strZza = zzlt.zza(zzicVar.zzaY(), "google_app_id", zzicVar4.zzq());
                if (TextUtils.isEmpty(strZza)) {
                    str2 = strZza;
                }
                this.zzl = str2;
                if (iZzC == 0) {
                    zzicVar.zzaV().zzk().zzc("App measurement enabled for app package, google app id", this.zza, this.zzl);
                }
                this.zzi = null;
                zzicVar2 = this.zzu;
                zzicVar2.zzaU();
                listZzs = zzicVar2.zzc().zzs("analytics.safelisted_events");
                if (listZzs != null) {
                    this.zzi = listZzs;
                    break;
                } else if (listZzs.isEmpty()) {
                    it = listZzs.iterator();
                    do {
                        if (it.hasNext()) {
                            this.zzi = listZzs;
                            break;
                        }
                    } while (zzicVar2.zzk().zzk("safelisted event", (String) it.next()));
                } else {
                    zzicVar2.zzaV().zzh().zza("Safelisted event list is empty. Ignoring");
                }
                if (packageManager != null) {
                    this.zzk = InstantApps.isInstantApp(zzicVar2.zzaY()) ? 1 : 0;
                } else {
                    this.zzk = 0;
                }
            }
            zzicVar3.zzaV().zzb().zzb("PackageManager is null, app identity information might be inaccurate. appId", zzgu.zzl(packageName));
            strZza = zzlt.zza(zzicVar.zzaY(), "google_app_id", zzicVar4.zzq());
            if (TextUtils.isEmpty(strZza)) {
                str2 = strZza;
            }
            this.zzl = str2;
            if (iZzC == 0) {
                zzicVar.zzaV().zzk().zzc("App measurement enabled for app package, google app id", this.zza, this.zzl);
            }
        } catch (IllegalStateException e) {
            this.zzu.zzaV().zzb().zzc("Fetching Google App Id failed with exception. appId", zzgu.zzl(packageName), e);
        }
        string = "Unknown";
        this.zza = packageName;
        this.zzd = installerPackageName;
        this.zzb = str3;
        this.zzc = i;
        this.zze = string;
        this.zzf = 0L;
        zzic zzicVar6 = this.zzu;
        iZzC = zzicVar6.zzC();
        if (iZzC != 0) {
            this.zzu.zzaV().zzk().zza("App measurement collection enabled");
        } else if (iZzC != 1) {
            this.zzu.zzaV().zzi().zza("App measurement deactivated via the manifest");
        } else if (iZzC != 3) {
            this.zzu.zzaV().zzi().zza("App measurement disabled by setAnalyticsCollectionEnabled(false)");
        } else if (iZzC != 4) {
            this.zzu.zzaV().zzi().zza("App measurement disabled via the manifest");
        } else if (iZzC != 6) {
            this.zzu.zzaV().zzh().zza("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
        } else if (iZzC != 7) {
            this.zzu.zzaV().zzi().zza("App measurement disabled via the global data collection setting");
        } else if (iZzC != 8) {
            zzic zzicVar7 = this.zzu;
            zzicVar7.zzaV().zzi().zza("App measurement disabled");
            zzicVar7.zzaV().zzc().zza("Invalid scion state in identity");
        } else {
            this.zzu.zzaV().zzi().zza("App measurement disabled due to denied storage consent");
        }
        this.zzl = "";
        zzicVar = this.zzu;
        zzicVar.zzaU();
        this.zzi = null;
        zzicVar2 = this.zzu;
        zzicVar2.zzaU();
        listZzs = zzicVar2.zzc().zzs("analytics.safelisted_events");
        if (listZzs != null) {
            this.zzi = listZzs;
            break;
        } else if (listZzs.isEmpty()) {
            it = listZzs.iterator();
            do {
                if (it.hasNext()) {
                    this.zzi = listZzs;
                    break;
                }
            } while (zzicVar2.zzk().zzk("safelisted event", (String) it.next()));
        } else {
            zzicVar2.zzaV().zzh().zza("Safelisted event list is empty. Ignoring");
        }
        if (packageManager != null) {
            this.zzk = InstantApps.isInstantApp(zzicVar2.zzaY()) ? 1 : 0;
        } else {
            this.zzk = 0;
        }
    }

    final zzr zzh(String str) {
        String str2;
        long j;
        int i;
        List list;
        String str3;
        int i2;
        int i3;
        long j2;
        long jZzP;
        zzg();
        String strZzj = zzj();
        String strZzk = zzk();
        zzb();
        String str4 = this.zzb;
        zzb();
        long j3 = this.zzc;
        zzb();
        Preconditions.checkNotNull(this.zzd);
        String str5 = this.zzd;
        zzic zzicVar = this.zzu;
        zzicVar.zzc().zzi();
        zzb();
        zzg();
        long j4 = this.zzf;
        if (j4 == 0) {
            zzpp zzppVarZzk = this.zzu.zzk();
            Context contextZzaY = zzicVar.zzaY();
            String packageName = zzicVar.zzaY().getPackageName();
            zzppVarZzk.zzg();
            Preconditions.checkNotNull(contextZzaY);
            Preconditions.checkNotEmpty(packageName);
            PackageManager packageManager = contextZzaY.getPackageManager();
            MessageDigest messageDigestZzO = zzpp.zzO();
            if (messageDigestZzO == null) {
                zzppVarZzk.zzu.zzaV().zzb().zza("Could not get MD5 instance");
                j4 = -1;
            } else if (packageManager != null) {
                try {
                    if (zzppVarZzk.zzad(contextZzaY, packageName)) {
                        jZzP = 0;
                    } else {
                        PackageManagerWrapper packageManagerWrapperPackageManager = Wrappers.packageManager(contextZzaY);
                        zzic zzicVar2 = zzppVarZzk.zzu;
                        PackageInfo packageInfo = packageManagerWrapperPackageManager.getPackageInfo(zzicVar2.zzaY().getPackageName(), 64);
                        if (packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                            zzicVar2.zzaV().zze().zza("Could not get signatures");
                            jZzP = -1;
                        } else {
                            jZzP = zzpp.zzP(messageDigestZzO.digest(packageInfo.signatures[0].toByteArray()));
                        }
                    }
                    j4 = jZzP;
                } catch (PackageManager.NameNotFoundException e) {
                    zzppVarZzk.zzu.zzaV().zzb().zzb("Package name not found", e);
                    j4 = 0;
                }
            } else {
                j4 = 0;
            }
            this.zzf = j4;
        }
        long j5 = j4;
        zzic zzicVar3 = this.zzu;
        zzic zzicVar4 = this.zzu;
        boolean zZzB = zzicVar3.zzB();
        boolean z = !zzicVar4.zzd().zzm;
        zzg();
        if (zzicVar3.zzB()) {
            zzrn.zza();
            if (zzicVar4.zzc().zzp(null, zzfy.zzaH)) {
                this.zzu.zzaV().zzk().zza("Disabled IID for tests.");
            } else {
                try {
                    Class<?> clsLoadClass = zzicVar4.zzaY().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                    if (clsLoadClass != null) {
                        try {
                            Object objInvoke = clsLoadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, this.zzu.zzaY());
                            if (objInvoke != null) {
                                try {
                                    str2 = (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", null).invoke(objInvoke, null);
                                } catch (Exception unused) {
                                    this.zzu.zzaV().zzh().zza("Failed to retrieve Firebase Instance Id");
                                    str2 = null;
                                }
                            }
                        } catch (Exception unused2) {
                            this.zzu.zzaV().zzf().zza("Failed to obtain Firebase Analytics instance");
                        }
                    }
                } catch (ClassNotFoundException unused3) {
                }
            }
            str2 = null;
        } else {
            str2 = null;
        }
        zzic zzicVar5 = this.zzu;
        long jZza = zzicVar5.zzd().zzc.zza();
        long jMin = jZza == 0 ? zzicVar5.zza : Math.min(zzicVar5.zza, jZza);
        zzb();
        int i4 = this.zzk;
        zzic zzicVar6 = this.zzu;
        boolean zZzu = zzicVar6.zzc().zzu();
        zzhh zzhhVarZzd = zzicVar6.zzd();
        zzhhVarZzd.zzg();
        boolean z2 = zzhhVarZzd.zzd().getBoolean("deferred_analytics_collection", false);
        boolean z3 = zzicVar6.zzc().zzw("google_analytics_default_allow_ad_personalization_signals", true) != zzji.GRANTED;
        long j6 = this.zzg;
        Boolean boolValueOf = Boolean.valueOf(z3);
        List list2 = this.zzi;
        String strZzl = zzicVar6.zzd().zzl().zzl();
        if (this.zzj == null) {
            this.zzj = zzicVar6.zzk().zzaw();
        }
        String str6 = this.zzj;
        if (zzicVar6.zzd().zzl().zzo(zzjk.ANALYTICS_STORAGE)) {
            zzg();
            j = 0;
            if (this.zzn == 0) {
                i = i4;
                list = list2;
            } else {
                i = i4;
                list = list2;
                long jCurrentTimeMillis = zzicVar6.zzaZ().currentTimeMillis() - this.zzn;
                if (this.zzm != null && jCurrentTimeMillis > 86400000 && this.zzo == null) {
                    zzi();
                }
            }
            if (this.zzm == null) {
                zzi();
            }
            str3 = this.zzm;
        } else {
            i = i4;
            list = list2;
            j = 0;
            str3 = null;
        }
        boolean zZzx = zzicVar6.zzc().zzx();
        zzpp zzppVarZzk2 = zzicVar6.zzk();
        String strZzj2 = zzj();
        zzic zzicVar7 = zzppVarZzk2.zzu;
        if (zzicVar7.zzaY().getPackageManager() == null) {
            j2 = j;
            i2 = 0;
        } else {
            try {
                i2 = 0;
                try {
                    ApplicationInfo applicationInfo = Wrappers.packageManager(zzicVar7.zzaY()).getApplicationInfo(strZzj2, 0);
                    i3 = applicationInfo != null ? applicationInfo.targetSdkVersion : i2;
                } catch (PackageManager.NameNotFoundException unused4) {
                    zzic zzicVar8 = zzppVarZzk2.zzu;
                    zzicVar8.zzaU();
                    zzicVar8.zzaV().zzi().zzb("PackageManager failed to find running app: app_id", strZzj2);
                }
            } catch (PackageManager.NameNotFoundException unused5) {
                i2 = 0;
            }
            j2 = i3;
        }
        zzic zzicVar9 = this.zzu;
        int iZzb = zzicVar9.zzd().zzl().zzb();
        String strZze = zzicVar9.zzd().zzj().zze();
        zzqp.zza();
        zzal zzalVarZzc = zzicVar9.zzc();
        zzfx zzfxVar = zzfy.zzaQ;
        int iZzU = zzalVarZzc.zzp(null, zzfxVar) ? zzicVar9.zzk().zzU() : i2;
        zzqp.zza();
        return new zzr(strZzj, strZzk, str4, j3, str5, 133005L, j5, str, zZzB, z, str2, jMin, i, zZzu, z2, boolValueOf, j6, list, strZzl, str6, str3, zZzx, j2, iZzb, strZze, iZzU, zzicVar9.zzc().zzp(null, zzfxVar) ? zzicVar9.zzk().zzV() : j, zzicVar9.zzc().zzz(), new zze(zzicVar9.zzc().zzw("google_analytics_default_allow_ad_personalization_signals", true)).zzb(), this.zzu.zza, this.zzu.zzx().zzj().zza());
    }

    final void zzi() {
        String str;
        zzg();
        zzic zzicVar = this.zzu;
        if (zzicVar.zzd().zzl().zzo(zzjk.ANALYTICS_STORAGE)) {
            byte[] bArr = new byte[16];
            zzicVar.zzk().zzf().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            zzicVar.zzaV().zzj().zza("Analytics Storage consent is not granted");
            str = null;
        }
        zzicVar.zzaV().zzj().zza(String.format("Resetting session stitching token to %s", str == null ? "null" : "not null"));
        this.zzm = str;
        this.zzn = zzicVar.zzaZ().currentTimeMillis();
    }

    final String zzj() {
        zzb();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    final String zzk() {
        zzg();
        zzb();
        Preconditions.checkNotNull(this.zzl);
        return this.zzl;
    }

    final String zzl() {
        zzb();
        Preconditions.checkNotNull(this.zze);
        return this.zze;
    }

    final int zzm() {
        zzb();
        return this.zzc;
    }

    final long zzn() {
        return this.zzh;
    }

    final int zzo() {
        zzb();
        return this.zzk;
    }

    final List zzp() {
        return this.zzi;
    }

    final boolean zzq(String str) {
        String str2 = this.zzo;
        boolean z = false;
        if (str2 != null && !str2.equals(str)) {
            z = true;
        }
        this.zzo = str;
        return z;
    }
}
