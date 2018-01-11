package org.liaohailong.mvptest01.util;

import android.util.Log;

import org.liaohailong.mvptest01.BuildConfig;

/**
 * Describe as : Log日志打印
 * Created by LHL on 2018/1/10.
 */

public class LogMan {
    private static final String TAG = "LogMan";

    private static boolean debug = BuildConfig.DEBUG;


    public static void i(String msg) {
        i(TAG, msg);
    }

    public static void i(String tag, String msg) {
        if (debug) {
            Log.i(tag, msg);
        }
    }
}
