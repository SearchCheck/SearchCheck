package com.gxl.searchcheck.app;

import android.content.Context;

import com.search.baselibrary.base.BaseApplication;

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
    }

    @Override
    public Context getContext() {
        return mContext;
    }
}
