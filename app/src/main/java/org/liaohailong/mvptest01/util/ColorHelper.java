package org.liaohailong.mvptest01.util;

import android.graphics.Color;
import android.support.annotation.ColorInt;

import java.util.Random;

/**
 * Describe as : 颜色复制类
 * Created by LHL on 2018/1/9.
 */

public class ColorHelper {
    public static final int[] colors = {Color.RED, Color.YELLOW, Color.BLUE,
            Color.BLACK, Color.DKGRAY, Color.GRAY, Color.LTGRAY, Color.GREEN,
            Color.CYAN, Color.MAGENTA};
    public static final Random mRandom = new Random();

    @ColorInt
    public static int getNextColor() {
        int nextInt = mRandom.nextInt(colors.length);
        return colors[nextInt];
    }

    @ColorInt
    public static int getNextColor(int index) {
        return colors[index % colors.length];
    }
}
