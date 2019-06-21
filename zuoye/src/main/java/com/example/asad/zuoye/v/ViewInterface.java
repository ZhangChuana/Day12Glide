package com.example.asad.zuoye.v;

import com.example.asad.zuoye.bean.Shujukulei;

import java.util.List;

/**
 * Created by 13768 on 2019/5/15.
 */

public interface ViewInterface {
    void onCharuChenggong(String s);
    void onCharuShibai(String s);

    void onChaXunChenggong(List<Shujukulei> mlist);
    void onChaXunShibai(String s);
}
