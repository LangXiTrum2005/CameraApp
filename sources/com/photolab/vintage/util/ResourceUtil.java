package com.photolab.vintage.util;

import android.graphics.Color;
import com.google.android.gms.ads.RequestConfiguration;
import com.photolab.vintage.util.bean.FilterConfig;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ResourceUtil {
    public static List<FilterConfig> getFilterConfig() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FilterConfig(0, "file:///android_asset/ic_original.png", "", "ORI", Color.parseColor("#ff2357"), true, 100));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/lomo_01.jpg", "@adjust lut filter/lomo1.webp {0}", "Lomo 01", Color.parseColor("#3498DB"), 100));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/lomo_02.jpg", "@adjust lut filter/lomo2.webp {0}", "Lomo 02", Color.parseColor("#3498DB"), 100));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/lomo_03.jpg", "@adjust lut filter/lomo3.webp {0}", "Lomo 03", Color.parseColor("#3498DB"), 100, true));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/lomo_04.jpg", "@adjust lut filter/lomo4.webp {0}", "Lomo 04", Color.parseColor("#3498DB"), 100));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/lomo_05.jpg", "@adjust lut filter/lomo5.webp {0}", "Lomo 05", Color.parseColor("#3498DB"), true, 100, true));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/retro_01.jpg", "@adjust lut filter/retro1.jpg {0}", "Retro 01", Color.parseColor("#1ABC9C"), 100));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/retro_02.jpg", "@adjust lut filter/retro2.jpg {0}", "Retro 02", Color.parseColor("#1ABC9C"), 100));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/retro_03.jpg", "@adjust lut filter/retro3.jpg {0}", "Retro 03", Color.parseColor("#1ABC9C"), 100));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/retro_04.jpg", "@adjust lut filter/retro4.jpg {0}", "Retro 04", Color.parseColor("#1ABC9C"), 100));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/retro_05.jpg", "@adjust lut filter/retro5.jpg {0}", "Retro 05", Color.parseColor("#1ABC9C"), 100));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/retro_06.jpg", "@adjust lut filter/retro6.jpg {0}", "Retro 06", Color.parseColor("#1ABC9C"), 100));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/retro_07.jpg", "@adjust lut filter/retro7.jpg {0}", "Retro 07", Color.parseColor("#1ABC9C"), 100));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/retro_08.jpg", "@adjust lut filter/retro8.jpg {0}", "Retro 08", Color.parseColor("#1ABC9C"), 100));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/retro_09.jpg", "@adjust lut filter/retro9.jpg {0}", "Retro 09", Color.parseColor("#1ABC9C"), 100, true));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/retro_10.jpg", "@adjust lut filter/retro10.jpg {0}", "Retro 10", Color.parseColor("#1ABC9C"), true, 100, true));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/cube_01.jpg", "@adjust lut filter/cube1.jpg {0}", "Cube 01", Color.parseColor("#fb28f4"), 100));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/cube_02.jpg", "@adjust lut filter/cube2.jpg {0}", "Cube 02", Color.parseColor("#fb28f4"), 100));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/cube_03.jpg", "@adjust lut filter/cube3.jpg {0}", "Cube 03", Color.parseColor("#fb28f4"), 100, true));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/cube_04.jpg", "@adjust lut filter/cube4.jpg {0}", "Cube 04", Color.parseColor("#fb28f4"), 100));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/cube_05.jpg", "@adjust lut filter/cube5.jpg {0}", "Cube 05", Color.parseColor("#fb28f4"), 100));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/cube_06.jpg", "@adjust lut filter/cube6.jpg {0}", "Cube 06", Color.parseColor("#fb28f4"), 100, true));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/cube_07.jpg", "@adjust lut filter/cube7.jpg {0}", "Cube 07", Color.parseColor("#fb28f4"), 100));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/cube_08.jpg", "@adjust lut filter/cube8.jpg {0}", "Cube 08", Color.parseColor("#fb28f4"), 100));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/cube_09.jpg", "@adjust lut filter/cube9.jpg {0}", "Cube 09", Color.parseColor("#fb28f4"), 100));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/cube_10.jpg", "@adjust lut filter/cube10.jpg {0}", "Cube 10", Color.parseColor("#fb28f4"), true, 100));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/euro_01.jpg", "@adjust lut filter/euro01.webp {0}", "Euro 01", Color.parseColor("#ffa200"), 100, true));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/euro_02.jpg", "@adjust lut filter/euro02.webp {0}", "Euro 02", Color.parseColor("#ffa200"), 100));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/euro_03.jpg", "@adjust lut filter/euro03.webp {0}", "Euro 03", Color.parseColor("#ffa200"), 100));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/euro_04.jpg", "@adjust lut filter/euro04.webp {0}", "Euro 04", Color.parseColor("#ffa200"), 100, true));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/euro_05.jpg", "@adjust lut filter/euro05.webp {0}", "Euro 05", Color.parseColor("#ffa200"), 100));
        arrayList.add(new FilterConfig(0, "file:///android_asset/filter/euro_06.jpg", "@adjust lut filter/euro06.webp {0}", "Euro 06", Color.parseColor("#ffa200"), true, 100, true));
        for (int i = 1; i <= 10; i++) {
            arrayList.add(new FilterConfig(0, "file:///android_asset/filter/vignette_" + i + ".jpg", "@adjust lut filter/a" + i + ".png @vignette 0.1 0.9 {0}", "Vignette " + i, Color.parseColor("#00a8ff"), 100));
        }
        for (int i2 = 68; i2 <= 75; i2++) {
            StringBuilder sb = new StringBuilder("file:///android_asset/filter/BW");
            int i3 = i2 - 67;
            sb.append(i3);
            sb.append(".jpg");
            arrayList.add(new FilterConfig(0, sb.toString(), "@adjust lut filter/a" + i2 + ".png {0}", "B&W " + i3, Color.parseColor("#AA98DB"), 100));
        }
        return arrayList;
    }

    public static List<FilterConfig> getDustConfig() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FilterConfig(2, "file:///android_asset/ic_original.png", "", "ORI", Color.parseColor("#ffad37"), true, 100));
        for (int i = 1; i <= 28; i++) {
            arrayList.add(new FilterConfig(2, "file:///android_asset/dust/dust_" + i + ".jpg", "#unpack @krblend sr dust/dust_" + i + ".jpg {0}", "D" + i + "", Color.parseColor("#0cf4aa"), 100));
        }
        return arrayList;
    }

    public static List<FilterConfig> getLightConfig() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FilterConfig(1, "file:///android_asset/ic_original.png", "", "ORI", Color.parseColor("#d706c1"), true, 100));
        for (int i = 1; i <= 28; i++) {
            arrayList.add(new FilterConfig(1, "file:///android_asset/light/" + i + ".jpg", "#unpack @krblend sr light/" + i + ".jpg {0}", "L" + i + "", Color.parseColor("#00aeef"), 80));
        }
        return arrayList;
    }

    public static List<FilterConfig> getGradientConfig() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FilterConfig(3, "file:///android_asset/ic_original.png", "", "ORI", Color.parseColor("#ffad37"), true, 40));
        for (int i = 0; i <= 22; i++) {
            arrayList.add(new FilterConfig(3, "file:///android_asset/gradient/gradient" + i + ".png", "#unpack @krblend sr gradient/gradient" + i + ".png {0}", RequestConfiguration.MAX_AD_CONTENT_RATING_G + i + "", Color.parseColor("#b926ea"), 40));
        }
        return arrayList;
    }

    public static List<FilterConfig> getMaskConfig() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FilterConfig(4, "file:///android_asset/ic_original.png", "", "ORI", Color.parseColor("#0ed3ea"), true, 100));
        for (int i = 1; i <= 11; i++) {
            arrayList.add(new FilterConfig(4, "file:///android_asset/mask/mask_dark" + i + ".jpeg", "#unpack @krblend hl mask/mask_dark" + i + ".jpeg {0}", "M" + i + "", Color.parseColor("#AA98DB"), 25));
        }
        for (int i2 = 1; i2 <= 13; i2++) {
            arrayList.add(new FilterConfig(4, "file:///android_asset/mask/mask_" + i2 + ".jpg", "#unpack @krblend hl mask/mask_" + i2 + ".jpg {0}", "M" + i2 + "", Color.parseColor("#AA98DB"), 25));
        }
        for (int i3 = 1; i3 <= 9; i3++) {
            arrayList.add(new FilterConfig(4, "file:///android_asset/mask/mask_light" + i3 + ".jpeg", "#unpack @krblend hl mask/mask_light" + i3 + ".jpeg {0}", "M" + i3 + "", Color.parseColor("#AA98DB"), 25));
        }
        return arrayList;
    }
}
