package org.liaohailong.mvptest01.model.login;

import android.os.Handler;

import org.liaohailong.mvptest01.base.BasePresenter;
import org.liaohailong.mvptest01.bean.UserInfo;

import java.util.Random;

/**
 * 登录控制层实现
 * Created by LHL on 2017/12/23.
 */

public class LoginPresenterImpl extends BasePresenter<LoginContract.LoginView> implements LoginContract.LoginPresenter {
    private Handler mHandler;
    private Random mRandom;

    public LoginPresenterImpl() {
        mHandler = new Handler();
        mRandom = new Random();
    }

    @Override
    public void login(final String name, final int age, final boolean man) {
        getView().onStartLoading();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getView().onStopLoading();
                boolean success = mRandom.nextBoolean();
                if (success) {
                    getView().onLoginSuccess(new UserInfo(name, age, man));
                } else {
                    getView().onLoginFailure("出错了！");
                }
            }
        }, 8000);
    }
}
