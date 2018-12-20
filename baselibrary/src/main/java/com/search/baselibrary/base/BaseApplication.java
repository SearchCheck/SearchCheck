package com.search.baselibrary.base;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.search.baselibrary.utils.CrashHandler;

/**
 * author : gxl
 * email : 1739037476@qq.com
 * create data : 2018/12/18
 * Describe  :
 */
public abstract class BaseApplication extends MultiDexApplication {
    private static BaseApplication mInstance;

    public static Context getInstance() {
        return mInstance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
        this.mInstance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public abstract Context getContext();
}
