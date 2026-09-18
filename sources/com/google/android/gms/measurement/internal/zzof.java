package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzof {
    static final ImmutableList zza = ImmutableList.of("Version", "GoogleConsent", "VendorConsent", "VendorLegitimateInterest", "gdprApplies", "EnableAdvertiserConsentMode", "PolicyVersion", "PurposeConsents", "PurposeOneTreatment", "Purpose1", "Purpose3", "Purpose4", "Purpose7", "CmpSdkID", "PublisherCC", "PublisherRestrictions1", "PublisherRestrictions3", "PublisherRestrictions4", "PublisherRestrictions7", "AuthorizePurpose1", "AuthorizePurpose3", "AuthorizePurpose4", "AuthorizePurpose7", "PurposeDiagnostics");
    public static final /* synthetic */ int zzb = 0;

    static String zza(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getString(str, "");
        } catch (ClassCastException unused) {
            return "";
        }
    }

    static int zzb(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getInt(str, -1);
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0073  */
    /* JADX WARN: Code duplicated, block: B:15:0x0077  */
    /* JADX WARN: Code duplicated, block: B:17:0x007d  */
    /* JADX WARN: Code duplicated, block: B:19:0x0086  */
    /* JADX WARN: Code duplicated, block: B:21:0x008c  */
    /* JADX WARN: Code duplicated, block: B:26:0x0099  */
    /* JADX WARN: Code duplicated, block: B:27:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:31:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:45:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:47:0x0120  */
    /* JADX WARN: Code duplicated, block: B:49:0x0144  */
    /* JADX WARN: Code duplicated, block: B:51:0x016b  */
    /* JADX WARN: Code duplicated, block: B:53:0x018f  */
    /* JADX WARN: Code duplicated, block: B:55:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:58:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:60:0x0200  */
    /* JADX WARN: Code duplicated, block: B:69:0x0235  */
    static final boolean zzc(com.google.android.gms.internal.measurement.zzkp zzkpVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        char c;
        int i12;
        zzoe zzoeVar;
        int iOrdinal;
        char c2;
        int iZze = zze(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, true);
        if (iZze > 0) {
            i7 = i3;
            i6 = i2;
            if (i7 == 1) {
                if (i6 != 1) {
                    i7 = 1;
                } else {
                    i9 = 1;
                    i8 = 1;
                }
                if (zzi(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i5, str, str2, str3, z, z2, true) == com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_NOT_ALLOWED) {
                    c2 = '3';
                } else {
                    if (zzkpVar == com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
                        i10 = i5;
                        i11 = 1;
                        if (i10 == 1) {
                            if (immutableSet.contains(str)) {
                                if (iZze > 0 && cArr[iZze] != '2') {
                                    cArr[iZze] = '1';
                                }
                                return true;
                            }
                            c = '2';
                            i12 = 1;
                        }
                        if (immutableMap.containsKey(zzkpVar) || (zzoeVar = (zzoe) immutableMap.get(zzkpVar)) == null) {
                            c2 = '0';
                        } else {
                            iOrdinal = zzoeVar.ordinal();
                            if (iOrdinal != 0) {
                                if (iOrdinal != i11) {
                                    if (iOrdinal != 2) {
                                        return zzi(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true) == com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST ? zzh(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true) : zzg(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true);
                                    }
                                    if (iOrdinal == 3) {
                                        return zzi(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true) == com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_CONSENT ? zzg(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true) : zzh(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true);
                                    }
                                    c2 = '0';
                                } else if (zzi(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true) != com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_CONSENT) {
                                    return zzh(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true);
                                }
                            } else if (zzi(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true) != com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST) {
                                return zzg(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true);
                            }
                            c2 = '8';
                        }
                    } else {
                        i10 = i5;
                        i11 = 1;
                    }
                    c = '2';
                    i12 = i10;
                    if (immutableMap.containsKey(zzkpVar)) {
                        c2 = '0';
                    } else {
                        iOrdinal = zzoeVar.ordinal();
                        if (iOrdinal != 0) {
                            if (iOrdinal != i11) {
                                if (iOrdinal != 2) {
                                    if (zzi(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true) == com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST) {
                                    }
                                }
                                if (iOrdinal == 3) {
                                    if (zzi(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true) == com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_CONSENT) {
                                    }
                                }
                                c2 = '0';
                            } else if (zzi(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true) != com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_CONSENT) {
                                return zzh(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true);
                            }
                        } else if (zzi(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true) != com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST) {
                            return zzg(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true);
                        }
                        c2 = '8';
                    }
                }
                if (iZze <= 0 && cArr[iZze] != '2') {
                    cArr[iZze] = c2;
                    return false;
                }
            }
            cArr[iZze] = '2';
        } else {
            i6 = i2;
            i7 = i3;
        }
        i8 = i7;
        i9 = i6;
        if (zzi(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i5, str, str2, str3, z, z2, true) == com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_NOT_ALLOWED) {
            c2 = '3';
        } else {
            if (zzkpVar == com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
                i10 = i5;
                i11 = 1;
                if (i10 == 1) {
                    if (immutableSet.contains(str)) {
                        if (iZze > 0) {
                            cArr[iZze] = '1';
                        }
                        return true;
                    }
                    c = '2';
                    i12 = 1;
                }
                if (immutableMap.containsKey(zzkpVar)) {
                    c2 = '0';
                } else {
                    iOrdinal = zzoeVar.ordinal();
                    if (iOrdinal != 0) {
                        if (iOrdinal != i11) {
                            if (iOrdinal != 2) {
                                if (zzi(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true) == com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST) {
                                }
                            }
                            if (iOrdinal == 3) {
                                if (zzi(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true) == com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_CONSENT) {
                                }
                            }
                            c2 = '0';
                        } else if (zzi(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true) != com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_CONSENT) {
                            return zzh(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true);
                        }
                    } else if (zzi(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true) != com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST) {
                        return zzg(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true);
                    }
                    c2 = '8';
                }
            } else {
                i10 = i5;
                i11 = 1;
            }
            c = '2';
            i12 = i10;
            if (immutableMap.containsKey(zzkpVar)) {
                c2 = '0';
            } else {
                iOrdinal = zzoeVar.ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal != i11) {
                        if (iOrdinal != 2) {
                            if (zzi(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true) == com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST) {
                            }
                        }
                        if (iOrdinal == 3) {
                            if (zzi(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true) == com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_CONSENT) {
                            }
                        }
                        c2 = '0';
                    } else if (zzi(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true) != com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_CONSENT) {
                        return zzh(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true);
                    }
                } else if (zzi(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true) != com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST) {
                    return zzg(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i9, i8, i4, i12, str, str2, str3, z, z2, true);
                }
                c2 = '8';
            }
        }
        return iZze <= 0 ? false : false;
    }

    public static final Map zzd(ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        if (!z3) {
            return ImmutableMap.of();
        }
        com.google.android.gms.internal.measurement.zzkp zzkpVar = com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE;
        com.google.android.gms.internal.measurement.zzkq zzkqVar = (com.google.android.gms.internal.measurement.zzkq) immutableMap2.get(zzkpVar);
        com.google.android.gms.internal.measurement.zzkp zzkpVar2 = com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE;
        com.google.android.gms.internal.measurement.zzkq zzkqVar2 = (com.google.android.gms.internal.measurement.zzkq) immutableMap2.get(zzkpVar2);
        com.google.android.gms.internal.measurement.zzkp zzkpVar3 = com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS;
        com.google.android.gms.internal.measurement.zzkq zzkqVar3 = (com.google.android.gms.internal.measurement.zzkq) immutableMap2.get(zzkpVar3);
        com.google.android.gms.internal.measurement.zzkp zzkpVar4 = com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE;
        com.google.android.gms.internal.measurement.zzkq zzkqVar4 = (com.google.android.gms.internal.measurement.zzkq) immutableMap2.get(zzkpVar4);
        return ImmutableMap.builder().put("Version", "2").put("VendorConsent", true != z ? "0" : "1").put("VendorLegitimateInterest", true != z2 ? "0" : "1").put("gdprApplies", i3 != 1 ? "0" : "1").put("EnableAdvertiserConsentMode", i2 != 1 ? "0" : "1").put("PolicyVersion", String.valueOf(i4)).put("CmpSdkID", String.valueOf(i)).put("PurposeOneTreatment", i5 != 1 ? "0" : "1").put("PublisherCC", str).put("PublisherRestrictions1", String.valueOf(zzkqVar != null ? zzkqVar.zza() : com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_UNDEFINED.zza())).put("PublisherRestrictions3", String.valueOf(zzkqVar2 != null ? zzkqVar2.zza() : com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_UNDEFINED.zza())).put("PublisherRestrictions4", String.valueOf(zzkqVar3 != null ? zzkqVar3.zza() : com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_UNDEFINED.zza())).put("PublisherRestrictions7", String.valueOf(zzkqVar4 != null ? zzkqVar4.zza() : com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_UNDEFINED.zza())).putAll(ImmutableMap.of("Purpose1", zzf(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, true), "Purpose3", zzf(zzkpVar2, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, true), "Purpose4", zzf(zzkpVar3, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, true), "Purpose7", zzf(zzkpVar4, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, true))).putAll(ImmutableMap.of("AuthorizePurpose1", (String) (true != zzc(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, true) ? "0" : "1"), "AuthorizePurpose3", (String) (true != zzc(zzkpVar2, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, true) ? "0" : "1"), "AuthorizePurpose4", (String) (true != zzc(zzkpVar3, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, true) ? "0" : "1"), "AuthorizePurpose7", true != zzc(zzkpVar4, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, true) ? "0" : "1", "PurposeDiagnostics", new String(cArr))).buildOrThrow();
    }

    private static final int zze(com.google.android.gms.internal.measurement.zzkp zzkpVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        if (zzkpVar == com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
            return 1;
        }
        if (zzkpVar == com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE) {
            return 2;
        }
        if (zzkpVar == com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS) {
            return 3;
        }
        return zzkpVar == com.google.android.gms.internal.measurement.zzkp.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE ? 4 : -1;
    }

    private static final String zzf(com.google.android.gms.internal.measurement.zzkp zzkpVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        String strValueOf = "0";
        String strValueOf2 = (TextUtils.isEmpty(str2) || str2.length() < zzkpVar.zza()) ? "0" : String.valueOf(str2.charAt(zzkpVar.zza() - 1));
        if (!TextUtils.isEmpty(str3) && str3.length() >= zzkpVar.zza()) {
            strValueOf = String.valueOf(str3.charAt(zzkpVar.zza() - 1));
        }
        String.valueOf(strValueOf2);
        String.valueOf(strValueOf);
        return String.valueOf(strValueOf2).concat(String.valueOf(strValueOf));
    }

    private static final boolean zzg(com.google.android.gms.internal.measurement.zzkp zzkpVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        char c;
        int iZze = zze(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, true);
        if (!z) {
            c = '4';
        } else {
            if (str2.length() >= zzkpVar.zza()) {
                char cCharAt = str2.charAt(zzkpVar.zza() - 1);
                boolean z4 = cCharAt == '1';
                if (iZze > 0 && cArr[iZze] != '2') {
                    cArr[iZze] = cCharAt != '1' ? '6' : '1';
                }
                return z4;
            }
            c = '0';
        }
        if (iZze > 0 && cArr[iZze] != '2') {
            cArr[iZze] = c;
        }
        return false;
    }

    private static final boolean zzh(com.google.android.gms.internal.measurement.zzkp zzkpVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        char c;
        int iZze = zze(zzkpVar, immutableMap, immutableMap2, immutableSet, cArr, i, i2, i3, i4, i5, str, str2, str3, z, z2, true);
        if (!z2) {
            c = '5';
        } else {
            if (str3.length() >= zzkpVar.zza()) {
                char cCharAt = str3.charAt(zzkpVar.zza() - 1);
                boolean z4 = cCharAt == '1';
                if (iZze > 0 && cArr[iZze] != '2') {
                    cArr[iZze] = cCharAt != '1' ? '7' : '1';
                }
                return z4;
            }
            c = '0';
        }
        if (iZze > 0 && cArr[iZze] != '2') {
            cArr[iZze] = c;
        }
        return false;
    }

    private static final com.google.android.gms.internal.measurement.zzkq zzi(com.google.android.gms.internal.measurement.zzkp zzkpVar, ImmutableMap immutableMap, ImmutableMap immutableMap2, ImmutableSet immutableSet, char[] cArr, int i, int i2, int i3, int i4, int i5, String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        return (com.google.android.gms.internal.measurement.zzkq) immutableMap2.getOrDefault(zzkpVar, com.google.android.gms.internal.measurement.zzkq.PURPOSE_RESTRICTION_UNDEFINED);
    }
}
