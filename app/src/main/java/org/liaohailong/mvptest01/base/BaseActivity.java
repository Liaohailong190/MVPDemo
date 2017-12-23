package org.liaohailong.mvptest01.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.liaohailong.mvptest01.util.ToastUtil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 所有Activity的基类
 * Created by LHL on 2017/12/23.
 */

@SuppressLint("Registered")
public class BaseActivity<P extends IPresenter<V>, V extends IView> extends AppCompatActivity implements IView{
    private P mPresenter;
    private V mView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
            Type[] types = parameterizedType.getActualTypeArguments();
            Class<P> presenterClass = (Class<P>) types[0];
            mPresenter = presenterClass.newInstance();
            mView = (V) this;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (mPresenter != null && mView != null) {
            mPresenter.attachView(mView);
        }
    }

    protected P getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void onStartLoading() {
        ToastUtil.show("展開進度條");
    }

    @Override
    public void onStopLoading() {
        ToastUtil.show("關閉進度條");
    }
}
