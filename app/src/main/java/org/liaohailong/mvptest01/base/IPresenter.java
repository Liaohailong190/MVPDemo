package org.liaohailong.mvptest01.base;

/**
 * 所有控制层基类
 * Created by LHL on 2017/12/23.
 */

public interface IPresenter<V> {

    void attachView(V view);

    void detachView();
}
