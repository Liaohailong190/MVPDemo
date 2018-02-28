package org.liaohailong.mvptest01.module.login;

import org.liaohailong.mvptest01.base.BasePresenter;
import org.liaohailong.mvptest01.model.UserInfo;

/**
 * 登录控制层实现
 * Created by LHL on 2017/12/23.
 */

public class LoginPresenterImpl extends BasePresenter<LoginContract.LoginView> implements LoginContract.LoginPresenter {

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
        }, 3000);
    }
}
