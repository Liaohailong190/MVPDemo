package org.liaohailong.mvptest01.util;

import android.view.View;
import android.view.ViewGroup;

/**
 * Describe as : View操作相关辅助类
 * Created by LHL on 2018/1/10.
 */

public class ViewHelper {

    public static void setHeight(View view, int height) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.height = height;
        view.setLayoutParams(layoutParams);
    }

    public static void setWidth(View view, int width) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.width = width;
        view.setLayoutParams(layoutParams);
    }
}
