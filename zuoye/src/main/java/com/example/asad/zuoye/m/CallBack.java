package com.example.asad.zuoye.m;

import com.example.asad.zuoye.bean.Shujukulei;

import java.util.List;

/**
 * Created by 13768 on 2019/5/15.
 */

public interface CallBack {
    void onCharuChenggong(String s);
    void onCharuShibai(String s);

    void onChaXunChenggong(List<Shujukulei> mlist);
    void onChaXunShibai(String s);
}
