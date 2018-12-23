package com.gxl.searchcheck.app;

import android.content.Context;

import com.gxl.searchcheck.utils.AppConstants;
import com.gxl.searchcheck.utils.FileUtils;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.search.baselibrary.base.BaseApplication;
import com.search.baselibrary.manager.SkinManager;
import com.search.baselibrary.utils.CrashHandler;

import java.io.File;

/**
 * @author Tomze
 * @time 2018年12月18日 23:00
 * @desc
 */
public class MyApplication extends BaseApplication {

    private Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        this.mContext = this;
        SkinManager.getInstance().init(this);
        // 判断  是debug模式 且 有写文件的权限 保存崩溃日志注册
        if (XXPermissions.isHasPermission(this, Permission.WRITE_EXTERNAL_STORAGE)) {
            FileUtils.createAllDirs(this);
            CrashHandler.getInstance().init(this, AppConstants.ROOT_DIR + File.separator + AppConstants.LOG_DIR);
        }
        //初始化Logger
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    public Context getContext() {
        return mContext;
    }
}
