package org.liaohailong.mvptest01.base;

import android.app.Application;

/**
 * 本APP的application类别
 * Created by LHL on 2017/12/23.
 */

public class MvpApplication extends Application {

    private static MvpApplication INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }

    public static MvpApplication getInstance() {
        return INSTANCE;
    }
}
