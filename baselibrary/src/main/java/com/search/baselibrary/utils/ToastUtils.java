package com.search.baselibrary.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * ToastUtils
 *
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2013-12-9
 */
public class ToastUtils {
    public static Toast mToast;

    /**
     * 显示吐司
     * @param message
     */
    public static void show(final String message){
        if (mToast == null){
            mToast = Toast.makeText(UiUtils.getContext(), message, Toast.LENGTH_SHORT);
        }else{
            mToast.setText(message);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    /**
     * 显示吐司
     * @param messageResId
     */
    public static void show(final int messageResId){
        if (mToast == null){
            mToast = Toast.makeText(UiUtils.getContext(), messageResId, Toast.LENGTH_SHORT);
        }else{
            mToast.setText(messageResId);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public static void showL(final String message){
        if (mToast == null){
            mToast = Toast.makeText(UiUtils.getContext(), message, Toast.LENGTH_LONG);
        }else{
            mToast.setText(message);
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        mToast.show();
    }

    public static void showL(final int messageResId){
        if (mToast == null){
            mToast = Toast.makeText(UiUtils.getContext(), messageResId, Toast.LENGTH_LONG);
        }else{
            mToast.setText(messageResId);
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        mToast.show();
    }
}
