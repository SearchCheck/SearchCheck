package com.search.baselibrary.utils;

import android.content.res.Resources;


public class DisplayUtil {
    /**
     * 获取状态栏高度
     */
    public static int getStatusBarHeight() {
        Resources resources = UiUtils.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }
}
