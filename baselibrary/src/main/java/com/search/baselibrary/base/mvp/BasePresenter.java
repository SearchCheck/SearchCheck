package com.search.baselibrary.base.mvp;

/**
 * author : gxl
 * email : 1739037476@qq.com
 * create data : 2018/12/20
 * Describe  : 基础的Presenter类
 */
public abstract class BasePresenter<T extends BaseView> implements BasePre {
    protected T mView;

    public BasePresenter(T view) {
        this.mView = view;
    }

    /**
     * 设置View层
     */
    public void setView(T mView) {
        this.mView = mView;
    }

    /**
     * 获取View层
     */
    public T getView() {
        return mView;
    }
}
