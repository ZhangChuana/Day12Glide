package com.example.asad.day12glide;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

public class MainActivity extends AppCompatActivity {

    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.transform(new RoundedCorners(15));
        requestOptions.placeholder(R.mipmap.ic_launcher);
        requestOptions.error(R.mipmap.ic_launcher);
        requestOptions.centerCrop();

        Glide.with(MainActivity.this)
                .load("https://k.zol-img.com.cn/sjbbs/7692/a7691515_s.jpg")
                .apply(requestOptions)
                .into(mIv);

    }

    private void initView() {
        mIv = (ImageView) findViewById(R.id.iv);
    }
}
