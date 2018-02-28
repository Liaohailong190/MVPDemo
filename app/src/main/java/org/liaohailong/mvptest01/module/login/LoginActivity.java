package org.liaohailong.mvptest01.module.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;

import org.liaohailong.mvptest01.R;
import org.liaohailong.mvptest01.base.BaseActivity;
import org.liaohailong.mvptest01.model.UserInfo;
import org.liaohailong.mvptest01.util.ToastUtil;
import org.liaohailong.mvptest01.widget.GlideApp;

/**
 * 登录界面
 * Created by LHL on 2017/12/23.
 */

public class LoginActivity extends BaseActivity<LoginPresenterImpl, LoginContract.LoginView> implements LoginContract.LoginView {
    public static void show(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    private TextView mLoginStatusTxt;
    private ImageView mImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.login_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginPresenterImpl presenter = getPresenter();
                if (presenter != null) {
                    presenter.login("小明", 18, true);
                }
            }
        });
        mLoginStatusTxt = findViewById(R.id.login_status_txt);
        mImageView = findViewById(R.id.image_view);
        GlideApp.with(this)
                .applyDefaultRequestOptions(new RequestOptions())
                .asBitmap()
                .load("")
                .into(mImageView);
    }

    @Override
    public void onStartLoading() {
        super.onStartLoading();
        if (mLoginStatusTxt != null) {
            mLoginStatusTxt.setText("开始登陆啦！！！");
        }
    }

    @Override
    public void onStopLoading() {
        super.onStopLoading();
        if (mLoginStatusTxt != null) {
            mLoginStatusTxt.setText("登陆结束啦！！！");
        }
    }

    @Override
    public void onLoginFailure(String msg) {
        ToastUtil.show("登陸失敗 msg = " + msg);
    }

    @Override
    public void onLoginSuccess(UserInfo userInfo) {
        ToastUtil.show("登陸成功 userInfo = " + userInfo.toString());
    }
}
