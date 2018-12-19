package com.search.baselibrary.base;

/**
 * @author Tomze
 * @time 2018年12月18日 23:13
 * @desc 基础的Presenter
 */
public abstract class BasePresenter<V extends BaseView> {

    protected final V mView;

    public BasePresenter(V mView) {
        this.mView = mView;
    }
}
