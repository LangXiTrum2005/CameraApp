package kotlin.streams.jdk8;

import java.util.StringJoiner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.function.BiFunction;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StreamsKt$$ExternalSyntheticApiModelOutline5 {
    public static /* synthetic */ StringJoiner m(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        return new StringJoiner(charSequence, charSequence2, charSequence3);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ CompletableFuture m1856m() {
        return new CompletableFuture();
    }

    public static /* bridge */ /* synthetic */ CompletionException m(Object obj) {
        return (CompletionException) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ BiFunction m1857m(Object obj) {
        return (BiFunction) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ boolean m1859m(Object obj) {
        return obj instanceof CompletionException;
    }
}
