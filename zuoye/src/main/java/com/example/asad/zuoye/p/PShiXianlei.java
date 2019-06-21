package com.example.asad.zuoye.p;

import com.example.asad.zuoye.bean.Shujukulei;
import com.example.asad.zuoye.m.CallBack;
import com.example.asad.zuoye.m.MShixianlei;
import com.example.asad.zuoye.v.ViewInterface;

import java.util.List;

/**
 * Created by 13768 on 2019/5/15.
 */

public class PShiXianlei implements PInterface,CallBack{
    private MShixianlei mShixianlei;
    private ViewInterface viewInterface;

    public PShiXianlei(MShixianlei mShixianlei, ViewInterface viewInterface) {
        this.mShixianlei = mShixianlei;
        this.viewInterface = viewInterface;
    }

    @Override
    public void getChaRuData(Shujukulei shujukulei) {
        if (mShixianlei!=null) {
            mShixianlei.getCharuData(shujukulei,this);
        }
    }

    @Override
    public void getChaXunData() {
        if (mShixianlei!=null) {
            mShixianlei.getChaxunData(this);
        }
    }

    @Override
    public void onCharuChenggong(String s) {
        if (viewInterface!=null) {
            viewInterface.onCharuChenggong(s);
        }
    }

    @Override
    public void onCharuShibai(String s) {
        if (viewInterface!=null) {
            viewInterface.onCharuShibai(s);
        }
    }

    @Override
    public void onChaXunChenggong(List<Shujukulei> mlist) {
        if (viewInterface!=null) {
            viewInterface.onChaXunChenggong(mlist);
        }
    }

    @Override
    public void onChaXunShibai(String s) {
        if (viewInterface!=null) {
            viewInterface.onChaXunShibai(s);
        }
    }

}
