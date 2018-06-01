package com.coderpig.drysister.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.coderpig.drysister.R;
import com.r0adkll.slidr.Slidr;

public class PictureDetailActivity extends AppCompatActivity {
    private ImageView img_picture;
    private String picUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detail);
        picUrl = getIntent().getStringExtra("pic_url");
        initView();
        initData();
    }

    private void initData() {
        //实现手指滑动退出当前的Activity.
        Slidr.attach(this);
        if(picUrl != null) {
            Glide.with(this).load(picUrl).into(img_picture);
        }
    }

    private void initView() {
        img_picture = findViewById(R.id.img_picture);
    }
}
