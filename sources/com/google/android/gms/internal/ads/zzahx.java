package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzahx {
    public byte[] zzN;
    public zzaeb zzT;
    public boolean zzU;
    public zzaea zzW;
    public int zzX;
    private int zzY;
    public String zza;
    public String zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public boolean zzg;
    public byte[] zzh;
    public zzadz zzi;
    public byte[] zzj;
    public zzae zzk;
    public int zzl = -1;
    public int zzm = -1;
    public int zzn = -1;
    public int zzo = -1;
    public int zzp = -1;
    public int zzq = 0;
    public int zzr = -1;
    public float zzs = 0.0f;
    public float zzt = 0.0f;
    public float zzu = 0.0f;
    public byte[] zzv = null;
    public int zzw = -1;
    public boolean zzx = false;
    public int zzy = -1;
    public int zzz = -1;
    public int zzA = -1;
    public int zzB = 1000;
    public int zzC = 200;
    public float zzD = -1.0f;
    public float zzE = -1.0f;
    public float zzF = -1.0f;
    public float zzG = -1.0f;
    public float zzH = -1.0f;
    public float zzI = -1.0f;
    public float zzJ = -1.0f;
    public float zzK = -1.0f;
    public float zzL = -1.0f;
    public float zzM = -1.0f;
    public int zzO = 1;
    public int zzP = -1;
    public int zzQ = 8000;
    public long zzR = 0;
    public long zzS = 0;
    public boolean zzV = true;
    private String zzZ = "eng";

    protected zzahx() {
    }

    private static Pair zzf(zzfp zzfpVar) throws zzcc {
        try {
            zzfpVar.zzL(16);
            long jZzs = zzfpVar.zzs();
            if (jZzs == 1482049860) {
                return new Pair("video/divx", null);
            }
            if (jZzs == 859189832) {
                return new Pair("video/3gpp", null);
            }
            if (jZzs != 826496599) {
                zzff.zzf("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair("video/x-unknown", null);
            }
            int iZzd = zzfpVar.zzd() + 20;
            byte[] bArrZzM = zzfpVar.zzM();
            while (true) {
                int length = bArrZzM.length;
                if (iZzd >= length - 4) {
                    throw zzcc.zza("Failed to find FourCC VC1 initialization data", null);
                }
                int i = iZzd + 1;
                if (bArrZzM[iZzd] == 0 && bArrZzM[i] == 0 && bArrZzM[iZzd + 2] == 1 && bArrZzM[iZzd + 3] == 15) {
                    return new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArrZzM, iZzd, length)));
                }
                iZzd = i;
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzcc.zza("Error parsing FourCC private data", null);
        }
    }

    private static List zzg(byte[] bArr) throws zzcc {
        int i;
        int i2;
        try {
            if (bArr[0] != 2) {
                throw zzcc.zza("Error parsing vorbis codec private", null);
            }
            int i3 = 0;
            int i4 = 1;
            while (true) {
                int i5 = bArr[i4];
                i4++;
                i = i5 & 255;
                if (i != 255) {
                    break;
                }
                i3 += 255;
            }
            int i6 = i3 + i;
            int i7 = 0;
            while (true) {
                int i8 = bArr[i4];
                i4++;
                i2 = i8 & 255;
                if (i2 != 255) {
                    break;
                }
                i7 += 255;
            }
            int i9 = i7 + i2;
            if (bArr[i4] != 1) {
                throw zzcc.zza("Error parsing vorbis codec private", null);
            }
            byte[] bArr2 = new byte[i6];
            System.arraycopy(bArr, i4, bArr2, 0, i6);
            int i10 = i4 + i6;
            if (bArr[i10] != 3) {
                throw zzcc.zza("Error parsing vorbis codec private", null);
            }
            int i11 = i10 + i9;
            if (bArr[i11] != 5) {
                throw zzcc.zza("Error parsing vorbis codec private", null);
            }
            int length = bArr.length - i11;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr, i11, bArr3, 0, length);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(bArr2);
            arrayList.add(bArr3);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzcc.zza("Error parsing vorbis codec private", null);
        }
    }

    private static boolean zzh(zzfp zzfpVar) throws zzcc {
        try {
            int iZzk = zzfpVar.zzk();
            if (iZzk == 1) {
                return true;
            }
            if (iZzk == 65534) {
                zzfpVar.zzK(24);
                if (zzfpVar.zzt() == zzahy.zzf.getMostSignificantBits() && zzfpVar.zzt() == zzahy.zzf.getLeastSignificantBits()) {
                    return true;
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzcc.zza("Error parsing MS/ACM codec private", null);
        }
    }

    @EnsuresNonNull({"codecPrivate"})
    private final byte[] zzi(String str) throws zzcc {
        byte[] bArr = this.zzj;
        if (bArr != null) {
            return bArr;
        }
        throw zzcc.zza("Missing CodecPrivate for codec ".concat(String.valueOf(str)), null);
    }

    /* JADX WARN: Code duplicated, block: B:132:0x024f A[PHI: r10
  0x024f: PHI (r10v11 int) = (r10v5 int), (r10v6 int), (r10v7 int), (r10v8 int), (r10v9 int), (r10v10 int), (r10v0 int) binds: [B:136:0x0269, B:130:0x0236, B:127:0x0218, B:125:0x0213, B:123:0x020e, B:121:0x020a, B:116:0x01ed] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:173:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:178:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:179:0x03c4  */
    /* JADX WARN: Code duplicated, block: B:182:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:183:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:185:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:187:0x03ea  */
    /* JADX WARN: Code duplicated, block: B:189:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:192:0x03f6  */
    /* JADX WARN: Code duplicated, block: B:196:0x0400  */
    /* JADX WARN: Code duplicated, block: B:199:0x040e  */
    /* JADX WARN: Code duplicated, block: B:202:0x0413  */
    /* JADX WARN: Code duplicated, block: B:204:0x0419  */
    /* JADX WARN: Code duplicated, block: B:224:0x04cc  */
    /* JADX WARN: Code duplicated, block: B:226:0x04f3  */
    /* JADX WARN: Code duplicated, block: B:229:0x04f8  */
    /* JADX WARN: Code duplicated, block: B:234:0x0518  */
    /* JADX WARN: Code duplicated, block: B:253:0x0564  */
    /* JADX WARN: Code duplicated, block: B:255:0x0584  */
    /* JADX WARN: Code duplicated, block: B:257:0x058a  */
    /* JADX WARN: Code duplicated, block: B:273:0x05be  */
    @EnsuresNonNull({"this.output"})
    @RequiresNonNull({"codecId"})
    public final void zze(zzacx zzacxVar, int i) throws zzcc {
        byte b;
        List listSingletonList;
        List listZzn;
        String str;
        String str2;
        int i2;
        List listZzg;
        int i3;
        String str3;
        int i4;
        zzak zzakVar;
        int i5;
        float f;
        zzt zztVarZzg;
        byte[] bArr;
        int i6;
        int i7;
        int i8;
        zzacq zzacqVarZza;
        String str4 = this.zzb;
        int i9 = 1;
        int iZzk = 4;
        int i10 = 0;
        int iIntValue = -1;
        switch (str4) {
            case "V_MPEG4/ISO/AP":
                b = 6;
                break;
            case "V_MPEG4/ISO/SP":
                b = 4;
                break;
            case "A_MS/ACM":
                b = Ascii.ETB;
                break;
            case "A_TRUEHD":
                b = Ascii.DC2;
                break;
            case "A_VORBIS":
                b = Ascii.VT;
                break;
            case "A_MPEG/L2":
                b = Ascii.SO;
                break;
            case "A_MPEG/L3":
                b = Ascii.SI;
                break;
            case "V_MS/VFW/FOURCC":
                b = 9;
                break;
            case "S_DVBSUB":
                b = 32;
                break;
            case "V_MPEG4/ISO/ASP":
                b = 5;
                break;
            case "V_MPEG4/ISO/AVC":
                b = 7;
                break;
            case "S_VOBSUB":
                b = Ascii.RS;
                break;
            case "A_DTS/LOSSLESS":
                b = Ascii.NAK;
                break;
            case "A_AAC":
                b = Ascii.CR;
                break;
            case "A_AC3":
                b = 16;
                break;
            case "A_DTS":
                b = 19;
                break;
            case "V_AV1":
                b = 2;
                break;
            case "V_VP8":
                b = 0;
                break;
            case "V_VP9":
                b = 1;
                break;
            case "S_HDMV/PGS":
                b = Ascii.US;
                break;
            case "V_THEORA":
                b = 10;
                break;
            case "A_DTS/EXPRESS":
                b = Ascii.DC4;
                break;
            case "A_PCM/FLOAT/IEEE":
                b = Ascii.SUB;
                break;
            case "A_PCM/INT/BIG":
                b = Ascii.EM;
                break;
            case "A_PCM/INT/LIT":
                b = 24;
                break;
            case "S_TEXT/ASS":
                b = Ascii.FS;
                break;
            case "V_MPEGH/ISO/HEVC":
                b = 8;
                break;
            case "S_TEXT/WEBVTT":
                b = Ascii.GS;
                break;
            case "S_TEXT/UTF8":
                b = Ascii.ESC;
                break;
            case "V_MPEG2":
                b = 3;
                break;
            case "A_EAC3":
                b = 17;
                break;
            case "A_FLAC":
                b = Ascii.SYN;
                break;
            case "A_OPUS":
                b = Ascii.FF;
                break;
            default:
                b = -1;
                break;
        }
        String str5 = "audio/raw";
        switch (b) {
            case 0:
                str5 = "video/x-vnd.on2.vp8";
                i2 = -1;
                iZzk = -1;
                listZzn = null;
                str2 = null;
                if (this.zzN != null && (zzacqVarZza = zzacq.zza(new zzfp(this.zzN))) != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i11 = (z ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                } else if (zzcb.zzh(str3)) {
                    if (this.zzq == 0) {
                        i7 = this.zzo;
                        if (i7 == -1) {
                            i7 = this.zzl;
                        }
                        this.zzo = i7;
                        i8 = this.zzp;
                        if (i8 == -1) {
                            i8 = this.zzm;
                        }
                        this.zzp = i8;
                    }
                    i5 = this.zzo;
                    if (i5 != -1 || (i6 = this.zzp) == -1) {
                        f = -1.0f;
                    } else {
                        f = (this.zzm * i5) / (this.zzl * i6);
                    }
                    if (this.zzx) {
                        if (this.zzD != -1.0f || this.zzE == -1.0f || this.zzF == -1.0f || this.zzG == -1.0f || this.zzH == -1.0f || this.zzI == -1.0f || this.zzJ == -1.0f || this.zzK == -1.0f || this.zzL == -1.0f || this.zzM == -1.0f) {
                            bArr = null;
                        } else {
                            bArr = new byte[25];
                            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                            byteBufferOrder.put((byte) 0);
                            byteBufferOrder.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) (this.zzL + 0.5f));
                            byteBufferOrder.putShort((short) (this.zzM + 0.5f));
                            byteBufferOrder.putShort((short) this.zzB);
                            byteBufferOrder.putShort((short) this.zzC);
                        }
                        zzr zzrVar = new zzr();
                        zzrVar.zzc(this.zzy);
                        zzrVar.zzb(this.zzA);
                        zzrVar.zzd(this.zzz);
                        zzrVar.zze(bArr);
                        zzrVar.zzf(this.zzn);
                        zzrVar.zza(this.zzn);
                        zztVarZzg = zzrVar.zzg();
                    } else {
                        zztVarZzg = null;
                    }
                    if (this.zza != null && zzahy.zzg.containsKey(this.zza)) {
                        iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                    }
                    if (this.zzr == 0 || Float.compare(this.zzs, 0.0f) != 0 || Float.compare(this.zzt, 0.0f) != 0) {
                        i10 = iIntValue;
                    } else if (Float.compare(this.zzu, 0.0f) != 0) {
                        if (Float.compare(this.zzu, 90.0f) == 0) {
                            i10 = 90;
                        } else if (Float.compare(this.zzu, -180.0f) == 0 || Float.compare(this.zzu, 180.0f) == 0) {
                            i10 = 180;
                        } else if (Float.compare(this.zzu, -90.0f) == 0) {
                            i10 = 270;
                        } else {
                            i10 = iIntValue;
                        }
                    }
                    zzakVar.zzab(this.zzl);
                    zzakVar.zzI(this.zzm);
                    zzakVar.zzS(f);
                    zzakVar.zzV(i10);
                    zzakVar.zzT(this.zzv);
                    zzakVar.zzZ(this.zzw);
                    zzakVar.zzA(zztVarZzg);
                    i9 = 2;
                } else {
                    if ("application/x-subrip".equals(str3) && !"text/x-ssa".equals(str3) && !"text/vtt".equals(str3) && !"application/vobsub".equals(str3) && !"application/pgs".equals(str3) && !"application/dvbsubs".equals(str3)) {
                        throw zzcc.zza("Unexpected MIME type.", null);
                    }
                    i9 = 3;
                }
                if (this.zza != null && !zzahy.zzg.containsKey(this.zza)) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i11);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac = zzakVar.zzac();
                zzaea zzaeaVarZzw = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw;
                zzaeaVarZzw.zzl(zzamVarZzac);
                return;
            case 1:
                str5 = "video/x-vnd.on2.vp9";
                i2 = -1;
                iZzk = -1;
                listZzn = null;
                str2 = null;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z2 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i12 = (z2 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar2 = new zzr();
                            zzrVar2.zzc(this.zzy);
                            zzrVar2.zzb(this.zzA);
                            zzrVar2.zzd(this.zzz);
                            zzrVar2.zze(bArr);
                            zzrVar2.zzf(this.zzn);
                            zzrVar2.zza(this.zzn);
                            zztVarZzg = zzrVar2.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i12);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac2 = zzakVar.zzac();
                zzaea zzaeaVarZzw2 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw2;
                zzaeaVarZzw2.zzl(zzamVarZzac2);
                return;
            case 2:
                str5 = "video/av01";
                i2 = -1;
                iZzk = -1;
                listZzn = null;
                str2 = null;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z3 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i13 = (z3 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar3 = new zzr();
                            zzrVar3.zzc(this.zzy);
                            zzrVar3.zzb(this.zzA);
                            zzrVar3.zzd(this.zzz);
                            zzrVar3.zze(bArr);
                            zzrVar3.zzf(this.zzn);
                            zzrVar3.zza(this.zzn);
                            zztVarZzg = zzrVar3.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i13);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac3 = zzakVar.zzac();
                zzaea zzaeaVarZzw3 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw3;
                zzaeaVarZzw3.zzl(zzamVarZzac3);
                return;
            case 3:
                str5 = "video/mpeg2";
                i2 = -1;
                iZzk = -1;
                listZzn = null;
                str2 = null;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z4 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i14 = (z4 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar4 = new zzr();
                            zzrVar4.zzc(this.zzy);
                            zzrVar4.zzb(this.zzA);
                            zzrVar4.zzd(this.zzz);
                            zzrVar4.zze(bArr);
                            zzrVar4.zzf(this.zzn);
                            zzrVar4.zza(this.zzn);
                            zztVarZzg = zzrVar4.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i14);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac4 = zzakVar.zzac();
                zzaea zzaeaVarZzw4 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw4;
                zzaeaVarZzw4.zzl(zzamVarZzac4);
                return;
            case 4:
            case 5:
            case 6:
                byte[] bArr2 = this.zzj;
                listSingletonList = bArr2 == null ? null : Collections.singletonList(bArr2);
                str5 = "video/mp4v-es";
                listZzn = listSingletonList;
                i2 = -1;
                iZzk = -1;
                str2 = null;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z5 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i15 = (z5 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar5 = new zzr();
                            zzrVar5.zzc(this.zzy);
                            zzrVar5.zzb(this.zzA);
                            zzrVar5.zzd(this.zzz);
                            zzrVar5.zze(bArr);
                            zzrVar5.zzf(this.zzn);
                            zzrVar5.zza(this.zzn);
                            zztVarZzg = zzrVar5.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i15);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac5 = zzakVar.zzac();
                zzaea zzaeaVarZzw5 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw5;
                zzaeaVarZzw5.zzl(zzamVarZzac5);
                return;
            case 7:
                zzabz zzabzVarZza = zzabz.zza(new zzfp(zzi(this.zzb)));
                listZzn = zzabzVarZza.zza;
                this.zzX = zzabzVarZza.zzb;
                str = zzabzVarZza.zzk;
                str5 = "video/avc";
                str2 = str;
                i2 = -1;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z6 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i16 = (z6 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar6 = new zzr();
                            zzrVar6.zzc(this.zzy);
                            zzrVar6.zzb(this.zzA);
                            zzrVar6.zzd(this.zzz);
                            zzrVar6.zze(bArr);
                            zzrVar6.zzf(this.zzn);
                            zzrVar6.zza(this.zzn);
                            zztVarZzg = zzrVar6.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i16);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac6 = zzakVar.zzac();
                zzaea zzaeaVarZzw6 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw6;
                zzaeaVarZzw6.zzl(zzamVarZzac6);
                return;
            case 8:
                zzadl zzadlVarZza = zzadl.zza(new zzfp(zzi(this.zzb)));
                listZzn = zzadlVarZza.zza;
                this.zzX = zzadlVarZza.zzb;
                str = zzadlVarZza.zzi;
                str5 = "video/hevc";
                str2 = str;
                i2 = -1;
                iZzk = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z7 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i17 = (z7 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar7 = new zzr();
                            zzrVar7.zzc(this.zzy);
                            zzrVar7.zzb(this.zzA);
                            zzrVar7.zzd(this.zzz);
                            zzrVar7.zze(bArr);
                            zzrVar7.zzf(this.zzn);
                            zzrVar7.zza(this.zzn);
                            zztVarZzg = zzrVar7.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i17);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac7 = zzakVar.zzac();
                zzaea zzaeaVarZzw7 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw7;
                zzaeaVarZzw7.zzl(zzamVarZzac7);
                return;
            case 9:
                Pair pairZzf = zzf(new zzfp(zzi(this.zzb)));
                str5 = (String) pairZzf.first;
                listSingletonList = (List) pairZzf.second;
                listZzn = listSingletonList;
                i2 = -1;
                iZzk = -1;
                str2 = null;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z8 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i18 = (z8 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar8 = new zzr();
                            zzrVar8.zzc(this.zzy);
                            zzrVar8.zzb(this.zzA);
                            zzrVar8.zzd(this.zzz);
                            zzrVar8.zze(bArr);
                            zzrVar8.zzf(this.zzn);
                            zzrVar8.zza(this.zzn);
                            zztVarZzg = zzrVar8.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i18);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac8 = zzakVar.zzac();
                zzaea zzaeaVarZzw8 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw8;
                zzaeaVarZzw8.zzl(zzamVarZzac8);
                return;
            case 10:
                str5 = "video/x-unknown";
                i2 = -1;
                iZzk = -1;
                listZzn = null;
                str2 = null;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z9 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i19 = (z9 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar9 = new zzr();
                            zzrVar9.zzc(this.zzy);
                            zzrVar9.zzb(this.zzA);
                            zzrVar9.zzd(this.zzz);
                            zzrVar9.zze(bArr);
                            zzrVar9.zzf(this.zzn);
                            zzrVar9.zza(this.zzn);
                            zztVarZzg = zzrVar9.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i19);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac9 = zzakVar.zzac();
                zzaea zzaeaVarZzw9 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw9;
                zzaeaVarZzw9.zzl(zzamVarZzac9);
                return;
            case 11:
                listZzg = zzg(zzi(str4));
                i3 = 8192;
                str5 = "audio/vorbis";
                listZzn = listZzg;
                iZzk = -1;
                i2 = i3;
                str2 = null;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z10 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i110 = (z10 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar10 = new zzr();
                            zzrVar10.zzc(this.zzy);
                            zzrVar10.zzb(this.zzA);
                            zzrVar10.zzd(this.zzz);
                            zzrVar10.zze(bArr);
                            zzrVar10.zzf(this.zzn);
                            zzrVar10.zza(this.zzn);
                            zztVarZzg = zzrVar10.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i110);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac10 = zzakVar.zzac();
                zzaea zzaeaVarZzw10 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw10;
                zzaeaVarZzw10.zzl(zzamVarZzac10);
                return;
            case 12:
                listZzg = new ArrayList(3);
                listZzg.add(zzi(this.zzb));
                listZzg.add(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.zzR).array());
                listZzg.add(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.zzS).array());
                i3 = 5760;
                str5 = "audio/opus";
                listZzn = listZzg;
                iZzk = -1;
                i2 = i3;
                str2 = null;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z11 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i111 = (z11 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar11 = new zzr();
                            zzrVar11.zzc(this.zzy);
                            zzrVar11.zzb(this.zzA);
                            zzrVar11.zzd(this.zzz);
                            zzrVar11.zze(bArr);
                            zzrVar11.zzf(this.zzn);
                            zzrVar11.zza(this.zzn);
                            zztVarZzg = zzrVar11.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i111);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac11 = zzakVar.zzac();
                zzaea zzaeaVarZzw11 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw11;
                zzaeaVarZzw11.zzl(zzamVarZzac11);
                return;
            case 13:
                List listSingletonList2 = Collections.singletonList(zzi(str4));
                zzabr zzabrVarZza = zzabs.zza(this.zzj);
                this.zzQ = zzabrVarZza.zza;
                this.zzO = zzabrVarZza.zzb;
                str5 = "audio/mp4a-latm";
                str2 = zzabrVarZza.zzc;
                iZzk = -1;
                listZzn = listSingletonList2;
                i2 = -1;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z12 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i112 = (z12 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar12 = new zzr();
                            zzrVar12.zzc(this.zzy);
                            zzrVar12.zzb(this.zzA);
                            zzrVar12.zzd(this.zzz);
                            zzrVar12.zze(bArr);
                            zzrVar12.zzf(this.zzn);
                            zzrVar12.zza(this.zzn);
                            zztVarZzg = zzrVar12.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i112);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac12 = zzakVar.zzac();
                zzaea zzaeaVarZzw12 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw12;
                zzaeaVarZzw12.zzl(zzamVarZzac12);
                return;
            case 14:
                str5 = "audio/mpeg-L2";
                iZzk = -1;
                i2 = 4096;
                listZzn = null;
                str2 = null;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z13 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i113 = (z13 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar13 = new zzr();
                            zzrVar13.zzc(this.zzy);
                            zzrVar13.zzb(this.zzA);
                            zzrVar13.zzd(this.zzz);
                            zzrVar13.zze(bArr);
                            zzrVar13.zzf(this.zzn);
                            zzrVar13.zza(this.zzn);
                            zztVarZzg = zzrVar13.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i113);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac13 = zzakVar.zzac();
                zzaea zzaeaVarZzw13 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw13;
                zzaeaVarZzw13.zzl(zzamVarZzac13);
                return;
            case 15:
                str5 = "audio/mpeg";
                iZzk = -1;
                i2 = 4096;
                listZzn = null;
                str2 = null;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z14 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i114 = (z14 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar14 = new zzr();
                            zzrVar14.zzc(this.zzy);
                            zzrVar14.zzb(this.zzA);
                            zzrVar14.zzd(this.zzz);
                            zzrVar14.zze(bArr);
                            zzrVar14.zzf(this.zzn);
                            zzrVar14.zza(this.zzn);
                            zztVarZzg = zzrVar14.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i114);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac14 = zzakVar.zzac();
                zzaea zzaeaVarZzw14 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw14;
                zzaeaVarZzw14.zzl(zzamVarZzac14);
                return;
            case 16:
                str5 = "audio/ac3";
                i2 = -1;
                iZzk = -1;
                listZzn = null;
                str2 = null;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z15 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i115 = (z15 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar15 = new zzr();
                            zzrVar15.zzc(this.zzy);
                            zzrVar15.zzb(this.zzA);
                            zzrVar15.zzd(this.zzz);
                            zzrVar15.zze(bArr);
                            zzrVar15.zzf(this.zzn);
                            zzrVar15.zza(this.zzn);
                            zztVarZzg = zzrVar15.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i115);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac15 = zzakVar.zzac();
                zzaea zzaeaVarZzw15 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw15;
                zzaeaVarZzw15.zzl(zzamVarZzac15);
                return;
            case 17:
                str5 = "audio/eac3";
                i2 = -1;
                iZzk = -1;
                listZzn = null;
                str2 = null;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z16 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i116 = (z16 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar16 = new zzr();
                            zzrVar16.zzc(this.zzy);
                            zzrVar16.zzb(this.zzA);
                            zzrVar16.zzd(this.zzz);
                            zzrVar16.zze(bArr);
                            zzrVar16.zzf(this.zzn);
                            zzrVar16.zza(this.zzn);
                            zztVarZzg = zzrVar16.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i116);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac16 = zzakVar.zzac();
                zzaea zzaeaVarZzw16 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw16;
                zzaeaVarZzw16.zzl(zzamVarZzac16);
                return;
            case 18:
                this.zzT = new zzaeb();
                str5 = "audio/true-hd";
                i2 = -1;
                iZzk = -1;
                listZzn = null;
                str2 = null;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z17 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i117 = (z17 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar17 = new zzr();
                            zzrVar17.zzc(this.zzy);
                            zzrVar17.zzb(this.zzA);
                            zzrVar17.zzd(this.zzz);
                            zzrVar17.zze(bArr);
                            zzrVar17.zzf(this.zzn);
                            zzrVar17.zza(this.zzn);
                            zztVarZzg = zzrVar17.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i117);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac17 = zzakVar.zzac();
                zzaea zzaeaVarZzw17 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw17;
                zzaeaVarZzw17.zzl(zzamVarZzac17);
                return;
            case 19:
            case 20:
                str5 = "audio/vnd.dts";
                i2 = -1;
                iZzk = -1;
                listZzn = null;
                str2 = null;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z18 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i118 = (z18 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar18 = new zzr();
                            zzrVar18.zzc(this.zzy);
                            zzrVar18.zzb(this.zzA);
                            zzrVar18.zzd(this.zzz);
                            zzrVar18.zze(bArr);
                            zzrVar18.zzf(this.zzn);
                            zzrVar18.zza(this.zzn);
                            zztVarZzg = zzrVar18.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i118);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac18 = zzakVar.zzac();
                zzaea zzaeaVarZzw18 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw18;
                zzaeaVarZzw18.zzl(zzamVarZzac18);
                return;
            case 21:
                str5 = "audio/vnd.dts.hd";
                i2 = -1;
                iZzk = -1;
                listZzn = null;
                str2 = null;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z19 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i119 = (z19 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar19 = new zzr();
                            zzrVar19.zzc(this.zzy);
                            zzrVar19.zzb(this.zzA);
                            zzrVar19.zzd(this.zzz);
                            zzrVar19.zze(bArr);
                            zzrVar19.zzf(this.zzn);
                            zzrVar19.zza(this.zzn);
                            zztVarZzg = zzrVar19.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i119);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac19 = zzakVar.zzac();
                zzaea zzaeaVarZzw19 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw19;
                zzaeaVarZzw19.zzl(zzamVarZzac19);
                return;
            case 22:
                listSingletonList = Collections.singletonList(zzi(str4));
                str5 = "audio/flac";
                listZzn = listSingletonList;
                i2 = -1;
                iZzk = -1;
                str2 = null;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z110 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1110 = (z110 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar110 = new zzr();
                            zzrVar110.zzc(this.zzy);
                            zzrVar110.zzb(this.zzA);
                            zzrVar110.zzd(this.zzz);
                            zzrVar110.zze(bArr);
                            zzrVar110.zzf(this.zzn);
                            zzrVar110.zza(this.zzn);
                            zztVarZzg = zzrVar110.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i1110);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac110 = zzakVar.zzac();
                zzaea zzaeaVarZzw110 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw110;
                zzaeaVarZzw110.zzl(zzamVarZzac110);
                return;
            case 23:
                if (zzh(new zzfp(zzi(this.zzb)))) {
                    iZzk = zzfy.zzk(this.zzP);
                    if (iZzk == 0) {
                        zzff.zzf("MatroskaExtractor", "Unsupported PCM bit depth: " + this.zzP + ". Setting mimeType to audio/x-unknown");
                    } else {
                        i2 = -1;
                    }
                    listZzn = null;
                    str2 = null;
                    if (this.zzN != null) {
                        str2 = zzacqVarZza.zza;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    boolean z111 = this.zzV;
                    if (true != this.zzU) {
                        i4 = 0;
                    } else {
                        i4 = 2;
                    }
                    int i1111 = (z111 ? 1 : 0) | i4;
                    zzakVar = new zzak();
                    if (!zzcb.zzg(str3)) {
                        if (zzcb.zzh(str3)) {
                            if (this.zzq == 0) {
                                i7 = this.zzo;
                                if (i7 == -1) {
                                    i7 = this.zzl;
                                }
                                this.zzo = i7;
                                i8 = this.zzp;
                                if (i8 == -1) {
                                    i8 = this.zzm;
                                }
                                this.zzp = i8;
                            }
                            i5 = this.zzo;
                            if (i5 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.zzx) {
                                if (this.zzD != -1.0f) {
                                    bArr = null;
                                } else {
                                    bArr = null;
                                }
                                zzr zzrVar111 = new zzr();
                                zzrVar111.zzc(this.zzy);
                                zzrVar111.zzb(this.zzA);
                                zzrVar111.zzd(this.zzz);
                                zzrVar111.zze(bArr);
                                zzrVar111.zzf(this.zzn);
                                zzrVar111.zza(this.zzn);
                                zztVarZzg = zzrVar111.zzg();
                            } else {
                                zztVarZzg = null;
                            }
                            if (this.zza != null) {
                                iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                            }
                            if (this.zzr == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            zzakVar.zzab(this.zzl);
                            zzakVar.zzI(this.zzm);
                            zzakVar.zzS(f);
                            zzakVar.zzV(i10);
                            zzakVar.zzT(this.zzv);
                            zzakVar.zzZ(this.zzw);
                            zzakVar.zzA(zztVarZzg);
                            i9 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i9 = 3;
                        }
                        break;
                    } else {
                        zzakVar.zzy(this.zzO);
                        zzakVar.zzX(this.zzQ);
                        zzakVar.zzQ(iZzk);
                    }
                    if (this.zza != null) {
                        zzakVar.zzM(this.zza);
                    }
                    zzakVar.zzJ(i);
                    zzakVar.zzW(str3);
                    zzakVar.zzO(i2);
                    zzakVar.zzN(this.zzZ);
                    zzakVar.zzY(i1111);
                    zzakVar.zzL(listZzn);
                    zzakVar.zzz(str2);
                    zzakVar.zzE(this.zzk);
                    zzam zzamVarZzac111 = zzakVar.zzac();
                    zzaea zzaeaVarZzw111 = zzacxVar.zzw(this.zzc, i9);
                    this.zzW = zzaeaVarZzw111;
                    zzaeaVarZzw111.zzl(zzamVarZzac111);
                    return;
                }
                zzff.zzf("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                i2 = -1;
                iZzk = -1;
                str5 = "audio/x-unknown";
                listZzn = null;
                str2 = null;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z112 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1112 = (z112 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar112 = new zzr();
                            zzrVar112.zzc(this.zzy);
                            zzrVar112.zzb(this.zzA);
                            zzrVar112.zzd(this.zzz);
                            zzrVar112.zze(bArr);
                            zzrVar112.zzf(this.zzn);
                            zzrVar112.zza(this.zzn);
                            zztVarZzg = zzrVar112.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i1112);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac112 = zzakVar.zzac();
                zzaea zzaeaVarZzw112 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw112;
                zzaeaVarZzw112.zzl(zzamVarZzac112);
                return;
            case 24:
                iZzk = zzfy.zzk(this.zzP);
                if (iZzk == 0) {
                    zzff.zzf("MatroskaExtractor", "Unsupported little endian PCM bit depth: " + this.zzP + ". Setting mimeType to audio/x-unknown");
                    i2 = -1;
                    iZzk = -1;
                    str5 = "audio/x-unknown";
                } else {
                    i2 = -1;
                }
                listZzn = null;
                str2 = null;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z113 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1113 = (z113 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar113 = new zzr();
                            zzrVar113.zzc(this.zzy);
                            zzrVar113.zzb(this.zzA);
                            zzrVar113.zzd(this.zzz);
                            zzrVar113.zze(bArr);
                            zzrVar113.zzf(this.zzn);
                            zzrVar113.zza(this.zzn);
                            zztVarZzg = zzrVar113.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i1113);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac113 = zzakVar.zzac();
                zzaea zzaeaVarZzw113 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw113;
                zzaeaVarZzw113.zzl(zzamVarZzac113);
                return;
            case 25:
                int i20 = this.zzP;
                if (i20 == 8) {
                    iZzk = 3;
                } else if (i20 == 16) {
                    iZzk = 268435456;
                } else if (i20 == 24) {
                    iZzk = 1342177280;
                } else {
                    if (i20 != 32) {
                        zzff.zzf("MatroskaExtractor", "Unsupported big endian PCM bit depth: " + i20 + ". Setting mimeType to audio/x-unknown");
                        i2 = -1;
                        iZzk = -1;
                        str5 = "audio/x-unknown";
                        listZzn = null;
                        str2 = null;
                        if (this.zzN != null) {
                            str2 = zzacqVarZza.zza;
                            str5 = "video/dolby-vision";
                        }
                        str3 = str5;
                        boolean z114 = this.zzV;
                        if (true != this.zzU) {
                            i4 = 0;
                        } else {
                            i4 = 2;
                        }
                        int i1114 = (z114 ? 1 : 0) | i4;
                        zzakVar = new zzak();
                        if (!zzcb.zzg(str3)) {
                            if (zzcb.zzh(str3)) {
                                if (this.zzq == 0) {
                                    i7 = this.zzo;
                                    if (i7 == -1) {
                                        i7 = this.zzl;
                                    }
                                    this.zzo = i7;
                                    i8 = this.zzp;
                                    if (i8 == -1) {
                                        i8 = this.zzm;
                                    }
                                    this.zzp = i8;
                                }
                                i5 = this.zzo;
                                if (i5 != -1) {
                                    f = -1.0f;
                                } else {
                                    f = -1.0f;
                                }
                                if (this.zzx) {
                                    if (this.zzD != -1.0f) {
                                        bArr = null;
                                    } else {
                                        bArr = null;
                                    }
                                    zzr zzrVar114 = new zzr();
                                    zzrVar114.zzc(this.zzy);
                                    zzrVar114.zzb(this.zzA);
                                    zzrVar114.zzd(this.zzz);
                                    zzrVar114.zze(bArr);
                                    zzrVar114.zzf(this.zzn);
                                    zzrVar114.zza(this.zzn);
                                    zztVarZzg = zzrVar114.zzg();
                                } else {
                                    zztVarZzg = null;
                                }
                                if (this.zza != null) {
                                    iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                                }
                                if (this.zzr == 0) {
                                    i10 = iIntValue;
                                } else {
                                    i10 = iIntValue;
                                }
                                zzakVar.zzab(this.zzl);
                                zzakVar.zzI(this.zzm);
                                zzakVar.zzS(f);
                                zzakVar.zzV(i10);
                                zzakVar.zzT(this.zzv);
                                zzakVar.zzZ(this.zzw);
                                zzakVar.zzA(zztVarZzg);
                                i9 = 2;
                            } else {
                                if ("application/x-subrip".equals(str3)) {
                                }
                                i9 = 3;
                            }
                            break;
                        } else {
                            zzakVar.zzy(this.zzO);
                            zzakVar.zzX(this.zzQ);
                            zzakVar.zzQ(iZzk);
                        }
                        if (this.zza != null) {
                            zzakVar.zzM(this.zza);
                        }
                        zzakVar.zzJ(i);
                        zzakVar.zzW(str3);
                        zzakVar.zzO(i2);
                        zzakVar.zzN(this.zzZ);
                        zzakVar.zzY(i1114);
                        zzakVar.zzL(listZzn);
                        zzakVar.zzz(str2);
                        zzakVar.zzE(this.zzk);
                        zzam zzamVarZzac114 = zzakVar.zzac();
                        zzaea zzaeaVarZzw114 = zzacxVar.zzw(this.zzc, i9);
                        this.zzW = zzaeaVarZzw114;
                        zzaeaVarZzw114.zzl(zzamVarZzac114);
                        return;
                    }
                    iZzk = 1610612736;
                }
                i2 = -1;
                listZzn = null;
                str2 = null;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z115 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1115 = (z115 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar115 = new zzr();
                            zzrVar115.zzc(this.zzy);
                            zzrVar115.zzb(this.zzA);
                            zzrVar115.zzd(this.zzz);
                            zzrVar115.zze(bArr);
                            zzrVar115.zzf(this.zzn);
                            zzrVar115.zza(this.zzn);
                            zztVarZzg = zzrVar115.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i1115);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac115 = zzakVar.zzac();
                zzaea zzaeaVarZzw115 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw115;
                zzaeaVarZzw115.zzl(zzamVarZzac115);
                return;
            case 26:
                int i21 = this.zzP;
                if (i21 == 32) {
                    i2 = -1;
                } else {
                    zzff.zzf("MatroskaExtractor", "Unsupported floating point PCM bit depth: " + i21 + ". Setting mimeType to audio/x-unknown");
                    i2 = -1;
                    iZzk = -1;
                    str5 = "audio/x-unknown";
                }
                listZzn = null;
                str2 = null;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z116 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1116 = (z116 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar116 = new zzr();
                            zzrVar116.zzc(this.zzy);
                            zzrVar116.zzb(this.zzA);
                            zzrVar116.zzd(this.zzz);
                            zzrVar116.zze(bArr);
                            zzrVar116.zzf(this.zzn);
                            zzrVar116.zza(this.zzn);
                            zztVarZzg = zzrVar116.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i1116);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac116 = zzakVar.zzac();
                zzaea zzaeaVarZzw116 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw116;
                zzaeaVarZzw116.zzl(zzamVarZzac116);
                return;
            case 27:
                i2 = -1;
                iZzk = -1;
                str5 = "application/x-subrip";
                listZzn = null;
                str2 = null;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z117 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1117 = (z117 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar117 = new zzr();
                            zzrVar117.zzc(this.zzy);
                            zzrVar117.zzb(this.zzA);
                            zzrVar117.zzd(this.zzz);
                            zzrVar117.zze(bArr);
                            zzrVar117.zzf(this.zzn);
                            zzrVar117.zza(this.zzn);
                            zztVarZzg = zzrVar117.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i1117);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac117 = zzakVar.zzac();
                zzaea zzaeaVarZzw117 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw117;
                zzaeaVarZzw117.zzl(zzamVarZzac117);
                return;
            case 28:
                listZzn = zzgaa.zzn(zzahy.zzc, zzi(this.zzb));
                i2 = -1;
                iZzk = -1;
                str5 = "text/x-ssa";
                str2 = null;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z118 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1118 = (z118 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar118 = new zzr();
                            zzrVar118.zzc(this.zzy);
                            zzrVar118.zzb(this.zzA);
                            zzrVar118.zzd(this.zzz);
                            zzrVar118.zze(bArr);
                            zzrVar118.zzf(this.zzn);
                            zzrVar118.zza(this.zzn);
                            zztVarZzg = zzrVar118.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i1118);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac118 = zzakVar.zzac();
                zzaea zzaeaVarZzw118 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw118;
                zzaeaVarZzw118.zzl(zzamVarZzac118);
                return;
            case 29:
                str5 = "text/vtt";
                i2 = -1;
                iZzk = -1;
                listZzn = null;
                str2 = null;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z119 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1119 = (z119 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar119 = new zzr();
                            zzrVar119.zzc(this.zzy);
                            zzrVar119.zzb(this.zzA);
                            zzrVar119.zzd(this.zzz);
                            zzrVar119.zze(bArr);
                            zzrVar119.zzf(this.zzn);
                            zzrVar119.zza(this.zzn);
                            zztVarZzg = zzrVar119.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i1119);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac119 = zzakVar.zzac();
                zzaea zzaeaVarZzw119 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw119;
                zzaeaVarZzw119.zzl(zzamVarZzac119);
                return;
            case 30:
                listSingletonList = zzgaa.zzm(zzi(str4));
                str5 = "application/vobsub";
                listZzn = listSingletonList;
                i2 = -1;
                iZzk = -1;
                str2 = null;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z1110 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i11110 = (z1110 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar1110 = new zzr();
                            zzrVar1110.zzc(this.zzy);
                            zzrVar1110.zzb(this.zzA);
                            zzrVar1110.zzd(this.zzz);
                            zzrVar1110.zze(bArr);
                            zzrVar1110.zzf(this.zzn);
                            zzrVar1110.zza(this.zzn);
                            zztVarZzg = zzrVar1110.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i11110);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac1110 = zzakVar.zzac();
                zzaea zzaeaVarZzw1110 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw1110;
                zzaeaVarZzw1110.zzl(zzamVarZzac1110);
                return;
            case 31:
                str5 = "application/pgs";
                i2 = -1;
                iZzk = -1;
                listZzn = null;
                str2 = null;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z1111 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i11111 = (z1111 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar1111 = new zzr();
                            zzrVar1111.zzc(this.zzy);
                            zzrVar1111.zzb(this.zzA);
                            zzrVar1111.zzd(this.zzz);
                            zzrVar1111.zze(bArr);
                            zzrVar1111.zzf(this.zzn);
                            zzrVar1111.zza(this.zzn);
                            zztVarZzg = zzrVar1111.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i11111);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac1111 = zzakVar.zzac();
                zzaea zzaeaVarZzw1111 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw1111;
                zzaeaVarZzw1111.zzl(zzamVarZzac1111);
                return;
            case 32:
                byte[] bArr3 = new byte[4];
                System.arraycopy(zzi(str4), 0, bArr3, 0, 4);
                listSingletonList = zzgaa.zzm(bArr3);
                str5 = "application/dvbsubs";
                listZzn = listSingletonList;
                i2 = -1;
                iZzk = -1;
                str2 = null;
                if (this.zzN != null) {
                    str2 = zzacqVarZza.zza;
                    str5 = "video/dolby-vision";
                }
                str3 = str5;
                boolean z1112 = this.zzV;
                if (true != this.zzU) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i11112 = (z1112 ? 1 : 0) | i4;
                zzakVar = new zzak();
                if (!zzcb.zzg(str3)) {
                    if (zzcb.zzh(str3)) {
                        if (this.zzq == 0) {
                            i7 = this.zzo;
                            if (i7 == -1) {
                                i7 = this.zzl;
                            }
                            this.zzo = i7;
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                        }
                        i5 = this.zzo;
                        if (i5 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzx) {
                            if (this.zzD != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzr zzrVar1112 = new zzr();
                            zzrVar1112.zzc(this.zzy);
                            zzrVar1112.zzb(this.zzA);
                            zzrVar1112.zzd(this.zzz);
                            zzrVar1112.zze(bArr);
                            zzrVar1112.zzf(this.zzn);
                            zzrVar1112.zza(this.zzn);
                            zztVarZzg = zzrVar1112.zzg();
                        } else {
                            zztVarZzg = null;
                        }
                        if (this.zza != null) {
                            iIntValue = ((Integer) zzahy.zzg.get(this.zza)).intValue();
                        }
                        if (this.zzr == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zzakVar.zzab(this.zzl);
                        zzakVar.zzI(this.zzm);
                        zzakVar.zzS(f);
                        zzakVar.zzV(i10);
                        zzakVar.zzT(this.zzv);
                        zzakVar.zzZ(this.zzw);
                        zzakVar.zzA(zztVarZzg);
                        i9 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i9 = 3;
                    }
                    break;
                } else {
                    zzakVar.zzy(this.zzO);
                    zzakVar.zzX(this.zzQ);
                    zzakVar.zzQ(iZzk);
                }
                if (this.zza != null) {
                    zzakVar.zzM(this.zza);
                }
                zzakVar.zzJ(i);
                zzakVar.zzW(str3);
                zzakVar.zzO(i2);
                zzakVar.zzN(this.zzZ);
                zzakVar.zzY(i11112);
                zzakVar.zzL(listZzn);
                zzakVar.zzz(str2);
                zzakVar.zzE(this.zzk);
                zzam zzamVarZzac1112 = zzakVar.zzac();
                zzaea zzaeaVarZzw1112 = zzacxVar.zzw(this.zzc, i9);
                this.zzW = zzaeaVarZzw1112;
                zzaeaVarZzw1112.zzl(zzamVarZzac1112);
                return;
            default:
                throw zzcc.zza("Unrecognized codec identifier.", null);
        }
    }
}
