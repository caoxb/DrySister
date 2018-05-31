package com.coderpig.drysister.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.coderpig.drysister.R;

/**
 * 描述：闪屏页
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TextView tv_logo = findViewById(R.id.tv_logo);
        //this::jump，得在Java 1.8,android api 27的编译环境下特性
        tv_logo.postDelayed(this::jump,500L);
    }

    /* 页面逻辑跳转 */
    private void jump() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}
