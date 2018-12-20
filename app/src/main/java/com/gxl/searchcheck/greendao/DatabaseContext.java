package com.gxl.searchcheck.greendao;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;

import com.gxl.searchcheck.utils.AppConstants;
import com.gxl.searchcheck.utils.IOUtils;
import com.search.baselibrary.utils.SDCardUtils;

import java.io.File;
import java.io.IOException;

/**
 * author : gxl
 * email : 1739037476@qq.com
 * create data : 2018/12/20
 * Describe  : 如果想要数据库放在SD卡中，必须要重写这个类
 */
public class DatabaseContext extends ContextWrapper {
    private Context mContext;

    public DatabaseContext(Context base) {
        super(base);
        this.mContext = base;
    }

    @Override
    public File getDatabasePath(String name) {
        File rootDirectory = SDCardUtils.getRootDirectory();
        if (rootDirectory == null) {
            return super.getDatabasePath(name);
        }
        //db存放的目录
        String dbDirPath = IOUtils.getRootStoragePath(mContext) //主目录
                + File.separator + AppConstants.DB_DIR; //db目录
        File dbDirFile = new File(dbDirPath);
        if (!dbDirFile.exists()) {
            dbDirFile.mkdirs();
        }
        //db文件
        String dbFilePath = dbDirFile.getAbsolutePath() + File.separator + AppConstants.DB_NAME;
        File dbFile = new File(dbFilePath);
        if (!dbFile.exists()) {
            try {
                dbFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dbFile;
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), null);
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(name), null);
    }


}
