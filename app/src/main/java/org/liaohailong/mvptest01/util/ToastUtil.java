package org.liaohailong.mvptest01.util;

import android.support.annotation.StringRes;
import android.widget.Toast;

import org.liaohailong.mvptest01.base.MvpApplication;

/**
 * 土司封装类
 * 解决队列弹出的问题
 * Created by LHL on 2017/12/23.
 */

public class ToastUtil {

    private static Toast mToast = null;

    public static void show(@StringRes int stringRes) {
        String text = MvpApplication.getInstance().getResources().getString(stringRes);
        show(text);
    }

    public static void show(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(MvpApplication.getInstance(), msg, Toast.LENGTH_SHORT);
            mToast.show();
        } else {
            mToast.setText(msg);
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.show();
        }
    }
}
