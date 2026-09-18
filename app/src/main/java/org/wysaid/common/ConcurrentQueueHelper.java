package org.wysaid.common;

import android.util.Log;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public class ConcurrentQueueHelper {
    protected ConcurrentLinkedQueue<Runnable> mQueue = new ConcurrentLinkedQueue<>();

    public void offer(Runnable runnable) {
        this.mQueue.offer(runnable);
    }

    public void consume() {
        Runnable runnablePoll;
        do {
            try {
                runnablePoll = this.mQueue.poll();
                if (runnablePoll != null) {
                    runnablePoll.run();
                }
            } catch (Throwable th) {
                Log.e("libCGE_java", "ConcurrentQueueHelper: " + th.getLocalizedMessage());
                return;
            }
        } while (runnablePoll != null);
    }

    public boolean isEmpty() {
        return this.mQueue.isEmpty();
    }

    public void consumeLast() {
        Runnable runnablePoll;
        do {
            try {
                runnablePoll = this.mQueue.poll();
                if (runnablePoll != null) {
                    runnablePoll.run();
                }
            } catch (Throwable th) {
                Log.e("libCGE_java", "ConcurrentQueueHelper: " + th.getLocalizedMessage());
                return;
            }
        } while (runnablePoll != null);
    }
}
