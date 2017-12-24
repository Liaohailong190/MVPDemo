package org.liaohailong.mvptest01;

import android.os.Bundle;
import android.view.View;

import org.liaohailong.mvptest01.base.BaseActivity;
import org.liaohailong.mvptest01.module.login.LoginActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.jump_login_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.show(v.getContext());
            }
        });
    }
}
