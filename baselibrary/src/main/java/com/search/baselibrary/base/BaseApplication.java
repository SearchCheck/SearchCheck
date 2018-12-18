package com.search.baselibrary.base;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

/**
 * author : gxl
 * email : 1739037476@qq.com
 * create data : 2018/12/18
 * Describe  :
 */
public abstract class BaseApplication extends MultiDexApplication {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * 获取Application的Context
     */
    protected abstract Context getContext();
}
