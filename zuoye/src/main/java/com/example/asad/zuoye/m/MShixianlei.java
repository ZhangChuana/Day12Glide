package com.example.asad.zuoye.m;

import com.example.asad.zuoye.bean.Shujukulei;
import com.example.asad.zuoye.db.DataHelp;
import com.example.asad.zuoye.db.ShujukuleiDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 13768 on 2019/5/15.
 */

public class MShixianlei implements MInterface{

    @Override
    public void getCharuData(Shujukulei shujukulei, CallBack callBack) {
        int insert = DataHelp.getDataHelp().insert(shujukulei);
        if (insert>=1) {
            callBack.onCharuChenggong("插入成功");
        }else {
            callBack.onCharuShibai("插入失败");
        }
    }

    @Override
    public void getChaxunData(CallBack callBack) {
        List<Shujukulei> list = DataHelp.getDataHelp().chaXun();
        if (list.size()>0 && list!=null) {
            callBack.onChaXunChenggong(list);
        }else {
            callBack.onChaXunShibai("查询失败");
        }
    }
}
