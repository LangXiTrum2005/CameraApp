package com.google.android.gms.internal.ads;

import androidx.core.view.ViewCompat;
import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzajd {
    static final String[] zza = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", HttpHeaders.TRAILER, "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};
    public static final /* synthetic */ int zzb = 0;

    /* JADX WARN: Code duplicated, block: B:136:0x0267 A[Catch: all -> 0x01f9, TryCatch #0 {all -> 0x01f9, blocks: (B:9:0x0030, B:13:0x003a, B:16:0x0043, B:18:0x004f, B:21:0x005b, B:24:0x0068, B:27:0x0077, B:30:0x0084, B:33:0x0091, B:35:0x009b, B:43:0x00b4, B:44:0x00c5, B:45:0x00d8, B:48:0x00e4, B:51:0x00f1, B:54:0x00fe, B:57:0x010b, B:60:0x0118, B:63:0x0125, B:66:0x0132, B:69:0x013f, B:72:0x014c, B:75:0x015c, B:79:0x0170, B:81:0x0176, B:83:0x018b, B:84:0x0192, B:86:0x0199, B:91:0x01a4, B:96:0x01b0, B:136:0x0267, B:97:0x01c5, B:99:0x01cc, B:101:0x01d6, B:102:0x01ea, B:117:0x0219, B:120:0x0226, B:123:0x0232, B:126:0x023e, B:129:0x024a, B:132:0x0256, B:135:0x0260, B:137:0x027b, B:138:0x0282), top: B:143:0x0022 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:136:0x0267, please report this as an issue */
    public static zzbx zza(zzfp zzfpVar) {
        String str;
        zzbx zzagcVar;
        int iZzd = zzfpVar.zzd() + zzfpVar.zzg();
        int iZzg = zzfpVar.zzg();
        int i = (iZzg >> 24) & 255;
        zzbx zzbxVarZze = null;
        try {
            if (i == 169 || i == 253) {
                int i2 = iZzg & ViewCompat.MEASURED_SIZE_MASK;
                if (i2 == 6516084) {
                    int iZzg2 = zzfpVar.zzg();
                    if (zzfpVar.zzg() == 1684108385) {
                        zzfpVar.zzL(8);
                        String strZzz = zzfpVar.zzz(iZzg2 - 16);
                        zzbxVarZze = new zzagk("und", strZzz, strZzz);
                    } else {
                        zzff.zzf("MetadataUtil", "Failed to parse comment attribute: ".concat(zzaio.zzf(iZzg)));
                    }
                } else if (i2 == 7233901 || i2 == 7631467) {
                    zzbxVarZze = zze(iZzg, "TIT2", zzfpVar);
                } else if (i2 == 6516589 || i2 == 7828084) {
                    zzbxVarZze = zze(iZzg, "TCOM", zzfpVar);
                } else if (i2 == 6578553) {
                    zzbxVarZze = zze(iZzg, "TDRC", zzfpVar);
                } else if (i2 == 4280916) {
                    zzbxVarZze = zze(iZzg, "TPE1", zzfpVar);
                } else if (i2 == 7630703) {
                    zzbxVarZze = zze(iZzg, "TSSE", zzfpVar);
                } else if (i2 == 6384738) {
                    zzbxVarZze = zze(iZzg, "TALB", zzfpVar);
                } else if (i2 == 7108978) {
                    zzbxVarZze = zze(iZzg, "USLT", zzfpVar);
                } else if (i2 == 6776174) {
                    zzbxVarZze = zze(iZzg, "TCON", zzfpVar);
                } else if (i2 == 6779504) {
                    zzbxVarZze = zze(iZzg, "TIT1", zzfpVar);
                } else {
                    zzff.zzb("MetadataUtil", "Skipped unknown metadata entry: " + zzaio.zzf(iZzg));
                }
            } else if (iZzg == 1735291493) {
                int iZzb = zzb(zzfpVar);
                String str2 = (iZzb <= 0 || iZzb > 192) ? null : zza[iZzb - 1];
                if (str2 != null) {
                    zzagcVar = new zzagz("TCON", null, zzgaa.zzm(str2));
                    zzbxVarZze = zzagcVar;
                } else {
                    zzff.zzf("MetadataUtil", "Failed to parse standard genre code");
                }
            } else if (iZzg == 1684632427) {
                zzbxVarZze = zzd(1684632427, "TPOS", zzfpVar);
            } else if (iZzg == 1953655662) {
                zzbxVarZze = zzd(1953655662, "TRCK", zzfpVar);
            } else if (iZzg == 1953329263) {
                zzbxVarZze = zzc(1953329263, "TBPM", zzfpVar, true, false);
            } else if (iZzg == 1668311404) {
                zzbxVarZze = zzc(1668311404, "TCMP", zzfpVar, true, true);
            } else if (iZzg == 1668249202) {
                int iZzg3 = zzfpVar.zzg();
                if (zzfpVar.zzg() == 1684108385) {
                    int iZzg4 = zzfpVar.zzg() & ViewCompat.MEASURED_SIZE_MASK;
                    if (iZzg4 == 13) {
                        str = "image/jpeg";
                    } else if (iZzg4 == 14) {
                        str = "image/png";
                        iZzg4 = 14;
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        zzff.zzf("MetadataUtil", "Unrecognized cover art flags: " + iZzg4);
                    } else {
                        zzfpVar.zzL(4);
                        int i3 = iZzg3 - 16;
                        byte[] bArr = new byte[i3];
                        zzfpVar.zzG(bArr, 0, i3);
                        zzagcVar = new zzagc(str, null, 3, bArr);
                        zzbxVarZze = zzagcVar;
                    }
                } else {
                    zzff.zzf("MetadataUtil", "Failed to parse cover art attribute");
                }
            } else if (iZzg == 1631670868) {
                zzbxVarZze = zze(1631670868, "TPE2", zzfpVar);
            } else if (iZzg == 1936682605) {
                zzbxVarZze = zze(1936682605, "TSOT", zzfpVar);
            } else if (iZzg == 1936679276) {
                zzbxVarZze = zze(1936679276, "TSO2", zzfpVar);
            } else if (iZzg == 1936679282) {
                zzbxVarZze = zze(1936679282, "TSOA", zzfpVar);
            } else if (iZzg == 1936679265) {
                zzbxVarZze = zze(1936679265, "TSOP", zzfpVar);
            } else if (iZzg == 1936679791) {
                zzbxVarZze = zze(1936679791, "TSOC", zzfpVar);
            } else if (iZzg == 1920233063) {
                zzbxVarZze = zzc(1920233063, "ITUNESADVISORY", zzfpVar, false, false);
            } else if (iZzg == 1885823344) {
                zzbxVarZze = zzc(1885823344, "ITUNESGAPLESS", zzfpVar, false, true);
            } else if (iZzg == 1936683886) {
                zzbxVarZze = zze(1936683886, "TVSHOWSORT", zzfpVar);
            } else if (iZzg == 1953919848) {
                zzbxVarZze = zze(1953919848, "TVSHOW", zzfpVar);
            } else if (iZzg == 757935405) {
                int i4 = -1;
                int i5 = -1;
                String strZzz2 = null;
                String strZzz3 = null;
                while (zzfpVar.zzd() < iZzd) {
                    int iZzd2 = zzfpVar.zzd();
                    int iZzg5 = zzfpVar.zzg();
                    int iZzg6 = zzfpVar.zzg();
                    zzfpVar.zzL(4);
                    if (iZzg6 == 1835360622) {
                        strZzz2 = zzfpVar.zzz(iZzg5 - 12);
                    } else {
                        int i6 = iZzg5 - 12;
                        if (iZzg6 == 1851878757) {
                            strZzz3 = zzfpVar.zzz(i6);
                        } else {
                            if (iZzg6 == 1684108385) {
                                i5 = iZzg5;
                            }
                            if (iZzg6 == 1684108385) {
                                i4 = iZzd2;
                            }
                            zzfpVar.zzL(i6);
                        }
                    }
                }
                if (strZzz2 != null && strZzz3 != null && i4 != -1) {
                    zzfpVar.zzK(i4);
                    zzfpVar.zzL(16);
                    zzbxVarZze = new zzagt(strZzz2, strZzz3, zzfpVar.zzz(i5 - 16));
                }
            } else {
                zzff.zzb("MetadataUtil", "Skipped unknown metadata entry: " + zzaio.zzf(iZzg));
            }
            zzfpVar.zzK(iZzd);
            return zzbxVarZze;
        } catch (Throwable th) {
            zzfpVar.zzK(iZzd);
            throw th;
        }
    }

    private static int zzb(zzfp zzfpVar) {
        zzfpVar.zzL(4);
        if (zzfpVar.zzg() == 1684108385) {
            zzfpVar.zzL(8);
            return zzfpVar.zzm();
        }
        zzff.zzf("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    private static zzagr zzc(int i, String str, zzfp zzfpVar, boolean z, boolean z2) {
        int iZzb = zzb(zzfpVar);
        if (z2) {
            iZzb = Math.min(1, iZzb);
        }
        if (iZzb >= 0) {
            return z ? new zzagz(str, null, zzgaa.zzm(Integer.toString(iZzb))) : new zzagk("und", str, Integer.toString(iZzb));
        }
        zzff.zzf("MetadataUtil", "Failed to parse uint8 attribute: ".concat(zzaio.zzf(i)));
        return null;
    }

    private static zzagz zzd(int i, String str, zzfp zzfpVar) {
        int iZzg = zzfpVar.zzg();
        if (zzfpVar.zzg() == 1684108385 && iZzg >= 22) {
            zzfpVar.zzL(10);
            int iZzq = zzfpVar.zzq();
            if (iZzq > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(iZzq);
                String string = sb.toString();
                int iZzq2 = zzfpVar.zzq();
                if (iZzq2 > 0) {
                    string = string + RemoteSettings.FORWARD_SLASH_STRING + iZzq2;
                }
                return new zzagz(str, null, zzgaa.zzm(string));
            }
        }
        zzff.zzf("MetadataUtil", "Failed to parse index/count attribute: ".concat(zzaio.zzf(i)));
        return null;
    }

    private static zzagz zze(int i, String str, zzfp zzfpVar) {
        int iZzg = zzfpVar.zzg();
        if (zzfpVar.zzg() == 1684108385) {
            zzfpVar.zzL(8);
            return new zzagz(str, null, zzgaa.zzm(zzfpVar.zzz(iZzg - 16)));
        }
        zzff.zzf("MetadataUtil", "Failed to parse text attribute: ".concat(zzaio.zzf(i)));
        return null;
    }
}
