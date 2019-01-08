package com.gxl.searchcheck.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


import com.gxl.searchcheck.greendao.DaoMaster;
import com.gxl.searchcheck.greendao.MigrationHelper;
import com.gxl.searchcheck.greendao.UserDao;

import org.greenrobot.greendao.database.Database;

/**
 * 数据库升级保留数据的帮助类
 */
public class UpdateSQLiteOpenHelper extends DaoMaster.OpenHelper {
    public UpdateSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {
            @Override
            public void onCreateAllTables(Database db, boolean ifNotExists) {
                DaoMaster.createAllTables(db, ifNotExists);
            }

            @Override
            public void onDropAllTables(Database db, boolean ifExists) {
                DaoMaster.dropAllTables(db, ifExists);
            }
            //这里要添加保存数据的dao类
        }, UserDao.class);
    }
}
