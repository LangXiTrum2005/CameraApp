package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Pair;
import android.view.Surface;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.location.LocationRequestCompat;
import androidx.core.text.HtmlCompat;
import androidx.work.WorkRequest;
import com.google.android.gms.common.Scopes;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.io.encoding.Base64;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaah extends zzsz implements zzaan {
    private static final int[] zzb = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean zzc;
    private static boolean zzd;
    private boolean zzA;
    private boolean zzB;
    private int zzC;
    private zzaal zzD;
    private zzabo zzE;
    private final Context zze;
    private final zzabp zzf;
    private final zzabj zzg;
    private final boolean zzh;
    private final zzaao zzi;
    private final zzaam zzj;
    private zzaag zzk;
    private boolean zzl;
    private boolean zzm;
    private Surface zzn;
    private zzaak zzo;
    private boolean zzp;
    private int zzq;
    private long zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private long zzv;
    private int zzw;
    private long zzx;
    private zzdp zzy;
    private zzdp zzz;

    public zzaah(Context context, zzsq zzsqVar, zztb zztbVar, long j, boolean z, Handler handler, zzabk zzabkVar, int i, float f) {
        super(2, zzsqVar, zztbVar, false, 30.0f);
        Context applicationContext = context.getApplicationContext();
        this.zze = applicationContext;
        this.zzg = new zzabj(handler, zzabkVar);
        zzzs zzzsVar = new zzzs(applicationContext);
        zzzsVar.zzc(new zzaao(applicationContext, this, 0L));
        zzaab zzaabVarZzd = zzzsVar.zzd();
        this.zzf = zzaabVarZzd;
        this.zzi = zzaabVarZzd.zza();
        this.zzj = new zzaam();
        this.zzh = "NVIDIA".equals(zzfy.zzc);
        this.zzq = 1;
        this.zzy = zzdp.zza;
        this.zzC = 0;
        this.zzz = null;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x014c  */
    /* JADX WARN: Code duplicated, block: B:102:0x0154  */
    /* JADX WARN: Code duplicated, block: B:103:0x0158  */
    /* JADX WARN: Code duplicated, block: B:105:0x0160  */
    /* JADX WARN: Code duplicated, block: B:106:0x0164  */
    /* JADX WARN: Code duplicated, block: B:108:0x016c  */
    /* JADX WARN: Code duplicated, block: B:109:0x0170  */
    /* JADX WARN: Code duplicated, block: B:111:0x0178  */
    /* JADX WARN: Code duplicated, block: B:112:0x017c  */
    /* JADX WARN: Code duplicated, block: B:114:0x0184  */
    /* JADX WARN: Code duplicated, block: B:115:0x0188  */
    /* JADX WARN: Code duplicated, block: B:117:0x0190  */
    /* JADX WARN: Code duplicated, block: B:118:0x0194  */
    /* JADX WARN: Code duplicated, block: B:120:0x019c  */
    /* JADX WARN: Code duplicated, block: B:121:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:123:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:124:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:126:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:127:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:129:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:130:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:132:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:133:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:135:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:136:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:138:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:139:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:141:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:142:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:144:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:145:0x0200  */
    /* JADX WARN: Code duplicated, block: B:147:0x0208  */
    /* JADX WARN: Code duplicated, block: B:148:0x020c  */
    /* JADX WARN: Code duplicated, block: B:150:0x0214  */
    /* JADX WARN: Code duplicated, block: B:151:0x0218  */
    /* JADX WARN: Code duplicated, block: B:153:0x0220  */
    /* JADX WARN: Code duplicated, block: B:154:0x0224  */
    /* JADX WARN: Code duplicated, block: B:156:0x022c  */
    /* JADX WARN: Code duplicated, block: B:157:0x0230  */
    /* JADX WARN: Code duplicated, block: B:159:0x0238  */
    /* JADX WARN: Code duplicated, block: B:160:0x023c  */
    /* JADX WARN: Code duplicated, block: B:162:0x0244  */
    /* JADX WARN: Code duplicated, block: B:163:0x0248  */
    /* JADX WARN: Code duplicated, block: B:165:0x0250  */
    /* JADX WARN: Code duplicated, block: B:166:0x0254  */
    /* JADX WARN: Code duplicated, block: B:168:0x025c  */
    /* JADX WARN: Code duplicated, block: B:169:0x0260  */
    /* JADX WARN: Code duplicated, block: B:171:0x0268  */
    /* JADX WARN: Code duplicated, block: B:172:0x026c  */
    /* JADX WARN: Code duplicated, block: B:174:0x0274  */
    /* JADX WARN: Code duplicated, block: B:175:0x0278  */
    /* JADX WARN: Code duplicated, block: B:177:0x0280  */
    /* JADX WARN: Code duplicated, block: B:178:0x0284  */
    /* JADX WARN: Code duplicated, block: B:180:0x028c  */
    /* JADX WARN: Code duplicated, block: B:181:0x0290  */
    /* JADX WARN: Code duplicated, block: B:183:0x0298  */
    /* JADX WARN: Code duplicated, block: B:184:0x029c  */
    /* JADX WARN: Code duplicated, block: B:186:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:187:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:189:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:190:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:192:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:193:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:195:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:196:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:198:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:199:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:201:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:202:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:204:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:205:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:207:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:208:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:210:0x0303  */
    /* JADX WARN: Code duplicated, block: B:211:0x0307  */
    /* JADX WARN: Code duplicated, block: B:213:0x030f  */
    /* JADX WARN: Code duplicated, block: B:214:0x0313  */
    /* JADX WARN: Code duplicated, block: B:216:0x031b  */
    /* JADX WARN: Code duplicated, block: B:217:0x031f  */
    /* JADX WARN: Code duplicated, block: B:219:0x0327  */
    /* JADX WARN: Code duplicated, block: B:220:0x032b  */
    /* JADX WARN: Code duplicated, block: B:222:0x0333  */
    /* JADX WARN: Code duplicated, block: B:223:0x0337  */
    /* JADX WARN: Code duplicated, block: B:225:0x033f  */
    /* JADX WARN: Code duplicated, block: B:226:0x0343  */
    /* JADX WARN: Code duplicated, block: B:228:0x034b  */
    /* JADX WARN: Code duplicated, block: B:229:0x034f  */
    /* JADX WARN: Code duplicated, block: B:231:0x0357  */
    /* JADX WARN: Code duplicated, block: B:232:0x035b  */
    /* JADX WARN: Code duplicated, block: B:234:0x0363  */
    /* JADX WARN: Code duplicated, block: B:235:0x0367  */
    /* JADX WARN: Code duplicated, block: B:237:0x036f  */
    /* JADX WARN: Code duplicated, block: B:238:0x0373  */
    /* JADX WARN: Code duplicated, block: B:240:0x037b  */
    /* JADX WARN: Code duplicated, block: B:241:0x037f  */
    /* JADX WARN: Code duplicated, block: B:243:0x0387  */
    /* JADX WARN: Code duplicated, block: B:244:0x038b  */
    /* JADX WARN: Code duplicated, block: B:246:0x0393  */
    /* JADX WARN: Code duplicated, block: B:247:0x0397  */
    /* JADX WARN: Code duplicated, block: B:249:0x039f  */
    /* JADX WARN: Code duplicated, block: B:250:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:252:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:253:0x03af  */
    /* JADX WARN: Code duplicated, block: B:255:0x03b7  */
    /* JADX WARN: Code duplicated, block: B:256:0x03ba  */
    /* JADX WARN: Code duplicated, block: B:258:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:259:0x03c6  */
    /* JADX WARN: Code duplicated, block: B:261:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:262:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:264:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:265:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:267:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:268:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:270:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:271:0x03f4  */
    /* JADX WARN: Code duplicated, block: B:273:0x03fc  */
    /* JADX WARN: Code duplicated, block: B:274:0x0400  */
    /* JADX WARN: Code duplicated, block: B:276:0x0408  */
    /* JADX WARN: Code duplicated, block: B:277:0x040c  */
    /* JADX WARN: Code duplicated, block: B:279:0x0414  */
    /* JADX WARN: Code duplicated, block: B:280:0x0418  */
    /* JADX WARN: Code duplicated, block: B:282:0x0420  */
    /* JADX WARN: Code duplicated, block: B:283:0x0424  */
    /* JADX WARN: Code duplicated, block: B:285:0x042c  */
    /* JADX WARN: Code duplicated, block: B:286:0x0430  */
    /* JADX WARN: Code duplicated, block: B:288:0x0438  */
    /* JADX WARN: Code duplicated, block: B:289:0x043c  */
    /* JADX WARN: Code duplicated, block: B:291:0x0444  */
    /* JADX WARN: Code duplicated, block: B:292:0x0448  */
    /* JADX WARN: Code duplicated, block: B:294:0x0450  */
    /* JADX WARN: Code duplicated, block: B:295:0x0454  */
    /* JADX WARN: Code duplicated, block: B:297:0x045c  */
    /* JADX WARN: Code duplicated, block: B:298:0x0460  */
    /* JADX WARN: Code duplicated, block: B:300:0x0468  */
    /* JADX WARN: Code duplicated, block: B:301:0x046c  */
    /* JADX WARN: Code duplicated, block: B:303:0x0474  */
    /* JADX WARN: Code duplicated, block: B:304:0x0478  */
    /* JADX WARN: Code duplicated, block: B:306:0x0480  */
    /* JADX WARN: Code duplicated, block: B:307:0x0484  */
    /* JADX WARN: Code duplicated, block: B:309:0x048c  */
    /* JADX WARN: Code duplicated, block: B:310:0x0490  */
    /* JADX WARN: Code duplicated, block: B:312:0x0498  */
    /* JADX WARN: Code duplicated, block: B:313:0x049b  */
    /* JADX WARN: Code duplicated, block: B:315:0x04a3  */
    /* JADX WARN: Code duplicated, block: B:316:0x04a6  */
    /* JADX WARN: Code duplicated, block: B:318:0x04ae  */
    /* JADX WARN: Code duplicated, block: B:319:0x04b1  */
    /* JADX WARN: Code duplicated, block: B:321:0x04b9  */
    /* JADX WARN: Code duplicated, block: B:322:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:325:0x04c7  */
    /* JADX WARN: Code duplicated, block: B:327:0x04cf  */
    /* JADX WARN: Code duplicated, block: B:328:0x04d2  */
    /* JADX WARN: Code duplicated, block: B:330:0x04da  */
    /* JADX WARN: Code duplicated, block: B:331:0x04dd  */
    /* JADX WARN: Code duplicated, block: B:333:0x04e5  */
    /* JADX WARN: Code duplicated, block: B:334:0x04e9  */
    /* JADX WARN: Code duplicated, block: B:336:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:337:0x04f5  */
    /* JADX WARN: Code duplicated, block: B:339:0x04fd  */
    /* JADX WARN: Code duplicated, block: B:340:0x0501  */
    /* JADX WARN: Code duplicated, block: B:342:0x0509  */
    /* JADX WARN: Code duplicated, block: B:343:0x050d  */
    /* JADX WARN: Code duplicated, block: B:345:0x0515  */
    /* JADX WARN: Code duplicated, block: B:346:0x0519  */
    /* JADX WARN: Code duplicated, block: B:348:0x0521  */
    /* JADX WARN: Code duplicated, block: B:349:0x0525  */
    /* JADX WARN: Code duplicated, block: B:351:0x052d  */
    /* JADX WARN: Code duplicated, block: B:352:0x0531  */
    /* JADX WARN: Code duplicated, block: B:354:0x0539  */
    /* JADX WARN: Code duplicated, block: B:355:0x053d  */
    /* JADX WARN: Code duplicated, block: B:357:0x0545  */
    /* JADX WARN: Code duplicated, block: B:358:0x0549  */
    /* JADX WARN: Code duplicated, block: B:360:0x0551  */
    /* JADX WARN: Code duplicated, block: B:361:0x0555  */
    /* JADX WARN: Code duplicated, block: B:363:0x055d  */
    /* JADX WARN: Code duplicated, block: B:364:0x0561  */
    /* JADX WARN: Code duplicated, block: B:366:0x0569  */
    /* JADX WARN: Code duplicated, block: B:367:0x056d  */
    /* JADX WARN: Code duplicated, block: B:369:0x0575  */
    /* JADX WARN: Code duplicated, block: B:370:0x0579  */
    /* JADX WARN: Code duplicated, block: B:372:0x0581  */
    /* JADX WARN: Code duplicated, block: B:373:0x0585  */
    /* JADX WARN: Code duplicated, block: B:375:0x058d  */
    /* JADX WARN: Code duplicated, block: B:376:0x0591  */
    /* JADX WARN: Code duplicated, block: B:378:0x0599  */
    /* JADX WARN: Code duplicated, block: B:379:0x059d  */
    /* JADX WARN: Code duplicated, block: B:381:0x05a5  */
    /* JADX WARN: Code duplicated, block: B:382:0x05a9  */
    /* JADX WARN: Code duplicated, block: B:384:0x05b1  */
    /* JADX WARN: Code duplicated, block: B:385:0x05b5  */
    /* JADX WARN: Code duplicated, block: B:387:0x05bd  */
    /* JADX WARN: Code duplicated, block: B:388:0x05c1  */
    /* JADX WARN: Code duplicated, block: B:390:0x05c9  */
    /* JADX WARN: Code duplicated, block: B:391:0x05cd  */
    /* JADX WARN: Code duplicated, block: B:393:0x05d5  */
    /* JADX WARN: Code duplicated, block: B:394:0x05d9  */
    /* JADX WARN: Code duplicated, block: B:396:0x05e1  */
    /* JADX WARN: Code duplicated, block: B:397:0x05e5  */
    /* JADX WARN: Code duplicated, block: B:399:0x05ed  */
    /* JADX WARN: Code duplicated, block: B:400:0x05f1  */
    /* JADX WARN: Code duplicated, block: B:402:0x05f9  */
    /* JADX WARN: Code duplicated, block: B:403:0x05fd  */
    /* JADX WARN: Code duplicated, block: B:405:0x0605  */
    /* JADX WARN: Code duplicated, block: B:406:0x0609  */
    /* JADX WARN: Code duplicated, block: B:408:0x0611  */
    /* JADX WARN: Code duplicated, block: B:409:0x0615  */
    /* JADX WARN: Code duplicated, block: B:411:0x061d  */
    /* JADX WARN: Code duplicated, block: B:412:0x0621  */
    /* JADX WARN: Code duplicated, block: B:414:0x0629  */
    /* JADX WARN: Code duplicated, block: B:415:0x062d  */
    /* JADX WARN: Code duplicated, block: B:417:0x0635  */
    /* JADX WARN: Code duplicated, block: B:418:0x0639  */
    /* JADX WARN: Code duplicated, block: B:41:0x0080 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:420:0x0641  */
    /* JADX WARN: Code duplicated, block: B:421:0x0645  */
    /* JADX WARN: Code duplicated, block: B:423:0x064d  */
    /* JADX WARN: Code duplicated, block: B:424:0x0651  */
    /* JADX WARN: Code duplicated, block: B:426:0x0659  */
    /* JADX WARN: Code duplicated, block: B:427:0x065c  */
    /* JADX WARN: Code duplicated, block: B:429:0x0664  */
    /* JADX WARN: Code duplicated, block: B:42:0x0083 A[Catch: all -> 0x07aa, TRY_ENTER, TryCatch #0 {, blocks: (B:7:0x000f, B:9:0x0013, B:11:0x0021, B:514:0x07a2, B:42:0x0083, B:44:0x0089, B:47:0x0094, B:80:0x00ff, B:82:0x0105, B:507:0x078e, B:515:0x07a6), top: B:521:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:430:0x0667  */
    /* JADX WARN: Code duplicated, block: B:432:0x066f  */
    /* JADX WARN: Code duplicated, block: B:433:0x0673  */
    /* JADX WARN: Code duplicated, block: B:435:0x067b  */
    /* JADX WARN: Code duplicated, block: B:436:0x067f  */
    /* JADX WARN: Code duplicated, block: B:438:0x0687  */
    /* JADX WARN: Code duplicated, block: B:439:0x068b  */
    /* JADX WARN: Code duplicated, block: B:441:0x0693  */
    /* JADX WARN: Code duplicated, block: B:442:0x0697  */
    /* JADX WARN: Code duplicated, block: B:444:0x069f  */
    /* JADX WARN: Code duplicated, block: B:445:0x06a3  */
    /* JADX WARN: Code duplicated, block: B:447:0x06ab  */
    /* JADX WARN: Code duplicated, block: B:448:0x06af  */
    /* JADX WARN: Code duplicated, block: B:450:0x06b7  */
    /* JADX WARN: Code duplicated, block: B:451:0x06bb  */
    /* JADX WARN: Code duplicated, block: B:453:0x06c3  */
    /* JADX WARN: Code duplicated, block: B:454:0x06c7  */
    /* JADX WARN: Code duplicated, block: B:456:0x06cf  */
    /* JADX WARN: Code duplicated, block: B:457:0x06d3  */
    /* JADX WARN: Code duplicated, block: B:459:0x06db  */
    /* JADX WARN: Code duplicated, block: B:460:0x06df  */
    /* JADX WARN: Code duplicated, block: B:462:0x06e7  */
    /* JADX WARN: Code duplicated, block: B:463:0x06eb  */
    /* JADX WARN: Code duplicated, block: B:465:0x06f3  */
    /* JADX WARN: Code duplicated, block: B:466:0x06f7  */
    /* JADX WARN: Code duplicated, block: B:468:0x06ff  */
    /* JADX WARN: Code duplicated, block: B:469:0x0703  */
    /* JADX WARN: Code duplicated, block: B:471:0x070b  */
    /* JADX WARN: Code duplicated, block: B:472:0x070f  */
    /* JADX WARN: Code duplicated, block: B:474:0x0717  */
    /* JADX WARN: Code duplicated, block: B:475:0x071b  */
    /* JADX WARN: Code duplicated, block: B:477:0x0723  */
    /* JADX WARN: Code duplicated, block: B:478:0x0727  */
    /* JADX WARN: Code duplicated, block: B:47:0x0094 A[Catch: all -> 0x07aa, TRY_LEAVE, TryCatch #0 {, blocks: (B:7:0x000f, B:9:0x0013, B:11:0x0021, B:514:0x07a2, B:42:0x0083, B:44:0x0089, B:47:0x0094, B:80:0x00ff, B:82:0x0105, B:507:0x078e, B:515:0x07a6), top: B:521:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:480:0x072f  */
    /* JADX WARN: Code duplicated, block: B:481:0x0732  */
    /* JADX WARN: Code duplicated, block: B:483:0x073a  */
    /* JADX WARN: Code duplicated, block: B:484:0x073d  */
    /* JADX WARN: Code duplicated, block: B:486:0x0745  */
    /* JADX WARN: Code duplicated, block: B:487:0x0748  */
    /* JADX WARN: Code duplicated, block: B:489:0x0750  */
    /* JADX WARN: Code duplicated, block: B:490:0x0753  */
    /* JADX WARN: Code duplicated, block: B:492:0x075b  */
    /* JADX WARN: Code duplicated, block: B:493:0x075e  */
    /* JADX WARN: Code duplicated, block: B:495:0x0766  */
    /* JADX WARN: Code duplicated, block: B:496:0x0769  */
    /* JADX WARN: Code duplicated, block: B:498:0x0771  */
    /* JADX WARN: Code duplicated, block: B:499:0x0774  */
    /* JADX WARN: Code duplicated, block: B:501:0x077c  */
    /* JADX WARN: Code duplicated, block: B:502:0x077f  */
    /* JADX WARN: Code duplicated, block: B:504:0x0787  */
    /* JADX WARN: Code duplicated, block: B:505:0x078a  */
    /* JADX WARN: Code duplicated, block: B:507:0x078e A[Catch: all -> 0x07aa, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:7:0x000f, B:9:0x0013, B:11:0x0021, B:514:0x07a2, B:42:0x0083, B:44:0x0089, B:47:0x0094, B:80:0x00ff, B:82:0x0105, B:507:0x078e, B:515:0x07a6), top: B:521:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:511:0x0798  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:531:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:532:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:533:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:534:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:535:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:536:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:537:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:538:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:539:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:540:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:541:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:542:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:543:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:544:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:545:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:546:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:547:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:548:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:549:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:550:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:551:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:552:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:553:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:554:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:555:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:556:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:557:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:558:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:559:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:560:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:561:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:562:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:563:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:564:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:565:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:566:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:567:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:568:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:569:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:570:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:571:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:572:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:573:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:574:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:575:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:576:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:577:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:578:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:579:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:580:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:581:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:582:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:583:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:584:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:585:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:586:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:587:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:588:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:589:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:590:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:591:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:592:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:593:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:594:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:595:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:596:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:597:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:598:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:599:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:600:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:601:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:602:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:603:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:604:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:605:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:606:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:607:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:608:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:609:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:610:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:611:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:612:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:613:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:614:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:615:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:616:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:617:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:618:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:619:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:620:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:621:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:622:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:623:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:624:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:625:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:626:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:627:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:628:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:629:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:630:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:631:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:632:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:633:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:634:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:635:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:636:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:637:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:638:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:639:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:640:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:641:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:642:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:643:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:644:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:645:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:646:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:647:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:648:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:649:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:650:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:651:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:652:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:653:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:654:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:655:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:656:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:657:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:658:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:659:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:660:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:661:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:662:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:663:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:664:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:665:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:666:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:667:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:668:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:669:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:670:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:671:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:672:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:673:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:674:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:675:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:676:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:677:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:678:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:679:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x00db  */
    /* JADX WARN: Code duplicated, block: B:69:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:74:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:75:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:78:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:80:0x00ff A[Catch: all -> 0x07aa, TRY_ENTER, TryCatch #0 {, blocks: (B:7:0x000f, B:9:0x0013, B:11:0x0021, B:514:0x07a2, B:42:0x0083, B:44:0x0089, B:47:0x0094, B:80:0x00ff, B:82:0x0105, B:507:0x078e, B:515:0x07a6), top: B:521:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0105 A[Catch: all -> 0x07aa, TRY_LEAVE, TryCatch #0 {, blocks: (B:7:0x000f, B:9:0x0013, B:11:0x0021, B:514:0x07a2, B:42:0x0083, B:44:0x0089, B:47:0x0094, B:80:0x00ff, B:82:0x0105, B:507:0x078e, B:515:0x07a6), top: B:521:0x000f }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0110  */
    /* JADX WARN: Code duplicated, block: B:87:0x0118  */
    /* JADX WARN: Code duplicated, block: B:88:0x011c  */
    /* JADX WARN: Code duplicated, block: B:90:0x0124  */
    /* JADX WARN: Code duplicated, block: B:91:0x0128  */
    /* JADX WARN: Code duplicated, block: B:93:0x0130  */
    /* JADX WARN: Code duplicated, block: B:94:0x0134  */
    /* JADX WARN: Code duplicated, block: B:96:0x013c  */
    /* JADX WARN: Code duplicated, block: B:97:0x0140  */
    /* JADX WARN: Code duplicated, block: B:99:0x0148  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    protected static final boolean zzaM(String str) {
        String str2;
        byte b;
        String str3;
        byte b2;
        boolean z = false;
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (zzaah.class) {
            if (!zzc) {
                int i = zzfy.zza;
                byte b3 = Ascii.FS;
                if (i <= 28) {
                    String str4 = zzfy.zzb;
                    switch (str4.hashCode()) {
                        case -1339091551:
                            b2 = !str4.equals("dangal") ? (byte) -1 : (byte) 1;
                            break;
                        case -1220081023:
                            b2 = !str4.equals("dangalFHD") ? (byte) -1 : (byte) 3;
                            break;
                        case -1220066608:
                            b2 = !str4.equals("dangalUHD") ? (byte) -1 : (byte) 2;
                            break;
                        case -1012436106:
                            b2 = !str4.equals("oneday") ? (byte) -1 : (byte) 7;
                            break;
                        case -760312546:
                            b2 = !str4.equals("aquaman") ? (byte) -1 : (byte) 0;
                            break;
                        case -64886864:
                            b2 = !str4.equals("magnolia") ? (byte) -1 : (byte) 4;
                            break;
                        case 3415681:
                            b2 = !str4.equals("once") ? (byte) -1 : (byte) 6;
                            break;
                        case 825323514:
                            b2 = !str4.equals("machuca") ? (byte) -1 : (byte) 5;
                            break;
                        default:
                            b2 = -1;
                            break;
                    }
                    switch (b2) {
                        default:
                            if (zzfy.zza <= 27 || !"HWEML".equals(zzfy.zzb)) {
                                str2 = zzfy.zzd;
                                switch (str2.hashCode()) {
                                    case -349662828:
                                        if (!str2.equals("AFTJMST12")) {
                                            b = -1;
                                        } else {
                                            b = 6;
                                        }
                                        break;
                                    case -321033677:
                                        if (!str2.equals("AFTKMST12")) {
                                            b = -1;
                                        } else {
                                            b = 7;
                                        }
                                        break;
                                    case 2006354:
                                        if (!str2.equals("AFTA")) {
                                            b = -1;
                                        } else {
                                            b = 0;
                                        }
                                        break;
                                    case 2006367:
                                        if (!str2.equals("AFTN")) {
                                            b = -1;
                                        } else {
                                            b = 1;
                                        }
                                        break;
                                    case 2006371:
                                        if (!str2.equals("AFTR")) {
                                            b = -1;
                                        } else {
                                            b = 2;
                                        }
                                        break;
                                    case 1785421873:
                                        if (!str2.equals("AFTEU011")) {
                                            b = -1;
                                        } else {
                                            b = 3;
                                        }
                                        break;
                                    case 1785421876:
                                        if (!str2.equals("AFTEU014")) {
                                            b = -1;
                                        } else {
                                            b = 4;
                                        }
                                        break;
                                    case 1798172390:
                                        if (!str2.equals("AFTSO001")) {
                                            b = -1;
                                        } else {
                                            b = 8;
                                        }
                                        break;
                                    case 2119412532:
                                        if (!str2.equals("AFTEUFF014")) {
                                            b = -1;
                                        } else {
                                            b = 5;
                                        }
                                        break;
                                    default:
                                        b = -1;
                                        break;
                                }
                                switch (b) {
                                    default:
                                        if (zzfy.zza <= 26) {
                                            str3 = zzfy.zzb;
                                            switch (str3.hashCode()) {
                                                case -2144781245:
                                                    if (!str3.equals("GIONEE_SWW1609")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 54;
                                                    }
                                                    break;
                                                case -2144781185:
                                                    if (!str3.equals("GIONEE_SWW1627")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 55;
                                                    }
                                                    break;
                                                case -2144781160:
                                                    if (!str3.equals("GIONEE_SWW1631")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 56;
                                                    }
                                                    break;
                                                case -2097309513:
                                                    if (!str3.equals("K50a40")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 74;
                                                    }
                                                    break;
                                                case -2022874474:
                                                    if (!str3.equals("CP8676_I02")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = Ascii.SYN;
                                                    }
                                                    break;
                                                case -1978993182:
                                                    if (!str3.equals("NX541J")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 89;
                                                    }
                                                    break;
                                                case -1978990237:
                                                    if (!str3.equals("NX573J")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 90;
                                                    }
                                                    break;
                                                case -1936688988:
                                                    if (!str3.equals("PGN528")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 101;
                                                    }
                                                    break;
                                                case -1936688066:
                                                    if (!str3.equals("PGN610")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 102;
                                                    }
                                                    break;
                                                case -1936688065:
                                                    if (!str3.equals("PGN611")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 103;
                                                    }
                                                    break;
                                                case -1931988508:
                                                    if (!str3.equals("AquaPowerM")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = Ascii.CR;
                                                    }
                                                    break;
                                                case -1885099851:
                                                    if (!str3.equals("RAIJIN")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 116;
                                                    }
                                                    break;
                                                case -1696512866:
                                                    if (!str3.equals("XT1663")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 137;
                                                    }
                                                    break;
                                                case -1680025915:
                                                    if (!str3.equals("ComioS1")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = Ascii.NAK;
                                                    }
                                                    break;
                                                case -1615810839:
                                                    if (!str3.equals("Phantom6")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 104;
                                                    }
                                                    break;
                                                case -1600724499:
                                                    if (!str3.equals("pacificrim")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 95;
                                                    }
                                                    break;
                                                case -1554255044:
                                                    if (!str3.equals("vernee_M5")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 130;
                                                    }
                                                    break;
                                                case -1481772737:
                                                    if (!str3.equals("panell_dl")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 97;
                                                    }
                                                    break;
                                                case -1481772730:
                                                    if (!str3.equals("panell_ds")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 98;
                                                    }
                                                    break;
                                                case -1481772729:
                                                    if (!str3.equals("panell_dt")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 99;
                                                    }
                                                    break;
                                                case -1320080169:
                                                    if (!str3.equals("GiONEE_GBL7319")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 52;
                                                    }
                                                    break;
                                                case -1217592143:
                                                    if (!str3.equals("BRAVIA_ATV2")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = Ascii.DC2;
                                                    }
                                                    break;
                                                case -1180384755:
                                                    if (!str3.equals("iris60")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 70;
                                                    }
                                                    break;
                                                case -1139198265:
                                                    if (!str3.equals("Slate_Pro")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 118;
                                                    }
                                                    break;
                                                case -1052835013:
                                                    if (!str3.equals("namath")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 87;
                                                    }
                                                    break;
                                                case -993250464:
                                                    if (!str3.equals("A10-70F")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 5;
                                                    }
                                                    break;
                                                case -993250458:
                                                    if (!str3.equals("A10-70L")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 6;
                                                    }
                                                    break;
                                                case -965403638:
                                                    if (!str3.equals("s905x018")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 120;
                                                    }
                                                    break;
                                                case -958336948:
                                                    if (!str3.equals("ELUGA_Ray_X")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 34;
                                                    }
                                                    break;
                                                case -879245230:
                                                    if (!str3.equals("tcl_eu")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 126;
                                                    }
                                                    break;
                                                case -842500323:
                                                    if (!str3.equals("nicklaus_f")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 88;
                                                    }
                                                    break;
                                                case -821392978:
                                                    if (!str3.equals("A7000-a")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 9;
                                                    }
                                                    break;
                                                case -797483286:
                                                    if (!str3.equals("SVP-DTV15")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 119;
                                                    }
                                                    break;
                                                case -794946968:
                                                    if (!str3.equals("watson")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 131;
                                                    }
                                                    break;
                                                case -788334647:
                                                    if (!str3.equals("whyred")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 132;
                                                    }
                                                    break;
                                                case -782144577:
                                                    if (!str3.equals("OnePlus5T")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 91;
                                                    }
                                                    break;
                                                case -575125681:
                                                    if (!str3.equals("GiONEE_CBL7513")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 51;
                                                    }
                                                    break;
                                                case -521118391:
                                                    if (!str3.equals("GIONEE_GBL7360")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 53;
                                                    }
                                                    break;
                                                case -430914369:
                                                    if (!str3.equals("Pixi4-7_3G")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 105;
                                                    }
                                                    break;
                                                case -290434366:
                                                    if (!str3.equals("taido_row")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 121;
                                                    }
                                                    break;
                                                case -282781963:
                                                    if (!str3.equals("BLACK-1X")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 17;
                                                    }
                                                    break;
                                                case -277133239:
                                                    if (!str3.equals("Z12_PRO")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 138;
                                                    }
                                                    break;
                                                case -173639913:
                                                    if (!str3.equals("ELUGA_A3_Pro")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = Ascii.US;
                                                    }
                                                    break;
                                                case -56598463:
                                                    if (!str3.equals("woods_fn")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 134;
                                                    }
                                                    break;
                                                case 2126:
                                                    if (!str3.equals("C1")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = Ascii.DC4;
                                                    }
                                                    break;
                                                case 2564:
                                                    if (!str3.equals("Q5")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 113;
                                                    }
                                                    break;
                                                case 2715:
                                                    if (!str3.equals("V1")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 127;
                                                    }
                                                    break;
                                                case 2719:
                                                    if (!str3.equals("V5")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 129;
                                                    }
                                                    break;
                                                case 3091:
                                                    if (!str3.equals("b5")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = Ascii.DLE;
                                                    }
                                                    break;
                                                case 3483:
                                                    if (!str3.equals("mh")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 84;
                                                    }
                                                    break;
                                                case 73405:
                                                    if (!str3.equals("JGZ")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 73;
                                                    }
                                                    break;
                                                case 75537:
                                                    if (!str3.equals("M04")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 79;
                                                    }
                                                    break;
                                                case 75739:
                                                    if (!str3.equals("M5c")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 80;
                                                    }
                                                    break;
                                                case 76779:
                                                    if (!str3.equals("MX6")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 86;
                                                    }
                                                    break;
                                                case 78669:
                                                    if (!str3.equals("P85")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 94;
                                                    }
                                                    break;
                                                case 79305:
                                                    if (!str3.equals("PLE")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 107;
                                                    }
                                                    break;
                                                case 80618:
                                                    if (!str3.equals("QX1")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 115;
                                                    }
                                                    break;
                                                case 88274:
                                                    if (!str3.equals("Z80")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 139;
                                                    }
                                                    break;
                                                case 98846:
                                                    if (!str3.equals("cv1")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 26;
                                                    }
                                                    break;
                                                case 98848:
                                                    if (!str3.equals("cv3")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 27;
                                                    }
                                                    break;
                                                case 99329:
                                                    if (!str3.equals("deb")) {
                                                        b3 = -1;
                                                    }
                                                    break;
                                                case 101481:
                                                    if (!str3.equals("flo")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 49;
                                                    }
                                                    break;
                                                case 1513190:
                                                    if (!str3.equals("1601")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 0;
                                                    }
                                                    break;
                                                case 1514184:
                                                    if (!str3.equals("1713")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 1;
                                                    }
                                                    break;
                                                case 1514185:
                                                    if (!str3.equals("1714")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 2;
                                                    }
                                                    break;
                                                case 2133089:
                                                    if (!str3.equals("F01H")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 36;
                                                    }
                                                    break;
                                                case 2133091:
                                                    if (!str3.equals("F01J")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 37;
                                                    }
                                                    break;
                                                case 2133120:
                                                    if (!str3.equals("F02H")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 38;
                                                    }
                                                    break;
                                                case 2133151:
                                                    if (!str3.equals("F03H")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 39;
                                                    }
                                                    break;
                                                case 2133182:
                                                    if (!str3.equals("F04H")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 40;
                                                    }
                                                    break;
                                                case 2133184:
                                                    if (!str3.equals("F04J")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 41;
                                                    }
                                                    break;
                                                case 2436959:
                                                    if (!str3.equals("P681")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 93;
                                                    }
                                                    break;
                                                case 2463773:
                                                    if (!str3.equals("Q350")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 109;
                                                    }
                                                    break;
                                                case 2464648:
                                                    if (!str3.equals("Q427")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 111;
                                                    }
                                                    break;
                                                case 2689555:
                                                    if (!str3.equals("XE2X")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 136;
                                                    }
                                                    break;
                                                case 3154429:
                                                    if (!str3.equals("fugu")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 50;
                                                    }
                                                    break;
                                                case 3284551:
                                                    if (!str3.equals("kate")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 75;
                                                    }
                                                    break;
                                                case 3351335:
                                                    if (!str3.equals("mido")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 85;
                                                    }
                                                    break;
                                                case 3386211:
                                                    if (!str3.equals("p212")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 92;
                                                    }
                                                    break;
                                                case 41325051:
                                                    if (!str3.equals("MEIZU_M5")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 83;
                                                    }
                                                    break;
                                                case 51349633:
                                                    if (!str3.equals("601LV")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 3;
                                                    }
                                                    break;
                                                case 51350594:
                                                    if (!str3.equals("602LV")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 4;
                                                    }
                                                    break;
                                                case 55178625:
                                                    if (!str3.equals("Aura_Note_2")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = Ascii.SI;
                                                    }
                                                    break;
                                                case 61542055:
                                                    if (!str3.equals("A1601")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 7;
                                                    }
                                                    break;
                                                case 65355429:
                                                    if (!str3.equals("E5643")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = Ascii.RS;
                                                    }
                                                    break;
                                                case 66214468:
                                                    if (!str3.equals("F3111")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 42;
                                                    }
                                                    break;
                                                case 66214470:
                                                    if (!str3.equals("F3113")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 43;
                                                    }
                                                    break;
                                                case 66214473:
                                                    if (!str3.equals("F3116")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 44;
                                                    }
                                                    break;
                                                case 66215429:
                                                    if (!str3.equals("F3211")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 45;
                                                    }
                                                    break;
                                                case 66215431:
                                                    if (!str3.equals("F3213")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 46;
                                                    }
                                                    break;
                                                case 66215433:
                                                    if (!str3.equals("F3215")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 47;
                                                    }
                                                    break;
                                                case 66216390:
                                                    if (!str3.equals("F3311")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 48;
                                                    }
                                                    break;
                                                case 76402249:
                                                    if (!str3.equals("PRO7S")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 108;
                                                    }
                                                    break;
                                                case 76404105:
                                                    if (!str3.equals("Q4260")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 110;
                                                    }
                                                    break;
                                                case 76404911:
                                                    if (!str3.equals("Q4310")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 112;
                                                    }
                                                    break;
                                                case 80963634:
                                                    if (!str3.equals("V23GB")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 128;
                                                    }
                                                    break;
                                                case 82882791:
                                                    if (!str3.equals("X3_HK")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 135;
                                                    }
                                                    break;
                                                case 98715550:
                                                    if (!str3.equals("i9031")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 67;
                                                    }
                                                    break;
                                                case 101370885:
                                                    if (!str3.equals("l5460")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 76;
                                                    }
                                                    break;
                                                case 102844228:
                                                    if (!str3.equals("le_x6")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 77;
                                                    }
                                                    break;
                                                case 165221241:
                                                    if (!str3.equals("A2016a40")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 8;
                                                    }
                                                    break;
                                                case 182191441:
                                                    if (!str3.equals("CPY83_I00")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = Ascii.EM;
                                                    }
                                                    break;
                                                case 245388979:
                                                    if (!str3.equals("marino_f")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 82;
                                                    }
                                                    break;
                                                case 287431619:
                                                    if (!str3.equals("griffin")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 60;
                                                    }
                                                    break;
                                                case 307593612:
                                                    if (!str3.equals("A7010a48")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = Ascii.VT;
                                                    }
                                                    break;
                                                case 308517133:
                                                    if (!str3.equals("A7020a48")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = Ascii.FF;
                                                    }
                                                    break;
                                                case 316215098:
                                                    if (!str3.equals("TB3-730F")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 122;
                                                    }
                                                    break;
                                                case 316215116:
                                                    if (!str3.equals("TB3-730X")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 123;
                                                    }
                                                    break;
                                                case 316246811:
                                                    if (!str3.equals("TB3-850F")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 124;
                                                    }
                                                    break;
                                                case 316246818:
                                                    if (!str3.equals("TB3-850M")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 125;
                                                    }
                                                    break;
                                                case 407160593:
                                                    if (!str3.equals("Pixi5-10_4G")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 106;
                                                    }
                                                    break;
                                                case 507412548:
                                                    if (!str3.equals("QM16XE_U")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 114;
                                                    }
                                                    break;
                                                case 793982701:
                                                    if (!str3.equals("GIONEE_WBL5708")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 57;
                                                    }
                                                    break;
                                                case 794038622:
                                                    if (!str3.equals("GIONEE_WBL7365")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 58;
                                                    }
                                                    break;
                                                case 794040393:
                                                    if (!str3.equals("GIONEE_WBL7519")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 59;
                                                    }
                                                    break;
                                                case 835649806:
                                                    if (!str3.equals("manning")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 81;
                                                    }
                                                    break;
                                                case 917340916:
                                                    if (!str3.equals("A7000plus")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 10;
                                                    }
                                                    break;
                                                case 958008161:
                                                    if (!str3.equals("j2xlteins")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 72;
                                                    }
                                                    break;
                                                case 1060579533:
                                                    if (!str3.equals("panell_d")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 96;
                                                    }
                                                    break;
                                                case 1150207623:
                                                    if (!str3.equals("LS-5017")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 78;
                                                    }
                                                    break;
                                                case 1176899427:
                                                    if (!str3.equals("itel_S41")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 71;
                                                    }
                                                    break;
                                                case 1280332038:
                                                    if (!str3.equals("hwALE-H")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 62;
                                                    }
                                                    break;
                                                case 1306947716:
                                                    if (!str3.equals("EverStar_S")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 35;
                                                    }
                                                    break;
                                                case 1349174697:
                                                    if (!str3.equals("htc_e56ml_dtul")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = Base64.padSymbol;
                                                    }
                                                    break;
                                                case 1522194893:
                                                    if (!str3.equals("woods_f")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 133;
                                                    }
                                                    break;
                                                case 1691543273:
                                                    if (!str3.equals("CPH1609")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = Ascii.ETB;
                                                    }
                                                    break;
                                                case 1691544261:
                                                    if (!str3.equals("CPH1715")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = Ascii.CAN;
                                                    }
                                                    break;
                                                case 1709443163:
                                                    if (!str3.equals("iball8735_9806")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 68;
                                                    }
                                                    break;
                                                case 1865889110:
                                                    if (!str3.equals("santoni")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 117;
                                                    }
                                                    break;
                                                case 1906253259:
                                                    if (!str3.equals("PB2-670M")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 100;
                                                    }
                                                    break;
                                                case 1977196784:
                                                    if (!str3.equals("Infinix-X572")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 69;
                                                    }
                                                    break;
                                                case 2006372676:
                                                    if (!str3.equals("BRAVIA_ATV3_4K")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 19;
                                                    }
                                                    break;
                                                case 2019281702:
                                                    if (!str3.equals("DM-01K")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = Ascii.GS;
                                                    }
                                                    break;
                                                case 2029784656:
                                                    if (!str3.equals("HWBLN-H")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 63;
                                                    }
                                                    break;
                                                case 2030379515:
                                                    if (!str3.equals("HWCAM-H")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = SignedBytes.MAX_POWER_OF_TWO;
                                                    }
                                                    break;
                                                case 2033393791:
                                                    if (!str3.equals("ASUS_X00AD_2")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = Ascii.SO;
                                                    }
                                                    break;
                                                case 2047190025:
                                                    if (!str3.equals("ELUGA_Note")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 32;
                                                    }
                                                    break;
                                                case 2047252157:
                                                    if (!str3.equals("ELUGA_Prim")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 33;
                                                    }
                                                    break;
                                                case 2048319463:
                                                    if (!str3.equals("HWVNS-H")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 65;
                                                    }
                                                    break;
                                                case 2048855701:
                                                    if (!str3.equals("HWWAS-H")) {
                                                        b3 = -1;
                                                    } else {
                                                        b3 = 66;
                                                    }
                                                    break;
                                                default:
                                                    b3 = -1;
                                                    break;
                                            }
                                            switch (b3) {
                                                default:
                                                    if (str2.hashCode() == -594534941 && str2.equals("JSN-L21")) {
                                                    }
                                                case 0:
                                                case 1:
                                                case 2:
                                                case 3:
                                                case 4:
                                                case 5:
                                                case 6:
                                                case 7:
                                                case 8:
                                                case 9:
                                                case 10:
                                                case 11:
                                                case 12:
                                                case 13:
                                                case 14:
                                                case 15:
                                                case 16:
                                                case 17:
                                                case 18:
                                                case 19:
                                                case 20:
                                                case 21:
                                                case 22:
                                                case 23:
                                                case 24:
                                                case 25:
                                                case 26:
                                                case 27:
                                                case 28:
                                                case 29:
                                                case 30:
                                                case 31:
                                                case 32:
                                                case 33:
                                                case 34:
                                                case 35:
                                                case 36:
                                                case 37:
                                                case 38:
                                                case 39:
                                                case 40:
                                                case 41:
                                                case 42:
                                                case 43:
                                                case 44:
                                                case 45:
                                                case 46:
                                                case 47:
                                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                                                case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                                case 50:
                                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                                case 52:
                                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                                                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                                case 56:
                                                case 57:
                                                case 58:
                                                case 59:
                                                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                                                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                                case 62:
                                                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                                case 64:
                                                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                                                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                                case 67:
                                                case 68:
                                                case 69:
                                                case 70:
                                                case 71:
                                                case 72:
                                                case 73:
                                                case 74:
                                                case 75:
                                                case Base64.mimeLineLength /* 76 */:
                                                case 77:
                                                case 78:
                                                case 79:
                                                case 80:
                                                case 81:
                                                case 82:
                                                case 83:
                                                case 84:
                                                case 85:
                                                case 86:
                                                case 87:
                                                case 88:
                                                case 89:
                                                case 90:
                                                case 91:
                                                case 92:
                                                case 93:
                                                case 94:
                                                case 95:
                                                case 96:
                                                case 97:
                                                case 98:
                                                case 99:
                                                case 100:
                                                case 101:
                                                case LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY /* 102 */:
                                                case 103:
                                                case LocationRequestCompat.QUALITY_LOW_POWER /* 104 */:
                                                case 105:
                                                case 106:
                                                case 107:
                                                case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
                                                case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY /* 109 */:
                                                case 110:
                                                case 111:
                                                case 112:
                                                case 113:
                                                case 114:
                                                case 115:
                                                case 116:
                                                case 117:
                                                case 118:
                                                case 119:
                                                case 120:
                                                case 121:
                                                case 122:
                                                case 123:
                                                case 124:
                                                case 125:
                                                case 126:
                                                case WorkQueueKt.MASK /* 127 */:
                                                case 128:
                                                case 129:
                                                case 130:
                                                case 131:
                                                case 132:
                                                case 133:
                                                case 134:
                                                case 135:
                                                case 136:
                                                case 137:
                                                case 138:
                                                case 139:
                                                    z = true;
                                                    break;
                                            }
                                        }
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                        z = true;
                                        break;
                                }
                            }
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            z = true;
                            break;
                    }
                } else if (zzfy.zza <= 27) {
                    str2 = zzfy.zzd;
                    switch (str2.hashCode()) {
                        case -349662828:
                            if (!str2.equals("AFTJMST12")) {
                                b = -1;
                            } else {
                                b = 6;
                            }
                            break;
                        case -321033677:
                            if (!str2.equals("AFTKMST12")) {
                                b = -1;
                            } else {
                                b = 7;
                            }
                            break;
                        case 2006354:
                            if (!str2.equals("AFTA")) {
                                b = -1;
                            } else {
                                b = 0;
                            }
                            break;
                        case 2006367:
                            if (!str2.equals("AFTN")) {
                                b = -1;
                            } else {
                                b = 1;
                            }
                            break;
                        case 2006371:
                            if (!str2.equals("AFTR")) {
                                b = -1;
                            } else {
                                b = 2;
                            }
                            break;
                        case 1785421873:
                            if (!str2.equals("AFTEU011")) {
                                b = -1;
                            } else {
                                b = 3;
                            }
                            break;
                        case 1785421876:
                            if (!str2.equals("AFTEU014")) {
                                b = -1;
                            } else {
                                b = 4;
                            }
                            break;
                        case 1798172390:
                            if (!str2.equals("AFTSO001")) {
                                b = -1;
                            } else {
                                b = 8;
                            }
                            break;
                        case 2119412532:
                            if (!str2.equals("AFTEUFF014")) {
                                b = -1;
                            } else {
                                b = 5;
                            }
                            break;
                        default:
                            b = -1;
                            break;
                    }
                    switch (b) {
                        default:
                            if (zzfy.zza <= 26) {
                                str3 = zzfy.zzb;
                                switch (str3.hashCode()) {
                                    case -2144781245:
                                        if (!str3.equals("GIONEE_SWW1609")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 54;
                                        }
                                        break;
                                    case -2144781185:
                                        if (!str3.equals("GIONEE_SWW1627")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 55;
                                        }
                                        break;
                                    case -2144781160:
                                        if (!str3.equals("GIONEE_SWW1631")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 56;
                                        }
                                        break;
                                    case -2097309513:
                                        if (!str3.equals("K50a40")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 74;
                                        }
                                        break;
                                    case -2022874474:
                                        if (!str3.equals("CP8676_I02")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.SYN;
                                        }
                                        break;
                                    case -1978993182:
                                        if (!str3.equals("NX541J")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 89;
                                        }
                                        break;
                                    case -1978990237:
                                        if (!str3.equals("NX573J")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 90;
                                        }
                                        break;
                                    case -1936688988:
                                        if (!str3.equals("PGN528")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 101;
                                        }
                                        break;
                                    case -1936688066:
                                        if (!str3.equals("PGN610")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 102;
                                        }
                                        break;
                                    case -1936688065:
                                        if (!str3.equals("PGN611")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 103;
                                        }
                                        break;
                                    case -1931988508:
                                        if (!str3.equals("AquaPowerM")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.CR;
                                        }
                                        break;
                                    case -1885099851:
                                        if (!str3.equals("RAIJIN")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 116;
                                        }
                                        break;
                                    case -1696512866:
                                        if (!str3.equals("XT1663")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 137;
                                        }
                                        break;
                                    case -1680025915:
                                        if (!str3.equals("ComioS1")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.NAK;
                                        }
                                        break;
                                    case -1615810839:
                                        if (!str3.equals("Phantom6")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 104;
                                        }
                                        break;
                                    case -1600724499:
                                        if (!str3.equals("pacificrim")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 95;
                                        }
                                        break;
                                    case -1554255044:
                                        if (!str3.equals("vernee_M5")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 130;
                                        }
                                        break;
                                    case -1481772737:
                                        if (!str3.equals("panell_dl")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 97;
                                        }
                                        break;
                                    case -1481772730:
                                        if (!str3.equals("panell_ds")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 98;
                                        }
                                        break;
                                    case -1481772729:
                                        if (!str3.equals("panell_dt")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 99;
                                        }
                                        break;
                                    case -1320080169:
                                        if (!str3.equals("GiONEE_GBL7319")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 52;
                                        }
                                        break;
                                    case -1217592143:
                                        if (!str3.equals("BRAVIA_ATV2")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.DC2;
                                        }
                                        break;
                                    case -1180384755:
                                        if (!str3.equals("iris60")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 70;
                                        }
                                        break;
                                    case -1139198265:
                                        if (!str3.equals("Slate_Pro")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 118;
                                        }
                                        break;
                                    case -1052835013:
                                        if (!str3.equals("namath")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 87;
                                        }
                                        break;
                                    case -993250464:
                                        if (!str3.equals("A10-70F")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 5;
                                        }
                                        break;
                                    case -993250458:
                                        if (!str3.equals("A10-70L")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 6;
                                        }
                                        break;
                                    case -965403638:
                                        if (!str3.equals("s905x018")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 120;
                                        }
                                        break;
                                    case -958336948:
                                        if (!str3.equals("ELUGA_Ray_X")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 34;
                                        }
                                        break;
                                    case -879245230:
                                        if (!str3.equals("tcl_eu")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 126;
                                        }
                                        break;
                                    case -842500323:
                                        if (!str3.equals("nicklaus_f")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 88;
                                        }
                                        break;
                                    case -821392978:
                                        if (!str3.equals("A7000-a")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 9;
                                        }
                                        break;
                                    case -797483286:
                                        if (!str3.equals("SVP-DTV15")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 119;
                                        }
                                        break;
                                    case -794946968:
                                        if (!str3.equals("watson")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 131;
                                        }
                                        break;
                                    case -788334647:
                                        if (!str3.equals("whyred")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 132;
                                        }
                                        break;
                                    case -782144577:
                                        if (!str3.equals("OnePlus5T")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 91;
                                        }
                                        break;
                                    case -575125681:
                                        if (!str3.equals("GiONEE_CBL7513")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 51;
                                        }
                                        break;
                                    case -521118391:
                                        if (!str3.equals("GIONEE_GBL7360")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 53;
                                        }
                                        break;
                                    case -430914369:
                                        if (!str3.equals("Pixi4-7_3G")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 105;
                                        }
                                        break;
                                    case -290434366:
                                        if (!str3.equals("taido_row")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 121;
                                        }
                                        break;
                                    case -282781963:
                                        if (!str3.equals("BLACK-1X")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 17;
                                        }
                                        break;
                                    case -277133239:
                                        if (!str3.equals("Z12_PRO")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 138;
                                        }
                                        break;
                                    case -173639913:
                                        if (!str3.equals("ELUGA_A3_Pro")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.US;
                                        }
                                        break;
                                    case -56598463:
                                        if (!str3.equals("woods_fn")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 134;
                                        }
                                        break;
                                    case 2126:
                                        if (!str3.equals("C1")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.DC4;
                                        }
                                        break;
                                    case 2564:
                                        if (!str3.equals("Q5")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 113;
                                        }
                                        break;
                                    case 2715:
                                        if (!str3.equals("V1")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 127;
                                        }
                                        break;
                                    case 2719:
                                        if (!str3.equals("V5")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 129;
                                        }
                                        break;
                                    case 3091:
                                        if (!str3.equals("b5")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.DLE;
                                        }
                                        break;
                                    case 3483:
                                        if (!str3.equals("mh")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 84;
                                        }
                                        break;
                                    case 73405:
                                        if (!str3.equals("JGZ")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 73;
                                        }
                                        break;
                                    case 75537:
                                        if (!str3.equals("M04")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 79;
                                        }
                                        break;
                                    case 75739:
                                        if (!str3.equals("M5c")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 80;
                                        }
                                        break;
                                    case 76779:
                                        if (!str3.equals("MX6")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 86;
                                        }
                                        break;
                                    case 78669:
                                        if (!str3.equals("P85")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 94;
                                        }
                                        break;
                                    case 79305:
                                        if (!str3.equals("PLE")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 107;
                                        }
                                        break;
                                    case 80618:
                                        if (!str3.equals("QX1")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 115;
                                        }
                                        break;
                                    case 88274:
                                        if (!str3.equals("Z80")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 139;
                                        }
                                        break;
                                    case 98846:
                                        if (!str3.equals("cv1")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 26;
                                        }
                                        break;
                                    case 98848:
                                        if (!str3.equals("cv3")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 27;
                                        }
                                        break;
                                    case 99329:
                                        if (!str3.equals("deb")) {
                                            b3 = -1;
                                        }
                                        break;
                                    case 101481:
                                        if (!str3.equals("flo")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 49;
                                        }
                                        break;
                                    case 1513190:
                                        if (!str3.equals("1601")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 0;
                                        }
                                        break;
                                    case 1514184:
                                        if (!str3.equals("1713")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 1;
                                        }
                                        break;
                                    case 1514185:
                                        if (!str3.equals("1714")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 2;
                                        }
                                        break;
                                    case 2133089:
                                        if (!str3.equals("F01H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 36;
                                        }
                                        break;
                                    case 2133091:
                                        if (!str3.equals("F01J")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 37;
                                        }
                                        break;
                                    case 2133120:
                                        if (!str3.equals("F02H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 38;
                                        }
                                        break;
                                    case 2133151:
                                        if (!str3.equals("F03H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 39;
                                        }
                                        break;
                                    case 2133182:
                                        if (!str3.equals("F04H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 40;
                                        }
                                        break;
                                    case 2133184:
                                        if (!str3.equals("F04J")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 41;
                                        }
                                        break;
                                    case 2436959:
                                        if (!str3.equals("P681")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 93;
                                        }
                                        break;
                                    case 2463773:
                                        if (!str3.equals("Q350")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 109;
                                        }
                                        break;
                                    case 2464648:
                                        if (!str3.equals("Q427")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 111;
                                        }
                                        break;
                                    case 2689555:
                                        if (!str3.equals("XE2X")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 136;
                                        }
                                        break;
                                    case 3154429:
                                        if (!str3.equals("fugu")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 50;
                                        }
                                        break;
                                    case 3284551:
                                        if (!str3.equals("kate")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 75;
                                        }
                                        break;
                                    case 3351335:
                                        if (!str3.equals("mido")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 85;
                                        }
                                        break;
                                    case 3386211:
                                        if (!str3.equals("p212")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 92;
                                        }
                                        break;
                                    case 41325051:
                                        if (!str3.equals("MEIZU_M5")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 83;
                                        }
                                        break;
                                    case 51349633:
                                        if (!str3.equals("601LV")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 3;
                                        }
                                        break;
                                    case 51350594:
                                        if (!str3.equals("602LV")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 4;
                                        }
                                        break;
                                    case 55178625:
                                        if (!str3.equals("Aura_Note_2")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.SI;
                                        }
                                        break;
                                    case 61542055:
                                        if (!str3.equals("A1601")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 7;
                                        }
                                        break;
                                    case 65355429:
                                        if (!str3.equals("E5643")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.RS;
                                        }
                                        break;
                                    case 66214468:
                                        if (!str3.equals("F3111")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 42;
                                        }
                                        break;
                                    case 66214470:
                                        if (!str3.equals("F3113")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 43;
                                        }
                                        break;
                                    case 66214473:
                                        if (!str3.equals("F3116")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 44;
                                        }
                                        break;
                                    case 66215429:
                                        if (!str3.equals("F3211")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 45;
                                        }
                                        break;
                                    case 66215431:
                                        if (!str3.equals("F3213")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 46;
                                        }
                                        break;
                                    case 66215433:
                                        if (!str3.equals("F3215")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 47;
                                        }
                                        break;
                                    case 66216390:
                                        if (!str3.equals("F3311")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 48;
                                        }
                                        break;
                                    case 76402249:
                                        if (!str3.equals("PRO7S")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 108;
                                        }
                                        break;
                                    case 76404105:
                                        if (!str3.equals("Q4260")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 110;
                                        }
                                        break;
                                    case 76404911:
                                        if (!str3.equals("Q4310")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 112;
                                        }
                                        break;
                                    case 80963634:
                                        if (!str3.equals("V23GB")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 128;
                                        }
                                        break;
                                    case 82882791:
                                        if (!str3.equals("X3_HK")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 135;
                                        }
                                        break;
                                    case 98715550:
                                        if (!str3.equals("i9031")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 67;
                                        }
                                        break;
                                    case 101370885:
                                        if (!str3.equals("l5460")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 76;
                                        }
                                        break;
                                    case 102844228:
                                        if (!str3.equals("le_x6")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 77;
                                        }
                                        break;
                                    case 165221241:
                                        if (!str3.equals("A2016a40")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 8;
                                        }
                                        break;
                                    case 182191441:
                                        if (!str3.equals("CPY83_I00")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.EM;
                                        }
                                        break;
                                    case 245388979:
                                        if (!str3.equals("marino_f")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 82;
                                        }
                                        break;
                                    case 287431619:
                                        if (!str3.equals("griffin")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 60;
                                        }
                                        break;
                                    case 307593612:
                                        if (!str3.equals("A7010a48")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.VT;
                                        }
                                        break;
                                    case 308517133:
                                        if (!str3.equals("A7020a48")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.FF;
                                        }
                                        break;
                                    case 316215098:
                                        if (!str3.equals("TB3-730F")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 122;
                                        }
                                        break;
                                    case 316215116:
                                        if (!str3.equals("TB3-730X")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 123;
                                        }
                                        break;
                                    case 316246811:
                                        if (!str3.equals("TB3-850F")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 124;
                                        }
                                        break;
                                    case 316246818:
                                        if (!str3.equals("TB3-850M")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 125;
                                        }
                                        break;
                                    case 407160593:
                                        if (!str3.equals("Pixi5-10_4G")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 106;
                                        }
                                        break;
                                    case 507412548:
                                        if (!str3.equals("QM16XE_U")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 114;
                                        }
                                        break;
                                    case 793982701:
                                        if (!str3.equals("GIONEE_WBL5708")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 57;
                                        }
                                        break;
                                    case 794038622:
                                        if (!str3.equals("GIONEE_WBL7365")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 58;
                                        }
                                        break;
                                    case 794040393:
                                        if (!str3.equals("GIONEE_WBL7519")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 59;
                                        }
                                        break;
                                    case 835649806:
                                        if (!str3.equals("manning")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 81;
                                        }
                                        break;
                                    case 917340916:
                                        if (!str3.equals("A7000plus")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 10;
                                        }
                                        break;
                                    case 958008161:
                                        if (!str3.equals("j2xlteins")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 72;
                                        }
                                        break;
                                    case 1060579533:
                                        if (!str3.equals("panell_d")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 96;
                                        }
                                        break;
                                    case 1150207623:
                                        if (!str3.equals("LS-5017")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 78;
                                        }
                                        break;
                                    case 1176899427:
                                        if (!str3.equals("itel_S41")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 71;
                                        }
                                        break;
                                    case 1280332038:
                                        if (!str3.equals("hwALE-H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 62;
                                        }
                                        break;
                                    case 1306947716:
                                        if (!str3.equals("EverStar_S")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 35;
                                        }
                                        break;
                                    case 1349174697:
                                        if (!str3.equals("htc_e56ml_dtul")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Base64.padSymbol;
                                        }
                                        break;
                                    case 1522194893:
                                        if (!str3.equals("woods_f")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 133;
                                        }
                                        break;
                                    case 1691543273:
                                        if (!str3.equals("CPH1609")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.ETB;
                                        }
                                        break;
                                    case 1691544261:
                                        if (!str3.equals("CPH1715")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.CAN;
                                        }
                                        break;
                                    case 1709443163:
                                        if (!str3.equals("iball8735_9806")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 68;
                                        }
                                        break;
                                    case 1865889110:
                                        if (!str3.equals("santoni")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 117;
                                        }
                                        break;
                                    case 1906253259:
                                        if (!str3.equals("PB2-670M")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 100;
                                        }
                                        break;
                                    case 1977196784:
                                        if (!str3.equals("Infinix-X572")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 69;
                                        }
                                        break;
                                    case 2006372676:
                                        if (!str3.equals("BRAVIA_ATV3_4K")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 19;
                                        }
                                        break;
                                    case 2019281702:
                                        if (!str3.equals("DM-01K")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.GS;
                                        }
                                        break;
                                    case 2029784656:
                                        if (!str3.equals("HWBLN-H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 63;
                                        }
                                        break;
                                    case 2030379515:
                                        if (!str3.equals("HWCAM-H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = SignedBytes.MAX_POWER_OF_TWO;
                                        }
                                        break;
                                    case 2033393791:
                                        if (!str3.equals("ASUS_X00AD_2")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.SO;
                                        }
                                        break;
                                    case 2047190025:
                                        if (!str3.equals("ELUGA_Note")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 32;
                                        }
                                        break;
                                    case 2047252157:
                                        if (!str3.equals("ELUGA_Prim")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 33;
                                        }
                                        break;
                                    case 2048319463:
                                        if (!str3.equals("HWVNS-H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 65;
                                        }
                                        break;
                                    case 2048855701:
                                        if (!str3.equals("HWWAS-H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 66;
                                        }
                                        break;
                                    default:
                                        b3 = -1;
                                        break;
                                }
                                switch (b3) {
                                    default:
                                        if (str2.hashCode() == -594534941) {
                                            break;
                                        }
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                    case 14:
                                    case 15:
                                    case 16:
                                    case 17:
                                    case 18:
                                    case 19:
                                    case 20:
                                    case 21:
                                    case 22:
                                    case 23:
                                    case 24:
                                    case 25:
                                    case 26:
                                    case 27:
                                    case 28:
                                    case 29:
                                    case 30:
                                    case 31:
                                    case 32:
                                    case 33:
                                    case 34:
                                    case 35:
                                    case 36:
                                    case 37:
                                    case 38:
                                    case 39:
                                    case 40:
                                    case 41:
                                    case 42:
                                    case 43:
                                    case 44:
                                    case 45:
                                    case 46:
                                    case 47:
                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                    case 50:
                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                    case 52:
                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                    case 56:
                                    case 57:
                                    case 58:
                                    case 59:
                                    case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                                    case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                    case 62:
                                    case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                    case 64:
                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                    case 67:
                                    case 68:
                                    case 69:
                                    case 70:
                                    case 71:
                                    case 72:
                                    case 73:
                                    case 74:
                                    case 75:
                                    case Base64.mimeLineLength /* 76 */:
                                    case 77:
                                    case 78:
                                    case 79:
                                    case 80:
                                    case 81:
                                    case 82:
                                    case 83:
                                    case 84:
                                    case 85:
                                    case 86:
                                    case 87:
                                    case 88:
                                    case 89:
                                    case 90:
                                    case 91:
                                    case 92:
                                    case 93:
                                    case 94:
                                    case 95:
                                    case 96:
                                    case 97:
                                    case 98:
                                    case 99:
                                    case 100:
                                    case 101:
                                    case LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY /* 102 */:
                                    case 103:
                                    case LocationRequestCompat.QUALITY_LOW_POWER /* 104 */:
                                    case 105:
                                    case 106:
                                    case 107:
                                    case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
                                    case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY /* 109 */:
                                    case 110:
                                    case 111:
                                    case 112:
                                    case 113:
                                    case 114:
                                    case 115:
                                    case 116:
                                    case 117:
                                    case 118:
                                    case 119:
                                    case 120:
                                    case 121:
                                    case 122:
                                    case 123:
                                    case 124:
                                    case 125:
                                    case 126:
                                    case WorkQueueKt.MASK /* 127 */:
                                    case 128:
                                    case 129:
                                    case 130:
                                    case 131:
                                    case 132:
                                    case 133:
                                    case 134:
                                    case 135:
                                    case 136:
                                    case 137:
                                    case 138:
                                    case 139:
                                        z = true;
                                        break;
                                }
                            }
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                            z = true;
                            break;
                    }
                } else {
                    str2 = zzfy.zzd;
                    switch (str2.hashCode()) {
                        case -349662828:
                            if (!str2.equals("AFTJMST12")) {
                                b = -1;
                            } else {
                                b = 6;
                            }
                            break;
                        case -321033677:
                            if (!str2.equals("AFTKMST12")) {
                                b = -1;
                            } else {
                                b = 7;
                            }
                            break;
                        case 2006354:
                            if (!str2.equals("AFTA")) {
                                b = -1;
                            } else {
                                b = 0;
                            }
                            break;
                        case 2006367:
                            if (!str2.equals("AFTN")) {
                                b = -1;
                            } else {
                                b = 1;
                            }
                            break;
                        case 2006371:
                            if (!str2.equals("AFTR")) {
                                b = -1;
                            } else {
                                b = 2;
                            }
                            break;
                        case 1785421873:
                            if (!str2.equals("AFTEU011")) {
                                b = -1;
                            } else {
                                b = 3;
                            }
                            break;
                        case 1785421876:
                            if (!str2.equals("AFTEU014")) {
                                b = -1;
                            } else {
                                b = 4;
                            }
                            break;
                        case 1798172390:
                            if (!str2.equals("AFTSO001")) {
                                b = -1;
                            } else {
                                b = 8;
                            }
                            break;
                        case 2119412532:
                            if (!str2.equals("AFTEUFF014")) {
                                b = -1;
                            } else {
                                b = 5;
                            }
                            break;
                        default:
                            b = -1;
                            break;
                    }
                    switch (b) {
                        default:
                            if (zzfy.zza <= 26) {
                                str3 = zzfy.zzb;
                                switch (str3.hashCode()) {
                                    case -2144781245:
                                        if (!str3.equals("GIONEE_SWW1609")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 54;
                                        }
                                        break;
                                    case -2144781185:
                                        if (!str3.equals("GIONEE_SWW1627")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 55;
                                        }
                                        break;
                                    case -2144781160:
                                        if (!str3.equals("GIONEE_SWW1631")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 56;
                                        }
                                        break;
                                    case -2097309513:
                                        if (!str3.equals("K50a40")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 74;
                                        }
                                        break;
                                    case -2022874474:
                                        if (!str3.equals("CP8676_I02")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.SYN;
                                        }
                                        break;
                                    case -1978993182:
                                        if (!str3.equals("NX541J")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 89;
                                        }
                                        break;
                                    case -1978990237:
                                        if (!str3.equals("NX573J")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 90;
                                        }
                                        break;
                                    case -1936688988:
                                        if (!str3.equals("PGN528")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 101;
                                        }
                                        break;
                                    case -1936688066:
                                        if (!str3.equals("PGN610")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 102;
                                        }
                                        break;
                                    case -1936688065:
                                        if (!str3.equals("PGN611")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 103;
                                        }
                                        break;
                                    case -1931988508:
                                        if (!str3.equals("AquaPowerM")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.CR;
                                        }
                                        break;
                                    case -1885099851:
                                        if (!str3.equals("RAIJIN")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 116;
                                        }
                                        break;
                                    case -1696512866:
                                        if (!str3.equals("XT1663")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 137;
                                        }
                                        break;
                                    case -1680025915:
                                        if (!str3.equals("ComioS1")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.NAK;
                                        }
                                        break;
                                    case -1615810839:
                                        if (!str3.equals("Phantom6")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 104;
                                        }
                                        break;
                                    case -1600724499:
                                        if (!str3.equals("pacificrim")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 95;
                                        }
                                        break;
                                    case -1554255044:
                                        if (!str3.equals("vernee_M5")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 130;
                                        }
                                        break;
                                    case -1481772737:
                                        if (!str3.equals("panell_dl")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 97;
                                        }
                                        break;
                                    case -1481772730:
                                        if (!str3.equals("panell_ds")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 98;
                                        }
                                        break;
                                    case -1481772729:
                                        if (!str3.equals("panell_dt")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 99;
                                        }
                                        break;
                                    case -1320080169:
                                        if (!str3.equals("GiONEE_GBL7319")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 52;
                                        }
                                        break;
                                    case -1217592143:
                                        if (!str3.equals("BRAVIA_ATV2")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.DC2;
                                        }
                                        break;
                                    case -1180384755:
                                        if (!str3.equals("iris60")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 70;
                                        }
                                        break;
                                    case -1139198265:
                                        if (!str3.equals("Slate_Pro")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 118;
                                        }
                                        break;
                                    case -1052835013:
                                        if (!str3.equals("namath")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 87;
                                        }
                                        break;
                                    case -993250464:
                                        if (!str3.equals("A10-70F")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 5;
                                        }
                                        break;
                                    case -993250458:
                                        if (!str3.equals("A10-70L")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 6;
                                        }
                                        break;
                                    case -965403638:
                                        if (!str3.equals("s905x018")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 120;
                                        }
                                        break;
                                    case -958336948:
                                        if (!str3.equals("ELUGA_Ray_X")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 34;
                                        }
                                        break;
                                    case -879245230:
                                        if (!str3.equals("tcl_eu")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 126;
                                        }
                                        break;
                                    case -842500323:
                                        if (!str3.equals("nicklaus_f")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 88;
                                        }
                                        break;
                                    case -821392978:
                                        if (!str3.equals("A7000-a")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 9;
                                        }
                                        break;
                                    case -797483286:
                                        if (!str3.equals("SVP-DTV15")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 119;
                                        }
                                        break;
                                    case -794946968:
                                        if (!str3.equals("watson")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 131;
                                        }
                                        break;
                                    case -788334647:
                                        if (!str3.equals("whyred")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 132;
                                        }
                                        break;
                                    case -782144577:
                                        if (!str3.equals("OnePlus5T")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 91;
                                        }
                                        break;
                                    case -575125681:
                                        if (!str3.equals("GiONEE_CBL7513")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 51;
                                        }
                                        break;
                                    case -521118391:
                                        if (!str3.equals("GIONEE_GBL7360")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 53;
                                        }
                                        break;
                                    case -430914369:
                                        if (!str3.equals("Pixi4-7_3G")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 105;
                                        }
                                        break;
                                    case -290434366:
                                        if (!str3.equals("taido_row")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 121;
                                        }
                                        break;
                                    case -282781963:
                                        if (!str3.equals("BLACK-1X")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 17;
                                        }
                                        break;
                                    case -277133239:
                                        if (!str3.equals("Z12_PRO")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 138;
                                        }
                                        break;
                                    case -173639913:
                                        if (!str3.equals("ELUGA_A3_Pro")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.US;
                                        }
                                        break;
                                    case -56598463:
                                        if (!str3.equals("woods_fn")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 134;
                                        }
                                        break;
                                    case 2126:
                                        if (!str3.equals("C1")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.DC4;
                                        }
                                        break;
                                    case 2564:
                                        if (!str3.equals("Q5")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 113;
                                        }
                                        break;
                                    case 2715:
                                        if (!str3.equals("V1")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 127;
                                        }
                                        break;
                                    case 2719:
                                        if (!str3.equals("V5")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 129;
                                        }
                                        break;
                                    case 3091:
                                        if (!str3.equals("b5")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.DLE;
                                        }
                                        break;
                                    case 3483:
                                        if (!str3.equals("mh")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 84;
                                        }
                                        break;
                                    case 73405:
                                        if (!str3.equals("JGZ")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 73;
                                        }
                                        break;
                                    case 75537:
                                        if (!str3.equals("M04")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 79;
                                        }
                                        break;
                                    case 75739:
                                        if (!str3.equals("M5c")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 80;
                                        }
                                        break;
                                    case 76779:
                                        if (!str3.equals("MX6")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 86;
                                        }
                                        break;
                                    case 78669:
                                        if (!str3.equals("P85")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 94;
                                        }
                                        break;
                                    case 79305:
                                        if (!str3.equals("PLE")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 107;
                                        }
                                        break;
                                    case 80618:
                                        if (!str3.equals("QX1")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 115;
                                        }
                                        break;
                                    case 88274:
                                        if (!str3.equals("Z80")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 139;
                                        }
                                        break;
                                    case 98846:
                                        if (!str3.equals("cv1")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 26;
                                        }
                                        break;
                                    case 98848:
                                        if (!str3.equals("cv3")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 27;
                                        }
                                        break;
                                    case 99329:
                                        if (!str3.equals("deb")) {
                                            b3 = -1;
                                        }
                                        break;
                                    case 101481:
                                        if (!str3.equals("flo")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 49;
                                        }
                                        break;
                                    case 1513190:
                                        if (!str3.equals("1601")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 0;
                                        }
                                        break;
                                    case 1514184:
                                        if (!str3.equals("1713")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 1;
                                        }
                                        break;
                                    case 1514185:
                                        if (!str3.equals("1714")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 2;
                                        }
                                        break;
                                    case 2133089:
                                        if (!str3.equals("F01H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 36;
                                        }
                                        break;
                                    case 2133091:
                                        if (!str3.equals("F01J")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 37;
                                        }
                                        break;
                                    case 2133120:
                                        if (!str3.equals("F02H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 38;
                                        }
                                        break;
                                    case 2133151:
                                        if (!str3.equals("F03H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 39;
                                        }
                                        break;
                                    case 2133182:
                                        if (!str3.equals("F04H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 40;
                                        }
                                        break;
                                    case 2133184:
                                        if (!str3.equals("F04J")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 41;
                                        }
                                        break;
                                    case 2436959:
                                        if (!str3.equals("P681")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 93;
                                        }
                                        break;
                                    case 2463773:
                                        if (!str3.equals("Q350")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 109;
                                        }
                                        break;
                                    case 2464648:
                                        if (!str3.equals("Q427")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 111;
                                        }
                                        break;
                                    case 2689555:
                                        if (!str3.equals("XE2X")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 136;
                                        }
                                        break;
                                    case 3154429:
                                        if (!str3.equals("fugu")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 50;
                                        }
                                        break;
                                    case 3284551:
                                        if (!str3.equals("kate")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 75;
                                        }
                                        break;
                                    case 3351335:
                                        if (!str3.equals("mido")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 85;
                                        }
                                        break;
                                    case 3386211:
                                        if (!str3.equals("p212")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 92;
                                        }
                                        break;
                                    case 41325051:
                                        if (!str3.equals("MEIZU_M5")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 83;
                                        }
                                        break;
                                    case 51349633:
                                        if (!str3.equals("601LV")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 3;
                                        }
                                        break;
                                    case 51350594:
                                        if (!str3.equals("602LV")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 4;
                                        }
                                        break;
                                    case 55178625:
                                        if (!str3.equals("Aura_Note_2")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.SI;
                                        }
                                        break;
                                    case 61542055:
                                        if (!str3.equals("A1601")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 7;
                                        }
                                        break;
                                    case 65355429:
                                        if (!str3.equals("E5643")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.RS;
                                        }
                                        break;
                                    case 66214468:
                                        if (!str3.equals("F3111")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 42;
                                        }
                                        break;
                                    case 66214470:
                                        if (!str3.equals("F3113")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 43;
                                        }
                                        break;
                                    case 66214473:
                                        if (!str3.equals("F3116")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 44;
                                        }
                                        break;
                                    case 66215429:
                                        if (!str3.equals("F3211")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 45;
                                        }
                                        break;
                                    case 66215431:
                                        if (!str3.equals("F3213")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 46;
                                        }
                                        break;
                                    case 66215433:
                                        if (!str3.equals("F3215")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 47;
                                        }
                                        break;
                                    case 66216390:
                                        if (!str3.equals("F3311")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 48;
                                        }
                                        break;
                                    case 76402249:
                                        if (!str3.equals("PRO7S")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 108;
                                        }
                                        break;
                                    case 76404105:
                                        if (!str3.equals("Q4260")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 110;
                                        }
                                        break;
                                    case 76404911:
                                        if (!str3.equals("Q4310")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 112;
                                        }
                                        break;
                                    case 80963634:
                                        if (!str3.equals("V23GB")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 128;
                                        }
                                        break;
                                    case 82882791:
                                        if (!str3.equals("X3_HK")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 135;
                                        }
                                        break;
                                    case 98715550:
                                        if (!str3.equals("i9031")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 67;
                                        }
                                        break;
                                    case 101370885:
                                        if (!str3.equals("l5460")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 76;
                                        }
                                        break;
                                    case 102844228:
                                        if (!str3.equals("le_x6")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 77;
                                        }
                                        break;
                                    case 165221241:
                                        if (!str3.equals("A2016a40")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 8;
                                        }
                                        break;
                                    case 182191441:
                                        if (!str3.equals("CPY83_I00")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.EM;
                                        }
                                        break;
                                    case 245388979:
                                        if (!str3.equals("marino_f")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 82;
                                        }
                                        break;
                                    case 287431619:
                                        if (!str3.equals("griffin")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 60;
                                        }
                                        break;
                                    case 307593612:
                                        if (!str3.equals("A7010a48")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.VT;
                                        }
                                        break;
                                    case 308517133:
                                        if (!str3.equals("A7020a48")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.FF;
                                        }
                                        break;
                                    case 316215098:
                                        if (!str3.equals("TB3-730F")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 122;
                                        }
                                        break;
                                    case 316215116:
                                        if (!str3.equals("TB3-730X")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 123;
                                        }
                                        break;
                                    case 316246811:
                                        if (!str3.equals("TB3-850F")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 124;
                                        }
                                        break;
                                    case 316246818:
                                        if (!str3.equals("TB3-850M")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 125;
                                        }
                                        break;
                                    case 407160593:
                                        if (!str3.equals("Pixi5-10_4G")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 106;
                                        }
                                        break;
                                    case 507412548:
                                        if (!str3.equals("QM16XE_U")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 114;
                                        }
                                        break;
                                    case 793982701:
                                        if (!str3.equals("GIONEE_WBL5708")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 57;
                                        }
                                        break;
                                    case 794038622:
                                        if (!str3.equals("GIONEE_WBL7365")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 58;
                                        }
                                        break;
                                    case 794040393:
                                        if (!str3.equals("GIONEE_WBL7519")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 59;
                                        }
                                        break;
                                    case 835649806:
                                        if (!str3.equals("manning")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 81;
                                        }
                                        break;
                                    case 917340916:
                                        if (!str3.equals("A7000plus")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 10;
                                        }
                                        break;
                                    case 958008161:
                                        if (!str3.equals("j2xlteins")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 72;
                                        }
                                        break;
                                    case 1060579533:
                                        if (!str3.equals("panell_d")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 96;
                                        }
                                        break;
                                    case 1150207623:
                                        if (!str3.equals("LS-5017")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 78;
                                        }
                                        break;
                                    case 1176899427:
                                        if (!str3.equals("itel_S41")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 71;
                                        }
                                        break;
                                    case 1280332038:
                                        if (!str3.equals("hwALE-H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 62;
                                        }
                                        break;
                                    case 1306947716:
                                        if (!str3.equals("EverStar_S")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 35;
                                        }
                                        break;
                                    case 1349174697:
                                        if (!str3.equals("htc_e56ml_dtul")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Base64.padSymbol;
                                        }
                                        break;
                                    case 1522194893:
                                        if (!str3.equals("woods_f")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 133;
                                        }
                                        break;
                                    case 1691543273:
                                        if (!str3.equals("CPH1609")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.ETB;
                                        }
                                        break;
                                    case 1691544261:
                                        if (!str3.equals("CPH1715")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.CAN;
                                        }
                                        break;
                                    case 1709443163:
                                        if (!str3.equals("iball8735_9806")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 68;
                                        }
                                        break;
                                    case 1865889110:
                                        if (!str3.equals("santoni")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 117;
                                        }
                                        break;
                                    case 1906253259:
                                        if (!str3.equals("PB2-670M")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 100;
                                        }
                                        break;
                                    case 1977196784:
                                        if (!str3.equals("Infinix-X572")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 69;
                                        }
                                        break;
                                    case 2006372676:
                                        if (!str3.equals("BRAVIA_ATV3_4K")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 19;
                                        }
                                        break;
                                    case 2019281702:
                                        if (!str3.equals("DM-01K")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.GS;
                                        }
                                        break;
                                    case 2029784656:
                                        if (!str3.equals("HWBLN-H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 63;
                                        }
                                        break;
                                    case 2030379515:
                                        if (!str3.equals("HWCAM-H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = SignedBytes.MAX_POWER_OF_TWO;
                                        }
                                        break;
                                    case 2033393791:
                                        if (!str3.equals("ASUS_X00AD_2")) {
                                            b3 = -1;
                                        } else {
                                            b3 = Ascii.SO;
                                        }
                                        break;
                                    case 2047190025:
                                        if (!str3.equals("ELUGA_Note")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 32;
                                        }
                                        break;
                                    case 2047252157:
                                        if (!str3.equals("ELUGA_Prim")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 33;
                                        }
                                        break;
                                    case 2048319463:
                                        if (!str3.equals("HWVNS-H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 65;
                                        }
                                        break;
                                    case 2048855701:
                                        if (!str3.equals("HWWAS-H")) {
                                            b3 = -1;
                                        } else {
                                            b3 = 66;
                                        }
                                        break;
                                    default:
                                        b3 = -1;
                                        break;
                                }
                                switch (b3) {
                                    default:
                                        if (str2.hashCode() == -594534941) {
                                            break;
                                        }
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                    case 14:
                                    case 15:
                                    case 16:
                                    case 17:
                                    case 18:
                                    case 19:
                                    case 20:
                                    case 21:
                                    case 22:
                                    case 23:
                                    case 24:
                                    case 25:
                                    case 26:
                                    case 27:
                                    case 28:
                                    case 29:
                                    case 30:
                                    case 31:
                                    case 32:
                                    case 33:
                                    case 34:
                                    case 35:
                                    case 36:
                                    case 37:
                                    case 38:
                                    case 39:
                                    case 40:
                                    case 41:
                                    case 42:
                                    case 43:
                                    case 44:
                                    case 45:
                                    case 46:
                                    case 47:
                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX /* 49 */:
                                    case 50:
                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                                    case 52:
                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                                    case 56:
                                    case 57:
                                    case 58:
                                    case 59:
                                    case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                                    case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                    case 62:
                                    case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                    case 64:
                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                                    case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                    case 67:
                                    case 68:
                                    case 69:
                                    case 70:
                                    case 71:
                                    case 72:
                                    case 73:
                                    case 74:
                                    case 75:
                                    case Base64.mimeLineLength /* 76 */:
                                    case 77:
                                    case 78:
                                    case 79:
                                    case 80:
                                    case 81:
                                    case 82:
                                    case 83:
                                    case 84:
                                    case 85:
                                    case 86:
                                    case 87:
                                    case 88:
                                    case 89:
                                    case 90:
                                    case 91:
                                    case 92:
                                    case 93:
                                    case 94:
                                    case 95:
                                    case 96:
                                    case 97:
                                    case 98:
                                    case 99:
                                    case 100:
                                    case 101:
                                    case LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY /* 102 */:
                                    case 103:
                                    case LocationRequestCompat.QUALITY_LOW_POWER /* 104 */:
                                    case 105:
                                    case 106:
                                    case 107:
                                    case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
                                    case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY /* 109 */:
                                    case 110:
                                    case 111:
                                    case 112:
                                    case 113:
                                    case 114:
                                    case 115:
                                    case 116:
                                    case 117:
                                    case 118:
                                    case 119:
                                    case 120:
                                    case 121:
                                    case 122:
                                    case 123:
                                    case 124:
                                    case 125:
                                    case 126:
                                    case WorkQueueKt.MASK /* 127 */:
                                    case 128:
                                    case 129:
                                    case 130:
                                    case 131:
                                    case 132:
                                    case 133:
                                    case 134:
                                    case 135:
                                    case 136:
                                    case 137:
                                    case 138:
                                    case 139:
                                        z = true;
                                        break;
                                }
                            }
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                            z = true;
                            break;
                    }
                }
                zzd = z;
                zzc = true;
            }
        }
        return zzd;
    }

    private static List zzaN(Context context, zztb zztbVar, zzam zzamVar, boolean z, boolean z2) throws zzth {
        if (zzamVar.zzm == null) {
            return zzgaa.zzl();
        }
        if (zzfy.zza >= 26 && "video/dolby-vision".equals(zzamVar.zzm) && !zzaaf.zza(context)) {
            List listZzd = zztn.zzd(zztbVar, zzamVar, z, z2);
            if (!listZzd.isEmpty()) {
                return listZzd;
            }
        }
        return zztn.zzf(zztbVar, zzamVar, z, z2);
    }

    private final void zzaO() {
        zzdp zzdpVar = this.zzz;
        if (zzdpVar != null) {
            this.zzg.zzt(zzdpVar);
        }
    }

    private final void zzaP() {
        Surface surface = this.zzn;
        zzaak zzaakVar = this.zzo;
        if (surface == zzaakVar) {
            this.zzn = null;
        }
        if (zzaakVar != null) {
            zzaakVar.release();
            this.zzo = null;
        }
    }

    private final boolean zzaQ(zzsv zzsvVar) {
        if (zzfy.zza < 23 || zzaM(zzsvVar.zza)) {
            return false;
        }
        return !zzsvVar.zzf || zzaak.zzb(this.zze);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int zzac(zzsv zzsvVar, zzam zzamVar) {
        int iIntValue;
        int i = zzamVar.zzr;
        int i2 = zzamVar.zzs;
        if (i != -1 && i2 != -1) {
            String str = zzamVar.zzm;
            str.getClass();
            if ("video/dolby-vision".equals(str)) {
                Pair pairZza = zztn.zza(zzamVar);
                str = (pairZza == null || !((iIntValue = ((Integer) pairZza.first).intValue()) == 512 || iIntValue == 1 || iIntValue == 2)) ? "video/hevc" : "video/avc";
            }
            int i3 = 4;
            switch (str) {
                case "video/3gpp":
                case "video/mp4v-es":
                case "video/av01":
                case "video/x-vnd.on2.vp8":
                    return ((i * i2) * 3) / i3;
                case "video/hevc":
                    return Math.max(2097152, ((i * i2) * 3) / 4);
                case "video/avc":
                    if (!"BRAVIA 4K 2015".equals(zzfy.zzd) && (!"Amazon".equals(zzfy.zzc) || (!"KFSOWI".equals(zzfy.zzd) && (!"AFTS".equals(zzfy.zzd) || !zzsvVar.zzf)))) {
                        return ((((i + 15) / 16) * ((i2 + 15) / 16)) * 768) / 4;
                    }
                    break;
                case "video/x-vnd.on2.vp9":
                    i3 = 8;
                    return ((i * i2) * 3) / i3;
            }
        }
        return -1;
    }

    protected static int zzad(zzsv zzsvVar, zzam zzamVar) {
        if (zzamVar.zzn == -1) {
            return zzac(zzsvVar, zzamVar);
        }
        int size = zzamVar.zzo.size();
        int length = 0;
        for (int i = 0; i < size; i++) {
            length += ((byte[]) zzamVar.zzo.get(i)).length;
        }
        return zzamVar.zzn + length;
    }

    @Override // com.google.android.gms.internal.ads.zziq
    protected final void zzA() {
        if (this.zzf.zzk()) {
            this.zzf.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zziq
    protected final void zzB() {
        try {
            super.zzB();
            this.zzB = false;
            if (this.zzo != null) {
            }
        } finally {
            this.zzB = false;
            if (this.zzo != null) {
                zzaP();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zziq
    protected final void zzC() {
        this.zzs = 0;
        zzh();
        this.zzr = SystemClock.elapsedRealtime();
        this.zzv = 0L;
        this.zzw = 0;
        this.zzi.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zziq
    protected final void zzD() {
        if (this.zzs > 0) {
            zzh();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.zzg.zzd(this.zzs, jElapsedRealtime - this.zzr);
            this.zzs = 0;
            this.zzr = jElapsedRealtime;
        }
        int i = this.zzw;
        if (i != 0) {
            this.zzg.zzr(this.zzv, i);
            this.zzv = 0L;
            this.zzw = 0;
        }
        this.zzi.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zziq, com.google.android.gms.internal.ads.zzmf
    public final void zzL(float f, float f2) throws zziz {
        super.zzL(f, f2);
        this.zzi.zzn(f);
        if (this.zzE != null) {
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmf, com.google.android.gms.internal.ads.zzmh
    public final String zzT() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zzmf
    public final void zzU(long j, long j2) throws zziz {
        super.zzU(j, j2);
        if (this.zzE == null) {
            return;
        }
        try {
            throw null;
        } catch (zzabn e) {
            throw zzi(e, e.zza, false, 7001);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zzmf
    public final boolean zzV() {
        if (!super.zzV()) {
            return false;
        }
        if (this.zzE == null) {
            return true;
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zzmf
    public final boolean zzW() {
        boolean z;
        zzaak zzaakVar;
        if (!super.zzW()) {
            z = false;
        } else {
            if (this.zzE != null) {
                throw null;
            }
            z = true;
        }
        if (!z || (((zzaakVar = this.zzo) == null || this.zzn != zzaakVar) && zzau() != null)) {
            return this.zzi.zzo(z);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final float zzY(float f, zzam zzamVar, zzam[] zzamVarArr) {
        float fMax = -1.0f;
        for (zzam zzamVar2 : zzamVarArr) {
            float f2 = zzamVar2.zzt;
            if (f2 != -1.0f) {
                fMax = Math.max(fMax, f2);
            }
        }
        if (fMax == -1.0f) {
            return -1.0f;
        }
        return fMax * f;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final int zzZ(zztb zztbVar, zzam zzamVar) throws zzth {
        boolean z;
        if (!zzcb.zzh(zzamVar.zzm)) {
            return 128;
        }
        int i = 1;
        int i2 = 0;
        boolean z2 = zzamVar.zzp != null;
        List listZzaN = zzaN(this.zze, zztbVar, zzamVar, z2, false);
        if (z2 && listZzaN.isEmpty()) {
            listZzaN = zzaN(this.zze, zztbVar, zzamVar, false, false);
        }
        if (!listZzaN.isEmpty()) {
            if (zzaJ(zzamVar)) {
                zzsv zzsvVar = (zzsv) listZzaN.get(0);
                boolean zZze = zzsvVar.zze(zzamVar);
                if (!zZze) {
                    int i3 = 1;
                    while (true) {
                        if (i3 >= listZzaN.size()) {
                            z = true;
                            break;
                        }
                        zzsv zzsvVar2 = (zzsv) listZzaN.get(i3);
                        if (zzsvVar2.zze(zzamVar)) {
                            zZze = true;
                            z = false;
                            zzsvVar = zzsvVar2;
                            break;
                        }
                        i3++;
                    }
                } else {
                    z = true;
                    break;
                }
                int i4 = true != zZze ? 3 : 4;
                int i5 = true != zzsvVar.zzf(zzamVar) ? 8 : 16;
                int i6 = true != zzsvVar.zzg ? 0 : 64;
                int i7 = true != z ? 0 : 128;
                if (zzfy.zza >= 26 && "video/dolby-vision".equals(zzamVar.zzm) && !zzaaf.zza(this.zze)) {
                    i7 = 256;
                }
                if (zZze) {
                    List listZzaN2 = zzaN(this.zze, zztbVar, zzamVar, z2, true);
                    if (!listZzaN2.isEmpty()) {
                        zzsv zzsvVar3 = (zzsv) zztn.zzg(listZzaN2, zzamVar).get(0);
                        if (zzsvVar3.zze(zzamVar) && zzsvVar3.zzf(zzamVar)) {
                            i2 = 32;
                        }
                    }
                }
                return i4 | i5 | i2 | i6 | i7;
            }
            i = 2;
        }
        return i | 128;
    }

    @Override // com.google.android.gms.internal.ads.zzaan
    public final boolean zza(long j, long j2, boolean z) {
        return j < -30000 && !z;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final void zzaA(zzam zzamVar) throws zziz {
        if (this.zzA && !this.zzB && !this.zzf.zzk()) {
            try {
                this.zzf.zzd(zzamVar);
                this.zzf.zzh(zzas());
                zzaal zzaalVar = this.zzD;
                if (zzaalVar != null) {
                    this.zzf.zzj(zzaalVar);
                }
            } catch (zzabn e) {
                throw zzi(e, zzamVar, false, 7000);
            }
        }
        if (this.zzE != null || !this.zzf.zzk()) {
            this.zzB = true;
        } else {
            this.zzE = this.zzf.zzb();
            zzgfe.zzb();
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final void zzaC() {
        super.zzaC();
        this.zzu = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final boolean zzaI(zzsv zzsvVar) {
        return this.zzn != null || zzaQ(zzsvVar);
    }

    protected final void zzaK(int i, int i2) {
        zzir zzirVar = this.zza;
        zzirVar.zzh += i;
        int i3 = i + i2;
        zzirVar.zzg += i3;
        this.zzs += i3;
        int i4 = this.zzt + i3;
        this.zzt = i4;
        zzirVar.zzi = Math.max(i4, zzirVar.zzi);
    }

    protected final void zzaL(long j) {
        zzir zzirVar = this.zza;
        zzirVar.zzk += j;
        zzirVar.zzl++;
        this.zzv += j;
        this.zzw++;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final zzis zzaa(zzsv zzsvVar, zzam zzamVar, zzam zzamVar2) {
        int i;
        int i2;
        zzis zzisVarZzb = zzsvVar.zzb(zzamVar, zzamVar2);
        int i3 = zzisVarZzb.zze;
        zzaag zzaagVar = this.zzk;
        zzaagVar.getClass();
        if (zzamVar2.zzr > zzaagVar.zza || zzamVar2.zzs > zzaagVar.zzb) {
            i3 |= 256;
        }
        if (zzad(zzsvVar, zzamVar2) > zzaagVar.zzc) {
            i3 |= 64;
        }
        String str = zzsvVar.zza;
        if (i3 != 0) {
            i2 = i3;
            i = 0;
        } else {
            i = zzisVarZzb.zzd;
            i2 = 0;
        }
        return new zzis(str, zzamVar, zzamVar2, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final zzis zzab(zzlb zzlbVar) throws zziz {
        zzis zzisVarZzab = super.zzab(zzlbVar);
        zzam zzamVar = zzlbVar.zza;
        zzamVar.getClass();
        this.zzg.zzf(zzamVar, zzisVarZzab);
        return zzisVarZzab;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0218  */
    /* JADX WARN: Code duplicated, block: B:103:0x0220  */
    /* JADX WARN: Code duplicated, block: B:71:0x0168  */
    /* JADX WARN: Code duplicated, block: B:74:0x0178  */
    /* JADX WARN: Code duplicated, block: B:76:0x0191  */
    /* JADX WARN: Code duplicated, block: B:84:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:86:0x01de  */
    /* JADX WARN: Code duplicated, block: B:88:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:91:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:93:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:95:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:97:0x020e  */
    @Override // com.google.android.gms.internal.ads.zzsz
    protected final zzsp zzae(zzsv zzsvVar, zzam zzamVar, MediaCrypto mediaCrypto, float f) {
        String str;
        Point pointZza;
        int i;
        int i2;
        boolean z;
        MediaFormat mediaFormat;
        float f2;
        zzt zztVar;
        Pair pairZza;
        byte[] bArr;
        int iZzac;
        zzaak zzaakVar = this.zzo;
        if (zzaakVar != null) {
            if (zzaakVar.zza != zzsvVar.zzf) {
                zzaP();
            }
        }
        String str2 = zzsvVar.zzc;
        zzam[] zzamVarArrZzS = zzS();
        int iMax = zzamVar.zzr;
        int iMax2 = zzamVar.zzs;
        int iZzad = zzad(zzsvVar, zzamVar);
        int length = zzamVarArrZzS.length;
        if (length != 1) {
            boolean z2 = false;
            for (int i3 = 0; i3 < length; i3++) {
                zzam zzamVarZzac = zzamVarArrZzS[i3];
                if (zzamVar.zzy != null && zzamVarZzac.zzy == null) {
                    zzak zzakVarZzb = zzamVarZzac.zzb();
                    zzakVarZzb.zzA(zzamVar.zzy);
                    zzamVarZzac = zzakVarZzb.zzac();
                }
                if (zzsvVar.zzb(zzamVar, zzamVarZzac).zzd != 0) {
                    int i4 = zzamVarZzac.zzr;
                    z2 |= i4 == -1 || zzamVarZzac.zzs == -1;
                    iMax = Math.max(iMax, i4);
                    iMax2 = Math.max(iMax2, zzamVarZzac.zzs);
                    iZzad = Math.max(iZzad, zzad(zzsvVar, zzamVarZzac));
                }
            }
            if (z2) {
                zzff.zzf("MediaCodecVideoRenderer", "Resolutions unknown. Codec max resolution: " + iMax + "x" + iMax2);
                int i5 = zzamVar.zzs;
                int i6 = zzamVar.zzr;
                boolean z3 = i5 > i6;
                int i7 = z3 ? i5 : i6;
                if (true == z3) {
                    i5 = i6;
                }
                int[] iArr = zzb;
                int i8 = 0;
                while (true) {
                    if (i8 < 9) {
                        float f3 = i5;
                        float f4 = i7;
                        str = str2;
                        int i9 = iArr[i8];
                        int[] iArr2 = iArr;
                        float f5 = i9;
                        if (i9 > i7 && (i = (int) (f5 * (f3 / f4))) > i5) {
                            int i10 = zzfy.zza;
                            int i11 = true != z3 ? i9 : i;
                            if (true != z3) {
                                i9 = i;
                            }
                            pointZza = zzsvVar.zza(i11, i9);
                            float f6 = zzamVar.zzt;
                            if (pointZza != null) {
                                i2 = i5;
                                if (zzsvVar.zzg(pointZza.x, pointZza.y, f6)) {
                                    break;
                                }
                            } else {
                                i2 = i5;
                            }
                            i8++;
                            str2 = str;
                            iArr = iArr2;
                            i5 = i2;
                        }
                    } else {
                        str = str2;
                    }
                    pointZza = null;
                    break;
                }
                if (pointZza != null) {
                    iMax = Math.max(iMax, pointZza.x);
                    iMax2 = Math.max(iMax2, pointZza.y);
                    zzak zzakVarZzb2 = zzamVar.zzb();
                    zzakVarZzb2.zzab(iMax);
                    zzakVarZzb2.zzI(iMax2);
                    iZzad = Math.max(iZzad, zzac(zzsvVar, zzakVarZzb2.zzac()));
                    zzff.zzf("MediaCodecVideoRenderer", "Codec max resolution adjusted to: " + iMax + "x" + iMax2);
                }
            }
            zzaag zzaagVar = new zzaag(iMax, iMax2, iZzad);
            this.zzk = zzaagVar;
            z = this.zzh;
            mediaFormat = new MediaFormat();
            mediaFormat.setString("mime", str);
            mediaFormat.setInteger("width", zzamVar.zzr);
            mediaFormat.setInteger("height", zzamVar.zzs);
            zzfi.zzb(mediaFormat, zzamVar.zzo);
            f2 = zzamVar.zzt;
            if (f2 != -1.0f) {
                mediaFormat.setFloat("frame-rate", f2);
            }
            zzfi.zza(mediaFormat, "rotation-degrees", zzamVar.zzu);
            zztVar = zzamVar.zzy;
            if (zztVar != null) {
                zzfi.zza(mediaFormat, "color-transfer", zztVar.zzf);
                zzfi.zza(mediaFormat, "color-standard", zztVar.zzd);
                zzfi.zza(mediaFormat, "color-range", zztVar.zze);
                bArr = zztVar.zzg;
                if (bArr != null) {
                    mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
                }
            }
            if ("video/dolby-vision".equals(zzamVar.zzm) && (pairZza = zztn.zza(zzamVar)) != null) {
                zzfi.zza(mediaFormat, Scopes.PROFILE, ((Integer) pairZza.first).intValue());
            }
            mediaFormat.setInteger("max-width", zzaagVar.zza);
            mediaFormat.setInteger("max-height", zzaagVar.zzb);
            zzfi.zza(mediaFormat, "max-input-size", zzaagVar.zzc);
            if (zzfy.zza >= 23) {
                mediaFormat.setInteger("priority", 0);
                if (f != -1.0f) {
                    mediaFormat.setFloat("operating-rate", f);
                }
            }
            if (z) {
                mediaFormat.setInteger("no-post-process", 1);
                mediaFormat.setInteger("auto-frc", 0);
            }
            if (this.zzn == null) {
                if (zzaQ(zzsvVar)) {
                    throw new IllegalStateException();
                }
                if (this.zzo == null) {
                    this.zzo = zzaak.zza(this.zze, zzsvVar.zzf);
                }
                this.zzn = this.zzo;
            }
            if (this.zzE == null) {
                return zzsp.zzb(zzsvVar, mediaFormat, zzamVar, this.zzn, null);
            }
            throw null;
        }
        if (iZzad != -1 && (iZzac = zzac(zzsvVar, zzamVar)) != -1) {
            iZzad = Math.min((int) (iZzad * 1.5f), iZzac);
        }
        str = str2;
        zzaag zzaagVar2 = new zzaag(iMax, iMax2, iZzad);
        this.zzk = zzaagVar2;
        z = this.zzh;
        mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", zzamVar.zzr);
        mediaFormat.setInteger("height", zzamVar.zzs);
        zzfi.zzb(mediaFormat, zzamVar.zzo);
        f2 = zzamVar.zzt;
        if (f2 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f2);
        }
        zzfi.zza(mediaFormat, "rotation-degrees", zzamVar.zzu);
        zztVar = zzamVar.zzy;
        if (zztVar != null) {
            zzfi.zza(mediaFormat, "color-transfer", zztVar.zzf);
            zzfi.zza(mediaFormat, "color-standard", zztVar.zzd);
            zzfi.zza(mediaFormat, "color-range", zztVar.zze);
            bArr = zztVar.zzg;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        if ("video/dolby-vision".equals(zzamVar.zzm)) {
            zzfi.zza(mediaFormat, Scopes.PROFILE, ((Integer) pairZza.first).intValue());
        }
        mediaFormat.setInteger("max-width", zzaagVar2.zza);
        mediaFormat.setInteger("max-height", zzaagVar2.zzb);
        zzfi.zza(mediaFormat, "max-input-size", zzaagVar2.zzc);
        if (zzfy.zza >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (z) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (this.zzn == null) {
            if (zzaQ(zzsvVar)) {
                throw new IllegalStateException();
            }
            if (this.zzo == null) {
                this.zzo = zzaak.zza(this.zze, zzsvVar.zzf);
            }
            this.zzn = this.zzo;
        }
        if (this.zzE == null) {
            return zzsp.zzb(zzsvVar, mediaFormat, zzamVar, this.zzn, null);
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final List zzaf(zztb zztbVar, zzam zzamVar, boolean z) throws zzth {
        return zztn.zzg(zzaN(this.zze, zztbVar, zzamVar, false, false), zzamVar);
    }

    protected final void zzag(zzsr zzsrVar, int i, long j, long j2) {
        Surface surface;
        int i2 = zzfy.zza;
        Trace.beginSection("releaseOutputBuffer");
        zzsrVar.zzm(i, j2);
        Trace.endSection();
        this.zza.zze++;
        this.zzt = 0;
        if (this.zzE == null) {
            zzdp zzdpVar = this.zzy;
            if (!zzdpVar.equals(zzdp.zza) && !zzdpVar.equals(this.zzz)) {
                this.zzz = zzdpVar;
                this.zzg.zzt(zzdpVar);
            }
            if (!this.zzi.zzp() || (surface = this.zzn) == null) {
                return;
            }
            this.zzg.zzq(surface);
            this.zzp = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final void zzah(zzih zzihVar) throws zziz {
        if (this.zzm) {
            ByteBuffer byteBuffer = zzihVar.zzf;
            byteBuffer.getClass();
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b == -75 && s == 60 && s2 == 1 && b2 == 4) {
                    if (b3 == 0 || b3 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        zzsr zzsrVarZzau = zzau();
                        zzsrVarZzau.getClass();
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("hdr10-plus-info", bArr);
                        zzsrVarZzau.zzp(bundle);
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final void zzai(Exception exc) {
        zzff.zzd("MediaCodecVideoRenderer", "Video codec error", exc);
        this.zzg.zzs(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final void zzaj(String str, zzsp zzspVar, long j, long j2) {
        this.zzg.zza(str, j, j2);
        this.zzl = zzaM(str);
        zzsv zzsvVarZzaw = zzaw();
        zzsvVarZzaw.getClass();
        boolean z = false;
        if (zzfy.zza >= 29 && "video/x-vnd.on2.vp9".equals(zzsvVarZzaw.zzb)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : zzsvVarZzaw.zzh()) {
                if (codecProfileLevel.profile == 16384) {
                    z = true;
                    break;
                }
            }
        }
        this.zzm = z;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final void zzak(String str) {
        this.zzg.zzb(str);
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final void zzal(zzam zzamVar, MediaFormat mediaFormat) {
        zzsr zzsrVarZzau = zzau();
        if (zzsrVarZzau != null) {
            zzsrVarZzau.zzq(this.zzq);
        }
        mediaFormat.getClass();
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        int integer = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
        int integer2 = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        float f = zzamVar.zzv;
        int i = zzfy.zza;
        int i2 = zzamVar.zzu;
        if (i2 == 90 || i2 == 270) {
            f = 1.0f / f;
            int i3 = integer2;
            integer2 = integer;
            integer = i3;
        }
        this.zzy = new zzdp(integer, integer2, 0, f);
        this.zzi.zzl(zzamVar.zzt);
        if (this.zzE == null) {
            return;
        }
        zzak zzakVarZzb = zzamVar.zzb();
        zzakVarZzb.zzab(integer);
        zzakVarZzb.zzI(integer2);
        zzakVarZzb.zzV(0);
        zzakVarZzb.zzS(f);
        zzakVarZzb.zzac();
        throw null;
    }

    protected final void zzam(zzsr zzsrVar, int i, long j) {
        int i2 = zzfy.zza;
        Trace.beginSection("skipVideoBuffer");
        zzsrVar.zzn(i, false);
        Trace.endSection();
        this.zza.zzf++;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final void zzan() {
        this.zzi.zzf();
        int i = zzfy.zza;
        if (this.zzf.zzk()) {
            this.zzf.zzh(zzas());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final int zzar(zzih zzihVar) {
        int i = zzfy.zza;
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final zzst zzav(Throwable th, zzsv zzsvVar) {
        return new zzaae(th, zzsvVar, this.zzn);
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final void zzay(long j) {
        super.zzay(j);
        this.zzu--;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final void zzaz(zzih zzihVar) throws zziz {
        this.zzu++;
        int i = zzfy.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaan
    public final boolean zzb(long j, long j2) {
        return j < -30000 && j2 > 100000;
    }

    @Override // com.google.android.gms.internal.ads.zzaan
    public final boolean zzc(long j, long j2, long j3, boolean z, boolean z2) throws zziz {
        int iZzd;
        if (j >= -500000 || z || (iZzd = zzd(j2)) == 0) {
            return false;
        }
        if (z2) {
            zzir zzirVar = this.zza;
            zzirVar.zzd += iZzd;
            zzirVar.zzf += this.zzu;
        } else {
            this.zza.zzj++;
            zzaK(iZzd, this.zzu);
        }
        zzaE();
        if (this.zzE == null) {
            return true;
        }
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zziq, com.google.android.gms.internal.ads.zzmf
    public final void zzs() {
        this.zzi.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zziq
    protected final void zzw() {
        this.zzz = null;
        this.zzi.zzd();
        int i = zzfy.zza;
        this.zzp = false;
        try {
            super.zzw();
        } finally {
            this.zzg.zzc(this.zza);
            this.zzg.zzt(zzdp.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zziq
    protected final void zzx(boolean z, boolean z2) throws zziz {
        super.zzx(z, z2);
        zzm();
        this.zzg.zze(this.zza);
        this.zzi.zze(z2);
    }

    @Override // com.google.android.gms.internal.ads.zziq
    protected final void zzy() {
        zzaao zzaaoVar = this.zzi;
        zzel zzelVarZzh = zzh();
        zzaaoVar.zzk(zzelVarZzh);
        this.zzf.zzf(zzelVarZzh);
    }

    @Override // com.google.android.gms.internal.ads.zzsz, com.google.android.gms.internal.ads.zziq
    protected final void zzz(long j, boolean z) throws zziz {
        if (this.zzE != null) {
            throw null;
        }
        super.zzz(j, z);
        if (this.zzf.zzk()) {
            this.zzf.zzh(zzas());
        }
        this.zzi.zzi();
        if (z) {
            this.zzi.zzc();
        }
        int i = zzfy.zza;
        this.zzt = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzsz
    protected final boolean zzap(long j, long j2, zzsr zzsrVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzam zzamVar) throws zziz {
        zzsrVar.getClass();
        long jZzas = j3 - zzas();
        int iZza = this.zzi.zza(j3, j, j2, zzat(), z2, this.zzj);
        if (z && !z2) {
            zzam(zzsrVar, i, jZzas);
            return true;
        }
        if (this.zzn == this.zzo) {
            if (this.zzj.zzc() < WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                zzam(zzsrVar, i, jZzas);
                zzaL(this.zzj.zzc());
                return true;
            }
        } else {
            if (this.zzE != null) {
                try {
                    throw null;
                } catch (zzabn e) {
                    throw zzi(e, e.zza, false, 7001);
                }
            }
            if (iZza == 0) {
                zzh();
                long jNanoTime = System.nanoTime();
                int i4 = zzfy.zza;
                zzag(zzsrVar, i, jZzas, jNanoTime);
                zzaL(this.zzj.zzc());
                return true;
            }
            if (iZza == 1) {
                zzaam zzaamVar = this.zzj;
                long jZzd = zzaamVar.zzd();
                long jZzc = zzaamVar.zzc();
                int i5 = zzfy.zza;
                if (jZzd == this.zzx) {
                    zzam(zzsrVar, i, jZzas);
                } else {
                    zzag(zzsrVar, i, jZzas, jZzd);
                }
                zzaL(jZzc);
                this.zzx = jZzd;
                return true;
            }
            if (iZza == 2) {
                int i6 = zzfy.zza;
                Trace.beginSection("dropVideoBuffer");
                zzsrVar.zzn(i, false);
                Trace.endSection();
                zzaK(0, 1);
                zzaL(this.zzj.zzc());
                return true;
            }
            if (iZza == 3) {
                zzam(zzsrVar, i, jZzas);
                zzaL(this.zzj.zzc());
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.internal.ads.zzsr] */
    /* JADX WARN: Type inference failed for: r5v14, types: [com.google.android.gms.internal.ads.zzabp] */
    /* JADX WARN: Type inference failed for: r5v5, types: [com.google.android.gms.internal.ads.zzaao] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10, types: [com.google.android.gms.internal.ads.zzaak] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v28 */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.view.Surface] */
    /* JADX WARN: Type inference failed for: r6v6, types: [android.view.Surface] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zziq, com.google.android.gms.internal.ads.zzma
    public final void zzt(int i, Object obj) throws zziz {
        ?? Zza;
        ?? r6;
        ?? r7;
        Surface surface;
        Surface surface2;
        if (i != 1) {
            if (i == 7) {
                obj.getClass();
                zzaal zzaalVar = (zzaal) obj;
                this.zzD = zzaalVar;
                this.zzf.zzj(zzaalVar);
                return;
            }
            if (i == 10) {
                obj.getClass();
                int iIntValue = ((Integer) obj).intValue();
                if (this.zzC != iIntValue) {
                    this.zzC = iIntValue;
                    return;
                }
                return;
            }
            if (i == 4) {
                obj.getClass();
                int iIntValue2 = ((Integer) obj).intValue();
                this.zzq = iIntValue2;
                zzsr zzsrVarZzau = zzau();
                if (zzsrVarZzau != null) {
                    zzsrVarZzau.zzq(iIntValue2);
                    return;
                }
                return;
            }
            if (i == 5) {
                zzaao zzaaoVar = this.zzi;
                obj.getClass();
                zzaaoVar.zzj(((Integer) obj).intValue());
                return;
            } else if (i == 13) {
                obj.getClass();
                this.zzf.zzi((List) obj);
                this.zzA = true;
                return;
            } else {
                if (i != 14) {
                    return;
                }
                obj.getClass();
                zzfq zzfqVar = (zzfq) obj;
                if (zzfqVar.zzb() == 0 || zzfqVar.zza() == 0 || (surface2 = this.zzn) == null) {
                    return;
                }
                this.zzf.zzg(surface2, zzfqVar);
                return;
            }
        }
        if (obj instanceof Surface) {
            surface = (Surface) obj;
        } else {
            Zza = 0;
        }
        if (Zza == 0) {
            zzaak zzaakVar = this.zzo;
            if (zzaakVar != null) {
                Zza = surface;
                Zza = zzaakVar;
            } else {
                zzsv zzsvVarZzaw = zzaw();
                if (zzsvVarZzaw != null && zzaQ(zzsvVarZzaw)) {
                    Zza = surface;
                    Zza = zzaak.zza(this.zze, zzsvVarZzaw.zzf);
                    this.zzo = Zza;
                }
            }
        }
        Zza = surface;
        Zza = surface;
        Zza = surface;
        if (this.zzn == Zza) {
            if (Zza == 0 || Zza == this.zzo) {
                return;
            }
            zzaO();
            Surface surface3 = this.zzn;
            if (surface3 == null || !this.zzp) {
                return;
            }
            this.zzg.zzq(surface3);
            return;
        }
        this.zzn = Zza;
        this.zzi.zzm(Zza);
        this.zzp = false;
        int iZzbf = zzbf();
        ?? Zzau = zzau();
        if (Zzau != 0 && !this.zzf.zzk()) {
            if (zzfy.zza < 23) {
                r6 = Zza;
                r6 = Zza;
                r7 = Zza;
                zzaB();
                zzax();
                r6 = r7;
            } else {
                if (Zza != 0) {
                    r7 = Zza;
                    if (!this.zzl) {
                        Zzau.zzo(Zza);
                        r6 = Zza;
                    }
                } else {
                    r7 = 0;
                }
                r6 = Zza;
                r6 = Zza;
                r7 = Zza;
                zzaB();
                zzax();
                r6 = r7;
            }
        }
        if (r6 == 0 || r6 == this.zzo) {
            this.zzz = null;
            if (this.zzf.zzk()) {
                this.zzf.zzc();
            }
        } else {
            zzaO();
            if (iZzbf == 2) {
                this.zzi.zzc();
            }
            if (this.zzf.zzk()) {
                this.zzf.zzg(r6, zzfq.zza);
            }
        }
        int i2 = zzfy.zza;
    }
}
