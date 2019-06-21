package com.example.asad.zuoye.db;

import com.example.asad.zuoye.App;
import com.example.asad.zuoye.bean.Shujukulei;

import java.util.List;

/**
 * Created by 13768 on 2019/5/15.
 */

public class DataHelp {
    public static DataHelp dataHelp;
    public ShujukuleiDao shujukuleiDao;

    public static DataHelp getDataHelp() {
        if (dataHelp==null) {
            synchronized (DataHelp.class){
                if (dataHelp==null) {
                    dataHelp=new DataHelp();
                }
            }
        }
        return dataHelp;
    }

    public DataHelp() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(App.getApp(), "zc.db");
        shujukuleiDao = new DaoMaster(devOpenHelper.getWritableDatabase()).newSession().getShujukuleiDao();
    }

    public int insert(Shujukulei shujukulei){
        if (shujukulei!=null) {
            long insert = shujukuleiDao.insertOrReplace(shujukulei);
            return (int)insert;
        }
        return 0;
    }

    public List<Shujukulei> chaXun(){
        List<Shujukulei> list = shujukuleiDao.queryBuilder().list();
        return list;
    }

    public boolean ShanChu(Shujukulei shujukulei){
        shujukuleiDao.delete(shujukulei);
        return true;
    }
}
