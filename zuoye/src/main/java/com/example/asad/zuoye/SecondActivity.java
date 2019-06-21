package com.example.asad.zuoye;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.asad.zuoye.afragment.AFragment;
import com.example.asad.zuoye.bfragment.BFragment;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private ViewPager mVp;
    private TabLayout mTb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();

        final String[] s = {"首页", "数据库"};
        final ArrayList<Fragment> fragmentlist = new ArrayList<>();
        fragmentlist.add(new AFragment());
        fragmentlist.add(new BFragment());
        mVp.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentlist.get(position);
            }

            @Override
            public int getCount() {
                return fragmentlist.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return s[position];
            }
        });
        mTb.setupWithViewPager(mVp);
        mTb.getTabAt(0).setIcon(R.drawable.tabxuanze).setText("首页");
        mTb.getTabAt(1).setIcon(R.drawable.tabxuanzeer).setText("数据库");
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mTb = (TabLayout) findViewById(R.id.tb);
    }
}
