package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzft implements zzev {
    private Message zza;
    private zzfu zzb;

    private zzft() {
    }

    /* synthetic */ zzft(zzfs zzfsVar) {
    }

    private final void zzd() {
        this.zza = null;
        this.zzb = null;
        zzfu.zzl(this);
    }

    public final zzft zzb(Message message, zzfu zzfuVar) {
        this.zza = message;
        this.zzb = zzfuVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzev
    public final void zza() {
        Message message = this.zza;
        message.getClass();
        message.sendToTarget();
        zzd();
    }

    public final boolean zzc(Handler handler) {
        Message message = this.zza;
        message.getClass();
        boolean zSendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue(message);
        zzd();
        return zSendMessageAtFrontOfQueue;
    }
}
