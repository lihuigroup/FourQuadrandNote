package com.android.app;

import android.app.Application;

import com.android.app.Dao.Dao;
import com.android.app.Dao.DaoMaster;
import com.android.app.Dao.DaoSession;
import com.android.app.Dao.NoteDao;
import com.android.app.Dao.UserDao;

import org.xutils.x;

public class FourQuardNoteApplication extends Application {
    private DaoSession daoSession;
    @Override
    public void onCreate() {
        super.onCreate();
        initDatabaseDao();
        x.Ext.init(this);
    }

    public DaoSession getDaoSession(){ return daoSession; }

    public void setDaoSession(DaoSession dao){ daoSession=dao;}

    public UserDao getUserDao(){
        return daoSession.getUserDao();
    }

    public NoteDao getNoteDao(){
        return daoSession.getNoteDao();
    }

    public void initDatabaseDao(){
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getApplicationContext(), "fourQuard.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        setDaoSession(daoMaster.newSession());
        Dao.initDao(daoSession);
    }
}
