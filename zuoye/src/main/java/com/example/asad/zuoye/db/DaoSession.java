package com.example.asad.zuoye.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.asad.zuoye.bean.Shujukulei;

import com.example.asad.zuoye.db.ShujukuleiDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig shujukuleiDaoConfig;

    private final ShujukuleiDao shujukuleiDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        shujukuleiDaoConfig = daoConfigMap.get(ShujukuleiDao.class).clone();
        shujukuleiDaoConfig.initIdentityScope(type);

        shujukuleiDao = new ShujukuleiDao(shujukuleiDaoConfig, this);

        registerDao(Shujukulei.class, shujukuleiDao);
    }
    
    public void clear() {
        shujukuleiDaoConfig.clearIdentityScope();
    }

    public ShujukuleiDao getShujukuleiDao() {
        return shujukuleiDao;
    }

}
