package org.liaohailong.mvptest01.module.login;

import org.liaohailong.mvptest01.base.IView;
import org.liaohailong.mvptest01.model.UserInfo;

/**
 * 登陆功能相关
 * Created by LHL on 2017/12/23.
 */

public interface LoginContract {
    interface LoginView extends IView {
        void onLoginSuccess(UserInfo userInfo);

        void onLoginFailure(String msg);
    }

    interface LoginPresenter {
        void login(String name, int age, boolean man);
    }
}
