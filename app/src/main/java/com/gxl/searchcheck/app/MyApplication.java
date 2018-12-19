package com.gxl.searchcheck.app;

import android.content.Context;

import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.search.baselibrary.base.BaseApplication;
import com.search.baselibrary.utils.AppUtils;
import com.search.baselibrary.utils.CrashHandler;

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
        // 判断  是debug模式 且 有写文件的权限 保存崩溃日志注册
        if (AppUtils.isDebug(mContext) && XXPermissions.isHasPermission(this, Permission.WRITE_EXTERNAL_STORAGE)) {
            CrashHandler.getInstance().init(this);
        }
    }

    public Context getContext() {
        return mContext;
    }
}
