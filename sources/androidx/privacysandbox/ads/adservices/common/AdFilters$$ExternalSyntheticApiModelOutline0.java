package androidx.privacysandbox.ads.adservices.common;

import android.adservices.customaudience.CustomAudience;
import android.adservices.customaudience.CustomAudienceManager;
import android.adservices.customaudience.FetchAndJoinCustomAudienceRequest;
import android.adservices.customaudience.JoinCustomAudienceRequest;
import android.adservices.customaudience.LeaveCustomAudienceRequest;
import android.adservices.customaudience.TrustedBiddingData;
import android.adservices.measurement.DeletionRequest;
import android.adservices.measurement.MeasurementManager;
import android.adservices.measurement.WebSourceParams;
import android.adservices.measurement.WebSourceRegistrationRequest;
import android.adservices.measurement.WebTriggerParams;
import android.adservices.measurement.WebTriggerRegistrationRequest;
import android.net.Uri;
import java.time.Duration;
import java.util.List;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AdFilters$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ android.adservices.common.AdData.Builder m() {
        return new android.adservices.common.AdData.Builder();
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ android.adservices.common.AdFilters.Builder m185m() {
        return new android.adservices.common.AdFilters.Builder();
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ android.adservices.common.FrequencyCapFilters.Builder m187m() {
        return new android.adservices.common.FrequencyCapFilters.Builder();
    }

    public static /* synthetic */ android.adservices.common.KeyedFrequencyCap.Builder m(int i, int i2, Duration duration) {
        return new android.adservices.common.KeyedFrequencyCap.Builder(i, i2, duration);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ CustomAudience.Builder m188m() {
        return new CustomAudience.Builder();
    }

    public static /* bridge */ /* synthetic */ CustomAudienceManager m(Object obj) {
        return (CustomAudienceManager) obj;
    }

    public static /* synthetic */ FetchAndJoinCustomAudienceRequest.Builder m(Uri uri) {
        return new FetchAndJoinCustomAudienceRequest.Builder(uri);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ JoinCustomAudienceRequest.Builder m189m() {
        return new JoinCustomAudienceRequest.Builder();
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ LeaveCustomAudienceRequest.Builder m190m() {
        return new LeaveCustomAudienceRequest.Builder();
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ TrustedBiddingData.Builder m191m() {
        return new TrustedBiddingData.Builder();
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ DeletionRequest.Builder m192m() {
        return new DeletionRequest.Builder();
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ MeasurementManager m194m(Object obj) {
        return (MeasurementManager) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ WebSourceParams.Builder m195m(Uri uri) {
        return new WebSourceParams.Builder(uri);
    }

    public static /* synthetic */ WebSourceRegistrationRequest.Builder m(List list, Uri uri) {
        return new WebSourceRegistrationRequest.Builder(list, uri);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ WebTriggerParams.Builder m196m(Uri uri) {
        return new WebTriggerParams.Builder(uri);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ WebTriggerRegistrationRequest.Builder m197m(List list, Uri uri) {
        return new WebTriggerRegistrationRequest.Builder(list, uri);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m199m() {
        return CustomAudienceManager.class;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m202m() {
    }

    public static /* bridge */ /* synthetic */ Class m$1() {
        return MeasurementManager.class;
    }

    /* JADX INFO: renamed from: m$1, reason: collision with other method in class */
    public static /* synthetic */ void m204m$1() {
    }

    public static /* synthetic */ void m$2() {
    }

    public static /* synthetic */ void m$3() {
    }

    public static /* synthetic */ void m$4() {
    }

    public static /* synthetic */ void m$5() {
    }
}
