package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfsg {
    final File zza;
    private final File zzb;
    private final SharedPreferences zzc;
    private final int zzd;

    public zzfsg(Context context, int i) {
        this.zzc = context.getSharedPreferences("pcvmspf", 0);
        File dir = context.getDir("pccache", 0);
        zzfsh.zza(dir, false);
        this.zzb = dir;
        File dir2 = context.getDir("tmppccache", 0);
        zzfsh.zza(dir2, true);
        this.zza = dir2;
        this.zzd = i;
    }

    private final File zzd() {
        File file = new File(this.zzb, Integer.toString(this.zzd - 1));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private final String zze() {
        StringBuilder sb = new StringBuilder("FBAMTD");
        sb.append(this.zzd - 1);
        return sb.toString();
    }

    private final String zzf() {
        StringBuilder sb = new StringBuilder("LATMTD");
        sb.append(this.zzd - 1);
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0087  */
    public final boolean zza(zzayc zzaycVar, zzfsm zzfsmVar) {
        boolean z;
        String strZzk = zzaycVar.zzd().zzk();
        byte[] bArrZzA = zzaycVar.zzf().zzA();
        byte[] bArrZzA2 = zzaycVar.zze().zzA();
        if (!TextUtils.isEmpty(strZzk) && bArrZzA2 != null && bArrZzA2.length != 0) {
            zzfsh.zzd(this.zza);
            this.zza.mkdirs();
            zzfsh.zzc(strZzk, this.zza).mkdirs();
            File fileZzb = zzfsh.zzb(strZzk, "pcam.jar", this.zza);
            if ((bArrZzA == null || bArrZzA.length <= 0 || zzfsh.zze(fileZzb, bArrZzA)) && zzfsh.zze(zzfsh.zzb(strZzk, "pcbc", this.zza), bArrZzA2)) {
                File fileZzb2 = zzfsh.zzb(zzaycVar.zzd().zzk(), "pcam.jar", this.zza);
                if (fileZzb2.exists() && zzfsmVar != null && !zzfsmVar.zza(fileZzb2)) {
                    return false;
                }
                String strZzk2 = zzaycVar.zzd().zzk();
                if (TextUtils.isEmpty(strZzk2)) {
                    z = false;
                } else {
                    File fileZzb3 = zzfsh.zzb(strZzk2, "pcam.jar", this.zza);
                    File fileZzb4 = zzfsh.zzb(strZzk2, "pcbc", this.zza);
                    File fileZzb5 = zzfsh.zzb(strZzk2, "pcam.jar", zzd());
                    File fileZzb6 = zzfsh.zzb(strZzk2, "pcbc", zzd());
                    if ((!fileZzb3.exists() || fileZzb3.renameTo(fileZzb5)) && fileZzb4.exists() && fileZzb4.renameTo(fileZzb6)) {
                        zzaye zzayeVarZze = zzayf.zze();
                        zzayeVarZze.zze(zzaycVar.zzd().zzk());
                        zzayeVarZze.zza(zzaycVar.zzd().zzj());
                        zzayeVarZze.zzb(zzaycVar.zzd().zza());
                        zzayeVarZze.zzd(zzaycVar.zzd().zzd());
                        zzayeVarZze.zzc(zzaycVar.zzd().zzc());
                        zzayf zzayfVar = (zzayf) zzayeVarZze.zzal();
                        zzayf zzayfVarZzb = zzb(1);
                        SharedPreferences.Editor editorEdit = this.zzc.edit();
                        if (zzayfVarZzb != null && !zzayfVar.zzk().equals(zzayfVarZzb.zzk())) {
                            editorEdit.putString(zze(), Hex.bytesToStringLowercase(zzayfVarZzb.zzax()));
                        }
                        editorEdit.putString(zzf(), Hex.bytesToStringLowercase(zzayfVar.zzax()));
                        if (editorEdit.commit()) {
                            z = true;
                        } else {
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                }
                HashSet hashSet = new HashSet();
                zzayf zzayfVarZzb2 = zzb(1);
                if (zzayfVarZzb2 != null) {
                    hashSet.add(zzayfVarZzb2.zzk());
                }
                zzayf zzayfVarZzb3 = zzb(2);
                if (zzayfVarZzb3 != null) {
                    hashSet.add(zzayfVarZzb3.zzk());
                }
                for (File file : zzd().listFiles()) {
                    String name = file.getName();
                    if (!hashSet.contains(name)) {
                        zzfsh.zzd(zzfsh.zzc(name, zzd()));
                    }
                }
                return z;
            }
        }
        return false;
    }

    final zzayf zzb(int i) {
        String string = i == 1 ? this.zzc.getString(zzf(), null) : this.zzc.getString(zze(), null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            byte[] bArrStringToBytes = Hex.stringToBytes(string);
            zzgyl zzgylVar = zzgyl.zzb;
            zzayf zzayfVarZzh = zzayf.zzh(zzgyl.zzv(bArrStringToBytes, 0, bArrStringToBytes.length));
            String strZzk = zzayfVarZzh.zzk();
            File fileZzb = zzfsh.zzb(strZzk, "pcam.jar", zzd());
            if (!fileZzb.exists()) {
                fileZzb = zzfsh.zzb(strZzk, "pcam", zzd());
            }
            File fileZzb2 = zzfsh.zzb(strZzk, "pcbc", zzd());
            if (fileZzb.exists() && fileZzb2.exists()) {
                return zzayfVarZzh;
            }
            return null;
        } catch (zzhag unused) {
        }
    }

    public final zzfsf zzc(int i) {
        zzayf zzayfVarZzb = zzb(1);
        if (zzayfVarZzb == null) {
            return null;
        }
        String strZzk = zzayfVarZzb.zzk();
        File fileZzb = zzfsh.zzb(strZzk, "pcam.jar", zzd());
        if (!fileZzb.exists()) {
            fileZzb = zzfsh.zzb(strZzk, "pcam", zzd());
        }
        return new zzfsf(zzayfVarZzb, fileZzb, zzfsh.zzb(strZzk, "pcbc", zzd()), zzfsh.zzb(strZzk, "pcopt", zzd()));
    }
}
