package com.gxl.searchcheck.utils;

import android.content.res.Resources;

import com.gxl.searchcheck.base.BaseApplication;

public class DisplayUtil {
    /**
     * 获取状态栏高度
     */
    public static int getStatusBarHeight() {
        Resources resources = BaseApplication.getContext().getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }
}
