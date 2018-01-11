package org.liaohailong.mvptest01.util;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;

import org.liaohailong.mvptest01.base.MvpApplication;

/**
 * Describe as : 属性工具类
 * Created by LHL on 2018/1/10.
 */

public class AttrHelper {

    private static int WINDOW_WIDTH = getWindowWidth();//屏幕的总宽度
    private static int WINDOW_HEIGHT = getWindowHeight();//屏幕的总高度

    private static int getWindowWidth() {
        WindowManager wm = (WindowManager) MvpApplication.getInstance().getSystemService(Context.WINDOW_SERVICE);
        if (wm == null) {
            return 0;
        }
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);
        return point.x;
    }

    private static int getWindowHeight() {
        WindowManager wm = (WindowManager) MvpApplication.getInstance().getSystemService(Context.WINDOW_SERVICE);
        if (wm == null) {
            return 0;
        }
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);
        return point.y;
    }

    /**
     * 获取屏幕百分比宽度
     *
     * @param percent 0.0f ~ 1.0f
     * @return 百分比宽度
     */
    public static int getWindowWidthPercent(float percent) {
        return (int) (WINDOW_WIDTH * percent);
    }

    /**
     * 获取屏幕百分比高度
     *
     * @param percent 0.0f ~ 1.0f
     * @return 百分比高度
     */
    public static int getWindowHeightPercent(float percent) {
        return (int) (WINDOW_HEIGHT * percent);
    }
}
