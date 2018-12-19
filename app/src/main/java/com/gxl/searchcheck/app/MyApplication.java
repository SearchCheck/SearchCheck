package com.gxl.searchcheck.app;

import android.content.Context;

import com.search.baselibrary.base.BaseApplication;
import com.search.baselibrary.utils.AppUtils;
import com.search.baselibrary.utils.CrashHandler;

/**
 * @author Tomze
 * @time 2018年12月18日 23:00
 * @desc
 */
public class MyApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        if (AppUtils.isDebug(this)) {
            CrashHandler.getInstance().init(this);
        }
    }

}
