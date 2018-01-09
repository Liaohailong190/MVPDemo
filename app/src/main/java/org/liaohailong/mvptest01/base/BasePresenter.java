package org.liaohailong.mvptest01.base;

import android.os.Handler;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * 所有控制层基类
 * Created by LHL on 2017/12/23.
 */

public class BasePresenter<V> implements IPresenter<V> {
    private WeakReference<V> mView;
    private V mProxyView;

    protected Handler mHandler = new Handler();
    protected Random mRandom = new Random();

    @Override
    public void attachView(V view) {
        mView = new WeakReference<>(view);
        //动态代理，防止防止空指针
        mProxyView = (V) Proxy.newProxyInstance(view.getClass().getClassLoader(),
                view.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (mView != null && mView.get() != null) {
                            method.setAccessible(true);
                            return method.invoke(mView.get(), args);
                        }
                        return null;
                    }
                });
    }

    protected V getView() {
        return mProxyView;
    }

    @Override
    public void detachView() {
        if (mView != null) {
            mView.clear();
            mView = null;
        }
    }
}
