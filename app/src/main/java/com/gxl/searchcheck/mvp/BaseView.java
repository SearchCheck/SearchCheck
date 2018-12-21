package com.gxl.searchcheck.mvp;

/**
 * author : gxl
 * email : 1739037476@qq.com
 * create data : 2018/12/20
 * Describe  : View层的机类
 */
public interface BaseView<T extends BasePre> {
    /**
     * 设置View相关的P层
     */
    void setPresenter(T presenter);
}
