package androidx.tracing;

import android.adservices.signals.UpdateSignalsRequest;
import android.adservices.topics.EncryptedTopic;
import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.adservices.topics.TopicsManager;
import android.app.ApplicationExitInfo;
import android.app.job.JobInfo;
import android.content.pm.ApkChecksum;
import android.media.ExifInterface;
import android.net.Uri;
import dalvik.system.DelegateLastClassLoader;
import java.io.InputStream;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Trace$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ UpdateSignalsRequest.Builder m(Uri uri) {
        return new UpdateSignalsRequest.Builder(uri);
    }

    public static /* bridge */ /* synthetic */ EncryptedTopic m(Object obj) {
        return (EncryptedTopic) obj;
    }

    public static /* synthetic */ GetTopicsRequest.Builder m() {
        return new GetTopicsRequest.Builder();
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ GetTopicsResponse m208m(Object obj) {
        return (GetTopicsResponse) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Topic m209m(Object obj) {
        return (Topic) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ TopicsManager m210m(Object obj) {
        return (TopicsManager) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ApplicationExitInfo m211m(Object obj) {
        return (ApplicationExitInfo) obj;
    }

    public static /* synthetic */ JobInfo.TriggerContentUri m(Uri uri, int i) {
        return new JobInfo.TriggerContentUri(uri, i);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ApkChecksum m213m(Object obj) {
        return (ApkChecksum) obj;
    }

    public static /* synthetic */ ExifInterface m(InputStream inputStream) {
        return new ExifInterface(inputStream);
    }

    public static /* synthetic */ DelegateLastClassLoader m(String str, ClassLoader classLoader) {
        return new DelegateLastClassLoader(str, classLoader);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m216m() {
        return TopicsManager.class;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m219m() {
    }

    /* JADX INFO: renamed from: m$1, reason: collision with other method in class */
    public static /* synthetic */ void m228m$1() {
    }

    public static /* synthetic */ void m$2() {
    }

    public static /* synthetic */ void m$3() {
    }
}
