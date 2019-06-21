package com.example.asad.zuoye;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIv;
    private TextView mTv;
    int a=1;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mTv.setText("倒计时：" + msg.what + "");
            if (a==1) {
                if (msg.what == 0) {
                    startActivity(new Intent(MainActivity.this, SecondActivity.class));
                }
            }
        }
    };
    /**
     * 跳过
     */
    private Button mBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //张宇龙
        SharedPreferences zuoye = getSharedPreferences("zuoye", MODE_PRIVATE);
        SharedPreferences.Editor edit = zuoye.edit();
        int anInt = zuoye.getInt("jizhu", 0);
        edit.commit();
        if (anInt == 1) {
            startActivity(new Intent(this, SecondActivity.class));
        } else {
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.huanyin);
            mIv.startAnimation(animation);
            new Thread() {
                @Override
                public void run() {
                    for (int i = 5; i >= 0; i--) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        handler.sendEmptyMessage(i);
                    }
                }
            }.start();
        }


    }

    private void initView() {
        mIv = (ImageView) findViewById(R.id.iv);
        mTv = (TextView) findViewById(R.id.tv);
        mBt = (Button) findViewById(R.id.bt);
        mBt.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt:
                a=2;
                SharedPreferences zuoye = getSharedPreferences("zuoye", MODE_PRIVATE);
                SharedPreferences.Editor edit = zuoye.edit();
                SharedPreferences.Editor jizhu = edit.putInt("jizhu", 1);
                edit.commit();
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                break;
        }
    }
}
