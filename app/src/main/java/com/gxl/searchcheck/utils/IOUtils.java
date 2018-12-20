package com.gxl.searchcheck.utils;

import android.content.Context;

import com.search.baselibrary.utils.AppUtils;
import com.search.baselibrary.utils.SDCardUtils;

import java.io.File;

/**
 * author : gxl
 * email : 1739037476@qq.com
 * create data : 2018/12/20
 * Describe  : 提供一些关于应用的io操作
 */
public class IOUtils {
    /**
     * 获取本应用存放数据的主目录
     */
    public static String getRootStoragePath(Context context) {
        File rootDirectory = SDCardUtils.getRootDirectory();
        if (rootDirectory == null) {
            //SD卡不存在
            return context.getFilesDir().getAbsolutePath();
        }
        String tmpPath = rootDirectory + File.separator + AppConstants.ROOT_DIR;
        File file = new File(tmpPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
