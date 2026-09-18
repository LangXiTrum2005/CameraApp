package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzhag extends IOException {
    private zzhbe zza;
    private boolean zzb;

    public zzhag(IOException iOException) {
        super(iOException.getMessage(), iOException);
        this.zza = null;
    }

    static zzhaf zza() {
        return new zzhaf("Protocol message tag had invalid wire type.");
    }

    static zzhag zzb() {
        return new zzhag("Protocol message end-group tag did not match expected tag.");
    }

    static zzhag zzc() {
        return new zzhag("Protocol message contained an invalid tag (zero).");
    }

    static zzhag zzd() {
        return new zzhag("Protocol message had invalid UTF-8.");
    }

    static zzhag zze() {
        return new zzhag("CodedInputStream encountered a malformed varint.");
    }

    static zzhag zzf() {
        return new zzhag("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzhag zzg() {
        return new zzhag("Failed to parse the message.");
    }

    static zzhag zzi() {
        return new zzhag("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static zzhag zzj() {
        return new zzhag("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final zzhag zzh(zzhbe zzhbeVar) {
        this.zza = zzhbeVar;
        return this;
    }

    final void zzk() {
        this.zzb = true;
    }

    final boolean zzl() {
        return this.zzb;
    }

    public zzhag(String str) {
        super(str);
        this.zza = null;
    }
}
