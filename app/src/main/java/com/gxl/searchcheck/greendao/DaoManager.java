package com.gxl.searchcheck.greendao;

import android.database.sqlite.SQLiteDatabase;

import com.gxl.searchcheck.app.MyApplication;
import com.gxl.searchcheck.utils.AppConstants;

/**
 * author : gxl
 * email : 1739037476@qq.com
 * create data : 2018/12/20
 * Describe  : GreenDao的管理类通过这个类获取相应的DaoSession
 */
public class DaoManager {

    private static volatile DaoManager mInstance;
    private final DaoMaster.DevOpenHelper mHelper;
    private final DaoMaster mDaoMaster;

    protected DaoManager() {
        mHelper = new DaoMaster.DevOpenHelper(new DatabaseContext(MyApplication.getInstance()),
                AppConstants.DB_NAME, null);
        SQLiteDatabase db = mHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
    }

    /**
     * 获取DaoManager的实例
     */
    public static DaoManager getInstance() {
        if (mInstance == null) {
            synchronized (DaoManager.class) {
                if (mInstance == null) {
                    mInstance = new DaoManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * 获取DaoSession
     */
    public DaoSession getDaoSession() {
        return mDaoMaster.newSession();
    }
}
