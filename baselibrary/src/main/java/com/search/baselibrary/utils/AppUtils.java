package com.search.baselibrary.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import com.search.baselibrary.R;
import com.search.baselibrary.base.BaseApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Tomze
 * @time 2018年12月19日 0:31
 * @desc
 */
public class AppUtils {

    private AppUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    private static Context getContext(){
        return UiUtils.getContext();
    }

    /**
     * 获取当前应用包名
     * @return 如: com.caveman.androidframework
     */
    public static String getPackageName(){
        return UiUtils.getContext().getPackageName();
    }

    /**
     * 获取当前应用版本名称
     * @return 如: 1.0.0
     */
    public static String getAppVersionName(){
        String versionName = "";
        try {
            PackageInfo packageInfo = getContext().getPackageManager()
                    .getPackageInfo(getPackageName(), 0);
            versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }

    /**
     * 获取当前应用版本号
     * @return 如 1
     */
    public static int getAppVersionCode(){
        int versionCode = 0;
        try{
            PackageInfo packageInfo = getContext().getPackageManager()
                    .getPackageInfo(getPackageName(), 0);
            versionCode = packageInfo.versionCode;
        }catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * 获取当前应用最后一次更新的时间
     * @return 时间戳
     */
    public static long getLastUpdateTime(){
        try {
            PackageInfo packageInfo = getContext().getPackageManager()
                    .getPackageInfo(getPackageName(), 0);
            return packageInfo.lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    public static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }

    public static boolean isDebug(Context context){
        boolean isDebug = context.getApplicationInfo() != null &&
                (context.getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        return isDebug;
    }
}
